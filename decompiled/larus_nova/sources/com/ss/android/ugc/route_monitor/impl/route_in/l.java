package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f454535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f454536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Intent f454537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f454538e;

    public l(i r100, Activity r101, boolean r102, Intent r103, String r104) {
        this.f454534a = r100;
        this.f454535b = r101;
        this.f454536c = r102;
        this.f454537d = r103;
        this.f454538e = r104;
    }

    public final void a() {
        String r100 = this.f454534a.d(this.f454535b);
        boolean r101 = false;
        if (this.f454536c == false) goto L18;
        Activity r102 = this.f454535b;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.f454537d != null) goto L9;
        return;
    L9:
        if (r102.getIntent() != null) goto L11;
        return;
    L11:
        if (r100.length() != 0) goto L13;
        r101 = true;
    L13:
        if (r101 == false) goto L15;
    L16:
        this.f454534a.g(this.f454538e, this.f454535b);
    L17:
        i.b(this.f454534a, r100, true, this.f454535b, this.f454536c);
        return;
    L15:
        if (t.b(r100) != null) goto L17;
    L18:
        Activity r103 = this.f454535b;
        if (r103 == null) goto L26;
        i.b(this.f454534a, r100, true, r103, false);
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
