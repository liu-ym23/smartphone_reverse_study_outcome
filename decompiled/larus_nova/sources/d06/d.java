package d06;

import com.larus.apm.impl.protector.RunnableProtector;
import gz5.w;
import hz5.k;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f466209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f466210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f466211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f466212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ w f466213e;

    public d(String r100, long r101, String r102, String r103, w r104) {
        this.f466209a = r100;
        this.f466210b = r101;
        this.f466211c = r102;
        this.f466212d = r103;
        this.f466213e = r104;
    }

    public final void a() {
        k.d("Helios-Common-Env", "generateSampleRateResults deviceId=" + this.f466209a + " hashCode=" + this.f466210b + " date=" + this.f466211c + " originalDate=" + this.f466212d);
        StringBuilder r100 = new StringBuilder("generateSampleRateResults\n");
        r100.append(e06.c.c(this.f466213e));
        k.d("Helios-Common-Env", r100.toString());
        k.d("Helios-Common-Env", "generateSampleRateResults\n" + e.f466215b + '\n' + e.f466216c + '\n' + e.f466217d);
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
}
