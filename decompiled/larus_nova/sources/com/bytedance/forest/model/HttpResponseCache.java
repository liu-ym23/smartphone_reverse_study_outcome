package com.bytedance.forest.model;

import android.os.Handler;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class HttpResponseCache extends h.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f244252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile PolarisFileWrapper f244253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f244254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f244256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<l> f244257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<Map<String, String>> f244258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f244259i;

    public static final class a {
    }

    public static final class b implements com.bytedance.forest.model.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpResponseCache f244260a;

        @Override // com.bytedance.forest.model.b
        public final boolean b() {
            return true;
        }

        @Override // com.bytedance.forest.model.b
        public final InputStream a() {
            PolarisFileWrapper r100 = this.f244260a.f244253c;     // Catch: Exception -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwNpe();     // Catch: Exception -> L7
        L5:
            return new PolarisFileInputStreamWrapper(r100);
        L7:
            e = move-exception;
            com.bytedance.forest.utils.i r101 = com.bytedance.forest.utils.i.f244548a;
            StringBuilder r102 = new StringBuilder("error occurs when getting input stream from ResponseCache, file: ");
            PolarisFileWrapper r103 = this.f244260a.f244253c;
            if (r103 == null) goto L11;
            String r104 = r103.getPath();
        L12:
            r102.append(r104);
            com.bytedance.forest.utils.i.e(r101, ForestBuffer.TAG, r102.toString(), e, true, 112);
            return null;
        L11:
            r104 = null;
            goto L12
        }

        public b(HttpResponseCache r100) {
            this.f244260a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpResponseCache f244261a;

        public c(HttpResponseCache r100) {
            this.f244261a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f244261a.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f244263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f244264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.forest.utils.c f244265d;

        public d(String r100, Map r101, String r102, com.bytedance.forest.utils.c r103) {
            this.f244262a = r100;
            this.f244263b = r101;
            this.f244264c = r102;
            this.f244265d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = MD5Utils.stringToMd5(this.f244262a);     // Catch: Throwable -> L4
            com.bytedance.forest.utils.c.a(this.f244265d, 4, "ResponseCache", "json recorded: " + r100 + " for key:" + this.f244264c, true, null, null, 48);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.forest.utils.c f244267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f244268c;

        public e(String r100, com.bytedance.forest.utils.c r101, String r102) {
            this.f244266a = r100;
            this.f244267b = r101;
            this.f244268c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = MD5Utils.stringToMd5(this.f244266a);     // Catch: Throwable -> L4
            com.bytedance.forest.utils.c.a(this.f244267b, 4, "ResponseCache", "json recorded2: " + r100 + " for key:" + this.f244268c, true, null, null, 48);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean a() {
        if (this.f244252b == true) goto L9;
        com.bytedance.forest.utils.i r100 = com.bytedance.forest.utils.i.f244548a;
        StringBuilder r101 = new StringBuilder();
        String r102 = this.f244254d;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L7:
        r101.append(r102);
        r101.append(" is not valid");
        com.bytedance.forest.utils.i.f("ResponseCache", r101.toString(), 4);
    L9:
        return this.f244252b;
    }

    public final String b() {
        String r100 = this.f244254d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L5:
        return r100;
    }

    public final HttpResponseCache c() {
        h.a r100 = this.f244338a.get();
        if ((r100 instanceof HttpResponseCache) == true) goto L6;
        r100 = null;
    L6:
        return (HttpResponseCache) r100;
    }

    public final boolean e() {
        if (this.f244252b == true) goto L5;
    L7:
        return false;
    L5:
        if (System.currentTimeMillis() <= this.f244256f) goto L7;
        return true;
    }

    public final void h() {
        WeakReference<l> r100 = this.f244257g;
        if (r100 == null) goto L5;
        l r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
    L21:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        PolarisFileWrapper r103 = this.f244253c;     // Catch: Throwable -> L17
        if (r103 == null) goto L14;
        Boolean r104 = Boolean.valueOf(r103.delete());     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L17
    L19:
        this.f244253c = null;
        return;
    L14:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L8:
        if (r101.isCacheReady$forest_release() == true) goto L21;
        ((Handler) ThreadUtils.f244503b.getValue()).postDelayed(new c(this), 300000);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final Map<String, String> g() {
        Map<String, String> r100 = null;
        if (a() == true) goto L5;
        return null;
    L5:
        WeakReference<Map<String, String>> r101 = this.f244258h;
        if (r101 == null) goto L10;
        Map<String, String> r102 = r101.get();
        if (r102 == null) goto L10;
        r100 = r102;
    L19:
        if (r100 == null) goto L21;
        this.f244258h = new WeakReference(r100);
    L21:
        return r100;
    L10:
        Keva r103 = com.bytedance.forest.utils.n.f244584a;
        String r104 = this.f244254d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L13:
        Keva r105 = com.bytedance.forest.utils.n.f244584a;
        if (r105 == null) goto L16;
        String r106 = r105.getStringJustDisk(r104, null);
    L17:
        if (r106 == null) goto L19;
        OfflineUtil.f244497d.getClass();
        r100 = (Map) GsonProtectorUtils.fromJson(OfflineUtil.f244495b, r106, new HashMap().getClass());
        goto L19
    L16:
        r106 = null;
        goto L17
    }

    public HttpResponseCache(String r100) {
        this.f244259i = r100;
        this.f244252b = true;
    }

    public final void d(boolean r100) {
        this.f244252b = false;
        com.bytedance.forest.utils.n r101 = com.bytedance.forest.utils.n.f244585b;
        String r102 = this.f244254d;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L5:
        r101.delete(r102);
        if (r100 == true) goto L17;
        h();
        return;
    L17:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        PolarisFileWrapper r104 = this.f244253c;     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        Boolean r105 = Boolean.valueOf(r104.delete());     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
        return;
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public HttpResponseCache(String r100, String r101) {
        this(r100);
        List r102 = StringsKt.split$default(r101, new String[]{"-"}, false, 0, 6, null);
        if (r102.size() != 3) goto L21;
        Integer r103 = StringsKt.toIntOrNull((String) ListProtector.get(r102, 1));
        if (r103 == null) goto L19;
        this.f244255e = r103.intValue();
        Long r104 = StringsKt.toLongOrNull((String) ListProtector.get(r102, 2));
        if (r104 == null) goto L17;
        this.f244256f = r104.longValue();
        PolarisFileWrapper r105 = new PolarisFileWrapper(CDNFetchDepender.c(), r101);
        if (r105.exists() == false) goto L15;
        if (r105.isFile() == false) goto L15;
        this.f244254d = r101;
        this.f244253c = r105;
        return;
    L15:
        throw new IllegalArgumentException("cache not exists or not a file");
    L17:
        throw new IllegalArgumentException("file name not valid");
    L19:
        throw new IllegalArgumentException("file name not valid");
    L21:
        throw new IllegalArgumentException("file name not valid");
    }

    public final l f(com.bytedance.forest.utils.e r100, Request r101) {
        l r102 = null;
        if (a() == true) goto L5;
        return null;
    L5:
        WeakReference<l> r103 = this.f244257g;
        if (r103 == null) goto L8;
        l r104 = r103.get();
    L10:
        if (r104 != null) goto L12;
    L14:
        PolarisFileWrapper r105 = this.f244253c;
        if (r105 != null) goto L17;
    L19:
        if (r102 == null) goto L21;
        this.f244257g = new WeakReference(r102);
    L21:
        return r102;
    L17:
        if (r105.isFile() != true) goto L19;
        r102 = r100.a(new b(this), r101);
        goto L19
    L12:
        if (r104.isCacheProvided$forest_release() != true) goto L14;
        r102 = r104;
        goto L19
    L8:
        r104 = null;
        goto L10
    }

    public final void i(ForestNetAPI.a r210, ForestNetAPI.HttpResponse r211, l r212, final Response r213) {
        this.f244257g = new WeakReference(r212);
        final StringBuilder r100 = new StringBuilder(this.f244259i);
        r100.append(':');
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = true;
        OfflineUtil r102 = OfflineUtil.f244497d;
        Function2<String, Map<String, ? extends String>, String> r103 = new HttpResponseCache$updateFromOnline$result$1(r101, r100);
        r102.getClass();
        HashMap r104 = new HashMap();
        Iterator<Map.Entry<String, String>> r105 = r211.f244422c.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry<String, String> r106 = r105.next();
        r104.put(r106.getKey(), r106.getValue());
        goto L4
    L6:
        String r107 = (String) r104.get("vary");
        if (r107 == null) goto L13;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L13;
        String r110 = r108.toLowerCase(Locale.ENGLISH);
        if (r110 == null) goto L13;
        List r109 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
    L14:
        if (r109 != null) goto L17;
        r109 = CollectionsKt.emptyList();
    L17:
        List r111 = CollectionsKt.sorted(r109);
        r104.put("vary", CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, null, 62, null));
        r104.put("forest-append-on-request", String.valueOf(r211.f244423d));
        Iterator r112 = r111.iterator();
    L19:
        if (r112.hasNext() == false) goto L25;
        String r113 = (String) r112.next();
        String r114 = "forest-append-" + r113;
        Map<String, ? extends String> r115 = r210.f244425b;
        if (r115 != null) goto L24;
        r115 = MapsKt.emptyMap();
    L24:
        r104.put(r114, r103.invoke(r113, r115));
        goto L19
    L25:
        Pair r116 = new Pair(r104, Integer.valueOf(r111.size()));
        final Map r117 = (Map) r116.getFirst();
        this.f244258h = new WeakReference(r117);
        OfflineUtil.f244497d.getClass();
        Long r118 = OfflineUtil.d(r211);
        if (r118 == null) goto L109;
        long r119 = r118.longValue();
        StringBuilder r120 = new StringBuilder();
        String r121 = MD5Utils.stringToMd5(r100.toString());
        if (r121 == null) goto L107;
        r120.append(r121.substring(0, 8));
        r120.append("-");
        r120.append(((Number) r116.getSecond()).intValue());
        r120.append("-");
        r120.append(r119);
        String r122 = r120.toString();
    L30:
        com.bytedance.forest.utils.n r123 = com.bytedance.forest.utils.n.f244585b;
        Keva r124 = com.bytedance.forest.utils.n.f244584a;
        if (r124 == null) goto L33;
        boolean r125 = r124.contains(r122);
    L34:
        if (r125 == false) goto L36;
        r122 = "forest_" + r122;
        goto L30
    L36:
        final com.bytedance.forest.utils.c r126 = r213.D;
        if (this.f244253c == null) goto L70;
        PolarisFileWrapper r127 = this.f244253c;
        if (r127 == null) goto L41;
        String r128 = r127.getName();
    L43:
        if ((!Intrinsics.areEqual(r128, r122)) == false) goto L70;
        final String r129 = this.f244254d;
        if (r129 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L47:
        this.f244254d = r122;
        this.f244255e = ((Number) r116.getSecond()).intValue();
        this.f244256f = r119;
        if (e() == false) goto L50;
        return;
    L50:
        final PolarisFileWrapper r130 = new PolarisFileWrapper(CDNFetchDepender.c(), r122);
        if (r130.exists() == false) goto L54;
        com.bytedance.forest.utils.c.a(r126, 6, "ResponseCache", "update but new file already existed", true, null, null, 48);
        return;
    L54:
        PolarisFileWrapper r131 = this.f244253c;
        if (r131 != null) goto L119;
        return;
    L119:
        r131.renameTo(r130);     // Catch: Throwable -> L65
        r213.f244318t = r130.getAbsolutePath();     // Catch: Throwable -> L65
        r213.n(FilePathType.Disk);     // Catch: Throwable -> L65
        OfflineUtil.f244497d.getClass();     // Catch: Throwable -> L65
        final String r132 = GsonProtectorUtils.toJson(OfflineUtil.f244495b, r117);     // Catch: Throwable -> L65
        if (r124 == null) goto L59;
        r124.storeStringJustDisk(r122, r132);     // Catch: Throwable -> L65
    L59:
        final String r133 = r122;
        com.bytedance.forest.utils.c r134 = r126;
        com.bytedance.forest.utils.c.c(r126, 4, "ResponseCache", false, null, null, new HttpResponseCache$updateFromOnline$$inlined$also$lambda$1(r132, this, r130, r213, r117, r133, r126, r129), 28);     // Catch: Throwable -> L63
        this.f244253c = r130;     // Catch: Throwable -> L63
        r123.delete(r129);     // Catch: Throwable -> L63
        ((Handler) ThreadUtils.f244503b.getValue()).post(new d(r132, r117, r122, r134));     // Catch: Throwable -> L63
        return;
    L63:
        th = th;
    L67:
        com.bytedance.forest.utils.c.a(r134, 6, "ResponseCache", "rename failed", true, th, null, 32);
        return;
    L65:
        th = th;
        r134 = r126;
        goto L67
    L41:
        r128 = null;
    L70:
        if (this.f244253c != null) goto L128;
        this.f244254d = r122;
        this.f244255e = ((Number) r116.getSecond()).intValue();
        this.f244256f = r119;
        PolarisFileWrapper r135 = new PolarisFileWrapper(CDNFetchDepender.c(), r122 + "_tmp");
        PolarisFileWrapper r136 = new PolarisFileWrapper(CDNFetchDepender.c(), r122);
        com.bytedance.forest.utils.c.a(r126, 4, "ResponseCache", "start to write file, " + r122, false, null, null, 56);     // Catch: Throwable -> L102
        r135.delete();     // Catch: Throwable -> L102
        r136.delete();     // Catch: Throwable -> L102
        InputStream r137 = r212.provideInputStream(r213);     // Catch: Throwable -> L102
        if (r137 != null) goto L121;
        int r138 = -1;
    L95:
        if (r138 <= 0) goto L100;
        r135.renameTo(r136);     // Catch: Throwable -> L102
        r213.f244318t = r136.getAbsolutePath();     // Catch: Throwable -> L102
        r213.n(FilePathType.Disk);     // Catch: Throwable -> L102
        OfflineUtil.f244497d.getClass();     // Catch: Throwable -> L102
        final String r139 = GsonProtectorUtils.toJson(OfflineUtil.f244495b, r117);     // Catch: Throwable -> L102
        if (r124 == null) goto L99;
        r124.storeStringJustDisk(r122, r139);     // Catch: Throwable -> L102
    L99:
        com.bytedance.forest.utils.c.c(r126, 4, "ResponseCache", false, null, null, new HttpResponseCache$updateFromOnline$3(r139), 28);     // Catch: Throwable -> L102
        this.f244253c = r136;     // Catch: Throwable -> L102
        ((Handler) ThreadUtils.f244503b.getValue()).post(new e(r139, r126, r122));     // Catch: Throwable -> L102
        return;
    L100:
        d(true);     // Catch: Throwable -> L102
        r135.delete();     // Catch: Throwable -> L102
        throw new IOException("written file size is unexpected");     // Catch: Throwable -> L102
    L121:
        PolarisFileOutputStreamWrapper r140 = new PolarisFileOutputStreamWrapper(r135);     // Catch: Throwable -> L87
        r138 = (int) ByteStreamsKt.copyTo$default(r137, r140, 0, 2, null);     // Catch: Throwable -> L80
        Unit r141 = Unit.INSTANCE;     // Catch: Throwable -> L80
        CloseableKt.closeFinally(r140, null);     // Catch: Throwable -> L87
        CloseableKt.closeFinally(r137, null);     // Catch: Throwable -> L102
        goto L95
    L80:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        CloseableKt.closeFinally(r140, th);     // Catch: Throwable -> L87
        throw th;     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        CloseableKt.closeFinally(r137, th);     // Catch: Throwable -> L102
        throw th;     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        com.bytedance.forest.utils.i.e(com.bytedance.forest.utils.i.f244548a, "ResponseCache", "write file failed", th, true, 112);
        this.f244252b = false;
        r135.delete();
        r136.delete();
        this.f244253c = null;
        throw th;
    L128:
        return;
    L33:
        r125 = false;
        goto L34
    L107:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L109:
        throw new IllegalArgumentException("Cache not supported since no expired time provided");
    L13:
        r109 = null;
        goto L14
    }
}
