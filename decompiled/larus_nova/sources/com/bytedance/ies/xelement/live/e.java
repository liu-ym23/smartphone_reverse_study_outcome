package com.bytedance.ies.xelement.live;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLiveLight f250128a;

    @Override // com.bytedance.ies.xelement.live.b
    public final void onRelease() {
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void onFirstFrame() {
        LynxLiveLight r100 = this.f250128a;
        int r101 = LynxLiveLight.f250107h;
        r100.O("firstframe", null);
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void onPlay() {
        LynxLiveLight r100 = this.f250128a;
        int r101 = LynxLiveLight.f250107h;
        r100.O("play", null);
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void onPrepared() {
        LynxLiveLight r100 = this.f250128a;
        int r101 = LynxLiveLight.f250107h;
        r100.O("prepared", null);
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void onStop() {
        LynxLiveLight r100 = this.f250128a;
        int r101 = LynxLiveLight.f250107h;
        r100.O("stop", null);
    }

    public e(LynxLiveLight r100) {
        this.f250128a = r100;
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f250128a.O("error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg", r100)}));
    }

    @Override // com.bytedance.ies.xelement.live.b
    public final void onSeiUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        this.f250128a.O("sei", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sei", r100)}));
    }
}
