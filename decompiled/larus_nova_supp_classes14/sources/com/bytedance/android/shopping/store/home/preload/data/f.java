package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.api.TabStyle;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.hybrid.l;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridDataTransformer;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridHolderCreatorSource;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt;
import com.bytedance.android.shopping.store.hybridproduct.extension.p;
import com.bytedance.android.shopping.store.hybridproduct.holder.creator.ECShopHybridHolderFactory;
import com.bytedance.android.shopping.store.hybridproduct.l0;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.model.t;
import com.bytedance.android.shopping.store.tabkit.model.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import uj3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ECStoreHomeTabResponseTabkit r9) {
        Intrinsics.checkNotNullParameter(r9, "response");
        if (ShopHybridHolderCreatorSource.a == true) goto L22;
        Map r0 = ShopHybridHolderCreatorSource.a(ECShopHybridHolderFactory.a);
        ArrayList r3 = new ArrayList();
        Iterator r1 = ((LinkedHashMap) r0).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r1.next();
        int r5 = ((Number) r4.getKey()).intValue();
        Function5 r6 = (Function5) r4.getValue();
        boolean r7 = ShopHybridHolderCreatorSource.a;
        p r8 = ShopHybridDataTransformer.a.get(Integer.valueOf(r5));
        if (r8 != null) goto L10;
        ShopHybridHolderCreatorSource.a r10 = null;
    L11:
        if (r10 == null) goto L6;
        r3.add(r10);
        goto L6
    L10:
        r10 = new ShopHybridHolderCreatorSource.a(r5, r8.a, r8.b, r6);
        goto L11
    L13:
        Iterator r2 = r3.iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        ShopHybridHolderCreatorSource.a r11 = (ShopHybridHolderCreatorSource.a) r2.next();
        Function2<DTO, String, VO> r12 = r11.c;
        if (r12 == 0) goto L20;
        com.bytedance.android.shopping.store.hybridproduct.extension.c r13 = new com.bytedance.android.shopping.store.hybridproduct.extension.c(r11.b, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 2));
        ECHybridListEngine.Companion r14 = ECHybridListEngine.x;
        int r15 = r11.getType();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "transformer");
        ECHybridListEngine.w.put(Integer.valueOf(r15), r13);
        goto L15
    L20:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any, kotlin.String?) -> com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridItemVO");
    L21:
        ShopHybridHolderCreatorSource.a = true;
    L22:
        z r16 = r9.getTabkitResponse();
        if (r16 == null) goto L33;
        int r17 = t.a;
        ECShopABSettings.k.getClass();
        t.g(r16, null, !((Boolean) ECShopABSettings.i.getValue()).booleanValue());
        return;
    }

    public static void b(j r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = h.a;
        int r1 = h.b(r6.g, r6.C).getType();
        ECHybridListDTO r2 = r6.H;
        if (r2 == null) goto L12;
        List r3 = r2.getSections();
        if (r3 == null) goto L12;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ECHybridListSectionDTO r5 = (ECHybridListSectionDTO) r4.next();
        l0.b(r5, r1);
        l0.d(r5, r1);
    L12:
        ECHybridListDTO r7 = r6.H;
        if (r7 == null) goto L33;
        ECHybridListDTO.Companion.getClass();
        k r8 = ECHybridListDTO.a.d(r7, false, null);
        ArrayList r9 = r8.c;
        if (r9 == null) goto L25;
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L25;
        i r11 = (i) r10.next();
        ArrayList r12 = r11.i;
        if (r12 == null) goto L18;
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L18;
        ECHybridListItemVO r14 = (ECHybridListItemVO) r13.next();
        ShopHybridTabExtKt.d(r14, r11);
        ShopHybridTabExtKt.c(r14, false);
    L25:
        r6.I = r8;
        return;
    }

    public static com.bytedance.android.shopping.store.viewmodel.k c(ECStoreHomeTabResponseTabkit r13, ECStoreParam r14) {
        Intrinsics.checkNotNullParameter(r13, "response");
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r13.getStatusCode() == 0) goto L15;
        Map<Long, m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
        if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r14.getLifecycleMonitorId())) == null) goto L10;
        int r2 = l.a;
        l.b(TabEnum.HOMEPAGE_TAB.getType());
        ErrorDomain.NET.getCode();
        r13.getStatusCode();
        r13.getStatusMsg();
    L10:
        m r15 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r14.getLifecycleMonitorId()));
        if (r15 == null) goto L14;
        r15.d(null, r13);
    L14:
        return new com.bytedance.android.shopping.store.viewmodel.k(r13.getStatusCode(), null);
    L15:
        int r3 = ECStoreTabAreaVO.f;
        ECStoreTabAreaVO r4 = ECStoreTabAreaVO.a.a(r13);
        Map<Long, m> r5 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r6 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r14.getLifecycleMonitorId()));
        if (r6 == null) goto L18;
        r6.G(r14, r4, r13);
    L18:
        r14.setTempId(r4.d);
        r14.setTabPerfLogExtra(r4.e);
        List<j> r7 = r4.b;
        if (r7 == null) goto L21;
        TabEnum[] r8 = TabEnum.values();
        HashSet r9 = new HashSet();
        int r10 = r8.length;
        int r11 = 0;
    L23:
        if (r11 >= r10) goto L25;
        r9.add(Integer.valueOf(r8[r11].getType()));
        r11 = r11 + 1;
        goto L23
    L25:
        ArrayList r12 = new ArrayList();
        Iterator<T> r16 = r7.iterator();
    L26:
        boolean r17 = true;
        if (r16.hasNext() == false) goto L38;
        Object r18 = r16.next();
        j r19 = (j) r18;
        if (r9.contains(Integer.valueOf(r19.d)) == false) goto L31;
    L36:
        if (r17 == false) goto L26;
        r12.add(r18);
        goto L26
    L31:
        if (r19.e() == true) goto L36;
        if (r19.g() == true) goto L36;
        r17 = false;
        goto L36
    L38:
        Iterator r20 = r12.iterator();
    L40:
        if (r20.hasNext() == false) goto L67;
        j r21 = (j) r20.next();
        List<j> r22 = r21.b;
        if (r22 != null) goto L44;
    L47:
        boolean r23 = true;
    L48:
        if (r23 == true) goto L40;
        List<j> r24 = r21.b;
        if (r24 == null) goto L65;
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r24.iterator();
    L53:
        if (r26.hasNext() == false) goto L66;
        Object r110 = r26.next();
        j r111 = (j) r110;
        if (r9.contains(Integer.valueOf(r111.d)) == false) goto L57;
    L62:
        boolean r112 = true;
    L63:
        if (r112 == false) goto L53;
        r25.add(r110);
        goto L53
    L57:
        if (r111.e() == true) goto L62;
        if (r111.g() == true) goto L62;
        r112 = false;
    L66:
        r21.b = r25;
        goto L40
    L65:
        r25 = null;
        goto L66
    L44:
        if (r22.isEmpty() == true) goto L47;
        r23 = false;
        goto L48
    L67:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r12.iterator();
    L69:
        if (r28.hasNext() == false) goto L79;
        j r29 = (j) r28.next();
        List<j> r30 = r29.b;
        if (r30 == null) goto L78;
        if ((!r30.isEmpty()) == true) goto L76;
        r30 = null;
    L76:
        if (r30 == null) goto L78;
        r27.addAll(r30);
    L78:
        r27.add(r29);
        goto L69
    L79:
        Iterator r31 = r27.iterator();
    L81:
        if (r31.hasNext() == false) goto L85;
        j r32 = (j) r31.next();
        Map<Integer, TabStyle> r33 = r14.getTabStyles();
        Integer r34 = Integer.valueOf(r32.d);
        TabStyle r35 = new TabStyle();
        r35.setTemplateId(r32.v);
        Unit r36 = Unit.INSTANCE;
        r33.put(r34, r35);
        if (r32.i() == false) goto L81;
        r14.getProductBasicRequestParam().setCursor(r32.r);
        goto L81
    L85:
        Iterator r113 = r12.iterator();
    L87:
        if (r113.hasNext() == false) goto L91;
        Object r37 = r113.next();
        if (((j) r37).i() == false) goto L87;
    L92:
        j r38 = (j) r37;
        if (r38 == null) goto L95;
        b(r38);
    L95:
        Iterator r114 = r12.iterator();
    L97:
        if (r114.hasNext() == false) goto L110;
        List<j> r39 = ((j) r114.next()).b;
        if (r39 == null) goto L97;
        Iterator<T> r40 = r39.iterator();
    L102:
        if (r40.hasNext() == false) goto L106;
        Object r41 = r40.next();
        if (((j) r41).i() == false) goto L102;
    L107:
        j r42 = (j) r41;
        if (r42 == null) goto L97;
        b(r42);
        goto L97
    L106:
        r41 = null;
        goto L107
    L110:
        r4.b = r12;
        return new com.bytedance.android.shopping.store.viewmodel.k(r13.getStatusCode(), r4);
    L91:
        r37 = null;
        goto L92
    L21:
        return new com.bytedance.android.shopping.store.viewmodel.k(r13.getStatusCode(), null);
    }
}
