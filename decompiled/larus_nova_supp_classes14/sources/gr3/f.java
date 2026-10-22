package gr3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final IntRange a = null;
    public static final a b = null;
    public static final a c = null;
    public static final a d = null;

    public static final class a {
        public final ConcurrentHashMap<String, Integer> a;
        public final ConcurrentHashMap<Integer, Integer> b;
        public final ConcurrentHashMap<Integer, Integer> c;
        public final ConcurrentHashMap<Integer, Integer> d;
        public final AtomicInteger e;

        public a(int r2) {
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.c = new ConcurrentHashMap();
            this.d = new ConcurrentHashMap();
            this.e = new AtomicInteger(r2);
        }

        public final int a(int r4, boolean r5) {
            if (r5 == false) goto L4;
            ConcurrentHashMap<Integer, Integer> r6 = this.c;
        L5:
            Integer r0 = r6.get(Integer.valueOf(r4));
            if (r0 != null) goto L8;
            int r1 = this.e.getAndIncrement();
            r6.put(Integer.valueOf(r4), Integer.valueOf(r1));
            this.d.put(Integer.valueOf(r1), Integer.valueOf(r4));
            return r1;
        L8:
            return r0.intValue();
        L4:
            r6 = this.b;
            goto L5
        }
    }

    static {
        a = RangesKt.until(50001, 100000);
        b = new a(0);
        c = new a(3000);
        d = new a(50001);
    }

    public static int a(int r2) {
        if (r2 >= 3000) goto L7;
        return r2 + 3000;
    L7:
        if (r2 < 4000) goto L9;
        ECExceptionMonitor.c("native card type range overflow, input is " + r2);
    L9:
        return r2;
    }

    public static int b(ECHybridListItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "vo");
        Integer r0 = r4.c;
        int r1 = 3000;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        Integer r3 = Integer.valueOf(r2);
        Integer r5 = r4.i();
        boolean r6 = false;
        if (r5 == null) goto L9;
        int r7 = r5.intValue();
    L11:
        if (r7 < 2) goto L13;
        r6 = true;
    L13:
        if (r3 == null) goto L16;
        r1 = r3.intValue();
    L16:
        if (a.contains(r1) == false) goto L18;
        a r8 = d;
    L20:
        return r8.a(r1, r6);
    L18:
        r8 = c;
        goto L20
    L9:
        r7 = 0;
        goto L11
    L5:
        r2 = 3000;
        goto L6
    }
}
