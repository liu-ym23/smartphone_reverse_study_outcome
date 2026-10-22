package com.bytedance.android.livesdk.ktvimpl.mv;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.message.model.fd;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ KtvMvModel a;
    public final /* synthetic */ Function1 b;

    public f(KtvMvModel r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r15) {
        com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
        com.bytedance.android.live.ktv.common.model.api.b r0 = (com.bytedance.android.live.ktv.common.model.api.b) ((ExtraResponse) r16).data;
        fd r1 = r0.a();
        fd r2 = r0.a();
        String r3 = null;
        if (r2 == null) goto L5;
        String r5 = r2.d();
    L6:
        if (r5 == null) goto L21;
        if (r1 == null) goto L21;
        l r17 = new l(new y(-1, null, "", null, null, 24), r5, r1.a(), r1.b(), r1.e());
        List r4 = r1.c();
        if (r4 == null) goto L18;
        Iterator<T> r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        T r7 = r6.next();
        if ((!TextUtils.isEmpty((String) r7)) == false) goto L13;
        r3 = r7;
    L17:
        r3 = r3;
    L18:
        r17.c = r3;
        Function1 r8 = this.b;
        if (r8 == null) goto L28;
        Unit r18 = (Unit) r8.invoke(r17);
        return;
    L28:
        return;
    L21:
        ALogger.e("KtvMvModel", "vId/videoInfo is null, " + ((ExtraResponse) r16).logId);
        Function3<? super String, ? super Long, ? super String, Unit> r19 = this.a.f;
        if (r19 == null) goto L30;
        Unit r110 = (Unit) r19.invoke(r5, null, null);
        return;
    L30:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
