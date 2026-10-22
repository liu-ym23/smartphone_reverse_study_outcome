package v19;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.Unit;

/* JADX INFO: loaded from: classes27.dex */
public final class h7 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f552484b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f552483a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        kotlinx.coroutines.i<Unit> r100 = this.f552484b;     // Catch: Exception -> L5
        Result.Companion r101 = Result.Companion;     // Catch: Exception -> L5
        r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere("View.awaitNextLayout: " + e.getMessage());
    }

    public h7(View r100, kotlinx.coroutines.j r101) {
        this.f552483a = r100;
        this.f552484b = r101;
    }
}
