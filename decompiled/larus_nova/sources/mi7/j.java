package mi7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f514103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f514104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k.a f514105d;

    @Override // java.lang.Runnable
    public final void run() {
        e.b(k.a("zlink", this.f514102a), k.b(this.f514103b, this.f514104c, this.f514105d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(String r100, String r101, JSONObject r102, k.a r103) {
        this.f514102a = r100;
        this.f514103b = r101;
        this.f514104c = r102;
        this.f514105d = r103;
    }
}
