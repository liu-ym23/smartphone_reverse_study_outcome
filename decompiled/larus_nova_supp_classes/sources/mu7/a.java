package mu7;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements ju7.a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // ju7.a
    public final void onReport(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "params");
        JSONObject r0 = new JSONObject(r5);
        Lazy r6 = ku7.c.a;
        ku7.c.a("onReport " + r4 + " ==== start");
        ku7.c.a(r0.toString(4));
        ku7.c.a("onReport " + r4 + " ==== end");
    }
}
