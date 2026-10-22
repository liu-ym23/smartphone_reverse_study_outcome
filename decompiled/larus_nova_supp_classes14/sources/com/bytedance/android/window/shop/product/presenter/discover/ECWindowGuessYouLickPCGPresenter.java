package com.bytedance.android.window.shop.product.presenter.discover;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ap.c;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.android.window.shop.secondary.ECWindowSecondaryPageActivity;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yn.u;
import yo.g;
import yo.h;
import yo.j;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowGuessYouLickPCGPresenter extends j {
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final a r;
    public final b s;

    public static final class a implements h {
        public final /* synthetic */ ECWindowGuessYouLickPCGPresenter a;
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
            return ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getAuthorId();
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
            return ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getSecAuthorId();
        }

        public final c f() {
            return ECWindowGuessYouLickPCGPresenter.m0(this.a).getTagPools();
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_home_product_card");
        }

        public a(ECWindowGuessYouLickPCGPresenter r1, WindowLayoutType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements g {
        public final /* synthetic */ ECWindowGuessYouLickPCGPresenter a;
        public final /* synthetic */ WindowLayoutType b;
        public final /* synthetic */ Fragment c;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ WindowV2ProductItemVO b;

            public a(b r1, WindowV2ProductItemVO r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ar3.h r0 = (ar3.h) this.a.a.n.getValue();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.a(this.b, ECWindowGuessYouLickPCGPresenter.l0(this.a.a).getLastCategoryId());     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void b(WindowV2ProductItemVO r47) {
            Intrinsics.checkNotNullParameter(r47, "item");
            fo.a<WindowLayoutType> r1 = WindowConstDef.a;
            Fragment r2 = this.c;
            Intrinsics.checkNotNullParameter(r2, "fragment");
            if ((r2.getActivity() instanceof ECWindowSecondaryPageActivity) == true) goto L5;
            ECWindowGuessYouLickPCGPresenter.m0(this.a).add(Schedulers.io().scheduleDirect(new a(this, r47)));
        L5:
            HashMap r3 = new HashMap();
            String r4 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourcePage();
            if (r4 != null) goto L8;
            r4 = "store_page";
        L8:
            r3.put("enter_from_merge", r4);
            String r5 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourceMethod();
            if (r5 != null) goto L11;
            r5 = "mini_window";
        L11:
            r3.put("enter_method", r5);
            r3.put("data_type", "commerce_data");
            int r6 = com.bytedance.android.ec.window.base.product.presenter.utils.c.a;
            com.bytedance.android.ec.window.base.product.presenter.utils.c.a(r47, this.a.Y(), r3);
            ECWindowParam r9 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam();
            int r7 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            JSONObject r8 = com.bytedance.android.ec.window.base.product.presenter.utils.b.d(r9.getSearchParams(), r47);
            String r10 = ECWindowGuessYouLickPCGPresenter.k0(this.a, r47);
            Boolean r11 = Boolean.TRUE;
            com.bytedance.android.btm.api.model.c r12 = new BtmItemBuilder(r10, r11).withBtmPage(this.a.q.getValue()).build();
            BtmSDK r13 = BtmSDK.INSTANCE;
            r13.willJumpToNextPage(r12);
            Unit r14 = Unit.INSTANCE;
            String r15 = r13.obtainEventBtmParams(new BtmItemBuilder(ECWindowGuessYouLickPCGPresenter.k0(this.a, r47), r11).withBtmPage(this.a.q.getValue()).build());
            com.bytedance.commerce.base.json.a[] r16 = new com.bytedance.commerce.base.json.a[21];
            r16[0] = JsonDslUtilKt.d("product_source_page", r9.getEntranceLocation());
            r16[1] = JsonDslUtilKt.d("carrier_source", r9.getPageName());
            r16[2] = JsonDslUtilKt.d("source_method", "discover");
            Integer r17 = r9.getFollowStatus();
            String r18 = "";
            if (r17 == null) goto L15;
            String r19 = String.valueOf(r17.intValue());
            if (r19 == null) goto L15;
        L16:
            r16[3] = JsonDslUtilKt.d("follow_status", r19);
            r16[4] = JsonDslUtilKt.d("tab_label", "list_card");
            String r20 = r9.getTempId();
            if (r20 != null) goto L19;
            r20 = "";
        L19:
            r16[5] = JsonDslUtilKt.d("temp_id", r20);
            r16[6] = JsonDslUtilKt.d("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(this.b));
            r16[7] = JsonDslUtilKt.d("ecom_group_type", "product");
            String r21 = r9.getStoreSourcePage();
            if (r21 != null) goto L22;
            r21 = "";
        L22:
            r16[8] = JsonDslUtilKt.d("store_source_page", r21);
            String r22 = r9.getStoreSourceMethod();
            if (r22 != null) goto L25;
            r22 = "";
        L25:
            r16[9] = JsonDslUtilKt.d("store_source_method", r22);
            String r23 = r9.getStoreGroupType();
            if (r23 != null) goto L28;
            r23 = "";
        L28:
            r16[10] = JsonDslUtilKt.d("store_group_type", r23);
            r16[11] = JsonDslUtilKt.d("pre_product_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreProductId());
            r16[12] = JsonDslUtilKt.d("pre_room_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreRoomId());
            r16[13] = JsonDslUtilKt.d("pre_group_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreGroupId());
            r16[14] = JsonDslUtilKt.d("store_type", "window");
            String r24 = r47.b;
            String r110 = null;
            if (r24 != null) goto L31;
        L38:
            r24 = r47.a;
        L39:
            r16[15] = JsonDslUtilKt.d("promotion_id", r24);
            boolean r25 = k.c(r47.i);
            String r111 = CommentScene.COMMENTSCENE_NO_AWEME;
            if (r25 == false) goto L42;
            String r26 = CommentScene.COMMENTSCENE_NO_AWEME;
        L43:
            r16[16] = JsonDslUtilKt.d("is_price_info", r26);
            if (r47.d() != null) goto L47;
            r111 = "0";
        L47:
            r16[17] = JsonDslUtilKt.d("is_recommend_info", r111);
            WindowV2ProductItemDTO.b r27 = r47.v;
            if (r27 == null) goto L50;
            String r28 = r27.a();
        L51:
            r16[18] = JsonDslUtilKt.d("content_form", r28);
            r16[19] = JsonDslUtilKt.d("content_source", "shop");
            String r29 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getWhichAccount();
            if (r29 != null) goto L54;
            r29 = "";
        L54:
            r16[20] = JsonDslUtilKt.d("which_account", r29);
            JSONObject r30 = JsonDslUtilKt.a(r16);
            Map r31 = r47.q;
            if (r31 == null) goto L58;
            String r32 = (String) r31.get("tab_name_second");
            if (r32 == null) goto L58;
        L59:
            if (r32 == null) goto L61;
            r30.put("source_method_second", r32);
        L61:
            r30.put("tab_name", "discover");
            fo.b r33 = r47.C;
            fo.a r34 = wn.a.e;
            String r35 = (String) r33.a(r34);
            if (r35 == null) goto L65;
            r30.put(r34.a, r35);
        L65:
            if (r9.isEcShare() == false) goto L67;
            r30.accumulate("share_content", r9.getShareContent());
            r30.accumulate("share_object", r9.getShareObject());
        L67:
            Map r36 = r47.q;
            if (r36 == null) goto L73;
            Iterator r37 = r36.entrySet().iterator();
        L71:
            if (r37.hasNext() == false) goto L73;
            Map.Entry r38 = (Map.Entry) r37.next();
            r30.put((String) r38.getKey(), r38.getValue());
        L73:
            JSONObject r39 = z1.g((String) ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPassThroughParam("pass_through_api"));
            if (r39 == null) goto L76;
            r30.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r39.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
            Unit r40 = Unit.INSTANCE;
        L76:
            List r41 = com.bytedance.android.ec.window.base.utils.g.a;
            com.bytedance.android.ec.window.base.utils.g.a(r47.a);
            com.bytedance.android.ec.window.base.product.presenter.utils.b.g(PageFinder.via(this.a.a0()));
            if (k.c(r47.E) == false) goto L82;
            int r42 = f.a;
            String r43 = r47.E;
            Intrinsics.checkNotNull(r43);
            String r112 = f.c(r43, r15, PageFinder.via(this.a.a0()), f.a(r9.getAuthorId(), r47));
            xn.b r113 = xn.b.f;
            Context r114 = this.a.Y().c();
            String r115 = String.valueOf(r9.getFollowStatus());
            JSONObject r116 = WindowEntranceInfoExtKt.a(r30, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null);
            Map r210 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r9.getAuthorId()), TuplesKt.to("product_id", r47.a)});
            u r44 = r47.w;
            if (r44 == null) goto L81;
            r110 = r44.i();
        L81:
            com.bytedance.android.ec.window.base.common.starter.f.b(r113, r114, r112, r115, r116, r210, r110);
        L126:
            int r45 = WindowBstReport.a;
            WindowBstReport.g(this.a.a0(), ECWindowGuessYouLickPCGPresenter.k0(this.a, r47), r47, this.b, l(r47), ECWindowGuessYouLickPCGPresenter.m0(this.a), ECWindowGuessYouLickPCGPresenter.l0(this.a));
            dm.a.a("WINDOW").i("[click product]productId:" + r47.a);
            dm.a.a("WINDOW").i("[click product]secAuthorId:" + r9.getSecAuthorId());
            return;
        L82:
            xn.b r211 = xn.b.f;
            Context r212 = this.a.Y().c();
            String r46 = r47.b;
            if (r46 != null) goto L85;
        L92:
            r46 = r47.a;
        L93:
            String r213 = r46;
            String r214 = r9.getPageName();
            String r48 = r47.m;
            String r49 = r47.a;
            Integer r310 = r9.getFollowStatus();
            String r311 = r9.getWhichAccount();
            String r312 = WindowEntranceInfoExtKt.a(r30, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null).toString();
            if (r8 == null) goto L96;
            String r313 = r8.toString();
        L97:
            com.bytedance.commerce.base.json.a[] r50 = new com.bytedance.commerce.base.json.a[1];
            JSONObject r51 = z1.g((String) ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPassThroughParam("pass_through_api"));
            if (r51 == null) goto L100;
            String r52 = r51.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L101:
            if (r52 == null) goto L104;
            r18 = r52;
        L104:
            r50[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r18);
            JSONObject r53 = JsonDslUtilKt.a(r50);
            if ((r47 instanceof rq3.a) == true) goto L107;
            WindowV2ProductItemVO r54 = null;
        L108:
            rq3.a r55 = (rq3.a) r54;
            if (r55 == null) goto L118;
            String r56 = r55.Q;
            if (r56 == null) goto L118;
            if ((!StringsKt.isBlank(r56)) == true) goto L116;
            r56 = null;
        L116:
            if (r56 == null) goto L118;
            r53.put("cps_track", r56);
            r53.put("cps_report_type", 0);
            Unit r57 = Unit.INSTANCE;
        L118:
            Unit r58 = Unit.INSTANCE;
            String r314 = (String) CollectionsKt.getOrNull(r47.h, 0);
            u r59 = r47.w;
            if (r59 == null) goto L121;
            r110 = r59.i();
        L121:
            String r315 = r110;
            Long r60 = r47.c;
            if (r60 == null) goto L124;
            long r117 = r60.longValue();
        L125:
            com.bytedance.android.ec.window.base.common.starter.f.a(r211, r212, r213, r214, r48, "", "", r49, r310, "list_card", r311, r312, r313, r53, r314, false, r315, r117, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getAuthorId())}), (String) r47.C.a(wn.a.y), (String) r47.C.a(wn.a.z), null, 260603904);
            goto L126
        L124:
            r117 = SourceType.UNKNOWN.getType();
            goto L125
        L107:
            r54 = r47;
            goto L108
        L100:
            r52 = null;
            goto L101
        L96:
            r313 = null;
            goto L97
        L85:
            if (r46.length() <= 0) goto L87;
            boolean r61 = true;
        L88:
            if (r61 == true) goto L91;
            r46 = null;
        L91:
            if (r46 != null) goto L93;
        L87:
            r61 = false;
        L58:
            r32 = (String) r47.C.a(wn.a.e);
            goto L59
        L50:
            r28 = "";
            goto L51
        L42:
            r26 = "0";
            goto L43
        L31:
            if (r24.length() <= 0) goto L33;
            boolean r118 = true;
        L34:
            if (r118 == true) goto L37;
            r24 = null;
        L37:
            if (r24 != null) goto L39;
        L33:
            r118 = false;
        L15:
            r19 = "";
            goto L16
        }

        public final void c(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void d(WindowV2ProductItemVO r18) {
            Intrinsics.checkNotNullParameter(r18, "item");
            String r2 = r18.r;
            Context r8 = null;
            String r10 = "";
            if (r2 == null) goto L14;
            m0 r11 = new m0(r2);
            r11.b("enter_from", "store_page_product_card");
            r11.b("pre_product_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreProductId());
            r11.b("pre_group_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreGroupId());
            r11.b("pre_room_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreRoomId());
            r11.b("entrance_location", "store_page_product_card");
            String r3 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourcePage();
            if (r3 != null) goto L7;
            r3 = "";
        L7:
            r11.b("store_source_page", r3);
            String r4 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourceMethod();
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            r11.b("store_source_method", r4);
            String r5 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreGroupType();
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            r11.b("store_group_type", r5);
            r11.b("pass_through_api", (String) ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPassThroughParam("pass_through_api"));
            String r13 = r11.c();
        L15:
            if (r13 != null) goto L17;
            return;
        L17:
            if (a2.b(r13) == false) goto L38;
            BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(ECWindowGuessYouLickPCGPresenter.k0(this.a, r18), Boolean.TRUE).withBtmPage(this.a.q.getValue()).build());
            int r6 = f.a;
            QContext r7 = this.a.Y();
            Context r12 = l0.c(r7.c());
            if ((r12 instanceof FragmentActivity) == false) goto L22;
            r8 = r12;
        L22:
            if (r8 != null) goto L24;
            Context r14 = r7.a();
        L25:
            f.b(r14, ECWindowGuessYouLickPCGPresenter.m0(this.a), r13, "a1.b7635.c68164.d22909", PageFinder.via(this.a.a0()), null);
            ECWindowViewModel r15 = ECWindowGuessYouLickPCGPresenter.m0(this.a);
            this.a.getClass();
            String r16 = "a1.b7635.c68164.d22909_i" + ((Integer) r18.C.a(wn.a.C));
            PageFinder r17 = PageFinder.via(this.c);
            Pair[] r9 = new Pair[8];
            r9[0] = TuplesKt.to("author_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getAuthorId());
            r9[1] = TuplesKt.to("entrance_location", "store_page_product_card");
            r9[2] = TuplesKt.to("enter_from", "store_page_product_card");
            String r19 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourcePage();
            if (r19 != null) goto L28;
            r19 = "";
        L28:
            r9[3] = TuplesKt.to("store_source_page", r19);
            String r20 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourceMethod();
            if (r20 != null) goto L31;
            r20 = "";
        L31:
            r9[4] = TuplesKt.to("store_source_method", r20);
            String r21 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreGroupType();
            if (r21 == null) goto L35;
            r10 = r21;
        L35:
            r9[5] = TuplesKt.to("store_group_type", r10);
            r9[6] = TuplesKt.to("store_type", "shop");
            r9[7] = TuplesKt.to("product_id", r18.a);
            r15.doAnyEventActionWithBtm(r16, r17, "click_store_entrance", MapsKt.mapOf(r9), new Pair[0]);
            return;
        L24:
            r14 = r8;
            goto L25
        L38:
            return;
        L14:
            r13 = null;
            goto L15
        }

        public final void e(WindowV2ProductItemVO r10) {
            Intrinsics.checkNotNullParameter(r10, "item");
            ECWindowViewModel r1 = ECWindowGuessYouLickPCGPresenter.m0(this.a);
            this.a.getClass();
            String r2 = "a1.b7635.c68164.d22909_i" + ((Integer) r10.C.a(wn.a.C));
            PageFinder r3 = PageFinder.via(this.c);
            Pair[] r0 = new Pair[8];
            r0[0] = TuplesKt.to("author_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getAuthorId());
            r0[1] = TuplesKt.to("entrance_location", "store_page_product_card");
            r0[2] = TuplesKt.to("enter_from", "store_page_product_card");
            String r5 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourcePage();
            String r7 = "";
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r0[3] = TuplesKt.to("store_source_page", r5);
            String r6 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourceMethod();
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r0[4] = TuplesKt.to("store_source_method", r6);
            String r8 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreGroupType();
            if (r8 == null) goto L12;
            r7 = r8;
        L12:
            r0[5] = TuplesKt.to("store_group_type", r7);
            r0[6] = TuplesKt.to("store_type", "shop");
            r0[7] = TuplesKt.to("product_id", r10.a);
            r1.doAnyEventActionWithBtm(r2, r3, "show_store_entrance", MapsKt.mapOf(r0), new Pair[0]);
        }

        public final void f(WindowFollowCouponTagView r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void g(WindowV2ProductItemVO r9) {
            Intrinsics.checkNotNullParameter(r9, "item");
            if (ECWindowGuessYouLickPCGPresenter.l0(this.a).shouldReportEvent(wn.a.g, r9.a) == false) goto L6;
            com.bytedance.android.btm.api.model.c r0 = new BtmItemBuilder(ECWindowGuessYouLickPCGPresenter.k0(this.a, r9), Boolean.FALSE).withBtmPage(this.a.q.getValue()).build();
            BtmSDK.INSTANCE.obtainEventBtmParams(r0);
            int r1 = WindowBstReport.a;
            WindowBstReport.i(this.a.a0(), ECWindowGuessYouLickPCGPresenter.k0(this.a, r9), r9, this.b, l(r9), ECWindowGuessYouLickPCGPresenter.m0(this.a), ECWindowGuessYouLickPCGPresenter.l0(this.a));
            boolean r10 = com.bytedance.android.ec.window.base.shop.j.a;
            com.bytedance.android.ec.window.base.shop.j.b("window_visit_product", PostActionType.DO);
            return;
        }

        public final void h(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void i(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void j(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void k(sq3.h r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final Map<String, String> l(WindowV2ProductItemVO r10) {
            Pair[] r0 = new Pair[40];
            boolean r2 = false;
            r0[0] = TuplesKt.to("author_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getAuthorId());
            r0[1] = TuplesKt.to("sec_author_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getSecAuthorId());
            r0[2] = TuplesKt.to("enter_from", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getEnterFrom());
            r0[3] = TuplesKt.to("entrance_location", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getEntranceLocation());
            r0[4] = TuplesKt.to("store_source_page", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourcePage());
            r0[5] = TuplesKt.to("store_source_method", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreSourceMethod());
            r0[6] = TuplesKt.to("store_group_type", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getStoreGroupType());
            r0[7] = TuplesKt.to("live_anchor_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getLiveAnchorId());
            r0[8] = TuplesKt.to("page_name", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPageName());
            r0[9] = TuplesKt.to("source_page", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPageName());
            r0[10] = TuplesKt.to("page_type", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPageType());
            r0[11] = TuplesKt.to(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1004");
            r0[12] = TuplesKt.to("store_type", "window");
            r0[13] = TuplesKt.to("entrance_info", ECWindowGuessYouLickPCGPresenter.m0(this.a).getEntranceInfo());
            r0[14] = TuplesKt.to("entrance_location", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getEntranceLocation());
            r0[15] = TuplesKt.to("source_page", "store_page");
            r0[16] = TuplesKt.to("store_type", "window");
            r0[17] = TuplesKt.to("ecom_entrance_form", "discover");
            r0[18] = TuplesKt.to("ecom_group_type", "product");
            r0[19] = TuplesKt.to("product_id", r10.a);
            int r1 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            r0[20] = TuplesKt.to("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(this.b));
            String r3 = r10.b;
            String r5 = null;
            if (r3 != null) goto L5;
        L11:
            r3 = r10.a;
        L12:
            r0[21] = TuplesKt.to("commodity_id", r3);
            Long r4 = r10.c;
            if (r4 == null) goto L15;
            String r6 = String.valueOf(r4.longValue());
        L16:
            r0[22] = TuplesKt.to("commodity_type", r6);
            ECUrlModel r7 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getBrandTag();
            String r8 = CommentScene.COMMENTSCENE_NO_AWEME;
            if (r7 == null) goto L19;
            Object r9 = CommentScene.COMMENTSCENE_NO_AWEME;
        L20:
            r0[23] = TuplesKt.to("brand_verified", r9);
            r0[24] = TuplesKt.to("search_params", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getSearchParams());
            r0[25] = TuplesKt.to("pre_product_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreProductId());
            r0[26] = TuplesKt.to("pre_room_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreRoomId());
            r0[27] = TuplesKt.to("pre_group_id", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getPreGroupId());
            Integer r11 = ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getFollowStatus();
            if (r11 == null) goto L23;
            String r12 = String.valueOf(r11.intValue());
        L25:
            if (r12 != null) goto L27;
            r12 = "";
        L27:
            r0[28] = TuplesKt.to("follow_status", r12);
            Map r13 = r10.s;
            if (r13 == null) goto L34;
            List r14 = (List) r13.get("ecom_shop_product_before");
            if (r14 == null) goto L34;
            ECRitTag r15 = (ECRitTag) CollectionsKt.firstOrNull(r14);
            if (r15 == null) goto L34;
            r5 = r15.getTrackTag();
        L34:
            if (r5 != null) goto L36;
            r5 = "";
        L36:
            r0[29] = TuplesKt.to("label_name", r5);
            if (r10.f() == null) goto L39;
            Object r16 = CommentScene.COMMENTSCENE_NO_AWEME;
        L40:
            r0[30] = TuplesKt.to("is_product_info", r16);
            if (k.c(r10.i) == false) goto L43;
            Object r17 = CommentScene.COMMENTSCENE_NO_AWEME;
        L44:
            r0[31] = TuplesKt.to("is_price_info", r17);
            if (r10.d() != null) goto L48;
            r8 = "0";
        L48:
            r0[32] = TuplesKt.to("is_recommend_info", r8);
            WindowV2ProductItemDTO.b r18 = r10.v;
            if (r18 == null) goto L51;
            String r19 = r18.a();
        L52:
            r0[33] = TuplesKt.to("content_form", r19);
            r0[34] = TuplesKt.to("classification_tab", ECWindowGuessYouLickPCGPresenter.l0(this.a).getCategoryName());
            r0[35] = TuplesKt.to("classification_tab_id", ECWindowGuessYouLickPCGPresenter.l0(this.a).getLastCategoryId());
            r0[36] = TuplesKt.to("classification_sub_tab_id", ECWindowGuessYouLickPCGPresenter.l0(this.a).getLastSubCategoryId());
            r0[37] = TuplesKt.to("content_source", "shop");
            if (ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().isEcShare() == false) goto L55;
            Pair r20 = TuplesKt.to("share_content", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getShareContent());
        L56:
            r0[38] = r20;
            if (ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().isEcShare() == false) goto L59;
            Pair r21 = TuplesKt.to("share_object", ECWindowGuessYouLickPCGPresenter.m0(this.a).getShopParam().getShareObject());
        L60:
            r0[39] = r21;
            Map<String, String> r22 = MapsKt.mutableMapOf(r0);
            r22.putAll(com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r10));
            r22.put("tab_name", "discover");
            String r110 = (String) r10.C.a(wn.a.e);
            if (r110 == null) goto L63;
            r22.put("tab_name_second", r110);
        L63:
            return r22;
        L59:
            r21 = TuplesKt.to("", "");
            goto L60
        L55:
            r20 = TuplesKt.to("", "");
            goto L56
        L51:
            r19 = "";
            goto L52
        L43:
            r17 = "0";
            goto L44
        L39:
            r16 = "0";
            goto L40
        L23:
            r12 = null;
            goto L25
        L19:
            r9 = "0";
            goto L20
        L15:
            r6 = null;
            goto L16
        L5:
            if (r3.length() <= 0) goto L7;
            r2 = true;
        L7:
            if (r2 == true) goto L10;
            r3 = null;
        L10:
            if (r3 != null) goto L12;
            goto L11
        }

        public b(ECWindowGuessYouLickPCGPresenter r1, WindowLayoutType r2, Fragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void c0() {
        super.c0();
    }

    public final g e0() {
        return this.s;
    }

    public final h h0() {
        return this.r;
    }

    public static final BaseWindowTabViewModel l0(ECWindowGuessYouLickPCGPresenter r0) {
        return (BaseWindowTabViewModel) r0.p.getValue();
    }

    public static final ECWindowViewModel m0(ECWindowGuessYouLickPCGPresenter r0) {
        return (ECWindowViewModel) r0.o.getValue();
    }

    public ECWindowGuessYouLickPCGPresenter(final Fragment r2, WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.n = LazyKt.lazy(new ECWindowGuessYouLickPCGPresenter$clickWindowVaneController$2(this));
        this.o = LazyKt.lazy(new ECWindowGuessYouLickPCGPresenter$viewModel$2(this));
        this.p = LazyKt.lazy(new ECWindowGuessYouLickPCGPresenter$tabViewModel$2(this, r2));
        this.q = LazyKt.lazy(new ECWindowGuessYouLickPCGPresenter$btmHost$2(this));
        this.r = new a(this, r3);
        this.s = new b(this, r3, r2);
    }

    public static final String k0(ECWindowGuessYouLickPCGPresenter r1, WindowV2ProductItemVO r2) {
        r1.getClass();
        return "a1.b7635.c68164.d6432593_i" + ((Integer) r2.C.a(wn.a.C));
    }
}
