package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.p;
import com.bytedance.android.window.shop.repository.tab.entity.q;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowTabHybridDataSource {
    public int a;
    public final CompositeDisposable b;
    public final g c;
    public Long d;
    public Function1<? super WindowProductTabRequestParam, ? extends Observable<WindowHybridTabDataListResponseDTO>> e;
    public final String f;
    public final com.bytedance.android.window.shop.repository.tab.datasource.g g;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            WindowHybridTabDataListResponseDTO r4 = (WindowHybridTabDataListResponseDTO) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            WindowDynamicViewCache r0 = WindowDynamicViewCache.g;
            WindowHybridTabDataListResponseDTO.a r1 = r4.getBaseInfo();
            if (r1 == null) goto L5;
            List<nq3.a> r2 = r1.b();
        L6:
            r0.d(r2);
            return TuplesKt.to(r4, WindowDataMapper.b(r4));
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WindowTabHybridDataSource a;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c b;
        public final /* synthetic */ long c;

        public b(WindowTabHybridDataSource r1, com.bytedance.android.window.shop.repository.tab.datasource.c r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void accept(Object r18) {
            Pair r0 = (Pair) r18;
            WindowHybridTabDataListResponseDTO r2 = (WindowHybridTabDataListResponseDTO) r0.component1();
            com.bytedance.android.ec.hybrid.list.entity.k r1 = (com.bytedance.android.ec.hybrid.list.entity.k) r0.component2();
            Intrinsics.checkNotNullParameter(r1, "$this$getFirstNormalItemId");
            ArrayList r3 = r1.c;
            if (r3 == null) goto L25;
            Iterator<T> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L17;
            T r7 = r4.next();
            com.bytedance.android.ec.hybrid.list.entity.i r8 = (com.bytedance.android.ec.hybrid.list.entity.i) r7;
            ArrayList r9 = r8.i;
            if (r9 != null) goto L10;
        L14:
            boolean r10 = false;
        L15:
            if (r10 == false) goto L6;
        L18:
            com.bytedance.android.ec.hybrid.list.entity.i r11 = (com.bytedance.android.ec.hybrid.list.entity.i) r7;
            if (r11 == null) goto L25;
            ArrayList r5 = r11.i;
            if (r5 == null) goto L25;
            ECHybridListItemVO r6 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r5);
            if (r6 == null) goto L25;
            String r12 = r6.d;
        L26:
            com.bytedance.android.window.shop.repository.tab.datasource.c r13 = this.b;
            Intrinsics.checkNotNullParameter(r1, "$this$getValidItemCount");
            ArrayList r14 = r1.c;
            if (r14 != null) goto L29;
            int r15 = 0;
        L37:
            r13.V(r12, r15, this.c, this.a.d);
            this.a.d = Long.valueOf(this.c);
            this.a.getClass();
            WindowHybridTabDataListResponseDTO.a r16 = r2.getBaseInfo();
            if (r16 == null) goto L70;
            String r17 = r16.f();
            if (r17 == null) goto L70;
            ArrayList r19 = r1.c;
            if (r19 == null) goto L70;
            Iterator<T> r20 = r19.iterator();
        L46:
            if (r20.hasNext() == false) goto L70;
            ArrayList r21 = ((com.bytedance.android.ec.hybrid.list.entity.i) r20.next()).i;
            if (r21 == null) goto L46;
            Iterator<T> r22 = r21.iterator();
        L51:
            if (r22.hasNext() == false) goto L46;
            ECHybridListItemVO r23 = (ECHybridListItemVO) r22.next();
            Object r110 = r23.d();
            if ((r110 instanceof i0) == false) goto L56;
            r23.o(new i0(((i0) r110).k, r17));
        L56:
            if ((r110 instanceof q) == false) goto L51;
            q r111 = (q) r110;
            i0 r24 = r111.l;
            if (r24 == null) goto L60;
            r111.l = new i0(r24.k, r17);
        L60:
            e0 r25 = r111.j;
            if (r25 == null) goto L51;
            WindowLayoutType.a r112 = WindowLayoutType.Companion;
            WindowHybridTabDataListResponseDTO.a r113 = r2.getBaseInfo();
            if (r113 == null) goto L65;
            Integer r114 = Integer.valueOf(r113.c());
        L66:
            r112.getClass();
            WindowLayoutType r115 = WindowLayoutType.a.b(r114);
            if (r115 != null) goto L69;
            r115 = WindowLayoutType.SINGLECOLUMN;
        L69:
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r25.k = r115;
            goto L51
        L65:
            r114 = null;
        L70:
            WindowTabHybridDataSource r26 = this.a;
            r26.getClass();
            ECHybridListDTO r27 = r2.getFeed();
            if (r27 != null) goto L73;
        L75:
            WindowHybridTabDataListResponseDTO.a r28 = r2.getBaseInfo();
            if (r28 == null) goto L78;
            String r29 = r28.d();
        L79:
            String r30 = a2.d(r29);
            if (r30 == null) goto L83;
            ShopRepository.a.getClass();
            r26.e = ShopRepository.c(r30);
        L83:
            this.a.getClass();
            ArrayList r31 = r1.c;
            if (r31 != null) goto L86;
        L89:
            boolean r32 = true;
        L90:
            if (r32 == true) goto L112;
            ArrayList r33 = r1.c;
            if (r33 != null) goto L94;
        L111:
            boolean r34 = false;
        L113:
            boolean r35 = r2.hasMore();
            this.a.c.update(r35);
            WindowProductTabRequestParam r36 = this.a.g.b();
            ECHybridListDTO r37 = r2.getFeed();
            if (r37 == null) goto L116;
            int r38 = r37.getCursor();
        L117:
            r36.setPageNum(r38);
            WindowHybridTabDataListResponseDTO.a r39 = r2.getBaseInfo();
            if (r39 == null) goto L120;
            String r40 = r39.a();
        L121:
            r36.setCommonPassThroughParam(r40);
            ArrayList r41 = r1.c;
            if (r41 == null) goto L150;
            Iterator<T> r42 = r41.iterator();
        L125:
            if (r42.hasNext() == false) goto L129;
            T r116 = r42.next();
            if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r116).a, "tool_bar") == false) goto L125;
        L130:
            com.bytedance.android.ec.hybrid.list.entity.i r117 = (com.bytedance.android.ec.hybrid.list.entity.i) r116;
            if (r117 == null) goto L150;
            ArrayList r43 = r117.i;
            if (r43 == null) goto L150;
            Iterator<T> r44 = r43.iterator();
        L136:
            if (r44.hasNext() == false) goto L146;
            T r118 = r44.next();
            Integer r119 = ((ECHybridListItemVO) r118).c;
            if (r119 != null) goto L141;
        L143:
            boolean r120 = false;
        L144:
            if (r120 == false) goto L136;
        L147:
            ECHybridListItemVO r121 = (ECHybridListItemVO) r118;
            if (r121 == null) goto L150;
            Object r45 = r121.d();
        L152:
            if ((r45 instanceof mp3.c) == false) goto L158;
            Object r46 = ((mp3.c) r45).a();
            if ((r46 instanceof q) == true) goto L156;
            r46 = null;
        L156:
            q r47 = (q) r46;
        L161:
            if (r47 == null) goto L196;
            e0 r122 = r47.j;
            if (r122 == null) goto L182;
            d0 r123 = r122.j;
            if (r123 == null) goto L182;
            List<d0.b> r124 = r123.j;
            if (r124 == null) goto L182;
            Iterator r125 = ((ArrayList) r124).iterator();
        L170:
            if (r125.hasNext() == false) goto L174;
            Object r126 = r125.next();
            if (((d0.b) r126).e == false) goto L170;
        L175:
            d0.b r127 = (d0.b) r126;
            if (r127 == null) goto L182;
            r36.setSortType(Long.valueOf(r127.a));
            if (r127.c == false) goto L180;
            Integer r128 = Integer.valueOf(r127.d ? 1 : 0);
        L181:
            r36.setSort(r128);
            goto L182
        L180:
            r128 = null;
            goto L181
        L174:
            r126 = null;
        L182:
            WindowChildCategoryVO r48 = r47.m;
            if (r48 == null) goto L196;
            List<WindowChildCategoryVO.ChildCategoryVO> r49 = r48.a;
            if (r49 == null) goto L196;
            Iterator<T> r50 = r49.iterator();
        L188:
            if (r50.hasNext() == false) goto L192;
            T r129 = r50.next();
            if (((WindowChildCategoryVO.ChildCategoryVO) r129).getSelected() == false) goto L188;
        L193:
            WindowChildCategoryVO.ChildCategoryVO r130 = r129;
            if (r130 == null) goto L196;
            r36.setChildCategory(r130.getId());
            goto L196
        L192:
            r129 = (T) null;
        L196:
            final WindowTabHybridDataSource r51 = this.a;
            if (r51.g.b().getPageNum() != 0) goto L199;
            r51.a = 0;
        L199:
            ArrayList r52 = r1.c;
            if (r52 == null) goto L223;
            Iterator<T> r53 = r52.iterator();
        L203:
            if (r53.hasNext() == false) goto L223;
            ArrayList r131 = ((com.bytedance.android.ec.hybrid.list.entity.i) r53.next()).i;
            if (r131 == null) goto L203;
            Iterator<T> r132 = r131.iterator();
        L208:
            if (r132.hasNext() == false) goto L203;
            Object r133 = ((ECHybridListItemVO) r132.next()).d();
            final int r134 = r51.a;
            r51.a = r134 + 1;
            if ((r133 instanceof mp3.c) == true) goto L211;
            WindowTabHybridDataSource.b(r133, r134);
            goto L208
        L211:
            mp3.c r135 = (mp3.c) r133;
            Function1<Object, Unit> r136 = new WindowTabHybridDataSource$updateBstIndex$$inlined$forEach$lambda$1(r134, r51);
            r135.getClass();
            Intrinsics.checkNotNullParameter(r136, "processor");
            mp3.c<T> r137 = r135.b;
            monitor-enter(r137);
            if (r135.d == false) goto L216;
            r136.invoke(r135.c);     // Catch: Throwable -> L219
        L217:
            monitor-exit(r137);
            goto L208
        L216:
            r135.a.add((Function1<T, Unit>) r136);     // Catch: Throwable -> L219
        L219:
            th = move-exception;
            throw th;
        L223:
            WindowTabHybridDataSource r54 = this.a;
            com.bytedance.android.window.shop.repository.tab.datasource.c r55 = this.b;
            r54.getClass();
            ArrayList r138 = r1.c;
            if (r138 == null) goto L268;
            if ((!r138.isEmpty()) != true) goto L268;
            r55.f(r2, r54.g.b());
            List r139 = CollectionsKt.emptyList();
            com.bytedance.android.window.shop.c r140 = com.bytedance.android.window.shop.c.c;
            List<ECHybridListSectionDTO> r141 = r2.getTopCards();
            if (r141 != null) goto L230;
        L233:
            boolean r142 = true;
        L234:
            if (r142 == false) goto L236;
            com.bytedance.android.ec.hybrid.list.entity.k r143 = null;
        L266:
            r55.y(new n0(r139, r140, r1, r143), ShopWindowVODataType.NORMAL);
            goto L268
        L236:
            r143 = new com.bytedance.android.ec.hybrid.list.entity.k();
            r143.b = r1.b;
            r143.a = r1.a;
            ArrayList r144 = new ArrayList();
            List<ECHybridListSectionDTO> r145 = r2.getTopCards();
            ArrayList r146 = new ArrayList();
            Iterator<T> r147 = r145.iterator();
        L238:
            if (r147.hasNext() == false) goto L250;
            T r56 = r147.next();
            ECHybridListSectionDTO r148 = (ECHybridListSectionDTO) r56;
            if (Intrinsics.areEqual(r148.getSectionId(), "tabs_card") == false) goto L246;
            ArrayList r57 = r148.getItems();
            if (r57 == null) goto L246;
            if ((!r57.isEmpty()) != true) goto L246;
            boolean r58 = true;
        L247:
            if (r58 == true) goto L238;
            r146.add(r56);
        L246:
            r58 = false;
            goto L247
        L250:
            ArrayList r59 = new ArrayList();
            Iterator r60 = r146.iterator();
        L252:
            if (r60.hasNext() == false) goto L265;
            ECHybridListSectionDTO r61 = (ECHybridListSectionDTO) r60.next();
            ECHybridListSectionDTO.Companion.getClass();
            com.bytedance.android.ec.hybrid.list.entity.i r62 = ECHybridListSectionDTO.a.a(r61, false, null);
            ArrayList r149 = r62.i;
            if (r149 == null) goto L259;
            if ((!r149.isEmpty()) != true) goto L259;
            boolean r150 = true;
        L260:
            if (r150 == false) goto L262;
            com.bytedance.android.ec.hybrid.list.entity.i r151 = r62;
        L263:
            if (r151 == null) goto L252;
            r59.add(r151);
            goto L252
        L262:
            r151 = null;
        L259:
            r150 = false;
            goto L260
        L265:
            r144.addAll(r59);
            Unit r63 = Unit.INSTANCE;
            r143.c = r144;
            goto L266
        L230:
            if (r141.isEmpty() == true) goto L233;
            r142 = false;
        L268:
            if (r2.hasMore() == true) goto L270;
            r55.c(null);
        L270:
            if (r35 == false) goto L332;
            if (r34 == false) goto L333;
            this.a.a(this.b);
            return;
        L333:
            return;
        L332:
            return;
        L158:
            if ((r45 instanceof q) == true) goto L160;
            r45 = null;
        L160:
            r47 = (q) r45;
            goto L161
        L141:
            if (r119.intValue() != 3002) goto L143;
            r120 = true;
            goto L144
        L146:
            r118 = null;
            goto L147
        L129:
            r116 = null;
        L150:
            r45 = null;
            goto L152
        L120:
            r40 = null;
            goto L121
        L116:
            r38 = 0;
            goto L117
        L94:
            if (r33.isEmpty() == true) goto L108;
            Iterator<T> r64 = r33.iterator();
        L98:
            if (r64.hasNext() == false) goto L108;
            ArrayList r65 = ((com.bytedance.android.ec.hybrid.list.entity.i) r64.next()).i;
            if (r65 != null) goto L102;
        L105:
            boolean r66 = true;
        L106:
            if (r66 == true) goto L98;
            boolean r67 = false;
        L109:
            if (r67 != true) goto L111;
        L102:
            if (r65.isEmpty() == true) goto L105;
            r66 = false;
        L108:
            r67 = true;
        L112:
            r34 = true;
            goto L113
        L86:
            if (r31.isEmpty() == true) goto L89;
            r32 = false;
            goto L90
        L78:
            r29 = null;
            goto L79
        L73:
            if (r27.getHasMore() != true) goto L75;
        L29:
            Iterator r68 = r14.iterator();
            r15 = 0;
        L31:
            if (r68.hasNext() == false) goto L37;
            ArrayList r152 = ((com.bytedance.android.ec.hybrid.list.entity.i) r68.next()).i;
            if (r152 == null) goto L35;
            int r153 = r152.size();
        L36:
            r15 = r15 + r153;
            goto L31
        L35:
            r153 = 0;
            goto L36
        L10:
            if ((!r9.isEmpty()) != true) goto L14;
            if (r8.getType() != 0) goto L14;
            r10 = true;
            goto L15
        L17:
            r7 = null;
        L25:
            r12 = null;
            goto L26
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WindowTabHybridDataSource a;
        public final /* synthetic */ long b;
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c c;

        public c(WindowTabHybridDataSource r1, long r2, com.bytedance.android.window.shop.repository.tab.datasource.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r3) {
            ECExceptionMonitor.e((Throwable) r3);
            WindowTabHybridDataSource r4 = this.a;
            r4.d = Long.valueOf(this.b);
            this.a.c.a = false;
            this.c.c(null);
            this.c.onError("");
            this.a.c.b = false;
        }
    }

    public final void a(com.bytedance.android.window.shop.repository.tab.datasource.c r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        g r0 = this.c;
        if (r0.b == false) goto L6;
        return;
    L6:
        if (r0.a == true) goto L8;
        return;
    L8:
        r0.b = true;
        long r2 = System.nanoTime();
        r6.F(this.g.b().getPageNum(), r2, this.d);
        WindowProductTabRequestParam r1 = this.g.b();
        if (r1.getPageNum() == 0) goto L11;
    L13:
        r1.setFirstEnter(false);
        Observable r3 = (Observable) this.e.invoke(r1);
    L14:
        Disposable r7 = bg4.b.b(r3.map(a.a)).subscribe(new b(this, r6, r2), new c(this, r2, r6));
        this.b.add(r7);
        return;
    L11:
        if (this.g.c == null) goto L13;
        r1.setFirstEnter(true);
        com.bytedance.android.window.shop.repository.tab.datasource.g r4 = this.g;
        WindowHybridTabDataListResponseDTO r5 = r4.c;
        r4.c = null;
        r3 = Observable.just(r5);
        goto L14
    }

    public WindowTabHybridDataSource(String r2, com.bytedance.android.window.shop.repository.tab.datasource.g r3) {
        Intrinsics.checkNotNullParameter(r2, "categoryId");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.f = r2;
        this.g = r3;
        r3.b().setTargetCategory(r2);
        this.b = new CompositeDisposable();
        this.c = new g();
        this.e = new WindowTabHybridDataSource$currentFetcher$1(ShopRepository.a);
    }

    public static void b(Object r2, int r3) {
        fo.b r1 = null;
        if ((r2 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.android.window.shop.repository.tab.entity.f r4 = (com.bytedance.android.window.shop.repository.tab.entity.f) r2;
        if (r4 != null) goto L9;
        return;
    L9:
        if ((r4 instanceof b0) == false) goto L12;
        r1 = ((WindowV2ProductItemVO) ((b0) r4).j).C;
    L22:
        if (r1 != null) goto L24;
        return;
    L24:
        fo.a r0 = wn.a.C;
        Integer r5 = r4.b;
        if (r5 == null) goto L27;
        r3 = r5.intValue();
    L27:
        r1.b(r0, Integer.valueOf(r3));
        return;
    L12:
        if ((r4 instanceof p) == false) goto L17;
        WindowV2ProductItemVO r6 = ((p) r4).k;
        if (r6 == null) goto L22;
        r1 = r6.C;
        goto L22
    L17:
        if ((r4 instanceof m) == false) goto L19;
        r1 = ((WindowV2ProductItemVO) ((m) r4).j).C;
        goto L22
    L19:
        WindowV2ProductItemVO r7 = r4.c();
        if (r7 == null) goto L22;
        r1 = r7.C;
        goto L22
    }
}
