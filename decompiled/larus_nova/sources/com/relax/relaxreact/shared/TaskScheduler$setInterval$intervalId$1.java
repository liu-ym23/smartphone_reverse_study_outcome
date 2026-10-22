package com.relax.relaxreact.shared;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.kmp.foundation.p;
import com.bytedance.rts.kmp.foundation.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class TaskScheduler$setInterval$intervalId$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ p<TaskScheduler> $weakSelf;

    public TaskScheduler$setInterval$intervalId$1(p<TaskScheduler> r100, Function0<Unit> r101) {
        this.$weakSelf = r100;
        this.$callback = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TaskScheduler r100 = (TaskScheduler) q.a(this.$weakSelf);
        if (r100 != null) goto L5;
        return;
    L5:
        TaskScheduler.a(r100, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
