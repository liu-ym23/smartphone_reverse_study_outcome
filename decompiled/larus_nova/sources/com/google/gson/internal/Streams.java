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
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Streams {

    /* JADX INFO: renamed from: com.google.gson.internal.Streams$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        /* JADX INFO: loaded from: classes23.dex */
        public static class CurrentWrite implements CharSequence {
            private String cachedString;
            private char[] chars;

            private CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.cachedString != null) goto L6;
                this.cachedString = new String(this.chars);
            L6:
                return this.cachedString;
            }

            public /* synthetic */ CurrentWrite(AnonymousClass1 r100) {
                this();
            }

            @Override // java.lang.CharSequence
            public char charAt(int r100) {
                return this.chars[r100];
            }

            public void setChars(char[] r100) {
                this.chars = r100;
                this.cachedString = null;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r100, int r101) {
                return new String(this.chars, r100, r101 - r100);
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public AppendableWriter(Appendable r100) {
            this.currentWrite = new CurrentWrite(null);
            this.appendable = r100;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r100) throws IOException {
            this.appendable.append(r100);
            return this;
        }

        @Override // java.io.Writer
        public void write(int r100) throws IOException {
            this.appendable.append((char) r100);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
            return append(r100);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r100, int r101, int r102) throws IOException {
            this.appendable.append(r100, r101, r102);
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] r100, int r101, int r102) throws IOException {
            this.currentWrite.setChars(r100);
            this.appendable.append(this.currentWrite, r101, r102 + r101);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
            return append(r100, r101, r102);
        }

        @Override // java.io.Writer
        public void write(String r100, int r101, int r102) throws IOException {
            Objects.requireNonNull(r100);
            this.appendable.append(r100, r101, r102 + r101);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r100) throws JsonParseException {
        r100.peek();     // Catch: NumberFormatException -> L8 IOException -> L11 MalformedJsonException -> L14 EOFException -> L17
        boolean r101 = false;
        return TypeAdapters.JSON_ELEMENT.read(r100);
    L6:
        e = e;
    L19:
        if (r101 == false) goto L23;
        return JsonNull.INSTANCE;
    L23:
        throw new JsonSyntaxException(e);
    L17:
        e = e;
        r101 = true;
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

    public static Writer writerForAppendable(Appendable r100) {
        if ((r100 instanceof Writer) == false) goto L6;
        return (Writer) r100;
    L6:
        return new AppendableWriter(r100);
    }

    public static void write(JsonElement r100, JsonWriter r101) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(r101, r100);
    }
}
