package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements sb0.c {
    public List<LinkPlayerInfo> a;
    public final IRoom b;

    public final List<LinkPlayerInfo> getOnlineUserList() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L7;
        List<ILinkPlayerInfoBridge> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L7;
        List r2 = CollectionsKt.toMutableList(r1);
    L8:
        List<LinkPlayerInfo> r3 = KotlinTypeUtilsKt.castMutableElementType(r2);
        this.a = r3;
        return r3;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean isAudienceLinkEngineOn() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    public d(IRoom r1) {
        this.b = r1;
    }
}
