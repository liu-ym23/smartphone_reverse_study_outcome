package com.bytedance.android.shopping.orderlist.common.controller;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.BaseLinkedScrollView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonBallLoadingView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonMaskView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonShopSkeletonLoadingView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.ShowBarType;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a {
    public int a;
    public final BaseLinkedScrollView b;
    public final OrderCommonHeadBarView c;
    public final View d;
    public final OrderCommonShopSkeletonLoadingView e;
    public final OrderCommonBallLoadingView f;
    public final OrderCommonMaskView g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.orderlist.common.controller.a$a, reason: collision with other inner class name */
    public static final class C0139a {
    }

    static {
    }

    public void a(SlcRenderContext r1, String r2) {
    }

    public final void e() {
        this.a = 2;
        this.g.setVisibility(8);
        this.f.T5();
        OrderCommonHeadBarView r2 = this.c;
        int r0 = OrderCommonHeadBarView.e;
        r2.R5(false, null, null, false, false, null);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        OrderCommonYataView r1 = this.b.a;
        r1.c = false;
        r1.b.setVisibility(8);
        r1.a.setVisibility(0);
    }

    public ShowBarType b() {
        return ShowBarType.ONLY_BACK;
    }

    public final void c(b r11) {
        Intrinsics.checkNotNullParameter(r11, "config");
        this.a = 1;
        this.g.setVisibility(8);
        this.f.T5();
        this.e.setVisibility(8);
        OrderCommonHeadBarView r3 = this.c;
        boolean r4 = r11.b;
        ShowBarType r5 = b();
        String r6 = r11.c;
        int r1 = OrderCommonHeadBarView.e;
        r3.R5(r4, r5, r6, false, false, null);
        if (r11.b == true) goto L5;
        this.d.setVisibility(8);
    L7:
        if (r11.a == false) goto L9;
        OrderCommonYataView r12 = this.b.a;
        r12.c = true;
        r12.b.setVisibility(0);
        r12.a.setVisibility(8);
        return;
    L9:
        OrderCommonYataView r13 = this.b.a;
        r13.c = false;
        r13.b.setVisibility(8);
        r13.a.setVisibility(0);
        return;
    L5:
        this.d.setVisibility(0);
        goto L7
    }

    public final void d(c r11, SlcRenderContext r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "config");
        this.a = 0;
        if (r11.a == false) goto L5;
        this.g.setVisibility(0);
    L7:
        if (r11.b == false) goto L9;
        this.f.S5();
    L10:
        this.c.R5(r11.c, r11.d, r11.e, r11.g, r11.f, r12);
        if (r11.c == false) goto L13;
    L16:
        this.d.setVisibility(0);
    L18:
        if (r11.h == false) goto L20;
        this.a = 3;
        a(r12, r13);
        this.e.setVisibility(0);
        return;
    L20:
        this.e.setVisibility(8);
        return;
    L13:
        if (r11.g == true) goto L16;
        this.d.setVisibility(8);
        goto L18
    L9:
        this.f.T5();
        goto L10
    L5:
        this.g.setVisibility(8);
        goto L7
    }

    public a(BaseLinkedScrollView r2, OrderCommonHeadBarView r3, View r4, OrderCommonShopSkeletonLoadingView r5, OrderCommonBallLoadingView r6, OrderCommonMaskView r7) {
        Intrinsics.checkNotNullParameter(r2, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r3, "headBarView");
        Intrinsics.checkNotNullParameter(r4, "headMakeUpView");
        Intrinsics.checkNotNullParameter(r5, "shopSkeletonLoadingView");
        Intrinsics.checkNotNullParameter(r6, "ballLoadingView");
        Intrinsics.checkNotNullParameter(r7, "maskView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.a = 2;
    }
}
