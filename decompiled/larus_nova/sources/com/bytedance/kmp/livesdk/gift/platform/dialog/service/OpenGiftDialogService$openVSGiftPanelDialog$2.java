package com.bytedance.kmp.livesdk.gift.platform.dialog.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/d;", "", AbsMethodDelegate.TAG_INVOKE, "(Lyy0/d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class OpenGiftDialogService$openVSGiftPanelDialog$2 extends Lambda implements Function1<yy0.d, Unit> {
    final /* synthetic */ e this$0;

    public OpenGiftDialogService$openVSGiftPanelDialog$2(e r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(yy0.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(AnonymousClass1.INSTANCE);
        r100.b(new AnonymousClass2(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(yy0.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
