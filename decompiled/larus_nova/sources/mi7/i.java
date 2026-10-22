package mi7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f514098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f514099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f514100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k.a f514101e;

    @Override // java.lang.Runnable
    public final void run() {
        e.c(k.a(this.f514097a, this.f514098b), k.b(this.f514099c, this.f514100d, this.f514101e));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(String r100, String r101, JSONObject r102, k.a r103) {
        this.f514097a = "zlink";
        this.f514098b = r100;
        this.f514099c = r101;
        this.f514100d = r102;
        this.f514101e = r103;
    }
}
