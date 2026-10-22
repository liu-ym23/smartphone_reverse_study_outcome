package v19;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Function0<Unit>> f552600a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Function0<Unit> r100 = this.f552600a.get();
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public p5(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "check");
        this.f552600a = new WeakReference(r100);
    }
}
