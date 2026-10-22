package rm7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f538590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f538591b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f538591b.b(this.f538590a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(i r100, JSONObject r101) {
        this.f538591b = r100;
        this.f538590a = r101;
    }
}
