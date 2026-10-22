package iwc;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scope f496307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<lwc.a> f496308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lwc.a f496309c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(org.koin.core.a r100, Scope r101, Function0<? extends lwc.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "koin");
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f496307a = r101;
        this.f496308b = r102;
        if (r102 != 0) goto L5;
        lwc.a r103 = null;
    L6:
        if (r103 != null) goto L8;
        r103 = new lwc.a(0);
    L8:
        this.f496309c = r103;
        return;
    L5:
        r103 = (lwc.a) r102.invoke();
        goto L6
    }
}
