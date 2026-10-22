package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.hybrid.list.entity.j;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.q;
import com.bytedance.android.window.shop.repository.tab.entity.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/r;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/q;", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/r;)Lcom/bytedance/android/window/shop/repository/tab/entity/q;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$2 extends FunctionReferenceImpl implements Function1<r, q> {
    public WindowDataMapper$customSingleTransformers$2(q.a r8) {
        super(1, r8, q.a.class, "create", "create(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowHybridToolbarDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowHybridToolBarVO;", 0);
    }

    public final q invoke(r r12) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        ((q.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r12, "dto");
        q r1 = new q();
        e0.a r2 = e0.m;
        List<com.bytedance.android.ec.window.base.repository.dto.q> r3 = r12.e();
        if (r3 != null) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        WindowLayoutType.a r4 = WindowLayoutType.Companion;
        Integer r5 = r12.d();
        r4.getClass();
        WindowLayoutType r6 = WindowLayoutType.a.a(r5);
        if (r6 != null) goto L8;
        r6 = WindowLayoutType.SINGLECOLUMN;
    L8:
        List<com.bytedance.android.window.shop.repository.dto.a> r7 = r12.b();
        r2.getClass();
        r1.j = e0.a.a(r3, r6, r7);
        Map<String, Map<Integer, ECHybridListStyleDTO>> r8 = r12.c();
        boolean r9 = true;
        if (r8 == null) goto L27;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<Integer, ECHybridListStyleDTO>>> r11 = r8.entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L26;
        Map.Entry<String, Map<Integer, ECHybridListStyleDTO>> r13 = r11.next();
        String r14 = r13.getKey();
        Map<Integer, ECHybridListStyleDTO> r15 = r13.getValue();
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, ECHybridListStyleDTO>> r17 = r15.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L24;
        Map.Entry<Integer, ECHybridListStyleDTO> r18 = r17.next();
        int r19 = r18.getKey().intValue();
        ECHybridListStyleDTO r20 = r18.getValue();
        WindowLayoutType.a r110 = WindowLayoutType.Companion;
        Integer r21 = Integer.valueOf(r19);
        r110.getClass();
        WindowLayoutType r22 = WindowLayoutType.a.a(r21);
        if (r22 == null) goto L15;
        ECHybridListStyleDTO.Companion.getClass();
        j r23 = ECHybridListStyleDTO.a.a(r20);
        if (r23 == null) goto L15;
        r16.put(r22, r23);
        goto L15
    L24:
        if ((!r16.isEmpty()) == false) goto L12;
        r10.put(r14, r16);
        goto L12
    L26:
        r1.k = r10;
    L27:
        int r24 = i0.m;
        List<p> r25 = r12.f();
        if (r25 != null) goto L30;
        r25 = CollectionsKt.emptyList();
    L30:
        WindowChildCategoryVO r26 = null;
        r1.l = i0.a.a(r25, null);
        int r27 = WindowChildCategoryVO.b;
        List<com.bytedance.android.window.shop.repository.tab.entity.a> r111 = r12.a();
        if (r111 != null) goto L33;
        r111 = CollectionsKt.emptyList();
    L33:
        List<com.bytedance.android.window.shop.repository.tab.entity.a> r28 = r111;
        if (r28 != null) goto L36;
    L39:
        if (r9 == true) goto L64;
        ArrayList r29 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L43:
        if (r112.hasNext() == false) goto L61;
        com.bytedance.android.window.shop.repository.tab.entity.a r30 = (com.bytedance.android.window.shop.repository.tab.entity.a) r112.next();
        WindowChildCategoryVO.ChildCategoryVO.Companion.getClass();
        Intrinsics.checkNotNullParameter(r30, "dto");
        if (r30.a() == null) goto L52;
        WindowChildCategoryVO.ChildCategoryItemVO.a r31 = WindowChildCategoryVO.ChildCategoryItemVO.Companion;
        com.bytedance.android.window.shop.repository.tab.entity.b r32 = r30.c();
        r31.getClass();
        WindowChildCategoryVO.ChildCategoryItemVO r33 = WindowChildCategoryVO.ChildCategoryItemVO.a.a(r32);
        if (r33 == null) goto L52;
        WindowChildCategoryVO.ChildCategoryItemVO r34 = WindowChildCategoryVO.ChildCategoryItemVO.a.a(r30.d());
        if (r34 == null) goto L52;
        Boolean r35 = r30.b();
        if (r35 == null) goto L56;
        boolean r36 = r35.booleanValue();
    L57:
        WindowChildCategoryVO.ChildCategoryVO r37 = new WindowChildCategoryVO.ChildCategoryVO(r33, r34, r36, r30.a());
    L58:
        if (r37 == null) goto L43;
        r29.add(r37);
        goto L43
    L56:
        r36 = false;
    L52:
        r37 = null;
        goto L58
    L61:
        if (r29.isEmpty() == true) goto L64;
        r26 = new WindowChildCategoryVO(r29);
    L64:
        r1.m = r26;
        return r1;
    L36:
        if (r28.isEmpty() == true) goto L39;
        r9 = false;
        goto L39
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((r) r1);
    }
}
