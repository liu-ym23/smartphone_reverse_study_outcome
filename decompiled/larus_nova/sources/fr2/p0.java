package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class p0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f478524a;

    public p0() {
        Intrinsics.checkNotNullParameter(this, "impl");
        this.f478524a = ((g0) vh6.c.b(g0.class)).o6().d(this);
    }

    @Override // xh6.c
    public Object getReal() {
        return this.f478524a;
    }
}
