package iu5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static String a(long r100) {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(r100 * 1000));
    }

    public static String b(long r100) {
        return String.valueOf((int) (((System.currentTimeMillis() / 1000) - r100) / 86400.0d));
    }
}
