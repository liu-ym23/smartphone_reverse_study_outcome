package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypeAdapter<T> {
    public abstract T read(JsonReader r100) throws IOException;

    public abstract void write(JsonWriter r100, T r101) throws IOException;

    public final TypeAdapter<T> nullSafe() {
        return new AnonymousClass1(this);
    }

    public TypeAdapter() {
    }

    public final T fromJson(Reader r100) throws IOException {
        return read(new JsonReader(r100));
    }

    public final T fromJsonTree(JsonElement r100) {
        return read(new JsonTreeReader(r100));
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final String toJson(T r100) {
        StringWriter r101 = new StringWriter();
        toJson(r101, r100);     // Catch: IOException -> L6
        return r101.toString();
    L6:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final JsonElement toJsonTree(T r100) {
        JsonTreeWriter r101 = new JsonTreeWriter();     // Catch: IOException -> L4
        write(r101, r100);     // Catch: IOException -> L4
        return r101.get();
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final T fromJson(String r100) throws IOException {
        return fromJson(new StringReader(r100));
    }

    public final void toJson(Writer r100, T r101) throws IOException {
        write(new JsonWriter(r100), r101);
    }
}
