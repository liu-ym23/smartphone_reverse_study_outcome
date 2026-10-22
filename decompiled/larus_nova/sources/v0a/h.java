package v0a;

import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements IComponentRegistry {
    public h() {
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final int priority() {
        return 0;
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final void register() {
        IComponentRegistry.a r100 = IComponentRegistry.f375180a;
        Function1 r101 = new a();
        r100.getClass();
        IComponentRegistry.a.b(r101);
        IComponentRegistry.a.c(new b());
    }
}
