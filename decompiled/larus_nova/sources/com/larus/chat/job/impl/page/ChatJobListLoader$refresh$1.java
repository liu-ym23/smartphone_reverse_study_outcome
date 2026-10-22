package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJobRequestType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListLoader$refresh$1 extends FunctionReferenceImpl implements Function1<AIJobRequestType, Unit> {
    public ChatJobListLoader$refresh$1(Object r100) {
        super(1, r100, ChatJobListLoader.class, "finishPullRefreshRequest", "finishPullRefreshRequest(Lcom/larus/im/bean/job/AIJobRequestType;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AIJobRequestType r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ChatJobListLoader r101 = (ChatJobListLoader) this.receiver;
        int r102 = ChatJobListLoader.f325083t;
        r101.e(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AIJobRequestType r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
