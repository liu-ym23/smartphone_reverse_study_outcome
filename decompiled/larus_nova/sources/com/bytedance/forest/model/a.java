package com.bytedance.forest.model;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.forest.utils.e f244327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f244328b;

    public abstract void a(int r100, byte[] r101, int r102, int r103);

    public abstract void b();

    public abstract void c();

    public abstract boolean d();

    public abstract byte[] e();

    public abstract void f(int r100, byte[] r101, int r102, int r103);

    public com.bytedance.forest.utils.e getContext() {
        return this.f244327a;
    }

    public void g(com.bytedance.forest.utils.e r100) {
        this.f244327a = r100;
    }

    public a(int r100, com.bytedance.forest.utils.e r101) {
        this.f244328b = r100;
        this.f244327a = r101;
    }
}
