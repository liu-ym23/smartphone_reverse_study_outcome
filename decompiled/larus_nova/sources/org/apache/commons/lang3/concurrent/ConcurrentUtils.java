package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public class ConcurrentUtils {
    public static Throwable checkedException(Throwable r100) {
        if (r100 != null) goto L5;
    L9:
        boolean r101 = false;
    L10:
        Validate.isTrue(r101, "Not a checked exception: " + r100, new Object[0]);
        return r100;
    L5:
        if ((r100 instanceof RuntimeException) == true) goto L9;
        if ((r100 instanceof Error) == true) goto L9;
        r101 = true;
        goto L10
    }
}
