package jx5;

import androidx.camera.video.AudioStats;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f500867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f500868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<ConnectionQuality> f500869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicReference<ConnectionQuality> f500870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<InterfaceC6493b> f500871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f500872f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f500873a = null;

        static {
            f500873a = new b();
        }
    }

    /* JADX INFO: renamed from: jx5.b$b, reason: collision with other inner class name */
    public interface InterfaceC6493b {
        void onBandwidthStateChange(ConnectionQuality r100);
    }

    public final synchronized ConnectionQuality b() {
        monitor-enter(this);
        c r100 = this.f500867a;     // Catch: Throwable -> L28
        if (r100 != null) goto L31;
        ConnectionQuality r101 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r101;
    L31:
        double r102 = r100.f500875b;     // Catch: Throwable -> L20
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        ConnectionQuality r103 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L20
    L23:
        monitor-exit(this);
        return r103;
    L12:
        if (r102 >= 28.0d) goto L15;
        r103 = ConnectionQuality.POOR;     // Catch: Throwable -> L20
        goto L23
    L15:
        if (r102 >= 112.0d) goto L18;
        r103 = ConnectionQuality.MODERATE;     // Catch: Throwable -> L20
        goto L23
    L18:
        if (r102 >= 560.0d) goto L22;
        r103 = ConnectionQuality.GOOD;     // Catch: Throwable -> L20
        goto L23
    L22:
        r103 = ConnectionQuality.EXCELLENT;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        return ConnectionQuality.UNKNOWN;
    L28:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f500867a = new c();
        this.f500868b = false;
        this.f500869c = new AtomicReference(ConnectionQuality.UNKNOWN);
        this.f500871e = new ArrayList();
    }

    public final synchronized void a(long r100, long r110) {
        monitor-enter(this);
        double r101 = ((r100 * 1.0d) / r110) * 8.0d;
        if (r110 != 0) goto L7;
    L62:
        monitor-exit(this);
        return;
    L7:
        if (r101 < 3.0d) goto L62;
        if (Logger.debug() == false) goto L12;
        Logger.d("ConnectionClassManager", "bytes = " + r100 + " timeInMs = " + r110 + " bandwidth = " + r101);     // Catch: Throwable -> L64
    L12:
        this.f500867a.a(r101);     // Catch: Throwable -> L64
        if (this.f500868b == false) goto L58;
        this.f500872f++;     // Catch: Throwable -> L64
        int r111 = 0;
        if (b() == this.f500870d.get()) goto L18;
        this.f500868b = false;     // Catch: Throwable -> L64
        this.f500872f = 1;     // Catch: Throwable -> L64
    L18:
        if (this.f500872f >= 5.0d) goto L20;
    L55:
        monitor-exit(this);
        return;
    L20:
        if (this.f500867a != null) goto L68;
    L46:
        boolean r102 = false;
    L47:
        if (r102 == false) goto L55;
        this.f500868b = false;     // Catch: Throwable -> L64
        this.f500872f = 1;     // Catch: Throwable -> L64
        this.f500869c.set(this.f500870d.get());     // Catch: Throwable -> L64
        int r103 = this.f500871e.size();     // Catch: Throwable -> L53
    L50:
        if (r111 >= r103) goto L55;
        ((InterfaceC6493b) ListProtector.get(this.f500871e, r111)).onBandwidthStateChange(this.f500869c.get());     // Catch: Throwable -> L53
        r111 = r111 + 1;
        goto L50
    L53:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        goto L55
    L68:
        ConnectionQuality r104 = this.f500869c.get();     // Catch: Throwable -> L44
        double r105 = 28.0d;
        if (ConnectionQuality.POOR != r104) goto L25;
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L35:
        double r107 = this.f500867a.f500875b;     // Catch: Throwable -> L44
        goto L60
    L37:
        if (r107 <= r105) goto L42;
        if (r107 <= (r105 * 1.25d)) goto L46;
    L43:
        r102 = true;
        goto L47
    L42:
        if (r107 >= (r106 * 0.8d)) goto L46;
    L25:
        r106 = 112.0d;
        if (ConnectionQuality.MODERATE == r104) goto L34;
        r105 = 560.0d;
        if (ConnectionQuality.GOOD == r104) goto L35;
        if (ConnectionQuality.EXCELLENT != r104) goto L43;
        r106 = 3.4028234663852886E38d;
    L34:
        double r108 = r105;
        r105 = r106;
        r106 = r108;
    L44:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        goto L46
    L58:
        if (this.f500869c.get() == b()) goto L60;
        this.f500868b = true;     // Catch: Throwable -> L64
        this.f500870d = new AtomicReference(b());     // Catch: Throwable -> L64
    L60:
        monitor-exit(this);
    }
}
