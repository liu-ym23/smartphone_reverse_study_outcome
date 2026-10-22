package com.google.gson.internal.bind;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonTreeWriter extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED = null;
    private static final Writer UNWRITABLE_WRITER = null;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack;

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    static {
        UNWRITABLE_WRITER = new AnonymousClass1();
        SENTINEL_CLOSED = new JsonPrimitive(PTYSocketStateCallback.CLOSED);
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        List<JsonElement> r100 = this.stack;
        return r100.get(r100.size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray r100 = new JsonArray();
        put(r100);
        this.stack.add(r100);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject r100 = new JsonObject();
        put(r100);
        this.stack.add(r100);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.stack.isEmpty() == false) goto L7;
        this.stack.add(SENTINEL_CLOSED);
        return;
    L7:
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonArray) == false) goto L11;
        List<JsonElement> r100 = this.stack;
        r100.remove(r100.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        List<JsonElement> r100 = this.stack;
        r100.remove(r100.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    public JsonElement get() {
        if (this.stack.isEmpty() == false) goto L7;
        return this.product;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + this.stack);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    private void put(JsonElement r100) {
        if (this.pendingName == null) goto L11;
        if (r100.isJsonNull() == true) goto L7;
    L8:
        ((JsonObject) peek()).add(this.pendingName, r100);
    L9:
        this.pendingName = null;
        return;
    L7:
        if (getSerializeNulls() == false) goto L9;
    L11:
        if (this.stack.isEmpty() == false) goto L13;
        this.product = r100;
        return;
    L13:
        JsonElement r101 = peek();
        if ((r101 instanceof JsonArray) == false) goto L18;
        ((JsonArray) r101).add(r100);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter jsonValue(String r100) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String r100) throws IOException {
        Objects.requireNonNull(r100, "name == null");
        if (this.stack.isEmpty() == true) goto L13;
        if (this.pendingName != null) goto L13;
        if ((peek() instanceof JsonObject) == false) goto L11;
        this.pendingName = r100;
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number r100) throws IOException {
        if (r100 != null) goto L6;
        return nullValue();
    L6:
        if (isLenient() == true) goto L14;
        double r101 = r100.doubleValue();
        if (Double.isNaN(r101) == true) goto L13;
        if (Double.isInfinite(r101) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r100);
    L14:
        put(new JsonPrimitive(r100));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double r100) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        put(new JsonPrimitive(Double.valueOf(r100)));
        return this;
    L5:
        if (Double.isNaN(r100) == true) goto L10;
        if (Double.isInfinite(r100) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r100);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(float r100) throws IOException {
        if (isLenient() == false) goto L5;
    L11:
        put(new JsonPrimitive(Float.valueOf(r100)));
        return this;
    L5:
        if (Float.isNaN(r100) == true) goto L10;
        if (Float.isInfinite(r100) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r100);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean r100) throws IOException {
        if (r100 == null) goto L4;
        put(new JsonPrimitive(r100));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String r100) throws IOException {
        if (r100 == null) goto L4;
        put(new JsonPrimitive(r100));
        return this;
    L4:
        return nullValue();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long r100) throws IOException {
        put(new JsonPrimitive(Long.valueOf(r100)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean r100) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(r100)));
        return this;
    }
}
