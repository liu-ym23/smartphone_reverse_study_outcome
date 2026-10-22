package gs7;

import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    static {
        new HashMap();
    }

    public static Method a(Class r100, Class... r101) throws NoSuchMethodException {
        Method r102 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{"setVivoFrameRate", r101});     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
