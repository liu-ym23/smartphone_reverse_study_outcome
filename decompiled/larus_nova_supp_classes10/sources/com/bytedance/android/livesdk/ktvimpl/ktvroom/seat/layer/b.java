package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer;

import ag1.d;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.larus.apm.impl.protector.RunnableProtector;
import kk0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends ig0.b {

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a() {
            b r0 = this.a;
            hg0.a r1 = ((ig0.b) r0).h;
            View r2 = null;
            if (r1 == null) goto L5;
            View r3 = r1.Za(((ig0.b) r0).g, 2131389564);
        L6:
            ImageView r4 = (ImageView) r3;
            if (r4 == null) goto L9;
            this.a.t().setGuestAvatar(r4);
        L9:
            b r5 = this.a;
            hg0.a r6 = ((ig0.b) r5).h;
            if (r6 == null) goto L12;
            r2 = r6.Za(((ig0.b) r5).g, 2131389585);
        L12:
            TextView r7 = (TextView) r2;
            if (r7 == null) goto L16;
            this.a.t().setGuestName(r7);
            return;
        L16:
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void r() {
        SeatAnimationView r0 = t();
        if (r0 == null) goto L6;
        r0.post(new a(this));
        return;
    }

    public final void c(d6 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof d6.a) == false) goto L18;
        d6.a r4 = (d6.a) r3;
        wj0.b r0 = r4.a;
        if (r0 == null) goto L19;
        TalkRoomBaseDynamicEmoji r1 = r0.b;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isRandomEmoji == true) goto L11;
        return;
    L11:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 == null) goto L23;
        g r5 = r2.getLinkMicSeatCallback();
        if (r5 == null) goto L24;
        int r6 = d.a;
        r5.N0(d.a(r4.a));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L19:
        return;
    }

    public b(hg0.a r7, SeatAnimEngineWrapper r8, MicSeatScene r9) {
        Intrinsics.checkNotNullParameter(r7, "layerGetter");
        Intrinsics.checkNotNullParameter(r9, "scene");
        super(r7, 9, r8, r9, null);
    }
}
