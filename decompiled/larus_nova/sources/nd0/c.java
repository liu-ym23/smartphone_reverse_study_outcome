package nd0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.EventConstant;
import cy0.j;
import java.util.Iterator;
import jc1.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f518746a = null;

    static {
        f518746a = new c();
    }

    public static MultiLinkEventModule l() {
        Integer r100 = Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene());
        m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L7;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L7;
        boolean r103 = r102.isLiveTypeAudio();
    L9:
        return m(r100, Boolean.valueOf(r103));
    L7:
        r103 = false;
        goto L9
    }

    public c() {
    }

    public static MultiLinkEventType n(String r100) {
        MultiLinkEventType r101 = MultiLinkEventType.SERVER_API_CALL;
        if (Intrinsics.areEqual(r100, r101.name()) == false) goto L5;
        return r101;
    L5:
        if (Intrinsics.areEqual(r100, r101.getName()) == true) goto L32;
        MultiLinkEventType r102 = MultiLinkEventType.SDK_CALLBACK;
        if (Intrinsics.areEqual(r100, r102.name()) == false) goto L10;
        return r102;
    L10:
        if (Intrinsics.areEqual(r100, r102.getName()) == true) goto L33;
        MultiLinkEventType r103 = MultiLinkEventType.BUSSINESS_API_CALL;
        if (Intrinsics.areEqual(r100, r103.name()) == false) goto L15;
        return r103;
    L15:
        if (Intrinsics.areEqual(r100, r103.getName()) == true) goto L34;
        MultiLinkEventType r104 = MultiLinkEventType.MESSAGE_RECEIVED;
        if (Intrinsics.areEqual(r100, r104.name()) == true) goto L27;
        if (Intrinsics.areEqual(r100, r104.getName()) == true) goto L27;
        r104 = MultiLinkEventType.SDK_INTERFACE_CALL;
        if (Intrinsics.areEqual(r100, r104.name()) == true) goto L27;
        if (Intrinsics.areEqual(r100, r104.getName()) == true) goto L27;
        return r103;
    L27:
        return r104;
    L34:
        return r103;
    L33:
        return r102;
    L32:
        return r101;
    }

    public static String u(MultiLinkEventType r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        int r101 = b.f518745a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "server_api_name";
    L5:
        if (r101 != 2) goto L7;
        return "server_message_name";
    L7:
        if (r101 != 3) goto L9;
        return "sdk_api_name";
    L9:
        if (r101 != 4) goto L11;
        return "sdk_callback_name";
    L11:
        if (r101 != 5) goto L14;
        return "business_api_name";
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public static MultiLinkEventModule m(Integer r100, Boolean r101) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        if (r100 != null) goto L20;
    L22:
        if (r100 == null) goto L31;
        if (r100.intValue() != 16) goto L31;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L36;
        return MultiLinkEventModule.MULTI_AUDIO;
    L36:
        return MultiLinkEventModule.BIG_PARTY;
    L31:
        return MultiLinkEventModule.common;
    L20:
        if (r100.intValue() != 9) goto L22;
        return MultiLinkEventModule.KTV;
    L15:
        if (r100.intValue() != 12) goto L17;
    L33:
        return MultiLinkEventModule.BIG_PARTY;
    L10:
        if (r100.intValue() != 8) goto L12;
    L5:
        if (r100.intValue() != 5) goto L7;
        return MultiLinkEventModule.MULTI_AUDIO;
    }

    public static Pair t(Throwable r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        int r102 = -1;
        String r103 = "";
        if (r100 != null) goto L5;
    L41:
        BaseMonitor.add(r101, "error_code", r102);
        BaseMonitor.add(r101, "error_msg", r103);
        return new Pair(Integer.valueOf(r102), r103);
    L5:
        if ((r100 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r104 = (CustomApiServerException) r100;
        BaseMonitor.add(r101, "detail_url", r104.getUrl());
        BaseMonitor.add(r101, "log_id", r104.getXTtLogId());
    L8:
        if ((r100 instanceof ApiServerException) == false) goto L26;
        ApiServerException r105 = (ApiServerException) r100;
        String r106 = r105.getErrorMsg();
        if (r106 == null) goto L26;
        if (r106.length() <= 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 != true) goto L26;
        r102 = r105.getErrorCode();
        String r108 = r105.getErrorMsg();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        String r109 = r105.getPrompt();
        if (r109 == null) goto L23;
        r103 = r109;
    L23:
        BaseMonitor.add(r101, EventConstant.Key.RETAIN_PROMPT, r103);
    L24:
        r103 = r108;
        goto L41
    L14:
        r107 = false;
    L26:
        if ((r100 instanceof ApiException) == false) goto L31;
        r102 = ((ApiException) r100).getErrorCode();
        r108 = r100.getMessage();
        if (r108 != null) goto L24;
    L31:
        if ((r100 instanceof NetworkErrorException) == false) goto L36;
        r102 = ((NetworkErrorException) r100).statusCode;
        r108 = r100.getMessage();
        if (r108 != null) goto L24;
    L36:
        if ((r100 instanceof Exception) == false) goto L40;
        r108 = r100.getMessage();
        if (r108 != null) goto L24;
    L40:
        r108 = r100.toString();
        goto L24
    }

    public final void q(LinkMonitorData r110, MultiLinkEventModule r111, long r112, Throwable r113, JSONObject r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r111, "eventModule");
        Intrinsics.checkNotNullParameter(r114, "extra");
        BaseMonitor.add(r114, "duration", r112);
        Pair r100 = t(r113, r114);
        p(this, r110, r114, r111, ((Number) r100.getFirst()).intValue(), (String) r100.getSecond(), r115, null, 64);
    }

    public static void o(c r110, LinkMonitorData r111, JSONObject r112, int r113, String r114, boolean r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r116 & 16) == 0) goto L13;
        boolean r102 = false;
    L14:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r112, "extra");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        p(r110, r111, r112, l(), r100, r101, r102, null, 64);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ void r(c r100, LinkMonitorData r101, MultiLinkEventModule r110, long r111, Throwable r112, JSONObject r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        r100.getClass();
        r110 = l();
    L5:
        r100.q(r101, r110, r111, r112, r113, false);
    }

    public static void s(c r110, LinkMonitorData r111, MultiLinkEventModule r112, long r113, String r114, JSONObject r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        r110.getClass();
        MultiLinkEventModule r100 = l();
    L7:
        if ((r116 & 32) == 0) goto L9;
        JSONObject r101 = new JSONObject();
    L10:
        JSONObject r102 = r101;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r114, "logId");
        Intrinsics.checkNotNullParameter(r115, "extra");
        Intrinsics.checkNotNullParameter(r102, "metrics");
        BaseMonitor.add(r115, "duration", r113);
        BaseMonitor.add(r115, "log_id", r114);
        p(r110, r111, r115, r100, 0, null, false, r102, 24);
        return;
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = r112;
        goto L7
    }

    public static void p(c r210, LinkMonitorData r211, JSONObject r212, MultiLinkEventModule r213, int r214, String r215, boolean r216, JSONObject r217, int r310) {
        if ((r310 & 4) == 0) goto L5;
        r210.getClass();
        MultiLinkEventModule r100 = l();
    L7:
        if ((r310 & 8) == 0) goto L9;
        int r110 = 0;
    L11:
        if ((r310 & 16) == 0) goto L13;
        String r111 = "";
    L15:
        if ((r310 & 32) == 0) goto L17;
        boolean r101 = false;
    L19:
        if ((r310 & 64) == 0) goto L21;
        JSONObject r102 = new JSONObject();
    L22:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r211, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r212, "extra");
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        Intrinsics.checkNotNullParameter(r102, "metrics");
        Intrinsics.checkNotNullParameter(r211, "linkMonitorData");
        BaseMonitor.add(r212, u(r211.getEventType()), r211.getEventTypeValue());
        if (r211.getNeedRoomCommonParams() == false) goto L26;
        od0.c.a(r212);
    L26:
        if (r211.getNeedLinkCommonParams() == false) goto L29;
        od0.a.a(r212);
    L29:
        if (r211.getNeedTalkRoomCommonParams() == false) goto L31;
        od0.d.a(r212);
    L31:
        BaseMonitor.add(r102, "phone_score", String.valueOf(((Number) vm2.g.f556078d.getValue(null, vm2.g.f556075a[2])).floatValue()));
        int r103 = rd0.b.f537203a;
        String r112 = r211.getServiceName();
        JSONObject r113 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        String r106 = r100.getName();
        Intrinsics.checkNotNullParameter(r106, "eventModuleString");
        String r107 = r211.getEventType().getName();
        Intrinsics.checkNotNullParameter(r107, "eventTypeString");
        r104.put("status_code", String.valueOf(r110));
        r105.put("status_code", String.valueOf(r110));
        Intrinsics.checkNotNullParameter(r111, "string");
        r105.put("status_message", r111);
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator<String> r108 = r212.keys();
    L33:
        if (r108.hasNext() == false) goto L35;
        String r114 = r108.next();
        Object r109 = r212.get(r114);
        Intrinsics.checkNotNullParameter(r114, "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put(r114, r109);
        goto L33
    L35:
        cy0.e.f465759a.getClass();
        j r115 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r116 = com.bytedance.android.scope.m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r116);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r116)).g(r112, r106, r107, r113, r104, r105);
        if (r101 == true) goto L43;
        pd0.b r117 = pd0.b.f528640a;
        String r118 = r211.getServiceName();
        Intrinsics.checkNotNullParameter(r118, "serviceName");
        boolean r119 = false;
        if (StringsKt.contains$default(r118, "ttlive_multi_revenue_", false, 2, null) == false) goto L40;
        boolean r120 = ((Boolean) vm2.e.f556068y.getValue(null, vm2.e.f556037a[23])).booleanValue();
    L41:
        if (r120 == true) goto L44;
    L45:
        pd0.b r121 = pd0.b.f528640a;
        Intrinsics.checkNotNullParameter(r211, "linkMonitorData");
        if (((Boolean) vm2.e.f556067x.getValue(null, vm2.e.f556037a[22])).booleanValue() == true) goto L49;
    L59:
        if (r119 == false) goto L63;
        jy0.b.d("LinkService", "event: " + r211.getEventTypeValue() + ", status_code: " + r110 + ", status_msg: " + r111);
        jy0.b.d("LinkService", r212.toString());
        int r122 = rd0.a.f537202a;
        rd0.a.c(r211, ProductId.CHAT_CHANNEL, "chat_channel_link", r212, r100, r110, r111);
        return;
    L63:
        return;
    L49:
        if (Intrinsics.areEqual(r211.getServiceName(), "ttlive_channel_link_business_logic") == false) goto L51;
    L58:
        r119 = true;
        goto L59
    L51:
        if (Intrinsics.areEqual(r211.getServiceName(), "ttlive_channel_link_server_api_call") == true) goto L58;
        if (Intrinsics.areEqual(r211.getServiceName(), "ttlive_channel_link_im_message_received") == true) goto L58;
        if (Intrinsics.areEqual(r211.getServiceName(), "ttlive_channel_link_sdk_api_call") == true) goto L58;
        if (Intrinsics.areEqual(r211.getServiceName(), "ttlive_channel_link_sdk_callback") == false) goto L59;
    L44:
        int r123 = rd0.a.f537202a;
        rd0.a.c(r211, ProductId.MULTI_SCENE, "client_multi_scene", r212, r100, r110, r111);
        goto L45
    L40:
        r120 = false;
        goto L41
    L43:
        r119 = false;
        goto L44
    L21:
        r102 = r217;
        goto L22
    L17:
        r101 = r216;
        goto L19
    L13:
        r111 = r215;
        goto L15
    L9:
        r110 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
