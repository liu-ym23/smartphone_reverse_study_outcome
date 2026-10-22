package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class MentionPanelView$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public MentionPanelView$3(Object r100) {
        super(0, r100, MentionPanelListView.class, "unlockHeight", "unlockHeight()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MentionPanelListView r100 = (MentionPanelListView) this.receiver;
        r100.f(true);
        r100.j(0);
        r100.f298823h = null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
