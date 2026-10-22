package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final <E extends Enum<E>> E d(Class<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "enumClass");
        return (E) ArraysKt.first(r100.getEnumConstants());
    }

    public static final Boolean c(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Boolean.valueOf(r102.getAsBoolean());
    }

    public static final Integer e(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Integer.valueOf(r102.getAsInt());
    }

    public static final Long f(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Long.valueOf(r102.getAsLong());
    }

    public static final String l(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.isJsonNull() == false) goto L9;
        return null;
    L9:
        return r102.getAsString();
    }

    public static final <T> List<T> b(JsonObject r100, String r101, TypeAdapter<List<T>> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "adapter");
        JsonElement r103 = r100.get(r101);
        if (r103 != null) goto L6;
        return null;
    L6:
        if (r103.isJsonNull() == false) goto L9;
        return null;
    L9:
        return r102.fromJsonTree(r103);
    }

    public static final void g(JsonObject r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r102 == null) goto L5;
        JsonElement r103 = new JsonPrimitive(r102);
    L6:
        r100.add(r101, r103);
        return;
    L5:
        r103 = JsonNull.INSTANCE;
        goto L6
    }

    public static final void h(JsonObject r100, String r101, Number r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r102 == null) goto L5;
        JsonElement r103 = new JsonPrimitive(r102);
    L6:
        r100.add(r101, r103);
        return;
    L5:
        r103 = JsonNull.INSTANCE;
        goto L6
    }

    public static final void j(JsonObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r102 == null) goto L5;
        JsonElement r103 = new JsonPrimitive(r102);
    L6:
        r100.add(r101, r103);
        return;
    L5:
        r103 = JsonNull.INSTANCE;
        goto L6
    }

    public static final <T> T k(JsonObject r100, String r101, TypeAdapter<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "adapter");
        JsonElement r103 = r100.get(r101);
        if (r103 != null) goto L6;
        return null;
    L6:
        if (r103.isJsonNull() == false) goto L9;
        return null;
    L9:
        return r102.fromJsonTree(r103);
    }

    public static final <T> void a(JsonObject r100, String r101, List<? extends T> r102, TypeAdapter<List<T>> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "adapter");
        if (r102 != null) goto L5;
        JsonElement r104 = JsonNull.INSTANCE;
    L6:
        r100.add(r101, r104);
        return;
    L5:
        r104 = r103.toJsonTree(r102);
        goto L6
    }

    public static final <T> void i(JsonObject r100, String r101, T r102, TypeAdapter<T> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "adapter");
        if (r102 != null) goto L5;
        JsonElement r104 = JsonNull.INSTANCE;
    L6:
        r100.add(r101, r104);
        return;
    L5:
        r104 = r103.toJsonTree(r102);
        goto L6
    }
}
