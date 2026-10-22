package fu3;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f478886a;

    @Override // java.lang.Runnable
    public final void run() {
        jt3.a.b("apm_frequency_monitor", this.f478886a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(JSONObject r100) {
        this.f478886a = r100;
    }
}
