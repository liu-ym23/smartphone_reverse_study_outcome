package com.bytedance.android.shopping.product.flow.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yg3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends RecyclerView.Adapter<BannerHolder> {
    public List<? extends ECUrlModel> a;
    public ECUrlModel b;
    public d c;
    public yg3.b d;
    public final b e;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ BannerAdapter g;

        public b(BannerAdapter r3) {
            this.g = r3;
            super(null, "bind_product_flow_card", 1);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            d r0 = this.g.c;
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
        if (this.d == null) goto L5;
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

    public BannerAdapter() {
        this.e = new b(this);
    }

    public final int getItemViewType(int r4) {
        if (this.d == null) goto L5;
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

    public final void onBindViewHolder(RecyclerView.ViewHolder r20, int r21) {
        BannerHolder r1 = (BannerHolder) r20;
        Intrinsics.checkNotNullParameter(r1, "bannerHolder");
        if ((r1 instanceof ImageBannerHolder) == false) goto L42;
        if (this.d == null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        int r3 = r21 - 1;
    L11:
        List<? extends ECUrlModel> r7 = this.a;
        if (r7 == null) goto L14;
        ECUrlModel r8 = (ECUrlModel) ListProtector.get(r7, r3);
    L15:
        ImageBannerHolder r9 = (ImageBannerHolder) r1;
        ECUrlModel r10 = this.b;
        View r11 = r9.b;
        if (r11 == null) goto L19;
        AccessibilityDelegateCompatImpl r12 = new AccessibilityDelegateCompatImpl(r11);
        r12.b = "商品大图";
        ViewCompat.setAccessibilityDelegate(r11, r12);
    L19:
        ECDraweeView r13 = r9.a;
        r r14 = new r("ec_goods_feed", "ec_goods_feed_banner");
        r14.g("ec_goods_feed_enable_preconnect", Integer.valueOf(!ECSettingKeys.x().isEmpty() ? 1 : 0));
        Unit r15 = Unit.INSTANCE;
        ImageExtensionsKt.D(r13, r14);
        ECDraweeView r16 = r9.a;
        if (r8 == null) goto L22;
        List r17 = r8.getUrlList();
    L23:
        ImagePosition r18 = ImagePosition.GOODS_HEADER;
        y.c(r16, r8, -1, -1, new z53.a(r17, r18.getValue(), null, false, 28));
        if (r10 == null) goto L35;
        List r5 = r10.getUrlList();
        if (r5 == null) goto L35;
        if ((!r5.isEmpty()) != true) goto L35;
        if (r21 != 0) goto L35;
        r9.c.setVisibility(0);
        RemoteRoundImageView r4 = r9.c;
        if (r8 == null) goto L33;
        List r19 = r8.getUrlList();
    L34:
        y.c(r4, r10, -1, -1, new z53.a(r19, r18.getValue(), null, false, 28));
    L36:
        List<? extends ECUrlModel> r6 = this.a;
        if (r6 == null) goto L51;
        ECUrlModel r22 = (ECUrlModel) CollectionsKt.getOrNull(r6, r3 + 1);
        if (r22 == null) goto L51;
        Intrinsics.checkNotNullParameter(r22, "urlModel");
        y.n(r22, new yg3.a());
    L51:
        ((RecyclerView.ViewHolder) r1).itemView.setTag(Integer.valueOf(r21));
        return;
    L33:
        r19 = null;
    L35:
        r9.c.setVisibility(8);
        goto L36
    L22:
        r17 = null;
        goto L23
    L14:
        r8 = null;
        goto L15
    L10:
        r3 = r21;
        goto L11
    L7:
        r2 = false;
        goto L8
    L42:
        if ((r1 instanceof VideoBannerHolder) == false) goto L51;
        VideoBannerHolder r23 = (VideoBannerHolder) r1;
        yg3.b r24 = this.d;
        r23.b.setVisibility(0);
        ECVideoPlayer r25 = r23.a;
        if (r25 == null) goto L46;
        r25.o(false);
    L46:
        r23.c.setMute(false);
        r23.d = r24;
        SimpleDraweeView r26 = r23.b;
        if (r24 == null) goto L49;
        String r27 = r24.a();
    L50:
        y.e(r26, r27, -1, -1, null);
        goto L51
    L49:
        r27 = null;
        goto L50
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L5;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131560583, r4, false);
        r6.setOnClickListener(this.e);
        return new ImageBannerHolder(r6);
    L5:
        if (r5 != 1) goto L7;
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131560666, r4, false);
        r7.setOnClickListener(this.e);
        return new VideoBannerHolder(r7);
    L7:
        if (r5 == 2) goto L14;
        return new ImageBannerHolder(LayoutInflater.from(r4.getContext()).inflate(2131560456, r4, false));
    L14:
        return new FooterBannerHolder(LayoutInflater.from(r4.getContext()).inflate(2131564853, r4, false));
    }
}
