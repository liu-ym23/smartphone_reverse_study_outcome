package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.KolGridComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.KolReviewElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/b;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationVH extends AbsFullSpanVH<b> implements d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final Lazy m;
    public final ViewGroup n;
    public final VisibleLogManager o;
    public final Context p;
    public final AnchorV4VM q;

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
        LinkedHashMap r0 = new LinkedHashMap();
        AnchorV4KolEvaluationMeta r1 = ((b) getItem()).c;
        if (r1 == null) goto L9;
        AnchorV4KolEvaluationTrackMeta r2 = r1.getTrackMeta();
        if (r2 == null) goto L9;
        String r3 = r2.getContentSource();
        if (r3 == null) goto L9;
        r0.put("content_source", r3);
    L9:
        int r4 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r5 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.q);
        if (r5 == null) goto L13;
        r5.c = r0;
        AnchorV4TrackerImpl.b(r5, "goods_video_entrance_show", false, null, false, null, 28);
        return;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r17) {
        b r1 = (b) r17;
        Intrinsics.checkNotNullParameter(r1, "item");
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        AttributeSet r5 = null;
        if ((r3 instanceof AnchorV4KolEvaluationView) == true) goto L5;
        r3 = null;
    L5:
        final AnchorV4KolEvaluationView r4 = (AnchorV4KolEvaluationView) r3;
        if (r4 == null) goto L84;
        AnchorV4VM r6 = this.q;
        Intrinsics.checkNotNullParameter(r1, "item");
        LongContentLabelComponentView r2 = r4.a;
        if (r2 == null) goto L14;
        AnchorV4KolEvaluationDisplay r7 = r1.b;
        if (r7 == null) goto L12;
        LongContentLabelComponent r8 = r7.getKolReviewTitle();
    L13:
        r2.bind(r8);
        goto L14
    L12:
        r8 = null;
    L14:
        AnchorV4KolEvaluationDisplay r9 = r1.b;
        if (r9 == null) goto L19;
        List<KolReviewElement> r10 = r9.getKolReviewList();
        if (r10 == null) goto L19;
        int r11 = r10.size();
    L21:
        if (r11 <= 3) goto L35;
        LinearLayout r12 = r4.c;
        if (r12 == null) goto L25;
        r12.setVisibility(8);
    L25:
        KolGridComponentView r13 = r4.b;
        if (r13 == null) goto L28;
        r13.setVisibility(0);
    L28:
        KolGridComponentView r14 = r4.b;
        if (r14 == null) goto L76;
        AnchorV4KolEvaluationDisplay r15 = r1.b;
        if (r15 == null) goto L33;
        List<KolReviewElement> r16 = r15.getKolReviewList();
    L34:
        r14.a(r16, new AnchorV4KolEvaluationView$bind$1(r4));
        goto L76
    L33:
        r16 = null;
    L76:
        if (r6 == null) goto L80;
        CommonMeta r18 = r6.commonMeta();
        if (r18 == null) goto L80;
        Boolean r19 = Boolean.valueOf(r18.getEnablePDPOptimize());
    L82:
        if (k.i(r19) == false) goto L84;
        r4.d.f(new Radius(12, 12, 12, 12));
    L80:
        r19 = null;
        goto L82
    L35:
        if (r11 <= 0) goto L76;
        AnchorV4KolEvaluationDisplay r20 = r1.b;
        if (r20 == null) goto L39;
        List<KolReviewElement> r21 = r20.getKolReviewList();
    L40:
        LinearLayout r22 = r4.c;
        if (r22 == null) goto L43;
        r22.setVisibility(0);
    L43:
        KolGridComponentView r23 = r4.b;
        if (r23 == null) goto L46;
        r23.setVisibility(8);
    L46:
        LinearLayout r24 = r4.c;
        if (r24 == null) goto L50;
        r24.removeAllViews();
    L50:
        if (r21 != null) goto L52;
    L56:
        if (r21 == null) goto L76;
        if ((!r21.isEmpty()) != true) goto L76;
        KolReviewElement r110 = (KolReviewElement) CollectionsKt.firstOrNull(r21);
        if (r110 == null) goto L62;
        float r111 = r110.getEdgePercent();
    L63:
        float r25 = (n1.f - (com.bytedance.android.shopping.extensions.b.b(8) * (((int) (1 / r111)) - 1))) * r111;
        Iterator<T> r26 = r21.iterator();
        int r112 = 0;
    L65:
        if (r26.hasNext() == false) goto L76;
        Object r113 = r26.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L69;
        CollectionsKt.throwIndexOverflow();
    L69:
        KolReviewElementView r115 = new KolReviewElementView(r4.getContext(), r5, 0, 14);
        int r27 = (int) r25;
        r115.a((KolReviewElement) r113, new ViewGroup.MarginLayoutParams(r27, r27));
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(r27, -2);
        if (r112 <= 0) goto L72;
        r116.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L72:
        LinearLayout r28 = r4.c;
        if (r28 == null) goto L75;
        r28.addView(r115, r116);
    L75:
        r112 = r114;
        r5 = null;
        goto L65
    L62:
        r111 = 1.0f;
        goto L63
    L52:
        if (r21.size() != 1) goto L56;
        LinearLayout r29 = r4.c;
        if (r29 == null) goto L76;
        KolReviewElementView r30 = new KolReviewElementView(r4.getContext(), null, 0, 14);
        r30.a((KolReviewElement) CollectionsKt.firstOrNull(r21), null);
        Unit r31 = Unit.INSTANCE;
        r29.addView(r30, -1, -2);
        goto L76
    L39:
        r21 = null;
    L19:
        r11 = 0;
    L84:
        View r32 = ((RecyclerView.ViewHolder) this).itemView;
        if (r32 == null) goto L89;
        ExtensionsKt.e((ViewGroup) r32, this);
        this.o.b(this, r1, 0);
        return;
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((a) this.m.getValue()).O0(((RecyclerView.ViewHolder) this).itemView, r3, r4);
    }

    public AnchorV4KolEvaluationVH(ViewGroup r6, VisibleLogManager r7, FragmentActivity r8, AnchorV4VM r9) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        super(new AnchorV4KolEvaluationView(r6.getContext(), null, 6, 0), true);
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.m = LazyKt.lazy(new AnchorV4KolEvaluationVH$actionHandler$2(this));
    }
}
