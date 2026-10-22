package com.larus.bmhome.instruction;

/* JADX INFO: loaded from: classes26.dex */
public final class a2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f311884g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f311885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f311886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f311887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f311888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f311889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f311890f;

    public static final class a {
    }

    static {
        f311884g = true;
    }

    public a2() {
        this.f311885a = f311884g;
        f311884g = false;
    }

    public static Long a(long r100, long r101) {
        if (r100 > 0) goto L5;
    L7:
        return null;
    L5:
        if (r101 <= 0) goto L7;
        return Long.valueOf(r101 - r100);
    }
}
