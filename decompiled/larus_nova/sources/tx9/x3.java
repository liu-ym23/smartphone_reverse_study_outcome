package tx9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f547914a = null;

    static {
        f547914a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.larus.platform.service.g r103 = com.larus.platform.service.g.f365738a;     // Catch: Throwable -> L8
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L8
        r104.put("type", r100);     // Catch: Throwable -> L8
        r104.put("action", r101);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r104.put("extra", r102);     // Catch: Throwable -> L8
    L6:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r103.monitorEventForSlardar("unreachable_logic_monitor", r104, null, null);     // Catch: Throwable -> L8
        return;
    }
}
