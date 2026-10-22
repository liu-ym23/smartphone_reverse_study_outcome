package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.linkvideo.h;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LinkVideoIntroduceDialog a;

    public f(LinkVideoIntroduceDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if ((this.a.getContext() instanceof FragmentActivity) == false) goto L27;
        h r8 = h.a;
        String r3 = LinkVideoIntroduceDialog.l;
        FragmentActivity r9 = this.a.getContext();
        if (r9 == null) goto L26;
        FragmentManager r1 = r9.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r1, "manager");
        ALogger.d("UILinkVideoManager", "关联视频：goLinkVideoDialog");
        IRoomModuleService r0 = k.f(IRoomModuleService.class);
        if (r0 == null) goto L9;
        r0.showLinkVideoDialog(r1, 1, r3, 0);
    L9:
        IRoomModuleService r10 = k.f(IRoomModuleService.class);
        if (r10 == null) goto L28;
        com.bytedance.android.livesdk.linkvideo.b r11 = r10.getLinkVideoTea();
        if (r11 == null) goto L28;
        if (LinkVideoIntroduceDialog.m == false) goto L16;
        String r2 = "auto_play";
    L17:
        r11.d(r2, this.a.j);
        goto L28
    L16:
        r2 = "active_click";
    L28:
        this.a.dismiss();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L30;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L30:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
