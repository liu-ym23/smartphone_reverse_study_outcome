package ly3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.jvm.internal.Intrinsics;
import sy3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b implements View.OnTouchListener {

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ b b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            super.onAnimationEnd(r1);
            this.b.getClass();
        }

        public a(b r1, View r2, MotionEvent r3) {
            this.b = r1;
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: ly3.b$b, reason: collision with other inner class name */
    public class C0144b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ MotionEvent b;
        public final /* synthetic */ b c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            super.onAnimationEnd(r5);
            b r6 = this.c;
            View r0 = this.a;
            MotionEvent r1 = this.b;
            ly3.a r7 = (ly3.a) r6;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r0, "view");
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r0, "view");
            BaseCommentViewHolder r8 = ((g) r7).a;
            o14.a r2 = r8.m;
            if (r2 == null) goto L7;
            User r3 = r2.o();
            if (r3 == null) goto L7;
            String r4 = r3.u();
        L8:
            r8.V3(r4);
            return;
        L7:
            r4 = null;
            goto L8
        }

        public C0144b(b r1, View r2, MotionEvent r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }

    public abstract Animator a(View r1);

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        if (r6.getAction() != 0) goto L7;
        Intrinsics.checkNotNullParameter(r5, "view");
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.75f});
        r0.setDuration(150);
        r0.addListener(new a(this, r5, r6));
        r0.start();
        return true;
    L7:
        if (r6.getAction() != 1) goto L11;
        Animator r1 = a(r5);
        r1.addListener(new C0144b(this, r5, r6));
        r1.start();
        return true;
    L11:
        if (r6.getAction() != 3) goto L13;
        a(r5).start();
    L13:
        return false;
    }
}
