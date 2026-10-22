package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.shopping.anchorv4.video.d {
    public final boolean i;
    public final /* synthetic */ MoreVideoComponent j;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f k;

    public final boolean e() {
        return true;
    }

    public final boolean b() {
        MoreVideoComponent.b r0 = MoreVideoComponent.i2(this.j);
        if (r0 == null) goto L9;
        x73.a r1 = r0.c;
        if (r1 == null) goto L10;
        r1.pausePlay();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public final boolean c() {
        MoreVideoComponent.b r0 = MoreVideoComponent.i2(this.j);
        if (r0 == null) goto L9;
        x73.a r1 = r0.c;
        if (r1 == null) goto L10;
        r1.startPlay();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public final Object getPlayer() {
        MoreVideoComponent.b r0 = MoreVideoComponent.i2(this.j);
        if (r0 == null) goto L7;
        x73.a r1 = r0.c;
        if (r1 == null) goto L7;
        return r1.getPlayer();
    L7:
        return null;
    }

    public final boolean isPlaying() {
        MoreVideoComponent.b r0 = MoreVideoComponent.i2(this.j);
        if (r0 == null) goto L9;
        x73.a r1 = r0.c;
        if (r1 == null) goto L9;
        if (r1.isPlaying() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean m() {
        return this.i;
    }

    public g(MoreVideoComponent r8, com.bytedance.android.shopping.anchorv4.video.f r9, com.bytedance.android.shopping.anchorv4.video.f r10) {
        this.j = r8;
        this.k = r9;
        super("more_video", r10, null, false, false, 60);
        this.i = true;
    }
}
