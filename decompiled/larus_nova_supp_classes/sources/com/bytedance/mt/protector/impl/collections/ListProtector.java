package com.bytedance.mt.protector.impl.collections;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import java.util.List;
import s27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ListProtector extends a {
    public ListProtector() {
    }

    @ProtectorMethod(exceptions = {IndexOutOfBoundsException.class})
    public static <T> T get(List<T> r1, int r2) {
        return r1.get(r2);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r1.size() <= 0) goto L13;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 == null) goto L13;
        return r1.get(r0.intValue());
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T remove(List<T> r1, int r2) {
        return r1.remove(r2);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r1.size() <= 0) goto L13;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 == null) goto L13;
        return r1.remove(r0.intValue());
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> void add(List<T> r1, int r2, T r3) {
        r1.add(r2, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (c.b() == false) goto L11;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 == null) goto L11;
        r1.add(r0.intValue(), r3);
        return;
    L11:
        throw th;
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T set(List<T> r1, int r2, T r3) {
        return r1.set(r2, r3);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r1.size() <= 0) goto L13;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 == null) goto L13;
        return r1.set(r0.intValue(), r3);
    }
}
