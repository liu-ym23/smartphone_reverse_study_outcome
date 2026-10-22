package com.bytedance.dataplatform;

import android.app.Application;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f204335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f204337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f204338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f204339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t f204340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v f204341g;

    public final void a() {
        o.f204343b = new i(this.f204335a, this.f204336b, this.f204337c, this.f204338d, this.f204339e, this.f204340f, o.f204352k, o.f204353l);
        o.f204342a = this.f204341g;
        v r100 = o.f204342a;
        p.a r101 = p.f204357a;
        if (r101 == null) goto L6;
        r101.init();
    L6:
        o.f204348g = true;
        if (o.f204349h == null) goto L10;
        o.f204343b.e(o.f204349h);
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

    public n(Application r100, String r101, u r102, s r103, t r104, v r105) {
        this.f204335a = r100;
        this.f204336b = r101;
        this.f204337c = true;
        this.f204338d = r102;
        this.f204339e = r103;
        this.f204340f = r104;
        this.f204341g = r105;
    }
}
