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

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ug2.a f567483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Map<String, LinkedList<xg2.c>> f567484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map<String, String> f567485c;

    /* JADX INFO: renamed from: yg2.a$a, reason: collision with other inner class name */
    public static final class C8339a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile ExecutorService f567486a;

        static {
            f567486a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ActionRecordServiceImpl$SingleExecutor"));
        }

        public static ExecutorService a() {
            if (f567486a.isShutdown() == false) goto L6;
            f567486a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ActionRecordServiceImpl$SingleExecutor"));
        L6:
            return f567486a;
        }
    }

    public a() {
        this.f567483a = new ug2.a();
        this.f567484b = new ConcurrentHashMap();
        this.f567485c = new ConcurrentHashMap();
    }

    public final void a(xg2.c r100) {
        String r101 = r100.f563597b.toString();
        String r102 = (String) ((ConcurrentHashMap) this.f567485c).get(r101);
        ((ConcurrentHashMap) this.f567485c).remove(r101);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L14;
        LinkedList r104 = (LinkedList) ((ConcurrentHashMap) this.f567484b).get(r102);
        if (r104 == null) goto L15;
        r104.clear();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final String c(xg2.c r100) {
        String r101 = (String) ((ConcurrentHashMap) this.f567485c).get(r100.f563597b.toString());
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        dm.a.a("ActionRecordServiceImpl").w("ActionUUID is Empty, Node is: " + r100, null);
        return null;
    L13:
        LinkedList r104 = (LinkedList) ((ConcurrentHashMap) this.f567484b).get(r101);
        if (r104 != null) goto L16;
    L19:
        if (r102 == false) goto L22;
        dm.a.a("ActionRecordServiceImpl").w("LinkedList is Empty, Node is: " + r100, null);
        return null;
    L22:
        return r101;
    L16:
        if (r104.isEmpty() == true) goto L19;
        r102 = false;
        goto L19
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final void d(xg2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (EComABUtils.isArsEnable() == true) goto L6;
        return;
    L6:
        if ((r100 instanceof xg2.d) == false) goto L13;
        xg2.d r101 = (xg2.d) r100;
        C8339a.a().submit(new c(this, r101));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("sendSingleNode:", e);
        return;
    L13:
        if ((r100 instanceof xg2.e) == false) goto L20;
        xg2.e r102 = (xg2.e) r100;
        String r103 = UUID.randomUUID().toString();
        C8339a.a().submit(new e(this, r102, r103));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchStartNode:", e);
        return;
    L20:
        if ((r100 instanceof xg2.b) == false) goto L27;
        xg2.b r104 = (xg2.b) r100;
        C8339a.a().submit(new b(this, r104));     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("addInfoNode: ", e);
        return;
    L27:
        if ((r100 instanceof xg2.a) == false) goto L34;
        xg2.a r105 = (xg2.a) r100;
        C8339a.a().submit(new d(this, r105));     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchFailureNode: ", e);
        return;
    L34:
        if ((r100 instanceof xg2.f) == false) goto L40;
        xg2.f r106 = (xg2.f) r100;
        C8339a.a().submit(new f(this, r106));     // Catch: Exception -> L38
        return;
    L38:
        e = move-exception;
        dm.a.a("ActionRecordServiceImpl").b("storeDispatchSuccessNode: ", e);
        return;
    L40:
        dm.a.a("ActionRecordServiceImpl").i("code is not correct");
    }

    public final void b(xg2.c r100, EventType r101, String r102, String r103) {
        int r104 = g.f567498a;
        LinkedList r105 = (LinkedList) ((ConcurrentHashMap) this.f567484b).get(r103);
        LinkedHashMap r106 = new LinkedHashMap();
        if (r105 == null) goto L15;
        Iterator r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L15;
        xg2.c r108 = (xg2.c) r107.next();
        if ((r108 instanceof xg2.b) == true) goto L10;
        r108 = null;
    L10:
        xg2.b r109 = (xg2.b) r108;
        if (r109 == null) goto L6;
        Map<String, String> r110 = r109.f563595d;
        if (r110 == null) goto L6;
        r106.putAll(r110);
    L15:
        vg2.a r111 = g.a(r100, r101, r102, r106);
        this.f567483a.a(r111);
    }
}
