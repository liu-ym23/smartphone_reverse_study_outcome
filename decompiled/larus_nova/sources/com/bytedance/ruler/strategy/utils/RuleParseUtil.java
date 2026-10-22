package com.bytedance.ruler.strategy.utils;

import android.os.Handler;
import com.bytedance.express.ExprRunner;
import com.bytedance.express.command.Instruction;
import com.bytedance.express.command.Primitive;
import com.bytedance.express.util.ThreadTimeUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ruler.utils.AsyncExecutorKt;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class RuleParseUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f267746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<fa7.a> f267747b = null;

    static {
        f267746a = new Gson();
        new HashMap(1000);
        new ga7.d();
        System.nanoTime();
        ThreadTimeUtil.a();
        f267747b = new ArrayList();
    }

    public static JsonElement a(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof JsonNull) == false) goto L8;
        return r100;
    L8:
        if (r100.isJsonPrimitive() == false) goto L11;
        return r100;
    L11:
        if ((r100 instanceof JsonObject) == false) goto L35;
        JsonObject r101 = new JsonObject();
        Iterator<T> r102 = ((JsonObject) r100).entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L49;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        JsonElement r105 = (JsonElement) r103.getValue();
        boolean r106 = false;
        if (r105 != null) goto L18;
    L31:
        if (r106 == true) goto L14;
        r101.add(r104, a(r105));
        goto L14
    L18:
        if (r105.isJsonPrimitive() != true) goto L31;
        JsonPrimitive r107 = r105.getAsJsonPrimitive();
        if (r107 == null) goto L31;
        if (r107.isString() != true) goto L31;
        String r108 = r105.getAsString();
        if (StringsKt.startsWith$default(r108, "$", false, 2, null) == false) goto L31;
        v97.d<?> r109 = ga7.b.f480571a.get(r108.substring(1, r108.length()));
        if (r109 == null) goto L28;
        Object r110 = r109.getValue();
    L29:
        if (r110 == null) goto L31;
        r101.add(r104, GsonProtectorUtils.toJsonTree(f267746a, r110));
        r106 = true;
        goto L31
    L28:
        r110 = null;
        goto L29
    L49:
        return r101;
    L35:
        if ((r100 instanceof JsonArray) == false) goto L41;
        JsonArray r111 = new JsonArray();
        Iterator<JsonElement> r112 = r111.iterator();
    L38:
        if (r112.hasNext() == false) goto L52;
        r111.add(a(r112.next()));
        goto L38
    L52:
        return r111;
    L41:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
    public static fa7.a b(JsonElement r110) {
        List<com.bytedance.express.command.b> r100 = null;
        ArrayList r101 = null;
        if (r110 != null) goto L5;
    L150:
        return null;
    L5:
        if (r110.isJsonObject() == false) goto L150;
        JsonObject r111 = r110.getAsJsonObject();
        if (r111 == null) goto L150;
        JsonElement r102 = r111.get("title");
        if (r102 == null) goto L12;
        String r103 = r102.getAsString();
    L13:
        JsonElement r104 = r111.get("conf");
        JsonElement r105 = r111.get("cel");
        if (r105 == null) goto L16;
        String r106 = r105.getAsString();
    L17:
        List r107 = c(r111.get("children"));
        JsonElement r108 = r111.get("il");
        if (com.bytedance.ruler.d.f267691o == false) goto L44;
        if (r108 == null) goto L44;
        if (r108.isJsonArray() == false) goto L44;
        ArrayList r109 = new ArrayList();
        Iterator<JsonElement> r112 = r108.getAsJsonArray().iterator();
    L24:
        if (r112.hasNext() == false) goto L43;
        JsonObject r113 = r112.next().getAsJsonObject();
        Primitive r114 = com.bytedance.express.command.e.a((r113.get(RXScreenCaptureService.KEY_INDEX).getAsInt() << 18) >> 28);
        JsonElement r115 = r113.get(BaseSwitches.V);
        switch(d.f267750a[r114.ordinal()]) {
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            default: goto L37;
        };
    L30:
        Object r116 = Character.valueOf(r115.getAsCharacter());
    L38:
        int r117 = r113.get(RXScreenCaptureService.KEY_INDEX).getAsInt();
        if (r116 == null) goto L42;
        r109.add(new Instruction(r117, r116));
        goto L24
    L42:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    L31:
        r116 = r115.getAsString();
        goto L38
    L32:
        r116 = Double.valueOf(r115.getAsDouble());
        goto L38
    L33:
        r116 = Float.valueOf(r115.getAsFloat());
        goto L38
    L34:
        r116 = Long.valueOf(r115.getAsLong());
        goto L38
    L35:
        r116 = Integer.valueOf(r115.getAsInt());
        goto L38
    L36:
        r116 = Boolean.valueOf(r115.getAsBoolean());
        goto L38
    L37:
        r116 = "null";
        goto L38
    L29:
        throw new NotImplementedError("An operation is not implemented: ");
    L43:
        ArrayList r118 = r109;
    L45:
        JsonElement r119 = r111.get("type");
        boolean r120 = false;
        if (r119 == null) goto L48;
        int r121 = Integer.valueOf(r119.getAsInt());
    L49:
        final fa7.a r122 = new fa7.a(r103, r107, r104, r106, r121, r118, 8080);
        Integer r123 = r122.getType();
        if (r123 != null) goto L53;
    L79:
        f267747b.add(r122);
        if (com.bytedance.ruler.d.f267691o == true) goto L151;
        com.bytedance.ruler.a r124 = com.bytedance.ruler.d.f267678b;
        if (r124 == null) goto L143;
        r120 = r124.f267624j;
    L143:
        if (r120 == true) goto L145;
    L148:
        r122.f(a(r122.b()));
        return r122;
    L145:
        if (Intrinsics.areEqual(AsyncExecutorKt.f267756b.get(), Boolean.TRUE) == false) goto L147;
        AsyncExecutorKt.a(new RuleParseUtil$$special$$inlined$runInBackground$1(r122));
        goto L148
    L147:
        Handler r125 = com.bytedance.ruler.utils.a.f267757a;
        com.bytedance.ruler.utils.a.a(new RuleParseUtil$$special$$inlined$runInBackground$2(r122), 0);
        goto L148
    L151:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L138
        List<Instruction> r127 = r122.f476027d;     // Catch: Throwable -> L138
        if (r127 != null) goto L84;
    L85:
        r120 = true;
    L86:
        String r128 = "";
        if (r120 == false) goto L93;
        Map<String, List<Instruction>> r129 = y97.b.f566987a;     // Catch: Throwable -> L138
        String r130 = r122.a();     // Catch: Throwable -> L138
        if (r130 != null) goto L92;
        r130 = "";
    L92:
        r122.f476027d = (List) ((ConcurrentHashMap) y97.b.f566987a).get(r130);     // Catch: Throwable -> L138
    L93:
        List<Instruction> r131 = r122.f476027d;     // Catch: Throwable -> L138
        if (r131 != null) goto L96;
    L104:
        ExprRunner r132 = com.bytedance.ruler.d.b();     // Catch: Throwable -> L138
        if (r132 == null) goto L111;
        String r133 = r122.a();     // Catch: Throwable -> L138
        if (r133 != null) goto L110;
        r133 = "";
    L110:
        r100 = r132.d(r133);     // Catch: Throwable -> L138
    L111:
        r122.f476024a = r100;     // Catch: Throwable -> L138
        if (r100 == null) goto L125;
        ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));     // Catch: Throwable -> L138
        Iterator r135 = r100.iterator();     // Catch: Throwable -> L138
    L115:
        if (r135.hasNext() == false) goto L117;
        r134.add(((com.bytedance.express.command.b) r135.next()).b());     // Catch: Throwable -> L138
        goto L115
    L117:
        r122.f476027d = r134;     // Catch: Throwable -> L138
        Map<String, List<Instruction>> r136 = y97.b.f566987a;     // Catch: Throwable -> L138
        String r137 = r122.a();     // Catch: Throwable -> L138
        if (r137 != null) goto L121;
        r137 = "";
    L121:
        List<Instruction> r138 = r122.f476027d;     // Catch: Throwable -> L138
        if (r138 != null) goto L124;
        Intrinsics.throwNpe();     // Catch: Throwable -> L138
    L124:
        ((ConcurrentHashMap) y97.b.f566987a).put(r137, r138);     // Catch: Throwable -> L138
    L125:
        List<Instruction> r139 = r122.f476027d;     // Catch: Throwable -> L138
        if (r139 != null) goto L128;
    L136:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L138
        goto L148
    L128:
        if ((!r139.isEmpty()) != true) goto L136;
        Map<String, List<Instruction>> r140 = y97.b.f566987a;     // Catch: Throwable -> L138
        String r141 = r122.a();     // Catch: Throwable -> L138
        if (r141 == null) goto L132;
        r128 = r141;
    L132:
        List<Instruction> r142 = r122.f476027d;     // Catch: Throwable -> L138
        if (r142 != null) goto L135;
        Intrinsics.throwNpe();     // Catch: Throwable -> L138
    L135:
        ((ConcurrentHashMap) y97.b.f566987a).put(r128, r142);     // Catch: Throwable -> L138
        goto L136
    L96:
        if ((!r131.isEmpty()) != true) goto L104;
        List<Instruction> r143 = r122.f476027d;     // Catch: Throwable -> L138
        if (r143 == null) goto L103;
        List<Instruction> r144 = r143;     // Catch: Throwable -> L138
        r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r144, 10));     // Catch: Throwable -> L138
        Iterator r145 = r144.iterator();     // Catch: Throwable -> L138
    L101:
        if (r145.hasNext() == false) goto L103;
        r101.add(com.bytedance.express.command.c.a((Instruction) r145.next(), com.bytedance.ruler.d.b().f243178a));     // Catch: Throwable -> L138
    L103:
        r122.f476024a = r101;     // Catch: Throwable -> L138
        goto L125
    L84:
        if (r127.isEmpty() == false) goto L86;
    L138:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L148
    L53:
        if (r123.intValue() != 2) goto L79;
        JsonElement r147 = r111.get("c_para");
        if (r147 != null) goto L57;
    L62:
        ?? r148 = 0;
    L63:
        if (r148 != 0) goto L66;
        r148 = CollectionsKt.emptyList();
    L66:
        r122.f476030g = r148;
        JsonElement r149 = r111.get("c_type");
        if (r149 == null) goto L69;
        int r150 = r149.getAsInt();
    L70:
        r122.f476031h = Integer.valueOf(r150);
        JsonElement r151 = r111.get("c_limi");
        if (r151 == null) goto L73;
        int r152 = r151.getAsInt();
    L74:
        r122.f476032i = Integer.valueOf(r152);
        JsonElement r153 = r111.get("c_ival");
        if (r153 == null) goto L77;
        long r154 = r153.getAsLong();
    L78:
        r122.f476033j = Long.valueOf(r154);
        goto L79
    L77:
        r154 = 0;
        goto L78
    L73:
        r152 = 0;
        goto L74
    L69:
        r150 = 1;
        goto L70
    L57:
        if (r147.isJsonArray() == false) goto L62;
        r148 = new ArrayList();
        Iterator<JsonElement> r155 = r147.getAsJsonArray().iterator();
    L60:
        if (r155.hasNext() == false) goto L63;
        r148.add(r155.next().getAsString());
        goto L60
    L48:
        r121 = 0;
    L44:
        r118 = null;
        goto L45
    L16:
        r106 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    }

    public static List c(JsonElement r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isJsonArray() == false) goto L20;
        ArrayList r101 = new ArrayList();
        Iterator<JsonElement> r102 = r100.getAsJsonArray().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        fa7.a r103 = b(r102.next().getAsJsonObject());
        if (r103 == null) goto L8;
        r101.add(r103);
        goto L8
    L12:
        return r101;
    L20:
        return null;
    }
}
