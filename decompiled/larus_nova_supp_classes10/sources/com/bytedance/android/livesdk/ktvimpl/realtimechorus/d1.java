package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d1 implements oe2.b {
    public String a;
    public final int b;
    public final int c;
    public com.bytedance.android.live.pushstream.d d;
    public final com.bytedance.android.livesdk.chatroom.widget.j1 e;

    public d1() {
        this(null);
    }

    @Override // oe2.b
    public final int b() {
        return -1;
    }

    @Override // oe2.b
    public final Boolean e() {
        return null;
    }

    @Override // oe2.b
    public final boolean j() {
        return false;
    }

    @Override // oe2.b
    public final boolean l() {
        return false;
    }

    @Override // oe2.b
    public final int d() {
        int r0 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        int r1 = ((Number) com.bytedance.android.livesdk.sharedpref.c.g.getValue()).intValue();
        if (r1 != 0) goto L6;
        return 2;
    L6:
        return r1;
    }

    @Override // oe2.b
    public final boolean m() {
        if (jc1.k.n(IInteractService.class).getCurrentScene() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // oe2.b
    public final String a() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L5;
        return "chorus_room_open";
    L5:
        return null;
    }

    @Override // oe2.b
    public final String c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L7;
        return null;
    L7:
        return this.a;
    }

    @Override // oe2.b
    public final com.bytedance.android.live.pushstream.d g() {
        return this.d;
    }

    @Override // oe2.b
    public final String getEnterFrom() {
        return this.a;
    }

    @Override // oe2.b
    public final int i() {
        return this.c;
    }

    @Override // oe2.b
    public final int k() {
        return this.b;
    }

    public d1(com.bytedance.android.livesdk.chatroom.widget.j1 r1) {
        this.e = r1;
        this.b = 1;
        this.c = 2;
    }

    @Override // oe2.b
    public final void f(boolean r2) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.g;
        if (r2 == false) goto L5;
        int r3 = 1;
    L6:
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // oe2.b
    public final <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        com.bytedance.android.livesdk.chatroom.widget.j1 r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getScopeServiceOrNullInMultiLinkRoom(r2);
    }

    @Override // oe2.b
    public final com.bytedance.android.live.pushstream.d h(boolean r1) {
        if (r1 == true) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r2 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.guestLiveStream();
    L9:
        return this.d;
    }
}
