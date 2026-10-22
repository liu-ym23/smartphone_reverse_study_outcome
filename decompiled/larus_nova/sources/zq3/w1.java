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

/* JADX INFO: loaded from: classes14.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v1> f573329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f573330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<v1> f573331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Long, List<v1>> f573332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Long> f573333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WindowHybridTabViewModel f573334f;

    public static final class a {
    }

    static {
    }

    public w1(WindowHybridTabViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridTabVm");
        this.f573334f = r100;
        this.f573329a = new ArrayList();
        this.f573331c = new ArrayList();
        this.f573332d = new ConcurrentHashMap();
        this.f573333e = new ConcurrentHashMap();
    }

    public static Map a(List r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map<String, Object> r103 = ((v1) r102.next()).a();
        if (r103.isEmpty() == true) goto L4;
        r101.putAll(r103);
        goto L4
    L8:
        return r101;
    }

    public final void c(v1 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ArrayList r101 = (ArrayList) this.f573329a;
        if (r101.size() < 50) goto L5;
        r101.clear();
    L5:
        ((ArrayList) this.f573329a).add(r100);
    }

    public final Map<String, Object> b(List<? extends v1> r100, Long r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        List<? extends v1> r103 = r100;
        Iterator<T> r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        v1 r105 = (v1) r104.next();
        r102.put(r105.f573317a, Long.valueOf(r105.f573318b));
        goto L4
    L6:
        Iterator<T> r106 = r103.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Map<String, Object> r107 = ((v1) r106.next()).b();
        if (r107.isEmpty() == true) goto L8;
        r102.putAll(r107);
        goto L8
    L12:
        if (r101 == null) goto L16;
        Long r108 = this.f573333e.get(r101);
        if (r108 == null) goto L16;
        r102.put("t_last_render_end", r108);
    L16:
        return r102;
    }

    public final void d(List<? extends v1> r100, Long r101) {
        if (r101 == null) goto L18;
        r101.longValue();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L5:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        if ((r104 instanceof v1.d) == false) goto L5;
        r102.add(r104);
        goto L5
    L9:
        v1.d r105 = (v1.d) CollectionsKt.firstOrNull(r102);
        if (r105 == null) goto L19;
        long r106 = r105.f573322e;
        this.f573333e.put(Long.valueOf(r106), r101);
        return;
    L19:
        return;
    }
}
