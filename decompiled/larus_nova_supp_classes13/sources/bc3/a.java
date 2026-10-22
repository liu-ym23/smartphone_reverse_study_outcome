package bc3;

import android.view.ViewGroup;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentImageVH;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVH;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ ViewGroup.LayoutParams a;
    public final /* synthetic */ CommentImageVH b;

    public a(ViewGroup.LayoutParams r1, CommentImageVH r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r0 = this.a;     // Catch: Throwable -> L4
        r0.height = this.b.b.getHeight() - CommentVideoVH.d;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
