package com.bytedance.salamander.adapter;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267796a = 0;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.salamander.adapter.u] */
        public static void a(final Function1 r100, i r101, double r102) {
            Intrinsics.checkNotNullParameter(r100, "workload");
            Intrinsics.checkNotNullParameter(r101, "queue");
            ConcurrentHashMap<String, j> r103 = v.f267800a;
            Intrinsics.checkNotNullParameter(r100, "workload");
            Intrinsics.checkNotNullParameter(r101, "queue");
            j r104 = r101.f267788b;
            boolean r105 = r104 instanceof j;
            j r106 = r104;
            if (r105 == true) goto L6;
            r106 = 0;
        L6:
            if (r106 != 0) goto L8;
            System.out.println("Queue.ref must be Handler for " + r101.f267787a);
            return;
        L8:
            long r107 = RangesKt.coerceAtLeast((long) (r102 * ((double) 1000)), 0);
            ?? r108 = new u(r100);
            if (r107 <= 0) goto L11;
            r106.a(r108, r107);
            return;
        L11:
            r106.b(r108);
        }
    }

    static {
        new a();
    }
}
