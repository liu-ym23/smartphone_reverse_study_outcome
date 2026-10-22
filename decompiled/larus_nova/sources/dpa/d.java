package dpa;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f469618a;

    public static c a() {
        if (f469618a == null) goto L5;
        c r100 = ((com.larus.security.api.a) f469618a).a();
        if (r100.azerothGlobalSettings != null) goto L10;
        b r101 = new b();
        r101.global_function_switch = true;
        r100.azerothGlobalSettings = r101;
    L10:
        if (r100.testConf != null) goto L13;
        i r102 = new i();
        r102.msg = "hello from local default!";
        r102.version = 0;
        r100.testConf = r102;
    L13:
        if (r100.envReportSetting != null) goto L16;
        g r103 = new g();
        r103.enabled = true;
        r103.version = 0;
        r103.report_interval = 24;
        r103.collect_android_id = false;
        r103.collect_iccid = false;
        r103.collect_imei = false;
        r103.collect_mac = false;
        r103.min_report_interval = 28800;
        r100.envReportSetting = r103;
    L16:
        if (r100.dailyReportSetting != null) goto L19;
        f r104 = new f();
        r104.enabled = true;
        r100.dailyReportSetting = r104;
    L19:
        if (r100.cryptoSetting != null) goto L22;
        e r105 = new e();
        r105.enabled = true;
        r105.version = 0;
        r105.disable_crypto = false;
        r105.disable_android_key_store = false;
        r100.cryptoSetting = r105;
    L22:
        if (r100.aKexgSetting != null) goto L24;
        a r106 = new a();
        r106.downgrade = false;
        r100.aKexgSetting = r106;
    L24:
        return r100;
    L5:
        return c.a();
    }
}
