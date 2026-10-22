package l93;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final String a(Object r2) {
        if ((r2 instanceof String) == false) goto L7;
        return (String) r2;
    L7:
        if ((r2 instanceof Map) == false) goto L15;
        Object r3 = ((Map) r2).get("url_list");
        if ((r3 instanceof List) == true) goto L11;
        r3 = null;
    L11:
        List r4 = (List) r3;
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) CollectionsKt.getOrNull(r4, 0);
    L15:
        return null;
    }
}
