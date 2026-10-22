package qi2;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends a {
    public zk.a a;
    public RoomContextController b;
    public EntryController c;
    public final RealRoomController d;

    public b(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.d = r2;
    }

    @Override // qi2.a
    public final boolean b(ee.b r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        RoomContextController r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomContextController");
    L5:
        boolean r1 = r0.s();
        int r2 = r9.getMsgType();
        if (r2 != 13) goto L8;
        EntryController r3 = this.c;
        if (r3 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("entryController");
    L49:
        r3.L = true;
        if (r1 == false) goto L61;
        RoomContextController r4 = this.b;
        if (r4 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("roomContextController");
    L54:
        Context r5 = r4.getContext();
        if (r5 == null) goto L57;
        k.n(r5, r9.A());
    L57:
        zk.a r10 = this.a;
        if (r10 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("commerceInfoTracer");
    L60:
        r10.k(true);
    L65:
        return true;
    L61:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e.getClass();
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a r11 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.b(r9);
        RoomContextController r6 = this.b;
        if (r6 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("roomContextController");
    L64:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.f(r11, r6);
        goto L65
    L8:
        if (r2 == 14) goto L27;
        EntryController r7 = this.c;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("entryController");
    L13:
        if (r7.L == false) goto L15;
    L25:
        return false;
    L15:
        if (r9.getMsgType() != 2) goto L17;
        return true;
    L17:
        if (r9.getMsgType() != 0) goto L19;
        return true;
    L19:
        if (r9.getMsgType() != 4) goto L21;
        return true;
    L21:
        if (r9.getMsgType() != 8) goto L23;
        return true;
    L23:
        if (r9.getMsgType() != 10) goto L25;
        return true;
    L27:
        EntryController r8 = this.c;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("entryController");
    L30:
        r8.L = false;
        if (r1 == false) goto L42;
        RoomContextController r12 = this.b;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("roomContextController");
    L35:
        Context r13 = r12.getContext();
        if (r13 == null) goto L38;
        k.n(r13, r9.A());
    L38:
        zk.a r14 = this.a;
        if (r14 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("commerceInfoTracer");
    L41:
        r14.k(false);
        goto L65
    L42:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e.getClass();
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a r15 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.b(r9);
        RoomContextController r16 = this.b;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("roomContextController");
    L45:
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.f(r15, r16);
        goto L65
    }

    @Override // qi2.a
    public final void c(j r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a = r3.h();
        if (this.d.l() == false) goto L5;
        RoomContextController r0 = this.d.m;
    L6:
        this.b = r0;
        if (this.d.l() == false) goto L9;
        EntryController r4 = this.d.t;
    L10:
        this.c = r4;
        return;
    L9:
        boolean r1 = EntryController.M1;
        r4 = EntryController.a.b(r3.roomId(), null);
        goto L10
    L5:
        int r2 = RoomContextController.h;
        r0 = RoomContextController.a.b(r3.roomId(), null);
        goto L6
    }
}
