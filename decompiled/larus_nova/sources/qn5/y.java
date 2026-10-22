package qn5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class y extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetEditorLayout f534074a;

    public y(SheetEditorLayout r100) {
        this.f534074a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        SheetEditorLayout r101 = this.f534074a;
        if (r101.f238467J == false) goto L6;
        rcb.c.h(r101.f238477j, null);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        SheetEditorLayout r101 = this.f534074a;
        r101.f238468a.getLayoutParams().height = -1;
        r101.f238468a.requestLayout();
        this.f534074a.f238476i.setVisibility(0);
        this.f534074a.f238478k.setVisibility(8);
        SheetEditorLayout r102 = this.f534074a;
        r102.B = true;
        r102.f();
        this.f534074a.f238477j.getPresenter().d().c();
        this.f534074a.f238481m.getSegments().subscribe(new w(this), new x());
        wm5.b r103 = this.f534074a.f238490u;
        if (r103 == null) goto L6;
        r103.b();
        return;
    }
}
