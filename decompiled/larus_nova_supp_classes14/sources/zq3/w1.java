package zq3;

import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w1 {
    public final List<v1> a;
    public Map<String, ? extends Object> b;
    public final List<v1> c;
    public final ConcurrentHashMap<Long, List<v1>> d;
    public final ConcurrentHashMap<Long, Long> e;
    public final WindowHybridTabViewModel f;

    public static final class a {
    }

    static {
    }

    public w1(WindowHybridTabViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridTabVm");
        this.f = r2;
        this.a = new ArrayList();
        this.c = new ArrayList();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    public static Map a(List r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map<String, Object> r1 = ((v1) r4.next()).a();
        if (r1.isEmpty() == true) goto L4;
        r0.putAll(r1);
        goto L4
    L8:
        return r0;
    }

    public final void c(v1 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        ArrayList r0 = (ArrayList) this.a;
        if (r0.size() < 50) goto L5;
        r0.clear();
    L5:
        ((ArrayList) this.a).add(r4);
    }

    public final Map<String, Object> b(List<? extends v1> r7, Long r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        List<? extends v1> r9 = r7;
        Iterator<T> r1 = r9.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        v1 r2 = (v1) r1.next();
        r0.put(r2.a, Long.valueOf(r2.b));
        goto L4
    L6:
        Iterator<T> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Map<String, Object> r3 = ((v1) r10.next()).b();
        if (r3.isEmpty() == true) goto L8;
        r0.putAll(r3);
        goto L8
    L12:
        if (r8 == null) goto L16;
        Long r11 = this.e.get(r8);
        if (r11 == null) goto L16;
        r0.put("t_last_render_end", r11);
    L16:
        return r0;
    }

    public final void d(List<? extends v1> r4, Long r5) {
        if (r5 == null) goto L18;
        r5.longValue();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L5:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        if ((r1 instanceof v1.d) == false) goto L5;
        r0.add(r1);
        goto L5
    L9:
        v1.d r7 = (v1.d) CollectionsKt.firstOrNull(r0);
        if (r7 == null) goto L19;
        long r2 = r7.e;
        this.e.put(Long.valueOf(r2), r5);
        return;
    L19:
        return;
    }
}
