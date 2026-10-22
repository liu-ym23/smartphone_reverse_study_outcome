package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = null;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r100;
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        LAZILY_PARSED_NUMBER_FACTORY = newFactory(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    private NumberTypeAdapter(ToNumberStrategy r100) {
        this.toNumberStrategy = r100;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r100) {
        if (r100 != ToNumberPolicy.LAZILY_PARSED_NUMBER) goto L7;
        return LAZILY_PARSED_NUMBER_FACTORY;
    L7:
        return newFactory(r100);
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy r100) {
        final NumberTypeAdapter r101 = new NumberTypeAdapter(r100);
        return new AnonymousClass1(r101);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.nextNull();
        return null;
    L5:
        if (r102 == 2) goto L12;
        if (r102 == 3) goto L12;
        throw new JsonSyntaxException("Expecting number, got: " + r101 + "; at path " + r100.getPath());
    L12:
        return this.toNumberStrategy.readNumber(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number read(JsonReader r100) throws IOException {
        return read(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Number r101) throws IOException {
        write2(r100, r101);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Number r101) throws IOException {
        r100.value(r101);
    }
}
