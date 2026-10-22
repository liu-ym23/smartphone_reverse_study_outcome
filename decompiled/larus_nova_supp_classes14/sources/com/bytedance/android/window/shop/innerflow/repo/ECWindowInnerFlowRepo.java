package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import up3.f;
import up3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowRepo {
    public final b<g, vp3.b> a;
    public final com.bytedance.android.window.shop.repository.tab.datasource.impl.g b;
    public final ECWindowInnerFlowReqParam c;
    public final ECWindowInnerFlowRemoteDataSource d;
    public final MutexImpl e;

    public ECWindowInnerFlowRepo() {
        this.a = new b(MapsKt.mapOf(TuplesKt.to(602, new Pair(f.class, new ECWindowInnerFlowRepo$mixDataTransformer$1(a.a)))));
        ECWindowInnerFlowRemoteDataSource r0 = new ECWindowInnerFlowRemoteDataSource();
        this.b = new com.bytedance.android.window.shop.repository.tab.datasource.impl.g();
        this.c = new ECWindowInnerFlowReqParam();
        this.d = r0;
        this.e = kotlinx.coroutines.sync.b.a();
    }

    public final Object b(Continuation<? super e<List<vp3.b>>> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECWindowInnerFlowRepo$getInnerFlowData$2(this, null), r4);
    }

    public final Object d(Continuation<? super vp3.a> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECWindowInnerFlowRepo$getShopCartInfo$2(this, null), r4);
    }

    public static final void a(ECWindowInnerFlowRepo r4, List r5) {
        r4.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((vp3.b) r6.next()).getClass();
        goto L4
    L6:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((vp3.b) r1.next()).getClass();
        r7.add(null);
        goto L8
    L10:
        List r8 = CollectionsKt.toMutableList(r7);
        String r2 = r4.c.getCustomId();
        if (r2 == null) goto L13;
        r8.add(r2);
        r4.c.setCustomId(null);
        r4.c.setPromotionId(null);
    L13:
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L24;
        String r3 = (String) r9.next();
        StringBuilder r10 = r4.c.getFilterPromotionIds();
        if (r4.c.getFilterPromotionIds().length() != 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L23;
        r3 = "," + r3;
    L23:
        r10.append(r3);
        goto L15
    L19:
        r11 = false;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final Object c(ECWindowInnerFlowReqParam r9, Continuation<? super ECShopInnerFlowDTO> r10) {
        if ((r10 instanceof ECWindowInnerFlowRepo$getInnerFlowDataSafely$1) == false) goto L7;
        ECWindowInnerFlowRepo$getInnerFlowDataSafely$1 r0 = (ECWindowInnerFlowRepo$getInnerFlowDataSafely$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ?? r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L35:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (ECWindowInnerFlowReqParam) r0.L$1;
        ECWindowInnerFlowRepo r5 = (ECWindowInnerFlowRepo) r0.L$0;
        ResultKt.throwOnFailure(r11);
        ?? r12 = r11;
    L20:
        r11 = (ECShopInnerFlowDTO) r12;
        if (r11 != 0) goto L24;
        return null;
    L24:
        if (r11.getHasMore() == false) goto L35;
        List<g> r6 = r11.getMixCards();
        if (r6 != null) goto L28;
    L31:
        if (r4 == false) goto L35;
        r9.setPageNum(r11.getCursor());
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r11 = r5.c(r9, r0);
        if (r11 != r2) goto L35;
        return r2;
    L28:
        if (r6.isEmpty() == true) goto L31;
        r4 = false;
        goto L31
    L16:
        ResultKt.throwOnFailure(r11);
        ECWindowInnerFlowRemoteDataSource r13 = this.d;
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.label = 1;
        Object r14 = r13.a(r9, r0);
        if (r14 != r2) goto L19;
        return r2;
    L19:
        r5 = this;
        r12 = r14;
    L7:
        r0 = new ECWindowInnerFlowRepo$getInnerFlowDataSafely$1(this, r10);
        goto L8
    }
}
