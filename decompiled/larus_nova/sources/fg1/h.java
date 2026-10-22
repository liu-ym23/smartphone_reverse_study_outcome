package fg1;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements s00.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f476795a;

    @Override // s00.c
    public final void run() {
        this.f476795a.invoke();
    }

    @Override // s00.c
    public final r00.a getName() {
        return k.i.f476805a;
    }

    public h(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f476795a = r100;
    }
}
