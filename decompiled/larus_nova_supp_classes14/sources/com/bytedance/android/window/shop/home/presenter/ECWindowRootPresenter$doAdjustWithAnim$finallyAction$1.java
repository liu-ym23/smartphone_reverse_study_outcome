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
public final class ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 implements Runnable {
    public final /* synthetic */ ECWindowRootPresenter a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ CoordinatorLayout.Behavior e;
    public final /* synthetic */ AppBarLayout f;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.presenter.ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 a;
        public final /* synthetic */ Runnable b;

        public AnonymousClass1(ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.c.getHeight() != this.a.d) goto L19;
            this.b.run();
            CoordinatorLayout.Behavior r10 = this.a.e;
            if ((r10 instanceof WindowControllableAppBarSnapBehavior) == true) goto L7;
            CoordinatorLayout.Behavior r11 = null;
        L8:
            final WindowControllableAppBarSnapBehavior r12 = (WindowControllableAppBarSnapBehavior) r11;
            if (r12 != null) goto L11;
        L17:
            ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r13 = this.a;
            r13.a.o = false;
            r13.c.removeOnLayoutChangeListener(this);
            return;
        L11:
            if ((r10 instanceof ECWindowOverScrollExpandBehavior) == true) goto L13;
            r10 = null;
        L13:
            ECWindowOverScrollExpandBehavior r14 = (ECWindowOverScrollExpandBehavior) r10;
            if (r14 == null) goto L16;
            r14.setExpandEnable(true);
        L16:
            ECWindowRootPresenter r15 = this.a.a;
            Function0<Unit> r16 = new ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1$1$onLayoutChange$$inlined$let$lambda$1(r12, this);
            int r17 = ECWindowRootPresenter.q;
            r15.getClass();
            Choreographer.getInstance().postFrameCallback(new x1(r16));
            goto L17
        L7:
            r11 = r10;
            goto L8
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 a;

        public a(ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r0 = this.a;     // Catch: Throwable -> L4
            ECWindowRootPresenter r1 = r0.a;     // Catch: Throwable -> L4
            ECWindowRootPresenter.b0(r1, r0.b, r1.N());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1(ECWindowRootPresenter r1, CoordinatorLayout r2, View r3, int r4, CoordinatorLayout.Behavior r5, AppBarLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        a r0 = new a(this);
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if (r1 == null) goto L5;
        r1.height = this.d;
    L5:
        CoordinatorLayout.Behavior r2 = this.e;
        if ((r2 instanceof ECWindowOverScrollExpandBehavior) == true) goto L8;
        r2 = null;
    L8:
        ECWindowOverScrollExpandBehavior r3 = (ECWindowOverScrollExpandBehavior) r2;
        if (r3 == null) goto L11;
        r3.refreshTargetOriginHeight(Integer.valueOf(this.d));
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
