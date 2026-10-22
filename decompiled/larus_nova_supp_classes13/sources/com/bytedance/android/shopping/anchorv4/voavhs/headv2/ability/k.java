package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.shopping.anchorv4.video.d {
    public final /* synthetic */ l i;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.f j;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f k;

    public final boolean b() {
        this.i.e.pausePlay();
        return true;
    }

    public final boolean e() {
        return this.i.e.isMute();
    }

    public final Object getPlayer() {
        return this.i.e.getPlayer();
    }

    public final boolean isPlaying() {
        return this.i.e.isPlaying();
    }

    public final boolean g(boolean r3) {
        this.i.e.f(r3, false);
        return true;
    }

    public final Boolean j(Boolean r3, boolean r4) {
        Boolean r5 = this.j.a(r3, r4, this.i.c);
        if (r5 != null) goto L5;
        Boolean r6 = this.i.c;
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r0) == false) goto L11;
        if (r3 != null) goto L11;
        return r0;
    L11:
        if (((com.bytedance.android.shopping.anchorv4.video.d) this).b == false) goto L14;
    L21:
        return null;
    L14:
        if (com.bytedance.android.ec.core.abtest.d.p() == false) goto L19;
        if (this.j.isFullScreen() == true) goto L21;
        return r0;
    L19:
        if (this.j.isExpanded() == true) goto L21;
        return r0;
    L5:
        return Boolean.valueOf(r5.booleanValue());
    }

    public final void n(boolean r1, boolean r2) {
        super.n(r1, r2);
        if (r2 == false) goto L6;
        this.j.b();
        return;
    }

    public k(l r8, y.b r9, com.bytedance.android.shopping.anchorv4.video.f r10, com.bytedance.android.shopping.anchorv4.video.f r11) {
        this.i = r8;
        this.j = r9;
        this.k = r10;
        super("head_video", r11, null, true, false, 44);
    }
}
