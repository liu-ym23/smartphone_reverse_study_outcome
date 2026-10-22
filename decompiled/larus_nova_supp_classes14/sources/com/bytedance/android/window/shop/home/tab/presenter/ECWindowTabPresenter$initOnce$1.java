package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0015\u0010\u0004\u001a\u00110\u0000¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u00032\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lkotlin/ParameterName;", "name", "vo", "p1", "", "siblingSize", "p2", "", "", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/f;I)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowTabPresenter$initOnce$1 extends FunctionReferenceImpl implements Function2<com.bytedance.android.window.shop.repository.tab.entity.f, Integer, List<? extends String>> {
    public ECWindowTabPresenter$initOnce$1(WindowTypeSeparatedAdapter r8) {
        super(2, r8, WindowTypeSeparatedAdapter.class, "getSurroundedProductIds", "getSurroundedProductIds(Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;I)Ljava/util/List;", 0);
    }

    public final List<String> invoke(com.bytedance.android.window.shop.repository.tab.entity.f r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        WindowTypeSeparatedAdapter r0 = (WindowTypeSeparatedAdapter) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "vo");
        int r8 = ((ArrayList) r0.h).indexOf(r6);
        if (r8 < 0) goto L25;
        int r2 = 0;
        int r1 = RangesKt.coerceAtLeast(r8 - r7, 0);
        int r9 = RangesKt.coerceAtMost(r8 + r7, ((ArrayList) r0.h).size());
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r10 = r0.h;
        ArrayList r3 = new ArrayList();
        Iterator r11 = ((ArrayList) r10).iterator();
    L7:
        if (r11.hasNext() == false) goto L21;
        Object r4 = r11.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.bytedance.android.window.shop.repository.tab.entity.f r12 = (com.bytedance.android.window.shop.repository.tab.entity.f) r4;
        if (r1 > r2) goto L16;
        if (r9 <= r2) goto L16;
        String r13 = r12.b();
    L17:
        if (r13 == null) goto L19;
        r3.add(r13);
    L19:
        r2 = r5;
    L16:
        r13 = null;
        goto L17
    L21:
        return r3;
    L25:
        return CollectionsKt.emptyList();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.bytedance.android.window.shop.repository.tab.entity.f) r1, ((Number) r2).intValue());
    }
}
