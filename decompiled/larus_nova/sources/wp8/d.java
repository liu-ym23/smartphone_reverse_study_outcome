package wp8;

import aq8.f;
import com.larus.im.internal.delegate.c0;
import cq8.b0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f560614a = null;

    static {
        f560614a = new d();
    }

    public d() {
    }

    public final i1<b0> b() {
        c0.f348199b.e("NoopInstructionCoreAbility", "[renderModelFlow] noop implementation");
        return j1.a(b0.f464803d);
    }

    @Override // wp8.c
    public final i1<b0> Jf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelId");
        return b();
    }

    @Override // wp8.c
    public final f ki(aq8.c r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        c0.f348199b.e("NoopInstructionCoreAbility", "[handleIntent] noop implementation");
        return f.b.f15952a;
    }

    @Override // wp8.c
    public final void sl(aq8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        c0.f348199b.e("NoopInstructionCoreAbility", "[setupDependency] noop implementation");
    }
}
