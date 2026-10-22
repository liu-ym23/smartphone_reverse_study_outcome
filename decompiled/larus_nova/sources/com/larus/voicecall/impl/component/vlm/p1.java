package com.larus.voicecall.impl.component.vlm;

import com.larus.voicecall.impl.video.VideoPreviewState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class p1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealtimeVideoComponent f377982a;

    public /* synthetic */ p1(RealtimeVideoComponent r100) {
        this.f377982a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final RealtimeVideoComponent r100 = this.f377982a;
        if (r100.G == true) goto L14;
        if (r100.B3().f484245m == false) goto L7;
        r100.q4("onVideoServiceAvailable", new s1(r100), r100.f377811k0);
    L7:
        com.larus.voicecall.impl.plugins.o1 r101 = r100.E3().z();
        if (r101 == null) goto L11;
        r101.l();
    L11:
        if (r100.N.f379614c.getValue() != VideoPreviewState.full) goto L14;
        r100.v4(Intrinsics.areEqual(r100.N.f379613b.getValue(), Boolean.TRUE), "video_service_available", 0);
    L14:
        return Unit.INSTANCE;
    }
}
