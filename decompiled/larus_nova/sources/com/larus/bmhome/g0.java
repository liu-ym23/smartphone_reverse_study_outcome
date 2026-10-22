package com.larus.bmhome;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 implements nr8.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f311764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nr8.b f311765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n3 f311766c;

    @Override // nr8.s
    public final void a() {
        FLogger.f375446a.i("NotificationControlManager", "ondismiss");
        AppHost.f326268a.a().f(this.f311764a);
        i0.b(i0.f311775a, this.f311765b, 2);
        Function0<Unit> r100 = this.f311766c.f486722t;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public g0(h0 r100, nr8.b r101, n3 r102) {
        this.f311764a = r100;
        this.f311765b = r101;
        this.f311766c = r102;
    }
}
