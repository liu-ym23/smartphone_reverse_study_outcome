package h5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f483889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.lynx.clay.embedding.engine.plugins.audio.a f483890b;

    @Override // java.lang.Runnable
    public final void run() {
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.f483890b, this.f483889a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.lynx.clay.embedding.engine.plugins.audio.a r100, String r101) {
        this.f483890b = r100;
        this.f483889a = r101;
    }
}
