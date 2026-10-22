package wx6;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f561836a = null;

    static {
        f561836a = new a();
    }

    public a() {
    }

    public static void a(a r100, JsonObject r101, Map r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r101 == null) goto L18;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<T> r104 = r101.keySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();     // Catch: Throwable -> L11
        JsonElement r106 = r101.get(r105);     // Catch: Throwable -> L11
        b(f561836a, r105, r106, r102);     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Result.m9452exceptionOrNullimpl(r107);
        return;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(a r100, String r101, JsonElement r102, Map r103) {
        r100.getClass();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        if ((r102 instanceof JsonObject) == false) goto L7;
        a(r100, (JsonObject) r102, r103);     // Catch: Throwable -> L17
    L15:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.m9452exceptionOrNullimpl(r105);
        return;
    L7:
        if ((r102 instanceof JsonArray) == false) goto L13;
        Iterator r106 = ((Iterable) r102).iterator();     // Catch: Throwable -> L17
    L10:
        if (r106.hasNext() == false) goto L15;
        b(r100, r101, (JsonElement) r106.next(), r103);     // Catch: Throwable -> L17
        goto L10
    L13:
        if ((r102 instanceof JsonPrimitive) == false) goto L15;
        r103.put(r101, ((JsonPrimitive) r102).getAsString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
