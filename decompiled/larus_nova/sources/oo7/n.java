package oo7;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.share.api.entity.PermissionType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class n {

    public static class a implements in7.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f524631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ in7.g f524632b;

        @Override // in7.g
        public final void onDenied() {
            if (this.f524631a.getEventCallBack() == null) goto L5;
            this.f524631a.getEventCallBack().c(PermissionType.DENIED, this.f524631a, "");
        L5:
            go7.b.e(this.f524631a, false);
            in7.g r100 = this.f524632b;
            if (r100 == null) goto L9;
            r100.onDenied();
            return;
        }

        @Override // in7.g
        public final void onGranted() {
            if (this.f524631a.getEventCallBack() == null) goto L5;
            this.f524631a.getEventCallBack().c(PermissionType.GRANTED, this.f524631a, "android.permission.WRITE_EXTERNAL_STORAGE");
        L5:
            go7.b.e(this.f524631a, true);
            in7.g r100 = this.f524632b;
            if (r100 == null) goto L9;
            r100.onGranted();
            return;
        }

        public a(ShareContent r100, in7.g r101) {
            this.f524631a = r100;
            this.f524632b = r101;
        }
    }

    public static boolean e() {
        String r100 = Build.BRAND;
        String[] r101 = {"华为", "荣耀", RomUtils.BRAND_HUAWEI, RomUtils.BRAND_HONOR};
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L9;
        if (r101[r102].equals(r100) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static Uri b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return a(com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a, new PolarisFileWrapper(r100));
    }

    public static Uri a(Context r100, PolarisFileWrapper r101) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L14;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".ug.sdk.share.fileprovider", r101);
    L9:
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".fileprovider", r101);
    L11:
        th = move-exception;
        k.b(th.toString());
        return null;
    L14:
        return Uri.fromFile(r101);
    L5:
        r102 = false;
        goto L6
    }

    public static String c(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L21;
        if (r101 <= 0) goto L26;
        int r102 = r100.getBytes().length;
        if (r102 > r101) goto L9;
        return r100;
    L9:
        int r103 = r100.length();
    L11:
        if (r102 <= r101) goto L13;
        r103 = r103 / 2;
        r102 = r100.substring(0, r103).length();
        goto L11
    L13:
        int r104 = r103 * 2;
    L14:
        if (r103 >= r104) goto L20;
        if (r100.substring(0, r103).getBytes().length > r101) goto L20;
        r103 = r103 + 1;
    L20:
        return r100.substring(0, r103 - 1);
    L26:
        return "";
    L21:
        return "";
    }

    public static void d(Context r100, ShareContent r101, in7.g r102) {
        StringBuilder r103 = new StringBuilder("requestWritePermission version = ");
        int r104 = Build.VERSION.SDK_INT;
        r103.append(r104);
        k.e("ShareUtils", r103.toString());
        if (r104 >= 29) goto L22;
        eo7.a r105 = eo7.a.b.f473353a;
        jn7.j r106 = r105.f473328b;
        if (r106 == null) goto L7;
        boolean r107 = r106.hasPermission(r100, "android.permission.WRITE_EXTERNAL_STORAGE");
    L8:
        if (r107 == true) goto L22;
        k.e("ShareUtils", "requestWritePermission request permission");
        go7.b.f(r101, false);
        Activity r108 = r105.h();
        if (r108 != null) goto L13;
        return;
    L13:
        r105.requestPermissions(r108, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, r101, new a(r101, r102));
        JSONObject r109 = new JSONObject();
        if (r101 != null) goto L24;
    L19:
        go7.b.a(r109);
        c.a("ug_sdk_share_authorize_popup_show", r109);
        if (r101.getEventCallBack() == null) goto L26;
        r101.getEventCallBack().c(PermissionType.SHOW, r101, "android.permission.WRITE_EXTERNAL_STORAGE");
        return;
    L26:
        return;
    L24:
        r109.put(ShareConstants.KEY_PANEL_TYPE, r101.getFrom());     // Catch: JSONException -> L17
        r109.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r101.getShareChanelType()));     // Catch: JSONException -> L17
        r109.put("share_type", ShareStrategy.getStrategyStr(r101.getShareStrategy()));     // Catch: JSONException -> L17
        r109.put("panel_id", r101.getPanelId());     // Catch: JSONException -> L17
        r109.put("resource_id", r101.getResourceId());     // Catch: JSONException -> L17
        go7.b.b(r109, r101.getLogEventParams());     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L7:
        r107 = false;
    L22:
        k.e("ShareUtils", "requestWritePermission permission onGranted");
        go7.b.f(r101, true);
        r102.onGranted();
    }
}
