package com.bytedance.assem.arch.extensions;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "T", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DataStoreExtKt$getProducerFactoryOrNull$2 extends Lambda implements Function0<Object> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ String $identify;
    final /* synthetic */ AssemViewModel $this_getProducerFactoryOrNull;

    public DataStoreExtKt$getProducerFactoryOrNull$2(AssemViewModel r1, Class r2, String r3) {
        this.$this_getProducerFactoryOrNull = r1;
        this.$clazz = r2;
        this.$identify = r3;
        super(0);
    }

    public final Object invoke() {
        com.bytedance.assem.arch.core.b r0 = this.$this_getProducerFactoryOrNull.getHierarchyDataStore();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(this.$clazz, this.$identify);
    }
}
