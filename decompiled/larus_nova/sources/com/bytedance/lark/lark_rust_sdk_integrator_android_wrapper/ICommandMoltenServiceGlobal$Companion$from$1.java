package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android_wrapper/ICommandMoltenServiceGlobal;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ICommandMoltenServiceGlobal$Companion$from$1 extends Lambda implements Function0<d> {
    final /* synthetic */ LarkInjectContainerExportedModuleWrapper $container;

    public ICommandMoltenServiceGlobal$Companion$from$1(LarkInjectContainerExportedModuleWrapper r100) {
        this.$container = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d invoke() {
        return (a) this.$container.f253257e.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d invoke() {
        return invoke();
    }
}
