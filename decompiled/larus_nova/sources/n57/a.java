package n57;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import p57.d;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f518039a;

    public static void a(String r100) {
        if (f518039a == null) goto L14;
    L12:
        Printer r101 = (Printer) f518039a.get(Looper.getMainLooper());     // Catch: Throwable -> L7
    L8:
        if (r101 == null) goto L16;
        r101.println(r100);
        return;
    L16:
        return;
    L7:
        r101 = null;
        goto L8
    L14:
        f518039a = d.a(Looper.class, "mLogging");     // Catch: Throwable -> L11
        goto L12
    }
}
