package com.facebook.keyframes.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ListHelper {
    public ListHelper() {
    }

    public static List immutableOrEmpty(List r100) {
        if (r100 != null) goto L5;
        return Collections.EMPTY_LIST;
    L5:
        return Collections.unmodifiableList(r100);
    }

    public static void sort(List r100, Comparator r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        Collections.sort(r100, r101);
        return;
    }
}
