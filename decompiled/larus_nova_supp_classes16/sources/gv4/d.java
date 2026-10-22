package gv4;

import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class d implements a {
    public m a;

    public d() {
    }

    @Override // gv4.a
    public void a(Action r2) {
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        m r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final a update(m r1) {
        this.a = r1;
        return this;
    }
}
