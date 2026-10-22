package xw3;

import com.bytedance.applog.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, CopyOnWriteArraySet<j>> f565223a;

    public b() {
        this.f565223a = new ConcurrentHashMap();
    }

    public final boolean b(int r100) {
        return !((ConcurrentHashMap) this.f565223a).containsKey(Integer.valueOf(r100));
    }

    public final void a(int r100, j r101) {
        if (b(r100) == false) goto L5;
        Map<Integer, CopyOnWriteArraySet<j>> r102 = this.f565223a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(Integer.valueOf(r100), new CopyOnWriteArraySet());
    L5:
        if (r101 == null) goto L10;
        Map<Integer, CopyOnWriteArraySet<j>> r104 = this.f565223a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        CopyOnWriteArraySet r106 = (CopyOnWriteArraySet) r105.get(Integer.valueOf(r100));
        if (r106 == null) goto L11;
        r106.add(r101);
        return;
    L11:
        return;
    }

    public final void c(int r100, String r101, String r102, JSONObject r103) {
        if (b(r100) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<j>> r104 = this.f565223a;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        CopyOnWriteArraySet r106 = (CopyOnWriteArraySet) r105.get(Integer.valueOf(r100));
        if (r106 != null) goto L8;
        return;
    L8:
        Iterator r107 = r106.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        ((j) r107.next()).a();
        goto L10
    }
}
