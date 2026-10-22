package u57;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Field> f548872a = null;

    static {
        f548872a = new HashMap();
    }

    public static Field a(Class<?> r100, String r101) {
        if (r100 == null) goto L46;
        if ((!TextUtils.isEmpty(r101)) == false) goto L44;
        String r102 = r100.toString() + "#" + r101;
        Map<String, Field> r103 = f548872a;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        if (r104 != null) goto L12;
    L15:
        if (r100 == null) goto L38;
    L37:
        r100 = r100.getSuperclass();
        goto L15
    L17:
        if (e.a() == false) goto L23;
        p57.f r105 = c.f548875a;     // Catch: NoSuchFieldException -> L37
        if (r105 == null) goto L23;
        Field r106 = r105.b(r100, r101);     // Catch: NoSuchFieldException -> L37
        if (r106 != null) goto L24;
        r106 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L37
    L24:
        if (r106 == null) goto L36;
        if (r106.isAccessible() == true) goto L28;
        r106.setAccessible(true);     // Catch: NoSuchFieldException -> L37
    L28:
        Map<String, Field> r107 = f548872a;     // Catch: NoSuchFieldException -> L37
        monitor-enter(r107);     // Catch: NoSuchFieldException -> L37
        ((HashMap) r107).put(r102, r106);     // Catch: Throwable -> L33
        monitor-exit(r107);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L37
    L36:
        return r106;
    L23:
        r106 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L37
        goto L24
    L38:
        return null;
    L12:
        if (r104.isAccessible() == true) goto L14;
        r104.setAccessible(true);
    L14:
        return r104;
    L40:
        th = move-exception;
        throw th;
    L44:
        throw new IllegalArgumentException("The field name must not be blank");
    L46:
        throw new IllegalArgumentException("The class must not be null");
    }
}
