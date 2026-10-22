package mqc;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class s {
    public static final void a(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$addParam");
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(r1);
        r1.put(r2, r3);     // Catch: Throwable -> L6 Exception -> L8
    L9:
        monitor-exit(r1);
        return;
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
