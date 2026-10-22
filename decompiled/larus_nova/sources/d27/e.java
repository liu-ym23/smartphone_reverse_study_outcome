package d27;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f466541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f466542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f466543c = null;

    static {
        Class<?> r100 = Integer.TYPE;
        Class<?> r101 = Long.TYPE;
        Class<?> r102 = Float.TYPE;
        f466541a = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, r100, r101, r102, Double.TYPE};
        HashMap r103 = new HashMap();
        f466542b = r103;
        f466543c = new HashMap();
        r103.put(Byte.TYPE, Byte.class);
        r103.put(Boolean.TYPE, Boolean.class);
        r103.put(Short.TYPE, Short.class);
        r103.put(Character.TYPE, Character.class);
        r103.put(r101, Long.class);
        r103.put(r100, Integer.class);
        r103.put(r102, Float.class);
        r103.put(Double.TYPE, Double.class);
        Class r104 = Void.TYPE;
        r103.put(r104, r104);
        Iterator r105 = r103.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Class<?> r106 = (Class) r105.next();
        Class<?> r107 = f466542b.get(r106);
        if (r106.equals(r107) == true) goto L4;
        f466543c.put(r107, r106);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(AccessibleObject r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (r100.isAccessible() == true) goto L24;
        Member r101 = (Member) r100;
        if (r100.isAccessible() == false) goto L9;
        return;
    L9:
        if (Modifier.isPublic(r101.getModifiers()) == true) goto L11;
        return;
    L11:
        if ((r101.getDeclaringClass().getModifiers() & 7) != 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L23;
        r100.setAccessible(true);     // Catch: Exception -> L17
        return;
    L25:
        return;
    L23:
        return;
    L13:
        r102 = false;
        goto L14
    }

    public static float a(Class<?>[] r110, Class<?>[] r111) {
        int r100 = 0;
        float r101 = 0.0f;
    L4:
        if (r100 >= r110.length) goto L34;
        Class<?> r102 = r110[r100];
        Class<?> r103 = r111[r100];
        if (r103.isPrimitive() == true) goto L8;
        float r104 = 0.0f;
    L22:
        if (r102 == null) goto L31;
        if (r103.equals(r102) == true) goto L31;
        if (r103.isInterface() == false) goto L30;
        if (b(r102, r103) == false) goto L30;
        r104 = r104 + 0.25f;
    L30:
        r104 = r104 + 1.0f;
        r102 = r102.getSuperclass();
    L31:
        if (r102 != null) goto L33;
        r104 = r104 + 1.5f;
    L33:
        r101 = r101 + r104;
        r100 = r100 + 1;
        goto L4
    L8:
        if (r102.isPrimitive() == true) goto L10;
        r102 = (Class) ((HashMap) f466543c).get(r102);
        r104 = 0.1f;
    L11:
        int r105 = 0;
    L12:
        if (r102 == r103) goto L33;
        if (r105 >= 7) goto L33;
        Class<?>[] r106 = f466541a;
        if (r102 != r106[r105]) goto L20;
        r104 = r104 + 0.1f;
        if (r105 >= 6) goto L20;
        r102 = r106[r105 + 1];
    L20:
        r105 = r105 + 1;
        goto L12
    L10:
        r104 = 0.0f;
        goto L11
    L34:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Class r100, Class r101) {
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r100 != null) goto L10;
        return !r101.isPrimitive();
    L10:
        if (r100.isPrimitive() == false) goto L19;
        if (r101.isPrimitive() == true) goto L19;
        if (r100.isPrimitive() == false) goto L16;
        r100 = (Class) ((HashMap) f466542b).get(r100);
    L16:
        if (r100 != null) goto L19;
        return false;
    L19:
        if (r101.isPrimitive() == false) goto L26;
        if (r100.isPrimitive() == true) goto L26;
        r100 = (Class) ((HashMap) f466543c).get(r100);
        if (r100 != null) goto L26;
        return false;
    L26:
        if (r100.equals(r101) == false) goto L29;
        return true;
    L29:
        if (r100.isPrimitive() == false) goto L82;
        if (r101.isPrimitive() == false) goto L90;
        Class r102 = Integer.TYPE;
        if (r102.equals(r100) == true) goto L36;
        Class r103 = Long.TYPE;
        if (r103.equals(r100) == false) goto L50;
        if (Float.TYPE.equals(r101) == false) goto L47;
    L78:
        return true;
    L47:
        if (Double.TYPE.equals(r101) == true) goto L78;
        return false;
    L50:
        if (Boolean.TYPE.equals(r100) == false) goto L52;
        return false;
    L52:
        if (Double.TYPE.equals(r100) == true) goto L91;
        Class r104 = Float.TYPE;
        if (r104.equals(r100) == false) goto L58;
        return Double.TYPE.equals(r101);
    L58:
        if (r102.equals(r101) == false) goto L60;
    L67:
        boolean r105 = true;
    L69:
        if (Character.TYPE.equals(r100) == true) goto L80;
        if (Short.TYPE.equals(r100) == true) goto L80;
        if (Byte.TYPE.equals(r100) == true) goto L76;
        return false;
    L76:
        if (Short.TYPE.equals(r101) == true) goto L78;
        if (r105 == true) goto L78;
        return false;
    L80:
        return r105;
    L60:
        if (r103.equals(r101) == true) goto L67;
        if (r104.equals(r101) == true) goto L67;
        if (Double.TYPE.equals(r101) == true) goto L67;
        r105 = false;
        goto L69
    L91:
        return false;
    L36:
        if (Long.TYPE.equals(r101) == true) goto L78;
        if (Float.TYPE.equals(r101) == true) goto L78;
        if (Double.TYPE.equals(r101) == true) goto L78;
        return false;
    L90:
        return false;
    L82:
        return r101.isAssignableFrom(r100);
    }
}
