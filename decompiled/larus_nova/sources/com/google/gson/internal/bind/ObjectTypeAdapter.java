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

/* JADX INFO: loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = null;
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r100) {
        if (r100 != ToNumberPolicy.DOUBLE) goto L7;
        return DOUBLE_FACTORY;
    L7:
        return newFactory(r100);
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy r100) {
        return new AnonymousClass1(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        Object r102 = tryBeginNesting(r100, r101);
        if (r102 == null) goto L5;
        ArrayDeque r103 = new ArrayDeque();
    L8:
        if (r100.hasNext() == true) goto L10;
        if ((r102 instanceof List) == false) goto L28;
        r100.endArray();
    L30:
        if (r103.isEmpty() == true) goto L31;
        r102 = r103.removeLast();
        goto L8
    L31:
        return r102;
    L28:
        r100.endObject();
        goto L30
    L10:
        if ((r102 instanceof Map) == false) goto L12;
        String r104 = r100.nextName();
    L13:
        JsonToken r105 = r100.peek();
        Object r106 = tryBeginNesting(r100, r105);
        if (r106 == null) goto L16;
        boolean r107 = true;
    L17:
        if (r106 != null) goto L20;
        r106 = readTerminal(r100, r105);
    L20:
        if ((r102 instanceof List) == false) goto L22;
        ((List) r102).add(r106);
    L23:
        if (r107 == false) goto L8;
        r103.addLast(r102);
        r102 = r106;
        goto L8
    L22:
        ((Map) r102).put(r104, r106);
        goto L23
    L16:
        r107 = false;
        goto L17
    L12:
        r104 = null;
        goto L13
    L5:
        return readTerminal(r100, r101);
    }

    private ObjectTypeAdapter(Gson r100, ToNumberStrategy r101) {
        this.gson = r100;
        this.toNumberStrategy = r101;
    }

    private Object readTerminal(JsonReader r100, JsonToken r101) throws IOException {
        int r102 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r101.ordinal()];
        if (r102 == 3) goto L19;
        if (r102 == 4) goto L17;
        if (r102 == 5) goto L15;
        if (r102 != 6) goto L13;
        r100.nextNull();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r101);
    L15:
        return Boolean.valueOf(r100.nextBoolean());
    L17:
        return this.toNumberStrategy.readNumber(r100);
    L19:
        return r100.nextString();
    }

    private Object tryBeginNesting(JsonReader r100, JsonToken r101) throws IOException {
        int r102 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.beginArray();
        return new ArrayList();
    L5:
        if (r102 == 2) goto L8;
        return null;
    L8:
        r100.beginObject();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r100, Object r101) throws IOException {
        if (r101 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        TypeAdapter r102 = this.gson.getAdapter(r101.getClass());
        if ((r102 instanceof ObjectTypeAdapter) == false) goto L9;
        r100.beginObject();
        r100.endObject();
        return;
    L9:
        r102.write(r100, r101);
    }

    public /* synthetic */ ObjectTypeAdapter(Gson r100, ToNumberStrategy r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
