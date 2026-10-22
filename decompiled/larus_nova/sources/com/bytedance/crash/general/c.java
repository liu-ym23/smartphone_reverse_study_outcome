package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f203206a;

    public static class a extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203207b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return Build.DISPLAY + "_" + this.f203207b;
        }

        public a() {
            this.f203207b = c.b("ro.gn.sv.version");
        }
    }

    public static class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203208b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return "coloros_" + this.f203208b + "_" + Build.DISPLAY;
        }

        public b() {
            this.f203208b = c.b("ro.build.version.opporom");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.general.c$c, reason: collision with other inner class name */
    public static class C2954c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203209b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            if (TextUtils.isEmpty(this.f203209b) == false) goto L5;
        L8:
            String r100 = Build.DISPLAY;
            if (r100 != null) goto L12;
            return "unknown";
        L12:
            return r100;
        L5:
            if (this.f203209b.toLowerCase(i.f203215a).contains("emotionui") == false) goto L8;
            return this.f203209b + "_" + Build.DISPLAY;
        }

        public C2954c() {
            this.f203209b = c.b(com.alipay.sdk.m.c.a.f25238a);
        }
    }

    public static class d extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203210b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return "eui_" + this.f203210b + "_" + Build.DISPLAY;
        }

        public d() {
            this.f203210b = c.b("ro.letv.release.version");
        }
    }

    public static class e extends i {
        public e() {
        }
    }

    public static class f extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f203212c;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return this.f203211b + "_" + this.f203212c;
        }

        public f() {
            this.f203211b = c.b("ro.vivo.os.build.display.id");
            this.f203212c = c.b("ro.vivo.product.version");
        }
    }

    public static class g extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203213b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return "miui_" + this.f203213b + "_" + Build.VERSION.INCREMENTAL;
        }

        public g() {
            this.f203213b = c.b("ro.miui.ui.version.name");
        }
    }

    public static class h extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f203214b;

        @Override // com.bytedance.crash.general.c.i
        public final String a() {
            return this.f203214b + "_" + Build.DISPLAY;
        }

        public h() {
            this.f203214b = c.b("ro.build.uiversion");
        }
    }

    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale f203215a = null;

        public String a() {
            String r100 = Build.DISPLAY;
            if (r100 != null) goto L6;
            return "unknown";
        L6:
            return r100;
        }

        static {
            f203215a = Locale.getDefault();
        }

        public i() {
        }
    }

    public static class j extends i {
        public j() {
        }
    }

    public static class k extends i {
        public k() {
        }
    }

    public static i c() {
        C2954c r100 = new C2954c();
        boolean r101 = false;
        if (TextUtils.isEmpty(r100.f203209b) == true) goto L90;
        String r102 = r100.f203209b.toLowerCase(i.f203215a);
        if (r102.startsWith("emotionui") == false) goto L7;
    L8:
        boolean r103 = true;
    L20:
        if (r103 == false) goto L22;
        return r100;
    L22:
        g r104 = new g();
        a("miui.os.Build");     // Catch: Throwable -> L25
        boolean r105 = true;
    L26:
        if (r105 == false) goto L28;
        return r104;
    L28:
        f r106 = new f();
        if (TextUtils.isEmpty(r106.f203211b) == false) goto L31;
    L33:
        boolean r107 = false;
    L34:
        if (r107 == false) goto L36;
        return r106;
    L36:
        b r108 = new b();
        String r109 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r109) == false) goto L39;
    L41:
        boolean r110 = false;
    L42:
        if (r110 == false) goto L44;
        return r108;
    L44:
        e r111 = new e();
        String r112 = Build.DISPLAY;
        if (TextUtils.isEmpty(r112) == true) goto L50;
        if (r112.toLowerCase(i.f203215a).contains("flyme") == false) goto L50;
    L48:
        boolean r113 = true;
    L55:
        if (r113 == false) goto L57;
        return r111;
    L57:
        d r114 = new d();
        if ((!TextUtils.isEmpty(r114.f203210b)) == false) goto L60;
        return r114;
    L60:
        j r115 = new j();
        StringBuilder r116 = new StringBuilder();
        String r117 = Build.BRAND;
        r116.append(r117);
        r116.append(r109);
        String r118 = r116.toString();
        if (TextUtils.isEmpty(r118) == false) goto L63;
    L65:
        boolean r119 = false;
    L66:
        if (r119 == false) goto L68;
        return r115;
    L68:
        a r120 = new a();
        if (TextUtils.isEmpty(r112) == false) goto L71;
    L73:
        boolean r121 = false;
    L74:
        if (r121 == false) goto L76;
        return r120;
    L76:
        h r122 = new h();
        String r123 = r109 + r117;
        if (TextUtils.isEmpty(r123) == true) goto L84;
        String r124 = r123.toLowerCase(i.f203215a);
        if (r124.contains(AppConstants.CHANNEL_360) == false) goto L82;
    L83:
        r101 = true;
        goto L84
    L82:
        if (r124.contains("qiku") == true) goto L83;
    L84:
        if (r101 == false) goto L87;
        return r122;
    L87:
        return new k();
    L71:
        if (r112.toLowerCase(i.f203215a).contains("amigo") == false) goto L73;
        r121 = true;
        goto L74
    L63:
        if (r118.toLowerCase(i.f203215a).contains("sony") == false) goto L65;
        r119 = true;
    L50:
        if (TextUtils.isEmpty(Build.USER) == false) goto L52;
    L54:
        r113 = false;
        goto L55
    L52:
        if (Build.USER.equals("flyme") == false) goto L54;
    L39:
        if (r109.toLowerCase(i.f203215a).contains(AppConstants.CHANNEL_OPPO) == false) goto L41;
        r110 = true;
        goto L42
    L31:
        if (r106.f203211b.toLowerCase(i.f203215a).contains("funtouch") == false) goto L33;
        r107 = true;
    L25:
        r105 = false;
        goto L26
    L7:
        if (r102.startsWith("magicui") == true) goto L8;
    L90:
        String r125 = Build.BRAND;     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r125) == true) goto L92;
        if (r125.toLowerCase(i.f203215a).startsWith(RomUtils.BRAND_HUAWEI) == true) goto L8;
    L92:
        String r126 = Build.MANUFACTURER;     // Catch: Throwable -> L89
        if (TextUtils.isEmpty(r126) == true) goto L19;
        if (r126.toLowerCase(i.f203215a).startsWith(RomUtils.BRAND_HUAWEI) == true) goto L8;
    L19:
        r103 = false;
        goto L20
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String b(String r100) {
        return (String) a("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, ""});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
