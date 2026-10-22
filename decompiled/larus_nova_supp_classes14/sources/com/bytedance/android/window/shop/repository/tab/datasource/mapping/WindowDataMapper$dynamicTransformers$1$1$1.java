package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/h$b;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/h$b;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$dynamicTransformers$1$1$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.window.shop.repository.tab.entity.h.b, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$dynamicTransformers$1$1$1(d r8) {
        super(1, r8, d.class, "dynamicDto2Vo", "dynamicDto2Vo(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowDynamicItemVO$ShopWindowDynamicItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(com.bytedance.android.window.shop.repository.tab.entity.h.b r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ((d) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        int r0 = com.bytedance.android.window.shop.repository.tab.entity.h.m;
        Intrinsics.checkNotNullParameter(r6, "dto");
        Integer r1 = r6.b();
        if (r1 == null) goto L16;
        int r2 = r1.intValue();
        String r3 = r6.c();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        WindowDynamicViewCache r5 = WindowDynamicViewCache.g;
        String r7 = r6.e();
        r5.getClass();
        k r8 = WindowDynamicViewCache.c(r7);
    L14:
        if (r8 == null) goto L16;
        int r9 = to.d.c;
        to.d r10 = to.d.a.a(r6.d());
        int r11 = to.b.b;
        return new com.bytedance.android.window.shop.repository.tab.entity.h(r2, r8, r10, to.b.a.a(r6.a()));
    L13:
        WindowDynamicViewCache r12 = WindowDynamicViewCache.g;
        String r13 = r6.c();
        r12.getClass();
        r8 = WindowDynamicViewCache.b(r13);
        goto L14
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
    L16:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.bytedance.android.window.shop.repository.tab.entity.h.b) r1);
    }
}
