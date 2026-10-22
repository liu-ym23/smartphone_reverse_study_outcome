package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r1) {
            this.this$0 = r1;
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r2) {
            return this.this$0.gson.toJsonTree(r2);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter r1, 1 r2) {
            this(r1);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r2, Type r3) throws JsonParseException {
            return (R) this.this$0.gson.fromJson(r2, r3);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r2, Type r3) {
            return this.this$0.gson.toJsonTree(r2, r3);
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r0 = this.delegate;
        if (r0 != null) goto L7;
        TypeAdapter<T> r1 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer == null) goto L6;
        return this;
    L6:
        return delegate();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r4) throws IOException {
        if (this.deserializer == null) goto L5;
        JsonElement r5 = Streams.parse(r4);
        if (this.nullSafe == false) goto L13;
        if (r5.isJsonNull() == false) goto L13;
        return null;
    L13:
        return this.deserializer.deserialize(r5, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r4);
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r3, Object r4) {
        return new SingleTypeFactory(r4, r3, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r3, Object r4) {
        if (r3.getType() != r3.getRawType()) goto L5;
        boolean r0 = true;
    L7:
        return new SingleTypeFactory(r4, r3, r0, null);
    L5:
        r0 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r3, Object r4) {
        return new SingleTypeFactory(r4, null, false, r3);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r4, T r5) throws IOException {
        JsonSerializer<T> r0 = this.serializer;
        if (r0 != null) goto L7;
        delegate().write(r4, r5);
        return;
    L7:
        if (this.nullSafe == false) goto L11;
        if (r5 != null) goto L11;
        r4.nullValue();
        return;
    L11:
        Streams.write(r0.serialize(r5, this.typeToken.getType(), this.context), r4);
    }

    public TreeTypeAdapter(JsonSerializer<T> r8, JsonDeserializer<T> r9, Gson r10, TypeToken<T> r11, TypeAdapterFactory r12) {
        this(r8, r9, r10, r11, r12, true);
    }

    public TreeTypeAdapter(JsonSerializer<T> r3, JsonDeserializer<T> r4, Gson r5, TypeToken<T> r6, TypeAdapterFactory r7, boolean r8) {
        this.context = new GsonContextImpl(this, null);
        this.serializer = r3;
        this.deserializer = r4;
        this.gson = r5;
        this.typeToken = r6;
        this.skipPast = r7;
        this.nullSafe = r8;
    }
}
