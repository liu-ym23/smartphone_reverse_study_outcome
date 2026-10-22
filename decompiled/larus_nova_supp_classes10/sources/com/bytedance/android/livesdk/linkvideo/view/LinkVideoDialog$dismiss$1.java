package com.bytedance.android.livesdk.linkvideo.view;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LinkVideoDialog$dismiss$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g this$0;

    public LinkVideoDialog$dismiss$1(g r1) {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m517invoke() {
        int r0 = g.b;
        Handler r1 = DialogLancet.resolveDialogHandler(null);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(null);
        throw null;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L9
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L9
        if (r2 == null) goto L15;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L9
    L15:
        DialogLancet.afterDialogDismiss(null);
        return;
    L9:
        th = move-exception;
        DialogLancet.afterDialogDismiss(null);
        throw th;
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(null));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m517invoke();
        return Unit.INSTANCE;
    }
}
