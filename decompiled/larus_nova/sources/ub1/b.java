package ub1;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f549333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f549334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.uikit.dialog.a f549335c;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.uikit.dialog.a.a(this.f549335c.f102142w, this.f549333a, this.f549334b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.bytedance.android.live.uikit.dialog.a r100, View r101, View r102) {
        this.f549335c = r100;
        this.f549333a = r101;
        this.f549334b = r102;
    }
}
