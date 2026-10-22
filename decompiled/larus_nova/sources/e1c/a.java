package e1c;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements o1c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<o1c.c<?, ?>>, Set<Object>> f470759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<o1c.c<?, ?>>, Set<Object>> f470760b;

    public a() {
        this.f470759a = new HashMap();
        this.f470760b = new HashMap();
    }

    @Override // o1c.b
    public final void b(o1c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r101 = this.f470759a;
        HashMap r102 = (HashMap) r101;
        r102.remove(r100.getClass());
        Map<Class<o1c.c<?, ?>>, Set<Object>> r103 = this.f470760b;
        HashMap r104 = (HashMap) r103;
        r104.remove(r100.getClass());
    }

    @Override // o1c.b
    public final void a(o1c.c r100, Collection r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "cache");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r102 = this.f470759a;
        HashMap r103 = (HashMap) r102;
        if (r103.get(r100.getClass()) != null) goto L5;
        Map<Class<o1c.c<?, ?>>, Set<Object>> r104 = this.f470759a;
        HashMap r105 = (HashMap) r104;
        r105.put(r100.getClass(), new HashSet());
    L5:
        Map<Class<o1c.c<?, ?>>, Set<Object>> r106 = this.f470759a;
        HashMap r107 = (HashMap) r106;
        Set r108 = (Set) r107.get(r100.getClass());
        if (r108 == null) goto L9;
        r108.addAll(r101);
        return;
    }

    @Override // o1c.b
    public final boolean c(o1c.c<?, ?> r100, Collection<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "cache");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r102 = this.f470760b;
        HashMap r103 = (HashMap) r102;
        if (r103.get(r100.getClass()) != null) goto L5;
        Map<Class<o1c.c<?, ?>>, Set<Object>> r104 = this.f470760b;
        HashMap r105 = (HashMap) r104;
        r105.put(r100.getClass(), new HashSet());
    L5:
        Iterator<T> r106 = r101.iterator();
    L6:
        boolean r107 = false;
        if (r106.hasNext() == false) goto L15;
        Object r108 = r106.next();
        Map<Class<o1c.c<?, ?>>, Set<Object>> r109 = this.f470760b;
        HashMap r110 = (HashMap) r109;
        Set r111 = (Set) r110.get(r100.getClass());
        if (r111 == null) goto L13;
        if (r111.contains(r108) != true) goto L13;
        r107 = true;
    L13:
        if (r107 == false) goto L6;
        r107 = true;
    L15:
        Map<Class<o1c.c<?, ?>>, Set<Object>> r112 = this.f470760b;
        HashMap r113 = (HashMap) r112;
        Set r114 = (Set) r113.get(r100.getClass());
        if (r114 == null) goto L18;
        r114.addAll(r101);
    L18:
        return r107;
    }

    @Override // o1c.b
    public final boolean d(o1c.c<?, ?> r100, Collection<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "cache");
        Iterator<T> r102 = r101.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L12;
        Object r104 = r102.next();
        Map<Class<o1c.c<?, ?>>, Set<Object>> r105 = this.f470759a;
        HashMap r106 = (HashMap) r105;
        Set r107 = (Set) r106.get(r100.getClass());
        if (r107 == null) goto L10;
        if (r107.contains(r104) != true) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L3;
        return true;
    L12:
        return false;
    }
}
