package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements mcc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f414073a;

    public final c getContext() {
        return this.f414073a;
    }

    public d(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414073a = r100;
    }

    @Override // mcc.e
    public final void n(View r100, CodeBlockV2Info r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "codeBlockV2Info");
        float r102 = zz7.b.h(this.f414073a.getContext(), 14);
        CodeBlockV2ProcessParams.Companion.getClass();
        CodeBlockV2ProcessParams r103 = CodeBlockV2ProcessParams.b.a((int) r102);
        com.ss.android.lark.widget.richtext.codeblockv2.h.a(this.f414073a.getContext(), r101.getLineContents(), r103);
    }
}
