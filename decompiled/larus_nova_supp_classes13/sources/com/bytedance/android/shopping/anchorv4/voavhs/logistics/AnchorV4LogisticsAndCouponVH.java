package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.AnchorV4Adapter;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponVH extends AbsFullSpanVH<a> implements d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public a m;
    public final Lazy n;
    public TextElement o;
    public final ViewGroup p;
    public final VisibleLogManager q;
    public final Context r;
    public final AnchorV4Adapter s;
    public final AnchorV4VM t;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        Map r2 = null;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        ExtensionsKt.f(r1, new AnonymousClass1(this));
    L8:
        int r3 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r4 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.t);
        if (r4 == null) goto L21;
        AnchorV4TrackerImpl r5 = r4.e("show_product_service");
        if (r5 == null) goto L21;
        a r6 = this.m;
        if (r6 == null) goto L19;
        AnchorV4LogisticsAndCouponMeta r7 = r6.c;
        if (r7 == null) goto L19;
        AnchorV4LogisticsAndCouponBusinessMeta r8 = r7.getBusinessMeta();
        if (r8 == null) goto L19;
        String r9 = r8.getServiceTypes();
    L20:
        r5.c = MapsKt.mapOf(TuplesKt.to("service_type", r9));
        AnchorV4TrackerImpl.b(r5, "show_product_service", false, null, false, null, 28);
    L19:
        r9 = null;
    L21:
        a r10 = this.m;
        if (r10 == null) goto L40;
        AnchorV4LogisticsAndCouponMeta r11 = r10.c;
        if (r11 == null) goto L41;
        AnchorV4LogisticsAndCouponBusinessMeta r12 = r11.getBusinessMeta();
        if (r12 == null) goto L42;
        String r13 = r12.getCouponMeta();
        if (r13 == null) goto L43;
        AnchorV4TrackerImpl r14 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.t);
        if (r14 == null) goto L44;
        AnchorV4TrackerImpl r15 = r14.e("product_coupon_show");
        if (r15 == null) goto L45;
        JSONObject r16 = k.w(r13);
        if (r16 == null) goto L38;
        JSONObject r17 = r16.optJSONObject("track_meta");
        if (r17 == null) goto L38;
        r2 = z1.j(r17);
    L38:
        r15.c = r2;
        AnchorV4TrackerImpl.b(r15, "product_coupon_show", false, null, false, null, 28);
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r2) {
        Intrinsics.checkNotNullParameter((a) r2, "item");
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    public static final void c4(AnchorV4LogisticsAndCouponVH r2, String r3) {
        r2.getClass();
        Object r4 = ((RecyclerView.ViewHolder) r2).itemView.findViewWithTag("choose_panel_text");
        if ((r4 instanceof TextElementView) == true) goto L5;
        r4 = null;
    L5:
        ?? r5 = (TextElementView) r4;
        if (r5 == 0) goto L9;
        r2.o = r5.getDescriptionVO();
        r5.setText(j.c(2131913783) + r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((AnchorV4LogisticsAndCouponClickHandler) this.n.getValue()).O0(r2, r3, r4);     // Catch: Exception -> L5
        return;
    }

    public final void b4(Object r3, final int r4, List r5) {
        final a r6 = (a) r3;
        Intrinsics.checkNotNullParameter(r6, "item");
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if (r7 == null) goto L11;
        ((AnchorV4LogisticsAndCouponView) r7).b(r6, this.t, new AnchorV4LogisticsAndCouponVH$bindView$$inlined$apply$lambda$1(this, r6, r4));
        Unit r8 = Unit.INSTANCE;
        this.m = r6;
        AnchorV4LogisticsAndCouponClickHandler r9 = (AnchorV4LogisticsAndCouponClickHandler) this.n.getValue();
        r9.d = this.m;
        this.q.b(this, r6, 0);
        View r10 = ((RecyclerView.ViewHolder) this).itemView;
        if (r10 == null) goto L9;
        ExtensionsKt.e((ViewGroup) r10, this);
        this.t.registerRefreshDetailInfoListener(new AnchorV4LogisticsAndCouponVH$listenDetailInfoChange$1(this));
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.logistics.AnchorV4LogisticsAndCouponView");
    }

    public AnchorV4LogisticsAndCouponVH(ViewGroup r6, VisibleLogManager r7, FragmentActivity r8, AnchorV4Adapter r9, AnchorV4VM r10) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "anchorV4Adapter");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        super(new AnchorV4LogisticsAndCouponView(r6.getContext(), null, 6, 0), true);
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        this.t = r10;
        this.n = LazyKt.lazy(new AnchorV4LogisticsAndCouponVH$clickHandler$2(this));
    }
}
