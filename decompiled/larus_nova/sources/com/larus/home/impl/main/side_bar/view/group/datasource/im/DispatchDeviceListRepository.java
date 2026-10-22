package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class DispatchDeviceListRepository implements h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f345220k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f345221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f345222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f345223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f345224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineDispatcher f345225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<List<n0>, Unit>> f345226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f345227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile List<n0> f345228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutexImpl f345229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Deferred<? extends List<n0>> f345230j;

    public static final class a {
    }

    public static final class b implements Grouping<RawDeviceEntry, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f345231a;

        @Override // kotlin.collections.Grouping
        public final Iterator<RawDeviceEntry> sourceIterator() {
            return this.f345231a.iterator();
        }

        public b(Iterable r100) {
            this.f345231a = r100;
        }

        @Override // kotlin.collections.Grouping
        public final String keyOf(RawDeviceEntry r100) {
            return r100.getDeviceId();
        }
    }

    static {
    }

    public DispatchDeviceListRepository() {
        ListDevicesRemoteSource r100 = ListDevicesRemoteSource.f345313a;
        q0 r101 = q0.f345376a;
        m0 r102 = m0.f345363a;
        CoroutineScope r103 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        MainCoroutineDispatcher r104 = Dispatchers.getMain().getImmediate();
        Intrinsics.checkNotNullParameter(r100, "remoteSource");
        Intrinsics.checkNotNullParameter(r101, "cacheStore");
        Intrinsics.checkNotNullParameter(r102, "endTagResolver");
        Intrinsics.checkNotNullParameter(r103, "requestScope");
        Intrinsics.checkNotNullParameter(r104, "callbackDispatcher");
        this.f345221a = r100;
        this.f345222b = r101;
        this.f345223c = r102;
        this.f345224d = r103;
        this.f345225e = r104;
        this.f345226f = new CopyOnWriteArrayList();
        this.f345227g = new Object();
        this.f345229i = kotlinx.coroutines.sync.b.a();
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.h
    public final List<n0> c() {
        List<n0> r100 = this.f345228h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        List<RawDeviceEntry> r101 = this.f345222b.read();
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List<n0> r102 = h(g(r101));
        Object r103 = this.f345227g;
        monitor-enter(r103);
        List<n0> r104 = this.f345228h;     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        monitor-exit(r103);
        return r104;
    L14:
        this.f345228h = r102;     // Catch: Throwable -> L17
        monitor-exit(r103);
        return r102;
    L17:
        th = move-exception;
        throw th;
    }

    public static List g(List r110) {
        ArrayList r100 = new ArrayList();
        Iterator r111 = r110.iterator();
    L3:
        int r101 = 0;
        if (r111.hasNext() == false) goto L13;
        Object r102 = r111.next();
        String r103 = ((RawDeviceEntry) r102).getDeviceId();
        if (r103 != null) goto L8;
    L9:
        r101 = 1;
    L11:
        if ((r101 ^ 1) == 0) goto L3;
        r100.add(r102);
        goto L3
    L8:
        if (StringsKt.isBlank(r103) == false) goto L11;
    L13:
        Map r112 = GroupingKt.eachCount(new b(r100));
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r113 = r112.entrySet().iterator();
    L15:
        if (r113.hasNext() == false) goto L23;
        Map.Entry r105 = (Map.Entry) r113.next();
        if (((Number) r105.getValue()).intValue() <= 1) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L15;
        r104.put(r105.getKey(), r105.getValue());
        goto L15
    L19:
        r106 = false;
        goto L20
    L23:
        if ((!r104.isEmpty()) == false) goto L29;
        int r114 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r115 = new StringBuilder("total=");
        r115.append(r100.size());
        r115.append(" dropped=");
        Iterator r107 = r104.values().iterator();
    L26:
        if (r107.hasNext() == false) goto L28;
        r101 = r101 + (((Number) r107.next()).intValue() - 1);
        goto L26
    L28:
        r115.append(r101);
        r115.append(' ');
        r115.append(CollectionsKt.joinToString$default(r104.entrySet(), ",", "dup=[", "]", 0, null, new i(), 24, null));
        com.larus.home.impl.main.side_bar.feed.arch.t.a("device_list_duplicate", r115.toString());
    L29:
        HashSet r116 = new HashSet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r100.iterator();
    L31:
        if (r109.hasNext() == false) goto L35;
        Object r117 = r109.next();
        if (r116.add(((RawDeviceEntry) r117).getDeviceId()) == false) goto L31;
        r108.add(r117);
        goto L31
    L35:
        return r108;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.h
    public final Object a(Continuation<? super r0> r100) {
        if ((r100 instanceof DispatchDeviceListRepository$loadDevices$1) == false) goto L7;
        DispatchDeviceListRepository$loadDevices$1 r101 = (DispatchDeviceListRepository$loadDevices$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        List r106 = (List) r103;
        if (r106 != null) goto L21;
        return new r0(c(), false);
    L21:
        return new r0(r106, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        r103 = f(r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new DispatchDeviceListRepository$loadDevices$1(this, r100);
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.h
    public final void b(Function1<? super List<n0>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345226f.remove(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.h
    public final void d(Function1<? super List<n0>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f345226f.addIfAbsent(r100) == true) goto L6;
        return;
    L6:
        if (this.f345226f.size() <= 1) goto L8;
        return;
    L8:
        BuildersKt.launch$default(this.f345224d, null, null, new DispatchDeviceListRepository$addChangeListener$1(this, null), 3, null);
    }

    public final Object f(Continuation<? super List<n0>> r110) {
        if ((r110 instanceof DispatchDeviceListRepository$refresh$1) == false) goto L7;
        DispatchDeviceListRepository$refresh$1 r100 = (DispatchDeviceListRepository$refresh$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L21;
        if (r103 == 1) goto L20;
        if (r103 != 2) goto L19;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14 CancellationException -> L16
    L36:
    L48:
        return (List) r111;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L44:
        Deferred<? extends List<n0>> r112 = this.f345230j;     // Catch: Throwable -> L41
        if (r112 != null) goto L27;
    L31:
        r112 = BuildersKt.async$default(this.f345224d, null, null, new DispatchDeviceListRepository$refresh$deferred$1$2(this, null), 3, null);     // Catch: Throwable -> L41
        this.f345230j = r112;     // Catch: Throwable -> L41
    L32:
        r104.unlock(null);
        r100.L$0 = null;     // Catch: Throwable -> L14 CancellationException -> L16
        r100.label = 2;     // Catch: Throwable -> L14 CancellationException -> L16
        r111 = r112.await(r100);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r111 != r102) goto L36;
        return r102;
    L27:
        if (r112.isActive() == true) goto L30;
        r112 = null;
    L30:
        if (r112 != null) goto L32;
    L41:
        th = move-exception;
        r104.unlock(null);
        throw th;
    L21:
        ResultKt.throwOnFailure(r111);
        r104 = this.f345229i;
        r100.L$0 = r104;
        r100.label = 1;
        if (r104.a(null, r100) != r102) goto L44;
        return r102;
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        com.larus.home.impl.main.side_bar.feed.arch.t.b("device_list_refresh_failed", "", th);
        return null;
    L7:
        r100 = new DispatchDeviceListRepository$refresh$1(this, r110);
        goto L8
    }

    public final List<n0> h(List<RawDeviceEntry> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L33;
        RawDeviceEntry r103 = (RawDeviceEntry) r102.next();
        String r104 = r103.getDeviceId();
        n0 r105 = null;
        String r106 = null;
        r106 = null;
        r105 = null;
        if (r104 != null) goto L8;
    L31:
        if (r105 == null) goto L4;
        r101.add(r105);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r104)) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L31;
        String r107 = r103.getDeviceName();
        if (r107 != null) goto L16;
    L20:
        r107 = r104;
    L21:
        String r108 = this.f345223c.a(r103.getAppId());
        if (r108 == null) goto L27;
        if ((!StringsKt.isBlank(r108)) == false) goto L27;
        r106 = r108;
    L27:
        if (r106 == null) goto L30;
        r107 = r107 + " - " + r106;
    L30:
        r105 = new n0(r104, r107);
        goto L31
    L16:
        if ((!StringsKt.isBlank(r107)) == true) goto L19;
        r107 = null;
    L19:
        if (r107 != null) goto L21;
    L33:
        return r101;
    }

    public static final Object e(DispatchDeviceListRepository r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DispatchDeviceListRepository$fetchAndPublish$1) == false) goto L7;
        DispatchDeviceListRepository$fetchAndPublish$1 r102 = (DispatchDeviceListRepository$fetchAndPublish$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        List r107 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L19:
        List r108 = (List) r104;
        if (r108 == null) goto L48;
        List<RawDeviceEntry> r109 = g(r108);
        r100.f345222b.a(r109);
        List<n0> r110 = r100.h(r109);
        r102.L$0 = r110;
        r102.label = 2;
        Object r111 = r100.f345227g;
        monitor-enter(r111);
        List<n0> r112 = r100.f345228h;     // Catch: Throwable -> L42
        r100.f345228h = r110;     // Catch: Throwable -> L42
        monitor-exit(r111);
        int r113 = o0.f345366c;
        if (r112 != null) goto L29;
        r112 = CollectionsKt.emptyList();
    L29:
        o0 r114 = o0.a.a(r112, r110);
        if (r114.f345367a.isEmpty() == true) goto L32;
    L34:
        int r115 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("device_list_changed", "added=" + r114.f345367a.size() + " removed=" + r114.f345368b.size() + " total=" + ((ArrayList) r110).size());
        Object r116 = BuildersKt.withContext(r100.f345225e, new DispatchDeviceListRepository$publish$2(r100, r110, null), r102);
        if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r116 = Unit.INSTANCE;
    L38:
        if (r116 != r105) goto L41;
        return r105;
    L41:
        return r110;
    L32:
        if (r114.f345368b.isEmpty() == false) goto L34;
        r116 = Unit.INSTANCE;
    L42:
        th = move-exception;
        throw th;
    L48:
        return null;
    L16:
        ResultKt.throwOnFailure(r104);
        g r117 = r100.f345221a;
        r102.label = 1;
        r104 = r117.a(r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new DispatchDeviceListRepository$fetchAndPublish$1(r100, r101);
        goto L8
    }
}
