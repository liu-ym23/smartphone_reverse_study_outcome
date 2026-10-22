package ia3;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.buynow.components.SkeletonMode;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.buynow.widgets.BuyNowErrorView;
import com.bytedance.android.shopping.buynow.widgets.BuyNowLoadingView;
import com.bytedance.android.shopping.buynow.widgets.BuyNowTouchMaskView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final BuyNowViewModel a;
    public final View b;
    public final BuyNowLoadingView c;
    public final View d;
    public final BuyNowErrorView e;
    public final View f;
    public final BuyNowTouchMaskView g;

    public final void c() {
        this.a.setPageLoading(false);
        this.b.setVisibility(8);
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.g.setVisibility(8);
        this.c.S5();
        this.f.setVisibility(8);
        this.e.setVisibility(8);
    }

    public final void b(c r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        this.a.setPageLoading(true);
        View r0 = this.b;
        if (r6.c == false) goto L7;
        int r2 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(this.a) == true) goto L7;
        boolean r3 = true;
    L8:
        wg.a.h(r0, r3);
        View r1 = this.d;
        if (r1 == null) goto L20;
        if (r6.a == false) goto L17;
        SkeletonMode r4 = r6.b;
        if (r4 == SkeletonMode.ONLY_PAY) goto L17;
        if (r4 == SkeletonMode.CONTINUE_PAY) goto L17;
        boolean r5 = true;
    L18:
        wg.a.h(r1, r5);
    L17:
        r5 = false;
    L20:
        if (r6.f != null) goto L23;
        boolean r7 = r6.d;
    L28:
        wg.a.h(this.g, r7);
        if (r6.f != null) goto L32;
        boolean r8 = r6.e;
    L38:
        if (r6.a == false) goto L40;
        this.c.R5(true, r8, r6.b);
    L44:
        if (this.a.getStaticState().b() == true) goto L46;
    L48:
        this.f.setVisibility(8);
    L49:
        this.e.setVisibility(8);
        return;
    L46:
        if (r6.a == false) goto L48;
        this.f.setVisibility(0);
        goto L49
    L40:
        if (r8 == false) goto L42;
        BuyNowLoadingView r9 = this.c;
        SkeletonMode r10 = r6.b;
        int r11 = BuyNowLoadingView.g;
        r9.R5(false, true, r10);
        goto L44
    L42:
        this.c.S5();
        goto L44
    L32:
        if (r6.e == true) goto L34;
    L36:
        r8 = false;
        goto L38
    L34:
        if (this.a.getSkuService().n(r6.f) == false) goto L36;
        r8 = true;
        goto L38
    L23:
        if (r6.d == true) goto L25;
    L27:
        r7 = false;
        goto L28
    L25:
        if (this.a.getSkuService().n(r6.f) == false) goto L27;
        r7 = true;
    L7:
        r3 = false;
        goto L8
    }

    public final void a(la3.d r9, c r10) {
        Intrinsics.checkNotNullParameter(r9, "errorForm");
        Intrinsics.checkNotNullParameter(r10, "config");
        wg.a.h(this.b, r10.c);
        View r11 = this.d;
        if (r11 == null) goto L5;
        r11.setVisibility(8);
    L5:
        this.g.setVisibility(8);
        this.c.S5();
        if (this.a.getStaticState().c() == false) goto L8;
    L9:
        this.f.setVisibility(0);
    L10:
        BuyNowErrorView r12 = this.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "errorForm");
        h0.e(r12.a(2131371757), r9.e(), new r("ec_buy_now", "buy_now_error_icon"), -1, -1, 96);
        String r0 = r9.f();
        if (r0 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
        ((TextView) r12.a(2131371776)).setText(r9.f());
        wg.a.h(r12.a(2131371776), true);
    L19:
        String r2 = r9.d();
        if (r2 != null) goto L22;
    L25:
        boolean r3 = true;
    L26:
        if (r3 == true) goto L28;
        ((TextView) r12.a(2131371770)).setText(r9.d());
        wg.a.h(r12.a(2131371770), true);
    L28:
        ((TextView) r12.a(2131371750)).setText(r9.b());
        TextView r4 = (TextView) r12.a(2131371750);
        if (r4 == null) goto L31;
        r4.setOnClickListener(new com.bytedance.android.shopping.buynow.widgets.a(r12, r9));
    L31:
        r12.setVisibility(0);
        com.bytedance.android.shopping.buynow.tracker.a r13 = this.a.getTracker();
        int r14 = com.bytedance.android.shopping.buynow.monitor.error.b.a;
        if (r13 == null) goto L35;
        r13.b("buynow_error_monitor", MapsKt.mapOf(TuplesKt.to("type", CheckPointType.ERROR_PAGE_SHOW)));
        return;
    L35:
        return;
    L22:
        if (r2.length() == 0) goto L25;
        r3 = false;
        goto L26
    L13:
        if (r0.length() == 0) goto L16;
        r1 = false;
        goto L17
    L8:
        if (this.a.getStaticState().b() == false) goto L10;
        goto L9
    }

    public b(BuyNowViewModel r2, View r3, BuyNowLoadingView r4, SimpleDraweeView r5, BuyNowErrorView r6, View r7, BuyNowTouchMaskView r8) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "navigationBar");
        Intrinsics.checkNotNullParameter(r4, "loadingView");
        Intrinsics.checkNotNullParameter(r6, "errorView");
        Intrinsics.checkNotNullParameter(r7, "errorCloseIcon");
        Intrinsics.checkNotNullParameter(r8, "maskView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        r8.setMaskOnClick(r2);
    }
}
