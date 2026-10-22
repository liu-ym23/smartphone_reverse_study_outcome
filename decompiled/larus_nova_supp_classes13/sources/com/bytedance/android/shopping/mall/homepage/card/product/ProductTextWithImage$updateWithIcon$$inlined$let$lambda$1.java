package com.bytedance.android.shopping.mall.homepage.card.product;

import android.graphics.Bitmap;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TagUIParams;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextWithIconConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke", "com/bytedance/android/shopping/mall/homepage/card/product/ProductTextWithImage$updateWithIcon$1$1"}, k = 3, mv = {1, 4, 3})
final class ProductTextWithImage$updateWithIcon$$inlined$let$lambda$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ TextWithIconConfig $config$inlined;
    final /* synthetic */ TagUIParams $iconParams;
    final /* synthetic */ Pair $imageMonitorTag$inlined;
    final /* synthetic */ ProductTextWithImage this$0;

    public ProductTextWithImage$updateWithIcon$$inlined$let$lambda$1(TagUIParams r1, ProductTextWithImage r2, TextWithIconConfig r3, Pair r4) {
        this.$iconParams = r1;
        this.this$0 = r2;
        this.$config$inlined = r3;
        this.$imageMonitorTag$inlined = r4;
        super(1);
    }

    public final void invoke(Bitmap r4) {
        this.this$0.getClass();
        if (r4 == null) goto L14;
        ProductStyle r0 = this.$iconParams.getStyle();
        Float r1 = null;
        if (r0 == null) goto L7;
        Float r2 = r0.getWidth();
    L8:
        ProductStyle r3 = this.$iconParams.getStyle();
        if (r3 == null) goto L11;
        r1 = r3.getHeight();
    L11:
        if (r2 == null) goto L14;
        if (r1 == null) goto L14;
        float r5 = r1.floatValue();
        ProductTextWithImage.A(this.this$0, r4, r2.floatValue(), r5);
        goto L14
    L7:
        r2 = null;
    L14:
        this.this$0.getClass();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }
}
