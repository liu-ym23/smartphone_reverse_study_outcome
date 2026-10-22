package d60;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static final void a(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L24;
        return;
    L24:
    L21:
        e = move-exception;
        ALogger.e("TraceClientMonitor", e.getMessage());
        return;
    L6:
        if ((r102 instanceof Collection) == false) goto L13;
        JSONArray r103 = new JSONArray();     // Catch: JSONException -> L21
        Iterator r104 = ((Iterable) r102).iterator();     // Catch: JSONException -> L21
    L9:
        if (r104.hasNext() == false) goto L11;
        r103.put(r104.next());     // Catch: JSONException -> L21
        goto L9
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: JSONException -> L21
        r100.put(r101, r103);     // Catch: JSONException -> L21
        return;
    L13:
        if ((r102 instanceof Map) == false) goto L19;
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L21
        Iterator r107 = ((Map) r102).entrySet().iterator();     // Catch: JSONException -> L21
    L16:
        if (r107.hasNext() == false) goto L18;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: JSONException -> L21
        Object r109 = r108.getKey();     // Catch: JSONException -> L21
        Object r110 = r108.getValue();     // Catch: JSONException -> L21
        a(r106, String.valueOf(r109), r110);     // Catch: JSONException -> L21
        goto L16
    L18:
        Unit r111 = Unit.INSTANCE;     // Catch: JSONException -> L21
        r100.put(r101, r106);     // Catch: JSONException -> L21
        return;
    L19:
        r100.put(r101, r102);     // Catch: JSONException -> L21
    }
}
