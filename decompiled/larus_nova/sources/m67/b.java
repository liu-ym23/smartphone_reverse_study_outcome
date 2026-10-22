package m67;

import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f512297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f512298b;

    public final void a() {
        ArrayList r100 = new ArrayList();
        r100.add(this.f512297a);
        Iterator r101 = ((ArrayList) this.f512298b.f512290b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ProcessEnum r102 = (ProcessEnum) r101.next();
        CrossProcessHelper.getInstance().callMethod(r102, "onAppStatusChanged", r100);
        goto L4
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

    public b(a r100, String r101) {
        this.f512298b = r100;
        this.f512297a = r101;
    }
}
