package ko7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.manager.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f504530a;

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = com.bytedance.ug.sdk.share.impl.manager.a.C3811a.f272314a.a(this.f504530a, false);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == true) goto L5;
        c.b.f504529a.c(r100, 3);     // Catch: Throwable -> L8
    L6:
        j.c.f272350a.getClass();     // Catch: Throwable -> L8
        return;
    L5:
        eo7.a.b.f473353a.h();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public d(String r100) {
        this.f504530a = r100;
    }
}
