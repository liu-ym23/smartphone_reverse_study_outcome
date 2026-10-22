package r37;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f535888a;

    public static Object a(Class r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (f535888a != null) goto L6;
        f535888a = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L8
    L6:
        Field r101 = (Field) f535888a.invoke(r100, new Object[]{"mUiThreadId"});     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        return r101;
    }
}
