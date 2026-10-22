package com.larus.dora.impl.device.settings.gesture.wakeup;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.network.z;
import com.larus.dora.impl.util.t0;
import com.larus.utils.o0;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class GestureWakeupRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GestureWakeupRepository f334505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f334506b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f334507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile GestureWakeupType f334508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Map<Integer, ? extends GestureWakeupType> f334509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f334510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f334511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutableSharedFlow<h> f334512h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a1 f334513i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f334514j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final MutableSharedFlow f334515k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MutexImpl f334516l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f334517m = null;

    public static final class a extends t0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            super.onDoraLinkStateChanged(r100, r101, r102);
            if (r102 != 2) goto L9;
            GestureWakeupRepository r103 = GestureWakeupRepository.f334505a;
            if (r100 != null) goto L7;
            r100 = DoraAdapterExtKt.h(kj4.a.g());
        L7:
            r103.getClass();
            GestureWakeupRepository.f334507c = GestureWakeupRepository.c(r100);
            GestureWakeupRepository.f334508d = null;
            GestureWakeupRepository.f334509e = MapsKt.emptyMap();
            GestureWakeupRepository.j();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository$update$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {0, 0, 0, 1, 1, 2, 2, 3}, l = {300, 129, 130, 132}, m = "update", n = {"type", "$this$withLock_u24default$iv", "side", "$this$withLock_u24default$iv", "result", "$this$withLock_u24default$iv", "result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GestureWakeupRepository this$0;

        public AnonymousClass1(GestureWakeupRepository r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(0, null, this);
        }
    }

    public GestureWakeupRepository() {
    }

    public final synchronized void h() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (f334511g == false) goto L21;
        monitor-exit(this);
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        kj4.a.g().registerDoraLinkCallback(f334517m);     // Catch: Throwable -> L9
        CoroutineScope r101 = f334506b;     // Catch: Throwable -> L9
        BuildersKt.launch$default(r101, null, null, new GestureWakeupRepository$init$1$1(this, null), 3, null);     // Catch: Throwable -> L9
        BuildersKt.launch$default(r101, null, null, new GestureWakeupRepository$init$1$2(this, null), 3, null);     // Catch: Throwable -> L9
        f334511g = true;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        g49.d.c("DoraOTA", "init failed", r103);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L16
        goto L11
    }

    static {
        f334505a = new GestureWakeupRepository();
        f334506b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f334509e = MapsKt.emptyMap();
        MutableSharedFlow<h> r100 = SharedFlowKt.MutableSharedFlow$default(2, 0, null, 6, null);
        f334512h = r100;
        f334513i = kotlinx.coroutines.flow.e.a(r100);
        MutableSharedFlow<Boolean> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f334514j = r101;
        f334515k = r101;
        f334516l = kotlinx.coroutines.sync.b.a();
        f334517m = new a();
    }

    public static boolean g() {
        IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.t();
    }

    public static void j() {
        Job r100 = f334510f;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isActive() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        f334510f = BuildersKt.launch$default(f334506b, null, null, new GestureWakeupRepository$refreshCacheInBackground$1(null), 3, null);
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static String c(DoraDevice r100) {
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

    public final Object i(Continuation<? super Unit> r100) {
        if ((r100 instanceof GestureWakeupRepository$load$1) == false) goto L7;
        GestureWakeupRepository$load$1 r101 = (GestureWakeupRepository$load$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r108 = r106;
        th = th;
        kotlinx.coroutines.sync.a r109 = r108;
    L32:
        r109.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r109 = r110;
    L36:
        GestureWakeupRepository r111 = f334505a;     // Catch: Throwable -> L31
        r101.L$0 = r109;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        QuickNoteRepo r112 = QuickNoteRepo.f335241a;     // Catch: Throwable -> L31
        DoraDevice r113 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L31
        r112.getClass();     // Catch: Throwable -> L31
        if (r111.m(QuickNoteRepo.b(r113), r101) != r104) goto L26;
        return r104;
    L26:
        r106 = r109;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r103);
        r109 = f334516l;
        r101.L$0 = r109;
        r101.label = 1;
        if (r109.a(null, r101) != r104) goto L36;
        return r104;
    L7:
        r101 = new GestureWakeupRepository$load$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    public static final Object a(GestureWakeupRepository r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof GestureWakeupRepository$rebuildCacheWithQuickNote$1) == false) goto L7;
        GestureWakeupRepository$rebuildCacheWithQuickNote$1 r101 = (GestureWakeupRepository$rebuildCacheWithQuickNote$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r101.label;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L19;
        ?? r112 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L16
        r112 = r112;
    L44:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r112.unlock(null);
        return Unit.INSTANCE;
    L16:
        th = th;
    L49:
        r112.unlock(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L47
    L40:
        MutableSharedFlow<Boolean> r107 = f334514j;     // Catch: Throwable -> L47
        Boolean r108 = Boxing.boxBoolean(true);     // Catch: Throwable -> L47
        r101.L$0 = r106;     // Catch: Throwable -> L47
        r101.label = 3;     // Catch: Throwable -> L47
        if (r107.emit(r108, r101) == r111) goto L57;
        r112 = r106;
        goto L44
    L57:
        return r111;
    L23:
        r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        GestureWakeupType r109 = f334508d;     // Catch: Throwable -> L47
        if (r109 != null) goto L32;
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L31:
        Unit r114 = r113;
        r106.unlock(null);
        return r114;
    L32:
        String r115 = f334507c;     // Catch: Throwable -> L47
        GestureWakeupRepository r116 = f334505a;     // Catch: Throwable -> L47
        DoraDevice r117 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L47
        r116.getClass();     // Catch: Throwable -> L47
        if (Intrinsics.areEqual(r115, c(r117)) == true) goto L37;
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L47
        goto L31
    L37:
        QuickNoteRepo r118 = QuickNoteRepo.f335241a;     // Catch: Throwable -> L47
        DoraDevice r119 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L47
        r118.getClass();     // Catch: Throwable -> L47
        Map<Integer, ? extends GestureWakeupType> r120 = b(r109, QuickNoteRepo.b(r119));     // Catch: Throwable -> L47
        r101.L$0 = r106;     // Catch: Throwable -> L47
        r101.label = 2;     // Catch: Throwable -> L47
        if (r116.d(r120, r101) != r111) goto L40;
        return r111;
    L24:
        ResultKt.throwOnFailure(r103);
        MutexImpl r121 = f334516l;
        r101.L$0 = r121;
        r101.label = 1;
        if (r121.a(null, r101) == r111) goto L56;
        r106 = r121;
        goto L28
    L56:
        return r111;
    L47:
        th = th;
        r112 = r104;
    L7:
        r101 = new GestureWakeupRepository$rebuildCacheWithQuickNote$1(r100, r110);
        goto L8
    }

    public static Map b(GestureWakeupType r100, z r101) {
        GestureWakeupType r102 = GestureWakeupType.RADIO;
        if (r100 != r102) goto L5;
    L8:
        if (r101 == null) goto L10;
        boolean r103 = o0.d(r101.c());
        boolean r104 = o0.d(r101.e());
        if (r103 == true) goto L16;
        if (r104 == true) goto L16;
        return MapsKt.mapOf(TuplesKt.to(0, r100));
    L16:
        Pair[] r105 = new Pair[2];
        if (r103 == false) goto L19;
        GestureWakeupType r106 = GestureWakeupType.RADIO_RECORD;
    L20:
        r105[0] = TuplesKt.to(1, r106);
        if (r104 == false) goto L23;
        r102 = GestureWakeupType.RADIO_RECORD;
    L23:
        r105[1] = TuplesKt.to(2, r102);
        return MapsKt.mapOf(r105);
    L19:
        r106 = r102;
        goto L20
    L10:
        return MapsKt.mapOf(TuplesKt.to(0, r100));
    L5:
        if (r100 == GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE) goto L8;
        return MapsKt.mapOf(TuplesKt.to(0, r100));
    }

    public static GestureWakeupType e(DoraDevice r100, int r101) {
        if (Intrinsics.areEqual(f334507c, c(r100)) == true) goto L7;
        return null;
    L7:
        return f334509e.get(Integer.valueOf(r101));
    }

    public final Object d(Map<Integer, ? extends GestureWakeupType> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof GestureWakeupRepository$emitTypes$1) == false) goto L7;
        GestureWakeupRepository$emitTypes$1 r102 = (GestureWakeupRepository$emitTypes$1) r101;
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
        Iterator<Map.Entry<Integer, ? extends GestureWakeupType>> r107 = (Iterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L25:
        if (r107.hasNext() == false) goto L30;
        Map.Entry<Integer, ? extends GestureWakeupType> r108 = r107.next();
        int r109 = r108.getKey().intValue();
        GestureWakeupType r110 = r108.getValue();
        MutableSharedFlow<h> r111 = f334512h;
        h r112 = new h(r110, r109);
        r102.L$0 = r107;
        r102.label = 2;
        if (r111.emit(r112, r102) != r105) goto L25;
        return r105;
    L30:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r104);
        f334509e = r100;
        if (r100.isEmpty() == false) goto L23;
        MutableSharedFlow<h> r113 = f334512h;
        r102.label = 1;
        if (r113.emit(null, r102) != r105) goto L22;
        return r105;
    L23:
        r107 = r100.entrySet().iterator();
    L7:
        r102 = new GestureWakeupRepository$emitTypes$1(this, r101);
        goto L8
    }

    public final Object k(z r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof GestureWakeupRepository$syncQuickNoteWakeup$1) == false) goto L7;
        GestureWakeupRepository$syncQuickNoteWakeup$1 r100 = (GestureWakeupRepository$syncQuickNoteWakeup$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        Ref.BooleanRef r104 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L46:
        Ref.BooleanRef r114 = r104;
    L48:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r113.unlock(null);
        return Boxing.boxBoolean(r114.element);
    L15:
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r106 = r113;
    L54:
        r106.unlock(null);
        throw th10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$3;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r100.L$2;
        Ref.BooleanRef r108 = (Ref.BooleanRef) r100.L$1;
        z r109 = (z) r100.L$0;
        ResultKt.throwOnFailure(r112);
        r114 = r108;
        r106 = r115;
        r110 = r109;
    L58:
        boolean r116 = false;
        if (o0.d(r110.c()) == false) goto L32;
        int r117 = DoraAdapterExtKt.S(kj4.a.g(), 1, GestureWakeupType.RADIO_RECORD);     // Catch: Throwable -> L52
        if (r114.element == false) goto L29;
        if (r117 != 0) goto L29;
        boolean r118 = true;
    L30:
        r114.element = r118;     // Catch: Throwable -> L52
        r107.element = true;     // Catch: Throwable -> L52
    L29:
        r118 = false;
    L32:
        if (o0.d(r110.e()) == false) goto L39;
        int r119 = DoraAdapterExtKt.S(kj4.a.g(), 2, GestureWakeupType.RADIO_RECORD);     // Catch: Throwable -> L52
        if (r114.element == false) goto L37;
        if (r119 != 0) goto L37;
        r116 = true;
    L37:
        r114.element = r116;     // Catch: Throwable -> L52
        r107.element = true;     // Catch: Throwable -> L52
    L39:
        if (r107.element == true) goto L41;
    L47:
        r113 = r106;
        goto L48
    L41:
        if (r114.element == false) goto L47;
        GestureWakeupRepository r120 = f334505a;     // Catch: Throwable -> L52
        r100.L$0 = r114;     // Catch: Throwable -> L52
        r100.L$1 = r106;     // Catch: Throwable -> L52
        r100.L$2 = null;     // Catch: Throwable -> L52
        r100.L$3 = null;     // Catch: Throwable -> L52
        r100.label = 2;     // Catch: Throwable -> L52
        if (r120.m(r110, r100) != r102) goto L45;
        return r102;
    L45:
        r104 = r114;
        r113 = r106;
    L52:
        th = move-exception;
        th10 = th;
        goto L54
    L20:
        ResultKt.throwOnFailure(r112);
        r114 = new Ref.BooleanRef();
        r114.element = true;
        r107 = new Ref.BooleanRef();
        r106 = f334516l;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.L$2 = r107;
        r100.L$3 = r106;
        r100.label = 1;
        if (r106.a(null, r100) != r102) goto L58;
        return r102;
    L7:
        r100 = new GestureWakeupRepository$syncQuickNoteWakeup$1(this, r111);
        goto L8
    }

    public final Object m(z r100, ContinuationImpl r101) {
        GestureWakeupType r102 = DoraAdapterExtKt.o(kj4.a.g());
        f334508d = r102;
        f334507c = c(DoraAdapterExtKt.h(kj4.a.g()));
        GestureWakeupType r103 = GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE;
        if (r102 != r103) goto L23;
        if (g() == false) goto L23;
        kj4.a r104 = kj4.a.g();
        GestureWakeupType r105 = GestureWakeupType.RADIO;
        if (DoraAdapterExtKt.S(r104, 0, r105) != 0) goto L9;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L17;
        g49.d.d("DoraOTA", "set gesture wakeup type to radio for obric");
        f334508d = r105;
        Object r107 = d(MapsKt.mapOf(TuplesKt.to(Boxing.boxInt(0), r105)), r101);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r107;
    L16:
        return Unit.INSTANCE;
    L17:
        g49.d.b("DoraOTA", "set gesture wakeup type to radio for obric failed");
        f334509e = MapsKt.emptyMap();
        Object r108 = f334512h.emit(null, r101);
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r108;
    L21:
        return Unit.INSTANCE;
    L9:
        r106 = false;
    L23:
        if (r102 == GestureWakeupType.RADIO) goto L37;
        if (r102 == r103) goto L37;
        if (r102 != null) goto L32;
        f334509e = MapsKt.emptyMap();
        Object r109 = f334512h.emit(null, r101);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        return r109;
    L31:
        return Unit.INSTANCE;
    L32:
        Object r110 = d(MapsKt.mapOf(TuplesKt.to(Boxing.boxInt(0), r102)), r101);
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        return r110;
    L36:
        return Unit.INSTANCE;
    L37:
        Object r111 = d(b(r102, r100), r101);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        return r111;
    L41:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ GestureWakeupType f(GestureWakeupRepository r100, DoraDevice r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r101 = DoraAdapterExtKt.h(kj4.a.g());
    L5:
        r100.getClass();
        return e(r101, 0);
    }

    public final Object l(int r110, GestureWakeupType r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof GestureWakeupRepository$updateQuickNoteWake$1) == false) goto L7;
        GestureWakeupRepository$updateQuickNoteWake$1 r100 = (GestureWakeupRepository$updateQuickNoteWake$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L16;
            case 7: goto L13;
            case 8: goto L16;
            case 9: goto L12;
            case 10: goto L16;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r113);
    L63:
        z r103 = (z) r113;
        if (r103 == null) goto L69;
        QuickNoteRepo r114 = QuickNoteRepo.f335241a;
        z r115 = z.a(r103, "", "", null, null, 12);
        r100.label = 10;
        if (r114.l(r115, r100) != r102) goto L69;
        return r102;
    L69:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r113);
    L47:
        z r104 = (z) r113;
        if (r104 == null) goto L69;
        QuickNoteRepo r116 = QuickNoteRepo.f335241a;
        z r117 = z.a(r104, null, "", null, null, 13);
        r100.label = 8;
        if (r116.l(r117, r100) != r102) goto L69;
        return r102;
    L14:
        ResultKt.throwOnFailure(r113);
    L55:
        z r105 = (z) r113;
        if (r105 == null) goto L69;
        QuickNoteRepo r118 = QuickNoteRepo.f335241a;
        z r119 = z.a(r105, "", null, null, null, 14);
        r100.label = 6;
        if (r118.l(r119, r100) != r102) goto L69;
        return r102;
    L15:
        ResultKt.throwOnFailure(r113);
    L26:
        z r106 = (z) r113;
        if (r106 == null) goto L69;
        QuickNoteRepo r120 = QuickNoteRepo.f335241a;
        z r121 = z.a(r106, null, "record_or_query", null, null, 13);
        r100.label = 4;
        if (r120.l(r121, r100) != r102) goto L69;
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        goto L69
    L17:
        ResultKt.throwOnFailure(r113);
    L34:
        z r107 = (z) r113;
        if (r107 == null) goto L69;
        QuickNoteRepo r122 = QuickNoteRepo.f335241a;
        z r123 = z.a(r107, "record_or_query", null, null, null, 14);
        r100.label = 2;
        if (r122.l(r123, r100) != r102) goto L69;
        return r102;
    L18:
        ResultKt.throwOnFailure(r113);
        if (r111 != GestureWakeupType.RADIO_RECORD) goto L40;
        if (r110 == 1) goto L31;
        if (r110 != 2) goto L69;
        QuickNoteRepo r124 = QuickNoteRepo.f335241a;
        r100.label = 3;
        r113 = r124.c(r100);
        if (r113 != r102) goto L26;
        return r102;
    L31:
        QuickNoteRepo r125 = QuickNoteRepo.f335241a;
        r100.label = 1;
        r113 = r125.c(r100);
        if (r113 != r102) goto L34;
        return r102;
    L40:
        if (r111 != GestureWakeupType.RADIO) goto L60;
        if (r110 == 1) goto L52;
        if (r110 != 2) goto L69;
        QuickNoteRepo r126 = QuickNoteRepo.f335241a;
        r100.label = 7;
        r113 = r126.c(r100);
        if (r113 != r102) goto L47;
        return r102;
    L52:
        QuickNoteRepo r127 = QuickNoteRepo.f335241a;
        r100.label = 5;
        r113 = r127.c(r100);
        if (r113 != r102) goto L55;
        return r102;
    L60:
        QuickNoteRepo r128 = QuickNoteRepo.f335241a;
        r100.label = 9;
        r113 = r128.c(r100);
        if (r113 != r102) goto L63;
        return r102;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new GestureWakeupRepository$updateQuickNoteWake$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12, types: [int] */
    /* JADX WARN: Type inference failed for: r12v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v12, types: [com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object update(int r110, GestureWakeupType r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L28;
        if (r103 != 1) goto L66;
        int r114 = r100.I$0;
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$1;
        GestureWakeupType r105 = (GestureWakeupType) r100.L$0;
        ResultKt.throwOnFailure(r113);
        kotlinx.coroutines.sync.a r116 = r115;
        ?? r117 = r105;
        ?? r118 = r114;
    L64:
    L57:
        Throwable th10 = th;
        r111 = r116;
    L59:
        ?? r119 = r111;
        th = th10;
        ?? r120 = r119;
    L60:
        r120.unlock(null);
        throw th;
    L32:
        if (DoraAdapterExtKt.S(kj4.a.g(), r118, r117) != 0) goto L34;
        int r106 = 1;
    L35:
        if (r106 == 0) goto L47;
        ?? r107 = f334505a;     // Catch: Throwable -> L57
        r100.L$0 = r116;     // Catch: Throwable -> L57
        r100.L$1 = null;     // Catch: Throwable -> L57
        r100.I$0 = r106;     // Catch: Throwable -> L57
        r100.label = 2;     // Catch: Throwable -> L57
        if (r107.l(r118, r117, r100) != r102) goto L39;
        return r102;
    L39:
        kotlinx.coroutines.sync.a r121 = r116;
    L40:
        GestureWakeupRepository r122 = f334505a;     // Catch: Throwable -> L45
        r100.L$0 = r121;     // Catch: Throwable -> L45
        r100.I$0 = r106;     // Catch: Throwable -> L45
        r100.label = 3;     // Catch: Throwable -> L45
        QuickNoteRepo r123 = QuickNoteRepo.f335241a;     // Catch: Throwable -> L45
        DoraDevice r108 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L45
        r123.getClass();     // Catch: Throwable -> L45
        if (r122.m(QuickNoteRepo.b(r108), r100) != r102) goto L43;
        return r102;
    L43:
        kotlinx.coroutines.sync.a r124 = r121;
        int r125 = r106;
    L44:
        r106 = r125;
        kotlinx.coroutines.sync.a r126 = r124;
    L48:
        MutableSharedFlow<Boolean> r127 = f334514j;     // Catch: Throwable -> L45
        if (r106 == 0) goto L51;
        r104 = true;
    L51:
        Boolean r128 = Boxing.boxBoolean(r104);     // Catch: Throwable -> L45
        r100.L$0 = r126;     // Catch: Throwable -> L45
        r100.L$1 = null;     // Catch: Throwable -> L45
        r100.label = 4;     // Catch: Throwable -> L45
        r110 = r126;
        if (r127.emit(r128, r100) != r102) goto L54;
        return r102;
    L54:
        Unit r129 = Unit.INSTANCE;     // Catch: Throwable -> L45
        r110.unlock(null);
        return Unit.INSTANCE;
    L47:
        r126 = r116;
        goto L48
    L34:
        r106 = 0;
        goto L35
    L66:
        if (r103 == 2) goto L22;
        if (r103 == 3) goto L19;
        if (r103 != 4) goto L18;
        kotlinx.coroutines.sync.a r130 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L45
        r110 = r130;
        goto L54
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r125 = r100.I$0;
        r124 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L25
        goto L44
    L22:
        int r131 = r100.I$0;
        kotlinx.coroutines.sync.a r132 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L25
        r106 = r131;
        r121 = r132;
    L25:
        th10 = th;
        goto L59
    L28:
        ResultKt.throwOnFailure(r113);
        r116 = f334516l;
        r100.L$0 = r111;
        r100.L$1 = r116;
        r100.I$0 = r110;
        r100.label = 1;
        r118 = r110;
        r117 = r111;
        if (r116.a(null, r100) != r102) goto L64;
        return r102;
    L45:
        th = th;
        r120 = r110;
    L7:
        r100 = new AnonymousClass1(this, r112);
        goto L8
    }
}
