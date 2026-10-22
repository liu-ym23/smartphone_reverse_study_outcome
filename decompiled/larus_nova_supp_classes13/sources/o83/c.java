package o83;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    static {
    }

    public static JSONObject a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        JSONObject r1 = new JSONObject();
        r1.put("id", r2);
        r1.put("address_type", r3);
        if (r4 == null) goto L5;
        JSONObject r5 = new JSONObject();
        r5.put("strategy", r4);
        Unit r6 = Unit.INSTANCE;
        r1.put("extra", r5);
    L5:
        return r1;
    }
}
