package zw3;

import android.util.EventsUtils;
import com.bytedance.applog.b;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final List<String> e = null;
    public final LinkedList<jx3.a> a;
    public final LinkedList<String> b;
    public volatile int c;
    public final b d;

    static {
        e = Collections.singletonList("AppLogCache");
    }

    public a(b r2) {
        this.a = new LinkedList();
        this.b = new LinkedList();
        this.c = EventsUtils.FEAT_TYPE_SHUT_DOWN;
        this.d = r2;
    }

    public final void a(jx3.a r8) {
        LinkedList<jx3.a> r0 = this.a;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.a.size() <= this.c) goto L12;
        jx3.a r1 = this.a.poll();     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        if (r1.s <= 0) goto L11;
        ax3.b.c(this.d.W, EventStage.CACHE_DROP_BEFORE_HANDLE, r8);     // Catch: Throwable -> L15
    L11:
        this.d.W.b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L15
        this.d.W.h("cache drop event", new Throwable(r1.toString()), false);     // Catch: Throwable -> L15
        this.d.t0.f(0, e, "AppLogCache overflow remove data: {}", new Object[]{r1});     // Catch: Throwable -> L15
        int r2 = bx3.a.a;     // Catch: Throwable -> L15
    L12:
        this.a.add(r8);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public final int b(ArrayList<jx3.a> r6) {
        LinkedList<jx3.a> r0 = this.a;
        monitor-enter(r0);
        int r1 = this.a.size();     // Catch: Throwable -> L13
        r6.addAll(this.a);     // Catch: Throwable -> L13
        Iterator<jx3.a> r7 = this.a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r7.hasNext() == false) goto L10;
        jx3.a r2 = r7.next();     // Catch: Throwable -> L13
        if (r2.s <= 0) goto L6;
        ax3.b.c(this.d.W, EventStage.DATA_LIST_ADDED, r2);     // Catch: Throwable -> L13
        goto L6
    L10:
        this.a.clear();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    }
}
