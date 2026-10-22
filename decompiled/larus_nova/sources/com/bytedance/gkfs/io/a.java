package com.bytedance.gkfs.io;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f245184b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f245185a;

    /* JADX INFO: renamed from: com.bytedance.gkfs.io.a$a, reason: collision with other inner class name */
    public static final class C3509a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f245185a == ((a) r100).f245185a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f245185a;
    }

    public final String toString() {
        return "BlockIdentifier(value=" + this.f245185a + ")";
    }

    static {
        f245184b = new a(-1);
    }

    public final int a() {
        return this.f245185a;
    }

    public a(int r100) {
        this.f245185a = r100;
    }
}
