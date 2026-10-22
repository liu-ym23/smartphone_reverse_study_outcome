package ho5;

import android.app.Application;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static String a = "";
    public static ml5.a b;
    public static final LruCache<String, String> c = null;
    public static final List<String> d = null;
    public static int e;
    public static String f;
    public static final HashMap<String, Boolean> g = null;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    static {
        c = new LruCache(200);
        d = new CopyOnWriteArrayList();
        f = Locale.ENGLISH.getLanguage();
        g = new HashMap();
        new HashMap();
    }

    public static c d() {
        if (b != null) goto L7;
        a("");
    L7:
        return a.a;
    }

    public c() {
        String r0 = ((b0) org.koin.java.a.a(b0.class)).getUid();
        if (b != null) goto L6;
        a(r0);
    L6:
        final i0 r1 = (i0) org.koin.java.a.a(i0.class);
        f = r1.a();
        m.a(new ho5.a(r1));
    }

    public static void a(String r2) {
        int r0 = woc.a.a;
        Application r1 = LarkContext.getApplication();
        Intrinsics.checkNotNullParameter(r1, "app");
        com.ss.android.lark.storage.kv.storage.a r3 = LarkKVStorage.e(r1, "lark");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        a = r2;
        b = new ml5.a(du5.b.g(r2), r3);
        return;
    L5:
        b = new ml5.a("etag_cache", r3);
    }

    public final synchronized String b(String r3, String r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (b == null) goto L15;
        if (TextUtils.isEmpty(r3) == true) goto L9;
        String r5 = e(r3, r4);     // Catch: Throwable -> L16
        tt5.a.b("ETagCache", "getETagFromDiskCache, new Key:" + r5);     // Catch: Throwable -> L16
        String r6 = du5.b.d((String) b.a(du5.b.e(r5), ""));     // Catch: Throwable -> L16
        monitor-exit(this);
        return r6;
    L9:
        monitor-exit(this);
        return "";
    L15:
        throw new RuntimeException("you must call init first");     // Catch: Throwable -> L16
    }

    public final synchronized String c(String r3, String r4) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L7;
        String r5 = e(r3, r4);     // Catch: Throwable -> L12
        tt5.a.b("ETagCache", "getETagFromMemoryCache, new Key:" + r5);     // Catch: Throwable -> L12
        String r6 = c.get(r5);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r6;
    L7:
        monitor-exit(this);
        return "";
    }

    public final synchronized String e(String r3, String r4) {
        monitor-enter(this);
        String r5 = UriProtector.parse(r3).buildUpon().clearQuery().toString();     // Catch: Throwable -> L9
        String r0 = UriProtector.parse(r5).getHost();     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r5 = r5.replace(r0, "");     // Catch: Throwable -> L9
    L6:
        String r6 = r5 + "_" + f + "_" + r4;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r6;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(String r3, String r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        String r5 = e(r3, r4);     // Catch: Throwable -> L11
        tt5.a.b("ETagCache", "removeETagFromAllCache, new Key:" + r5);     // Catch: Throwable -> L11
        c.remove(r5);     // Catch: Throwable -> L11
        b.b(r5, "");     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized void i(String r3, String r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        String r5 = e(r3, r4);     // Catch: Throwable -> L11
        tt5.a.b("ETagCache", "removeETagFromMemoryCache, new Key:" + r5);     // Catch: Throwable -> L11
        c.remove(r5);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized void g(String r2, boolean r3, String r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        String r5 = e(r2, r4) + "_isIcon";     // Catch: Throwable -> L10
        g.put(r5, Boolean.valueOf(r3));     // Catch: Throwable -> L10
        b.b(du5.b.e(r5), Boolean.valueOf(r3));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void f(String r4, int r5, String r6, boolean r7) {
        monitor-enter(this);
        tt5.a.b("ETagCache", "last chatWindowId:" + e + ",current chatWindowId:" + r5 + ", isForceUpdate = false");     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r4) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (e == r5) goto L18;
        List<String> r8 = d;     // Catch: Throwable -> L23
        if (hu5.a.d(r8) == true) goto L18;
        tt5.a.h("ETagCache", "clear chat thumbnail load record");     // Catch: Throwable -> L23
        Iterator r9 = ((CopyOnWriteArrayList) r8).iterator();     // Catch: Throwable -> L23
    L15:
        if (r9.hasNext() == false) goto L17;
        d().i((String) r9.next(), r6);     // Catch: Throwable -> L23
        goto L15
    L17:
        ((CopyOnWriteArrayList) d).clear();     // Catch: Throwable -> L23
    L18:
        e = r5;     // Catch: Throwable -> L23
        List<String> r10 = d;     // Catch: Throwable -> L23
        if (((CopyOnWriteArrayList) r10).contains(r4) == true) goto L21;
        ((CopyOnWriteArrayList) r10).add(r4);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
