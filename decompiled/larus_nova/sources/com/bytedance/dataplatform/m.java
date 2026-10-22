package com.bytedance.dataplatform;

import android.app.Application;
import com.bytedance.android.ecom.live.adapter.impl.ECSdkAbInitializer;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f204328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f204330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u f204331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f204332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t f204333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v f204334g;

    public final void a() {
        o.f204343b = new i(this.f204328a, this.f204329b, this.f204330c, this.f204331d, this.f204332e, this.f204333f, o.f204352k, o.f204353l);
        o.f204342a = this.f204334g;
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

    public m(Application r100, ECSdkAbInitializer.a r101) {
        ECSdkAbInitializer.b r102 = ECSdkAbInitializer.b.f51172a;
        ECSdkAbInitializer.c r103 = ECSdkAbInitializer.c.f51173a;
        this.f204328a = r100;
        this.f204329b = "https://abtest-ch.snssdk.com/common";
        this.f204330c = true;
        this.f204331d = r101;
        this.f204332e = r102;
        this.f204333f = r103;
        this.f204334g = null;
    }
}
