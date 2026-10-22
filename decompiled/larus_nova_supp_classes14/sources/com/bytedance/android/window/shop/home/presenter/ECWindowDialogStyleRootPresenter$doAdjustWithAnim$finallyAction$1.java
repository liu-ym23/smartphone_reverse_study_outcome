package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 implements Runnable {
    public final /* synthetic */ ECWindowDialogStyleRootPresenter a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ View c;
    public final /* synthetic */ CoordinatorLayout.Behavior d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ AppBarLayout g;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.presenter.ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 a;
        public final /* synthetic */ Runnable b;

        public AnonymousClass1(ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.c.getHeight() != this.a.a.K()) goto L24;
            this.b.run();
            CoordinatorLayout.Behavior r10 = this.a.d;
            if ((r10 instanceof WindowControllableAppBarSnapBehavior) == true) goto L7;
            CoordinatorLayout.Behavior r11 = null;
        L8:
            final WindowControllableAppBarSnapBehavior r12 = (WindowControllableAppBarSnapBehavior) r11;
            if (r12 != null) goto L11;
        L22:
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r13 = this.a;
            r13.a.p = false;
            r13.c.removeOnLayoutChangeListener(this);
            this.a.a.w().b(2131370858).f().g = true;
            return;
        L11:
            if ((r10 instanceof ECWindowOverScrollExpandBehavior) == true) goto L13;
            r10 = null;
        L13:
            ECWindowOverScrollExpandBehavior r14 = (ECWindowOverScrollExpandBehavior) r10;
            if (r14 == null) goto L16;
            r14.setExpandEnable(true);
        L16:
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r15 = this.a;
            if (r15.a.p == true) goto L19;
        L21:
            r12.setOffsetDownEnable(true, Integer.valueOf(this.a.f));
            ECWindowDialogStyleRootPresenter r16 = this.a.a;
            Function0<Unit> r17 = new ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1$1$onLayoutChange$$inlined$let$lambda$1(r12, this);
            r16.getClass();
            Choreographer.getInstance().postFrameCallback(new j0(r17));
            goto L22
        L19:
            if (r15.e == true) goto L21;
            r12.snapTo(r15.f, r15.b, r15.g);
            goto L21
        L7:
            r11 = r10;
            goto L8
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 a;

        public a(ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r0 = this.a;     // Catch: Throwable -> L4
            ECWindowDialogStyleRootPresenter r1 = r0.a;     // Catch: Throwable -> L4
            ECWindowDialogStyleRootPresenter.Z(r1, r0.b, r1.N());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1(ECWindowDialogStyleRootPresenter r1, CoordinatorLayout r2, View r3, CoordinatorLayout.Behavior r4, boolean r5, int r6, AppBarLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void a() {
        a r0 = new a(this);
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if (r1 == null) goto L5;
        r1.height = this.a.K();
    L5:
        CoordinatorLayout.Behavior r2 = this.d;
        if ((r2 instanceof ECWindowOverScrollExpandBehavior) == true) goto L8;
        r2 = null;
    L8:
        ECWindowOverScrollExpandBehavior r3 = (ECWindowOverScrollExpandBehavior) r2;
        if (r3 == null) goto L11;
        r3.refreshTargetOriginHeight(Integer.valueOf(this.a.K()));
    L11:
        this.c.addOnLayoutChangeListener(new AnonymousClass1(this, r0));
        this.c.requestLayout();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
