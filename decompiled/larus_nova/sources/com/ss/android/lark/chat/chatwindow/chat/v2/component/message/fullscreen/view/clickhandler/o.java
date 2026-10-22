package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements mcc.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f414115a;

    @Override // mcc.i
    public final boolean o(View r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        return false;
    }

    public final c getContext() {
        return this.f414115a;
    }

    public o(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414115a = r100;
    }

    @Override // mcc.i
    public final void p(View r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        ChatCoreModule.a().openAppLinkUrl(this.f414115a.getContext(), r104);
    }
}
