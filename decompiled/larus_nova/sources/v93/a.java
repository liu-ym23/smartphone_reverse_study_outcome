package v93;

import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f553776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f553777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f553778c = null;

    public a() {
    }

    public static Pair a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        return TuplesKt.to(new JSONObject(f553776a.optString("user_behavior")), null);
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    static {
        f553778c = new a();
        f553776a = new JSONObject();
        f553777b = "";
    }
}
