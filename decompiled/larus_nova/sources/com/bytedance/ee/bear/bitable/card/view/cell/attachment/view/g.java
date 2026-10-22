package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachmentGridView f207470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f207471b;

    public g(AttachmentGridView r100, int r101) {
        this.f207470a = r100;
        this.f207471b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f207470a.getMAttachmentAdapter().notifyItemChanged(this.f207471b, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
