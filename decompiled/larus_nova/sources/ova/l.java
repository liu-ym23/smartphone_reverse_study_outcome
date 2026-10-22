package ova;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.applink.AppLinkConfigV3;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f526973a = 0;

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final boolean a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Log.i("ApplinkV3", "isAppLinkV3 " + r110.getHost() + ", path " + r110.getPath());
        if (idb.f.a().isCurrentEnable("openplatform.applink.v3") == true) goto L5;
        Log.e("ApplinkV3", "isAppLinkV3 fg not enabled");
    L5:
        AppLinkConfigV3 r100 = (AppLinkConfigV3) SettingManager.getInstance().get(AppLinkConfigV3.class);
        List<String> r101 = null;
        if (r100 == null) goto L8;
        List<String> r102 = r100.b();
    L10:
        if (r102 != null) goto L12;
        Log.e("ApplinkV3", "setting hosts null");
        return false;
    L12:
        Log.i("ApplinkV3", "settings hosts " + CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null));
        if (r102.contains(r110.getHost()) == false) goto L28;
        AppLinkConfigV3 r103 = (AppLinkConfigV3) SettingManager.getInstance().get(AppLinkConfigV3.class);
        if (r103 == null) goto L17;
        r101 = r103.d();
    L17:
        List<String> r111 = r110.getPathSegments();
        Intrinsics.checkNotNull(r111);
        if ((!r111.isEmpty()) == false) goto L25;
        String r112 = HTTP.URL_DEFAULT + ((String) ListProtector.get(r111, 0));
        if (r101 != null) goto L22;
    L24:
        Log.e("ApplinkV3", "paths V3 not contains root path");
        return false;
    L22:
        if (r101.contains(r112) == false) goto L24;
        return true;
    L25:
        Log.e("ApplinkV3", "uri paths is null");
        return false;
    L28:
        return false;
    L8:
        r102 = null;
        goto L10
    }

    @JvmStatic
    public static final Uri b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        AppLinkConfigV3 r101 = (AppLinkConfigV3) SettingManager.getInstance().get(AppLinkConfigV3.class);
        if (r101 == null) goto L5;
        HashMap<String, k> r102 = r101.a();
    L6:
        List<String> r103 = r100.getPathSegments();
        boolean r104 = false;
        if (r102 != null) goto L9;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        Log.e("ApplinkV3", "converters is null");
        return r100;
    L16:
        Iterator r106 = CollectionsKt.filterNotNull(r102.values()).iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        Log.i("ApplinkV3", ((k) r106.next()).a());
        goto L18
    L20:
        Intrinsics.checkNotNull(r103);
        if ((!r103.isEmpty()) == false) goto L47;
        k r107 = r102.get(HTTP.URL_DEFAULT + ((String) ListProtector.get(r103, 0)));
        if (r107 == null) goto L43;
        String r108 = r107.b();
        if (r108 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        if (r109 == false) goto L33;
        Log.e("ApplinkV3", "converter targetPath is empty for " + ((String) ListProtector.get(r103, 0)));
        return r100;
    L33:
        Uri.Builder r110 = r100.buildUpon().scheme("lark").authority("applink").path(r108);
        String r111 = r107.c();
        if (r111 == null) goto L49;
        if (r103.size() != 2) goto L49;
        if (r111.length() <= 0) goto L40;
        r104 = true;
    L40:
        if (r104 == false) goto L49;
        r110.appendQueryParameter(r111, (String) ListProtector.get(r103, 1));
    L49:
        return r110.build();
    L27:
        if (r108.length() == 0) goto L30;
        r109 = false;
        goto L31
    L43:
        Log.e("ApplinkV3", "converter is not supported for " + ((String) ListProtector.get(r103, 0)));
        return r100;
    L47:
        return r100;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r105 = false;
        goto L14
    L5:
        r102 = null;
        goto L6
    }
}
