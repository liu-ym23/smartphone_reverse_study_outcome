package com.bytedance.ies.ugc.aweme.fmp.core;

import android.os.SystemClock;
import android.view.ViewTreeObserver;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function10;

/* JADX INFO: loaded from: classes19.dex */
public final class FmpCalculator$onLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FmpCalculator f248884a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver r100 = this.f248884a.f248849a.getViewTreeObserver();
        if (r100 == null) goto L16;
        FmpCalculator r101 = this.f248884a;
        if (r100.isAlive() == false) goto L16;
        monitor-enter(this);
        r100.removeOnGlobalLayoutListener(this);     // Catch: Throwable -> L13
        if (r101.Q.size() <= 0) goto L10;
        r100.addOnGlobalLayoutListener(this);     // Catch: Throwable -> L13
    L10:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    L13:
        th = move-exception;
        throw th;
    L16:
        FmpCallback r103 = this.f248884a.f248868t;
        boolean r104 = false;
        if (r103 != null) goto L19;
    L21:
        if (r104 == false) goto L30;
        Iterator<T> r105 = this.f248884a.Q.iterator();
    L24:
        if (r105.hasNext() == false) goto L26;
        ((FmpCalculator.d) r105.next()).b();
        goto L24
    L26:
        final long r106 = SystemClock.elapsedRealtime();
        final FmpCalculator r107 = this.f248884a;
        Function10<Long, Long, Integer, Integer, Integer, Integer, Float, Float, FmpCalculator.a, y46.b, Unit> r108 = new FmpCalculator$onLayoutListener$1$onGlobalLayout$3(r107, r106);
        final FmpCalculator r109 = this.f248884a;
        FmpCalculator.b(r107, r106, r108, new FmpCalculator$onLayoutListener$1$onGlobalLayout$4(r109, r106));
        Iterator<T> r110 = this.f248884a.Q.iterator();
    L28:
        if (r110.hasNext() == false) goto L35;
        ((FmpCalculator.d) r110.next()).c();
        goto L28
    L35:
        return;
    L30:
        return;
    L19:
        if (r103.g() != true) goto L21;
        r104 = true;
        goto L21
    }

    public FmpCalculator$onLayoutListener$1(FmpCalculator r100) {
        this.f248884a = r100;
    }
}
