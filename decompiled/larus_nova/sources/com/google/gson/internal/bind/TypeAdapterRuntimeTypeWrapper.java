package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    private static boolean isReflective(TypeAdapter<?> r100) {
    L3:
        if ((r100 instanceof SerializationDelegatingTypeAdapter) == false) goto L9;
        TypeAdapter<?> r101 = ((SerializationDelegatingTypeAdapter) r100).getSerializationDelegate();
        if (r101 == r100) goto L9;
        r100 = r101;
    L9:
        return r100 instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r100) throws IOException {
        return this.delegate.read(r100);
    }

    private static Type getRuntimeTypeIfMoreSpecific(Type r100, Object r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        if ((r100 instanceof Class) == true) goto L8;
        if ((r100 instanceof TypeVariable) == true) goto L8;
        return r100;
    L8:
        return r101.getClass();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r100, T r101) throws IOException {
        TypeAdapter r102 = this.delegate;
        Type r103 = getRuntimeTypeIfMoreSpecific(this.type, r101);
        if (r103 == this.type) goto L10;
        r102 = this.context.getAdapter(TypeToken.get(r103));
        if ((r102 instanceof ReflectiveTypeAdapterFactory.Adapter) == false) goto L10;
        if (isReflective(this.delegate) == true) goto L10;
        r102 = this.delegate;
    L10:
        r102.write(r100, r101);
    }

    public TypeAdapterRuntimeTypeWrapper(Gson r100, TypeAdapter<T> r101, Type r102) {
        this.context = r100;
        this.delegate = r101;
        this.type = r102;
    }
}
