package da7;

import ca7.l;
import ga7.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f467697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f467698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f467699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f467700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TreeSet<l> f467701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f467702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ca7.c f467703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<ca7.c, c> f467704h;

    public final c a(ca7.c r100) {
        c r101 = this.f467704h.get(r100);
        if (r101 != null) goto L8;
        r101 = new c();
        if ((r100 instanceof ca7.b) == false) goto L7;
        HashSet<ca7.c> r102 = new HashSet();
        r101.f467707c = r102;
        r102.addAll(((ca7.b) r100).f22955c);
    L7:
        this.f467704h.put(r100, r101);
    L8:
        return r101;
    }

    public b(Map<String, Object> r100, d r101, boolean r102) {
        this.f467699c = Integer.MIN_VALUE;
        this.f467700d = false;
        this.f467701e = new TreeSet(new a());
        this.f467704h = new HashMap();
        this.f467697a = r100;
        this.f467698b = r102;
        this.f467702f = r101;
    }
}
