package ok7;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static final Map a(Map r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r100.put("bridge_version", "bridge_version");
        r102.put("data", r100);
        r102.put("code", 1);
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r102.put("msg", r101);
        return r102;
    }
}
