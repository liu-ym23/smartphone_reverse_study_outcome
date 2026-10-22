package com.bytedance.android.livesdk.linkvideo.view;

import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LinkVideoDialog$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g this$0;

    public LinkVideoDialog$show$1(g r1) {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m518invoke() {
        int r0 = g.b;
        if (DialogLancet.shouldBlockDialogShow(null) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(null);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(null);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m518invoke();
        return Unit.INSTANCE;
    }
}
