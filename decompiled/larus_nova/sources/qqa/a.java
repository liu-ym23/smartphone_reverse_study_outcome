package qqa;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Field> f534501a = null;

    static {
        f534501a = new HashMap();
    }

    public static Field a(Class<?> r100, String r110) {
        Object[] r101 = new Object[0];
        if (TextUtils.isEmpty(r110) == true) goto L55;
        String r102 = r100.toString() + "#" + r110;
        Map<String, Field> r103 = f534501a;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L51
        monitor-exit(r103);     // Catch: Throwable -> L51
        if (r104 != null) goto L11;
        Class<?> r105 = r100;
    L14:
        if (r105 == null) goto L27;
        Field r106 = r105.getDeclaredField(r110);     // Catch: Throwable -> L26
        if (Modifier.isPublic(r106.getModifiers()) == true) goto L18;
        r106.setAccessible(true);     // Catch: Throwable -> L26
    L18:
        Map<String, Field> r107 = f534501a;     // Catch: Throwable -> L26
        monitor-enter(r107);     // Catch: Throwable -> L26
        ((HashMap) r107).put(r102, r106);     // Catch: Throwable -> L23
        monitor-exit(r107);     // Catch: Throwable -> L23
    L47:
        return r106;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        r105 = r105.getSuperclass();
        goto L14
    L27:
        LinkedHashSet r108 = new LinkedHashSet();
        d.a(r100, r108);
        Iterator r109 = new ArrayList(r108).iterator();
        r106 = null;
    L29:
        if (r109.hasNext() == false) goto L41;
        Field r111 = ((Class) r109.next()).getField(r110);     // Catch: Throwable -> L40
        if (r106 == null) goto L34;
        boolean r112 = true;
    L35:
        Object[] r113 = {r110, r100};     // Catch: Throwable -> L40
        if (r112 == false) goto L37;
        throw new IllegalArgumentException(String.format("field %s on %s is ambiguous, more than one interface have the field", r113));     // Catch: Throwable -> L40
    L37:
        r106 = r111;
        goto L29
    L34:
        r112 = false;
        goto L35
    L41:
        Map<String, Field> r114 = f534501a;
        monitor-enter(r114);
        if (r106 != null) goto L57;
    L45:
        monitor-exit(r114);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L57:
        ((HashMap) r114).put(r102, r106);     // Catch: Throwable -> L48
        goto L45
    L11:
        if (r104.isAccessible() == true) goto L74;
        r104.setAccessible(true);
        return r104;
    L74:
        return r104;
    L51:
        th = move-exception;
        throw th;
    L55:
        throw new IllegalArgumentException(String.format("fieldName can not be null or empty", r101));
    }
}
