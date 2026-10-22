package ra3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import di.d;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    static {
    }

    public static Map a(d r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468687a);
        String r103 = "";
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r101.put("before_stream", r102);
        String r104 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468688b);
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r101.put("body_recv", r104);
        String r105 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468689c);
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r101.put("connect_delay", r105);
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468690d);
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r101.put("create_stream", r106);
        String r107 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468691e);
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r101.put("dispatch", r107);
        String r108 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468692f);
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r101.put(MultiProcessFileUtils.KEY_DNS, r108);
        String r109 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468693g);
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        r101.put("edge", r109);
        String r110 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468694h);
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        r101.put("header_recv", r110);
        String r111 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468695i);
        if (r111 != null) goto L32;
        r111 = "";
    L32:
        r101.put(RNParamRegisterEventHandler.SRC_INNER, r111);
        String r112 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468696j);
        if (r112 != null) goto L35;
        r112 = "";
    L35:
        r101.put(PlayerResolution.SDKKEY.ORIGIN, r112);
        String r113 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468697k);
        if (r113 != null) goto L38;
        r113 = "";
    L38:
        r101.put("proxy", r113);
        String r114 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468698l);
        if (r114 != null) goto L41;
        r114 = "";
    L41:
        r101.put("rtt", r114);
        String r115 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468699m);
        if (r115 != null) goto L44;
        r115 = "";
    L44:
        r101.put("security_callback", r115);
        String r116 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468700n);
        if (r116 != null) goto L47;
        r116 = "";
    L47:
        r101.put("send", r116);
        String r117 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468701o);
        if (r117 != null) goto L50;
        r117 = "";
    L50:
        r101.put(TTVideoEngineInterface.PLAY_API_KEY_SSL, r117);
        String r118 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468702p);
        if (r118 != null) goto L53;
        r118 = "";
    L53:
        r101.put("tcp", r118);
        String r119 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468703q);
        if (r119 != null) goto L56;
        r119 = "";
    L56:
        r101.put(MonitorConstants.TTFB, r119);
        String r120 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r100.f468709a.f468705s));
        if (r120 != null) goto L59;
        r120 = "";
    L59:
        r101.put("pre_request_duration", r120);
        String r121 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468709a.f468706t);
        if (r121 != null) goto L62;
        r121 = "";
    L62:
        r101.put("net_total_duration", r121);
        String r122 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r100.f468709a.f468707u));
        if (r122 != null) goto L65;
        r122 = "";
    L65:
        r101.put("after_request_duration", r122);
        String r123 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r100.f468709a.f468708v));
        if (r123 != null) goto L68;
        r123 = "";
    L68:
        r101.put("response_serializer_duration", r123);
        String r124 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468713a);
        if (r124 != null) goto L71;
        r124 = "";
    L71:
        r101.put(ILoadStallMonitor.START_TIME, r124);
        String r125 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468714b);
        if (r125 != null) goto L74;
        r125 = "";
    L74:
        r101.put("create_stream_start", r125);
        String r126 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468715c);
        if (r126 != null) goto L77;
        r126 = "";
    L77:
        r101.put("create_stream_finish", r126);
        String r127 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468716d);
        if (r127 != null) goto L80;
        r127 = "";
    L80:
        r101.put("request_sent_time", r127);
        String r128 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468717e);
        if (r128 != null) goto L83;
        r128 = "";
    L83:
        r101.put("response_recv_time", r128);
        String r129 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468718f);
        if (r129 != null) goto L86;
        r129 = "";
    L86:
        r101.put("end_time", r129);
        String r130 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468719g);
        if (r130 != null) goto L89;
        r130 = "";
    L89:
        r101.put("ec_net_request_start", r130);
        String r131 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468720h);
        if (r131 != null) goto L92;
        r131 = "";
    L92:
        r101.put("ec_net_request_end", r131);
        String r132 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468721i);
        if (r132 != null) goto L95;
        r132 = "";
    L95:
        r101.put("app_level_request_start", r132);
        String r133 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468710b.f468722j);
        if (r133 != null) goto L98;
        r133 = "";
    L98:
        r101.put("before_all_interceptors", r133);
        String r134 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468711c.f468673d);
        if (r134 != null) goto L101;
        r134 = "";
    L101:
        r101.put(StreamTrafficObservable.STREAM_RECEIVEDBYTES, r134);
        String r135 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468711c.f468674e);
        if (r135 != null) goto L104;
        r135 = "";
    L104:
        r101.put(StreamTrafficObservable.STREAM_SENTBYTES, r135);
        String r136 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468711c.f468682m);
        if (r136 != null) goto L107;
        r136 = "";
    L107:
        r101.put("downlink_throughput", r136);
        String r137 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468711c.f468684o);
        if (r137 != null) goto L110;
        r137 = "";
    L110:
        r101.put("http_rtt", r137);
        String r138 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r100.f468711c.f468685p);
        if (r138 == null) goto L114;
        r103 = r138;
    L114:
        r101.put("tcp_rtt", r103);
        return r101;
    }
}
