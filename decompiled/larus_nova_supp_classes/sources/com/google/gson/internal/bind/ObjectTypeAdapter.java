package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = null;
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    static {
        DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r1) {
        if (r1 != ToNumberPolicy.DOUBLE) goto L7;
        return DOUBLE_FACTORY;
    L7:
        return newFactory(r1);
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy r1) {
        return new AnonymousClass1(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r7) throws IOException {
        JsonToken r0 = r7.peek();
        Object r1 = tryBeginNesting(r7, r0);
        if (r1 == null) goto L5;
        ArrayDeque r2 = new ArrayDeque();
    L8:
        if (r7.hasNext() == true) goto L10;
        if ((r1 instanceof List) == false) goto L28;
        r7.endArray();
    L30:
        if (r2.isEmpty() == true) goto L31;
        r1 = r2.removeLast();
        goto L8
    L31:
        return r1;
    L28:
        r7.endObject();
        goto L30
    L10:
        if ((r1 instanceof Map) == false) goto L12;
        String r3 = r7.nextName();
    L13:
        JsonToken r4 = r7.peek();
        Object r5 = tryBeginNesting(r7, r4);
        if (r5 == null) goto L16;
        boolean r6 = true;
    L17:
        if (r5 != null) goto L20;
        r5 = readTerminal(r7, r4);
    L20:
        if ((r1 instanceof List) == false) goto L22;
        ((List) r1).add(r5);
    L23:
        if (r6 == false) goto L8;
        r2.addLast(r1);
        r1 = r5;
        goto L8
    L22:
        ((Map) r1).put(r3, r5);
        goto L23
    L16:
        r6 = false;
        goto L17
    L12:
        r3 = null;
        goto L13
    L5:
        return readTerminal(r7, r0);
    }

    private ObjectTypeAdapter(Gson r1, ToNumberStrategy r2) {
        this.gson = r1;
        this.toNumberStrategy = r2;
    }

    private Object readTerminal(JsonReader r3, JsonToken r4) throws IOException {
        int r0 = 2.$SwitchMap$com$google$gson$stream$JsonToken[r4.ordinal()];
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L15;
        if (r0 != 6) goto L13;
        r3.nextNull();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r4);
    L15:
        return Boolean.valueOf(r3.nextBoolean());
    L17:
        return this.toNumberStrategy.readNumber(r3);
    L19:
        return r3.nextString();
    }

    private Object tryBeginNesting(JsonReader r2, JsonToken r3) throws IOException {
        int r4 = 2.$SwitchMap$com$google$gson$stream$JsonToken[r3.ordinal()];
        if (r4 != 1) goto L5;
        r2.beginArray();
        return new ArrayList();
    L5:
        if (r4 == 2) goto L8;
        return null;
    L8:
        r2.beginObject();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r3, Object r4) throws IOException {
        if (r4 != null) goto L5;
        r3.nullValue();
        return;
    L5:
        TypeAdapter r0 = this.gson.getAdapter(r4.getClass());
        if ((r0 instanceof ObjectTypeAdapter) == false) goto L9;
        r3.beginObject();
        r3.endObject();
        return;
    L9:
        r0.write(r3, r4);
    }

    public /* synthetic */ ObjectTypeAdapter(Gson r1, ToNumberStrategy r2, AnonymousClass1 r3) {
        this(r1, r2);
    }
}
