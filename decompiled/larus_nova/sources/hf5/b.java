package hf5;

import gf5.e;
import java.util.Comparator;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f484924a = null;

    static {
        f484924a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        e r102 = (e) r100;
        e r103 = (e) r101;
        int r104 = 10;
        if (r103 == null) goto L5;
        r103.getPriority();
        int r105 = 10;
    L6:
        if (r102 == null) goto L8;
        r102.getPriority();
    L9:
        int r106 = r105 - r104;
        if (r106 != 0) goto L14;
        return 1;
    L14:
        return r106;
    L8:
        r104 = 0;
        goto L9
    L5:
        r105 = 0;
        goto L6
    }
}
