package com.ss.android.lark.inline.ai.ui.richtext;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichtextPreviewWebview f427651a;

    public j(RichtextPreviewWebview r100) {
        this.f427651a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f427651a.setVerticalScrollBarEnabled(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
