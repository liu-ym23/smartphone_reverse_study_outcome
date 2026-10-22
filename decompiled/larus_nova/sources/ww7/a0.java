package ww7;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f561637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f561638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f561639c;

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.f561639c.f561645b == false) goto L5;
        this.f561637a.run();     // Catch: Throwable -> L9
    L14:
        return;
    L5:
        a r100 = this.f561638b;     // Catch: Throwable -> L9
        if (r100 == null) goto L14;
        HonorPushErrorEnum r101 = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;     // Catch: Throwable -> L9
        r100.onFailure(r101.getErrorCode(), r101.getMessage());     // Catch: Throwable -> L9
        goto L14
    }

    public a0(c0 r100, Runnable r101, a r102) {
        this.f561639c = r100;
        this.f561637a = r101;
        this.f561638b = r102;
    }
}
