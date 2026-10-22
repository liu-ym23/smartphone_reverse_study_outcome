package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InputPanelListView$view$1$1 extends FunctionReferenceImpl implements Function1<Integer, String> {
    public InputPanelListView$view$1$1(Object r100) {
        super(1, r100, InputPanelListView.c.class, "headerTitleAt", "headerTitleAt(I)Ljava/lang/String;", 0);
    }

    public final String invoke(int r100) {
        Object r101 = CollectionsKt.getOrNull(((InputPanelListView.c) this.receiver).f299048a, r100);
        if ((r101 instanceof o.b) == false) goto L5;
        o.b r102 = (o.b) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.f299086a;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
