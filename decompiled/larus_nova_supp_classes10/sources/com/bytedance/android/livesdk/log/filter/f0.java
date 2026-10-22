package com.bytedance.android.livesdk.log.filter;

import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 extends a<am2.s> {
    public f0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r4, Object r5) {
        am2.s r6 = (am2.s) r5;
        super.u(r4, r6);
        if (r6 == null) goto L32;
        String r0 = r6.b;
        String r2 = null;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        if (r4 == null) goto L11;
        String r1 = (String) r4.put("action_type", r0);
    L11:
        String r3 = r6.a;
        if ((!StringsKt.isBlank(r3)) == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L18;
        if (r4 == null) goto L18;
        String r7 = (String) r4.put("game_tab", r3);
    L18:
        String r8 = r6.c;
        if ((!StringsKt.isBlank(r8)) == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L25;
        if (r4 == null) goto L25;
        String r9 = (String) r4.put("first_game_live_tab", r8);
    L25:
        String r10 = r6.d;
        if ((!StringsKt.isBlank(r10)) == false) goto L28;
        r2 = r10;
    L28:
        if (r2 == null) goto L33;
        if (r4 == null) goto L34;
        String r11 = (String) r4.put("second_game_live_tab", r2);
        return;
    L34:
        return;
    L33:
        return;
    }
}
