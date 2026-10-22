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
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BuyNowViewModel f488860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f488861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BuyNowLoadingView f488862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f488863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BuyNowErrorView f488864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f488865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BuyNowTouchMaskView f488866g;

    public final void c() {
        this.f488860a.setPageLoading(false);
        this.f488861b.setVisibility(8);
        View r100 = this.f488863d;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f488866g.setVisibility(8);
        this.f488862c.S5();
        this.f488865f.setVisibility(8);
        this.f488864e.setVisibility(8);
    }

    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f488860a.setPageLoading(true);
        View r101 = this.f488861b;
        if (r100.f488869c == false) goto L7;
        int r102 = com.bytedance.android.shopping.buynow.utils.b.f171205a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(this.f488860a) == true) goto L7;
        boolean r103 = true;
    L8:
        wg.a.h(r101, r103);
        View r104 = this.f488863d;
        if (r104 == null) goto L20;
        if (r100.f488867a == false) goto L17;
        SkeletonMode r105 = r100.f488868b;
        if (r105 == SkeletonMode.ONLY_PAY) goto L17;
        if (r105 == SkeletonMode.CONTINUE_PAY) goto L17;
        boolean r106 = true;
    L18:
        wg.a.h(r104, r106);
    L17:
        r106 = false;
    L20:
        if (r100.f488872f != null) goto L23;
        boolean r107 = r100.f488870d;
    L28:
        wg.a.h(this.f488866g, r107);
        if (r100.f488872f != null) goto L32;
        boolean r108 = r100.f488871e;
    L38:
        if (r100.f488867a == false) goto L40;
        this.f488862c.R5(true, r108, r100.f488868b);
    L44:
        if (this.f488860a.getStaticState().b() == true) goto L46;
    L48:
        this.f488865f.setVisibility(8);
    L49:
        this.f488864e.setVisibility(8);
        return;
    L46:
        if (r100.f488867a == false) goto L48;
        this.f488865f.setVisibility(0);
        goto L49
    L40:
        if (r108 == false) goto L42;
        BuyNowLoadingView r109 = this.f488862c;
        SkeletonMode r110 = r100.f488868b;
        int r111 = BuyNowLoadingView.f171244g;
        r109.R5(false, true, r110);
        goto L44
    L42:
        this.f488862c.S5();
        goto L44
    L32:
        if (r100.f488871e == true) goto L34;
    L36:
        r108 = false;
        goto L38
    L34:
        if (this.f488860a.getSkuService().n(r100.f488872f) == false) goto L36;
        r108 = true;
        goto L38
    L23:
        if (r100.f488870d == true) goto L25;
    L27:
        r107 = false;
        goto L28
    L25:
        if (this.f488860a.getSkuService().n(r100.f488872f) == false) goto L27;
        r107 = true;
    L7:
        r103 = false;
        goto L8
    }

    public final void a(la3.d r100, c r110) {
        Intrinsics.checkNotNullParameter(r100, "errorForm");
        Intrinsics.checkNotNullParameter(r110, "config");
        wg.a.h(this.f488861b, r110.f488869c);
        View r111 = this.f488863d;
        if (r111 == null) goto L5;
        r111.setVisibility(8);
    L5:
        this.f488866g.setVisibility(8);
        this.f488862c.S5();
        if (this.f488860a.getStaticState().c() == false) goto L8;
    L9:
        this.f488865f.setVisibility(0);
    L10:
        BuyNowErrorView r112 = this.f488864e;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "errorForm");
        h0.e((GenericDraweeView) r112.a(R.id.error_icon), r100.e(), new r("ec_buy_now", "buy_now_error_icon"), -1, -1, 96);
        String r101 = r100.f();
        if (r101 != null) goto L13;
    L16:
        boolean r102 = true;
    L17:
        if (r102 == true) goto L19;
        ((TextView) r112.a(R.id.error_title)).setText(r100.f());
        wg.a.h(r112.a(R.id.error_title), true);
    L19:
        String r103 = r100.d();
        if (r103 != null) goto L22;
    L25:
        boolean r104 = true;
    L26:
        if (r104 == true) goto L28;
        ((TextView) r112.a(R.id.error_subtitle)).setText(r100.d());
        wg.a.h(r112.a(R.id.error_subtitle), true);
    L28:
        ((TextView) r112.a(R.id.error_button)).setText(r100.b());
        TextView r105 = (TextView) r112.a(R.id.error_button);
        if (r105 == null) goto L31;
        r105.setOnClickListener(new com.bytedance.android.shopping.buynow.widgets.a(r112, r100));
    L31:
        r112.setVisibility(0);
        com.bytedance.android.shopping.buynow.tracker.a r106 = this.f488860a.getTracker();
        int r113 = com.bytedance.android.shopping.buynow.monitor.error.b.f170996a;
        if (r106 == null) goto L35;
        r106.b("buynow_error_monitor", MapsKt.mapOf(TuplesKt.to("type", CheckPointType.ERROR_PAGE_SHOW)));
        return;
    L35:
        return;
    L22:
        if (r103.length() == 0) goto L25;
        r104 = false;
        goto L26
    L13:
        if (r101.length() == 0) goto L16;
        r102 = false;
        goto L17
    L8:
        if (this.f488860a.getStaticState().b() == false) goto L10;
        goto L9
    }

    public b(BuyNowViewModel r100, View r101, BuyNowLoadingView r102, SimpleDraweeView r103, BuyNowErrorView r104, View r105, BuyNowTouchMaskView r106) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "navigationBar");
        Intrinsics.checkNotNullParameter(r102, "loadingView");
        Intrinsics.checkNotNullParameter(r104, "errorView");
        Intrinsics.checkNotNullParameter(r105, "errorCloseIcon");
        Intrinsics.checkNotNullParameter(r106, "maskView");
        this.f488860a = r100;
        this.f488861b = r101;
        this.f488862c = r102;
        this.f488863d = r103;
        this.f488864e = r104;
        this.f488865f = r105;
        this.f488866g = r106;
        r106.setMaskOnClick(r100);
    }
}
