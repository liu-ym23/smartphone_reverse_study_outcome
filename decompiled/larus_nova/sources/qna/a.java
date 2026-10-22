package qna;

import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534116a = 0;

    static {
        new HashMap();
    }

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
