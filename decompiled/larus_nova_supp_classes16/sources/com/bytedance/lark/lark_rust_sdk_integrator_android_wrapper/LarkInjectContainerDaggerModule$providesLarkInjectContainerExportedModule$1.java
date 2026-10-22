package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.v;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android_wrapper/LarkInjectContainerExportedModuleWrapper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LarkInjectContainerDaggerModule$providesLarkInjectContainerExportedModule$1 extends Lambda implements Function0<LarkInjectContainerExportedModuleWrapper> {
    final /* synthetic */ v $strategy;

    public LarkInjectContainerDaggerModule$providesLarkInjectContainerExportedModule$1(v r1) {
        this.$strategy = r1;
        super(0);
    }

    public final LarkInjectContainerExportedModuleWrapper invoke() {
        return new LarkInjectContainerExportedModuleWrapper(this.$strategy);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m512invoke() {
        return invoke();
    }
}
