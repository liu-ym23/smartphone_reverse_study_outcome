package jv5;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f500557a = null;

    static {
        f500557a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        String r102 = (String) r100;
        String r103 = (String) r101;
        if (r102.length() != r103.length()) goto L6;
        return 0;
    L6:
        if (r102.length() <= r103.length()) goto L8;
        return -1;
    L8:
        return 1;
    }
}
