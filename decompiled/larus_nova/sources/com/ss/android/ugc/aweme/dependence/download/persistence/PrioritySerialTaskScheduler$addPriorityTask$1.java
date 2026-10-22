package com.ss.android.ugc.aweme.dependence.download.persistence;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.dependence.download.persistence.task.SerialTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Param", "Target", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class PrioritySerialTaskScheduler$addPriorityTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SerialTask $task;
    final /* synthetic */ PrioritySerialTaskScheduler this$0;

    public PrioritySerialTaskScheduler$addPriorityTask$1(PrioritySerialTaskScheduler r100, SerialTask r101) {
        this.$task = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        throw null;
    }
}
