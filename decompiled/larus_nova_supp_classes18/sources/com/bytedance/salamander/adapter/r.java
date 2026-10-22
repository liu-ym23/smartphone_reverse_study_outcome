package com.bytedance.salamander.adapter;

import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.salamander.adapter.u] */
        public static void a(final Function1 r3, i r4, double r5) {
            Intrinsics.checkNotNullParameter(r3, "workload");
            Intrinsics.checkNotNullParameter(r4, "queue");
            ConcurrentHashMap<String, j> r2 = v.a;
            Intrinsics.checkNotNullParameter(r3, "workload");
            Intrinsics.checkNotNullParameter(r4, "queue");
            j r0 = r4.b;
            boolean r1 = r0 instanceof j;
            j r6 = r0;
            if (r1 == true) goto L6;
            r6 = 0;
        L6:
            if (r6 != 0) goto L8;
            System.out.println("Queue.ref must be Handler for " + r4.a);
            return;
        L8:
            long r7 = RangesKt.coerceAtLeast((long) (r5 * ((double) CCMLynxCardView.ViewType.BANNER)), 0);
            ?? r8 = new u(r3);
            if (r7 <= 0) goto L11;
            r6.a(r8, r7);
            return;
        L11:
            r6.b(r8);
        }
    }

    static {
        new a();
    }
}
