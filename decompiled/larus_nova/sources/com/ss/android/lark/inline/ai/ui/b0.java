package com.ss.android.lark.inline.ai.ui;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b0 implements PromptsAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubPromptsPanelController f427486a;

    public b0(SubPromptsPanelController r100) {
        this.f427486a = r100;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void a(Prompt r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        this.f427486a.f427474b.q(r100);
        if (r100.getRightArrow() == true) goto L6;
        this.f427486a.a(true, true);
        return;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsAdapter.b
    public final void b(Prompt r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        Log.i("SubPromptsPanelController", "RecentPrompt onDeleteClick");
        this.f427486a.f427474b.m(r100);
    }
}
