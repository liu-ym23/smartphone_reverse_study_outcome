package com.huawei.hms.common.internal;

/* JADX INFO: loaded from: classes23.dex */
public class ResolveClientBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f277114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnyClient f277115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f277116c;

    public void clientReconnect() {
        this.f277115b.connect(this.f277116c, true);
    }

    public AnyClient getClient() {
        return this.f277115b;
    }

    public int hashCode() {
        return this.f277114a;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof ResolveClientBean) == true) goto L10;
        return false;
    L10:
        return this.f277115b.equals(((ResolveClientBean) r100).f277115b);
    }

    public ResolveClientBean(AnyClient r100, int r101) {
        this.f277115b = r100;
        this.f277114a = Objects.hashCode(new Object[]{r100});
        this.f277116c = r101;
    }
}
