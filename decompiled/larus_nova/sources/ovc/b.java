package ovc;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f527013d = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f527014e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f527015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f527016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f527017c;

    public b(Map<String, Object> r110, boolean r111) {
        this.f527017c = true;
        if (NetworkParams.getDestroyDeltaMillis() <= 0) goto L5;
        f527013d = NetworkParams.getDestroyDeltaMillis();
        long r100 = a(r110, "destroy_timeout_millis", 0);
        if (r100 < 1000) goto L11;
        f527014e = true;
        if (r111 == false) goto L20;
        long r101 = r100 - f527013d;
        this.f527015a = r101;
        if (Logger.debug() == false) goto L39;
        Logger.d("CronetFrontierConnection", "Destroy ws timeout: " + r101);
        return;
    L39:
        return;
    L20:
        long r112 = a(r110, "fallback_timeout_mills", 10000);
        if (Logger.debug() == false) goto L24;
        Logger.d("CronetFrontierConnection", "fallback timeout:" + r112 + " destroy timeout:" + r100);
    L24:
        if (r112 < r100) goto L30;
        this.f527017c = false;
        if (Logger.debug() == false) goto L28;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.f527016b = r100 - f527013d;
        return;
    L30:
        long r102 = f527013d;
        this.f527016b = r112 - r102;
        long r103 = (r100 - r112) - r102;
        this.f527015a = r103;
        if (r103 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, timeout <= 0:" + r103);
    L35:
        this.f527017c = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d("CronetFrontierConnection", "Destroy timeout disable: " + r100);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d("CronetFrontierConnection", "Destroy delta disable: " + NetworkParams.getDestroyDeltaMillis());
        return;
    }

    public static boolean b(String r100, boolean r101) {
        if (f527014e == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (r101 == false) goto L16;
        if (r100.contains("\\\"net_error\\\":-7") == true) goto L12;
        return false;
    L12:
        if (r100.contains("WebSocket opening handshake timed out") == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        if (r100.contains("\"error_code\":-193") == false) goto L18;
    L21:
        return true;
    L18:
        if (r100.contains("\"error_code\":-356") == true) goto L20;
        return false;
    L20:
        if (r100.contains("\\\"internal_error\\\":67") == true) goto L21;
        return false;
    }

    public static long a(Map<String, Object> r100, String r101, long r102) {
        Map r103 = (Map) r100.get(WsConstants.KEY_HEADERS);
        if (r103 != null) goto L5;
        return r102;
    L5:
        if (r103.isEmpty() == false) goto L8;
        return r102;
    L8:
        if (r103.containsKey(r101) == true) goto L10;
        return r102;
    L10:
        String r104 = (String) r103.get(r101);
        if (TextUtils.isEmpty(r104) == false) goto L18;
        return r102;
    L18:
        int r105 = CastIntegerProtector.valueOf(r104).intValue();     // Catch: Exception -> L17
        if (r105 > 0) goto L16;
        return r102;
    L16:
        return r105;
    L23:
        return r102;
    }
}
