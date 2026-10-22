package y15;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.document.menu.OfficeTitleMenuPlugin;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f565649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f565650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f565651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f565652d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        h r101 = this.f565652d;
        View r102 = this.f565649a;
        e r103 = this.f565650b;
        r101.getClass();
        if ((r102 instanceof ImageView) == false) goto L6;
        r101.a((ImageView) r102, r103);
    L13:
        this.f565651c.start();
        return;
    L6:
        if ((r102 instanceof ViewGroup) == false) goto L13;
        ViewGroup r104 = (ViewGroup) r102;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        View r107 = r104.getChildAt(r106);
        if ((r107 instanceof ImageView) == true) goto L11;
        r106 = r106 + 1;
        goto L8
    L11:
        r101.a((ImageView) r107, r103);
        goto L13
    }

    public g(OfficeTitleMenuPlugin.a r100, View r101, e r102, ObjectAnimator r103) {
        this.f565652d = r100;
        this.f565649a = r101;
        this.f565650b = r102;
        this.f565651c = r103;
    }
}
