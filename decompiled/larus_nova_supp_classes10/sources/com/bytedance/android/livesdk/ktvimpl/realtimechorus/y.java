package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements com.bytedance.android.livesdk.chatroom.widget.j1 {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public final bn0.b getMultiLinkRoomScope() {
        com.bytedance.android.livesdk.chatroom.widget.j1 r0 = this.a.P2;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkRoomScope();
    }

    public y(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final <T extends dn0.b> T getScopeServiceInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceType");
        com.bytedance.android.livesdk.chatroom.widget.j1 r0 = this.a.P2;
        Intrinsics.checkNotNull(r0);
        return (T) r0.getScopeServiceInMultiLinkRoom(r2);
    }

    public final <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceType");
        com.bytedance.android.livesdk.chatroom.widget.j1 r0 = this.a.P2;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getScopeServiceOrNullInMultiLinkRoom(r2);
    }
}
