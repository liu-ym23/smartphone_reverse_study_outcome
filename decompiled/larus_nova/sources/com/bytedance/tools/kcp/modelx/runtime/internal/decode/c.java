package com.bytedance.tools.kcp.modelx.runtime.internal.decode;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f270978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f270979b;

    public c(Object r100, Object r101) {
        if (r100 == null) goto L11;
        this.f270978a = r100;
        if (r101 == null) goto L9;
        this.f270979b = r101;
        return;
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
