package gv4;

import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class e implements a {
    public a a;

    public e() {
    }

    public abstract boolean b(Action r1);

    public e(a r1) {
        this.a = r1;
    }

    @Override // gv4.a
    public final void a(Action r2) {
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        if (b(r2) == true) goto L8;
        a r0 = this.a;
        if (r0 == null) goto L9;
        r0.a(r2);
        return;
    L9:
        return;
    }
}
