package cc3;

import android.text.method.ScrollingMovementMethod;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryExpandableTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ CommentGalleryExpandableTextView a;

    public a(CommentGalleryExpandableTextView r1) {
        this.a = r1;
    }

    public final void a() {
        CommentGalleryExpandableTextView r0 = this.a;
        if (r0.a.getHeight() < r0.h) goto L5;
        r0.a.setVerticalScrollBarEnabled(true);
        r0.a.setMovementMethod(ScrollingMovementMethod.getInstance());
        r0.a.setText(r0.j + "\n");
        return;
    L5:
        r0.a.setVerticalScrollBarEnabled(false);
        r0.a.setMovementMethod(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
