package q07;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static boolean a(JsonObject r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
    L13:
        return r102;
    L4:
        if (r100.has(r101) == false) goto L13;
        JsonElement r103 = r100.get(r101);
        if (r103.isJsonPrimitive() == false) goto L13;
        if (r103.getAsJsonPrimitive().isBoolean() == false) goto L13;
        return r103.getAsBoolean();
    }
}
