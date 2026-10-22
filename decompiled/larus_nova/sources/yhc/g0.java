package yhc;

import android.app.Activity;
import android.content.SharedPreferences;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.update.UpdateService;

/* JADX INFO: loaded from: classes40.dex */
public final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f567695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f567696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f567697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.update.e f567698d;

    public final void a() {
        if (this.f567695a.isFinishing() == true) goto L77;
        e0 r100 = e0.a(this.f567695a);
        long r101 = System.currentTimeMillis();
        int r102 = this.f567698d.f455322a.getVersionCode();
        this.f567698d.f455324c = r100.b("pre_download_version", 0);
        this.f567698d.f455325d = r100.b("pre_download_delay_days", 0);
        this.f567698d.f455326e = r100.f567691a.getLong("pre_download_delay_second", -1);
        this.f567698d.f455327f = r100.f567691a.getLong("pre_download_start_time", 0);
        this.f567698d.f455328g = r100.b("last_hint_version", 0);
        this.f567698d.f455329h = r100.b("hint_version_delay_days", 0);
        this.f567698d.f455330i = r100.f567691a.getLong("last_hint_time", 0);
        if (this.f567698d.f455322a.needPreDownload() == false) goto L21;
        com.ss.android.update.e r103 = this.f567698d;
        if (r102 == r103.f455324c) goto L11;
        r103.f455324c = r102;
        r103.f455325d = r103.f455322a.getPreDownloadDelayDays();
        com.ss.android.update.e r104 = this.f567698d;
        r104.f455326e = r104.f455322a.getPreDownloadDelaySecond();
        com.ss.android.update.e r105 = this.f567698d;
        r105.f455327f = r101;
        r100.c("pre_download_version", r105.f455324c);
        r100.c("pre_download_delay_days", this.f567698d.f455325d);
        long r106 = this.f567698d.f455326e;
        SharedPreferences.Editor r107 = r100.f567691a.edit();
        r107.putLong("pre_download_delay_second", r106);
        r107.apply();
        long r108 = this.f567698d.f455327f;
        SharedPreferences.Editor r109 = r100.f567691a.edit();
        r109.putLong("pre_download_start_time", r108);
        r109.apply();
    L11:
        if (Logger.debug() == false) goto L13;
        String r110 = "UpdateShowServiceImpl";
        Logger.i(r110, "need pre download, version " + this.f567698d.f455324c + ", delay " + this.f567698d.f455325d + ", delay s " + this.f567698d.f455326e + ", start " + this.f567698d.f455327f);
    L15:
        if (this.f567698d.f455322a.getUpdateReadyApk() != null) goto L23;
        if (NetworkUtils.isWifi(this.f567695a) == false) goto L23;
        this.f567698d.f455322a.startPreDownload();
        if (Logger.debug() == false) goto L23;
        Logger.i(r110, "begin pre download");
    L23:
        if (this.f567698d.f455322a.isClientStrategyEnable() == false) goto L74;
        com.ss.android.update.e r111 = this.f567698d;
        if (r111.f455326e != (-1)) goto L27;
        String r112 = "last_hint_version";
        if (r111.f455322a.needPreDownload() == false) goto L46;
        com.ss.android.update.e r113 = this.f567698d;
        if ((r101 - r113.f455327f) >= (((long) ((r113.f455325d * 24) * AnnouncementViewModel.HOUR_DURATION)) * 1000)) goto L46;
        if (Logger.debug() == false) goto L43;
        Logger.i(r110, "in pre download delay");
    L43:
        com.ss.android.update.c.k(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
        return;
    L46:
        if (Logger.debug() == false) goto L49;
        Logger.i(r110, "hint version " + this.f567698d.f455328g + ", delay " + this.f567698d.f455329h + ", start " + this.f567698d.f455330i);
    L49:
        if (this.f567698d.f455322a.isForceUpdate() == true) goto L75;
        com.ss.android.update.e r114 = this.f567698d;
        if (r102 == r114.f455328g) goto L53;
        r114.f455329h = 0;
        long r115 = 0;
        r114.f455330i = 0;
    L54:
        long r116 = this.f567696b.f567699a;
        if (r116 > r115) goto L59;
        r116 = ((long) ((r114.f455329h * 24) * AnnouncementViewModel.HOUR_DURATION)) * 1000;
    L59:
        if ((r101 - r114.f455330i) >= r116) goto L63;
        com.ss.android.update.c.k(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
        return;
    L63:
        if (NetworkUtils.isWifi(this.f567695a) == true) goto L67;
        com.ss.android.update.c.k(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
        return;
    L67:
        if (this.f567696b.f567699a > 0) goto L75;
        com.ss.android.update.e r117 = this.f567698d;
        int r118 = r117.f455329h;
        if (r118 > 0) goto L71;
        r117.f455329h = 1;
        goto L75
    L71:
        int r119 = r118 * 2;
        r117.f455329h = r119;
        if (r119 <= 16) goto L75;
        r117.f455329h = 16;
        goto L75
    L53:
        r115 = 0;
    L75:
        com.ss.android.update.e r120 = this.f567698d;
        r120.f455328g = r102;
        r120.f455330i = r101;
        r100.c(r112, r102);
        r100.c("hint_version_delay_days", this.f567698d.f455329h);
        long r121 = this.f567698d.f455330i;
        SharedPreferences.Editor r122 = r100.f567691a.edit();
        r122.putLong("last_hint_time", r121);
        r122.apply();
        this.f567698d.f455322a.showUpdateDialog(2, this.f567695a, this.f567697c);
        return;
    L27:
        if (r111.f455322a.needPreDownload() == false) goto L35;
        com.ss.android.update.e r123 = this.f567698d;
        r112 = "last_hint_version";
        if ((r101 - r123.f455327f) >= (r123.f455326e * 1000)) goto L46;
        if (Logger.debug() == false) goto L33;
        Logger.i(r110, "in ore download delay second");
    L33:
        com.ss.android.update.c.k(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
        return;
    L35:
        r112 = "last_hint_version";
        goto L46
    L74:
        r112 = "last_hint_version";
        goto L75
    L13:
        r110 = r14;
        goto L15
    L21:
        r110 = "UpdateShowServiceImpl";
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g0(com.ss.android.update.e r100, Activity r101, i0 r102, boolean r103) {
        this.f567698d = r100;
        this.f567695a = r101;
        this.f567696b = r102;
        this.f567697c = r103;
    }
}
