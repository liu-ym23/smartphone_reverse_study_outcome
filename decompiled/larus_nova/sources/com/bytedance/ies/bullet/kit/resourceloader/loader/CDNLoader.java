package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import bolts.Task;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.argus.util.ForceHttpsUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.d;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.ies.bullet.kit.resourceloader.k;
import com.bytedance.ies.bullet.kit.resourceloader.n;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v26.f;
import v26.g;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class CDNLoader extends IXResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246835a;

    public static final class a {
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f246836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f246837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CDNLoader f246838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<k, Unit> f246839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<Throwable, Unit> f246840e;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<Throwable, Unit> f246841a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f246842b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super Throwable, Unit> r100, String r101) {
                this.f246841a = r100;
                this.f246842b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                this.f246841a.invoke(new Throwable(this.f246842b));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                ConcurrentHashMap<String, ResourceLoaderService> r100 = i.f246824a;
                if (i.f246826c == true) goto L10;
                th.printStackTrace();
                return;
            L10:
                throw new Throwable(th);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader$b$b, reason: collision with other inner class name */
        public static final class CallableC3529b<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<k, Unit> f246843a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f246844b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f f246845c;

            /* JADX WARN: Multi-variable type inference failed */
            public CallableC3529b(Function1<? super k, Unit> r100, String r101, f r102) {
                this.f246843a = r100;
                this.f246844b = r101;
                this.f246845c = r102;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Function1<k, Unit> r100 = this.f246843a;     // Catch: Throwable -> L4
                k r101 = new k(UriProtector.parse(this.f246844b));     // Catch: Throwable -> L4
                f r102 = this.f246845c;     // Catch: Throwable -> L4
                PolarisFileWrapper r103 = new PolarisFileWrapper(r102.f552677a);     // Catch: Throwable -> L4
                ResourceFrom r104 = ResourceFrom.GECKO;     // Catch: Throwable -> L4
                d r105 = new d(r103);     // Catch: Throwable -> L4
                r105.f246810c = 0L;     // Catch: Throwable -> L4
                r105.f246809b = r102.f552678b;     // Catch: Throwable -> L4
                r101.f246833a = r105;     // Catch: Throwable -> L4
                r100.invoke(r101);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (i.f246826c == true) goto L10;
                y16.b r106 = y16.c.f565659a;
                y16.c.a("CDNLoader resolveOnException,uri=" + this.f246844b + ", message=" + th.getMessage());
                return;
            L10:
                throw new Throwable(th);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        @Override // v26.g
        public final void a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "infoRL");
            y16.b r101 = y16.c.f565659a;
            y16.c.a("CDNLoader onSuccess,uri=" + this.f246836a + ", syncCall=" + this.f246837b + ",isCache=" + r100.f552678b);
            CallableC3529b r102 = new CallableC3529b(this.f246839d, this.f246836a, r100);
            this.f246838c.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            r102.call();
            return;
        L5:
            Task.call(r102, Task.UI_THREAD_EXECUTOR);
        }

        @Override // v26.g
        public final void onFailed(String r100) {
            Intrinsics.checkNotNullParameter(r100, "errorMessage");
            y16.b r101 = y16.c.f565659a;
            y16.c.a("CDNLoader onFailed,uri=" + this.f246836a + ", message=" + r100);
            a r102 = new a(this.f246840e, r100);
            this.f246838c.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            r102.call();
            return;
        L5:
            Task.call(r102, Task.UI_THREAD_EXECUTOR);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, boolean r101, CDNLoader r102, Function1<? super k, Unit> r103, Function1<? super Throwable, Unit> r104) {
            this.f246836a = r100;
            this.f246837b = r101;
            this.f246838c = r102;
            this.f246839d = r103;
            this.f246840e = r104;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void cancelLoad() {
    }

    public final String toString() {
        return "CDNLoader@" + this;
    }

    public CDNLoader() {
        this.f246835a = "CDN";
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final String getTAG() {
        return this.f246835a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final d1 loadSync(d1 r110, l r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, "config");
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        final CountDownLatch r101 = new CountDownLatch(1);
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = true;
        b(r110, r111, true, new AnonymousClass1(r100, r101), new C105562(r100, r102, r101));
        r101.await(r111.f552702e, TimeUnit.MILLISECONDS);
        HybridLogger r103 = HybridLogger.f246343a;
        Map r112 = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", r111.f552708k), TuplesKt.to("taskConfig", r111.toString()), TuplesKt.to("url", r110.f247858a.toString()), TuplesKt.to("success", Boolean.valueOf(r102.element))});
        com.bytedance.ies.bullet.base.utils.logger.a r104 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r104.a("resourceSession", r111.B);
        Unit r113 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "CDNLoader loadSync", r112, r104);
        return (d1) r100.element;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void loadAsync(d1 r110, l r111, final Function1<? super d1, Unit> r112, final Function1<? super Throwable, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r113, "reject");
        HybridLogger r100 = HybridLogger.f246343a;
        Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", r111.f552708k), TuplesKt.to("taskConfig", r111.toString()), TuplesKt.to("url", r110.f247858a.toString())});
        com.bytedance.ies.bullet.base.utils.logger.a r102 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r102.a("resourceSession", r111.B);
        Unit r103 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "CDNLoader loadAsync", r101, r102);
        b(r110, r111, false, new AnonymousClass2(r112), new AnonymousClass3(r113));
    }

    public final void a(String r100, boolean r110, l r111, Function1<? super k, Unit> r112, Function1<? super Throwable, Unit> r113) {
        String r101 = ForceHttpsUtil.a(r100);
        y16.b r102 = y16.c.f565659a;
        y16.c.d("CDNLoader downloadResourceFile,origin uri=" + r100 + ", secUrl=" + r101 + ", syncCall=" + r110);
        getService().f().f552688i.a(r101, r110, r111, new b(r101, r110, this, r112, r113));
    }

    public final void b(final d1 r210, final l r211, boolean r212, final Function2<? super d1, ? super Long, Unit> r213, final Function4<? super Integer, ? super Throwable, ? super d1, ? super Long, Unit> r214) {
        final com.bytedance.ies.bullet.base.utils.logger.a r110 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r110.a("resourceSession", r211.B);
        setInterval(new n());
        final long r111 = SystemClock.elapsedRealtime();
        if (r211.f552708k.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        Uri r101 = r210.f247858a;
    L9:
        final Uri r102 = r101;
        HybridLogger r103 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "CDNLoader realLoad", MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", r211.f552708k), TuplesKt.to("taskConfig", r211.toString()), TuplesKt.to("url", r210.f247858a.toString())}), r110);
        Function1<k, Unit> r112 = new CDNLoader$realLoad$1(r210, this, r211, r102, r110, r213, r111, r214);
        Function1<Throwable, Unit> r104 = new CDNLoader$realLoad$2(r210, r211, r102, r110, r214, r111, this);
        y16.b r105 = y16.c.f565659a;
        y16.c.d("CDNLoader loadFromCDN,uri=" + r102 + ", syncCall=" + r212);
        String r106 = r102.getScheme();
        if (r106 == null) goto L32;
        int r107 = r106.hashCode();
        if (r107 == (-1772600516)) goto L26;
        if (r107 == 3213448) goto L22;
        if (r107 != 99617003) goto L32;
        if (r106.equals("https") == false) goto L32;
    L24:
        a(r102.toString(), r212, r211, r112, r104);
        return;
    L22:
        if (r106.equals("http") == true) goto L24;
    L26:
        if (r106.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L32;
        j.f246830a.getClass();
        String r108 = j.b(r102);
        if (r108 != null) goto L31;
        r108 = "";
    L31:
        a(r108, r212, r211, r112, r104);
        return;
    L32:
        Map r109 = MapsKt.mapOf(new Pair[]{TuplesKt.to("cdnUrl", r102.toString()), TuplesKt.to("taskConfig", r211.toString())});
        com.bytedance.ies.bullet.base.utils.logger.a r113 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r113.a("resourceSession", r211.B);
        Unit r114 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "CDNLoader cdn Invalid URL", r109, r113);
        r104.invoke(new IllegalArgumentException("cdn Invalid URL"));
        return;
    L8:
        r101 = UriProtector.parse(r211.f552708k);
        goto L9
    L5:
        r100 = false;
        goto L6
    }
}
