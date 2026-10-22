package mqc;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s {
    public static final void a(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addParam");
        Intrinsics.checkNotNullParameter(r101, "key");
        monitor-enter(r100);
        r100.put(r101, r102);     // Catch: Throwable -> L6 Exception -> L8
    L9:
        monitor-exit(r100);
        return;
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
