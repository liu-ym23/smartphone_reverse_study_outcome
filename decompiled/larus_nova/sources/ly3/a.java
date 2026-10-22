package ly3;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a extends b {
    public a() {
    }

    @Override // ly3.b
    public final Animator a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.75f, 1.0f});
        r101.setDuration(150);
        return r101;
    }
}
