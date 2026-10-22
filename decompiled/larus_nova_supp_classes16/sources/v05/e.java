package v05;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.BitableSubtype;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocumentFragment;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final Map<String, Queue<View>> a = null;
    public static final Queue<a> b = null;
    public static volatile boolean c;

    public static class a {
        public final Context a;
        public final String b;

        public a(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public e() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new LinkedBlockingDeque();
        c = false;
    }

    public static void g() {
        Queue<a> r0 = b;
        if (((LinkedBlockingDeque) r0).size() == 0) goto L5;
        c = true;
        final a r1 = (a) ((LinkedBlockingDeque) r0).poll();
        Flowable.timer(3, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new b(r1), new c(), new d());
        return;
    L5:
        c = false;
    }

    public static int b(String r1) {
        Queue r2 = (Queue) ((ConcurrentHashMap) a).get(r1);
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L7:
        return Math.max(0, 2 - r3);
    L5:
        r3 = 0;
        goto L7
    }

    public static synchronized void d(Context r4) {
        monitor-enter(e.class);
        tt5.a.h("DocumentViewCache", "prepareViewCache");     // Catch: Throwable -> L22
        if (r4 != null) goto L8;
        monitor-exit(e.class);
        return;
    L8:
        Iterator r1 = ((ConcurrentHashMap) f.a).entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r1.hasNext() == false) goto L20;
        String r2 = (String) ((Map.Entry) r1.next()).getKey();     // Catch: Throwable -> L22
        DocOpenConfig.a();     // Catch: Throwable -> L22
        if (DocOpenConfig.g.preload_view_cache == true) goto L14;
        f(r4, r2);     // Catch: Throwable -> L22
        goto L9
    L14:
        if (TextUtils.equals(r2, sbb.e.g.getType()) == true) goto L17;
        if (TextUtils.equals(r2, sbb.e.h.getType()) == false) goto L9;
    L17:
        f(r4, r2);     // Catch: Throwable -> L22
        goto L9
    L20:
        monitor-exit(e.class);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static String c(String r1, String r2) {
        if (TextUtils.equals(r1, sbb.e.i.getType()) == true) goto L5;
        return r1;
    L5:
        if (TextUtils.equals(r2, BitableSubtype.APP.getTypeName()) == false) goto L9;
        return "bitable_app";
    L9:
        return ((v05.a) ((ConcurrentHashMap) f.a).get(r1)).a(r1);
    }

    public static void f(Context r2, String r3) {
        tt5.a.h("DocumentViewCache", "DocumentViewCache  reCreate : " + r3);
        ((LinkedBlockingDeque) b).offer(new a(r2, r3));
        if (c == true) goto L6;
        g();
        return;
    }

    public static void e(String r3, String r4, View r5) {
        String r6 = c(r3, r4);
        Map<String, Queue<View>> r7 = a;
        Queue r0 = (Queue) ((ConcurrentHashMap) r7).get(r6);
        if (r0 != null) goto L15;
        monitor-enter(e.class);
        r0 = (Queue) ((ConcurrentHashMap) r7).get(r6);     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new LinkedBlockingDeque(2);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r7).put(r6, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        if (r0.contains(r5) == true) goto L20;
        r0.offer(r5);
        return;
    }

    public static void a(int r5, Context r6, String r7, String r8) {
    L2:
        int r0 = r5 - 1;
        if (r5 <= 0) goto L11;
        sbb.e r9 = sbb.e.i;
        if (TextUtils.equals(r7, r9.getType()) == false) goto L9;
        BitableSubtype r1 = BitableSubtype.APP;
        if (TextUtils.equals(r8, r1.getTypeName()) == false) goto L9;
        Class<? extends DocumentFragment> r3 = ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).a();
        ((com.bytedance.ee.bear.document.bitable.f) org.koin.java.a.a(com.bytedance.ee.bear.document.bitable.f.class)).c();
        e(r9.getType(), r1.getTypeName(), f.a(r6, new FrameLayout(r6), new v05.a(r3, 2131558805)));
    L10:
        r5 = r0;
    L9:
        e(r7, null, f.a(r6, new FrameLayout(r6), (v05.a) ((ConcurrentHashMap) f.a).get(r7)));
        goto L10
    }
}
