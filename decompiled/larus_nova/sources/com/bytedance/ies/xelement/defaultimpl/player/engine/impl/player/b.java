package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import o76.c;
import o76.j;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f249899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MusicPlayerImpl f249900b;

    public b(j r100, MusicPlayerImpl r101) {
        this.f249899a = r100;
        this.f249900b = r101;
    }

    @Override // o76.j
    public final void a(long r100, boolean r101) {
        j r102 = this.f249899a;
        if (r102 == null) goto L5;
        r102.a(r100, r101);
    L5:
        c r103 = this.f249900b.f249889b;
        if (r101 == false) goto L8;
        SeekState r104 = SeekState.SEEK_SUCCESS;
    L9:
        r103.q(r104);
        return;
    L8:
        r104 = SeekState.SEEK_FAILED;
        goto L9
    }
}
