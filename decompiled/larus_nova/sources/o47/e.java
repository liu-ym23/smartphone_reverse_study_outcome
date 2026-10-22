package o47;

import android.net.Uri;
import com.bytedance.pia.core.utils.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f521974a;

    public e(Uri r100) {
        this.f521974a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Uri r100 = this.f521974a;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        String r101 = j.g(r100, null);     // Catch: Throwable -> L10
        if (r101 == null) goto L17;
        f.n(r101);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
