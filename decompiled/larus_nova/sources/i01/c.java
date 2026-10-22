package i01;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements h01.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f487848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f487849b;

    public c() {
        this.f487848a = new b();
        this.f487849b = new a();
    }

    @Override // h01.d
    public final void a(Function1<? super h01.c, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.invoke(this.f487848a);
    }

    @Override // h01.d
    public final void b(Function1<? super h01.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.invoke(this.f487849b);
    }
}
