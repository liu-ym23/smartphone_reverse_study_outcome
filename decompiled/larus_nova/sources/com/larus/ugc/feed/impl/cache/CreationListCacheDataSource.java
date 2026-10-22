package com.larus.ugc.feed.impl.cache;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationListCacheDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationListCacheDataSource f374641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> f374642b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f374643c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f374644d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f374645e = null;

    public CreationListCacheDataSource() {
    }

    static {
        f374641a = new CreationListCacheDataSource();
        f374642b = new ConcurrentHashMap();
        f374643c = new ConcurrentHashMap();
        f374644d = LazyKt.lazy(new a());
        f374645e = LazyKt.lazy(new b());
    }

    public static final void a(Ref.ObjectRef r100, boolean r101) {
        Function1 r102 = (Function1) r100.element;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.invoke(Boolean.valueOf(r101));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        boolean r103 = w0a.a.f557826a;
        w0a.a.b("CreationListCacheDataSource", "prefetch callback failed, updateCache:" + r101 + ", error:" + th.getMessage());
    }

    public final Object b(String r100, CreationFeedCacheEntity r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof CreationListCacheDataSource$updateCreationCache$1) == false) goto L7;
        CreationListCacheDataSource$updateCreationCache$1 r103 = (CreationListCacheDataSource$updateCreationCache$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        String r108 = (String) r103.L$1;
        r101 = (CreationFeedCacheEntity) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L34:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L24
        Object r110 = Result.m9449constructorimpl(((Gson) f374645e.getValue()).toJson(r101));     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r110) == false) goto L29;
        r110 = null;
    L29:
        String r111 = (String) r110;
        if (r111 == null) goto L33;
        boolean r112 = w0a.a.f557826a;
        w0a.a.c("CreationListCacheDataSource", "[updateLocalCreationCache] cacheKey = " + r108);
        f374641a.getClass();
        ((Keva) f374644d.getValue()).storeString(r108, r111);
    L33:
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r108 = "creation_local_cache_" + AccountService.f365697a.getSecUserId() + '_' + r100;
        ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> r114 = f374642b;
        if (r114.get(r108) != null) goto L17;
        r114.put(r108, j1.a(r101));
        goto L34
    L17:
        z0<CreationFeedCacheEntity> r115 = r114.get(r108);
        if (r115 == null) goto L34;
        r103.L$0 = r101;
        r103.L$1 = r108;
        r103.label = 1;
        if (r115.emit(r101, r103) != r106) goto L34;
        return r106;
    L7:
        r103 = new CreationListCacheDataSource$updateCreationCache$1(this, r102);
        goto L8
    }
}
