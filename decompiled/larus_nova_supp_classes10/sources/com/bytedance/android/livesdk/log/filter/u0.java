package com.bytedance.android.livesdk.log.filter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u0 implements v {
    public static boolean a;
    public static long b;

    public static final class a {
    }

    public u0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        a = true;
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        int r0 = r5.hashCode();
        if (r0 == (-1284480695)) goto L11;
        if (r0 == (-773966155)) goto L8;
        return;
    L8:
        if (r5.equals("livesdk_live_leave") == false) goto L16;
        r6.put("duration_session", String.valueOf(System.currentTimeMillis() - b));
        a = true;
        b = 0;
        return;
    L16:
        return;
    L11:
        if (r5.equals("livesdk_room_enter_success") == true) goto L13;
        return;
    L13:
        if (a == false) goto L19;
        b = System.currentTimeMillis();
        a = false;
        return;
    }
}
