package com.obric.oui.panel.header;

import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/titlebar/OTitleBar;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    public BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$initHeader");
        if ((r100 instanceof ONormalTitleBar) == false) goto L13;
        ONormalTitleBar r101 = (ONormalTitleBar) r100;
        ImageView r102 = r101.getStartBtn();
        if (r102 == null) goto L8;
        r102.setPadding(pla.d.n(r102, 10), pla.d.n(r102, 10), pla.d.n(r102, 10), pla.d.n(r102, 10));
    L8:
        ImageView r103 = r101.getEndBtn();
        if (r103 == null) goto L14;
        r103.setPadding(pla.d.n(r103, 10), pla.d.n(r103, 10), pla.d.n(r103, 10), pla.d.n(r103, 10));
        return;
    L14:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OTitleBar r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
