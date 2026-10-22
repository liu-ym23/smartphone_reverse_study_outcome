package com.bytedance.android.shopping.anchorv4.voavhs.offerrecord;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.auction.AnchorV3AuctionOfferRecordsFragment;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.PriceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.car.f;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l83.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/offerrecord/AnchorV4OfferRecordVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Ll83/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4OfferRecordVH extends AbsFullSpanVH<a> implements d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final ViewGroup m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d n;
    public final Context o;
    public final f p;

    public final int M0() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.offerrecord.AnchorV4OfferRecordItemView] */
    public final void a4(Object r19) {
        a r1 = (a) r19;
        Intrinsics.checkNotNullParameter(r1, "item");
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        if (r2 == null) goto L55;
        AnchorV4OfferRecordsView r3 = (AnchorV4OfferRecordsView) r2;
        AnchorV4OfferRecordsDisplay r4 = r1.b;
        CommonMeta r5 = this.p.a();
        LongContentLabelComponent r6 = null;
        if (r5 == null) goto L7;
        Boolean r7 = Boolean.valueOf(r5.getEnablePDPOptimize());
    L8:
        boolean r8 = k.i(r7);
        r3.removeAllViews();
        if (r8 == false) goto L12;
        r3.a.f(new Radius(12, 12, 12, 12));
    L12:
        if (r4 == null) goto L16;
        LongContentLabelComponent r9 = r4.getTitle();
        if (r9 == null) goto L16;
        LongContentLabelComponentView r15 = new LongContentLabelComponentView(r3.getContext(), null, null, 6, null);
        r15.bind(r9);
        r3.addView(r15, new LinearLayout.LayoutParams(-1, -2));
    L16:
        if (r4 == null) goto L48;
        List<AnchorV4OfferRecordItemVO> r10 = r4.getRecords();
        if (r10 == null) goto L48;
        Iterator<T> r11 = r10.iterator();
        int r12 = 0;
    L21:
        if (r11.hasNext() == false) goto L48;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        AnchorV4OfferRecordItemVO r16 = (AnchorV4OfferRecordItemVO) r13;
        ?? r17 = new AnchorV4OfferRecordItemView(r3.getContext(), r6, 6, 0);
        LongContentLabelComponentView r18 = (LongContentLabelComponentView) r17._$_findCachedViewById(2131381319);
        if (r16 == null) goto L28;
        LongContentLabelComponent r110 = r16.getAuthor();
    L29:
        r18.bind(r110);
        TextElementView r111 = (TextElementView) r17._$_findCachedViewById(2131381320);
        if (r16 == null) goto L32;
        LongContentLabelComponent r112 = r16.getDateTime();
    L33:
        r111.x(r112);
        PriceElementView r113 = (PriceElementView) r17._$_findCachedViewById(2131381321);
        if (r16 == null) goto L36;
        LongContentLabelComponent r114 = r16.getPrice();
    L37:
        r113.D(r114);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -2);
        if (r8 == false) goto L40;
        r115.topMargin = b.b(8);
    L43:
        Unit r20 = Unit.INSTANCE;
        r3.addView(r17, r115);
        if (r12 >= (r4.getRecords().size() - 1)) goto L47;
        if (r8 == false) goto L47;
        ImageView r21 = new ImageView(r3.getContext());
        r21.setBackgroundColor(ColorProtector.parseColor("#F6F7FB"));
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-1, b.b(Double.valueOf(0.5d)));
        r116.topMargin = b.b(16);
        r3.addView(r21, r116);
    L47:
        r12 = r14;
        r6 = null;
        goto L21
    L40:
        if (r12 != 0) goto L42;
        r115.topMargin = b.b(12);
        goto L43
    L42:
        r115.topMargin = b.b(16);
        goto L43
    L36:
        r114 = r6;
        goto L37
    L32:
        r112 = r6;
        goto L33
    L28:
        r110 = r6;
    L48:
        this.n.b(this, r1);
        View r22 = ((RecyclerView.ViewHolder) this).itemView;
        if (r22 == null) goto L53;
        ExtensionsKt.e((ViewGroup) r22, this);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L7:
        r7 = null;
        goto L8
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.offerrecord.AnchorV4OfferRecordsView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r11, Action r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r12, "action");
        String r14 = r12.getId();
        if (r14 != null) goto L6;
        return;
    L6:
        if (r14.hashCode() == 1228711812) goto L9;
        return;
    L9:
        if (r14.equals("id_offer_records_click") == false) goto L34;
        Context r15 = this.o;
        String r16 = null;
        if ((r15 instanceof FragmentActivity) == true) goto L13;
        r15 = null;
    L13:
        FragmentActivity r17 = (FragmentActivity) r15;
        if (r17 == null) goto L27;
        int r18 = AnchorV3AuctionOfferRecordsFragment.g;
        AnchorV4OfferRecordsMeta r0 = ((a) getItem()).c;
        if (r0 == null) goto L20;
        AnchorV4OfferRecordsBusinessMeta r1 = r0.getBusinessMeta();
        if (r1 == null) goto L20;
        r16 = r1.getAuctionId();
    L20:
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        Parcelable r19 = new AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams(r16, 0);
        Intrinsics.checkNotNullParameter(r19, "params");
        AnchorV3AuctionOfferRecordsFragment r110 = new AnchorV3AuctionOfferRecordsFragment();
        Bundle r2 = new Bundle();
        r2.putParcelable("key_params", r19);
        Unit r111 = Unit.INSTANCE;
        r110.setArguments(r2);
        FragmentManager r112 = r17.getSupportFragmentManager();
        LandscapeRestrictionOperation r113 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r110, "OfferRecordsDialog", r113);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r110, r113) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L26:
        r110.show(r112, "OfferRecordsDialog");
    L27:
        f r3 = this.p;
        if (r3 == null) goto L35;
        f.a.a(r3, "auction_pay_record_click", null, false, null, null, null, null, 254);
        return;
    L35:
        return;
    }

    public AnchorV4OfferRecordVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, FragmentActivity r8, f r9) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        super(new AnchorV4OfferRecordsView(r6.getContext(), null, 6, 0), true);
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = r9;
    }
}
