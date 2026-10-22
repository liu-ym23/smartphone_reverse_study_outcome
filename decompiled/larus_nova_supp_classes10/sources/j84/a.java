package j84;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Handler;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.networklistener.WifiChangeListener;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.larus.apm.impl.protector.RunnableProtector;
import m84.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements WifiChangeListener {
    public static volatile a e;
    public static long f;
    public volatile boolean a;
    public RunnableC0146a b;
    public final Handler c;
    public volatile long d;

    /* JADX INFO: renamed from: j84.a$a, reason: collision with other inner class name */
    public class RunnableC0146a implements Runnable {
        public long a;
        public volatile boolean b;
        public long c;
        public String d;
        public final /* synthetic */ a e;

        public final void a() {
            if (BDLocationConfig.isRestrictedModeOn() == false) goto L5;
        L53:
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is return");
            Logger.i("BDLocation_LocationScheduler_pollupload:onCancel");
            this.b = true;
            this.e.c.removeCallbacksAndMessages(null);
            return;
        L5:
            if (LocationUtil.checkBackground() == true) goto L53;
            long r2 = System.currentTimeMillis();
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask intervalMs:" + this.c + "---currentTimeMs:" + r2 + "---lastScheduleTimeMs:" + this.a);
            if ((r2 - this.a) >= this.c) goto L11;
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is exception");
            this.e.c.removeCallbacksAndMessages(null);
        L11:
            if (this.b == true) goto L51;
            String r0 = this.d;
            monitor-enter(this);
        L48:
            th = move-exception;
            throw th;
        L15:
            if ((System.currentTimeMillis() - a.f) >= 55000) goto L19;
            Logger.i("BDLocation_UploadScheduleController_pollupload lastUploadTime:" + a.f);     // Catch: Throwable -> L48
            monitor-exit(this);
        L47:
            this.d = "";
            this.a = r2;
            goto L51
        L19:
            a.f = System.currentTimeMillis();     // Catch: Throwable -> L48
            if (BDLocationConfig.isUpload() == true) goto L22;
        L45:
            Logger.i(":---isPollingUpload:" + BDLocationConfig.isPollingUpload());     // Catch: Throwable -> L48
            monitor-exit(this);
            goto L47
        L22:
            if (BDLocationConfig.isPollingUpload() == false) goto L45;
            if (BDLocationConfig.isRestrictedModeOn() == true) goto L45;
        L29:
            e = move-exception;
            Logger.e("BDLocation_UploadScheduleController_pollupload:" + e.getMessage());     // Catch: Throwable -> L48
        L43:
            monitor-exit(this);
            goto L47
        L27:
            if (BDLocationConfig.isUploadLocation() == true) goto L32;
            Logger.i("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus1");     // Catch: Exception -> L29 Throwable -> L48
            LocationUtil.uploadDeviceStatus("bdlocation_upload_internal_polling", 0);     // Catch: Exception -> L29 Throwable -> L48
            goto L43
        L32:
            if (LocationUtil.isLocationEnabled() == true) goto L34;
        L40:
            Logger.i("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus2 no Permission");     // Catch: Exception -> L29 Throwable -> L48
            LocationUtil.uploadDeviceStatus("bdlocation_upload_internal_polling", 0);     // Catch: Exception -> L29 Throwable -> L48
            goto L43
        L34:
            if (LocationUtil.needLocate() == false) goto L40;
            Logger.i("BDLocation_UploadScheduleController_pollupload:getLocationAsync");     // Catch: Exception -> L29 Throwable -> L48
            if (LocationInfoConst.NETWORK_CHANGE_CERT.equals(r0) == false) goto L38;
            Object r1 = BDLocationConfig.getBpeaCert(LocationInfoConst.NETWORK_CHANGE_CERT);     // Catch: Exception -> L29 Throwable -> L48
            String r5 = "bdlocation_upload_network_change";
        L39:
            b.c(r5, r1);     // Catch: Exception -> L29 Throwable -> L48
            goto L43
        L38:
            r1 = BDLocationConfig.getBpeaCert(LocationInfoConst.POLL_CERT);     // Catch: Exception -> L29 Throwable -> L48
            r5 = "bdlocation_upload_internal_polling";
        L51:
            this.b = false;
            long r3 = this.e.b();
            this.c = r3;
            this.e.c.postDelayed(this, r3);
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

        public RunnableC0146a(a r3) {
            this.e = r3;
            this.a = 0;
            this.b = true;
            this.c = r3.b();
        }
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        boolean r0 = this.a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void g() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.b != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.a == false) goto L15;
        long r0 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L17
        if (r0 < 0) goto L12;
        this.d = r0;     // Catch: Throwable -> L17
    L12:
        RunnableC0146a r1 = this.b;     // Catch: Throwable -> L17
        r1.getClass();     // Catch: Throwable -> L17
        Logger.i("BDLocation_LocationScheduler_pollupload:onCancel");     // Catch: Throwable -> L17
        r1.b = true;     // Catch: Throwable -> L17
        r1.e.c.removeCallbacksAndMessages(null);     // Catch: Throwable -> L17
        this.a = false;     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public static a a() {
        if (e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public final long b() {
        if (this.d != 0) goto L6;
        this.d = BDLocationConfig.getUploadInterval();
    L6:
        return this.d;
    }

    public a() {
        this.a = false;
        this.d = 0;
        this.c = new Handler(ThreadLooperManager.getPollUploadWorker());
        NetworkManager.getInstance().setListener(this);
    }

    public final void f() {
        if (b() != BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L5;
        return;
    L5:
        if (this.a == false) goto L18;
        long r0 = BDLocationConfig.getUploadInterval();
        if (r0 < 0) goto L11;
        this.d = r0;
    L11:
        long r1 = System.currentTimeMillis() - f;
        if (r1 < BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L14;
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:onStart" + b());
        e(100, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    L14:
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:resetControllerIntervalMs" + b());
        e(BDLocationConfig.getNetworkStatusChangeUploadInterval() - r1, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    }

    public final synchronized void d(long r4) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.a == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (r4 < 0) goto L10;
        this.d = r4;     // Catch: Throwable -> L15
    L10:
        if (this.b != null) goto L12;
        this.b = new RunnableC0146a(this);     // Catch: Throwable -> L15
    L12:
        this.c.post(this.b);     // Catch: Throwable -> L15
        this.a = true;     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public final void notifyWifiChangedTwo(NetworkInfo r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isAvailable() == false) goto L8;
        Logger.i("UploadScheduleController notifyWifiChanged two");
        f();
        return;
    }

    public final void e(long r3, String r5) {
        RunnableC0146a r0 = this.b;
        if (r0 == null) goto L6;
        r0.d = r5;
        r0.c = r3;
        Logger.i("BDLocation_LocationScheduler_pollupload resetIntervalMs intervalMs：" + r3);
        r0.e.c.removeCallbacksAndMessages(null);
        r0.e.c.postDelayed(r0, r3);
        return;
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public final void notifyWifiChanged(Network r1, NetworkCapabilities r2) {
        if (r2.hasCapability(16) == false) goto L6;
        Logger.i("UploadScheduleController notifyWifiChanged");
        f();
        return;
    }
}
