package xb5;

import com.bytedance.ee.bear.document.chatdraftdoc.h;
import com.bytedance.ee.bear.document.chatdraftdoc.i;
import com.bytedance.ee.bear.document.chatdraftdoc.l;
import com.bytedance.ee.bear.document.chatdraftdoc.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements d5b.c.a {
    @Override // d5b.c.a
    public final void a() {
    }

    @Override // d5b.c.a
    public final void onStart() {
    }

    @Override // d5b.c.a
    public final void onStop() {
    }

    @Override // d5b.c.a
    public final void onDestroy() {
        i r100 = h.f219209a;
        if (r100 == null) goto L5;
        r100.f219212a.clear();
    L5:
        h.f219209a = null;
        m r101 = h.f219210b;
        if (r101 == null) goto L8;
        r101.f219218a.clear();
    L8:
        h.f219210b = null;
        l r102 = h.f219211c;
        if (r102 == null) goto L11;
        r102.f219215a.clear();
    L11:
        h.f219211c = null;
        tt5.a.h("DocSendKBPlusItem", "ILifeCycleCallback onDestroy");
    }

    public c() {
    }
}
