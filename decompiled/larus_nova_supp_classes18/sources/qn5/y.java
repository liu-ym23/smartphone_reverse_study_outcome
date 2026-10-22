package qn5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y extends AnimatorListenerAdapter {
    public final /* synthetic */ SheetEditorLayout a;

    public y(SheetEditorLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        SheetEditorLayout r3 = this.a;
        if (r3.J == false) goto L6;
        rcb.c.h(r3.j, null);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        SheetEditorLayout r4 = this.a;
        r4.a.getLayoutParams().height = -1;
        r4.a.requestLayout();
        this.a.i.setVisibility(0);
        this.a.k.setVisibility(8);
        SheetEditorLayout r5 = this.a;
        r5.B = true;
        r5.f();
        this.a.j.getPresenter().d().c();
        this.a.m.getSegments().subscribe(new w(this), new x());
        wm5.b r6 = this.a.u;
        if (r6 == null) goto L6;
        r6.b();
        return;
    }
}
