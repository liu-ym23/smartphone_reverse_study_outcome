package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.j0;
import com.bytedance.android.window.shop.repository.tab.entity.w;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/j0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/j0;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$headerTransformers$5 extends FunctionReferenceImpl implements Function1<j0, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$headerTransformers$5(h r8) {
        super(1, r8, h.class, "heightToHeaderMarginVo", "heightToHeaderMarginVo(Lcom/bytedance/android/window/shop/repository/dto/WindowHeaderMarginDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(j0 r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((h) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        Double r5 = r4.a();
        if (r5 == null) goto L5;
        double r1 = r5.doubleValue();
    L7:
        return new w(r1);
    L5:
        r1 = 0.0d;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((j0) r1);
    }
}
