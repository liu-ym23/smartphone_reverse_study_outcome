package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class n0 implements xh6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f478520a;

    public abstract void b(gr2.b r100, int r101, long r102, Exception r103);

    public abstract void l(gr2.b r100, int r101, long r102, Object... r103);

    public n0() {
        Intrinsics.checkNotNullParameter(this, "impl");
        this.f478520a = ((g0) vh6.c.b(g0.class)).o6().c(this);
    }

    @Override // xh6.c
    public Object getReal() {
        return this.f478520a;
    }
}
