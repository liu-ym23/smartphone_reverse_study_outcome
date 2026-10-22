package com.ss.android.lark.monitor.traffic;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class RustSdkTrafficHandler extends a<TrafficMetrics> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e3c.a f432467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e3c.a f432468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RustSDKTrafficCallback f432469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledFuture<?> f432470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f432471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f432472g;

    public class RustSDKTrafficCallback implements IGetDataCallback<e3c.a> {
        private boolean mIsFirstCollect;
        final /* synthetic */ RustSdkTrafficHandler this$0;

        public RustSDKTrafficCallback(RustSdkTrafficHandler r100) {
            this.this$0 = r100;
            this.mIsFirstCollect = true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            Log.w("RustSdkTrafficHandler", "rustSDK traffic data error: " + r100.getMessage());
        }

        public void onSuccess(e3c.a r100) {
            if (r100 != null) goto L5;
            Log.i("RustSdkTrafficHandler", "rustSDK traffic data is null");
            return;
        L5:
            Log.i("RustSdkTrafficHandler", "rustSDK traffic data, wfRx: " + r100.f470953a + ",wfTx: " + r100.f470954b + ",mbRx: " + r100.f470955c + ",mbTx: " + r100.f470956d);
            RustSDKTrafficCallback r101 = this.this$0.f432469d;
            monitor-enter(r101);
        L13:
            th = move-exception;
            throw th;
        L8:
            if (this.mIsFirstCollect == false) goto L10;
            this.mIsFirstCollect = false;     // Catch: Throwable -> L13
            this.this$0.f432467b = r100;     // Catch: Throwable -> L13
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            return;
        L10:
            this.this$0.f432468c = r100;     // Catch: Throwable -> L13
            goto L11
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((e3c.a) r100);
        }
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        r100.from = "rust";
        RustSDKTrafficCallback r101 = this.f432469d;
        monitor-enter(r101);
        e3c.a r102 = this.f432468c;     // Catch: Throwable -> L18
        boolean r103 = true;
        if (r102 == null) goto L7;
        boolean r104 = true;
    L8:
        e3c.a r105 = this.f432467b;     // Catch: Throwable -> L18
        if (r105 != null) goto L13;
        r103 = false;
    L13:
        if ((r103 & r104) == false) goto L15;
        r100.mobileBytesRx = r102.f470955c - r105.f470955c;     // Catch: Throwable -> L18
        r100.mobileBytesTx = r102.f470956d - r105.f470956d;     // Catch: Throwable -> L18
        r100.wifiBytesRx = r102.f470953a - r105.f470953a;     // Catch: Throwable -> L18
        r100.wifiBytesTx = r102.f470954b - r105.f470954b;     // Catch: Throwable -> L18
        this.f432473a = r100;     // Catch: Throwable -> L18
    L15:
        this.f432467b = r102;     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r100;
    L7:
        r104 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public RustSdkTrafficHandler() {
        this.f432471f = false;
        this.f432472g = true;
        this.f432469d = new RustSDKTrafficCallback(this);
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (true != this.f432471f) goto L9;
        Log.i("RustSdkTrafficHandler", "rustSDK traffic data has started, isAppFront:true");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L9:
        this.f432471f = true;     // Catch: Throwable -> L19
        ScheduledFuture<?> r100 = this.f432470e;     // Catch: Throwable -> L19
        if (r100 == null) goto L13;
        r100.cancel(true);     // Catch: Throwable -> L19
        this.f432470e = null;     // Catch: Throwable -> L19
    L13:
        if (this.f432472g == false) goto L15;
        this.f432472g = false;     // Catch: Throwable -> L19
        long r101 = 5;
    L16:
        long r102 = r101;
        this.f432470e = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new e(this), r102, 30, TimeUnit.SECONDS);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L15:
        r101 = 30;
        goto L16
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        TrafficMetrics r101 = this.f432473a;
        if (r101 == null) goto L6;
        r100.f432502f = r101.totalKBytes();
        r100.f432505i = this.f432473a.totalMobileKBytes();
        r100.f432506j = this.f432473a.totalWifiKBytes();
        r100.f432503g = this.f432473a.totalRxKBytes();
        r100.f432504h = this.f432473a.totalTxKBytes();
        return;
    }
}
