package com.bytedance.android.window.shop.innerflow.util;

import android.content.Context;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "skuCartResult", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", "invoke", "com/bytedance/android/window/shop/innerflow/util/WindowShoppingCartUtil$addProductToCart$2$2"}, k = 3, mv = {1, 4, 3})
final class WindowShoppingCartUtil$addProductToCart$$inlined$let$lambda$1 extends Lambda implements Function1<SkuCartResult, Unit> {
    final /* synthetic */ Function1 $addCartListener$inlined;
    final /* synthetic */ String $btmPageId$inlined;
    final /* synthetic */ Function3 $cartListener$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ WindowV2ProductItemVO $currentItem$inlined;
    final /* synthetic */ Map $eventParams$inlined;
    final /* synthetic */ a.C0038a $param$inlined;
    final /* synthetic */ String $searchParam$inlined;

    public WindowShoppingCartUtil$addProductToCart$$inlined$let$lambda$1(a.C0038a r1, WindowV2ProductItemVO r2, Map r3, String r4, Function3 r5, Context r6, String r7, Function1 r8) {
        this.$currentItem$inlined = r2;
        this.$eventParams$inlined = r3;
        this.$searchParam$inlined = r4;
        this.$cartListener$inlined = r5;
        this.$context$inlined = r6;
        this.$btmPageId$inlined = r7;
        this.$addCartListener$inlined = r8;
        super(1);
    }

    public final void invoke(SkuCartResult r6) {
        Intrinsics.checkNotNullParameter(r6, "skuCartResult");
        Function3 r0 = this.$cartListener$inlined;
        if (r0 == null) goto L6;
        Unit r7 = (Unit) r0.invoke(r6.getSpec(), r6.getSkuId(), Long.valueOf(r6.getComboNum()));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SkuCartResult) r1);
        return Unit.INSTANCE;
    }
}
