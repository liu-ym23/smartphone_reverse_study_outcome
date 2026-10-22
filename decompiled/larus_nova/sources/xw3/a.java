package xw3;

import com.bytedance.applog.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, CopyOnWriteArraySet<i>> f565222a;

    public a() {
        this.f565222a = new ConcurrentHashMap();
    }

    public final boolean b(int r100) {
        return !((ConcurrentHashMap) this.f565222a).containsKey(Integer.valueOf(r100));
    }

    public final void a(int r100, i r101) {
        if (b(r100) == false) goto L5;
        Map<Integer, CopyOnWriteArraySet<i>> r102 = this.f565222a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(Integer.valueOf(r100), new CopyOnWriteArraySet());
    L5:
        if (r101 == null) goto L10;
        Map<Integer, CopyOnWriteArraySet<i>> r104 = this.f565222a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        CopyOnWriteArraySet r106 = (CopyOnWriteArraySet) r105.get(Integer.valueOf(r100));
        if (r106 == null) goto L11;
        r106.add(r101);
        return;
    L11:
        return;
    }

    public final void d(int r100, String r101, String r102) {
        if (b(r100) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r103 = this.f565222a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) r104.get(Integer.valueOf(r100));
        if (r105 != null) goto L8;
        return;
    L8:
        Iterator r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        ((i) r106.next()).onEventV3(r101, r102);
        goto L10
    }

    public final void e(int r100, String r101, String r102) {
        if (b(r100) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r103 = this.f565222a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) r104.get(Integer.valueOf(r100));
        if (r105 != null) goto L8;
        return;
    L8:
        Iterator r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        ((i) r106.next()).b(r101);
        goto L10
    }

    public final void c(int r110, String r111, String r112, String r113, long r114, long r115, String r210) {
        if (b(r110) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r100 = this.f565222a;
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        CopyOnWriteArraySet r102 = (CopyOnWriteArraySet) r101.get(Integer.valueOf(r110));
        if (r102 != null) goto L8;
        return;
    L8:
        Iterator r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        ((i) r103.next()).a(r111, r112, r113, r114, r115, r210);
        goto L10
    }
}
