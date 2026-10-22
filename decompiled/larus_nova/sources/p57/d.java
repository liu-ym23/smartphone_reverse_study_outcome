package p57;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static Field a(Class<?> r100, String r101) {
        if (u57.e.a() == false) goto L13;
        Field r102 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L6
        r102.setAccessible(true);     // Catch: Throwable -> L6
        return r102;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        return null;
    L11:
        return null;
    L13:
        return u57.a.a(r100, r101);
    }
}
