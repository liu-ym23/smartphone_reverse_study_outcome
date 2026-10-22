package com.obric.aiagent.ipc.control;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f384691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f384692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f384693c;

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.a$a, reason: collision with other inner class name */
    public static final class C4584a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f384691a == r101.f384691a) goto L12;
        return false;
    L12:
        if (this.f384692b == r101.f384692b) goto L15;
        return false;
    L15:
        if (this.f384693c == r101.f384693c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f384691a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f384692b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f384693c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "BinderControlConfig(waitConnectTimeLimitMs=" + this.f384691a + ", maxDiedRebindDelayMs=" + this.f384692b + ", maxFailRebindDelayMs=" + this.f384693c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(5000, 600000, 30000);
    }

    public a(long r100, long r101, long r102) {
        this.f384691a = r100;
        this.f384692b = r101;
        this.f384693c = r102;
    }
}
