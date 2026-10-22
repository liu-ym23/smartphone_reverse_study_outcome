package z06;

import android.view.ViewTreeObserver;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Function<Unit, Unit>> f569635a;

    public d() {
        this(null);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WeakReference<Function<Unit, Unit>> r100 = this.f569635a;
        if (r100 == null) goto L5;
        Function<Unit, Unit> r101 = r100.get();
    L6:
        if (r101 == null) goto L10;
        Unit r102 = r101.apply(Unit.INSTANCE);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public d(Object r100) {
        this.f569635a = null;
    }
}
