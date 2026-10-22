package okio;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f524030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f524031b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<g0>[] f524032c = null;

    static {
        int r100 = 0;
        f524030a = new g0(new byte[0], 0, 0, false, false);
        int r101 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f524031b = r101;
        AtomicReference<g0>[] r102 = new AtomicReference[r101];
    L3:
        if (r100 >= r101) goto L5;
        r102[r100] = new AtomicReference();
        r100 = r100 + 1;
        goto L3
    L5:
        f524032c = r102;
    }

    @JvmStatic
    public static final g0 b() {
        int r100 = (int) (ThreadMethodProxy.currentThread().getId() & (((long) f524031b) - 1));
        AtomicReference<g0> r101 = f524032c[r100];
        g0 r102 = f524030a;
        g0 r103 = r101.getAndSet(r102);
        if (r103 != r102) goto L7;
        return new g0();
    L7:
        if (r103 != null) goto L10;
        r101.set(null);
        return new g0();
    L10:
        r101.set(r103.f524022f);
        r103.f524022f = null;
        r103.f524019c = 0;
        return r103;
    }

    @JvmStatic
    public static final void a(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, MonitorConstants.SEGMENT);
        if (r100.f524022f == null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L25;
        if (r100.f524020d == false) goto L12;
        return;
    L12:
        int r102 = (int) (ThreadMethodProxy.currentThread().getId() & (((long) f524031b) - 1));
        AtomicReference<g0> r103 = f524032c[r102];
        g0 r104 = f524030a;
        g0 r105 = r103.getAndSet(r104);
        if (r105 != r104) goto L15;
        return;
    L15:
        if (r105 == null) goto L17;
        int r106 = r105.f524019c;
    L19:
        if (r106 < 65536) goto L22;
        r103.set(r105);
        return;
    L22:
        r100.f524022f = r105;
        r100.f524018b = 0;
        r100.f524019c = r106 + 8192;
        r103.set(r100);
        return;
    L17:
        r106 = 0;
        goto L19
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r100.f524023g != null) goto L7;
        r101 = true;
        goto L8
    }
}
