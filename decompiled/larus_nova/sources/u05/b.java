package u05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()) + du5.b.c(12);
    }
}
