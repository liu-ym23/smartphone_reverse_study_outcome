package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.log.g;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import hl.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/car/AnchorV4CarAddressVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/car/b;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Lhl/n;", "event", "", "onPoiInfoUpdated", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CarAddressVH extends AbsFullSpanVH<b> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public b m;
    public final Lazy n;
    public boolean o;
    public final ViewGroup p;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d q;
    public final Context r;
    public final e s;

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

    public final void onDestroy() {
        ECLiveHybridUtil.p("updateSelectedShop", d1.c);
        d1.a = null;
        d1.b = null;
        s0.e(this);
    }

    public final void onResume() {
        if (this.o == false) goto L6;
        ECLiveHybridUtil.m("updateSelectedShop", d1.c);
        s0.c(this);
        this.o = false;
        return;
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L14;
        AnchorV4CarAddressView r1 = (AnchorV4CarAddressView) r0;
        if (g.a(r1) == false) goto L7;
        AnchorV4CarAddressView r2 = r1;
    L8:
        if (r2 == null) goto L15;
        e r3 = r1.h;
        if (r3 == null) goto L16;
        f.a.a(r3, "show_offline_store_entrance", null, false, null, null, null, null, 246);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.car.AnchorV4CarAddressView");
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r5) {
        b r6 = (b) r5;
        Intrinsics.checkNotNullParameter(r6, "item");
        this.m = r6;
        this.q.b(this, r6);
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV4CarAddressView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4CarAddressView r1 = (AnchorV4CarAddressView) r0;
        if (r1 == null) goto L8;
        r1.c(r6, r6.b, this.s, false);
    L8:
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if (r7 == null) goto L13;
        ExtensionsKt.e((ViewGroup) r7, this);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPoiInfoUpdated(n r30) {
        Intrinsics.checkNotNullParameter(r30, "event");
        ProductSelectPoiInfo r1 = r30.a;
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        TextElement r4 = null;
        if ((r2 instanceof AnchorV4CarAddressView) == true) goto L5;
        r2 = null;
    L5:
        AnchorV4CarAddressView r3 = (AnchorV4CarAddressView) r2;
        if (r3 == null) goto L66;
        e r5 = this.s;
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        if (d1.a == null) goto L10;
        f.a.a(r5, "change_offline_store", null, false, null, null, null, null, 254);
    L10:
        if (r1 != null) goto L12;
    L52:
        int r6 = g0.a;
        if (g0.a(r3.getContext()) == true) goto L60;
        TextElementView r7 = r3.b;
        AnchorV4CarAddressDisplay r8 = r3.e;
        if (r8 == null) goto L59;
        TextElement r9 = r8.getCarAddress();
        if (r9 == null) goto L59;
        r4 = TextElement.copy$default(r9, null, null, th.a.g(r3.getContext(), 2131913790), null, null, null, null, null, 0, null, 1019, null);
    L59:
        r7.x(r4);
        goto L66
    L60:
        TextElementView r10 = r3.b;
        AnchorV4CarAddressDisplay r11 = r3.e;
        if (r11 == null) goto L65;
        TextElement r12 = r11.getCarAddress();
        if (r12 == null) goto L65;
        r4 = TextElement.copy$default(r12, null, null, th.a.g(r3.getContext(), 2131913791), null, null, null, null, null, 0, null, 1019, null);
    L65:
        r10.x(r4);
        r3.c.setVisibility(8);
        goto L66
    L12:
        if (k.c(r1.getPoiName()) == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L52;
        r3.b.setVisibility(0);
        String r13 = "";
        if (r1.getDistance() == null) goto L21;
        Double r14 = r1.getDistance();
        Intrinsics.checkNotNull(r14);
        if (r14.doubleValue() <= 0) goto L21;
        String r15 = String.valueOf(r1.getDistance()).concat("km");
    L22:
        AnchorV4CarAddressDisplay r16 = r3.e;
        if (r16 == null) goto L25;
        LongContentLabelComponent r17 = r16.getCarTitle();
    L26:
        AnchorV4CarAddressDisplay r18 = r3.e;
        if (r18 == null) goto L31;
        TextElement r19 = r18.getCarAddress();
        if (r19 == null) goto L31;
        TextElement r110 = TextElement.copy$default(r19, null, null, "已选：" + r1.getPoiName(), null, null, null, null, null, 0, null, 1019, null);
    L32:
        AnchorV4CarAddressDisplay r20 = r3.e;
        if (r20 == null) goto L37;
        TextElement r21 = r20.getCarDistance();
        if (r21 == null) goto L37;
        TextElement r22 = TextElement.copy$default(r21, null, null, r15, null, null, null, null, null, 0, null, 1019, null);
    L38:
        AnchorV4CarAddressDisplay r111 = r3.e;
        if (r111 == null) goto L43;
        TextElement r112 = r111.getCarAddressDetail();
        if (r112 == null) goto L43;
        TextElement r113 = TextElement.copy$default(r112, null, null, r1.getAddress(), null, null, null, null, null, 0, null, 1019, null);
    L44:
        r3.c(null, new AnchorV4CarAddressDisplay(r17, r110, r22, r113), r5, true);
        String r23 = r1.getPoiName();
        if (r23 == null) goto L48;
        r13 = r23;
    L48:
        r3.b(r13, r1.getDistanceDesc());
        if (k.c(r1.getAddress()) == false) goto L51;
        r3.c.setVisibility(0);
        goto L66
    L51:
        r3.c.setVisibility(8);
    L43:
        r113 = null;
    L37:
        r22 = null;
    L31:
        r110 = null;
        goto L32
    L25:
        r17 = null;
    L21:
        r15 = "";
    L66:
        this.s.e();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((a) this.n.getValue()).O0(r2, r3, r4);
    }

    public AnchorV4CarAddressVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, Context r8, d r9) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        super(new AnchorV4CarAddressView(r6.getContext(), null, 6, 0), true);
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        this.n = LazyKt.lazy(new AnchorV4CarAddressVH$clickHandler$2(this));
        this.o = true;
    }
}
