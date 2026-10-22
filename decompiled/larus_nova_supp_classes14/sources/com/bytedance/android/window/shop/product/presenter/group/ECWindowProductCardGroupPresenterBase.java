package com.bytedance.android.window.shop.product.presenter.group;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.BaseTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yo.g;
import yo.h;
import yo.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECWindowProductCardGroupPresenterBase extends j {
    public static final a w = null;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Map<String, Object> q;
    public final Lazy r;
    public final b s;
    public final ECWindowProductCardGroupPresenterBase$behavior$1 t;
    public final ECWindowProductCardGroupPresenterBase$eventReporter$1 u;
    public final d v;

    public static final class a {
        public a() {
        }

        public static String c(WindowV2ProductItemVO r1, BaseTabViewModel r2) {
            if ((r2 instanceof BaseWindowTabViewModel) == true) goto L5;
            r2 = null;
        L5:
            BaseWindowTabViewModel r3 = (BaseWindowTabViewModel) r2;
            if (r3 == null) goto L11;
            String r4 = r3.getLastSubCategoryId();
            if (r4 == null) goto L11;
            String r5 = a2.d(r4);
            if (r5 == null) goto L11;
        L12:
            if (r5 != null) goto L15;
            return CommentServiceId.HOT_SPOT;
        L15:
            return r5;
        L11:
            r5 = (String) r1.C.a(wn.a.e);
            goto L12
        }

        public static Map a(ECWindowViewModel r22, BaseTabViewModel r23, WindowV2ProductItemVO r24, WindowLayoutType r25, String r26, String r27) {
            Intrinsics.checkNotNullParameter(r22, "viewModel");
            Intrinsics.checkNotNullParameter(r23, "tabViewModel");
            Intrinsics.checkNotNullParameter(r24, "item");
            Intrinsics.checkNotNullParameter(r26, "categoryId");
            f r3 = (f) r24.C.a(wn.a.D);
            Pair[] r6 = new Pair[43];
            int r8 = 0;
            r6[0] = TuplesKt.to("author_id", r22.getShopParam().getAuthorId());
            boolean r9 = true;
            r6[1] = TuplesKt.to("sec_author_id", r22.getShopParam().getSecAuthorId());
            r6[2] = TuplesKt.to("enter_from", r22.getShopParam().getEnterFrom());
            r6[3] = TuplesKt.to("entrance_location", r22.getShopParam().getEntranceLocation());
            r6[4] = TuplesKt.to("store_source_page", r22.getShopParam().getStoreSourcePage());
            r6[5] = TuplesKt.to("store_source_method", r22.getShopParam().getStoreSourceMethod());
            r6[6] = TuplesKt.to("store_group_type", r22.getShopParam().getStoreGroupType());
            r6[7] = TuplesKt.to("live_anchor_id", r22.getShopParam().getLiveAnchorId());
            r6[8] = TuplesKt.to("page_name", r22.getShopParam().getPageName());
            r6[9] = TuplesKt.to("source_page", r22.getShopParam().getPageName());
            r6[10] = TuplesKt.to("page_type", r22.getShopParam().getPageType());
            r6[11] = TuplesKt.to(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1004");
            r6[12] = TuplesKt.to("store_type", "window");
            if (r27 != null) goto L5;
            String r13 = r22.getEntranceInfo();
        L6:
            r6[13] = TuplesKt.to("entrance_info", r13);
            r6[14] = TuplesKt.to("entrance_location", r22.getShopParam().getEntranceLocation());
            r6[15] = TuplesKt.to("source_page", "store_page");
            r6[16] = TuplesKt.to("store_type", "window");
            String r7 = (String) r24.C.a(wn.a.d);
            if (r7 != null) goto L9;
            r7 = "product_card";
        L9:
            r6[17] = TuplesKt.to("ecom_entrance_form", r7);
            r6[18] = TuplesKt.to("ecom_group_type", "product");
            r6[19] = TuplesKt.to("product_id", r24.a);
            r6[20] = TuplesKt.to("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(r25));
            String r10 = r24.b;
            BaseTabViewModel r11 = null;
            if (r10 != null) goto L12;
        L19:
            r10 = r24.a;
        L20:
            r6[21] = TuplesKt.to("commodity_id", r10);
            Long r12 = r24.c;
            if (r12 == null) goto L23;
            String r14 = String.valueOf(r12.longValue());
        L24:
            r6[22] = TuplesKt.to("commodity_type", r14);
            ECUrlModel r15 = r22.getShopParam().getBrandTag();
            String r16 = CommentScene.COMMENTSCENE_NO_AWEME;
            if (r15 == null) goto L27;
            Object r17 = CommentScene.COMMENTSCENE_NO_AWEME;
        L28:
            r6[23] = TuplesKt.to("brand_verified", r17);
            r6[24] = TuplesKt.to("search_params", r22.getShopParam().getSearchParams());
            r6[25] = TuplesKt.to("pre_product_id", r22.getShopParam().getPreProductId());
            r6[26] = TuplesKt.to("pre_room_id", r22.getShopParam().getPreRoomId());
            r6[27] = TuplesKt.to("pre_group_id", r22.getShopParam().getPreGroupId());
            Integer r18 = r22.getShopParam().getFollowStatus();
            if (r18 == null) goto L31;
            String r19 = String.valueOf(r18.intValue());
        L32:
            String r110 = "";
            if (r19 != null) goto L35;
            r19 = "";
        L35:
            r6[28] = TuplesKt.to("follow_status", r19);
            Map r20 = r24.s;
            if (r20 == null) goto L42;
            List r21 = (List) r20.get("ecom_shop_product_before");
            if (r21 == null) goto L42;
            ECRitTag r28 = (ECRitTag) CollectionsKt.firstOrNull(r21);
            if (r28 == null) goto L42;
            String r29 = r28.getTrackTag();
        L43:
            if (r29 != null) goto L45;
            r29 = "";
        L45:
            r6[29] = TuplesKt.to("label_name", r29);
            if (r24.f() == null) goto L48;
            Object r30 = CommentScene.COMMENTSCENE_NO_AWEME;
        L49:
            r6[30] = TuplesKt.to("is_product_info", r30);
            if (k.c(r24.i) == false) goto L52;
            Object r31 = CommentScene.COMMENTSCENE_NO_AWEME;
        L53:
            r6[31] = TuplesKt.to("is_price_info", r31);
            if (r24.d() != null) goto L57;
            r16 = "0";
        L57:
            r6[32] = TuplesKt.to("is_recommend_info", r16);
            WindowV2ProductItemDTO.b r32 = r24.v;
            if (r32 == null) goto L60;
            String r33 = r32.a();
        L61:
            r6[33] = TuplesKt.to("content_form", r33);
            r6[34] = TuplesKt.to("tab_id", r26);
            r6[35] = TuplesKt.to("content_source", "shop");
            if (r3 == null) goto L68;
            Map<String, ? extends Map<String, String>> r2 = r3.d;
            if (r2 == null) goto L68;
            Set<String> r4 = r2.keySet();
            if (r4 == null) goto L68;
            String r5 = CollectionsKt.joinToString$default(r4, ",", null, null, 0, null, null, 62, null);
        L69:
            r6[36] = TuplesKt.to("ui_elements", r5);
            if ((r24 instanceof tq3.c) == true) goto L72;
            WindowV2ProductItemVO r34 = null;
        L73:
            tq3.c r35 = (tq3.c) r34;
            if (r35 == null) goto L85;
            List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r36 = r35.S;
            if (r36 == null) goto L85;
            ArrayList r111 = new ArrayList();
            Iterator<T> r37 = r36.iterator();
        L79:
            if (r37.hasNext() == false) goto L83;
            String r38 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r37.next()).c();
            if (r38 == null) goto L79;
            r111.add(r38);
            goto L79
        L83:
            String r39 = CollectionsKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null);
            if (r39 == null) goto L85;
        L86:
            r6[37] = TuplesKt.to("product_tags", r39);
            if (r22.getShopParam().isEcShare() == false) goto L89;
            Pair r40 = TuplesKt.to("share_content", r22.getShopParam().getShareContent());
        L90:
            r6[38] = r40;
            if (r22.getShopParam().isEcShare() == false) goto L93;
            Pair r41 = TuplesKt.to("share_object", r22.getShopParam().getShareObject());
        L94:
            r6[39] = r41;
            boolean r42 = r23 instanceof BaseWindowTabViewModel;
            if (r42 == true) goto L97;
            BaseTabViewModel r43 = null;
        L98:
            BaseWindowTabViewModel r44 = (BaseWindowTabViewModel) r43;
            if (r44 == null) goto L102;
            String r45 = r44.getCategoryName();
            if (r45 == null) goto L102;
        L103:
            r6[40] = TuplesKt.to("classification_tab", r45);
            if (r42 == true) goto L106;
            BaseTabViewModel r46 = null;
        L107:
            BaseWindowTabViewModel r47 = (BaseWindowTabViewModel) r46;
            if (r47 == null) goto L111;
            String r48 = r47.getLastCategoryId();
            if (r48 == null) goto L111;
        L112:
            r6[41] = TuplesKt.to("classification_tab_id", r48);
            if (r42 == false) goto L116;
            r11 = r23;
        L116:
            BaseWindowTabViewModel r112 = (BaseWindowTabViewModel) r11;
            if (r112 == null) goto L122;
            String r49 = r112.getLastSubCategoryId();
            if (r49 == null) goto L122;
            r110 = r49;
        L122:
            r6[42] = TuplesKt.to("classification_sub_tab_id", r110);
            LinkedHashMap r50 = new LinkedHashMap();
        L123:
            if (r8 >= 43) goto L130;
            Pair r51 = r6[r8];
            String r52 = (String) r51.component1();
            Object r53 = r51.component2();
            if (StringsKt.isBlank(r52) == true) goto L129;
            if (r53 == null) goto L129;
            r50.put(r52, r53);
        L129:
            r8 = r8 + 1;
            goto L123
        L130:
            r50.putAll(com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r24));
            String r54 = (String) r24.C.a(wn.a.a);
            if (r54 == null) goto L133;
            r50.put("tab_name", r54);
        L133:
            r50.put("tab_name_second", c(r24, r23));
            Integer r0 = (Integer) r24.C.a(wn.a.f);
            if (r0 == null) goto L136;
            r50.put("window_item_type", String.valueOf(r0.intValue()));
        L136:
            Map r1 = r24.q;
            if (r1 == null) goto L139;
            r50.putAll(r1);
        L139:
            return r50;
        L111:
            r48 = "";
            goto L112
        L106:
            r46 = r23;
        L102:
            r45 = "";
            goto L103
        L97:
            r43 = r23;
            goto L98
        L93:
            r41 = TuplesKt.to("", "");
            goto L94
        L89:
            r40 = TuplesKt.to("", "");
        L85:
            r39 = "";
            goto L86
        L72:
            r34 = r24;
        L68:
            r5 = null;
            goto L69
        L60:
            r33 = "";
            goto L61
        L52:
            r31 = "0";
            goto L53
        L48:
            r30 = "0";
        L42:
            r29 = null;
            goto L43
        L31:
            r19 = null;
            goto L32
        L27:
            r17 = "0";
            goto L28
        L23:
            r14 = null;
            goto L24
        L12:
            if (r10.length() > 0) goto L15;
            r9 = false;
        L15:
            if (r9 == true) goto L18;
            r10 = null;
        L18:
            if (r10 != null) goto L20;
        L5:
            r13 = r27;
            goto L6
        }

        public static /* synthetic */ Map b(a r6, ECWindowViewModel r7, BaseWindowTabViewModel r8, WindowV2ProductItemVO r9, WindowLayoutType r10, String r11) {
            r6.getClass();
            return a(r7, r8, r9, r10, r11, null);
        }
    }

    public static final class b implements h {
        public final /* synthetic */ ECWindowProductCardGroupPresenterBase a;
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
            return this.a.o0().getShopParam().getAuthorId();
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
            return this.a.o0().getShopParam().getSecAuthorId();
        }

        public final ap.c f() {
            return this.a.o0().getTagPools();
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_home_product_card");
        }

        public b(ECWindowProductCardGroupPresenterBase r1, WindowLayoutType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public String m0() {
        return "product_card";
    }

    public abstract BaseWindowTabViewModel n0();

    public final ECWindowViewModel o0() {
        return (ECWindowViewModel) this.p.getValue();
    }

    static {
        w = new a();
    }

    public g e0() {
        return this.t;
    }

    public h h0() {
        return this.s;
    }

    public final yo.f i0() {
        return this.u;
    }

    public static final String k0(ECWindowProductCardGroupPresenterBase r2) {
        BaseWindowTabViewModel r3 = r2.n0();
        if ((r3 instanceof BaseWindowTabViewModel) == true) goto L5;
        r3 = null;
    L5:
        if (r3 == null) goto L10;
        String r4 = r3.getLastCategoryId();
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4;
    L10:
        return null;
    }

    public final void b0(QModel r1) {
        super.b0(r1);
        n0();
        o0();
    }

    public static final String l0(ECWindowProductCardGroupPresenterBase r2, WindowV2ProductItemVO r3) {
        r2.getClass();
        Integer r4 = (Integer) r3.C.a(wn.a.C);
        f r0 = (f) r3.C.a(wn.a.D);
        if (r0 == null) goto L11;
        int r1 = com.bytedance.android.window.shop.b.a;
        int r5 = r0.i & (-1073741825);
        if (r5 == 307) goto L20;
        if (r5 != 308) goto L11;
        return "a1.b7635.c68164.d866576_i" + r4;
    L20:
        return "a1.b7635.c68164.d345368_i" + r4;
    L11:
        Boolean r6 = (Boolean) r3.C.a(wn.a.t);
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == false) goto L15;
        return "a1.b7635.c68164.d689913_i" + r4;
    L15:
        if (Intrinsics.areEqual((Boolean) r3.C.a(wn.a.v), r7) == false) goto L18;
        return "a1.b7635.c68164.d183883_i" + r4;
    L18:
        return "a1.b7635.c68164.d73007_i" + r4;
    }

    public ECWindowProductCardGroupPresenterBase(Fragment r2, WindowLayoutType r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.v = r4;
        this.n = LazyKt.lazy(new ECWindowProductCardGroupPresenterBase$showWindowVaneController$2(this));
        this.o = LazyKt.lazy(new ECWindowProductCardGroupPresenterBase$clickWindowVaneController$2(this));
        this.p = LazyKt.lazy(new ECWindowProductCardGroupPresenterBase$viewModel$2(this));
        this.q = new LinkedHashMap();
        this.r = LazyKt.lazy(new ECWindowProductCardGroupPresenterBase$btmHost$2(this));
        this.s = new b(this, r3);
        this.t = new ECWindowProductCardGroupPresenterBase$behavior$1(this, r3, r2);
        this.u = new ECWindowProductCardGroupPresenterBase$eventReporter$1(this, r3);
    }
}
