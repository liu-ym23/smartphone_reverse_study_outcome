package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ui.base.widget.round.RoundView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final long a;
    public final OrderListTabLayout b;
    public final FrameLayout c;
    public final CustomHorizontalScrollView d;
    public final RoundView e;
    public final View f;

    public static final class a implements CustomHorizontalScrollView.a {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.shopping.orderlist.list.slice.elements.tab.CustomHorizontalScrollView.a
        public final void a() {
            if (this.a.d.getScrollX() <= 0) goto L5;
            this.a.f.setVisibility(0);
            return;
        L5:
            this.a.f.setVisibility(8);
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public final float a(int r6) {
        OrderListTabLayout.a r7 = this.b.e(r6);
        if (r7 != null) goto L6;
        return 0.0f;
    L6:
        if (r7.a.i == false) goto L19;
        float r0 = (r7.b.getLeft() + (r7.b.getWidth() / 2.0f)) - (this.e.getWidth() / 2);
        if (r7.a.g == true) goto L43;
        OrderListTabLayout.a r8 = this.b.getFirstViewInfo();
        if (r8 == null) goto L13;
        ConstraintLayout r9 = r8.b;
    L14:
        if (r9 == null) goto L16;
        int r10 = r9.getWidth();
    L18:
        return r0 + r10;
    L16:
        r10 = 0;
        goto L18
    L13:
        r9 = null;
        goto L14
    L43:
        return r0;
    L19:
        OrderListTabLayout.a r1 = this.b.getFirstViewInfo();
        if (r1 == null) goto L42;
        ConstraintLayout r2 = r1.b;
        if (r2 == null) goto L42;
        OrderListTabLayout.a r3 = this.b.getLastViewInfo();
        if (r3 == null) goto L42;
        ConstraintLayout r4 = r3.b;
        if (r4 == null) goto L42;
        int r5 = r7.b.getLeft() + (r7.b.getWidth() / 2);
        int r11 = this.d.getWidth() / 2;
        if (r5 < 0) goto L34;
        if (r11 < r5) goto L34;
    L41:
        return (r5 + r2.getWidth()) - (this.e.getWidth() / 2);
    L34:
        int r12 = r4.getRight() - r11;
        int r13 = r4.getRight();
        if (r12 > r5) goto L39;
        if (r13 < r5) goto L39;
        r5 = this.d.getWidth() - (r4.getRight() - r5);
    L39:
        r5 = r11;
    L42:
        return 0.0f;
    }

    public b(OrderListTabLayout r2, FrameLayout r3, CustomHorizontalScrollView r4, RoundView r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r3, "firstTabContainer");
        Intrinsics.checkNotNullParameter(r4, "tabScrollContainer");
        Intrinsics.checkNotNullParameter(r5, "indicator");
        Intrinsics.checkNotNullParameter(r6, "shadowView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = 200;
        r5.setVisibility(4);
        r6.setVisibility(8);
        r4.setScrollListener(new a(this));
    }
}
