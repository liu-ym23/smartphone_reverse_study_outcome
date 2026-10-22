package com.larus.camera.impl.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class TabPickerView$scrollToItemCenter$scroll$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public TabPickerView$scrollToItemCenter$scroll$1(Object r100) {
        super(2, r100, RecyclerView.class, "smoothScrollBy", "smoothScrollBy(II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Integer r101) {
        invoke(r100.intValue(), r101.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, int r101) {
        ((RecyclerView) this.receiver).smoothScrollBy(r100, r101);
    }
}
