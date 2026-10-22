package gh5;

import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((SpaceEditText) this.a.b.findViewById(2131386085)).requestFocus();     // Catch: Throwable -> L4
        rcb.c.h(this.a.b.findViewById(2131386085), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
