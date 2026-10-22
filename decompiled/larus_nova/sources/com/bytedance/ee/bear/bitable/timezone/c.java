package com.bytedance.ee.bear.bitable.timezone;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.facade.common.widget.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableTimeZoneListFragment f215951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f215952b;

    public c(BitableTimeZoneListFragment r100, Ref.IntRef r101) {
        this.f215951a = r100;
        this.f215952b = r101;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        if (r100 == 0) goto L12;
    L10:
        this.f215952b.element = r100;
        return;
    L12:
        this.f215951a.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L10;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
