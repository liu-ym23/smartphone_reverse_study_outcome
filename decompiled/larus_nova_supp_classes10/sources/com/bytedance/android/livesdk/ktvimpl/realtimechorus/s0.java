package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public s0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        sh6.b r6 = (sh6.b) r5;
        if (r6 == null) goto L14;
        Pair r7 = (Pair) sh6.c.b(r6);
        if (r7 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty((CharSequence) r7.getSecond()) == true) goto L15;
        RealTimeChorusMainViewWidget r0 = this.a;
        String r1 = o3.e(r0).w();
        if (r1 != null) goto L12;
        r1 = "ktv_convenient";
    L12:
        r0.br(r1, false, (String) r7.getSecond(), (Integer) r7.getFirst());
        return;
    L15:
        return;
    }
}
