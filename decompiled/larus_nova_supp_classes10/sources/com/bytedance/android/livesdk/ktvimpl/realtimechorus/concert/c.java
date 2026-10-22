package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.h40;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c a;

    public static final class a {
    }

    public static final class b extends b7.a {
        public b() {
        }

        public final void onLoadSuccess(View r2) {
            ALogger.i("ConcertHybridManager", "loadLynxView success");
        }

        public final void onLoadFail(View r1, String r2, String r3) {
            ALogger.e("ConcertHybridManager", "loadLynxView onLoadFail");
        }
    }

    static {
    }

    public c() {
    }

    public final void b() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r0 = this.a;
        if (r0 == null) goto L5;
        r0.J();
    L5:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r1 = this.a;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    public final void a(fd2.b r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        String r0 = (String) h40.a.getValue();
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.a;
        String r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.b(r0, Long.valueOf(d5.c(r10.b)), r10.d, r10.f);
        u6 r3 = new u6("sslocal://webcast_lynxview?hybrid_type=lynx&url=");
        r3.b("url", r2);
        u6 r4 = r3.d("url");
        String r5 = "1";
        if (r10.e == false) goto L5;
        String r6 = "1";
    L6:
        r4.b("is_video_chorus", r6);
        r4.b("anchor_id", r10.c);
        r4.b("room_id", r10.b);
        if (r10.d == true) goto L10;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L10:
        r4.b("is_feed", r5);
        String r7 = r10.f;
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r4.b("enter_from", r7);
        int r8 = q.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r9 = q.b(r10.getContext(), r3.c(), new b(), 0, null, 56);
        this.a = r9;
        ih0.c.a.a(r9, null, null, 7);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r11 = this.a;
        if (r11 == null) goto L21;
        View r12 = r11.h;
        if (r12 == null) goto L22;
        r12.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r13 = r10.i;
        if (r13 == null) goto L23;
        r13.addView(r12);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void c(String r6, String r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 != null) goto L10;
        m r10 = o3.f().getRoom();
        if (r10 == null) goto L9;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L9;
        r6 = r11.getIdStr();
    L9:
        r6 = null;
    L10:
        if (r7 != null) goto L17;
        m r12 = o3.f().getRoom();
        if (r12 == null) goto L16;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L16;
        r7 = r13.getOwnerUserIdString();
    L16:
        r7 = null;
    L17:
        String r1 = gh0.a.c();
        String r2 = "";
        if (r6 != null) goto L20;
        String r3 = "";
    L21:
        r0.put("room_id", r3);
        if (r7 != null) goto L24;
        String r4 = "";
    L25:
        r0.put("anchor_id", r4);
        if (r1 == null) goto L29;
        r2 = r1;
    L29:
        r0.put("user_id", r2);
        if (r8 == false) goto L32;
        String r5 = "1";
    L33:
        r0.put("is_feed", r5);
        r0.put("enter_from", r9);
        ALogger.i("ConcertHybridManager", "更新GlobalProps, mHybridCard=" + this.a + ", roomId=" + r6 + ", anchorId=" + r7 + ", userId=" + r1 + ", is_feed=" + r8 + ", enterFrom=" + r9);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r14 = this.a;
        if (r14 == null) goto L37;
        r14.updateGlobalProps(r0);
        return;
    L37:
        return;
    L32:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L33
    L24:
        r4 = r7;
        goto L25
    L20:
        r3 = r6;
        goto L21
    }
}
