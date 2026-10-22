package com.bytedance.salamander.adapter;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267793a = 0;

    public static final class a {
        public static String a(int r100) {
            int r101 = com.bytedance.rts.foundation.c.f267576a;
            int r102 = com.bytedance.rts.foundation.h.f267580a;
            return com.bytedance.rts.foundation.r.a("0123456789ABCDEF", (int) Math.floor(com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r100) / ((double) 16))) + com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r100 % 16);
        }
    }

    static {
    }
}
