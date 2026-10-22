package com.larus.utils.cache;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import okio.ByteString;

/* JADX INFO: loaded from: classes31.dex */
public final class DiskCache {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f375373d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f375375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f375376c;

    public static final class a {
    }

    static {
        f375373d = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.larus.utils.cache.a()));
    }

    public DiskCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        this.f375374a = r100;
        this.f375375b = BdpOkClient.CACHE_MAX_SIZE;
        this.f375376c = LazyKt.lazy(new b(this));
    }

    public static String a(String r100) {
        ByteString.Companion.getClass();
        return ByteString.a.b(r100).md5().hex();
    }

    public final boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r110, "key");
        boolean r100 = true;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L20;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DiskCache$getCacheFileSync$1$1$1(this, r110, null), 3, null);     // Catch: Throwable -> L12
        String r111 = AppHost.f326268a.getApplication().getCacheDir() + '/' + this.f375374a + '/' + a(r110) + ".0";     // Catch: Throwable -> L12
        if (new PolarisFileWrapper(r111).exists() == false) goto L20;
    L22:
        if (r111.length() == 0) goto L25;
        r100 = false;
    L25:
        if (r100 == false) goto L28;
        return false;
    L28:
        return new PolarisFileWrapper(r111).exists();
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Object r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r112) == true) goto L17;
        r102 = r112;
    L17:
        Object r105 = (Void) r102;
        if (r105 == null) goto L20;
        r111 = (String) r105;
    L20:
        r111 = "";
        goto L22
    L5:
        r101 = false;
        goto L6
    }

    public final Object c(String r100, Continuation<? super String> r101) {
        return BuildersKt.withContext(f375373d, new DiskCache$getString$2(r100, this, null), r101);
    }

    public final Object e(String r100, Continuation<? super Boolean> r101) {
        return BuildersKt.withContext(f375373d, new DiskCache$remove$2(this, r100, null), r101);
    }

    public final Object d(String r100, String r101, Continuation<Object> r102) {
        return BuildersKt.withContext(f375373d, new DiskCache$put$4(r100, this, r101, null), r102);
    }
}
