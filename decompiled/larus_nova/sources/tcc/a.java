package tcc;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.span.d0;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieComposition f545493b;

    public a(b r100, LottieComposition r101) {
        this.f545492a = r100;
        this.f545493b = r101;
    }

    public final void a() {
        b r100 = this.f545492a;
        LottieDrawable r101 = r100.f545498e;
        if (r101.f24725b != null) goto L12;
        LottieComposition r102 = this.f545493b;
        r101.setCallback(r100);
        r101.m(r102);
        IntRange r103 = r100.f545496c;
        if (r103 == null) goto L7;
        r100.f545498e.r(r103.getFirst(), r103.getLast());
    L7:
        d0.a r104 = r100.f545497d;
        if (r104 == null) goto L10;
        r104.a();
    L10:
        r100.f545498e.k();
        return;
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
}
