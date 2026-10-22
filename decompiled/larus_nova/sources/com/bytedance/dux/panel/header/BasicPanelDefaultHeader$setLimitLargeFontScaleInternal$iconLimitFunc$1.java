package com.bytedance.dux.panel.header;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BasicPanelDefaultHeader$setLimitLargeFontScaleInternal$iconLimitFunc$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ int $iconPadding;

    public BasicPanelDefaultHeader$setLimitLargeFontScaleInternal$iconLimitFunc$1(int r100) {
        this.$iconPadding = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        com.bytedance.dux.largefont.a.a(r100, 28, 28);
        int r101 = this.$iconPadding;
        r100.setPadding(r101, r101, r101, r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
