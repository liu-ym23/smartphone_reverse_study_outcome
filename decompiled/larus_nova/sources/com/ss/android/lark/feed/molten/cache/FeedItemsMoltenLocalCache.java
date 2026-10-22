package com.ss.android.lark.feed.molten.cache;

import com.google.gson.Gson;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache;
import com.ss.android.lark.feed.molten.cache.utils.FeedItemsLocalCacheUtil;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import geb.c;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class FeedItemsMoltenLocalCache implements com.ss.android.lark.feed.molten.cache.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f421025i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f421026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f421027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, FeedUserHolderLocalCache> f421028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f421029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f421030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f421031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f421032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f421033h;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache$1", f = "FeedItemsMoltenLocalCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FeedItemsMoltenLocalCache this$0;

        public AnonymousClass1(FeedItemsMoltenLocalCache r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            FeedItemsMoltenLocalCache r102 = this.this$0;
            com.ss.android.lark.storage.a r103 = FeedItemsMoltenLocalCache.f421025i;
            Set<String> r104 = r102.j();
            c.d("FeedItemsMoltenLocalCache", "preload known uids size=" + r104.size());
            FeedItemsMoltenLocalCache r105 = this.this$0;
            Iterator<T> r106 = r104.iterator();
        L6:
            if (r106.hasNext() == false) goto L15;
            String r107 = (String) r106.next();
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L10
            Object r109 = Result.m9449constructorimpl(r105.g(r107));     // Catch: Throwable -> L10
        L12:
            Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
            if (r110 == null) goto L6;
            c.b("FeedItemsMoltenLocalCache", "preload ensureHolder failed, uid=" + r107, r110);
        L10:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        L15:
            this.this$0.h();
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a {
    }

    public static final class b implements ttb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedItemsMoltenLocalCache f421034a;

        public b(FeedItemsMoltenLocalCache r100) {
            this.f421034a = r100;
        }

        @Override // ttb.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == false) goto L10;
            c.a("FeedItemsMoltenLocalCache", "callback onUserOnline skip, uid is empty");
            return;
        L10:
            c.c("FeedItemsMoltenLocalCache", "callback onUserOnline uid=" + r100);
            FeedItemsMoltenLocalCache r102 = this.f421034a;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
            com.ss.android.lark.storage.a r104 = FeedItemsMoltenLocalCache.f421025i;     // Catch: Throwable -> L13
            Object r105 = Result.m9449constructorimpl(r102.g(r100));     // Catch: Throwable -> L13
        L15:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L21;
            c.b("FeedItemsMoltenLocalCache", "onUserOnline ensureHolder failed, uid=" + r100, r106);
            return;
        L21:
            return;
        L13:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L5:
            r101 = false;
            goto L7
        }

        @Override // ttb.a
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == false) goto L10;
            c.a("FeedItemsMoltenLocalCache", "callback onUserOffline skip, uid is empty");
            return;
        L10:
            c.d("FeedItemsMoltenLocalCache", "callback onUserOffline uid=" + r100);
            this.f421034a.f(r100);
            return;
        L5:
            r101 = false;
            goto L7
        }
    }

    static {
        f421025i = new com.ss.android.lark.storage.a("feed::molten::index");
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final boolean c() {
        return this.f421026a.get();
    }

    public final void h() {
        if (this.f421033h.compareAndSet(false, true) == true) goto L20;
        return;
    L20:
        stb.a r100 = (stb.a) LarkContext.spiByDwarf(stb.a.class);     // Catch: Throwable -> L7
    L9:
        if (r100 != null) goto L22;
        c.a("FeedItemsMoltenLocalCache", "ensureUserIdListener skip, officeSDKUserApi is null");
        this.f421033h.set(false);
        return;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        r100.Y0(new b(this));     // Catch: Throwable -> L14
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L24;
        c.b("FeedItemsMoltenLocalCache", "registerUserIdChanged failed", r103);
        this.f421033h.set(false);
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        c.b("FeedItemsMoltenLocalCache", "spiByDwarf(officeSDKUserApi) failed", th);
        r100 = null;
        goto L9
    }

    public final FeedUserHolderLocalCache i() {
        stb.a r100 = (stb.a) LarkContext.spiByDwarf(stb.a.class);     // Catch: Throwable -> L5
    L7:
        if (r100 == null) goto L9;
        String r101 = r100.a();
    L10:
        boolean r102 = false;
        if (r101 != null) goto L13;
    L18:
        if (r102 == true) goto L21;
        c.a("FeedItemsMoltenLocalCache", "hostUid is empty, register user id listener");
        h();
        return null;
    L21:
        c.c("FeedItemsMoltenLocalCache", "hostUid=" + r101);
        return g(r101);
    L13:
        if (r101.length() != 0) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
        r102 = true;
        goto L18
    L15:
        r103 = false;
        goto L16
    L9:
        r101 = null;
    L5:
        th = move-exception;
        c.b("FeedItemsMoltenLocalCache", "spiByDwarf(officeSDKUserApi) failed", th);
        r100 = null;
        goto L7
    }

    public final Set<String> j() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        Set<String> r101 = ((KVRepo) this.f421030e.getValue()).getStringSet("known_uids", SetsKt.emptySet());     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        r101 = SetsKt.emptySet();     // Catch: Throwable -> L7
    L5:
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        c.b("FeedItemsMoltenLocalCache", "readKnownUids failed", r103);
    L12:
        Set r104 = SetsKt.emptySet();
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = r104;
    L16:
        return (Set) r102;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Inject
    public FeedItemsMoltenLocalCache() {
        this.f421026a = new AtomicBoolean(false);
        this.f421027b = LazyKt.lazy(FeedItemsMoltenLocalCache$gson$2.INSTANCE);
        this.f421028c = new ConcurrentHashMap();
        this.f421029d = new Object();
        this.f421030e = LazyKt.lazy(FeedItemsMoltenLocalCache$indexRepo$2.INSTANCE);
        this.f421031f = LazyKt.lazy(FeedItemsMoltenLocalCache$clearScope$2.INSTANCE);
        Lazy r100 = LazyKt.lazy(FeedItemsMoltenLocalCache$preloadScope$2.INSTANCE);
        this.f421032g = r100;
        this.f421033h = new AtomicBoolean(false);
        c.c("FeedItemsMoltenLocalCache", "preload all known uids");
        BuildersKt.launch$default((CoroutineScope) r100.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final com.ss.android.lark.feed.molten.cache.a b() {
        FeedUserHolderLocalCache r100 = i();
        if (r100 != null) goto L7;
        c.d("FeedItemsMoltenLocalCache", "restoreHumanSidebarFeedItems skip, no current uid");
        return null;
    L7:
        return r100.g();
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final List<UIFeedCard> d() {
        FeedUserHolderLocalCache r100 = i();
        if (r100 != null) goto L5;
        c.d("FeedItemsMoltenLocalCache", "restoreLatestFeedItems skip, no current uid");
        List<UIFeedCard> r101 = CollectionsKt.emptyList();
    L7:
        if ((!r101.isEmpty()) == false) goto L9;
        this.f421026a.compareAndSet(false, true);
    L9:
        return r101;
    L5:
        r101 = r100.h();
        goto L7
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        c.a("FeedItemsMoltenLocalCache", "clearLocalCacheData skip, uid is empty");
        return;
    L9:
        c.c("FeedItemsMoltenLocalCache", "clearLocalCacheData uid = " + r100);
        Object r103 = this.f421029d;
        monitor-enter(r103);
        FeedUserHolderLocalCache r104 = this.f421028c.remove(r100);     // Catch: Throwable -> L19
        if (r104 == null) goto L15;
        r104.d();     // Catch: Throwable -> L19
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L16:
        monitor-exit(r103);
        c.d("FeedItemsMoltenLocalCache", "clearLocalCacheData enqueue, uid=" + r100 + ", disposedActive=" + r101);
        this.f421026a.set(false);
        BuildersKt.launch$default((CoroutineScope) this.f421031f.getValue(), null, null, new FeedItemsMoltenLocalCache$clearLocalCacheData$2(this, r100, null), 3, null);
        return;
    L15:
        r101 = false;
    L19:
        th = move-exception;
        throw th;
    L5:
        r102 = false;
        goto L6
    }

    public final FeedUserHolderLocalCache g(String r100) {
        FeedUserHolderLocalCache r101 = this.f421028c.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Object r102 = this.f421029d;
        monitor-enter(r102);
        FeedUserHolderLocalCache r103 = this.f421028c.get(r100);     // Catch: Throwable -> L23
        if (r103 != null) goto L21;
        r103 = new FeedUserHolderLocalCache(r100, (Gson) this.f421027b.getValue());     // Catch: Throwable -> L23
        r103.i();     // Catch: Throwable -> L23
        this.f421028c.put(r100, r103);     // Catch: Throwable -> L23
        c.d("FeedItemsMoltenLocalCache", "ensureHolder created for uid=".concat(r100));     // Catch: Throwable -> L23
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        Set<String> r105 = j();     // Catch: Throwable -> L16
        if (r105.contains(r100) == true) goto L14;
        ((KVRepo) this.f421030e.getValue()).putStringSet("known_uids", SetsKt.plus(r105, r100));     // Catch: Throwable -> L16
    L14:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L23
        if (r107 == null) goto L21;
        c.b("FeedItemsMoltenLocalCache", "addKnownUid failed, uid=".concat(r100), r107);     // Catch: Throwable -> L23
        goto L21
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L23
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L21:
        monitor-exit(r102);
        return r103;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void e(List<? extends UIFeedCard> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "latestItems");
        FeedUserHolderLocalCache r102 = i();
        if (r102 != null) goto L6;
        c.a("FeedItemsMoltenLocalCache", "syncLatestFeedItems skip, no current uid");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "latestItems");
        List<UIFeedCard> r103 = FeedItemsLocalCacheUtil.b(r100, r101);
        r102.f421045f.set(r103);
        Object r104 = r102.f421044e.mo10962trySendJP2dKIU(Unit.INSTANCE);
        StringBuilder r105 = new StringBuilder("syncLatestFeedItems enqueue, inputSize:");
        r105.append(r100.size());
        r105.append(", normalizedSize:");
        r105.append(r103.size());
        r105.append(", success:");
        g.c r106 = g.f504696b;
        r105.append(!(r104 instanceof g.c));
        r105.append(", closed:");
        r105.append(r104 instanceof g.a);
        c.c("FeedUserHolderLocalCache", r105.toString());
    }

    @Override // com.ss.android.lark.feed.molten.cache.b
    public final void a(List r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "latestItems");
        FeedUserHolderLocalCache r103 = i();
        if (r103 != null) goto L6;
        c.a("FeedItemsMoltenLocalCache", "syncHumanSidebarFeedItems skip, no current uid");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "latestItems");
        r103.f421047h.set(new com.ss.android.lark.feed.molten.cache.a(FeedItemsLocalCacheUtil.a(r100), r101, r102));
        r103.f421046g.mo10962trySendJP2dKIU(Unit.INSTANCE);
    }
}
