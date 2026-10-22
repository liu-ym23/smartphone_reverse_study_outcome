package com.larus.chat.job.impl.component;

import com.larus.im.bean.job.AIJob;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListComponent$onViewCreated$listAdapter$2 extends FunctionReferenceImpl implements Function2<AIJob, Integer, Unit> {
    public ChatJobListComponent$onViewCreated$listAdapter$2(Object r100) {
        super(2, r100, ez8.a.class, "trackJobClick", "trackJobClick(Lcom/larus/im/bean/job/AIJob;I)V", 0);
    }

    public final void invoke(AIJob r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ez8.a) this.receiver).getClass();
        ez8.a.i(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AIJob r100, Integer r101) {
        invoke(r100, r101.intValue());
        return Unit.INSTANCE;
    }
}
