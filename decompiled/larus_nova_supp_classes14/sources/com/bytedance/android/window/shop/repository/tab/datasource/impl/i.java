package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.ec.window.base.repository.dto.q;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.WindowForceDoFrameMessage;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.a0;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.android.window.shop.repository.tab.entity.w;
import com.bytedance.android.window.shop.repository.tab.entity.z;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.android.window.shop.repository.tab.datasource.impl.a<WindowProductTabRequestParam, com.bytedance.android.window.shop.repository.tab.datasource.g> {
    public final ShopWindowVODataType f;
    public int g;
    public final String h;

    public static final class a {
    }

    static {
    }

    public i(String r2, com.bytedance.android.window.shop.c r3) {
        Intrinsics.checkNotNullParameter(r3, "shopWindowContentType");
        super(r3, new com.bytedance.android.window.shop.repository.tab.datasource.g());
        this.h = r2;
        ((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b().setTargetCategory(r2);
        this.f = ShopWindowVODataType.PIN;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.impl.a
    public final void f(mq3.a r4, WindowTabDataListResponseDTODeprecated r5) {
        WindowProductTabRequestParam r6 = (WindowProductTabRequestParam) r4;
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
        WindowDynamicViewCache.g.d(r10.getDynamicViews());
        if (((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b().getPageNum() != 0) goto L76;
        if (((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).d == false) goto L35;
        com.bytedance.android.window.shop.repository.dto.c r0 = r10.getTopCards();
        if (r0 == null) goto L9;
        Integer r1 = r0.c();
    L10:
        if (r1 == null) goto L14;
        Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r2 = WindowDataMapper.a;
        v r3 = WindowDataMapper.e(r10.getTopCards(), r10.getTopCards().c().intValue());
        if (r3 == null) goto L14;
        r12.y(new n0(CollectionsKt.listOf(r3), getType(), null, 12), ShopWindowVODataType.NORMAL);
    L14:
        List<p> r4 = r10.getSubCategorys();
        if (r4 == null) goto L21;
        int r5 = i0.m;
        i0 r6 = i0.a.a(r4, r10.getSelectSubCategory());
        if (r6 != null) goto L19;
        return;
    L19:
        r12.y(new n0(CollectionsKt.listOf(r6), getType(), null, 12), ShopWindowVODataType.NORMAL);
    L21:
        if (r10.getHasMore() == false) goto L23;
    L24:
        List<q> r7 = r10.getSortType();
        if (r7 == null) goto L35;
        if (r10.getLayout() != (-1)) goto L29;
        WindowLayoutType r8 = com.bytedance.android.window.shop.a.a;
    L33:
        e0.a r9 = e0.m;
        List<com.bytedance.android.window.shop.repository.dto.a> r13 = r10.getFilterType();
        r9.getClass();
        r12.y(new n0(CollectionsKt.listOf(e0.a.a(r7, r8, r13)), getType(), null, 12), this.f);
        goto L35
    L29:
        int r14 = r10.getLayout();
        WindowLayoutType r15 = WindowLayoutType.SINGLECOLUMN;
        if (r14 != r15.getType()) goto L32;
        r8 = r15;
        goto L33
    L32:
        r8 = WindowLayoutType.DOUBLECOLUMN;
        goto L33
    L23:
        if (com.bytedance.android.window.shop.repository.tab.datasource.impl.a.e(r10) == false) goto L35;
    L9:
        r1 = null;
    L35:
        if (r10.getHasMore() == true) goto L76;
        if (com.bytedance.android.window.shop.repository.tab.datasource.impl.a.e(r10) == true) goto L76;
        if (r10.getHideEmptyStatus() == true) goto L76;
        com.bytedance.android.window.shop.repository.tab.entity.f[] r16 = new com.bytedance.android.window.shop.repository.tab.entity.f[1];
        String r17 = ((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b().getTargetCategory();
        if (r17 != null) goto L43;
    L46:
        boolean r18 = true;
    L47:
        if (r18 == false) goto L49;
    L54:
        com.bytedance.android.window.shop.repository.tab.entity.f r19 = new z();
    L55:
        r16[0] = r19;
        List r20 = CollectionsKt.mutableListOf(r16);
        List<com.bytedance.android.window.shop.repository.dto.i> r21 = r10.getTabs();
        if (r21 != null) goto L58;
    L60:
        Iterator<T> r22 = r11.iterator();
    L62:
        if (r22.hasNext() == false) goto L69;
        Object r23 = r22.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r23).i != 102) goto L66;
        boolean r24 = true;
    L67:
        if (r24 == false) goto L62;
    L70:
        com.bytedance.android.window.shop.repository.tab.entity.f r25 = (com.bytedance.android.window.shop.repository.tab.entity.f) r23;
        if (r25 == null) goto L74;
        ListProtector.add(r20, 0, r25);
        r11.remove(r25);
    L74:
        r12.y(new n0(r20, getType(), null, 12), ShopWindowVODataType.NORMAL);
        goto L76
    L66:
        r24 = false;
        goto L67
    L69:
        r23 = null;
        goto L70
    L58:
        if (r21.size() != 1) goto L60;
        r12.y(new n0(CollectionsKt.listOf(new w(com.bytedance.android.shopping.extensions.b.b(12))), getType(), null, 12), ShopWindowVODataType.PIN);
        goto L60
    L49:
        if (Intrinsics.areEqual(r17, "-1") == true) goto L54;
        if (getType().getType() != 100) goto L54;
        r19 = new a0();
        goto L55
    L43:
        if (StringsKt.isBlank(r17) == true) goto L46;
        r18 = false;
    L76:
        if (((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b().getPageNum() != 0) goto L78;
        this.g = 0;
    L78:
        Iterator<T> r26 = r11.iterator();
    L80:
        if (r26.hasNext() == false) goto L139;
        com.bytedance.android.window.shop.repository.tab.entity.f r27 = (com.bytedance.android.window.shop.repository.tab.entity.f) r26.next();
        if ((r27 instanceof b0) == true) goto L84;
        com.bytedance.android.window.shop.repository.tab.entity.f r28 = null;
    L85:
        b0 r29 = (b0) r28;
        if (r29 == null) goto L96;
        tq3.c r30 = r29.j;
        if (r30 == null) goto L96;
        fo.b r31 = ((WindowV2ProductItemVO) r30).C;
        if (r31 == null) goto L96;
        int r32 = this.g + 1;
        this.g = r32;
        fo.a r33 = wn.a.C;
        Integer r34 = r27.b;
        if (r34 == null) goto L94;
        r32 = r34.intValue();
    L94:
        r31.b(r33, Integer.valueOf(r32));
    L96:
        if ((r27 instanceof com.bytedance.android.window.shop.repository.tab.entity.p) == true) goto L98;
        com.bytedance.android.window.shop.repository.tab.entity.f r35 = null;
    L99:
        com.bytedance.android.window.shop.repository.tab.entity.p r36 = (com.bytedance.android.window.shop.repository.tab.entity.p) r35;
        if (r36 == null) goto L110;
        WindowV2ProductItemVO r37 = r36.k;
        if (r37 == null) goto L110;
        fo.b r38 = r37.C;
        if (r38 == null) goto L110;
        int r39 = this.g + 1;
        this.g = r39;
        fo.a r40 = wn.a.C;
        Integer r41 = r27.b;
        if (r41 == null) goto L108;
        r39 = r41.intValue();
    L108:
        r38.b(r40, Integer.valueOf(r39));
    L110:
        if ((r27 instanceof m) == true) goto L112;
        com.bytedance.android.window.shop.repository.tab.entity.f r42 = null;
    L113:
        m r43 = (m) r42;
        if (r43 == null) goto L126;
        rq3.a r44 = r43.j;
        if (r44 == null) goto L126;
        fo.b r45 = ((WindowV2ProductItemVO) r44).C;
        if (r45 == null) goto L126;
        fo.a r46 = wn.a.C;
        if (r45.a(r46) != null) goto L80;
        int r47 = this.c + 1;
        this.c = r47;
        Integer r48 = r27.b;
        if (r48 == null) goto L125;
        r47 = r48.intValue();
    L125:
        Integer r49 = (Integer) r45.b(r46, Integer.valueOf(r47));
    L126:
        WindowV2ProductItemVO r50 = r27.c();
        if (r50 == null) goto L80;
        fo.b r51 = r50.C;
        if (r51 == null) goto L80;
        fo.a r52 = wn.a.C;
        if (r51.a(r52) != null) goto L80;
        this.g++;
        Integer r53 = r27.b;
        if (r53 == null) goto L136;
        int r54 = r53.intValue();
    L137:
        Integer r55 = (Integer) r51.b(r52, Integer.valueOf(r54));
        goto L80
    L136:
        r54 = this.c;
        goto L137
    L112:
        r42 = r27;
        goto L113
    L98:
        r35 = r27;
        goto L99
    L84:
        r28 = r27;
        goto L85
    L139:
        if ((!r11.isEmpty()) == false) goto L142;
        r12.f(r10, ((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b());
        r12.y(new n0(r11, getType(), null, 12), ShopWindowVODataType.NORMAL);
    L142:
        if (r10.getHasMore() == true) goto L150;
        com.bytedance.android.window.shop.repository.dto.v r110 = r10.getExtensionCardControl();
        if (r110 != null) goto L146;
    L147:
        r12.c(this);
        return;
    L146:
        if (r110.b() != true) goto L147;
    L150:
        if (((com.bytedance.android.window.shop.repository.tab.datasource.g) this.e).b().getPageNum() == 0) goto L152;
        return;
    L152:
        if (yq3.a.d() != 1) goto L187;
        WindowForceDoFrameMessage.a();
        return;
    }
}
