package w53;

import com.bytedance.android.shopping.anchorv3.comment.viewholder.CommentNodeVH;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentNodeVH f558319a;

    public b(CommentNodeVH r100) {
        this.f558319a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f558319a.f164563a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
