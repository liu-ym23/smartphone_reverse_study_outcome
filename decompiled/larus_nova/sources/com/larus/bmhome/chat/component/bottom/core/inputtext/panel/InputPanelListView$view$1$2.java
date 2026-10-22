package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InputPanelListView$view$1$2 extends FunctionReferenceImpl implements Function1<ViewGroup, TextView> {
    public InputPanelListView$view$1$2(Object r100) {
        super(1, r100, InputPanelListView.class, "createHeader", "createHeader(Landroid/view/ViewGroup;)Landroid/widget/TextView;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TextView invoke2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        InputPanelListView r101 = (InputPanelListView) this.receiver;
        int r102 = InputPanelListView.f299040h;
        return r101.c(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TextView invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
