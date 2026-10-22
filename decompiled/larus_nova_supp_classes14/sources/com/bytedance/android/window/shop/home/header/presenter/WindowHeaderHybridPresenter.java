package com.bytedance.android.window.shop.home.header.presenter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.j0;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.ability.s;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.j;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.factory.d;
import com.bytedance.android.window.shop.home.header.WindowHybridListOperationPlugin;
import com.bytedance.android.window.shop.home.tab.presenter.c0;
import com.bytedance.android.window.shop.home.tab.tabplugin.f;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.lifecycle.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oq3.e;
import uq3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderHybridPresenter extends QFragmentPresenter {
    public final f f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final String j;
    public final Lazy k;
    public final ECHybridListContainer l;
    public final Fragment m;

    public static final class a<T> implements Observer {
        public final /* synthetic */ WindowHeaderHybridPresenter a;

        public a(WindowHeaderHybridPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r14) {
            uq3.a r15 = (uq3.a) r14;
            if (r15.c == null) goto L170;
            ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = c.a;
            com.bytedance.android.window.shop.lifecycle.f r1 = c.a(this.a.e0().getShopParam().getLifecycleMonitorId());
            if (r1 == null) goto L8;
            r1.f();
        L8:
            ECHybridListEngine.p(this.a.d0(), new k(), 6);
            k r2 = r15.b;
            if (r2 == null) goto L171;
            WindowHeaderHybridPresenter r3 = this.a;
            o r16 = r15.c;
            if (r16 == null) goto L14;
            Map<String, ? extends List<String>> r17 = r16.w;
        L16:
            if (r17 != null) goto L18;
            r3.getClass();
        L41:
            k r4 = r2;
        L42:
            ArrayList r18 = r4.c;
            if (r18 == null) goto L45;
            i r19 = (i) CollectionsKt.lastOrNull(r18);
        L46:
            if (r19 != null) goto L48;
            this.a.d0().b.setVisibility(8);
        L49:
            if (r19 == null) goto L53;
            ArrayList r5 = r19.i;
            if (r5 == null) goto L53;
            ECHybridListItemVO r6 = new ECHybridListItemVO();
            r6.o(new e());
            r6.c = Integer.valueOf(gr3.f.a(999));
            r6.d = "window_native_tail_card";
            r6.a = Integer.valueOf(r19.f);
            Unit r110 = Unit.INSTANCE;
            r5.add(r6);
        L53:
            Intrinsics.checkNotNullParameter(r4, "$this$saveSectionStyleForAllItem");
            ArrayList r111 = r4.c;
            if (r111 == null) goto L81;
            Iterator<T> r112 = r111.iterator();
        L57:
            if (r112.hasNext() == false) goto L81;
            i r7 = (i) r112.next();
            String r8 = r7.a;
            if (r8 == null) goto L57;
            if (StringsKt.endsWith$default(r8, "author_info", false, 2, null) != true) goto L57;
            j r9 = r7.h;
            if (r9 == null) goto L57;
            Double r10 = r9.c;
            if (r10 == null) goto L57;
            double r11 = r10.doubleValue();
            j r12 = r7.h;
            if (r12 == null) goto L70;
            r12.c = Double.valueOf(0.0d);
        L70:
            ArrayList r13 = r7.i;
            if (r13 == null) goto L57;
            Iterator<T> r20 = r13.iterator();
        L74:
            if (r20.hasNext() == false) goto L57;
            Object r21 = c0.c((ECHybridListItemVO) r20.next());
            if ((r21 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == true) goto L78;
            r21 = null;
        L78:
            com.bytedance.android.window.shop.repository.tab.entity.f r22 = (com.bytedance.android.window.shop.repository.tab.entity.f) r21;
            if (r22 == null) goto L74;
            j r113 = new j();
            r113.c = Double.valueOf(r11);
            Unit r114 = Unit.INSTANCE;
            r22.h = r113;
        L81:
            Intrinsics.checkNotNullParameter(r4, "$this$ensureMarginVerticalEmpty");
            LinkedHashMap r115 = new LinkedHashMap();
            LinkedHashMap r23 = new LinkedHashMap();
            ArrayList r24 = r4.c;
            if (r24 == null) goto L95;
            Iterator<T> r25 = r24.iterator();
        L85:
            if (r25.hasNext() == false) goto L95;
            i r26 = (i) r25.next();
            j r27 = r26.h;
            if (r27 == null) goto L85;
            Double r28 = r27.c;
            Double r116 = r27.d;
            r27.c = Double.valueOf(0.0d);
            r27.d = Double.valueOf(0.0d);
            i r29 = c0.i("section_" + r26.a + "_margin_begin", r28);
            if (r29 == null) goto L92;
            r115.put(r26, r29);
        L92:
            i r30 = c0.i("section_" + r26.a + "_margin_end", r116);
            if (r30 == null) goto L85;
            r23.put(r26, r30);
        L95:
            ArrayList r31 = r4.c;
            if (r31 != null) goto L99;
        L115:
            j r117 = r4.a;
            if (r117 == null) goto L135;
            Double r32 = r117.c;
            Double r33 = r117.d;
            r117.c = Double.valueOf(0.0d);
            r117.d = Double.valueOf(0.0d);
            ArrayList r118 = r4.c;
            if (r118 == null) goto L126;
            i r119 = (i) CollectionsKt.firstOrNull(r118);
            if (r119 == null) goto L126;
            ECHybridListItemVO r34 = c0.h("list_margin_begin", r32, r119.f);
            if (r34 == null) goto L126;
            ArrayList r120 = r119.i;
            if (r120 == null) goto L126;
            ListProtector.add(r120, 0, r34);
        L126:
            ArrayList r121 = r4.c;
            if (r121 == null) goto L135;
            i r122 = (i) CollectionsKt.lastOrNull(r121);
            if (r122 == null) goto L135;
            ECHybridListItemVO r35 = c0.h("list_margin_end", r33, r122.f);
            if (r35 == null) goto L135;
            ArrayList r123 = r122.i;
            if (r123 == null) goto L135;
            r123.add(r35);
        L135:
            ECHybridListEngine.p(this.a.d0(), r4, 6);
            return;
        L99:
            if (r31.isEmpty() == true) goto L115;
            Iterator r124 = r115.entrySet().iterator();
        L103:
            if (r124.hasNext() == false) goto L108;
            Map.Entry r36 = (Map.Entry) r124.next();
            i r37 = (i) r36.getKey();
            i r38 = (i) r36.getValue();
            int r39 = r31.indexOf(r37);
            if (r39 < 0) goto L115;
            ListProtector.add(r31, r39, r38);
            goto L103
        L108:
            Iterator r125 = r23.entrySet().iterator();
        L110:
            if (r125.hasNext() == false) goto L115;
            Map.Entry r40 = (Map.Entry) r125.next();
            i r41 = (i) r40.getKey();
            i r42 = (i) r40.getValue();
            int r43 = r31.indexOf(r41);
            if (r43 < 0) goto L115;
            ListProtector.add(r31, r43 + 1, r42);
            goto L110
        L48:
            this.a.d0().b.setVisibility(0);
            goto L49
        L45:
            r19 = null;
            goto L46
        L18:
            Fragment r44 = r3.Y().a;
            if (r44 == null) goto L41;
            String r45 = r44.getTag();
            if (r45 == null) goto L41;
            List<String> r126 = r17.get(r45);
            if (r126 != null) goto L26;
            r2 = new k();
            goto L41
        L26:
            r4 = new k();
            r4.a = r2.a;
            r4.b = r2.b;
            r4.d = r2.d;
            ArrayList r46 = new ArrayList();
            ArrayList r47 = r2.c;
            if (r47 == null) goto L39;
            ArrayList r48 = new ArrayList();
            Iterator<T> r49 = r47.iterator();
        L30:
            if (r49.hasNext() == false) goto L34;
            T r50 = r49.next();
            if (CollectionsKt.contains(r126, ((i) r50).a) == false) goto L30;
            r48.add(r50);
            goto L30
        L34:
            Object[] r127 = r48.toArray(new i[0]);
            if (r127 == null) goto L38;
            i[] r128 = (i[]) r127;
        L40:
            CollectionsKt.addAll(r46, r128);
            Unit r129 = Unit.INSTANCE;
            r4.c = r46;
            goto L42
        L38:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L39:
            r128 = new i[0];
            goto L40
        L14:
            r17 = null;
            goto L16
        L171:
            return;
        }
    }

    public final ECHybridListEngine d0() {
        return (ECHybridListEngine) this.k.getValue();
    }

    public final ECWindowViewModel e0() {
        return (ECWindowViewModel) this.g.getValue();
    }

    public final void c0() {
        this.f.b();
        ECHybridRecyclerView r0 = d0().b;
        Intrinsics.checkNotNullParameter(r0, "$this$getVisibleHybridHolders");
        VirtualLayoutManager r1 = r0.getLayoutManager();
        if (r1 != null) goto L5;
        List r2 = CollectionsKt.emptyList();
    L22:
        Iterator r3 = r2.iterator();
    L24:
        if (r3.hasNext() == false) goto L26;
        ((ShopWindowItemHolder) r3.next()).o();
        goto L24
    L26:
        ECHybridListEngine r4 = d0();
        k r5 = new k();
        r5.c = new ArrayList();
        Unit r6 = Unit.INSTANCE;
        ECHybridListEngine.p(r4, r5, 6);
        return;
    L5:
        int r7 = r1.findFirstVisibleItemPosition();
        int r8 = r1.findLastVisibleItemPosition();
        if (r7 < 0) goto L21;
        if (r8 < r7) goto L21;
        ArrayList r9 = new ArrayList();
        if (r7 > r8) goto L20;
    L11:
        RecyclerView.ViewHolder r10 = r0.findViewHolderForAdapterPosition(r7);
        if ((r10 instanceof ShopWindowItemHolder) == true) goto L14;
        r10 = null;
    L14:
        ShopWindowItemHolder r11 = (ShopWindowItemHolder) r10;
        if (r11 == null) goto L18;
        r9.add(r11);
    L18:
        if (r7 == r8) goto L20;
        r7 = r7 + 1;
    L20:
        r2 = r9;
    L21:
        r2 = CollectionsKt.emptyList();
        goto L22
    }

    public final void b0(QModel r7) {
        Set<Integer> r8 = d.a;
        d.a(((QFragmentPresenter) this).e, new fo.b(), this.j);
        Iterator r9 = MapsKt.mapOf(new Pair[]{TuplesKt.to(l0.class, new com.bytedance.android.window.shop.home.header.presenter.a()), TuplesKt.to(m0.class, new WindowHeaderHybridPresenter$windowAbilities$2(this)), TuplesKt.to(j0.class, new b())}).entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) r9.next();
        Class r3 = (Class) r0.getKey();
        s r1 = (s) r0.getValue();
        ECHybridListEngine r4 = d0();
        if (r3 == null) goto L9;
        r4.b(r3, r1);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.bytedance.android.ec.hybrid.list.ability.IAbility>");
    L10:
        e0().getHeaderResponse().a(Y().e(), new a(this), false);
        this.f.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{new WindowHybridListOperationPlugin(this.m, e0(), d0())});
    }

    public WindowHeaderHybridPresenter(ECHybridListContainer r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "tabFragment");
        super(r3);
        this.l = r2;
        this.m = r3;
        this.f = new f();
        this.g = LazyKt.lazy(new WindowHeaderHybridPresenter$viewModel$2(this));
        this.h = LazyKt.lazy(WindowHeaderHybridPresenter$pathInterpolatorLive$2.INSTANCE);
        this.i = LazyKt.lazy(WindowHeaderHybridPresenter$pathInterpolatorNormal$2.INSTANCE);
        this.j = com.bytedance.android.window.shop.home.viewmodel.a.a();
        this.k = LazyKt.lazy(new WindowHeaderHybridPresenter$hybridListEngine$2(this));
    }
}
