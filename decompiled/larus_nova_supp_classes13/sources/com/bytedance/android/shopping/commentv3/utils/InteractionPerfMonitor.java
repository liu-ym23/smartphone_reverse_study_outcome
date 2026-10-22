package com.bytedance.android.shopping.commentv3.utils;

import android.content.Context;
import java.util.Map;
import jd3.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t53.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class InteractionPerfMonitor {
    public static final Lazy i = null;
    public static final a j = null;
    public String a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public static final class a {
        public a() {
        }

        public static InteractionPerfMonitor a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Lazy r0 = InteractionPerfMonitor.i;
            if (((Map) r0.getValue()).containsKey(r2) == false) goto L7;
            InteractionPerfMonitor r1 = (InteractionPerfMonitor) ((Map) r0.getValue()).get(r2);
            if (r1 == null) goto L7;
            return r1;
        L7:
            InteractionPerfMonitor r3 = new InteractionPerfMonitor();
            ((Map) r0.getValue()).put(r2, r3);
            return r3;
        }
    }

    static {
        j = new a();
        i = LazyKt.lazy(InteractionPerfMonitor$Companion$monitors$2.INSTANCE);
    }

    public InteractionPerfMonitor() {
        this.a = "";
        this.b = "";
    }

    public final void a(int r10, String r11, Context r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "key");
        long r0 = System.currentTimeMillis();
        long r2 = this.c;
        long r4 = r0 - r2;
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r4 <= 0) goto L10;
        k r3 = new k();
        r3.a = r10;
        String r14 = this.a;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r3.b = r14;
        String r15 = this.b;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r3.c = r15;
        r3.d = r0 - this.c;
        r3.f = this.e - this.d;
        r3.g = this.g - this.f;
        r3.h = r0 - this.h;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r3.i = r11;
        e.c(r3, r12, null);
        j.getClass();
        ((Map) i.getValue()).remove(r13);
        return;
    }
}
