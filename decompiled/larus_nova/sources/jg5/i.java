package jg5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f499006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f499007b;

    public final void a() {
        a r100 = j.f499009c;
        String r101 = this.f499006a;
        int r102 = this.f499007b;
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L19;
        Iterator r103 = ((ConcurrentHashMap) r100.f498998a).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L20;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r101.equals(r104.getValue()) == false) goto L9;
        ((com.bytedance.ee.bear.middleground_permission_export.model.g) r104.getKey()).notifyMemberNumber(r102);
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

    public i(String r100, int r101) {
        this.f499006a = r100;
        this.f499007b = r101;
    }
}
