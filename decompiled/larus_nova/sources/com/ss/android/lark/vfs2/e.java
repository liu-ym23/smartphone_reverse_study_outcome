package com.ss.android.lark.vfs2;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f444836b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f444837a;

    public static final class a {
    }

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f444837a == ((e) r100).f444837a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f444837a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "FileSystemOptions(useCache=" + this.f444837a + ')';
    }

    static {
        f444836b = new e(0);
    }

    public e(int r100) {
        this.f444837a = true;
    }
}
