package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.s0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.feed.utils.h;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.product.flow.banner.FooterBannerHolder;
import com.bytedance.android.shopping.product.flow.banner.ImageBannerHolder;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/MainCardImageBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCardImageBannerAdapter extends RecyclerView.Adapter<BannerHolder> {
    public List<? extends ECUrlModel> a;
    public rd3.a b;
    public ECUrlModel c;
    public yg3.d d;
    public yg3.b e;
    public Integer f;
    public final b g;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ MainCardImageBannerAdapter g;

        public b(MainCardImageBannerAdapter r3) {
            this.g = r3;
            super(null, "bind_product_flow_card", 1);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            yg3.d r0 = this.g.d;
            if (r0 == null) goto L9;
            Object r1 = r3.getTag();
            if (r1 == null) goto L8;
            r0.a(((Integer) r1).intValue(), r3);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    public final int getItemCount() {
        int r2 = 0;
        if (this.e == null) goto L5;
        int r0 = 1;
    L6:
        List<? extends ECUrlModel> r3 = this.a;
        if (r3 == null) goto L10;
        r2 = r3.size();
    L10:
        return (r0 + r2) + 1;
    L5:
        r0 = 0;
        goto L6
    }

    public MainCardImageBannerAdapter() {
        this.g = new b(this);
    }

    public final int getItemViewType(int r4) {
        if (this.e == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        if (r4 != 0) goto L10;
        return 1;
    L10:
        if (r4 != (getItemCount() - 1)) goto L13;
        return 2;
    L13:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r31, int r32) {
        BannerHolder r1 = (BannerHolder) r31;
        Intrinsics.checkNotNullParameter(r1, "bannerHolder");
        if ((r1 instanceof MainCardImageBannerHolder) == true) goto L5;
    L78:
        ((RecyclerView.ViewHolder) r1).itemView.setTag(Integer.valueOf(r32));
        return;
    L5:
        if (this.e == null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        int r3 = r32 - 1;
    L11:
        List<? extends ECUrlModel> r5 = this.a;
        if (r5 == null) goto L14;
        ECUrlModel r6 = (ECUrlModel) ListProtector.get(r5, r3);
    L15:
        MainCardImageBannerHolder r14 = (MainCardImageBannerHolder) r1;
        ECUrlModel r15 = this.c;
        Integer r7 = this.f;
        rd3.a r13 = this.b;
        r14.g.setVisibility(8);
        r14.h.setVisibility(8);
        View r8 = r14.e;
        if (r8 == null) goto L19;
        AccessibilityDelegateCompatImpl r9 = new AccessibilityDelegateCompatImpl(r8);
        r9.b = "商品大图";
        ViewCompat.setAccessibilityDelegate(r8, r9);
    L19:
        r14.e.setOnLongClickListener(new c(r14, r13, r6));
        ECDraweeView r10 = r14.a;
        r r11 = new r("ec_goods_feed", "ec_goods_feed_banner");
        r11.g("ec_goods_feed_enable_preconnect", Integer.valueOf(!ECSettingKeys.x().isEmpty() ? 1 : 0));
        Unit r12 = Unit.INSTANCE;
        ImageExtensionsKt.D(r10, r11);
        r14.d.setVisibility(0);
        int r16 = s0.f;
        int r17 = h.a;
        r r18 = h.a.a();
        s0 r19 = new s0(r6, r18);
        Integer r110 = 2;
        if (r110 != null) goto L22;
        IterativeBoxBlurPostProcessor r111 = new IterativeBoxBlurPostProcessor(24);
    L23:
        Intrinsics.checkNotNullParameter(r111, "processor");
        r19.a = r111;
        ECDraweeView r20 = r14.c;
        Intrinsics.checkNotNullParameter(r20, "target");
        if (r6 != null) goto L27;
    L53:
        if (r7 == null) goto L55;
        int r21 = r7.intValue();
        r14.b.getLayoutParams().width = r21;
        r14.b.getLayoutParams().height = r21;
    L55:
        ECDraweeView r22 = r14.a;
        r r23 = h.a.a();
        if (r6 == null) goto L58;
        List r112 = r6.getUrlList();
    L59:
        ImagePosition r24 = ImagePosition.GOODS_HEADER;
        h0.b(r22, r6, r23, null, null, null, new z53.a(r112, r24.getValue(), null, false, 28));
        if (r32 != 0) goto L73;
        if (r15 == null) goto L71;
        List r25 = r15.getUrlList();
        if (r25 == null) goto L71;
        if ((!r25.isEmpty()) != true) goto L71;
        r14.f.setVisibility(0);
        RemoteRoundImageView r26 = r14.f;
        r r27 = h.a.a();
        if (r6 == null) goto L69;
        List r113 = r6.getUrlList();
    L70:
        h0.b(r26, r15, r27, null, null, null, new z53.a(r113, r24.getValue(), null, false, 28));
    L72:
        r14.U3(r13);
        goto L73
    L69:
        r113 = null;
    L71:
        r14.f.setVisibility(8);
    L73:
        List<? extends ECUrlModel> r4 = this.a;
        if (r4 == null) goto L78;
        ECUrlModel r28 = (ECUrlModel) CollectionsKt.getOrNull(r4, r3 + 1);
        if (r28 == null) goto L78;
        Intrinsics.checkNotNullParameter(r28, "urlModel");
        h0.i(r28, h.a.a());
        goto L78
    L58:
        r112 = null;
        goto L59
    L27:
        if ((r6 instanceof String) == false) goto L29;
        ImageExtensionsKt.s(r20, (String) r6, null, r19.e, null, null, null, r19.a, null, true, null, null, null);
        goto L53
    L29:
        boolean r114 = r6 instanceof ECUrlModel;
        if (r114 == false) goto L32;
    L33:
        if (r114 == false) goto L36;
        List r115 = r6.getUrlList();
    L41:
        List r116 = r115;
    L43:
        List r117 = r116;
        if (r117 != null) goto L46;
    L49:
        boolean r118 = true;
    L50:
        if (r118 == true) goto L53;
        ImageExtensionsKt.x(r20, r116, null, r18, null, null, null, r19.a, null, true, null, null, null, 4096);
        goto L53
    L46:
        if (r117.isEmpty() == true) goto L49;
        r118 = false;
        goto L50
    L36:
        if ((r6 instanceof List) == false) goto L42;
        r115 = (List) r6;
        if ((!r115.isEmpty()) == false) goto L42;
        if ((CollectionsKt.first(r115) instanceof String) == true) goto L41;
    L42:
        r116 = null;
        goto L43
    L32:
        if ((r6 instanceof List) == false) goto L53;
    L22:
        r111 = new IterativeBoxBlurPostProcessor(r110.intValue(), 24);
        goto L23
    L14:
        r6 = null;
        goto L15
    L10:
        r3 = r32;
        goto L11
    L7:
        r2 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r1 = r4.getContext();
        r6.getClass();
        View r7 = ShoppingAsyncInflater.a.a(r1).aU(2131560741, r4, false);
        r7.setOnClickListener(this.g);
        return new MainCardImageBannerHolder(r7);
    L5:
        if (r5 == 2) goto L7;
        ShoppingAsyncInflater.a r8 = ShoppingAsyncInflater.e;
        Context r2 = r4.getContext();
        r8.getClass();
        return new ImageBannerHolder(ShoppingAsyncInflater.a.a(r2).aU(2131560456, r4, false));
    L7:
        ShoppingAsyncInflater.a r3 = ShoppingAsyncInflater.e;
        Context r9 = r4.getContext();
        r3.getClass();
        return new FooterBannerHolder(ShoppingAsyncInflater.a.a(r9).aU(2131564853, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List r8) {
        BannerHolder r9 = (BannerHolder) r6;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        boolean r2 = false;
        if ((!r8.isEmpty()) == false) goto L15;
        Iterator r0 = r8.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        if ((r3 instanceof String) == false) goto L6;
        if (Intrinsics.areEqual("updateGoodPriceStrip", r3) == false) goto L6;
        if ((r9 instanceof MainCardImageBannerHolder) == false) goto L6;
        if (r7 != 0) goto L6;
        ((MainCardImageBannerHolder) r9).U3(this.b);
        r2 = true;
    L15:
        if (r2 == true) goto L29;
        super.onBindViewHolder(r9, r7, r8);
        return;
    }
}
