package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z1 implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.m1.b f478580a;

    @Override // fr2.k0
    public final int d() {
        return this.f478580a.d();
    }

    @Override // fr2.k0
    public final float getBottom() {
        return this.f478580a.getBottom();
    }

    @Override // fr2.k0
    public final float getLeft() {
        return this.f478580a.getLeft();
    }

    @Override // fr2.k0
    public final int getMode() {
        return this.f478580a.getMode();
    }

    @Override // fr2.k0
    public final float getRight() {
        return this.f478580a.getRight();
    }

    @Override // fr2.k0
    public final float getTop() {
        return this.f478580a.getTop();
    }

    @Override // fr2.k0
    public final boolean getVisible() {
        return this.f478580a.isVisible();
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478580a;
    }

    public z1(uf2.m1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478580a = r100;
    }

    @Override // fr2.k0
    public final void I4(float r100) {
        this.f478580a.b();
    }

    @Override // fr2.k0
    public final void J2(float r100) {
        this.f478580a.f();
    }

    @Override // fr2.k0
    public final void K1(float r100) {
        this.f478580a.e();
    }

    @Override // fr2.k0
    public final void h3(int r100) {
        this.f478580a.h();
    }

    @Override // fr2.k0
    public final void p1(float r100) {
        this.f478580a.c();
    }

    @Override // fr2.k0
    public final void setMode(int r100) {
        this.f478580a.g();
    }

    @Override // fr2.k0
    public final void setVisible(boolean r100) {
        this.f478580a.i();
    }
}
