package w20;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b4 {
    public static final JSONObject a(xb r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$extraJson");
        JsonObject r101 = r100.getExtra();
        if (r101 == null) goto L7;
        String r102 = r101.toString();
        if (r102 == null) goto L7;
        return new JSONObject(r102);
    L7:
        return null;
    }
}
