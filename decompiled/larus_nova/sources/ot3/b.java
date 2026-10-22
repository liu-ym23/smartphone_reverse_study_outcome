package ot3;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import mt3.i;
import org.json.JSONObject;
import xu3.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f526660e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f526661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f526662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f526663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f526664d;

    public static b b() {
        if (f526660e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f526660e != null) goto L9;
        f526660e = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f526660e;
    }

    public final void c() {
        a r100 = new a();
        r100.f526643j = "Android";
        r100.f526644k = "android";
        r100.f526645l = Build.VERSION.RELEASE;
        r100.f526646m = Build.VERSION.SDK_INT;
        r100.f526647n = Build.MODEL;
        String r101 = Build.BRAND;
        r100.f526648o = r101;
        String r102 = Build.MANUFACTURER;
        r100.f526649p = r102;
        r100.f526650q = du3.a.e();
        r100.f526651r = du3.a.k();
        if (f.f565091b == true) goto L5;
    L7:
        boolean r103 = true;
        if (f.a("miui.os.Build") == null) goto L12;
        f.f565090a = true;     // Catch: Exception -> L162
        boolean r104 = true;
    L13:
        String r105 = "";
        if (r104 == true) goto L165;
        String r106 = Build.DISPLAY;
        boolean r107 = false;
        if (r106.contains("Flyme") == false) goto L25;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == true) goto L31;
        String r109 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r109) == true) goto L36;
        boolean r110 = r109.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L37:
        if (r110 == true) goto L39;
        String r111 = f.c(com.alipay.sdk.m.c.a.f25238a);
        if (r111 != null) goto L46;
    L48:
        String r112 = "";
    L50:
        if (TextUtils.isEmpty(r112) == true) goto L52;
        String r113 = r112;
    L86:
        f.f565092c = r113;
    L87:
        r100.f526652s = r113;
        Application r114 = xu3.a.getContext();
        FileChannel r115 = null;
        if (i.f515634a != null) goto L163;
        i.f515634a = new Properties();
        InputStream r116 = r114.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L93
        i.f515634a.load(r116);     // Catch: Throwable -> L159
    L95:
        xu3.c.a(r116);
    L179:
        i.f515634a = null;     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        xu3.c.a(r116);
        throw th;
    L93:
        r116 = null;
    L163:
        Properties r117 = i.f515634a;     // Catch: Exception -> L160
        if (r117 == null) goto L105;
        if (r117.containsKey("release_build") == false) goto L105;
        Object r118 = i.f515634a.get("release_build");     // Catch: Exception -> L160
    L106:
        r100.f526657x = String.valueOf(r118);
        r100.f526656w = du3.a.g();
        r100.f526636c = du3.a.d();
        r100.f526634a = du3.a.b();
        r100.f526655v = du3.a.f470025c.getUid();
        r100.f526637d = String.valueOf(du3.a.l());
        if (TextUtils.isEmpty(du3.a.f470030h) == true) goto L109;
    L118:
        r100.f526641h = du3.a.f470030h;
        r100.f526640g = String.valueOf(du3.a.n());
        r100.f526638e = du3.a.c();
        r100.f526642i = du3.a.i();
        r100.f526653t = xu3.a.getContext().getPackageName();
        r100.B = r100.f526637d;
        r100.f526639f = du3.a.h();
        r100.C = du3.a.f470039q;
        JSONObject r119 = new JSONObject();
        xu3.d.a(r119, du3.a.j());     // Catch: Exception -> L135
        if (r119.has("version_code") == false) goto L123;
        r119.remove("version_code");     // Catch: Exception -> L135
    L123:
        if (r119.has("app_version") == false) goto L126;
        r119.remove("app_version");     // Catch: Exception -> L135
    L126:
        if (r119.has("uid") == false) goto L129;
        r119.remove("uid");     // Catch: Exception -> L135
    L129:
        if (r119.has("update_version_code") == false) goto L132;
        r119.remove("update_version_code");     // Catch: Exception -> L135
    L132:
        if (r119.has("manifest_version_code") == false) goto L137;
        r119.remove("manifest_version_code");     // Catch: Exception -> L135
    L137:
        r100.f526659z = r119;
        r100.f526654u = "5.0.21.46-alpha.1";
        if (du3.a.o() == false) goto L143;
        d r120 = d.a.f526667a;
        r120.a();
        PolarisFileWrapper r121 = r120.f526666b;
        if (r121 == null) goto L143;
        r121.listFiles(new c());
    L143:
        String r122 = String.valueOf(e.a());
        ((ConcurrentHashMap) this.f526661a).put(r122, r100);
        this.f526662b = r100;
        d r123 = d.a.f526667a;
        r123.a();
        if (r123.f526666b == null) goto L183;
        JSONObject r124 = e.b(r100);
        if (r124 != null) goto L177;
        return;
    L177:
        r115 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r123.f526666b, r122 + ".bin")).getChannel();     // Catch: Throwable -> L152
        r115.write(ByteBuffer.wrap(r124.toString().getBytes()));     // Catch: Throwable -> L152
    L154:
        xu3.c.a(r115);
        return;
    L152:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        xu3.c.a(r115);
        throw th;
    L183:
        return;
    L135:
        e = move-exception;
        av3.b.b("APM", "header json exception" + e.toString());
        goto L137
    L109:
        monitor-enter(du3.a.class);
    L115:
        th = move-exception;
        throw th;
    L111:
        if (TextUtils.isEmpty(du3.a.f470030h) == false) goto L113;
        du3.a.f470030h = du3.a.f470025c.getVersionName();     // Catch: Throwable -> L115
    L113:
        monitor-exit(du3.a.class);     // Catch: Throwable -> L115
    L105:
        r118 = null;
        goto L106
    L52:
        String r125 = f.c("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r125) == false) goto L55;
    L57:
        boolean r126 = false;
    L58:
        if (r126 == false) goto L61;
        r113 = f.c("ro.vivo.os.build.display.id") + "_" + f.c("ro.vivo.product.version");
        goto L86
    L61:
        if (TextUtils.isEmpty(r106) == false) goto L63;
    L65:
        boolean r127 = false;
    L66:
        if (r127 == false) goto L68;
        r113 = r106 + "_" + f.c("ro.gn.sv.version");
        goto L86
    L68:
        String r128 = r102 + r101;
        if (TextUtils.isEmpty(r128) == true) goto L76;
        String r129 = r128.toLowerCase(Locale.getDefault());
        if (r129.contains(AppConstants.CHANNEL_360) == false) goto L74;
    L75:
        r107 = true;
        goto L76
    L74:
        if (r129.contains("qiku") == true) goto L75;
    L76:
        if (r107 == false) goto L79;
        r113 = f.c("ro.build.uiversion") + "_" + r106;
        goto L86
    L79:
        if ((!TextUtils.isEmpty(f.c("ro.letv.release.version"))) == false) goto L82;
        r105 = "eui_" + f.c("ro.letv.release.version") + "_" + r106;
    L82:
        if (TextUtils.isEmpty(r105) == true) goto L84;
    L83:
        r113 = r105;
        goto L86
    L84:
        f.f565091b = true;
    L85:
        r113 = r106;
        goto L86
    L63:
        if (r106.toLowerCase(Locale.getDefault()).contains("amigo") == false) goto L65;
        r127 = true;
        goto L66
    L55:
        if (r125.toLowerCase(Locale.getDefault()).contains("funtouch") == false) goto L57;
        r126 = true;
        goto L58
    L46:
        if (r111.toLowerCase(Locale.getDefault()).contains("emotionui") == false) goto L48;
        r112 = r111 + "_" + r106;
        goto L50
    L39:
        if (TextUtils.isEmpty(r109) == true) goto L41;
        r107 = r109.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO);
    L41:
        if (r107 == false) goto L83;
        r113 = "coloros_" + f.c("ro.build.version.opporom") + "_" + r106;
        goto L86
    L36:
        r110 = false;
        goto L37
    L31:
        if (r106.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L83;
    L25:
        if ("flyme".equals(Build.USER) == true) goto L28;
        r108 = false;
        goto L29
    L165:
        if (f.a("miui.os.Build") == null) goto L19;
        f.f565090a = true;     // Catch: Exception -> L161
    L20:
        if (r103 == false) goto L83;
        r113 = "miui_" + f.c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L19:
        r103 = f.f565090a;
    L12:
        r104 = f.f565090a;
        goto L13
    L5:
        if (TextUtils.isEmpty(f.f565092c) == true) goto L7;
        r113 = f.f565092c;
        goto L87
    }

    public b() {
        this.f526661a = new ConcurrentHashMap();
        this.f526663c = -1;
        this.f526664d = -1;
    }

    public final a a(String r100) {
        if (((ConcurrentHashMap) this.f526661a).containsKey(r100) == false) goto L5;
        a r101 = (a) ((ConcurrentHashMap) this.f526661a).get(r100);
    L21:
        if (r101 != null) goto L24;
    L38:
        return r101;
    L24:
        if (TextUtils.isEmpty(r101.f526635b) == false) goto L26;
        r101.f526635b = du3.a.f();
    L26:
        du3.b r102 = du3.a.f470025c;
        if (r102 == null) goto L29;
        r102.c();
        r101.f526658y = null;
    L29:
        long r103 = this.f526664d;
        if (r103 == (-1)) goto L33;
        r101.D = r103;
        r101.E = this.f526663c;
    L33:
        if (xu3.a.a() == false) goto L35;
        List<String> r104 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "nptTime:" + this.f526664d + " nptOffset:" + this.f526663c);
    L35:
        r101.f526655v = du3.a.f470025c.getUid();
        r101.C = du3.a.f470039q;
        a r105 = this.f526662b;
        if (r105 == null) goto L38;
        r101.B = r105.f526637d;
        goto L38
    L5:
        d r106 = d.a.f526667a;
        r106.a();
        if (r106.f526666b == null) goto L18;
        byte[] r107 = xu3.b.b(new PolarisFileWrapper(r106.f526666b, r100 + ".bin"));
        if (r107 == null) goto L18;
        a r108 = new a();     // Catch: Exception -> L17
        JSONObject r109 = new JSONObject(new String(r107));     // Catch: Exception -> L17
        r108.f526640g = xu3.d.g(r109, "version_code");     // Catch: Exception -> L17
        r108.f526641h = xu3.d.g(r109, "version_name");     // Catch: Exception -> L17
        r108.f526639f = xu3.d.g(r109, "manifest_version_code");     // Catch: Exception -> L17
        r108.f526637d = xu3.d.g(r109, "update_version_code");     // Catch: Exception -> L17
        r108.f526638e = xu3.d.g(r109, "app_version");     // Catch: Exception -> L17
        r108.f526643j = xu3.d.g(r109, "os");     // Catch: Exception -> L17
        r108.f526644k = xu3.d.g(r109, "device_platform");     // Catch: Exception -> L17
        r108.f526645l = xu3.d.g(r109, "os_version");     // Catch: Exception -> L17
        r108.f526646m = xu3.d.e(r109, "os_api");     // Catch: Exception -> L17
        r108.f526647n = xu3.d.g(r109, "device_model");     // Catch: Exception -> L17
        r108.f526648o = xu3.d.g(r109, "device_brand");     // Catch: Exception -> L17
        r108.f526649p = xu3.d.g(r109, "device_manufacturer");     // Catch: Exception -> L17
        r108.f526650q = xu3.d.g(r109, "process_name");     // Catch: Exception -> L17
        r108.f526651r = xu3.d.f(r109, WsConstants.KEY_SESSION_ID);     // Catch: Exception -> L17
        r108.f526652s = xu3.d.g(r109, "rom_version");     // Catch: Exception -> L17
        r108.f526653t = xu3.d.g(r109, "package");     // Catch: Exception -> L17
        r108.f526654u = xu3.d.g(r109, MonitorConstants.EXTRA_MONITOR_VERSION);     // Catch: Exception -> L17
        r108.f526636c = xu3.d.g(r109, "channel");     // Catch: Exception -> L17
        r108.f526634a = xu3.d.e(r109, "aid");     // Catch: Exception -> L17
        r108.f526635b = xu3.d.g(r109, "device_id");     // Catch: Exception -> L17
        r108.f526656w = xu3.d.f(r109, "phone_startup_time");     // Catch: Exception -> L17
        r108.f526642i = xu3.d.g(r109, "release_build");     // Catch: Exception -> L17
        r108.f526655v = xu3.d.f(r109, "uid");     // Catch: Exception -> L17
        r108.f526657x = xu3.d.g(r109, "verify_info");     // Catch: Exception -> L17
        r108.B = xu3.d.g(r109, "current_update_version_code");     // Catch: Exception -> L17
        if (r109.has("config_time") == false) goto L44;
        r108.C = xu3.d.e(r109, "config_time");     // Catch: Exception -> L17
    L44:
        r108.A = new JSONObject((String) r109.remove("filters"));     // Catch: Exception -> L41
    L15:
        r108.f526659z = r109;     // Catch: Exception -> L17
    L19:
        if (r108 == null) goto L40;
        ((ConcurrentHashMap) this.f526661a).put(r100, r108);
        r101 = r108;
        goto L21
    L40:
        return this.f526662b;
    L18:
        r108 = null;
        goto L19
    }
}
