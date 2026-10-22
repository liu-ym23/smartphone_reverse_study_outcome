package ga9;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f480599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f480600b = null;

    public e() {
    }

    static {
        f480599a = new e();
        f480600b = LazyKt.lazy(new d());
    }

    public static JSONObject c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(((Gson) f480600b.getValue()).toJson(r100)));     // Catch: Throwable -> L5
    L7:
        JSONObject r103 = new JSONObject();
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = r103;
    L11:
        return (JSONObject) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static JsonObject b(JsonObject r100, JsonObject r101) {
        JsonObject r102 = new JsonObject();
        Iterator<T> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        Intrinsics.checkNotNull(r104);
        r102.add((String) r104.getKey(), (JsonElement) r104.getValue());
        goto L4
    L6:
        Iterator<T> r105 = r101.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L20;
        Map.Entry r106 = (Map.Entry) r105.next();
        Intrinsics.checkNotNull(r106);
        String r107 = (String) r106.getKey();
        JsonElement r108 = (JsonElement) r106.getValue();
        JsonElement r109 = r102.get(r107);
        if (r109 == null) goto L14;
        boolean r110 = true;
        if (r109.isJsonObject() != true) goto L14;
    L15:
        if (r110 == false) goto L19;
        if (r108.isJsonObject() == false) goto L19;
        e r111 = f480599a;
        JsonObject r112 = r109.getAsJsonObject();
        JsonObject r113 = r108.getAsJsonObject();
        r111.getClass();
        r102.add(r107, b(r112, r113));
    L19:
        r102.add(r107, r108);
    L14:
        r110 = false;
        goto L15
    L20:
        return r102;
    }

    public static Object a(JSONObject r100, Class r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Lazy r104 = f480600b;     // Catch: Throwable -> L5
        JsonObject r105 = ((Gson) r104.getValue()).toJsonTree(r102).getAsJsonObject();     // Catch: Throwable -> L5
        JsonObject r106 = new JsonParser().parse(r100.toString()).getAsJsonObject();     // Catch: Throwable -> L5
        Gson r107 = (Gson) r104.getValue();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(r107.fromJson(b(r105, r106), r101));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r108) == false) goto L10;
        r108 = null;
    L10:
        if (r108 != null) goto L13;
        return r102;
    L13:
        return r108;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
