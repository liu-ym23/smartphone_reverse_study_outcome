package com.larus.home.impl.main.side_bar.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SideBarFloatingButtonView$updateTextLayout$resolveSize$2 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    public SideBarFloatingButtonView$updateTextLayout$resolveSize$2(Object r100) {
        super(1, r100, SideBarFloatingButtonView.class, "dimensionByDp", "dimensionByDp(I)I", 0);
    }

    public final Integer invoke(int r100) {
        SideBarFloatingButtonView r101 = (SideBarFloatingButtonView) this.receiver;
        int r102 = SideBarFloatingButtonView.f344826i;
        return Integer.valueOf(r101.e(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
