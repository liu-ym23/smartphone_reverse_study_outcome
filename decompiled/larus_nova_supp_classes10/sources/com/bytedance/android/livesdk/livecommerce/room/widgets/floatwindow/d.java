package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.livesdk.livecommerce.event.b2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ FloatWindowView a;
    public final /* synthetic */ c b;

    public d(FloatWindowView r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        b2 r0 = new b2();
        r0.f("anchor_id", (String) this.a.i.getAnchorId().getValue());
        r0.f("product_id", this.b.b);
        r0.f("commodity_id", this.b.c);
        r0.f("commodity_type", this.b.d);
        r0.f("room_id", (String) this.a.i.getRoomId().getValue());
        ECFloatWindowInfo r1 = this.b.a;
        if (r1 == null) goto L5;
        String r2 = r1.getInfoType();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        Intrinsics.checkNotNullParameter(r2, "infoType");
        r0.f("info_type", r2);
        r0.k();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
