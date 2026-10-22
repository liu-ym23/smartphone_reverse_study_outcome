package com.google.gson.internal.sql;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    public /* synthetic */ SqlTimeTypeAdapter(AnonymousClass1 r100) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Time read2(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L6;
        r100.nextNull();
        return null;
    L6:
        String r101 = r100.nextString();
        monitor-enter(this);     // Catch: ParseException -> L14
        Time r102 = new Time(this.format.parse(r101).getTime());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r101 + "' as SQL Time; at path " + r100.getPreviousPath(), e);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time read(JsonReader r100) throws IOException {
        return read2(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Time r101) throws IOException {
        if (r101 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        monitor-enter(this);
        String r102 = this.format.format(r101);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r100.value(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Time r101) throws IOException {
        write2(r100, r101);
    }
}
