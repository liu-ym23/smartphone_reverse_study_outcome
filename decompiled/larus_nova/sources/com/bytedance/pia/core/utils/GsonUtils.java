package com.bytedance.pia.core.utils;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class GsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f266370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f266371b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JsonParser f266372c = null;

    @Target({ElementType.FIELD})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$Exclude;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface Exclude {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$JSONArrayAdapter;", "Lcom/google/gson/TypeAdapter;", "Lorg/json/JSONArray;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class JSONArrayAdapter extends TypeAdapter<JSONArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JSONArrayAdapter f266373a = null;

        static {
            f266373a = new JSONArrayAdapter();
        }

        private JSONArrayAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final JSONArray read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            JsonElement r101 = GsonUtils.f266372c.parse(r100);
            if (r101.isJsonArray() == true) goto L6;
            r101 = null;
        L6:
            if (r101 == null) goto L11;
            JsonArray r102 = r101.getAsJsonArray();
            if (r102 != null) goto L10;
            return null;
        L10:
            return GsonUtils.f(r102);
        L11:
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, JSONArray r101) {
            JSONArray r102 = r101;
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            Intrinsics.checkNotNullParameter(r102, "value");
            GsonUtils.h(r100, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/pia/core/utils/GsonUtils$JSONObjectAdapter;", "Lcom/google/gson/TypeAdapter;", "Lorg/json/JSONObject;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class JSONObjectAdapter extends TypeAdapter<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JSONObjectAdapter f266374a = null;

        static {
            f266374a = new JSONObjectAdapter();
        }

        private JSONObjectAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final JSONObject read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            JsonElement r101 = GsonUtils.f266372c.parse(r100);
            if (r101.isJsonObject() == true) goto L6;
            r101 = null;
        L6:
            if (r101 == null) goto L11;
            JsonObject r102 = r101.getAsJsonObject();
            if (r102 != null) goto L10;
            return null;
        L10:
            return GsonUtils.g(r102);
        L11:
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, JSONObject r101) {
            JSONObject r102 = r101;
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            Intrinsics.checkNotNullParameter(r102, "value");
            GsonUtils.i(r100, r102);
        }
    }

    public static final class a implements ExclusionStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f266375a = null;

        static {
            f266375a = new a();
        }

        public a() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public final boolean shouldSkipClass(Class<?> r100) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public final boolean shouldSkipField(FieldAttributes r100) {
            Intrinsics.checkNotNullParameter(r100, "field");
            if (r100.getAnnotation(Exclude.class) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f266370a = LazyKt.lazy(GsonUtils$gson$2.INSTANCE);
        f266371b = LazyKt.lazy(GsonUtils$unsafeGson$2.INSTANCE);
        f266372c = new JsonParser();
    }

    public static final Gson b() {
        return (Gson) f266370a.getValue();
    }

    @JvmStatic
    public static final JSONArray f(JsonArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONArray r101 = new JSONArray();
        Iterator<JsonElement> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        JsonElement r103 = r102.next();
        if ((r103 instanceof JsonObject) == true) goto L7;
        if ((r103 instanceof JsonArray) == true) goto L10;
        if ((r103 instanceof JsonNull) == true) goto L13;
        if ((r103 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r104 = (JsonPrimitive) r103;
        if (r104.isBoolean() == true) goto L18;
        if (r104.isString() == true) goto L21;
        if (r104.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r104.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r101.put(r104.getAsNumber().longValue());
        goto L4
    L26:
        r101.put(r104.getAsNumber().doubleValue());
        goto L4
    L21:
        r101.put(r104.getAsString());
        goto L4
    L18:
        r101.put(r104.getAsBoolean());
        goto L4
    L13:
        r101.put(JSONObject.NULL);
        goto L4
    L10:
        r101.put(f((JsonArray) r103));
        goto L4
    L7:
        r101.put(g((JsonObject) r103));
        goto L4
    L28:
        return r101;
    }

    @JvmStatic
    public static final JSONObject g(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        JsonElement r105 = (JsonElement) r103.getValue();
        if ((r105 instanceof JsonObject) == true) goto L7;
        if ((r105 instanceof JsonArray) == true) goto L10;
        if ((r105 instanceof JsonNull) == true) goto L13;
        if ((r105 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r106 = (JsonPrimitive) r105;
        if (r106.isBoolean() == true) goto L18;
        if (r106.isString() == true) goto L21;
        if (r106.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r106.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r101.put(r104, r106.getAsNumber().longValue());
        goto L4
    L26:
        r101.put(r104, r106.getAsNumber().doubleValue());
        goto L4
    L21:
        r101.put(r104, r106.getAsString());
        goto L4
    L18:
        r101.put(r104, r106.getAsBoolean());
        goto L4
    L13:
        r101.put(r104, JSONObject.NULL);
        goto L4
    L10:
        r101.put(r104, f((JsonArray) r105));
        goto L4
    L7:
        r101.put(r104, g((JsonObject) r105));
        goto L4
    L28:
        return r101;
    }

    @JvmStatic
    public static final <T> T a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L18;
        return null;
    L18:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(b().fromJson(r100, r101));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        return null;
    L17:
        return (T) r104;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r102 = false;
        goto L7
    }

    public static void c(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Iterator<String> r103 = r101.keys();     // Catch: Throwable -> L9
    L5:
        if (r103.hasNext() == false) goto L7;
        String r104 = r103.next();     // Catch: Throwable -> L9
        e(r100, r104, r101.get(r104));     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r105 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L15;
        r105 = new JSONObject();
    L15:
        JSONObject r106 = (JSONObject) r105;
        return;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static void d(Object r100, JsonWriter r101) {
        if ((r100 instanceof Boolean) == false) goto L6;
        r101.value(((Boolean) r100).booleanValue());
        return;
    L6:
        if ((r100 instanceof Number) == false) goto L9;
        r101.value((Number) r100);
        return;
    L9:
        if ((r100 instanceof String) == false) goto L12;
        r101.value((String) r100);
        return;
    L12:
        if ((r100 instanceof JSONObject) == false) goto L15;
        i(r101, (JSONObject) r100);
        return;
    L15:
        if ((r100 instanceof JSONArray) == false) goto L17;
        h(r101, (JSONArray) r100);
        return;
    L17:
        r101.nullValue();
    }

    public static void h(JsonWriter r100, JSONArray r101) {
        r100.beginArray();
        int r102 = r101.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        d(r101.opt(r103), r100);
        r103 = r103 + 1;
        goto L3
    L5:
        r100.endArray();
    }

    public static void i(JsonWriter r100, JSONObject r101) {
        r100.beginObject();
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r100.name(r103);
        d(r101.opt(r103), r100);
        goto L4
    L6:
        r100.endObject();
    }

    public static void e(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r100 = r100.put(r101, r102);     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L14;
        r104 = new JSONObject();
    L14:
        JSONObject r105 = (JSONObject) r104;
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
