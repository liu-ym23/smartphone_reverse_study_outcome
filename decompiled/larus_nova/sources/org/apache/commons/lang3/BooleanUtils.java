package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes42.dex */
public class BooleanUtils {
    public static int compare(boolean r100, boolean r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 == false) goto L7;
        return 1;
    L7:
        return -1;
    }
}
