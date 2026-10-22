package com.bytedance.android.window.shop.product.presenter.group;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ar3.h;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yn.u;
import yo.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowProductCardGroupPresenterBase$behavior$1 implements g {
    public final /* synthetic */ ECWindowProductCardGroupPresenterBase a;
    public final /* synthetic */ WindowLayoutType b;
    public final /* synthetic */ Fragment c;

    public static final class a implements Runnable {
        public final /* synthetic */ ECWindowProductCardGroupPresenterBase$behavior$1 a;
        public final /* synthetic */ WindowV2ProductItemVO b;

        public a(ECWindowProductCardGroupPresenterBase$behavior$1 r1, WindowV2ProductItemVO r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = (h) this.a.a.o.getValue();     // Catch: Throwable -> L9
            if (r0 == null) goto L12;
            WindowV2ProductItemVO r1 = this.b;     // Catch: Throwable -> L9
            String r2 = ECWindowProductCardGroupPresenterBase.k0(this.a.a);     // Catch: Throwable -> L9
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            r0.a(r1, r2);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECWindowProductCardGroupPresenterBase$behavior$1 a;
        public final /* synthetic */ WindowV2ProductItemVO b;

        public b(ECWindowProductCardGroupPresenterBase$behavior$1 r1, WindowV2ProductItemVO r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            h r0 = (h) this.a.a.n.getValue();
            if (r0 == null) goto L8;
            WindowV2ProductItemVO r1 = this.b;
            String r2 = ECWindowProductCardGroupPresenterBase.k0(this.a.a);
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            Boolean r3 = Boolean.valueOf(r0.a(r1, r2));
        L9:
            Boolean r4 = Boolean.TRUE;
            if (Intrinsics.areEqual(r3, r4) == false) goto L13;
            this.a.a.n0().getTabCache().d(wn.a.u, r4);
            return;
        L13:
            return;
        L8:
            r3 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void g(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        int r0 = rp.a.a;
        if (rp.a.a(r3.getId()) == false) goto L6;
        return;
    L6:
        if ((r3 instanceof WindowFollowCouponTagView) == false) goto L9;
        this.a.n0().runLowPriorityTask(new ECWindowProductCardGroupPresenterBase$behavior$1$onProductTagClick$1(this, r3));
        int r1 = com.bytedance.android.window.shop.widget.b.a;
        com.bytedance.android.ec.core.async.a.a(com.bytedance.android.window.shop.widget.b.a(this.a.o0(), ((WindowFollowCouponTagView) r3).getFansCouponSceneParam()), this.a.o0());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(WindowV2ProductItemVO r43) {
        Intrinsics.checkNotNullParameter(r43, "item");
        fo.b r0 = this.a.n0().getTabCache();
        fo.a r2 = wn.a.u;
        Boolean r3 = Boolean.TRUE;
        r0.d(r2, r3);
        BaseWindowTabViewModel r1 = this.a.n0();
        fo.a<Set<String>> r4 = wn.a.n;
        String r5 = r43.b;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r1.isIdFirstShowing(r4, r5) == false) goto L8;
        this.a.o0().add(Schedulers.io().scheduleDirect(new a(this, r43)));
    L8:
        HashMap r6 = new HashMap();
        String r7 = this.a.o0().getShopParam().getStoreSourcePage();
        if (r7 != null) goto L11;
        r7 = "store_page";
    L11:
        r6.put("enter_from_merge", r7);
        String r8 = this.a.o0().getShopParam().getStoreSourceMethod();
        if (r8 != null) goto L14;
        r8 = "mini_window";
    L14:
        r6.put("enter_method", r8);
        r6.put("data_type", "commerce_data");
        int r9 = com.bytedance.android.ec.window.base.product.presenter.utils.c.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.c.a(r43, this.a.Y(), r6);
        ECWindowParam r10 = this.a.o0().getShopParam();
        int r11 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        JSONObject r12 = com.bytedance.android.ec.window.base.product.presenter.utils.b.d(r10.getSearchParams(), r43);
        String r13 = (String) r43.C.a(wn.a.E);
        Map r14 = (Map) r43.C.a(wn.a.F);
        if (r13 == null) goto L17;
        String r15 = "a1.b7635.c68164.d15552_i" + ((Integer) r43.C.a(wn.a.C));
    L18:
        BtmItemBuilder r16 = new BtmItemBuilder(r15, r3).withBtmPage(this.a.r.getValue());
        BcmParams r17 = new BcmParams();
        r17.put("category_id", this.a.n0().getLastCategoryId());
        Unit r18 = Unit.INSTANCE;
        r16.internalSetUnitParams("description", r17);
        String r19 = BtmSDK.INSTANCE.createBtmId(r16.build());
        List r20 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r43.a);
        com.bytedance.commerce.base.json.a[] r21 = new com.bytedance.commerce.base.json.a[27];
        r21[0] = JsonDslUtilKt.d("product_source_page", r10.getEntranceLocation());
        r21[1] = JsonDslUtilKt.d("carrier_source", r10.getPageName());
        r21[2] = JsonDslUtilKt.d("source_method", this.a.m0());
        Integer r22 = r10.getFollowStatus();
        if (r22 == null) goto L22;
        String r23 = String.valueOf(r22.intValue());
        if (r23 == null) goto L22;
    L23:
        r21[3] = JsonDslUtilKt.d("follow_status", r23);
        r21[4] = JsonDslUtilKt.d("tab_label", "list_card");
        String r24 = r10.getTempId();
        if (r24 != null) goto L26;
        r24 = "";
    L26:
        r21[5] = JsonDslUtilKt.d("temp_id", r24);
        r21[6] = JsonDslUtilKt.d("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(this.b));
        r21[7] = JsonDslUtilKt.d("ecom_group_type", "product");
        String r25 = r10.getStoreSourcePage();
        if (r25 != null) goto L29;
        r25 = "";
    L29:
        r21[8] = JsonDslUtilKt.d("store_source_page", r25);
        String r26 = r10.getStoreSourceMethod();
        if (r26 != null) goto L32;
        r26 = "";
    L32:
        r21[9] = JsonDslUtilKt.d("store_source_method", r26);
        String r27 = r10.getStoreGroupType();
        if (r27 != null) goto L35;
        r27 = "";
    L35:
        r21[10] = JsonDslUtilKt.d("store_group_type", r27);
        r21[11] = JsonDslUtilKt.d("pre_product_id", this.a.o0().getShopParam().getPreProductId());
        r21[12] = JsonDslUtilKt.d("pre_room_id", this.a.o0().getShopParam().getPreRoomId());
        r21[13] = JsonDslUtilKt.d("pre_group_id", this.a.o0().getShopParam().getPreGroupId());
        r21[14] = JsonDslUtilKt.d("store_type", "window");
        String r28 = r43.b;
        Object r110 = null;
        if (r28 != null) goto L38;
    L45:
        r28 = r43.a;
    L46:
        r21[15] = JsonDslUtilKt.d("promotion_id", r28);
        boolean r29 = k.c(r43.i);
        String r111 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r29 == false) goto L49;
        String r30 = CommentScene.COMMENTSCENE_NO_AWEME;
    L50:
        r21[16] = JsonDslUtilKt.d("is_price_info", r30);
        if (r43.d() != null) goto L54;
        r111 = "0";
    L54:
        r21[17] = JsonDslUtilKt.d("is_recommend_info", r111);
        WindowV2ProductItemDTO.b r31 = r43.v;
        if (r31 == null) goto L57;
        String r32 = r31.a();
    L58:
        r21[18] = JsonDslUtilKt.d("content_form", r32);
        r21[19] = JsonDslUtilKt.d("content_source", "shop");
        String r33 = ECWindowProductCardGroupPresenterBase.k0(this.a);
        if (r33 != null) goto L61;
        r33 = "";
    L61:
        r21[20] = JsonDslUtilKt.d("tab_id", r33);
        BaseWindowTabViewModel r34 = this.a.n0();
        if ((r34 instanceof BaseWindowTabViewModel) == true) goto L64;
        r34 = null;
    L64:
        if (r34 == null) goto L67;
        String r35 = r34.getCategoryName();
        if (r35 == null) goto L67;
    L68:
        r21[21] = JsonDslUtilKt.d("classification_tab", r35);
        BaseWindowTabViewModel r36 = this.a.n0();
        if ((r36 instanceof BaseWindowTabViewModel) == true) goto L71;
        r36 = null;
    L71:
        if (r36 == null) goto L74;
        String r37 = r36.getLastCategoryId();
        if (r37 == null) goto L74;
    L75:
        r21[22] = JsonDslUtilKt.d("classification_tab_id", r37);
        BaseWindowTabViewModel r38 = this.a.n0();
        if ((r38 instanceof BaseWindowTabViewModel) == true) goto L78;
        r38 = null;
    L78:
        if (r38 == null) goto L81;
        String r39 = r38.getLastSubCategoryId();
        if (r39 == null) goto L81;
    L82:
        r21[23] = JsonDslUtilKt.d("classification_sub_tab_id", r39);
        String r40 = this.a.o0().getShopParam().getWhichAccount();
        if (r40 != null) goto L85;
        r40 = "";
    L85:
        r21[24] = JsonDslUtilKt.d("which_account", r40);
        ECWindowProductCardGroupPresenterBase r41 = this.a;
        if ((r43 instanceof tq3.c) == true) goto L88;
        WindowV2ProductItemVO r112 = null;
    L89:
        tq3.c r113 = (tq3.c) r112;
        r41.getClass();
        if (r113 == null) goto L101;
        List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r42 = r113.S;
        if (r42 == null) goto L101;
        ArrayList r114 = new ArrayList();
        Iterator<T> r44 = r42.iterator();
    L95:
        if (r44.hasNext() == false) goto L99;
        String r115 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r44.next()).c();
        if (r115 == null) goto L95;
        r114.add(r115);
        goto L95
    L99:
        String r45 = CollectionsKt.joinToString$default(r114, null, null, null, 0, null, null, 63, null);
        if (r45 == null) goto L101;
    L102:
        r21[25] = JsonDslUtilKt.d("product_tags", r45);
        r21[26] = JsonDslUtilKt.d("bst_group_type", "product");
        JSONObject r46 = JsonDslUtilKt.a(r21);
        Map r47 = r43.q;
        if (r47 == null) goto L106;
        String r48 = (String) r47.get("tab_name_second");
        if (r48 == null) goto L106;
    L107:
        if (r48 == null) goto L109;
        r46.put("source_method_second", r48);
    L109:
        fo.b r49 = r43.C;
        fo.a r116 = wn.a.a;
        String r50 = (String) r49.a(r116);
        if (r50 == null) goto L112;
        r46.put(r116.a, r50);
    L112:
        ECWindowProductCardGroupPresenterBase.a r51 = ECWindowProductCardGroupPresenterBase.w;
        BaseWindowTabViewModel r117 = this.a.n0();
        r51.getClass();
        r46.put("tab_name_second", ECWindowProductCardGroupPresenterBase.a.c(r43, r117));
        fo.b r52 = r43.C;
        fo.a r118 = wn.a.f;
        Integer r53 = (Integer) r52.a(r118);
        if (r53 == null) goto L116;
        r46.put(r118.a, r53.intValue());
    L116:
        if (r10.isEcShare() == false) goto L118;
        r46.accumulate("share_content", r10.getShareContent());
        r46.accumulate("share_object", r10.getShareObject());
    L118:
        Map r54 = r43.q;
        if (r54 == null) goto L124;
        Iterator r55 = r54.entrySet().iterator();
    L122:
        if (r55.hasNext() == false) goto L124;
        Map.Entry r119 = (Map.Entry) r55.next();
        r46.put((String) r119.getKey(), r119.getValue());
    L124:
        JSONObject r56 = z1.g((String) this.a.o0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r56 == null) goto L127;
        r46.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r56.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L127:
        z1.b(r46, cd.a.c(this.a.q));
        f r57 = (f) r43.C.a(wn.a.D);
        if (r57 == null) goto L134;
        Map<String, ? extends Map<String, String>> r58 = r57.d;
        if (r58 == null) goto L134;
        Set<String> r59 = r58.keySet();
        if (r59 == null) goto L134;
        String r60 = CollectionsKt.joinToString$default(r59, ",", null, null, 0, null, null, 62, null);
    L135:
        if (r60 == null) goto L137;
        r46.put("ui_elements", r60);
    L137:
        if (r14 == null) goto L143;
        Iterator r61 = r14.entrySet().iterator();
    L140:
        if (r61.hasNext() == false) goto L142;
        Map.Entry r120 = (Map.Entry) r61.next();
        r46.put((String) r120.getKey(), (String) r120.getValue());
        goto L140
    L142:
        Unit r62 = Unit.INSTANCE;
    L143:
        if (r13 != null) goto L145;
        String r63 = r43.E;
    L146:
        if (r63 != null) goto L148;
    L151:
        boolean r64 = true;
    L153:
        if (r64 == true) goto L175;
        int r65 = zq3.f.a;
        String r66 = zq3.f.c(r63, r19, PageFinder.via(this.c), zq3.f.a(r10.getAuthorId(), r43));
        if (Intrinsics.areEqual(r63, r13) == false) goto L171;
        p r67 = p.a;
        Context r68 = this.a.Y().c();
        ECWindowProductCardGroupPresenterBase r69 = this.a;
        r69.getClass();
        o0 r70 = new o0(r66);
        String r71 = r46.toString();
        xn.c.b(r46, r69.Y().a());
        JSONObject r72 = WindowEntranceInfoExtKt.a(r46, WindowEntranceInfoScene.PRODUCT_GENERIC, r71);
        String r121 = r70.e("entrance_info");
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L159
        Object r74 = Result.constructor-impl(z1.g(r121));     // Catch: Throwable -> L159
    L162:
        if (Result.isFailure-impl(r74) == true) goto L165;
        r110 = r74;
    L165:
        JSONObject r122 = (JSONObject) r110;
        if (r121 == null) goto L169;
        if (r122 == null) goto L170;
        xn.c.a(r122, r72);
        r70.a("entrance_info", r122.toString());
    L170:
        r67.openSchema(r68, r70.c());
    L223:
        ECWindowProductCardGroupPresenterBase.a r75 = ECWindowProductCardGroupPresenterBase.w;
        ECWindowViewModel r76 = this.a.o0();
        BaseWindowTabViewModel r77 = this.a.n0();
        WindowLayoutType r78 = this.b;
        String r79 = ECWindowProductCardGroupPresenterBase.k0(this.a);
        if (r79 != null) goto L226;
        String r80 = "";
    L227:
        Map r81 = ECWindowProductCardGroupPresenterBase.a.b(r75, r76, r77, r43, r78, r80);
        if (r14 == null) goto L230;
        r81.putAll(r14);
    L230:
        Map r82 = MapsKt.plus(r81, this.a.q);
        int r83 = WindowBstReport.a;
        WindowBstReport.g(this.a.a0(), ECWindowProductCardGroupPresenterBase.l0(this.a, r43), r43, this.b, r82, this.a.o0(), this.a.n0());
        dm.a.a("WINDOW").i("[click product]productId:" + r43.a);
        dm.a.a("WINDOW").i("[click product]secAuthorId:" + r10.getSecAuthorId());
        return;
    L226:
        r80 = r79;
        goto L227
    L169:
        r70.a("entrance_info", r72.toString());
    L159:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L162
    L171:
        xn.b r124 = xn.b.f;
        Context r125 = this.a.Y().c();
        String r210 = String.valueOf(r10.getFollowStatus());
        JSONObject r211 = WindowEntranceInfoExtKt.a(r46, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null);
        Map r212 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r10.getAuthorId()), TuplesKt.to("product_id", r43.a)});
        u r84 = r43.w;
        if (r84 == null) goto L174;
        r110 = r84.i();
    L174:
        com.bytedance.android.ec.window.base.common.starter.f.b(r124, r125, r66, r210, r211, r212, r110);
        goto L223
    L175:
        int r85 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.b.f(PageFinder.via(this.a.a0()), this.a.o0().getShopParam().getAuthorId(), r43);
        xn.b r126 = xn.b.f;
        Context r127 = this.a.Y().c();
        String r86 = r43.b;
        if (r86 != null) goto L178;
    L185:
        r86 = r43.a;
    L186:
        String r213 = r86;
        String r214 = r10.getPageName();
        String r87 = r43.m;
        String r215 = r10.getAuthorId();
        String r216 = r10.getSecAuthorId();
        String r88 = r43.a;
        Integer r217 = r10.getFollowStatus();
        String r218 = r10.getWhichAccount();
        WindowEntranceInfoScene r89 = WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL;
        Set<WindowEntranceInfoScene> r90 = WindowEntranceInfoExtKt.a;
        Intrinsics.checkNotNullParameter(r46, "$this$doPostEntranceInfoStringCheck");
        Intrinsics.checkNotNullParameter(r89, "scene");
        gl.a r91 = WindowEntranceInfoExtKt.b(r46, r89, null);
        if (r91 != null) goto L189;
        String r92 = r46.toString();
    L190:
        String r219 = r92;
        if (r12 == null) goto L193;
        String r310 = r12.toString();
    L194:
        com.bytedance.commerce.base.json.a[] r93 = new com.bytedance.commerce.base.json.a[1];
        JSONObject r94 = z1.g((String) this.a.o0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r94 == null) goto L197;
        String r95 = r94.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L198:
        if (r95 != null) goto L200;
        r95 = "";
    L200:
        r93[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r95);
        JSONObject r96 = JsonDslUtilKt.a(r93);
        if ((r43 instanceof rq3.a) == true) goto L203;
        WindowV2ProductItemVO r97 = null;
    L204:
        rq3.a r98 = (rq3.a) r97;
        if (r98 == null) goto L214;
        String r99 = r98.Q;
        if (r99 == null) goto L214;
        if ((!StringsKt.isBlank(r99)) == true) goto L212;
        r99 = null;
    L212:
        if (r99 == null) goto L214;
        r96.put("cps_track", r99);
        int r100 = 0;
        r96.put("cps_report_type", 0);
        Unit r101 = Unit.INSTANCE;
    L215:
        Unit r102 = Unit.INSTANCE;
        String r311 = (String) CollectionsKt.getOrNull(r43.h, r100);
        u r103 = r43.w;
        if (r103 == null) goto L218;
        r110 = r103.i();
    L218:
        String r312 = r110;
        Long r104 = r43.c;
        if (r104 == null) goto L221;
        long r105 = r104.longValue();
    L222:
        com.bytedance.android.ec.window.base.common.starter.f.a(r126, r127, r213, r214, r87, r215, r216, r88, r217, "list_card", r218, r219, r310, r96, r311, false, r312, r105, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", this.a.o0().getShopParam().getAuthorId())}), (String) r43.C.a(wn.a.y), (String) r43.C.a(wn.a.z), null, 260603904);
        goto L223
    L221:
        r105 = SourceType.UNKNOWN.getType();
    L214:
        r100 = 0;
        goto L215
    L203:
        r97 = r43;
        goto L204
    L197:
        r95 = null;
        goto L198
    L193:
        r310 = null;
        goto L194
    L189:
        r92 = r91.h();
        goto L190
    L178:
        if (r86.length() <= 0) goto L180;
        boolean r106 = true;
    L181:
        if (r106 == true) goto L184;
        r86 = null;
    L184:
        if (r86 != null) goto L186;
    L180:
        r106 = false;
        goto L181
    L148:
        if (StringsKt.isBlank(r63) == true) goto L151;
        r64 = false;
        goto L153
    L145:
        r63 = r13;
    L134:
        r60 = null;
    L106:
        r48 = (String) r43.C.a(wn.a.e);
    L101:
        r45 = "";
        goto L102
    L88:
        r112 = r43;
    L81:
        r39 = "";
    L74:
        r37 = "";
    L67:
        r35 = "";
        goto L68
    L57:
        r32 = "";
        goto L58
    L49:
        r30 = "0";
        goto L50
    L38:
        if (r28.length() <= 0) goto L40;
        boolean r128 = true;
    L41:
        if (r128 == true) goto L44;
        r28 = null;
    L44:
        if (r28 != null) goto L46;
    L40:
        r128 = false;
    L22:
        r23 = "";
        goto L23
    L17:
        r15 = ECWindowProductCardGroupPresenterBase.l0(this.a, r43);
        goto L18
    }

    public final void c(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void d(WindowV2ProductItemVO r27) {
        Intrinsics.checkNotNullParameter(r27, "item");
        if (a2.b(r27.r) == false) goto L50;
        int r2 = r27.f;
        if (r2 != 1) goto L14;
        UrlBuilderV2 r3 = new UrlBuilderV2(r27.r);
        JSONObject r14 = cd.a.c(this.a.o0().getMetaInfoWithoutKolId());
        r14.put("author_id", this.a.o0().getShopParam().getAuthorId());
        Unit r9 = Unit.INSTANCE;
        r3.addOrReplaceParam("meta_info", r14);
        String r17 = r3.build();
        int r4 = zq3.f.a;
        QContext r5 = this.a.Y();
        Context r10 = l0.c(r5.c());
        if ((r10 instanceof FragmentActivity) == true) goto L9;
        Context r7 = null;
    L10:
        if (r7 != null) goto L12;
        Context r15 = r5.a();
    L13:
        zq3.f.b(r15, this.a.o0(), r17, "a1.b7635.c68164.d22909", PageFinder.via(this.a.a0()), null);
        this.a.o0().doEventAction("window_tag_click", new Pair[]{TuplesKt.to("entrance_location", "store_page_product_card"), TuplesKt.to("enter_from", "store_page_product_card"), TuplesKt.to("product_id", r27.a), TuplesKt.to("tag_type", CommentServiceId.HOT_SPOT)});
        return;
    L12:
        r15 = r7;
        goto L13
    L9:
        r7 = r10;
        goto L10
    L14:
        if (r2 != 2) goto L52;
        String r6 = r27.r;
        if (r6 == null) goto L27;
        m0 r8 = new m0(r6);
        r8.b("enter_from", "store_page_product_card");
        r8.b("pre_product_id", this.a.o0().getShopParam().getPreProductId());
        r8.b("pre_group_id", this.a.o0().getShopParam().getPreGroupId());
        r8.b("pre_room_id", this.a.o0().getShopParam().getPreRoomId());
        r8.b("entrance_location", "store_page_product_card");
        String r11 = this.a.o0().getShopParam().getStoreSourcePage();
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r8.b("store_source_page", r11);
        String r12 = this.a.o0().getShopParam().getStoreSourceMethod();
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r8.b("store_source_method", r12);
        String r13 = this.a.o0().getShopParam().getStoreGroupType();
        if (r13 != null) goto L26;
        r13 = "";
    L26:
        r8.b("store_group_type", r13);
        r8.b("pass_through_api", (String) this.a.o0().getShopParam().getPassThroughParam("pass_through_api"));
        String r16 = r8.c();
    L28:
        int r18 = zq3.f.a;
        QContext r19 = this.a.Y();
        Context r20 = l0.c(r19.c());
        if ((r20 instanceof FragmentActivity) == true) goto L31;
        Context r110 = null;
    L32:
        if (r110 != null) goto L34;
        Context r21 = r19.a();
    L35:
        ECWindowViewModel r22 = this.a.o0();
        if (r16 != null) goto L38;
        String r23 = "";
    L39:
        zq3.f.b(r21, r22, r23, "a1.b7635.c68164.d22909", PageFinder.via(this.a.a0()), null);
        ECWindowViewModel r24 = this.a.o0();
        PageFinder r25 = PageFinder.via(this.c);
        Pair[] r26 = new Pair[8];
        r26[0] = TuplesKt.to("author_id", this.a.o0().getShopParam().getAuthorId());
        r26[1] = TuplesKt.to("entrance_location", "store_page_product_card");
        r26[2] = TuplesKt.to("enter_from", "store_page_product_card");
        String r28 = this.a.o0().getShopParam().getStoreSourcePage();
        if (r28 != null) goto L42;
        r28 = "";
    L42:
        r26[3] = TuplesKt.to("store_source_page", r28);
        String r29 = this.a.o0().getShopParam().getStoreSourceMethod();
        if (r29 != null) goto L45;
        r29 = "";
    L45:
        r26[4] = TuplesKt.to("store_source_method", r29);
        String r30 = this.a.o0().getShopParam().getStoreGroupType();
        if (r30 != null) goto L48;
        r30 = "";
    L48:
        r26[5] = TuplesKt.to("store_group_type", r30);
        r26[6] = TuplesKt.to("store_type", "shop");
        r26[7] = TuplesKt.to("product_id", r27.a);
        r24.doAnyEventActionWithBtm("a1.b7635.c68164.d22909", r25, "click_store_entrance", MapsKt.mapOf(r26), new Pair[0]);
        return;
    L38:
        r23 = r16;
        goto L39
    L34:
        r21 = r110;
        goto L35
    L31:
        r110 = r20;
        goto L32
    L27:
        r16 = null;
        goto L28
    L52:
        return;
    }

    public final void e(final WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        BaseWindowTabViewModel r0 = this.a.n0();
        fo.a r1 = wn.a.a;
        if (r0.shouldReportEvent(wn.a.j, r4.a) == true) goto L6;
        return;
    L6:
        if (k.i((Boolean) this.a.n0().getTabCache().a(wn.a.u)) == true) goto L8;
        this.a.o0().add(Schedulers.io().scheduleDirect(new b(this, r4)));
    L8:
        this.a.n0().runLowPriorityTask(new ECWindowProductCardGroupPresenterBase$behavior$1$onDisplaySource$2(this, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(final WindowFollowCouponTagView r6) {
        Intrinsics.checkNotNullParameter(r6, "tag");
        Intrinsics.checkNotNullParameter(r6, "tag");
        BaseWindowTabViewModel r0 = this.a.n0();
        fo.a<Set<String>> r1 = wn.a.i;
        lq3.b<lq3.d> r2 = r6.getFansCouponSceneParam();
        String r3 = null;
        if (r2 == null) goto L7;
        lq3.d r4 = r2.b;
        if (r4 == null) goto L7;
        String r5 = r4.b();
    L8:
        lq3.b<lq3.d> r7 = r6.getFansCouponSceneParam();
        if (r7 == null) goto L14;
        lq3.d r8 = r7.b;
        if (r8 == null) goto L14;
        r3 = r8.a();
    L14:
        if (r0.shouldReportEvent(r1, Intrinsics.stringPlus(r5, r3)) == false) goto L17;
        this.a.n0().runLowPriorityTask(new ECWindowProductCardGroupPresenterBase$behavior$1$onProductTagShow$1(this, r6));
        return;
    L17:
        return;
    L7:
        r5 = null;
        goto L8
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

    public ECWindowProductCardGroupPresenterBase$behavior$1(ECWindowProductCardGroupPresenterBase r1, WindowLayoutType r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
