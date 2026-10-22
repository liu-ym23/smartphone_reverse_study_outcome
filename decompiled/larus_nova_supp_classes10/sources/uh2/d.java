package uh2;

import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroBenefit;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.h;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.m0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
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
public final class d {
    static {
    }

    @JvmStatic
    public static final IntroPromotionVO a(t0 r8, s0 r9, IntroCardScene r10, RoomContextController r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "roomContextController");
        String r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        long r1 = SystemClock.elapsedRealtime();
        IntroPromotionVO r3 = new IntroPromotionVO(r1);
        int r4 = k.a;
        k.a("[progress] set currentTime " + r1);
        r3.setControl(r9);
        r3.setImage(r8.i());
        r3.setIntroAtmosphere(r8.a());
        r3.setPrice(r8.k());
        r3.setTitle(r8.p());
        r3.setBenefits(r8.c());
        r3.setCarouselBenefits(r8.f());
        r3.setIntroBackground(r8.b());
        r3.setPurchase(r8.m());
        r3.setOpenPriceAnimation(r8.j());
        r3.setBlank(r8.e());
        r3.setProduct(r8.l());
        r3.setDurations(r8.g());
        r3.setSecondFrame(r8.n());
        IntroProduct r13 = r8.l();
        if (r13 == null) goto L8;
        String r14 = r13.i();
    L9:
        String r2 = "";
        if (r14 != null) goto L12;
        r14 = "";
    L12:
        r3.setPromotionId(r14);
        IntroProduct r15 = r8.l();
        if (r15 == null) goto L15;
        String r16 = r15.g();
    L16:
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        r3.setProductId(r16);
        Map<String, String> r17 = r8.h();
        if (r17 == null) goto L40;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.putAll(r17);
        Unit r6 = Unit.INSTANCE;
        r3.setEventParams(r5);
        r3.setHasDiscountPrice(r17.get("avl_discount"));
        int r7 = 1;
        if (r17.get("combination_id") == null) goto L23;
        boolean r18 = true;
    L24:
        r3.setShowCombination(r18);
        r3.setRealPrice(r17.get("real_price"));
        r3.setSingleSku(Intrinsics.areEqual(r17.get("with_sku"), BDLocationException.ERROR_TIMEOUT));
        String r19 = r17.get("live_product_type");
        if (r19 == null) goto L38;
        int r20 = r19.hashCode();
        if (r20 == (-538757262)) goto L36;
        if (r20 != 478830658) goto L38;
        if (r19.equals("buynow_part") == false) goto L38;
        r7 = 2;
    L39:
        r3.setFlashType(r7);
        r3.setInsuranceProduct(Intrinsics.areEqual(r17.get("insurance_commodity_flag"), "1"));
        goto L40
    L36:
        if (r19.equals("buynow_all") == true) goto L39;
    L38:
        r7 = 0;
        goto L39
    L23:
        r18 = false;
    L40:
        r3.processEventParams();
        r3.setStandardEventTrack(r8.o());
        r3.setTrack(r8.q());
        IntroProduct r21 = r8.l();
        if (r21 == null) goto L43;
        Long r22 = Long.valueOf(r21.b());
    L44:
        r3.setChannelId(String.valueOf(r22));
        IntroProduct r23 = r8.l();
        if (r23 == null) goto L47;
        Integer r24 = Integer.valueOf((int) r23.c());
    L48:
        r3.setChannelType(r24);
        IntroProduct r25 = r8.l();
        if (r25 == null) goto L51;
        String r26 = r25.d();
    L52:
        r3.setScheme(r26);
        IntroProduct r27 = r8.l();
        if (r27 == null) goto L55;
        Long r28 = Long.valueOf(r27.j());
    L56:
        r3.setShopId(String.valueOf(r28));
        IntroProduct r29 = r8.l();
        if (r29 == null) goto L59;
        String r30 = String.valueOf(r29.f());
    L60:
        r3.setEventItemType(r30);
        h r31 = r8.d();
        if (r31 == null) goto L63;
        ECUrlModel r32 = r31.c();
    L64:
        r3.setDetailCover(r32);
        h r33 = r8.d();
        if (r33 == null) goto L67;
        ECHotAtmosphere r34 = r33.b();
    L68:
        r3.setHotAtmosphere(r34);
        r3.setLogid(r12);
        JSONObject r35 = new JSONObject();     // Catch: Exception -> L71
        int r36 = w.h;     // Catch: Exception -> L71
        r35.put("ecom_scene_id", w.a.b());     // Catch: Exception -> L71
        r35.put("anchor_id", r11.y());     // Catch: Exception -> L71
        r35.put("room_id", r11.B());     // Catch: Exception -> L71
        r35.put("show_dou_campaign", 0);     // Catch: Exception -> L71
        r3.setExtraTransmissibleLogParams(r35);     // Catch: Exception -> L71
    L73:
        r3.setEventLabel("normal");
        LinkedHashMap r37 = new LinkedHashMap();
        o0 r110 = r8.p();
        if (r110 == null) goto L78;
        List<ECRitTag> r111 = r110.c();
        if (r111 == null) goto L78;
        r37.put("live_room_product_title_before", r111);
    L78:
        g r112 = r8.c();
        if (r112 == null) goto L96;
        List<p0> r113 = r112.a();
        if (r113 == null) goto L96;
        Iterator<T> r114 = r113.iterator();
    L84:
        if (r114.hasNext() == false) goto L96;
        List<IntroBenefit> r115 = ((p0) r114.next()).a();
        if (r115 == null) goto L84;
        Iterator<T> r116 = r115.iterator();
    L89:
        if (r116.hasNext() == false) goto L84;
        IntroBenefit r38 = (IntroBenefit) r116.next();
        List<ECRitTag> r39 = r38.f();
        if (r39 == null) goto L93;
        r37.put("live_room_good_list_user_right", r39);
    L93:
        List<ECRitTag> r40 = r38.c();
        if (r40 == null) goto L89;
        r37.put("live_info_under_title", r40);
    L96:
        r3.setRitTag(r37);
        l r41 = r8.f();
        if (r41 == null) goto L111;
        List<p0> r42 = r41.b();
        if (r42 == null) goto L111;
        Iterator<T> r43 = r42.iterator();
    L102:
        if (r43.hasNext() == false) goto L111;
        List<IntroBenefit> r117 = ((p0) r43.next()).a();
        if (r117 == null) goto L102;
        Iterator<T> r118 = r117.iterator();
    L107:
        if (r118.hasNext() == false) goto L102;
        List<PromotionBenefitLabel> r119 = ((IntroBenefit) r118.next()).a();
        if (r119 == null) goto L107;
    L127:
        r3.setBenefitLabels(r119);
        k0 r44 = r8.m();
        if (r44 == null) goto L133;
        l0 r45 = r44.a();
        if (r45 == null) goto L133;
        String r46 = r45.b();
        if (r46 == null) goto L133;
    L134:
        r3.setCurrentLabel(r46);
        IntroPrice r47 = r8.k();
        if (r47 == null) goto L141;
        m0 r48 = r47.c();
        if (r48 == null) goto L141;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.w r49 = r48.b();
        if (r49 == null) goto L141;
        String r50 = com.bytedance.android.livesdk.livecommerce.utils.k.g(r49.b());
    L142:
        r3.setCostPrice(String.valueOf(r50));
        r3.setCanAddShopCart(false);
        IntroProduct r51 = r8.l();
        if (r51 == null) goto L145;
        String r52 = r51.a();
    L146:
        r3.setBizIdentity(r52);
        h r53 = r8.d();
        if (r53 == null) goto L149;
        String r54 = r53.a();
    L150:
        r3.setCheckCallback(r54);
        h r55 = r8.d();
        if (r55 == null) goto L153;
        PrefetchOrder r56 = r55.d();
    L154:
        r3.setPrefetchOrder(r56);
        r3.setCardReqScene(r10);
        if (r10 == null) goto L157;
        r0 = r10.getValue();
    L157:
        if (r0 == null) goto L160;
        r2 = r0;
    L160:
        r3.appendExtraEventParams("popup_scene", r2);
        return r3;
    L153:
        r56 = null;
        goto L154
    L149:
        r54 = null;
        goto L150
    L145:
        r52 = null;
    L141:
        r50 = null;
    L133:
        r46 = "";
    L111:
        g r57 = r8.c();
        if (r57 == null) goto L126;
        List<p0> r58 = r57.a();
        if (r58 == null) goto L126;
        Iterator<T> r59 = r58.iterator();
    L117:
        if (r59.hasNext() == false) goto L126;
        List<IntroBenefit> r120 = ((p0) r59.next()).a();
        if (r120 == null) goto L117;
        Iterator<T> r121 = r120.iterator();
    L122:
        if (r121.hasNext() == false) goto L117;
        r119 = ((IntroBenefit) r121.next()).a();
        if (r119 == null) goto L122;
    L126:
        r119 = null;
    L71:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L73
    L67:
        r34 = null;
        goto L68
    L63:
        r32 = null;
        goto L64
    L59:
        r30 = null;
        goto L60
    L55:
        r28 = null;
        goto L56
    L51:
        r26 = null;
        goto L52
    L47:
        r24 = null;
        goto L48
    L43:
        r22 = null;
        goto L44
    L15:
        r16 = null;
        goto L16
    L8:
        r14 = null;
        goto L9
    }
}
