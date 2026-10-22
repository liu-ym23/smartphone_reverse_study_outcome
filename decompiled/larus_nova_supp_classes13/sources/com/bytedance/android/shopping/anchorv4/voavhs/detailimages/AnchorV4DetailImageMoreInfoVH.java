package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailMoreInfo;
import com.bytedance.android.shopping.events.ImagePosition;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageMoreInfoVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageMoreInfoVH extends AbsFullSpanVH<d> implements com.bytedance.android.shopping.anchorv4.log.d {
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
        String r9 = "pd_picture_show" + String.valueOf(((d) getItem()).c);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r2 = this.p;
        String r8 = String.valueOf(((d) getItem()).c);
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("display_rank", String.valueOf(((d) getItem()).c));
        d r1 = this.m;
        if (r1 == null) goto L7;
        List<String> r3 = r1.g;
        if (r3 == null) goto L7;
        String r4 = (String) CollectionsKt.getOrNull(r3, ((d) getItem()).c);
    L8:
        r0[1] = TuplesKt.to("pic_type", r4);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r2, "pd_picture_show", MapsKt.mapOf(r0), false, null, null, r8, r9, 52);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.shopping.anchorv4.voavhs.detailimages.AnchorV4DetailImageMoreInfoView] */
    public final void a4(Object r14) {
        d r15 = (d) r14;
        Intrinsics.checkNotNullParameter(r15, "item");
        Object r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L38;
        ?? r1 = (AnchorV4DetailImageMoreInfoView) r0;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r2 = this.p;
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        TextView r3 = r1.b;
        DetailMoreInfo r4 = r15.d;
        if (r4 == null) goto L9;
        String r5 = r4.getTitle();
        if (r5 == null) goto L9;
    L10:
        r3.setText(r5);
        r1.a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
        r1.a.getHierarchy().setActualImageFocusPoint(new PointF(0.0f, 0.0f));
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L18;
        r1.setContentDescription(com.bytedance.android.shopping.extensions.j.d(2131913858, Integer.valueOf(r15.c + 1)));
        int r6 = com.bytedance.android.shopping.anchorv4.data.h.a;
        ArrayList r7 = new ArrayList();
        List r8 = r15.b.getUrlList();
        if (r8 == null) goto L17;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L17;
        r7.add(r9);
    L17:
        Unit r10 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.data.h.a(r7).subscribe(new a(r1, r15), new b(r1));
    L18:
        int r11 = 100;
        if (r15.b.getWidth() != 0) goto L21;
        int r12 = 100;
    L23:
        if (r15.b.getHeight() == 0) goto L26;
        r11 = r15.b.getHeight();
    L26:
        if (r12 == 0) goto L28;
        n1.i.getClass();
        r11 = (n1.a.d() * r11) / r12;
    L28:
        ImageExtensionsKt.D(r1.a, new r("ec_detail", "ec_product_detail_image"));
        SimpleDraweeView r13 = r1.a;
        ECUrlModel r16 = r15.b;
        n1.i.getClass();
        y.c(r13, r16, n1.a.d(), r11, new z53.a(r15.b.getUrlList(), ImagePosition.GOODS_CONTENT.getValue(), null, false, 28));
        r1.a.setLayoutParams(new ConstraintLayout.LayoutParams(-1, r11));
        r1.setOnClickListener(new c(r1, r2, r15));
        Unit r17 = Unit.INSTANCE;
        r1.c = r15;
        this.m = r15;
        ViewGroup.LayoutParams r18 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r18 = null;
    L31:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L34;
        r19.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r19.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
    L35:
        this.o.b(this, r15);
        return;
    L34:
        View r20 = ((RecyclerView.ViewHolder) this).itemView;
        ViewGroup.MarginLayoutParams r21 = new ViewGroup.MarginLayoutParams(-1, -2);
        r21.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r21.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r20.setLayoutParams(r21);
        goto L35
    L21:
        r12 = r15.b.getWidth();
    L9:
        r5 = "";
        goto L10
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.detailimages.AnchorV4DetailImageMoreInfoView");
    }

    public AnchorV4DetailImageMoreInfoVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, com.bytedance.android.shopping.anchorv4.voavhs.car.f r8) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "anchorV4VM");
        super(new AnchorV4DetailImageMoreInfoView(r6.getContext(), null, 6, 0), false);
        this.n = r6;
        this.o = r7;
        this.p = r8;
    }
}
