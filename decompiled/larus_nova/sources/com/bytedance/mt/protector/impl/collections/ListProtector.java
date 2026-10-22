package com.bytedance.mt.protector.impl.collections;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import java.util.List;
import s27.a;

/* JADX INFO: loaded from: classes.dex */
public class ListProtector extends a {
    public ListProtector() {
    }

    @ProtectorMethod(exceptions = {IndexOutOfBoundsException.class})
    public static <T> T get(List<T> r100, int r101) {
        return r100.get(r101);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r100.size() <= 0) goto L13;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 == null) goto L13;
        return r100.get(r102.intValue());
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T remove(List<T> r100, int r101) {
        return r100.remove(r101);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r100.size() <= 0) goto L13;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 == null) goto L13;
        return r100.remove(r102.intValue());
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> void add(List<T> r100, int r101, T r102) {
        r100.add(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (c.b() == false) goto L11;
        Integer r103 = (Integer) a.tryProtect(th, Integer.class);
        if (r103 == null) goto L11;
        r100.add(r103.intValue(), r102);
        return;
    L11:
        throw th;
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T set(List<T> r100, int r101, T r102) {
        return r100.set(r101, r102);
    L4:
        th = move-exception;
        if (c.b() == true) goto L8;
    L13:
        throw th;
    L8:
        if (r100.size() <= 0) goto L13;
        Integer r103 = (Integer) a.tryProtect(th, Integer.class);
        if (r103 == null) goto L13;
        return r100.set(r103.intValue(), r102);
    }
}
