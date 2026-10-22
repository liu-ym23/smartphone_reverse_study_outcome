package com.ss.android.lark.inline.ai.creationai.editor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIEditorWebview f427093a;

    public e(CreationAIEditorWebview r100) {
        this.f427093a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f427093a.setVerticalScrollBarEnabled(false);     // Catch: Throwable -> L4
        this.f427093a.setHorizontalScrollBarEnabled(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
