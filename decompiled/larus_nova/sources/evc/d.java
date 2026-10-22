package evc;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f474507b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DateFormat[] f474508c = null;

    public static class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            SimpleDateFormat r100 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            r100.setLenient(false);
            r100.setTimeZone(cvc.c.f465528p);
            return r100;
        }

        public a() {
        }
    }

    static {
        f474506a = new a();
        String[] r100 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f474507b = r100;
        f474508c = new DateFormat[r100.length];
    }

    public static Date a(String r110) {
        if (r110.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r100 = new ParsePosition(0);
        Date r101 = f474506a.get().parse(r110, r100);
        if (r100.getIndex() != r110.length()) goto L8;
        return r101;
    L8:
        String[] r102 = f474507b;
        monitor-enter(r102);
        int r103 = r102.length;     // Catch: Throwable -> L22
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L20;
        DateFormat[] r105 = f474508c;     // Catch: Throwable -> L22
        DateFormat r106 = r105[r104];     // Catch: Throwable -> L22
        if (r106 != null) goto L15;
        r106 = new SimpleDateFormat(f474507b[r104], Locale.US);     // Catch: Throwable -> L22
        r106.setTimeZone(cvc.c.f465528p);     // Catch: Throwable -> L22
        r105[r104] = r106;     // Catch: Throwable -> L22
    L15:
        r100.setIndex(0);     // Catch: Throwable -> L22
        Date r107 = r106.parse(r110, r100);     // Catch: Throwable -> L22
        if (r100.getIndex() != 0) goto L17;
        r104 = r104 + 1;     // Catch: Throwable -> L22
        goto L11
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L22
        return r107;
    L20:
        monitor-exit(r102);     // Catch: Throwable -> L22
        return null;
    L22:
        th = move-exception;
        throw th;
    }
}
