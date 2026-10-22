package oi3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends SlcRoundFrameLayout {
    public boolean c;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            c r4 = this.a;
            r4.c = false;
            r4.b(this.b + 1, this.c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            this.a.c = true;
        }

        public a(c r1, int r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int r5, List<oi3.a> r6) {
        oi3.a r0 = (oi3.a) CollectionsKt.getOrNull(r6, r5);
        if (r0 == null) goto L6;
        ViewPropertyAnimator r1 = animate().setDuration((long) (r0.c * 1000)).scaleX(r0.a).scaleY(r0.b);
        r1.setListener(new a(this, r5, r6));
        r1.start();
        return;
    }
}
