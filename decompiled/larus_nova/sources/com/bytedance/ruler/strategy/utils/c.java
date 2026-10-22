package com.bytedance.ruler.strategy.utils;

import com.bytedance.ruler.strategy.store.StrategyStore;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267749a = 0;

    static {
    }

    public static Object b(JsonObject r100) {
        JsonElement r101 = r100.get("TYPE");
        HashMap r102 = null;
        ArrayList r103 = null;
        r103 = null;
        r102 = null;
        if (r101 == null) goto L5;
        String r104 = r101.getAsString();
    L6:
        if (r104 != null) goto L9;
        return null;
    L9:
        switch(r104.hashCode()) {
            case -1808118735: goto L86;
            case 73679: goto L80;
            case 77116: goto L63;
            case 2086184: goto L57;
            case 2099062: goto L51;
            case 2374300: goto L45;
            case 63537721: goto L30;
            case 67973692: goto L24;
            case 79860828: goto L18;
            case 2052876273: goto L12;
            default: goto L118;
        };
    L118:
        return null;
    L12:
        if (r104.equals("Double") == false) goto L106;
        JsonElement r105 = r100.get("VALUE");
        if (r105 != null) goto L16;
        return null;
    L16:
        return Double.valueOf(r105.getAsDouble());
    L106:
        return null;
    L18:
        if (r104.equals("Short") == false) goto L107;
        JsonElement r106 = r100.get("VALUE");
        if (r106 != null) goto L22;
        return null;
    L22:
        return Short.valueOf(r106.getAsShort());
    L107:
        return null;
    L24:
        if (r104.equals("Float") == false) goto L108;
        JsonElement r107 = r100.get("VALUE");
        if (r107 != null) goto L28;
        return null;
    L28:
        return Float.valueOf(r107.getAsFloat());
    L108:
        return null;
    L30:
        if (r104.equals("Array") == false) goto L109;
        JsonElement r108 = r100.get("VALUE");
        if (r108 == null) goto L43;
        JsonArray r109 = r108.getAsJsonArray();
        if (r109 == null) goto L43;
        r103 = new ArrayList();
        Iterator<JsonElement> r110 = r109.iterator();
    L37:
        if (r110.hasNext() == false) goto L43;
        JsonElement r111 = r110.next();
        if (r111 == null) goto L42;
        r103.add(b((JsonObject) r111));
        goto L37
    L42:
        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
    L43:
        return r103;
    L109:
        return null;
    L45:
        if (r104.equals("Long") == false) goto L110;
        JsonElement r112 = r100.get("VALUE");
        if (r112 != null) goto L49;
        return null;
    L49:
        return Long.valueOf(r112.getAsLong());
    L110:
        return null;
    L51:
        if (r104.equals("Char") == false) goto L111;
        JsonElement r113 = r100.get("VALUE");
        if (r113 != null) goto L55;
        return null;
    L55:
        return Character.valueOf(r113.getAsCharacter());
    L111:
        return null;
    L57:
        if (r104.equals("Byte") == false) goto L112;
        JsonElement r114 = r100.get("VALUE");
        if (r114 != null) goto L61;
        return null;
    L61:
        return Byte.valueOf(r114.getAsByte());
    L112:
        return null;
    L63:
        if (r104.equals("Map") == false) goto L113;
        JsonElement r115 = r100.get("VALUE");
        if (r115 == null) goto L78;
        JsonObject r116 = r115.getAsJsonObject();
        if (r116 == null) goto L78;
        r102 = new HashMap();
        Iterator<T> r117 = r116.entrySet().iterator();
    L70:
        if (r117.hasNext() == false) goto L78;
        Map.Entry r118 = (Map.Entry) r117.next();
        Object r119 = r118.getValue();
        if (r119 == null) goto L77;
        Object r120 = b((JsonObject) r119);
        if (r120 == null) goto L70;
        r102.put(r118.getKey(), r120);
        goto L70
    L77:
        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
    L78:
        return r102;
    L113:
        return null;
    L80:
        if (r104.equals("Int") == false) goto L114;
        JsonElement r121 = r100.get("VALUE");
        if (r121 != null) goto L84;
        return null;
    L84:
        return Integer.valueOf(r121.getAsInt());
    L114:
        return null;
    L86:
        if (r104.equals("String") == false) goto L115;
        JsonElement r122 = r100.get("VALUE");
        if (r122 != null) goto L90;
        return null;
    L90:
        return r122.getAsString();
    L115:
        return null;
    L5:
        r104 = null;
        goto L6
    }

    public static Map c(String r100) {
        HashMap r101 = new HashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Iterator<T> r103 = ((JsonObject) StrategyStore.f267726g.fromJson(r100, JsonObject.class)).entrySet().iterator();     // Catch: Throwable -> L15
    L5:
        if (r103.hasNext() == false) goto L13;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L15
        JsonElement r105 = (JsonElement) r104.getValue();     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        Object r106 = b((JsonObject) r105);     // Catch: Throwable -> L15
        if (r106 == null) goto L5;
        r101.put(r104.getKey(), r106);     // Catch: Throwable -> L15
        goto L5
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        return r101;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static JsonObject d(Object r100) {
        JsonObject r101 = new JsonObject();
        if (r100 != null) goto L7;
        r101.add("TYPE", new JsonPrimitive("Null"));
        r101.add("VALUE", (JsonElement) r100);
        return r101;
    L7:
        if ((r100 instanceof String) == false) goto L11;
        r101.add("TYPE", new JsonPrimitive("String"));
        r101.add("VALUE", new JsonPrimitive((String) r100));
        return r101;
    L11:
        if ((r100 instanceof Long) == false) goto L15;
        r101.add("TYPE", new JsonPrimitive("Long"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L15:
        if ((r100 instanceof Integer) == false) goto L19;
        r101.add("TYPE", new JsonPrimitive("Int"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L19:
        if ((r100 instanceof Float) == false) goto L23;
        r101.add("TYPE", new JsonPrimitive("Float"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L23:
        if ((r100 instanceof Double) == false) goto L27;
        r101.add("TYPE", new JsonPrimitive("Double"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L27:
        if ((r100 instanceof Byte) == false) goto L31;
        r101.add("TYPE", new JsonPrimitive("Byte"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L31:
        if ((r100 instanceof Character) == false) goto L35;
        r101.add("TYPE", new JsonPrimitive("Char"));
        r101.add("VALUE", new JsonPrimitive((Character) r100));
        return r101;
    L35:
        if ((r100 instanceof Short) == false) goto L38;
        r101.add("TYPE", new JsonPrimitive("Short"));
        r101.add("VALUE", new JsonPrimitive((Number) r100));
        return r101;
    L38:
        return null;
    }

    public static String a(Map r100, List r110) {
        JsonObject r101 = new JsonObject();
        if (r110 == null) goto L48;
        Iterator r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L46;
        String r102 = (String) r111.next();
        Object r103 = r100.get(r102);
        JsonObject r104 = d(r103);
        if (r104 == null) goto L11;
    L41:
        if (r104 == null) goto L43;
        r101.add(r102, r104);
        goto L6
    L43:
        return "";
    L11:
        if ((r103 instanceof Collection) == false) goto L23;
        JsonArray r105 = new JsonArray();
        Iterator r106 = ((Collection) r103).iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        JsonObject r107 = d(r106.next());
        if (r107 == null) goto L18;
        r105.add(r107);
        goto L14
    L18:
        JsonObject r108 = null;
    L20:
        if (r108 != null) goto L39;
    L40:
        r104 = null;
    L39:
        r104 = r108;
        goto L41
    L19:
        r108 = new JsonObject();
        r108.add("TYPE", new JsonPrimitive("Array"));
        r108.add("VALUE", r105);
        goto L20
    L23:
        if ((r103 instanceof Map) == false) goto L40;
        JsonObject r109 = new JsonObject();
        Iterator r112 = ((Map) r103).entrySet().iterator();
    L26:
        if (r112.hasNext() == false) goto L37;
        Map.Entry r113 = (Map.Entry) r112.next();
        if ((r113.getKey() instanceof String) == false) goto L36;
        JsonObject r114 = d(r113.getValue());
        if (r114 == null) goto L36;
        Object r115 = r113.getKey();
        if (r115 == null) goto L35;
        r109.add((String) r115, r114);
        goto L26
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L36:
        r108 = null;
    L38:
        if (r108 == null) goto L40;
    L37:
        r108 = new JsonObject();
        r108.add("TYPE", new JsonPrimitive("Map"));
        r108.add("VALUE", r109);
        goto L38
    L46:
        return r101.toString();
    L48:
        return r100.toString();
    }
}
