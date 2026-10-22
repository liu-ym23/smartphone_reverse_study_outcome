package l84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f508036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocation f508037b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f508036a.onLocationChanged(this.f508037b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(l0 r100, BDLocation r101) {
        this.f508036a = r100;
        this.f508037b = r101;
    }
}
