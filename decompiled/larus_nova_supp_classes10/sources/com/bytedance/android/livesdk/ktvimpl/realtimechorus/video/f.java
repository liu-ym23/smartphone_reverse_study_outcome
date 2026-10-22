package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements ti6.j {
    public fi6.a a;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ boolean b(aj6.d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public f() {
    }

    public final String a(int r15, int r16, List<ti6.f> r17) {
        Intrinsics.checkNotNullParameter(r17, "mixRegions");
        if (r17.isEmpty() == false) goto L6;
        return "";
    L6:
        ti6.f r1 = new ti6.f();
        Iterator<ti6.f> r2 = r17.iterator();
    L7:
        List r4 = null;
        if (r2.hasNext() == false) goto L17;
        ti6.f r3 = r2.next();
        if (r3 == null) goto L12;
        String r5 = r3.b;
    L13:
        if (r5 == null) goto L7;
        if (Intrinsics.areEqual(r3.b, null) == false) goto L7;
        r1.b(r3.v);
        r1.a(r3.b);
        r1.d(LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN);
        r1.m = true;
        r1.a = Integer.valueOf(r3.a).intValue();
        r1.c(r3.c);
        r1.u = Double.valueOf(r3.u).doubleValue();
        r1.s = Integer.valueOf(r3.s).intValue();
        r1.i = Integer.valueOf(r3.i).intValue();
        r3.d(LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_3RD);
        r3.b(null);
        goto L7
    L12:
        r5 = null;
        goto L13
    L17:
        String r6 = r1.b;
        Map r7 = MapsKt.emptyMap();
        fi6.a r8 = this.a;
        long r9 = tc0.c.h().getChannelId();
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r11 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r12 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r13 = r12.t();
        if (r13 == null) goto L26;
        ClientUIInfo r14 = r13.e;
        if (r14 == null) goto L26;
        r4 = r14.getUiFeatureList();
    L26:
        String r0 = LiveSeiCreator.b(r17, null, r8, r7, r9, 63, false, 0, -1, r4, 8).toString();
        b.b("VideoChorusStreamMixer", "mixStream appData " + r0);
        return r0;
    }
}
