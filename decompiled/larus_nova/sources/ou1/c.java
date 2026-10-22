package ou1;

import java.util.Map;
import ju1.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements nu1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu1.b f526720a;

    public static final class a {
    }

    static {
    }

    public c() {
        nu1.a r100 = nu1.a.f520601a;
        Intrinsics.checkNotNullParameter(r100, "expressionExecutor");
        this.f526720a = r100;
    }

    @Override // nu1.d
    public final boolean b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return r100 instanceof ju1.b;
    }

    @Override // nu1.d
    public final boolean a(l r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "stateMap");
        if ((r100 instanceof ju1.b) == true) goto L7;
        return r100.a();
    L7:
        return Intrinsics.areEqual(this.f526720a.a(((ju1.b) r100).d(), r101), Boolean.TRUE);
    }
}
