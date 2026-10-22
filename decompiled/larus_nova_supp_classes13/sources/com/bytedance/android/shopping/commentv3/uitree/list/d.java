package com.bytedance.android.shopping.commentv3.uitree.list;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ CommentListUI.a a;

    public d(CommentListUI.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentListUI r0 = this.a.a;     // Catch: Throwable -> L14
        int r1 = CommentListUI.o;     // Catch: Throwable -> L14
        RecyclerView r2 = r0.i;     // Catch: Throwable -> L14
        RecyclerView.LayoutManager r3 = null;
        if (r2 == null) goto L5;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();     // Catch: Throwable -> L14
    L7:
        if ((r4 instanceof LinearLayoutManager) == false) goto L10;
        r3 = r4;
    L10:
        LinearLayoutManager r5 = (LinearLayoutManager) r3;     // Catch: Throwable -> L14
        if (r5 == null) goto L17;
        r5.scrollToPositionWithOffset(0, 0);     // Catch: Throwable -> L14
        return;
    L17:
        return;
    L5:
        r4 = null;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
