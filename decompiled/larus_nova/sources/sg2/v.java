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
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
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

/* JADX INFO: loaded from: classes10.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f541818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f541819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f541820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f541821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.ec.common.api.jump.model.a f541822e;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f541823a;

        public a(b r100) {
            this.f541823a = r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f541823a.run();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f541824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f541825b;

        public b(v r100, String r101) {
            this.f541824a = r100;
            this.f541825b = r101;
        }

        public final void a() {
            this.f541824a.h();
            com.bytedance.android.ec.common.api.jump.model.f r100 = (com.bytedance.android.ec.common.api.jump.model.f) this.f541824a.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
            String r101 = a2.d(this.f541825b);
            String r102 = null;
            if (r101 != null) goto L7;
            if (r100 == null) goto L6;
            r101 = r100.f42859a;
            goto L7
        L6:
            r101 = null;
        L7:
            if (r101 == null) goto L12;
            if (r100 == null) goto L10;
            r102 = r100.f42860b;
        L10:
            if (r102 == null) goto L12;
            v r103 = this.f541824a;
            com.bytedance.android.livesdk.livecommerce.room.f.e(r103.f541821d, r103.f(), r101, PageFinder.via(r100.f42860b));
            return;
        L12:
            v r104 = this.f541824a;
            com.bytedance.android.livesdk.livecommerce.room.f.d(r104.f541821d, r104.f());
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f541826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f541827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f541828c;

        public c(v r100, String r101, String r102) {
            this.f541826a = r100;
            this.f541827b = r101;
            this.f541828c = r102;
        }

        public final void a() {
            this.f541826a.h();
            com.bytedance.android.ec.common.api.jump.model.f r100 = (com.bytedance.android.ec.common.api.jump.model.f) this.f541826a.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
            String r101 = a2.d(this.f541827b);
            String r102 = null;
            if (r101 != null) goto L7;
            if (r100 == null) goto L6;
            r101 = r100.f42859a;
            goto L7
        L6:
            r101 = null;
        L7:
            String r103 = a2.d(this.f541828c);
            if (r103 != null) goto L11;
            if (r100 == null) goto L12;
            r102 = r100.f42860b;
        L12:
            if (r101 == null) goto L15;
            if (r102 == null) goto L15;
            v r104 = this.f541826a;
            com.bytedance.android.livesdk.livecommerce.room.f.e(r104.f541821d, r104.f(), r101, PageFinder.via(r102));
            return;
        L15:
            v r105 = this.f541826a;
            com.bytedance.android.livesdk.livecommerce.room.f.d(r105.f541821d, r105.f());
            return;
        L11:
            r102 = r103;
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
        Map<String, String> r100 = this.f541820c.f147739a;
        Map<String, String> r101 = this.f541819b.f147739a;
        HashMap r102 = new HashMap();
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        if (r100 == null) goto L7;
        r102.putAll(r100);
    L7:
        return r102;
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
        if (this.f541818a == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.f541818a = true;
        LiveRoomParams r101 = (LiveRoomParams) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        k0 r102 = this.f541819b;
        String r103 = null;
        if (r101 == null) goto L8;
        Map<String, String> r104 = r101.getReportParams();
    L9:
        r102.d(r104);
        if (r101 == null) goto L19;
        String r105 = r101.getLiveTrackerParams();
        if (r105 == null) goto L19;
        JSONObject r106 = com.bytedance.android.shopping.anchorv3.a.d(r105);
        if (r106 == null) goto L19;
        Iterator<String> r107 = r106.keys();
    L17:
        if (r107.hasNext() == false) goto L19;
        String r108 = r107.next();
        this.f541819b.c(r108, r106.optString(r108));
    L19:
        String r109 = (String) ((HashMap) this.f541819b.f147739a).remove("live_tracker_params");
        k0 r110 = this.f541819b;
        if (r101 == null) goto L22;
        Map<String, String> r111 = r101.getEcomLiveParamsEventParams();
    L23:
        r110.d(r111);
        if (r101 == null) goto L31;
        JSONObject r112 = r101.getPassThroughLogData();
        if (r112 == null) goto L31;
        Iterator<String> r113 = r112.keys();
    L29:
        if (r113.hasNext() == false) goto L31;
        String r114 = r113.next();
        this.f541819b.c(r114, r112.optString(r114));
    L31:
        this.f541819b.d(Collections.unmodifiableMap(f2.f147736b.f147737a));
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        this.f541819b.c("enter_from", "live");
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        k0 r115 = this.f541819b;
        if (r101 == null) goto L34;
        String r116 = r101.getEnterMethod();
    L35:
        r115.c("enter_method", r116);
        k0 r117 = this.f541819b;
        if (r101 == null) goto L38;
        String r118 = r101.getEnterFromMerge();
    L39:
        r117.c("enter_from_merge", r118);
        k0 r119 = this.f541819b;
        if (r101 == null) goto L42;
        String r120 = r101.getSourcePage();
    L43:
        r119.c("source_page", r120);
        k0 r121 = this.f541819b;
        if (r101 == null) goto L46;
        String r122 = r101.getActionType();
    L47:
        r121.c("action_type", r122);
        k0 r123 = this.f541819b;
        if (r101 == null) goto L50;
        String r124 = r101.getRoomId();
    L51:
        r123.c("room_id", r124);
        k0 r125 = this.f541819b;
        if (r101 == null) goto L54;
        String r126 = r101.getAuthorId();
    L55:
        r125.c("anchor_id", r126);
        k0 r127 = this.f541819b;
        if (r101 == null) goto L58;
        String r128 = r101.getRequestId();
    L59:
        r127.c("request_id", r128);
        k0 r129 = this.f541819b;
        if (r101 == null) goto L62;
        String r130 = r101.getFollowStatus();
    L63:
        r129.c("follow_status", r130);
        k0 r131 = this.f541819b;
        if (r101 == null) goto L68;
        Function0<String> r132 = r101.getScreenType();
        if (r132 == null) goto L68;
        String r133 = r132.invoke();
    L69:
        r131.c("screen_type", r133);
        k0 r134 = this.f541819b;
        if (r101 == null) goto L72;
        String r135 = r101.getGroupId();
    L73:
        r134.c("group_id", r135);
        k0 r136 = this.f541819b;
        if (r101 == null) goto L78;
        Map<String, String> r137 = r101.getReportParams();
        if (r137 == null) goto L78;
        String r138 = r137.get("group_type");
    L79:
        r136.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r138);
        this.f541819b.c("enter_from", "live");
        k0 r139 = this.f541819b;
        if (r101 == null) goto L82;
        String r140 = r101.getDisplayRoomId();
    L83:
        r139.c("display_room_id", r140);
        k0 r141 = this.f541819b;
        if (r101 == null) goto L86;
        String r142 = r101.getDisplayAnchorId();
    L87:
        r141.c("display_anchor_id", r142);
        k0 r143 = this.f541819b;
        if (r101 == null) goto L90;
        String r144 = r101.getDisplaySecAnchorId();
    L91:
        r143.c("display_sec_anchor_id", r144);
        k0 r145 = this.f541819b;
        if (r101 == null) goto L94;
        String r146 = r101.getDisplayFollowStatus();
    L95:
        r145.c("display_follow_status", r146);
        if (r101 == null) goto L104;
        Function0<n1> r147 = r101.getRoomInfo();
        if (r147 == null) goto L104;
        n1 r148 = r147.invoke();
        if (r148 == null) goto L104;
        List<Long> r149 = r148.a();
        if (r149 == null) goto L104;
        k0 r150 = this.f541819b;
        int r151 = m0.f153098a;
        r150.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(m0.a.f153099a, r149));
    L104:
        k0 r152 = this.f541819b;
        if (r101 == null) goto L111;
        Function0<Integer> r153 = r101.getInstantType();
        if (r153 == null) goto L111;
        Integer r154 = r153.invoke();
        if (r154 == null) goto L111;
        int r155 = r154.intValue();
    L112:
        r152.a("instant_type", r155);
        this.f541819b.c("ec_live_font_scale", (String) ECLiveLargeModeConfigHelper.f149245a.getValue());
        int r156 = ECSdk.f48106a;
        IAdapterService r157 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r157 == null) goto L115;
        r157.getStrategyService();
    L115:
        com.bytedance.android.ec.common.api.jump.model.f r158 = (com.bytedance.android.ec.common.api.jump.model.f) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r158 == null) goto L135;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r158.f42861c.f498849a);
        if (Intrinsics.areEqual(r158.f42861c, jf.b.C6430b.f498851b) == false) goto L135;
        com.bytedance.android.ec.common.api.jump.model.g r159 = (com.bytedance.android.ec.common.api.jump.model.g) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r159 == null) goto L122;
        ql.a r160 = r159.f42873a;
    L123:
        k0 r161 = this.f541819b;
        if (r160 == null) goto L126;
        int r162 = r160.getFlashType();
    L127:
        Integer r163 = Integer.valueOf(r162);
        if (r163.intValue() != 1) goto L131;
        String r164 = "buynow_all";
    L134:
        r161.getClass();
        k0.a.C2294a r165 = k0.a.f147740a;
        r161.e("carrier_type", r164);
        r161.c("live_product_type", "buynow_part");
        goto L135
    L131:
        if (r163.intValue() != 2) goto L133;
        r164 = "buynow_part";
        goto L134
    L133:
        r164 = "live_bubble";
        goto L134
    L126:
        r162 = 0;
        goto L127
    L122:
        r160 = null;
    L135:
        gi2.a r166 = (gi2.a) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        String r167 = "1";
        if (r166 == null) goto L176;
        Map<String, String> r168 = r166.f481340f;
        if (r168 == null) goto L144;
        Iterator<Map.Entry<String, String>> r169 = r168.entrySet().iterator();
    L141:
        if (r169.hasNext() == false) goto L143;
        Map.Entry<String, String> r170 = r169.next();
        this.f541819b.c(r170.getKey(), r170.getValue());
        goto L141
    L143:
        Unit r171 = Unit.INSTANCE;
    L144:
        this.f541819b.c("page_name", "live_list");
        k0 r172 = this.f541819b;
        String r173 = r166.f481336b;
        if (r173 != null) goto L147;
        r173 = "live_shopping_cart";
    L147:
        r172.c(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r173);
        k0 r174 = this.f541819b;
        if (r101 == null) goto L150;
        String r175 = r101.getEnterFromMerge();
    L151:
        r174.c(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r175);
        k0 r176 = this.f541819b;
        if (r101 == null) goto L154;
        String r177 = r101.getEnterMethod();
    L155:
        r176.c(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r177);
        LivePromotionPageRoomInfo r178 = r166.f481339e.invoke();
        if (r178 == null) goto L166;
        this.f541819b.c(IPerformanceManager.Params.room_type, String.valueOf(r178.getRoomType()));
        this.f541819b.c("instant_room_type", String.valueOf(r178.getInstantRoomType()));
        String r179 = r178.getReceiveAddressId();
        if (r179 == null) goto L160;
        this.f541819b.c("receive_address_id", r179);
    L160:
        String r180 = r178.getAddressType();
        if (r180 == null) goto L163;
        this.f541819b.c("address_type", r180);
    L163:
        String r181 = r178.getAddressStrategy();
        if (r181 == null) goto L166;
        this.f541819b.c("address_strategy_type", r181);
        Unit r182 = Unit.INSTANCE;
    L166:
        Function0<Boolean> r183 = r166.f481342h;
        if (r183 == null) goto L176;
        Boolean r184 = r183.invoke();
        if (r184 == null) goto L176;
        if (r184.booleanValue() == true) goto L174;
        r184 = null;
    L174:
        if (r184 == null) goto L176;
        r184.booleanValue();
        this.f541819b.c("is_instant_store", "1");
        goto L176
    L154:
        r177 = null;
        goto L155
    L150:
        r175 = null;
    L176:
        pk2.b r185 = (pk2.b) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        if (r185 == null) goto L197;
        k0 r186 = this.f541819b;
        if (r185.f529584c.invoke().booleanValue() != true) goto L181;
        String r187 = "1";
    L182:
        r186.c("has_flash_notice", r187);
        if (r185.f529582a.f481036a != 1) goto L185;
        boolean r188 = true;
    L186:
        if (r188 != true) goto L197;
        if (this.f541819b.g("enter_from_merge").booleanValue() == true) goto L191;
        this.f541819b.c("enter_from_merge", "store_page");
    L191:
        if (this.f541819b.g("enter_method").booleanValue() == true) goto L194;
        this.f541819b.c("enter_method", "live_cell_card");
    L194:
        if (this.f541819b.g("source_page").booleanValue() == true) goto L197;
        String r189 = this.f541819b.f("enter_from_merge");
        String r190 = this.f541819b.f("enter_method");
        this.f541819b.c("source_page", r189 + "_temai_" + r190);
        goto L197
    L185:
        r188 = false;
        goto L186
    L181:
        r187 = "0";
    L197:
        if (((rh2.b) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(rh2.b.class))) == null) goto L207;
        k0 r191 = this.f541819b;
        if (r185 == null) goto L205;
        Function0<Boolean> r192 = r185.f529584c;
        if (r192 == null) goto L205;
        if (r192.invoke().booleanValue() != true) goto L205;
        String r193 = "1";
    L206:
        r191.c("has_flash_notice", r193);
    L205:
        r193 = "0";
    L207:
        com.bytedance.android.ec.common.api.jump.model.g r194 = (com.bytedance.android.ec.common.api.jump.model.g) this.f541822e.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class));
        if (r194 == null) goto L342;
        ql.a r195 = r194.f42873a;
        if (r195 == null) goto L343;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r195.getEventItemType());
        r195.getClientData().getClass();
        k0 r196 = this.f541819b;
        String r197 = r195.getPromotionId();
        r196.getClass();
        k0.a.C2294a r198 = k0.a.f147740a;
        r196.e(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r197);
        r196.e("product_id", r195.getProductId());
        r196.c("inventory_status", r195.getInventoryStatus());
        if (TextUtils.isEmpty(r195.getRealPrice()) == true) goto L215;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE, r195.getRealPrice());
    L215:
        if (TextUtils.isEmpty(r195.getCostPrice()) == true) goto L218;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE, r195.getCostPrice());
    L218:
        if (TextUtils.isEmpty(r195.getLogid()) == true) goto L220;
        this.f541819b.c(CronetDataStorageAccess.LOGID, r195.getLogid());
    L220:
        k0 r199 = this.f541819b;
        r199.a("list_num", r195.getIronIndex());
        r199.e(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_LABEL, r195.getEventLabel());
        if (si2.q.a(r195) == false) goto L223;
        String r200 = "seckill";
    L224:
        r199.e(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE, r200);
        r199.d(r195.getEventParams());
        r199.a("ecom_goods_status", r195.getEcomGoodsStatus());
        if (r195.getActivity() == null) goto L234;
        k0 r201 = this.f541819b;
        ECUIActivity r202 = r195.getActivity();
        long r203 = 0;
        if (r202 == null) goto L229;
        long r1100 = r202.getActivityId();
    L230:
        r201.b(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_ID, r1100);
        ECUIActivity r204 = r195.getActivity();
        if (r204 == null) goto L233;
        r203 = r204.getActivityType();
    L233:
        r201.b(com.bytedance.android.ec.core.event.a.KEY_ECOM_TAG_ACTIVITY_TYPE, r203);
        goto L234
    L229:
        r1100 = 0;
    L234:
        k0 r205 = this.f541819b;
        r205.a(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, !r195.getSingleSku() ? 1 : 0);
        r205.e(com.bytedance.android.ec.core.event.a.KEY_IS_GROUP_BUYING, r195.getIsGroupBuying());
        ECUIAskExplainInfo r206 = r195.getAskExplainInfo();
        if (r206 != null) goto L237;
    L239:
        int r207 = 0;
    L240:
        r205.a(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r207);
        if (r195.isPreSale() == false) goto L243;
        String r208 = "1";
    L244:
        r205.e(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r208);
        r205.e(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r195.getBaseVerifiedCategory());
        if (r195.isDiscountPrice() == false) goto L247;
        String r209 = "1";
    L248:
        r205.e(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r209);
        if (r195.isCrossborderProduct() == false) goto L251;
        String r210 = "1";
    L252:
        r205.e(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS, r210);
        r205.e(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r195.getTrackLabelName());
        String r211 = r195.getLabelNameLive();
        if (r211 != null) goto L255;
        r211 = "";
    L255:
        r205.e(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r211);
        if (r195.getStatus() != 5) goto L258;
        int r212 = 1;
    L259:
        r205.a(com.bytedance.android.ec.core.event.a.KEY_IS_UNDER_STOCK, r212);
        r205.a("is_hot_sale", r195.canShowHotAtmosphere() ? 1 : 0);
        r205.a("hot_sale_num", r195.getHotAtmosphereSaleNum());
        r205.e("hot_sale_type", r195.getHotSaleTypeStr());
        if (r195.getClientData().f533692a == false) goto L262;
        String r213 = "1";
    L263:
        r205.c("is_notice", r213);
        ql.d r214 = r195.getClientData().f533697f;
        if (r214 == null) goto L305;
        String r215 = r214.f533703c;
        if (r215 == null) goto L268;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_HEAD_TAB_RANK, r215);
    L268:
        String r216 = r214.f533705e;
        if (r216 == null) goto L271;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r216);
    L271:
        String r217 = r214.f533702b;
        if (r217 != null) goto L274;
    L281:
        r217 = "0";
    L282:
        this.f541819b.c("tab_type", r217);
        String r218 = r214.f533701a;
        if (r218 != null) goto L285;
    L292:
        r218 = "0";
    L293:
        this.f541819b.c("live_tab_id", r218);
        String r219 = r214.f533704d;
        if (r219 != null) goto L296;
    L302:
        r103 = "0";
    L303:
        this.f541819b.c("tab_unique_index", r103);
        goto L305
    L296:
        if (r219.length() > 0) goto L299;
        r100 = false;
    L299:
        if (r100 == false) goto L301;
        r103 = r219;
    L301:
        if (r103 != null) goto L303;
    L285:
        if (r218.length() <= 0) goto L287;
        boolean r220 = true;
    L288:
        if (r220 == true) goto L291;
        r218 = null;
    L291:
        if (r218 != null) goto L293;
    L287:
        r220 = false;
        goto L288
    L274:
        if (r217.length() <= 0) goto L276;
        boolean r221 = true;
    L277:
        if (r221 == true) goto L280;
        r217 = null;
    L280:
        if (r217 != null) goto L282;
    L276:
        r221 = false;
    L305:
        if (this.f541819b.g("is_exist_matching_button").booleanValue() == true) goto L312;
        k0 r222 = this.f541819b;
        if (r195.isShowCombination() == false) goto L309;
        String r223 = "1";
    L310:
        r222.c("is_exist_matching_button", r223);
        goto L312
    L309:
        r223 = "0";
    L312:
        if (r195.isShowCombination() == false) goto L318;
        ECCombination r224 = r195.getCombination();
        if (r224 == null) goto L318;
        String r225 = r224.getCombinationId();
        if (r225 == null) goto L318;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r225);
    L318:
        Map<String, String> r226 = r195.getExtraEventParams();
        if (r226 == null) goto L321;
        this.f541819b.d(r226);
    L321:
        Integer r227 = r195.getCampainExtraType();
        if (r227 == null) goto L324;
        this.f541819b.a(com.bytedance.android.ec.core.event.a.KEY_CAMPAIGN_EXTRA_TYPE, r227.intValue());
    L324:
        k0 r228 = this.f541819b;
        if (r195.isOnExplaining() == true) goto L328;
        r167 = "0";
    L328:
        r228.getClass();
        r228.e("is_explaining", r167);
        r228.a("local_num", r195.getLocalNum());
        if (r195.getClientData().f533694c != null) goto L331;
    L333:
        StandardEventTrack r229 = r195.getStandardEventTrack();
        if (r229 == null) goto L344;
        String r230 = r229.getTrackParamsJSONStr();
        if (r230 == null) goto L345;
        this.f541819b.c(com.bytedance.android.ec.core.event.a.KEY_STANDARD_TRACK_PARAM, r230);
        return;
    L345:
        return;
    L344:
        return;
    L331:
        if (r195.getClientData().f533695d == null) goto L333;
        k0 r231 = this.f541819b;
        String r232 = r195.getClientData().f533694c;
        r231.getClass();
        r231.e("smart_product_exist", r232);
        r231.c("have_smart_like_product", r195.getClientData().f533695d);
        goto L333
    L262:
        r213 = "0";
        goto L263
    L258:
        r212 = 0;
        goto L259
    L251:
        r210 = "0";
        goto L252
    L247:
        r209 = "0";
        goto L248
    L243:
        r208 = "0";
        goto L244
    L237:
        if (r206.isAsked() != true) goto L239;
        r207 = 1;
        goto L240
    L223:
        r200 = "nonactivity";
        goto L224
    L343:
        return;
    L342:
        return;
    L111:
        r155 = 0;
        goto L112
    L94:
        r146 = null;
        goto L95
    L90:
        r144 = null;
        goto L91
    L86:
        r142 = null;
        goto L87
    L82:
        r140 = null;
    L78:
        r138 = null;
        goto L79
    L72:
        r135 = null;
    L68:
        r133 = null;
        goto L69
    L62:
        r130 = null;
        goto L63
    L58:
        r128 = null;
        goto L59
    L54:
        r126 = null;
        goto L55
    L50:
        r124 = null;
        goto L51
    L46:
        r122 = null;
        goto L47
    L42:
        r120 = null;
        goto L43
    L38:
        r118 = null;
        goto L39
    L34:
        r116 = null;
        goto L35
    L22:
        r111 = null;
        goto L23
    L8:
        r104 = null;
        goto L9
    }

    public final Map<String, String> g() {
        h();
        return f();
    }

    public final void d(Map r100) {
        if (r100 == null) goto L5;
        this.f541820c.d(r100);
        return;
    }

    public final void e(String r100) {
        Map<String, String> r101 = g();
        if (r100 == null) goto L27;
        Map<String, Object> r102 = EcomBcmTracker.f(PageFinder.via(r100), r101);
        if (r102 == null) goto L28;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, Object> r105 = r104.next();
        if (r105.getValue() == null) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L8;
        r103.put(r105.getKey(), r105.getValue());
        goto L8
    L12:
        r106 = false;
        goto L13
    L15:
        LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
        Iterator r108 = r103.entrySet().iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put(r109.getKey(), String.valueOf(r109.getValue()));
        goto L17
    L19:
        d(r107);
        return;
    L28:
        return;
    }

    public final void i(String r100) {
        if (TextUtils.isEmpty(this.f541821d) == false) goto L5;
        return;
    L5:
        b r101 = new b(this, r100);
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L8;
        Single.fromCallable(new a(r101)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L8:
        r101.run();
    }

    public v(String r100, com.bytedance.android.ec.common.api.jump.model.a r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f541821d = r100;
        this.f541822e = r101;
        this.f541819b = new k0();
        this.f541820c = new k0();
    }

    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f541820c.a(r100, r101);
    }

    public final void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f541820c.b(r100, r101);
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f541820c.c(r100, r101);
    }

    public final void j(String r100, String r101) {
        if (TextUtils.isEmpty(this.f541821d) == false) goto L5;
        return;
    L5:
        oh.a.a(new c(this, r100, r101));
    }
}
