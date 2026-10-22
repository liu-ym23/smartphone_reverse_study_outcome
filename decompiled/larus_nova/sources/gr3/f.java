package gr3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f482355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f482356b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f482357c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f482358d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, Integer> f482359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f482360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f482361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Integer> f482362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f482363e;

        public a(int r100) {
            this.f482359a = new ConcurrentHashMap();
            this.f482360b = new ConcurrentHashMap();
            this.f482361c = new ConcurrentHashMap();
            this.f482362d = new ConcurrentHashMap();
            this.f482363e = new AtomicInteger(r100);
        }

        public final int a(int r100, boolean r101) {
            if (r101 == false) goto L4;
            ConcurrentHashMap<Integer, Integer> r102 = this.f482361c;
        L5:
            Integer r103 = r102.get(Integer.valueOf(r100));
            if (r103 != null) goto L8;
            int r104 = this.f482363e.getAndIncrement();
            r102.put(Integer.valueOf(r100), Integer.valueOf(r104));
            this.f482362d.put(Integer.valueOf(r104), Integer.valueOf(r100));
            return r104;
        L8:
            return r103.intValue();
        L4:
            r102 = this.f482360b;
            goto L5
        }
    }

    static {
        f482355a = RangesKt.until(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, 100000);
        f482356b = new a(0);
        f482357c = new a(3000);
        f482358d = new a(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND);
    }

    public static int a(int r100) {
        if (r100 >= 3000) goto L7;
        return r100 + 3000;
    L7:
        if (r100 < 4000) goto L9;
        ECExceptionMonitor.c("native card type range overflow, input is " + r100);
    L9:
        return r100;
    }

    public static int b(ECHybridListItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Integer r101 = r100.f47028c;
        int r102 = 3000;
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        Integer r104 = Integer.valueOf(r103);
        Integer r105 = r100.i();
        boolean r106 = false;
        if (r105 == null) goto L9;
        int r107 = r105.intValue();
    L11:
        if (r107 < 2) goto L13;
        r106 = true;
    L13:
        if (r104 == null) goto L16;
        r102 = r104.intValue();
    L16:
        if (f482355a.contains(r102) == false) goto L18;
        a r108 = f482358d;
    L20:
        return r108.a(r102, r106);
    L18:
        r108 = f482357c;
        goto L20
    L9:
        r107 = 0;
        goto L11
    L5:
        r103 = 3000;
        goto L6
    }
}
