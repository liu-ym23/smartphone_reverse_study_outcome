package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.n0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uq3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$4 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$4(c r8) {
        super(1, r8, c.class, "liveRecommendProductDto2Vo", "liveRecommendProductDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ((c) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        n0 r6 = (n0) r5;
        int r0 = sq3.f.k;
        Intrinsics.checkNotNullParameter(r6, "dto");
        int r2 = sq3.h.W;
        Intrinsics.checkNotNullParameter(r6, "dto");
        WindowV2ProductItemDTO r3 = r6.a;
        if (r3 == null) goto L5;
        List r4 = r3.e();
    L6:
        sq3.h r1 = new sq3.h(r4);
        WindowV2ProductItemDTO r7 = r6.a;
        if (r7 == null) goto L9;
        WindowV2ProductItemVO.P.getClass();
        WindowV2ProductItemVO.a.b(r7, r1);
    L9:
        r1.V = r6.a();
        com.bytedance.android.window.shop.repository.dto.g r8 = r6.b();
        if (r8 == null) goto L13;
        int r9 = s.c;
        r1.U = s.a.a(r8);
    L13:
        return new sq3.f(r1);
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m920invoke(Object r1) {
        return invoke(r1);
    }
}
