package com.bytedance.salamander.adapter;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a(int r5) {
            int r0 = com.bytedance.rts.foundation.c.a;
            int r1 = com.bytedance.rts.foundation.h.a;
            return com.bytedance.rts.foundation.r.a("0123456789ABCDEF", (int) Math.floor(com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r5) / ((double) 16))) + com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r5 % 16);
        }
    }

    static {
    }
}
