package p21;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f527374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f527375b;

    public final Map<String, String> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r101 = this.f527375b;
        d31.d r102 = null;
        if (r101 == null) goto L5;
        g r103 = r101.getMultiAnchorLinkContextObj();
    L6:
        if (r103 == null) goto L8;
        Long r104 = Long.valueOf(r103.a());
    L9:
        int r105 = 0;
        long r106 = 0;
        if (r104 != null) goto L12;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r107 = this.f527375b;
        if (r107 == null) goto L16;
        g r108 = r107.getMultiAnchorLinkContextObj();
    L17:
        if (r108 == null) goto L25;
        com.bytedance.android.live.revlink.impl.global.c r109 = r108.f95051a;
        if (r109 == null) goto L21;
        LinkCrossRoomDataHolder r110 = r109.getLinkCrossRoomDataHolder();
    L22:
        if (r110 == null) goto L24;
        r106 = r110.c();
    L24:
        Long r111 = Long.valueOf(r106);
    L26:
        com.bytedance.android.live.revlink.impl.global.c r112 = this.f527375b;
        if (r112 == null) goto L29;
        z r113 = r112.getMultiPkMonitor();
    L30:
        if (r113 == null) goto L32;
        z.y(r113, "link_log_param_channel_id_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("originChannelId", String.valueOf(r104)), TuplesKt.to(RemoteMessageConst.Notification.CHANNEL_ID, String.valueOf(r111))}), null, 12);
    L32:
        r104 = r111;
    L33:
        r100.put("channel_id", String.valueOf(r104));
        com.bytedance.android.live.revlink.impl.global.c r114 = this.f527375b;
        if (r114 == null) goto L36;
        s r115 = r114.getRevLinkCommonUtil();
    L37:
        if (r115 == null) goto L39;
        String r116 = r115.e();
    L40:
        r100.put("user_id", String.valueOf(r116));
        com.bytedance.android.livesdk.revenue.service.room.c r117 = this.f527374a;
        if (r117 == null) goto L47;
        com.bytedance.android.livesdk.revenue.room.a r118 = r117.getRoomContext();
        if (r118 == null) goto L47;
        if (r118.getCommonIsAnchor() != true) goto L47;
        String r119 = "1";
    L48:
        r100.put(IPerformanceManager.Params.is_anchor, r119);
        com.bytedance.android.live.revlink.impl.global.c r120 = this.f527375b;
        if (r120 == null) goto L51;
        LinkCrossRoomDataHolder r121 = r120.getLinkCrossRoomDataHolder();
    L52:
        if (r121 == null) goto L54;
        String r122 = r121.g();
    L55:
        String r123 = "";
        if (r122 != null) goto L58;
        r122 = "";
    L58:
        r100.put("invitee_id", r122);
        com.bytedance.android.live.revlink.impl.global.c r124 = this.f527375b;
        if (r124 == null) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r125 = r124.R8();
    L62:
        if (r125 == null) goto L66;
        i11.b r126 = r125.getLinkUserCenter();
        if (r126 == null) goto L66;
        Integer r127 = Integer.valueOf(r126.c());
    L67:
        r100.put("anchor_connect_status", String.valueOf(r127));
        com.bytedance.android.live.revlink.impl.global.c r128 = this.f527375b;
        if (r128 == null) goto L70;
        q r129 = r128.getMultiAnchorLinkLogUtils();
    L71:
        if (r129 == null) goto L74;
        String r130 = r129.c();
        if (r130 == null) goto L74;
    L75:
        r100.put("connection_type", r130);
        com.bytedance.android.live.revlink.impl.global.c r131 = this.f527375b;
        if (r131 == null) goto L78;
        d31.d r132 = r131.getRevLinkLogHelper();
    L79:
        if (r132 == null) goto L88;
        com.bytedance.android.live.revlink.impl.global.c r133 = this.f527375b;
        if (r133 == null) goto L83;
        g r134 = r133.getMultiAnchorLinkContextObj();
    L84:
        if (r134 == null) goto L86;
        r105 = r134.b();
    L86:
        String r135 = r132.p(r105);
        if (r135 == null) goto L88;
    L89:
        r100.put("invitee_list", r135);
        com.bytedance.android.live.revlink.impl.global.c r136 = this.f527375b;
        if (r136 == null) goto L92;
        d31.d r137 = r136.getRevLinkLogHelper();
    L93:
        if (r137 == null) goto L95;
        r123 = r137.s();
    L95:
        r100.put("room_status", r123);
        com.bytedance.android.live.revlink.impl.global.c r138 = this.f527375b;
        if (r138 == null) goto L98;
        r102 = r138.getRevLinkLogHelper();
    L98:
        if (r102 == null) goto L100;
        r102.r(r100);
    L100:
        return r100;
    L92:
        r137 = null;
        goto L93
    L83:
        r134 = null;
    L88:
        r135 = "";
        goto L89
    L78:
        r132 = null;
    L74:
        r130 = "";
        goto L75
    L70:
        r129 = null;
    L66:
        r127 = null;
        goto L67
    L61:
        r125 = null;
        goto L62
    L54:
        r122 = null;
        goto L55
    L51:
        r121 = null;
    L47:
        r119 = "0";
        goto L48
    L39:
        r116 = null;
        goto L40
    L36:
        r115 = null;
        goto L37
    L29:
        r113 = null;
        goto L30
    L21:
        r110 = null;
        goto L22
    L25:
        r111 = null;
        goto L26
    L16:
        r108 = null;
        goto L17
    L12:
        if (r104.longValue() != 0) goto L33;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r100, com.bytedance.android.live.revlink.impl.global.c r101) {
        this.f527374a = r100;
        this.f527375b = r101;
    }
}
