package fh4;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<com.bytedance.crash.monitor.f, ConcurrentLinkedQueue<j>> f477041d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<com.bytedance.crash.monitor.f, ConcurrentLinkedQueue<j>> f477042e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArrayList<i> f477043f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f477044g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f477045h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f477046i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f477047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<j> f477048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<j> f477049c;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f477050b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f477051a;

        public final void a() {
            JSONArray r100 = new JSONArray();     // Catch: Throwable -> L29
            int r101 = Process.myPid();     // Catch: Throwable -> L29
            long r102 = System.currentTimeMillis();     // Catch: Throwable -> L29
            Iterator<com.bytedance.crash.monitor.f> r103 = i.f477041d.keySet().iterator();     // Catch: Throwable -> L29
            String r110 = "0";
            int r104 = 0;
            boolean r105 = false;
        L7:
            if (r103.hasNext() == false) goto L23;
            com.bytedance.crash.monitor.f r111 = r103.next();     // Catch: Throwable -> L29
            ConcurrentLinkedQueue<j> r112 = i.f477041d.get(r111);     // Catch: Throwable -> L29
            if (r112 == null) goto L7;
            JSONArray r113 = new JSONArray();     // Catch: Throwable -> L29
        L13:
            if (r112.isEmpty() == true) goto L18;
            r113.put(r112.poll().a());     // Catch: Throwable -> L29
            i.f477044g.decrementAndGet();     // Catch: Throwable -> L29
            r104 = r104 + 1;     // Catch: Throwable -> L29
            if (r104 <= 100) goto L13;
            r105 = true;
        L18:
            if (r113.length() == 0) goto L7;
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L29
            r110 = r111.d("0");     // Catch: Throwable -> L29
            r106.put("data", r113);     // Catch: Throwable -> L29
            JSONObject r114 = Header.b(r111, r102, CrashType.ENSURE, r101).f203195a;     // Catch: Throwable -> L29
            r114.put("from", "npth");     // Catch: Throwable -> L29
            r106.put("header", r114);     // Catch: Throwable -> L29
            r100.put(r106);     // Catch: Throwable -> L29
            if (r105 == false) goto L7;
        L23:
            if (r100.length() != 0) goto L25;
            boolean r107 = true;
        L26:
            if (r107 == true) goto L31;
            String r108 = zg4.g.f572072l.f572079g;     // Catch: Throwable -> L29
            HashMap r109 = new HashMap();     // Catch: Throwable -> L29
            r109.put("device_id", r110);     // Catch: Throwable -> L29
            r109.put("os", "Android");     // Catch: Throwable -> L29
            r109.put("sdk_version", zg4.h.f572084a);     // Catch: Throwable -> L29
            r109.put("from", "npth");     // Catch: Throwable -> L29
            String r115 = n.c(r108, r109);     // Catch: Throwable -> L29
            JSONObject r116 = new JSONObject();     // Catch: Throwable -> L29
            r116.put("list", r100);     // Catch: Throwable -> L29
            CrashUploader.h(r115, r116);     // Catch: Throwable -> L29
        L31:
            if (i.f477044g.get() <= 0) goto L33;
        L36:
            wh4.b.postDelayed(this, 30000);
            i.f477046i = true;
            return;
        L33:
            if (i.f477045h.get() > 0) goto L36;
            i.f477046i = false;
            return;
        L25:
            r107 = false;
        L29:
            boolean r117 = zg4.i.f572087c;
            goto L31
        }

        static {
            f477050b = new a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    static {
        f477041d = new ConcurrentHashMap();
        f477042e = new ConcurrentHashMap();
        f477043f = new CopyOnWriteArrayList();
        f477044g = new AtomicInteger(0);
        f477045h = new AtomicInteger(0);
        f477046i = false;
    }

    public i(com.bytedance.crash.monitor.f r100) {
        ConcurrentLinkedQueue<j> r101 = new ConcurrentLinkedQueue();
        this.f477048b = r101;
        f477041d.put(r100, r101);
        this.f477049c = new ConcurrentLinkedQueue();
        f477042e.put(r100, r101);
        f477043f.add(this);
        a r102 = a.f477050b;
        if (r102.f477051a == true) goto L7;
        r102.f477051a = true;
        f477046i = true;
        wh4.b.f(r102);
        wh4.b.postDelayed(r102, 30000);
        return;
    }
}
