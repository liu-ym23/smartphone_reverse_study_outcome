package com.ss.android.lark.inline.ai.creationai;

import android.text.TextUtils;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i0 implements QuickPromptAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f427136a;

    public i0(g0 r100) {
        this.f427136a = r100;
    }

    @Override // com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptAdapter.b
    public final void a(MenuItem r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItem");
        if (TextUtils.equals(r100.getType(), "dataset") == false) goto L5;
        this.f427136a.f427111b.o(r100);
        return;
    L5:
        this.f427136a.f427111b.n(r100);
    }
}
