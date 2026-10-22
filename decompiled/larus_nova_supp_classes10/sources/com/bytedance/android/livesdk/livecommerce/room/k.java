package com.bytedance.android.livesdk.livecommerce.room;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public static final <R> R a(j r1, Class<R> r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$getReceiver");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        if (Intrinsics.areEqual(r2, lj2.a.class) == false) goto L8;
        R r4 = (R) r1.o(r3);
        if ((r4 instanceof Object) == true) goto L51;
    L49:
        return null;
    L51:
        return r4;
    L8:
        if (Intrinsics.areEqual(r2, oj2.a.class) == false) goto L13;
        R r5 = (R) r1.m(r3);
        if ((r5 instanceof Object) == false) goto L49;
        return r5;
    L13:
        if (Intrinsics.areEqual(r2, fh2.a.class) == false) goto L18;
        R r6 = (R) r1.p(r3);
        if ((r6 instanceof Object) == false) goto L49;
        return r6;
    L18:
        if (Intrinsics.areEqual(r2, o.class) == false) goto L23;
        R r7 = (R) r1.n(r3);
        if ((r7 instanceof Object) == false) goto L49;
        return r7;
    L23:
        if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c.class) == false) goto L28;
        R r8 = (R) r1.i(r3);
        if ((r8 instanceof Object) == false) goto L49;
        return r8;
    L28:
        if (Intrinsics.areEqual(r2, jk2.a.class) == false) goto L31;
        r1.j(r3);
        goto L49
    L31:
        if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.livecommerce.intro.message.a.class) == false) goto L36;
        R r9 = (R) r1.q(r3);
        if ((r9 instanceof Object) == false) goto L49;
        return r9;
    L36:
        if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j.class) == false) goto L41;
        R r10 = (R) r1.d();
        if ((r10 instanceof Object) == false) goto L49;
        return r10;
    L41:
        if (Intrinsics.areEqual(r2, com.bytedance.android.livesdk.livecommerce.room.api.c.class) == false) goto L46;
        R r11 = (R) r1.k();
        if ((r11 instanceof Object) == false) goto L49;
        return r11;
    L46:
        if (Intrinsics.areEqual(r2, RoomContextController.class) == false) goto L49;
        R r12 = (R) r1.b();
        if ((r12 instanceof Object) == false) goto L49;
        return r12;
    }
}
