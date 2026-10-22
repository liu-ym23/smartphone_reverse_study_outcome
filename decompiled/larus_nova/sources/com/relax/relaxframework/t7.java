package com.relax.relaxframework;

import com.byted.cast.common.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<y1> f405284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f405285b;

    public t7() {
        this.f405284a = com.bytedance.rts.foundation.j.k(new y1[0]);
        this.f405285b = com.bytedance.rts.foundation.j.k(new Integer[0]);
    }

    public final void c(int r100) {
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = com.bytedance.rts.foundation.j.d(this.f405284a);
        com.bytedance.rts.foundation.k.c(r101, r102);
        if (r102 <= 0) goto L8;
        Object r103 = com.bytedance.rts.foundation.j.i(this.f405284a);
        Intrinsics.checkNotNull(r103);
        y1 r104 = (y1) r103;
        Object r105 = com.bytedance.rts.foundation.j.i(this.f405285b);
        Intrinsics.checkNotNull(r105);
        int r106 = ((Number) r105).intValue();
        int r107 = com.bytedance.rts.foundation.j.d(this.f405284a);
        com.bytedance.rts.foundation.k.c(r101, r107);
        if (r100 >= r107) goto L9;
        ArrayList<Integer> r108 = r104.f().f405268b;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        ListProtector.set(r108, r106, Integer.valueOf(r100));
        ListProtector.set(this.f405284a, r100, r104);
        ListProtector.set(this.f405285b, r100, Integer.valueOf(r106));
        return;
    L9:
        return;
    }

    public final int a(y1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        com.bytedance.rts.foundation.j.j(this.f405284a, r100);
        com.bytedance.rts.foundation.j.j(this.f405285b, Integer.valueOf(r101));
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.foundation.j.d(this.f405284a);
        com.bytedance.rts.foundation.k.c(r102, r103);
        return r103 - 1;
    }

    public final void b(z1 r100, boolean r101, ArrayList<e2> r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r102, "pendingWatchers");
        int r103 = 0;
    L3:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.foundation.j.d(this.f405284a);
        com.bytedance.rts.foundation.k.c(r104, r105);
        if (r103 >= r105) goto L6;
        ArrayList<y1> r106 = this.f405284a;
        int r107 = com.bytedance.rts.foundation.d.f267577a;
        ((y1) ListProtector.get(r106, r103)).d(r100, r101, r102);
        r103 = r103 + 1;
        goto L3
    }
}
