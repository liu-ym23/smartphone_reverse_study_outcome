package j01;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putAll");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        b(r100, r103, r101.opt(r103));
        goto L4
    }

    public static final void b(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L13;
        return;
    L13:
        r100.put(r101, r102);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        jy0.b.c("RevenueMonitorJsonException", r103, null, 4);
    }
}
