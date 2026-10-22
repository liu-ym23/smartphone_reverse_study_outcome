package com.bytedance.android.shopping.store.aggregate.classification;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.product.presenter.utils.f;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregatePageFragment;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.view.ScrollableViewPager;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopClassificationFilterPresenter extends QPresenter {
    public final String e;
    public final Lazy f;
    public View g;
    public View h;
    public ECTabLayout i;
    public ScrollableViewPager j;
    public int k;
    public final b l;
    public final a m;
    public final ShopAggregatePageFragment n;

    public static final class a implements View.OnScrollChangeListener {
        public final /* synthetic */ ShopClassificationFilterPresenter a;

        public a(ShopClassificationFilterPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r1, int r2, int r3, int r4, int r5) {
            ShopClassificationFilterPresenter.D(this.a);
        }
    }

    public static final class b implements ECTabLayout.OnTabSelectedListener {
        public final /* synthetic */ ShopClassificationFilterPresenter a;

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(ECTabLayout.Tab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r1) {
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(ECTabLayout.Tab r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        public b(ShopClassificationFilterPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(ECTabLayout.Tab r5, boolean r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            dm.a.b r0 = dm.a.a;
            dm.a.a(this.a.e).a("onTabSelect, position: " + r5.getPosition() + ", isClicked: " + r6);
            ScrollableViewPager r1 = this.a.j;     // Catch: Exception -> L44
            if (r1 == null) goto L8;
            r1.setCurrentItem(r5.getPosition());     // Catch: Exception -> L44
        L8:
            if (r6 == false) goto L52;
            ScrollableViewPager r7 = this.a.j;     // Catch: Exception -> L44
            if (r7 == null) goto L12;
            PagerAdapter r8 = r7.getAdapter();     // Catch: Exception -> L44
        L14:
            if ((r8 instanceof ShopClassificationViewPagerAdapter) == true) goto L16;
            r8 = null;
        L16:
            ShopClassificationViewPagerAdapter r9 = (ShopClassificationViewPagerAdapter) r8;     // Catch: Exception -> L44
            if (r9 == null) goto L19;
            Fragment r10 = r9.getItem(r5.getPosition());     // Catch: Exception -> L44
        L21:
            if ((r10 instanceof ShopAggregateProductListFragment) == true) goto L23;
            r10 = null;
        L23:
            ShopAggregateProductListFragment r11 = (ShopAggregateProductListFragment) r10;     // Catch: Exception -> L44
            if (r11 != null) goto L26;
            return;
        L26:
            if (r11.isAdded() == false) goto L49;
            boolean r2 = true;
            if (r11.isDetached() != true) goto L30;
            return;
        L30:
            if (r11.getFragmentManager() == null) goto L51;
            this.a.F().getOnPageSelect().setValue(Unit.INSTANCE);     // Catch: Exception -> L44
            Object r12 = r5.getTag();     // Catch: Exception -> L44
            if ((r12 instanceof Map) == true) goto L35;
            r12 = null;
        L35:
            Map<String, String> r13 = (Map) r12;     // Catch: Exception -> L44
            if (r13 == null) goto L53;
            ShopClassificationFilterPresenter r3 = this.a;     // Catch: Exception -> L44
            if (r5.getPosition() == 0) goto L41;
            r2 = false;
        L41:
            r3.G(r13, PinchEnterMethod.CLICK, r2);     // Catch: Exception -> L44
            return;
        L53:
            return;
        L51:
            return;
        L49:
            return;
        L19:
            r10 = null;
            goto L21
        L12:
            r8 = null;
            goto L14
        L52:
            return;
        L44:
            e = move-exception;
            dm.a.b r14 = dm.a.a;
            dm.a.a(this.a.e).b("onTabSelect, error:: " + e, null);
        }
    }

    public final ShopAggregatePageViewModel F() {
        return (ShopAggregatePageViewModel) this.f.getValue();
    }

    public ShopClassificationFilterPresenter(ShopAggregatePageFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.n = r2;
        this.e = "ShopClassificationFilterPresenter";
        this.f = LazyKt.lazy(new ShopClassificationFilterPresenter$viewModel$2(this));
        this.l = new b(this);
        this.m = new a(this);
    }

    public static final void D(ShopClassificationFilterPresenter r15) {
        ECTabLayout r0 = r15.i;
        if (r0 == null) goto L38;
        Iterator r1 = ((ArrayList) e.k(r0)).iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L44;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECTabLayout.Tab r5 = (ECTabLayout.Tab) r3;
        View r6 = r5.getCustomView();
        String r7 = null;
        if ((r6 instanceof CategoryTabItemView) == true) goto L13;
        r6 = null;
    L13:
        CategoryTabItemView r8 = (CategoryTabItemView) r6;
        if (r8 == null) goto L37;
        ShopAggregatePageViewModel r9 = r15.F();
        ShopAggregateParam r10 = r15.F().getStoreParam();
        Object r11 = r5.getTag();
        if ((r11 instanceof Map) == true) goto L18;
        r11 = null;
    L18:
        Map r12 = (Map) r11;
        if (r2 != 0) goto L21;
        boolean r13 = true;
    L22:
        Intrinsics.checkNotNullParameter(r9, "eventAction");
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        if (r8.b == true) goto L37;
        if (wg.a.b(r8) <= 0.5d) goto L37;
        PageFinder r14 = PageFinder.via(r8);
        Pair[] r16 = new Pair[3];
        r16[0] = TuplesKt.to("sec_shop_id", r10.getSecShopId());
        if (r12 == null) goto L30;
        String r17 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r12, "category_id", null);
    L31:
        r16[1] = TuplesKt.to("category_id", r17);
        if (r13 == false) goto L34;
        r7 = "全部";
    L36:
        r16[2] = TuplesKt.to("category_name", r7);
        r9.doEventAction("shop_classification_category_show", "a1.b56317.c27743.d19191", r14, r16);
        r8.b = true;
        goto L37
    L34:
        if (r12 == null) goto L36;
        r7 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r12, "category_name", null);
        goto L36
    L30:
        r17 = null;
        goto L31
    L21:
        r13 = false;
    L37:
        r2 = r4;
        goto L6
    L44:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void A(QModel r11) {
        if (Intrinsics.areEqual(F().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        return;
    L10:
        CategoryInfo r13 = F().getStoreParam().getCategoryInfo();
        if (r13 != null) goto L13;
        return;
    L13:
        if (r13.canClassificationPageShowFilterTab() != true) goto L95;
        y().findViewById(2131380430).setVisibility(0);
        this.g = f.a(w().b(2131366921));
        this.h = f.a(w().b(2131366922));
        this.i = (ECTabLayout) f.a(w().b(2131366920));
        this.j = (ScrollableViewPager) f.a(w().b(2131366922));
        ECTabLayout r14 = this.i;
        if (r14 == null) goto L53;
        r14.setSelectedTabIndicatorFixedWidth(com.bytedance.android.shopping.extensions.b.b(20));
        CategoryInfo r2 = F().getStoreParam().getCategoryInfo();
        if (r2 == null) goto L53;
        List<Map<String, String>> r3 = r2.getSubCategoryList();
        if (r3 == null) goto L53;
        CategoryInfo r4 = F().getStoreParam().getCategoryInfo();
        if (r4 == null) goto L27;
        String r5 = r4.getAnchorSubCategoryId();
        if (r5 == null) goto L27;
    L28:
        List<Map<String, String>> r6 = r3;
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L30:
        if (r7.hasNext() == false) goto L38;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        if (Intrinsics.areEqual(com.bytedance.android.ecom.arch.slice.render.util.b.v((Map) r9, "category_id", null), r5) == false) goto L37;
        this.k = r10;
    L37:
        r8 = r10;
        goto L30
    L38:
        ECTabLayout.Tab r15 = r14.newTab();
        CategoryTabItemView r16 = new CategoryTabItemView(r14.getContext(), null, 6, 0);
        r16.setText("全部");
        Unit r17 = Unit.INSTANCE;
        r15.setCustomView(r16);
        CategoryInfo r18 = F().getStoreParam().getCategoryInfo();
        if (r18 == null) goto L41;
        Map<String, String> r19 = r18.getMainCategoryItem();
    L42:
        r15.setTag(r19);
        r14.addTab(r15, false);
        Iterator<T> r20 = r6.iterator();
        int r21 = 0;
    L44:
        if (r20.hasNext() == false) goto L52;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        Map r24 = (Map) r22;
        CategoryTabItemView r25 = new CategoryTabItemView(r14.getContext(), null, 6, 0);
        String r26 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r24, "category_name", null);
        if (r26 != null) goto L51;
        r26 = "";
    L51:
        r25.setText(r26);
        ECTabLayout.Tab r27 = r14.newTab();
        r27.setCustomView(r25);
        r27.setTag(r24);
        r14.addTab(r27, false);
        r21 = r23;
        goto L44
    L52:
        r14.addOnTabSelectedListener(this.l);
        r14.setOnScrollChangeListener(this.m);
        r14.post(new com.bytedance.android.shopping.store.aggregate.classification.b(this, r14));
        goto L53
    L41:
        r19 = null;
    L27:
        r5 = "";
    L53:
        CategoryInfo r110 = F().getStoreParam().getCategoryInfo();
        if (r110 == null) goto L90;
        final List<Map<String, String>> r111 = r110.getSubCategoryList();
        if (r111 == null) goto L96;
        CategoryInfo r28 = F().getStoreParam().getCategoryInfo();
        if (r28 == null) goto L91;
        final Map<String, String> r29 = r28.getMainCategoryItem();
        if (r29 == null) goto L97;
        FragmentManager r30 = this.n.getChildFragmentManager();
        if (r30 == null) goto L98;
        ShopClassificationViewPagerAdapter r31 = new ShopClassificationViewPagerAdapter(r30);
        ((ArrayList) r31.a).add(E(r29));
        Iterator<T> r32 = r111.iterator();
    L68:
        if (r32.hasNext() == false) goto L70;
        Map r33 = (Map) r32.next();
        ((ArrayList) r31.a).add(E(r33));
        goto L68
    L70:
        ScrollableViewPager r34 = this.j;
        if (r34 == null) goto L92;
        r34.setOffscreenPageLimit(r31.getCount());
        r34.setAdapter(r31);
        PagerAdapter r35 = r34.getAdapter();
        if (r35 == null) goto L75;
        r35.notifyDataSetChanged();
    L75:
        r34.addOnPageChangeListener(new ShopClassificationFilterPresenter$initViewPager$$inlined$apply$lambda$1(this, r29, r111));
        r34.setCurrentItem(this.k);
        int r36 = this.k;
        if (r36 != 0) goto L78;
        G(r29, CommentConstants$CmtLongPanelStrategy.DEFAULT, true);
        return;
    L78:
        Map<String, String> r112 = (Map) CollectionsKt.getOrNull(r111, r36 - 1);
        if (r112 == null) goto L94;
        G(r112, CommentConstants$CmtLongPanelStrategy.DEFAULT, false);
        return;
    L94:
        return;
    L92:
        return;
    L98:
        return;
    L97:
        return;
    L91:
        return;
    L96:
        return;
    L90:
        return;
    L95:
        return;
    L5:
        if (HybridPageConfigSetting.f == false) goto L7;
        r12 = true;
        goto L8
    }

    public final ShopAggregateProductListFragment E(Map r4) {
        ShopAggregateParam r0 = F().getStoreParam().deepCopy();
        r0.setShowCategoryTab(true);
        r0.getProductBasicRequestParam().setExtraParamMap(r4);
        int r5 = ShopAggregateProductListFragment.g;
        Intrinsics.checkNotNullParameter(r0, "storeParam");
        ShopAggregateProductListFragment r6 = new ShopAggregateProductListFragment();
        Bundle r1 = new Bundle();
        r1.putSerializable("store_param", r0);
        Unit r2 = Unit.INSTANCE;
        r6.setArguments(r1);
        return r6;
    }

    public final void G(Map<String, String> r6, String r7, boolean r8) {
        ShopAggregatePageViewModel r0 = F();
        PageFinder r1 = PageFinder.via(this.n);
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("sec_shop_id", F().getStoreParam().getSecShopId());
        r2[1] = TuplesKt.to("switch_type", r7);
        r2[2] = TuplesKt.to("category_id", com.bytedance.android.ecom.arch.slice.render.util.b.v(r6, "category_id", null));
        if (r8 == false) goto L5;
        String r9 = "全部";
    L6:
        r2[3] = TuplesKt.to("category_name", r9);
        r0.doEventAction("shop_classification_category_switch", "a1.b56317.c27743.d19191", r1, r2);
        return;
    L5:
        r9 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r6, "category_name", null);
        goto L6
    }
}
