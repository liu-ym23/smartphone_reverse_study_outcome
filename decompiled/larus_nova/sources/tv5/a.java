package tv5;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Gson f547697a;

    public a() {
    }

    public static JSONObject b(Object r100) throws JSONException {
        Gson r101 = f547697a;
        if (r101 != null) goto L15;
        monitor-enter(a.class);
        r101 = f547697a;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new Gson();     // Catch: Throwable -> L11
        f547697a = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return a(r101, r100);
    }

    public static JSONObject c(JsonElement r100) throws JSONException {
        return new JSONObject(r100.toString());
    }

    public static JSONObject a(Gson r100, Object r101) throws JSONException {
        if ((r101 instanceof JsonElement) == false) goto L7;
        return c((JsonElement) r101);
    L7:
        return new JSONObject(GsonProtectorUtils.toJson(r100, r101));
    }
}
