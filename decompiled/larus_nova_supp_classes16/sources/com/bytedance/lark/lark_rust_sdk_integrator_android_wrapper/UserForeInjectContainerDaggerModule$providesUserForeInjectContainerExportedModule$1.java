package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.lark_rust_sdk_integrator_android.l;
import com.bytedance.lark.view_flow_wrapper.v;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android_wrapper/UserForeInjectContainerExportedModuleWrapper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class UserForeInjectContainerDaggerModule$providesUserForeInjectContainerExportedModule$1 extends Lambda implements Function0<UserForeInjectContainerExportedModuleWrapper> {
    final /* synthetic */ l $param0;
    final /* synthetic */ v $strategy;

    public UserForeInjectContainerDaggerModule$providesUserForeInjectContainerExportedModule$1(l r1, v r2) {
        this.$param0 = r1;
        this.$strategy = r2;
        super(0);
    }

    public final UserForeInjectContainerExportedModuleWrapper invoke() {
        return new UserForeInjectContainerExportedModuleWrapper(this.$param0, this.$strategy);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m516invoke() {
        return invoke();
    }
}
