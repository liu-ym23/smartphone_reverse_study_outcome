package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ContentDurationLogger {
    public long a;
    public long b;
    public boolean c;
    public final DataCenter d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, this.d, 0, 2);
        if (r1 != null) goto L5;
    L25:
        ALogger.i("ContentDurationLogger", "Report content duration failed for non-vs room.");
        return;
    L5:
        if (r1.isVSRoom() != true) goto L25;
        if (this.c == false) goto L12;
        ALogger.i("ContentDurationLogger", "Report content duration failed for duplicate reporting.");
        return;
    L12:
        if (this.a > 0) goto L14;
    L23:
        ALogger.i("ContentDurationLogger", "Report content duration failed for invalid startTime: " + this.a + " or contentId: " + this.b + '.');
        return;
    L14:
        if (this.b <= 0) goto L23;
        long r6 = System.currentTimeMillis();
        final long r8 = r6 - this.a;
        ALogger.i("ContentDurationLogger", "Start reporting content duration for contentId " + this.b + " with duration " + r8 + " ms");
        RoomContext r2 = RoomContext.a.c(r0, null, 0, 3);
        if (r2 == null) goto L21;
        com.bytedance.live.datacontext.j r3 = r2.getLoggerHelper();
        if (r3 == null) goto L21;
        r3.c(new ContentDurationLogger$reportDuration$1(this, r8));
    L21:
        this.a = r6;
        this.c = true;
    }

    public ContentDurationLogger(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
    }

    public final void b(long r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.d, 0, 2);
        if (r0 != null) goto L5;
    L14:
        ALogger.i("ContentDurationLogger", "Start recording content duration failed for non-vs room.");
        return;
    L5:
        if (r0.isVSRoom() != true) goto L14;
        ALogger.i("ContentDurationLogger", "Start recording content duration for contentId " + r6);
        if (r6 > 0) goto L10;
    L12:
        this.c = false;
        this.a = System.currentTimeMillis();
        return;
    L10:
        if (r6 == this.b) goto L12;
        this.b = r6;
        goto L12
    }
}
