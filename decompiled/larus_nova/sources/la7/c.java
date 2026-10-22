package la7;

import android.animation.Animator;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator f508209a;

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        this.f508209a.cancel();
    }

    public c(Animator r100) {
        this.f508209a = r100;
    }
}
