package com.samskivert.mustache;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends com.samskivert.mustache.a {

    public class a implements e.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f405723a;

        public a(Method r100) {
            this.f405723a = r100;
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return this.f405723a.invoke(r100, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: com.samskivert.mustache.b$b, reason: collision with other inner class name */
    public class C4696b implements e.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Field f405724a;

        public C4696b(Field r100) {
            this.f405724a = r100;
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return this.f405724a.get(r100);
        }
    }

    public class c implements e.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f405725a;

        public c(Method r100) {
            this.f405725a = r100;
        }

        @Override // com.samskivert.mustache.e.t
        public final Object a(Object r100, String r101) throws Exception {
            return this.f405725a.invoke(r100, new Object[0]);
        }
    }

    public b() {
    }

    public static Field e(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Exception -> L6
        if (r102.isAccessible() == true) goto L5;
        r102.setAccessible(true);     // Catch: Exception -> L6
    L5:
        return r102;
    L6:
        Class r103 = r100.getSuperclass();
        if (r103 == Object.class) goto L11;
        if (r103 != null) goto L10;
        return null;
    L10:
        return e(r100.getSuperclass(), r101);
    L11:
        return null;
    }

    public static Method f(Class r100, String r101) {
        Method r102 = r100.getDeclaredMethod(r101, new Class[0]);     // Catch: Exception -> L26
        if (r102.getReturnType().equals(Void.TYPE) == true) goto L9;
        if (r102.isAccessible() == true) goto L8;
        r102.setAccessible(true);     // Catch: Exception -> L26
    L8:
        return r102;
    L9:
        String r103 = Character.toUpperCase(r101.charAt(0)) + r101.substring(1);
        Method r104 = r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET + r103, new Class[0]);     // Catch: Exception -> L27
        if (r104.getReturnType().equals(Void.TYPE) == true) goto L29;
        if (r104.isAccessible() == true) goto L15;
        r104.setAccessible(true);     // Catch: Exception -> L27
    L15:
        return r104;
    L29:
        Method r105 = r100.getDeclaredMethod("is" + r103, new Class[0]);     // Catch: Exception -> L28
        if (r105.getReturnType().equals(Boolean.TYPE) == true) goto L21;
        if (r105.getReturnType().equals(Boolean.class) == true) goto L21;
        return null;
    L21:
        if (r105.isAccessible() == true) goto L23;
        r105.setAccessible(true);     // Catch: Exception -> L28
    L23:
        return r105;
    L35:
        return null;
    }

    public final e.t d(Object r100, String r101) {
        if (r101 != h.f405774e) goto L5;
    L24:
        e.t r102 = com.samskivert.mustache.a.f405709d;
    L25:
        if (r102 == null) goto L27;
        return r102;
    L27:
        Class<?> r103 = r100.getClass();
        Class<?> r104 = r103;
    L28:
        if (r104 == null) goto L35;
        if (r104 == Object.class) goto L35;
        Method r105 = f(r104, r101);
        if (r105 != null) goto L36;
        r104 = r104.getSuperclass();
    L36:
        if (r105 != null) goto L38;
        Field r106 = e(r103, r101);
        if (r106 != null) goto L42;
        LinkedHashSet r107 = new LinkedHashSet();
    L44:
        if (r103 == null) goto L48;
        if (r103 == Object.class) goto L48;
        c(r107, r103, false);
        r103 = r103.getSuperclass();
    L48:
        Iterator r108 = r107.iterator();
    L50:
        if (r108.hasNext() == false) goto L54;
        Method r109 = f((Class) r108.next(), r101);
        if (r109 == null) goto L50;
    L55:
        if (r109 != null) goto L57;
        return null;
    L57:
        return new c(r109);
    L54:
        r109 = null;
        goto L55
    L42:
        return new C4696b(r106);
    L38:
        return new a(r105);
    L35:
        r105 = null;
        goto L36
    L5:
        if (r101 == h.f405775f) goto L24;
        if ((r100 instanceof Map) == false) goto L10;
        r102 = com.samskivert.mustache.a.f405706a;
        goto L25
    L10:
        char r110 = r101.charAt(0);
        if (r110 >= '0') goto L13;
    L23:
        r102 = null;
        goto L25
    L13:
        if (r110 > '9') goto L23;
        if ((r100 instanceof List) == false) goto L18;
        r102 = com.samskivert.mustache.a.f405707b;
        goto L25
    L18:
        if ((r100 instanceof Iterator) == false) goto L21;
        r102 = com.samskivert.mustache.a.f405708c;
        goto L25
    L21:
        if (r100.getClass().isArray() == false) goto L23;
        r102 = com.samskivert.mustache.a.a(r100);
        goto L25
    }

    public static void c(Set r100, Class r101, boolean r102) {
        if (r102 == false) goto L4;
        r100.add(r101);
    L4:
        Class<?>[] r103 = r101.getInterfaces();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        c(r100, r103[r105], true);
        r105 = r105 + 1;
        goto L5
    }
}
