package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final Set<Integer> a = null;
    public static final Set<Integer> b = null;

    public static final class a<DTO, VO extends com.bytedance.android.window.shop.repository.tab.entity.f> {
        public final int a;
        public final Class<DTO> b;
        public final Function1<DTO, VO> c;
        public final Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> d;

        public final int getType() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(int r2, Class<DTO> r3, Function1<? super DTO, ? extends VO> r4, Function2<? super Fragment, ? super fo.b, ? extends ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> r5) {
            Intrinsics.checkNotNullParameter(r3, "dtoClazz");
            Intrinsics.checkNotNullParameter(r4, "transformer");
            Intrinsics.checkNotNullParameter(r5, "creator");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = SetsKt.setOf(new Integer[]{3002, 2503, 3003, 3004, 3005});
        Set r0 = SetsKt.setOf(new Integer[]{101, 103, 504, 208, 209, 210});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(gr3.f.a(((Number) r2.next()).intValue())));
        goto L4
    L6:
        b = CollectionsKt.toSet(r1);
    }

    public static void a(Fragment r10, fo.b r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "sceneId");
        Map<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r0 = i.b.b();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<Integer, Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>>> r3 = r2.next();
        int r4 = r3.getKey().intValue();
        final Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> r5 = r3.getValue();
        r1.put(Integer.valueOf(r4), new WindowHybridHolderCreatorSource$ensureLayoutParamsRight$1(r5));
        goto L4
    L6:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r8 = (Map.Entry) r7.next();
        int r9 = ((Number) r8.getKey()).intValue();
        Function2 r13 = (Function2) r8.getValue();
        com.bytedance.android.window.shop.repository.tab.datasource.mapping.f r14 = WindowDataMapper.g.get(Integer.valueOf(r9));
        if (r14 != null) goto L12;
        a r15 = null;
    L13:
        if (r15 == null) goto L8;
        r6.add(r15);
        goto L8
    L12:
        r15 = new a(r9, r14.a, r14.b, r13);
        goto L13
    L15:
        Iterator r16 = r6.iterator();
    L17:
        if (r16.hasNext() == false) goto L47;
        a r17 = (a) r16.next();
        Function2<Fragment, fo.b, ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> r18 = r17.d;
        int r19 = r17.getType();
        Set<Integer> r20 = a;
        if (r20.contains(Integer.valueOf(r19)) == false) goto L21;
        r0 r21 = new e(r18, r10, r11);
    L22:
        Function1<DTO, VO> r22 = r17.c;
        if (r22 == 0) goto L46;
        Function1 r23 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r22, 1);
        Class<DTO> r24 = r17.b;
        if (r20.contains(Integer.valueOf(r17.getType())) == false) goto L27;
        Object r25 = new f(r24, r23);
    L28:
        IntRange r26 = gr3.f.a;
        int r27 = gr3.f.a(r17.getType());
        List r28 = CollectionsKt.listOf(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L30:
        if (r30.hasNext() == false) goto L40;
        boolean r31 = ((Boolean) r30.next()).booleanValue();
        IntRange r32 = gr3.f.a;
        Integer r33 = Integer.valueOf(r27);
        if (r33 == null) goto L34;
        int r34 = r33.intValue();
    L36:
        if (gr3.f.a.contains(r34) == false) goto L38;
        gr3.f.a r35 = gr3.f.d;
    L39:
        r29.add(Integer.valueOf(r35.a(r34, r31)));
        goto L30
    L38:
        r35 = gr3.f.c;
        goto L39
    L34:
        r34 = 3000;
        goto L36
    L40:
        LinkedHashMap r36 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r29, 10)), 16));
        Iterator r37 = r29.iterator();
    L42:
        if (r37.hasNext() == false) goto L44;
        Object r38 = r37.next();
        ((Number) r38).intValue();
        r36.put(r38, r21);
        goto L42
    L44:
        ECHybridListEngine.Companion r39 = ECHybridListEngine.x;
        Pair r40 = TuplesKt.to(Integer.valueOf(r27), r25);
        r39.getClass();
        ECHybridListEngine.Companion.d(r12, r10, r40, r36);
        goto L17
    L27:
        r25 = new WindowHybridHolderCreatorSource$makeTransformedModelTransformer$1(r24, r23);
        goto L28
    L46:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any) -> com.bytedance.android.window.shop.repository.tab.entity.ShopWindowItemVO");
    L21:
        r21 = new g(r18, r10, r11);
        goto L22
    }
}
