package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.livesdk.livecommerce.event.a2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ c b;
    public final /* synthetic */ boolean c;

    public b(a r1, c r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        a2 r0 = new a2();
        r0.f("anchor_id", (String) this.a.h.getAnchorId().getValue());
        r0.f("product_id", this.b.b);
        r0.f("commodity_id", this.b.c);
        r0.f("commodity_type", this.b.d);
        r0.f("room_id", (String) this.a.h.getRoomId().getValue());
        if (this.c == false) goto L5;
        String r1 = "expand";
    L6:
        r0.f("click_type", r1);
        ECFloatWindowInfo r2 = this.b.a;
        if (r2 == null) goto L9;
        String r3 = r2.getInfoType();
    L10:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        Intrinsics.checkNotNullParameter(r3, "infoType");
        r0.f("info_type", r3);
        r0.k();
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = "close";
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
