package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J'\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000e*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/oppanel/SheetItemCompatDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "parseListAsStringArray", "", "", "element", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonDeserializationContext;)[Ljava/lang/String;", "parseAnyAsString", "primitiveToString", "p", "Lcom/google/gson/JsonPrimitive;", "getAsStringOrNull", "Lcom/google/gson/JsonObject;", "memberName", "getAsBooleanOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getAsIntOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetItemCompatDeserializer implements JsonDeserializer<SheetItem> {
    public SheetItemCompatDeserializer() {
    }

    public static String d(JsonPrimitive r100) {
        if (r100.isString() == false) goto L6;
        return r100.getAsString();
    L6:
        if (r100.isBoolean() == false) goto L9;
        return String.valueOf(r100.getAsBoolean());
    L9:
        if (r100.isNumber() == false) goto L12;
        return r100.getAsNumber().toString();
    L12:
        return r100.toString();
    }

    public static Boolean a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        Object r103 = null;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r102.getAsBoolean()));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r103 = r105;
    L17:
        return (Boolean) r103;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static Integer b(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        Object r103 = null;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r102.getAsInt()));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r103 = r105;
    L17:
        return (Integer) r103;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static String c(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        Object r103 = null;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L18;
        return null;
    L18:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(r102.getAsString());     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r103 = r105;
    L17:
        return (String) r103;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.google.gson.JsonDeserializer
    public final SheetItem deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.isJsonObject() == false) goto L91;
        JsonObject r103 = r100.getAsJsonObject();
        SheetItem r104 = new SheetItem();
        Intrinsics.checkNotNull(r103);
        r104.setId(c(r103, "id"));
        r104.setTitle(c(r103, "title"));
        r104.setValue(c(r103, "value"));
        r104.setInfo(c(r103, "info"));
        r104.setType(c(r103, "type"));
        r104.setIconKey(c(r103, "iconKey"));
        r104.setGroupId(c(r103, "groupId"));
        Boolean r105 = a(r103, "selected");
        if (r105 == null) goto L7;
        r104.setSelected(r105.booleanValue());
    L7:
        Boolean r106 = a(r103, "enable");
        if (r106 == null) goto L10;
        r104.setEnable(r106.booleanValue());
    L10:
        Boolean r107 = a(r103, "adminLimit");
        if (r107 == null) goto L13;
        r104.setAdminLimit(r107.booleanValue());
    L13:
        Integer r108 = b(r103, BitableFieldEditAnalytic.ProgressFieldEditScene.MIN);
        if (r108 == null) goto L16;
        r104.setMin(r108.intValue());
    L16:
        Integer r109 = b(r103, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX);
        if (r109 == null) goto L19;
        r104.setMax(r109.intValue());
    L19:
        String r110 = c(r103, "groupPosition");
        SheetItem[] r111 = null;
        if (r110 != null) goto L94;
    L31:
        JsonElement r112 = r103.get("list");
        if (r112 != null) goto L34;
    L65:
        String[] r113 = null;
    L66:
        r104.setList(r113);
        JsonElement r114 = r103.get("items");
        if (r114 != null) goto L69;
    L89:
        return r104;
    L69:
        if (r114.isJsonArray() == false) goto L89;
        JsonArray r115 = r114.getAsJsonArray();
        ArrayList r116 = new ArrayList(r115.size());
        Iterator<JsonElement> r117 = r115.iterator();
    L72:
        if (r117.hasNext() == false) goto L85;
        JsonElement r118 = r117.next();
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L76
        Object r120 = Result.m9449constructorimpl((SheetItem) r102.deserialize(r118, SheetItem.class));     // Catch: Throwable -> L76
    L79:
        if (Result.m9455isFailureimpl(r120) == false) goto L81;
        r120 = null;
    L81:
        SheetItem r121 = (SheetItem) r120;
        if (r121 == null) goto L72;
        r116.add(r121);
    L76:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L79
    L85:
        if (r116.isEmpty() == true) goto L88;
        r111 = (SheetItem[]) r116.toArray(new SheetItem[0]);
    L88:
        r104.setItems(r111);
        goto L89
    L34:
        if (r112.isJsonNull() == true) goto L65;
        if (r112.isJsonArray() == false) goto L58;
        JsonArray r123 = r112.getAsJsonArray();
        ArrayList r124 = new ArrayList(r123.size());
        Iterator<JsonElement> r125 = r123.iterator();
    L40:
        if (r125.hasNext() == false) goto L54;
        JsonElement r126 = r125.next();
        if (r126 != null) goto L44;
    L50:
        String r127 = null;
    L51:
        if (r127 == null) goto L40;
        r124.add(r127);
        goto L40
    L44:
        if (r126.isJsonNull() == true) goto L50;
        if (r126.isJsonPrimitive() == false) goto L49;
        r127 = d(r126.getAsJsonPrimitive());
        goto L51
    L49:
        r127 = r126.toString();
        goto L51
    L54:
        if (r124.isEmpty() == true) goto L65;
        r113 = (String[]) r124.toArray(new String[0]);
        goto L66
    L58:
        if (r112.isJsonObject() == false) goto L62;
        String[] r128 = {r112.toString()};
    L60:
        r113 = r128;
        goto L66
    L62:
        if (r112.isJsonPrimitive() == false) goto L64;
        JsonPrimitive r129 = r112.getAsJsonPrimitive();
        Intrinsics.checkNotNull(r129);
        r128 = new String[]{d(r129)};
        goto L60
    L64:
        r128 = new String[]{r112.toString()};
        goto L60
    L94:
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L23
        Object r131 = Result.m9449constructorimpl(SheetItem.GroupPosition.valueOf(r110));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r131) == false) goto L28;
        r131 = null;
    L28:
        SheetItem.GroupPosition r132 = (SheetItem.GroupPosition) r131;
        if (r132 == null) goto L31;
        r104.setGroupPosition(r132);
    L23:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L91:
        throw new JsonParseException("SheetItem json is not object");
    }
}
