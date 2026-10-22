package com.vivo.push.restructure.a.a;

import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class j implements i<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f462459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f462460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f462461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f462462d;

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.restructure.a.a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.e() == true) goto L8;
        t.a("core is not support monitor report");
        return;
    L8:
        t.a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + r100.f());
        if (r100.f() == false) goto L19;
        n r101 = this.f462460b;
        if (r101 == null) goto L13;
        r101.a(r100, this.f462459a);
    L13:
        k r102 = this.f462461c;
        if (r102 == null) goto L17;
        r102.a(r100, this.f462459a.c().toString());
        t.a("reportNodeMonitorInfo() , report client NodeInfo！！！");
        return;
    L17:
        t.a("onNodeError , mReporter is null， can not report");
        return;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* bridge */ /* synthetic */ void a(com.vivo.push.restructure.a.a r100) {
        com.vivo.push.restructure.a.a r101 = r100;
        if (r101 != null) goto L7;
        t.a("onAllNodeExecuteComplete, receivedMsg is null");
        return;
    L7:
        if (this.f462459a != null) goto L10;
        t.a("onAllNodeExecuteComplete, mFirstNode is null");
        return;
    L10:
        a2(r101);
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final void a(g r100) {
        this.f462459a = r100;
    }

    public j(n r100, k r101, com.vivo.push.restructure.c.a r102) {
        this.f462460b = r100;
        this.f462461c = r101;
        this.f462462d = r102;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(a r100, com.vivo.push.restructure.a.a r101, int r102) {
        com.vivo.push.restructure.a.a r103 = r101;
        if (r103 != null) goto L6;
        t.a("onNodeError() receivedMsg is null ");
        return;
    L6:
        t.a("onNodeError() , msgID = " + r103.a() + ", nodeName = " + r100.b());
        com.vivo.push.restructure.c.a r104 = this.f462462d;
        if (r104 == null) goto L9;
        r104.a(r102, r103.a());
    L9:
        a2(r103);
    }
}
