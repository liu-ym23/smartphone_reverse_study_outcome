package com.relax.relaxreact;

/* JADX INFO: loaded from: classes34.dex */
public final class Context<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f405397b;

    public Context(T r100) {
        int r101 = j.f405523a;
        j.f405523a = r101 + 1;
        this.f405396a = r101;
        this.f405397b = r100;
        e.a(new AnonymousClass1(this));
        e.a(new AnonymousClass2(this));
    }
}
