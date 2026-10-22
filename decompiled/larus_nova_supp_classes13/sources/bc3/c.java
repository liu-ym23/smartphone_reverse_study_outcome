package bc3;

import com.bytedance.android.shopping.commentfeed.view.CommentItemFragment;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVHNew;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements d {
    public final /* synthetic */ CommentVideoVHNew a;
    public final /* synthetic */ CommentItemFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CommentVideoVHNew r0 = this.a.a;     // Catch: Throwable -> L4
            int r1 = CommentVideoVHNew.o;     // Catch: Throwable -> L4
            r0.W3();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // bc3.d
    public final void onItemSelected(int r4) {
        if (this.b.s == false) goto L12;
        CommentVideoVHNew r0 = this.a;
        if (r4 == r0.l) goto L7;
        r0.d.x();
        r0.f.setVisibility(0);
        return;
    L7:
        if (r0.m == false) goto L9;
        r0.m = false;
        r0.d.post(new a(this));
        return;
    L9:
        r0.W3();
        return;
    }

    public c(CommentVideoVHNew r1, CommentItemFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
