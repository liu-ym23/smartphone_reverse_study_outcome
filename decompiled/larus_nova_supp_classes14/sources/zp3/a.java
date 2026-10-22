package zp3;

import com.bytedance.android.window.shop.innerflow.holder.element.commentlist.CommentListItemHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import wp3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ CommentListItemHolder a;
    public final /* synthetic */ b.C0182b b;

    public a(CommentListItemHolder r1, b.C0182b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentListItemHolder r0 = this.a;     // Catch: Throwable -> L4
        b.C0182b r1 = this.b;     // Catch: Throwable -> L4
        int r2 = CommentListItemHolder.e;     // Catch: Throwable -> L4
        r0.T3(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
