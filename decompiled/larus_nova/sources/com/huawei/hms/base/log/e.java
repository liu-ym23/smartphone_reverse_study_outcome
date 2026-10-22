package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f277002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f277005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f277006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f277007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f277009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f277010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f277011j;

    public String a() {
        StringBuilder r100 = new StringBuilder();
        a(r100);
        return r100.toString();
    }

    public String c() {
        StringBuilder r100 = new StringBuilder();
        b(r100);
        return r100.toString();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        b(r100);
        a(r100);
        return r100.toString();
    }

    private e b() {
        this.f277006e = System.currentTimeMillis();
        Thread r100 = Thread.currentThread();
        this.f277007f = r100.getId();
        this.f277009h = Process.myPid();
        StackTraceElement[] r101 = r100.getStackTrace();
        int r102 = r101.length;
        int r103 = this.f277011j;
        if (r102 <= r103) goto L5;
        StackTraceElement r104 = r101[r103];
        this.f277008g = r104.getFileName();
        this.f277010i = r104.getLineNumber();
    L5:
        return this;
    }

    public static String a(int r100) {
        if (r100 != 3) goto L5;
        return "D";
    L5:
        if (r100 != 4) goto L7;
        return "I";
    L7:
        if (r100 != 5) goto L9;
        return ExifInterface.LONGITUDE_WEST;
    L9:
        if (r100 != 6) goto L11;
        return ExifInterface.LONGITUDE_EAST;
    L11:
        return String.valueOf(r100);
    }

    private StringBuilder b(StringBuilder r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        r100.append('[');
        r100.append(r101.format(Long.valueOf(this.f277006e)));
        String r102 = a(this.f277005d);
        r100.append(' ');
        r100.append(r102);
        r100.append('/');
        r100.append(this.f277004c);
        r100.append('/');
        r100.append(this.f277003b);
        r100.append(' ');
        r100.append(this.f277009h);
        r100.append(':');
        r100.append(this.f277007f);
        r100.append(' ');
        r100.append(this.f277008g);
        r100.append(':');
        r100.append(this.f277010i);
        r100.append(']');
        return r100;
    }

    public e a(Throwable r100) {
        a('\n').a(Log.getStackTraceString(r100));
        return this;
    }

    private StringBuilder a(StringBuilder r100) {
        r100.append(' ');
        r100.append(this.f277002a.toString());
        return r100;
    }

    public <T> e a(T r100) {
        this.f277002a.append(r100);
        return this;
    }

    public e(int r100, String r101, int r102, String r103) {
        this.f277002a = new StringBuilder();
        this.f277004c = "HMS";
        this.f277006e = 0;
        this.f277007f = 0;
        this.f277011j = r100;
        this.f277003b = r101;
        this.f277005d = r102;
        if (r103 == null) goto L5;
        this.f277004c = r103;
    L5:
        b();
    }
}
