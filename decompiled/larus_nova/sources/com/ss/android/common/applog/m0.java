package com.ss.android.common.applog;

/* JADX INFO: loaded from: classes6.dex */
public final class m0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m0 f408190h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m0 f408191i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f408192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f408193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f408194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f408195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f408196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f408197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f408198g;

    static {
        m0 r100 = new m0(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}, new String[]{"https://log.snssdk.com/service/2/device_register/", "https://log.snssdk.com/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com/service/2/app_alert_check/"}, "https://log.zijieapi.com/service/2/log_settings/", new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, "https://log.zijieapi.com/service/2/log_settings/");
        f408190h = r100;
        f408191i = r100;
    }

    public final String toString() {
        return super.toString() + ":\nmApplogURL : " + this.f408192a + "\nmApplogTimelyUrl : " + this.f408194c + "\nmDeviceRegisterUrl : " + this.f408196e + "\nmAppActiveUrl : " + this.f408195d + "\nmApplogSettingsUrl : " + this.f408193b + "\n\nmApplogFallbackUrl : " + this.f408197f + "\nmApplogSettingsFallbackUrl : " + this.f408198g + "\nmUserProfileUrl : https://dpprofile.snssdk.com\n\n\n\n";
    }

    public m0(String[] r100, String[] r101, String[] r102, String[] r103, String r104, String[] r105, String r106) {
        this.f408192a = r100;
        this.f408193b = r104;
        this.f408194c = r101;
        this.f408195d = r103;
        this.f408196e = r102;
        this.f408197f = r105;
        this.f408198g = r106;
    }
}
