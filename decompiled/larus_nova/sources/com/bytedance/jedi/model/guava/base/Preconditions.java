package com.bytedance.jedi.model.guava.base;

import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes19.dex */
public final class Preconditions {
    public static void a(boolean r100, @NullableDecl String r101, long r110) {
        if (r100 == true) goto L22;
        Long r111 = Long.valueOf(r110);
        int r112 = 0;
        Object[] r102 = {r111};
        String r113 = String.valueOf(r111);     // Catch: Exception -> L6
    L8:
        r102[0] = r113;
        StringBuilder r114 = new StringBuilder(r101.length() + 16);
        int r103 = 0;
    L9:
        if (r112 >= 1) goto L14;
        int r104 = r101.indexOf("%s", r103);
        if (r104 == (-1)) goto L14;
        r114.append(r101, r103, r104);
        r114.append(r102[r112]);
        r103 = r104 + 2;
        r112 = r112 + 1;
    L14:
        r114.append(r101, r103, r101.length());
        if (r112 >= 1) goto L21;
        r114.append(" [");
        int r105 = r112 + 1;
        r114.append(r102[r112]);
    L17:
        if (r105 >= 1) goto L19;
        r114.append(", ");
        r114.append(r102[r105]);
        r105 = r105 + 1;
        goto L17
    L19:
        r114.append(']');
    L21:
        throw new IllegalStateException(r114.toString());
    L6:
        e = move-exception;
        String r115 = r111.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(r111));
        Logger.getLogger("com.bytedance.jedi.model.guava.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + r115, e);
        r113 = "<" + r115 + " threw " + e.getClass().getName() + ">";
        goto L8
    }
}
