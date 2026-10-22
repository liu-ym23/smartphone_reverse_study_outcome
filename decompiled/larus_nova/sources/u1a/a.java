package u1a;

import com.larus.ui.arch.component.external.api.Component;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Function1<p1a.b, Component> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<p1a.b, Component> f548348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548349b;

    public final String toString() {
        return this.f548349b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Component invoke(p1a.b r100) {
        p1a.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "p1");
        return this.f548348a.invoke(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super p1a.b, ? extends Component> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f548348a = r100;
        this.f548349b = r101;
    }
}
