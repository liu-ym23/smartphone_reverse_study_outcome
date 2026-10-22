package com.bytedance.android.livesdk.livecommerce.utils;

import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.BizExtendParam;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.model.response.Product;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.ec.model.response.j1;
import com.bytedance.android.ec.model.response.l1;
import com.bytedance.android.ec.model.response.m1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0 {
    static {
    }

    @JvmStatic
    public static final ECUIPromotionV2 a(com.bytedance.android.ec.model.response.w r10, String r11) {
        PrefetchOrder r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ECUIPromotionV2 r1 = new ECUIPromotionV2(SystemClock.elapsedRealtime());
        r1.setImage(r10.f());
        com.bytedance.android.ec.model.response.z0 r2 = r10.f();
        if (r2 == null) goto L8;
        ECHotAtmosphere r3 = r2.f();
    L9:
        r1.setHotAtmosphere(r3);
        r1.setPrice(r10.h());
        r1.setTitle(r10.o());
        r1.setBenefits(r10.a());
        r1.setPurchase(r10.k());
        r1.setBlank(r10.c());
        r1.setExtend(r10.e());
        r1.setProduct(r10.i());
        String r4 = r10.j();
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r1.setPromotionId(r4);
        r1.setStatus(r10.n());
        Integer r6 = r10.g();
        boolean r7 = false;
        if (r6 == null) goto L15;
        int r8 = r6.intValue();
    L16:
        r1.setIronIndex(r8);
        Integer r9 = r10.l();
        if (r9 == null) goto L19;
        int r12 = r9.intValue();
    L20:
        r1.setRealIndex(r12);
        Map r13 = r10.d();
        if (r13 == null) goto L42;
        LinkedHashMap r14 = new LinkedHashMap();
        r14.putAll(r13);
        Unit r15 = Unit.INSTANCE;
        r1.setEventParams(r14);
        r1.setHasDiscountPrice((String) r13.get("avl_discount"));
        if (r13.get("combination_id") == null) goto L25;
        boolean r16 = true;
    L26:
        r1.setShowCombination(r16);
        r1.setRealPrice((String) r13.get("real_price"));
        r1.setSingleSku(Intrinsics.areEqual((String) r13.get("with_sku"), BDLocationException.ERROR_TIMEOUT));
        String r17 = (String) r13.get("live_product_type");
        if (r17 == null) goto L40;
        int r18 = r17.hashCode();
        if (r18 == (-538757262)) goto L38;
        if (r18 != 478830658) goto L40;
        if (r17.equals("buynow_part") == false) goto L40;
        int r19 = 2;
    L41:
        r1.setFlashType(r19);
        r1.setInsuranceProduct(Intrinsics.areEqual((String) r13.get("insurance_commodity_flag"), "1"));
        goto L42
    L38:
        if (r17.equals("buynow_all") == false) goto L40;
        r19 = 1;
    L40:
        r19 = 0;
        goto L41
    L25:
        r16 = false;
    L42:
        r1.processEventParams();
        r1.setStandardEventTrack(r10.m());
        r1.setTrack(r10.p());
        Product r20 = r10.i();
        if (r20 == null) goto L45;
        String r21 = r20.getProductId();
    L46:
        if (r21 != null) goto L48;
        r21 = "";
    L48:
        r1.setProductId(r21);
        Product r22 = r10.i();
        if (r22 == null) goto L51;
        String r23 = r22.getChannelId();
    L52:
        r1.setChannelId(r23);
        Product r24 = r10.i();
        if (r24 == null) goto L55;
        Integer r25 = r24.getChannelType();
    L56:
        r1.setChannelType(r25);
        Product r26 = r10.i();
        if (r26 == null) goto L59;
        String r27 = r26.getDetailUrl();
    L60:
        r1.setScheme(r27);
        Product r28 = r10.i();
        if (r28 == null) goto L63;
        String r29 = r28.getShopId();
    L64:
        if (r29 != null) goto L66;
        r29 = "";
    L66:
        r1.setShopId(r29);
        Product r30 = r10.i();
        if (r30 == null) goto L71;
        Long r31 = r30.getItemType();
        if (r31 == null) goto L71;
        String r32 = String.valueOf(r31.longValue());
    L72:
        r1.setEventItemType(r32);
        BizExtendParam r33 = r10.b();
        if (r33 == null) goto L77;
        Integer r34 = r33.getDynamicRecommendIndex();
        if (r34 == null) goto L77;
        int r35 = r34.intValue();
    L78:
        r1.setDynamicRecommendIndex(r35);
        BizExtendParam r36 = r10.b();
        if (r36 == null) goto L81;
        String r37 = r36.getLeafCategory();
    L82:
        r1.setLeafCategory(r37);
        BizExtendParam r38 = r10.b();
        if (r38 == null) goto L85;
        ECUrlModel r39 = r38.getDetailCover();
    L86:
        r1.setDetailCover(r39);
        r1.setLogid(r11);
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L89
        int r40 = RoomContextController.h;     // Catch: Exception -> L89
        RoomContextController r41 = RoomContextController.a.a();     // Catch: Exception -> L89
        int r42 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;     // Catch: Exception -> L89
        r110.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());     // Catch: Exception -> L89
        r110.put("anchor_id", r41.y());     // Catch: Exception -> L89
        r110.put("room_id", r41.B());     // Catch: Exception -> L89
        r110.put("show_dou_campaign", 0);     // Catch: Exception -> L89
        r1.setExtraTransmissibleLogParams(r110);     // Catch: Exception -> L89
    L91:
        r1.setEventLabel("normal");
        LinkedHashMap r111 = new LinkedHashMap();
        j1 r43 = r10.o();
        if (r43 == null) goto L96;
        List r44 = r43.c();
        if (r44 == null) goto L96;
        r111.put("live_room_product_title_before", r44);
    L96:
        com.bytedance.android.ec.model.response.q0 r45 = r10.a();
        if (r45 == null) goto L114;
        List r46 = r45.a();
        if (r46 == null) goto L114;
        Iterator r47 = r46.iterator();
    L102:
        if (r47.hasNext() == false) goto L114;
        List r48 = ((com.bytedance.android.ec.model.response.i0) r47.next()).a();
        if (r48 == null) goto L102;
        Iterator r49 = r48.iterator();
    L107:
        if (r49.hasNext() == false) goto L102;
        com.bytedance.android.ec.model.response.p0 r50 = (com.bytedance.android.ec.model.response.p0) r49.next();
        List r51 = r50.f();
        if (r51 == null) goto L111;
        r111.put("live_room_good_list_user_right", r51);
    L111:
        List r52 = r50.c();
        if (r52 == null) goto L107;
        r111.put("live_info_under_title", r52);
    L114:
        r1.setRitTag(r111);
        com.bytedance.android.ec.model.response.q0 r112 = r10.a();
        if (r112 == null) goto L129;
        List r113 = r112.a();
        if (r113 == null) goto L129;
        Iterator r114 = r113.iterator();
    L120:
        if (r114.hasNext() == false) goto L129;
        List r53 = ((com.bytedance.android.ec.model.response.i0) r114.next()).a();
        if (r53 == null) goto L120;
        Iterator r54 = r53.iterator();
    L125:
        if (r54.hasNext() == false) goto L120;
        List r55 = ((com.bytedance.android.ec.model.response.p0) r54.next()).a();
        if (r55 == null) goto L125;
    L130:
        r1.setBenefitLabels(r55);
        g1 r115 = r10.k();
        if (r115 == null) goto L138;
        m1 r116 = r115.b();
        if (r116 == null) goto L138;
        String r117 = r116.b();
        if (r117 == null) goto L138;
        r5 = r117;
    L138:
        r1.setCurrentLabel(r5);
        com.bytedance.android.ec.model.response.d1 r118 = r10.h();
        if (r118 == null) goto L145;
        h1 r119 = r118.c();
        if (r119 == null) goto L145;
        com.bytedance.android.ec.model.response.c1 r120 = r119.b();
        if (r120 == null) goto L145;
        String r121 = k.g(r120.b());
    L146:
        r1.setCostPrice(String.valueOf(r121));
        g1 r122 = r10.k();
        if (r122 == null) goto L151;
        l1 r123 = r122.a();
        if (r123 == null) goto L151;
        com.bytedance.android.ec.model.response.j0 r124 = r123.a();
    L152:
        if (r124 == null) goto L154;
        r7 = true;
    L154:
        r1.setCanAddShopCart(r7);
        Product r125 = r10.i();
        if (r125 == null) goto L157;
        String r126 = r125.getBizIdentity();
    L158:
        r1.setBizIdentity(r126);
        BizExtendParam r127 = r10.b();
        if (r127 == null) goto L161;
        String r128 = r127.getCheckCallback();
    L162:
        r1.setCheckCallback(r128);
        BizExtendParam r129 = r10.b();
        if (r129 == null) goto L165;
        r0 = r129.getPrefetchOrder();
    L165:
        r1.setPrefetchOrder(r0);
        return r1;
    L161:
        r128 = null;
        goto L162
    L157:
        r126 = null;
    L151:
        r124 = null;
    L145:
        r121 = null;
    L129:
        r55 = null;
    L89:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L91
    L85:
        r39 = null;
        goto L86
    L81:
        r37 = null;
    L77:
        r35 = 0;
    L71:
        r32 = null;
        goto L72
    L63:
        r29 = null;
        goto L64
    L59:
        r27 = null;
        goto L60
    L55:
        r25 = null;
        goto L56
    L51:
        r23 = null;
        goto L52
    L45:
        r21 = null;
        goto L46
    L19:
        r12 = 0;
        goto L20
    L15:
        r8 = 0;
        goto L16
    L8:
        r3 = null;
        goto L9
    }
}
