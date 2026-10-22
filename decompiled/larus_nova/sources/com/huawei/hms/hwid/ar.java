package com.huawei.hms.hwid;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f277505a = null;

    static {
        HashSet r100 = new HashSet();
        f277505a = r100;
        r100.add(0);
    }

    public static int a(int r100) {
        if (f277505a.contains(Integer.valueOf(r100)) == false) goto L6;
        return 0;
    L6:
        return 1;
    }
}
