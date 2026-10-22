package com.larus.io;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes30.dex */
public class StringBuilderWriter extends Writer implements Serializable {
    private final StringBuilder builder;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.builder.toString();
    }

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public StringBuilderWriter(StringBuilder r100) {
        if (r100 != null) goto L6;
        r100 = new StringBuilder();
    L6:
        this.builder = r100;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char r100) {
        this.builder.append(r100);
        return this;
    }

    @Override // java.io.Writer
    public void write(String r100) {
        if (r100 == null) goto L5;
        this.builder.append(r100);
        return;
    }

    public StringBuilderWriter(int r100) {
        this.builder = new StringBuilder(r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r100) {
        this.builder.append(r100);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r100) throws IOException {
        return append(r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        return append(r100);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence r100, int r101, int r102) {
        this.builder.append(r100, r101, r102);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] r100, int r101, int r102) {
        if (r100 == null) goto L5;
        this.builder.append(r100, r101, r102);
        return;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
        return append(r100, r101, r102);
    }
}
