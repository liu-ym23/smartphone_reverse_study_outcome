package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcr3/b;", "invoke", "()Lcr3/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowHybridSubTabsPresenter$initTab$indicator$1 extends FunctionReferenceImpl implements Function0<cr3.b> {
    public ECWindowHybridSubTabsPresenter$initTab$indicator$1(ECWindowHybridSubTabsPresenter r8) {
        super(0, r8, ECWindowHybridSubTabsPresenter.class, "getScrollPercent", "getScrollPercent()Lcom/bytedance/android/window/shop/widget/effect/TabScrollState;", 0);
    }

    public final cr3.b invoke() {
        ECWindowHybridSubTabsPresenter r0 = (ECWindowHybridSubTabsPresenter) ((CallableReference) this).receiver;
        int r1 = ECWindowHybridSubTabsPresenter.s;
        int r2 = r0.e0().getSelectedTabPosition();
        ECTabLayout.Tab r3 = r0.e0().getTabAt(r2);
        Integer r4 = null;
        if (r3 == null) goto L6;
        ECTabLayout.TabView r5 = r3.view;
        if ((r5 instanceof View) == false) goto L6;
    L7:
        ECTabLayout.Tab r6 = r0.e0().getTabAt(r2 - 1);
        if (r6 == null) goto L11;
        ECTabLayout.TabView r7 = r6.view;
        if ((r7 instanceof View) == false) goto L11;
    L12:
        ECTabLayout.Tab r8 = r0.e0().getTabAt(r2 + 1);
        if (r8 == null) goto L16;
        ECTabLayout.TabView r9 = r8.view;
        if ((r9 instanceof View) == false) goto L16;
    L17:
        cr3.b r10 = r0.r;
        if (r5 == null) goto L20;
        Float r11 = Float.valueOf(r5.getX());
    L21:
        if (r7 == null) goto L23;
        Float r12 = Float.valueOf(r7.getX());
    L24:
        if (r9 == null) goto L26;
        Float r13 = Float.valueOf(r9.getX());
    L27:
        if (r5 == null) goto L29;
        Integer r14 = Integer.valueOf(r5.getWidth());
    L30:
        if (r7 == null) goto L32;
        Integer r15 = Integer.valueOf(r7.getWidth());
    L33:
        if (r9 == null) goto L36;
        r4 = Integer.valueOf(r9.getWidth());
    L36:
        return r10.update(r11, r12, r13, r14, r15, r4);
    L32:
        r15 = null;
        goto L33
    L29:
        r14 = null;
        goto L30
    L26:
        r13 = null;
        goto L27
    L23:
        r12 = null;
        goto L24
    L20:
        r11 = null;
    L16:
        r9 = null;
    L11:
        r7 = null;
    L6:
        r5 = null;
        goto L7
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m680invoke() {
        return invoke();
    }
}
