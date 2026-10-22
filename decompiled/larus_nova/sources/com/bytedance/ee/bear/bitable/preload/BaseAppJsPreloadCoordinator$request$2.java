package com.bytedance.ee.bear.bitable.preload;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BaseAppJsPreloadCoordinator$request$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public BaseAppJsPreloadCoordinator$request$2(Object r100) {
        super(0, r100, BaseAppJsPreloadCoordinator.class, "kickDispatchOnMainThread", "kickDispatchOnMainThread()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseAppJsPreloadCoordinator.a((BaseAppJsPreloadCoordinator) this.receiver);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
