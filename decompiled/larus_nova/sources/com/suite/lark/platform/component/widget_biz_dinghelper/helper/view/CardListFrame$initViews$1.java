package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CardListFrame$initViews$1 extends FunctionReferenceImpl implements Function2<Integer, View, Unit> {
    public CardListFrame$initViews$1(Object r100) {
        super(2, r100, CardListFrame.class, "onCardViewClicked", "onCardViewClicked(ILandroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, View r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        CardListFrame.a((CardListFrame) this.receiver, r100);
    }
}
