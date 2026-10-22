package com.google.crypto.tink.internal;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class JsonParser {

    public static final class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
        private JsonElementTypeAdapter() {
        }

        public /* synthetic */ JsonElementTypeAdapter(int r100) {
            this();
        }

        @Override // com.google.gson.TypeAdapter
        public final JsonElement read(JsonReader r100) throws IOException {
            JsonToken r101 = r100.peek();
            JsonElement r102 = b(r100, r101);
            if (r102 == null) goto L57;
            ArrayDeque r103 = new ArrayDeque();
        L7:
            if (r100.hasNext() == true) goto L9;
            if ((r102 instanceof JsonArray) == false) goto L40;
            r100.endArray();
        L42:
            if (r103.isEmpty() == true) goto L44;
            r102 = (JsonElement) r103.removeLast();
            goto L7
        L44:
            return r102;
        L40:
            r100.endObject();
            goto L42
        L9:
            if ((r102 instanceof JsonObject) == false) goto L15;
            String r104 = r100.nextName();
            if (JsonParser.a(r104) == false) goto L14;
        L16:
            JsonToken r105 = r100.peek();
            JsonElement r106 = b(r100, r105);
            if (r106 == null) goto L19;
            boolean r107 = true;
        L20:
            if (r106 != null) goto L22;
            JsonElement r108 = a(r100, r105);
        L24:
            if ((r102 instanceof JsonArray) == false) goto L26;
            ((JsonArray) r102).add(r108);
        L29:
            if (r107 == false) goto L7;
            r103.addLast(r102);
            if (r103.size() > 100) goto L34;
            r102 = r108;
            goto L7
        L34:
            throw new IOException("too many recursions");
        L26:
            JsonObject r109 = (JsonObject) r102;
            if (r109.has(r104) == true) goto L36;
            r109.add(r104, r108);
            goto L29
        L36:
            throw new IOException("duplicate key: " + r104);
        L22:
            r108 = r106;
            goto L24
        L19:
            r107 = false;
            goto L20
        L14:
            throw new IOException("illegal characters in string");
        L15:
            r104 = null;
            goto L16
        L57:
            return a(r100, r101);
        }

        public static JsonElement a(JsonReader r100, JsonToken r101) throws IOException {
            int r102 = a.f275747a[r101.ordinal()];
            if (r102 != 3) goto L5;
            String r103 = r100.nextString();
            if (JsonParser.a(r103) == false) goto L23;
            return new JsonPrimitive(r103);
        L23:
            throw new IOException("illegal characters in string");
        L5:
            if (r102 == 4) goto L17;
            if (r102 == 5) goto L15;
            if (r102 != 6) goto L13;
            r100.nextNull();
            return JsonNull.INSTANCE;
        L13:
            throw new IllegalStateException("Unexpected token: " + r101);
        L15:
            return new JsonPrimitive(Boolean.valueOf(r100.nextBoolean()));
        L17:
            return new JsonPrimitive(new LazilyParsedNumber(r100.nextString()));
        }

        @Nullable
        public static JsonElement b(JsonReader r100, JsonToken r101) throws IOException {
            int r102 = a.f275747a[r101.ordinal()];
            if (r102 != 1) goto L5;
            r100.beginArray();
            return new JsonArray();
        L5:
            if (r102 == 2) goto L8;
            return null;
        L8:
            r100.beginObject();
            return new JsonObject();
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, JsonElement r101) throws IOException {
            throw new UnsupportedOperationException("write is not supported");
        }
    }

    public static final class LazilyParsedNumber extends Number {
        private final String value;

        private Object writeReplace() throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return CastDoubleProtector.parseDouble(this.value);
        }

        @Override // java.lang.Number
        public float floatValue() {
            return CastFloatProtector.parseFloat(this.value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            return CastIntegerProtector.parseInt(this.value);
        L4:
            return (int) CastLongProtector.parseLong(this.value);
        L8:
            return new BigDecimal(this.value).intValue();
        }

        @Override // java.lang.Number
        public long longValue() {
            return CastLongProtector.parseLong(this.value);
        L5:
            return new BigDecimal(this.value).longValue();
        }

        public String toString() {
            return this.value;
        }

        public LazilyParsedNumber(String r100) {
            this.value = r100;
        }

        private void readObject(ObjectInputStream r100) throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LazilyParsedNumber) == true) goto L8;
            return false;
        L8:
            return this.value.equals(((LazilyParsedNumber) r100).value);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275747a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f275747a = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f275747a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f275747a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f275747a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f275747a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f275747a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        new JsonElementTypeAdapter(0);
    }

    public static boolean a(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 == r101) goto L4;
        char r103 = r100.charAt(r102);
        r102 = r102 + 1;
        if (Character.isSurrogate(r103) == false) goto L3;
        if (Character.isLowSurrogate(r103) == true) goto L15;
        if (r102 == r101) goto L15;
        if (Character.isLowSurrogate(r100.charAt(r102)) == false) goto L15;
        r102 = r102 + 1;
    L15:
        return false;
    L4:
        return true;
    }
}
