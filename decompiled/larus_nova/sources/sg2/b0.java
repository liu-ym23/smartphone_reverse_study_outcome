package sg2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
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

/* JADX INFO: loaded from: classes10.dex */
public final class b0 implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f541777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, c> f541778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f541779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f541780d;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((c) r101).c()), Long.valueOf(((c) r100).c()));
        }
    }

    @Override // sg2.y
    public final void h() {
    }

    @Override // sg2.y
    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
    }

    public b0() {
        this.f541777a = new LinkedHashMap();
        this.f541778b = new LinkedHashMap();
        this.f541779c = "";
    }

    @Override // sg2.y
    public final String i() {
        return this.f541779c;
    }

    @Override // sg2.y
    public final void a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Map<String, c> r102 = this.f541778b;
        c r103 = (c) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L14;
        r103 = new c();
    L14:
        r103.i(r100);
        r103.k(1);
        r103.j(r103.e() + 1);
        Unit r104 = Unit.INSTANCE;
        r102.put(r100, r103);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // sg2.y
    public final void b(boolean r100) {
        this.f541780d = r100 ? 1 : 0;
    }

    @Override // sg2.y
    public final List<String> c(int r100) {
        List r101 = CollectionsKt.toList(((LinkedHashMap) this.f541778b).values());
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add(((c) r103.next()).d());
        goto L4
    L7:
        return CollectionsKt.take(r102, r100);
    }

    @Override // sg2.y
    public final void e(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Map<String, c> r102 = this.f541777a;
        c r103 = (c) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L14;
        r103 = new c();
    L14:
        r103.k(0);
        r103.g();
        r103.f(r103.a() + 1);
        r103.h(System.currentTimeMillis());
        r103.i(r100);
        Unit r104 = Unit.INSTANCE;
        r102.put(r100, r103);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // sg2.y
    public final void f(String r100) {
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == true) goto L5;
    L7:
        r100 = "";
    L8:
        this.f541779c = r100;
        return;
    L5:
        if ((!Intrinsics.areEqual(r100, "0")) == false) goto L7;
        if (r100 != null) goto L8;
        goto L7
    }

    @Override // sg2.y
    public final JSONObject g(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("live_explain_product", this.f541779c);     // Catch: Exception -> L5
        r101.put("live_is_shopping", this.f541780d);     // Catch: Exception -> L5
        r101.put("live_show_products", c(r100));     // Catch: Exception -> L5
        r101.put("live_click_products", d(r100, null));     // Catch: Exception -> L5
        return r101;
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
    public final List<String> d(int r100, Integer r101) {
        if (r101 == null) goto L12;
        Collection r102 = ((LinkedHashMap) this.f541777a).values();
        ?? r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L5:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((c) r105).b() != r101.intValue()) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L5;
        r103.add(r105);
        goto L5
    L9:
        r106 = false;
    L13:
        List r107 = CollectionsKt.sortedWith((Iterable) r103, new a());
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L15:
        if (r109.hasNext() == false) goto L18;
        r108.add(((c) r109.next()).d());
        goto L15
    L18:
        return CollectionsKt.takeLast(r108, r100);
    L12:
        r103 = CollectionsKt.toList(((LinkedHashMap) this.f541777a).values());
        goto L13
    }
}
