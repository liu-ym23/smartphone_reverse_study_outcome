package com.bytedance.navigation.kmp.handler.tracker;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class NavigationLifecycleTraceCoordinator$1 extends FunctionReferenceImpl implements Function0<Long> {
    public NavigationLifecycleTraceCoordinator$1(Object r100) {
        super(0, r100, i.class, "nowMs", "nowMs()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        ((i) this.receiver).getClass();
        return Long.valueOf(Duration.m10811getInWholeMillisecondsimpl(TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(i.f265920b)));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
