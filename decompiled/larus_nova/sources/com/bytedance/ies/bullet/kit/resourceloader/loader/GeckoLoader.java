package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import bolts.Task;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ecom.arch.slice.render.SlcPosition;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.d;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.kit.resourceloader.k;
import com.bytedance.ies.bullet.kit.resourceloader.n;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v26.e;
import v26.j;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class GeckoLoader extends IXResourceLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f246846b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246847a;

    public static final class a {
    }

    public static final class b implements e {
        public b() {
        }

        @Override // v26.e
        public final void a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "channelList");
        }

        @Override // v26.e
        public final void b(List<String> r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "channelList");
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d1 f246848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GeckoLoader f246849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f246850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.base.utils.logger.a f246851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<d1, Unit> f246852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<Throwable, Unit> f246853f;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GeckoLoader f246854a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d1 f246855b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ l f246856c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Throwable f246857d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function1<d1, Unit> f246858e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Function1<Throwable, Unit> f246859f;

            /* JADX WARN: Multi-variable type inference failed */
            public a(GeckoLoader r100, d1 r101, l r102, Throwable r103, Function1<? super d1, Unit> r104, Function1<? super Throwable, Unit> r105) {
                this.f246854a = r100;
                this.f246855b = r101;
                this.f246856c = r102;
                this.f246857d = r103;
                this.f246858e = r104;
                this.f246859f = r105;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                GeckoLoader r100 = this.f246854a;
                d1 r101 = this.f246855b;
                l r102 = this.f246856c;
                Throwable r103 = this.f246857d;
                Function1<d1, Unit> r104 = this.f246858e;
                Function1<Throwable, Unit> r105 = this.f246859f;
                int r106 = GeckoLoader.f246846b;
                r100.b(false, r101, r102, r103, r104, r105);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        @Override // v26.e
        public final void a(List r110) {
            Intrinsics.checkNotNullParameter(r110, "channelList");
            JSONObject r111 = this.f246848a.A.f17023e;
            if (r111 == null) goto L5;
            r111.put("gecko_update", this.f246849b.getInterval().a());
        L5:
            HybridLogger r112 = HybridLogger.f246343a;
            HybridLogger.k("XResourceLoader", "finish gecko update", MapsKt.mapOf(TuplesKt.to("taskConfig", this.f246850c.toString())), this.f246851d);
            l r113 = this.f246850c;
            if (r113.f552704g == false) goto L8;
            HybridLogger.k("XResourceLoader", "finish gecko update success, skip callbacks when onlyLocal is true", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r113.toString()), TuplesKt.to("url", this.f246848a.f247858a.toString())}), this.f246851d);
            return;
        L8:
            HybridLogger.k("XResourceLoader", "pull gecko resource Successfully,start deal result", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r113.toString()), TuplesKt.to("url", this.f246848a.f247858a.toString())}), this.f246851d);
            Task.call(new com.bytedance.ies.bullet.kit.resourceloader.loader.a(this.f246849b, this.f246848a, this.f246850c, this.f246852e, this.f246853f), Task.UI_THREAD_EXECUTOR);
        }

        @Override // v26.e
        public final void b(List<String> r110, Throwable r111) {
            Intrinsics.checkNotNullParameter(r110, "channelList");
            JSONObject r100 = this.f246848a.A.f17023e;
            if (r100 == null) goto L5;
            r100.put("gecko_update", this.f246849b.getInterval().a());
        L5:
            HybridLogger r101 = HybridLogger.f246343a;
            HybridLogger.k("XResourceLoader", "GeckoLoader check update failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", this.f246850c.toString()), TuplesKt.to("url", this.f246848a.f247858a.toString()), TuplesKt.to("message", r111.getMessage())}), this.f246851d);
            this.f246848a.f247869l = "gecko CheckUpdate Failed";
            l r102 = this.f246850c;
            if (r102.f552704g == false) goto L8;
            HybridLogger.k("XResourceLoader", "finish gecko update failed, skip callbacks when onlyLocal is true", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r102.toString()), TuplesKt.to("url", this.f246848a.f247858a.toString())}), this.f246851d);
            return;
        L8:
            HybridLogger.k("XResourceLoader", "pull gecko resource failed,try to read it, if it failed will go through the failure process", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r102.toString()), TuplesKt.to("url", this.f246848a.f247858a.toString())}), this.f246851d);
            Task.call(new a(this.f246849b, this.f246848a, this.f246850c, r111, this.f246852e, this.f246853f), Task.UI_THREAD_EXECUTOR);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(d1 r100, GeckoLoader r101, l r102, com.bytedance.ies.bullet.base.utils.logger.a r103, Function1<? super d1, Unit> r104, Function1<? super Throwable, Unit> r105) {
            this.f246848a = r100;
            this.f246849b = r101;
            this.f246850c = r102;
            this.f246851d = r103;
            this.f246852e = r104;
            this.f246853f = r105;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void cancelLoad() {
    }

    public final String toString() {
        return "GeckoLoader@" + this;
    }

    public GeckoLoader() {
        this.f246847a = "GECKO";
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final String getTAG() {
        return this.f246847a;
    }

    public static String d(l r100) {
        ConcurrentHashMap<String, ResourceLoaderService> r101 = i.f246824a;
        i.b(r100.f552701d, 2).f().a(r100.f552698a).getLoaderDepender().getSdkVersion();
        return "5.4.2.2-bugfix";
    }

    public static PolarisFileWrapper c(String r100, l r101) {
        String r102 = r101.f552698a;
        ConcurrentHashMap<String, ResourceLoaderService> r103 = i.f246824a;
        GeckoConfig r104 = i.b(r101.f552701d, 2).f().a(r101.f552698a);
        String r105 = r104.getLoaderDepender().g(r104.getOfflineDir(), r102, r100);
        boolean r106 = true;
        if (r105 != null) goto L5;
    L18:
        r105 = null;
    L19:
        y16.b r107 = y16.c.f565659a;
        y16.c.a("GeckoLoader using gecko info [accessKey=" + r102 + ",filePath=" + r105 + ']');
        if (r105 != null) goto L22;
    L25:
        if (r106 == false) goto L28;
        return null;
    L28:
        return new PolarisFileWrapper(r105);
    L22:
        if (r105.length() == 0) goto L25;
        r106 = false;
        goto L25
    L5:
        if (GkFSUtils.g(r105) == true) goto L19;
        if (new PolarisFileWrapper(r105).exists() == true) goto L19;
        String r108 = GkFSUtils.d(r101.f552698a, r101.f552705h, r105);
        if (r108 != null) goto L11;
    L14:
        boolean r109 = true;
    L15:
        if (r109 == false) goto L17;
        HybridLogger r110 = HybridLogger.f246343a;
        Map r111 = MapsKt.mapOf(TuplesKt.to(PlayerResolution.SDKKEY.ORIGIN, r105));
        com.bytedance.ies.bullet.base.utils.logger.a r112 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r112.a("resourceSession", r101.B);
        Unit r113 = Unit.INSTANCE;
        HybridLogger.g("XResourceLoader", "GkFS disable and origin file not exists", r111, r112);
        goto L18
    L17:
        r105 = r108;
        goto L19
    L11:
        if (r108.length() == 0) goto L14;
        r109 = false;
        goto L15
    }

    public static d f(d1 r110, l r111) {
        long r100 = SystemClock.uptimeMillis();
        String r101 = r111.f552705h;
        String r102 = r111.f552706i;
        boolean r112 = true;
        if (StringsKt.contains$default(r101, "../", false, 2, null) == false) goto L5;
    L8:
        ConcurrentHashMap<String, ResourceLoaderService> r103 = i.f246824a;
        j r104 = i.b(r111.f552701d, 2).f();
        SharedPreferences r105 = b26.b.f16998a;
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r111, "taskConfig");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r102, "bundle");
        Task.callInBackground(new b26.c(r104, r111, r101, r102));
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("XResourceLoader", "security check failed: gecko loader path traversal, channel: " + r101 + ", bundle: " + r102, null, 12);
        boolean r107 = true;
    L9:
        if (r107 == false) goto L12;
        r110.f247869l = "security check failed: gecko loader path traversal";
        r110.f247862e = false;
        return null;
    L12:
        k r108 = e(com.bytedance.ies.bullet.kit.resourceloader.l.b(com.bytedance.ies.bullet.kit.resourceloader.loader.b.a(r101, r102)), r111, r101);
        if (r108 == null) goto L22;
        com.bytedance.ies.bullet.kit.resourceloader.a r109 = r108.f246833a;
        if ((r109 instanceof d) == true) goto L18;
        r109 = null;
    L18:
        if (r109 == null) goto L20;
        d r113 = (d) r109;
    L21:
        d r114 = r113;
    L23:
        y16.b r115 = y16.c.f565659a;
        y16.c.a("GeckoLoader async load uri: " + r110.f247858a + " gecko only local");
        JSONObject r116 = r110.A.f17023e;
        if (r116 != null) goto L65;
    L33:
        if (r114 == null) goto L49;
        if (r114.f246808a.exists() == false) goto L49;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(r111.f552711n, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L43;
        PolarisFileInputStreamWrapper r118 = new PolarisFileInputStreamWrapper(r114.f246808a);     // Catch: Throwable -> L45
        if (r118.available() != 0) goto L42;
        r110.f247869l = "gecko size 0";     // Catch: Throwable -> L45
        r118.close();     // Catch: Throwable -> L45
        r110.f247862e = false;     // Catch: Throwable -> L45
        return null;
    L42:
        r118.close();     // Catch: Throwable -> L45
    L43:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        return r114;
    L45:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L49:
        if (r111.f552698a.length() != 0) goto L51;
        boolean r120 = true;
    L52:
        if (r120 == false) goto L61;
        String r121 = r110.f247869l;
        if (r121 != null) goto L56;
    L59:
        if (r112 == false) goto L61;
        r110.f247869l = "gecko accessKey invalid";
    L62:
        r110.f247862e = false;
        return null;
    L56:
        if (r121.length() == 0) goto L59;
        r112 = false;
    L61:
        r110.f247869l = "gecko File Not Found";
        goto L62
    L51:
        r120 = false;
        goto L52
    L65:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L27
        Object r123 = Result.m9449constructorimpl(Long.valueOf(JSONObjectProtectorUtils.getLong(r116, "gecko_local")));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r123) == false) goto L32;
        r123 = 0L;
    L32:
        r116.put("gecko_local", ((Number) r123).longValue() + (SystemClock.uptimeMillis() - r100));
    L27:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L20:
        r113 = null;
        goto L21
    L22:
        r114 = null;
        goto L23
    L5:
        if (StringsKt.contains$default(r102, "../", false, 2, null) == true) goto L8;
        r107 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final d1 loadSync(d1 r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "config");
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = true;
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        final CountDownLatch r104 = new CountDownLatch(1);
        loadAsync(r100, r101, new AnonymousClass1(r103, r104), new AnonymousClass2(r102, r104));
        r104.await(r101.f552702e, TimeUnit.MILLISECONDS);
        HybridLogger r105 = HybridLogger.f246343a;
        Map r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r100.f247858a.toString()), TuplesKt.to("loadSuccess", Boolean.valueOf(r102.element))});
        com.bytedance.ies.bullet.base.utils.logger.a r107 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r107.a("resourceSession", r101.B);
        Unit r108 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "GeckoLoader sync load", r106, r107);
        return (d1) r103.element;
    }

    public static void a(Uri r100, l r101, e r102) {
        HybridLogger r103 = HybridLogger.f246343a;
        boolean r104 = false;
        Map r105 = MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r101.toString()), TuplesKt.to("url", r100.toString())});
        com.bytedance.ies.bullet.base.utils.logger.a r106 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r106.a("resourceSession", r101.B);
        Unit r107 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "trigger gecko update", r105, r106);
        if (Intrinsics.areEqual(r100.getScheme(), "local_file") == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100.getAuthority(), SlcPosition.RELATIVE) == false) goto L25;
        String r108 = r100.getPath();
        if (r108 != null) goto L9;
        r108 = "";
    L9:
        String r109 = null;
        if (r108.length() > 1) goto L12;
    L14:
        if (r104 == true) goto L17;
        r108 = null;
    L17:
        if (r108 == null) goto L19;
        r109 = r108.substring(1);
    L19:
        if (r109 != null) goto L22;
        r102.b(new ArrayList(), new Exception("update failed because channel is null"));
        return;
    L22:
        ArrayList r110 = new ArrayList();
        r110.add(r109);
        ConcurrentHashMap<String, ResourceLoaderService> r111 = i.f246824a;
        i.b(r101.f552701d, 2).f().a(r101.f552698a).getLoaderDepender().a(r101, r110, r102);
        return;
    L12:
        if (StringsKt.startsWith$default(r108, HTTP.URL_DEFAULT, false, 2, null) == false) goto L14;
        r104 = true;
        goto L14
    }

    public static k e(Uri r100, l r101, String r102) {
        String r103 = r100.getScheme();     // Catch: FileNotFoundException -> L38
        if (r103 == null) goto L37;
        if (r103.hashCode() != 1303296464) goto L37;
        if (r103.equals("local_file") == false) goto L37;
        String r104 = r100.getAuthority();     // Catch: FileNotFoundException -> L38
        if (r104 == null) goto L35;
        int r105 = r104.hashCode();     // Catch: FileNotFoundException -> L38
        String r106 = "";
        if (r105 == (-554435892)) goto L25;
        if (r105 != 1728122231) goto L35;
        if (r104.equals(SlcPosition.ABSOLUTE) == false) goto L35;
        String r107 = r100.getPath();     // Catch: FileNotFoundException -> L38
        if (r107 == null) goto L23;
        r106 = r107;
    L23:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106);     // Catch: FileNotFoundException -> L38
    L31:
        if (r108 == null) goto L40;
        k r109 = new k(r100);     // Catch: FileNotFoundException -> L38
        y16.c.a("load from gecko success");     // Catch: FileNotFoundException -> L38
        d r110 = new d(r108);     // Catch: FileNotFoundException -> L38
        ResourceFrom r111 = ResourceFrom.GECKO;     // Catch: FileNotFoundException -> L38
        ConcurrentHashMap<String, ResourceLoaderService> r112 = i.f246824a;     // Catch: FileNotFoundException -> L38
        GeckoConfig r113 = i.b(r101.f552701d, 2).f().a(r101.f552698a);     // Catch: FileNotFoundException -> L38
        r110.f246810c = Long.valueOf(r113.getLoaderDepender().h(r113.getOfflineDir(), r101.f552698a, r102));     // Catch: FileNotFoundException -> L38
        r109.f246833a = r110;     // Catch: FileNotFoundException -> L38
        return r109;
    L40:
        return null;
    L25:
        if (r104.equals(SlcPosition.RELATIVE) == false) goto L35;
        String r114 = r100.getPath();     // Catch: FileNotFoundException -> L38
        if (r114 == null) goto L30;
        r106 = r114;
    L30:
        r108 = c(r106, r101);     // Catch: FileNotFoundException -> L38
    L35:
        throw new FileNotFoundException(r100 + " not found");     // Catch: FileNotFoundException -> L38
    L37:
        throw new FileNotFoundException(r100 + " not found");     // Catch: FileNotFoundException -> L38
    L38:
        return null;
    }

    public final void h(d1 r100, l r101, c r102) {
        if (r101.f552704g == false) goto L5;
        r100.f247869l = "gecko only local";
        JSONArray r103 = r100.B;
        JSONObject r104 = new JSONObject();
        r104.put("name", this.f246847a);
        r104.put("status", "failed");
        r104.put("detail", r100);
        r103.put(r104);
        HybridLogger r105 = HybridLogger.f246343a;
        Map r106 = MapsKt.mapOf(TuplesKt.to("reason", "gecko only local"));
        com.bytedance.ies.bullet.base.utils.logger.a r107 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r107.a("resourceSession", r101.B);
        Unit r108 = Unit.INSTANCE;
        HybridLogger.k("XResourceLoader", "GeckoLoader pull Gecko package sync failed", r106, r107);
        r102.b(CollectionsKt.mutableListOf(new String[]{r101.f552705h}), new Exception("gecko only local"));
    L5:
        Uri r109 = com.bytedance.ies.bullet.kit.resourceloader.l.b(r101.f552705h);
        r101.f552722y = 1;
        a(r109, r101, r102);
    }

    public final boolean g(d1 r100, boolean r101, l r102, d r103) {
        if (r103 != null) goto L5;
        return false;
    L5:
        r100.f247862e = r101;
        r100.f247859b = r103.f246808a.getAbsolutePath();
        r100.f247860c = ResourceType.DISK;
        r100.f247861d = ResourceFrom.GECKO;
        Long r104 = r103.f246810c;
        if (r104 == null) goto L8;
        long r105 = r104.longValue();
    L9:
        r100.f247863f = r105;
        JSONArray r106 = r100.B;
        JSONObject r107 = new JSONObject();
        r107.put("name", this.f246847a);
        r107.put("status", "success");
        r106.put(r107);
        d(r102);
        Intrinsics.checkNotNullParameter("5.4.2.2-bugfix", "<set-?>");
        r100.f247881x = "5.4.2.2-bugfix";
        String r108 = r102.f552705h;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r100.f247878u = r108;
        String r109 = r102.f552706i;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r100.f247879v = r109;
        String r110 = r102.f552698a;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r100.f247880w = r110;
        return true;
    L8:
        r105 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v34 */
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public final void loadAsync(d1 r210, l r211, Function1<? super d1, Unit> r310, Function1<? super Throwable, Unit> r311) {
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, "config");
        Intrinsics.checkNotNullParameter(r310, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r311, "reject");
        setInterval(new n());
        com.bytedance.ies.bullet.base.utils.logger.a r110 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r110.a("resourceSession", r211.B);
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "GeckoLoader start to async load from gecko", MapsKt.mapOf(new Pair[]{TuplesKt.to("channel", r211.f552705h), TuplesKt.to("bundle", r211.f552706i), TuplesKt.to("ak", r211.f552698a), TuplesKt.to("url", r210.f247858a.toString())}), r110);
        r210.f247869l = "";
        if (r211.f552710m == true) goto L10;
        r210.f247869l = "gecko disable";
        JSONArray r101 = r210.B;
        JSONObject r111 = new JSONObject();
        r111.put("name", this.f246847a);
        r111.put("status", "failed");
        r111.put("detail", r210.f247869l);
        r101.put(r111);
        JSONObject r102 = r210.A.f17023e;
        if (r102 == null) goto L7;
        r102.put("gecko_total", getInterval().b());
    L7:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load gecko disable", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("useGeckoLoader", Boolean.valueOf(r211.f552710m))}), r110);
        r311.invoke(new Throwable("gecko disable"));
        return;
    L10:
        if (r211.f552705h.length() != 0) goto L12;
        boolean r103 = true;
    L13:
        Object r212 = null;
        if (r103 == false) goto L55;
        k r104 = e(r210.f247858a, r211, r211.f552705h);
        if (r104 == null) goto L23;
        com.bytedance.ies.bullet.kit.resourceloader.a r105 = r104.f246833a;
        if ((r105 instanceof d) == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L23;
        d r106 = (d) r105;
    L24:
        if (r106 != null) goto L26;
    L50:
        r210.f247869l = "GFM:Channel/Bundle invalid";
        JSONArray r107 = r210.B;
        JSONObject r108 = new JSONObject();
        r108.put("name", this.f246847a);
        r108.put("status", "failed");
        r108.put("detail", r210.f247869l);
        r107.put(r108);
        JSONObject r109 = r210.A.f17023e;
        if (r109 == null) goto L53;
        r109.put("gecko_total", getInterval().b());
    L53:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load url failed,channel is empty for gecko", MapsKt.mapOf(TuplesKt.to("url", r210.f247858a.toString())), r110);
        r311.invoke(new IllegalArgumentException("channel is empty for gecko"));
        return;
    L26:
        if (r106.f246808a.exists() == false) goto L50;
        r210.f247859b = r106.f246808a.getAbsolutePath();
        r210.f247860c = ResourceType.DISK;
        r210.f247862e = true;
        String r112 = r210.f247858a.getAuthority();
        if (r112 == null) goto L42;
        int r113 = r112.hashCode();
        if (r113 == (-554435892)) goto L39;
        if (r113 != 1728122231) goto L42;
        if (r112.equals(SlcPosition.ABSOLUTE) == false) goto L42;
        r212 = ResourceFrom.LOCAL_FILE;
        goto L42
    L39:
        if (r112.equals(SlcPosition.RELATIVE) == false) goto L42;
        r212 = ResourceFrom.GECKO;
    L42:
        r210.f247861d = r212;
        JSONArray r114 = r210.B;
        JSONObject r115 = new JSONObject();
        r115.put("name", this.f246847a);
        r115.put("status", "success");
        r114.put(r115);
        Long r116 = r106.f246810c;
        if (r116 == null) goto L45;
        long r117 = r116.longValue();
    L46:
        r210.f247863f = r117;
        d(r211);
        Intrinsics.checkNotNullParameter("5.4.2.2-bugfix", "<set-?>");
        r210.f247881x = "5.4.2.2-bugfix";
        HybridLogger.k("XResourceLoader", "GeckoLoader async load url success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("resourceInfo", r210.toString())}), r110);
        JSONObject r118 = r210.A.f17023e;
        if (r118 == null) goto L49;
        r118.put("gecko_total", getInterval().b());
    L49:
        r310.invoke(r210);
        return;
    L45:
        r117 = 0;
    L23:
        r106 = null;
        goto L24
    L55:
        String r119 = r211.f552698a;
        if (r119.length() != 0) goto L58;
        boolean r120 = true;
    L59:
        if (r120 == false) goto L61;
        HybridLogger.k("XResourceLoader", "GeckoLoader config accessKey not found, using default", MapsKt.mapOf(TuplesKt.to("url", r210.f247858a.toString())), r110);
    L61:
        ConcurrentHashMap<String, ResourceLoaderService> r121 = i.f246824a;
        GeckoConfig r122 = i.b(r211.f552701d, 2).f().a(r119);
        if (r119.length() != 0) goto L64;
        boolean r123 = true;
    L65:
        if (r123 == false) goto L67;
        r119 = r122.getAccessKey();
    L67:
        String r124 = r119;
        Uri r125 = r210.f247858a;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L74
        String r127 = UriProtector.getQueryParameter(r125, "dynamic");     // Catch: Throwable -> L74
        if (r127 == null) goto L71;
        Integer r128 = Integer.valueOf(CastIntegerProtector.parseInt(r127));     // Catch: Throwable -> L74
    L72:
        Object r129 = Result.m9449constructorimpl(r128);     // Catch: Throwable -> L74
    L77:
        if (Result.m9455isFailureimpl(r129) == true) goto L80;
        r212 = r129;
    L80:
        Integer r213 = (Integer) r212;
        Integer r130 = r211.f552703f;
        if (r130 == null) goto L83;
        int r131 = r130.intValue();
    L86:
        HybridLogger r132 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "GeckoLoader load detail", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("accessKey", r124), TuplesKt.to("channel", r211.f552705h), TuplesKt.to("bundle", r211.f552706i), TuplesKt.to("dynamic", Integer.valueOf(r131)), TuplesKt.to("config", r211.toString())}), r110);
        c r133 = new c(r210, this, r211, r110, r310, r311);
        if (r131 == 0) goto L130;
        if (r131 == 1) goto L115;
        if (r131 != 2) goto L93;
        r210.f247862e = false;
        if (r211.f552704g == false) goto L112;
        JSONObject r134 = r210.A.f17023e;
        if (r134 == null) goto L111;
        r134.put("gecko_total", getInterval().b());
    L111:
        HybridLogger.k("XResourceLoader", "GeckoLoader pull sync,but onlyLocal", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131)), TuplesKt.to("onlyLocal", Boolean.valueOf(r211.f552704g))}), r110);
        r311.invoke(new Throwable("GeckoLoader pull sync but onlyLocal，reject"));
    L112:
        h(r210, r211, r133);
    L143:
        return;
    L93:
        if (r131 == 3) goto L115;
        if (g(r210, true, r211, f(r210, r211)) == false) goto L100;
        JSONObject r135 = r210.A.f17023e;
        if (r135 == null) goto L99;
        r135.put("gecko_total", getInterval().b());
    L99:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load uri gecko success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131))}), r110);
        r310.invoke(r210);
        goto L143
    L100:
        JSONObject r136 = r210.A.f17023e;
        if (r136 == null) goto L103;
        r136.put("gecko_total", getInterval().b());
    L103:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load uri gecko file not found", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131))}), r110);
        r311.invoke(new Throwable("Gecko File not found"));
    L115:
        boolean r137 = r122.getLoaderDepender().c(r122.getOfflineDir(), r124, r211.f552705h);
        Uri r138 = com.bytedance.ies.bullet.kit.resourceloader.l.b(r211.f552705h);
        if (r137 == false) goto L118;
        ?? r139 = 1;
    L128:
        r210.f247862e = r139;
        Pair[] r140 = new Pair[3];
        r140[0] = TuplesKt.to("url", r210.f247858a.toString());
        r140[r139] = TuplesKt.to("dynamic", String.valueOf(r131));
        r140[2] = TuplesKt.to("isCache", Boolean.TRUE);
        HybridLogger.k(r26, "GeckoLoader load from cache", MapsKt.mapOf(r140), r110);
        b(r137, r210, r211, null, r310, r311);
        a(r138, r211, new b());
        return;
    L118:
        if (r131 != 3) goto L120;
        r139 = 1;
        goto L128
    L120:
        r210.f247862e = false;
        if (r211.f552704g == false) goto L126;
        HybridLogger.k("XResourceLoader", "GeckoLoader pull sync,but onlyLocal", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131)), TuplesKt.to("onlyLocal", Boolean.valueOf(r211.f552704g))}), r110);
        JSONObject r141 = r210.A.f17023e;
        if (r141 == null) goto L125;
        r141.put("gecko_total", getInterval().b());
    L125:
        r311.invoke(new Throwable("GeckoLoader pull sync but onlyLocal，reject"));
    L126:
        h(r210, r211, r133);
        return;
    L130:
        if (g(r210, true, r211, f(r210, r211)) == false) goto L135;
        JSONObject r142 = r210.A.f17023e;
        if (r142 == null) goto L134;
        r142.put("gecko_total", getInterval().b());
    L134:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load uri no update load success", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131))}), r110);
        r310.invoke(r210);
        return;
    L135:
        JSONObject r143 = r210.A.f17023e;
        if (r143 == null) goto L138;
        r143.put("gecko_total", getInterval().b());
    L138:
        HybridLogger.k("XResourceLoader", "GeckoLoader async load uri no update load failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r210.f247858a.toString()), TuplesKt.to("dynamic", String.valueOf(r131))}), r110);
        r311.invoke(new Throwable("Gecko File not found"));
        return;
    L83:
        if (r213 == null) goto L85;
        r131 = r213.intValue();
        goto L86
    L85:
        r131 = 0;
        goto L86
    L71:
        r128 = null;
    L74:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L77
    L64:
        r123 = false;
        goto L65
    L58:
        r120 = false;
        goto L59
    L12:
        r103 = false;
        goto L13
    }

    public final void b(boolean r110, d1 r111, l r210, Throwable r211, Function1<? super d1, Unit> r212, Function1<? super Throwable, Unit> r213) {
        com.bytedance.ies.bullet.base.utils.logger.a r100 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r100.a("resourceSession", r210.B);
        y16.b r101 = y16.c.f565659a;
        StringBuilder r102 = new StringBuilder("GeckoLoader#dealResult: input=");
        r102.append(r111);
        r102.append(",throwable=");
        if (r211 == null) goto L5;
        String r103 = r211.getMessage();
    L6:
        r102.append(r103);
        y16.c.a(r102.toString());
        if (r211 == null) goto L13;
        JSONArray r104 = r111.B;
        JSONObject r105 = new JSONObject();
        r105.put("name", this.f246847a);
        r105.put("status", "failed");
        r105.put("detail", r211.getMessage());
        r104.put(r105);
        JSONObject r106 = r111.A.f17023e;
        if (r106 == null) goto L11;
        r106.put("gecko_total", getInterval().b());
    L11:
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "fetch gecko failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", r211.getMessage()), TuplesKt.to("taskConfig", r210.toString()), TuplesKt.to("url", r111.f247858a.toString())}), r100);
        r213.invoke(r211);
        return;
    L13:
        boolean r108 = g(r111, r110, r210, f(r111, r210));
        JSONArray r109 = r111.B;
        JSONObject r112 = new JSONObject();
        r112.put("name", this.f246847a);
        if (r108 == false) goto L16;
        r112.put("status", "success");
    L17:
        r109.put(r112);
        if (r108 == false) goto L23;
        JSONObject r113 = r111.A.f17023e;
        if (r113 == null) goto L22;
        r113.put("gecko_total", getInterval().b());
    L22:
        HybridLogger r114 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "fetch gecko successfully", MapsKt.mapOf(new Pair[]{TuplesKt.to("taskConfig", r210.toString()), TuplesKt.to("url", r111.f247858a.toString()), TuplesKt.to("isCache", Boolean.valueOf(r110))}), r100);
        r212.invoke(r111);
        return;
    L23:
        JSONObject r115 = r111.A.f17023e;
        if (r115 == null) goto L26;
        r115.put("gecko_total", getInterval().b());
    L26:
        HybridLogger r116 = HybridLogger.f246343a;
        HybridLogger.k("XResourceLoader", "fetch gecko failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "Gecko File not found"), TuplesKt.to("taskConfig", r210.toString()), TuplesKt.to("url", r111.f247858a.toString()), TuplesKt.to("isCache", Boolean.valueOf(r110))}), r100);
        r213.invoke(new Throwable("Gecko File not found"));
        return;
    L16:
        r112.put("status", "failed");
        r112.put("detail", "Gecko File not found");
        goto L17
    L5:
        r103 = null;
        goto L6
    }
}
