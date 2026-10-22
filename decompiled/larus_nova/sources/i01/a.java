package i01;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements h01.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Long, Boolean> f487846a;

    public a() {
    }

    @Override // h01.b
    public final void a(Function1<? super Long, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f487846a = r100;
    }
}
