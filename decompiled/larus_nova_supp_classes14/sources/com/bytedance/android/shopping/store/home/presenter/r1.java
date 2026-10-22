package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.widget.HorizontalScrollView;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ uj3.j b;
    public final /* synthetic */ ECShopRootPresenterV2 c;
    public final /* synthetic */ HorizontalScrollView d;

    public r1(int r1, uj3.j r2, ECShopRootPresenterV2 r3, HorizontalScrollView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        boolean r1 = true;
        ECTabLayout r3 = null;
        if ((this.c.h instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L21;
        HorizontalScrollView r0 = this.d;
        if ((r0 instanceof ECTabLayout) == true) goto L7;
        r0 = null;
    L7:
        ECTabLayout r2 = (ECTabLayout) r0;
        if (r2 != null) goto L10;
        return;
    L10:
        if (this.a < r2.getTabCount()) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        r3 = r2;
    L15:
        if (r3 == null) goto L40;
        ECTabLayout.Tab r4 = r3.getTabAt(this.a);
        if (r4 == null) goto L41;
        View r5 = r4.getCustomView();
        if (r5 == null) goto L42;
        ECShopRootPresenterV2.r0(this.c, r5, this.b);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L21:
        HorizontalScrollView r6 = this.d;
        if ((r6 instanceof TabLayout) == true) goto L24;
        r6 = null;
    L24:
        ECTabLayout r7 = (TabLayout) r6;
        if (r7 != null) goto L27;
        return;
    L27:
        if (this.a < r7.getTabCount()) goto L30;
        r1 = false;
    L30:
        if (r1 == false) goto L32;
        r3 = r7;
    L32:
        if (r3 == null) goto L45;
        TabLayout.Tab r8 = r3.getTabAt(this.a);
        if (r8 == null) goto L46;
        View r9 = r8.getCustomView();
        if (r9 == null) goto L47;
        ECShopRootPresenterV2.r0(this.c, r9, this.b);
        return;
    L47:
        return;
    L46:
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
