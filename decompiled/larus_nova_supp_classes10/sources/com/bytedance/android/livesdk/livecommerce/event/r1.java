package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r1 extends ECEventV3 {
    public r1(String r2, String r3, int r4, long r5, long r7, boolean r9, boolean r10, boolean r11, boolean r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r13, "preloadTiming");
        super("livesdk_room_promotion_list_trace");
        f("room_id", r2);
        f("anchor_id", r3);
        d("list_showed_times", r4);
        if (r5 <= 0) goto L5;
        e("list_first_show_time", r5);
    L5:
        e("live_room_duration", r7);
        String r6 = "1";
        if (r9 == false) goto L8;
        String r8 = "1";
    L9:
        f("preload_list_data", r8);
        if (r10 == false) goto L12;
        String r15 = "1";
    L13:
        f("preload_list_layout", r15);
        if (r11 == false) goto L16;
        String r16 = "1";
    L17:
        f("first_show_hit_cache_data", r16);
        if (r12 == true) goto L21;
        r6 = BDLocationException.ERROR_TIMEOUT;
    L21:
        f("first_show_hit_cache_layout", r6);
        f("preload_timing", r13);
        if (r14 <= 0) goto L25;
        e("preload_time_after_entering_room", r14);
        return;
    L25:
        return;
    L16:
        r16 = BDLocationException.ERROR_TIMEOUT;
        goto L17
    L12:
        r15 = BDLocationException.ERROR_TIMEOUT;
        goto L13
    L8:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L9
    }
}
