package com.bytedance.locallife.dito.core;

import android.text.TextUtils;
import com.bytedance.locallife.dito.common.reporter.DitoCommonReporter;
import com.bytedance.locallife.dito.data.DitoPage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<c, ConcurrentLinkedQueue<a>> f257992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Future<?> f257993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Future<?> f257994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f257995d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DitoPage f257996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f257997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f257998c;

        public a(DitoPage r100, d r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "ditoPage");
            Intrinsics.checkNotNullParameter(r101, "pageManageInfo");
            this.f257996a = r100;
            this.f257997b = r101;
            this.f257998c = r102;
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        JSONObject a();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f257999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f258000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f258001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f258002d;

        public static final class a {
        }

        static {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 15);
        }

        public final String toString() {
            return "PageManageInfo(pageType=" + this.f257999a + ", scene=" + this.f258000b + ", expireTime=" + this.f258001c + ", cachePageSecondarySource=" + this.f258002d + ')';
        }

        public final int hashCode() {
            int r100 = this.f258000b.hashCode() * 31;
            Integer r101 = this.f257999a;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == false) goto L14;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f257999a, r101.f257999a) == true) goto L10;
        L12:
            return false;
        L10:
            if (TextUtils.equals(this.f258000b, r101.f258000b) == false) goto L12;
            return true;
        L14:
            return true;
        }

        public /* synthetic */ d(Integer r100, String r110, int r111) {
            String r101 = null;
            if ((r111 & 1) == 0) goto L5;
            Integer r102 = null;
        L7:
            if ((r111 & 2) == 0) goto L9;
            r110 = "any";
        L9:
            String r103 = r110;
            if ((r111 & 4) == 0) goto L12;
            long r104 = 300000;
        L13:
            long r105 = r104;
            if ((r111 & 8) == 0) goto L16;
            r101 = "";
        L16:
            this(r102, r103, r105, r101);
            return;
        L12:
            r104 = 0;
            goto L13
        L5:
            r102 = r100;
            goto L7
        }

        public d(Integer r100, String r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r103, "cachePageSecondarySource");
            this.f257999a = r100;
            this.f258000b = r101;
            this.f258001c = r102;
            this.f258002d = r103;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f258003a = null;

        static {
            f258003a = new e();
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            rq6.a.f538927a.a("DitoPageCacheCenter", "triggerCleanExpiredCacheTask");     // Catch: Exception -> L5 Throwable -> L8
            ConcurrentHashMap<c, ConcurrentLinkedQueue<a>> r100 = v.f257992a;     // Catch: Exception -> L5 Throwable -> L8
            v.a();     // Catch: Exception -> L5 Throwable -> L8
            v.f257993b = null;     // Catch: Exception -> L5 Throwable -> L8
            v.c();     // Catch: Exception -> L5 Throwable -> L8
        L16:
            return;
        L5:
            e = move-exception;
            rq6.a.f538927a.b("DitoPageCacheCenter", e);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public v() {
    }

    static {
        f257992a = new ConcurrentHashMap();
        f257995d = new CopyOnWriteArrayList();
    }

    public static final void a() {
        ConcurrentHashMap<c, ConcurrentLinkedQueue<a>> r100 = f257992a;
        if (r100.size() == 0) goto L27;
        long r101 = System.currentTimeMillis();
        Iterator<Map.Entry<c, ConcurrentLinkedQueue<a>>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L36;
        Map.Entry<c, ConcurrentLinkedQueue<a>> r103 = r102.next();
        c r104 = r103.getKey();
        ConcurrentLinkedQueue<a> r105 = r103.getValue();
        if (r105.size() <= 0) goto L11;
        a r106 = (a) CollectionsKt.last(r105);
    L12:
        boolean r107 = false;
        if (r106 != null) goto L15;
    L25:
        if (r107 == true) goto L7;
        r102.remove();
        rq6.a.f538927a.a("DitoPageCacheCenter", "cleanExpiredCache page" + r104);
        goto L7
    L15:
        if ((r101 - r106.f257998c) <= r106.f257997b.f258001c) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L25;
        Iterator<b> r109 = f257995d.iterator();
    L21:
        if (r109.hasNext() == false) goto L25;
        if (r109.next().a() == false) goto L21;
        rq6.a.f538927a.a("DitoPageCacheCenter", "cleanExpiredCache interceptClean page" + r104);
        r107 = true;
        goto L25
    L17:
        r108 = false;
        goto L18
    L11:
        r106 = null;
        goto L12
    L36:
        return;
    }

    public static void c() {
        if (f257993b == null) goto L5;
        return;
    L5:
        if (f257992a.size() == 0) goto L10;
        f257993b = ThreadPoolHelper.e().schedule(e.f258003a, 300000, TimeUnit.MILLISECONDS);
        return;
    }

    public static a b(c r110, d r111, DitoCommonReporter r210) {
        Intrinsics.checkNotNullParameter(r110, "pageKey");
        Intrinsics.checkNotNullParameter(r111, "targetPageManageInfo");
        Intrinsics.checkNotNullParameter(r210, "ditoReporter");
        ConcurrentLinkedQueue<a> r100 = f257992a.get(r110);
        if (r100 != null) goto L6;
        r210.l(r110, null);
        rq6.a.f538927a.a("DitoPageCacheCenter", "getDitoPage page:" + r110 + " page cache is null");
        return null;
    L6:
        long r101 = System.currentTimeMillis();
        Integer r102 = r111.f257999a;
        String r103 = r111.f258000b;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r100.iterator();
    L8:
        if (r113.hasNext() == false) goto L25;
        Object r114 = r113.next();
        a r104 = (a) r114;
        if (Intrinsics.areEqual(r103, "any") == false) goto L12;
    L15:
        long r115 = r101;
        if ((r101 - r104.f257998c) <= r104.f257997b.f258001c) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L21;
        boolean r116 = true;
    L22:
        if (r116 == false) goto L24;
        r112.add(r114);
    L24:
        r101 = r115;
    L21:
        r116 = false;
        goto L22
    L18:
        r105 = false;
        goto L19
    L12:
        if (Intrinsics.areEqual(r103, r104.f257997b.f258000b) == true) goto L15;
        r115 = r101;
        goto L21
    L25:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r107 = r112.iterator();
        a r108 = null;
    L27:
        if (r107.hasNext() == false) goto L49;
        a r117 = (a) r107.next();
        if (r102 != null) goto L43;
        Integer r118 = r117.f257997b.f257999a;
        int r119 = Integer.MIN_VALUE;
        if (r118 == null) goto L33;
        int r120 = r118.intValue();
    L34:
        if (r108 == null) goto L40;
        d r121 = r108.f257997b;
        if (r121 == null) goto L40;
        Integer r122 = r121.f257999a;
        if (r122 == null) goto L40;
        r119 = r122.intValue();
    L40:
        if (r120 < r119) goto L48;
    L47:
        r108 = r117;
    L48:
        r106.add(Unit.INSTANCE);
        goto L27
    L33:
        r120 = Integer.MIN_VALUE;
        goto L34
    L43:
        if (Intrinsics.areEqual(r102, r117.f257997b.f257999a) == false) goto L48;
        if (Intrinsics.areEqual(r103, "any") == true) goto L47;
        r108 = r117;
    L49:
        r210.l(r110, r108);
        if (r108 == null) goto L55;
        if (r100.size() <= 1) goto L55;
        r100.remove(r108);
        r100.add(r108);
    L55:
        rq6.a r109 = rq6.a.f538927a;
        StringBuilder r123 = new StringBuilder("getDitoPage page:");
        r123.append(r110);
        r123.append(" hasCache:");
        if (r108 == null) goto L58;
        DitoPage r124 = r108.f257996a;
    L59:
        if (r124 == null) goto L61;
        boolean r125 = true;
    L62:
        r123.append(r125);
        r109.a("DitoPageCacheCenter", r123.toString());
        return r108;
    L61:
        r125 = false;
        goto L62
    L58:
        r124 = null;
        goto L59
    }
}
