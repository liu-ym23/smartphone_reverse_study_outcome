package com.bytedance.ee.bear.bitable.infoarch.view;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f213742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f213743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f213744c;

    public a(RecyclerView r100, int r101) {
        this.f213742a = false;
        this.f213743b = r100;
        this.f213744c = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.f213742a == false) goto L5;
        this.f213743b.smoothScrollToPosition(this.f213744c);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        this.f213743b.scrollToPosition(this.f213744c);     // Catch: Throwable -> L7
        goto L12
    }
}
