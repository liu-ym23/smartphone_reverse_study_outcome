package ex3;

import android.os.SystemClock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f474706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f474707b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f474708c = null;

    static {
        f474708c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        long r100 = (((SystemClock.elapsedRealtime() / 1000) * 100) + ((long) new SecureRandom().nextInt(99))) * 100000;
        f474706a = new AtomicLong(r100);
        f474707b = new AtomicLong(r100);
    }

    public static String a() {
        return f474708c.format(new Date());
    }
}
