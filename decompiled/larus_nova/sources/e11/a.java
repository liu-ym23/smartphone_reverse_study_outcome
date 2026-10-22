package e11;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.link.model.f;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import d11.h;
import d11.i;
import d11.j;
import d11.k;
import d11.l;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b {
    public a() {
    }

    public static void k(Map r100, uz0.c r101) {
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        Iterator r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L8;
        String r107 = r106.toString();
    L9:
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        Intrinsics.checkNotNullParameter(r105, "$this$setTo");
        r102.put(r105, r107);
        goto L4
    L8:
        r107 = null;
        goto L9
    }

    public final Observable<ExtraResponse<f, Extra>> c(h r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110.getRoomId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("room_id", r103);
    L5:
        String r104 = Long.valueOf(r110.getToRoomId()).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("to_room_id", r104);
    L8:
        String r105 = Long.valueOf(r110.getApplyType()).toString();
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, "$this$setTo");
        if (r105 == null) goto L11;
        r102.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, r105);
    L11:
        String r106 = Long.valueOf(r110.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r106 == null) goto L14;
        r102.put("scene", r106);
    L14:
        String r107 = Long.valueOf(r110.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r107 == null) goto L17;
        r102.put("channel_id", r107);
    L17:
        String r108 = r110.getClientAttachedInfo();
        Intrinsics.checkNotNullParameter("client_attached_info", "$this$setTo");
        if (r108 == null) goto L20;
        r102.put("client_attached_info", r108);
    L20:
        int r109 = f11.a.f475050a;
        r110.l();
        Intrinsics.checkNotNullParameter(r110, "$this$revUserId");
        String r112 = r110.getToOpenId();
        HashMap r113 = new HashMap();
        if (r112 != null) goto L23;
        r112 = "";
    L23:
        r113.put("to_open_id", r112);
        if (r111 == null) goto L26;
        r113.putAll(r111);
    L26:
        k(r113, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/apply/", TypesJVMKt.getJavaType(Reflection.typeOf(f.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    public final Observable<ExtraResponse<Object, Extra>> d(i r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("channel_id", r103);
    L5:
        String r104 = Long.valueOf(r110.getToRoomId()).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("to_room_id", r104);
    L8:
        String r105 = Long.valueOf(r110.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r105 == null) goto L11;
        r102.put("scene", r105);
    L11:
        String r106 = Integer.valueOf(r110.getCancelType()).toString();
        Intrinsics.checkNotNullParameter("cancel_type", "$this$setTo");
        if (r106 == null) goto L14;
        r102.put("cancel_type", r106);
    L14:
        String r107 = r110.getRequestSource();
        String r108 = "";
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r102.put("request_source", r107);
        int r109 = f11.a.f475050a;
        Intrinsics.checkNotNullParameter(r110, "$this$toRevUid");
        String r112 = r110.getToOpenId();
        r110.l();
        Pair[] r113 = new Pair[1];
        if (r112 == null) goto L21;
        r108 = r112;
    L21:
        r113[0] = TuplesKt.to("to_open_id", r108);
        Map r114 = MapsKt.mutableMapOf(r113);
        if (r111 != null) goto L24;
        r111 = MapsKt.emptyMap();
    L24:
        r114.putAll(r111);
        k(r114, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/cancel/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    public final Observable<ExtraResponse<m0, Extra>> g(j r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        uz0.f r102 = new uz0.f(r101.f552161b);
        r102.a("to_room_id", Long.valueOf(r110.getToRoomId()).toString());
        r102.a("room_id", Long.valueOf(r110.getRoomId()).toString());
        r102.a("invite_type", Long.valueOf(r110.getInviteType()).toString());
        r102.a(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, r110.getMatchType());
        r102.a("scene", Long.valueOf(r110.getScene()).toString());
        String r103 = r110.getTheme();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.a("theme", r103);
        r102.a("duration", Long.valueOf(r110.getDuration()).toString());
        String r105 = r110.getActivityName();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.a("activity_name", r105);
        r102.a("match_sub_type", Integer.valueOf(r110.p1()).toString());
        r102.a("invite_source", Integer.valueOf(r110.getInviteSource()).toString());
        r102.a("invitee_scene", Long.valueOf(r110.y5()).toString());
        r102.a("multi_pk_mode", Integer.valueOf(r110.getMultiPkMode()).toString());
        String r106 = r110.getBattleConfigSetting();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102.a("battle_config_setting", r106);
        String r107 = r110.getBattleAttachedInfo();
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        r102.a("battle_attached_info", r107);
        r102.a("invite_status", Integer.valueOf(r110.getInviteStatus()).toString());
        r102.a("client_attached_info", r110.getClientAttachedInfo());
        String r108 = r110.s();
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r102.a("open_game_app_id", r108);
        if (r110.j() <= 0) goto L21;
        r102.a("bitrate_kbps", Long.valueOf(r110.j()).toString());
    L21:
        if (r110.K() <= 0) goto L24;
        r102.a("resolution_width", Long.valueOf(r110.K()).toString());
    L24:
        if (r110.x() <= 0) goto L26;
        r102.a("resolution_height", Long.valueOf(r110.x()).toString());
    L26:
        r102.a("channel_id", Long.valueOf(r110.getChannelId()).toString());
        r102.a("biz_type", Integer.valueOf(r110.getBizType()).toString());
        int r109 = f11.a.f475050a;
        Intrinsics.checkNotNullParameter(r110, "$this$toRevUid");
        String r112 = r110.getToOpenId();
        r110.l();
        Intrinsics.checkNotNullParameter(r110, "$this$inviteeUserIds");
        List r113 = StringsKt.split$default(r110.Q6(), new String[]{","}, false, 0, 6, null);
        HashMap r114 = new HashMap();
        if (r112 != null) goto L29;
        r112 = "";
    L29:
        r114.put("to_open_id", r112);
        if (r113 == null) goto L32;
        String r115 = CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, null, 62, null);
    L33:
        if (r115 == null) goto L36;
        r104 = r115;
    L36:
        r114.put("invitee_followed_user_ids", r104);
        if (r111 == null) goto L40;
        r114.putAll(r111);
    L40:
        if (r114.isEmpty() == false) goto L42;
        r114 = null;
    L42:
        if (r114 == null) goto L44;
        k(r114, r101);
    L44:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/invite/", TypesJVMKt.getJavaType(Reflection.typeOf(m0.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L32:
        r115 = null;
        goto L33
    }

    public final Observable<ExtraResponse<v, Extra>> j(k r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("channel_id", r103);
    L5:
        String r104 = Long.valueOf(r110.Z3()).toString();
        Intrinsics.checkNotNullParameter("permit_status", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("permit_status", r104);
    L8:
        String r105 = Long.valueOf(r110.getRoomId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r105 == null) goto L11;
        r102.put("room_id", r105);
    L11:
        String r106 = Long.valueOf(r110.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r106 == null) goto L14;
        r102.put("scene", r106);
    L14:
        int r107 = f11.a.f475050a;
        Intrinsics.checkNotNullParameter(r110, "$this$applyRevUid");
        String r108 = r110.Z0();
        r110.j7();
        Pair[] r112 = new Pair[1];
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r112[0] = TuplesKt.to("apply_open_id", r108);
        Map r113 = MapsKt.mutableMapOf(r112);
        if (r111 != null) goto L20;
        r111 = MapsKt.emptyMap();
    L20:
        r113.putAll(r111);
        k(r113, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/permit/", TypesJVMKt.getJavaType(Reflection.typeOf(v.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    public final Observable<ExtraResponse<d1, Extra>> l(l r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        uz0.f r102 = new uz0.f(r101.f552161b);
        r102.a("channel_id", Long.valueOf(r110.getChannelId()).toString());
        r102.a("room_id", Long.valueOf(r110.getRoomId()).toString());
        r102.a("reply_status", Long.valueOf(r110.getReplyStatus()).toString());
        r102.a("scene", Long.valueOf(r110.getScene()).toString());
        r102.a("multi_pk_mode", Integer.valueOf(r110.getMultiPkMode()).toString());
        r102.a("switch_play_mode", Integer.valueOf(r110.getSwitchPlayMode()).toString());
        r102.a(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, Long.valueOf(r110.getMatchType()).toString());
        String r103 = r110.getClientAttachedInfo();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.a("client_attached_info", r103);
        if (r110.s().length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r102.a("open_game_app_id", r110.s());
    L12:
        if (r110.j() <= 0) goto L15;
        r102.a("bitrate_kbps", Long.valueOf(r110.j()).toString());
    L15:
        if (r110.K() <= 0) goto L18;
        r102.a("resolution_width", Long.valueOf(r110.K()).toString());
    L18:
        if (r110.x() <= 0) goto L20;
        r102.a("resolution_height", Long.valueOf(r110.x()).toString());
    L20:
        r102.a("biz_type", Integer.valueOf(r110.getBizType()).toString());
        int r106 = f11.a.f475050a;
        Intrinsics.checkNotNullParameter(r110, "$this$inviteRevUid");
        String r107 = r110.V5();
        r110.N8();
        Pair[] r112 = new Pair[1];
        if (r107 == null) goto L24;
        r104 = r107;
    L24:
        r112[0] = TuplesKt.to("invite_open_id", r104);
        Map r113 = MapsKt.mutableMapOf(r112);
        if (r111 != null) goto L27;
        r111 = MapsKt.emptyMap();
    L27:
        r113.putAll(r111);
        k(r113, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(d1.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L8:
        r105 = false;
        goto L9
    }

    public final Observable<ExtraResponse<a7, Extra>> f(long r110, long r111, int r112) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r113 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r113 == null) goto L5;
        r102.put("channel_id", r113);
    L5:
        String r114 = Long.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r114 == null) goto L8;
        r102.put("room_id", r114);
    L8:
        String r115 = Integer.valueOf(r112).toString();
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        if (r115 == null) goto L11;
        r102.put("request_source", r115);
    L11:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/get_cross_room_rtc_info/", TypesJVMKt.getJavaType(Reflection.typeOf(a7.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    @Override // e11.b
    public final Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r110, String r111, int r112) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r113 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r113 == null) goto L5;
        r102.put("channel_id", r113);
    L5:
        if (r111 != null) goto L7;
        r111 = "";
    L7:
        Intrinsics.checkNotNullParameter("content", "$this$setTo");
        r102.put("content", r111);
        String r114 = Integer.valueOf(r112).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r114 == null) goto L10;
        r102.put("scene", r114);
    L10:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/send_signal/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    public final Observable h(long r110, int r111, int r112, int r113) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r114 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r114 == null) goto L5;
        r102.put("channel_id", r114);
    L5:
        String r115 = Integer.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("is_from_audience", "$this$setTo");
        if (r115 == null) goto L8;
        r102.put("is_from_audience", r115);
    L8:
        String r116 = Integer.valueOf(r112).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r116 == null) goto L11;
        r102.put("scene", r116);
    L11:
        Long r117 = 0L;
        String r118 = r117.toString();
        Intrinsics.checkNotNullParameter("resource_id", "$this$setTo");
        if (r118 == null) goto L14;
        r102.put("resource_id", r118);
    L14:
        String r119 = Integer.valueOf(r113).toString();
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, "$this$setTo");
        if (r119 == null) goto L17;
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, r119);
    L17:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/join_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.link.model.bridge.f.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    }

    public final Observable<ExtraResponse<n0, Extra>> a(long r110, int r111, String r112, long r113, int r114) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("channel_id", r103);
    L5:
        String r104 = Integer.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("scene", r104);
    L8:
        if (r112 != null) goto L10;
        String r105 = "";
    L11:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r102.put("request_source", r105);
        String r106 = Long.valueOf(r113).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r106 == null) goto L14;
        r102.put("room_id", r106);
    L14:
        String r107 = Integer.valueOf(r114).toString();
        Intrinsics.checkNotNullParameter("leave_source", "$this$setTo");
        if (r107 == null) goto L17;
        r102.put("leave_source", r107);
    L17:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/leave/", TypesJVMKt.getJavaType(Reflection.typeOf(n0.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L10:
        r105 = r112;
        goto L11
    }

    public final Observable<ExtraResponse<Object, Extra>> e(long r110, int r111, int r112, String r113, String r114) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("channel_id", r103);
    L5:
        String r104 = Integer.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("is_to_audience", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("is_to_audience", r104);
    L8:
        String r105 = Integer.valueOf(r112).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r105 == null) goto L11;
        r102.put("scene", r105);
    L11:
        if (r113 != null) goto L13;
        String r106 = "";
    L14:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r102.put("request_source", r106);
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        r102.put("room_id", r114);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/finish/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L13:
        r106 = r113;
        goto L14
    }

    public final Observable<ExtraResponse<Object, Extra>> b(long r100, long r101, String r102, String r110, long r111, String r112) {
        Intrinsics.checkNotNullParameter(r102, "linkmicId");
        Intrinsics.checkNotNullParameter(r110, "rtcInfo");
        Intrinsics.checkNotNullParameter(r112, "requestSource");
        tz0.b r103 = tz0.b.f548039a;
        uz0.c r104 = new uz0.c();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "$this$beforeConfigureRequest");
        Map<String, String> r105 = r104.f552161b;
        Intrinsics.checkNotNullParameter(r105, "queriesMap");
        String r106 = Long.valueOf(r100).toString();
        Intrinsics.checkNotNullParameter("linker_id", "$this$setTo");
        if (r106 == null) goto L5;
        r105.put("linker_id", r106);
    L5:
        String r107 = Long.valueOf(r101).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r107 == null) goto L8;
        r105.put("room_id", r107);
    L8:
        Intrinsics.checkNotNullParameter("linkmic_id", "$this$setTo");
        r105.put("linkmic_id", r102);
        Intrinsics.checkNotNullParameter("rtc_ext_info", "$this$setTo");
        r105.put("rtc_ext_info", r110);
        String r108 = Long.valueOf(r111).toString();
        Intrinsics.checkNotNullParameter("mix_type", "$this$setTo");
        if (r108 == null) goto L11;
        r105.put("mix_type", r108);
    L11:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r105.put("request_source", r112);
        Intrinsics.checkNotNullParameter(r104, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/media_info_change_call_back/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r104.f552163d, r104.f552160a, r104.f552161b, r104.f552162c);
    }

    public final Observable<ExtraResponse<Object, Extra>> i(long r110, String r111, String r112, int r113, String r114, int r115) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r103 == null) goto L5;
        r102.put("channel_id", r103);
    L5:
        String r104 = Integer.valueOf(r113).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r104 == null) goto L8;
        r102.put("scene", r104);
    L8:
        String r105 = "";
        if (r114 != null) goto L11;
        String r106 = "";
    L12:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r102.put("request_source", r106);
        String r107 = Integer.valueOf(r115).toString();
        Intrinsics.checkNotNullParameter("kick_out_source", "$this$setTo");
        if (r107 == null) goto L15;
        r102.put("kick_out_source", r107);
    L15:
        int r108 = f11.a.f475050a;
        Pair[] r109 = new Pair[2];
        if (r111 != null) goto L18;
        String r116 = "";
    L19:
        r109[0] = TuplesKt.to("to_open_id", r116);
        if (r112 == null) goto L23;
        r105 = r112;
    L23:
        r109[1] = TuplesKt.to("sec_to_user_id", r105);
        Map r117 = MapsKt.mapOf(r109);
        if (r117 == null) goto L26;
        k(r117, r101);
    L26:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/kick_out/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L18:
        r116 = r111;
        goto L19
    L11:
        r106 = r114;
        goto L12
    }

    @Override // e11.b
    public final Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r110, long r111, long r112, long r113, int r114, boolean r115, String r210, long r211) {
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        uz0.f r102 = new uz0.f(r101.f552161b);
        r102.a("channel_id", Long.valueOf(r110).toString());
        r102.a("link_status", Long.valueOf(r111).toString());
        r102.a("offset", Long.valueOf(r112).toString());
        r102.a("count", Long.valueOf(r113).toString());
        r102.a("scene", Integer.valueOf(r114).toString());
        r102.a("use_local_cache", String.valueOf(r115));
        if (r210 != null) goto L5;
        String r103 = "";
    L6:
        r102.a("request_source", r103);
        r102.a("room_id", Long.valueOf(r211).toString());
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/list/", TypesJVMKt.getJavaType(Reflection.typeOf(r.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c);
    L5:
        r103 = r210;
        goto L6
    }
}
