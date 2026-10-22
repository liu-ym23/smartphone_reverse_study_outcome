package com.bytedance.android.shopping.anchorv4.voavhs.unifiedtips;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.anchorv3.detail.widget.CategoryView;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3UnifiedTipsSubView;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3UnifiedTipsView;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.car.f;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import d63.d;
import d63.u;
import h53.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/unifiedtips/AnchorV4UnifiedTipVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Ld63/d;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4UnifiedTipVH extends AbsFullSpanVH<d> implements com.bytedance.android.shopping.anchorv4.log.d {
    public final ViewGroup m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d n;
    public final f o;

    public final void onScan() {
    }

    public final void onVisible() {
    }

    public final int M0() {
        return b.b(60);
    }

    public final void onCreate() {
        int r0 = UnifiedTipItemDecoration.c;
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        r1.setTag(2131896920, Boolean.TRUE);
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r14) {
        d r15 = (d) r14;
        Intrinsics.checkNotNullParameter(r15, "item");
        int r0 = UnifiedTipItemDecoration.c;
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        boolean r2 = true;
        if (r15.b != 0) goto L5;
        boolean r3 = true;
    L6:
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        r1.setTag(2131896918, Boolean.valueOf(r3));
        View r4 = ((RecyclerView.ViewHolder) this).itemView;
        boolean r5 = r15.c;
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        r4.setTag(2131896919, Boolean.valueOf(r5));
        AnchorV3UnifiedTipsView r6 = ((RecyclerView.ViewHolder) this).itemView;
        if (r6 == null) goto L61;
        AnchorV3UnifiedTipsView r7 = r6;
        CommonMeta r8 = this.o.a();
        if (r8 == null) goto L11;
        Boolean r9 = Boolean.valueOf(r8.getEnablePDPOptimize());
    L12:
        boolean r10 = k.i(r9);
        Intrinsics.checkNotNullParameter(r15, "anchorV3UnifiedTipsVO");
        if (r10 == false) goto L15;
        int r11 = 12;
    L16:
        r7.b.setPadding(b.b(12), b.b(0), b.b(12), b.b(0));
        int r12 = r15.b;
        if (r12 == 0) goto L19;
    L21:
        if (r12 != 0) goto L24;
        r7.c.f(new Radius(r11, r11, 0, 0));
    L27:
        CategoryView r13 = r7.findViewById(2131369232);
        if (r15.b <= 0) goto L30;
        r13.setVisibility(0);
        r13.a(a.a.a, r10);
    L31:
        r7.a.setTextSize(2, 16.0f);
        String r16 = r15.b();
        if (r16 != null) goto L34;
    L37:
        if (r2 == false) goto L39;
        r7.a.setVisibility(8);
    L40:
        r7.b.removeAllViews();
        List r17 = r15.a();
        if (r17 == null) goto L58;
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L44:
        if (r18.hasNext() == false) goto L58;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        u r22 = (u) r20;
        if (r19 <= 0) goto L57;
        View r23 = new CategoryView(r7.getContext(), null, 6, 0);
        ViewGroup.LayoutParams r110 = r23.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L53;
        r110 = null;
    L53:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L56;
        r111.leftMargin = b.b(12);
        r111.rightMargin = b.b(12);
        r23.setLayoutParams(r111);
    L56:
        r23.setVisibility(0);
        r23.a(a.a.a, r10);
        r7.b.addView(r23);
    L57:
        View r24 = new AnchorV3UnifiedTipsSubView(r7.getContext(), null, 6, 0);
        r24.a(r22, r10);
        r7.b.addView(r24);
        r19 = r21;
    L58:
        Unit r25 = Unit.INSTANCE;
        this.n.b(this, r15);
        return;
    L39:
        r7.a.setVisibility(0);
        r7.a.setText(r15.b());
        goto L40
    L34:
        if (r16.length() == 0) goto L37;
        r2 = false;
        goto L37
    L30:
        r13.setVisibility(8);
        goto L31
    L24:
        if (r15.c == false) goto L26;
        r7.c.f(new Radius(0, 0, r11, r11));
        goto L27
    L26:
        r7.c.f(new Radius(0, 0, 0, 0));
        goto L27
    L19:
        if (r15.c == false) goto L21;
        r7.c.f(new Radius(r11, r11, r11, r11));
        goto L27
    L15:
        r11 = 8;
        goto L16
    L11:
        r9 = null;
        goto L12
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.view.AnchorV3UnifiedTipsView");
    L5:
        r3 = false;
        goto L6
    }

    public AnchorV4UnifiedTipVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, f r8) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        super(new AnchorV3UnifiedTipsView(r6.getContext(), null, 6, 0), false);
        this.m = r6;
        this.n = r7;
        this.o = r8;
    }
}
