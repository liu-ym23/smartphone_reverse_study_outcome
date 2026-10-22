package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.tab.entity.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/s;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/s;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$2 extends FunctionReferenceImpl implements Function1<s, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$productSingleTransformers$2(d r8) {
        super(1, r8, d.class, "dynamicProductDto2Vo", "dynamicProductDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowDynamicProductDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(s r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((d) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = i.k;
        Intrinsics.checkNotNullParameter(r4, "dto");
        WindowV2ProductItemVO.a r1 = WindowV2ProductItemVO.P;
        int r2 = tq3.c.T;
        tq3.c r3 = tq3.c.a.a(r4);
        r1.getClass();
        WindowV2ProductItemVO.a.b(r4, r3);
        i r5 = new i(r3);
        fo.b r6 = ((WindowV2ProductItemVO) r5.j).C;
        r6.b(wn.a.d, "product_card");
        r6.b(wn.a.a, "product_card");
        r6.b(wn.a.D, r5);
        return r5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((s) r1);
    }
}
