package com.bytedance.android.shopping.prepurchase.arch.container.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/ability/a;", "T", "Ljava/lang/Class;", "service", "Lkotlin/coroutines/Continuation;", "continuation", "", "awaitServiceAvailable"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.container.component.ServiceRegistryImpl", f = "ServiceRegistry.kt", i = {}, l = {47}, m = "awaitServiceAvailable", n = {}, s = {})
public final class ServiceRegistryImpl$awaitServiceAvailable$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServiceRegistryImpl this$0;

    public ServiceRegistryImpl$awaitServiceAvailable$1(ServiceRegistryImpl r1, Continuation r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
