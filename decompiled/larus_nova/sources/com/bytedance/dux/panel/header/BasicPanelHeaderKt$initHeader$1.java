package com.bytedance.dux.panel.header;

import com.bytedance.dux.titlebar.DuxTitleBar;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/dux/titlebar/DuxTitleBar;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BasicPanelHeaderKt$initHeader$1 extends Lambda implements Function1<DuxTitleBar, Unit> {
    public static final BasicPanelHeaderKt$initHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelHeaderKt$initHeader$1();
    }

    public BasicPanelHeaderKt$initHeader$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DuxTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DuxTitleBar r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
