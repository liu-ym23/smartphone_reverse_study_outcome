package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b1> f404999a;

    public a1() {
        this.f404999a = com.bytedance.rts.foundation.j.k(new b1[0]);
    }

    public final ArrayList<q1> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = 0;
    L3:
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.foundation.j.d(this.f404999a);
        com.bytedance.rts.foundation.k.c(r102, r103);
        if (r101 >= r103) goto L13;
        ArrayList<b1> r104 = this.f404999a;
        int r105 = com.bytedance.rts.foundation.d.f267577a;
        if (Intrinsics.areEqual(((b1) ListProtector.get(r104, r101)).f405014a, r100) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        ArrayList<q1> r106 = ((b1) ListProtector.get(this.f404999a, r101)).f405015b;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("___listeners");
        return null;
    L11:
        return r106;
    L13:
        return null;
    }
}
