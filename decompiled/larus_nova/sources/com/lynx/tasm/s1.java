package com.lynx.tasm;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class s1 extends LynxViewClientV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<LynxViewClientV2> f383734a;

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void c() {
        Iterator<LynxViewClientV2> r100 = this.f383734a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().c();
        goto L4
    }

    public s1() {
        this.f383734a = new CopyOnWriteArrayList();
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void a(JSONObject r100) {
        Iterator<LynxViewClientV2> r101 = this.f383734a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }

    @Override // com.lynx.tasm.LynxViewClientV2, y7a.a
    public final void onPerformanceEvent(b8a.l r100) {
        Iterator<LynxViewClientV2> r101 = this.f383734a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPerformanceEvent(r100);
        goto L4
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void b(LynxView r100, LynxViewClientV2.LynxPipelineInfo r101) {
        Iterator<LynxViewClientV2> r102 = this.f383734a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().b(r100, r101);
        goto L4
    }
}
