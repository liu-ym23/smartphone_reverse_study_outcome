package com.relax.relaxreact.shared;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.kmp.foundation.i;
import com.bytedance.rts.kmp.foundation.p;
import com.bytedance.rts.kmp.foundation.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "ts", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class TaskScheduler$requestAnimationFrame$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Long, Unit> $callback;
    final /* synthetic */ Ref.BooleanRef $fired;
    final /* synthetic */ Ref.LongRef $frameId;
    final /* synthetic */ p<TaskScheduler> $weakSelf;

    /* JADX WARN: Multi-variable type inference failed */
    public TaskScheduler$requestAnimationFrame$1(Ref.BooleanRef r100, p<TaskScheduler> r101, Ref.LongRef r102, Function1<? super Long, Unit> r103) {
        this.$fired = r100;
        this.$weakSelf = r101;
        this.$frameId = r102;
        this.$callback = r103;
        super(1);
    }

    public final void invoke(final long r100) {
        this.$fired.element = true;
        TaskScheduler r101 = (TaskScheduler) q.a(this.$weakSelf);
        if (r101 != null) goto L5;
        return;
    L5:
        long r102 = this.$frameId.element;
        int r103 = i.d(r101.f405573h, Long.valueOf(r102));
        if (r103 == (-1)) goto L8;
        i.i(r101.f405573h, r103, new Long[0]);
    L8:
        final Function1<Long, Unit> r104 = this.$callback;
        TaskScheduler.a(r101, new AnonymousClass1(r104, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
        invoke(r100.longValue());
        return Unit.INSTANCE;
    }
}
