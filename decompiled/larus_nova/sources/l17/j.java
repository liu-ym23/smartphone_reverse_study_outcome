package l17;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class j {
    public static JSONObject a(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L14;
        if (r100 == null) goto L14;
    L12:
        th = move-exception;
        k.b(new String[]{"JsonConfigManager mergeJson error:" + th.toString()});
        goto L14
    L5:
        if (r100.length() != 0) goto L7;
        return r101;
    L7:
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L12
    L9:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: Throwable -> L12
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L12
    L14:
        return r100;
    }
}
