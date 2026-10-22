package com.relax.relaxframework;

import com.byted.cast.common.Constants;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<z1> f405267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<Integer> f405268b;

    public s7() {
        this.f405267a = com.bytedance.rts.foundation.j.k(new z1[0]);
        this.f405268b = com.bytedance.rts.foundation.j.k(new Integer[0]);
    }

    public final void a(z1 r100, y1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, Constants.ROLE_SINK);
        com.bytedance.rts.foundation.j.j(this.f405267a, r100);
        int r103 = -1;
        if (r102 == false) goto L5;
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.foundation.j.d(this.f405267a);
        com.bytedance.rts.foundation.k.c(r104, r105);
        r103 = r100.e(r101, r105 - 1);
    L5:
        com.bytedance.rts.foundation.j.j(this.f405268b, Integer.valueOf(r103));
        com.bytedance.rts.foundation.k.c(IntCompanionObject.INSTANCE, com.bytedance.rts.foundation.j.d(this.f405267a));
    }
}
