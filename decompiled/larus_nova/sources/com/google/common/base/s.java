package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class s {
    public static String a(@CheckForNull String r100, @CheckForNull Object... r110) {
        String r101 = String.valueOf(r100);
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r110.length) goto L13;
        Object r104 = r110[r103];
        if (r104 != null) goto L29;
        String r105 = "null";
    L12:
        r110[r103] = r105;
        r103 = r103 + 1;
        goto L4
    L29:
        r105 = r104.toString();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        String r106 = r104.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(r104));
        Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + r106, e);
        r105 = "<" + r106 + " threw " + e.getClass().getName() + ">";
        goto L12
    L13:
        StringBuilder r107 = new StringBuilder(r101.length() + (r110.length * 16));
        int r108 = 0;
    L15:
        if (r102 >= r110.length) goto L20;
        int r109 = r101.indexOf("%s", r108);
        if (r109 == (-1)) goto L20;
        r107.append(r101, r108, r109);
        r107.append(r110[r102]);
        r108 = r109 + 2;
        r102 = r102 + 1;
    L20:
        r107.append(r101, r108, r101.length());
        if (r102 >= r110.length) goto L28;
        r107.append(" [");
        int r111 = r102 + 1;
        r107.append(r110[r102]);
    L24:
        if (r111 >= r110.length) goto L26;
        r107.append(", ");
        r107.append(r110[r111]);
        r111 = r111 + 1;
        goto L24
    L26:
        r107.append(']');
    L28:
        return r107.toString();
    }
}
