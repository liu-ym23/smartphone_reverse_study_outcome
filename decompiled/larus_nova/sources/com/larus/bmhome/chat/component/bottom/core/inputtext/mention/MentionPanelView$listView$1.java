package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class MentionPanelView$listView$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public MentionPanelView$listView$1(Object r100) {
        super(1, r100, q0.class, "onContentHeightChanged", "onContentHeightChanged(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        ((q0) this.receiver).f298957d.g(r100);
    }
}
