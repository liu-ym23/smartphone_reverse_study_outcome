package com.bytedance.android.window.shop.product.presenter.hotsale;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ap.c;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.product.presenter.utils.b;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
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
import org.json.JSONObject;
import yn.u;
import yo.g;
import yo.h;
import yo.j;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHotSaleProductGroupPresenter extends j {
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final a q;
    public final ECWindowHotSaleProductGroupPresenter$behavior$1 r;
    public final Function1<Integer, Unit> s;
    public final Function3<String, String, Long, Unit> t;

    public static final class a implements h {
        public final /* synthetic */ ECWindowHotSaleProductGroupPresenter a;

        public final void g() {
        }

        public final boolean isClickable() {
            return true;
        }

        public final String a() {
            return this.a.l0().getShopParam().getAuthorId();
        }

        public final Function3<String, String, Long, Unit> b() {
            return this.a.t;
        }

        public final String d() {
            return this.a.l0().getShopParam().getSecAuthorId();
        }

        public final Function1<Integer, Unit> e() {
            return this.a.s;
        }

        public final c f() {
            return this.a.l0().getTagPools();
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_hotsale_product_card");
        }

        public final WindowLayoutTypes c() {
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        }

        public a(ECWindowHotSaleProductGroupPresenter r1) {
            this.a = r1;
        }
    }

    public final ECWindowViewModel l0() {
        return (ECWindowViewModel) this.n.getValue();
    }

    public final g e0() {
        return this.r;
    }

    public final h h0() {
        return this.q;
    }

    public ECWindowHotSaleProductGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.n = LazyKt.lazy(new ECWindowHotSaleProductGroupPresenter$viewModel$2(this));
        this.o = LazyKt.lazy(new ECWindowHotSaleProductGroupPresenter$tabViewModel$2(this));
        this.p = LazyKt.lazy(new ECWindowHotSaleProductGroupPresenter$btmHost$2(this));
        this.q = new a(this);
        this.r = new ECWindowHotSaleProductGroupPresenter$behavior$1(this);
        this.s = new ECWindowHotSaleProductGroupPresenter$addCartListener$1(this);
        this.t = ECWindowHotSaleProductGroupPresenter$cartListener$1.INSTANCE;
    }

    public static final void k0(ECWindowHotSaleProductGroupPresenter r45, WindowV2ProductItemVO r46, WindowTabEventReporter.HotSaleProductClickArea r47, String r48) {
        r45.getClass();
        HashMap r3 = new HashMap();
        String r4 = r45.l0().getShopParam().getStoreSourcePage();
        if (r4 != null) goto L5;
        r4 = "store_page";
    L5:
        r3.put("enter_from_merge", r4);
        String r5 = r45.l0().getShopParam().getStoreSourceMethod();
        if (r5 != null) goto L8;
        r5 = "mini_window";
    L8:
        r3.put("enter_method", r5);
        r3.put("data_type", "commerce_data");
        int r6 = com.bytedance.android.ec.window.base.product.presenter.utils.c.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.c.a(r46, r45.Y(), r3);
        ECWindowParam r7 = r45.l0().getShopParam();
        int r8 = b.a;
        JSONObject r9 = b.d(r7.getSearchParams(), r46);
        List r10 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r46.a);
        com.bytedance.commerce.base.json.a[] r11 = new com.bytedance.commerce.base.json.a[22];
        r11[0] = JsonDslUtilKt.d("product_source_page", r7.getEntranceLocation());
        r11[1] = JsonDslUtilKt.d("carrier_source", r7.getPageName());
        r11[2] = JsonDslUtilKt.d("source_method", "live_top");
        r11[3] = JsonDslUtilKt.d("source_method_second", "live_top_101");
        Integer r12 = r7.getFollowStatus();
        String r13 = "";
        if (r12 == null) goto L12;
        String r14 = String.valueOf(r12.intValue());
        if (r14 == null) goto L12;
    L13:
        r11[4] = JsonDslUtilKt.d("follow_status", r14);
        r11[5] = JsonDslUtilKt.d("tab_label", "list_card");
        String r15 = r7.getTempId();
        if (r15 != null) goto L16;
        r15 = "";
    L16:
        r11[6] = JsonDslUtilKt.d("temp_id", r15);
        r11[7] = JsonDslUtilKt.d("ecom_group_type", "product");
        String r16 = r7.getStoreSourcePage();
        if (r16 != null) goto L19;
        r16 = "";
    L19:
        r11[8] = JsonDslUtilKt.d("store_source_page", r16);
        String r17 = r7.getStoreSourceMethod();
        if (r17 != null) goto L22;
        r17 = "";
    L22:
        r11[9] = JsonDslUtilKt.d("store_source_method", r17);
        String r18 = r7.getStoreGroupType();
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        r11[10] = JsonDslUtilKt.d("store_group_type", r18);
        r11[11] = JsonDslUtilKt.d("pre_product_id", r45.l0().getShopParam().getPreProductId());
        r11[12] = JsonDslUtilKt.d("pre_room_id", r45.l0().getShopParam().getPreRoomId());
        r11[13] = JsonDslUtilKt.d("pre_group_id", r45.l0().getShopParam().getPreGroupId());
        r11[14] = JsonDslUtilKt.d("store_type", "window");
        String r19 = r46.b;
        FragmentActivity r110 = null;
        if (r19 != null) goto L28;
    L35:
        r19 = r46.a;
    L36:
        r11[15] = JsonDslUtilKt.d("promotion_id", r19);
        boolean r20 = k.c(r46.i);
        String r111 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r20 == false) goto L39;
        String r21 = CommentScene.COMMENTSCENE_NO_AWEME;
    L40:
        r11[16] = JsonDslUtilKt.d("is_price_info", r21);
        if (r46.d() != null) goto L44;
        r111 = "0";
    L44:
        r11[17] = JsonDslUtilKt.d("is_recommend_info", r111);
        WindowV2ProductItemDTO.b r22 = r46.v;
        if (r22 == null) goto L47;
        String r23 = r22.a();
    L48:
        r11[18] = JsonDslUtilKt.d("content_form", r23);
        r11[19] = JsonDslUtilKt.d("content_source", "shop");
        String r24 = r45.l0().getShopParam().getWhichAccount();
        if (r24 != null) goto L51;
        r24 = "";
    L51:
        r11[20] = JsonDslUtilKt.d("which_account", r24);
        r11[21] = JsonDslUtilKt.d("bst_group_type", "product");
        JSONObject r25 = JsonDslUtilKt.a(r11);
        if (r7.isEcShare() == false) goto L54;
        r25.accumulate("share_content", r7.getShareContent());
        r25.accumulate("share_object", r7.getShareObject());
    L54:
        Map r26 = r46.q;
        if (r26 == null) goto L60;
        Iterator r27 = r26.entrySet().iterator();
    L58:
        if (r27.hasNext() == false) goto L60;
        Map.Entry r28 = (Map.Entry) r27.next();
        r25.put((String) r28.getKey(), r28.getValue());
    L60:
        JSONObject r29 = z1.g((String) r45.l0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r29 == null) goto L63;
        r25.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r29.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L63:
        JSONObject r210 = WindowEntranceInfoExtKt.a(r25, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null);
        BtmItemBuilder r30 = new BtmItemBuilder(r48, null, 2, null).withPageFinder(PageFinder.via(((QFragmentPresenter) r45).e));
        if (k.c(r46.E) == false) goto L70;
        int r31 = f.a;
        String r32 = r46.E;
        Intrinsics.checkNotNull(r32);
        String r112 = f.c(r32, r48, PageFinder.via(((QFragmentPresenter) r45).e), f.a(r45.l0().getShopParam().getAuthorId(), r46));
        xn.b r113 = xn.b.f;
        Context r114 = r45.Y().c();
        String r115 = String.valueOf(r45.l0().getShopParam().getFollowStatus());
        Map r211 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r45.l0().getShopParam().getAuthorId()), TuplesKt.to("product_id", r46.a)});
        u r33 = r46.w;
        if (r33 == null) goto L68;
        String r212 = r33.i();
    L69:
        com.bytedance.android.ec.window.base.common.starter.f.b(r113, r114, r112, r115, r210, r211, r212);
    L101:
        int r34 = WindowTabEventReporter.a;
        ECWindowParam r35 = r45.l0().getShopParam();
        ECWindowProductForm r36 = ECWindowProductForm.SINGLE_PRODUCT;
        QContext r37 = r45.Y();
        FragmentActivity r38 = l0.c(r37.c());
        if ((r38 instanceof FragmentActivity) == false) goto L105;
        r110 = r38;
    L105:
        if (r110 != null) goto L107;
        r110 = r37.a();
    L107:
        Map r39 = WindowTabEventReporter.a(r46, r35, r36, r110, "live_top_101");
        Map r40 = r46.q;
        if (r40 == null) goto L110;
        r39.putAll(r40);
    L110:
        if (r47 == null) goto L112;
        r39.put("click_area", String.valueOf(r47.getPosition()));
    L112:
        int r41 = WindowBstReport.a;
        View r42 = r45.a0();
        ECWindowViewModel r0 = r45.l0();
        Intrinsics.checkNotNullParameter(r39, "eventParams");
        Intrinsics.checkNotNullParameter(r0, "reporter");
        WindowBstReport.d(r42, r48, r46, new com.bytedance.android.window.shop.product.utils.b(r0, r39, r39));
        dm.a.a("WINDOW").i("[click hotsale product]productId:" + r46.a);
        dm.a.a("WINDOW").i("[click hotsale product]secAuthorId:" + r7.getSecAuthorId());
        return;
    L68:
        r212 = null;
        goto L69
    L70:
        r30.willJumpToNextPage();
        int r43 = b.a;
        b.f(PageFinder.via(r45.a0()), r45.l0().getShopParam().getAuthorId(), r46);
        xn.b r213 = xn.b.f;
        Context r214 = r45.Y().c();
        String r44 = r46.b;
        if (r44 != null) goto L73;
    L80:
        r44 = r46.a;
    L81:
        String r215 = r44;
        String r216 = r7.getPageName();
        String r49 = r46.m;
        String r217 = r7.getAuthorId();
        String r218 = r7.getSecAuthorId();
        String r50 = r46.a;
        Integer r219 = r7.getFollowStatus();
        String r310 = r7.getWhichAccount();
        String r311 = r210.toString();
        if (r9 == null) goto L84;
        String r312 = r9.toString();
    L85:
        com.bytedance.commerce.base.json.a[] r51 = new com.bytedance.commerce.base.json.a[1];
        JSONObject r52 = z1.g((String) r45.l0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r52 == null) goto L88;
        String r53 = r52.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L89:
        if (r53 == null) goto L92;
        r13 = r53;
    L92:
        r51[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r13);
        JSONObject r313 = JsonDslUtilKt.a(r51);
        String r314 = (String) CollectionsKt.getOrNull(r46.h, 0);
        u r54 = r46.w;
        if (r54 == null) goto L95;
        String r315 = r54.i();
    L96:
        Long r55 = r46.c;
        if (r55 == null) goto L99;
        long r56 = r55.longValue();
    L100:
        com.bytedance.android.ec.window.base.common.starter.f.a(r213, r214, r215, r216, r49, r217, r218, r50, r219, "list_card", r310, r311, r312, r313, r314, true, r315, r56, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r45.l0().getShopParam().getAuthorId())}), (String) r46.C.a(wn.a.y), (String) r46.C.a(wn.a.z), null, 260571136);
        goto L101
    L99:
        r56 = SourceType.UNKNOWN.getType();
        goto L100
    L95:
        r315 = null;
        goto L96
    L88:
        r53 = null;
        goto L89
    L84:
        r312 = null;
        goto L85
    L73:
        if (r44.length() <= 0) goto L75;
        boolean r57 = true;
    L76:
        if (r57 == true) goto L79;
        r44 = null;
    L79:
        if (r44 != null) goto L81;
    L75:
        r57 = false;
        goto L76
    L47:
        r23 = "";
        goto L48
    L39:
        r21 = "0";
        goto L40
    L28:
        if (r19.length() <= 0) goto L30;
        boolean r116 = true;
    L31:
        if (r116 == true) goto L34;
        r19 = null;
    L34:
        if (r19 != null) goto L36;
    L30:
        r116 = false;
    L12:
        r14 = "";
        goto L13
    }
}
