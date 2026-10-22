package t0a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f544131a;

    public final k0a.a a() {
        return (k0a.a) this.f544131a.getValue();
    }

    public a() {
        this.f544131a = j1.a(new k0a.a(0));
    }

    public final void update(Function1<? super k0a.a, k0a.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        StateFlowImpl r101 = this.f544131a;
    L3:
        Object r102 = r101.getValue();
        if (r101.compareAndSet(r102, r100.invoke((k0a.a) r102)) == false) goto L3;
    }
}
