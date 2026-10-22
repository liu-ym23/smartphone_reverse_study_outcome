package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.sortbar.HorizonSortBarAdapter;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.ec.store.view.SortFilterExpandPanel;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopHorizonSortBarPresenter extends QFragmentPresenter implements View.OnClickListener {
    public static final /* synthetic */ int r = 0;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public boolean k;
    public HorizonSortBarAdapter l;
    public boolean m;
    public boolean n;
    public String o;
    public boolean p;
    public final ECStoreViewModel q;

    public static final class a {
        public static void a(ECShopHybridProductViewModel r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r4, "viewModel");
            Intrinsics.checkNotNullParameter(r5, "eventActionName");
            Intrinsics.checkNotNullParameter(r7, "clickType");
            Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", r4.getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", r4.getStoreParam().getShopId()), TuplesKt.to("follow_status", String.valueOf(r4.getStoreParam().getFollowStatus())), TuplesKt.to("entrance_location", r4.getStoreParam().getEntranceLocation()), TuplesKt.to("store_source_page", r4.getStoreParam().getStoreSourcePage()), TuplesKt.to("store_source_method", r4.getStoreParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", r4.getStoreParam().getStoreGroupType()), TuplesKt.to("tab_name", "products"), TuplesKt.to("move_discount_to_tool_bar", CommentScene.COMMENTSCENE_NO_AWEME)});
            if (r6 == null) goto L8;
            Map<String, String> r8 = com.bytedance.android.shopping.store.hybridproduct.presenter.a.a(r6);
            if (r8 == null) goto L8;
            r0.putAll(r8);
        L8:
            if (Intrinsics.areEqual(r5, "click_discount_filter_button") == false) goto L10;
            r0.put("click_type", r7);
        L10:
            r4.doEventAction(r5, r0, new Pair[0]);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopHorizonSortBarPresenter a;

        public b(ECShopHorizonSortBarPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r24) {
            final ej3.f r1 = (ej3.f) r24;
            View r2 = this.a.Z().b(2131372858).f();
            qc3.a.i(r2, 12.0f, 12.0f);
            r2.setBackgroundColor((int) 4294967295L);
            final ECShopHorizonSortBarPresenter r3 = this.a;
            r3.getClass();
            int r6 = 8;
            if (r1 == null) goto L85;
            final List<com.bytedance.android.ec.store.repository.vo.r> r8 = r1.a;
            if (r8 == null) goto L85;
            if (r8.isEmpty() == false) goto L10;
            ((RecyclerView) r3.g.getValue()).setVisibility(8);
            goto L85
        L10:
            List<com.bytedance.android.ec.store.repository.vo.r> r9 = r1.b;
            List<com.bytedance.android.ec.store.repository.dto.c> r10 = r3.h0().getFilterSelectButtons();
            r10.clear();
            List<com.bytedance.android.ec.store.repository.vo.r> r11 = r9;
            if (r11 != null) goto L13;
        L16:
            boolean r12 = true;
        L17:
            if (r12 == true) goto L25;
            Iterator<com.bytedance.android.ec.store.repository.vo.r> r13 = r9.iterator();
        L20:
            if (r13.hasNext() == false) goto L25;
            com.bytedance.android.ec.store.repository.dto.c r14 = r13.next().s;
            if (r14 == null) goto L20;
            r10.add(r14);
        L25:
            if (r3.k == true) goto L27;
            r3.k = true;
            RecyclerView r15 = (RecyclerView) r3.g.getValue();
            r15.setVisibility(0);
            final Context r16 = r3.Y().c();
            LinearLayoutManager r17 = new ECShopHorizonSortBarPresenter$initSortInner$$inlined$let$lambda$1(r16, r8);
            r17.setOrientation(0);
            Unit r18 = Unit.INSTANCE;
            r15.setLayoutManager(r17);
            r15.setAdapter(new HorizonSortBarAdapter(((QFragmentPresenter) r3).e, (List) r3.h0().getSortTypes().getValue(), r1.b, Intrinsics.areEqual(r1.c, Boolean.TRUE), true, 0, (int) com.bytedance.android.shopping.extensions.b.c(12), r3.q.isBrandShopUpgrade(), new ECShopHorizonSortBarPresenter$initSortInner$$inlined$let$lambda$2(r3, r1, r8), new ECShopHorizonSortBarPresenter$initSortInner$$inlined$let$lambda$3(r3, r1, r8)));
            List<com.bytedance.android.ec.store.repository.vo.r> r4 = r8;
            Iterator<T> r5 = r4.iterator();
        L33:
            if (r5.hasNext() == false) goto L37;
            T r19 = r5.next();
            if (((com.bytedance.android.ec.store.repository.vo.r) r19).c == false) goto L33;
        L38:
            if (r19 != null) goto L42;
            com.bytedance.android.ec.store.repository.vo.r r7 = (com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.firstOrNull(r8);
            if (r7 == null) goto L42;
            r7.c = true;
        L42:
            Iterator<T> r20 = r4.iterator();
        L44:
            if (r20.hasNext() == false) goto L48;
            T r21 = r20.next();
            if (((com.bytedance.android.ec.store.repository.vo.r) r21).c == false) goto L44;
        L49:
            com.bytedance.android.ec.store.repository.vo.r r22 = (com.bytedance.android.ec.store.repository.vo.r) r21;
            if (r22 != null) goto L52;
        L54:
            String r23 = "";
        L55:
            if (r22 == null) goto L57;
            String r25 = r22.b;
        L58:
            r3.j0(r25, "102", r23);
            RecyclerView.Adapter r26 = r15.getAdapter();
            if ((r26 instanceof HorizonSortBarAdapter) == true) goto L61;
            r26 = null;
        L61:
            r3.l = (HorizonSortBarAdapter) r26;
            if (Intrinsics.areEqual(r1.c, Boolean.TRUE) == false) goto L74;
            View r27 = ((QFragmentPresenter) r3).e.getView();
            if (r27 == null) goto L66;
            int r28 = r27.getWidth();
        L68:
            if (r28 <= com.bytedance.android.shopping.extensions.b.b(350)) goto L70;
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(19)));
            goto L85
        L70:
            if (com.bytedance.android.shopping.store.utils.o.c == false) goto L72;
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8)));
            goto L85
        L72:
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(12)));
            goto L85
        L66:
            r28 = 0;
            goto L68
        L74:
            View r29 = ((QFragmentPresenter) r3).e.getView();
            if (r29 == null) goto L77;
            int r30 = r29.getWidth();
        L79:
            if (r30 <= com.bytedance.android.shopping.extensions.b.b(350)) goto L81;
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(20), com.bytedance.android.shopping.extensions.b.b(24)));
            goto L85
        L81:
            if (com.bytedance.android.shopping.store.utils.o.c == false) goto L83;
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(20), com.bytedance.android.shopping.extensions.b.b(8)));
            goto L85
        L83:
            r15.addItemDecoration(new HorizonSortBarAdapter.SortBarItemDecoration(com.bytedance.android.shopping.extensions.b.b(20), com.bytedance.android.shopping.extensions.b.b(12)));
            goto L85
        L77:
            r30 = 0;
            goto L79
        L57:
            r25 = null;
            goto L58
        L52:
            if (r22.d != true) goto L54;
            r23 = String.valueOf(r22.e);
            goto L55
        L48:
            r21 = null;
            goto L49
        L37:
            r19 = null;
            goto L38
        L27:
            if (Intrinsics.areEqual(r1.c, Boolean.TRUE) == false) goto L85;
            HorizonSortBarAdapter r31 = r3.l;
            if (r31 == null) goto L85;
            r31.c = r8;
            r31.d = r9;
            r31.e = true;
            r31.y2(r8, r9);
            r31.notifyDataSetChanged();
            goto L85
        L13:
            if (r11.isEmpty() == true) goto L16;
            r12 = false;
        L85:
            ECShopHorizonSortBarPresenter r32 = this.a;
            if (r1 == null) goto L88;
            Map<String, dj3.k> r33 = r1.f;
        L89:
            r32.getClass();
            if (r33 != null) goto L92;
        L95:
            boolean r34 = true;
        L96:
            if (r34 == false) goto L99;
            ((SimpleDraweeView) r32.h.getValue()).setVisibility(8);
            r32.e0().setVisibility(8);
        L128:
            ECShopHorizonSortBarPresenter r35 = this.a;
            if (r1 == null) goto L131;
            String r36 = r1.e;
        L132:
            View r37 = r35.Z().b(2131387419).f();
            TextView r38 = (TextView) r35.Z().b(2131387421).f();
            ImageView r39 = (ImageView) r35.Z().b(2131387420).f();
            if (r36 == null) goto L142;
            r37.setVisibility(0);
            r37.setOnClickListener(new e(r35, r37));
            if (r35.q.isBrandShopUpgrade() == false) goto L137;
            r38.setTextColor(r35.Y().c().getResources().getColor(2131101801));
            r39.setBackgroundResource(2131234808);
        L137:
            ViewParent r40 = null;
            r35.k0("show_ecom_component", null);
            r35.k0("show_ecom_element", MapsKt.mapOf(TuplesKt.to("detail", "openlayer")));
            r35.h0().setShowSelectPanelEntry(true);
            r35.q.getSelectPanelState().a(ECQuickUtilKt.a(r35.Y()), new f(r35, r37, r38, r39), false);
            if (Intrinsics.areEqual((Boolean) r35.h0().getBigSaleMoveToTop().getValue(), Boolean.TRUE) == true) goto L141;
            r6 = 0;
        L141:
            r38.setVisibility(r6);
        L143:
            ECShopHorizonSortBarPresenter r41 = this.a;
            if (r41.m == true) goto L148;
            r41.m = true;
            r41.h0().getSortTypes().a(((QFragmentPresenter) r41).e, new g(r41), false);
        L148:
            if (Intrinsics.areEqual((Boolean) this.a.q.isBrandShop().getValue(), Boolean.TRUE) == false) goto L156;
            ViewParent r42 = this.a.a0().getParent();
            if ((r42 instanceof ViewGroup) == true) goto L152;
            ViewParent r43 = r40;
        L153:
            ViewGroup r44 = (ViewGroup) r43;
            if (r44 == null) goto L156;
            wg.a.d(r44, com.bytedance.android.shopping.extensions.b.b(35));
            goto L156
        L152:
            r43 = r42;
        L156:
            ECShopHorizonSortBarPresenter r45 = this.a;
            if (r45.q.isMiddleTabFrameworkOrBrandShop() == false) goto L173;
            RecyclerView r46 = (RecyclerView) r45.g.getValue();
            if (r46 == null) goto L174;
            wg.a.d(r46, com.bytedance.android.shopping.extensions.b.b(35));
            return;
        L174:
            return;
        L173:
            return;
        L142:
            r40 = null;
            r37.setVisibility(8);
            goto L143
        L131:
            r36 = null;
            goto L132
        L99:
            if (r33.containsKey("clothes_preview_button") == false) goto L120;
            r32.n = true;
            dj3.k r47 = r33.get("clothes_preview_button");
            if (r47 != null) goto L103;
        L116:
            dj3.k r48 = r33.get("double_column_button");
            if (r48 == null) goto L127;
            r32.d0(r48);
            r32.o = "double_column_button";
            r32.h0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ORDER_FIRST_IMAGE);
        L127:
            r32.h0().doAnyEventActionWithBtm("a1.b6269.c2429.d57203", PageFinder.via(r32.a0()), "store_product_form_switch_show", w.a(r32.h0()), new Pair[0]);
            ((SimpleDraweeView) r32.h.getValue()).setOnClickListener(r32);
            r32.e0().setOnClickListener(r32);
            ((View) r32.j.getValue()).setOnClickListener(r32);
            goto L128
        L103:
            if (r47.b() != true) goto L116;
            dj3.k r49 = r33.get("clothes_preview_button");
            if (r49 == null) goto L127;
            r32.d0(r49);
            r32.o = "clothes_preview_button";
            if (r49.a() == null) goto L115;
            dj3.c r50 = r49.a();
            if (r32.p == true) goto L115;
            View r51 = r32.Z().b(2131372884).f();
            if (r51.getVisibility() == 8) goto L115;
            r51.setOnClickListener(r32);
            r51.post(new d(r51, r32, r50));
            ECShopDataStorageForRemote.b.d(r50.d());
            r32.h0().refreshPassthroughApiForSql();
            r32.p = true;
        L115:
            r32.h0().upDateSelectParams(r47.d());
            r32.h0().isClothesSelected().setValue(Boolean.TRUE);
            r32.h0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ALL_SAME);
            goto L127
        L120:
            if (((LayoutTypes) r32.h0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L124;
            dj3.k r52 = r33.get("single_column_button");
            if (r52 == null) goto L127;
            r32.d0(r52);
            r32.o = "single_column_button";
            goto L127
        L124:
            dj3.k r53 = r33.get("double_column_button");
            if (r53 == null) goto L127;
            r32.d0(r53);
            r32.o = "double_column_button";
            goto L127
        L92:
            if (r33.isEmpty() == true) goto L95;
            r34 = false;
            goto L96
        L88:
            r33 = null;
            goto L89
        }
    }

    public static final class c<T> implements Observer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void onChanged(Object r1) {
            uj3.j r2 = (uj3.j) r1;
            s0.a(new SortFilterExpandPanel.e());
        }
    }

    static {
    }

    public final TextView e0() {
        return (TextView) this.i.getValue();
    }

    public final ECShopHybridProductViewModel h0() {
        return (ECShopHybridProductViewModel) this.f.getValue();
    }

    public final void c0() {
        ej3.f r0 = (ej3.f) h0().getSortsVO().getValue();
        if (r0 == null) goto L16;
        List<com.bytedance.android.ec.store.repository.vo.r> r1 = r0.a;
        if (r1 == null) goto L10;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        com.bytedance.android.ec.store.repository.vo.r r3 = (com.bytedance.android.ec.store.repository.vo.r) r2.next();
        r3.getClass();
        com.bytedance.android.ec.store.repository.vo.r.c(r3, null);
    L10:
        List<com.bytedance.android.ec.store.repository.vo.r> r4 = r0.b;
        if (r4 == null) goto L16;
        Iterator<T> r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        com.bytedance.android.ec.store.repository.vo.r r6 = (com.bytedance.android.ec.store.repository.vo.r) r5.next();
        r6.getClass();
        com.bytedance.android.ec.store.repository.vo.r.c(r6, null);
    L16:
        this.k = false;
    }

    public final void l0() {
        Iterator<com.bytedance.android.ec.store.repository.dto.c> r0 = h0().getSelectButtons().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f(Boolean.FALSE);
        goto L4
    }

    public final void b0(QModel r4) {
        h0().getSortsVO().a(ECQuickUtilKt.a(Y()), new b(this), false);
        this.q.getCurrentTabLiveData().a(ECQuickUtilKt.a(Y()), c.a, false);
    }

    public final void d0(dj3.k r5) {
        if (r5.c() == null) goto L5;
        com.bytedance.android.ec.core.imagex.h0 r0 = com.bytedance.android.ec.core.imagex.h0.a;
        com.bytedance.android.shopping.store.tabkit.e.g((SimpleDraweeView) this.h.getValue(), r5.c());
        ((SimpleDraweeView) this.h.getValue()).setVisibility(0);
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r5.e()) == false) goto L12;
        e0().setText(r5.e());
        int r1 = com.bytedance.android.ec.core.utils.s.a;
        Integer r6 = com.bytedance.android.ec.core.utils.s.b(r5.f());
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
        e0().setTextColor(r7);
    L11:
        e0().setVisibility(0);
        return;
    L12:
        e0().setVisibility(8);
        return;
    L5:
        ((SimpleDraweeView) this.h.getValue()).setVisibility(8);
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (r12 == null) goto L7;
        if (kn.a.a(r12.getId()) != true) goto L7;
        return;
    L7:
        if (r12 == null) goto L9;
        Integer r13 = Integer.valueOf(r12.getId());
    L10:
        if (r13 != null) goto L13;
    L15:
        if (r13 != null) goto L18;
    L20:
        if (r13 != null) goto L23;
        return;
    L23:
        if (r13.intValue() == 2131372885) goto L25;
        return;
    L25:
        if (this.n == false) goto L56;
        if (Intrinsics.areEqual(this.o, "clothes_preview_button") == false) goto L48;
        h0().getLayoutType().setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
        ej3.f r14 = (ej3.f) h0().getSortsVO().getValue();
        if (r14 == null) goto L84;
        Map<String, dj3.k> r15 = r14.f;
        if (r15 == null) goto L84;
        dj3.k r16 = r15.get("double_column_button");
        if (r16 == null) goto L84;
        d0(r16);
        h0().isClothesSelected().setValue(Boolean.FALSE);
        List<com.bytedance.android.ec.store.repository.dto.c> r17 = h0().getSelectButtons();
        if (r17 == null) goto L46;
        Iterator<T> r18 = r17.iterator();
    L38:
        if (r18.hasNext() == false) goto L42;
        Object r1 = r18.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r1).e(), Boolean.TRUE) == false) goto L38;
    L43:
        com.bytedance.android.ec.store.repository.dto.c r2 = (com.bytedance.android.ec.store.repository.dto.c) r1;
        if (r2 == null) goto L46;
        ECShopHybridProductViewModel.refreshByDiscountSelect$default(h0(), r2.c(), null, 2, null);
    L47:
        h0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ALL_SAME);
        goto L84
    L42:
        r1 = null;
    L46:
        ECShopHybridProductViewModel.refreshByDiscountSelect$default(h0(), null, null, 3, null);
        Unit r19 = Unit.INSTANCE;
    L84:
        h0().doAnyEventActionWithBtm("a1.b6269.c2429.d57203", PageFinder.via(a0()), "store_product_form_switch_click", w.a(h0()), new Pair[0]);
        return;
    L48:
        h0().getLayoutType().setValue(LayoutTypes.RECYCLER_VIEW_ITEM_CLOTHES_PREVIEW);
        ej3.f r110 = (ej3.f) h0().getSortsVO().getValue();
        if (r110 == null) goto L84;
        Map<String, dj3.k> r111 = r110.f;
        if (r111 == null) goto L84;
        dj3.k r112 = r111.get("clothes_preview_button");
        if (r112 == null) goto L84;
        h0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ORDER_FIRST_IMAGE);
        d0(r112);
        h0().isClothesSelected().setValue(Boolean.TRUE);
        ECShopHybridProductViewModel.refreshByDiscountSelect$default(h0(), r112.d(), null, 2, null);
        goto L84
    L56:
        if (Intrinsics.areEqual(this.o, "single_column_button") == false) goto L58;
        String r113 = "double_column_button";
    L59:
        this.o = r113;
        int r3 = r113.hashCode();
        if (r3 == (-570803068)) goto L75;
        if (r3 == (-366423987)) goto L65;
        return;
    L65:
        if (r113.equals("double_column_button") == false) goto L90;
        jm.a<LayoutTypes> r114 = h0().getLayoutType();
        LayoutTypes r0 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r114.setValue(r0);
        ej3.f r115 = (ej3.f) h0().getSortsVO().getValue();
        if (r115 == null) goto L73;
        Map<String, dj3.k> r116 = r115.f;
        if (r116 == null) goto L73;
        dj3.k r117 = r116.get("double_column_button");
        if (r117 == null) goto L73;
        d0(r117);
    L73:
        com.bytedance.android.ec.sdk.helper.q.a.d("product_card_local_layout_type", r0.getType());
        goto L84
    L90:
        return;
    L75:
        if (r113.equals("single_column_button") == false) goto L91;
        jm.a<LayoutTypes> r118 = h0().getLayoutType();
        LayoutTypes r4 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        r118.setValue(r4);
        ej3.f r119 = (ej3.f) h0().getSortsVO().getValue();
        if (r119 == null) goto L83;
        Map<String, dj3.k> r120 = r119.f;
        if (r120 == null) goto L83;
        dj3.k r121 = r120.get("single_column_button");
        if (r121 == null) goto L83;
        d0(r121);
    L83:
        com.bytedance.android.ec.sdk.helper.q.a.d("product_card_local_layout_type", r4.getType());
        goto L84
    L91:
        return;
    L58:
        r113 = "single_column_button";
        goto L59
    L18:
        if (r13.intValue() != 2131372886) goto L20;
    L13:
        if (r13.intValue() != 2131372884) goto L15;
    L9:
        r13 = null;
        goto L10
    }

    public ECShopHorizonSortBarPresenter(Fragment r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.q = r3;
        this.f = LazyKt.lazy(new ECShopHorizonSortBarPresenter$viewModel$2(this));
        this.g = LazyKt.lazy(new ECShopHorizonSortBarPresenter$recyclerView$2(this));
        this.h = LazyKt.lazy(new ECShopHorizonSortBarPresenter$layoutSwitchIcon$2(this));
        this.i = LazyKt.lazy(new ECShopHorizonSortBarPresenter$layoutSwitchText$2(this));
        this.j = LazyKt.lazy(new ECShopHorizonSortBarPresenter$layoutSwitchIconContainer$2(this));
    }

    public final void i0(List<com.bytedance.android.ec.store.repository.vo.r> r5, com.bytedance.android.ec.store.repository.vo.r r6) {
        if (r6.o != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (r6.c == true) goto L10;
        return;
    L10:
        if (r6.d == true) goto L32;
        r6.g();
        com.bytedance.android.ec.store.repository.vo.r r7 = (com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.firstOrNull(r5);
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.e() == false) goto L23;
        List r1 = r7.n;
        if (r1 == null) goto L23;
        com.bytedance.android.ec.store.repository.vo.r r2 = (com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L23;
        r7 = r2;
    L23:
        if (r7.a == r6.a) goto L33;
        HorizonSortBarAdapter r8 = this.l;
        if (r8 == null) goto L34;
        Function1 r9 = r8.k;
        if (r9 == null) goto L35;
        Unit r10 = (Unit) r9.invoke(r7);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void k0(String r7, Map<String, ? extends Object> r8) {
        h0().doAnyEventActionWithBtm("a1.b6269.c2429.d0", PageFinder.via(((QFragmentPresenter) this).e), r7, r8, new Pair[]{TuplesKt.to("module_name", "shop_filter")});
    }

    public final void j0(String r5, String r6, String r7) {
        h0().doEventAction("click_ecommerce_store_sort", new Pair[]{TuplesKt.to("tab_name", "products"), TuplesKt.to("order_type", r5), TuplesKt.to("click_type", r6), TuplesKt.to("order_ascending", r7)});
    }
}
