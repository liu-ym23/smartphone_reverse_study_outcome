package x7a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f562863d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<d> f562864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<f, d> f562865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f562866c;

    static {
        f562863d = new g();
    }

    public final d a() {
        Stack<d> r100 = this.f562864a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return this.f562864a.peek();
    }

    public g() {
        this.f562864a = new Stack();
        this.f562865b = new WeakHashMap();
        this.f562866c = Integer.MAX_VALUE;
    }

    public final void b() {
        d r100 = a();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f562857b.isEmpty() == true) goto L7;
        h r101 = r100.f562857b.pop();
        r100.c(r100.f562859d.remove(r101));
        return;
    L7:
        f r102 = r100.b();
        if (r102 == null) goto L13;
        r102.quit();
        return;
    }

    public final void c(String r100, Map<String, Object> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        d r102 = a();
        if (r102 == null) goto L17;
        HashMap<String, Object> r103 = r102.f562858c;
        if (r103 == null) goto L11;
        Object r104 = r103.get(r100);
        if ((r104 instanceof String) == false) goto L11;
        String r105 = (String) r104;
    L12:
        h r106 = new h(r105, r101);
        a r107 = new a(r102, r106, r100);
        f r108 = r102.b();
        if (r108 == null) goto L18;
        r108.j(r106, new c(r102, r106, r107));
        return;
    L18:
        return;
    L11:
        r105 = r100;
        goto L12
    L17:
        return;
    }
}
