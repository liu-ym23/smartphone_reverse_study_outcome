package com.bytedance.android.window.shop.home.tab.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ ECWindowProductSharePresenter a;
    public final /* synthetic */ View b;

    public l(ECWindowProductSharePresenter r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r35) {
        int r1 = rp.a.a;
        if (rp.a.a(r35.getId()) == false) goto L5;
        return;
    L5:
        this.a.i0(true);
        ECWindowProductSharePresenter r2 = this.a;
        o0 r3 = r2.j;
        if ((r3 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L8;
        r3 = null;
    L8:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r4 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r3;
        Object r5 = "unknow";
        if (r4 == null) goto L24;
        List<? extends WindowV2ProductItemVO> r6 = r4.q;
        if (r6 == null) goto L24;
        WindowV2ProductItemVO r7 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L24;
        StringBuilder r8 = new StringBuilder("c3129.d42889_i");
        o0 r9 = r2.j;
        if ((r9 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L18;
        r9 = null;
    L18:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r10 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r9;
        if (r10 == null) goto L22;
        Object r11 = r10.n;
        if (r11 == null) goto L22;
    L23:
        r8.append(r11);
        String r12 = r8.toString();
        BtmItemBuilder r13 = new BtmItemBuilder(r12, Boolean.FALSE).withBtmPage(r2.m.getValue());
        Map<String, String> r14 = r2.j0();
        int r15 = WindowBstReport.a;
        WindowBstReport.c(r2.a0(), r12, r13, r7, new j(r2, r14, r14));
    L22:
        r11 = "unknow";
    L24:
        o0 r16 = this.a.j;
        if ((r16 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L27;
        r16 = null;
    L27:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r17 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r16;
        if (r17 == null) goto L134;
        List<? extends WindowV2ProductItemVO> r18 = r17.q;
        if (r18 == null) goto L135;
        WindowV2ProductItemVO r19 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L137;
        ECWindowParam r20 = this.a.d0().getShopParam();
        ECWindowProductSharePresenter r21 = this.a;
        View r22 = this.b;
        String r23 = r21.d0().getShopParam().getSearchParams();
        List r24 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r19.a);
        StringBuilder r25 = new StringBuilder("c3129.d42889_i");
        o0 r26 = r21.j;
        if ((r26 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L37;
        r26 = null;
    L37:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r27 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r26;
        if (r27 == null) goto L43;
        Integer r28 = r27.n;
        if (r28 == null) goto L43;
        r5 = r28;
    L43:
        r25.append(r5);
        String r29 = r25.toString();
        com.bytedance.commerce.base.json.a[] r30 = new com.bytedance.commerce.base.json.a[22];
        r30[0] = JsonDslUtilKt.d("product_source_page", r20.getEntranceLocation());
        r30[1] = JsonDslUtilKt.d("carrier_source", r20.getPageName());
        r30[2] = JsonDslUtilKt.d("source_method", "video_tab");
        Integer r31 = r20.getFollowStatus();
        String r110 = "";
        if (r31 == null) goto L47;
        String r32 = String.valueOf(r31.intValue());
        if (r32 == null) goto L47;
    L48:
        r30[3] = JsonDslUtilKt.d("follow_status", r32);
        r30[4] = JsonDslUtilKt.d("tab_label", "list_card");
        String r33 = r20.getTempId();
        if (r33 != null) goto L51;
        r33 = "";
    L51:
        r30[5] = JsonDslUtilKt.d("temp_id", r33);
        r30[6] = JsonDslUtilKt.d("product_form", "double_product");
        r30[7] = JsonDslUtilKt.d("ecom_group_type", "product");
        String r34 = r20.getStoreSourcePage();
        if (r34 != null) goto L54;
        r34 = "";
    L54:
        r30[8] = JsonDslUtilKt.d("store_source_page", r34);
        String r36 = r20.getStoreSourceMethod();
        if (r36 != null) goto L57;
        r36 = "";
    L57:
        r30[9] = JsonDslUtilKt.d("store_source_method", r36);
        String r37 = r20.getStoreGroupType();
        if (r37 != null) goto L60;
        r37 = "";
    L60:
        r30[10] = JsonDslUtilKt.d("store_group_type", r37);
        r30[11] = JsonDslUtilKt.d("pre_product_id", r21.d0().getShopParam().getPreProductId());
        r30[12] = JsonDslUtilKt.d("pre_room_id", r21.d0().getShopParam().getPreRoomId());
        r30[13] = JsonDslUtilKt.d("pre_group_id", r21.d0().getShopParam().getPreGroupId());
        r30[14] = JsonDslUtilKt.d("store_type", "window");
        String r38 = r19.b;
        if (r38 != null) goto L63;
    L70:
        r38 = r19.a;
    L71:
        r30[15] = JsonDslUtilKt.d("promotion_id", r38);
        boolean r39 = com.bytedance.android.shopping.extensions.k.c(r19.i);
        String r111 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r39 == false) goto L74;
        String r40 = CommentScene.COMMENTSCENE_NO_AWEME;
    L75:
        r30[16] = JsonDslUtilKt.d("is_price_info", r40);
        if (r19.d() != null) goto L79;
        r111 = "0";
    L79:
        r30[17] = JsonDslUtilKt.d("is_recommend_info", r111);
        WindowV2ProductItemDTO.b r41 = r19.v;
        if (r41 == null) goto L82;
        String r42 = r41.a();
    L83:
        r30[18] = JsonDslUtilKt.d("content_form", r42);
        r30[19] = JsonDslUtilKt.d("content_source", "shop");
        String r43 = r21.d0().getShopParam().getWhichAccount();
        if (r43 != null) goto L86;
        r43 = "";
    L86:
        r30[20] = JsonDslUtilKt.d("which_account", r43);
        r30[21] = JsonDslUtilKt.d("bst_group_type", "product");
        JSONObject r44 = JsonDslUtilKt.a(r30);
        r44.put("source_method_second", "video_tab_101");
        if (r20.isEcShare() == false) goto L89;
        r44.accumulate("share_content", r20.getShareContent());
        r44.accumulate("share_object", r20.getShareObject());
    L89:
        Map r45 = r19.q;
        if (r45 == null) goto L95;
        Iterator r46 = r45.entrySet().iterator();
    L93:
        if (r46.hasNext() == false) goto L95;
        Map.Entry r47 = (Map.Entry) r46.next();
        r44.put((String) r47.getKey(), r47.getValue());
    L95:
        JSONObject r48 = z1.g((String) r21.d0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r48 == null) goto L99;
        r44.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r48.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L99:
        if (com.bytedance.android.shopping.extensions.k.c(r19.E) == false) goto L105;
        int r49 = zq3.f.a;
        String r50 = r19.E;
        Intrinsics.checkNotNull(r50);
        String r112 = zq3.f.c(r50, r29, PageFinder.via(((QFragmentPresenter) r21).e), zq3.f.a(r21.d0().getShopParam().getAuthorId(), r19));
        xn.b r113 = xn.b.f;
        Context r114 = r21.Y().c();
        String r115 = String.valueOf(r20.getFollowStatus());
        Map r116 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r20.getAuthorId()), TuplesKt.to("product_id", r19.a)});
        yn.u r51 = r19.w;
        if (r51 == null) goto L103;
        String r117 = r51.i();
    L104:
        com.bytedance.android.ec.window.base.common.starter.f.b(r113, r114, r112, r115, r44, r116, r117);
        return;
    L103:
        r117 = null;
        goto L104
    L105:
        BtmSDK.INSTANCE.willJumpToNextPage(new BtmItemBuilder(r29, null, 2, null).withView(r22).build());
        int r52 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.b.f(PageFinder.via(r22), r21.d0().getShopParam().getAuthorId(), r19);
        xn.b r53 = xn.b.f;
        Context r118 = r21.Y().c();
        String r54 = r19.b;
        if (r54 != null) goto L108;
    L115:
        r54 = r19.a;
    L116:
        String r55 = r20.getPageName();
        String r119 = r19.m;
        String r120 = r20.getAuthorId();
        String r121 = r20.getSecAuthorId();
        String r122 = r19.a;
        Integer r123 = r20.getFollowStatus();
        String r210 = r20.getWhichAccount();
        String r211 = r44.toString();
        com.bytedance.commerce.base.json.a[] r56 = new com.bytedance.commerce.base.json.a[1];
        JSONObject r57 = z1.g((String) r21.d0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r57 == null) goto L119;
        String r58 = r57.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L120:
        if (r58 == null) goto L123;
        r110 = r58;
    L123:
        r56[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r110);
        JSONObject r212 = JsonDslUtilKt.a(r56);
        String r213 = (String) CollectionsKt.getOrNull(r19.h, 0);
        yn.u r59 = r19.w;
        if (r59 == null) goto L126;
        String r214 = r59.i();
    L127:
        Long r60 = r19.c;
        if (r60 == null) goto L130;
        long r61 = r60.longValue();
    L131:
        com.bytedance.android.ec.window.base.common.starter.f.a(r53, r118, r54, r55, r119, r120, r121, r122, r123, "list_card", r210, r211, r23, r212, r213, false, r214, r61, null, (String) r19.C.a(wn.a.y), (String) r19.C.a(wn.a.z), null, 261652480);
        return;
    L130:
        r61 = SourceType.UNKNOWN.getType();
        goto L131
    L126:
        r214 = null;
        goto L127
    L119:
        r58 = null;
        goto L120
    L108:
        if (r54.length() <= 0) goto L110;
        boolean r62 = true;
    L111:
        if (r62 == true) goto L114;
        r54 = null;
    L114:
        if (r54 != null) goto L116;
    L110:
        r62 = false;
        goto L111
    L82:
        r42 = "";
        goto L83
    L74:
        r40 = "0";
        goto L75
    L63:
        if (r38.length() <= 0) goto L65;
        boolean r124 = true;
    L66:
        if (r124 == true) goto L69;
        r38 = null;
    L69:
        if (r38 != null) goto L71;
    L65:
        r124 = false;
    L47:
        r32 = "";
        goto L48
    L137:
        return;
    L135:
        return;
    }
}
