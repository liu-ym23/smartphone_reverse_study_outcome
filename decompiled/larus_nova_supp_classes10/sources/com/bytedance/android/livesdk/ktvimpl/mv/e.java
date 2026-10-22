package com.bytedance.android.livesdk.ktvimpl.mv;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ KtvMvModel a;
    public final /* synthetic */ y b;

    public e(KtvMvModel r1, y r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.a.h.remove(this.b);
        int r0 = mb0.b.a;
        int r1 = mb0.b.a.a(r8);
        String r2 = mb0.b.a.b(r8);
        ArrayList<Function3<l, Integer, String, Unit>> r3 = this.b.a;
        if (r3 == null) goto L8;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ((Function3) r4.next()).invoke(null, Integer.valueOf(r1), r2);
    L8:
        Function3<? super String, ? super Long, ? super String, Unit> r5 = this.a.f;
        if (r5 == null) goto L11;
        Unit r6 = (Unit) r5.invoke(null, Long.valueOf(this.b.b), this.b.d);
    L11:
        com.bytedance.android.live.ktv.common.util.g.e("requestAndNotifyAllMvInfoBySong error " + r8.getMessage());
    }
}
