package com.bytedance.ee.bear.bitable.itemview.util;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f214293a;

    public static final class a extends com.bytedance.ee.bear.bitable.common.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f214294a;

        public a(j r100) {
            this.f214294a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            j r101 = this.f214294a;
            WeakReference<View> r102 = r101.f214290b;
            boolean r103 = false;
            if (r102 == null) goto L9;
            View r104 = r102.get();
            if (r104 == null) goto L9;
            if (r104.isActivated() != true) goto L9;
            r103 = true;
        L9:
            r101.a(r103);
        }
    }

    public k(j r100) {
        this.f214293a = r100;
    }

    public final void a() {
        WeakReference<View> r100 = this.f214293a.f214289a;
        if (r100 == null) goto L9;
        View r101 = r100.get();
        if (r101 == null) goto L9;
        Drawable r102 = r101.getBackground();
        if (r102 == null) goto L9;
        j r103 = this.f214293a;
        ObjectAnimator r104 = ObjectAnimator.ofInt(r102, "alpha", new int[]{255, 0}).setDuration(1000);
        r104.addListener(new a(r103));
        r104.start();
        return;
    L9:
        this.f214293a.a(false);
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
