package com.bytedance.android.shopping.anchorv4.voavhs.processflow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.car.f;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m83.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lm83/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ProcessFlowVH extends AbsFullSpanVH<a> implements d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public a m;
    public final ViewGroup n;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d o;
    public final Context p;
    public final f q;

    public final int M0() {
        return 0;
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV4ProcessFlowView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4ProcessFlowView r1 = (AnchorV4ProcessFlowView) r0;
        if (r1 == null) goto L9;
        ExtensionsKt.b(r1, this);
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r7) {
        a r8 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "item");
        this.m = r8;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L25;
        AnchorV4ProcessFlowView r1 = (AnchorV4ProcessFlowView) r0;
        AnchorV4ProcessFlowDisplay r2 = r8.b;
        CommonMeta r3 = this.q.a();
        List<TextWithOneIconElement> r4 = null;
        if (r3 == null) goto L7;
        Boolean r5 = Boolean.valueOf(r3.getEnablePDPOptimize());
    L9:
        if (k.i(r5) == false) goto L11;
        r1.b.f(new Radius(12, 12, 12, 12));
    L11:
        LongContentLabelComponentView r6 = (LongContentLabelComponentView) r1.a(2131383102);
        if (r2 == null) goto L14;
        LongContentLabelComponent r9 = r2.getProcessTitle();
    L15:
        r6.bind(r9);
        AnchorV4PathEffectFlowLayout r10 = (AnchorV4PathEffectFlowLayout) r1.a(2131383099);
        if (r2 == null) goto L18;
        r4 = r2.getProcessItems();
    L18:
        r10.R5(r4);
        this.o.b(this, r8);
        View r11 = ((RecyclerView.ViewHolder) this).itemView;
        if (r11 == null) goto L23;
        ExtensionsKt.e((ViewGroup) r11, this);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L14:
        r9 = null;
        goto L15
    L7:
        r5 = null;
        goto L9
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4ProcessFlowView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r10, Object r11) {
        if (r10 == null) goto L4;
        String r12 = r10.getId();
    L5:
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.hashCode() == 491549749) goto L11;
        return;
    L11:
        if (r12.equals("action_group_buy_rules") == false) goto L16;
        f r0 = this.q;
        if (r0 == null) goto L17;
        f.a.a(r0, "groupbuying_rule_show", null, false, null, null, null, null, 246);
        return;
    L17:
        return;
    L16:
        return;
    L4:
        r12 = null;
        goto L5
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r23, Action r24, Object r25) {
        Intrinsics.checkNotNullParameter(r23, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r24, "action");
        String r1 = r24.getId();
        if (r1 == null) goto L43;
        int r2 = r1.hashCode();
        String r5 = null;
        if (r2 == 491549749) goto L24;
        if (r2 == 884182084) goto L11;
        return;
    L11:
        if (r1.equals("auction_rules_click") == false) goto L39;
        Context r6 = this.p;
        a r3 = this.m;
        if (r3 == null) goto L19;
        AnchorV4ProcessFlowMeta r4 = r3.c;
        if (r4 == null) goto L19;
        AnchorV4ProcessFlowBusinessMeta r7 = r4.getBusinessMeta();
        if (r7 == null) goto L19;
        r5 = r7.getLinkUrl();
    L19:
        if (r5 != null) goto L21;
        String r8 = "";
    L22:
        ECLiveHybridUtil.k(r6, r8, false, false, false, null, 252);
        return;
    L21:
        r8 = r5;
        goto L22
    L39:
        return;
    L24:
        if (r1.equals("action_group_buy_rules") == false) goto L41;
        Context r9 = this.p;
        a r10 = this.m;
        if (r10 == null) goto L32;
        AnchorV4ProcessFlowMeta r11 = r10.c;
        if (r11 == null) goto L32;
        AnchorV4ProcessFlowBusinessMeta r12 = r11.getBusinessMeta();
        if (r12 == null) goto L32;
        r5 = r12.getLinkUrl();
    L32:
        if (r5 != null) goto L34;
        String r13 = "";
    L35:
        ECLiveHybridUtil.k(r9, r13, false, false, false, null, 252);
        f r14 = this.q;
        if (r14 == null) goto L42;
        f.a.a(r14, "groupbuying_rule_click", null, false, null, null, null, null, 254);
        return;
    L42:
        return;
    L34:
        r13 = r5;
        goto L35
    L41:
        return;
    }

    public AnchorV4ProcessFlowVH(ViewGroup r4, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r5, FragmentActivity r6, f r7) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, "logManager");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        super(new AnchorV4ProcessFlowView(r4.getContext(), null), true);
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
    }
}
