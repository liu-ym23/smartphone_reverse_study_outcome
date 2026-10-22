package bc3;

import android.view.View;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVHNew;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ CommentVideoVHNew a;

    public b(CommentVideoVHNew r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.SeekBar, com.bytedance.android.shopping.commentfeed.widget.VideoPlaySeekBar] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a.g;     // Catch: Throwable -> L9
        Object r1 = r0.getParent();     // Catch: Throwable -> L9
        if ((r1 instanceof View) == true) goto L5;
        r1 = null;
    L5:
        View r2 = (View) r1;     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        r2.setOnTouchListener(new com.bytedance.android.shopping.commentfeed.widget.c(r0));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
