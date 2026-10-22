package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f405031a;

    public static final class a {
    }

    static {
    }

    public c1 r() {
        return null;
    }

    public c1() {
    }

    public q0 q(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a1 r101 = this.f405031a;
        if (r101 == null) goto L5;
        ArrayList<q1> r102 = r101.a(r100.f405311b);
    L6:
        int r103 = 0;
        if (r102 == null) goto L9;
        boolean r104 = false;
    L11:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        int r106 = com.bytedance.rts.foundation.j.d(r102);
        com.bytedance.rts.foundation.k.c(r105, r106);
        if (r103 >= r106) goto L15;
        int r107 = com.bytedance.rts.foundation.d.f267577a;
        q1 r108 = (q1) ListProtector.get(r102, r103);
        r108.getClass();
        r108.a(r100);
        r103 = r103 + 1;
        r104 = true;
        goto L11
    L15:
        return new q0(EventCancelType.NotCanceled, r104);
    L9:
        return new q0(EventCancelType.NotCanceled, false);
    L5:
        r102 = null;
        goto L6
    }
}
