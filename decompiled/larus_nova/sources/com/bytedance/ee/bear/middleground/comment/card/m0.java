package com.bytedance.ee.bear.middleground.comment.card;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f231003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerViewScrollHelper.SetSmoothScroller f231004b;

    public m0(RecyclerView r100, RecyclerViewScrollHelper.SetSmoothScroller r101) {
        this.f231003a = r100;
        this.f231004b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerViewScrollHelper.b(this.f231003a, this.f231004b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
