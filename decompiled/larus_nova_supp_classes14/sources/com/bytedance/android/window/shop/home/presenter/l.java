package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Runnable {
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowCroppedStyleAnimationPresenter r0 = this.a.a;     // Catch: Throwable -> L8
            int r1 = ECWindowCroppedStyleAnimationPresenter.B;     // Catch: Throwable -> L8
            int[] r2 = new int[2];     // Catch: Throwable -> L8
            r0.b0().getLocationInWindow(r2);     // Catch: Throwable -> L8
            Integer r3 = ArraysKt.getOrNull(r2, 0);     // Catch: Throwable -> L8
            if (r3 == null) goto L5;
            float r4 = r3.intValue();     // Catch: Throwable -> L8
        L6:
            r0.O().getPullOffset().observe(r0.U(), new k(r0, r4));     // Catch: Throwable -> L8
            return;
        L5:
            r4 = 0.0f;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ECWindowCroppedStyleAnimationPresenter r10 = this.a.a;
            if (r10.u != null) goto L5;
            return;
        L5:
            int r11 = r5 - r3;
            if (r11 > 0) goto L9;
            return;
        L9:
            if (r11 == r10.w) goto L12;
            r10.w = r11;
            ECWindowCroppedStyleAnimationPresenter.Z(r10);
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ECWindowCroppedStyleAnimationPresenter r10 = this.a.a;
            if (r10.u != null) goto L5;
            return;
        L5:
            int r11 = r5 - r3;
            if (r11 > 0) goto L8;
            return;
        L8:
            int r12 = r10.v;
            if ((r11 + r12) == r10.x) goto L12;
            r10.x = r11 + r12;
            ECWindowCroppedStyleAnimationPresenter.Z(r10);
            return;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ l a;

        public d(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r5 - r3;
            if (r10 > 0) goto L5;
            return;
        L5:
            ECWindowCroppedStyleAnimationPresenter r11 = this.a.a;
            int r12 = ECWindowCroppedStyleAnimationPresenter.B;
            int r13 = r11.d0().getHeight() + r10;
            ECWindowCroppedStyleAnimationPresenter r14 = this.a.a;
            if (r13 == r14.x) goto L9;
            r14.x = r14.d0().getHeight() + r10;
            ECWindowCroppedStyleAnimationPresenter r15 = this.a.a;
            r15.v = r10;
            ECWindowCroppedStyleAnimationPresenter.Z(r15);
            return;
        }
    }

    public l(ECWindowCroppedStyleAnimationPresenter r1) {
        this.a = r1;
    }

    public final void a() {
        ECWindowCroppedStyleAnimationPresenter r0 = this.a;
        View r1 = r0.u;
        if (r1 == null) goto L18;
        r0.v = r1.getHeight();
        this.a.b0().findViewById(2131371259).post(new a(this));
        this.a.b0().setVisibility(0);
        this.a.c0().setY(this.a.e0().getHeight());
        this.a.c0().setVisibility(4);
        this.a.c0().setAlpha(0.0f);
        ECWindowCroppedStyleAnimationPresenter r2 = this.a;
        r2.w = r2.c0().getHeight();
        ECWindowCroppedStyleAnimationPresenter r3 = this.a;
        r3.x = r3.v + r3.d0().getHeight();
        ExtensionsKt.gone(this.a.e0());
        this.a.e0().setAlpha(0.0f);
        ECWindowCroppedStyleAnimationPresenter r4 = this.a;
        View r5 = r4.u;
        if (r5 == null) goto L18;
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L10;
        r6 = null;
    L10:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L13;
        r7.removeView(r5);
    L13:
        r4.b0().addView(r5, new ViewGroup.LayoutParams(-1, -2));
        if ((r4.c0().getHeight() - r5.getHeight()) < 0) goto L16;
        int r8 = r4.v;
    L17:
        View r9 = new View(r4.u().c());
        r9.setClickable(false);
        r9.setVisibility(4);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, r8));
        Unit r10 = Unit.INSTANCE;
        r4.z = r9;
        ((ViewGroup) r4.o.getValue()).addView(r4.z);
        r4.w().b(2131370890).f().setClickable(false);
        r4.y = r4.c0().getHeight() - r5.getHeight();
        wg.a.d((View) r4.s.getValue(), r4.y);
        ((View) r4.t.getValue()).setTranslationY(-r4.y);
        r4.d0().setTranslationY(-r4.y);
        goto L18
    L16:
        r8 = r4.c0().getHeight();
    L18:
        this.a.c0().addOnLayoutChangeListener(new b(this));
        this.a.d0().addOnLayoutChangeListener(new c(this));
        View r11 = this.a.u;
        if (r11 == null) goto L22;
        r11.addOnLayoutChangeListener(new d(this));
        return;
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
