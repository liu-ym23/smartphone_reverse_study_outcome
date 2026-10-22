package com.larus.home.impl.main.side_bar.feed.arch;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CardFeedSlot$abilities$1$3 extends FunctionReferenceImpl implements Function1<List<? extends eb9.o<?>>, Unit> {
    public CardFeedSlot$abilities$1$3(Object r100) {
        super(1, r100, CardFeedSlot.class, "submitSelectionChangedCards", "submitSelectionChangedCards(Ljava/util/List;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends eb9.o<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((CardFeedSlot) this.receiver).c(r100, "selection", true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends eb9.o<?>> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
