package u47;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f548700a;

    public /* synthetic */ a(c.a r100) {
        this.f548700a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a r100 = this.f548700a;
        if (r100.f548706d.compareAndSet(false, true) == false) goto L33;
        Set<Map.Entry<String, ?>> r101 = r100.f548704b.getAll().entrySet();
        int r102 = (int) (((double) r100.f548705c) * 0.25d);
        PriorityQueue r103 = new PriorityQueue(r102, new b());
        c.a.b r104 = new c.a.b();
        Iterator<Map.Entry<String, ?>> r105 = r101.iterator();
    L7:
        if (r105.hasNext() == false) goto L16;
        r104.f548708a = r105.next();
        if (r103.size() < r102) goto L10;
        Map.Entry r106 = (Map.Entry) r103.peek();
        if (r106 == null) goto L7;
        if (((Long) r106.getValue()).longValue() <= r104.a().longValue()) goto L7;
        r103.poll();
        r103.offer(r104);
        goto L7
    L10:
        r103.offer(r104);
        goto L7
    L16:
        Iterator r107 = r103.iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        Map.Entry r108 = (Map.Entry) r107.next();
        r100.f548703a.erase((String) r108.getKey());
        r100.f548704b.erase((String) r108.getKey());
        goto L18
    L20:
        r100.f548706d.set(false);
        return;
    }
}
