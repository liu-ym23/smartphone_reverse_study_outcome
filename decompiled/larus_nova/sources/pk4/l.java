package pk4;

import com.bytedance.dora.device.DoraDevice;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f529633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f529634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f529635c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f529636d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f529637e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f529638f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f529639g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f529640h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f529641i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f529642j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f529643k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f529644l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f529645m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f529646n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f529647o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f529648p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f529649q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f529650r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f529651s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f529652t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f529653u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f529654v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f529655w = null;

    static {
        f529633a = h.a.f529626a;
        f529634b = "d_device_found";
        f529635c = "d_device_bond";
        f529636d = "d_device_reconnect";
        f529637e = "d_device_disconnect";
        f529638f = "d_protocol_downlink";
        f529639g = "d_protocol_downlink_blocked";
        f529640h = "d_protocol_command_fail";
        f529641i = "d_protocol_send_cost";
        f529642j = "d_vui_error";
        f529643k = "d_vui_t0";
        f529644l = "d_vui_loss";
        f529645m = "d_vui_wakeup";
        f529646n = "dora_take_image_start";
        f529647o = "dora_image_transmit_start";
        f529648p = "dora_image_first_frame";
        f529649q = "dora_image_last_frame";
        f529650r = "dora_image_transmit_end";
        f529651s = "dora_image_transmit_timeout";
        f529652t = "d_protocol_connect_spend";
        f529653u = "d_protocol_connect_spend_v2";
        f529654v = "d_bytelink_pair_client";
        f529655w = "dora_rtos_player_end";
    }

    public static String a(int r100, Set<String> r101) {
        if (r100 > 0) goto L6;
        return "size=0, keys=[]";
    L6:
        if (r101 == null) goto L16;
        if (r101.isEmpty() == true) goto L16;
        Object r102 = new TreeSet(r101);     // Catch: RuntimeException -> L12
    L14:
        return "size=" + r100 + ", keys=" + r102;
    L12:
        r102 = Collections.emptySet();
    L16:
        return "size=" + r100 + ", keys=[]";
    }

    public static void c(String r100, Map<String, Object> r101) {
        if (r101 != null) goto L4;
        r101 = new HashMap();
    L4:
        DoraDevice r102 = ak4.a.d().current();
        String r103 = null;
        if (r102 == null) goto L7;
        String r104 = r102.modelVersion;
    L8:
        b(r101, "alg_version", r104);
        if (r102 == null) goto L11;
        String r105 = r102.hwVersion;
    L12:
        b(r101, "hw_version", r105);
        if (r102 == null) goto L15;
        String r106 = r102.softVersion;
    L16:
        b(r101, "soft_version", r106);
        if (r102 == null) goto L19;
        String r107 = r102.typeName;
    L20:
        b(r101, "product", r107);
        b(r101, "bg_android", Integer.valueOf(n.o()));
        b(r101, "wake_mode", Integer.valueOf(sk4.b.C7624b.f542395a.f542383m));
        Map<String, Object> r108 = f529633a.e();
        if (r108 == null) goto L23;
        r101.putAll(r108);
    L23:
        a(r101.size(), r101.keySet());
        if (r102 == null) goto L26;
        r103 = r102.getSerialNumber();
    L26:
        b(r101, "series_no", r103);
        f529633a.d(r100, r101);
        return;
    L19:
        r107 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r104 = null;
        goto L8
    }

    public static void b(Map<String, Object> r100, String r101, Object r102) {
        if (r100.containsKey(r101) == true) goto L6;
        r100.put(r101, r102);
        return;
    }
}
