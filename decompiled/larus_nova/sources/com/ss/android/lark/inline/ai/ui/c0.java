package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c0 implements PromptsRecyclerView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubPromptsPanelController f427488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f427489b;

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView.b
    public final void a(boolean r100) {
        PromptsRecyclerView r101 = this.f427488a.f427477e;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r101 = null;
    L6:
        if (r101.getVisibility() != 0) goto L13;
        View r102 = this.f427489b;
        if (r100 == false) goto L10;
        int r103 = 0;
    L11:
        r102.setVisibility(r103);
        return;
    L10:
        r103 = 8;
        goto L11
    }

    public c0(SubPromptsPanelController r100, View r101) {
        this.f427488a = r100;
        this.f427489b = r101;
    }
}
