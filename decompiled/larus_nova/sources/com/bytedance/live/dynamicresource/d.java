package com.bytedance.live.dynamicresource;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f255131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f255132b;

    static {
        f255131a = new d();
    }

    public d() {
    }

    public final b getContext() {
        b r100 = f255132b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new b(new b.a());
    }
}
