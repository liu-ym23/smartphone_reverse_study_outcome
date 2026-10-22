package zr7;

import java.util.Collection;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static void a(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void b(Object r100, Object r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void c(Collection r100, Object r101) {
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L7;
        return;
    L7:
        throw new IllegalArgumentException(String.valueOf(r101));
    L9:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void d(boolean r100, String r101, Object... r102) {
        if (r100 == true) goto L19;
        StringBuilder r103 = new StringBuilder(r101.length() + (r102.length * 16));
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r102.length) goto L10;
        int r106 = r101.indexOf("%s", r105);
        if (r106 == (-1)) goto L10;
        r103.append(r101.substring(r105, r106));
        int r107 = r104 + 1;
        r103.append(r102[r104]);
        r105 = r106 + 2;
        r104 = r107;
    L10:
        r103.append(r101.substring(r105));
        if (r104 >= r102.length) goto L18;
        r103.append(" [");
        int r108 = r104 + 1;
        r103.append(r102[r104]);
    L14:
        if (r108 >= r102.length) goto L16;
        r103.append(", ");
        int r109 = r108 + 1;
        r103.append(r102[r108]);
        r108 = r109;
        goto L14
    L16:
        r103.append(']');
    L18:
        throw new IllegalStateException(r103.toString());
    }
}
