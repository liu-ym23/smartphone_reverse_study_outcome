package xp8;

import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements IComponentRegistry {
    public e() {
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final int priority() {
        return 0;
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final void register() {
        IComponentRegistry.a r100 = IComponentRegistry.f375180a;
        Function1 r101 = new c();
        r100.getClass();
        IComponentRegistry.a.b(r101);
    }
}
