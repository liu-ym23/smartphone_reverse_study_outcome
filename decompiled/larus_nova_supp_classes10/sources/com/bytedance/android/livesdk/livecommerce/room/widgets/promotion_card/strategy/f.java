package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.model.g;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static dm.a.b a() {
        return dm.a.a("ExplainCardShowStrategy");
    }

    static {
    }

    public static void b(String r6, String r7, Map r8, RoomContextController r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        if (r9 != null) goto L13;
        int r11 = RoomContextController.h;
        r9 = RoomContextController.a.a();
    L13:
        ECContext r12 = r9.r();
        if (r12 == null) goto L17;
        bk2.c.a(new qk2.a().b(new g(r12, r9), false, false, r7, r8).subscribe(new d(r8, r10), e.a), (bk2.d) r12.getDisposableContext().getValue());
        return;
    L17:
        return;
    L6:
        if (r9 != null) goto L8;
    L12:
        int r13 = RoomContextController.h;
        r9 = RoomContextController.a.b(r6, null);
        goto L13
    L8:
        if (r9.v() == true) goto L11;
        int r0 = RoomContextController.h;
        r9 = RoomContextController.a.b(r6, r9.D());
    L11:
        if (r9 != null) goto L13;
        goto L12
    }
}
