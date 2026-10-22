package com.larus.audio.call.aec;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f288964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f288965b = 0;

    static {
        f288964a = new SimpleDateFormat("HH:mm:ss.SSS");
        f288965b = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String a(long r100) {
        if (r100 >= 0) goto L7;
        return "NOT_TIME";
    L7:
        return f288964a.format(new Date(f288965b + (r100 / ((long) 1000000))));
    }

    public static String b(long r100) {
        return f288964a.format(new Date(r100));
    }
}
