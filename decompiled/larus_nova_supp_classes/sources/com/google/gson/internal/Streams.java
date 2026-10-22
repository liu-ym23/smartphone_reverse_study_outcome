package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r2) throws JsonParseException {
        r2.peek();     // Catch: NumberFormatException -> L8 IOException -> L11 MalformedJsonException -> L14 EOFException -> L17
        boolean r0 = false;
        return TypeAdapters.JSON_ELEMENT.read(r2);
    L6:
        e = e;
    L19:
        if (r0 == false) goto L23;
        return JsonNull.INSTANCE;
    L23:
        throw new JsonSyntaxException(e);
    L17:
        e = e;
        r0 = true;
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L11:
        e = move-exception;
        throw new JsonIOException(e);
    L8:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static Writer writerForAppendable(Appendable r1) {
        if ((r1 instanceof Writer) == false) goto L6;
        return (Writer) r1;
    L6:
        return new AppendableWriter(r1);
    }

    public static void write(JsonElement r1, JsonWriter r2) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(r2, r1);
    }
}
