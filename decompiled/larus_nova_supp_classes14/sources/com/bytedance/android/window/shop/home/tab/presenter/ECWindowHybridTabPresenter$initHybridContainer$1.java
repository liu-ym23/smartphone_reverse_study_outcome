package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "p1", "", "p2", "", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/f;I)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowHybridTabPresenter$initHybridContainer$1 extends FunctionReferenceImpl implements Function2<com.bytedance.android.window.shop.repository.tab.entity.f, Integer, Boolean> {
    public ECWindowHybridTabPresenter$initHybridContainer$1(ECWindowHybridTabPresenter r8) {
        super(2, r8, ECWindowHybridTabPresenter.class, "checkHybridListRangeHasDynamicInsertCard", "checkHybridListRangeHasDynamicInsertCard(Lcom/bytedance/android/window/shop/repository/tab/entity/ShopWindowItemVO;I)Z", 0);
    }

    public final boolean invoke(com.bytedance.android.window.shop.repository.tab.entity.f r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ECWindowHybridTabPresenter r0 = (ECWindowHybridTabPresenter) ((CallableReference) this).receiver;
        if (r7 > 0) goto L5;
        r0.getClass();
        return com.bytedance.android.window.shop.repository.tab.entity.s.b(r6);
    L5:
        com.bytedance.android.ec.hybrid.list.entity.k r1 = r0.e0().c.g;
        if (r1 == null) goto L45;
        ArrayList r2 = r1.c;
        if (r2 == null) goto L45;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        ArrayList r5 = ((com.bytedance.android.ec.hybrid.list.entity.i) r4.next()).i;
        if (r5 != null) goto L15;
        r5 = new ArrayList();
    L15:
        CollectionsKt.addAll(r3, r5);
        goto L11
    L16:
        Iterator r8 = r3.iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((ECHybridListItemVO) r8.next()).d(), r6) == true) goto L24;
        r9 = r9 + 1;
    L24:
        if (r9 < 0) goto L45;
        int r10 = RangesKt.coerceAtLeast(r9 - r7, 0);
        int r11 = RangesKt.coerceAtMost(r9 + r7, r3.size());
        if (r11 <= r10) goto L43;
    L29:
        if (r10 >= r11) goto L45;
        ECHybridListItemVO r12 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r10);
        Object r13 = null;
        if (r12 == null) goto L33;
        Object r14 = c0.c(r12);
    L35:
        if ((r14 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == false) goto L38;
        r13 = r14;
    L38:
        com.bytedance.android.window.shop.repository.tab.entity.f r15 = (com.bytedance.android.window.shop.repository.tab.entity.f) r13;
        if (r15 == null) goto L44;
        if (com.bytedance.android.window.shop.repository.tab.entity.s.b(r15) == true) goto L43;
    L44:
        r10 = r10 + 1;
        goto L29
    L33:
        r14 = null;
    L43:
        return true;
    L23:
        r9 = -1;
    L45:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return Boolean.valueOf(invoke((com.bytedance.android.window.shop.repository.tab.entity.f) r1, ((Number) r2).intValue()));
    }
}
