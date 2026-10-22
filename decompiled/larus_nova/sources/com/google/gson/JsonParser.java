package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class JsonParser {
    public JsonParser() {
    }

    public static JsonElement parseReader(JsonReader r100) throws JsonIOException, JsonSyntaxException {
        boolean r101 = r100.isLenient();
        r100.setLenient(true);
        JsonElement r102 = Streams.parse(r100);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r100.setLenient(r101);
        return r102;
    L6:
        th = move-exception;
        r100.setLenient(r101);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r100 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r100 + " to Json", e);     // Catch: Throwable -> L6
    }

    public static JsonElement parseString(String r100) throws JsonSyntaxException {
        return parseReader(new StringReader(r100));
    }

    public JsonElement parse(JsonReader r100) throws JsonIOException, JsonSyntaxException {
        return parseReader(r100);
    }

    public static JsonElement parseReader(Reader r100) throws JsonIOException, JsonSyntaxException {
        JsonReader r101 = new JsonReader(r100);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        JsonElement r102 = parseReader(r101);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        if (r102.isJsonNull() == false) goto L5;
    L9:
        return r102;
    L5:
        if (r101.peek() == JsonToken.END_DOCUMENT) goto L9;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
    L16:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L13:
        e = move-exception;
        throw new JsonIOException(e);
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public JsonElement parse(Reader r100) throws JsonIOException, JsonSyntaxException {
        return parseReader(r100);
    }

    public JsonElement parse(String r100) throws JsonSyntaxException {
        return parseString(r100);
    }
}
