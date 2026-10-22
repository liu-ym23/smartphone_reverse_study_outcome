package p57;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public static Method a(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
