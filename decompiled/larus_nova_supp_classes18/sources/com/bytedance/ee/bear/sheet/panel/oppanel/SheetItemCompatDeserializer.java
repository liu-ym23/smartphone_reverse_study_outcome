package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J'\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000e*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/oppanel/SheetItemCompatDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "parseListAsStringArray", "", "", "element", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonDeserializationContext;)[Ljava/lang/String;", "parseAnyAsString", "primitiveToString", "p", "Lcom/google/gson/JsonPrimitive;", "getAsStringOrNull", "Lcom/google/gson/JsonObject;", "memberName", "getAsBooleanOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getAsIntOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetItemCompatDeserializer implements JsonDeserializer<SheetItem> {
    public SheetItemCompatDeserializer() {
    }

    public static String d(JsonPrimitive r1) {
        if (r1.isString() == false) goto L6;
        return r1.getAsString();
    L6:
        if (r1.isBoolean() == false) goto L9;
        return String.valueOf(r1.getAsBoolean());
    L9:
        if (r1.isNumber() == false) goto L12;
        return r1.getAsNumber().toString();
    L12:
        return r1.toString();
    }

    public static Boolean a(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        Object r4 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(Boolean.valueOf(r3.getAsBoolean()));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r4 = r5;
    L17:
        return (Boolean) r4;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static Integer b(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        Object r4 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(Integer.valueOf(r3.getAsInt()));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r4 = r5;
    L17:
        return (Integer) r4;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static String c(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        Object r4 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl(r3.getAsString());     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r4 = r5;
    L17:
        return (String) r4;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final Object deserialize(JsonElement r7, Type r8, JsonDeserializationContext r9) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Intrinsics.checkNotNullParameter(r8, "typeOfT");
        Intrinsics.checkNotNullParameter(r9, "context");
        if (r7.isJsonObject() == false) goto L91;
        JsonObject r10 = r7.getAsJsonObject();
        SheetItem r11 = new SheetItem();
        Intrinsics.checkNotNull(r10);
        r11.setId(c(r10, ResourceData.KEY_ID));
        r11.setTitle(c(r10, "title"));
        r11.setValue(c(r10, "value"));
        r11.setInfo(c(r10, "info"));
        r11.setType(c(r10, ResourceData.KEY_TYPE));
        r11.setIconKey(c(r10, "iconKey"));
        r11.setGroupId(c(r10, "groupId"));
        Boolean r0 = a(r10, "selected");
        if (r0 == null) goto L7;
        r11.setSelected(r0.booleanValue());
    L7:
        Boolean r1 = a(r10, "enable");
        if (r1 == null) goto L10;
        r11.setEnable(r1.booleanValue());
    L10:
        Boolean r2 = a(r10, "adminLimit");
        if (r2 == null) goto L13;
        r11.setAdminLimit(r2.booleanValue());
    L13:
        Integer r3 = b(r10, "min");
        if (r3 == null) goto L16;
        r11.setMin(r3.intValue());
    L16:
        Integer r4 = b(r10, "max");
        if (r4 == null) goto L19;
        r11.setMax(r4.intValue());
    L19:
        String r5 = c(r10, "groupPosition");
        SheetItem[] r6 = null;
        if (r5 != null) goto L94;
    L31:
        JsonElement r12 = r10.get("list");
        if (r12 != null) goto L34;
    L65:
        String[] r13 = null;
    L66:
        r11.setList(r13);
        JsonElement r14 = r10.get("items");
        if (r14 != null) goto L69;
    L89:
        return r11;
    L69:
        if (r14.isJsonArray() == false) goto L89;
        JsonArray r15 = r14.getAsJsonArray();
        ArrayList r16 = new ArrayList(r15.size());
        Iterator r17 = r15.iterator();
    L72:
        if (r17.hasNext() == false) goto L85;
        JsonElement r18 = (JsonElement) r17.next();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L76
        Object r20 = Result.constructor-impl((SheetItem) r9.deserialize(r18, SheetItem.class));     // Catch: Throwable -> L76
    L79:
        if (Result.isFailure-impl(r20) == false) goto L81;
        r20 = null;
    L81:
        SheetItem r21 = (SheetItem) r20;
        if (r21 == null) goto L72;
        r16.add(r21);
    L76:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L85:
        if (r16.isEmpty() == true) goto L88;
        r6 = (SheetItem[]) r16.toArray(new SheetItem[0]);
    L88:
        r11.setItems(r6);
        goto L89
    L34:
        if (r12.isJsonNull() == true) goto L65;
        if (r12.isJsonArray() == false) goto L58;
        JsonArray r23 = r12.getAsJsonArray();
        ArrayList r24 = new ArrayList(r23.size());
        Iterator r25 = r23.iterator();
    L40:
        if (r25.hasNext() == false) goto L54;
        JsonElement r26 = (JsonElement) r25.next();
        if (r26 != null) goto L44;
    L50:
        String r27 = null;
    L51:
        if (r27 == null) goto L40;
        r24.add(r27);
        goto L40
    L44:
        if (r26.isJsonNull() == true) goto L50;
        if (r26.isJsonPrimitive() == false) goto L49;
        r27 = d(r26.getAsJsonPrimitive());
        goto L51
    L49:
        r27 = r26.toString();
        goto L51
    L54:
        if (r24.isEmpty() == true) goto L65;
        r13 = (String[]) r24.toArray(new String[0]);
        goto L66
    L58:
        if (r12.isJsonObject() == false) goto L62;
        String[] r28 = {r12.toString()};
    L60:
        r13 = r28;
        goto L66
    L62:
        if (r12.isJsonPrimitive() == false) goto L64;
        JsonPrimitive r29 = r12.getAsJsonPrimitive();
        Intrinsics.checkNotNull(r29);
        r28 = new String[]{d(r29)};
        goto L60
    L64:
        r28 = new String[]{r12.toString()};
        goto L60
    L94:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L23
        Object r31 = Result.constructor-impl(SheetItem.GroupPosition.valueOf(r5));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r31) == false) goto L28;
        r31 = null;
    L28:
        SheetItem.GroupPosition r32 = (SheetItem.GroupPosition) r31;
        if (r32 == null) goto L31;
        r11.setGroupPosition(r32);
    L23:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L91:
        throw new JsonParseException("SheetItem json is not object");
    }
}
