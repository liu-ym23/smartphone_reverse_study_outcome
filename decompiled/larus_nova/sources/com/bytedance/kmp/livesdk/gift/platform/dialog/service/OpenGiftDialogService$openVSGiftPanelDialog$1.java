package com.bytedance.kmp.livesdk.gift.platform.dialog.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import i12.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li12/p;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Li12/p;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class OpenGiftDialogService$openVSGiftPanelDialog$1 extends Lambda implements Function1<p, Unit> {
    public static final OpenGiftDialogService$openVSGiftPanelDialog$1 INSTANCE = null;

    static {
        INSTANCE = new OpenGiftDialogService$openVSGiftPanelDialog$1();
    }

    public OpenGiftDialogService$openVSGiftPanelDialog$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        p r101 = e.f252337e;
        e.f252337e = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
