package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/anniex/bd/foundation/impl/h;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/anniex/bd/foundation/impl/h;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class AnnieXServiceStore$getServiceFactory$1 extends Lambda implements Function0<com.bytedance.anniex.bd.foundation.impl.h> {
    final /* synthetic */ k3 $service;

    public AnnieXServiceStore$getServiceFactory$1(k3 r100) {
        this.$service = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.bytedance.anniex.bd.foundation.impl.h invoke() {
        k3 r100 = this.$service;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ com.bytedance.anniex.bd.foundation.impl.h invoke() {
        return invoke();
    }
}
