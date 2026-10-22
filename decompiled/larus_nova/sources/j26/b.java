package j26;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC6383a f497017a;

    public b(a.InterfaceC6383a r100) {
        this.f497017a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f497017a.getSchema();     // Catch: Throwable -> L9
        String r101 = this.f497017a.getBid();     // Catch: Throwable -> L9
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        a0.f247513a.d(r102, null, r101);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L6:
        if (r103 != null) goto L12;
        a0.e(r102, null, 6);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r103 = null;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
