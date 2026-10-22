package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.b0;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.tab.entity.ProductVideoVO;
import com.bytedance.android.window.shop.repository.tab.entity.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/b0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/b0;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$10 extends FunctionReferenceImpl implements Function1<b0, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$10(e r8) {
        super(1, r8, e.class, "explainRecommendProductCardDto2Vo", "explainRecommendProductCardDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowHangingProductVideoDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(b0 r14) {
        Intrinsics.checkNotNullParameter(r14, "p1");
        ((e) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r14, "item");
        int r0 = l.n;
        Intrinsics.checkNotNullParameter(r14, "dto");
        ProductVideoVO r1 = null;
        if (r14.c() != null) goto L5;
        tq3.c r3 = null;
    L6:
        int r2 = ProductVideoVO.i;
        ProductVideoVO r4 = ProductVideoVO.a.a(r14.e());
        if (r4 != null) goto L17;
        if (r3 == null) goto L12;
        List r5 = ((WindowV2ProductItemVO) r3).h;
        if (r5 == null) goto L12;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L13:
        if (r6 == null) goto L16;
        ECUrlModel r7 = new ECUrlModel();
        r7.setUri(r6);
        r7.setUrlList(CollectionsKt.listOf(r6));
        Unit r8 = Unit.INSTANCE;
        r1 = new ProductVideoVO(null, r7, 0, null, 1.0d, null);
    L16:
        r4 = r1;
    L12:
        r6 = null;
    L17:
        if (r3 == null) goto L21;
        fo.b r9 = ((WindowV2ProductItemVO) r3).C;
        if (r9 == null) goto L21;
        Integer r10 = (Integer) r9.b(wn.a.f, 210);
    L21:
        Boolean r11 = r14.d();
        Boolean r12 = Boolean.TRUE;
        l r13 = new l(r4, r3, Intrinsics.areEqual(r11, r12), Intrinsics.areEqual(r14.b(), r12));
        if (r3 == null) goto L26;
        fo.b r15 = ((WindowV2ProductItemVO) r3).C;
        if (r15 == null) goto L26;
        com.bytedance.android.window.shop.repository.tab.entity.f r16 = (com.bytedance.android.window.shop.repository.tab.entity.f) r15.b(wn.a.D, r13);
    L26:
        return r13;
    L5:
        WindowV2ProductItemVO.a r17 = WindowV2ProductItemVO.P;
        s r18 = r14.c();
        int r19 = tq3.c.T;
        r3 = tq3.c.a.a(r14.c());
        r17.getClass();
        WindowV2ProductItemVO.a.b(r18, r3);
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((b0) r1);
    }
}
