package hb1;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f484462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f484463b;

    public b(Activity r100, TokenCert r101) {
        this.f484462a = r100;
        this.f484463b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (Intrinsics.areEqual("SO-04J", Build.MODEL) == false) goto L9;
        this.f484462a.recreate();     // Catch: Throwable -> L6
        return;
    }
}
