package com.bytedance.salamander.bdfoundation;

import com.bytedance.rts.foundation.h;
import com.bytedance.rts.foundation.k;
import com.bytedance.rts.foundation.r;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: classes20.dex */
public final class b {
    public static final String a(int r100) {
        int r101 = com.bytedance.rts.foundation.c.f267576a;
        int r102 = h.f267580a;
        return r.a("0123456789ABCDEF", (int) Math.floor(k.b(IntCompanionObject.INSTANCE, r100) / ((double) 16))) + r.a("0123456789ABCDEF", r100 % 16);
    }
}
