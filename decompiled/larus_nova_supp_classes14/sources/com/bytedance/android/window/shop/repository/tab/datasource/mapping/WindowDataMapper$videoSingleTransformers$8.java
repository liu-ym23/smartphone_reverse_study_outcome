package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.b0;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.tab.entity.ProductVideoVO;
import com.bytedance.android.window.shop.repository.tab.entity.f0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/b0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/b0;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$8 extends FunctionReferenceImpl implements Function1<b0, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$8(e r8) {
        super(1, r8, e.class, "playableProductCardDto2Vo", "playableProductCardDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowHangingProductVideoDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(b0 r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ((e) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        int r0 = f0.n;
        Intrinsics.checkNotNullParameter(r6, "dto");
        int r1 = ProductVideoVO.i;
        ProductVideoVO r2 = ProductVideoVO.a.a(r6.e());
        if (r6.c() != null) goto L5;
        tq3.c r3 = null;
    L6:
        if (r3 == null) goto L10;
        fo.b r4 = ((WindowV2ProductItemVO) r3).C;
        if (r4 == null) goto L10;
        Integer r5 = (Integer) r4.b(wn.a.f, 208);
    L10:
        Boolean r7 = r6.d();
        Boolean r8 = Boolean.TRUE;
        f0 r9 = new f0(r2, r3, Intrinsics.areEqual(r7, r8), Intrinsics.areEqual(r6.b(), r8));
        if (r3 == null) goto L15;
        fo.b r10 = ((WindowV2ProductItemVO) r3).C;
        if (r10 == null) goto L15;
        com.bytedance.android.window.shop.repository.tab.entity.f r11 = (com.bytedance.android.window.shop.repository.tab.entity.f) r10.b(wn.a.D, r9);
    L15:
        return r9;
    L5:
        WindowV2ProductItemVO.a r12 = WindowV2ProductItemVO.P;
        s r13 = r6.c();
        int r14 = tq3.c.T;
        tq3.c r15 = tq3.c.a.a(r6.c());
        r12.getClass();
        WindowV2ProductItemVO.a.b(r13, r15);
        r3 = r15;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b0) r1);
    }
}
