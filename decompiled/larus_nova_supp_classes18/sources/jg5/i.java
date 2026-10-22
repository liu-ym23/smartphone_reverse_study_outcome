package jg5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public final void a() {
        a r0 = j.c;
        String r1 = this.a;
        int r2 = this.b;
        r0.getClass();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isEmpty() == true) goto L19;
        Iterator r3 = ((ConcurrentHashMap) r0.a).entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (r1.equals(r4.getValue()) == false) goto L9;
        ((com.bytedance.ee.bear.middleground_permission_export.model.g) r4.getKey()).notifyMemberNumber(r2);
        goto L9
    L20:
        return;
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

    public i(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
