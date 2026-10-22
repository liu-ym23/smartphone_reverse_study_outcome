package l84;

import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f507924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocationException f507925b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f507924a.onError(this.f507925b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(l0 r100, BDLocationException r101) {
        this.f507924a = r100;
        this.f507925b = r101;
    }
}
