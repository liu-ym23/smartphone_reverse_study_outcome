package com.larus.home.impl.main.side_bar.view.group.render;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ConversationGroupContent$feedSource$2 extends FunctionReferenceImpl implements Function1<eb9.o<?>, Unit> {
    public ConversationGroupContent$feedSource$2(Object r100) {
        super(1, r100, com.larus.home.impl.main.side_bar.view.b.class, "onFlowFeedCardSelected", "onFlowFeedCardSelected(Lcom/larus/home/api/feed/FlowUIFeedCard;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(eb9.o<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((com.larus.home.impl.main.side_bar.view.b) this.receiver).Zq(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(eb9.o<?> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
