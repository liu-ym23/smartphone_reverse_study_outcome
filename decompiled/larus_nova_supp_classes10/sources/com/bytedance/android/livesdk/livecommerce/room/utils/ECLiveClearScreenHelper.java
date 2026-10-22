package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.i;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveClearScreenHelper {
    public static a a;

    public static final class a {
        public final int a;
        public final long b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof a) == false) goto L10;
            a r6 = (a) r5;
            if (this.a == r6.a) goto L8;
            return false;
        L8:
            if (this.b == r6.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "ClearScreenAction(state=" + this.a + ", timeStamp=" + this.b + ")";
        }

        public a(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(final int r5, final String r6, final String r7) {
        int r0 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.room.api.c r1 = RoomContextController.a.b(r6, r7).J();
        if (r1 == null) goto L5;
        r1.b(r5);
    L5:
        ECContext r2 = RoomContextController.a.b(r6, r7).r();
        if (r2 == null) goto L10;
        i<fk2.b> r3 = r2.getEcLiveRoomDurationMonitor();
        if (r3 == null) goto L10;
        final fk2.b r4 = (fk2.b) r3.getValue();
    L11:
        long r8 = SystemClock.elapsedRealtime();
        a r9 = new a(r5, r8);
        Function0<Unit> r10 = new ECLiveClearScreenHelper$onFullDialogHoverStateChanged$2(r6, r7, r5, r4);
        a r11 = a;
        if (r11 != null) goto L14;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == true) goto L24;
        r10.invoke();
    L24:
        a = r9;
        return;
    L14:
        if (r5 != r11.a) goto L21;
        long r13 = r8 - r11.b;
        if (0 > r13) goto L21;
        if (1000 < r13) goto L21;
        r12 = true;
    L10:
        r4 = null;
        goto L11
    }
}
