package com.bytedance.ug.sdk.luckydog.base.pagecollect;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f271751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f271752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271753c;

    public b() {
    }

    public final long a(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PageMemCollectManager", "getMemorySize error mem type " + r100);
        return this.f271752b;
    L11:
        return this.f271753c;
    L13:
        return this.f271751a;
    L15:
        return this.f271752b;
    }
}
