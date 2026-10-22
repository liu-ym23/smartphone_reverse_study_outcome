package com.ss.android.lark.active.user.bridge;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f408561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f408562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Resp f408563c;

    public b() {
        throw null;
    }

    public final String toString() {
        return "code=" + this.f408561a + ", message=" + this.f408562b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int r100, String r101, Object r102) {
        this.f408561a = r100;
        this.f408562b = r101;
        this.f408563c = r102;
    }
}
