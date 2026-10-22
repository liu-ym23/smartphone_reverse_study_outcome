package com.lynx.clay.embedding.engine;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements FlutterEngine.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlutterEngine f380714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f380715b;

    @Override // com.lynx.clay.embedding.engine.FlutterEngine.a
    public final void b() {
    }

    @Override // com.lynx.clay.embedding.engine.FlutterEngine.a
    public final void a() {
        List<FlutterEngine> r100 = this.f380715b.f380717a;
        ArrayList r101 = (ArrayList) r100;
        r101.remove(this.f380714a);
    }

    public b(c r100, FlutterEngine r101) {
        this.f380715b = r100;
        this.f380714a = r101;
    }
}
