package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.HeadVideoController;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.HeadVideoAutoPlayController;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f {
    public final /* synthetic */ k a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean i() {
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void b() {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e.eh().a(false);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void c() {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e.eh().a(true);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void d() {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void f() {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean isPlaying() {
        HeadVideoController r0 = this.a.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final boolean j() {
        AnchorV4HeadV2VO r0 = this.a.i.K10();
        if (r0 == null) goto L5;
        Boolean r1 = r0.getEnableLego26();
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    public m(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void a(float r2) {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L8;
        BasePdpVideoView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.seek(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void e(boolean r2) {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e.w7().f(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void g(boolean r2) {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.e.w7().d(!r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void h(boolean r6) {
        HeadVideoController r0 = this.a.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() == false) goto L7;
        r0.e(false);
        Lazy r1 = HeadVideoAutoPlayController.a;
        HeadVideoAutoPlayController.f();
        r0.e.rR().e().d(false);
    L10:
        r0.e.w7().e(r6);
        r0.e.u1();
        return;
    L7:
        r0.g();
        b83.a r2 = r0.b();
        if (r2 == null) goto L10;
        b83.a.a(r2, true, false, 6);
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.f
    public final void k(boolean r4) {
        HeadVideoController r0 = this.a.c;
        if (r0 == null) goto L13;
        BasePdpVideoView r1 = r0.d;
        if (r1 == null) goto L7;
        r1.f(r4, true);
    L7:
        r0.e.w7().c(!r4);
        b83.a r2 = r0.b();
        if (r2 == null) goto L14;
        c63.c r3 = r2.c;
        if (r3 == null) goto L15;
        r3.K(r4);
        return;
    L15:
        return;
    L14:
        return;
    }
}
