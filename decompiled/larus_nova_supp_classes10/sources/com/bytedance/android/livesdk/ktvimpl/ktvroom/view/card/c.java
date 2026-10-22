package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ KtvRoomCardWidget a;

    public c(KtvRoomCardWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        sh6.b r6 = (sh6.b) r5;
        if (r6 == null) goto L16;
        Pair r7 = (Pair) sh6.c.b(r6);
        if (r7 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty((CharSequence) r7.getSecond()) == true) goto L17;
        KtvRoomCardWidget r0 = this.a;
        u r1 = m.e(r0);
        if (r1 == null) goto L13;
        String r2 = r1.w();
        if (r2 == null) goto L13;
    L14:
        r0.Aq(r2, false, (String) r7.getSecond(), (Integer) r7.getFirst());
        return;
    L13:
        r2 = "ktv_convenient";
        goto L14
    L17:
        return;
    }
}
