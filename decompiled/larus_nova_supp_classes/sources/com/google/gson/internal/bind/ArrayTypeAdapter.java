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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r5) throws IOException {
        if (r5.peek() != JsonToken.NULL) goto L6;
        r5.nextNull();
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        r5.beginArray();
    L8:
        if (r5.hasNext() == false) goto L10;
        r0.add(this.componentTypeAdapter.read(r5));
        goto L8
    L10:
        r5.endArray();
        int r6 = r0.size();
        if (this.componentType.isPrimitive() == false) goto L17;
        Object r1 = Array.newInstance(this.componentType, r6);
        int r2 = 0;
    L13:
        if (r2 >= r6) goto L15;
        Array.set(r1, r2, r0.get(r2));
        r2 = r2 + 1;
        goto L13
    L15:
        return r1;
    L17:
        return r0.toArray((Object[]) Array.newInstance(this.componentType, r6));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, Object r6) throws IOException {
        if (r6 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        r5.beginArray();
        int r0 = Array.getLength(r6);
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Object r2 = Array.get(r6, r1);
        this.componentTypeAdapter.write(r5, (E) r2);
        r1 = r1 + 1;
        goto L6
    L8:
        r5.endArray();
    }

    public ArrayTypeAdapter(Gson r2, TypeAdapter<E> r3, Class<E> r4) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r2, r3, r4);
        this.componentType = r4;
    }
}
