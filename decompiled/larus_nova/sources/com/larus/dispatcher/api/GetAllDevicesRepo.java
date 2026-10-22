package com.larus.dispatcher.api;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.im.internal.jni.bean.DeviceStatusChangeType;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes27.dex */
public final class GetAllDevicesRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GetAllDevicesRepo f330842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AllDeviceResponse f330843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f330844c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutexImpl f330845d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f330846e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f330847f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLong f330848g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f330849h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Deferred<AllDeviceResponse> f330850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Deferred<AllDeviceResponse> f330851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static CoroutineScope f330852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MutableLiveData<AllDeviceResponse> f330853l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final MutableLiveData<Integer> f330854m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile long f330855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final MutableLiveData f330856o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final MutableLiveData f330857p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f330858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final GetAllDevicesRepo$dispatchCommandListener$1 f330859r = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330860a = null;

        static {
            int[] r100 = new int[DeviceStatusChangeType.values().length];
            r100[DeviceStatusChangeType.DEVICE_STATUS_CHANGE_TYPE_ENABLE_CONTROL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DeviceStatusChangeType.DEVICE_STATUS_CHANGE_TYPE_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f330860a = r100;
        }
    }

    public GetAllDevicesRepo() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dispatcher.api.GetAllDevicesRepo$dispatchCommandListener$1] */
    static {
        f330842a = new GetAllDevicesRepo();
        f330844c = kotlinx.coroutines.sync.b.a();
        f330845d = kotlinx.coroutines.sync.b.a();
        f330846e = new Object();
        f330847f = new AtomicLong(0);
        f330848g = new AtomicLong(0);
        f330849h = LazyKt.lazy(new com.larus.dispatcher.api.a());
        MutableLiveData<AllDeviceResponse> r100 = new MutableLiveData();
        f330853l = r100;
        MutableLiveData<Integer> r101 = new MutableLiveData();
        f330854m = r101;
        f330856o = r100;
        f330857p = r101;
        f330859r = new GetAllDevicesRepo$dispatchCommandListener$1();
    }

    public static AllDeviceResponse d() {
        AllDeviceResponse r100 = f330843b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        AtomicLong r101 = f330847f;
        long r102 = r101.get();
        AllDeviceResponse r103 = h("getCurrentDevicesInfo");
        if (r103 == null) goto L8;
        Object r104 = f330846e;
        monitor-enter(r104);
        AllDeviceResponse r105 = f330843b;     // Catch: Throwable -> L23
        if (r105 == null) goto L15;
        r103 = r105;
    L21:
        monitor-exit(r104);
        return r103;
    L15:
        if (r101.get() != r102) goto L17;
        f330843b = r103;     // Catch: Throwable -> L23
        f330853l.postValue(r103);     // Catch: Throwable -> L23
        FLogger.f375446a.i("GetAllDevicesRepo", "[getCurrentDevicesInfo] disk cache restored");     // Catch: Throwable -> L23
    L17:
        AllDeviceResponse r106 = f330843b;     // Catch: Throwable -> L23
        if (r106 == null) goto L21;
        r103 = r106;
    L23:
        th = move-exception;
        throw th;
    L8:
        return f330843b;
    }

    public static CoroutineScope f() {
        CoroutineScope r100 = f330852k;
        if (r100 != null) goto L6;
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f330852k = r101;
        return r101;
    L6:
        return r100;
    }

    public static void g() {
        if (f330858q == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("GetAllDevicesRepo", "init");
        f330858q = true;
        com.larus.im.d.b().registerDispatchCommandListener(f330859r);
        long r100 = f330847f.get();
        BuildersKt.launch$default(f(), null, null, new GetAllDevicesRepo$init$1(r100, null), 3, null);
    }

    public static Integer c(final String r100) {
        List<PcDevice> r101 = null;
        if (r100 != null) goto L5;
    L17:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L17;
        AllDeviceResponse r102 = d();
        if (r102 == null) goto L13;
        r101 = r102.getDevices();
    L13:
        if (r101 != null) goto L16;
        r101 = CollectionsKt.emptyList();
    L16:
        return (Integer) SequencesKt.singleOrNull(SequencesKt.distinct(SequencesKt.mapNotNull(SequencesKt.filter(SequencesKt.filterNotNull(CollectionsKt.asSequence(r101)), new b(r100)), new c())));
    }

    public static AllDeviceResponse h(String r100) {
        FLogger r101 = FLogger.f375446a;
        r101.d("GetAllDevicesRepo", "[" + r100 + "] readCurrentDevicesInfoFromDisk read cache");
        String r102 = AccountService.f365697a.getUserId();
        if (StringsKt.isBlank(r102) == false) goto L27;
        r101.w("GetAllDevicesRepo", "[" + r100 + "] uid is empty, skip cache");
        return null;
    L27:
        String r103 = ((Keva) f330849h.getValue()).getString(r102, null);     // Catch: Exception -> L17
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L31;
        return (AllDeviceResponse) HttpExtKt.f360123f.fromJson(r103, AllDeviceResponse.class);
    L31:
        return null;
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
    L17:
        e = move-exception;
        FLogger.f375446a.e("GetAllDevicesRepo", "[" + r100 + "] read cache failed", e);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        ((Keva) f330849h.getValue()).erase(r102);     // Catch: Throwable -> L21
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L33;
        FLogger.f375446a.e("GetAllDevicesRepo", "[" + r100 + "] erase damaged cache failed", r107);
        return null;
    L33:
        return null;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public static void j(AllDeviceResponse r110) {
        Object r100 = f330846e;
        monitor-enter(r100);
        f330847f.incrementAndGet();     // Catch: Throwable -> L12
        f330843b = r110;     // Catch: Throwable -> L12
        f330853l.postValue(r110);     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        if (r110 == null) goto L17;
        long r102 = f330848g.incrementAndGet();
        String r103 = AccountService.f365697a.getUserId();
        if (StringsKt.isBlank(r103) == false) goto L10;
        FLogger.f375446a.w("GetAllDevicesRepo", "[persistCurrentDevicesInfoToDisk] uid is empty, skip cache");
        return;
    L10:
        BuildersKt.launch$default(f(), null, null, new GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1(r102, r103, r110, null), 3, null);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static Object e(String r100, Continuation r101) {
        return CoroutineScopeKt.coroutineScope(new GetAllDevicesRepo$getOrRequestAllDevices$2(r100, null), r101);
    }

    public static final Object a(GetAllDevicesRepo r100, long r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1) == false) goto L7;
        GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1 r103 = (GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.J$0;
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L38:
        AllDeviceResponse r110 = h("loadCurrentDevicesInfoFromDisk");     // Catch: Throwable -> L35
        r109.unlock(null);
        Object r111 = f330846e;
        monitor-enter(r111);
        if (r110 != null) goto L40;
    L29:
        r108 = false;
    L30:
        monitor-exit(r111);
        if (r108 == false) goto L34;
        FLogger.f375446a.i("GetAllDevicesRepo", "[loadCurrentDevicesInfoFromDisk] cache restored");
    L34:
        return Unit.INSTANCE;
    L40:
    L26:
        th = move-exception;
        throw th;
    L23:
        if (f330847f.get() != r101) goto L29;
        f330843b = r110;     // Catch: Throwable -> L26
        f330853l.postValue(r110);     // Catch: Throwable -> L26
    L35:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MutexImpl r112 = f330845d;
        r103.L$0 = r112;
        r103.J$0 = r101;
        r103.label = 1;
        if (r112.a(null, r103) == r106) goto L42;
        r109 = r112;
        goto L38
    L42:
        return r106;
    L7:
        r103 = new GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1(r100, r102);
        goto L8
    }

    public static final Object b(GetAllDevicesRepo r100, String r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof GetAllDevicesRepo$requestAllDevices$1) == false) goto L7;
        GetAllDevicesRepo$requestAllDevices$1 r102 = (GetAllDevicesRepo$requestAllDevices$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r101 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r106 = (dm9.a) r104;
        if ((r106 instanceof dm9.a.b) == false) goto L28;
        dm9.a.b r107 = (dm9.a.b) r106;
        if (r107.f469231a.isSuccess() == false) goto L22;
        FLogger.f375446a.i("GetAllDevicesRepo", "[requestAllDevices][" + r101 + "] request success");
        AllDeviceResponse r112 = (AllDeviceResponse) r107.f469231a.getData();
        j(r112);
        f330855n = SystemClock.elapsedRealtime();
        return r112;
    L22:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("[requestAllDevice][");
        r108.append(r101);
        r108.append("] request success but biz failed, code=");
        r108.append(r107.f469231a.getCode());
        r108.append(", msg=");
        r108.append(r107.f469231a.getMsg());
        r108.append(", error=");
        Throwable r109 = r107.f469232b;
        if (r109 == null) goto L25;
        String r114 = r109.getLocalizedMessage();
    L26:
        r108.append(r114);
        r113.e("GetAllDevicesRepo", r108.toString(), r107.f469232b);
        j(null);
    L35:
        return null;
    L25:
        r114 = null;
        goto L26
    L28:
        if ((r106 instanceof dm9.a.C5690a) == false) goto L37;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("[requestAllDevice][");
        r116.append(r101);
        r116.append("] request failed, code=");
        dm9.a.C5690a r117 = (dm9.a.C5690a) r106;
        r116.append(r117.f469228a);
        r116.append(", msg=");
        r116.append(r117.f469229b);
        r116.append(", error=");
        Throwable r118 = r117.f469230c;
        if (r118 == null) goto L32;
        String r119 = r118.getLocalizedMessage();
    L33:
        r116.append(r119);
        r115.e("GetAllDevicesRepo", r116.toString(), r117.f469230c);
        j(null);
        goto L35
    L32:
        r119 = null;
        goto L33
    L37:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("GetAllDevicesRepo", "[requestAllDevices][" + r101 + "] start");
        CoroutineDispatcher r120 = Dispatchers.getIO();
        GetAllDevicesRepo$requestAllDevices$result$1 r121 = new GetAllDevicesRepo$requestAllDevices$result$1(null);
        r102.L$0 = r101;
        r102.label = 1;
        r104 = BuildersKt.withContext(r120, r121, r102);
        if (r104 != r111) goto L17;
        return r111;
    L7:
        r102 = new GetAllDevicesRepo$requestAllDevices$1(r100, r110);
        goto L8
    }

    public final Object i(int r110, String r111, Continuation<? super AllDeviceResponse> r210) {
        if ((r210 instanceof GetAllDevicesRepo$requestAllDevicesWithTimeControl$1) == false) goto L7;
        GetAllDevicesRepo$requestAllDevicesWithTimeControl$1 r100 = (GetAllDevicesRepo$requestAllDevicesWithTimeControl$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$2;
        Object r106 = r100.L$1;
        Deferred<AllDeviceResponse> r107 = (Deferred) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L50:
    L44:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L39:
        if (f330851j != r107) goto L41;
        f330851j = null;     // Catch: Throwable -> L44
    L41:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r105.unlock(null);
        return r106;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Deferred<AllDeviceResponse> r109 = (Deferred) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L34:
        AllDeviceResponse r112 = (AllDeviceResponse) r102;
        MutexImpl r113 = f330844c;
        r100.L$0 = r109;
        r100.L$1 = r102;
        r100.L$2 = r113;
        r100.label = 3;
        if (r113.a(null, r100) != r103) goto L37;
        return r103;
    L37:
        r107 = r109;
        r105 = r113;
        r106 = r102;
        goto L50
    L17:
        int r114 = r100.I$0;
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L52:
        Deferred<AllDeviceResponse> r117 = f330851j;     // Catch: Throwable -> L47
        if (r117 != null) goto L25;
    L29:
        r117 = BuildersKt.async$default(f(), null, null, new GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2(r114, r116, null), 3, null);     // Catch: Throwable -> L47
        f330851j = r117;     // Catch: Throwable -> L47
    L30:
        r115.unlock(null);
        r100.L$0 = r117;
        r100.L$1 = null;
        r100.label = 2;
        Object r118 = r117.await(r100);
        if (r118 != r103) goto L33;
        return r103;
    L33:
        r109 = r117;
        r102 = r118;
        goto L34
    L25:
        if (r117.isActive() == true) goto L28;
        r117 = null;
    L28:
        if (r117 != null) goto L30;
    L47:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r102);
        MutexImpl r119 = f330844c;
        r100.L$0 = r111;
        r100.L$1 = r119;
        r100.I$0 = r110;
        r100.label = 1;
        if (r119.a(null, r100) != r103) goto L21;
        return r103;
    L21:
        r115 = r119;
        r116 = r111;
        r114 = r110;
    L7:
        r100 = new GetAllDevicesRepo$requestAllDevicesWithTimeControl$1(this, r210);
        goto L8
    }
}
