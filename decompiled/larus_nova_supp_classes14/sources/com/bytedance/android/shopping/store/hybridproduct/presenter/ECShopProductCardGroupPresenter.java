package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.baseinf.EventTags;
import com.bytedance.android.ec.store.repository.dto.MarketingDataDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ShopMarketingScene;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopProductCardGroupPresenter extends sm.m {
    public static final Lazy w = null;
    public com.bytedance.android.shopping.store.hybridproduct.module.r o;
    public final Lazy p;
    public final Lazy q;
    public final Map<String, Object> r;
    public final ECShopProductCardGroupPresenter$adapter$1 s;
    public final c t;
    public final b u;
    public final ECStoreViewModel v;

    public static final class a {
    }

    public final class b implements sm.f {
        public final Set<EventTags> a;
        public final Set<EventTags> b;
        public final /* synthetic */ ECShopProductCardGroupPresenter c;

        public final Set<EventTags> a() {
            return this.b;
        }

        public b(ECShopProductCardGroupPresenter r3) {
            this.c = r3;
            Set<EventTags> r4 = SetsKt.mutableSetOf(new EventTags[]{EventTags.SECKILL_INFO, EventTags.RECOMMEND_INFO});
            this.a = r4;
            this.b = r4;
        }

        public final void b(StoreV2ProductItemVO r3, List<ECRitTag> r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "ritTagList");
            Intrinsics.checkNotNullParameter(r5, "eventParams");
            if (this.c.o0().getStoreParam().isPreview() == false) goto L6;
            return;
        L6:
            if (this.c.o0().getIdRecords().contains(r3.a) == false) goto L8;
            return;
        L8:
            ECShopProductCardGroupPresenter r6 = this.c;
            r6.getClass();
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r6.o0().getStoreParam().getLifecycleMonitorId()));
            if (r7 == null) goto L11;
            Intrinsics.checkNotNullParameter(r3, "$this$toProductShowVO");
            com.bytedance.android.shopping.store.lifecycle.f r1 = new com.bytedance.android.shopping.store.lifecycle.f();
            r1.a = r3.o;
            r1.b = r3.v;
            r7.L(r1);
        L11:
            Map<String, String> r8 = this.c.l0("show_product", r3);
            if (r8 == null) goto L15;
            Map<String, ? extends Object> r9 = MapsKt.plus(r8, r5);
            if (r9 == null) goto L15;
        L16:
            this.c.r.putAll(r5);
            int r10 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.e(this.c.a0(), this.c.k0(r3), r3, r9, this.c.o0());
            this.c.o0().getIdRecords().add(r3.a);
            return;
        L15:
            r9 = r5;
            goto L16
        }
    }

    public static final class c implements sm.g {
        public final /* synthetic */ ECShopProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final void b(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void e(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void c(StoreV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            this.a.o0().doEventAction("add_to_cart_show", this.a.l0("show_product", r4), new Pair[0]);
        }

        public final void d(StoreV2ProductItemVO r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            String r0 = s.a(this.a.o0(), s.b(this.a.o0()));
            this.a.o0().doEventAction("click_add_to_cart", com.bytedance.android.ec.store.product.presenter.utils.a.d(r7), new Pair[]{TuplesKt.to("entrance_info", r0), TuplesKt.to("bst_group_type", "product")});
            this.a.o0().doEventAction("add_to_cart_click", this.a.l0("click_product", r7), new Pair[0]);
        }

        public final void f(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            this.a.o0().doEventAction("add_cart_toast_show", com.bytedance.android.ec.store.product.presenter.utils.a.d(r5), new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("ecom_group_type", "product_card"), TuplesKt.to("bst_group_type", "product")});
            ECStoreViewModel r6 = this.a.v;
            if (r6 == null) goto L6;
            ECStoreViewModel.tryUpdateFloatView$default(r6, ShopMarketingScene.CART_UPDATE, null, 2, null);
            return;
        }

        public final void g(StoreV2ProductItemVO r38) {
            Intrinsics.checkNotNullParameter(r38, "item");
            ECShopProductCardGroupPresenter r2 = this.a;
            ECShopHybridProductViewModel r3 = r2.o0();
            com.bytedance.android.ec.store.setting.f r4 = ECStoreSettings.a();
            if (r4 == null) goto L5;
            boolean r5 = r4.a();
        L6:
            r2.o = com.bytedance.android.shopping.store.hybridproduct.module.s.a(r3, r38, r5);
            BtmSDK r6 = BtmSDK.INSTANCE;
            String r7 = this.a.k0(r38);
            PageFinder r8 = PageFinder.via(this.b);
            BcmParams r9 = new BcmParams();
            r9.put("bst_group_type", "product");
            Unit r10 = Unit.INSTANCE;
            String r11 = r6.createJumpSourceBtmToken(r7, r8, r9.merge((Map) r38.P.getValue()));
            ECStoreParam r12 = this.a.o0().getStoreParam();
            ECStoreViewModel r13 = this.a.v;
            if (r13 == null) goto L11;
            im.b r14 = r13.getLiveManager();
            if (r14 == null) goto L11;
            r14.j();
        L11:
            ECStoreViewModel r15 = this.a.v;
            if (r15 == null) goto L14;
            r15.setEnterOtherPageCollaspeHeader(true);
        L14:
            int r16 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r17 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r12.getSearchParams(), r38);
            String r18 = this.a.o0().getEcomEntranceFrom();
            if ((!StringsKt.isBlank(r18)) == true) goto L19;
            r18 = null;
        L19:
            if (r18 == null) goto L21;
        L27:
            String r19 = r18;
            List r20 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r38.a);
            List<com.bytedance.android.ec.store.repository.dto.g> r21 = this.a.o0().getPickTypes();
            if (r21 == null) goto L40;
            com.bytedance.android.ec.store.repository.dto.g r22 = (com.bytedance.android.ec.store.repository.dto.g) CollectionsKt.firstOrNull(r21);
            if (r22 == null) goto L40;
            if (r22.a() == 0) goto L34;
            boolean r23 = true;
        L35:
            if (r23 == true) goto L38;
            r22 = null;
        L38:
            if (r22 == null) goto L40;
            Boolean r24 = Boolean.valueOf(r22.b());
        L41:
            com.bytedance.commerce.base.json.a[] r25 = new com.bytedance.commerce.base.json.a[26];
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getShareContent(), "shop") == false) goto L44;
            String r110 = "share_alert";
        L45:
            r25[0] = JsonDslUtilKt.d("product_source_page", r110);
            r25[1] = JsonDslUtilKt.d("source_method", r19);
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L48;
            String r26 = "_" + r38.v;
        L49:
            r25[2] = JsonDslUtilKt.d("tab_label", r26);
            r25[3] = JsonDslUtilKt.d("category_id", "");
            r25[4] = JsonDslUtilKt.d("tab_type", "");
            r25[5] = JsonDslUtilKt.d("page_version", "");
            r25[6] = JsonDslUtilKt.d("page_name", r12.getPageName());
            r25[7] = JsonDslUtilKt.d("price_type", String.valueOf(r38.h));
            Integer r27 = r12.getFollowStatus();
            if (r27 == null) goto L52;
            String r28 = String.valueOf(r27.intValue());
        L53:
            if (r28 != null) goto L55;
            r28 = "";
        L55:
            r25[8] = JsonDslUtilKt.d("follow_status", r28);
            String r29 = r12.getTempId();
            if (r29 != null) goto L58;
            r29 = "";
        L58:
            r25[9] = JsonDslUtilKt.d("temp_id", r29);
            r25[10] = JsonDslUtilKt.d("store_type", "shop");
            String r30 = r12.getStoreSourcePage();
            if (r30 != null) goto L61;
            r30 = "";
        L61:
            r25[11] = JsonDslUtilKt.d("store_source_page", r30);
            String r31 = r12.getStoreSourceMethod();
            if (r31 != null) goto L64;
            r31 = "";
        L64:
            r25[12] = JsonDslUtilKt.d("store_source_method", r31);
            String r32 = r12.getStoreGroupType();
            if (r32 != null) goto L67;
            r32 = "";
        L67:
            r25[13] = JsonDslUtilKt.d("store_group_type", r32);
            String r33 = r12.getLiveAnchorId();
            if (r33 != null) goto L70;
            r33 = "";
        L70:
            r25[14] = JsonDslUtilKt.d("live_anchor_id", r33);
            r25[15] = JsonDslUtilKt.d("pre_product_id", r12.getPreProductId());
            r25[16] = JsonDslUtilKt.d("pre_room_id", r12.getPreRoomId());
            r25[17] = JsonDslUtilKt.d("pre_group_id", r12.getPreGroupId());
            r25[18] = JsonDslUtilKt.d("product_ratio", r38.b());
            LayoutTypes r34 = (LayoutTypes) this.a.o0().getLayoutType().getValue();
            if (r34 != null) goto L74;
        L75:
            String r35 = "double_product";
        L77:
            r25[19] = JsonDslUtilKt.d("product_form", r35);
            MarketingDataDTO r36 = r38.D;
            if (r36 == null) goto L80;
            String r37 = r36.getTransMeta();
        L82:
            if (com.bytedance.android.shopping.extensions.k.c(r37) == false) goto L85;
            String r39 = "return_coin";
        L88:
            r25[20] = JsonDslUtilKt.d("source_method_second", r39);
            if (this.a.o0().hasDiscountSelected() == false) goto L91;
            String r40 = CommentScene.COMMENTSCENE_NO_AWEME;
        L92:
            r25[21] = JsonDslUtilKt.d("is_discount_selected", r40);
            r25[22] = JsonDslUtilKt.d("dynamic_product_status", r38.H.getStatus());
            r25[23] = JsonDslUtilKt.c("dismiss_live_strand", 1);
            com.bytedance.android.ec.store.repository.dto.n r41 = r38.G;
            if (r41 == null) goto L95;
            String r42 = r41.d();
        L96:
            if (r42 != null) goto L98;
            r42 = "";
        L98:
            r25[24] = JsonDslUtilKt.d("shop_video_id", r42);
            com.bytedance.android.ec.store.repository.dto.n r43 = r38.G;
            if (r43 == null) goto L101;
            Integer r44 = r43.f();
        L102:
            r25[25] = JsonDslUtilKt.d("shop_video_source", String.valueOf(r44));
            JSONObject r45 = JsonDslUtilKt.a(r25);
            ECHybridExtensionsKt.d(r45, com.bytedance.android.shopping.store.utils.y.a(r38));
            if (r12.getProductBasicRequestParam().isCustom() == false) goto L106;
            r45.accumulate("customer_id", r12.getProductBasicRequestParam().getMaterialId());
        L106:
            if (r12.isEcShare() == false) goto L108;
            r45.accumulate("share_content", r12.getShareContent());
            r45.accumulate("share_object", r12.getShareObject());
        L108:
            r45.accumulate("icon_type", this.a.o0().getStoreParam().getPassThroughParam("icon_type"));
            Map r46 = r38.o;
            if (r46 == null) goto L114;
            Iterator r47 = r46.entrySet().iterator();
        L112:
            if (r47.hasNext() == false) goto L114;
            Map.Entry r111 = (Map.Entry) r47.next();
            r45.put((String) r111.getKey(), r111.getValue());
        L114:
            JSONObject r48 = com.bytedance.android.shopping.extensions.k.w((String) this.a.o0().getStoreParam().getPassThroughParam("pass_through_api"));
            if (r48 == null) goto L118;
            r45.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r48.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
            Unit r49 = Unit.INSTANCE;
        L118:
            if (com.bytedance.android.shopping.extensions.k.c(r38.C) == false) goto L134;
            int r50 = com.bytedance.android.ec.store.utils.b.a;
            String r210 = com.bytedance.android.ec.store.utils.b.a(r38.C, r11);
            if (r210 != null) goto L122;
            return;
        L122:
            hm.b r112 = hm.b.c;
            Context r113 = this.a.Y().c();
            String r211 = String.valueOf(r12.getFollowStatus());
            ECStoreViewModel r51 = this.a.v;
            if (r51 == null) goto L127;
            Map<String, Object> r52 = r51.getAdParams();
            if (r52 == null) goto L127;
            r52.put("product_id", r38.a);
            Unit r53 = Unit.INSTANCE;
            Map<String, Object> r212 = r52;
        L128:
            boolean r54 = r38.N;
            int r55 = ECSdk.a;
            IAdapterService r56 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r56 == null) goto L133;
            wu1.a r57 = r56.getECLiveStateController();
            if (r57 == null) goto L133;
            r57.e();
        L133:
            com.bytedance.android.ec.store.common.starter.e.b(r112, r113, r210, r211, r45, r212, null, r54, 128);
            JSONObject r58 = null;
        L217:
            ECShopProductCardGroupPresenter r59 = this.a;
            r59.getClass();
            Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r60 = com.bytedance.android.shopping.store.lifecycle.a.a;
            com.bytedance.android.shopping.store.lifecycle.m r61 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r59.o0().getStoreParam().getLifecycleMonitorId()));
            if (r61 == null) goto L220;
            com.bytedance.android.shopping.store.lifecycle.c.a.a(r61, "click_product", r59.l0("click_product", r38), r58, 4);
        L220:
            Map<String, String> r62 = this.a.l0("click_product", r38);
            if (r62 == null) goto L224;
            Map<String, Object> r63 = MapsKt.plus(r62, this.a.r);
            if (r63 == null) goto L224;
        L225:
            int r64 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.c(this.a.a0(), this.a.k0(r38), r38, r63, this.a.o0());
            com.bytedance.android.ec.sdk.helper.c r65 = com.bytedance.android.ec.sdk.helper.c.a;
            r65.b("SHOP", "[click product]productId:" + r38.a);
            r65.b("SHOP", "[click product]secShopId:" + r12.getSecShopId());
            return;
        L224:
            r63 = this.a.r;
        L127:
            r212 = null;
            goto L128
        L134:
            com.bytedance.android.ec.store.repository.dto.n r66 = r38.G;
            if (r66 == null) goto L137;
            Integer r67 = r66.f();
        L138:
            com.bytedance.android.ec.store.repository.dto.n r114 = r38.G;
            if (r114 == null) goto L141;
            String r115 = r114.d();
        L142:
            if (r67 != null) goto L145;
        L146:
            if (r67 != null) goto L149;
        L158:
            String r310 = null;
        L159:
            hm.b r68 = hm.b.c;
            Context r69 = this.a.Y().c();
            String r116 = r38.b;
            if (r116 != null) goto L162;
        L169:
            r116 = r38.a;
        L171:
            if (r67 != null) goto L174;
        L179:
            String r70 = r38.l;
        L180:
            String r117 = this.a.s.a();
            if (r117 != null) goto L183;
            r117 = "";
            String r118 = r117;
        L184:
            String r119 = this.a.s.d();
            if (r119 != null) goto L187;
            String r213 = r118;
        L188:
            String r120 = r38.a;
            Integer r214 = r12.getFollowStatus();
            String r215 = r12.getWhichAccount();
            String r121 = r38.b;
            if (r121 != null) goto L191;
            r121 = r118;
        L191:
            r45.put("promotion_id", r121);
            r45.put("carrier_source", "store_page");
            MarketingDataDTO r122 = r38.D;
            if (r122 == null) goto L194;
            String r123 = r122.getTransMeta();
        L195:
            if (r123 != null) goto L197;
            r123 = r118;
        L197:
            r45.put("trans_meta", r123);
            Unit r124 = Unit.INSTANCE;
            String r216 = r45.toString();
            if (r17 == null) goto L200;
            String r125 = r17.toString();
            int r71 = 1;
        L201:
            com.bytedance.commerce.base.json.a[] r72 = new com.bytedance.commerce.base.json.a[r71];
            JSONObject r73 = com.bytedance.android.shopping.extensions.k.w((String) this.a.o0().getStoreParam().getPassThroughParam("pass_through_api"));
            if (r73 == null) goto L204;
            String r74 = r73.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L205:
            if (r74 != null) goto L207;
            String r126 = r118;
        L208:
            r72[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r126);
            JSONObject r75 = JsonDslUtilKt.a(r72);
            String r217 = (String) CollectionsKt.getOrNull(r38.f, 0);
            Long r76 = r38.c;
            if (r76 == null) goto L211;
            long r77 = r76.longValue();
        L212:
            long r311 = r77;
            ECStoreViewModel r78 = this.a.v;
            if (r78 == null) goto L215;
            Map<String, Object> r312 = r78.getAdParams();
        L216:
            r58 = null;
            com.bytedance.android.ec.store.common.starter.e.a(r68, r69, r116, "store_page", r70, r117, r213, r120, r214, r19, r215, r216, r125, r75, r217, true, null, r311, null, r312, null, r38.F, r11, r310, 32178176);
            goto L217
        L215:
            r312 = null;
            goto L216
        L211:
            r77 = SourceType.UNKNOWN.getType();
            goto L212
        L207:
            r126 = r74;
            goto L208
        L204:
            r74 = null;
            goto L205
        L200:
            r71 = 1;
            r125 = null;
            goto L201
        L194:
            r123 = null;
            goto L195
        L187:
            r213 = r119;
            goto L188
        L183:
            r118 = "";
            goto L184
        L174:
            if (r67.intValue() != 3) goto L179;
            com.bytedance.android.ec.store.repository.dto.n r79 = r38.G;
            if (r79 == null) goto L178;
            r70 = r79.d();
            goto L180
        L178:
            r70 = null;
            goto L180
        L162:
            if (r116.length() <= 0) goto L164;
            boolean r127 = true;
        L165:
            if (r127 == true) goto L168;
            r116 = null;
        L168:
            if (r116 != null) goto L171;
        L164:
            r127 = false;
            goto L165
        L149:
            if (r67.intValue() != 1) goto L158;
        L150:
            if (r115 != null) goto L152;
        L155:
            boolean r80 = true;
        L156:
            if (r80 == true) goto L158;
            JSONObject r81 = new JSONObject();
            r81.put("config_type", CommentScene.COMMENTSCENE_NO_AWEME);
            r81.put("content_type", String.valueOf(3 - r67.intValue()));
            r81.put("item_id", r115);
            r81.put("start_time", "0");
            r81.put("auto_play", true);
            r310 = r81.toString();
            goto L159
        L152:
            if (StringsKt.isBlank(r115) == true) goto L155;
            r80 = false;
            goto L156
        L145:
            if (r67.intValue() == 2) goto L150;
        L141:
            r115 = null;
            goto L142
        L137:
            r67 = null;
            goto L138
        L101:
            r44 = null;
            goto L102
        L95:
            r42 = null;
            goto L96
        L91:
            r40 = "0";
            goto L92
        L85:
            if (Intrinsics.areEqual(r24, Boolean.TRUE) == false) goto L87;
            r39 = "live_product";
            goto L88
        L87:
            r39 = CommentServiceId.HOT_SPOT;
            goto L88
        L80:
            r37 = null;
            goto L82
        L74:
            if (p.b[r34.ordinal()] != 1) goto L75;
            r35 = "single_product";
            goto L77
        L52:
            r28 = null;
            goto L53
        L48:
            r26 = "";
            goto L49
        L44:
            r110 = r12.getEntranceLocation();
            goto L45
        L34:
            r23 = false;
        L40:
            r24 = null;
            goto L41
        L21:
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L24;
            r18 = "classification";
            goto L27
        L24:
            if (r12.getProductBasicRequestParam().isCustom() == false) goto L26;
            r18 = "featured";
            goto L27
        L26:
            r18 = "products";
            goto L27
        L5:
            r5 = false;
            goto L6
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public c(ECShopProductCardGroupPresenter r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void i(StoreV2ProductItemVO r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "item");
            this.a.o0().getSkuProductIdRecords().add(r6.a);
            s0.a(new com.bytedance.android.shopping.store.home.c0());
            ECShopHybridProductViewModel r0 = this.a.o0();
            Pair<String, String>[] r1 = new Pair[4];
            r1[0] = TuplesKt.to("product_id", r6.a);
            LayoutTypes r2 = (LayoutTypes) this.a.o0().getLayoutType().getValue();
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
            if (p.a[r2.ordinal()] != 1) goto L7;
            r3 = "single_product";
            goto L9
        }

        public final void j(com.bytedance.android.ec.store.repository.vo.l r2, Map r3, List r4, List r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            Intrinsics.checkNotNullParameter(r4, "tagCodeList");
            Intrinsics.checkNotNullParameter(r5, "highlightTagCode");
            sm.g.a.a(r2, r3, r4, r5);
        }
    }

    public final ECShopHybridProductViewModel o0() {
        return (ECShopHybridProductViewModel) this.q.getValue();
    }

    static {
        w = LazyKt.lazy(ECShopProductCardGroupPresenter$Companion$imageConfig$2.INSTANCE);
    }

    public final void c0() {
        super.c0();
        com.bytedance.android.shopping.store.hybridproduct.module.r r0 = this.o;
        if (r0 == null) goto L5;
        r0.drop();
    L5:
        this.o = null;
    }

    public final sm.g h0() {
        return this.t;
    }

    public final sm.h i0() {
        return this.s;
    }

    public final sm.f j0() {
        return this.u;
    }

    public final String k0(StoreV2ProductItemVO r4) {
        StringBuilder r0 = new StringBuilder();
        if (this.s.c() != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
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

    public final String m0(StoreV2ProductItemVO r10) {
        com.bytedance.android.ec.store.repository.dto.i r11 = r10.J;
        if (r11 == null) goto L7;
        List r12 = r11.b();
        if (r12 == null) goto L7;
        return CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, ECShopProductCardGroupPresenter$getSKUIds$1.INSTANCE, 30, null);
    L7:
        return null;
    }

    public final String n0(StoreV2ProductItemVO r8) {
        MarketingDataDTO r9 = r8.D;
        Boolean r0 = null;
        if (r9 == null) goto L5;
        String r10 = r9.getTransMeta();
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r10) == false) goto L10;
        return "return_coin";
    L10:
        List<com.bytedance.android.ec.store.repository.dto.g> r11 = o0().getPickTypes();
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
        List<com.bytedance.android.ec.store.repository.dto.g> r6 = o0().getPickTypes();
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

    public ECShopProductCardGroupPresenter(Fragment r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.v = r3;
        this.p = LazyKt.lazy(ECShopProductCardGroupPresenter$shopImagePreloadConfig$2.INSTANCE);
        this.q = LazyKt.lazy(new ECShopProductCardGroupPresenter$viewModel$2(this));
        this.r = new LinkedHashMap();
        this.s = new ECShopProductCardGroupPresenter$adapter$1(this);
        this.t = new c(this, r2);
        this.u = new b(this);
    }

    public final Map<String, String> l0(String r38, StoreV2ProductItemVO r39) {
        String r3 = o0().getEcomEntranceFrom();
        int r4 = r38.hashCode();
        String r11 = "0";
        if (r4 == 1132134829) goto L38;
        if (r4 != 2022256952) goto L69;
        if (r38.equals("click_product") == false) goto L69;
        Map<String, String> r1 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r39);
        ECStoreParam r5 = Y().g(ECShopHybridProductViewModel.class).getStoreParam();
        Pair[] r14 = new Pair[27];
        if (Intrinsics.areEqual(o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L12;
        String r2 = "_" + r39.v;
    L13:
        r14[0] = TuplesKt.to("tab_label", r2);
        r14[1] = TuplesKt.to("category_id", null);
        r14[2] = TuplesKt.to("tab_type", null);
        r14[3] = TuplesKt.to("page_version", null);
        r14[4] = TuplesKt.to("ecom_entrance_form", r3);
        r14[5] = TuplesKt.to("brand_verified", "0");
        r14[6] = TuplesKt.to("search_params", o0().getStoreParam().getSearchParams());
        r14[7] = TuplesKt.to("pre_product_id", r5.getPreProductId());
        r14[8] = TuplesKt.to("pre_room_id", r5.getPreRoomId());
        r14[9] = TuplesKt.to("pre_group_id", r5.getPreGroupId());
        r14[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r0 = (LayoutTypes) o0().getLayoutType().getValue();
        if (r0 != null) goto L17;
    L18:
        Object r9 = "double_product";
    L21:
        r14[11] = TuplesKt.to("product_form", r9);
        r14[12] = TuplesKt.to("sku_ids", m0(r39));
        if (com.bytedance.android.shopping.extensions.k.c(r39.e) == false) goto L24;
        String r6 = "102";
    L25:
        r14[13] = TuplesKt.to("title_type", r6);
        r14[14] = TuplesKt.to("pay_price", String.valueOf(r39.j));
        r14[15] = TuplesKt.to("tab_name", r3);
        r14[16] = TuplesKt.to("tab_name_second", n0(r39));
        if (o0().hasDiscountSelected() == false) goto L28;
        r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L28:
        r14[17] = TuplesKt.to("is_discount_selected", r11);
        if (o0().getStoreParam().isEcShare() == false) goto L31;
        Pair r7 = TuplesKt.to("share_content", o0().getStoreParam().getShareContent());
        Object r8 = "";
    L32:
        r14[18] = r7;
        if (o0().getStoreParam().isEcShare() == false) goto L35;
        Pair r10 = TuplesKt.to("share_object", o0().getStoreParam().getShareObject());
    L36:
        r14[19] = r10;
        r14[20] = TuplesKt.to("btm_id", new BtmItemBuilder(k0(r39), null, 2, null).withPageFinder(PageFinder.via(((QFragmentPresenter) this).e)).obtainEventBtmParams());
        r14[21] = TuplesKt.to("btm_index", String.valueOf(r39.v + 1));
        r14[22] = TuplesKt.to("bst_group_type", "product");
        r14[23] = TuplesKt.to("product_view_num", String.valueOf(o0().getProductViewsNum().getValue()));
        r14[24] = TuplesKt.to("product_total_num", String.valueOf(o0().getTotalProductNum().getValue()));
        r14[25] = TuplesKt.to("product_click_index", String.valueOf(r39.w));
        r14[26] = TuplesKt.to("bst_tag", "bst_tag");
        Map<String, String> r12 = r1;
        r12.putAll(MapsKt.mapOf(r14));
    L70:
        return r12;
    L35:
        r10 = TuplesKt.to(r8, r8);
        goto L36
    L31:
        r8 = "";
        r7 = TuplesKt.to(r8, r8);
        goto L32
    L24:
        r6 = CommentServiceId.HOT_SPOT;
        goto L25
    L17:
        if (p.c[r0.ordinal()] != 1) goto L18;
        r9 = "single_product";
        goto L21
    L12:
        r2 = "";
    L69:
        return null;
    L38:
        if (r38.equals("show_product") == false) goto L69;
        Map<String, String> r13 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r39);
        Pair[] r15 = new Pair[24];
        if (Intrinsics.areEqual(o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L42;
        String r16 = "_" + r39.v;
    L43:
        r15[0] = TuplesKt.to("tab_label", r16);
        r15[1] = TuplesKt.to("category_id", null);
        r15[2] = TuplesKt.to("tab_type", null);
        r15[3] = TuplesKt.to("page_version", null);
        r15[4] = TuplesKt.to("ecom_entrance_form", r3);
        r15[5] = TuplesKt.to("pre_product_id", o0().getStoreParam().getPreProductId());
        r15[6] = TuplesKt.to("pre_room_id", o0().getStoreParam().getPreRoomId());
        r15[7] = TuplesKt.to("pre_group_id", o0().getStoreParam().getPreGroupId());
        r15[8] = TuplesKt.to("brand_verified", "0");
        r15[9] = TuplesKt.to("search_params", o0().getStoreParam().getSearchParams());
        r15[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r17 = (LayoutTypes) o0().getLayoutType().getValue();
        if (r17 != null) goto L47;
    L48:
        Object r18 = "double_product";
    L51:
        r15[11] = TuplesKt.to("product_form", r18);
        r15[12] = TuplesKt.to("sku_ids", m0(r39));
        r15[13] = TuplesKt.to("btm_id", new BtmItemBuilder(k0(r39), null, 2, null).withPageFinder(PageFinder.via(((QFragmentPresenter) this).e)).obtainEventBtmParams());
        r15[14] = TuplesKt.to("btm_index", String.valueOf(r39.v + 1));
        if (com.bytedance.android.shopping.extensions.k.c(r39.e) == false) goto L54;
        String r19 = "102";
    L55:
        r15[15] = TuplesKt.to("title_type", r19);
        r15[16] = TuplesKt.to("pay_price", String.valueOf(r39.j));
        r15[17] = TuplesKt.to("tab_name", r3);
        r15[18] = TuplesKt.to("tab_name_second", n0(r39));
        if (o0().hasDiscountSelected() == false) goto L58;
        r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L58:
        r15[19] = TuplesKt.to("is_discount_selected", r11);
        if (o0().getStoreParam().isEcShare() == false) goto L61;
        Pair r20 = TuplesKt.to("share_content", o0().getStoreParam().getShareContent());
        Object r21 = "";
    L62:
        r15[20] = r20;
        if (o0().getStoreParam().isEcShare() == false) goto L65;
        Pair r22 = TuplesKt.to("share_object", o0().getStoreParam().getShareObject());
    L66:
        r15[21] = r22;
        r15[22] = TuplesKt.to("bst_group_type", "product");
        r15[23] = TuplesKt.to("bst_tag", "bst_tag");
        r12 = r13;
        r12.putAll(MapsKt.mapOf(r15));
        goto L70
    L65:
        r22 = TuplesKt.to(r21, r21);
        goto L66
    L61:
        r21 = "";
        r20 = TuplesKt.to(r21, r21);
        goto L62
    L54:
        r19 = CommentServiceId.HOT_SPOT;
        goto L55
    L47:
        if (p.d[r17.ordinal()] != 1) goto L48;
        r18 = "single_product";
        goto L51
    L42:
        r16 = "";
        goto L43
    }
}
