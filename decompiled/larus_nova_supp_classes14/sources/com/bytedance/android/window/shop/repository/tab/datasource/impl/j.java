package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.window.base.repository.dto.q;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParamDeprecated;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.a0;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.android.window.shop.repository.tab.entity.w;
import com.bytedance.android.window.shop.repository.tab.entity.x;
import com.bytedance.android.window.shop.repository.tab.entity.z;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.android.window.shop.repository.tab.datasource.impl.a<WindowProductTabRequestParamDeprecated, com.bytedance.android.window.shop.repository.tab.datasource.d> {
    public boolean f;
    public ShopWindowVODataType g;
    public ShopWindowVODataType h;
    public int i;

    public static final class a {
    }

    static {
    }

    public j() {
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r0 = com.bytedance.android.window.shop.c.b;
        super(com.bytedance.android.window.shop.c.c, new com.bytedance.android.window.shop.repository.tab.datasource.d());
        ShopWindowVODataType r1 = ShopWindowVODataType.PIN;
        this.g = r1;
        this.h = r1;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.impl.a
    public final void f(mq3.a r4, WindowTabDataListResponseDTODeprecated r5) {
        WindowProductTabRequestParamDeprecated r6 = (WindowProductTabRequestParamDeprecated) r4;
        Intrinsics.checkNotNullParameter(r6, "reqParam");
        Intrinsics.checkNotNullParameter(r5, "windowTabDataListResponseDTO");
        super.f(r6, r5);
        List<q> r7 = r5.getSortType();
        q r0 = null;
        Object r1 = null;
        if (r7 == null) goto L11;
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        Object r2 = r8.next();
        if (((q) r2).f() == false) goto L6;
        r1 = r2;
    L10:
        r0 = (q) r1;
    L11:
        if (r0 == null) goto L18;
        r6.setSort(Integer.valueOf(r0.c()));
        r6.setSortType(Long.valueOf(r0.d()));
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.impl.a
    public final void b(WindowTabDataListResponseDTODeprecated r10, List<com.bytedance.android.window.shop.repository.tab.entity.f> r11, com.bytedance.android.window.shop.repository.tab.datasource.c r12) {
        Intrinsics.checkNotNullParameter(r10, "dto");
        Intrinsics.checkNotNullParameter(r11, "voList");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r2 = null;
        if (((com.bytedance.android.window.shop.repository.tab.datasource.d) this.e).b().getPageNum() != 0) goto L86;
        if (((com.bytedance.android.window.shop.repository.tab.datasource.d) this.e).e == false) goto L49;
        com.bytedance.android.window.shop.repository.dto.c r0 = r10.getTopCards();
        if (r0 == null) goto L9;
        Integer r1 = r0.c();
    L10:
        if (r1 == null) goto L14;
        Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r3 = WindowDataMapper.a;
        v r4 = WindowDataMapper.e(r10.getTopCards(), r10.getTopCards().c().intValue());
        if (r4 == null) goto L14;
        r12.y(new n0(CollectionsKt.listOf(r4), getType(), null, 12), ShopWindowVODataType.NORMAL);
    L14:
        int r5 = r10.getStickyArea();
        if (r5 == 0) goto L25;
        if (r5 != 1) goto L18;
        this.f = true;
        ShopWindowVODataType r6 = ShopWindowVODataType.PIN;
        this.g = r6;
        this.h = r6;
    L27:
        if (this.f == false) goto L33;
        List<p> r7 = r10.categories();
        int r8 = x.l;
        x r9 = x.a.a(r7, r10.getSelectCategoryId());
        if (r9 == null) goto L33;
        r12.y(new n0(CollectionsKt.listOf(r9), getType(), null, 12), this.g);
    L33:
        if (r10.getHasMore() == false) goto L35;
    L36:
        List<q> r13 = r10.getSortType();
        if (r13 == null) goto L49;
        WindowLayoutType r14 = ((com.bytedance.android.window.shop.repository.tab.datasource.d) this.e).d;
        if (r14 == null) goto L41;
    L47:
        e0.a r15 = e0.m;
        List<com.bytedance.android.window.shop.repository.dto.a> r16 = r10.getFilterType();
        r15.getClass();
        r12.y(new n0(CollectionsKt.listOf(e0.a.a(r13, r14, r16)), getType(), null, 12), this.h);
        goto L49
    L41:
        if (r10.getLayout() != (-1)) goto L43;
        r14 = com.bytedance.android.window.shop.a.a;
        goto L47
    L43:
        int r17 = r10.getLayout();
        WindowLayoutType r18 = WindowLayoutType.SINGLECOLUMN;
        if (r17 != r18.getType()) goto L46;
        r14 = r18;
        goto L47
    L46:
        r14 = WindowLayoutType.DOUBLECOLUMN;
        goto L47
    L35:
        if (com.bytedance.android.window.shop.repository.tab.datasource.impl.a.e(r10) == false) goto L49;
    L18:
        if (r5 != 2) goto L20;
        this.f = true;
        this.g = ShopWindowVODataType.PIN;
        this.h = ShopWindowVODataType.NORMAL;
        goto L27
    L20:
        if (r5 != 3) goto L27;
        this.f = true;
        this.g = ShopWindowVODataType.NORMAL;
        this.h = ShopWindowVODataType.PIN;
        goto L27
    L25:
        this.f = false;
        this.h = ShopWindowVODataType.PIN;
        goto L27
    L9:
        r1 = null;
    L49:
        if (r10.getHasMore() == true) goto L86;
        if (com.bytedance.android.window.shop.repository.tab.datasource.impl.a.e(r10) == true) goto L86;
        com.bytedance.android.window.shop.repository.tab.entity.f[] r19 = new com.bytedance.android.window.shop.repository.tab.entity.f[1];
        String r20 = ((com.bytedance.android.window.shop.repository.tab.datasource.d) this.e).b().getTargetCategory();
        if (r20 != null) goto L55;
    L58:
        boolean r21 = true;
    L59:
        if (r21 == false) goto L61;
    L64:
        com.bytedance.android.window.shop.repository.tab.entity.f r22 = new z();
    L65:
        r19[0] = r22;
        List r23 = CollectionsKt.mutableListOf(r19);
        List<com.bytedance.android.window.shop.repository.dto.i> r24 = r10.getTabs();
        if (r24 != null) goto L68;
    L70:
        Iterator<T> r25 = r11.iterator();
    L72:
        if (r25.hasNext() == false) goto L79;
        Object r26 = r25.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r26).i != 102) goto L76;
        boolean r27 = true;
    L77:
        if (r27 == false) goto L72;
    L80:
        com.bytedance.android.window.shop.repository.tab.entity.f r28 = (com.bytedance.android.window.shop.repository.tab.entity.f) r26;
        if (r28 == null) goto L84;
        ListProtector.add(r23, 0, r28);
        r11.remove(r28);
    L84:
        r12.y(new n0(r23, getType(), null, 12), ShopWindowVODataType.NORMAL);
        goto L86
    L76:
        r27 = false;
        goto L77
    L79:
        r26 = null;
        goto L80
    L68:
        if (r24.size() != 1) goto L70;
        r12.y(new n0(CollectionsKt.listOf(new w(com.bytedance.android.shopping.extensions.b.b(12))), getType(), null, 12), ShopWindowVODataType.PIN);
        goto L70
    L61:
        if (Intrinsics.areEqual(r20, "-1") == true) goto L64;
        r22 = new a0();
        goto L65
    L55:
        if (StringsKt.isBlank(r20) == true) goto L58;
        r21 = false;
    L86:
        if (((com.bytedance.android.window.shop.repository.tab.datasource.d) this.e).b().getPageNum() != 0) goto L88;
        this.i = 0;
    L88:
        Iterator<T> r29 = r11.iterator();
    L90:
        if (r29.hasNext() == false) goto L120;
        com.bytedance.android.window.shop.repository.tab.entity.f r30 = (com.bytedance.android.window.shop.repository.tab.entity.f) r29.next();
        if ((r30 instanceof b0) == true) goto L94;
        com.bytedance.android.window.shop.repository.tab.entity.f r31 = null;
    L95:
        b0 r32 = (b0) r31;
        if (r32 == null) goto L106;
        tq3.c r33 = r32.j;
        if (r33 == null) goto L106;
        fo.b r34 = ((WindowV2ProductItemVO) r33).C;
        if (r34 == null) goto L106;
        int r35 = this.i + 1;
        this.i = r35;
        fo.a r36 = wn.a.C;
        Integer r37 = r30.b;
        if (r37 == null) goto L104;
        r35 = r37.intValue();
    L104:
        Integer r38 = (Integer) r34.b(r36, Integer.valueOf(r35));
    L106:
        if ((r30 instanceof m) == true) goto L108;
        com.bytedance.android.window.shop.repository.tab.entity.f r39 = null;
    L109:
        m r40 = (m) r39;
        if (r40 == null) goto L90;
        rq3.a r41 = r40.j;
        if (r41 == null) goto L90;
        fo.b r42 = ((WindowV2ProductItemVO) r41).C;
        if (r42 == null) goto L90;
        int r43 = this.i + 1;
        this.i = r43;
        fo.a r44 = wn.a.C;
        Integer r45 = r30.b;
        if (r45 == null) goto L118;
        r43 = r45.intValue();
    L118:
        r42.b(r44, Integer.valueOf(r43));
        goto L90
    L108:
        r39 = r30;
        goto L109
    L94:
        r31 = r30;
        goto L95
    L120:
        if ((!r11.isEmpty()) == false) goto L123;
        r12.y(new n0(r11, getType(), null, 12), ShopWindowVODataType.NORMAL);
    L123:
        if (r10.getHasMore() == true) goto L144;
        com.bytedance.android.window.shop.repository.dto.v r110 = r10.getExtensionCardControl();
        if (r110 == null) goto L127;
        r2 = r110.a();
    L127:
        if (r2 != null) goto L145;
        r12.c(this);
        return;
    L145:
        return;
    }
}
