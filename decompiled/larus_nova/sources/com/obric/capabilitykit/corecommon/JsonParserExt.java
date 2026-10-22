package com.obric.capabilitykit.corecommon;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/corecommon/JsonParserExt;", "", "()V", "parseReader", "Lcom/google/gson/JsonElement;", "reader", "Lcom/google/gson/stream/JsonReader;", "Ljava/io/Reader;", "parseString", "json", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsonParserExt {
    public static final JsonParserExt INSTANCE = null;

    static {
        INSTANCE = new JsonParserExt();
    }

    private JsonParserExt() {
    }

    public final JsonElement parseReader(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
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

    public final JsonElement parseReader(Reader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        JsonReader r101 = new JsonReader(r100);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        JsonElement r102 = parseReader(r101);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        if (r102.isJsonNull() == false) goto L6;
    L10:
        return r102;
    L6:
        if (r101.peek() == JsonToken.END_DOCUMENT) goto L10;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
    L17:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L14:
        e = move-exception;
        throw new JsonIOException(e);
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public final JsonElement parseString(String r100) {
        return parseReader(new StringReader(r100));
    }
}
