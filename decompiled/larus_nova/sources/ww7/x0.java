package ww7;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f561723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y0.a f561724b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f561724b.b(HonorPushErrorEnum.fromCode(this.f561723a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public x0(y0.a r100, int r101) {
        this.f561724b = r100;
        this.f561723a = r101;
    }
}
