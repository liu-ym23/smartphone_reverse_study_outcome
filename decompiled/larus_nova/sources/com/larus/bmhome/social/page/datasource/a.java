package com.larus.bmhome.social.page.datasource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a<T, Key> {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return 38347;
    }

    public final String toString() {
        return "Config(pageSize=0, startKey=null, autoRefresh=false, reusedData=null)";
    }
}
