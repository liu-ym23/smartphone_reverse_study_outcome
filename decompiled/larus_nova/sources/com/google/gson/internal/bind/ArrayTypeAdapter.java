package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L6;
        r100.nextNull();
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        r100.beginArray();
    L8:
        if (r100.hasNext() == false) goto L10;
        r101.add(this.componentTypeAdapter.read(r100));
        goto L8
    L10:
        r100.endArray();
        int r102 = r101.size();
        if (this.componentType.isPrimitive() == false) goto L17;
        Object r103 = Array.newInstance(this.componentType, r102);
        int r104 = 0;
    L13:
        if (r104 >= r102) goto L15;
        Array.set(r103, r104, r101.get(r104));
        r104 = r104 + 1;
        goto L13
    L15:
        return r103;
    L17:
        return r101.toArray((Object[]) Array.newInstance(this.componentType, r102));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r100, Object r101) throws IOException {
        if (r101 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.beginArray();
        int r102 = Array.getLength(r101);
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        Object r104 = Array.get(r101, r103);
        this.componentTypeAdapter.write(r100, (E) r104);
        r103 = r103 + 1;
        goto L6
    L8:
        r100.endArray();
    }

    public ArrayTypeAdapter(Gson r100, TypeAdapter<E> r101, Class<E> r102) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r100, r101, r102);
        this.componentType = r102;
    }
}
