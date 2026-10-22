package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = null;
    private final List<DateFormat> dateFormats;

    static {
        FACTORY = new AnonymousClass1();
    }

    public DateTypeAdapter() {
        ArrayList r100 = new ArrayList();
        this.dateFormats = r100;
        Locale r101 = Locale.US;
        r100.add(DateFormat.getDateTimeInstance(2, 2, r101));
        if (Locale.getDefault().equals(r101) == true) goto L6;
        r100.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r100.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        return;
    }

    private Date deserializeToDate(JsonReader r100) throws IOException {
        String r101 = r100.nextString();
        List<DateFormat> r102 = this.dateFormats;
        monitor-enter(r102);
        Iterator<DateFormat> r103 = this.dateFormats.iterator();     // Catch: Throwable -> L17
    L6:
        if (r103.hasNext() == false) goto L11;
        Date r104 = r103.next().parse(r101);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return r104;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return ISO8601Utils.parse(r101, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r101 + "' as Date; at path " + r100.getPreviousPath(), e);
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L7;
        r100.nextNull();
        return null;
    L7:
        return deserializeToDate(r100);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r100) throws IOException {
        return read2(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Date r101) throws IOException {
        if (r101 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        DateFormat r102 = this.dateFormats.get(0);
        List<DateFormat> r103 = this.dateFormats;
        monitor-enter(r103);
        String r104 = r102.format(r101);     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
        r100.value(r104);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Date r101) throws IOException {
        write2(r100, r101);
    }
}
