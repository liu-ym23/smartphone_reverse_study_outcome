package an5;

import android.animation.Animator;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements Animator.AnimatorListener {
    public final /* synthetic */ SheetEditorLayout a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public b0(SheetEditorLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        tt5.a.b("SheetEditorLayout", "startHideFullScreenAnim.onAnimationCancel()...");
        this.a.i.setVisibility(8);
        this.a.t();
        SheetEditorLayout r4 = this.a;
        r4.I = false;
        Runnable r0 = r4.J;
        r4.J = null;
        if (r0 == null) goto L7;
        r4.addOnLayoutChangeListener(new c0(r4, r0));
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        tt5.a.b("SheetEditorLayout", "startHideFullScreenAnim.onAnimationEnd()...");
        this.a.i.setVisibility(8);
        this.a.t();
        SheetEditorLayout r4 = this.a;
        r4.I = false;
        Runnable r0 = r4.J;
        r4.J = null;
        if (r0 == null) goto L7;
        r4.addOnLayoutChangeListener(new c0(r4, r0));
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        SheetEditorLayout r4 = this.a;
        r4.I = true;
        r4.E = false;
        r4.f();
        this.a.k.setVisibility(0);
        this.a.j.getSegments().subscribe(new z(this), new a0());
        wm5.b r5 = this.a.x;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }
}
