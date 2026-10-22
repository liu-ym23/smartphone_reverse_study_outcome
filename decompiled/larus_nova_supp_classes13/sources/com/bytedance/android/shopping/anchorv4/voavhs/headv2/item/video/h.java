package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import com.bytedance.android.ec.host.api.player.HeaderCtrLynxPendant;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final fj.f a(n r6) {
        JsonObject r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        HeaderPendantLynx r2 = r6.b();
        if (r2 == null) goto L8;
        String r3 = r2.getLynxId();
    L9:
        String r4 = "";
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        HeaderPendantLynx r5 = r6.b();
        if (r5 == null) goto L15;
        String r7 = r5.getLynxUrl();
    L16:
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        HeaderPendantLynx r8 = r6.b();
        if (r8 == null) goto L21;
        JsonObject r9 = r8.getLynxData();
    L22:
        HeaderCtrLynxPendant r1 = new HeaderCtrLynxPendant(r3, r7, r9);
        HeaderPendantLynx r10 = r6.a();
        if (r10 == null) goto L25;
        String r11 = r10.getLynxId();
    L26:
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        HeaderPendantLynx r12 = r6.a();
        if (r12 == null) goto L31;
        String r13 = r12.getLynxUrl();
    L32:
        if (r13 == null) goto L35;
        r4 = r13;
    L35:
        HeaderPendantLynx r14 = r6.a();
        if (r14 == null) goto L39;
        r0 = r14.getLynxData();
    L39:
        return new fj.f(r1, new HeaderCtrLynxPendant(r11, r4, r0));
    L31:
        r13 = null;
        goto L32
    L25:
        r11 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    }
}
