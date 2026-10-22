package com.google.android.gms.internal.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
public final class n {
    public static String a(@CheckForNull String r110, @CheckForNull Object... r111) {
        int r100 = 0;
        int r101 = 0;
    L3:
        int r102 = r111.length;
        if (r101 >= r102) goto L13;
        Object r103 = r111[r101];
        if (r103 != null) goto L29;
        String r104 = "null";
    L12:
        r111[r101] = r104;
        r101 = r101 + 1;
        goto L3
    L29:
        r104 = r103.toString();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        String r105 = r103.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(r103));
        Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(r105), e);
        r104 = "<" + r105 + " threw " + e.getClass().getName() + ">";
        goto L12
    L13:
        StringBuilder r106 = new StringBuilder(r110.length() + (r102 * 16));
        int r107 = 0;
    L14:
        int r108 = r111.length;
        if (r100 >= r108) goto L20;
        int r109 = r110.indexOf("%s", r107);
        if (r109 == (-1)) goto L20;
        r106.append(r110, r107, r109);
        r106.append(r111[r100]);
        r107 = r109 + 2;
        r100 = r100 + 1;
    L20:
        r106.append(r110, r107, r110.length());
        if (r100 >= r108) goto L28;
        r106.append(" [");
        int r112 = r100 + 1;
        r106.append(r111[r100]);
    L24:
        if (r112 >= r111.length) goto L26;
        r106.append(", ");
        r106.append(r111[r112]);
        r112 = r112 + 1;
        goto L24
    L26:
        r106.append(']');
    L28:
        return r106.toString();
    }
}
