package com.larus.audio.call.plugins;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends com.larus.im.service.audio.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e<com.larus.audio.call.arch.c> f289458b;

    @Override // com.larus.im.service.audio.z0
    public final String g() {
        return this.f289457a;
    }

    public f(e<com.larus.audio.call.arch.c> r100) {
        this.f289458b = r100;
        this.f289457a = r100.f289448g;
    }

    @Override // com.larus.im.service.audio.z0
    public final void n(com.larus.im.service.audio.z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof pf9.z) == false) goto L5;
        this.f289458b.f289450i.b(false, "QueryBegin");
        this.f289458b.f289451j = true;
        return;
    L5:
        boolean r101 = r100 instanceof pf9.a0;
        if (r101 == false) goto L8;
    L29:
        e<com.larus.audio.call.arch.c> r102 = this.f289458b;
        r102.f289451j = true;
        if (r101 == false) goto L32;
        String r103 = "QueryEnd";
    L33:
        r102.f289450i.b(true, r103);
        this.f289458b.R1(r103);
        return;
    L32:
        r103 = "SceneSwitched";
        goto L33
    L8:
        if ((r100 instanceof pf9.i0) == true) goto L29;
        if ((r100 instanceof pf9.d0) == false) goto L16;
        this.f289458b.f289450i.b(true, "ReplyBegin");
        if (((Boolean) this.f289458b.f289449h.getValue()).booleanValue() == false) goto L36;
        this.f289458b.f289451j = true;
        return;
    L36:
        return;
    L16:
        if ((r100 instanceof pf9.f0) == false) goto L27;
        pf9.f0 r104 = (pf9.f0) r100;
        if (pf9.i.j(r104) == false) goto L38;
        e<com.larus.audio.call.arch.c> r105 = this.f289458b;
        if (r105.f289451j == false) goto L39;
        r105.f289451j = false;
        pf9.m r106 = r104.f528909c;
        if (r106 == null) goto L24;
        Map<String, String> r107 = r106.f528940a;
    L25:
        r105.j3(new com.larus.audio.call.play.h.c(r107));
        return;
    L24:
        r107 = null;
        goto L25
    L39:
        return;
    L38:
        return;
    L27:
        if ((r100 instanceof pf9.e0) == false) goto L41;
        this.f289458b.j3(com.larus.audio.call.play.h.b.f289335a);
        this.f289458b.f289451j = true;
        return;
    }
}
