package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.product.OneFrameAsyncTask;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.dto.MarketingDataDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSlcProductCardGroupPresenter extends sm.m {
    public static final Lazy B = null;
    public final ECStoreViewModel A;
    public com.bytedance.android.shopping.store.hybridproduct.module.r o;
    public final Map<String, Object> p;
    public final Set<String> q;
    public final Set<Map<String, String>> r;
    public View s;
    public final Lazy t;
    public final Lazy u;
    public final Map<String, Object> v;
    public final ECShopSlcProductCardGroupPresenter$adapter$1 w;
    public final b x;
    public final StoreEventReporter y;
    public final ECShopSlcProductCardGroupPresenter$actionHandler$1 z;

    public final class StoreEventReporter implements sm.f {
        public final Lazy a;
        public final Set<EventTags> b;
        public final /* synthetic */ ECShopSlcProductCardGroupPresenter c;

        public final Set<EventTags> a() {
            return this.b;
        }

        public StoreEventReporter(ECShopSlcProductCardGroupPresenter r1) {
            this.c = r1;
            Lazy r2 = LazyKt.lazy(ECShopSlcProductCardGroupPresenter$StoreEventReporter$tagsSet$2.INSTANCE);
            this.a = r2;
            this.b = (Set) r2.getValue();
        }

        public final void b(StoreV2ProductItemVO r3, List<ECRitTag> r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "ritTagList");
            Intrinsics.checkNotNullParameter(r5, "eventParams");
            if (this.c.r0().getStoreParam().isPreview() == false) goto L6;
            return;
        L6:
            if (this.c.r0().getIdRecords().contains(r3.a) == false) goto L8;
            return;
        L8:
            ECShopSlcProductCardGroupPresenter r6 = this.c;
            r6.getClass();
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r6.r0().getStoreParam().getLifecycleMonitorId()));
            if (r7 == null) goto L11;
            Intrinsics.checkNotNullParameter(r3, "$this$toProductShowVO");
            com.bytedance.android.shopping.store.lifecycle.f r1 = new com.bytedance.android.shopping.store.lifecycle.f();
            r1.a = r3.o;
            r1.b = r3.v;
            r7.L(r1);
        L11:
            Map<String, String> r8 = this.c.o0("show_product", r3);
            if (r8 == null) goto L15;
            Map<String, ? extends Object> r9 = MapsKt.plus(r8, r5);
            if (r9 == null) goto L15;
        L16:
            this.c.v.putAll(r5);
            int r10 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.e(this.c.a0(), this.c.n0(r3), r3, r9, this.c.r0());
            this.c.r0().getIdRecords().add(r3.a);
            return;
        L15:
            r9 = r5;
            goto L16
        }
    }

    public static final class a {
    }

    public static final class b implements sm.g {
        public final /* synthetic */ ECShopSlcProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ StoreV2ProductItemVO b;

            public a(b r1, StoreV2ProductItemVO r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                ECShopSlcProductCardGroupPresenter r0 = this.a.a;
                Map<String, Object> r1 = r0.p;
                r1.put("tag_code_list", r0.q);
                r1.put("highlight_tag_code", com.bytedance.android.ec.hybrid.list.util.k.d(this.a.a.r));
                this.a.a.y.b(this.b, CollectionsKt.emptyList(), this.a.a.p);
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

        public final void b(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void c(StoreV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            this.a.r0().doEventAction("add_to_cart_show", this.a.o0("show_product", r4), new Pair[0]);
        }

        public final void d(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            ECShopSlcProductCardGroupPresenter.l0(this.a, r2);
        }

        public final void e(StoreV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            ECShopSlcProductCardGroupPresenter r0 = this.a;
            if ((r0.y instanceof StoreEventReporter) == false) goto L5;
            OneFrameAsyncTask.a(new a(this, r4));
            return;
        L5:
            Map<String, Object> r1 = r0.p;
            r1.put("tag_code_list", r0.q);
            r1.put("highlight_tag_code", com.bytedance.android.ec.hybrid.list.util.k.d(this.a.r));
            this.a.y.b(r4, CollectionsKt.emptyList(), this.a.p);
        }

        public final void f(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            this.a.r0().doEventAction("add_cart_toast_show", com.bytedance.android.ec.store.product.presenter.utils.a.d(r5), new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("ecom_group_type", "product_card"), TuplesKt.to("bst_group_type", "product")});
        }

        public final void g(StoreV2ProductItemVO r37) {
            Intrinsics.checkNotNullParameter(r37, "item");
            ECShopSlcProductCardGroupPresenter r2 = this.a;
            ECShopHybridProductViewModel r3 = r2.r0();
            com.bytedance.android.ec.store.setting.f r4 = ECStoreSettings.a();
            if (r4 == null) goto L5;
            boolean r5 = r4.a();
        L6:
            r2.o = com.bytedance.android.shopping.store.hybridproduct.module.s.a(r3, r37, r5);
            BtmSDK r6 = BtmSDK.INSTANCE;
            String r7 = this.a.n0(r37);
            PageFinder r8 = PageFinder.via(this.b);
            BcmParams r9 = new BcmParams();
            r9.put("bst_group_type", "product");
            Unit r10 = Unit.INSTANCE;
            String r11 = r6.createJumpSourceBtmToken(r7, r8, r9.merge((Map) r37.P.getValue()));
            ECStoreParam r12 = this.a.r0().getStoreParam();
            ECStoreViewModel r13 = this.a.A;
            if (r13 == null) goto L11;
            im.b r14 = r13.getLiveManager();
            if (r14 == null) goto L11;
            r14.j();
        L11:
            int r15 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r16 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r12.getSearchParams(), r37);
            String r17 = this.a.r0().getEcomEntranceFrom();
            if ((!StringsKt.isBlank(r17)) == true) goto L16;
            r17 = null;
        L16:
            if (r17 == null) goto L18;
        L24:
            List r18 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r37.a);
            List<com.bytedance.android.ec.store.repository.dto.g> r19 = this.a.r0().getPickTypes();
            if (r19 == null) goto L37;
            com.bytedance.android.ec.store.repository.dto.g r20 = (com.bytedance.android.ec.store.repository.dto.g) CollectionsKt.firstOrNull(r19);
            if (r20 == null) goto L37;
            if (r20.a() == 0) goto L31;
            boolean r110 = true;
        L32:
            if (r110 == true) goto L35;
            r20 = null;
        L35:
            if (r20 == null) goto L37;
            Boolean r21 = Boolean.valueOf(r20.b());
        L38:
            com.bytedance.commerce.base.json.a[] r111 = new com.bytedance.commerce.base.json.a[26];
            if (Intrinsics.areEqual(this.a.r0().getStoreParam().getShareContent(), "shop") == false) goto L41;
            String r112 = "share_alert";
        L42:
            r111[0] = JsonDslUtilKt.d("product_source_page", r112);
            r111[1] = JsonDslUtilKt.d("source_method", r17);
            if (Intrinsics.areEqual(this.a.r0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L45;
            String r22 = "_" + r37.v;
        L46:
            r111[2] = JsonDslUtilKt.d("tab_label", r22);
            r111[3] = JsonDslUtilKt.d("category_id", "");
            r111[4] = JsonDslUtilKt.d("tab_type", "");
            r111[5] = JsonDslUtilKt.d("page_version", "");
            r111[6] = JsonDslUtilKt.d("page_name", r12.getPageName());
            r111[7] = JsonDslUtilKt.d("price_type", String.valueOf(r37.h));
            Integer r23 = r12.getFollowStatus();
            if (r23 == null) goto L49;
            String r24 = String.valueOf(r23.intValue());
        L50:
            if (r24 != null) goto L52;
            r24 = "";
        L52:
            r111[8] = JsonDslUtilKt.d("follow_status", r24);
            String r25 = r12.getTempId();
            if (r25 != null) goto L55;
            r25 = "";
        L55:
            r111[9] = JsonDslUtilKt.d("temp_id", r25);
            r111[10] = JsonDslUtilKt.d("store_type", "shop");
            String r26 = r12.getStoreSourcePage();
            if (r26 != null) goto L58;
            r26 = "";
        L58:
            r111[11] = JsonDslUtilKt.d("store_source_page", r26);
            String r27 = r12.getStoreSourceMethod();
            if (r27 != null) goto L61;
            r27 = "";
        L61:
            r111[12] = JsonDslUtilKt.d("store_source_method", r27);
            String r28 = r12.getStoreGroupType();
            if (r28 != null) goto L64;
            r28 = "";
        L64:
            r111[13] = JsonDslUtilKt.d("store_group_type", r28);
            String r29 = r12.getLiveAnchorId();
            if (r29 != null) goto L67;
            r29 = "";
        L67:
            r111[14] = JsonDslUtilKt.d("live_anchor_id", r29);
            r111[15] = JsonDslUtilKt.d("pre_product_id", r12.getPreProductId());
            r111[16] = JsonDslUtilKt.d("pre_room_id", r12.getPreRoomId());
            r111[17] = JsonDslUtilKt.d("pre_group_id", r12.getPreGroupId());
            r111[18] = JsonDslUtilKt.d("product_ratio", r37.b());
            LayoutTypes r30 = (LayoutTypes) this.a.r0().getLayoutType().getValue();
            if (r30 != null) goto L71;
        L72:
            String r31 = "double_product";
        L74:
            r111[19] = JsonDslUtilKt.d("product_form", r31);
            MarketingDataDTO r32 = r37.D;
            if (r32 == null) goto L77;
            String r33 = r32.getTransMeta();
        L79:
            if (com.bytedance.android.shopping.extensions.k.c(r33) == false) goto L82;
            String r34 = "return_coin";
        L85:
            r111[20] = JsonDslUtilKt.d("source_method_second", r34);
            if (this.a.r0().hasDiscountSelected() == false) goto L88;
            String r35 = CommentScene.COMMENTSCENE_NO_AWEME;
        L89:
            r111[21] = JsonDslUtilKt.d("is_discount_selected", r35);
            r111[22] = JsonDslUtilKt.d("dynamic_product_status", r37.H.getStatus());
            r111[23] = JsonDslUtilKt.c("dismiss_live_strand", 1);
            com.bytedance.android.ec.store.repository.dto.n r36 = r37.G;
            if (r36 == null) goto L92;
            String r38 = r36.d();
        L93:
            if (r38 != null) goto L95;
            r38 = "";
        L95:
            r111[24] = JsonDslUtilKt.d("shop_video_id", r38);
            com.bytedance.android.ec.store.repository.dto.n r39 = r37.G;
            if (r39 == null) goto L98;
            Integer r40 = r39.f();
        L99:
            r111[25] = JsonDslUtilKt.d("shop_video_source", String.valueOf(r40));
            JSONObject r41 = JsonDslUtilKt.a(r111);
            ECHybridExtensionsKt.d(r41, com.bytedance.android.shopping.store.utils.y.a(r37));
            if (r12.getProductBasicRequestParam().isCustom() == false) goto L103;
            r41.accumulate("customer_id", r12.getProductBasicRequestParam().getMaterialId());
        L103:
            if (r12.isEcShare() == false) goto L105;
            r41.accumulate("share_content", r12.getShareContent());
            r41.accumulate("share_object", r12.getShareObject());
        L105:
            r41.accumulate("icon_type", this.a.r0().getStoreParam().getPassThroughParam("icon_type"));
            Map r113 = r37.o;
            if (r113 == null) goto L111;
            Iterator r114 = r113.entrySet().iterator();
        L109:
            if (r114.hasNext() == false) goto L111;
            Map.Entry r115 = (Map.Entry) r114.next();
            r41.put((String) r115.getKey(), r115.getValue());
        L111:
            JSONObject r42 = com.bytedance.android.shopping.extensions.k.w((String) this.a.r0().getStoreParam().getPassThroughParam("pass_through_api"));
            if (r42 == null) goto L115;
            r41.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r42.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
            Unit r43 = Unit.INSTANCE;
        L115:
            if (com.bytedance.android.shopping.extensions.k.c(r37.C) == false) goto L131;
            int r44 = com.bytedance.android.ec.store.utils.b.a;
            String r210 = com.bytedance.android.ec.store.utils.b.a(r37.C, r11);
            if (r210 != null) goto L119;
            return;
        L119:
            hm.b r116 = hm.b.c;
            Context r117 = this.a.Y().c();
            String r211 = String.valueOf(r12.getFollowStatus());
            ECStoreViewModel r45 = this.a.A;
            if (r45 == null) goto L124;
            Map<String, Object> r46 = r45.getAdParams();
            if (r46 == null) goto L124;
            r46.put("product_id", r37.a);
            Unit r47 = Unit.INSTANCE;
            Map<String, Object> r212 = r46;
        L125:
            boolean r48 = r37.N;
            int r49 = ECSdk.a;
            IAdapterService r50 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r50 == null) goto L130;
            wu1.a r51 = r50.getECLiveStateController();
            if (r51 == null) goto L130;
            r51.e();
        L130:
            com.bytedance.android.ec.store.common.starter.e.b(r116, r117, r210, r211, r41, r212, null, r48, 128);
            JSONObject r52 = null;
        L219:
            ECShopSlcProductCardGroupPresenter r53 = this.a;
            r53.getClass();
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r54 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r55 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r53.r0().getStoreParam().getLifecycleMonitorId()));
            if (r55 == null) goto L222;
            com.bytedance.android.shopping.store.lifecycle.c.a.a(r55, "click_product", r53.o0("click_product", r37), r52, 4);
        L222:
            Map<String, String> r56 = this.a.o0("click_product", r37);
            if (r56 == null) goto L226;
            Map<String, Object> r57 = MapsKt.plus(MapsKt.plus(r56, this.a.v), this.a.p);
            if (r57 == null) goto L226;
        L227:
            int r58 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.c(this.a.a0(), this.a.n0(r37), r37, r57, this.a.r0());
            com.bytedance.android.ec.sdk.helper.c r59 = com.bytedance.android.ec.sdk.helper.c.a;
            r59.b("SHOP", "[click product]productId:" + r37.a);
            r59.b("SHOP", "[click product]secShopId:" + r12.getSecShopId());
            return;
        L226:
            r57 = this.a.v;
        L124:
            r212 = null;
            goto L125
        L131:
            com.bytedance.android.ec.store.repository.dto.n r60 = r37.G;
            if (r60 == null) goto L134;
            Integer r61 = r60.f();
        L135:
            com.bytedance.android.ec.store.repository.dto.n r118 = r37.G;
            if (r118 == null) goto L138;
            String r119 = r118.d();
        L139:
            if (r61 != null) goto L142;
        L143:
            if (r61 != null) goto L146;
        L155:
            String r310 = null;
        L156:
            hm.b r62 = hm.b.c;
            Context r63 = this.a.Y().c();
            String r120 = r37.b;
            if (r120 != null) goto L159;
        L166:
            r120 = r37.a;
        L168:
            if (r61 != null) goto L171;
        L176:
            String r64 = r37.l;
        L177:
            String r121 = this.a.w.a();
            if (r121 != null) goto L180;
            r121 = "";
            String r122 = r121;
        L181:
            String r123 = this.a.w.d();
            if (r123 != null) goto L184;
            String r213 = r122;
        L185:
            String r124 = r37.a;
            Integer r214 = r12.getFollowStatus();
            String r215 = r12.getWhichAccount();
            String r125 = r37.b;
            if (r125 != null) goto L188;
            r125 = r122;
        L188:
            r41.put("promotion_id", r125);
            r41.put("carrier_source", "store_page");
            MarketingDataDTO r65 = r37.D;
            if (r65 == null) goto L191;
            String r66 = r65.getTransMeta();
        L192:
            if (r66 != null) goto L194;
            r66 = r122;
        L194:
            r41.put("trans_meta", r66);
            Unit r67 = Unit.INSTANCE;
            String r68 = r41.toString();
            if (r16 == null) goto L197;
            String r126 = r16.toString();
            int r69 = 1;
        L198:
            com.bytedance.commerce.base.json.a[] r70 = new com.bytedance.commerce.base.json.a[r69];
            JSONObject r71 = com.bytedance.android.shopping.extensions.k.w((String) this.a.r0().getStoreParam().getPassThroughParam("pass_through_api"));
            if (r71 == null) goto L201;
            String r72 = r71.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L202:
            if (r72 != null) goto L204;
            String r127 = r122;
        L205:
            r70[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r127);
            JSONObject r73 = JsonDslUtilKt.a(r70);
            String r216 = (String) CollectionsKt.getOrNull(r37.f, 0);
            int r74 = ECSdk.a;
            IAdapterService r75 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r75 == null) goto L210;
            wu1.a r76 = r75.getECLiveStateController();
            if (r76 == null) goto L210;
            r76.e();
        L210:
            Long r77 = r37.c;
            if (r77 == null) goto L213;
            long r128 = r77.longValue();
        L214:
            long r311 = r128;
            ECStoreViewModel r78 = this.a.A;
            if (r78 == null) goto L217;
            Map<String, Object> r312 = r78.getAdParams();
        L218:
            r52 = null;
            com.bytedance.android.ec.store.common.starter.e.a(r62, r63, r120, "store_page", r64, r121, r213, r124, r214, r17, r215, r68, r126, r73, r216, true, null, r311, null, r312, null, r37.F, r11, r310, 32047104);
            goto L219
        L217:
            r312 = null;
            goto L218
        L213:
            r128 = SourceType.UNKNOWN.getType();
            goto L214
        L204:
            r127 = r72;
            goto L205
        L201:
            r72 = null;
            goto L202
        L197:
            r69 = 1;
            r126 = null;
            goto L198
        L191:
            r66 = null;
            goto L192
        L184:
            r213 = r123;
            goto L185
        L180:
            r122 = "";
            goto L181
        L171:
            if (r61.intValue() != 3) goto L176;
            com.bytedance.android.ec.store.repository.dto.n r79 = r37.G;
            if (r79 == null) goto L175;
            r64 = r79.d();
            goto L177
        L175:
            r64 = null;
            goto L177
        L159:
            if (r120.length() <= 0) goto L161;
            boolean r129 = true;
        L162:
            if (r129 == true) goto L165;
            r120 = null;
        L165:
            if (r120 != null) goto L168;
        L161:
            r129 = false;
            goto L162
        L146:
            if (r61.intValue() != 1) goto L155;
        L147:
            if (r119 != null) goto L149;
        L152:
            boolean r80 = true;
        L153:
            if (r80 == true) goto L155;
            JSONObject r81 = new JSONObject();
            r81.put("config_type", CommentScene.COMMENTSCENE_NO_AWEME);
            r81.put("content_type", String.valueOf(3 - r61.intValue()));
            r81.put("item_id", r119);
            r81.put("start_time", "0");
            r81.put("auto_play", true);
            r310 = r81.toString();
            goto L156
        L149:
            if (StringsKt.isBlank(r119) == true) goto L152;
            r80 = false;
            goto L153
        L142:
            if (r61.intValue() == 2) goto L147;
        L138:
            r119 = null;
            goto L139
        L134:
            r61 = null;
            goto L135
        L98:
            r40 = null;
            goto L99
        L92:
            r38 = null;
            goto L93
        L88:
            r35 = "0";
            goto L89
        L82:
            if (Intrinsics.areEqual(r21, Boolean.TRUE) == false) goto L84;
            r34 = "live_product";
            goto L85
        L84:
            r34 = CommentServiceId.HOT_SPOT;
            goto L85
        L77:
            r33 = null;
            goto L79
        L71:
            if (q.b[r30.ordinal()] != 1) goto L72;
            r31 = "single_product";
            goto L74
        L49:
            r24 = null;
            goto L50
        L45:
            r22 = "";
            goto L46
        L41:
            r112 = r12.getEntranceLocation();
            goto L42
        L31:
            r110 = false;
        L37:
            r21 = null;
            goto L38
        L18:
            if (Intrinsics.areEqual(this.a.r0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L21;
            r17 = "classification";
            goto L24
        L21:
            if (r12.getProductBasicRequestParam().isCustom() == false) goto L23;
            r17 = "featured";
            goto L24
        L23:
            r17 = "products";
            goto L24
        L5:
            r5 = false;
            goto L6
        }

        public final void h(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            ECShopHybridProductViewModel r0 = this.a.r0();
            Pair[] r1 = new Pair[2];
            r1[0] = TuplesKt.to("module_name", CommentServiceId.HOT_SPOT);
            String r6 = r5.a;
            if (r6 != null) goto L5;
            r6 = "";
        L5:
            r1[1] = TuplesKt.to("element_id", r6);
            r0.doEventAction("show_ecom_element", MapsKt.mutableMapOf(r1), new Pair[0]);
        }

        public b(ECShopSlcProductCardGroupPresenter r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void i(StoreV2ProductItemVO r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "item");
            this.a.r0().getSkuProductIdRecords().add(r6.a);
            s0.a(new com.bytedance.android.shopping.store.home.c0());
            ECShopHybridProductViewModel r0 = this.a.r0();
            Pair<String, String>[] r1 = new Pair[4];
            r1[0] = TuplesKt.to("product_id", r6.a);
            LayoutTypes r2 = (LayoutTypes) this.a.r0().getLayoutType().getValue();
            if (r2 != null) goto L6;
        L7:
            String r3 = "double_product";
        L9:
            r1[1] = TuplesKt.to("product_form", r3);
            r1[2] = TuplesKt.to("page_name", "store_page");
            com.bytedance.android.ec.store.repository.dto.i r8 = r6.J;
            if (r8 == null) goto L16;
            List r9 = r8.b();
            if (r9 == null) goto L16;
            com.bytedance.android.ec.store.repository.dto.j r10 = (com.bytedance.android.ec.store.repository.dto.j) CollectionsKt.getOrNull(r9, r7);
            if (r10 == null) goto L16;
            String r11 = r10.b();
        L17:
            if (r11 != null) goto L19;
            r11 = "";
        L19:
            r1[3] = TuplesKt.to("sku_id", r11);
            r0.doEventAction("click_transparent_sku", r1);
            return;
        L16:
            r11 = null;
            goto L17
        L6:
            if (q.a[r2.ordinal()] != 1) goto L7;
            r3 = "single_product";
            goto L9
        }

        public final void j(com.bytedance.android.ec.store.repository.vo.l r2, Map r3, List r4, List r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            Intrinsics.checkNotNullParameter(r4, "tagCodeList");
            Intrinsics.checkNotNullParameter(r5, "highlightTagCode");
            this.a.q.addAll(r4);
            this.a.r.addAll(r5);
        }
    }

    public final ECShopHybridProductViewModel r0() {
        return (ECShopHybridProductViewModel) this.u.getValue();
    }

    static {
        B = LazyKt.lazy(ECShopSlcProductCardGroupPresenter$Companion$imageConfig$2.INSTANCE);
    }

    public final void c0() {
        super.c0();
        com.bytedance.android.shopping.store.hybridproduct.module.r r0 = this.o;
        if (r0 == null) goto L5;
        r0.drop();
    L5:
        this.o = null;
    }

    public final com.bytedance.android.shopping.store.slicecard.a e0() {
        return this.z;
    }

    public final sm.g h0() {
        return this.x;
    }

    public final sm.h i0() {
        return this.w;
    }

    public final sm.f j0() {
        return this.y;
    }

    public static final void k0(ECShopSlcProductCardGroupPresenter r5) {
        WeakReference<LottieAnimationViewWithPlayCount> r0 = r5.r0().getCartAnimationView();
        if (r0 == null) goto L19;
        LottieAnimationViewWithPlayCount r1 = r0.get();
        if (r1 == null) goto L20;
        Object r2 = ((sm.m) r5).n.a.get(Reflection.getOrCreateKotlinClass(sm.k.class));
        Boolean r3 = null;
        if ((r2 instanceof sm.k) == true) goto L9;
        r2 = null;
    L9:
        sm.k r4 = (sm.k) r2;
        if (r4 == null) goto L21;
        String r6 = r4.c7();
        if (r6 == null) goto L22;
        View r7 = r5.s;
        int r8 = ECProductCardFunctionUtils.a;
        Context r9 = r5.Y().c();
        ECStoreViewModel r10 = r5.A;
        if (r10 == null) goto L17;
        r3 = Boolean.valueOf(r10.isBrandShopUpgrade());
    L17:
        ECProductCardFunctionUtils.a(r9, r6, r7, r1, r3);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public static final String m0(ECShopSlcProductCardGroupPresenter r11) {
        String r1 = r11.r0().getStoreParam().getStoreSourcePage();
        String r2 = r11.r0().getStoreParam().getStoreSourceMethod();
        String r3 = r11.r0().getStoreParam().getStoreGroupType();
        String r4 = r11.r0().getStoreParam().getEnterFrom();
        String r5 = r11.r0().getStoreParam().getTempId();
        String r6 = r11.r0().getStoreParam().getProductBasicRequestParam().getMaterialId();
        if (((LayoutTypes) r11.r0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
        boolean r7 = true;
    L7:
        return u.a(r1, r2, r3, r4, r5, r6, r7, r11.r0().hasDiscountSelected(), r11.r0().getStoreParam().getShareContent(), r11.r0().getStoreParam().getEntranceLocation());
    L5:
        r7 = false;
        goto L7
    }

    public final String n0(StoreV2ProductItemVO r4) {
        StringBuilder r0 = new StringBuilder();
        if (this.w.c() != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
        String r1 = "a1.b6269.c2429.d00357";
    L6:
        r0.append(r1);
        r0.append("_i");
        r0.append(r4.w + 1);
        return r0.toString();
    L5:
        r1 = "a1.b6269.c2429.d3147";
        goto L6
    }

    public final String p0(StoreV2ProductItemVO r10) {
        com.bytedance.android.ec.store.repository.dto.i r11 = r10.J;
        if (r11 == null) goto L7;
        List r12 = r11.b();
        if (r12 == null) goto L7;
        return CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, ECShopSlcProductCardGroupPresenter$getSKUIds$1.INSTANCE, 30, null);
    L7:
        return null;
    }

    public final String q0(StoreV2ProductItemVO r8) {
        MarketingDataDTO r9 = r8.D;
        Boolean r0 = null;
        if (r9 == null) goto L5;
        String r10 = r9.getTransMeta();
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r10) == false) goto L10;
        return "return_coin";
    L10:
        List<com.bytedance.android.ec.store.repository.dto.g> r11 = r0().getPickTypes();
        if (r11 == null) goto L25;
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L21;
        Object r3 = r12.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r3).a() != 1) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
    L22:
        com.bytedance.android.ec.store.repository.dto.g r5 = (com.bytedance.android.ec.store.repository.dto.g) r3;
        if (r5 == null) goto L25;
        Boolean r13 = Boolean.valueOf(r5.b());
    L26:
        List<com.bytedance.android.ec.store.repository.dto.g> r6 = r0().getPickTypes();
        if (r6 == null) goto L41;
        Iterator<T> r7 = r6.iterator();
    L30:
        if (r7.hasNext() == false) goto L37;
        Object r14 = r7.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r14).a() != 2) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == false) goto L30;
    L38:
        com.bytedance.android.ec.store.repository.dto.g r16 = (com.bytedance.android.ec.store.repository.dto.g) r14;
        if (r16 == null) goto L41;
        r0 = Boolean.valueOf(r16.b());
        goto L41
    L34:
        r15 = false;
        goto L35
    L37:
        r14 = null;
    L41:
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r1) == false) goto L45;
        return "live_product";
    L45:
        if (Intrinsics.areEqual(r0, r1) == false) goto L47;
        return "living_product";
    L47:
        return CommentServiceId.HOT_SPOT;
    L18:
        r4 = false;
        goto L19
    L21:
        r3 = null;
    L25:
        r13 = null;
        goto L26
    L5:
        r10 = null;
        goto L7
    }

    public ECShopSlcProductCardGroupPresenter(Fragment r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.A = r3;
        this.p = new LinkedHashMap();
        this.q = new LinkedHashSet();
        this.r = new LinkedHashSet();
        this.t = LazyKt.lazy(ECShopSlcProductCardGroupPresenter$shopImagePreloadConfig$2.INSTANCE);
        this.u = LazyKt.lazy(new ECShopSlcProductCardGroupPresenter$viewModel$2(this));
        this.v = new LinkedHashMap();
        this.w = new ECShopSlcProductCardGroupPresenter$adapter$1(this);
        this.x = new b(this, r2);
        this.y = new StoreEventReporter(this);
        this.z = new ECShopSlcProductCardGroupPresenter$actionHandler$1(this, r2);
    }

    public static final void l0(ECShopSlcProductCardGroupPresenter r6, StoreV2ProductItemVO r7) {
        String r0 = s.a(r6.r0(), s.b(r6.r0()));
        r6.r0().doEventAction("click_add_to_cart", com.bytedance.android.ec.store.product.presenter.utils.a.d(r7), new Pair[]{TuplesKt.to("entrance_info", r0), TuplesKt.to("bst_group_type", "product")});
        r6.r0().doEventAction("add_to_cart_click", r6.o0("click_product", r7), new Pair[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> o0(String r39, StoreV2ProductItemVO r40) {
        String r3 = r0().getEcomEntranceFrom();
        int r4 = r39.hashCode();
        String r12 = "0";
        if (r4 == 1132134829) goto L46;
        if (r4 != 2022256952) goto L84;
        if (r39.equals("click_product") == false) goto L84;
        Map<String, String> r1 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r40);
        ECStoreParam r5 = Y().g(ECShopHybridProductViewModel.class).getStoreParam();
        Pair[] r15 = new Pair[26];
        if (Intrinsics.areEqual(r0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L12;
        String r2 = "_" + r40.v;
    L13:
        r15[0] = TuplesKt.to("tab_label", r2);
        r15[1] = TuplesKt.to("category_id", null);
        r15[2] = TuplesKt.to("tab_type", null);
        r15[3] = TuplesKt.to("page_version", null);
        r15[4] = TuplesKt.to("ecom_entrance_form", r3);
        r15[5] = TuplesKt.to("brand_verified", "0");
        r15[6] = TuplesKt.to("search_params", r0().getStoreParam().getSearchParams());
        r15[7] = TuplesKt.to("pre_product_id", r5.getPreProductId());
        r15[8] = TuplesKt.to("pre_room_id", r5.getPreRoomId());
        r15[9] = TuplesKt.to("pre_group_id", r5.getPreGroupId());
        r15[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r0 = (LayoutTypes) r0().getLayoutType().getValue();
        if (r0 != null) goto L17;
    L18:
        Object r10 = "double_product";
    L21:
        r15[11] = TuplesKt.to("product_form", r10);
        r15[12] = TuplesKt.to("sku_ids", p0(r40));
        if (com.bytedance.android.shopping.extensions.k.c(r40.e) == false) goto L24;
        String r6 = "102";
    L25:
        r15[13] = TuplesKt.to("title_type", r6);
        r15[14] = TuplesKt.to("pay_price", String.valueOf(r40.j));
        r15[15] = TuplesKt.to("tab_name", r3);
        r15[16] = TuplesKt.to("tab_name_second", q0(r40));
        if (r0().hasDiscountSelected() == false) goto L28;
        r12 = CommentScene.COMMENTSCENE_NO_AWEME;
    L28:
        r15[17] = TuplesKt.to("is_discount_selected", r12);
        if (r0().getStoreParam().isEcShare() == false) goto L31;
        Pair r7 = TuplesKt.to("share_content", r0().getStoreParam().getShareContent());
        Object r8 = "";
    L32:
        r15[18] = r7;
        if (r0().getStoreParam().isEcShare() == false) goto L35;
        Pair r9 = TuplesKt.to("share_object", r0().getStoreParam().getShareObject());
    L36:
        r15[19] = r9;
        r15[20] = TuplesKt.to("btm_index", String.valueOf(r40.v + 1));
        r15[21] = TuplesKt.to("bst_group_type", "product");
        r15[22] = TuplesKt.to("product_view_num", String.valueOf(r0().getProductViewsNum().getValue()));
        r15[23] = TuplesKt.to("product_total_num", String.valueOf(r0().getTotalProductNum().getValue()));
        r15[24] = TuplesKt.to("product_click_index", String.valueOf(r40.w));
        r15[25] = TuplesKt.to("bst_tag", "bst_tag");
        r1.putAll(MapsKt.mapOf(r15));
        Iterator r11 = BtmSDK.INSTANCE.createReportParams(n0(r40), PageFinder.via(((QFragmentPresenter) this).e)).entrySet().iterator();
    L38:
        if (r11.hasNext() == false) goto L91;
        Map.Entry r13 = (Map.Entry) r11.next();
        Object r14 = r13.getKey();
        Object r16 = r13.getValue();
        if (r16 == null) goto L42;
        String r17 = r16.toString();
    L43:
        r1.put(r14, r17);
        goto L38
    L42:
        r17 = null;
        goto L43
    L91:
        return r1;
    L35:
        r9 = TuplesKt.to(r8, r8);
        goto L36
    L31:
        r8 = "";
        r7 = TuplesKt.to(r8, r8);
        goto L32
    L24:
        r6 = CommentServiceId.HOT_SPOT;
        goto L25
    L17:
        if (q.c[r0.ordinal()] != 1) goto L18;
        r10 = "single_product";
        goto L21
    L12:
        r2 = "";
    L84:
        return null;
    L46:
        if (r39.equals("show_product") == false) goto L84;
        Map<String, String> r18 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r40);
        Pair[] r19 = new Pair[23];
        if (Intrinsics.areEqual(r0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L50;
        String r20 = "_" + r40.v;
    L51:
        r19[0] = TuplesKt.to("tab_label", r20);
        r19[1] = TuplesKt.to("category_id", null);
        r19[2] = TuplesKt.to("tab_type", null);
        r19[3] = TuplesKt.to("page_version", null);
        r19[4] = TuplesKt.to("ecom_entrance_form", r3);
        r19[5] = TuplesKt.to("pre_product_id", r0().getStoreParam().getPreProductId());
        r19[6] = TuplesKt.to("pre_room_id", r0().getStoreParam().getPreRoomId());
        r19[7] = TuplesKt.to("pre_group_id", r0().getStoreParam().getPreGroupId());
        r19[8] = TuplesKt.to("brand_verified", "0");
        r19[9] = TuplesKt.to("search_params", r0().getStoreParam().getSearchParams());
        r19[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r21 = (LayoutTypes) r0().getLayoutType().getValue();
        if (r21 != null) goto L54;
        int r22 = 1;
    L56:
        Object r110 = "double_product";
    L59:
        r19[11] = TuplesKt.to("product_form", r110);
        r19[12] = TuplesKt.to("sku_ids", p0(r40));
        r19[13] = TuplesKt.to("btm_index", String.valueOf(r40.v + r22));
        if (com.bytedance.android.shopping.extensions.k.c(r40.e) == false) goto L62;
        String r23 = "102";
    L63:
        r19[14] = TuplesKt.to("title_type", r23);
        r19[15] = TuplesKt.to("pay_price", String.valueOf(r40.j));
        r19[16] = TuplesKt.to("tab_name", r3);
        r19[17] = TuplesKt.to("tab_name_second", q0(r40));
        if (r0().hasDiscountSelected() == false) goto L66;
        r12 = CommentScene.COMMENTSCENE_NO_AWEME;
    L66:
        r19[18] = TuplesKt.to("is_discount_selected", r12);
        if (r0().getStoreParam().isEcShare() == false) goto L69;
        Pair r24 = TuplesKt.to("share_content", r0().getStoreParam().getShareContent());
        Object r25 = "";
    L70:
        r19[19] = r24;
        if (r0().getStoreParam().isEcShare() == false) goto L73;
        Pair r26 = TuplesKt.to("share_object", r0().getStoreParam().getShareObject());
    L74:
        r19[20] = r26;
        r19[21] = TuplesKt.to("bst_group_type", "product");
        r19[22] = TuplesKt.to("bst_tag", "bst_tag");
        r18.putAll(MapsKt.mapOf(r19));
        Iterator r27 = BtmSDK.INSTANCE.createReportParams(n0(r40), PageFinder.via(((QFragmentPresenter) this).e)).entrySet().iterator();
    L76:
        if (r27.hasNext() == false) goto L92;
        Map.Entry r28 = (Map.Entry) r27.next();
        Object r29 = r28.getKey();
        Object r30 = r28.getValue();
        if (r30 == null) goto L80;
        String r31 = r30.toString();
    L81:
        r18.put(r29, r31);
        goto L76
    L80:
        r31 = null;
        goto L81
    L92:
        return r18;
    L73:
        r26 = TuplesKt.to(r25, r25);
        goto L74
    L69:
        r25 = "";
        r24 = TuplesKt.to(r25, r25);
        goto L70
    L62:
        r23 = CommentServiceId.HOT_SPOT;
        goto L63
    L54:
        r22 = 1;
        if (q.d[r21.ordinal()] != 1) goto L56;
        r110 = "single_product";
        goto L59
    L50:
        r20 = "";
        goto L51
    }
}
