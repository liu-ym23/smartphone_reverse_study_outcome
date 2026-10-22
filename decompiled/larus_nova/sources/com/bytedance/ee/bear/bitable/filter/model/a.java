package com.bytedance.ee.bear.bitable.filter.model;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final boolean a(String r100) {
        EFilterOperator.Companion.getClass();
        EFilterOperator r101 = EFilterOperator.a.a(r100);
        if (r101 != null) goto L6;
    L10:
        return false;
    L6:
        if (r101 != EFilterOperator.IsEmpty) goto L8;
    L11:
        return true;
    L8:
        if (r101 != EFilterOperator.IsNotEmpty) goto L10;
        goto L10
    }
}
