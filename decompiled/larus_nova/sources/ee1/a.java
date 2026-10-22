package ee1;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.config.sk0;
import com.bytedance.android.livesdk.config.tk0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f472272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f472273b = null;

    static {
        f472272a = tk0.f121307a.getValue();
        f472273b = CollectionsKt.listOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, "from_user_id"});
    }

    public static void a(String r100, Map r101, o r102) {
        if ((r102 instanceof s0) == true) goto L6;
        return;
    L6:
        if (((s0) r102).f153340k == false) goto L55;
        if (r100 == null) goto L56;
        if (r101 != null) goto L45;
        return;
    L45:
        Iterator<String> r103 = f472273b.iterator();     // Catch: Throwable -> L42
    L13:
        if (r103.hasNext() == false) goto L58;
        String r104 = r103.next();     // Catch: Throwable -> L42
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L42
        String r106 = f472272a;     // Catch: Throwable -> L42
        r105.append(r106);     // Catch: Throwable -> L42
        r105.append(r104);     // Catch: Throwable -> L42
        if (r101.containsKey(r105.toString()) == false) goto L35;
        Object r107 = r101.get(r106 + r104);     // Catch: Throwable -> L42
        if ((r107 instanceof String) == true) goto L20;
        r107 = null;
    L20:
        String r108 = (String) r107;     // Catch: Throwable -> L42
        if (r108 == null) goto L35;
        if (r108.length() != 71) goto L24;
        Logger.d("privacy_length", "getvalid length for event : " + r100);     // Catch: Throwable -> L42
        goto L35
    L24:
        int r109 = r108.length();     // Catch: Throwable -> L42
        if (r109 >= 50) goto L28;
        int r110 = 1;
    L31:
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L42
        r111.put("webcast_id_length", r110);     // Catch: Throwable -> L42
        LiveTracingMonitor.f("ttlive_privacy_room_uid_report", LiveTracingMonitor.EventModule.common, r111, new JSONObject(), new JSONObject());     // Catch: Throwable -> L42
        return;
    L28:
        if (r109 > 70) goto L30;
        r110 = 2;
        goto L31
    L30:
        r110 = 3;
    L35:
        if (sk0.f121235a.getValue().booleanValue() == false) goto L13;
        if (r101.containsKey(r104) == false) goto L13;
        if (r101.containsKey(r106 + r104) == true) goto L13;
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L42
        r112.put("event_type", r100);     // Catch: Throwable -> L42
        r112.put("event_param_name", r104);     // Catch: Throwable -> L42
        LiveTracingMonitor.f("ttlive_privacy_room_uid_report", LiveTracingMonitor.EventModule.common, r112, new JSONObject(), new JSONObject());     // Catch: Throwable -> L42
        return;
    L58:
        return;
    L42:
        th = move-exception;
        SafetyGuard.a(null, th, null);
        return;
    L56:
        return;
    }
}
