package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUserInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public static final void a(String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "uid");
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L38;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L42;
        List r3 = KotlinTypeUtilsKt.castElementType(r2.a());
        if (r3 != null) goto L10;
        return;
    L10:
        if ((!r3.isEmpty()) == false) goto L40;
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L43;
        LinkPlayerInfo r5 = (LinkPlayerInfo) r4.next();
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L13;
        if (Intrinsics.areEqual(r19, r6.getIdString()) == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L41;
        r0.accept(r6);
        TalkRoomLogUtils r7 = TalkRoomLogUtils.B;
        String r8 = r6.getIdString();
        if (r20 == false) goto L23;
        String r9 = "anchor";
    L24:
        String r10 = r9;
        List r11 = r5.songList;
        WaitingListUserInfo r12 = r5.waitingListUserInfo;
        if (r12 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        TalkRoomLogUtils.s0(r7, r8, r10, r11, "up_link", r13, null, null, null, null, r6.isSubscriber(), Long.valueOf(com.bytedance.android.live.liveinteract.plantform.model.n.b(r5)), null, 2528);
        return;
    L27:
        if (TextUtils.isEmpty(r12.applyReason) == true) goto L29;
        r13 = true;
        goto L30
    L23:
        r9 = "administrator";
        goto L24
    L41:
        return;
    L43:
        return;
    L40:
        return;
    L42:
        return;
    }
}
