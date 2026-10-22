package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$liveHotSingleTransformers$3 extends FunctionReferenceImpl implements Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$liveHotSingleTransformers$3(c r8) {
        super(1, r8, c.class, "liveAppointmentDto2Vo", "liveAppointmentDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ((c) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        int r0 = sq3.g.n;
        com.bytedance.android.window.shop.repository.dto.h r4 = (com.bytedance.android.window.shop.repository.dto.h) r3;
        Intrinsics.checkNotNullParameter(r4, "dto");
        sq3.g r1 = new sq3.g();
        r4.getClass();
        r1.j = r4.d();
        r1.k = r4.a();
        r1.l = r4.c();
        r1.m = r4.b();
        return r1;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m919invoke(Object r1) {
        return invoke(r1);
    }
}
