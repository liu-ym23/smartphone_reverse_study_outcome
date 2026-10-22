package yu7;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f569247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f569248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzb f569249c;

    public c(zzb r100, LifecycleCallback r101) {
        this.f569249c = r100;
        this.f569247a = r101;
        this.f569248b = "TaskOnStopCallback";
    }

    public final void a() {
        zzb r100 = this.f569249c;
        if (r100.f274478b <= 0) goto L9;
        LifecycleCallback r101 = this.f569247a;
        Bundle r102 = r100.f274479c;
        if (r102 == null) goto L7;
        r102.getBundle(this.f569248b);
    L7:
        r101.getClass();
    L9:
        if (this.f569249c.f274478b < 2) goto L12;
        this.f569247a.getClass();
    L12:
        if (this.f569249c.f274478b < 3) goto L15;
        this.f569247a.getClass();
    L15:
        if (this.f569249c.f274478b < 4) goto L18;
        this.f569247a.a();
    L18:
        if (this.f569249c.f274478b < 5) goto L21;
        this.f569247a.getClass();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
