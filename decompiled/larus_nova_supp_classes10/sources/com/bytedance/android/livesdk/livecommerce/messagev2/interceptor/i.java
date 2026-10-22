package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends a {
    public boolean e;

    public i() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        si2.b0 r1 = null;
        if ((r6 instanceof si2.b0) == true) goto L5;
        r6 = null;
    L5:
        si2.b0 r7 = (si2.b0) r6;
        if (r7 != null) goto L8;
    L22:
        return false;
    L8:
        if (r7.msgType == 2) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        r1 = r7;
    L15:
        if (r1 == null) goto L22;
        Context r8 = getContext();
        if (r8 == null) goto L21;
        ECV2PopupInfo r0 = r1.flashPopupInfo;
        if (r0 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a(r8, r0);
    L21:
        return true;
    L10:
        if (this.e == false) goto L12;
        r2 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = r2;
    }
}
