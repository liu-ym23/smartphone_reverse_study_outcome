package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ Integer c;

    public d(b r1, Integer r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        final b r0 = this.a;
        int r1 = this.b.intValue();
        final int r2 = this.c.intValue();
        float r3 = r0.a(r1);
        float r4 = r0.a(r2);
        r0.e.setTranslationX(r3);
        OrderListTabLayout.a r5 = r0.b.e(r2);
        if (r5 == null) goto L15;
        OrderListTabItemView r6 = r5.b;
        if (r6 == null) goto L15;
        int r7 = r6.getIndicatorBottomOffset();
        ViewGroup.LayoutParams r8 = r0.e.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r8 = null;
    L9:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9 == null) goto L15;
        if (r9.bottomMargin == r7) goto L15;
        r9.bottomMargin = r7;
        r0.e.setLayoutParams(r9);
    L15:
        r0.e.setVisibility(0);
        OrderListTabLayout.a r10 = r0.b.e(r1);
        if (r10 == null) goto L20;
        OrderListTabItemView r11 = r10.b;
        if (r11 == null) goto L20;
        r11.d.setVisibility(4);
    L20:
        ViewPropertyAnimator r12 = r0.e.animate().setDuration(r0.a).translationX(r4);
        com.bytedance.android.ec.core.utils.f.b(r12, new OrderListTabAnimHelper$doAnim$1(r0, r2));
        r12.start();
        OrderListTabLayout.a r13 = r0.b.e(r2);
        if (r13 == null) goto L25;
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r0.d.getScrollX(), (r13.b.getLeft() + (r13.b.getWidth() / 2)) - (r0.d.getWidth() / 2)});
        r14.addUpdateListener(new c(r0));
        r14.setDuration(r0.a).start();
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
