package qja;

import kotlin.jvm.internal.Intrinsics;
import oja.d;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.a f533435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.d f533436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.b f533437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.InterfaceC7343c f533438d;

    public a() {
    }

    @Override // qja.c
    public final void e(e r100) {
        Intrinsics.checkNotNullParameter(r100, "completionListener");
        this.f533435a = r100;
    }

    @Override // qja.c
    public final void f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "preparedListener");
        this.f533436b = r100;
    }

    @Override // qja.c
    public final void g(d r100) {
        Intrinsics.checkNotNullParameter(r100, "firstFrameListener");
        this.f533438d = r100;
    }

    @Override // qja.c
    public final void h(f r100) {
        Intrinsics.checkNotNullParameter(r100, "errorListener");
        this.f533437c = r100;
    }
}
