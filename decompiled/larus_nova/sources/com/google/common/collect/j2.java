package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class j2 {

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f275479a;

        public a(Field r100) {
            this.f275479a = r100;
            r100.setAccessible(true);
        }

        public final void a(T r100, Object r101) {
            this.f275479a.set(r100, r101);     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public static <T> a<T> a(Class<T> r100, String r101) {
        return new a(r100.getDeclaredField(r101));
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <K, V> void e(Map<K, V> r100, ObjectOutputStream r101) throws IOException {
        r101.writeInt(r100.size());
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r102.next();
        r101.writeObject(r103.getKey());
        r101.writeObject(r103.getValue());
        goto L4
    }

    public static <K, V> void f(q1<K, V> r100, ObjectOutputStream r101) throws IOException {
        r101.writeInt(r100.asMap().size());
        Iterator<Map.Entry<K, Collection<V>>> r102 = r100.asMap().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<K, Collection<V>> r103 = r102.next();
        r101.writeObject(r103.getKey());
        r101.writeInt(r103.getValue().size());
        Iterator<V> r104 = r103.getValue().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        r101.writeObject(r104.next());
        goto L7
    }

    public static <E> void g(y1<E> r100, ObjectOutputStream r101) throws IOException {
        r101.writeInt(r100.entrySet().size());
        Iterator<y1.a<E>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        y1.a<E> r103 = r102.next();
        r101.writeObject(r103.getElement());
        r101.writeInt(r103.getCount());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void b(Map<K, V> r100, ObjectInputStream r101, int r102) throws IOException, ClassNotFoundException {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101.readObject(), r101.readObject());
        r103 = r103 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(q1<K, V> r100, ObjectInputStream r101, int r102) throws IOException, ClassNotFoundException {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Collection r104 = r100.get(r101.readObject());
        int r105 = r101.readInt();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r104.add(r101.readObject());
        r106 = r106 + 1;
        goto L5
    L7:
        r103 = r103 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void d(y1<E> r100, ObjectInputStream r101, int r102) throws IOException, ClassNotFoundException {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.add(r101.readObject(), r101.readInt());
        r103 = r103 + 1;
        goto L3
    }
}
