package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class BridgeRegistry$handle$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a $callback;
    final /* synthetic */ String $funcName;
    final /* synthetic */ Function4<String, Object, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a, Function1<? super Throwable, Unit>, Unit> $impl;
    final /* synthetic */ Object $params;
    final /* synthetic */ Function1<Throwable, Unit> $reject;

    /* JADX WARN: Multi-variable type inference failed */
    public BridgeRegistry$handle$4(Function4<? super String, Object, ? super com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a, ? super Function1<? super Throwable, Unit>, Unit> r100, String r101, Object r102, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a r103, Function1<? super Throwable, Unit> r104) {
        this.$impl = r100;
        this.$funcName = r101;
        this.$params = r102;
        this.$callback = r103;
        this.$reject = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$impl.invoke(this.$funcName, this.$params, this.$callback, this.$reject);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
