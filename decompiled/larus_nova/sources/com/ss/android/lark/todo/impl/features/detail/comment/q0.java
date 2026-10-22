package com.ss.android.lark.todo.impl.features.detail.comment;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentTitleSection f442977a;

    public q0(CommentTitleSection r100) {
        this.f442977a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentTitleSection r100 = this.f442977a;     // Catch: Throwable -> L4
        lt7.d.a r101 = new lt7.d.a(r100.f442891b.findViewById(R.id.commentSkeletonFl));     // Catch: Throwable -> L4
        r101.f510707b = R.layout.todo_detail_comment_skeleton;     // Catch: Throwable -> L4
        r101.f510708c = true;     // Catch: Throwable -> L4
        r101.f510711f = 20;     // Catch: Throwable -> L4
        r101.f510710e = 1000;     // Catch: Throwable -> L4
        r100.f442894e = r101.b();     // Catch: Throwable -> L4
        this.f442977a.f442893d = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
