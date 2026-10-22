package com.obric.assistant.live.island;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ComplexTaskQueueingIslandModule$getQueueingTasks$2 extends FunctionReferenceImpl implements Function1<DMTaskState, Long> {
    public ComplexTaskQueueingIslandModule$getQueueingTasks$2(Object r100) {
        super(1, r100, p.class, "getQueueingTaskTimestamp", "getQueueingTaskTimestamp(Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;)J", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(DMTaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        p r101 = (p) this.receiver;
        int r102 = p.f390129e;
        r101.getClass();
        String r103 = r100.getExtra().get("o_task_queue_timestamp");
        if (r103 == null) goto L7;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L7;
        long r105 = r104.longValue();
    L9:
        return Long.valueOf(r105);
    L7:
        r105 = Long.MAX_VALUE;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(DMTaskState r100) {
        return invoke2(r100);
    }
}
