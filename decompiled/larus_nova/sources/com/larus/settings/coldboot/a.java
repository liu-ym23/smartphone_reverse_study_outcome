package com.larus.settings.coldboot;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f368530d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f368531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f368532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f368533c;

    /* JADX INFO: renamed from: com.larus.settings.coldboot.a$a, reason: collision with other inner class name */
    public static final class C4487a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f368531a == r101.f368531a) goto L12;
        return false;
    L12:
        if (this.f368532b == r101.f368532b) goto L15;
        return false;
    L15:
        if (this.f368533c == r101.f368533c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f368531a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f368532b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f368533c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KevaEarlyPerfOptConfig(enableInitRepoMainOnlyOpt=" + this.f368531a + ", enableGetRepoLockOpt=" + this.f368532b + ", enableExecutorOpt=" + this.f368533c + ')';
    }

    static {
        f368530d = new a(false, false, false);
    }

    public a(boolean r100, boolean r101, boolean r102) {
        this.f368531a = r100;
        this.f368532b = r101;
        this.f368533c = r102;
    }
}
