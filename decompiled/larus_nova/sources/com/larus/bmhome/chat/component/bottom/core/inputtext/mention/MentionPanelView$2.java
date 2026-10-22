package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class MentionPanelView$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public MentionPanelView$2(Object r100) {
        super(0, r100, MentionPanelListView.class, "contentHeightPx", "contentHeightPx()I", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        MentionPanelListView r100 = (MentionPanelListView) this.receiver;
        int r101 = r100.g(r100.f298826k);
        Integer r102 = r100.f298823h;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L7:
        return Integer.valueOf(Math.max(r101, r103));
    L5:
        r103 = 0;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
