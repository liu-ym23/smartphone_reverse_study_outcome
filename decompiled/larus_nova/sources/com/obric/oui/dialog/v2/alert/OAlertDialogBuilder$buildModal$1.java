package com.obric.oui.dialog.v2.alert;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAlertDialogBuilder$buildModal$1 extends Lambda implements Function1<CharSequence, Unit> {
    final /* synthetic */ h $dialogModal;
    final /* synthetic */ g this$0;

    public OAlertDialogBuilder$buildModal$1(h r100, g r101) {
        this.$dialogModal = r100;
        this.this$0 = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$dialogModal.setMessage(r100);
        if (this.this$0.f400762z == false) goto L6;
        this.$dialogModal.getClass();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CharSequence r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
