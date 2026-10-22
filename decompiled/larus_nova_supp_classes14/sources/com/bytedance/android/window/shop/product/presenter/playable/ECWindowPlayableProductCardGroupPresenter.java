package com.bytedance.android.window.shop.product.presenter.playable;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.group.d;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo.f;
import yo.g;
import yo.h;
import yo.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ECWindowPlayableProductCardGroupPresenter extends j {
    public static final /* synthetic */ int v = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Map<String, Object> q;
    public final b r;
    public final ECWindowPlayableProductCardGroupPresenter$behavior$1 s;
    public final ECWindowPlayableProductCardGroupPresenter$eventReporter$1 t;
    public final d u;

    public static final class a {
        public a() {
        }

        public static Map a(ECWindowViewModel r19, BaseWindowTabViewModel r20, WindowV2ProductItemVO r21, WindowLayoutType r22, String r23) {
            BaseWindowTabViewModel r0 = r20;
            int r3 = ECWindowPlayableProductCardGroupPresenter.v;
            Intrinsics.checkNotNullParameter(r19, "viewModel");
            Intrinsics.checkNotNullParameter(r0, "tabViewModel");
            Intrinsics.checkNotNullParameter(r21, "item");
            Intrinsics.checkNotNullParameter(r23, "categoryId");
            Pair[] r4 = new Pair[42];
            boolean r6 = false;
            r4[0] = TuplesKt.to("author_id", r19.getShopParam().getAuthorId());
            r4[1] = TuplesKt.to("sec_author_id", r19.getShopParam().getSecAuthorId());
            r4[2] = TuplesKt.to("enter_from", r19.getShopParam().getEnterFrom());
            r4[3] = TuplesKt.to("entrance_location", r19.getShopParam().getEntranceLocation());
            r4[4] = TuplesKt.to("store_source_page", r19.getShopParam().getStoreSourcePage());
            r4[5] = TuplesKt.to("store_source_method", r19.getShopParam().getStoreSourceMethod());
            r4[6] = TuplesKt.to("store_group_type", r19.getShopParam().getStoreGroupType());
            r4[7] = TuplesKt.to("live_anchor_id", r19.getShopParam().getLiveAnchorId());
            r4[8] = TuplesKt.to("page_name", r19.getShopParam().getPageName());
            r4[9] = TuplesKt.to("source_page", r19.getShopParam().getPageName());
            r4[10] = TuplesKt.to("page_type", r19.getShopParam().getPageType());
            r4[11] = TuplesKt.to(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1004");
            r4[12] = TuplesKt.to("store_type", "window");
            r4[13] = TuplesKt.to("entrance_info", r19.getEntranceInfo());
            r4[14] = TuplesKt.to("entrance_location", r19.getShopParam().getEntranceLocation());
            r4[15] = TuplesKt.to("source_page", "store_page");
            r4[16] = TuplesKt.to("store_type", "window");
            String r5 = (String) r21.C.a(wn.a.d);
            if (r5 != null) goto L5;
            r5 = "product_card";
        L5:
            r4[17] = TuplesKt.to("ecom_entrance_form", r5);
            r4[18] = TuplesKt.to("ecom_group_type", "product");
            r4[19] = TuplesKt.to("product_id", r21.a);
            r4[20] = TuplesKt.to("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(r22));
            String r7 = r21.b;
            if (r7 != null) goto L8;
        L14:
            r7 = r21.a;
        L15:
            r4[21] = TuplesKt.to("commodity_id", r7);
            Long r8 = r21.c;
            if (r8 == null) goto L18;
            String r9 = String.valueOf(r8.longValue());
        L19:
            r4[22] = TuplesKt.to("commodity_type", r9);
            ECUrlModel r10 = r19.getShopParam().getBrandTag();
            String r11 = CommentScene.COMMENTSCENE_NO_AWEME;
            if (r10 == null) goto L22;
            Object r12 = CommentScene.COMMENTSCENE_NO_AWEME;
        L23:
            r4[23] = TuplesKt.to("brand_verified", r12);
            r4[24] = TuplesKt.to("search_params", r19.getShopParam().getSearchParams());
            r4[25] = TuplesKt.to("pre_product_id", r19.getShopParam().getPreProductId());
            r4[26] = TuplesKt.to("pre_room_id", r19.getShopParam().getPreRoomId());
            r4[27] = TuplesKt.to("pre_group_id", r19.getShopParam().getPreGroupId());
            Integer r13 = r19.getShopParam().getFollowStatus();
            if (r13 == null) goto L26;
            String r14 = String.valueOf(r13.intValue());
        L27:
            String r15 = "";
            if (r14 != null) goto L30;
            r14 = "";
        L30:
            r4[28] = TuplesKt.to("follow_status", r14);
            Map r16 = r21.s;
            if (r16 == null) goto L37;
            List r17 = (List) r16.get("ecom_shop_product_before");
            if (r17 == null) goto L37;
            ECRitTag r18 = (ECRitTag) CollectionsKt.firstOrNull(r17);
            if (r18 == null) goto L37;
            String r24 = r18.getTrackTag();
        L38:
            if (r24 != null) goto L40;
            r24 = "";
        L40:
            r4[29] = TuplesKt.to("label_name", r24);
            if (r21.f() == null) goto L43;
            Object r25 = CommentScene.COMMENTSCENE_NO_AWEME;
        L44:
            r4[30] = TuplesKt.to("is_product_info", r25);
            if (com.bytedance.android.shopping.anchorv3.a.b(r21.i) == false) goto L47;
            Object r26 = CommentScene.COMMENTSCENE_NO_AWEME;
        L48:
            r4[31] = TuplesKt.to("is_price_info", r26);
            if (r21.d() != null) goto L52;
            r11 = "0";
        L52:
            r4[32] = TuplesKt.to("is_recommend_info", r11);
            WindowV2ProductItemDTO.b r27 = r21.v;
            if (r27 == null) goto L55;
            String r28 = r27.a();
        L56:
            r4[33] = TuplesKt.to("content_form", r28);
            r4[34] = TuplesKt.to("tab_id", r23);
            r4[35] = TuplesKt.to("content_source", "shop");
            if ((r21 instanceof tq3.c) == true) goto L59;
            WindowV2ProductItemVO r2 = null;
        L60:
            tq3.c r29 = (tq3.c) r2;
            if (r29 == null) goto L72;
            List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r30 = r29.S;
            if (r30 == null) goto L72;
            ArrayList r110 = new ArrayList();
            Iterator<T> r31 = r30.iterator();
        L66:
            if (r31.hasNext() == false) goto L70;
            String r32 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r31.next()).c();
            if (r32 == null) goto L66;
            r110.add(r32);
            goto L66
        L70:
            String r33 = CollectionsKt.joinToString$default(r110, null, null, null, 0, null, null, 63, null);
            if (r33 == null) goto L72;
        L73:
            r4[36] = TuplesKt.to("product_tags", r33);
            if (r19.getShopParam().isEcShare() == false) goto L76;
            Pair r34 = TuplesKt.to("share_content", r19.getShopParam().getShareContent());
        L77:
            r4[37] = r34;
            if (r19.getShopParam().isEcShare() == false) goto L80;
            Pair r35 = TuplesKt.to("share_object", r19.getShopParam().getShareObject());
        L81:
            r4[38] = r35;
            boolean r36 = r0 instanceof BaseWindowTabViewModel;
            if (r36 == true) goto L84;
            BaseWindowTabViewModel r37 = null;
        L85:
            if (r37 == null) goto L88;
            String r38 = r37.getCategoryName();
            if (r38 == null) goto L88;
        L89:
            r4[39] = TuplesKt.to("classification_tab", r38);
            if (r36 == true) goto L92;
            BaseWindowTabViewModel r39 = null;
        L93:
            if (r39 == null) goto L96;
            String r40 = r39.getLastCategoryId();
            if (r40 == null) goto L96;
        L97:
            r4[40] = TuplesKt.to("classification_tab_id", r40);
            if (r36 == true) goto L100;
            r0 = null;
        L100:
            if (r0 == null) goto L105;
            String r1 = r0.getLastSubCategoryId();
            if (r1 == null) goto L105;
            r15 = r1;
        L105:
            r4[41] = TuplesKt.to("classification_sub_tab_id", r15);
            Map r41 = MapsKt.mutableMapOf(r4);
            r41.putAll(com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r21));
            String r42 = (String) r21.C.a(wn.a.a);
            if (r42 == null) goto L108;
            r41.put("tab_name", r42);
        L108:
            String r43 = (String) r21.C.a(wn.a.e);
            if (r43 == null) goto L111;
            r41.put("tab_name_second", r43);
        L111:
            Integer r44 = (Integer) r21.C.a(wn.a.f);
            if (r44 == null) goto L114;
            r41.put("window_item_type", String.valueOf(r44.intValue()));
        L114:
            return r41;
        L96:
            r40 = "";
            goto L97
        L92:
            r39 = r0;
        L88:
            r38 = "";
            goto L89
        L84:
            r37 = r0;
            goto L85
        L80:
            r35 = TuplesKt.to("", "");
            goto L81
        L76:
            r34 = TuplesKt.to("", "");
        L72:
            r33 = "";
            goto L73
        L59:
            r2 = r21;
            goto L60
        L55:
            r28 = "";
            goto L56
        L47:
            r26 = "0";
            goto L48
        L43:
            r25 = "0";
        L37:
            r24 = null;
            goto L38
        L26:
            r14 = null;
            goto L27
        L22:
            r12 = "0";
            goto L23
        L18:
            r9 = null;
            goto L19
        L8:
            if (r7.length() <= 0) goto L10;
            r6 = true;
        L10:
            if (r6 == true) goto L13;
            r7 = null;
        L13:
            if (r7 != null) goto L15;
            goto L14
        }
    }

    public static final class b implements h {
        public final /* synthetic */ ECWindowPlayableProductCardGroupPresenter a;
        public final /* synthetic */ WindowLayoutType b;

        public final Function3<String, String, Long, Unit> b() {
            return null;
        }

        public final Function1<Integer, Unit> e() {
            return null;
        }

        public final void g() {
        }

        public final boolean isClickable() {
            return true;
        }

        public final String a() {
            return this.a.n0().getShopParam().getAuthorId();
        }

        public final WindowLayoutTypes c() {
            WindowLayoutType r0 = this.b;
            if (r0 == null) goto L8;
            if (r0.isSingleColumn() != true) goto L8;
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        L8:
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        }

        public final String d() {
            return this.a.n0().getShopParam().getSecAuthorId();
        }

        public final ap.c f() {
            return this.a.n0().getTagPools();
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_home_product_card");
        }

        public b(ECWindowPlayableProductCardGroupPresenter r1, WindowLayoutType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        new a();
    }

    public final BaseWindowTabViewModel m0() {
        return (BaseWindowTabViewModel) this.o.getValue();
    }

    public final ECWindowViewModel n0() {
        return (ECWindowViewModel) this.n.getValue();
    }

    public final g e0() {
        return this.s;
    }

    public final h h0() {
        return this.r;
    }

    public final f i0() {
        return this.t;
    }

    public String l0(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return k0(r2, "d066686");
    }

    public final String k0(WindowV2ProductItemVO r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "dNode");
        Integer r5 = (Integer) r3.C.a(wn.a.C);
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
        String r0 = (String) n0().getSecondaryPageParams().d.a(wn.a.c);
        if (r0 != null) goto L8;
        r0 = "a1.b7635.c68164";
    L8:
        return r0 + '.' + r4 + "_i" + r6;
    L9:
        return "";
    }

    public ECWindowPlayableProductCardGroupPresenter(final Fragment r2, WindowLayoutType r3, Function1<? super String, String> r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "schemaProcessor");
        super(r2);
        this.u = r5;
        this.n = LazyKt.lazy(new ECWindowPlayableProductCardGroupPresenter$viewModel$2(this));
        this.o = LazyKt.lazy(new ECWindowPlayableProductCardGroupPresenter$tabViewModel$2(this, r2));
        this.p = LazyKt.lazy(new ECWindowPlayableProductCardGroupPresenter$btmHost$2(this));
        this.q = new LinkedHashMap();
        this.r = new b(this, r3);
        this.s = new ECWindowPlayableProductCardGroupPresenter$behavior$1(this, r3, r2);
        this.t = new ECWindowPlayableProductCardGroupPresenter$eventReporter$1(this, r3);
    }
}
