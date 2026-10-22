package f2a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e {
    public static final Map<f, Object> a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() == 0) goto L5;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L8:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r101.put(new f(r103), r100.get(r103));
        goto L8
    L10:
        return r101;
    L5:
        return MapsKt.emptyMap();
    }
}
