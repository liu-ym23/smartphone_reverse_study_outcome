package com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c83.a;
import c83.c;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/deletedproducttip/AnchorV4DeletedProductTipVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lc83/a;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DeletedProductTipVH extends AbsFullSpanVH<a> implements d {
    public final ViewGroup m;
    public final c n;

    public final int M0() {
        return 0;
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r10) {
        a r11 = (a) r10;
        Intrinsics.checkNotNullParameter(r11, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        Unit r2 = null;
        if ((r0 instanceof AnchorV4DeletedProductTipView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4DeletedProductTipView r1 = (AnchorV4DeletedProductTipView) r0;
        if (r1 == null) goto L16;
        AnchorV4DeletedProductTipDisplay r12 = r11.b;
        c r3 = this.n;
        if (r12 == null) goto L15;
        TextWithOneIconElement r4 = r12.getDeletedTip();
        if (r4 == null) goto L15;
        TextWithOneIconElementView.b((TextWithOneIconElementView) r1.a(), r4, null, false, null, 14);
        r1.a().setVisibility(0);
        if (r3 == null) goto L14;
        r3.a();
        r2 = Unit.INSTANCE;
    L14:
        if (r2 != null) goto L16;
    L15:
        r1.a().setVisibility(8);
        Unit r13 = Unit.INSTANCE;
    L16:
        this.n.b();
    }

    public AnchorV4DeletedProductTipVH(ViewGroup r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        super(new AnchorV4DeletedProductTipView(r4.getContext(), null), false);
        this.m = r4;
        this.n = r5;
    }
}
