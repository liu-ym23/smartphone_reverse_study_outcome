package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/d;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailHeadVH extends AbsFullSpanVH<d> implements com.bytedance.android.shopping.anchorv4.log.d {
    public final ViewGroup m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d n;
    public final t o;

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onScan() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L7;
        ((AnchorV4DetailHeadView) r0).e();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.detailhead.AnchorV4DetailHeadView");
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r4) {
        d r5 = (d) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L11;
        AnchorV4DetailHeadView r1 = (AnchorV4DetailHeadView) r0;
        CommonMeta r2 = this.o.a();
        if (r2 == null) goto L7;
        String r3 = r2.getShopId();
    L8:
        r1.d(r5, r3, this.o);
        Unit r6 = Unit.INSTANCE;
        this.n.b(this, r5);
        return;
    L7:
        r3 = null;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.detailhead.AnchorV4DetailHeadView");
    }

    public AnchorV4DetailHeadVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, t r8) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "anchorV4VM");
        super(new AnchorV4DetailHeadView(r6.getContext(), null, 6, 0), true);
        this.m = r6;
        this.n = r7;
        this.o = r8;
    }
}
