package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.u;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/u;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/u;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$discoverySingleTransformers$1 extends FunctionReferenceImpl implements Function1<u, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$discoverySingleTransformers$1(b r8) {
        super(1, r8, b.class, "feedProductDto2Vo", "feedProductDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowExploreFeedProductDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(u r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((b) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = m.k;
        Intrinsics.checkNotNullParameter(r4, "dto");
        WindowV2ProductItemVO.a r1 = WindowV2ProductItemVO.P;
        rq3.a r2 = new rq3.a(r4.T());
        r1.getClass();
        WindowV2ProductItemVO.a.b(r4, r2);
        m r5 = new m(r2);
        ((WindowV2ProductItemVO) r2).C.d(wn.a.D, r5);
        fo.b r3 = ((WindowV2ProductItemVO) r5.j).C;
        r3.b(wn.a.d, "discover");
        r3.b(wn.a.e, String.valueOf(402));
        return r5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((u) r1);
    }
}
