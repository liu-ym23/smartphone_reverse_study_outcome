package v93;

import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final JSONObject a = null;
    public static final String b = null;
    public static final a c = null;

    public a() {
    }

    public static Pair a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        return TuplesKt.to(new JSONObject(a.optString("user_behavior")), null);
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    static {
        c = new a();
        a = new JSONObject();
        b = "";
    }
}
