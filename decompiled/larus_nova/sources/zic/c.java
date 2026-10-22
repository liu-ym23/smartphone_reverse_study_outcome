package zic;

import android.content.Context;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements yic.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<TreeSet<yic.a>> f572360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<TreeSet<yic.a>> f572361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<yic.a> f572362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TreeSet<yic.a> f572363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f572364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<Object>, Object> f572365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f572366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f572367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f572368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f572369j;

    public interface a {
        void a();

        Context getContext();

        p getVideoStateInquirer();
    }

    @Override // yic.b
    public final boolean a() {
        a r100 = this.f572364e;
        if (r100 == null) goto L7;
        r100.a();
        return false;
    L7:
        return false;
    }

    @Override // yic.b
    public Context getContext() {
        a r100 = this.f572364e;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    public c() {
        this.f572360a = new SparseArray();
        this.f572361b = new SparseArray();
        this.f572362c = new SparseArray();
        new SparseArray();
        this.f572363d = new TreeSet();
        this.f572365f = new HashMap();
        this.f572366g = false;
        this.f572367h = false;
        this.f572368i = new LinkedHashSet();
        this.f572369j = false;
    }

    public final boolean b(uic.d r100) {
        if (r100 != null) goto L5;
    L103:
        return false;
    L5:
        if (this.f572360a == null) goto L103;
        if (this.f572368i.isEmpty() == true) goto L10;
    L17:
        this.f572368i.add(Integer.valueOf(r100.getType()));
        if (this.f572366g == false) goto L54;
        TreeSet<yic.a> r101 = this.f572361b.get(r100.getType());
        if (r101 == null) goto L39;
        if (r101.isEmpty() == true) goto L39;
        TreeSet r102 = new TreeSet();
        Iterator<yic.a> r103 = r101.iterator();
    L25:
        if (r103.hasNext() == false) goto L29;
        yic.a r104 = r103.next();
        if (r104 == null) goto L25;
        r102.add(r104);
        goto L25
    L29:
        Iterator r105 = r102.iterator();
    L31:
        if (r105.hasNext() == false) goto L39;
        yic.a r106 = (yic.a) r105.next();
        if (r106.a() == true) goto L31;
        r106.b(true);
        Collections.singletonList(Integer.valueOf(r100.getType()));
        a r107 = this.f572364e;
        if (r107 == null) goto L37;
        r107.getVideoStateInquirer();
    L37:
        r106.d();
    L39:
        if (this.f572369j == true) goto L54;
        if (this.f572367h == false) goto L54;
        Iterator<yic.a> r108 = this.f572363d.iterator();
    L44:
        if (r108.hasNext() == false) goto L53;
        yic.a r109 = r108.next();
        if (r109 == null) goto L44;
        r109.i();
        if (r109.a() == true) goto L44;
        r109.b(true);
        Collections.singletonList(Integer.valueOf(r100.getType()));
        a r110 = this.f572364e;
        if (r110 == null) goto L52;
        r110.getVideoStateInquirer();
    L52:
        r109.d();
        goto L44
    L53:
        this.f572369j = true;
    L54:
        TreeSet<yic.a> r111 = this.f572360a.get(r100.getType());
        if (r111 == null) goto L91;
        if (r111.isEmpty() == true) goto L91;
        TreeSet r112 = new TreeSet();
        Iterator<yic.a> r113 = r111.iterator();
    L60:
        if (r113.hasNext() == false) goto L64;
        yic.a r114 = r113.next();
        if (r114 == null) goto L60;
        r112.add(r114);
        goto L60
    L64:
        Iterator r115 = r112.iterator();
    L66:
        if (r115.hasNext() == false) goto L91;
        yic.a r116 = (yic.a) r115.next();
        if ((r116 instanceof d) == true) goto L69;
        if (this.f572366g == true) goto L73;
    L76:
        boolean r117 = true;
    L77:
        if (r117 == false) goto L82;
        if ((r116 instanceof zic.a) == false) goto L82;
        ((zic.a) r116).g(r100);
    L82:
        if (this.f572366g == true) goto L84;
    L87:
        boolean r118 = true;
    L88:
        if (r118 == false) goto L66;
        r116.c();
        goto L66
    L84:
        if (r116.a() == true) goto L87;
        r118 = false;
        goto L88
    L73:
        if (r116.a() == true) goto L76;
        r117 = false;
        goto L77
    L69:
        ((d) r116).g(r100);
    L91:
        if (r100.getType() != 101) goto L103;
        this.f572368i.clear();
        if (this.f572366g == false) goto L103;
        if (this.f572367h == false) goto L103;
        Iterator<yic.a> r119 = this.f572363d.iterator();
    L98:
        if (r119.hasNext() == false) goto L102;
        yic.a r120 = r119.next();
        if (r120 == null) goto L98;
        r120.b(false);
        goto L98
    L102:
        this.f572369j = false;
        goto L103
    L10:
        if (this.f572366g == true) goto L17;
        Iterator<yic.a> r121 = this.f572363d.iterator();
    L13:
        if (r121.hasNext() == false) goto L17;
        yic.a r122 = r121.next();
        if (r122.a() == true) goto L13;
        r122.b(true);
        goto L13
    }
}
