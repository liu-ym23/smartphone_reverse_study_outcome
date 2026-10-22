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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes.dex */
    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = null;
        private final Class<T> dateClass;

        public abstract T deserialize(Date r100);

        static {
            final Class<Date> r100 = Date.class;
            DATE = new AnonymousClass1(r100);
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            int r100 = 2;
            return createFactory(new DefaultDateTypeAdapter(this, r100, r100, null));
        }

        public DateType(Class<T> r100) {
            this.dateClass = r100;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> r100) {
            return TypeAdapters.newFactory(this.dateClass, r100);
        }

        public final TypeAdapterFactory createAdapterFactory(int r100) {
            return createFactory(new DefaultDateTypeAdapter(this, r100, null));
        }

        public final TypeAdapterFactory createAdapterFactory(String r100) {
            return createFactory(new DefaultDateTypeAdapter(this, r100, null));
        }

        public final TypeAdapterFactory createAdapterFactory(int r100, int r101) {
            return createFactory(new DefaultDateTypeAdapter(this, r100, r101, null));
        }
    }

    public String toString() {
        DateFormat r100 = this.dateFormats.get(0);
        if ((r100 instanceof SimpleDateFormat) == false) goto L7;
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) r100).toPattern() + ')';
    L7:
        return "DefaultDateTypeAdapter(" + r100.getClass().getSimpleName() + ')';
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
    public T read(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L6;
        r100.nextNull();
        return null;
    L6:
        Date r101 = deserializeToDate(r100);
        return (T) this.dateType.deserialize(r101);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r100) throws IOException {
        return read(r100);
    }

    private DefaultDateTypeAdapter(DateType<T> r100, int r101) {
        ArrayList r102 = new ArrayList();
        this.dateFormats = r102;
        Objects.requireNonNull(r100);
        this.dateType = r100;
        Locale r103 = Locale.US;
        r102.add(DateFormat.getDateInstance(r101, r103));
        if (Locale.getDefault().equals(r103) == true) goto L6;
        r102.add(DateFormat.getDateInstance(r101));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r102.add(PreJava9DateFormatProvider.getUSDateFormat(r101));
        return;
    }

    public void write(JsonWriter r100, Date r101) throws IOException {
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

    private DefaultDateTypeAdapter(DateType<T> r100, String r101) {
        ArrayList r102 = new ArrayList();
        this.dateFormats = r102;
        Objects.requireNonNull(r100);
        this.dateType = r100;
        Locale r103 = Locale.US;
        r102.add(new SimpleDateFormat(r101, r103));
        if (Locale.getDefault().equals(r103) == true) goto L6;
        r102.add(new SimpleDateFormat(r101));
        return;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Object r101) throws IOException {
        write(r100, (Date) r101);
    }

    private DefaultDateTypeAdapter(DateType<T> r100, int r101, int r102) {
        ArrayList r103 = new ArrayList();
        this.dateFormats = r103;
        Objects.requireNonNull(r100);
        this.dateType = r100;
        Locale r104 = Locale.US;
        r103.add(DateFormat.getDateTimeInstance(r101, r102, r104));
        if (Locale.getDefault().equals(r104) == true) goto L6;
        r103.add(DateFormat.getDateTimeInstance(r101, r102));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r103.add(PreJava9DateFormatProvider.getUSDateTimeFormat(r101, r102));
        return;
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r100, String r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r100, int r101, int r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
