package com.larus.im.internal.network.link.impl.rtc.strategy;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.internal.audio.proto.BatchGetRTCTokenRequest;
import com.larus.im.internal.audio.proto.BatchGetRTCTokenResponse;
import com.larus.im.internal.audio.proto.RTCToken;
import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.o0;
import com.larus.im.internal.delegate.r0;
import com.larus.im.internal.delegate.w;
import com.larus.im.internal.trace.manager.definition.GetTokenType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import gd9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class RoomInfoGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RoomInfoGetter f349411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReentrantLock f349412b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f349413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f349414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PriorityQueue<RTCToken> f349415e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f349416f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f349417g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f349418h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f349419i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f349420j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReentrantLock f349421k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f349422l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile Deferred<? extends oe9.b<Collection<RTCToken>>> f349423m;

    public static final class a implements Comparator<RTCToken> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(RTCToken r100, RTCToken r101) {
            RTCToken r102 = r100;
            RTCToken r103 = r101;
            if (r102 != null) goto L6;
            if (r103 != null) goto L6;
            return 0;
        L6:
            if (r102 != null) goto L8;
            return -1;
        L8:
            if (r103 != null) goto L10;
            return 1;
        L10:
            RoomInfoGetter r104 = RoomInfoGetter.f349411a;
            if (RoomInfoGetter.b(r102) != RoomInfoGetter.b(r103)) goto L25;
            String r105 = r102.getRoomId();
            long r106 = -1;
            if (r105 == null) goto L17;
            Long r107 = StringsKt.toLongOrNull(r105);
            if (r107 == null) goto L17;
            long r108 = r107.longValue();
        L18:
            String r109 = r103.getRoomId();
            if (r109 == null) goto L29;
            Long r110 = StringsKt.toLongOrNull(r109);
            if (r110 == null) goto L29;
            r106 = r110.longValue();
        L29:
            return Intrinsics.compare(r108, r106);
        L17:
            r108 = -1;
            goto L18
        L25:
            return Intrinsics.compare(RoomInfoGetter.b(r102), RoomInfoGetter.b(r103));
        }
    }

    public RoomInfoGetter() {
    }

    static {
        f349411a = new RoomInfoGetter();
        f349412b = new ReentrantLock();
        f349414d = -1;
        f349415e = new PriorityQueue(10, new a());
        f349416f = new AtomicBoolean(true);
        f349417g = LazyKt.lazy(new g());
        f349418h = LazyKt.lazy(new h());
        f349419i = LazyKt.lazy(new i());
        f349420j = LazyKt.lazy(new j());
        f349421k = new ReentrantLock();
        f349422l = LazyKt.lazy(new k());
    }

    public static void h() {
        Lazy r100 = f349422l;
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L57;
        boolean r101 = true;
        if (f349416f.compareAndSet(true, false) == true) goto L7;
        return;
    L7:
        if (((Boolean) r100.getValue()).booleanValue() == true) goto L9;
        List r102 = CollectionsKt.emptyList();
    L31:
        long r103 = com.larus.im.internal.network.stragery.a.b();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L33:
        if (r105.hasNext() == false) goto L38;
        Object r106 = r105.next();
        if (a((RTCToken) r106, r103) == false) goto L33;
        r104.add(r106);
        goto L33
    L38:
        if ((!r104.isEmpty()) == false) goto L41;
        f349415e.addAll(r104);
    L41:
        if (r102.size() == r104.size()) goto L43;
    L46:
        if (r101 == false) goto L48;
        g(CollectionsKt.toList(f349415e), "tryLoadCacheFirst");
    L48:
        fe9.a.f476620a.e("RoomInfoGetter", "[tryLoadCacheFirst] Load cache token size: " + r102.size() + ", valid size: " + r104.size());
        return;
    L43:
        if (f349415e.size() != r104.size()) goto L46;
        r101 = false;
        goto L46
    L9:
        int r107 = b.f349428a;
        String r108 = c1.f348202a.a("token_cache", "", "rtc_tokens_" + com.larus.im.internal.delegate.b.f348193b.j());
        fe9.a.f476620a.e("RoomInfoGetter", "[loadFromCache] Load cache token string: " + r108);
        if (r108.length() <= 0) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L30;
        zd9.h r110 = zd9.h.f571481a;
        if (StringsKt.isBlank(r108) == false) goto L50;
    L26:
        Object r111 = null;
    L27:
        r102 = (List) r111;
        if (r102 != null) goto L31;
        r102 = CollectionsKt.emptyList();
        goto L31
    L50:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L19
        r110.getClass();     // Catch: Throwable -> L19
        r111 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r108, new l().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r111);
        if (r113 == null) goto L25;
        c0 r114 = c0.f348199b;
        StringBuilder r115 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r113, "<this>");
        r115.append(ExceptionsKt.stackTraceToString(r113));
        r114.e("GsonHolder", r115.toString());
    L25:
        if (Result.m9455isFailureimpl(r111) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L30:
        r102 = CollectionsKt.emptyList();
        goto L31
    L12:
        r109 = false;
        goto L13
    }

    public static long b(RTCToken r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getExpireDuration() >= 0) goto L5;
        return -1;
    L5:
        long r101 = r100.getLocalStartTime();
        long r102 = r100.getExpireDuration() * 1000;
        int r103 = r0.f348258b.d();
        if (com.larus.im.internal.delegate.c.f348197a.isTestChannel() == false) goto L9;
        if (r103 <= 0) goto L9;
        long r104 = ((long) r103) * 1000;
    L11:
        return r101 + r104;
    L9:
        r104 = (r102 - ((long) ((Number) f349417g.getValue()).intValue())) - ((Number) f349418h.getValue()).longValue();
        goto L11
    }

    public static void e(String r100) {
        ReentrantLock r101 = f349412b;
        r101.lock();
        PriorityQueue<RTCToken> r102 = f349415e;     // Catch: Throwable -> L29
        if (r102.isEmpty() == true) goto L26;
        long r103 = com.larus.im.internal.network.stragery.a.b();     // Catch: Throwable -> L29
        Iterator<RTCToken> r104 = r102.iterator();     // Catch: Throwable -> L29
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r104.hasNext() == false) goto L16;
        RTCToken r107 = r104.next();     // Catch: Throwable -> L29
        if (r106 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L29
    L12:
        RTCToken r108 = r107;     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L29
        if (a(r108, r103) == true) goto L17;
        r106 = r106 + 1;     // Catch: Throwable -> L29
    L17:
        if (r106 >= 0) goto L19;
        f349415e.clear();     // Catch: Throwable -> L29
        g(CollectionsKt.emptyList(), "resize_clear");     // Catch: Throwable -> L29
    L25:
        fe9.h.f476628a.f("RoomInfoGetter", "[resize][" + r100 + "] index: " + r106 + ", current count: " + f349415e.size());     // Catch: Throwable -> L29
        goto L26
    L19:
        if (r106 <= 0) goto L25;
    L20:
        if (r105 > r106) goto L25;
        PriorityQueue<RTCToken> r109 = f349415e;     // Catch: Throwable -> L29
        if (r109.poll() == null) goto L24;
        g(CollectionsKt.toList(r109), "resize_poll");     // Catch: Throwable -> L29
    L24:
        r105 = r105 + 1;     // Catch: Throwable -> L29
        goto L20
    L16:
        r106 = -1;
    L26:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L29
        r101.unlock();
        return;
    L29:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public static void i(String r110) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        ReentrantLock r100 = f349412b;
        r100.lock();
        h();     // Catch: Throwable -> L30
        e(r110);     // Catch: Throwable -> L30
        if (f349415e.size() > ((Number) f349420j.getValue()).intValue()) goto L6;
        boolean r101 = true;
    L7:
        r100.unlock();
        fe9.a r102 = fe9.a.f476620a;
        r102.e("RoomInfoGetter", "[tryPrefetchIfNeeded][" + r110 + "] Execute prefetch task: " + r101 + ", isAutoReq: false.");
        if (r101 == true) goto L10;
        return;
    L10:
        ReentrantLock r103 = f349421k;
        r103.lock();
    L27:
        th = move-exception;
        r103.unlock();
        throw th;
    L13:
        if (f349423m == null) goto L18;
        r102.e("RoomInfoGetter", "[prefetch][" + r110 + "] Has prefetch task running, not scheduling. isAutoReq: false.");     // Catch: Throwable -> L27
        r103.unlock();
        return;
    L18:
        if (f349414d > 0) goto L20;
    L24:
        r102.e("RoomInfoGetter", "[prefetch][" + r110 + "] Scheduling prefetch task on IO. isAutoReq: false.");     // Catch: Throwable -> L27
        f349423m = null;     // Catch: Throwable -> L27
        RoomInfoGetter$tryPrefetchIfNeeded$1$1 r111 = new RoomInfoGetter$tryPrefetchIfNeeded$1$1(r110, com.larus.im.internal.network.stragery.a.b(), false, null);     // Catch: Throwable -> L27
        Lazy r104 = CoroutineExtKt.f274143a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r111, "block");     // Catch: Throwable -> L27
        f349423m = BuildersKt.async$default((CoroutineScope) CoroutineExtKt.f274143a.getValue(), null, null, r111, 3, null);     // Catch: Throwable -> L27
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r103.unlock();
        return;
    L20:
        if ((com.larus.im.internal.network.stragery.a.b() - f349414d) >= (((long) sf9.a.b((d0) w.f348282r.getValue(), "prefetch_interval", 30)) * 1000)) goto L24;
        r102.e("RoomInfoGetter", "[prefetch][" + r110 + "] Prefetch task is carried out too frequently. isAutoReq: false.");     // Catch: Throwable -> L27
        r103.unlock();
        return;
    L6:
        r101 = false;
    L30:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public static boolean a(RTCToken r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= r100.getLocalStartTime()) goto L5;
        return false;
    L5:
        if (r100.getLocalUseTestDomain() != null) goto L7;
    L9:
        long r102 = b(r100);
        if (r102 >= 0) goto L12;
    L13:
        String r103 = r100.getAppId();
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L41;
        String r105 = r100.getRoomId();
        if (r105 != null) goto L24;
    L27:
        boolean r106 = true;
    L28:
        if (r106 == true) goto L42;
        String r107 = r100.getToken();
        if (r107 != null) goto L32;
    L35:
        boolean r108 = true;
    L36:
        if (r108 == true) goto L43;
        return true;
    L43:
        return false;
    L32:
        if (StringsKt.isBlank(r107) == true) goto L35;
        r108 = false;
        goto L36
    L42:
        return false;
    L24:
        if (StringsKt.isBlank(r105) == true) goto L27;
        r106 = false;
        goto L28
    L41:
        return false;
    L16:
        if (StringsKt.isBlank(r103) == true) goto L19;
        r104 = false;
        goto L20
    L12:
        if (r101 <= r102) goto L13;
        return false;
    L7:
        if (Intrinsics.areEqual(r100.getLocalUseTestDomain(), Boolean.valueOf(r0.f348258b.i())) == true) goto L9;
        return false;
    }

    public static void g(List r100, String r101) {
        if (((Boolean) f349422l.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        zd9.h.f571481a.getClass();
        String r102 = zd9.h.c(r100);
        int r103 = b.f349428a;
        if (r102 != null) goto L8;
        String r104 = "";
    L9:
        Intrinsics.checkNotNullParameter(r104, "tokenCache");
        c1.f348202a.k("token_cache", r104, "rtc_tokens_" + com.larus.im.internal.delegate.b.f348193b.j());
        fe9.a.f476620a.e("RoomInfoGetter", "[saveToCache] Save cache token size: " + r100.size() + ", tokens: " + r102 + ", callerId: " + r101);
        return;
    L8:
        r104 = r102;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static RTCToken c(String r100, jf9.d r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r110, "step");
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        ReentrantLock r102 = f349412b;
        r102.lock();
        h();     // Catch: Throwable -> L32
        String r103 = null;
        if (f349415e.isEmpty() == false) goto L9;
        fe9.a.f476620a.e("RoomInfoGetter", "[nextIfExist][" + r100 + "] cache info is empty.");     // Catch: Throwable -> L32
        r102.unlock();
        return null;
    L9:
        PriorityQueue<RTCToken> r104 = f349415e;     // Catch: Throwable -> L32
        RTCToken r105 = r104.poll();     // Catch: Throwable -> L32
        if (r105 == null) goto L14;
        g(CollectionsKt.toList(r104), "nextIfExist_poll");     // Catch: Throwable -> L32
        if (Boolean.valueOf(a(r105, com.larus.im.internal.network.stragery.a.b())).booleanValue() == false) goto L14;
        T r106 = r105;
    L15:
        r101.element = r106;     // Catch: Throwable -> L32
        if ((!r104.isEmpty()) == false) goto L19;
        if (r101.element == 0) goto L9;
    L19:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L32
        r102.unlock();
        if (r111 == false) goto L24;
        i(UUID.randomUUID().toString());
    L24:
        if (r101.element != 0) goto L27;
        fe9.a.f476620a.e("RoomInfoGetter", "[nextIfExist][" + r100 + "] Not find valid rtc room id.");
        return null;
    L27:
        fe9.a r112 = fe9.a.f476620a;
        StringBuilder r108 = new StringBuilder("[nextIfExist][");
        r108.append(r100);
        r108.append("] Find valid rtc room id: ");
        RTCToken r109 = (RTCToken) r101.element;
        if (r109 == null) goto L30;
        r103 = r109.getRoomId();
    L30:
        r108.append(r103);
        r108.append(", count: ");
        r108.append(r104.size());
        r108.append('.');
        r112.e("RoomInfoGetter", r108.toString());
        r110.f498923q = "";
        r110.f498920n = ((RTCToken) r101.element).getRoomId();
        r110.f498921o = GetTokenType.CACHE;
        return (RTCToken) r101.element;
    L14:
        r106 = 0;
    L32:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public static RTCToken f(oe9.b r100, String r101, jf9.d r102) {
        ReentrantLock r103 = f349412b;
        r103.lock();
        e(r101);     // Catch: Throwable -> L9
        PriorityQueue<RTCToken> r104 = f349415e;     // Catch: Throwable -> L9
        List r105 = (Collection) r100.a();     // Catch: Throwable -> L9
        if (r105 != null) goto L6;
        r105 = CollectionsKt.emptyList();     // Catch: Throwable -> L9
    L6:
        r104.addAll(r105);     // Catch: Throwable -> L9
        g(CollectionsKt.toList(r104), "resolveAndCache_addAll");     // Catch: Throwable -> L9
        RTCToken r106 = c(r101, r102, false);     // Catch: Throwable -> L9
        r103.unlock();
        return r106;
    L9:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x030d -> B:118:0x0314). Please report as a decompilation issue!!! */
    public final Object d(String r210, long r211, boolean r212, Continuation<? super oe9.b<Collection<RTCToken>>> r310) {
        if ((r310 instanceof RoomInfoGetter$requestWithRetry$1) == false) goto L7;
        RoomInfoGetter$requestWithRetry$1 r100 = (RoomInfoGetter$requestWithRetry$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 2;
        String r106 = "<this>";
        char r107 = 0;
        int r108 = 1;
        String r109 = "RoomInfoGetter";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r110 = r100.I$1;
        int r111 = r100.I$0;
        boolean r112 = r100.Z$0;
        long r113 = r100.J$0;
        String r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r115 = "<this>";
        RoomInfoGetter$requestWithRetry$1 r116 = r100;
        boolean r117 = r112;
        int r118 = r111;
        Object r119 = r103;
        int r120 = r110;
        String r121 = "RoomInfoGetter";
        final long r122 = r113;
    L118:
        oe9.b r123 = (oe9.b) r102;
        r123.f523023a = r118;
        boolean r124 = r123 instanceof oe9.b.f;
        if (r124 == true) goto L132;
        Intrinsics.checkNotNullParameter(r123, r115);
        if ((r123 instanceof oe9.b.C7042b) == true) goto L123;
    L125:
        boolean r125 = false;
    L126:
        if (r125 == true) goto L132;
        if ((r123 instanceof oe9.b.a) == true) goto L132;
        if (r118 >= r120) goto L132;
        String r126 = r114;
        r106 = r115;
        r105 = 2;
        r107 = 0;
        r108 = 1;
    L17:
        int r127 = r118 + r108;
        if (r127 <= 0) goto L24;
        long r128 = ((long) r127) * w.m();
        r116.L$0 = r126;
        r116.J$0 = r122;
        r116.Z$0 = r117;
        r116.I$0 = r127;
        r116.I$1 = r120;
        r116.label = r108;
        if (DelayKt.delay(r128, r116) != r119) goto L22;
        return r119;
    L22:
        r114 = r126;
        boolean r129 = r117;
        r100 = r116;
        r109 = r121;
        long r213 = r122;
        r103 = r119;
        int r130 = r127;
        int r131 = r120;
        long r132 = r213;
    L23:
        int r214 = r130;
        r119 = r103;
        long r215 = r132;
        r120 = r131;
        int r133 = r214;
        r122 = r215;
    L25:
        r100.L$0 = r114;
        r100.J$0 = r122;
        r100.Z$0 = r129;
        r100.I$0 = r133;
        r100.I$1 = r120;
        r100.label = r105;
        String r216 = r106;
        BatchGetRTCTokenRequest r134 = new BatchGetRTCTokenRequest(((Number) f349419i.getValue()).intValue());
        o0 r135 = o0.f348249a;
        Pair r136 = o0.n(r129);
        Pair[] r137 = new Pair[r108];
        r137[r107] = TuplesKt.to("Content-Type", "application/json; encoding=utf-8");
        Map r138 = MapsKt.mutableMapOf(r137);
        r138.put((String) r136.component1(), (String) r136.component2());
        gd9.e r139 = t.a.a(o0.l(), "/alice/audio/rtc/token_batch", r134, r138, null, 24);
        if (JobKt.isActive(r100.getContext()) == true) goto L29;
        fe9.a.f476620a.b(r109, "[request][" + r114 + "] Request task has been destroyed.");
        r102 = new oe9.b.a(null);
        r115 = r216;
    L115:
        if (r102 != r119) goto L117;
        return r119;
    L117:
        String r217 = r109;
        r116 = r100;
        r117 = r129;
        r118 = r133;
        r121 = r217;
        goto L118
    L29:
        if (r139.c() == false) goto L111;
        String r140 = r139.f480972h;
        if (r140 != null) goto L34;
        r140 = "";
    L34:
        if (StringsKt.isBlank(r140) == false) goto L141;
    L38:
        String r141 = null;
    L39:
        f349413c = r141;
        zd9.h r142 = zd9.h.f571481a;
        String r143 = r139.f480968d;
        if (r143 != null) goto L42;
    L45:
        boolean r144 = true;
    L46:
        if (r144 == false) goto L143;
        r115 = r216;
    L58:
        Object r145 = null;
    L59:
        BatchGetRTCTokenResponse r146 = (BatchGetRTCTokenResponse) r145;
        if (r146 == null) goto L62;
        ld9.a r147 = r146.getData();
    L63:
        if (r146 != null) goto L65;
    L105:
        fe9.a.f476620a.b(r109, "[request][" + r114 + "] Server error, " + r146 + '.');
        if (r146 == null) goto L108;
        int r148 = (int) r146.getStatusCode();
    L109:
        Object r149 = new oe9.b.e(r148, r139.a());
    L110:
        r102 = r149;
        goto L115
    L108:
        r148 = 0;
        goto L109
    L65:
        if (r146.getStatusCode() != 0) goto L105;
        if (r147 == null) goto L105;
        List<RTCToken> r150 = r147.b();
        if (r150 != null) goto L70;
    L73:
        boolean r151 = true;
    L74:
        if (r151 == true) goto L105;
        if (r147.a() == null) goto L91;
        Intrinsics.checkNotNullParameter(r147, r115);
        RTCToken r152 = r147.a();
        if (r152 == null) goto L91;
        String r153 = r152.getAppId();
        if (r153 != null) goto L83;
    L86:
        boolean r154 = true;
    L87:
        if (r154 == true) goto L91;
        String r155 = r152.getToken();
        if (r155 == null) goto L91;
        StringsKt.isBlank(r155);
        goto L91
    L83:
        if (StringsKt.isBlank(r153) == true) goto L86;
        r154 = false;
    L91:
        List<RTCToken> r156 = r147.b();
        if (r156 != null) goto L94;
    L97:
        boolean r157 = true;
    L98:
        if (r157 == false) goto L100;
        List r158 = CollectionsKt.emptyList();
    L102:
        if (r158.isEmpty() == false) goto L104;
        fe9.a.f476620a.b(r109, "[request][" + r114 + "] Response is null or empty.");
        r102 = new oe9.b.d(r139.a(), r139.f480968d);
        goto L115
    L104:
        r149 = new oe9.b.f(r158, r139.a());
        goto L110
    L100:
        final boolean r159 = r0.f348258b.i();
        r158 = SequencesKt.toList(SequencesKt.map(SequencesKt.mapNotNull(CollectionsKt.asSequence(r156), new e()), new f(r122, r159)));
        goto L102
    L94:
        if (r156.isEmpty() == true) goto L97;
        r157 = false;
        goto L98
    L70:
        if (r150.isEmpty() == true) goto L73;
        r151 = false;
        goto L74
    L62:
        r147 = null;
        goto L63
    L143:
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L50
        r142.getClass();     // Catch: Throwable -> L50
        r145 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r143, new m().getType()));     // Catch: Throwable -> L50
    L52:
        Throwable r161 = Result.m9452exceptionOrNullimpl(r145);
        if (r161 == null) goto L55;
        c0 r162 = c0.f348199b;
        StringBuilder r163 = new StringBuilder("fromJson failed, stack: ");
        r115 = r216;
        Intrinsics.checkNotNullParameter(r161, r115);
        r163.append(ExceptionsKt.stackTraceToString(r161));
        r162.e("GsonHolder", r163.toString());
    L57:
        if (Result.m9455isFailureimpl(r145) == false) goto L59;
    L55:
        r115 = r216;
    L50:
        th = move-exception;
        Result.Companion r164 = Result.Companion;
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L42:
        if (StringsKt.isBlank(r143) == true) goto L45;
        r144 = false;
        goto L46
    L141:
        r141 = ut7.a.a(r140, "device_id");     // Catch: Throwable -> L140
    L111:
        r115 = r216;
        if (r135.j(r139) == false) goto L114;
        fe9.a.f476620a.b(r109, "[request][" + r114 + "] Network is unavailable.");
        r102 = new oe9.b.c(null);
        goto L115
    L114:
        fe9.a.f476620a.b(r109, "[request][" + r114 + "] HttpError " + r139 + '.');
        r102 = new oe9.b.C7042b(r139.f480966b, r139.a());
        goto L115
    L24:
        r114 = r126;
        r129 = r117;
        r100 = r116;
        r109 = r121;
        r133 = r127;
        goto L25
    L123:
        if (((oe9.b.C7042b) r123).f523027b != (-555)) goto L125;
        r125 = true;
    L132:
        long r165 = com.larus.im.internal.network.stragery.a.b() - r122;
        fe9.a r166 = fe9.a.f476620a;
        StringBuilder r167 = new StringBuilder("result: ");
        r167.append(r124);
        r167.append(", auto: ");
        r167.append(r117);
        r167.append(", retry: ");
        r167.append(r118);
        r167.append(", server_downgrade: ");
        Intrinsics.checkNotNullParameter(r123, r115);
        if ((r123 instanceof oe9.b.C7042b) == true) goto L135;
    L137:
        boolean r168 = false;
    L138:
        r167.append(r168);
        r167.append(", total: ");
        r167.append(r165);
        r167.append("ms.");
        r166.e(r121, r167.toString());
        return r123;
    L135:
        if (((oe9.b.C7042b) r123).f523027b != (-555)) goto L137;
        r168 = true;
        goto L138
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r131 = r100.I$1;
        r130 = r100.I$0;
        r129 = r100.Z$0;
        r132 = r100.J$0;
        r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L23
    L16:
        ResultKt.throwOnFailure(r102);
        r120 = w.l();
        r119 = r103;
        r121 = "RoomInfoGetter";
        r118 = -1;
        r126 = r210;
        r122 = r211;
        r116 = r100;
        r117 = r212;
    L7:
        r100 = new RoomInfoGetter$requestWithRetry$1(this, r310);
        goto L8
    }
}
