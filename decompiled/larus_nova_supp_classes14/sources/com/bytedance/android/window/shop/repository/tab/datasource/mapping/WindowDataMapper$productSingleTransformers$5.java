package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.c1;
import com.bytedance.android.window.shop.repository.tab.entity.h0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c1;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/c1;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$5 extends FunctionReferenceImpl implements Function1<c1, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$productSingleTransformers$5(d r8) {
        super(1, r8, d.class, "storeEntranceDto2Vo", "storeEntranceDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowStoreEntranceDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(c1 r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((d) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = h0.m;
        Intrinsics.checkNotNullParameter(r4, "dto");
        return new h0(r4.a(), r4.b(), r4.c());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((c1) r1);
    }
}
