package hz5;

import com.bytedance.helios.api.consumer.EventHandler;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f487690b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Vector<List<EventHandler>> f487691a;

    static {
        f487690b = new g();
    }

    public g() {
        Vector<List<EventHandler>> r100 = new Vector();
        this.f487691a = r100;
        r100.setSize(6);
    }

    public final void a(int r100, PrivacyEvent r101) {
        List<EventHandler> r102 = this.f487691a.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() <= 0) goto L12;
        Iterator<EventHandler> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        r103.next().a(r101);
        goto L8
    L13:
        return;
    }

    public final void b(EventHandler r100, boolean r101) {
        monitor-enter(this);
        int r102 = r100.stage();     // Catch: Throwable -> L13
        k.d("EventHandler", "registerEventHandler: " + r100.stage() + "->" + r100);     // Catch: Throwable -> L13
        List<EventHandler> r103 = this.f487691a.get(r102);     // Catch: Throwable -> L13
        if (r103 != null) goto L7;
        r103 = new CopyOnWriteArrayList();     // Catch: Throwable -> L13
    L7:
        if (r101 == false) goto L9;
        r103.add(0, r100);     // Catch: Throwable -> L13
    L10:
        this.f487691a.set(r102, r103);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        r103.add(r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
