package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.m0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$1 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$1(c r8) {
        super(1, r8, c.class, "liveHotProductDto2Vo", "liveHotProductDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((c) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        m0 r5 = (m0) r4;
        int r0 = sq3.b.n;
        int r1 = sq3.h.W;
        sq3.h r2 = sq3.h.a.a(r5);
        ((WindowV2ProductItemVO) r2).y = r5.b();
        ((WindowV2ProductItemVO) r2).C.b(wn.a.C, Integer.valueOf(r5.b()));
        Unit r6 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "vo");
        return new sq3.b(r2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m917invoke(Object r1) {
        return invoke(r1);
    }
}
