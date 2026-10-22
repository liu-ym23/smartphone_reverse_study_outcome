package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.SystemClock;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public long a;
    public long b;

    public k() {
    }

    public final void c() {
        this.a = SystemClock.elapsedRealtime();
    }

    public final void b(n64.c r16, String r17) {
        long r1 = SystemClock.elapsedRealtime() - this.a;
        Long r5 = 0L;
        if (r1 <= 0) goto L5;
        this.b += r1;
    L5:
        this.a = SystemClock.elapsedRealtime();
        if (this.b > 0) goto L8;
        return;
    L8:
        AosEventReporter r2 = AosEventReporter.a;
        if (r16 == null) goto L14;
        String r6 = r5.toString();
        if (r6 == null) goto L14;
        String r8 = r6;
    L15:
        if (r17 != null) goto L17;
        String r9 = "";
    L18:
        if (r16 == null) goto L23;
        String r7 = r5.toString();
        if (r7 == null) goto L23;
        String r10 = r7;
    L24:
        if (r16 == null) goto L29;
        String r11 = r5.toString();
        if (r11 == null) goto L29;
        String r12 = r11;
    L30:
        long r13 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter("draw_video_WITHIN_tt_video_immerse", "enterFromMerge");
        Intrinsics.checkNotNullParameter("live_cell", "enterMethod");
        Intrinsics.checkNotNullParameter(PinchEnterMethod.CLICK, "actionType");
        Intrinsics.checkNotNullParameter("", "anchorId");
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "requestId");
        Intrinsics.checkNotNullParameter(r10, "anchorAid");
        Intrinsics.checkNotNullParameter(r12, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        d14.a r3 = b14.a.a;
        b14.a.a(t24.a.class).A0(r8, r9, r10, r12, r13, null);
        this.b = 0;
        return;
    L29:
        r12 = "";
    L23:
        r10 = "";
        goto L24
    L17:
        r9 = r17;
    L14:
        r8 = "";
        goto L15
    }

    public static void a(String r12, n64.c r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "sceneId");
        AosEventReporter r1 = AosEventReporter.a;
        Long r0 = 0L;
        if (r13 == null) goto L6;
        String r8 = r0.toString();
        if (r8 == null) goto L6;
    L7:
        if (r14 != null) goto L9;
        String r9 = "";
    L10:
        if (r13 == null) goto L15;
        String r15 = r0.toString();
        if (r15 == null) goto L15;
        String r10 = r15;
    L16:
        if (r13 == null) goto L21;
        String r16 = r0.toString();
        if (r16 == null) goto L21;
        String r11 = r16;
    L22:
        AosEventReporter.H(r1, "draw_video_WITHIN_tt_video_immerse", "live_cell", r12, "live_cell", "draw", "", r8, r9, r10, r11);
        return;
    L21:
        r11 = "";
    L15:
        r10 = "";
        goto L16
    L9:
        r9 = r14;
    L6:
        r8 = "";
        goto L7
    }
}
