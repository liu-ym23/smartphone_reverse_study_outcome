package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.livesdk.livecommerce.event.refactor.EntranceShowStatusByRoomState;
import com.bytedance.android.livesdk.livecommerce.event.refactor.ReportWhenEnter;
import com.bytedance.android.livesdk.livecommerce.event.refactor.RequestLivePromotions;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.utils.ECCartMonitor;
import com.bytedance.android.livesdk.livecommerce.utils.u0;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements v0<ECPromotionList> {
    public final /* synthetic */ EntryController a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.ec.adapter.api.state.a c;

    @Override // vi2.v0
    public final void onError(Throwable r6) {
        boolean r0 = ECCartMonitor.a;
        if (r6 == null) goto L5;
        String r1 = r6.toString();
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        Intrinsics.checkNotNullParameter("", "logId");
        ECCartMonitor.a(new u0(false, r1));
        if (r6 == null) goto L12;
        String r3 = r6.toString();
    L13:
        if (r3 == null) goto L16;
        r2 = r3;
    L16:
        ECLiveEntranceMonitor.trace$default("throwable = ".concat(r2), "EntryController", false, 4, null);
        if (r6 == null) goto L19;
        r6.toString();
    L19:
        this.a.h(new si2.d(true, false));
        int r7 = kh2.b.b;
        kh2.b.a r8 = kh2.b.C0149b.a(new kh2.f(this.c));
        kh2.a r4 = new kh2.a(this.c);
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.a = r4;
        kh2.d r5 = new kh2.d(this.c);
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.b = r5;
        r8.b(ReportWhenEnter.YES);
        kh2.j r9 = new kh2.j(this.c);
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.f = r9;
        kh2.i r10 = new kh2.i(this.c);
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.g = r10;
        r8.c(RequestLivePromotions.YES);
        kh2.g r11 = new kh2.g(null);
        Intrinsics.checkNotNullParameter(r11, "value");
        r8.i = r11;
        kh2.h r12 = new kh2.h(null);
        Intrinsics.checkNotNullParameter(r12, "value");
        r8.j = r12;
        kh2.c r13 = new kh2.c("request error happened");
        Intrinsics.checkNotNullParameter(r13, "value");
        r8.d = r13;
        r8.a(EntranceShowStatusByRoomState.NO);
        new kh2.b(r8).a();
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // vi2.v0
    public final void onSuccess(ECPromotionList r9) {
        ECPromotionList r10 = r9;
        if (TextUtils.equals(this.b, this.a.B()) == true) goto L5;
        int r0 = kh2.b.b;
        kh2.b.a r1 = kh2.b.C0149b.a(new kh2.f(this.c));
        kh2.a r2 = new kh2.a(this.c);
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.a = r2;
        kh2.d r3 = new kh2.d(this.c);
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.b = r3;
        r1.b(ReportWhenEnter.YES);
        kh2.j r4 = new kh2.j(this.c);
        Intrinsics.checkNotNullParameter(r4, "value");
        r1.f = r4;
        kh2.i r5 = new kh2.i(this.c);
        Intrinsics.checkNotNullParameter(r5, "value");
        r1.g = r5;
        r1.c(RequestLivePromotions.YES);
        kh2.g r6 = new kh2.g(r10);
        Intrinsics.checkNotNullParameter(r6, "value");
        r1.i = r6;
        kh2.h r7 = new kh2.h(r10);
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.j = r7;
        kh2.c r11 = new kh2.c("roomId doesn't match");
        Intrinsics.checkNotNullParameter(r11, "value");
        r1.d = r11;
        r1.a(EntranceShowStatusByRoomState.NO);
        new kh2.b(r1).a();
        return;
    L5:
        if (r10 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e.getClass();
        Intrinsics.checkNotNullParameter(r10, "list");
        ECPromotionList.u r8 = r10.roomCart;
        if (r8 == null) goto L9;
        de.b r12 = r8.vertical;
    L10:
        if (r8 == null) goto L12;
        de.b r13 = r8.horizontal;
    L13:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.f(new com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a(r12, r13), this.a.A().m);
        goto L14
    L12:
        r13 = null;
        goto L13
    L9:
        r12 = null;
    L14:
        boolean r14 = true;
        if (r10 != null) goto L17;
    L19:
        boolean r15 = false;
    L20:
        if (r15 == false) goto L24;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a r16 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e;
        com.bytedance.android.ec.adapter.api.state.a r17 = this.c;
        r16.getClass();
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.a(r17) == false) goto L24;
    L25:
        this.a.G = r15;
        ECLiveEntranceMonitor.trace$default("audience degrade isShowCart=" + r15 + " showEntrance=" + r14, "EntryController", false, 4, null);
        boolean r18 = ECCartMonitor.a;
        Intrinsics.checkNotNullParameter("", "logId");
        ECCartMonitor.a(new u0(r15, null));
        this.a.J(r14);
        int r19 = kh2.b.b;
        kh2.b.a r20 = kh2.b.C0149b.a(new kh2.f(this.c));
        kh2.a r21 = new kh2.a(this.c);
        Intrinsics.checkNotNullParameter(r21, "value");
        r20.a = r21;
        kh2.d r22 = new kh2.d(this.c);
        Intrinsics.checkNotNullParameter(r22, "value");
        r20.b = r22;
        r20.b(ReportWhenEnter.YES);
        kh2.j r23 = new kh2.j(this.c);
        Intrinsics.checkNotNullParameter(r23, "value");
        r20.f = r23;
        kh2.i r24 = new kh2.i(this.c);
        Intrinsics.checkNotNullParameter(r24, "value");
        r20.g = r24;
        r20.c(RequestLivePromotions.YES);
        kh2.g r25 = new kh2.g(r10);
        Intrinsics.checkNotNullParameter(r25, "value");
        r20.i = r25;
        kh2.h r26 = new kh2.h(r10);
        Intrinsics.checkNotNullParameter(r26, "value");
        r20.j = r26;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a r27 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e;
        com.bytedance.android.ec.adapter.api.state.a r28 = this.c;
        r27.getClass();
        kh2.c r29 = new kh2.c("request success happened".concat(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.d(r28, r15)));
        Intrinsics.checkNotNullParameter(r29, "value");
        r20.d = r29;
        if (r14 == false) goto L28;
        EntranceShowStatusByRoomState r30 = EntranceShowStatusByRoomState.YES;
    L29:
        r20.a(r30);
        new kh2.b(r20).a();
        return;
    L28:
        r30 = EntranceShowStatusByRoomState.NO;
    L24:
        r14 = false;
        goto L25
    L17:
        if (r10.showCart != 1) goto L19;
        r15 = true;
        goto L20
    }

    public l(EntryController r1, String r2, com.bytedance.android.ec.adapter.api.state.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
