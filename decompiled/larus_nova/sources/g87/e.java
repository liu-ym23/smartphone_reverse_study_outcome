package g87;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f480432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f480433b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f480433b.d(this.f480432a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(d r100) {
        this.f480433b = r100;
        this.f480432a = false;
    }
}
