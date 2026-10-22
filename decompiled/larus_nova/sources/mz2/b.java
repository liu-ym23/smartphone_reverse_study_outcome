package mz2;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f516471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f516472b;

    public b() {
        d.f516473a.getClass();
        this.f516472b = d.f516474b;
    }

    @Override // mz2.c, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        boolean r101 = true;
        int r102 = this.f516471a + 1;
        this.f516471a = r102;
        if (r102 > 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L18;
        a r104 = this.f516472b;
        r104.getClass();
        Iterator r105 = ((ArrayList) r104.f516468a).iterator();     // Catch: Throwable -> L16
    L9:
        if (r105.hasNext() == false) goto L18;
        f r106 = (f) r105.next();     // Catch: Throwable -> L16
        if (r100 == null) goto L14;
        r100.getApplicationContext();     // Catch: Throwable -> L16
    L14:
        r106.a();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    L18:
        a r107 = this.f516472b;
        if (this.f516471a <= 0) goto L22;
        r101 = false;
    L22:
        r107.f516470c = r101;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // mz2.c, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = this.f516471a - 1;
        this.f516471a = r101;
        boolean r102 = true;
        if (r101 > 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L18;
        a r104 = this.f516472b;
        r104.getClass();
        Iterator r105 = ((ArrayList) r104.f516469b).iterator();     // Catch: Throwable -> L16
    L9:
        if (r105.hasNext() == false) goto L18;
        e r106 = (e) r105.next();     // Catch: Throwable -> L16
        if (r100 == null) goto L14;
        r100.getApplicationContext();     // Catch: Throwable -> L16
    L14:
        r106.a();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    L18:
        a r107 = this.f516472b;
        if (this.f516471a <= 0) goto L22;
        r102 = false;
    L22:
        r107.f516470c = r102;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
