package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0015\u0010\u0004\u001a\u00110\u0000¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lkotlin/ParameterName;", "name", "vo", "p1", "", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/f;)I", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowTabPresenter$initOnce$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.window.shop.repository.tab.entity.f, Integer> {
    public ECWindowTabPresenter$initOnce$2(WindowTypeSeparatedAdapter r8) {
        super(1, r8, WindowTypeSeparatedAdapter.class, "getNearestDynamicInsertDistance", "getNearestDynamicInsertDistance(Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;)I", 0);
    }

    public final int invoke(com.bytedance.android.window.shop.repository.tab.entity.f r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        WindowTypeSeparatedAdapter r0 = (WindowTypeSeparatedAdapter) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "vo");
        if (com.bytedance.android.window.shop.repository.tab.entity.s.b(r7) == false) goto L5;
        return 0;
    L5:
        int r8 = ((ArrayList) r0.h).indexOf(r7);
        if (r8 >= 0) goto L8;
    L7:
        return Integer.MAX_VALUE;
    L8:
        int r2 = ((ArrayList) r0.h).size();
        int r3 = 1;
    L9:
        int r4 = r2 / 2;
        if (r3 < 0) goto L7;
        if (r4 < r3) goto L7;
        int r5 = r8 - r3;
        if (r5 >= 0) goto L16;
    L18:
        int r6 = r8 + r3;
        if (r6 >= r2) goto L23;
        if (com.bytedance.android.window.shop.repository.tab.entity.s.b((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(r0.h, r6)) == false) goto L23;
    L32:
        return r3;
    L23:
        r3 = r3 + 1;
        goto L9
    L16:
        if (com.bytedance.android.window.shop.repository.tab.entity.s.b((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(r0.h, r5)) == false) goto L18;
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Integer.valueOf(invoke((com.bytedance.android.window.shop.repository.tab.entity.f) r1));
    }
}
