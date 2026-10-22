package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final TypeAdapterFactory FACTORY = null;
    private final TypeAdapter<Date> dateTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> r100) {
        this.dateTypeAdapter = r100;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(JsonReader r100) throws IOException {
        Date r101 = this.dateTypeAdapter.read(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r101.getTime());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Timestamp read(JsonReader r100) throws IOException {
        return read2(r100);
    }

    public /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Timestamp r101) throws IOException {
        write2(r100, r101);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Timestamp r101) throws IOException {
        this.dateTypeAdapter.write(r100, r101);
    }
}
