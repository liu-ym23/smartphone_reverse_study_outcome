package com.bytedance.ies.bullet.preloadv2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import bolts.Task;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadErrorCode;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadResourceType;
import com.bytedance.ies.bullet.preloadv2.cache.h;
import com.bytedance.ies.bullet.preloadv2.cache.i;
import com.bytedance.ies.bullet.preloadv2.cache.j;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import m26.f;
import org.json.JSONObject;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class PreloadV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f247628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f247629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f247630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static double f247631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f247632e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f247633f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PThreadPoolExecutor f247634g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f247635h = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f247636a = null;

        static {
            int[] r100 = new int[PreloadResourceType.values().length];
            r100[PreloadResourceType.Template.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[PreloadResourceType.Image.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[PreloadResourceType.Font.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[PreloadResourceType.DynamicComponent.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[PreloadResourceType.ExternalJs.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[PreloadResourceType.Lottie.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[PreloadResourceType.Video.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[PreloadResourceType.Redirect.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[PreloadResourceType.Any.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f247636a = r100;
        }
    }

    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f247637a = null;

        static {
            f247637a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "bullet_preload_" + r100.hashCode());
            int r102 = f.f511670a;
            f.a("generate preload thread, coreSize " + PreloadV2.f247632e + ", maxSize " + PreloadV2.f247633f);
            return r101;
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f247638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f247639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f247640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f247641d;

        public c(String r100, boolean r101, boolean r102, String r103) {
            this.f247638a = r100;
            this.f247639b = r101;
            this.f247640c = r102;
            this.f247641d = r103;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            String r100 = this.f247638a;
            boolean r101 = this.f247639b;
            boolean r102 = this.f247640c;
            String r103 = this.f247641d;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
            Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L25
            int r106 = f.f511670a;     // Catch: Throwable -> L25
            f.c("decodeTemplate:" + r101 + ", preCodeCache:" + r102);     // Catch: Throwable -> L25
            boolean r107 = true;
            if (r101 == false) goto L6;
        L9:
            boolean r108 = true;
        L10:
            if (r102 == false) goto L12;
        L15:
            f.c("preload schema " + r100 + ",bid " + r103 + ", decodeTemplate:" + r108 + ", preCodeCache:" + r107);     // Catch: Throwable -> L25
            com.bytedance.ies.bullet.preloadv2.a r109 = com.bytedance.ies.bullet.preloadv2.a.f247651f.a(r100, r103);     // Catch: Throwable -> L25
            if (r109.f247656d == true) goto L20;
            if (r108 == false) goto L20;
            f.c("force set decodeTemplate to true");     // Catch: Throwable -> L25
            r109.f247656d = r108;     // Catch: Throwable -> L25
        L20:
            if (r109.f247657e == true) goto L23;
            if (r107 == false) goto L23;
            f.c("force set preCodeCache to true");     // Catch: Throwable -> L25
            r109.f247657e = r107;     // Catch: Throwable -> L25
        L23:
            boolean r110 = PreloadV2.f247628a;     // Catch: Throwable -> L25
            PreloadV2.f(r109, r103);     // Catch: Throwable -> L25
            Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L31;
            int r113 = f.f511670a;
            f.b("preload failure " + r112.getMessage());
        L31:
            return Result.m9448boximpl(r111);
        L12:
            if (r105.getBooleanQueryParameter("preCodeCache", false) == true) goto L15;
            r107 = false;
            goto L15
        L6:
            if (r105.getBooleanQueryParameter("decodeTemplate", false) == true) goto L9;
            r108 = false;
        L25:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L27
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreloadItem f247642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f247643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f247644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.preloadv2.a f247645d;

        public d(PreloadItem r100, long r101, String r102, com.bytedance.ies.bullet.preloadv2.a r103) {
            this.f247642a = r100;
            this.f247643b = r101;
            this.f247644c = r102;
            this.f247645d = r103;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            final PreloadItem r100 = this.f247642a;
            final long r101 = this.f247643b;
            String r102 = this.f247644c;
            com.bytedance.ies.bullet.preloadv2.a r103 = this.f247645d;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
            long r105 = System.currentTimeMillis();     // Catch: Throwable -> L5
            int r106 = f.f511670a;     // Catch: Throwable -> L5
            f.a(r100 + " thread switch to rlThread cost " + (r105 - r101));     // Catch: Throwable -> L5
            boolean r107 = PreloadV2.f247628a;     // Catch: Throwable -> L5
            PreloadV2.b(r100, r102, r103.f247656d, r103.f247657e, new PreloadV2$preload$2$1$1(r100, r101));     // Catch: Throwable -> L5
            Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            PreloadItem r109 = this.f247642a;
            Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
            if (r110 == null) goto L11;
            int r111 = f.f511670a;
            f.b(r109 + " callback Crash, " + r110.getMessage());
            boolean r112 = PreloadV2.f247628a;
            PreloadV2.c(r109.f247676b, r110.getMessage());
        L11:
            return Result.m9448boximpl(r108);
        L5:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public PreloadV2() {
    }

    static {
        f247628a = true;
        f247629b = 10;
        f247630c = BmLocated.ALIGN_RIGHT_BOTTOM;
        f247631d = 0.1d;
        int r100 = Runtime.getRuntime().availableProcessors();
        int r101 = RangesKt.coerceAtLeast(2, RangesKt.coerceAtMost(r100 - 1, 4));
        f247632e = r101;
        int r102 = (r100 * 2) + 1;
        f247633f = r102;
        f247634g = new PThreadPoolExecutor(r101, r102, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.f247637a);
        f247635h = LazyKt.lazy(PreloadV2$memReadHandler$2.INSTANCE);
    }

    public static boolean d(long r110) {
        long r100 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long r101 = Runtime.getRuntime().maxMemory();
        long r102 = r101 - r100;
        if ((r102 + r110) >= (r101 * f247631d)) goto L6;
        int r103 = f.f511670a;
        f.c("checkAppMemWarning, leftMem " + r102 + ", maxMemory " + r101 + ", size " + r110);
        return true;
    L6:
        return false;
    }

    public static final void c(String r100, String r110) {
        s26.d r101 = s26.d.f540305c;
        r r102 = (r) s26.d.f540305c.c(r.class);
        if (r102 == null) goto L9;
        c1 r103 = new c1("bdx_preload_crash", null, null, null, null, 254);
        JSONObject r104 = new JSONObject();
        r104.put("resUrl", r100);
        if (r110 == null) goto L7;
        r104.put("message", r110);
    L7:
        r103.f247794d = r104;
        r102.S(r103);
        return;
    }

    public static void e(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        int r102 = f.f511670a;
        f.c("clearCache because of ".concat(r101));
        i.f247714d.g(f247629b);
        h.f247713d.g(f247630c);
        if (r100 == false) goto L6;
        com.bytedance.ies.bullet.preloadv2.cache.d.f247701d.g(f247630c);
        return;
    }

    public static void f(com.bytedance.ies.bullet.preloadv2.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "targetBid");
        if (f247628a == true) goto L5;
        return;
    L5:
        Iterator r102 = ((ArrayList) r100.f247654b).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Task.call(new d((PreloadItem) r102.next(), System.currentTimeMillis(), r101, r100), f247634g);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final PreloadItem r110, com.bytedance.ies.bullet.preloadv2.cache.f r111, final Function1 r112) {
        com.bytedance.ies.bullet.preloadv2.cache.c r100 = null;
        ByteArrayPreloadItem r101 = null;
        switch(a.f247636a[r110.getType().ordinal()]) {
            case 1: goto L76;
            case 2: goto L50;
            case 3: goto L25;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L76;
            case 8: goto L76;
            case 9: goto L76;
            default: goto L93;
        };
    L5:
        r112.invoke(r110);
        return;
    L6:
        String r102 = r110.f247687m;
        Intrinsics.checkNotNull(r102);
        long r103 = new PolarisFileWrapper(r102).length();
        if (d(r103) == false) goto L9;
    L24:
        r112.invoke(null);
        return;
    L9:
        if (r111.a(r103) == false) goto L24;
        d1 r113 = r110.f247686l;
        if (r113 == null) goto L81;
        InputStream r114 = r113.c();
        if (r114 == null) goto L82;
        byte[] r115 = ByteStreamsKt.readBytes(r114);
        if (r115 != null) goto L18;
        return;
    L18:
        if ((r110 instanceof ByteArrayPreloadItem) == false) goto L20;
        r101 = (ByteArrayPreloadItem) r110;
    L20:
        if (r101 == null) goto L23;
        r101.f247667w = r115;
    L23:
        r112.invoke(r110);
        return;
    L82:
        return;
    L81:
        return;
    L25:
        String r104 = r110.f247687m;
        Intrinsics.checkNotNull(r104);
        long r105 = new PolarisFileWrapper(r104).length();
        if (d(r105) == false) goto L28;
    L49:
        r112.invoke(null);
        return;
    L28:
        if (r111.a(r105) == false) goto L49;
        String r106 = r110.f247687m;
        Intrinsics.checkNotNull(r106);
        PolarisFileWrapper r116 = new PolarisFileWrapper(r106);
        if (TypeFaceOptimizer.getSwitch() == false) goto L40;
        String r107 = r116.getPath();
        if (r107 == null) goto L40;
        if (TypeFaceLancet.cache.contains(r107) == false) goto L37;
        Typeface r117 = (Typeface) TypeFaceLancet.cache.get(r107);
    L41:
        if (r117 != null) goto L43;
        return;
    L43:
        if ((r110 instanceof com.bytedance.ies.bullet.preloadv2.cache.c) == false) goto L45;
        r100 = (com.bytedance.ies.bullet.preloadv2.cache.c) r110;
    L45:
        if (r100 == null) goto L48;
        r100.f247700w = r117;
    L48:
        r112.invoke(r110);
        return;
    L37:
        Typeface r108 = Typeface.createFromFile(r116);
        if (r108 == null) goto L40;
        TypeFaceLancet.cache.put(r107, r108);
        r117 = r108;
    L40:
        r117 = Typeface.createFromFile(r116);
        goto L41
    L50:
        m26.e r109 = m26.e.f511669a;
        String r118 = r110.f247687m;
        Intrinsics.checkNotNull(r118);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r118, "filePath");
        BitmapFactory.Options r119 = new BitmapFactory.Options();
        r119.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r118, r119);
        long r120 = ((long) (r119.outWidth * r119.outHeight)) * ((long) 4);
        int r121 = f.f511670a;
        f.c("PreloadImageHelper.getImageSize " + r120 + ", width " + r119.outWidth + ", height " + r119.outHeight + ", " + r118);
        if (r120 != 0) goto L53;
    L75:
        r112.invoke(null);
        return;
    L53:
        if (r111.a(r120) == false) goto L75;
        if (Build.VERSION.SDK_INT < 26) goto L58;
    L60:
        String r122 = r110.f247688n;
        Intrinsics.checkNotNull(r122);
        Function1<CloseableReference<Bitmap>, Unit> r123 = new PreloadV2$handleSubResourceMem$1(r110, r112);
        Intrinsics.checkNotNullParameter(r122, "resUrl");
        Intrinsics.checkNotNullParameter(r123, "callback");
        if (Fresco.hasBeenInitialized() == true) goto L63;
        r123.invoke(null);
        return;
    L63:
        CountDownLatch r124 = new CountDownLatch(1);
        long r125 = System.currentTimeMillis();
        f.a("PreloadImageHelper, request begin " + r122);
        Uri r126 = UriProtector.parse(r122);
        Ref.ObjectRef r127 = new Ref.ObjectRef();
        Ref.BooleanRef r128 = new Ref.BooleanRef();
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L66
        Object r130 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(UriProtector.getQueryParameter(r126, GearStrategyConsts.EV_QUALITY), "0")));     // Catch: Throwable -> L66
    L68:
        Boolean r131 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r130) == false) goto L71;
        r130 = r131;
    L71:
        boolean r132 = ((Boolean) r130).booleanValue();
        ImageRequestBuilder r133 = ImageRequestBuilder.newBuilderWithSource(r126);
        r133.disableMemoryCache();
        if (r132 == false) goto L74;
        r133.setPostprocessor(new m26.b());
    L74:
        Fresco.getImagePipeline().getDataSourceSupplier(r133.build(), null, ImageRequest.RequestLevel.FULL_FETCH).get().subscribe(new m26.c(r127, r124, r128), m26.d.f511668a);
        r124.await(10, TimeUnit.SECONDS);
        int r134 = f.f511670a;
        f.a("PreloadImageHelper, request end " + r122 + ", cost " + (System.currentTimeMillis() - r125));
        r123.invoke(r127.element);
        r128.element = true;
        return;
    L66:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L68
    L58:
        if (d(r120) == false) goto L60;
        r112.invoke(null);
        return;
    L76:
        r112.invoke(null);
        return;
    }

    public static void g(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "targetBid");
        if (f247628a == true) goto L6;
        f.c("enablePreload is false");
        return;
    L6:
        Task.call(new c(r100, r102, r103, r101), f247634g);
    }

    public static final void b(final PreloadItem r110, String r111, boolean r112, boolean r210, final Function1 r211) {
        String r113 = null;
        if (a.f247636a[r110.getType().ordinal()] != 1) goto L109;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem");
        j r100 = (j) r110;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100.f247676b));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        Uri r103 = (Uri) r102;
        if (r103 != null) goto L15;
        r100.f(PreloadErrorCode.UriInvalid, "resource schema in wrong format: " + r103);
        r211.invoke(r100);
        return;
    L15:
        int r104 = f.f511670a;
        f.a(r100 + " 模版资源 " + r103);
        long r114 = System.currentTimeMillis();
        l r105 = m26.a.c(r100, r103, r111);
        r105.f552702e = 3500;
        r100.f247684j = r105;
        l r106 = new l("");
        l r107 = r100.f247684j;
        Intrinsics.checkNotNull(r107);
        r106.a(r107);
        com.bytedance.ies.bullet.kit.resourceloader.j.f246830a.getClass();
        String r108 = com.bytedance.ies.bullet.kit.resourceloader.j.h("channel", r103);
        if (r108 == null) goto L18;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f552705h = r108;
    L18:
        String r109 = com.bytedance.ies.bullet.kit.resourceloader.j.h("bundle", r103);
        if (r109 == null) goto L21;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r106.f552706i = r109;
    L21:
        r100.f247685k = r106;
        ResourceLoaderService r115 = com.bytedance.ies.bullet.kit.resourceloader.i.b(r111, 2);
        l r116 = r100.f247684j;
        Intrinsics.checkNotNull(r116);
        d1 r117 = r115.h("", r116);
        long r118 = System.currentTimeMillis();
        r100.f247692r = r118 - r114;
        if (r117 == null) goto L24;
        String r119 = r117.f247859b;
    L25:
        if (r119 != null) goto L113;
    L42:
        PreloadErrorCode r120 = PreloadErrorCode.RLFail;
        l r121 = r100.f247684j;
        if (r121 == null) goto L45;
        r113 = r121.f552712o;
    L45:
        r100.f(r120, String.valueOf(r113));
        r211.invoke(r100);
        return;
    L113:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r103, "__dev"), "1") == true) goto L30;
        boolean r122 = true;
    L34:
        if (r122 == false) goto L42;
        r117.getClass();
        r100.f247686l = r117;
        r100.f247687m = r117.f247859b;
        int r123 = f.f511670a;
        f.c("enableMemory: " + r100.f247678d + ", decodeTemplate: " + r112 + ", preCodeCache: " + r210);
        if (r100.f247678d == true) goto L41;
        if (r112 == true) goto L41;
        r211.invoke(r100);
        return;
    L41:
        ((Handler) f247635h.getValue()).post(new com.bytedance.ies.bullet.preloadv2.c(r100, r118, r211, r117, r112, r210, r111, r103));
        return;
    L30:
        f.b("uri invalid " + r103);     // Catch: Exception -> L32
    L33:
        r122 = false;
        goto L34
    L24:
        r119 = null;
    L7:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L109:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L48
        Object r126 = Result.m9449constructorimpl(UriProtector.parse(r110.f247676b));     // Catch: Throwable -> L48
    L51:
        if (Result.m9455isFailureimpl(r126) == false) goto L53;
        r126 = null;
    L53:
        Uri r127 = (Uri) r126;
        if (r127 != null) goto L56;
        r110.f(PreloadErrorCode.UriInvalid, "resource schema in wrong format: " + r127);
        r211.invoke(r110);
        return;
    L56:
        int r128 = f.f511670a;
        f.a(r110 + " 子资源 " + r110.f247676b);
        long r129 = System.currentTimeMillis();
        r110.f247684j = m26.a.c(r110, r127, r111);
        l r130 = new l("");
        l r131 = r110.f247684j;
        Intrinsics.checkNotNull(r131);
        r130.a(r131);
        com.bytedance.ies.bullet.kit.resourceloader.j.f246830a.getClass();
        String r132 = com.bytedance.ies.bullet.kit.resourceloader.j.h("channel", r127);
        if (r132 == null) goto L59;
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        r130.f552705h = r132;
    L59:
        String r133 = com.bytedance.ies.bullet.kit.resourceloader.j.h("bundle", r127);
        if (r133 == null) goto L62;
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        r130.f552706i = r133;
    L62:
        r110.f247685k = r130;
        ResourceLoaderService r134 = com.bytedance.ies.bullet.kit.resourceloader.i.b(r111, 2);
        String r135 = r110.f247676b;
        l r136 = r110.f247684j;
        Intrinsics.checkNotNull(r136);
        d1 r137 = r134.h(r135, r136);
        final long r138 = System.currentTimeMillis();
        r110.f247692r = r138 - r129;
        if (r137 == null) goto L104;
        String r139 = r137.f247859b;
        if (r139 != null) goto L67;
    L70:
        boolean r140 = true;
    L71:
        if (r140 == true) goto L104;
        r110.f247686l = r137;
        r110.f247687m = r137.f247859b;
        if (r110.getType() != PreloadResourceType.Image) goto L76;
    L79:
        boolean r141 = true;
    L80:
        if (r141 == false) goto L88;
        r110.f247688n = r110.f247676b;
        boolean r142 = RedirectManager.f247717a;
        String r143 = r137.f247859b;
        Intrinsics.checkNotNull(r143);
        String r144 = RedirectManager.h(r143, r137.getType());
        if (r144 == null) goto L85;
        r110.f247688n = r144;
    L85:
        if (r137.f247861d != ResourceFrom.CDN) goto L87;
        r110.f247688n = r110.f247676b;
    L87:
        RedirectManager.b(r110.f247676b, r110.f247688n);
    L90:
        if (r110.f247678d == true) goto L92;
        r211.invoke(r110);
        return;
    L92:
        if (r110.f247679e == false) goto L94;
        com.bytedance.ies.bullet.preloadv2.cache.f r145 = com.bytedance.ies.bullet.preloadv2.cache.d.f247701d;
    L95:
        final com.bytedance.ies.bullet.preloadv2.cache.f r146 = r145;
        if (r141 == false) goto L98;
        String r147 = r110.f247688n;
    L99:
        Intrinsics.checkNotNull(r147);
        if (r146.c(r147) == null) goto L102;
        r110.f(PreloadErrorCode.CacheDuplicate, "duplicate cache, key " + r147 + " in " + r146.f247705b);
        r211.invoke(r110);
        return;
    L102:
        final boolean r148 = r141;
        ((Handler) f247635h.getValue()).post(new PreloadV2$preloadSubResource$3(r110, r138, r146, r211, r148));
        return;
    L98:
        r147 = r110.d();
        goto L99
    L94:
        r145 = h.f247713d;
        goto L95
    L88:
        r110.f247688n = r137.f247859b;
        goto L90
    L76:
        if (r110.getType() == PreloadResourceType.Redirect) goto L79;
        r141 = false;
        goto L80
    L67:
        if (r139.length() == 0) goto L70;
        r140 = false;
    L104:
        PreloadErrorCode r149 = PreloadErrorCode.RLFail;
        l r150 = r110.f247684j;
        if (r150 == null) goto L107;
        r113 = r150.f552712o;
    L107:
        r110.f(r149, String.valueOf(r113));
        r211.invoke(r110);
        return;
    L48:
        th = move-exception;
        Result.Companion r151 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    }
}
