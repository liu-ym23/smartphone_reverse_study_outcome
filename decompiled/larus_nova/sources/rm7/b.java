package rm7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f538574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f538575b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f538575b.k(this.f538574a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, JSONObject r101) {
        this.f538575b = r100;
        this.f538574a = r101;
    }
}
