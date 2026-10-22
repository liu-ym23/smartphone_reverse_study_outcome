package com.larus.dora.impl.onboarding.othersmart.streamlined;

import com.larus.dora.impl.settings.SimplifiedTopic;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class f0<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraHStreamlinedWakeupFragment f337265a;

    public f0(DoraHStreamlinedWakeupFragment r100) {
        this.f337265a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        List<SimplifiedTopic> r102 = (List) r100;
        if (Intrinsics.areEqual(this.f337265a.f337222r, r102) == true) goto L5;
        DoraHStreamlinedWakeupFragment r103 = this.f337265a;
        r103.f337222r = r102;
        r103.f337223s = CollectionsKt.emptyList();
        this.f337265a.f337224t = 0;
    L5:
        this.f337265a.sa0();
        return Unit.INSTANCE;
    }
}
