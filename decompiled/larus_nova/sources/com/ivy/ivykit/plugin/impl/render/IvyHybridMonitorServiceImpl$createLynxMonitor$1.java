package com.ivy.ivykit.plugin.impl.render;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class IvyHybridMonitorServiceImpl$createLynxMonitor$1 extends FunctionReferenceImpl implements Function1<Runnable, Unit> {
    public IvyHybridMonitorServiceImpl$createLynxMonitor$1(Object r100) {
        super(1, r100, ExecutorService.class, "execute", "execute(Ljava/lang/Runnable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Runnable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Runnable r100) {
        ((ExecutorService) this.receiver).execute(r100);
    }
}
