package zp3;

import com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListItemHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import wp3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentListItemHolder f573183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.C8144b f573184b;

    public a(CommentListItemHolder r100, b.C8144b r101) {
        this.f573183a = r100;
        this.f573184b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentListItemHolder r100 = this.f573183a;     // Catch: Throwable -> L4
        b.C8144b r101 = this.f573184b;     // Catch: Throwable -> L4
        int r102 = CommentListItemHolder.f189061e;     // Catch: Throwable -> L4
        r100.T3(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
