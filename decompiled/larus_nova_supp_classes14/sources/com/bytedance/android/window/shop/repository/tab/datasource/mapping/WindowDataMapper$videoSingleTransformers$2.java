package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.d1;
import com.bytedance.android.window.shop.repository.tab.entity.c0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d1;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "invoke", "(Lcom/bytedance/android/window/shop/repository/dto/d1;)Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$videoSingleTransformers$2 extends FunctionReferenceImpl implements Function1<d1, com.bytedance.android.window.shop.repository.tab.entity.f> {
    public WindowDataMapper$videoSingleTransformers$2(e r8) {
        super(1, r8, e.class, "videoCardNotHangingDto2Vo", "videoCardNotHangingDto2Vo(Lcom/bytedance/android/window/shop/repository/dto/WindowVideoItemDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;", 0);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f invoke(d1 r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((e) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        int r0 = c0.s;
        return c0.a.a(202, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((d1) r1);
    }
}
