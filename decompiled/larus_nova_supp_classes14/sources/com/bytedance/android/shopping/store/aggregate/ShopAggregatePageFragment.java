package com.bytedance.android.shopping.store.aggregate;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.router.hybridpage.fragment.ShopClassificationHybridPageFragment;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/ShopAggregatePageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lpm/a;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageFragment extends Fragment implements QViewModelOwner, pm.a {
    public static final a h = null;
    public final Lazy d;
    public final com.bytedance.android.ec.core.arch.viewmodel.c e;
    public final QUIManager f;
    public boolean g;

    public static final class a {
        public a() {
        }

        public static void a(final Context r17, Uri r18, String r19, String r20, String r21, String r22, String r23, final String r24, final String r25, String r26, String r27, String r28, boolean r29, String r30, String r31, String r32, String r33, boolean r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, int r56, String r57, String r58) {
            Intrinsics.checkNotNullParameter(r17, "fromAct");
            Intrinsics.checkNotNullParameter(r18, "uri");
            Intrinsics.checkNotNullParameter(r19, "uid");
            Intrinsics.checkNotNullParameter(r20, "secUid");
            Intrinsics.checkNotNullParameter(r21, "shopId");
            Intrinsics.checkNotNullParameter(r22, "secShopId");
            Intrinsics.checkNotNullParameter(r23, "entranceLocation");
            Intrinsics.checkNotNullParameter(r24, "enterFrom");
            Intrinsics.checkNotNullParameter(r25, "enterMethod");
            Intrinsics.checkNotNullParameter(r26, "materialId");
            Intrinsics.checkNotNullParameter(r27, "materialTitle");
            Intrinsics.checkNotNullParameter(r28, "token");
            Intrinsics.checkNotNullParameter(r30, "tempId");
            Intrinsics.checkNotNullParameter(r31, "followStatus");
            Intrinsics.checkNotNullParameter(r32, "customIds");
            Intrinsics.checkNotNullParameter(r33, "customIdType");
            Intrinsics.checkNotNullParameter(r35, "storeSourcePage");
            Intrinsics.checkNotNullParameter(r36, "storeSourceMethod");
            Intrinsics.checkNotNullParameter(r37, "storeGroupType");
            Intrinsics.checkNotNullParameter(r38, "passThroughApi");
            Intrinsics.checkNotNullParameter(r39, "logExtra");
            Intrinsics.checkNotNullParameter(r40, "tabNameSecond");
            Intrinsics.checkNotNullParameter(r41, "tabName");
            Intrinsics.checkNotNullParameter(r42, "roomId");
            Intrinsics.checkNotNullParameter(r43, "anchorId");
            Intrinsics.checkNotNullParameter(r44, "pageType");
            Intrinsics.checkNotNullParameter(r45, "tmpId");
            Intrinsics.checkNotNullParameter(r46, "metaInfo");
            Intrinsics.checkNotNullParameter(r47, "tabLabel");
            Intrinsics.checkNotNullParameter(r48, "categoryId");
            Intrinsics.checkNotNullParameter(r49, "tabType");
            Intrinsics.checkNotNullParameter(r50, "pageVersion");
            Intrinsics.checkNotNullParameter(r51, "preProductId");
            Intrinsics.checkNotNullParameter(r52, "preGroupId");
            Intrinsics.checkNotNullParameter(r53, "preRoomId");
            Intrinsics.checkNotNullParameter(r54, "searchParams");
            Intrinsics.checkNotNullParameter(r57, "categoryInfo");
            Intrinsics.checkNotNullParameter(r58, "entranceInfo");
            String r15 = UriProtector.getQueryParameter(r18, "live_user_act_params");
            if (r15 != null) goto L5;
            r15 = "";
        L5:
            final ShopAggregateParam r13 = new ShopAggregateParam(r22);
            r13.setShopId(r21);
            r13.getStoreAccountParam().setUserId(r19);
            r13.getStoreAccountParam().setSecUserId(r20);
            r13.setEntranceLocation(r23);
            r13.setEnterFrom(r24);
            r13.setEnterMethod(r25);
            r13.getProductBasicRequestParam().setMaterialId(r26);
            r13.getStoreUIParam().setMaterialTitle(r27);
            r13.getProductBasicRequestParam().setToken(r28);
            r13.setTempId(r30);
            r13.setShowAddCart(r29);
            r13.setFollowStatus(StringsKt.toIntOrNull(r31));
            r13.getProductBasicRequestParam().setCustom(false);
            r13.setTabNameSecond(r40);
            r13.setTabName(r41);
            r13.setTagData(r55);
            r13.setSelectIndex(r56);
            r13.setRoomId(r42);
            r13.setAnchorId(r43);
            r13.setPageType(r44);
            r13.getProductBasicRequestParam().setTmpId(r45);
            r13.setMetaInfo(r46);
            r13.setTabLabel(r47);
            r13.setCategoryId(r48);
            r13.setClassificationTabType(r49);
            if (Intrinsics.areEqual(r44, AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L8;
            String r0 = "classification_secondary_page";
        L9:
            r13.setPageName(r0);
            r13.setPageVersion(r50);
            r13.setProductCnt(k.r(UriProtector.getQueryParameter(r18, "product_cnt"), 0));
            r13.putPassThroughParam("pass_through_api", com.bytedance.android.ec.store.utils.k.a(r38, r23, r35, r37, r52, r51, r53, r15, null));
            r13.getProductBasicRequestParam().setCustomIds(r32);
            r13.getProductBasicRequestParam().setCustomIdType(StringsKt.toIntOrNull(r33));
            r13.setStoreSourcePage(r35);
            r13.setStoreSourceMethod(r36);
            r13.setSourceBtmToken(UriProtector.getQueryParameter(r18, "source_btm_token"));
            r13.setStoreGroupType(r37);
            r13.setEntranceInfo(r58);
            String r1 = UriProtector.getQueryParameter(r18, "page_params");
            if (r1 != null) goto L12;
            r1 = "";
        L12:
            r13.setPageParams(r1);
            r13.setCategoryInfoStr(r57);
            JSONObject r2 = z1.g(r39);
            if (r2 != null) goto L15;
        L19:
            r13.setSearchParams(r54);
            if (com.bytedance.android.shopping.store.settings.c.a() != 1) goto L26;
            ProductBasicRequestParam r3 = r13.getProductBasicRequestParam();
            CategoryInfo r4 = r13.getCategoryInfo();
            if (r4 == null) goto L24;
            Map<String, String> r5 = r4.getMainCategoryItem();
        L25:
            r3.setExtraParamMap(r5);
            goto L26
        L24:
            r5 = null;
        L26:
            Lazy r6 = ECStoreFoldPhoneHelper.a;
            if ((r17 instanceof Activity) == true) goto L29;
            Context r7 = null;
        L30:
            ECStoreFoldPhoneHelper.h((Activity) r7);
            n.b(r17, r34, null, new ShopAggregatePageFragment$Companion$start$1(r24, r25, r17, r13), ShopAggregatePageFragment$Companion$start$2.INSTANCE);
            return;
        L29:
            r7 = r17;
            goto L30
        L15:
            if (k.c(r2.optString("is_ec_shopping")) == false) goto L19;
            if (Intrinsics.areEqual(r2.optString("is_ec_shopping"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L19;
            r13.setEcShare(true);
            r13.setShareContent(r2.optString("share_content"));
            r13.setShareObject(r2.optString("share_object"));
            goto L19
        L8:
            r0 = "store_page";
            goto L9
        }
    }

    public final ShopAggregatePageViewModel S90() {
        return (ShopAggregatePageViewModel) this.e.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.d.getValue();
    }

    static {
        h = new a();
    }

    public final void bindModule() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        this.f.c(ri3.b.class, null);
    }

    public ShopAggregatePageFragment() {
        this.d = LazyKt.lazy(ShopAggregatePageFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ShopAggregatePageFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new ShopAggregatePageFragment$$special$$inlined$viewModels$1(this);
        this.e = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ShopAggregatePageViewModel.class), new ShopAggregatePageFragment$$special$$inlined$viewModels$2(r1), r0);
        this.f = new QUIManager();
    }

    public final boolean T90() {
        if (Intrinsics.areEqual(S90().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L7;
        Lazy r0 = HybridPageConfigSetting.a;
        if (HybridPageConfigSetting.f == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f.r(ri3.b.class);
    }

    public final void onResume() {
        super.onResume();
        if (S90().isStoreParamInit() == true) goto L5;
        return;
    L5:
        ShopAggregateParam r0 = S90().getStoreParam();
        if (Intrinsics.areEqual(r0.getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L8;
        return;
    L8:
        if (com.bytedance.android.shopping.store.settings.c.a() != 1) goto L16;
        CategoryInfo r1 = r0.getCategoryInfo();
        if (r1 == null) goto L14;
        List<Map<String, String>> r2 = r1.getSubCategoryList();
        if (r2 == null) goto L14;
        int r3 = r2.size();
    L15:
        String r4 = String.valueOf(r3);
    L17:
        S90().doEventAction("classification_secondary_page_show", "a1.b56317", PageFinder.via(this), new Pair[]{TuplesKt.to("page_name", r0.getTabLabel()), TuplesKt.to("entrance_location", r0.getEntranceLocation()), TuplesKt.to("product_cnt", String.valueOf(r0.getProductCnt())), TuplesKt.to("category_count", r4)});
        return;
    L14:
        r3 = 0;
        goto L15
    L16:
        r4 = null;
        goto L17
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        if (r7 == null) goto L5;
        Serializable r8 = r7.getSerializable("store_param");
    L7:
        if ((r8 instanceof ShopAggregateParam) == true) goto L9;
        r8 = null;
    L9:
        ShopAggregateParam r9 = (ShopAggregateParam) r8;
        if (r9 != null) goto L12;
        return;
    L12:
        Lazy r1 = BtmSDKWrapper.a;
        String r2 = r9.getPageType();
        AggregatePageTypes r3 = AggregatePageTypes.CLASSIFICATION;
        if (Intrinsics.areEqual(r2, r3.getType()) == false) goto L15;
        String r4 = "a1.b56317";
    L16:
        BtmSDKWrapper.b(this, r4, r9.getSourceBtmToken());
        if (Intrinsics.areEqual(r9.getPageType(), r3.getType()) == false) goto L19;
        qm.a.b("ec_perf_duration_shop_classification");
        qm.a.a("ec_perf_duration_shop_classification", "initial", System.currentTimeMillis());
    L19:
        ShopAggregatePageViewModel.init$default(S90(), r9, false, 2, null);
        return;
    L15:
        Intrinsics.areEqual(r2, AggregatePageTypes.FULL_DISCOUNT.getType());
        r4 = "a1.b741019";
        goto L16
    L5:
        r8 = null;
        goto L7
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        bindModule();
        if (T90() == false) goto L24;
        View r10 = getView();
        if (r10 == null) goto L9;
        View r11 = r10.findViewById(2131387282);
        if (r11 == null) goto L9;
        r11.setVisibility(8);
    L9:
        View r12 = getView();
        if (r12 == null) goto L14;
        View r13 = r12.findViewById(2131374277);
        if (r13 == null) goto L14;
        r13.setVisibility(8);
    L14:
        View r14 = getView();
        if (r14 == null) goto L47;
        View r15 = r14.findViewById(2131387434);
        if (r15 == null) goto L47;
        ViewGroup.LayoutParams r2 = r15.getLayoutParams();
        if ((r2 instanceof RelativeLayout.LayoutParams) == true) goto L21;
        r2 = null;
    L21:
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r2;
        if (r3 == null) goto L47;
        r3.removeRule(3);
        r3.addRule(10);
        r15.setLayoutParams(r3);
    L47:
        if (T90() == true) goto L53;
        CategoryInfo r16 = S90().getStoreParam().getCategoryInfo();
        if (r16 == null) goto L53;
        if (r16.canClassificationPageShowFilterTab() != true) goto L53;
        return;
    L53:
        if (T90() == false) goto L55;
        int r17 = ShopClassificationHybridPageFragment.h;
        ShopAggregateParam r18 = S90().getStoreParam();
        Intrinsics.checkNotNullParameter(r18, "storeParam");
        Fragment r4 = new ShopClassificationHybridPageFragment();
        Bundle r5 = new Bundle();
        r5.putSerializable("store_param", r18);
        Unit r19 = Unit.INSTANCE;
        r4.setArguments(r5);
    L56:
        FragmentTransaction r20 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r20, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131387434) == true) goto L60;
        r20 = r20.add(2131387434, r4);
    L60:
        r20.commitNowAllowingStateLoss();
        return;
    L55:
        int r21 = ShopAggregateProductListFragment.g;
        ShopAggregateParam r22 = S90().getStoreParam();
        Intrinsics.checkNotNullParameter(r22, "storeParam");
        r4 = new ShopAggregateProductListFragment();
        Bundle r6 = new Bundle();
        r6.putSerializable("store_param", r22);
        Unit r23 = Unit.INSTANCE;
        r4.setArguments(r6);
        goto L56
    L24:
        View r24 = getView();
        if (r24 == null) goto L30;
        View r25 = r24.findViewById(2131392468);
        if (r25 == null) goto L30;
        d2.d(r25, com.bytedance.android.shopping.extensions.b.b(7), 0, com.bytedance.android.shopping.extensions.b.b(0), 0);
        r25.setOnClickListener(new com.bytedance.android.shopping.store.aggregate.a(this));
    L30:
        if (S90().getStoreParam().isSplitMode() == false) goto L47;
        View r26 = getView();
        if (r26 == null) goto L36;
        View r27 = r26.findViewById(2131386222);
        if (r27 == null) goto L36;
        d2.d(r27, 0, com.bytedance.android.shopping.extensions.b.b(10), 0, 0);
    L36:
        View r28 = getView();
        if (r28 == null) goto L41;
        View r29 = r28.findViewById(2131371063);
        if (r29 == null) goto L41;
        ExtensionsKt.visible(r29);
        r29.setOnClickListener(new b(this));
    L41:
        View r30 = getView();
        if (r30 == null) goto L47;
        View r31 = r30.findViewById(2131374277);
        if (r31 == null) goto L47;
        r31.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, 0);
        goto L47
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.f;
        View r8 = th.a.c(requireContext(), 2131561064, null, false);
        if (r8 == null) goto L7;
        r7.k(new ri3.b((ViewGroup) r8, this), requireContext(), this);
        return this.f.p();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
