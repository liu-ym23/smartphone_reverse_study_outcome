package wqa;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f560770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f560771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f560772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f560773d;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.sdk.account.monitor.c.h(this.f560770a, this.f560771b, this.f560772c, ((HashMap) this.f560773d.f560774a).size());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(h r100, Set r101, boolean r102, boolean r103) {
        this.f560773d = r100;
        this.f560770a = r101;
        this.f560771b = r102;
        this.f560772c = r103;
    }
}
