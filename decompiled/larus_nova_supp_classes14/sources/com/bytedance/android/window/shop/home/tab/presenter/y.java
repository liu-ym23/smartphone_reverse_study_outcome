package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.widget.SortBarView;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements Runnable {
    public final /* synthetic */ ECWindowTabPresenterDeprecated a;

    public y(ECWindowTabPresenterDeprecated r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup, com.bytedance.android.window.shop.widget.ToolBarView] */
    public final void a() {
        Object r0 = com.bytedance.android.window.shop.widget.c.a(ECWindowTabPresenterDeprecated.d0(this.a), ToolBarView.class);
        if ((r0 instanceof ToolBarView) == true) goto L5;
        r0 = null;
    L5:
        ?? r1 = (ToolBarView) r0;
        if (r1 == 0) goto L25;
        ECWindowTabPresenterDeprecated r2 = this.a;
        r2.getClass();
        SortBarView r3 = r1.getSortBarView();
        if (r3 == null) goto L11;
        r3.a("resort", new ECWindowTabPresenterDeprecated$onSortBarInitialized$1(r2));
    L11:
        ECWindowTabPresenterDeprecated r4 = this.a;
        r4.getClass();
        r1.setDoEventAction(new ECWindowTabPresenterDeprecated$onLayoutControlInitialized$1(r4));
        r1.setLayoutChangeCallback(new ECWindowTabPresenterDeprecated$onLayoutControlInitialized$2(r4));
        WindowLazyStatusView r5 = this.a.j;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L14:
        WindowLazyStatusView r6 = this.a.j;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L17:
        int r7 = r6.getPaddingLeft();
        int r8 = r1.getBottom();
        WindowLazyStatusView r9 = this.a.j;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L20:
        int r10 = r9.getPaddingRight();
        WindowLazyStatusView r11 = this.a.j;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L23:
        r5.setPadding(r7, r8, r10, r11.getPaddingBottom());
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
