package sg2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 implements y {
    public final Map<String, c> a;
    public final Map<String, c> b;
    public String c;
    public int d;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((c) r4).c()), Long.valueOf(((c) r3).c()));
        }
    }

    @Override // sg2.y
    public final void h() {
    }

    @Override // sg2.y
    public final void setRoomId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
    }

    public b0() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = "";
    }

    @Override // sg2.y
    public final String i() {
        return this.c;
    }

    @Override // sg2.y
    public final void a(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Map<String, c> r2 = this.b;
        c r3 = (c) ((LinkedHashMap) r2).get(r8);
        if (r3 != null) goto L14;
        r3 = new c();
    L14:
        r3.i(r8);
        r3.k(1);
        r3.j(r3.e() + 1);
        Unit r0 = Unit.INSTANCE;
        r2.put(r8, r3);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // sg2.y
    public final void b(boolean r1) {
        this.d = r1 ? 1 : 0;
    }

    @Override // sg2.y
    public final List<String> c(int r4) {
        List r0 = CollectionsKt.toList(((LinkedHashMap) this.b).values());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(((c) r2.next()).d());
        goto L4
    L7:
        return CollectionsKt.take(r1, r4);
    }

    @Override // sg2.y
    public final void e(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Map<String, c> r2 = this.a;
        c r3 = (c) ((LinkedHashMap) r2).get(r8);
        if (r3 != null) goto L14;
        r3 = new c();
    L14:
        r3.k(0);
        r3.g();
        r3.f(r3.a() + 1);
        r3.h(System.currentTimeMillis());
        r3.i(r8);
        Unit r0 = Unit.INSTANCE;
        r2.put(r8, r3);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // sg2.y
    public final void f(String r3) {
        if (com.bytedance.android.shopping.anchorv3.a.b(r3) == true) goto L5;
    L7:
        r3 = "";
    L8:
        this.c = r3;
        return;
    L5:
        if ((!Intrinsics.areEqual(r3, BDLocationException.ERROR_TIMEOUT)) == false) goto L7;
        if (r3 != null) goto L8;
        goto L7
    }

    @Override // sg2.y
    public final JSONObject g(int r5) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("live_explain_product", this.c);     // Catch: Exception -> L5
        r1.put("live_is_shopping", this.d);     // Catch: Exception -> L5
        r1.put("live_show_products", c(r5));     // Catch: Exception -> L5
        r1.put("live_click_products", d(r5, null));     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    @Override // sg2.y
    public final List<String> d(int r6, Integer r7) {
        if (r7 == null) goto L12;
        Collection r0 = ((LinkedHashMap) this.a).values();
        ?? r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L5:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (((c) r3).b() != r7.intValue()) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L5;
        r1.add(r3);
        goto L5
    L9:
        r4 = false;
    L13:
        List r8 = CollectionsKt.sortedWith((Iterable) r1, new a());
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L18;
        r5.add(((c) r9.next()).d());
        goto L15
    L18:
        return CollectionsKt.takeLast(r5, r6);
    L12:
        r1 = CollectionsKt.toList(((LinkedHashMap) this.a).values());
        goto L13
    }
}
