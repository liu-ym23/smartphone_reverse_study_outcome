package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$3 extends FunctionReferenceImpl implements Function1<WindowV2ProductItemDTO, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$productSingleTransformers$3(d r8) {
        super(1, r8, d.class, "syncProductDto2Vo", "syncProductDto2Vo(Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(WindowV2ProductItemDTO r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ((d) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "productDto");
        int r0 = b0.k;
        Intrinsics.checkNotNullParameter(r5, "dto");
        WindowV2ProductItemVO.a r1 = WindowV2ProductItemVO.P;
        tq3.c r2 = new tq3.c(r5.e());
        r1.getClass();
        WindowV2ProductItemVO.a.b(r5, r2);
        b0 r3 = new b0(r2);
        fo.b r6 = ((WindowV2ProductItemVO) r3.j).C;
        r6.b(wn.a.d, "product_card");
        r6.b(wn.a.a, "product_card");
        r6.b(wn.a.t, Boolean.TRUE);
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((WindowV2ProductItemDTO) r1);
    }
}
