package hq7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f486512a = false;

    static {
        Method r100 = d.f486514b;
        boolean r101 = false;
        if (r100 != null) goto L19;
    L14:
        int r102 = 0;
    L15:
        if (r102 != 1) goto L17;
        r101 = true;
    L17:
        f486512a = r101;
        return;
    L19:
        r102 = ((Integer) r100.invoke(null, new Object[]{"debug.watson.log", 0})).intValue();     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
