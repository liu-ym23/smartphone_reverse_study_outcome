package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final ug2.a a;
    public volatile Map<String, LinkedList<xg2.c>> b;
    public volatile Map<String, String> c;

    /* JADX INFO: renamed from: yg2.a$a, reason: collision with other inner class name */
    public static final class C0191a {
        public static volatile ExecutorService a;

        static {
            a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ActionRecordServiceImpl$SingleExecutor"));
        }

        public static ExecutorService a() {
            if (a.isShutdown() == false) goto L6;
            a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ActionRecordServiceImpl$SingleExecutor"));
        L6:
            return a;
        }
    }

    public a() {
        this.a = new ug2.a();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public final void a(xg2.c r3) {
        String r4 = r3.b.toString();
        String r0 = (String) ((ConcurrentHashMap) this.c).get(r4);
        ((ConcurrentHashMap) this.c).remove(r4);
        if (r0 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L14;
        LinkedList r6 = (LinkedList) ((ConcurrentHashMap) this.b).get(r0);
        if (r6 == null) goto L15;
        r6.clear();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final String c(xg2.c r7) {
        String r0 = (String) ((ConcurrentHashMap) this.c).get(r7.b.toString());
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        dm.a.a("ActionRecordServiceImpl").w("ActionUUID is Empty, Node is: " + r7, null);
        return null;
    L13:
        LinkedList r4 = (LinkedList) ((ConcurrentHashMap) this.b).get(r0);
        if (r4 != null) goto L16;
    L19:
        if (r1 == false) goto L22;
        dm.a.a("ActionRecordServiceImpl").w("LinkedList is Empty, Node is: " + r7, null);
        return null;
    L22:
        return r0;
    L16:
        if (r4.isEmpty() == true) goto L19;
        r1 = false;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public final void d(xg2.c r5) {
        Intrinsics.checkNotNullParameter(r5, "node");
        if (EComABUtils.isArsEnable() == true) goto L6;
        return;
    L6:
        if ((r5 instanceof xg2.d) == false) goto L13;
        xg2.d r6 = (xg2.d) r5;
        C0191a.a().submit(new c(this, r6));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("sendSingleNode:", e);
        return;
    L13:
        if ((r5 instanceof xg2.e) == false) goto L20;
        xg2.e r7 = (xg2.e) r5;
        String r0 = UUID.randomUUID().toString();
        C0191a.a().submit(new e(this, r7, r0));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchStartNode:", e);
        return;
    L20:
        if ((r5 instanceof xg2.b) == false) goto L27;
        xg2.b r8 = (xg2.b) r5;
        C0191a.a().submit(new b(this, r8));     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("addInfoNode: ", e);
        return;
    L27:
        if ((r5 instanceof xg2.a) == false) goto L34;
        xg2.a r9 = (xg2.a) r5;
        C0191a.a().submit(new d(this, r9));     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchFailureNode: ", e);
        return;
    L34:
        if ((r5 instanceof xg2.f) == false) goto L40;
        xg2.f r10 = (xg2.f) r5;
        C0191a.a().submit(new f(this, r10));     // Catch: Exception -> L38
        return;
    L38:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchSuccessNode: ", e);
        return;
    L40:
        dm.a.a("ActionRecordServiceImpl").i("code is not correct");
    }

    public final void b(xg2.c r4, EventType r5, String r6, String r7) {
        int r0 = g.a;
        LinkedList r8 = (LinkedList) ((ConcurrentHashMap) this.b).get(r7);
        LinkedHashMap r1 = new LinkedHashMap();
        if (r8 == null) goto L15;
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L15;
        xg2.c r2 = (xg2.c) r9.next();
        if ((r2 instanceof xg2.b) == true) goto L10;
        r2 = null;
    L10:
        xg2.b r3 = (xg2.b) r2;
        if (r3 == null) goto L6;
        Map<String, String> r10 = r3.d;
        if (r10 == null) goto L6;
        r1.putAll(r10);
    L15:
        vg2.a r11 = g.a(r4, r5, r6, r1);
        this.a.a(r11);
    }
}
