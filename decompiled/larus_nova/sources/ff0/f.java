package ff0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    public static final Map<String, String> a(JSONObject r100) {
        if (r100 == null) goto L4;
        Iterator<String> r101 = r100.keys();
        HashMap r102 = new HashMap();
    L7:
        if (r101.hasNext() == false) goto L15;
        String r103 = r101.next();
        if (r100.optJSONObject(r103) == null) goto L14;
        Map<String, String> r104 = a(r100.optJSONObject(r103));     // Catch: NullPointerException -> L12
        Intrinsics.checkNotNull(r104);     // Catch: NullPointerException -> L12
        r102.putAll(r104);     // Catch: NullPointerException -> L12
    L12:
        e = move-exception;
        e.getMessage();
        goto L7
    L14:
        r102.put(r103, r100.optString(r103));
        goto L7
    L15:
        return r102;
    L4:
        return new LinkedHashMap();
    }
}
