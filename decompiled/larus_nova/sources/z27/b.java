package z27;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import b37.d;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f569790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f569791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SensorManager f569792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f569793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.bytedance.navigation.kmp.listener.b f569794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f569795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f569796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f569797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f569798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f569799j;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f569796g = 50;
    }

    public final void b(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "locationInfo");
        if (this.f569795f == true) goto L5;
        return;
    L5:
        Handler r101 = this.f569791b;
        if (r101 == null) goto L9;
        r101.post(new z27.a(r100, this));
        return;
    }

    public static void a(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        ona.b.c(new ona.a(r101.hashCode(), null));
    }
}
