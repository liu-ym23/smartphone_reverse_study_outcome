package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderScrollController.Binding f210425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f210426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f210427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderScrollController f210428d;

    public h(OfficeBaseMainHeaderScrollController.Binding r100, View r101, boolean r102, OfficeBaseMainHeaderScrollController r103) {
        this.f210425a = r100;
        this.f210426b = r101;
        this.f210427c = r102;
        this.f210428d = r103;
    }

    public final void a() {
        this.f210425a.f210348g.remove(this.f210426b);
        boolean r100 = false;
        if (this.f210427c == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        OfficeBaseMainHeaderScrollController.Binding r102 = this.f210425a;
        r102.f210361t = r101;
        if (r101 == false) goto L12;
        r102.f210360s = true;
    L12:
        ReleaseDirection r103 = r102.f210353l;
        OfficeBaseMainHeaderScrollController r104 = this.f210428d;
        String r105 = "Web scrollStop type:" + this.f210425a.f210342a + " direction:" + r103 + " gestureActive:" + this.f210425a.f210357p + " isTopArg:" + this.f210427c + " top:" + r101 + " touchMoved:" + this.f210425a.f210356o + " pendingTopReached:" + this.f210425a.f210360s;
        int r106 = OfficeBaseMainHeaderScrollController.f210317y;
        r104.getClass();
        OfficeBaseMainHeaderScrollController.j(r105);
        if (r103 == null) goto L26;
        OfficeBaseMainHeaderScrollController.Binding r107 = this.f210425a;
        if (r107.f210357p == false) goto L22;
        r107.f210358q = r103;
        if (this.f210427c == false) goto L19;
    L20:
        r100 = true;
    L21:
        r107.f210359r = r100;
        return;
    L19:
        if (this.f210426b.canScrollVertically(-1) == true) goto L21;
    L22:
        if (r101 == false) goto L24;
        OfficeBaseMainHeaderScrollController.a(this.f210428d, r107.f210342a);
    L25:
        this.f210425a.b();
        return;
    L24:
        this.f210428d.e(r103, r107.f210342a, false);
        goto L25
    L26:
        if (r101 == false) goto L34;
        OfficeBaseMainHeaderScrollController.Binding r108 = this.f210425a;
        if (r108.f210357p == false) goto L30;
        r108.f210360s = true;
        return;
    L30:
        OfficeBaseMainHeaderScrollController.a(this.f210428d, r108.f210342a);
        this.f210425a.b();
        return;
    L34:
        return;
    L5:
        if (this.f210426b.canScrollVertically(-1) == false) goto L8;
        r101 = false;
        goto L9
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
