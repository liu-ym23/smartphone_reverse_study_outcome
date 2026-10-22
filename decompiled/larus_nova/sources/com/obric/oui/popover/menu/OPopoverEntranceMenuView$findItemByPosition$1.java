package com.obric.oui.popover.menu;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$b;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class OPopoverEntranceMenuView$findItemByPosition$1 extends Lambda implements Function1<OPopoverEntranceMenuView.b, Boolean> {
    public static final OPopoverEntranceMenuView$findItemByPosition$1 INSTANCE = null;

    static {
        INSTANCE = new OPopoverEntranceMenuView$findItemByPosition$1();
    }

    public OPopoverEntranceMenuView$findItemByPosition$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(OPopoverEntranceMenuView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.f402302l != 0) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(OPopoverEntranceMenuView.b r100) {
        return invoke2(r100);
    }
}
