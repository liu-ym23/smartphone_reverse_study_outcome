package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/q;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$6 extends FunctionReferenceImpl implements Function1<q, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$productSingleTransformers$6(d r8) {
        super(1, r8, d.class, "couponBarDto2Vo", "couponBarDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowCouponItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(q r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((d) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        fo.a<tq3.a> r0 = tq3.a.k;
        if (r2 == null) goto L5;
        List<q.c> r3 = r2.a();
    L6:
        List<q.c> r1 = r3;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        return new tq3.a(CollectionsKt.emptyList());
    L16:
        return new tq3.a(r3);
    L9:
        if (r1.isEmpty() == true) goto L12;
        r4 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((q) r1);
    }
}
