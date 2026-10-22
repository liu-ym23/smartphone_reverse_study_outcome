package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import fg7.f;
import fg7.g;
import hg7.k;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fg7.e f270425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<Handler> f270426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f270427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rotation f270428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cg7.a f270429e;

    @Override // com.bytedance.sync.v2.net.NetTrace.a
    public final int e() {
        return 1;
    }

    @Override // fg7.f
    public final void c() {
        Rotation r100 = this.f270428d;
        if (r100 != null) goto L5;
    L6:
        Rotation r101 = this.f270428d;
        if (r101 == null) goto L9;
        r101.a();
    L9:
        Rotation.b r102 = new Rotation.b();
        r102.f270402a = this.f270429e.c();
        r102.f270403b = this.f270429e.c();
        b r103 = new b("[Compensator] ", this.f270425a, this.f270427c, this.f270426b, r102);
        this.f270428d = r103;
        r103.f(true);
        return;
    L5:
        if (r100.c() == 1) goto L6;
    }

    @Override // fg7.f
    public final void destroy() {
        zf7.b.a("[Compensator] WsConnectedCompensator destroy");
        Rotation r100 = this.f270428d;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // fg7.f
    public final void a(cg7.a r100) {
        this.f270429e = r100;
        Rotation.b r101 = new Rotation.b();
        if (this.f270428d.c() != 1) goto L5;
        r101.f270402a = r100.d();
        r101.f270403b = r100.d();
    L6:
        this.f270428d.f270399e = r101;
        return;
    L5:
        r101.f270402a = r100.c();
        r101.f270403b = r100.c();
        goto L6
    }

    @Override // fg7.f
    public final void b(BsyncProtocol r100) {
        Rotation r101 = this.f270428d;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // fg7.f
    public final void d(cg7.a r100, boolean r101) {
        zf7.b.a("[Compensator] WsConnectedCompensator start readyToPoll = " + r101);
        this.f270429e = r100;
        Rotation.b r102 = new Rotation.b();
        if (r101 == false) goto L5;
        r102.f270402a = r100.c();
        r102.f270403b = r100.c();
        this.f270428d = new b("[Compensator] ", this.f270425a, this.f270427c, this.f270426b, r102);
    L6:
        this.f270428d.f(true);
        return;
    L5:
        r102.f270402a = r100.d();
        r102.f270403b = r100.d();
        this.f270428d = new d("[Compensator] ", this.f270425a, this.f270427c, this.f270426b, r102);
        goto L6
    }

    public e(fg7.e r100, g r101, k r102) {
        this.f270425a = r100;
        this.f270426b = r101;
        this.f270427c = r102;
    }
}
