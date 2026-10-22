package xb5;

import com.bytedance.ee.bear.document.chatdraftdoc.h;
import com.bytedance.ee.bear.document.chatdraftdoc.i;
import com.bytedance.ee.bear.document.chatdraftdoc.l;
import com.bytedance.ee.bear.document.chatdraftdoc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements d5b.c.a {
    public final void a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void onDestroy() {
        i r0 = h.a;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        h.a = null;
        m r1 = h.b;
        if (r1 == null) goto L8;
        r1.a.clear();
    L8:
        h.b = null;
        l r2 = h.c;
        if (r2 == null) goto L11;
        r2.a.clear();
    L11:
        h.c = null;
        tt5.a.h("DocSendKBPlusItem", "ILifeCycleCallback onDestroy");
    }

    public c() {
    }
}
