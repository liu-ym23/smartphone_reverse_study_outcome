package com.obric.oui.window.permission;

import android.content.DialogInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementDialog$builder$3 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ e this$0;

    public PrivacyStatementDialog$builder$3(e r100) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DialogInterface r100, Integer r101) {
        invoke(r100, r101.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        throw null;
    }
}
