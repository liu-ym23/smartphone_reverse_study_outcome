package zl7;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f572792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonParser f572793b = null;

    static {
        f572792a = new Gson();
        f572793b = new JsonParser();
    }

    public static boolean a(JsonArray r100, JsonArray r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L18;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= r101.size()) goto L15;
        if (b(r100.get(r102), r101.get(r103)) == false) goto L14;
        r104 = true;
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        if (r104 == false) goto L16;
        r102 = r102 + 1;
        goto L7
    L16:
        return false;
    L18:
        return true;
    }

    public static boolean b(JsonElement r100, JsonElement r101) {
        if (r100.isJsonObject() == false) goto L17;
        if (r101.isJsonObject() == false) goto L17;
        JsonObject r102 = (JsonObject) r100;
        JsonObject r103 = (JsonObject) r101;
        Set<String> r104 = r102.keySet();
        if (r104.equals(r103.keySet()) == true) goto L9;
    L8:
        return false;
    L9:
        Iterator<String> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L38;
        String r106 = r105.next();
        if (b(r102.get(r106), r103.get(r106)) == true) goto L11;
    L38:
        return true;
    L17:
        if (r100.isJsonArray() == false) goto L23;
        if (r101.isJsonArray() == false) goto L23;
        return a((JsonArray) r100, (JsonArray) r101);
    L23:
        if (r100.isJsonPrimitive() == false) goto L29;
        if (r101.isJsonPrimitive() == false) goto L29;
        return ((JsonPrimitive) r100).equals((JsonPrimitive) r101);
    L29:
        if (r100.isJsonNull() == true) goto L31;
    L34:
        return false;
    L31:
        if (r101.isJsonNull() == false) goto L34;
        JsonNull r107 = (JsonNull) r100;
        JsonNull r108 = (JsonNull) r101;
        return true;
    }

    public static boolean c(String r100, String r101) {
        if (r100 != null) goto L9;
        if (r101 == null) goto L16;
        return false;
    L16:
        return true;
    L9:
        if (r100.equals(r101) == false) goto L11;
        return true;
    L11:
        JsonParser r102 = f572793b;
        JsonElement r103 = GsonProtectorUtils.parse(r102, r100);
        JsonElement r104 = GsonProtectorUtils.parse(r102, r101);
        Gson r105 = f572792a;
        if (GsonProtectorUtils.toJson(r105, r103).equals(GsonProtectorUtils.toJson(r105, r104)) == false) goto L15;
        return true;
    L15:
        return b(r103, r104);
    }
}
