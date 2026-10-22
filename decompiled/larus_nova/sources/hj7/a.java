package hj7;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f485433a;

    public static BridgeResult a(int r100, JSONObject r101, String r102) {
        if (f485433a == true) goto L5;
        com.bytedance.ug.sdk.luckycat.utils.b.a(com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f(), "3.0 JSBRIDGE");
        f485433a = true;
    L5:
        if (r101 != null) goto L19;
        r101 = new JSONObject();
    L19:
        r101.put("bridge_version", "3.0");     // Catch: JSONException -> L9
    L11:
        if (r100 == 1) goto L13;
        if (r100 == 0) goto L16;
        BridgeResult r103 = BridgeResult.Companion.createSuccessResult();
        r103.setCode(r100);
        r103.setData(r101);
        r103.setMessage(r102);
        return r103;
    L16:
        return BridgeResult.Companion.createErrorResult(r102, r101);
    L13:
        return BridgeResult.Companion.createSuccessResult(r101, r102);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void b(IBridgeContext r100, String r101, JSONArray r110, String r111) {
        boolean r102 = false;
        if (r110 != null) goto L5;
    L72:
        r100.callback(a(0, null, "market pkg list is null"));
        return;
    L5:
        if (r110.length() == 0) goto L72;
        int r103 = 0;
    L9:
        if (r103 >= r110.length()) goto L85;
        String r104 = r110.optString(r103, "");
        if (TextUtils.isEmpty(r104) == true) goto L70;
        Activity r105 = r100.getActivity();
        if (r105 != null) goto L17;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L70;
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L30
        r112.put("enter_from", r111);     // Catch: Throwable -> L30
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_go_to_market", r112, true);     // Catch: Throwable -> L30
    L32:
        Activity r113 = r100.getActivity();
        if (TextUtils.isEmpty(r104) == false) goto L35;
    L69:
        r100.callback(a(1, null, "success"));
        return;
    L35:
        if (TextUtils.isEmpty(r101) == true) goto L69;
        if (TextUtils.isEmpty(r104) == false) goto L40;
    L46:
        boolean r114 = false;
    L47:
        if (r114 == true) goto L69;
        if (r104.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_MIUI) == false) goto L56;
        zl7.i r115 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r115 == null) goto L56;
        if (r115.O() == false) goto L56;
        r115.r(r113, r101);
    L56:
        Intent r116 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r116.setData(UriProtector.parse(BaseConstants.MARKET_PREFIX + r101));
        if (TextUtils.isEmpty(r104) == true) goto L80;
        r116.setPackage(r104);
    L80:
        List<ResolveInfo> r107 = r113.getPackageManager().queryIntentActivities(r116, 65536);     // Catch: Throwable -> L64
        if (r107 == null) goto L66;
        if (r107.size() <= 0) goto L66;
        r102 = true;
    L66:
        if (r102 == false) goto L69;
        r116.addFlags(268435456);
        r113.startActivity(r116);
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L66
    L40:
        if (r104.equalsIgnoreCase(RomUtils.MARKET_PKG_NAME_SAMSUNG) == false) goto L46;
        Intent r108 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("http://apps.samsung.com/appquery/appDetail.as?appId=" + r101));
        r108.setPackage(RomUtils.MARKET_PKG_NAME_SAMSUNG);
        r108.addFlags(268435456);
        r113.startActivity(r108);     // Catch: ActivityNotFoundException -> L44
        r114 = true;
    L44:
        e = move-exception;
        e.printStackTrace();
    L30:
        th = move-exception;
        th.getMessage();
        goto L32
    L17:
        if (TextUtils.isEmpty(r104) == false) goto L76;
        PackageInfo r109 = null;
    L22:
        if (r109 == null) goto L26;
        if (r109.applicationInfo.enabled == false) goto L26;
        r106 = true;
        goto L27
    L76:
        r109 = r105.getPackageManager().getPackageInfo(r104, 0);     // Catch: Exception -> L20
    L70:
        r103 = r103 + 1;
        goto L9
    }
}
