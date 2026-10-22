package oq7;

import iq7.g;
import iq7.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f524889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pq7.b f524890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<c> f524891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Class, WeakReference<c>> f524892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<Class<? extends iq7.a>, g.c> f524893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, TreeMap<Integer, com.bytedance.webx.event.a>> f524894f;

    static {
        new WeakReference(null);
    }

    public final void a(LinkedHashSet<Class<? extends iq7.a>> r100) {
        if (r100 == null) goto L11;
        Iterator<Class<? extends iq7.a>> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L11;
        Class<? extends iq7.a> r102 = r101.next();
        iq7.a r103 = (iq7.a) wq7.b.b(r102);
        if (r103 == null) goto L10;
        b(r102, r103);
        goto L5
    L10:
        throw new Error("extension init fail: " + r102);
    L11:
        Iterator r104 = new ArrayList(this.f524891c).iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        c r105 = (c) r104.next();
        if ((r105 instanceof iq7.a) == false) goto L13;
        h.a((iq7.a) r105);
        goto L13
    }

    public a(g r100, pq7.b r101) {
        ArrayList<c> r102 = new ArrayList();
        this.f524891c = r102;
        this.f524892d = new HashMap();
        this.f524889a = r100;
        this.f524890b = r101;
        if ((r101 instanceof c) == false) goto L7;
        r102.add((c) r101);
        return;
    L7:
        throw new Error("! extendable instanceof IContextItem");
    }

    public final void b(Class<? extends iq7.a> r100, iq7.a r101) {
        LinkedHashSet<g.c> r102 = this.f524889a.f495398d;
        if (r102 == null) goto L8;
        Iterator<g.c> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r103.next().a();
    L8:
        HashMap<Class<? extends iq7.a>, LinkedHashSet<g.c>> r104 = this.f524889a.f495399e;
        if (r104 == null) goto L16;
        LinkedHashSet<g.c> r105 = r104.get(r100);
        if (r105 == null) goto L16;
        Iterator<g.c> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r106.next().a();
    L16:
        HashMap<Class<? extends iq7.a>, g.c> r107 = this.f524893e;
        if (r107 == null) goto L21;
        g.c r108 = r107.get(r100);
        if (r108 == null) goto L21;
        r108.a();
    L21:
        this.f524891c.add(r101);
        this.f524892d.put(r100, new WeakReference(r101));
        r101.f495385a = this;
    }
}
