package ok4;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.transfer.DoraDeviceLinkType;
import com.bytedance.dora.transfer.DoraTransferDirection;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ok4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f523649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f523650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f523651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f523652d;

    public class a implements IDoraLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f523653a;

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
            IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
            IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
            IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onScanFailed(int r100) {
            IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
        }

        public a(e r100) {
            this.f523653a = r100;
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            if (r102 != 0) goto L9;
            j.d("DoraTransferRateTrackerImpl", "Device disconnected, ending all active sessions.");
            e r103 = this.f523653a;
            int r104 = 0;
            String[] r105 = (String[]) r103.f523650b.keySet().toArray(new String[0]);
            int r106 = r105.length;
        L4:
            if (r104 >= r106) goto L13;
            String r107 = r105[r104];
            b r108 = r103.f523650b.get(r107);
            if (r108 == null) goto L8;
            r103.b(r107, r108.f523656c, new f.a("SPPDisconnect"));
        L8:
            r104 = r104 + 1;
            goto L4
        L13:
            return;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f523654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraDeviceLinkType f523655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ok4.a f523656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DoraTransferDirection f523657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f523658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicLong f523659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicLong f523660g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile long f523661h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile double f523662i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f523663j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ScheduledFuture<?> f523664k;

        public b(String r100, DoraDeviceLinkType r101, ok4.a r102, DoraTransferDirection r103, long r104) {
            this.f523659f = new AtomicLong(0);
            this.f523660g = new AtomicLong(0);
            this.f523662i = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.f523663j = false;
            this.f523654a = r100;
            this.f523655b = r101;
            this.f523656c = r102;
            this.f523657d = r103;
            this.f523658e = r104;
            this.f523661h = r104;
        }
    }

    public e() {
        this.f523649a = null;
        this.f523650b = new ConcurrentHashMap();
        this.f523651c = new ConcurrentHashMap();
        this.f523652d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("DoraTransferRateTrackerImpl"));
        ak4.a.d().registerDoraLinkCallback(new a(this));
    }

    public static void a(b r110, boolean r111) {
        monitor-enter(r110);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r110.f523663j == false) goto L9;
        if (r111 == true) goto L9;
        monitor-exit(r110);     // Catch: Throwable -> L33
        return;
    L9:
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L33
        long r101 = r100 - r110.f523661h;     // Catch: Throwable -> L33
        if (r101 > 0) goto L14;
        monitor-exit(r110);     // Catch: Throwable -> L33
        return;
    L14:
        if (r111 == false) goto L16;
    L19:
        long r102 = r110.f523659f.getAndSet(0);     // Catch: Throwable -> L33
        r110.f523661h = r100;     // Catch: Throwable -> L33
        if (r102 > 0) goto L24;
        monitor-exit(r110);     // Catch: Throwable -> L33
        return;
    L24:
        if (r101 >= 500) goto L28;
        j.a("DoraTransferRateTrackerImpl", "skip maxRate update for short window: sessionId=" + r110.f523654a + ", elapsedMs=" + r101 + ", bytesInWindow=" + r102);     // Catch: Throwable -> L33
        monitor-exit(r110);     // Catch: Throwable -> L33
        return;
    L28:
        double r103 = (r102 / 1024.0d) / (r101 / 1000.0d);     // Catch: Throwable -> L33
        if (r103 <= r110.f523662i) goto L31;
        r110.f523662i = r103;     // Catch: Throwable -> L33
    L31:
        monitor-exit(r110);     // Catch: Throwable -> L33
        return;
    L16:
        if (r101 >= 500) goto L19;
        monitor-exit(r110);     // Catch: Throwable -> L33
    }

    public final void d(String r100, int r101) {
        if (r101 <= 0) goto L23;
        if (r100 == null) goto L25;
        b r102 = this.f523650b.get(r100);
        if (r102 == null) goto L20;
        monitor-enter(r102);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (r102.f523663j == false) goto L14;
        j.a("DoraTransferRateTrackerImpl", "updateBytes ignored: session is closing, id=" + r100 + ", bytes=" + r101);     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L14:
        long r103 = r101;
        r102.f523659f.addAndGet(r103);     // Catch: Throwable -> L17
        r102.f523660g.addAndGet(r103);     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L20:
        j.f("DoraTransferRateTrackerImpl", "updateBytes: session not found for id=".concat(r100));
        return;
    L25:
        return;
    }

    public final void b(String r110, ok4.a r111, final f r112) {
        if (r110 != null) goto L5;
        j.f("DoraTransferRateTrackerImpl", "endSession: sessionId is null");
        return;
    L5:
        final b r100 = this.f523650b.remove(r110);
        if (r100 == null) goto L25;
        ok4.a r113 = r100.f523656c;
        if (r113 == null) goto L10;
        String r114 = r113.f523639a;
    L11:
        if (r114 == null) goto L13;
        this.f523651c.remove(r114, r100.f523654a);
    L13:
        final long r101 = SystemClock.elapsedRealtime() - r100.f523658e;
        monitor-enter(r100);
        r100.f523663j = true;     // Catch: Throwable -> L22
        ScheduledFuture<?> r102 = r100.f523664k;     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        r102.cancel(false);     // Catch: Throwable -> L22
    L19:
        a(r100, true);     // Catch: Throwable -> L22
        final long r103 = r100.f523660g.get();     // Catch: Throwable -> L22
        final double r104 = r100.f523662i;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        j.a("DoraTransferRateTrackerImpl", "endSession: sessionId=" + r100.f523654a + ", businessType=" + r114 + ", result=" + r112 + ", duration=" + r101 + "ms, totalBytes=" + r103 + ", maxRate=" + r104 + "KB/s");
        this.f523652d.execute(new c(this, r100, r101, r103, r104, r112));
        return;
    L22:
        th = move-exception;
        throw th;
    L10:
        r114 = null;
        goto L11
    L25:
        if (r111 == null) goto L27;
        this.f523651c.remove(r111.f523639a, r110);
    L27:
        j.f("DoraTransferRateTrackerImpl", "endSession: session not found for id=".concat(r110));
    }

    public final String c(DoraDeviceLinkType r210, ok4.a r211, DoraTransferDirection r212) {
        String r110 = r211.f523639a;
        monitor-enter(this);
        if (r110 != null) goto L22;
    L13:
        String r100 = UUID.randomUUID().toString();     // Catch: Throwable -> L19
        final b r111 = new b(r100, r210, r211, r212, SystemClock.elapsedRealtime());     // Catch: Throwable -> L19
        r111.f523664k = this.f523652d.scheduleAtFixedRate(new d(this, r111), 1, 1, TimeUnit.SECONDS);     // Catch: Throwable -> L19
        this.f523650b.put(r100, r111);     // Catch: Throwable -> L19
        if (r110 == null) goto L16;
        this.f523651c.put(r110, r100);     // Catch: Throwable -> L19
    L16:
        j.a("DoraTransferRateTrackerImpl", "startSession: sessionId=" + r100 + ", linkType=" + r210 + ", businessType=" + r110 + ", direction=" + r212);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r100;
    L22:
        String r101 = this.f523651c.get(r110);     // Catch: Throwable -> L19
        if (r101 == null) goto L13;
        if (this.f523650b.get(r101) == null) goto L12;
        j.a("DoraTransferRateTrackerImpl", "startSession ignored: active session exists for businessType=" + r110 + ", sessionId=" + r101);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r101;
    L12:
        this.f523651c.remove(r110, r101);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
