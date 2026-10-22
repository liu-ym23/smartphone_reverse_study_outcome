package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandHeaderStyleDto;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.entity.ECTopSearchInfo;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECShopBasePresenter extends AbsECShopPresenter {
    public static final /* synthetic */ int t = 0;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;

    public final int d0() {
        return ((Number) this.n.getValue()).intValue();
    }

    public final int e0() {
        return ((Number) this.s.getValue()).intValue();
    }

    public final int f0() {
        return ((Number) this.m.getValue()).intValue();
    }

    public final boolean i0() {
        ECShopBasePresenter$isCurrentTabBigSale$1 r0 = ECShopBasePresenter$isCurrentTabBigSale$1.INSTANCE;
        ECStoreTabAreaVO r1 = (ECStoreTabAreaVO) T().getTabArea().getValue();
        if (r1 == null) goto L8;
        List<uj3.j> r2 = r1.b;
        if (r2 == null) goto L8;
        int r3 = com.bytedance.android.shopping.store.home.t.a;
        return com.bytedance.android.shopping.store.home.t.c(r2, N(), r0);
    L8:
        return false;
    }

    public final int m0() {
        int r0 = com.bytedance.android.shopping.store.home.p.a;
        int r1 = ((Number) this.j.getValue()).intValue();
        Integer r2 = (Integer) T().getStoreInfoAreaWithoutTipsHeight().getValue();
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L7:
        return (r1 + r3) + ((Number) this.l.getValue()).intValue();
    L5:
        r3 = 0;
        goto L7
    }

    public final Activity X() {
        Activity r0 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final float Z() {
        return RangesKt.coerceAtLeast(com.bytedance.android.shopping.extensions.k.e((Float) T().getCollapseFactor().getValue(), 0.0f), 0.0f);
    }

    public final float b0() {
        float r0 = Z();
        if (r0 < 0.5f) goto L7;
        return 1.0f;
    L7:
        return RangesKt.coerceAtLeast(r0 / 0.5f, 0.0f);
    }

    public final ECUrlModel c0() {
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L9;
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r0 == null) goto L14;
        ECShopBrandHeaderStyleDto r1 = r0.j;
        if (r1 == null) goto L14;
        return r1.getHeaderBackgroundImg();
    L14:
        return null;
    L9:
        com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r2 == null) goto L14;
        com.bytedance.android.shopping.store.home.entity.p r3 = r2.h;
        if (r3 == null) goto L14;
        return r3.a();
    }

    public final int h0() {
        if (U() == true) goto L7;
        return 0;
    L7:
        return Math.abs(((Number) T().getStoreSizeConfig().b.getValue()).intValue() - T().getStoreSizeConfig().d());
    }

    public final boolean j0() {
        if (T().isBrandShopUpgrade() == false) goto L5;
    L8:
        return true;
    L5:
        if (ECShopABSettings.getEC_SHOP_FRAMEWORK_OPT_V2() > 0) goto L8;
        return false;
    }

    public final Lifecycle k0() {
        return W().getLifecycle();
    }

    public final int n0() {
        Integer r0 = (Integer) T().getTopBarHeight().getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L11:
        if (D() == false) goto L14;
        r1 = d0();
    L14:
        return (r2 + r1) + m0();
    L5:
        int r3 = f0();
        if (G() == false) goto L8;
        int r4 = d0();
    L9:
        r2 = r3 + r4;
        goto L11
    L8:
        r4 = 0;
        goto L9
    }

    public View o0() {
        View r0 = y();
    L4:
        if (r0.getId() == 16908290) goto L12;
        if ((r0.getParent() instanceof View) == false) goto L12;
        Object r1 = r0.getParent();
        if (r1 == null) goto L11;
        r0 = (View) r1;
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L12:
        return r0;
    }

    public final boolean p0() {
        boolean r0 = i0();
        com.bytedance.android.shopping.store.home.entity.n r1 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.store.home.entity.p r2 = r1.h;
        if (r2 == null) goto L7;
        Integer r3 = r2.e();
    L8:
        if (r0 == false) goto L12;
        if (r3 != null) goto L12;
        return false;
    L12:
        if (r3 == null) goto L17;
        int r4 = StoreUITheme.OLD.ordinal();
        if (r3.intValue() == r4) goto L18;
        return true;
    L18:
        return r0;
    L17:
        return r0;
    L7:
        r3 = null;
        goto L8
    }

    public ECShopBasePresenter(Fragment r1) {
        super(r1);
        this.j = LazyKt.lazy(new ECShopBasePresenter$infoGroupOutsideTopMargin$2(this));
        this.k = LazyKt.lazy(new ECShopBasePresenter$infoGroupInsideBottomMargin$2(this));
        this.l = LazyKt.lazy(new ECShopBasePresenter$infoGroupOutsideBottomMargin$2(this));
        this.m = LazyKt.lazy(new ECShopBasePresenter$topBarHeightWithoutTips$2(this));
        this.n = LazyKt.lazy(new ECShopBasePresenter$liveTipsHeight$2(this));
        this.o = LazyKt.lazy(new ECShopBasePresenter$liveHeight$2(this));
        this.p = LazyKt.lazy(new ECShopBasePresenter$videoContainerHeight$2(this));
        this.q = LazyKt.lazy(new ECShopBasePresenter$croppedHeight$2(this));
        this.r = LazyKt.lazy(new ECShopBasePresenter$screenHeight$2(this));
        this.s = LazyKt.lazy(new ECShopBasePresenter$rootTabBarHeight$2(this));
    }

    public final float a0(float r3) {
        float r0 = Z();
        if (r0 > r3) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceAtMost((r0 - r3) / (1.0f - r3), 1.0f);
    }

    public static void Y(ECShopBasePresenter r8, GenericDraweeView r9, ECUrlModel r10) {
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "draweeView");
        int r11 = com.bytedance.android.ec.core.imagex.r.h;
        com.bytedance.android.ec.core.imagex.h0.d(r9, r10, com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home"), null, null, null, null, 96);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l0(ECShopBasePresenter r16, String r17, String r18, Integer r19, Map r20, Map r21, int r22) {
        String r1 = "";
        if ((r22 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r22 & 4) == 0) goto L13;
        Integer r3 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Map r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Map r6 = null;
    L22:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "searchKeyword");
        Intrinsics.checkNotNullParameter(r2, "searchHint");
        ECStoreParam r7 = r16.T().getStoreParam();
        JSONObject r8 = new JSONObject();
        if (r7.isEcShare() == false) goto L25;
        r8.put("is_ec_shopping", 1);
        r8.put("share_content", r7.getShareContent());
        r8.put("share_object", r7.getShareObject());
    L26:
        String r9 = r8.toString();
        ECTopSearchInfo r10 = (ECTopSearchInfo) r16.T().getTopSearchInfo().getValue();
        Uri.Builder r12 = UriProtector.parse("sslocal://goods/store/search").buildUpon();
        String r13 = r7.getStoreAccountParam().getUserId();
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L34:
        if ((!r14) == true) goto L37;
        r13 = null;
    L37:
        if (r13 == null) goto L39;
        r12.appendQueryParameter("uid", r13);
    L39:
        String r15 = r7.getStoreAccountParam().getSecUserId();
        if (r15 != null) goto L42;
    L45:
        boolean r110 = true;
    L47:
        if ((!r110) == true) goto L50;
        r15 = null;
    L50:
        if (r15 == null) goto L52;
        r12.appendQueryParameter("sec_uid", r15);
    L52:
        Unit r111 = Unit.INSTANCE;
        Gson r112 = new Gson();
        if (r10 == null) goto L55;
        List<SearchSuggestWord> r113 = r10.getWords();
    L56:
        Uri.Builder r11 = r12.appendQueryParameter("search_suggest_words", GsonProtectorUtils.toJson(r112, r113)).appendQueryParameter("sec_shop_id", r7.getSecShopId()).appendQueryParameter("shop_id", r7.getShopId()).appendQueryParameter("enter_from", r7.getEnterFrom()).appendQueryParameter("enter_method", r7.getEnterMethod()).appendQueryParameter("which_account", r7.getWhichAccount());
        String r114 = CommentScene.COMMENTSCENE_NO_AWEME;
        Uri.Builder r115 = r11.appendQueryParameter("is_search", CommentScene.COMMENTSCENE_NO_AWEME);
        if (r2.length() != 0) goto L59;
        boolean r116 = true;
    L60:
        if (r116 == false) goto L69;
        com.bytedance.android.shopping.store.home.entity.n r4 = (com.bytedance.android.shopping.store.home.entity.n) r16.T().getHeaderArea().getValue();
        if (r4 == null) goto L66;
        com.bytedance.android.shopping.store.home.entity.g r23 = r4.e;
        if (r23 == null) goto L66;
        r2 = r23.f;
    L67:
        if (r2 != null) goto L69;
        r2 = "";
    L66:
        r2 = null;
    L69:
        Uri.Builder r24 = r115.appendQueryParameter("search_hint", r2).appendQueryParameter("store_source_page", r7.getStoreSourcePage()).appendQueryParameter("store_source_method", r7.getStoreSourceMethod()).appendQueryParameter("store_group_type", r7.getStoreGroupType()).appendQueryParameter("search_params", r7.getSearchParams()).appendQueryParameter("entrance_location", r7.getEntranceLocation()).appendQueryParameter("follow_status", String.valueOf(r7.getFollowStatus())).appendQueryParameter("tmp_id", r7.getTempId()).appendQueryParameter("share_params", r9).appendQueryParameter("search_keyword", r0);
        StoreV3LiveRoomVO r25 = (StoreV3LiveRoomVO) r16.T().getLiveInfo().getValue();
        if (r25 == null) goto L72;
        String r26 = r25.getRoomId();
    L73:
        Uri.Builder r27 = r24.appendQueryParameter("room_id", r26);
        StoreV3LiveRoomVO r28 = (StoreV3LiveRoomVO) r16.T().getLiveInfo().getValue();
        if (r28 == null) goto L76;
        String r29 = r28.getAnchorId();
    L77:
        Uri.Builder r30 = r27.appendQueryParameter("anchor_id", r29).appendQueryParameter("pass_through_api", (String) r7.getPassThroughParam("pass_through_api"));
        if (r16.T().enableLiveTab() == true) goto L81;
        r114 = "0";
    L81:
        Uri.Builder r31 = r30.appendQueryParameter("enable_hide_float_live", r114);
        Activity r32 = com.bytedance.android.ec.core.utils.l0.b(r16.u().c());
        if (r32 == null) goto L84;
        String r33 = hm.c.e(r32);
    L85:
        Uri.Builder r34 = r31.appendQueryParameter("entrance_info", r33);
        Activity r35 = com.bytedance.android.ec.core.utils.l0.b(r16.u().c());
        if (r35 == null) goto L95;
        Intrinsics.checkNotNullParameter(r35, "$this$readShopInfoAsString");
        if ((r35 instanceof com.bytedance.android.ec.store.common.activity.b) == true) goto L92;
        ConcurrentHashMap r36 = hm.a.a;
        Intrinsics.checkNotNullParameter(r35, "activity");
        JSONObject r37 = (JSONObject) hm.a.b.get(Integer.valueOf(r35.hashCode()));
        if (r37 == null) goto L95;
        String r38 = r37.toString();
    L96:
        if (r38 == null) goto L99;
        r1 = r38;
    L99:
        Uri.Builder r39 = r34.appendQueryParameter("ec_shop_inner_info", r1).appendQueryParameter("temp_id", r7.getTempId());
        if (r6 == null) goto L105;
        Iterator r40 = r6.entrySet().iterator();
    L103:
        if (r40.hasNext() == false) goto L105;
        Map.Entry r41 = (Map.Entry) r40.next();
        r39.appendQueryParameter((String) r41.getKey(), (String) r41.getValue());
    L105:
        String r42 = r39.build().toString();
        uj3.j r43 = r16.T().getCurrentTab();
        if (r43 != null) goto L108;
    L110:
        String r44 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b6269.c5887.d2396", Boolean.TRUE).withView(r16.y()).build());
    L111:
        r16.T().setEnterOtherPageCollaspeHeader(true);
        Activity r45 = com.bytedance.android.ec.core.utils.l0.b(r16.u().c());
        if (r45 == null) goto L114;
        com.bytedance.android.ec.sdk.helper.p r46 = com.bytedance.android.ec.sdk.helper.p.a;
        int r47 = com.bytedance.android.ec.store.utils.b.a;
        String r48 = null;
        r46.d(com.bytedance.android.ec.store.utils.b.b(r42, r44, PageFinder.via(r16.h), null), r45);
    L115:
        ECStoreViewModel r49 = r16.T();
        Pair[] r50 = new Pair[4];
        if (r10 == null) goto L122;
        List<SearchSuggestWord> r51 = r10.getWords();
        if (r51 == null) goto L122;
        SearchSuggestWord r52 = (SearchSuggestWord) CollectionsKt.firstOrNull(r51);
        if (r52 == null) goto L122;
        String r53 = r52.getWord();
    L123:
        r50[0] = TuplesKt.to("icon_content", r53);
        r50[1] = TuplesKt.to("enter_from", "search_store");
        r50[2] = TuplesKt.to("author_id", r16.T().getStoreParam().getStoreAccountParam().getUserId());
        r50[3] = TuplesKt.to("btm_id", r44);
        r49.doAnyEventAction("enter_search", r5, r50);
        if (r3 != null) goto L127;
        return;
    L127:
        if (r3.intValue() != 2131371167) goto L135;
        uj3.j r54 = r16.T().getCurrentTab();
        if (r54 != null) goto L131;
        return;
    L131:
        if (r54.j() != true) goto L137;
        r16.T().doEventAction("shopsdk_enter_search", new Pair[]{TuplesKt.to("enter_from", "search_store"), TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", r16.T().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", r16.T().getStoreParam().getShopId()), TuplesKt.to("entrance_location", r16.T().getStoreParam().getEntranceLocation()), TuplesKt.to("page_name", "store_page")});
        return;
    L137:
        return;
    L135:
        return;
    L122:
        r53 = r48;
        goto L123
    L114:
        r48 = null;
        goto L115
    L108:
        if (r43.j() != true) goto L110;
        r44 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b0715.c674495", Boolean.TRUE).withView(r16.y()).build());
        goto L111
    L92:
        Intent r55 = r35.getIntent();
        if (r55 == null) goto L95;
        r38 = r55.getStringExtra("ec_shop_inner_info");
    L95:
        r38 = null;
        goto L96
    L84:
        r33 = null;
        goto L85
    L76:
        r29 = null;
        goto L77
    L72:
        r26 = null;
        goto L73
    L59:
        r116 = false;
        goto L60
    L55:
        r113 = null;
        goto L56
    L42:
        if (StringsKt.isBlank(r15) == true) goto L45;
        r110 = false;
        goto L47
    L29:
        if (StringsKt.isBlank(r13) == true) goto L32;
        r14 = false;
        goto L34
    L25:
        r8.put("is_ec_shopping", 0);
        goto L26
    L21:
        r6 = r21;
        goto L22
    L17:
        r5 = r20;
        goto L19
    L13:
        r3 = r19;
        goto L15
    L9:
        r2 = r18;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }
}
