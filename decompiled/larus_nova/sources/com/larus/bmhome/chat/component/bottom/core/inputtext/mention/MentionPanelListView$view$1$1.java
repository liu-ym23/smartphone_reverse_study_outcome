package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MentionPanelListView$view$1$1 extends FunctionReferenceImpl implements Function1<Integer, String> {
    public MentionPanelListView$view$1$1(Object r100) {
        super(1, r100, MentionPanelListView.PanelAdapter.class, "headerTitleAt", "headerTitleAt(I)Ljava/lang/String;", 0);
    }

    public final String invoke(int r100) {
        MentionPanelListView.PanelAdapter r101 = (MentionPanelListView.PanelAdapter) this.receiver;
        if (r101.f298839c == false) goto L11;
        Object r102 = CollectionsKt.getOrNull(r101.f298837a, r100);
        if ((r102 instanceof y.a) == false) goto L7;
        y.a r103 = (y.a) r102;
    L8:
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.f298972a;
    L7:
        r103 = null;
        goto L8
    L11:
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
