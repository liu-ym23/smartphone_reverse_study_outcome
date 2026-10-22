package v0c;

import com.ss.android.lark.player.widget.SuperContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class s implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, o> f552371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o> f552372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<p.b> f552373c;

    public s() {
        this.f552371a = new ConcurrentHashMap(8);
        this.f552372b = Collections.synchronizedList(new ArrayList());
        this.f552373c = new CopyOnWriteArrayList();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new CopyOnWriteArrayList();
    }

    @Override // v0c.p
    public final void a(SuperContainer.b r100) {
        if (((CopyOnWriteArrayList) this.f552373c).contains(r100) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArrayList) this.f552373c).add(r100);
    }

    @Override // v0c.p
    public final void c(SuperContainer.b r100) {
        ((CopyOnWriteArrayList) this.f552373c).remove(r100);
    }

    @Override // v0c.p
    public final void d(p.a r100) {
        b(null, r100);
    }

    @Override // v0c.p
    public final void b(g.a r100, p.a r101) {
        Iterator<o> r102 = this.f552372b.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        o r103 = r102.next();
        if (r100 == null) goto L9;
        if ((r103 instanceof y0c.b) == false) goto L4;
    L9:
        r101.a(r103);
        goto L4
    }

    public final void e(String r100, a r101) {
        r101.getClass();
        r101.getClass();
        r101.g();
        ((ConcurrentHashMap) this.f552371a).put(r100, r101);
        this.f552372b.add(r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f552373c).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((p.b) r102.next()).a(r101);
        goto L4
    }
}
