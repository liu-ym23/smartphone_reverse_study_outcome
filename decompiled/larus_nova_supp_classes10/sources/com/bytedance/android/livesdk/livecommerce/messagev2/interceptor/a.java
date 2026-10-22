package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements sg2.e0 {
    public com.bytedance.android.livesdk.livecommerce.room.j a;
    public String b;
    public String c;
    public final boolean d;

    public a() {
        this(false);
    }

    public abstract boolean c(sg2.a r1);

    public boolean d() {
        return false;
    }

    public abstract void e(String r1, boolean r2);

    public final Context getContext() {
        com.bytedance.android.livesdk.livecommerce.room.j r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    public a(boolean r1) {
        this.d = r1;
    }

    @Override // sg2.e0
    public final <T> boolean a(sg2.e0.a<T> r6) throws Exception {
        T r0 = r6.getMessage();
        boolean r2 = false;
        if ((r0 instanceof sg2.a) == false) goto L28;
        sg2.a r1 = (sg2.a) r0;
        int r3 = RoomContextController.h;
        RoomContextController r4 = RoomContextController.a.b(this.b, this.c);
        if (d() == false) goto L12;
        if (r4.x() == false) goto L12;
        if (r4.M() == false) goto L28;
    L12:
        if (this.d == true) goto L27;
        sg2.b r5 = r1.getCommon();
        if (r5 == null) goto L16;
        String r7 = r5.e;
    L17:
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L27;
        if ((!Intrinsics.areEqual(r7, this.b)) == false) goto L27;
    L19:
        if (r7.length() == 0) goto L22;
        r8 = false;
        goto L23
    L16:
        r7 = null;
    L27:
        r2 = c(r1);
    L28:
        if (r2 == false) goto L31;
        return true;
    L31:
        return r6.a(r6.getMessage());
    }

    public final <R> R b(Class<R> r3, sg2.a r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        String r1 = null;
        if (this.d == false) goto L11;
        com.bytedance.android.livesdk.livecommerce.room.j r0 = this.a;
        if (r0 == null) goto L15;
        if (r4 == null) goto L16;
        sg2.b r5 = r4.getCommon();
        if (r5 == null) goto L16;
        r1 = r5.e;
    L16:
        return (R) com.bytedance.android.livesdk.livecommerce.room.k.a(r0, r3, r1);
    L15:
        return null;
    L11:
        com.bytedance.android.livesdk.livecommerce.room.j r6 = this.a;
        if (r6 != null) goto L14;
        return null;
    L14:
        return (R) com.bytedance.android.livesdk.livecommerce.room.k.a(r6, r3, null);
    }
}
