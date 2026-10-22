package hf5;

import gf5.e;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Comparator {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r3, Object r4) {
        e r5 = (e) r3;
        e r6 = (e) r4;
        int r0 = 10;
        if (r6 == null) goto L5;
        r6.getPriority();
        int r7 = 10;
    L6:
        if (r5 == null) goto L8;
        r5.getPriority();
    L9:
        int r8 = r7 - r0;
        if (r8 != 0) goto L14;
        return 1;
    L14:
        return r8;
    L8:
        r0 = 0;
        goto L9
    L5:
        r7 = 0;
        goto L6
    }
}
