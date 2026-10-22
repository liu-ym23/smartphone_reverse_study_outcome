package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BarrageBuyInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends a {
    public com.bytedance.android.livesdk.livecommerce.room.api.c e;

    public f() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        boolean r1 = false;
        if ((r9 instanceof si2.y) == true) goto L5;
        return false;
    L5:
        si2.y r10 = (si2.y) r9;
        if (r10.msgType != 0) goto L19;
        ECV2BarrageBuyInfo r11 = r10.barrageBuyInfo;
        if (r11 == null) goto L18;
        String r2 = r11.nickName;
        if (r2 != null) goto L12;
    L13:
        r1 = true;
    L14:
        if (r1 == true) goto L18;
        com.bytedance.android.livesdk.livecommerce.room.api.c r3 = this.e;
        if (r3 == null) goto L18;
        r3.jetDanmaku(r11.nickName, r11.purchaseCnt, r11.icon, r11.text);
        goto L18
    L12:
        if (StringsKt.isBlank(r2) == false) goto L14;
    L18:
        return true;
    L19:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = (com.bytedance.android.livesdk.livecommerce.room.api.c) b(com.bytedance.android.livesdk.livecommerce.room.api.c.class, null);
    }
}
