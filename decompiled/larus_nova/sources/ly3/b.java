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

/* JADX INFO: loaded from: classes14.dex */
public abstract class b implements View.OnTouchListener {

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f511298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f511299b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            this.f511299b.getClass();
        }

        public a(b r100, View r101, MotionEvent r102) {
            this.f511299b = r100;
            this.f511298a = r101;
        }
    }

    /* JADX INFO: renamed from: ly3.b$b, reason: collision with other inner class name */
    public class C6751b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f511300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f511301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f511302c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            b r101 = this.f511302c;
            View r102 = this.f511300a;
            MotionEvent r103 = this.f511301b;
            ly3.a r104 = (ly3.a) r101;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r102, "view");
            Intrinsics.checkNotNullParameter(r103, "event");
            Intrinsics.checkNotNullParameter(r102, "view");
            BaseCommentViewHolder r105 = ((g) r104).f543874a;
            o14.a r106 = r105.f194283m;
            if (r106 == null) goto L7;
            User r107 = r106.o();
            if (r107 == null) goto L7;
            String r108 = r107.u();
        L8:
            r105.V3(r108);
            return;
        L7:
            r108 = null;
            goto L8
        }

        public C6751b(b r100, View r101, MotionEvent r102) {
            this.f511302c = r100;
            this.f511300a = r101;
            this.f511301b = r102;
        }
    }

    public b() {
    }

    public abstract Animator a(View r100);

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L7;
        Intrinsics.checkNotNullParameter(r100, "view");
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.75f});
        r102.setDuration(150);
        r102.addListener(new a(this, r100, r101));
        r102.start();
        return true;
    L7:
        if (r101.getAction() != 1) goto L11;
        Animator r103 = a(r100);
        r103.addListener(new C6751b(this, r100, r101));
        r103.start();
        return true;
    L11:
        if (r101.getAction() != 3) goto L13;
        a(r100).start();
    L13:
        return false;
    }
}
