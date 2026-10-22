package com.larus.community.impl.cache;

import android.os.Looper;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes27.dex */
public final class CreationListCacheDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationListCacheDataSource f328905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> f328906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f328907c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Keva f328908d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f328909e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f328910f;

    public CreationListCacheDataSource() {
    }

    static {
        f328905a = new CreationListCacheDataSource();
        f328906b = new ConcurrentHashMap();
        f328907c = new ConcurrentHashMap();
        f328908d = Keva.getRepo("creation_feed_local_cache", 0);
        f328909e = LazyKt.lazy(new a());
    }

    public static String b(String r100) {
        return "creation_local_cache_" + AccountService.f365697a.getSecUserId() + '_' + r100;
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
        boolean r103 = m29.a.f511679a;
        m29.a.b("CreationListCacheDataSource", "prefetch callback failed, updateCache:" + r101 + ", error:" + th.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(String r110, CommunityCreationRecommendRepository r111, Function1 r112) {
        Intrinsics.checkNotNullParameter(r111, "creationFeedRepository");
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L15;
        boolean r113 = m29.a.f511679a;
        m29.a.c("CreationListCacheDataSource", "prefetch fail creationRecommendType is " + r110);
        if (r112 == 0) goto L17;
        r112.invoke(Boolean.FALSE);
        return;
    L17:
        return;
    L15:
        boolean r101 = m29.a.f511679a;
        m29.a.c("CreationListCacheDataSource", "start prefetch, creationRecommendType:" + r110);
        String r102 = b(r110);
        f328906b.put(r102, j1.a(null));
        f328908d.storeString(r102, "");
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = r112;
        final Job r114 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CreationListCacheDataSource$prefetch$job$1(r102, r111, r110, r103, null), 2, null);
        f328910f = r114;
        r114.invokeOnCompletion(new b(r114));
        return;
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public final Object e(String r100, CreationFeedCacheEntity r101, Continuation<? super Unit> r102) {
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
        Object r110 = Result.m9449constructorimpl(((Gson) f328909e.getValue()).toJson(r101));     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r110) == false) goto L29;
        r110 = null;
    L29:
        String r111 = (String) r110;
        if (r111 == null) goto L33;
        boolean r112 = m29.a.f511679a;
        m29.a.c("CreationListCacheDataSource", "[updateLocalCreationCache] cacheKey = " + r108);
        f328908d.storeString(r108, r111);
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
        r108 = b(r100);
        ConcurrentHashMap<String, z0<CreationFeedCacheEntity>> r114 = f328906b;
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

    public static CreationFeedCacheEntity c(CreationListCacheDataSource r100, String r101, boolean r102, boolean r103, int r104) {
        boolean r105 = true;
        if ((r104 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = true;
    L8:
        r100.getClass();
        if (r102 == false) goto L14;
        Job r106 = f328910f;
        if (r106 == null) goto L13;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L13:
        f328910f = null;
    L14:
        if (r101 == null) goto L55;
        String r107 = b(r101);
        boolean r108 = m29.a.f511679a;
        m29.a.c("CreationListCacheDataSource", "[getCreationFromCache] cacheKey = " + r107);
        z0<CreationFeedCacheEntity> r109 = f328906b.get(r107);
        if (r109 == null) goto L19;
        CreationFeedCacheEntity r110 = r109.getValue();
    L20:
        if (r110 != null) goto L46;
        if (r103 == true) goto L24;
    L44:
        m29.a.a("CreationListCacheDataSource", new c());
    L45:
        r110 = null;
        goto L46
    L24:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L44;
        m29.a.c("CreationListCacheDataSource", "[getCreationFromLocal] cacheKey = " + r107);
        String r111 = f328908d.getString(r107, "");
        if (r111 != null) goto L29;
    L32:
        if (r105 == false) goto L51;
        r110 = null;
    L42:
        if (r110 == null) goto L45;
    L51:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        Object r113 = Result.m9449constructorimpl((CreationFeedCacheEntity) ((Gson) f328909e.getValue()).fromJson(r111, CreationFeedCacheEntity.class));     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r113) == false) goto L41;
        r113 = null;
    L41:
        r110 = (CreationFeedCacheEntity) r113;
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L29:
        if (r111.length() == 0) goto L32;
        r105 = false;
    L46:
        if (r110 != null) goto L48;
        return null;
    L48:
        if (Intrinsics.areEqual(r110.getCreationRecommendType(), r101) == true) goto L50;
        return null;
    L50:
        return r110;
    L19:
        r110 = null;
        goto L20
    L55:
        return null;
    }
}
