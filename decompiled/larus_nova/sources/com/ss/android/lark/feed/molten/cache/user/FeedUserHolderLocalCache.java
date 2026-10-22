package com.ss.android.lark.feed.molten.cache.user;

import com.google.gson.Gson;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.molten.cache.utils.FeedItemsLocalCacheUtil;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedUserHolderLocalCache {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f421039p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f421040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f421041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f421042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f421043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Channel<Unit> f421044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<List<UIFeedCard>> f421045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Channel<Unit> f421046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<com.ss.android.lark.feed.molten.cache.a> f421047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f421048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List<String> f421049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Map<String, ? extends UIFeedCard> f421050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile List<? extends UIFeedCard> f421051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompletableDeferred<List<UIFeedCard>> f421052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompletableDeferred<com.ss.android.lark.feed.molten.cache.a> f421053n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile com.ss.android.lark.feed.molten.cache.a f421054o;

    public static final class a {
    }

    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedUserHolderLocalCache f421055a;

        public b(FeedUserHolderLocalCache r100) {
            this.f421055a = r100;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "feed-molten-local-cache-" + this.f421055a.f421040a);
            r101.setDaemon(true);
            return r101;
        }
    }

    static {
    }

    public final void d() {
        geb.c.d("FeedUserHolderLocalCache", "UserHolder dispose");
        if (this.f421052m.isCompleted() == true) goto L6;
        this.f421052m.complete(CollectionsKt.emptyList());
    L6:
        if (this.f421053n.isCompleted() == true) goto L8;
        this.f421053n.complete(null);
    L8:
        SendChannel.a.a(this.f421044e);
        SendChannel.a.a(this.f421046g);
        CoroutineScopeKt.cancel$default(this.f421043d, null, 1, null);
        this.f421042c.close();
    }

    public final KVRepo e() {
        return (KVRepo) this.f421048i.getValue();
    }

    public final com.ss.android.lark.feed.molten.cache.a g() {
        com.ss.android.lark.feed.molten.cache.a r100 = this.f421054o;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (com.ss.android.lark.feed.molten.cache.a) BuildersKt.runBlocking$default(null, new FeedUserHolderLocalCache$restoreHumanSidebarFeedItems$1(this, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<UIFeedCard> h() {
        List r100 = this.f421051l;
        boolean r101 = !r100.isEmpty();
        List r102 = r100;
        if (r101 == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return (List) BuildersKt.runBlocking$default(null, new FeedUserHolderLocalCache$restoreLatestFeedItems$2(this, null), 1, null);
    }

    public final void i() {
        geb.c.d("FeedUserHolderLocalCache", "UserHolder start");
        BuildersKt.launch$default(this.f421043d, null, null, new FeedUserHolderLocalCache$start$1(this, null), 3, null);
        BuildersKt.launch$default(this.f421043d, null, null, new FeedUserHolderLocalCache$start$2(this, null), 3, null);
    }

    public FeedUserHolderLocalCache(String r100, Gson r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "gson");
        this.f421040a = r100;
        this.f421041b = r101;
        ExecutorCoroutineDispatcher r102 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b(this)));
        this.f421042c = r102;
        this.f421043d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r102));
        this.f421044e = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f421045f = new AtomicReference(null);
        this.f421046g = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f421047h = new AtomicReference(null);
        this.f421048i = LazyKt.lazy(new FeedUserHolderLocalCache$repo$2(this));
        this.f421049j = CollectionsKt.emptyList();
        this.f421050k = MapsKt.emptyMap();
        this.f421051l = CollectionsKt.emptyList();
        this.f421052m = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f421053n = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    public static final Object a(FeedUserHolderLocalCache r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1) == false) goto L7;
        FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1 r102 = (FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ChannelIterator<Unit> r107 = (ChannelIterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        if (((Boolean) r104).booleanValue() == false) goto L35;
        r107.next();
    L21:
        com.ss.android.lark.feed.molten.cache.a r108 = r100.f421047h.getAndSet(null);
        if (r108 == null) goto L15;
        if (Intrinsics.areEqual(r100.f421054o, r108) == true) goto L21;
        r100.f421054o = r108;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L29
        r100.e().putString("human_sidebar:snapshot:v1", r100.f421041b.toJson(r108));     // Catch: Throwable -> L29
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L21;
        geb.c.b("FeedUserHolderLocalCache", "syncHumanSidebarFeedItems failed", r111);
    L29:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        r102.L$0 = r107;
        r102.label = 1;
        r104 = r107.hasNext(r102);
        if (r104 != r105) goto L19;
        return r105;
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r107 = r100.f421046g.iterator();
    L7:
        r102 = new FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1(r100, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0063 -> B:13:0x0032). Please report as a decompilation issue!!! */
    public static final Object b(FeedUserHolderLocalCache r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FeedUserHolderLocalCache$consumeSyncRequests$1) == false) goto L7;
        FeedUserHolderLocalCache$consumeSyncRequests$1 r102 = (FeedUserHolderLocalCache$consumeSyncRequests$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 == 1) goto L16;
        if (r106 != 2) goto L15;
        ChannelIterator<Unit> r107 = (ChannelIterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L13:
        ChannelIterator<Unit> r108 = r107;
    L25:
        List<? extends UIFeedCard> r109 = r100.f421045f.getAndSet(null);
        if (r109 == null) goto L18;
        r102.L$0 = r108;
        r102.label = 2;
        if (r100.j(r109, r102) != r105) goto L25;
        return r105;
    L18:
        r102.L$0 = r108;
        r102.label = 1;
        Object r110 = r108.hasNext(r102);
        if (r110 == r105) goto L36;
        r107 = r108;
        r104 = r110;
    L23:
        if (((Boolean) r104).booleanValue() == false) goto L32;
        r107.next();
        goto L13
    L32:
        return Unit.INSTANCE;
    L36:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r107 = (ChannelIterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
        goto L23
    L17:
        ResultKt.throwOnFailure(r104);
        r108 = r100.f421044e.iterator();
    L7:
        r102 = new FeedUserHolderLocalCache$consumeSyncRequests$1(r100, r101);
        goto L8
    }

    public static final Object c(FeedUserHolderLocalCache r110, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1) == false) goto L7;
        FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1 r100 = (FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        List r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L60:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = ((List) r102).iterator();
    L62:
        if (r108.hasNext() == false) goto L66;
        Pair r109 = (Pair) r108.next();
        String r111 = (String) r109.component1();
        UIFeedCard r112 = (UIFeedCard) r109.component2();
        if (r112 == null) goto L62;
        r112.setFlowDisplayType(UIFeedCard.FlowDisplayType.KV_STORAGE);
        r107.put(r111, r112);
        goto L62
    L66:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r106.iterator();
    L68:
        if (r114.hasNext() == false) goto L72;
        Object r115 = r114.next();
        if (r107.containsKey((String) r115) == false) goto L68;
        r113.add(r115);
        goto L68
    L72:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r113.iterator();
    L74:
        if (r117.hasNext() == false) goto L78;
        UIFeedCard r118 = (UIFeedCard) r107.get((String) r117.next());
        if (r118 == null) goto L74;
        r116.add(r118);
        goto L74
    L78:
        r110.k(r113, r107);
        TimedValue r119 = new TimedValue(r116, TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r105), null);
        List<UIFeedCard> r120 = (List) r119.component1();
        geb.c.d("FeedUserHolderLocalCache", "restoreLatestFeedItemsActual finish, size:" + r120.size() + ", cost:" + Duration.m10842toStringimpl(r119.m10952component2UwyO8pc()));
        if (r110.f421052m.isCompleted() == true) goto L82;
        r110.f421052m.complete(r120);
    L82:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r121 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L17
        Object r123 = Result.m9449constructorimpl(r110.e().getString("order:v2", null));     // Catch: Throwable -> L17
    L19:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L23;
        geb.c.a("FeedUserHolderLocalCache", "readOrderIdsFromStorage failed: " + r124);
    L23:
        if (Result.m9455isFailureimpl(r123) == false) goto L25;
        r123 = null;
    L25:
        String r125 = (String) r123;
        if (r125 != null) goto L83;
        List r126 = null;
    L31:
        Object r127 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L28
    L34:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L38;
        geb.c.a("FeedUserHolderLocalCache", "readOrderIdsFromStorage fromJson failed: " + r128);
    L38:
        if (Result.m9455isFailureimpl(r127) == false) goto L40;
        r127 = null;
    L40:
        List r129 = (List) r127;
        if (r129 != null) goto L43;
        r129 = CollectionsKt.emptyList();
    L43:
        ArrayList r130 = new ArrayList();
        Iterator r131 = r129.iterator();
    L45:
        if (r131.hasNext() == false) goto L52;
        Object r132 = r131.next();
        if (((String) r132).length() <= 0) goto L49;
        boolean r133 = true;
    L50:
        if (r133 == false) goto L45;
        r130.add(r132);
        goto L45
    L49:
        r133 = false;
        goto L50
    L52:
        List r134 = CollectionsKt.distinct(r130);
        List r135 = r134;
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r137 = r135.iterator();
    L54:
        if (r137.hasNext() == false) goto L56;
        r136.add(BuildersKt.async$default(r110.f421043d, Dispatchers.getIO(), null, new FeedUserHolderLocalCache$restoreLatestFeedItemsActual$2$readResults$1$1((String) r137.next(), r110, null), 2, null));
        goto L54
    L56:
        r100.L$0 = r134;
        r100.J$0 = r121;
        r100.label = 1;
        Object r138 = AwaitKt.a(r136, r100);
        if (r138 == r103) goto L108;
        r105 = r121;
        r106 = r134;
        r102 = r138;
        goto L60
    L108:
        return r103;
    L28:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L83:
        r126 = (List) r110.f421041b.fromJson(r125, new com.ss.android.lark.feed.molten.cache.user.b().getType());     // Catch: Throwable -> L28
    L17:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new FeedUserHolderLocalCache$restoreLatestFeedItemsActual$1(r110, r210);
        goto L8
    }

    public final Object f(feb.a r210, Continuation<? super Unit> r211) {
        feb.a r100 = r210;
        if ((r211 instanceof FeedUserHolderLocalCache$persistPlan$1) == false) goto L7;
        FeedUserHolderLocalCache$persistPlan$1 r101 = (FeedUserHolderLocalCache$persistPlan$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        long r106 = r101.J$0;
        r100 = (feb.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L12:
        Object r110 = r103;
        feb.a r107 = r100;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan put items finish, count:" + r107.f476632b.size() + ", cost:" + Duration.m10842toStringimpl(new TimedValue((List) r110, TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r106), null).m10954getDurationUwyO8pc()));
        long r108 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L26
        Object r111 = Result.m9449constructorimpl(this.f421041b.toJson(r107.f476631a));     // Catch: Throwable -> L26
    L28:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L32;
        geb.c.a("FeedUserHolderLocalCache", "persistPlan order toJson failed, error:" + r112);
    L32:
        if (Result.m9455isFailureimpl(r111) == false) goto L34;
        r111 = null;
    L34:
        String r113 = (String) r111;
        if (r113 != null) goto L37;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan abort put order because orderJson is null");
    L38:
        geb.c.d("FeedUserHolderLocalCache", "persistPlan put order cost:" + Duration.m10842toStringimpl(new TimedValue(Unit.INSTANCE, TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r108), null).m10954getDurationUwyO8pc()));
        long r114 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        Iterator<T> r115 = r107.f476633c.iterator();
    L40:
        if (r115.hasNext() == false) goto L42;
        e().remove("item:v2:" + ((String) r115.next()));
        goto L40
    L42:
        Unit r116 = Unit.INSTANCE;
        geb.c.d("FeedUserHolderLocalCache", "persistPlan remove items finish, count:" + r107.f476633c.size() + ", cost:" + Duration.m10842toStringimpl(new TimedValue(r116, TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(r114), null).m10954getDurationUwyO8pc()));
        geb.c.d("FeedUserHolderLocalCache", "persistPlan finish");
        return r116;
    L37:
        e().putString("order:v2", r113);
    L26:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        geb.c.d("FeedUserHolderLocalCache", "persistPlan start, finalOrder:" + r100.f476631a + ", upsertIds:" + r100.f476632b.keySet() + ", removeIds:" + r100.f476633c);
        long r118 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        Map<String, UIFeedCard> r119 = r100.f476632b;
        ArrayList r120 = new ArrayList(r119.size());
        Iterator<Map.Entry<String, UIFeedCard>> r121 = r119.entrySet().iterator();
    L17:
        if (r121.hasNext() == false) goto L19;
        Map.Entry<String, UIFeedCard> r122 = r121.next();
        r120.add(BuildersKt.async$default(this.f421043d, Dispatchers.getIO(), null, new FeedUserHolderLocalCache$persistPlan$putItemsDuration$1$taskList$1$1(this, r122.getKey(), r122.getValue(), null), 2, null));
        goto L17
    L19:
        r101.L$0 = r100;
        r101.J$0 = r118;
        r101.label = 1;
        r103 = AwaitKt.a(r120, r101);
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r106 = r118;
    L7:
        r101 = new FeedUserHolderLocalCache$persistPlan$1(this, r211);
        goto L8
    }

    public final Object j(List<? extends UIFeedCard> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof FeedUserHolderLocalCache$syncSnapshotInternal$1) == false) goto L7;
        FeedUserHolderLocalCache$syncSnapshotInternal$1 r100 = (FeedUserHolderLocalCache$syncSnapshotInternal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        feb.a r113 = (feb.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L50:
        geb.c.d("FeedUserHolderLocalCache", "syncSnapshotInternal finish, finalOrder:" + r113.f476631a + ", upsertIds:" + r113.f476632b.keySet() + ", removeIds:" + r113.f476633c);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        List<String> r114 = this.f421049j;
        Map<String, ? extends UIFeedCard> r104 = this.f421050k;
        List<? extends UIFeedCard> r115 = r110;
        List<String> r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r106 = r115.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        r105.add(((UIFeedCard) r106.next()).getId());
        goto L16
    L18:
        Map<String, ? extends UIFeedCard> r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r115, 10)), 16));
        Iterator<T> r116 = r115.iterator();
    L20:
        if (r116.hasNext() == false) goto L23;
        Object r108 = r116.next();
        r107.put(((UIFeedCard) r108).getId(), r108);
        goto L20
    L23:
        if (Intrinsics.areEqual(r114, r105) == false) goto L37;
        int r117 = FeedItemsLocalCacheUtil.f421056a;
        Intrinsics.checkNotNullParameter(r104, "oldItemMap");
        Intrinsics.checkNotNullParameter(r107, "newItemMap");
        Intrinsics.checkNotNullParameter(r105, "orderIds");
        if (r105.isEmpty() == true) goto L33;
        Iterator r118 = r105.iterator();
    L29:
        if (r118.hasNext() == false) goto L33;
        String r109 = (String) r118.next();
        if (Intrinsics.areEqual(r104.get(r109), r107.get(r109)) == true) goto L29;
        boolean r119 = false;
    L34:
        if (r119 == false) goto L37;
        geb.c.c("FeedUserHolderLocalCache", "syncSnapshotInternal skip because snapshot unchanged");
        k(r105, r107);
        return Unit.INSTANCE;
    L33:
        r119 = true;
    L37:
        int r120 = FeedItemsLocalCacheUtil.f421056a;
        Intrinsics.checkNotNullParameter(r114, "oldOrderIds");
        Intrinsics.checkNotNullParameter(r104, "oldItemMap");
        Intrinsics.checkNotNullParameter(r105, "newOrderIds");
        Intrinsics.checkNotNullParameter(r107, "newItemMap");
        Set r121 = SetsKt.minus(CollectionsKt.toSet(r114), CollectionsKt.toSet(r105));
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator r123 = r105.iterator();
    L39:
        if (r123.hasNext() == false) goto L46;
        String r124 = (String) r123.next();
        UIFeedCard r125 = (UIFeedCard) r107.get(r124);
        if (r125 == null) goto L39;
        if (Intrinsics.areEqual(r104.get(r124), r125) == true) goto L39;
        r122.put(r124, r125);
        goto L39
    L46:
        feb.a r126 = new feb.a(r105, r122, r121);
        k(r105, r107);
        r100.L$0 = r126;
        r100.label = 1;
        if (f(r126, r100) != r102) goto L49;
        return r102;
    L49:
        r113 = r126;
    L7:
        r100 = new FeedUserHolderLocalCache$syncSnapshotInternal$1(this, r111);
        goto L8
    }

    public final void k(List<String> r100, Map<String, ? extends UIFeedCard> r101) {
        this.f421049j = CollectionsKt.toList(r100);
        this.f421050k = MapsKt.toMap(r101);
        List<String> r102 = this.f421049j;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = (String) r104.next();
        UIFeedCard r106 = this.f421050k.get(r105);
        if (r106 == null) goto L4;
        r103.add(r106);
        goto L4
    L8:
        this.f421051l = r103;
    }
}
