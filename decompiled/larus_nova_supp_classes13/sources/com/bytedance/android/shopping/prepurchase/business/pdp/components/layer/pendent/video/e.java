package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.shopping.anchorv4.video.d {
    public final /* synthetic */ a i;

    public final boolean e() {
        return this.i.g.b;
    }

    public final Object getPlayer() {
        gj.b r0 = this.i.g.e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayer();
    }

    public final boolean isPlaying() {
        return this.i.c();
    }

    public final boolean b() {
        if (isPlaying() == false) goto L7;
        this.i.pause();
        return true;
    L7:
        return true;
    }

    public final boolean c() {
        if (isPlaying() == true) goto L7;
        this.i.d();
        return true;
    L7:
        return true;
    }

    public final boolean g(boolean r3) {
        c r0 = this.i.g;
        if (r0.b == r3) goto L7;
        r0.c(false);
        return true;
    L7:
        return true;
    }

    public final Boolean j(Boolean r2, boolean r3) {
        a r4 = this.i;
        if (r4.j.c.c != null) goto L5;
        return null;
    L5:
        if (((com.bytedance.android.shopping.anchorv4.video.d) this).b == false) goto L8;
        return null;
    L8:
        return Boolean.valueOf(r4.g.b);
    }

    public e(a r8, com.bytedance.android.shopping.anchorv4.video.f r9, Boolean r10) {
        this.i = r8;
        super("float_video", r9, r10, true, false, 40);
    }
}
