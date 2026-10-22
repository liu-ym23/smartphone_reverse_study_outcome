package yu7;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzd;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f569250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f569251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzd f569252c;

    public d(zzd r100, LifecycleCallback r101) {
        this.f569252c = r100;
        this.f569250a = r101;
        this.f569251b = "TaskOnStopCallback";
    }

    public final void a() {
        zzd r100 = this.f569252c;
        if (r100.f274482e <= 0) goto L9;
        LifecycleCallback r101 = this.f569250a;
        Bundle r102 = r100.f274483f;
        if (r102 == null) goto L7;
        r102.getBundle(this.f569251b);
    L7:
        r101.getClass();
    L9:
        if (this.f569252c.f274482e < 2) goto L12;
        this.f569250a.getClass();
    L12:
        if (this.f569252c.f274482e < 3) goto L15;
        this.f569250a.getClass();
    L15:
        if (this.f569252c.f274482e < 4) goto L18;
        this.f569250a.a();
    L18:
        if (this.f569252c.f274482e < 5) goto L21;
        this.f569250a.getClass();
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
