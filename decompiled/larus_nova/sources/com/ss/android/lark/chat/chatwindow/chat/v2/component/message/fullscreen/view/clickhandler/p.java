package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import androidx.autofill.HintConstants;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements mcc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f414116a;

    @Override // mcc.l
    public final void b(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
    }

    public final c getContext() {
        return this.f414116a;
    }

    public p(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414116a = r100;
    }

    @Override // mcc.l
    public final void a(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        ChatCoreModule.a().getPhoneDependency().a(this.f414116a.getContext(), r101);
    }
}
