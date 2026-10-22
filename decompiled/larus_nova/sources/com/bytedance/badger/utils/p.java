package com.bytedance.badger.utils;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199275b;

    public p(int r100, String r101) {
        this.f199274a = r100;
        this.f199275b = r101;
    }

    public final String a() {
        if (this.f199274a != (-7001)) goto L6;
        return "user not login";
    L6:
        String r100 = this.f199275b;
        if (r100 != null) goto L9;
    L14:
        StringBuilder r101 = new StringBuilder("error: ");
        r101.append(this.f199274a);
    L13:
        return r101.toString();
    L9:
        if (r100.isEmpty() == true) goto L14;
        r101 = new StringBuilder("error: ");
        r101.append(this.f199274a);
        r101.append(" (");
        r101.append(this.f199275b);
        r101.append(")");
        goto L13
    }
}
