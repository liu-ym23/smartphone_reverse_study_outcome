package com.ss.android.lark.ug.scheduler.coordinator.entity;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "N", "Lcom/ss/android/lark/ug/scheduler/coordinator/entity/DAGraph$DAGNode;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/ug/scheduler/coordinator/entity/DAGraph$DAGNode;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DAGraph$topologicalSort$1 extends Lambda implements Function1<DAGraph.b, Unit> {
    final /* synthetic */ List<DAGraph.b> $result;

    public DAGraph$topologicalSort$1(List<DAGraph.b> r100) {
        this.$result = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DAGraph.b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$result.add(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DAGraph.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
