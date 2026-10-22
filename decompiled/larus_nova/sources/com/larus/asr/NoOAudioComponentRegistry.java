package com.larus.asr;

import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/NoOAudioComponentRegistry;", "Lcom/larus/ui/arch/modulizer/di/IComponentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoOAudioComponentRegistry implements IComponentRegistry {
    public NoOAudioComponentRegistry() {
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final int priority() {
        return 0;
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final void register() {
        IComponentRegistry.a r100 = IComponentRegistry.f375180a;
        Function1 r101 = new e3();
        r100.getClass();
        IComponentRegistry.a.b(r101);
    }
}
