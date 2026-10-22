package fo1;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f478078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveMode f478079b;

    public c(b r100, LiveMode r101) {
        this.f478078a = r100;
        this.f478079b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.f(this.f478078a, this.f478079b);     // Catch: Throwable -> L6
        ILinkServiceExternal r100 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.updateLiveMode(this.f478079b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
