package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes23.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object r100 = this.lock;
        monitor-enter(r100);
        if (this.parser.peek() == JsonToken.END_DOCUMENT) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L10
    L15:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L10
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext() == false) goto L13;
        return Streams.parse(this.parser);
    L6:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L9:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L13:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ JsonElement next() {
        return next();
    }

    public JsonStreamParser(Reader r100) {
        JsonReader r101 = new JsonReader(r100);
        this.parser = r101;
        r101.setLenient(true);
        this.lock = new Object();
    }

    public JsonStreamParser(String r100) {
        this(new StringReader(r100));
    }
}
