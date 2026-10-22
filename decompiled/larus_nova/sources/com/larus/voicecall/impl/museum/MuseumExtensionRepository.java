package com.larus.voicecall.impl.museum;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class MuseumExtensionRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MuseumExtensionRepository f378372a = null;

    static {
        f378372a = new MuseumExtensionRepository();
    }

    public MuseumExtensionRepository() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, String r111, Continuation<? super j> r210) {
        if ((r210 instanceof MuseumExtensionRepository$pickExtension$1) == false) goto L7;
        MuseumExtensionRepository$pickExtension$1 r100 = (MuseumExtensionRepository$pickExtension$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MuseumExtensionRepository$pickExtension$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        JSONObject r105 = (JSONObject) r112.L$0;
        ResultKt.throwOnFailure(r102);
    L18:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r102;
        boolean r107 = false;
        String r108 = null;
        if ((r106 instanceof com.larus.network.http.f) == false) goto L22;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("[shortLink][response][fail] path=/alice/call/pick_extension body=");
        r113.append(r105);
        r113.append(" code=");
        com.larus.network.http.f r114 = (com.larus.network.http.f) r106;
        r113.append(r114.f360157d.getCode());
        r113.append(", msg=");
        r113.append(r114.f360157d.getMessage());
        r109.e("MuseumExtensionDebug", r113.toString());
        return new j(false, null, null, BuyNowCloseMethod.NETWORK_ERROR);
    L22:
        i r115 = (i) r106.f360135b;
        boolean r116 = r106 instanceof y;
        if (r116 == false) goto L53;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("[shortLink][response][success] path=/alice/call/pick_extension httpCode=");
        y r119 = (y) r106;
        r118.append(r119.f360205g);
        r118.append(", httpMsg=");
        r118.append(r119.f360204f);
        r118.append(", bizCode=");
        if (r115 == null) goto L27;
        Integer r120 = r115.a();
    L28:
        r118.append(r120);
        r118.append(", bizSuccess=");
        if (r115 == null) goto L31;
        Boolean r121 = r115.e();
    L32:
        r118.append(r121);
        r118.append(", bizMsg=");
        if (r115 == null) goto L35;
        String r122 = r115.d();
    L36:
        r118.append(r122);
        r118.append(", message=");
        if (r115 == null) goto L39;
        String r123 = r115.c();
    L40:
        r118.append(r123);
        r118.append(", grantDuration=");
        if (r115 == null) goto L45;
        h r124 = r115.b();
        if (r124 == null) goto L45;
        Long r125 = r124.b();
    L46:
        r118.append(r125);
        r118.append(", failReason=");
        if (r115 == null) goto L51;
        h r126 = r115.b();
        if (r126 == null) goto L51;
        String r127 = r126.a();
    L52:
        r118.append(r127);
        r118.append(", raw=");
        r118.append(r119.f360136c);
        r117.i(r14, r118.toString());
    L54:
        if (r116 == false) goto L62;
        if (r115 != null) goto L62;
        Long r128 = ((y) r106).f360205g;
        if (r128 == null) goto L62;
        if (r128.longValue() != 0) goto L62;
        boolean r129 = true;
    L63:
        if (r115 == null) goto L65;
        boolean r130 = Intrinsics.areEqual(r115.e(), Boxing.boxBoolean(true));
    L66:
        if (r130 == true) goto L77;
        if (r115 == null) goto L74;
        Integer r131 = r115.a();
        if (r131 == null) goto L74;
        if (r131.intValue() != 0) goto L74;
        boolean r132 = true;
    L75:
        if (r132 == true) goto L77;
        if (r129 == true) goto L77;
    L78:
        FLogger r133 = FLogger.f375446a;
        StringBuilder r134 = new StringBuilder("[shortLink][response][parsed] path=/alice/call/pick_extension success=");
        r134.append(r107);
        r134.append(", emptyBodyAsSuccess=");
        r134.append(r129);
        r134.append(", httpCode=");
        if (r116 == false) goto L81;
        y r135 = (y) r106;
    L82:
        if (r135 == null) goto L84;
        Long r136 = r135.f360205g;
    L85:
        r134.append(r136);
        r134.append(", bizCode=");
        if (r115 == null) goto L88;
        Integer r137 = r115.a();
    L89:
        r134.append(r137);
        r134.append(", bizSuccess=");
        if (r115 == null) goto L92;
        Boolean r138 = r115.e();
    L93:
        r134.append(r138);
        r133.i(r14, r134.toString());
        if (r115 == null) goto L97;
        String r139 = r115.d();
        if (r139 == null) goto L97;
    L100:
        if (r115 == null) goto L104;
        h r140 = r115.b();
        if (r140 == null) goto L104;
        Long r141 = r140.b();
    L105:
        if (r107 == true) goto L143;
        if (r115 == null) goto L141;
        h r142 = r115.b();
        if (r142 == null) goto L112;
        String r143 = r142.a();
    L114:
        if (Intrinsics.areEqual(r143, "already_claimed") == false) goto L117;
    L124:
        r108 = "already_claimed";
    L140:
        if (r108 != null) goto L143;
    L117:
        if (Intrinsics.areEqual(r143, AiBotPollingAuthResult.STATUS_EXPIRED) == true) goto L130;
        Integer r144 = r115.a();
        if (r144 != null) goto L123;
    L125:
        Integer r145 = r115.a();
        if (r145 == null) goto L132;
        if (r145.intValue() == 410) goto L130;
    L132:
        if (Intrinsics.areEqual(r115.e(), Boolean.TRUE) == true) goto L140;
        Integer r146 = r115.a();
        if (r146 != null) goto L137;
    L139:
        r108 = "server_error";
        goto L140
    L137:
        if (r146.intValue() != 0) goto L139;
    L123:
        if (r144.intValue() != 409) goto L125;
    L130:
        r108 = AiBotPollingAuthResult.STATUS_EXPIRED;
        goto L140
    L112:
        r143 = null;
    L141:
        r108 = "server_error";
    L143:
        return new j(r107, r139, r141, r108);
    L104:
        r141 = null;
    L97:
        if (r115 == null) goto L99;
        r139 = r115.c();
        goto L100
    L99:
        r139 = null;
        goto L100
    L92:
        r138 = null;
        goto L93
    L88:
        r137 = null;
        goto L89
    L84:
        r136 = null;
        goto L85
    L81:
        r135 = null;
    L74:
        r132 = false;
    L77:
        r107 = true;
        goto L78
    L65:
        r130 = false;
    L62:
        r129 = false;
    L51:
        r127 = null;
    L45:
        r125 = null;
        goto L46
    L39:
        r123 = null;
        goto L40
    L35:
        r122 = null;
        goto L36
    L31:
        r121 = null;
        goto L32
    L27:
        r120 = null;
        goto L28
    L53:
        FLogger.f375446a.i(r14, "[shortLink][response] path=/alice/call/pick_extension result=" + r106.getClass().getSimpleName() + ", response=" + r115);
        goto L54
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r147 = new JSONObject();
        r147.put("museum_name", r110);
        r147.put("stage", r111);
        FLogger.f375446a.i("MuseumExtensionDebug", "[shortLink][request] path=/alice/call/pick_extension body=" + r147 + ", requestFields=museum_name|stage");
        r112.L$0 = r147;
        r112.label = 1;
        Object r148 = HttpExtKt.k(ServiceType.AUDIO, i.class, "/alice/call/pick_extension", r147, null, null, false, null, null, null, r112, 1008);
        if (r148 != r103) goto L17;
        return r103;
    L17:
        r105 = r147;
        r102 = r148;
    L7:
        r100 = new MuseumExtensionRepository$pickExtension$1(this, r210);
        goto L8
    }
}
