package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import fg7.f;
import hg7.k;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fg7.e f270404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<Handler> f270405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f270406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f270407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Rotation f270408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cg7.a f270409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f270410g;

    @Override // fg7.f
    public final void c() {
        Rotation r100 = this.f270408e;
        if (r100 != null) goto L5;
    L6:
        Rotation r101 = this.f270408e;
        if (r101 == null) goto L9;
        r101.a();
    L9:
        Rotation.b r102 = new Rotation.b();
        r102.f270402a = this.f270409f.h();
        r102.f270403b = this.f270409f.c();
        b r103 = new b("[Compensator] ", this.f270404a, this.f270406c, this.f270405b, r102);
        this.f270408e = r103;
        r103.f(true);
        return;
    L5:
        if (r100.c() == 1) goto L6;
    }

    @Override // fg7.f
    public final void destroy() {
        zf7.b.a("[Compensator] HttpsCompensator destroy");
        Rotation r100 = this.f270408e;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.sync.v2.net.NetTrace.a
    public final int e() {
        if (this.f270404a.isForeground() == false) goto L5;
        return 3;
    L5:
        return 4;
    }

    @Override // fg7.f
    public final void a(cg7.a r100) {
        this.f270409f = r100;
        Rotation.b r101 = new Rotation.b();
        if (this.f270408e.c() != 1) goto L5;
        r101.f270402a = r100.m();
        r101.f270403b = r100.d();
    L6:
        this.f270408e.f270399e = r101;
        return;
    L5:
        r101.f270402a = r100.h();
        r101.f270403b = r100.c();
        goto L6
    }

    @Override // fg7.f
    public final void b(BsyncProtocol r100) {
        Rotation r101 = this.f270408e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f270410g == false) goto L9;
        r101.g(r100);
        return;
    }

    @Override // fg7.f
    public final void d(cg7.a r100, boolean r101) {
        zf7.b.a("[Compensator] HttpsCompensator start readyToPoll = " + r101);
        this.f270409f = r100;
        Rotation.b r102 = new Rotation.b();
        if (r101 == false) goto L5;
        r102.f270402a = r100.h();
        r102.f270403b = r100.c();
        this.f270408e = new b("[Compensator] ", this.f270404a, this.f270406c, this.f270405b, r102);
    L6:
        this.f270408e.f(this.f270407d);
        return;
    L5:
        r102.f270402a = r100.m();
        r102.f270403b = r100.d();
        this.f270408e = new d("[Compensator] ", this.f270404a, this.f270406c, this.f270405b, r102);
        goto L6
    }

    public a(fg7.e r100, n<Handler> r101, k r102, boolean r103, boolean r104) {
        this.f270404a = r100;
        this.f270405b = r101;
        this.f270406c = r102;
        this.f270407d = r103;
        this.f270410g = r104;
    }
}
