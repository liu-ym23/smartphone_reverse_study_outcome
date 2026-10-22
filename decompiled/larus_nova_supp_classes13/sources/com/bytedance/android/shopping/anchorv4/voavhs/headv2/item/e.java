package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.HeadVideoAutoPlayController;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f {
    public final /* synthetic */ j a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean i() {
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void b() {
        this.a.j.eh().a(false);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void c() {
        this.a.j.eh().a(true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean isPlaying() {
        PlayerBlock r0 = this.a.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean j() {
        AnchorV4HeadV2VO r0 = this.a.j.K10();
        if (r0 == null) goto L5;
        Boolean r1 = r0.getEnableLego26();
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    public e(j r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void a(float r3) {
        PlayerBlock r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.J(r3 * 100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void e(boolean r2) {
        this.a.j.w7().f(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void g(boolean r2) {
        this.a.j.w7().d(!r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void h(boolean r6) {
        PlayerBlock r0 = this.a.e;
        if (r0 != null) goto L5;
    L13:
        PlayerBlock r1 = this.a.e;
        if (r1 == null) goto L16;
        r1.j();
    L16:
        PlayerBlock r2 = this.a.e;
        if (r2 == null) goto L19;
        PlayerBlock.z(r2, true, false, null, 6);
    L19:
        this.a.j.w7().e(r6);
        this.a.j.u1();
        return;
    L5:
        if (r0.isPlaying() != true) goto L13;
        PlayerBlock r3 = this.a.e;
        if (r3 == null) goto L9;
        r3.E();
    L9:
        PlayerBlock r4 = this.a.e;
        if (r4 == null) goto L12;
        r4.x();
    L12:
        Lazy r5 = HeadVideoAutoPlayController.a;
        HeadVideoAutoPlayController.f();
        this.a.j.rR().e().d(false);
        goto L19
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void k(boolean r4) {
        PlayerBlock r0 = this.a.e;
        if (r0 == null) goto L5;
        PlayerBlock.o(r0, true, 2);
    L5:
        this.a.j.w7().c(!r4);
    }
}
