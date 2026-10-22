package com.bytedance.forest.model;

import android.content.res.AssetManager;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.Forest;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public class Response {
    public boolean A;
    public long B;
    public String C;
    public final com.bytedance.forest.utils.c D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f244299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f244300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f244301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile WebResourceResponse f244302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForestNetAPI.HttpResponse f244303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f244304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f244305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f244306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f244307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile transient SoftReference<CloseableReference<CloseableBitmap>> f244308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f244309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f244310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f244311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f244312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f244313o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FilePathType f244314p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Request f244315q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f244316r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ErrorInfo f244317s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f244318t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ResourceFrom f244319u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ResourceFrom2 f244320v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ResourceFrom f244321w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ResourceFrom2 f244322x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f244323y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f244324z;

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a extends ForestNetAPI.HttpResponse {
        @Override // com.bytedance.forest.pollyfill.ttnet.ForestNetAPI.HttpResponse
        public final InputStream b() {
            return null;
        }

        public a(int r100, String r101, Map r102, long r103) {
            super(r100, r101, r102, r103);
        }
    }

    public final ForestNetAPI.HttpResponse b() {
        ForestNetAPI.HttpResponse r100 = this.f244303e;
        if (r100 == null) goto L15;
        int r101 = r100.f244420a;
        if (r101 == 304) goto L7;
        return r100;
    L7:
        String r102 = r100.f244421b;
        Map<String, String> r103 = this.f244304f;
        if (r103 == null) goto L12;
        Map r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L12;
    L14:
        return new a(r101, r102, r104, r100.f244423d);
    L12:
        r104 = new LinkedHashMap();
        goto L14
    L15:
        return null;
    }

    public final String c() {
        if (this.f244316r == true) goto L7;
        return null;
    L7:
        return this.f244307i;
    }

    public final String d() {
        if (this.f244316r == false) goto L17;
        String r100 = this.f244305g;
        if (r100 != null) goto L7;
    L11:
        String r101 = e();
        OfflineUtil.f244497d.getClass();
        String r102 = OfflineUtil.e(r101);
        if (r102 != null) goto L15;
        r102 = "unknown";
    L15:
        this.f244305g = r102;
    L19:
        return this.f244305g;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L19;
    L9:
        r103 = false;
        goto L10
    L17:
        return null;
    }

    public final String e() {
        String r100 = this.f244318t;
        if (r100 == null) goto L9;
        OfflineUtil.f244497d.getClass();
        String r101 = OfflineUtil.b(r100, true);
        if (r101 != null) goto L7;
        return r101;
    L7:
        if (StringsKt.contains$default(r101, "rl_resource_offline", false, 2, null) == true) goto L13;
        return r101;
    L13:
        return OfflineUtil.b(this.f244315q.getOriginUrl(), false);
    L9:
        OfflineUtil r102 = OfflineUtil.f244497d;
        String r103 = this.f244315q.getOriginUrl();
        r102.getClass();
        return OfflineUtil.b(r103, false);
    }

    public final CloseableReference<CloseableBitmap> f() {
        SoftReference<CloseableReference<CloseableBitmap>> r100 = this.f244308j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public void i() {
        k r100 = this.f244306h;     // Catch: Throwable -> L6
        if (r100 == null) goto L8;
        r100.tryLoadToMemory$forest_release(this);     // Catch: Throwable -> L6
    L8:
        if (r100 != null) goto L10;
    L11:
        this.f244316r = false;     // Catch: Throwable -> L6
        this.f244317s.c(ErrorInfo.Type.Pipeline, 4, "fetch succeeded but IO failed, cache cleared, inMemoryBuffer=" + this.f244306h);     // Catch: Throwable -> L6
        return;
    L10:
        if (r100.isCacheClear$forest_release() == true) goto L11;
        return;
    L6:
        th = move-exception;
        this.f244316r = false;
        this.f244317s.c(ErrorInfo.Type.Pipeline, 4, "fetch succeeded but IO failed, occurred by " + th);
    }

    public byte[] j() {
        if (this.f244316r == true) goto L5;
        return null;
    L5:
        k r100 = this.f244306h;
        if (r100 == null) goto L11;
        byte[] r101 = r100.provideBytes();
        if (r101 == null) goto L11;
        return r101;
    L11:
        if (this.f244320v != ResourceFrom2.MEMORY) goto L13;
    L16:
        com.bytedance.forest.utils.l r102 = this.f244315q.getForest().getMemoryManager$forest_release().b(this.f244315q.getCacheKey$forest_release(), this.f244315q.getEnableRequestReuse());
        if (r102 == null) goto L26;
        k r103 = r102.f244578a;
        if (r103 == null) goto L26;
        this.f244306h = r103;
        byte[] r104 = r103.provideBytes();
        if (r104 == null) goto L26;
        if (this.f244315q.getEnableRequestReuse() == false) goto L25;
        this.f244309k = true;
    L25:
        return r104;
    L26:
        k r105 = this.f244306h;
        if (r105 == null) goto L31;
        this.f244306h = r105;
        byte[] r106 = r105.provideBytes();
        if (r106 == null) goto L31;
        return r106;
    L31:
        k r107 = this.f244306h;
        if (r107 != null) goto L77;
    L43:
        int r108 = com.bytedance.forest.utils.h.f244547a;
        if (this.f244316r == true) goto L47;
        return null;
    L47:
        if (this.f244320v != ResourceFrom2.MEMORY) goto L49;
        com.bytedance.forest.utils.i.e(com.bytedance.forest.utils.i.f244548a, null, "resource from memory but call loadAsBytes", null, true, 112);
        this.f244317s.c(ErrorInfo.Type.Memory, 2, "resource from memory but call loadAsBytes");
        this.f244319u = this.f244321w;
        this.f244320v = this.f244322x;
    L49:
        Forest r109 = this.f244315q.getForest();
        InputStream r110 = l();
        if (r110 != null) goto L79;
        byte[] r111 = null;
    L67:
        if (r111 != null) goto L81;
        r109.getMemoryManager$forest_release().d(this.f244315q.getCacheKey$forest_release());
        return null;
    L81:
        return r111;
    L79:
        r111 = ByteStreamsKt.readBytes(r110);     // Catch: Throwable -> L56
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L60:
        CloseableKt.closeFinally(r110, null);
    L54:
        th = th;
    L71:
        com.bytedance.forest.utils.i.e(com.bytedance.forest.utils.i.f244548a, null, "error occurs when read data", th, true, 112);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);
        throw th;
    L56:
        th = th;
        r111 = null;
        goto L71
    L77:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L38
        r107.tryLoadToMemory$forest_release(this);     // Catch: Throwable -> L38
        byte[] r114 = r107.provideBytes();     // Catch: Throwable -> L38
        if (r114 == null) goto L36;
        return r114;
    L36:
        Object r115 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L38
    L40:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L43;
        com.bytedance.forest.utils.c.a(this.D, 6, "provideBytes", "error occurred when provide bytes from buffer", true, r116, null, 32);
    L38:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L13:
        if (this.f244315q.getEnableRequestReuse() == true) goto L16;
        if (this.f244315q.getEnableMemoryCache() == false) goto L31;
        goto L16
    }

    public final ByteBuffer k() {
        if (this.f244316r == true) goto L5;
        return null;
    L5:
        k r100 = this.f244306h;
        if (r100 == null) goto L11;
        ByteBuffer r101 = a(r100);
        if (r101 == null) goto L11;
        return r101;
    L11:
        if (this.f244319u != ResourceFrom.MEMORY) goto L13;
    L16:
        com.bytedance.forest.utils.l r102 = this.f244315q.getForest().getMemoryManager$forest_release().b(this.f244315q.getCacheKey$forest_release(), this.f244315q.getEnableRequestReuse());
        if (r102 == null) goto L26;
        k r103 = r102.f244578a;
        if (r103 == null) goto L26;
        this.f244306h = r103;
        ByteBuffer r104 = a(r103);
        if (r104 == null) goto L26;
        if (this.f244315q.getEnableRequestReuse() == false) goto L25;
        this.f244309k = true;
    L25:
        return r104;
    L26:
        k r105 = this.f244306h;
        if (r105 == null) goto L32;
        this.f244306h = r105;
        ByteBuffer r106 = a(r105);
        if (r106 == null) goto L32;
        return r106;
    L32:
        if (this.f244315q.getUseDirectBuffer$forest_release() == false) goto L45;
        k r107 = this.f244306h;
        if (r107 == null) goto L45;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L40
        r107.tryLoadToMemory$forest_release(this);     // Catch: Throwable -> L40
        ByteBuffer r109 = a(r107);     // Catch: Throwable -> L40
        if (r109 == null) goto L38;
        return r109;
    L38:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L45;
        com.bytedance.forest.utils.c.a(this.D, 6, "provideDirectBuffer", "error occurred when provide provideDirectBuffer from buffer", true, r111, null, 32);
    L40:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L45:
        return null;
    L13:
        if (this.f244315q.getEnableRequestReuse() == true) goto L16;
        if (this.f244315q.getEnableMemoryCache() == false) goto L32;
        goto L16
    }

    public synchronized InputStream l() {
        monitor-enter(this);
    L59:
        th = move-exception;
        throw th;
    L5:
        DefaultConstructorMarker r100 = null;
        if (this.f244316r == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Forest r101 = this.f244315q.getForest();     // Catch: Throwable -> L59
        k r102 = this.f244306h;     // Catch: Throwable -> L59
        if (r102 == null) goto L20;
        byte[] r103 = r102.provideBytes();     // Catch: Throwable -> L59
        if (r103 == null) goto L16;
        ByteArrayInputStream r104 = new ByteArrayInputStream(r103);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r104;
    L16:
        InputStream r105 = r102.provideInputStream(this);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r105;
    L20:
        if (this.f244315q.getEnableMemoryCache() == false) goto L22;
    L23:
        com.bytedance.forest.utils.l r106 = r101.getMemoryManager$forest_release().b(this.f244315q.getCacheKey$forest_release(), this.f244315q.getEnableRequestReuse());     // Catch: Throwable -> L59
        if (r106 == null) goto L32;
        k r107 = r106.f244578a;     // Catch: Throwable -> L59
        if (r107 == null) goto L32;
        InputStream r108 = r107.provideInputStream(this);     // Catch: Throwable -> L59
        if (r108 == null) goto L32;
        this.f244306h = r107;     // Catch: Throwable -> L59
        monitor-exit(this);
        return r108;
    L32:
        r101.getMemoryManager$forest_release().d(this.f244315q.getCacheKey$forest_release());     // Catch: Throwable -> L59
        String r109 = this.f244318t;     // Catch: Throwable -> L59
        if (r109 != null) goto L35;
    L56:
        this.f244306h = null;     // Catch: Throwable -> L59
        com.bytedance.forest.utils.c.a(this.D, 6, "provideInputStream", "fetch succeeded but IO failed", true, null, null, 48);     // Catch: Throwable -> L59
        monitor-exit(this);
        return null;
    L35:
        boolean r110 = false;
        if (r109.length() <= 0) goto L38;
        boolean r111 = true;
    L39:
        if (r111 == true) goto L42;
        r109 = null;
    L42:
        if (r109 == null) goto L56;
    L53:
        e = move-exception;
        com.bytedance.forest.utils.c.a(this.D, 6, "provideInputStream", "error occurs when getting input stream from response, file: " + r109 + ", type:" + this.f244314p, true, e, null, 32);     // Catch: Throwable -> L59
        goto L56
    L44:
        if (this.f244314p != FilePathType.Asset) goto L46;
        InputStream r112 = Forest.Companion.getApp().getAssets().open(r109);     // Catch: Exception -> L53 Throwable -> L59
    L51:
        monitor-exit(this);
        return r112;
    L46:
        PolarisFileWrapper r113 = new PolarisFileWrapper(r109);     // Catch: Exception -> L53 Throwable -> L59
        if (GkFSUtils.g(r109) == false) goto L50;
        this.f244312n = true;     // Catch: Exception -> L53 Throwable -> L59
        r112 = new GkFSFileInputStream(r113, r110, 2, r100);     // Catch: Exception -> L53 Throwable -> L59
        goto L51
    L50:
        r112 = new PolarisFileInputStreamWrapper(r113);     // Catch: Exception -> L53 Throwable -> L59
        goto L51
    L38:
        r111 = false;
        goto L39
    L22:
        if (this.f244315q.getEnableRequestReuse() == false) goto L32;
        goto L23
    }

    public final WebResourceResponse m() {
        WebResourceResponse r100 = null;
        if (this.f244316r == false) goto L55;
        ForestNetAPI.HttpResponse r101 = this.f244303e;
        if (r101 != null) goto L7;
    L9:
        WebResourceResponse r102 = this.f244302d;
        if (r102 == null) goto L12;
        r100 = r102;
        goto L55
    L12:
        FilePathType r103 = this.f244314p;
        if (r103 == null) goto L55;
        int r104 = q.f244368a[r103.ordinal()];
        boolean r105 = false;
        if (r104 != 1) goto L18;
        OfflineUtil r106 = OfflineUtil.f244497d;
        AssetManager r107 = Forest.Companion.getApp().getAssets();
        String r108 = this.f244318t;
        r106.getClass();
        if (r107 == null) goto L55;
        if (r108 != null) goto L46;
    L47:
        r105 = true;
    L48:
        if (r105 == true) goto L55;
        String r109 = OfflineUtil.e(OfflineUtil.b(r108, true));
        if (r109 != null) goto L54;
        r109 = "";
    L54:
        r100 = OfflineUtil.c(r109, "", r107.open(r108), r108, null, 200);
        goto L55
    L46:
        if (r108.length() != 0) goto L48;
    L18:
        if (r104 != 2) goto L55;
        String r110 = this.f244318t;
        InputStream r111 = l();
        if (r111 == null) goto L55;
        OfflineUtil r112 = OfflineUtil.f244497d;
        String r113 = d();
        String r114 = c();
        r112.getClass();
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L40
        if (r110 == null) goto L38;
        PolarisFileWrapper r116 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L40
        if (r116.exists() == true) goto L28;
    L30:
        if (r105 == true) goto L33;
        r116 = null;
    L33:
        if (r116 == null) goto L38;
        if (r113 == null) goto L36;
        String r117 = r113;
    L37:
        r100 = OfflineUtil.c(r117, r114, r111, r110, null, 200);     // Catch: Throwable -> L40
        goto L55
    L36:
        r117 = OfflineUtil.e(OfflineUtil.b(r110, true));     // Catch: Throwable -> L40
        goto L37
    L28:
        if (r116.isDirectory() == true) goto L30;
        r105 = true;
    L38:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L7:
        if (r101.a() != true) goto L9;
    L55:
        if (r100 != null) goto L61;
    L60:
        return r100;
    L61:
        Map<String, String> r119 = com.bytedance.forest.utils.b.a(r100);     // Catch: Throwable -> L58
        r119.put("forest_res_load_start", String.valueOf(((ConcurrentHashMap) this.f244301c).get("res_load_start")));     // Catch: Throwable -> L58
        r119.put("forest_res_load_finish", String.valueOf(((ConcurrentHashMap) this.f244301c).get("res_load_finish")));     // Catch: Throwable -> L58
        r119.put("forest_res_from", h(this.f244320v));     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        com.bytedance.forest.utils.c.a(this.D, 6, "provideWebResourceResponse", "error occur cause by " + th.getMessage(), false, null, null, 56);
        goto L60
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L22
        r100.append(super.toString());     // Catch: Throwable -> L22
        r100.append("(request=");     // Catch: Throwable -> L22
        r100.append(this.f244315q);     // Catch: Throwable -> L22
        r100.append(", isSucceed=");     // Catch: Throwable -> L22
        r100.append(this.f244316r);     // Catch: Throwable -> L22
        r100.append(", errorInfo=");     // Catch: Throwable -> L22
        r100.append(this.f244317s);     // Catch: Throwable -> L22
        r100.append(", filePath=");     // Catch: Throwable -> L22
        r100.append(this.f244318t);     // Catch: Throwable -> L22
        r100.append(", filePathType=");     // Catch: Throwable -> L22
        r100.append(this.f244314p);     // Catch: Throwable -> L22
        r100.append(", from=");     // Catch: Throwable -> L22
        r100.append(this.f244320v);     // Catch: Throwable -> L22
        r100.append(", originFrom=");     // Catch: Throwable -> L22
        r100.append(this.f244322x);     // Catch: Throwable -> L22
        r100.append(", isCache=");     // Catch: Throwable -> L22
        r100.append(this.f244323y);     // Catch: Throwable -> L22
        r100.append(", version=");     // Catch: Throwable -> L22
        r100.append(this.B);     // Catch: Throwable -> L22
        r100.append(", successFetcher=");     // Catch: Throwable -> L22
        r100.append(this.C);     // Catch: Throwable -> L22
        r100.append(", isCanceled=");     // Catch: Throwable -> L22
        r100.append(this.f244299a);     // Catch: Throwable -> L22
        r100.append(", isRedirection=");     // Catch: Throwable -> L22
        r100.append(this.A);     // Catch: Throwable -> L22
        r100.append(", isNegotiation=");     // Catch: Throwable -> L22
        r100.append(this.f244324z);     // Catch: Throwable -> L22
        r100.append(", httpCode=");     // Catch: Throwable -> L22
        ForestNetAPI.HttpResponse r101 = this.f244303e;     // Catch: Throwable -> L22
        Object r102 = null;
        if (r101 == null) goto L6;
        Integer r103 = Integer.valueOf(r101.f244420a);     // Catch: Throwable -> L22
    L7:
        r100.append(r103);     // Catch: Throwable -> L22
        r100.append(", webResourceResponse=");     // Catch: Throwable -> L22
        r100.append(this.f244302d);     // Catch: Throwable -> L22
        r100.append("(data=");     // Catch: Throwable -> L22
        WebResourceResponse r104 = this.f244302d;     // Catch: Throwable -> L22
        if (r104 == null) goto L10;
        InputStream r105 = r104.getData();     // Catch: Throwable -> L22
    L11:
        r100.append(r105);     // Catch: Throwable -> L22
        r100.append(", size=");     // Catch: Throwable -> L22
        WebResourceResponse r106 = this.f244302d;     // Catch: Throwable -> L18
        if (r106 == null) goto L20;
        InputStream r107 = r106.getData();     // Catch: Throwable -> L18
        if (r107 == null) goto L20;
        r102 = Integer.valueOf(r107.available());     // Catch: Throwable -> L18
    L20:
        r100.append(r102);     // Catch: Throwable -> L22
        r100.append("), image=");     // Catch: Throwable -> L22
        r100.append(f());     // Catch: Throwable -> L22
        r100.append(", inMemoryBuffer=");     // Catch: Throwable -> L22
        r100.append(this.f244306h);     // Catch: Throwable -> L22
        r100.append(", dataType=");     // Catch: Throwable -> L22
        r100.append(d());     // Catch: Throwable -> L22
        r100.append(", charset=");     // Catch: Throwable -> L22
        r100.append(c());     // Catch: Throwable -> L22
        r100.append(", isPreloaded=");     // Catch: Throwable -> L22
        r100.append(this.f244309k);     // Catch: Throwable -> L22
        r100.append(", isRequestReused=");     // Catch: Throwable -> L22
        r100.append(this.f244310l);     // Catch: Throwable -> L22
        r100.append(", isStreamLoaded=");     // Catch: Throwable -> L22
        r100.append(this.f244311m);     // Catch: Throwable -> L22
        r100.append(", delegatedByTTWebView=");     // Catch: Throwable -> L22
        r100.append(this.f244313o);     // Catch: Throwable -> L22
        r100.append(')');     // Catch: Throwable -> L22
        return r100.toString();
    L18:
        th = move-exception;
        r102 = th.getMessage();     // Catch: Throwable -> L22
        goto L20
    L10:
        r105 = null;
        goto L11
    L6:
        r103 = null;
    L22:
        th = move-exception;
        com.bytedance.forest.utils.c.a(this.D, 6, "resp", "Response toString error", true, th, null, 32);
        return super.toString();
    }

    public final String p() {
        return super.toString();
    }

    public Response(Response r110) {
        this(new Request(r110.f244315q), r110.f244316r, r110.f244317s, r110.f244318t, r110.f244319u, r110.f244320v, r110.f244321w, r110.f244322x, r110.f244323y, r110.f244324z, r110.A, r110.B, r110.C, r110.D);
        this.f244299a = r110.f244299a;
        this.f244300b = r110.f244300b;
        Map<String, Long> r100 = this.f244301c;
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        r101.putAll(r110.f244301c);
        this.f244302d = r110.f244302d;
        this.f244303e = r110.f244303e;
        this.f244304f = r110.f244304f;
        this.f244305g = r110.d();
        this.f244306h = r110.f244306h;
        this.f244307i = r110.c();
        this.f244308j = r110.f244308j;
        this.f244309k = r110.f244309k;
        this.f244310l = r110.f244310l;
        this.f244312n = r110.f244312n;
        n(r110.f244314p);
    }

    public static ByteBuffer a(k r100) {
        ByteBuffer r101 = null;
        if ((r100 instanceof m) == true) goto L14;
        boolean r102 = r100 instanceof ForestBuffer;
        if (r102 == false) goto L11;
        if (r102 == true) goto L8;
        r100 = null;
    L8:
        ForestBuffer r103 = (ForestBuffer) r100;
        if (r103 == null) goto L11;
        r101 = r103.provideDirectBuffer();
    L11:
        if (r101 == null) goto L13;
        r101.flip();
    L13:
        return r101;
    L14:
        m r104 = (m) r100;
        throw null;
    }

    public static String h(ResourceFrom2 r100) {
        if (r100 == null) goto L8;
        String r101 = r100.toString();
        if (r101 == null) goto L8;
        String r102 = r101.toLowerCase(Locale.ROOT);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "unknown";
    }

    @Deprecated(message = "more detail in new api", replaceWith = @ReplaceWith(expression = "getSourceType2", imports = {"ResourceFrom2?"}))
    public final String g(ResourceFrom r100) {
        if (r100 == null) goto L12;
        int r101 = q.f244369b[r100.ordinal()];
        if (r101 != 1) goto L7;
        return "memory";
    L7:
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L11;
        return "builtin";
    L11:
        if (r101 != 4) goto L12;
        if (this.f244323y == false) goto L16;
        return "cdn_cache";
    L16:
        return "cdn";
    L19:
        if (this.f244323y == false) goto L21;
        return "gecko";
    L21:
        return "gecko_update";
    L12:
        return "unknown";
    }

    public final void n(FilePathType r100) {
        if (this.f244318t != null) goto L5;
        r100 = null;
    L5:
        this.f244314p = r100;
    }

    public final void o(final k r210) {
        final k r100 = this.f244306h;
        if (r100 != r210) goto L5;
        return;
    L5:
        com.bytedance.forest.utils.l r101 = this.f244315q.getForest().getMemoryManager$forest_release().b(this.f244315q.getCacheKey$forest_release(), this.f244315q.isPreload());
        Unit r102 = null;
        if (r101 == null) goto L8;
        k r103 = r101.f244578a;
    L9:
        if (r103 == r100) goto L21;
        com.bytedance.forest.utils.c.c(this.D, 4, "setInMemoryBuffer", true, null, null, new Response$setInMemoryBuffer$1(r100), 24);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        if (r100 == null) goto L14;
        r100.close();     // Catch: Throwable -> L16
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r105 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L16
    L18:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        com.bytedance.forest.utils.c.c(this.D, 6, "setInMemoryBuffer", false, r106, null, new Response$setInMemoryBuffer$$inlined$onFailure$lambda$1(this, r100), 20);
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        com.bytedance.forest.utils.c.c(this.D, 4, "setInMemoryBuffer", true, null, null, new Response$setInMemoryBuffer$4(r100, r210), 24);
        this.f244306h = r210;
        return;
    L8:
        r103 = null;
        goto L9
    }

    public /* synthetic */ Response(Request r110, com.bytedance.forest.utils.c r111) {
        this(r110, false, new ErrorInfo(0), null, null, null, null, null, false, false, false, 0, "", r111);
    }

    public Response(Request r100, boolean r101, ErrorInfo r102, String r103, ResourceFrom r104, ResourceFrom2 r105, ResourceFrom r106, ResourceFrom2 r107, boolean r108, boolean r110, boolean r111, long r112, String r113, com.bytedance.forest.utils.c r114) {
        this.f244315q = r100;
        this.f244316r = r101;
        this.f244317s = r102;
        this.f244318t = r103;
        this.f244319u = r104;
        this.f244320v = r105;
        this.f244321w = r106;
        this.f244322x = r107;
        this.f244323y = r108;
        this.f244324z = r110;
        this.A = r111;
        this.B = r112;
        this.C = r113;
        this.D = r114;
        this.f244301c = new ConcurrentHashMap();
    }
}
