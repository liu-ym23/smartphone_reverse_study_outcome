package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public u1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        u22.b r6 = (u22.b) r5;
        Intrinsics.checkNotNullParameter(r6, "event");
        KtvRoomGuestWidget r0 = this.a;
        int r1 = KtvRoomGuestWidget.G2;
        r0.getClass();
        Iterator r2 = r6.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) r2.next();
        int r4 = u22.b.c;
        if (Intrinsics.areEqual("30000001", r3) == false) goto L4;
        if (((MultiLinkVoiceBaseGuestLinkWidget) r0).I == null) goto L14;
        com.bytedance.android.live.liveinteract.voicechat.util.k.F(r0.getMRoom().getOwnerUserIdString(), r6.b);
        return;
    L14:
        return;
    }
}
