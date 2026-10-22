package w20;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class ea {
    public static final JSONObject a(o7 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$extraJson");
        JsonObject r101 = r100.f557971b;
        if (r101 == null) goto L7;
        String r102 = r101.toString();
        if (r102 == null) goto L7;
        return new JSONObject(r102);
    L7:
        return null;
    }
}
