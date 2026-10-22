package com.huawei.hms.hwid;

import java.util.Collection;

/* JADX INFO: loaded from: classes23.dex */
public class ap {
    public static Boolean a(Collection r100) {
        if (r100 == null) goto L9;
        if (r100.size() == 0) goto L9;
        return Boolean.FALSE;
    L9:
        return Boolean.TRUE;
    }

    public static Boolean b(Collection r100) {
        return Boolean.valueOf(!a(r100).booleanValue());
    }
}
