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
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r100) {
            this.this$0 = r100;
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r100) {
            return this.this$0.gson.toJsonTree(r100);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r100, Type r101) throws JsonParseException {
            return (R) this.this$0.gson.fromJson(r100, r101);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r100, Type r101) {
            return this.this$0.gson.toJsonTree(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
            TypeToken<?> r102 = this.exactType;
            if (r102 != null) goto L5;
            boolean r103 = this.hierarchyType.isAssignableFrom(r101.getRawType());
        L14:
            if (r103 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.serializer, this.deserializer, r100, r101, this);
        L5:
            if (r102.equals(r101) == false) goto L7;
        L12:
            r103 = true;
            goto L14
        L7:
            if (this.matchRawType == true) goto L9;
        L11:
            r103 = false;
            goto L14
        L9:
            if (this.exactType.getType() != r101.getRawType()) goto L11;
            goto L11
        }

        public SingleTypeFactory(Object r100, TypeToken<?> r101, boolean r102, Class<?> r103) {
            JsonDeserializer<?> r104 = null;
            if ((r100 instanceof JsonSerializer) == false) goto L5;
            JsonSerializer<?> r105 = (JsonSerializer) r100;
        L6:
            this.serializer = r105;
            if ((r100 instanceof JsonDeserializer) == false) goto L9;
            r104 = (JsonDeserializer) r100;
        L9:
            this.deserializer = r104;
            if (r105 != null) goto L14;
            if (r104 != null) goto L14;
            boolean r106 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r106);
            this.exactType = r101;
            this.matchRawType = r102;
            this.hierarchyType = r103;
            return;
        L14:
            r106 = true;
            goto L15
        L5:
            r105 = null;
            goto L6
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r100 = this.delegate;
        if (r100 != null) goto L7;
        TypeAdapter<T> r101 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer == null) goto L6;
        return this;
    L6:
        return delegate();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r100) throws IOException {
        if (this.deserializer == null) goto L5;
        JsonElement r101 = Streams.parse(r100);
        if (this.nullSafe == false) goto L13;
        if (r101.isJsonNull() == false) goto L13;
        return null;
    L13:
        return this.deserializer.deserialize(r101, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r100);
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r100, Object r101) {
        return new SingleTypeFactory(r101, r100, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r100, Object r101) {
        if (r100.getType() != r100.getRawType()) goto L5;
        boolean r102 = true;
    L7:
        return new SingleTypeFactory(r101, r100, r102, null);
    L5:
        r102 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r100, Object r101) {
        return new SingleTypeFactory(r101, null, false, r100);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r100, T r101) throws IOException {
        JsonSerializer<T> r102 = this.serializer;
        if (r102 != null) goto L7;
        delegate().write(r100, r101);
        return;
    L7:
        if (this.nullSafe == false) goto L11;
        if (r101 != null) goto L11;
        r100.nullValue();
        return;
    L11:
        Streams.write(r102.serialize(r101, this.typeToken.getType(), this.context), r100);
    }

    public TreeTypeAdapter(JsonSerializer<T> r100, JsonDeserializer<T> r101, Gson r110, TypeToken<T> r111, TypeAdapterFactory r112) {
        this(r100, r101, r110, r111, r112, true);
    }

    public TreeTypeAdapter(JsonSerializer<T> r100, JsonDeserializer<T> r101, Gson r102, TypeToken<T> r103, TypeAdapterFactory r104, boolean r105) {
        this.context = new GsonContextImpl(this, null);
        this.serializer = r100;
        this.deserializer = r101;
        this.gson = r102;
        this.typeToken = r103;
        this.skipPast = r104;
        this.nullSafe = r105;
    }
}
