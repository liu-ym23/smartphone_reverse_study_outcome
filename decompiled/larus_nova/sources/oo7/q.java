package oo7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f524634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f524635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f524636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f524637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r.a f524638e;

    @Override // java.lang.Runnable
    public final void run() {
        k.e(r.a(this.f524634a, this.f524635b), r.b(this.f524636c, this.f524637d, this.f524638e));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(String r100, String r101, JSONObject r102, r.a r103) {
        this.f524634a = "share";
        this.f524635b = r100;
        this.f524636c = r101;
        this.f524637d = r102;
        this.f524638e = r103;
    }
}
