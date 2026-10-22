package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.events.ImagePosition;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.DraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageVH extends AbsFullSpanVH<d> implements com.bytedance.android.shopping.anchorv4.log.d {
    public d m;
    public final ViewGroup n;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d o;
    public final com.bytedance.android.shopping.anchorv4.voavhs.car.f p;

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onScan() {
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r0 = this.p;
        String r6 = String.valueOf(((d) getItem()).c);
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("display_rank", String.valueOf(((d) getItem()).c));
        d r7 = this.m;
        if (r7 == null) goto L7;
        List<String> r8 = r7.g;
        if (r8 == null) goto L7;
        String r9 = (String) CollectionsKt.getOrNull(r8, ((d) getItem()).c);
    L8:
        r2[1] = TuplesKt.to("pic_type", r9);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r0, "pd_picture_show", MapsKt.mapOf(r2), false, null, null, r6, "pd_picture_show" + String.valueOf(((d) getItem()).c), 52);
        return;
    L7:
        r9 = null;
        goto L8
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r18) {
        d r1 = (d) r18;
        Intrinsics.checkNotNullParameter(r1, "item");
        DraweeView r2 = ((RecyclerView.ViewHolder) this).itemView;
        if (r2 == null) goto L23;
        DraweeView r3 = (AnchorV4DetailImageView) r2;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r4 = this.p;
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        r3.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r3.setOnClickListener(new e(r3, r4, r1));
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L12;
        r3.setContentDescription(com.bytedance.android.shopping.extensions.j.d(2131913858, Integer.valueOf(r1.c + 1)));
        int r5 = com.bytedance.android.shopping.anchorv4.data.h.a;
        ArrayList r6 = new ArrayList();
        List r7 = r1.b.getUrlList();
        if (r7 == null) goto L11;
        String r8 = (String) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L11;
        r6.add(r8);
    L11:
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.data.h.a(r6).subscribe(new f(r3, r1), new g(r3));
    L12:
        int r10 = 100;
        if (r1.b.getWidth() != 0) goto L15;
        int r11 = 100;
    L17:
        if (r1.b.getHeight() == 0) goto L20;
        r10 = r1.b.getHeight();
    L20:
        n1.i.getClass();
        int r12 = (n1.a.d() * r10) / r11;
        ImageExtensionsKt.D(r3, new r("ec_detail", "ec_product_detail_image"));
        h0.b(r3, r1.b, null, Integer.valueOf(n1.a.d()), Integer.valueOf(r12), null, new z53.a(r1.b.getUrlList(), ImagePosition.GOODS_CONTENT.getValue(), null, false, 28));
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        Unit r13 = Unit.INSTANCE;
        r3.a = r1;
        this.m = r1;
        this.o.b(this, r1);
        return;
    L15:
        r11 = r1.b.getWidth();
        goto L17
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.detailimages.AnchorV4DetailImageView");
    }

    public AnchorV4DetailImageVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, com.bytedance.android.shopping.anchorv4.voavhs.car.f r8) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "anchorV4VM");
        super(new AnchorV4DetailImageView(r6.getContext(), null, 6, 0), false);
        this.n = r6;
        this.o = r7;
        this.p = r8;
    }
}
