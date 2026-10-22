package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android_wrapper/ICommandMoltenService;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ICommandMoltenService$Companion$from$1 extends Lambda implements Function0<c> {
    final /* synthetic */ UserForeInjectContainerExportedModuleWrapper $container;

    public ICommandMoltenService$Companion$from$1(UserForeInjectContainerExportedModuleWrapper r1) {
        this.$container = r1;
        super(0);
    }

    public final c invoke() {
        return (b) this.$container.e.getValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m510invoke() {
        return invoke();
    }
}
