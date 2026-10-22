package com.larus.chat.job.impl.page;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListViewModel$loader$1 extends FunctionReferenceImpl implements Function1<j, Unit> {
    public ChatJobListViewModel$loader$1(Object r100) {
        super(1, r100, ChatJobListViewModel.class, ChameleonOpenTracker.Stage.RENDER, "render(Lcom/larus/chat/job/impl/page/ChatJobListLoadSnapshot;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(j r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ChatJobListViewModel.access$render((ChatJobListViewModel) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(j r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
