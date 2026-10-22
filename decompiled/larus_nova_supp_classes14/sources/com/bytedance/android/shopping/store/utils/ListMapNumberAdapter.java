package com.bytedance.android.shopping.store.utils;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/ListMapNumberAdapter;", "Lcom/google/gson/JsonSerializer;", "", "", "", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListMapNumberAdapter implements JsonSerializer<List<? extends Map<String, ? extends Object>>>, JsonDeserializer<List<? extends Map<String, ? extends Object>>> {
    public ListMapNumberAdapter() {
    }

    public final Object deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        if (r10 == null) goto L37;
        if (r10.isJsonArray() == false) goto L37;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.getAsJsonArray().iterator();
    L8:
        if (r14.hasNext() == false) goto L46;
        JsonElement r15 = (JsonElement) r14.next();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r16 = r15.getAsJsonObject().entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L35;
        Map.Entry r1 = (Map.Entry) r16.next();
        String r2 = (String) r1.getKey();
        JsonElement r3 = (JsonElement) r1.getValue();
        if (r3.isJsonPrimitive() == false) goto L34;
        JsonPrimitive r4 = r3.getAsJsonPrimitive();
        if (r4.isNumber() == false) goto L18;
        String r5 = r4.getAsString();
        if (StringsKt.contains$default(r5, '.', false, 2, null) == false) goto L24;
    L33:
        r3 = Double.valueOf(r4.getAsDouble());
        goto L34
    L24:
        if (StringsKt.contains(r5, 'e', true) == true) goto L33;
        long r6 = CastLongProtector.parseLong(r5);
        long r7 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= r6) goto L30;
    L32:
        r3 = Long.valueOf(r6);
        goto L34
    L30:
        if (r7 < r6) goto L32;
        r3 = Integer.valueOf((int) r6);
        goto L34
    L18:
        if (r4.isBoolean() == false) goto L20;
        r3 = Boolean.valueOf(r4.getAsBoolean());
        goto L34
    L20:
        r3 = r4.getAsString();
    L34:
        r0.put(r2, r3);
        goto L11
    L35:
        r13.add(r0);
        goto L8
    L46:
        return r13;
    L37:
        return CollectionsKt.emptyList();
    }

    public final JsonElement serialize(Object r12, Type r13, JsonSerializationContext r14) {
        List r15 = (List) r12;
        if (r15 == null) goto L38;
        JsonArray r16 = new JsonArray();
        Iterator r17 = r15.iterator();
    L7:
        if (r17.hasNext() == false) goto L33;
        Map r0 = (Map) r17.next();
        JsonObject r1 = new JsonObject();
        Iterator r2 = r0.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L31;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        Object r5 = r3.getValue();
        if (r14 != null) goto L14;
    L29:
        JsonElement r6 = new JsonPrimitive(r5.toString());
    L30:
        r1.add(r4, r6);
        goto L10
    L14:
        if ((r5 instanceof Number) == false) goto L24;
        Number r7 = (Number) r5;
        long r8 = r7.longValue();
        if (r8 != r7.doubleValue()) goto L23;
        long r9 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE > r8) goto L23;
        if (r9 < r8) goto L23;
        Object r10 = Integer.valueOf((int) r8);
    L27:
        r6 = r14.serialize(r10);
        if (r6 != null) goto L30;
    L23:
        r10 = Long.valueOf(r8);
        goto L27
    L24:
        if (r5 != null) goto L26;
        r10 = "";
        goto L27
    L26:
        r10 = r5;
        goto L27
    L31:
        r16.add(r1);
        goto L7
    L33:
        return r16;
    L38:
        return JsonNull.INSTANCE;
    }
}
