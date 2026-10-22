package uo5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ FloatViewContainer a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        d.a(this.a, this.b);
        this.a.setTranslationX(this.c);
    }

    public b(FloatViewContainer r1, int r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
