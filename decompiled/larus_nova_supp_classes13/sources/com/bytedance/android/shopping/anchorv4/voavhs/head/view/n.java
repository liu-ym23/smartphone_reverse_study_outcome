package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f {
    public final /* synthetic */ AnchorV4VideoView a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean j() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void b() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.a.D;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        AnchorV4CommentVideoEntryLayout r1 = this.a.u;
        if (r1 != null) goto L8;
    L9:
        AnchorV4CommentVideoEntryLayout r2 = this.a.u;
        if (r2 == null) goto L14;
        ViewExtensionsKt.i(r2);
        return;
    L14:
        return;
    L8:
        if (r1.getVisibility() != 8) goto L9;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void c() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.a.D;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        AnchorV4CommentVideoEntryLayout r1 = this.a.u;
        if (r1 != null) goto L8;
    L9:
        AnchorV4CommentVideoEntryLayout r2 = this.a.u;
        if (r2 == null) goto L14;
        ViewExtensionsKt.c(r2, false, 3);
        return;
    L14:
        return;
    L8:
        if (r1.getVisibility() != 8) goto L9;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean isPlaying() {
        PlayerBlock r0 = this.a.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() != true) goto L7;
        return true;
    }

    public n(AnchorV4VideoView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void a(float r3) {
        PlayerBlock r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.J(r3 * 100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void e(boolean r4) {
        AnchorV4VideoView r0 = this.a;
        c63.d r1 = r0.j;
        if (r1 == null) goto L10;
        boolean r5 = !r4;
        String r2 = AnchorV4VideoView.h(r0);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r3 = this.a.e;
        if (r3 == null) goto L7;
        String r6 = r3.j();
    L8:
        r1.D(r5, r2, r6);
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void g(boolean r4) {
        AnchorV4VideoView r0 = this.a;
        c63.d r1 = r0.j;
        if (r1 == null) goto L10;
        boolean r5 = !r4;
        String r2 = AnchorV4VideoView.h(r0);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r3 = this.a.e;
        if (r3 == null) goto L7;
        String r6 = r3.j();
    L8:
        r1.r(r5, r2, r6);
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void h(boolean r4) {
        PlayerBlock r0 = this.a.d;
        if (r0 != null) goto L5;
    L9:
        PlayerBlock r1 = this.a.d;
        if (r1 == null) goto L12;
        r1.j();
    L12:
        AnchorV4VideoView r2 = this.a;
        c63.d r3 = r2.j;
        if (r3 == null) goto L20;
        String r5 = AnchorV4VideoView.h(r2);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r6 = this.a.e;
        if (r6 == null) goto L17;
        String r7 = r6.j();
    L18:
        r3.g(r4, r5, r7);
        return;
    L17:
        r7 = null;
        goto L18
    L20:
        return;
    L5:
        if (r0.isPlaying() != true) goto L9;
        PlayerBlock r8 = this.a.d;
        if (r8 == null) goto L12;
        r8.E();
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void k(boolean r4) {
        PlayerBlock r0 = this.a.d;
        if (r0 == null) goto L5;
        PlayerBlock.o(r0, true, 2);
    L5:
        AnchorV4VideoView r1 = this.a;
        c63.d r2 = r1.j;
        if (r2 == null) goto L13;
        boolean r5 = !r4;
        String r3 = AnchorV4VideoView.h(r1);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r6 = this.a.e;
        if (r6 == null) goto L10;
        String r7 = r6.j();
    L11:
        r2.I(r5, r3, r7);
        return;
    L10:
        r7 = null;
        goto L11
    }
}
