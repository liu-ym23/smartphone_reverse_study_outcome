package ly3;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends b {
    public a() {
    }

    @Override // ly3.b
    public final Animator a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{0.75f, 1.0f});
        r4.setDuration(150);
        return r4;
    }
}
