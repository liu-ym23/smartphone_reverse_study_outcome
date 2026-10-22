package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements e6 {
    public final /* synthetic */ SeatAnimationView a;
    public final /* synthetic */ KtvRoomSeatManager b;

    public final void c(d6 r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof d6.c) == false) goto L14;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.b.b() == false) goto L14;
        wj0.b r0 = ((d6.c) r5).a;
        if (r0 == null) goto L14;
        TalkRoomBaseDynamicEmoji r1 = r0.b;
        if (r1 == null) goto L14;
        if (r1.isThanksInteractEmoji() != true) goto L14;
        SeatAnimationView r2 = this.a;
        int r3 = s1.f(52.0f);
        int r4 = s1.f(52.0f);
        SeatAnimationView.f(r2.e, r3, r4);
    L14:
        if ((r5 instanceof d6.a) == false) goto L34;
        d6.a r6 = (d6.a) r5;
        wj0.b r7 = r6.a;
        if (r7 == null) goto L35;
        TalkRoomBaseDynamicEmoji r8 = r7.b;
        if (r8 != null) goto L20;
        return;
    L20:
        if (r8.isRandomEmoji != true) goto L37;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.b.b() == false) goto L30;
        wj0.b r9 = r6.a;
        if (r9 == null) goto L30;
        TalkRoomBaseDynamicEmoji r10 = r9.b;
        if (r10 == null) goto L30;
        if (r10.isThanksInteractEmoji() != true) goto L30;
        SeatAnimationView r11 = this.a;
        int r12 = s1.f(44.0f);
        int r13 = s1.f(44.0f);
        SeatAnimationView.f(r11.e, r12, r13);
    L30:
        DataCenter r14 = this.b.r.a();
        if (r14 == null) goto L38;
        int r15 = ag1.d.a;
        r14.put("cmd_show_dynamic_emoji_in_comment", ag1.d.a(r6.a));
        return;
    L38:
        return;
    L37:
        return;
    L35:
        return;
    }

    public b(SeatAnimationView r1, KtvRoomSeatManager r2) {
        this.a = r1;
        this.b = r2;
    }
}
