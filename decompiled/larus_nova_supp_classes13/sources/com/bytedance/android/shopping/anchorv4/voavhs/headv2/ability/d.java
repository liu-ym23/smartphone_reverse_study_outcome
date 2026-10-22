package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b {
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b a;
    public final PlayerBlock b;
    public final l c;
    public final boolean d;
    public final boolean e;

    @Override // ee3.c
    public final void onTransitionBegin(int r1) {
    }

    @Override // ee3.c
    public final void onTransitionChanged(int r1, float r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final Integer a() {
        PlayerBlock r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf((int) ((r0.getPlayProgress() / 100.0f) * r0.s()));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final x73.c getSharePlayer() {
        if (this.e == false) goto L11;
        l r0 = this.c;
        if (r0 == null) goto L17;
        x73.a r1 = r0.e;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getSharePlayer();
    L17:
        return null;
    L11:
        if (this.d == true) goto L13;
        return null;
    L13:
        PlayerBlock r2 = this.b;
        if (r2 != null) goto L16;
        return null;
    L16:
        return r2.getSharePlayer();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getPlayInfo() {
        return this.a;
    }

    @Override // ee3.c
    public final PlayerBlock getPlayer() {
        return this.b;
    }

    public d(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1, PlayerBlock r2, l r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
