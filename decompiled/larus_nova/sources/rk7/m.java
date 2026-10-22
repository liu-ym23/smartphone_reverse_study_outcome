package rk7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.agilelogger.ALog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Application f538347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f538348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ik7.g f538349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ik7.a f538350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ik7.b f538351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static tk7.b f538352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ik7.c f538353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ik7.d f538354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ik7.e f538355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ik7.f f538356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f538357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f538358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f538359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f538360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m f538361o = null;

    public m() {
    }

    private final Context getContext() {
        Object r100 = a().getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L9
        if (r100 == null) goto L8;
        return (Application) r100;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.toString();
        return null;
    }

    static {
        f538361o = new m();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static int f() {
        ik7.b r100 = f538351e;
        if (r100 == null) goto L6;
        return ((dn7.b) r100).a();
    L6:
        return f538359m;
    }

    public static Application g() {
        Application r100 = f538347a;
        if (r100 != null) goto L7;
        AtomicBoolean r101 = u.f538372v;
        return u.c.f538395a.f538374a;
    L7:
        return r100;
    }

    public static String h() {
        ik7.b r100 = f538351e;
        if (r100 == null) goto L11;
        bn7.a r101 = ((dn7.b) r100).f469365b;
        if (r101 == null) goto L7;
        String r102 = r101.getDeviceId();
    L8:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L7:
        r102 = "";
        goto L8
    L11:
        return "";
    }

    public static String i() {
        StringBuilder r100 = new StringBuilder("config secUserId = ");
        ik7.a r101 = f538350d;
        if (r101 == null) goto L8;
        com.bytedance.ug.sdk.luckycat.api.depend.c r102 = ((dn7.a) r101).f469363a;
        if (r102 == null) goto L7;
        String r103 = r102.getSecUid();
    L9:
        r100.append(r103);
        r100.append(", mSecUserId = ");
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogApiConfigManager", r100.toString());
        ik7.a r104 = f538350d;
        if (r104 == null) goto L18;
        com.bytedance.ug.sdk.luckycat.api.depend.c r105 = ((dn7.a) r104).f469363a;
        if (r105 == null) goto L14;
        String r106 = r105.getSecUid();
    L15:
        if (r106 != null) goto L17;
        return "";
    L17:
        return r106;
    L14:
        r106 = "";
        goto L15
    L18:
        return "";
    L7:
        r103 = "";
        goto L9
    L8:
        r103 = null;
        goto L9
    }

    public static String j() {
        StringBuilder r100 = new StringBuilder("config userId = ");
        ik7.a r101 = f538350d;
        if (r101 == null) goto L8;
        com.bytedance.ug.sdk.luckycat.api.depend.c r102 = ((dn7.a) r101).f469363a;
        if (r102 == null) goto L7;
        String r103 = r102.getUserId();
    L9:
        r100.append(r103);
        r100.append(", mUserId = ");
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogApiConfigManager", r100.toString());
        ik7.a r104 = f538350d;
        if (r104 == null) goto L18;
        com.bytedance.ug.sdk.luckycat.api.depend.c r105 = ((dn7.a) r104).f469363a;
        if (r105 == null) goto L14;
        String r106 = r105.getUserId();
    L15:
        if (r106 != null) goto L17;
        return "";
    L17:
        return r106;
    L14:
        r106 = "";
        goto L15
    L18:
        return "";
    L7:
        r103 = "";
        goto L9
    L8:
        r103 = null;
        goto L9
    }

    public static boolean k() {
        ik7.b r100 = f538351e;
        if (r100 == null) goto L9;
        bn7.a r101 = ((dn7.b) r100).f469365b;
        if (r101 == null) goto L10;
        r101.isBasicMode();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public static boolean m() {
        ik7.f r100 = f538356j;
        if (r100 == null) goto L5;
        r100.isDisable();
        return true;
    L5:
        return false;
    }

    public static boolean o() {
        ik7.a r100 = f538350d;
        if (r100 == null) goto L7;
        com.bytedance.ug.sdk.luckycat.api.depend.c r101 = ((dn7.a) r100).f469363a;
        if (r101 == null) goto L7;
        return r101.isLogin();
    L7:
        return false;
    }

    public static boolean p() {
        ik7.b r100 = f538351e;
        if (r100 == null) goto L9;
        bn7.a r101 = ((dn7.b) r100).f469365b;
        if (r101 == null) goto L10;
        r101.isTeenMode();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final Context e() {
        Context r100 = f538348b;
        if (r100 != null) goto L6;
        AtomicBoolean r101 = u.f538372v;
        r100 = u.c.f538395a.f538374a;
    L6:
        if (r100 == null) goto L9;
        return r100;
    L9:
        return getContext();
    }

    public static boolean n() {
        p();
        k();
        return false;
    }

    public static boolean l() {
        return f538357k;
    }

    public static void c(Context r100) {
        ik7.c r101 = f538353g;
        if (r101 == null) goto L8;
        bn7.c r102 = ((dn7.c) r101).f469366a;
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    public static void d(Runnable r100) {
        ik7.b r101 = f538351e;
        if (r101 == null) goto L8;
        bn7.a r102 = ((dn7.b) r101).f469365b;
        if (r102 == null) goto L9;
        r102.execute(r100);
        return;
    L9:
        return;
    }

    public final String b(String r110) {
        String r100 = r110;
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return "";
    L6:
        if (f538355i == null) goto L40;
        ik7.b r111 = f538351e;
        if (r111 == null) goto L40;
        if (((dn7.b) r111).a() == 2329) goto L39;
        ik7.b r112 = f538351e;
        if (r112 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        if (((dn7.b) r112).a() == 1128) goto L39;
        ik7.b r113 = f538351e;
        if (r113 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        if (((dn7.b) r113).a() == 1112) goto L39;
        ik7.b r114 = f538351e;
        if (r114 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        if (((dn7.b) r114).a() == 8663) goto L39;
        ik7.b r115 = f538351e;
        if (r115 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        if (((dn7.b) r115).a() == 568863) goto L39;
        ik7.b r116 = f538351e;
        if (r116 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        bn7.a r117 = ((dn7.b) r116).f469365b;
        if (r117 == null) goto L37;
        r117.e();
        boolean r118 = true;
    L38:
        if (r118 == false) goto L40;
    L37:
        r118 = false;
    L39:
        boolean r119 = true;
    L42:
        if (r119 == false) goto L53;
        Set<String> r120 = UriProtector.getQueryParameterNames(UriProtector.parse(r110));
        if (r120 != null) goto L46;
    L47:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogApiConfigManager", "addCommonParams for dy apps");
        ik7.e r121 = f538355i;
        if (r121 != null) goto L50;
        Intrinsics.throwNpe();
    L50:
        bn7.e r122 = ((dn7.e) r121).f469367a;
        if (r122 == null) goto L53;
        String r123 = r122.addCommonParams(r100);
    L109:
        Uri r124 = UriProtector.parse(r123);     // Catch: Throwable -> L106
        Uri.Builder r125 = r124.buildUpon();     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "device_id")) == false) goto L58;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogApiConfigManager", "addCommonParams(); deviceId is null;");     // Catch: Throwable -> L106
        r125.appendQueryParameter("device_id", h());     // Catch: Throwable -> L106
    L58:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "luckydog_api_verison")) == false) goto L61;
        r125.appendQueryParameter("luckydog_api_verison", "8.75.0-rc.12-db");     // Catch: Throwable -> L106
    L61:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "luckydog_sdk_verison")) == false) goto L64;
        r125.appendQueryParameter("luckydog_sdk_verison", il7.h.c());     // Catch: Throwable -> L106
    L64:
        String r101 = "0";
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "is_teen_mode")) == false) goto L68;
        p();     // Catch: Throwable -> L106
        r125.appendQueryParameter("is_teen_mode", "0");     // Catch: Throwable -> L106
    L68:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "status_bar_height")) == false) goto L82;
        int r102 = f538360n;     // Catch: Throwable -> L106
        if (r102 > 0) goto L80;
        Context r103 = f538348b;     // Catch: Throwable -> L106
        int r104 = r103.getResources().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Throwable -> L106
        if (r104 <= 0) goto L75;
        float r105 = r103.getResources().getDimension(r104);     // Catch: Throwable -> L106
        Resources r106 = r103.getResources();     // Catch: Throwable -> L106
        int r126 = (int) (r105 / WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density);     // Catch: Throwable -> L106
    L76:
        if (r126 != 0) goto L78;
        r102 = 25;
    L79:
        f538360n = r102;     // Catch: Throwable -> L106
        goto L80
    L78:
        r102 = r126;
        goto L79
    L75:
        r126 = 0;
    L80:
        r125.appendQueryParameter("status_bar_height", String.valueOf(r102));     // Catch: Throwable -> L106
    L82:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "lucky_is_32")) == false) goto L88;
        boolean r107 = zl7.b.f572790a;     // Catch: Throwable -> L106
        if (zl7.b.a(e()) == false) goto L86;
        r101 = "1";
    L86:
        r125.appendQueryParameter("lucky_is_32", r101);     // Catch: Throwable -> L106
    L88:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "lucky_device_score")) == false) goto L95;
        r125.appendQueryParameter("lucky_device_score", String.valueOf(il7.b.a()));     // Catch: Throwable -> L106
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L106
        r108.put("lucky_device_score", Float.valueOf(il7.b.a()));     // Catch: Throwable -> L106
        if (r100 != null) goto L93;
        r100 = "";
    L93:
        r108.put("lucky_path", r100);     // Catch: Throwable -> L106
        com.bytedance.ug.sdk.luckydog.api.log.b.a("lucky_request_device_score", r108);     // Catch: Throwable -> L106
    L95:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r124, "lucky_device_type")) == false) goto L97;
        r125.appendQueryParameter("lucky_device_type", Build.MODEL);     // Catch: Throwable -> L106
    L97:
        String r109 = UriProtector.getQueryParameter(r124, "aid");     // Catch: Throwable -> L106
        String r127 = String.valueOf(f());     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r109) == false) goto L100;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogApiConfigManager", "addCommonParams(); aid is null;");     // Catch: Throwable -> L106
        r125.appendQueryParameter("aid", r127);     // Catch: Throwable -> L106
    L100:
        String r128 = r125.build().toString();     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r109) == false) goto L103;
        return r128;
    L103:
        if ((!Intrinsics.areEqual(r109, r127)) == false) goto L112;
        return il7.q.a(r128, r127);
    L112:
        return r128;
    L106:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogApiConfigManager", th.getMessage());
        return r123;
    L46:
        if (r120.contains("version_code") == false) goto L47;
    L53:
        r123 = r100;
    L40:
        r119 = false;
        goto L42
    }

    public static void q(Activity r100, String r101, String r102) {
        ik7.a r103 = f538350d;
        if (r103 == null) goto L8;
        com.bytedance.ug.sdk.luckycat.api.depend.c r104 = ((dn7.a) r103).f469363a;
        if (r104 == null) goto L9;
        r104.a();
        return;
    L9:
        return;
    }

    public static void r(int r100, String r101, String r102, Throwable r103) {
        ik7.d r104 = f538354h;
        if (r104 == null) goto L26;
        r104.c(r100, r101, r102);
        return;
    L26:
        if (r100 != 2) goto L8;
        ALog.v(r101, r102);     // Catch: Throwable -> L22
    L25:
        return;
    L8:
        if (r100 != 3) goto L10;
        ALog.d(r101, r102);     // Catch: Throwable -> L22
        goto L25
    L10:
        if (r100 != 4) goto L12;
        ALog.i(r101, r102);     // Catch: Throwable -> L22
        goto L25
    L12:
        if (r100 != 5) goto L14;
        ALog.w(r101, r102, r103);     // Catch: Throwable -> L22
        goto L25
    L14:
        if (r100 == 6) goto L16;
        ALog.i(r101, r102);     // Catch: Throwable -> L22
        goto L25
    L16:
        ALog.e(r101, r102, r103);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    }
}
