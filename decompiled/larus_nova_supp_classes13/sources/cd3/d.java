package cd3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ SlcScrollingView a;

    public d(SlcScrollingView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        SlcScrollingView r3 = this.a;
        r3.a = false;
        r3.b(0.0f);
        SlcScrollingView.b r4 = this.a.c;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }
}
