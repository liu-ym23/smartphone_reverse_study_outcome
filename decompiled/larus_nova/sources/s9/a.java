package s9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.prerender.PrerenderMaxSizeLruCache;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.r;
import com.bytedance.android.annie.util.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, f> f541022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<Disposable>> f541023b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> f541024c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HybridCard f541025d;

    /* JADX INFO: renamed from: s9.a$a, reason: collision with other inner class name */
    public static final class C7586a extends b7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f541026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f541027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f541028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f541029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f541030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f541031f;

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r110) {
            super.onLoadSuccess(r110);
            ConcurrentHashMap<Integer, f> r100 = a.f541022a;
            ViewParent r101 = null;
            if (r110 == null) goto L5;
            ViewParent r102 = r110.getParent();
        L7:
            if (r102 == null) goto L9;
            int r103 = r102.hashCode();
        L10:
            a.e(Integer.valueOf(r103), System.currentTimeMillis(), false);
            if (r110 == null) goto L24;
            String r104 = this.f541026a;
            String r105 = this.f541027b;
            ViewParent r106 = r110.getParent();
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.android.annie.api.card.HybridCard");
            HybridCard r107 = (HybridCard) r106;
            ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r108 = a.f541024c;
            if (r108.get(r104) != null) goto L21;
            com.bytedance.android.annie.ng.a r109 = g.f39671c.get(r104);
            if (r109 == null) goto L19;
            o8.g r111 = r109.f39646d;
            if (r111 == null) goto L19;
            int r112 = r111.f522332a;
        L20:
            PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r113 = new PrerenderMaxSizeLruCache(r112);
            r113.put(r105, new WeakReference(r107));
            r108.put(r104, r113);
        L19:
            r112 = 5;
            goto L20
        L21:
            PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r114 = r108.get(r104);
            if (r114 == null) goto L24;
            WeakReference<HybridCard> r115 = r114.put(r105, new WeakReference(r107));
        L24:
            String r116 = this.f541028c;
            String r117 = this.f541029d;
            String r118 = this.f541027b;
            String r119 = this.f541026a;
            int r120 = this.f541030e;
            int r121 = s.f40075a;
            Ref.IntRef r122 = new Ref.IntRef();
            if (r120 <= 0) goto L27;
            r122.element = r120;
        L27:
            a.f541023b.put(r118, new WeakReference(Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).map(new r(r122)).take(r122.element + 1).doOnComplete(new c(r116, r118, r119, r117)).doOnError(d.f541042a).subscribe()));
            int r123 = x8.a.f562881a;
            x8.a.d(Annie.ANNIE_TAG, "预渲染成功:" + this.f541028c, false);
            e r124 = this.f541031f;
            if (r124 == null) goto L30;
            r124.onSuccess(this.f541028c);
        L30:
            j9.b r125 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            if (r110 == null) goto L33;
            r101 = r110.getParent();
        L33:
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
            View r126 = (View) r101;
            String r127 = this.f541029d;
            JSONObject r128 = new JSONObject();
            String r129 = this.f541026a;
            String r130 = this.f541027b;
            r128.put("biz", r129);
            r128.put("cache_key", r130);
            r128.put("status", "success");
            r128.put("message", "success");
            Unit r131 = Unit.INSTANCE;
            JSONObject r132 = new JSONObject();
            r132.put("duration", a.a(Integer.valueOf(r110.getParent().hashCode())));
            JSONObject r133 = new JSONObject();
            r133.put("start_timestamp", a.b(Integer.valueOf(r110.getParent().hashCode())).f541043a);
            r133.put("end_timestamp", a.b(Integer.valueOf(r110.getParent().hashCode())).f541044b);
            j9.b.a.a(r125, r126, "annie_container_prerender", r127, r128, r132, r133, null, 1, 320);
            a.f541022a.remove(Integer.valueOf(r110.getParent().hashCode()));
            return;
        L9:
            r103 = 0;
            goto L10
        L5:
            r102 = null;
            goto L7
        }

        @Override // b7.a, b7.b
        public final void onLoadFail(View r110, String r111, String r112) {
            super.onLoadFail(r110, r111, r112);
            ConcurrentHashMap<Integer, f> r100 = a.f541022a;
            ViewParent r101 = null;
            if (r110 == null) goto L5;
            ViewParent r102 = r110.getParent();
        L7:
            if (r102 == null) goto L9;
            int r103 = r102.hashCode();
        L10:
            a.e(Integer.valueOf(r103), System.currentTimeMillis(), false);
            int r104 = x8.a.f562881a;
            x8.a.b(Annie.ANNIE_TAG, "预渲染失败:" + this.f541028c + " reason:" + r112, false);
            e r105 = this.f541031f;
            if (r105 == null) goto L13;
            r105.onFailed(this.f541028c, "预渲染失败:" + this.f541028c + " reason:" + r112);
        L13:
            j9.b r106 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            if (r110 == null) goto L16;
            r101 = r110.getParent();
        L16:
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
            View r107 = (View) r101;
            JSONObject r108 = new JSONObject();
            String r109 = this.f541026a;
            String r113 = this.f541027b;
            r108.put("biz", r109);
            r108.put("cache_key", r113);
            r108.put("status", "fail");
            if (r112 != null) goto L19;
            r112 = "fail";
        L19:
            r108.put("message", r112);
            Unit r114 = Unit.INSTANCE;
            JSONObject r115 = new JSONObject();
            r115.put("duration", a.a(Integer.valueOf(r110.getParent().hashCode())));
            JSONObject r116 = new JSONObject();
            r116.put("start_timestamp", a.b(Integer.valueOf(r110.getParent().hashCode())).f541043a);
            r116.put("end_timestamp", a.b(Integer.valueOf(r110.getParent().hashCode())).f541044b);
            j9.b.a.a(r106, r107, "annie_container_prerender", r111, r108, r115, r116, null, 1, 320);
            a.f541022a.remove(Integer.valueOf(r110.getParent().hashCode()));
            return;
        L9:
            r103 = 0;
            goto L10
        L5:
            r102 = null;
            goto L7
        }

        public C7586a(String r100, String r101, String r102, String r103, int r104, e r105) {
            this.f541026a = r100;
            this.f541027b = r101;
            this.f541028c = r102;
            this.f541029d = r103;
            this.f541030e = r104;
            this.f541031f = r105;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference<HybridCard> f541032a;

        public b(WeakReference<HybridCard> r100) {
            this.f541032a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<HybridCard> r100 = this.f541032a;     // Catch: Throwable -> L8 Exception -> L10
            if (r100 == null) goto L17;
            HybridCard r101 = r100.get();     // Catch: Throwable -> L8 Exception -> L10
            if (r101 == null) goto L17;
            r101.release();     // Catch: Throwable -> L8 Exception -> L10
        L17:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        L21:
            return;
        L10:
            e = move-exception;
            int r102 = x8.a.f562881a;     // Catch: Throwable -> L8
            x8.a.b(Annie.ANNIE_TAG, "回收预渲染View失败:" + e, false);     // Catch: Throwable -> L8
            goto L17
        }
    }

    public a() {
    }

    static {
        f541022a = new ConcurrentHashMap();
        f541023b = new ConcurrentHashMap();
        f541024c = new ConcurrentHashMap();
    }

    public static final long a(Integer r100) {
        if (r100 == null) goto L12;
        ConcurrentHashMap<Integer, f> r101 = f541022a;
        if (r101.containsKey(r100) == false) goto L12;
        f r102 = r101.get(r100);
        if (r102 == null) goto L9;
        Long r103 = Long.valueOf(r102.f541044b - r102.f541043a);
    L10:
        if (r103 == null) goto L12;
        return r103.longValue();
    L9:
        r103 = null;
    L12:
        return 0;
    }

    public static final f b(Integer r100) {
        ConcurrentHashMap<Integer, f> r101 = f541022a;
        if (r101 == null) goto L10;
        if (r101.containsKey(r100) == false) goto L8;
        f r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    L8:
        return new f();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public static boolean d(String r100, String r101) {
        ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r102 = f541024c;
        if (r102.get(r100) != null) goto L5;
        return false;
    L5:
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        if (r103.get(r101) != null) goto L8;
        return false;
    L8:
        return true;
    }

    public static void e(Integer r100, long r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<Integer, f> r103 = f541022a;
        if (r103.containsKey(r100) == false) goto L11;
        f r104 = r103.get(r100);
        if (r104 == null) goto L17;
        if (r102 == false) goto L10;
        r104.f541043a = r101;
        return;
    L10:
        r104.f541044b = r101;
        return;
    L17:
        return;
    L11:
        f r105 = new f();
        if (r102 == false) goto L14;
        r105.f541043a = r101;
    L15:
        r103.put(r100, r105);
        return;
    L14:
        r105.f541044b = r101;
        goto L15
    }

    public static void f(String r100, String r101, boolean r102) {
        ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r103 = f541024c;
        if (r103.get(r101) != null) goto L5;
        return;
    L5:
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r104 = r103.get(r101);
        if (r104 == null) goto L8;
        WeakReference r105 = (WeakReference) r104.remove(r100);
    L9:
        if (r102 == false) goto L12;
        ThreadUtils.c(new b(r105));
        return;
    L12:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static void c(Context r110, String r111, String r112, int r113, e r114) {
        Uri r100 = UriProtector.parse(r111);
        String r101 = UriProtector.getQueryParameter(r100, "url");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L15;
        int r103 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "url == null schema is: " + r111, false);
        if (r114 == null) goto L62;
        r114.onFailed(r111, "url == null");
        return;
    L62:
        return;
    L15:
        String r104 = UriProtector.getQueryParameter(r100, "prerender_cache_key");
        if (r104 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L60;
        int r106 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "prerenderCacheKey == null schema is: " + r111, false);
        if (r114 == null) goto L63;
        r114.onFailed(r111, "prerenderCacheKey == null");
        return;
    L63:
        return;
    L60:
        Uri r107 = UriProtector.parse(r101);     // Catch: Exception -> L56
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L56
        r108.append(r107.getScheme());     // Catch: Exception -> L56
        r108.append(':');     // Catch: Exception -> L56
        if (r107.getPort() != (-1)) goto L30;
        Object r115 = "";
    L31:
        r108.append(r115);     // Catch: Exception -> L56
        r108.append("//");     // Catch: Exception -> L56
        r108.append(r107.getHost());     // Catch: Exception -> L56
        r108.append(r107.getPath());     // Catch: Exception -> L56
        String r109 = r108.toString() + '_' + r104;
        if (d(r112, r109) == false) goto L46;
        int r116 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "当前缓存中已存在指定card schema is: " + r111, false);
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r117 = f541024c.get(r112);
        Intrinsics.checkNotNull(r117);
        Object r118 = r117.get(r109);
        Intrinsics.checkNotNull(r118);
        Object r119 = ((WeakReference) r118).get();
        Intrinsics.checkNotNull(r119);
        if (Intrinsics.areEqual(((HybridCard) r119).getContext(), r110) == false) goto L39;
        if (r114 == null) goto L64;
        r114.onFailed(r111, "当前缓存中已存在指定card");
        return;
    L64:
        return;
    L39:
        x8.a.d(Annie.ANNIE_TAG, "删除缓存card, 重新创建", false);
        f(r109, r112, true);
        ConcurrentHashMap<String, WeakReference<Disposable>> r120 = f541023b;
        WeakReference<Disposable> r121 = r120.get(r109);
        if (r121 == null) goto L46;
        r120.remove(r109);
        Disposable r122 = r121.get();
        if (r122 == null) goto L46;
        if (r122.isDisposed() == true) goto L46;
        r122.dispose();
    L46:
        f541025d = null;
        com.bytedance.android.annie.ng.c r123 = Annie.with(r110, r100, r112);
        Bundle r124 = new Bundle();
        r124.putInt("isPrerender", 1);
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, "bundle");
        r123.f39656e = r124;
        C7586a r125 = new C7586a(r112, r109, r111, r101, r113, r114);
        Intrinsics.checkNotNullParameter(r125, "commonLifecycle");
        r123.f39655d = r125;
        HybridCard r126 = r123.a();
        f541025d = r126;
        if (r126 != null) goto L52;
        int r127 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "预渲染失败:" + r111, false);
        if (r114 == null) goto L65;
        r114.onFailed(r111, "预渲染失败:" + r111);
        return;
    L65:
        return;
    L52:
        e(Integer.valueOf(r126.hashCode()), System.currentTimeMillis(), true);
        HybridCard r128 = f541025d;
        if (r128 == null) goto L66;
        a7.a.a(r128, null, null, 3);
        return;
    L66:
        return;
    L30:
        r115 = Integer.valueOf(r107.getPort());     // Catch: Exception -> L56
    L56:
        int r129 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, "解析schema种的url失败:" + r111, false);
        if (r114 == null) goto L67;
        r114.onFailed(r111, "解析schema种的url失败:" + r111);
        return;
    L67:
        return;
    L18:
        if (r104.length() == 0) goto L21;
        r105 = false;
        goto L22
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
