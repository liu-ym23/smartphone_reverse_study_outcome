package kjc;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f503730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f503731b;

    public c() {
        this.f503730a = new b();
    }

    public final b<T> c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (this.f503731b == true) goto L6;
        r100.run();
    L6:
        return this.f503730a;
    }

    public final b<T> d(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (this.f503731b == true) goto L6;
        b<T> r101 = this.f503730a;
        r101.f503729a = r100.invoke();
    L6:
        return this.f503730a;
    }

    public final void a(int r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (r100 != a.a()) goto L6;
        r101.run();
        this.f503731b = true;
        return;
    }

    public final void b(int r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 != a.a()) goto L6;
        b<T> r102 = this.f503730a;
        r102.f503729a = r101.invoke();
        this.f503731b = true;
        return;
    }
}
