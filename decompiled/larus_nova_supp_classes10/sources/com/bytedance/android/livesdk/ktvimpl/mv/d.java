package com.bytedance.android.livesdk.ktvimpl.mv;

import android.text.TextUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.message.model.MvVideoType;
import com.bytedance.android.livesdk.message.model.ag;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.od;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvMvModel a;
    public final /* synthetic */ y b;
    public final /* synthetic */ Function3 c;

    public d(KtvMvModel r1, y r2, Function3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r12) {
        com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
        this.a.h.remove(this.b);
        com.bytedance.android.live.ktv.common.model.api.a r0 = (com.bytedance.android.live.ktv.common.model.api.a) ((ExtraResponse) r13).data;
        Integer r1 = this.b.f;
        if (r1 != null) goto L6;
    L18:
        fd r2 = r0.b();
        fd r3 = r0.b();
        if (r3 == null) goto L21;
        String r4 = r3.d();
    L22:
        if (r4 == null) goto L50;
        if (r2 == null) goto L50;
        List r5 = r2.c();
        if (r5 == null) goto L35;
        Iterator<T> r6 = r5.iterator();
    L29:
        if (r6.hasNext() == false) goto L33;
        T r7 = r6.next();
        if ((!TextUtils.isEmpty((String) r7)) == false) goto L29;
    L34:
        String r8 = r7;
    L36:
        String r9 = r2.a();
        List r10 = r2.b();
        int r11 = r2.e();
        String r14 = r9;
        List r15 = r10;
        String r16 = r4;
        String r17 = r8;
    L37:
        if (r16 != null) goto L41;
        com.bytedance.android.live.ktv.common.util.g.e("vId is null, " + ((ExtraResponse) r13).logId);
        Function3<? super String, ? super Long, ? super String, Unit> r18 = this.a.f;
        if (r18 == null) goto L58;
        Unit r19 = (Unit) r18.invoke(r16, Long.valueOf(this.b.b), this.b.d);
        return;
    L58:
        return;
    L41:
        y r20 = this.b;
        l r110 = new l(r20, r16, r14, r15, r20.f, r11, "singer");
        String r21 = this.b.c;
        r110.c = r17;
        this.a.g(r110, false);
        Function3 r22 = this.c;
        if (r22 == null) goto L44;
        Unit r23 = (Unit) r22.invoke(r110, 0, null);
    L44:
        ArrayList<Function3<l, Integer, String, Unit>> r24 = this.b.a;
        if (r24 == null) goto L60;
        Iterator<T> r25 = r24.iterator();
    L48:
        if (r25.hasNext() == false) goto L62;
        ((Function3) r25.next()).invoke(r110, 0, null);
        goto L48
    L62:
        return;
    L60:
        return;
    L33:
        r7 = (T) null;
        goto L34
    L35:
        r8 = null;
    L50:
        com.bytedance.android.live.ktv.common.util.g.e("vId/videoInfo is null, " + ((ExtraResponse) r13).logId);
        Function3<? super String, ? super Long, ? super String, Unit> r111 = this.a.f;
        if (r111 == null) goto L61;
        Unit r112 = (Unit) r111.invoke(r4, Long.valueOf(this.b.b), this.b.d);
        return;
    L61:
        return;
    L21:
        r4 = null;
        goto L22
    L6:
        if (r1.intValue() != 2) goto L18;
        od r26 = r0.a();
        if (r26 == null) goto L12;
        ag r27 = r26.a();
        if (r27 == null) goto L12;
        String r28 = r27.d();
    L13:
        od r29 = r0.a();
        if (r29 == null) goto L16;
        r17 = r29.d();
    L17:
        r16 = r28;
        r14 = null;
        r15 = null;
        r11 = MvVideoType.VIDEO_TYPE_NORMAL_MATERIAL.getValue();
        goto L37
    L16:
        r17 = null;
    L12:
        r28 = null;
        goto L13
    }
}
