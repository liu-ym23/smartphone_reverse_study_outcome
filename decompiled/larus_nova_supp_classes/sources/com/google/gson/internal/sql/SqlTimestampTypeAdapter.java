package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final TypeAdapterFactory FACTORY = null;
    private final TypeAdapter<Date> dateTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> r1) {
        this.dateTypeAdapter = r1;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(JsonReader r4) throws IOException {
        Date r5 = this.dateTypeAdapter.read(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r5.getTime());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Timestamp read(JsonReader r1) throws IOException {
        return read2(r1);
    }

    public /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Timestamp r2) throws IOException {
        write2(r1, r2);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r2, Timestamp r3) throws IOException {
        this.dateTypeAdapter.write(r2, r3);
    }
}
