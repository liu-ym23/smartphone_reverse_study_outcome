package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/bullet/core/kit/bridge/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class BridgeRegistry$handle$3 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Function4<String, Object, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a, Function1<? super Throwable, Unit>, Unit> $impl;

    /* JADX WARN: Multi-variable type inference failed */
    public BridgeRegistry$handle$3(Function4<? super String, Object, ? super com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a, ? super Function1<? super Throwable, Unit>, Unit> r100) {
        this.$impl = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Function4<String, Object, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a, Function1<? super Throwable, Unit>, Unit> r101 = this.$impl;
        r100.getClass();
        r101.invoke(null, null, null, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
