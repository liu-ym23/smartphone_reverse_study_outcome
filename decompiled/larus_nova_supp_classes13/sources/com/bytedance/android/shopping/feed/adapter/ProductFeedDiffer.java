package com.bytedance.android.shopping.feed.adapter;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.feed.widget.s;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/ProductFeedDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedDiffer extends DiffUtil.ItemCallback<ProductFeedAdapter.b<?>> {

    public static final class a {
    }

    static {
    }

    public ProductFeedDiffer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean areContentsTheSame(Object r4, Object r5) {
        ProductFeedAdapter.b r6 = (ProductFeedAdapter.b) r4;
        ProductFeedAdapter.b r7 = (ProductFeedAdapter.b) r5;
        Intrinsics.checkNotNullParameter(r6, "pre");
        Intrinsics.checkNotNullParameter(r7, "post");
        T r8 = r6.b;
        T r9 = r7.b;
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L15;
        if ((r8 instanceof PromotionProductStruct) == false) goto L15;
        if ((r9 instanceof PromotionProductStruct) == false) goto L15;
        PromotionProductStruct r1 = (PromotionProductStruct) r9;
        if (r1.isForceRefreshExchangeCouponTips() == false) goto L12;
        return false;
    L12:
        if (r1.isForceRefreshHeadCard() == false) goto L15;
        r1.setForceRefreshHeadCard(false);
        return false;
    L15:
        if (ECAppInfoService.j() == false) goto L24;
        if ((r8 instanceof PromotionProductStruct) == false) goto L24;
        if ((r9 instanceof PromotionProductStruct) == false) goto L24;
        PromotionProductStruct r2 = (PromotionProductStruct) r9;
        if (r2.isForceRefreshHeadCard() == false) goto L24;
        r2.setForceRefreshHeadCard(false);
        return false;
    L24:
        if ((r8 instanceof PromotionProductStruct) == false) goto L31;
        if ((r9 instanceof PromotionProductStruct) == false) goto L31;
        if (((PromotionProductStruct) r9).isForceRefreshGoodPriceStrip() == true) goto L42;
    L37:
        return true;
    L42:
        return false;
    L31:
        if ((r8 instanceof rd3.a) == false) goto L37;
        if ((r9 instanceof rd3.a) == false) goto L37;
        if (((rd3.a) r9).n == false) goto L37;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean areItemsTheSame(Object r6, Object r7) {
        ProductFeedAdapter.b r8 = (ProductFeedAdapter.b) r6;
        ProductFeedAdapter.b r9 = (ProductFeedAdapter.b) r7;
        Intrinsics.checkNotNullParameter(r8, "preItem");
        Intrinsics.checkNotNullParameter(r9, "postItem");
        T r0 = r8.b;
        T r1 = r9.b;
        String r3 = null;
        Integer r4 = null;
        if ((r0 instanceof rd3.a) == false) goto L37;
        if ((r1 instanceof rd3.a) == false) goto L37;
        rd3.a r2 = (rd3.a) r0;
        Promotion r5 = r2.f();
        if (r5 == null) goto L13;
        PromotionProductStruct r10 = r5.getPromotionInfo();
        if (r10 == null) goto L13;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L13;
        String r12 = r11.getProductId();
    L14:
        rd3.a r13 = (rd3.a) r1;
        Promotion r14 = r13.f();
        if (r14 == null) goto L21;
        PromotionProductStruct r15 = r14.getPromotionInfo();
        if (r15 == null) goto L21;
        PromotionProductBaseStruct r16 = r15.getBaseInfo();
        if (r16 == null) goto L21;
        String r17 = r16.getProductId();
    L23:
        if (TextUtils.equals(r12, r17) == true) goto L25;
    L65:
        return false;
    L25:
        if (r8.a != r9.a) goto L65;
        p r18 = r2.i();
        if (r18 == null) goto L29;
        Integer r19 = Integer.valueOf(r18.getType());
    L30:
        p r20 = r13.i();
        if (r20 == null) goto L34;
        r4 = Integer.valueOf(r20.getType());
    L34:
        if (Intrinsics.areEqual(r19, r4) == false) goto L65;
    L64:
        return true;
    L29:
        r19 = null;
    L21:
        r17 = null;
    L13:
        r12 = null;
    L37:
        if ((r0 instanceof PromotionProductStruct) == false) goto L61;
        if ((r1 instanceof PromotionProductStruct) == false) goto L61;
        PromotionProductStruct r21 = (PromotionProductStruct) r0;
        PromotionProductBaseStruct r22 = r21.getBaseInfo();
        if (r22 == null) goto L43;
        String r23 = r22.getProductId();
    L44:
        PromotionProductStruct r24 = (PromotionProductStruct) r1;
        PromotionProductBaseStruct r25 = r24.getBaseInfo();
        if (r25 == null) goto L47;
        String r26 = r25.getProductId();
    L49:
        if (TextUtils.equals(r23, r26) == false) goto L65;
        PromotionProductBaseStruct r27 = r21.getBaseInfo();
        if (r27 == null) goto L53;
        String r28 = r27.getPromotionId();
    L54:
        PromotionProductBaseStruct r29 = r24.getBaseInfo();
        if (r29 == null) goto L58;
        r3 = r29.getPromotionId();
    L58:
        if (TextUtils.equals(r28, r3) == false) goto L65;
    L53:
        r28 = null;
        goto L54
    L47:
        r26 = null;
        goto L49
    L43:
        r23 = null;
    L61:
        if ((r0 instanceof s) == false) goto L65;
        if ((r1 instanceof s) == false) goto L65;
        goto L64
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object getChangePayload(Object r6, Object r7) {
        ProductFeedAdapter.b r8 = (ProductFeedAdapter.b) r6;
        ProductFeedAdapter.b r9 = (ProductFeedAdapter.b) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        T r0 = r8.b;
        T r1 = r9.b;
        Lazy r2 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L12;
        if ((r0 instanceof PromotionProductStruct) == false) goto L12;
        if ((r1 instanceof PromotionProductStruct) == false) goto L12;
        PromotionProductStruct r3 = (PromotionProductStruct) r1;
        if (r3.isForceRefreshExchangeCouponTips() == false) goto L12;
        r3.setForceRefreshExchangeCouponTips(false);
        return 1;
    L12:
        if ((r0 instanceof PromotionProductStruct) == false) goto L19;
        if ((r1 instanceof PromotionProductStruct) == false) goto L19;
        PromotionProductStruct r4 = (PromotionProductStruct) r1;
        if (r4.isForceRefreshGoodPriceStrip() == false) goto L26;
        r4.setForceRefreshGoodPriceStrip(false);
        return 2;
    L26:
        return super.getChangePayload(r8, r9);
    L19:
        if ((r0 instanceof rd3.a) == false) goto L26;
        if ((r1 instanceof rd3.a) == false) goto L26;
        rd3.a r5 = (rd3.a) r1;
        if (r5.n == false) goto L26;
        r5.n = false;
        return 2;
    }
}
