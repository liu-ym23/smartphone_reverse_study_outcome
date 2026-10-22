package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import eka.b;
import eka.c;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class FPSMonitorOnScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<b> f396954f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f396955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f396956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f396957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f396958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f396959e;

    public static final class a {
    }

    static {
        f396954f = new ConcurrentLinkedQueue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r110);
        if (r110 != 0) goto L5;
        b r111 = this.f396959e;
        if (r111 != null) goto L40;
    L43:
        this.f396957c = 0;
        this.f396958d = 0;
        this.f396956b = -1;
        b r101 = this.f396959e;
        if (r101 == null) goto L52;
        f396954f.add(r101);
        this.f396959e = null;
        throw null;
    L52:
        throw null;
    L40:
        if (this.f396956b <= 0) goto L42;
        r111.f472957b = SystemClock.elapsedRealtime() - this.f396956b;
    L42:
        r111.f472962g = this.f396957c;
        r111.f472963h = this.f396958d;
        r111.f472960e = r100.computeHorizontalScrollOffset();
        r111.f472961f = r100.computeVerticalScrollOffset();
        goto L43
    L5:
        if (r110 == 1) goto L8;
        return;
    L8:
        if (this.f396956b >= 0) goto L20;
        if (this.f396959e != null) goto L15;
        b r112 = b.f472955n.acquire();
        if (r112 != null) goto L14;
        r112 = new b(0);
    L14:
        this.f396959e = r112;
    L15:
        b r113 = this.f396959e;
        if (r113 == null) goto L18;
        r113.f472958c = r100.computeHorizontalScrollOffset();
        r113.f472959d = r100.computeVerticalScrollOffset();
    L18:
        this.f396956b = SystemClock.elapsedRealtime();
    L20:
        if (this.f396955a == true) goto L49;
        Field r102 = eka.a.a().getDeclaredField("mLogging");     // Catch: Exception -> L26
        r102.setAccessible(true);     // Catch: Exception -> L26
        Object r103 = r102.get(Looper.getMainLooper());     // Catch: Exception -> L26
        if (r103 == null) goto L25;
        Printer r104 = (Printer) r103;     // Catch: Exception -> L26
    L27:
        if (r104 != null) goto L50;
        gka.b.a("FPSMonitorOnScrollListener", "CurrentPrinter() == null, now reset.");
        Field r105 = c.class.getDeclaredField(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);     // Catch: Exception -> L34
        r105.setAccessible(true);     // Catch: Exception -> L34
        Object r106 = r105.get(null);     // Catch: Exception -> L34
        if (r106 == null) goto L33;
        Looper.getMainLooper().setMessageLogging((Printer) r106);     // Catch: Exception -> L34
        this.f396955a = true;     // Catch: Exception -> L34
        throw null;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        throw null;
    L50:
        throw null;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L26
    L26:
        r104 = null;
        goto L27
    L49:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f396957c += Math.abs(r101);
        this.f396958d += Math.abs(r102);
    }
}
