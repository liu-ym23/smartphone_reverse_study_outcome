package com.larus.dora.impl.dynamic.quicknote;

import android.app.Activity;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteItemState;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteKeys;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.a0;
import com.larus.dora.impl.network.z;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.t0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class QuickNoteRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QuickNoteRepo f335241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f335242b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f335243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static z f335244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f335245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f335246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f335247g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableSharedFlow f335248h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<f59.a> f335249i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f335250j = null;

    public static final class a extends t0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            super.onDoraLinkStateChanged(r100, r101, r102);
            if (r102 != 2) goto L13;
            QuickNoteRepo r103 = QuickNoteRepo.f335241a;
            if (r100 != null) goto L7;
            DoraDevice r104 = DoraAdapterExtKt.h(kj4.a.g());
        L8:
            r103.getClass();
            QuickNoteRepo.e(r104);
            if (r100 != null) goto L11;
            r100 = DoraAdapterExtKt.h(kj4.a.g());
        L11:
            QuickNoteRepo.f(r100);
            return;
        L7:
            r104 = r100;
            goto L8
        }
    }

    public QuickNoteRepo() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (f335246f == false) goto L21;
        monitor-exit(this);
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        kj4.a.g().registerDoraLinkCallback(f335250j);     // Catch: Throwable -> L9
        BuildersKt.launch$default(f335242b, null, null, new QuickNoteRepo$init$1$1(this, null), 3, null);     // Catch: Throwable -> L9
        f335246f = true;     // Catch: Throwable -> L9
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        g49.d.c("QuickNoteRepo", "init failed.", r102);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L16
        goto L11
    }

    static {
        f335241a = new QuickNoteRepo();
        f335242b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        MutableSharedFlow<Boolean> r100 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        f335247g = r100;
        f335248h = r100;
        String r101 = QuickNoteKeys.LEFT_LONG_PRESS.getValue();
        QuickNoteItemState r102 = QuickNoteItemState.IDLE;
        f335249i = CollectionsKt.listOf(new f59.a[]{new f59.a(r101, r102, "record_or_query"), new f59.a(QuickNoteKeys.RIGHT_LONG_PRESS.getValue(), r102, "record_or_query"), new f59.a(QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue(), r102, "voice_reminder"), new f59.a(QuickNoteKeys.RIGHT_DOUBLE_CLICK.getValue(), r102, "voice_reminder")});
        f335250j = new a();
    }

    public static void j() {
        BuildersKt.launch$default(f335242b, null, null, new QuickNoteRepo$resetNetworkConfig$1(null), 3, null);
    }

    public static String a(DoraDevice r100) {
        if (r100 == null) goto L11;
        String r101 = r100.getSerialNumber();
        if (r101 == null) goto L11;
        if ((!StringsKt.isBlank(r101)) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L11;
    L22:
        return r101;
    L11:
        if (r100 == null) goto L17;
        r101 = r100.f204389mac;
        if (r101 == null) goto L17;
        if ((!StringsKt.isBlank(r101)) == false) goto L17;
    L18:
        if (r101 != null) goto L22;
        if (r100 != null) goto L24;
        return null;
    L24:
        return Integer.valueOf(r100.productId).toString();
    L17:
        r101 = null;
        goto L18
    }

    public static z b(DoraDevice r100) {
        if (Intrinsics.areEqual(f335243c, a(r100)) == true) goto L7;
        return null;
    L7:
        return f335244d;
    }

    public static void e(DoraDevice r100) {
        String r101 = a(r100);
        if (Intrinsics.areEqual(f335243c, r101) == true) goto L7;
        if (r100 == null) goto L7;
        return;
    L7:
        if (f335244d == null) goto L9;
    L12:
        boolean r102 = true;
    L14:
        if (r100 != null) goto L16;
        r101 = null;
    L16:
        f335243c = r101;
        f335244d = null;
        if (r102 == false) goto L20;
        f335247g.tryEmit(Boolean.TRUE);
        return;
    L20:
        return;
    L9:
        if (f335243c != null) goto L12;
        r102 = false;
        goto L14
    }

    public static void f(DoraDevice r100) {
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r102 = false;
        if (r101 == null) goto L9;
        DeviceService r103 = r101.device();
        if (r103 == null) goto L9;
        if (r103.q0(null) != true) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        return;
    L12:
        if (r100 != null) goto L14;
        return;
    L14:
        Job r105 = f335245e;
        if (r105 != null) goto L17;
    L19:
        if (r102 == false) goto L21;
        return;
    L21:
        f335245e = BuildersKt.launch$default(f335242b, null, null, new QuickNoteRepo$refreshQuickNoteConfigInBackground$1(r100, null), 3, null);
        return;
    L17:
        if (r105.isActive() != true) goto L19;
        r102 = true;
    L9:
        r104 = false;
        goto L10
    }

    public static void h(DoraDevice r100) {
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 != null) goto L6;
        g49.d.e("QuickNoteRepo", "requestQuickNoteRecordUrlAndJump skipped without foreground activity");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new QuickNoteRepo$requestQuickNoteRecordUrlAndJump$1(r100, r101, null), 3, null);
    }

    public static void i(Function0 r100) {
        BuildersKt.launch$default(f335242b, null, null, new QuickNoteRepo$reset$1(r100, null), 3, null);
    }

    public final Object c(Continuation<? super z> r100) {
        if ((r100 instanceof QuickNoteRepo$getQuickNoteConfig$1) == false) goto L7;
        QuickNoteRepo$getQuickNoteConfig$1 r101 = (QuickNoteRepo$getQuickNoteConfig$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        DoraDevice r106 = (DoraDevice) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        z r107 = (z) r103;
        n(r106, r107);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IDoraService r108 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r108 == null) goto L21;
        DeviceService r109 = r108.device();
        if (r109 == null) goto L21;
        if (r109.q0(null) != true) goto L21;
        boolean r110 = true;
    L22:
        if (r110 == true) goto L24;
        return null;
    L24:
        DoraDevice r111 = DoraAdapterExtKt.h(kj4.a.g());
        r101.L$0 = r111;
        r101.label = 1;
        Object r112 = g(r111, r101);
        if (r112 != r104) goto L27;
        return r104;
    L27:
        r106 = r111;
        r103 = r112;
    L21:
        r110 = false;
    L7:
        r101 = new QuickNoteRepo$getQuickNoteConfig$1(this, r100);
        goto L8
    }

    public static void n(DoraDevice r100, z r101) {
        String r102 = a(r100);
        String r103 = f335243c;
        z r104 = f335244d;
        f335243c = r102;
        f335244d = r101;
        if (Intrinsics.areEqual(r103, r102) == true) goto L5;
    L6:
        f335247g.tryEmit(Boolean.TRUE);
        return;
    L5:
        if (Intrinsics.areEqual(r104, r101) == false) goto L6;
    }

    public final Object g(DoraDevice r100, Continuation<? super z> r101) {
        if ((r101 instanceof QuickNoteRepo$requestQuickNoteConfig$1) == false) goto L7;
        QuickNoteRepo$requestQuickNoteConfig$1 r102 = (QuickNoteRepo$requestQuickNoteConfig$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L36:
        if (Result.m9456isSuccessimpl(r107) == true) goto L38;
        g49.d.b("QuickNoteRepo", "requestQuickNoteConfig failed.");
        return null;
    L38:
        if (Result.m9455isFailureimpl(r107) == false) goto L40;
        r107 = null;
    L40:
        a0 r108 = (a0) r107;
        if (r108 != null) goto L43;
        return null;
    L43:
        return r108.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        IDoraService r109 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r109 == null) goto L21;
        DeviceService r110 = r109.device();
        if (r110 == null) goto L21;
        if (r110.q0(null) != true) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == true) goto L25;
        g49.d.e("QuickNoteRepo", "requestQuickNoteConfig but not support ota3p5.");
        return null;
    L25:
        if (r100 != null) goto L28;
        g49.d.b("QuickNoteRepo", "requestQuickNoteConfig device is null");
        return null;
    L28:
        List<f59.a> r112 = f335249i;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L30:
        if (r114.hasNext() == false) goto L32;
        r113.add(((f59.a) r114.next()).f475658a);
        goto L30
    L32:
        DoraNetworkApi r115 = DoraNetworkApi.f336157a;
        r102.label = 1;
        r107 = r115.t(r100, r113, r102);
        if (r107 != r105) goto L36;
        return r105;
    L21:
        r111 = false;
    L7:
        r102 = new QuickNoteRepo$requestQuickNoteConfig$1(this, r101);
        goto L8
    }

    public final Object l(z r100, ContinuationImpl r101) {
        Object r102 = m(r100, false, null, null, null, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object m(z r110, boolean r111, Function0<Unit> r210, Function0<Unit> r211, Function0<Unit> r212, Continuation<? super Unit> r213) {
        Function0<Unit> r100 = r210;
        Function0<Unit> r101 = r212;
        if ((r213 instanceof QuickNoteRepo$syncQuickNoteConfigInternal$1) == false) goto L7;
        QuickNoteRepo$syncQuickNoteConfigInternal$1 r102 = (QuickNoteRepo$syncQuickNoteConfigInternal$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L19;
        if (r106 == 4) goto L18;
        if (r106 != 5) goto L17;
        Function0<Unit> r107 = (Function0) r102.L$1;
        r100 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L76:
        r101 = r107;
        if (r100 == null) goto L82;
        r100.invoke();
    L82:
        if (r101 == null) goto L85;
        r101.invoke();
    L85:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r108 = r102.Z$0;
        DoraDevice r109 = (DoraDevice) r102.L$3;
        r101 = (Function0) r102.L$2;
        Function0<Unit> r112 = (Function0) r102.L$1;
        z r113 = (z) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L69:
        boolean r114 = r108;
        DoraDevice r115 = r109;
        r107 = r101;
        r100 = r112;
    L71:
        n(r115, r113);
        if (r114 == false) goto L76;
        GestureSettingsRepository r116 = GestureSettingsRepository.f334402a;
        r102.L$0 = r100;
        r102.L$1 = r107;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.label = 5;
        if (r116.f(true, r102) != r105) goto L76;
        return r105;
    L19:
        r108 = r102.Z$0;
        r109 = (DoraDevice) r102.L$3;
        r101 = (Function0) r102.L$2;
        r112 = (Function0) r102.L$1;
        z r117 = (z) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L63:
        r113 = r117;
    L65:
        if (o0.d(r113.d()) == false) goto L69;
        kj4.a r118 = kj4.a.g();
        GestureSettingsKey r119 = GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK;
        r102.L$0 = r113;
        r102.L$1 = r112;
        r102.L$2 = r101;
        r102.L$3 = r109;
        r102.Z$0 = r108;
        r102.label = 4;
        if (DoraAdapterExtKt.K(r118, r119, (byte) -1) != r105) goto L69;
        return r105;
    L20:
        r108 = r102.Z$0;
        r109 = (DoraDevice) r102.L$3;
        r101 = (Function0) r102.L$2;
        r112 = (Function0) r102.L$1;
        z r120 = (z) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r113 = r120;
    L55:
        if (((Boolean) r104).booleanValue() == true) goto L58;
        g49.d.b("QuickNoteRepo", "syncQuickNoteConfig update gesture wakeup failed.");
    L58:
        if (o0.d(r113.b()) == false) goto L65;
        kj4.a r121 = kj4.a.g();
        GestureSettingsKey r122 = GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK;
        r102.L$0 = r113;
        r102.L$1 = r112;
        r102.L$2 = r101;
        r102.L$3 = r109;
        r102.Z$0 = r108;
        r102.label = 3;
        if (DoraAdapterExtKt.K(r121, r122, (byte) -1) != r105) goto L62;
        return r105;
    L62:
        r117 = r113;
        goto L63
    L21:
        boolean r123 = r102.Z$0;
        DoraDevice r124 = (DoraDevice) r102.L$4;
        r101 = (Function0) r102.L$3;
        Function0<Unit> r125 = (Function0) r102.L$2;
        Function0<Unit> r126 = (Function0) r102.L$1;
        r113 = (z) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r114 = r123;
        Object r127 = ((Result) r104).m9458unboximpl();
        r115 = r124;
        r100 = r126;
    L48:
        if (Result.m9456isSuccessimpl(r127) == false) goto L79;
        if (r114 == false) goto L70;
        GestureWakeupRepository r128 = GestureWakeupRepository.f334505a;
        r102.L$0 = r113;
        r102.L$1 = r100;
        r102.L$2 = r101;
        r102.L$3 = r115;
        r102.L$4 = null;
        r102.Z$0 = r114;
        r102.label = 2;
        Object r129 = r128.k(r113, r102);
        if (r129 != r105) goto L53;
        return r105;
    L53:
        r112 = r100;
        r109 = r115;
        r104 = r129;
        r108 = r114;
        goto L55
    L70:
        r107 = r101;
        goto L71
    L79:
        if (r125 == null) goto L81;
        r125.invoke();
    L81:
        g49.d.b("QuickNoteRepo", "syncQuickNoteConfig failed：network error.");
        goto L82
    L22:
        ResultKt.throwOnFailure(r104);
        IDoraService r130 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r130 == null) goto L29;
        DeviceService r131 = r130.device();
        if (r131 == null) goto L29;
        if (r131.q0(null) != true) goto L29;
        boolean r132 = true;
    L30:
        if (r132 == true) goto L37;
        if (r100 == null) goto L33;
        r210.invoke();
    L33:
        if (r101 == null) goto L36;
        r212.invoke();
    L36:
        return Unit.INSTANCE;
    L37:
        r115 = DoraAdapterExtKt.h(kj4.a.g());
        if (r115 != null) goto L43;
        if (r101 == null) goto L41;
        r212.invoke();
    L41:
        g49.d.b("QuickNoteRepo", "syncQuickNoteConfig device is null");
        return Unit.INSTANCE;
    L43:
        DoraNetworkApi r133 = DoraNetworkApi.f336157a;
        r102.L$0 = r110;
        r102.L$1 = r100;
        r102.L$2 = r211;
        r102.L$3 = r101;
        r102.L$4 = r115;
        r114 = r111;
        r102.Z$0 = r114;
        r102.label = 1;
        Object r134 = r133.B(r115, r110, r102);
        if (r134 != r105) goto L46;
        return r105;
    L46:
        r113 = r110;
        r127 = r134;
        r125 = r211;
    L29:
        r132 = false;
    L7:
        r102 = new QuickNoteRepo$syncQuickNoteConfigInternal$1(this, r213);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object k(QuickNoteRepo r100, z r110, i r111, j r112, Function0 r113, Continuation r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        i r101 = null;
    L7:
        if ((r115 & 4) == 0) goto L9;
        j r102 = null;
    L11:
        if ((r115 & 8) == 0) goto L13;
        Function0 r103 = null;
    L14:
        Object r104 = r100.m(r110, true, r101, r102, r103, r114);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r104;
    L18:
        return Unit.INSTANCE;
    L13:
        r103 = r113;
        goto L14
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
