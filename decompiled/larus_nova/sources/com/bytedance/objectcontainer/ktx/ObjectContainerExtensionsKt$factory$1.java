package com.bytedance.objectcontainer.ktx;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.objectcontainer.Factory;
import com.bytedance.objectcontainer.FactoryArg;
import com.bytedance.objectcontainer.ObjectContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0010\b\u0000\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "INSTANCE", "kotlin.jvm.PlatformType", "ARG", "Lcom/bytedance/objectcontainer/FactoryArg;", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class ObjectContainerExtensionsKt$factory$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ FactoryArg $arg;
    final /* synthetic */ ObjectContainer $this_factory;

    public ObjectContainerExtensionsKt$factory$1(ObjectContainer r100, FactoryArg r101) {
        this.$this_factory = r100;
        this.$arg = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObjectContainer r100 = this.$this_factory;
        Intrinsics.reifiedOperationMarker(4, "ARG");
        Factory r101 = r100.c(FactoryArg.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a();
    }
}
