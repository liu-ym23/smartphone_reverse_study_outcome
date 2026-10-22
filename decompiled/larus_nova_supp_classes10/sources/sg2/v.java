package sg2;

import android.text.TextUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.f2;
import com.bytedance.android.livesdk.livecommerce.event.k0;
import com.bytedance.android.livesdk.livecommerce.largemode.ECLiveLargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v {
    public boolean a;
    public final k0 b;
    public final k0 c;
    public final String d;
    public final com.bytedance.android.ec.common.api.jump.model.a e;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Runnable a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.a.run();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ v a;
        public final /* synthetic */ String b;

        public b(v r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.h();
            com.bytedance.android.ec.common.api.jump.model.f r0 = this.a.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
            String r1 = a2.d(this.b);
            String r2 = null;
            if (r1 != null) goto L7;
            if (r0 == null) goto L6;
            r1 = r0.a;
            goto L7
        L6:
            r1 = null;
        L7:
            if (r1 == null) goto L12;
            if (r0 == null) goto L10;
            r2 = r0.b;
        L10:
            if (r2 == null) goto L12;
            v r3 = this.a;
            com.bytedance.android.livesdk.livecommerce.room.f.e(r3.d, r3.f(), r1, PageFinder.via(r0.b));
            return;
        L12:
            v r4 = this.a;
            com.bytedance.android.livesdk.livecommerce.room.f.d(r4.d, r4.f());
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

    public static final class c implements Runnable {
        public final /* synthetic */ v a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(v r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            this.a.h();
            com.bytedance.android.ec.common.api.jump.model.f r0 = this.a.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
            String r1 = a2.d(this.b);
            String r2 = null;
            if (r1 != null) goto L7;
            if (r0 == null) goto L6;
            r1 = r0.a;
            goto L7
        L6:
            r1 = null;
        L7:
            String r3 = a2.d(this.c);
            if (r3 != null) goto L11;
            if (r0 == null) goto L12;
            r2 = r0.b;
        L12:
            if (r1 == null) goto L15;
            if (r2 == null) goto L15;
            v r4 = this.a;
            com.bytedance.android.livesdk.livecommerce.room.f.e(r4.d, r4.f(), r1, PageFinder.via(r2));
            return;
        L15:
            v r5 = this.a;
            com.bytedance.android.livesdk.livecommerce.room.f.d(r5.d, r5.f());
            return;
        L11:
            r2 = r3;
            goto L12
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

    public final Map<String, String> f() {
        Map<String, String> r0 = this.c.a;
        Map<String, String> r1 = this.b.a;
        HashMap r2 = new HashMap();
        if (r1 == null) goto L5;
        r2.putAll(r1);
    L5:
        if (r0 == null) goto L7;
        r2.putAll(r0);
    L7:
        return r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h() {
        if (this.a == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.a = true;
        LiveRoomParams r1 = this.e.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        k0 r2 = this.b;
        String r3 = null;
        if (r1 == null) goto L8;
        Map r4 = r1.getReportParams();
    L9:
        r2.d(r4);
        if (r1 == null) goto L19;
        String r5 = r1.getLiveTrackerParams();
        if (r5 == null) goto L19;
        JSONObject r6 = com.bytedance.android.shopping.anchorv3.a.d(r5);
        if (r6 == null) goto L19;
        Iterator<String> r7 = r6.keys();
    L17:
        if (r7.hasNext() == false) goto L19;
        String r8 = r7.next();
        this.b.c(r8, r6.optString(r8));
    L19:
        String r9 = (String) ((HashMap) this.b.a).remove("live_tracker_params");
        k0 r10 = this.b;
        if (r1 == null) goto L22;
        Map r11 = r1.getEcomLiveParamsEventParams();
    L23:
        r10.d(r11);
        if (r1 == null) goto L31;
        JSONObject r12 = r1.getPassThroughLogData();
        if (r12 == null) goto L31;
        Iterator<String> r13 = r12.keys();
    L29:
        if (r13.hasNext() == false) goto L31;
        String r14 = r13.next();
        this.b.c(r14, r12.optString(r14));
    L31:
        this.b.d(Collections.unmodifiableMap(f2.b.a));
        this.b.c("EVENT_ORIGIN_FEATURE", "TEMAI");
        this.b.c("enter_from", "live");
        this.b.c("ecom_group_type", "live");
        this.b.c("_param_live_platform", "live");
        k0 r15 = this.b;
        if (r1 == null) goto L34;
        String r16 = r1.getEnterMethod();
    L35:
        r15.c("enter_method", r16);
        k0 r17 = this.b;
        if (r1 == null) goto L38;
        String r18 = r1.getEnterFromMerge();
    L39:
        r17.c("enter_from_merge", r18);
        k0 r19 = this.b;
        if (r1 == null) goto L42;
        String r20 = r1.getSourcePage();
    L43:
        r19.c("source_page", r20);
        k0 r21 = this.b;
        if (r1 == null) goto L46;
        String r22 = r1.getActionType();
    L47:
        r21.c("action_type", r22);
        k0 r23 = this.b;
        if (r1 == null) goto L50;
        String r24 = r1.getRoomId();
    L51:
        r23.c("room_id", r24);
        k0 r25 = this.b;
        if (r1 == null) goto L54;
        String r26 = r1.getAuthorId();
    L55:
        r25.c("anchor_id", r26);
        k0 r27 = this.b;
        if (r1 == null) goto L58;
        String r28 = r1.getRequestId();
    L59:
        r27.c("request_id", r28);
        k0 r29 = this.b;
        if (r1 == null) goto L62;
        String r30 = r1.getFollowStatus();
    L63:
        r29.c("follow_status", r30);
        k0 r31 = this.b;
        if (r1 == null) goto L68;
        Function0 r32 = r1.getScreenType();
        if (r32 == null) goto L68;
        String r33 = (String) r32.invoke();
    L69:
        r31.c("screen_type", r33);
        k0 r34 = this.b;
        if (r1 == null) goto L72;
        String r35 = r1.getGroupId();
    L73:
        r34.c("group_id", r35);
        k0 r36 = this.b;
        if (r1 == null) goto L78;
        Map r37 = r1.getReportParams();
        if (r37 == null) goto L78;
        String r38 = (String) r37.get("group_type");
    L79:
        r36.c("ecom_group_type", r38);
        this.b.c("enter_from", "live");
        k0 r39 = this.b;
        if (r1 == null) goto L82;
        String r40 = r1.getDisplayRoomId();
    L83:
        r39.c("display_room_id", r40);
        k0 r41 = this.b;
        if (r1 == null) goto L86;
        String r42 = r1.getDisplayAnchorId();
    L87:
        r41.c("display_anchor_id", r42);
        k0 r43 = this.b;
        if (r1 == null) goto L90;
        String r44 = r1.getDisplaySecAnchorId();
    L91:
        r43.c("display_sec_anchor_id", r44);
        k0 r45 = this.b;
        if (r1 == null) goto L94;
        String r46 = r1.getDisplayFollowStatus();
    L95:
        r45.c("display_follow_status", r46);
        if (r1 == null) goto L104;
        Function0 r47 = r1.getRoomInfo();
        if (r47 == null) goto L104;
        n1 r48 = (n1) r47.invoke();
        if (r48 == null) goto L104;
        List r49 = r48.a();
        if (r49 == null) goto L104;
        k0 r50 = this.b;
        int r51 = m0.a;
        r50.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(m0.a.a, r49));
    L104:
        k0 r52 = this.b;
        if (r1 == null) goto L111;
        Function0 r53 = r1.getInstantType();
        if (r53 == null) goto L111;
        Integer r54 = (Integer) r53.invoke();
        if (r54 == null) goto L111;
        int r55 = r54.intValue();
    L112:
        r52.a("instant_type", r55);
        this.b.c("ec_live_font_scale", (String) ECLiveLargeModeConfigHelper.a.getValue());
        int r56 = ECSdk.a;
        IAdapterService r57 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r57 == null) goto L115;
        r57.getStrategyService();
    L115:
        com.bytedance.android.ec.common.api.jump.model.f r58 = this.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r58 == null) goto L135;
        this.b.c("ecom_entrance_form", r58.c.a);
        if (Intrinsics.areEqual(r58.c, jf.b.b.b) == false) goto L135;
        com.bytedance.android.ec.common.api.jump.model.g r59 = this.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r59 == null) goto L122;
        ql.a r60 = r59.a;
    L123:
        k0 r61 = this.b;
        if (r60 == null) goto L126;
        int r62 = r60.getFlashType();
    L127:
        Integer r63 = Integer.valueOf(r62);
        if (r63.intValue() != 1) goto L131;
        String r64 = "buynow_all";
    L134:
        r61.getClass();
        k0.a.C0061a r65 = k0.a.a;
        r61.e("carrier_type", r64);
        r61.c("live_product_type", "buynow_part");
        goto L135
    L131:
        if (r63.intValue() != 2) goto L133;
        r64 = "buynow_part";
        goto L134
    L133:
        r64 = "live_bubble";
        goto L134
    L126:
        r62 = 0;
        goto L127
    L122:
        r60 = null;
    L135:
        gi2.a r66 = (gi2.a) this.e.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        String r67 = "1";
        if (r66 == null) goto L176;
        Map<String, String> r68 = r66.f;
        if (r68 == null) goto L144;
        Iterator<Map.Entry<String, String>> r69 = r68.entrySet().iterator();
    L141:
        if (r69.hasNext() == false) goto L143;
        Map.Entry<String, String> r70 = r69.next();
        this.b.c(r70.getKey(), r70.getValue());
        goto L141
    L143:
        Unit r71 = Unit.INSTANCE;
    L144:
        this.b.c("page_name", "live_list");
        k0 r72 = this.b;
        String r73 = r66.b;
        if (r73 != null) goto L147;
        r73 = "live_shopping_cart";
    L147:
        r72.c("live_list_channel", r73);
        k0 r74 = this.b;
        if (r1 == null) goto L150;
        String r75 = r1.getEnterFromMerge();
    L151:
        r74.c("carrier_source", r75);
        k0 r76 = this.b;
        if (r1 == null) goto L154;
        String r77 = r1.getEnterMethod();
    L155:
        r76.c("source_method", r77);
        LivePromotionPageRoomInfo r78 = (LivePromotionPageRoomInfo) r66.e.invoke();
        if (r78 == null) goto L166;
        this.b.c("room_type", String.valueOf(r78.getRoomType()));
        this.b.c("instant_room_type", String.valueOf(r78.getInstantRoomType()));
        String r79 = r78.getReceiveAddressId();
        if (r79 == null) goto L160;
        this.b.c("receive_address_id", r79);
    L160:
        String r80 = r78.getAddressType();
        if (r80 == null) goto L163;
        this.b.c("address_type", r80);
    L163:
        String r81 = r78.getAddressStrategy();
        if (r81 == null) goto L166;
        this.b.c("address_strategy_type", r81);
        Unit r82 = Unit.INSTANCE;
    L166:
        Function0<Boolean> r83 = r66.h;
        if (r83 == null) goto L176;
        Boolean r85 = (Boolean) r83.invoke();
        if (r85 == null) goto L176;
        if (r85.booleanValue() == true) goto L174;
        r85 = null;
    L174:
        if (r85 == null) goto L176;
        r85.booleanValue();
        this.b.c("is_instant_store", "1");
        goto L176
    L154:
        r77 = null;
        goto L155
    L150:
        r75 = null;
    L176:
        pk2.b r86 = (pk2.b) this.e.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        if (r86 == null) goto L197;
        k0 r87 = this.b;
        if (((Boolean) r86.c.invoke()).booleanValue() != true) goto L181;
        String r110 = "1";
    L182:
        r87.c("has_flash_notice", r110);
        if (r86.a.a != 1) goto L185;
        boolean r88 = true;
    L186:
        if (r88 != true) goto L197;
        if (this.b.g("enter_from_merge").booleanValue() == true) goto L191;
        this.b.c("enter_from_merge", "store_page");
    L191:
        if (this.b.g("enter_method").booleanValue() == true) goto L194;
        this.b.c("enter_method", "live_cell_card");
    L194:
        if (this.b.g("source_page").booleanValue() == true) goto L197;
        String r89 = this.b.f("enter_from_merge");
        String r90 = this.b.f("enter_method");
        this.b.c("source_page", r89 + "_temai_" + r90);
        goto L197
    L185:
        r88 = false;
        goto L186
    L181:
        r110 = BDLocationException.ERROR_TIMEOUT;
    L197:
        if (((rh2.b) this.e.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class))) == null) goto L207;
        k0 r91 = this.b;
        if (r86 == null) goto L205;
        Function0<Boolean> r92 = r86.c;
        if (r92 == null) goto L205;
        if (((Boolean) r92.invoke()).booleanValue() != true) goto L205;
        String r93 = "1";
    L206:
        r91.c("has_flash_notice", r93);
    L205:
        r93 = BDLocationException.ERROR_TIMEOUT;
    L207:
        com.bytedance.android.ec.common.api.jump.model.g r94 = this.e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r94 == null) goto L342;
        ql.a r95 = r94.a;
        if (r95 == null) goto L343;
        this.b.c("commodity_type", r95.getEventItemType());
        r95.getClientData().getClass();
        k0 r96 = this.b;
        String r97 = r95.getPromotionId();
        r96.getClass();
        k0.a.C0061a r98 = k0.a.a;
        r96.e("commodity_id", r97);
        r96.e("product_id", r95.getProductId());
        r96.c("inventory_status", r95.getInventoryStatus());
        if (TextUtils.isEmpty(r95.getRealPrice()) == true) goto L215;
        this.b.c("real_price", r95.getRealPrice());
    L215:
        if (TextUtils.isEmpty(r95.getCostPrice()) == true) goto L218;
        this.b.c("cost_price", r95.getCostPrice());
    L218:
        if (TextUtils.isEmpty(r95.getLogid()) == true) goto L220;
        this.b.c("logid", r95.getLogid());
    L220:
        k0 r99 = this.b;
        r99.a("list_num", r95.getIronIndex());
        r99.e("product_label", r95.getEventLabel());
        if (si2.q.a(r95) == false) goto L223;
        String r100 = "seckill";
    L224:
        r99.e("product_activity_type", r100);
        r99.d(r95.getEventParams());
        r99.a("ecom_goods_status", r95.getEcomGoodsStatus());
        if (r95.getActivity() == null) goto L234;
        k0 r101 = this.b;
        ECUIActivity r102 = r95.getActivity();
        long r103 = 0;
        if (r102 == null) goto L229;
        long r111 = r102.getActivityId();
    L230:
        r101.b("ecom_tag_activity_id", r111);
        ECUIActivity r104 = r95.getActivity();
        if (r104 == null) goto L233;
        r103 = r104.getActivityType();
    L233:
        r101.b("ecom_tag_activity_type", r103);
        goto L234
    L229:
        r111 = 0;
    L234:
        k0 r105 = this.b;
        r105.a("with_sku", !r95.getSingleSku() ? 1 : 0);
        r105.e("is_groupbuying", r95.getIsGroupBuying());
        ECUIAskExplainInfo r106 = r95.getAskExplainInfo();
        if (r106 != null) goto L237;
    L239:
        int r107 = 0;
    L240:
        r105.a("is_explain_apply", r107);
        if (r95.isPreSale() == false) goto L243;
        String r108 = "1";
    L244:
        r105.e("upfront_presell", r108);
        r105.e("base_verified_category", r95.getBaseVerifiedCategory());
        if (r95.isDiscountPrice() == false) goto L247;
        String r109 = "1";
    L248:
        r105.e("avl_discount", r109);
        if (r95.isCrossborderProduct() == false) goto L251;
        String r112 = "1";
    L252:
        r105.e("is_crossborder_goods", r112);
        r105.e("label_name", r95.getTrackLabelName());
        String r113 = r95.getLabelNameLive();
        if (r113 != null) goto L255;
        r113 = "";
    L255:
        r105.e("label_name_live", r113);
        if (r95.getStatus() != 5) goto L258;
        int r114 = 1;
    L259:
        r105.a("is_under_stock", r114);
        r105.a("is_hot_sale", r95.canShowHotAtmosphere() ? 1 : 0);
        r105.a("hot_sale_num", r95.getHotAtmosphereSaleNum());
        r105.e("hot_sale_type", r95.getHotSaleTypeStr());
        if (r95.getClientData().a == false) goto L262;
        String r115 = "1";
    L263:
        r105.c("is_notice", r115);
        ql.d r116 = r95.getClientData().f;
        if (r116 == null) goto L305;
        String r117 = r116.c;
        if (r117 == null) goto L268;
        this.b.c("tab_rank", r117);
    L268:
        String r118 = r116.e;
        if (r118 == null) goto L271;
        this.b.c("tab_name", r118);
    L271:
        String r119 = r116.b;
        if (r119 != null) goto L274;
    L281:
        r119 = BDLocationException.ERROR_TIMEOUT;
    L282:
        this.b.c("tab_type", r119);
        String r120 = r116.a;
        if (r120 != null) goto L285;
    L292:
        r120 = BDLocationException.ERROR_TIMEOUT;
    L293:
        this.b.c("live_tab_id", r120);
        String r121 = r116.d;
        if (r121 != null) goto L296;
    L302:
        r3 = BDLocationException.ERROR_TIMEOUT;
    L303:
        this.b.c("tab_unique_index", r3);
        goto L305
    L296:
        if (r121.length() > 0) goto L299;
        r0 = false;
    L299:
        if (r0 == false) goto L301;
        r3 = r121;
    L301:
        if (r3 != null) goto L303;
    L285:
        if (r120.length() <= 0) goto L287;
        boolean r122 = true;
    L288:
        if (r122 == true) goto L291;
        r120 = null;
    L291:
        if (r120 != null) goto L293;
    L287:
        r122 = false;
        goto L288
    L274:
        if (r119.length() <= 0) goto L276;
        boolean r123 = true;
    L277:
        if (r123 == true) goto L280;
        r119 = null;
    L280:
        if (r119 != null) goto L282;
    L276:
        r123 = false;
    L305:
        if (this.b.g("is_exist_matching_button").booleanValue() == true) goto L312;
        k0 r124 = this.b;
        if (r95.isShowCombination() == false) goto L309;
        String r125 = "1";
    L310:
        r124.c("is_exist_matching_button", r125);
        goto L312
    L309:
        r125 = BDLocationException.ERROR_TIMEOUT;
    L312:
        if (r95.isShowCombination() == false) goto L318;
        ECCombination r126 = r95.getCombination();
        if (r126 == null) goto L318;
        String r127 = r126.getCombinationId();
        if (r127 == null) goto L318;
        this.b.c("combination_id", r127);
    L318:
        Map r128 = r95.getExtraEventParams();
        if (r128 == null) goto L321;
        this.b.d(r128);
    L321:
        Integer r129 = r95.getCampainExtraType();
        if (r129 == null) goto L324;
        this.b.a("campaign_extra_type", r129.intValue());
    L324:
        k0 r130 = this.b;
        if (r95.isOnExplaining() == true) goto L328;
        r67 = BDLocationException.ERROR_TIMEOUT;
    L328:
        r130.getClass();
        r130.e("is_explaining", r67);
        r130.a("local_num", r95.getLocalNum());
        if (r95.getClientData().c != null) goto L331;
    L333:
        StandardEventTrack r131 = r95.getStandardEventTrack();
        if (r131 == null) goto L344;
        String r132 = r131.getTrackParamsJSONStr();
        if (r132 == null) goto L345;
        this.b.c("standard_track_param", r132);
        return;
    L345:
        return;
    L344:
        return;
    L331:
        if (r95.getClientData().d == null) goto L333;
        k0 r133 = this.b;
        String r134 = r95.getClientData().c;
        r133.getClass();
        r133.e("smart_product_exist", r134);
        r133.c("have_smart_like_product", r95.getClientData().d);
        goto L333
    L262:
        r115 = BDLocationException.ERROR_TIMEOUT;
        goto L263
    L258:
        r114 = 0;
        goto L259
    L251:
        r112 = BDLocationException.ERROR_TIMEOUT;
        goto L252
    L247:
        r109 = BDLocationException.ERROR_TIMEOUT;
        goto L248
    L243:
        r108 = BDLocationException.ERROR_TIMEOUT;
        goto L244
    L237:
        if (r106.isAsked() != true) goto L239;
        r107 = 1;
        goto L240
    L223:
        r100 = "nonactivity";
        goto L224
    L343:
        return;
    L342:
        return;
    L111:
        r55 = 0;
        goto L112
    L94:
        r46 = null;
        goto L95
    L90:
        r44 = null;
        goto L91
    L86:
        r42 = null;
        goto L87
    L82:
        r40 = null;
    L78:
        r38 = null;
        goto L79
    L72:
        r35 = null;
    L68:
        r33 = null;
        goto L69
    L62:
        r30 = null;
        goto L63
    L58:
        r28 = null;
        goto L59
    L54:
        r26 = null;
        goto L55
    L50:
        r24 = null;
        goto L51
    L46:
        r22 = null;
        goto L47
    L42:
        r20 = null;
        goto L43
    L38:
        r18 = null;
        goto L39
    L34:
        r16 = null;
        goto L35
    L22:
        r11 = null;
        goto L23
    L8:
        r4 = null;
        goto L9
    }

    public final Map<String, String> g() {
        h();
        return f();
    }

    public final void d(Map r2) {
        if (r2 == null) goto L5;
        this.c.d(r2);
        return;
    }

    public final void e(String r4) {
        Map<String, String> r0 = g();
        if (r4 == null) goto L27;
        Map r5 = EcomBcmTracker.f(PageFinder.via(r4), r0);
        if (r5 == null) goto L28;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r6.next();
        if (r2.getValue() == null) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r1.put(r2.getKey(), r2.getValue());
        goto L8
    L12:
        r3 = false;
        goto L13
    L15:
        LinkedHashMap r7 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r8 = r1.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put(r9.getKey(), String.valueOf(r9.getValue()));
        goto L17
    L19:
        d(r7);
        return;
    L28:
        return;
    }

    public final void i(String r2) {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
        return;
    L5:
        b r0 = new b(this, r2);
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L8;
        Single.fromCallable(new a(r0)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L8:
        r0.run();
    }

    public v(String r2, com.bytedance.android.ec.common.api.jump.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.d = r2;
        this.e = r3;
        this.b = new k0();
        this.c = new k0();
    }

    public final void a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.a(r2, r3);
    }

    public final void b(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.b(r2, r3);
    }

    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.c.c(r2, r3);
    }

    public final void j(String r2, String r3) {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
        return;
    L5:
        oh.a.a(new c(this, r2, r3));
    }
}
