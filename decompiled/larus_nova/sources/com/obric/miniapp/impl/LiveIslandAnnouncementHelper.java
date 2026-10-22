package com.obric.miniapp.impl;

import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.d1;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class LiveIslandAnnouncementHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveIslandAnnouncementHelper f397646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d1 f397647b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f397648c = null;

    public LiveIslandAnnouncementHelper() {
    }

    static {
        f397646a = new LiveIslandAnnouncementHelper();
        f397647b = AudioServiceDelegate.f288288a.i0();
        f397648c = new ConcurrentHashMap();
    }

    public final Object a(JSONObject r210, Continuation<? super Unit> r211) {
        JSONObject r100 = r210;
        if ((r211 instanceof LiveIslandAnnouncementHelper$requestAndPlay$1) == false) goto L7;
        LiveIslandAnnouncementHelper$requestAndPlay$1 r101 = (LiveIslandAnnouncementHelper$requestAndPlay$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (JSONObject) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        k r107 = (k) r103;
        if (r107 != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (r107.f397655a == true) goto L24;
        com.bytedance.ai.utils.g.f37637a.i("LiveIslandAnnouncement", "playAnnouncement skip cause shouldSpeak=false");
    L118:
        return Unit.INSTANCE;
    L24:
        String r108 = r107.f397656b;
        String r109 = null;
        if (r108 == null) goto L27;
        String r110 = StringsKt.trim(r108).toString();
    L28:
        String r111 = "";
        if (r110 != null) goto L32;
        r110 = "";
    L32:
        if (StringsKt.isBlank(r110) == false) goto L34;
        com.bytedance.ai.utils.g.f37637a.i("LiveIslandAnnouncement", "playAnnouncement skip cause speakText is blank");
        goto L118
    L34:
        long r112 = System.currentTimeMillis();
        Long r113 = r107.f397658d;
        if (r113 != null) goto L37;
    L42:
        r113 = null;
    L43:
        if (r113 != null) goto L45;
    L47:
        String r114 = r107.f397657c;
        if (r114 != null) goto L50;
    L54:
        Object r115 = r100.opt("notice_id");
        if (r115 != null) goto L57;
    L83:
        r114 = r109;
    L84:
        if (r114 == null) goto L108;
        Iterator<Map.Entry<String, Long>> r116 = f397648c.entrySet().iterator();
    L87:
        if (r116.hasNext() == false) goto L91;
        if (r116.next().getValue().longValue() > r112) goto L87;
        r116.remove();
        goto L87
    L91:
        ConcurrentHashMap<String, Long> r117 = f397648c;
        Long r118 = r117.get(r114);
        if (r118 != null) goto L94;
    L96:
        if (r113 == null) goto L98;
        long r119 = r113.longValue();
    L99:
        r117.put(r114, Long.valueOf(r119));
        if (r117.size() <= 128) goto L105;
        String r120 = (String) CollectionsKt.firstOrNull(r117.keySet());
        if (r120 == null) goto L105;
        Long r121 = r117.remove(r120);
    L105:
        r106 = false;
    L106:
        if (r106 == false) goto L108;
        com.bytedance.ai.utils.g.f37637a.i("LiveIslandAnnouncement", "playAnnouncement skip duplicate dedupeKey=".concat(r114));
        goto L118
    L98:
        r119 = 600000 + r112;
        goto L99
    L94:
        if (r118.longValue() <= r112) goto L96;
    L108:
        d1 r122 = f397647b;
        String r123 = "live_island_" + System.currentTimeMillis();
        StringBuilder r124 = new StringBuilder("live_island_");
        if (r114 != null) goto L111;
        Object r125 = Long.valueOf(System.currentTimeMillis());
    L112:
        r124.append(r125);
        d1.a.a(r122, r123, null, r110, true, null, r124.toString(), null, false, true, null, null, null, null, 3792);
        com.bytedance.ai.utils.g r126 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r127 = new StringBuilder("playAnnouncement start tts dedupeKey=");
        if (r114 == null) goto L116;
        r111 = r114;
    L116:
        r127.append(r111);
        r127.append(" textLen=");
        r127.append(r110.length());
        r126.i("LiveIslandAnnouncement", r127.toString());
        goto L118
    L111:
        r125 = r114;
        goto L112
    L57:
        if ((!Intrinsics.areEqual(r115, JSONObject.NULL)) == true) goto L60;
        r115 = null;
    L60:
        if (r115 == null) goto L83;
        String r128 = r115.toString();
        if (r128 == null) goto L83;
        if ((!StringsKt.isBlank(r128)) == true) goto L67;
        r128 = null;
    L67:
        if (r128 == null) goto L83;
        Object r129 = r100.opt("status");
        if (r129 == null) goto L83;
        if ((!Intrinsics.areEqual(r129, JSONObject.NULL)) == true) goto L74;
        r129 = null;
    L74:
        if (r129 == null) goto L83;
        String r130 = r129.toString();
        if (r130 == null) goto L83;
        if ((!StringsKt.isBlank(r130)) == true) goto L81;
        r130 = null;
    L81:
        if (r130 == null) goto L83;
        r109 = "notice_" + r128 + "_status_" + r130;
        goto L83
    L50:
        if ((!StringsKt.isBlank(r114)) == true) goto L53;
        r114 = null;
    L53:
        if (r114 != null) goto L84;
    L45:
        if (r112 <= r113.longValue()) goto L47;
        com.bytedance.ai.utils.g.f37637a.i("LiveIslandAnnouncement", "playAnnouncement skip cause expired expireAtMs=" + r113);
        goto L118
    L37:
        if (r113.longValue() <= 0) goto L39;
        boolean r131 = true;
    L40:
        if (r131 == false) goto L42;
    L39:
        r131 = false;
        goto L40
    L27:
        r110 = null;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = b(r100, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new LiveIslandAnnouncementHelper$requestAndPlay$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(JSONObject r100, Continuation<? super k> r101) {
        if ((r101 instanceof LiveIslandAnnouncementHelper$requestAnnouncement$1) == false) goto L7;
        LiveIslandAnnouncementHelper$requestAnnouncement$1 r102 = (LiveIslandAnnouncementHelper$requestAnnouncement$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L38:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r104;
        if (r107 != null) goto L43;
        com.bytedance.ai.utils.g.f37637a.w("LiveIslandAnnouncement", "requestAnnouncement timeout after 3000ms path=https://platform-api.obriccloud.com/ocean/island/v1/get_tts_text");
        return null;
    L43:
        if ((r107 instanceof y) == false) goto L59;
        l r108 = (l) ((y) r107).f360135b;
        if (r108 != null) goto L47;
        com.bytedance.ai.utils.g.f37637a.i("LiveIslandAnnouncement", "requestAnnouncement success but body is null");
        return null;
    L47:
        Boolean r109 = r108.d();
        if (r109 != null) goto L52;
        r109 = r108.c();
        if (r109 != null) goto L52;
        boolean r110 = false;
    L54:
        String r111 = r108.e();
        if (r111 != null) goto L64;
        r111 = r108.f();
    L64:
        return new k(r110, r111, r108.a(), r108.b());
    L52:
        r110 = r109.booleanValue();
        goto L54
    L59:
        if ((r107 instanceof com.larus.network.http.f) == false) goto L61;
        com.bytedance.ai.utils.g r112 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r113 = new StringBuilder("requestAnnouncement failed code=");
        com.larus.network.http.f r114 = (com.larus.network.http.f) r107;
        r113.append(r114.f360157d.getCode());
        r113.append(" msg=");
        r113.append(r114.f360157d.getMessage());
        r112.w("LiveIslandAnnouncement", r113.toString());
        return null;
    L61:
        com.bytedance.ai.utils.g.f37637a.w("LiveIslandAnnouncement", "requestAnnouncement unknown response=" + r107);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        LinkedHashMap r115 = new LinkedHashMap();
        AccountService r116 = AccountService.f365697a;
        String r117 = r116.getXTTToken();
        if (r117 != null) goto L18;
        r117 = "";
    L18:
        if ((!StringsKt.isBlank(r117)) == true) goto L21;
        r117 = null;
    L21:
        if (r117 == null) goto L23;
        String r118 = (String) r115.put(LoginVerifyService.X_TT_TOKEN, r117);
    L23:
        String r119 = r116.getUserId();
        if ((!StringsKt.isBlank(r119)) == true) goto L27;
        r119 = null;
    L27:
        if (r119 == null) goto L29;
        String r120 = (String) r115.put("user_id", r119);
    L29:
        String r121 = o.f365780a.getDeviceId();
        if ((!StringsKt.isBlank(r121)) == true) goto L33;
        r121 = null;
    L33:
        if (r121 == null) goto L35;
        r115.put("device_id", r121);
    L35:
        LiveIslandAnnouncementHelper$requestAnnouncement$response$1 r122 = new LiveIslandAnnouncementHelper$requestAnnouncement$response$1(r100, r115, null);
        r102.label = 1;
        r104 = TimeoutKt.c(3000, r122, r102);
        if (r104 != r105) goto L38;
        return r105;
    L7:
        r102 = new LiveIslandAnnouncementHelper$requestAnnouncement$1(this, r101);
        goto L8
    }
}
