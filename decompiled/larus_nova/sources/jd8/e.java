package jd8;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f498667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener f498668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f498669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f498670d;

    public /* synthetic */ e(g r100, ViewTreeObserver.OnPreDrawListener r101, int r102, View r103) {
        this.f498667a = r100;
        this.f498668b = r101;
        this.f498669c = r102;
        this.f498670d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f498667a;
        ViewTreeObserver.OnPreDrawListener r101 = this.f498668b;
        int r102 = this.f498669c;
        View r103 = this.f498670d;
        if (r100.f498697y == r101) goto L5;
        return;
    L5:
        if (r100.E != r102) goto L9;
        r100.A = true;
        r100.D = SystemClock.uptimeMillis();
        r100.F = -1;
        r103.requestLayout();
        return;
    }
}
