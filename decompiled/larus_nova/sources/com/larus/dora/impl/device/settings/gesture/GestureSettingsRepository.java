package com.larus.dora.impl.device.settings.gesture;

import android.app.Application;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.t0;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class GestureSettingsRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GestureSettingsRepository f334402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f334403b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f334404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Map<GestureSettingsKey, Byte> f334405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f334406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f334407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StateFlowImpl f334408g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final StateFlowImpl f334409h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f334410i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MutableSharedFlow f334411j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final MutexImpl f334412k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f334413l = null;

    public static final class a extends t0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            super.onDoraLinkStateChanged(r100, r101, r102);
            if (r102 != 2) goto L13;
            GestureSettingsRepository r103 = GestureSettingsRepository.f334402a;
            if (r100 != null) goto L7;
            DoraDevice r104 = DoraAdapterExtKt.h(kj4.a.g());
        L8:
            r103.getClass();
            GestureSettingsRepository.f334404c = GestureSettingsRepository.c(r104);
            GestureSettingsRepository.f334405d = MapsKt.emptyMap();
            GestureSettingsRepository.f334408g.setValue(MapsKt.emptyMap());
            if (r100 != null) goto L11;
            r100 = DoraAdapterExtKt.h(kj4.a.g());
        L11:
            GestureSettingsRepository.g(r100);
            return;
        L7:
            r104 = r100;
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository$update$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3}, l = {246, 138, 141, 157}, m = "update", n = {"key", "$this$withLock_u24default$iv", "value", "previousValue", "key", "$this$withLock_u24default$iv", "value", "previousValue", "key", "$this$withLock_u24default$iv", "value", "previousValue", "result", "ret", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "B$0", "B$1", "L$0", "L$1", "B$0", "B$1", "L$0", "L$1", "B$0", "B$1", "I$0", "I$1", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GestureSettingsRepository this$0;

        public AnonymousClass1(GestureSettingsRepository r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(null, (byte) 0, (byte) 0, this);
        }
    }

    public GestureSettingsRepository() {
    }

    public final synchronized void e() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (f334407f == false) goto L21;
        monitor-exit(this);
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        kj4.a.g().registerDoraLinkCallback(f334413l);     // Catch: Throwable -> L9
        CoroutineScope r101 = f334403b;     // Catch: Throwable -> L9
        BuildersKt.launch$default(r101, null, null, new GestureSettingsRepository$init$1$1(this, null), 3, null);     // Catch: Throwable -> L9
        BuildersKt.launch$default(r101, null, null, new GestureSettingsRepository$init$1$2(this, null), 3, null);     // Catch: Throwable -> L9
        f334407f = true;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        g49.d.c("GestureSettingsRepository", "init failed.", r103);     // Catch: Throwable -> L16
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
        f334402a = new GestureSettingsRepository();
        f334403b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f334405d = MapsKt.emptyMap();
        StateFlowImpl r100 = j1.a(MapsKt.emptyMap());
        f334408g = r100;
        f334409h = r100;
        MutableSharedFlow<Boolean> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f334410i = r101;
        f334411j = r101;
        f334412k = kotlinx.coroutines.sync.b.a();
        f334413l = new a();
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

    public static Map d(DoraDevice r100) {
        if (Intrinsics.areEqual(f334404c, c(r100)) == false) goto L6;
        return (Map) f334409h.getValue();
    L6:
        return MapsKt.emptyMap();
    }

    public static void g(DoraDevice r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Job r101 = f334406e;
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.isActive() != true) goto L9;
    L10:
        if (r102 == false) goto L12;
        return;
    L12:
        f334406e = BuildersKt.launch$default(f334403b, null, null, new GestureSettingsRepository$refreshCacheInBackground$1(null), 3, null);
        return;
    L9:
        r102 = false;
        goto L10
    }

    public static String i(Byte r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_hang_up_or_answer_cn);
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L17;
        int r105 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_answer_cn);
    L17:
        if (r100 != null) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L24;
        int r107 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_calling_hang_up_cn);
    L24:
        if (r100 != null) goto L26;
    L28:
        boolean r108 = false;
    L29:
        if (r108 == false) goto L31;
        int r109 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_play_or_pause_cn);
    L31:
        if (r100 != null) goto L33;
    L35:
        boolean r110 = false;
    L36:
        if (r110 == false) goto L38;
        int r111 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_previous_cn);
    L38:
        if (r100 != null) goto L40;
    L42:
        boolean r112 = false;
    L43:
        if (r112 == false) goto L45;
        int r113 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_media_next_cn);
    L45:
        if (r100 != null) goto L47;
    L49:
        boolean r114 = false;
    L50:
        if (r114 == false) goto L52;
        int r115 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_none_cn);
    L52:
        if (r100 != null) goto L54;
    L56:
        boolean r116 = false;
    L57:
        if (r116 == false) goto L59;
        int r117 = j0.f375426a;
        return j0.d(R.string.larus_dora_gesture_start_end_simul_interpret_cn);
    L59:
        if (r100 != null) goto L61;
    L63:
        if (r101 == false) goto L65;
        int r118 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_tips_cn);
    L65:
        return "";
    L61:
        if (r100.byteValue() != (-1)) goto L63;
        r101 = true;
        goto L63
    L54:
        if (r100.byteValue() != 34) goto L56;
        r116 = true;
        goto L57
    L47:
        if (r100.byteValue() != 0) goto L49;
        r114 = true;
        goto L50
    L40:
        if (r100.byteValue() != 20) goto L42;
        r112 = true;
        goto L43
    L33:
        if (r100.byteValue() != 19) goto L35;
        r110 = true;
        goto L36
    L26:
        if (r100.byteValue() != 16) goto L28;
        r108 = true;
        goto L29
    L19:
        if (r100.byteValue() != 3) goto L21;
        r106 = true;
        goto L22
    L12:
        if (r100.byteValue() != 2) goto L14;
        r104 = true;
        goto L15
    L5:
        if (r100.byteValue() != 1) goto L7;
        r102 = true;
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
    public static final Object a(GestureSettingsRepository r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof GestureSettingsRepository$rebuildCacheWithQuickNote$1) == false) goto L7;
        GestureSettingsRepository$rebuildCacheWithQuickNote$1 r101 = (GestureSettingsRepository$rebuildCacheWithQuickNote$1) r110;
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
        MutableSharedFlow<Boolean> r107 = f334410i;     // Catch: Throwable -> L47
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
    L29:
        if (f334405d.isEmpty() == false) goto L32;
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L31:
        Unit r113 = r109;
        r106.unlock(null);
        return r113;
    L32:
        DoraDevice r114 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L47
        String r115 = f334404c;     // Catch: Throwable -> L47
        f334402a.getClass();     // Catch: Throwable -> L47
        if (Intrinsics.areEqual(r115, c(r114)) == true) goto L37;
        r109 = Unit.INSTANCE;     // Catch: Throwable -> L47
        goto L31
    L37:
        StateFlowImpl r116 = f334408g;     // Catch: Throwable -> L47
        Map<GestureSettingsKey, Byte> r117 = f334405d;     // Catch: Throwable -> L47
        QuickNoteRepo.f335241a.getClass();     // Catch: Throwable -> L47
        Map r118 = b(r117, QuickNoteRepo.b(r114));     // Catch: Throwable -> L47
        r101.L$0 = r106;     // Catch: Throwable -> L47
        r101.label = 2;     // Catch: Throwable -> L47
        r116.setValue(r118);     // Catch: Throwable -> L47
        if (Unit.INSTANCE != r111) goto L40;
        return r111;
    L24:
        ResultKt.throwOnFailure(r103);
        MutexImpl r119 = f334412k;
        r101.L$0 = r119;
        r101.label = 1;
        if (r119.a(null, r101) == r111) goto L56;
        r106 = r119;
        goto L29
    L56:
        return r111;
    L47:
        th = th;
        r112 = r104;
    L7:
        r101 = new GestureSettingsRepository$rebuildCacheWithQuickNote$1(r100, r110);
        goto L8
    }

    public static Map b(Map r100, com.larus.dora.impl.network.z r101) {
        Map r102 = MapsKt.toMutableMap(r100);
        String r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.b();
    L7:
        if (o0.d(r104) == false) goto L9;
        r102.put(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK, (byte) -1);
    L9:
        if (r101 == null) goto L12;
        r103 = r101.d();
    L12:
        if (o0.d(r103) == false) goto L14;
        r102.put(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK, (byte) -1);
    L14:
        return r102;
    L5:
        r104 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v20, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final Object f(boolean r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof GestureSettingsRepository$load$1) == false) goto L7;
        GestureSettingsRepository$load$1 r100 = (GestureSettingsRepository$load$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L30;
        if (r103 == 1) goto L29;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L19;
        if (r103 != 4) goto L18;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L55
        r110 = r113;
    L51:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L55
        r110.unlock(null);
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Map<GestureSettingsKey, Byte> r115 = (Map) r100.L$1;
        ?? r104 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L22
        Map<GestureSettingsKey, Byte> r116 = r115;
        ?? r117 = r104;
        Object r105 = r112;
    L46:
        ?? r106 = r117;
        com.larus.dora.impl.network.z r118 = (com.larus.dora.impl.network.z) r105;     // Catch: Throwable -> L55
    L47:
        StateFlowImpl r107 = f334408g;     // Catch: Throwable -> L27
        f334402a.getClass();     // Catch: Throwable -> L27
        Map r119 = b(r116, r118);     // Catch: Throwable -> L27
        r100.L$0 = r106;     // Catch: Throwable -> L27
        r100.L$1 = null;     // Catch: Throwable -> L27
        r100.label = 4;     // Catch: Throwable -> L27
        r107.setValue(r119);     // Catch: Throwable -> L27
        if (Unit.INSTANCE != r102) goto L50;
        return r102;
    L50:
        r110 = r106;
    L27:
        Throwable th10 = th;
        r104 = r106;
    L57:
        r104.unlock(null);
        throw th10;
    L22:
        th10 = th;
        goto L57
    L24:
        boolean r120 = r100.Z$0;
        DoraDevice r108 = (DoraDevice) r100.L$1;
        r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L27
        ?? r109 = r106;
        ?? r121 = r120;
    L38:
        r116 = MapsKt.toMutableMap((Map) r112);     // Catch: Throwable -> L27
        f334405d = r116;     // Catch: Throwable -> L27
        f334402a.getClass();     // Catch: Throwable -> L27
        f334404c = c(r108);     // Catch: Throwable -> L27
        if (r121 == 0) goto L41;
        QuickNoteRepo.f335241a.getClass();     // Catch: Throwable -> L27
        r118 = QuickNoteRepo.b(r108);     // Catch: Throwable -> L27
        r106 = r109;
        goto L47
    L41:
        QuickNoteRepo r122 = QuickNoteRepo.f335241a;     // Catch: Throwable -> L27
        r100.L$0 = r109;     // Catch: Throwable -> L27
        r100.L$1 = r116;     // Catch: Throwable -> L27
        r100.label = 3;     // Catch: Throwable -> L27
        Object r123 = r122.c(r100);     // Catch: Throwable -> L27
        if (r123 != r102) goto L44;
        return r102;
    L44:
        r105 = r123;
        r117 = r109;
        goto L46
    L29:
        boolean r124 = r100.Z$0;
        kotlinx.coroutines.sync.a r125 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        ?? r126 = r124;
        kotlinx.coroutines.sync.a r127 = r125;
    L34:
        r108 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L55
        kj4.a r128 = kj4.a.g();     // Catch: Throwable -> L55
        r100.L$0 = r127;     // Catch: Throwable -> L55
        r100.L$1 = r108;     // Catch: Throwable -> L55
        r100.Z$0 = r126;     // Catch: Throwable -> L55
        r100.label = 2;     // Catch: Throwable -> L55
        Object r129 = DoraAdapterExtKt.n(r128);     // Catch: Throwable -> L55
        if (r129 != r102) goto L37;
        return r102;
    L37:
        r109 = r127;
        r121 = r126;
        r112 = r129;
        goto L38
    L30:
        ResultKt.throwOnFailure(r112);
        MutexImpl r130 = f334412k;
        r100.L$0 = r130;
        r100.Z$0 = r110;
        r100.label = 1;
        if (r130.a(null, r100) != r102) goto L33;
        return r102;
    L33:
        r126 = r110;
        r127 = r130;
    L55:
        th = move-exception;
        r104 = r110;
        th10 = th;
    L7:
        r100 = new GestureSettingsRepository$load$1(this, r111);
        goto L8
    }

    public final Object h(GestureSettingsKey r100, byte r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof GestureSettingsRepository$updateQuickNote$1) == false) goto L7;
        GestureSettingsRepository$updateQuickNote$1 r101 = (GestureSettingsRepository$updateQuickNote$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L15;
            case 7: goto L12;
            case 8: goto L15;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r112);
    L54:
        com.larus.dora.impl.network.z r104 = (com.larus.dora.impl.network.z) r112;
        if (r104 == null) goto L60;
        QuickNoteRepo r105 = QuickNoteRepo.f335241a;
        com.larus.dora.impl.network.z r113 = com.larus.dora.impl.network.z.a(r104, null, null, null, "", 7);
        r101.label = 8;
        if (r105.l(r113, r101) != r103) goto L60;
        return r103;
    L60:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r112);
    L44:
        com.larus.dora.impl.network.z r106 = (com.larus.dora.impl.network.z) r112;
        if (r106 == null) goto L60;
        QuickNoteRepo r107 = QuickNoteRepo.f335241a;
        com.larus.dora.impl.network.z r114 = com.larus.dora.impl.network.z.a(r106, null, null, "", null, 11);
        r101.label = 6;
        if (r107.l(r114, r101) != r103) goto L60;
        return r103;
    L14:
        ResultKt.throwOnFailure(r112);
    L34:
        com.larus.dora.impl.network.z r108 = (com.larus.dora.impl.network.z) r112;
        if (r108 == null) goto L60;
        QuickNoteRepo r109 = QuickNoteRepo.f335241a;
        com.larus.dora.impl.network.z r115 = com.larus.dora.impl.network.z.a(r108, null, null, null, "voice_reminder", 7);
        r101.label = 4;
        if (r109.l(r115, r101) != r103) goto L60;
        return r103;
    L15:
        ResultKt.throwOnFailure(r112);
        goto L60
    L16:
        ResultKt.throwOnFailure(r112);
    L24:
        com.larus.dora.impl.network.z r116 = (com.larus.dora.impl.network.z) r112;
        if (r116 == null) goto L60;
        QuickNoteRepo r117 = QuickNoteRepo.f335241a;
        com.larus.dora.impl.network.z r118 = com.larus.dora.impl.network.z.a(r116, null, null, "voice_reminder", null, 11);
        r101.label = 2;
        if (r117.l(r118, r101) != r103) goto L60;
        return r103;
    L17:
        ResultKt.throwOnFailure(r112);
        if (r110 != (-1)) goto L40;
        if (r100 != GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK) goto L30;
        QuickNoteRepo r119 = QuickNoteRepo.f335241a;
        r101.label = 1;
        r112 = r119.c(r101);
        if (r112 != r103) goto L24;
        return r103;
    L30:
        if (r100 != GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK) goto L60;
        QuickNoteRepo r120 = QuickNoteRepo.f335241a;
        r101.label = 3;
        r112 = r120.c(r101);
        if (r112 != r103) goto L34;
        return r103;
    L40:
        if (r100 != GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK) goto L50;
        QuickNoteRepo r121 = QuickNoteRepo.f335241a;
        r101.label = 5;
        r112 = r121.c(r101);
        if (r112 != r103) goto L44;
        return r103;
    L50:
        if (r100 != GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK) goto L60;
        QuickNoteRepo r122 = QuickNoteRepo.f335241a;
        r101.label = 7;
        r112 = r122.c(r101);
        if (r112 != r103) goto L54;
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new GestureSettingsRepository$updateQuickNote$1(this, r111);
        goto L8
    }

    public final Object update(GestureSettingsKey r110, byte r210, byte r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L32;
        if (r104 == 1) goto L31;
        if (r104 == 2) goto L26;
        if (r104 == 3) goto L21;
        if (r104 != 4) goto L20;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L17
    L71:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r106.unlock(null);
        return Unit.INSTANCE;
    L17:
        th = th;
    L79:
        kotlinx.coroutines.sync.a r111 = r106;
    L80:
        r111.unlock(null);
        throw th;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        int r108 = r100.I$1;
        int r109 = r100.I$0;
        byte r112 = r100.B$1;
        byte r113 = r100.B$0;
        r111 = (kotlinx.coroutines.sync.a) r100.L$1;
        GestureSettingsKey r114 = (GestureSettingsKey) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L24
    L49:
        DoraDevice r115 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L74
        f334402a.getClass();     // Catch: Throwable -> L74
        f334404c = c(r115);     // Catch: Throwable -> L74
        Map<GestureSettingsKey, Byte> r116 = MapsKt.toMutableMap(f334405d);     // Catch: Throwable -> L74
        byte r117 = r113;
        r116.put(r114, Boxing.boxByte(r117));     // Catch: Throwable -> L24
        f334405d = r116;     // Catch: Throwable -> L24
        StateFlowImpl r118 = f334408g;     // Catch: Throwable -> L24
        Map<GestureSettingsKey, Byte> r119 = f334405d;     // Catch: Throwable -> L24
        QuickNoteRepo.f335241a.getClass();     // Catch: Throwable -> L24
        r118.setValue(b(r119, QuickNoteRepo.b(r115)));     // Catch: Throwable -> L24
        GestureSettingsTracker r120 = GestureSettingsTracker.f334416a;     // Catch: Throwable -> L24
        GestureSettingsTracker.f(r114, r117);     // Catch: Throwable -> L24
        if (r113 == 34) goto L54;
    L62:
        int r121 = r109;
    L64:
        j49.b.e(r114, r113, r112, r108);     // Catch: Throwable -> L24
        MutableSharedFlow<Boolean> r122 = f334410i;     // Catch: Throwable -> L24
        if (r121 == 0) goto L67;
        r105 = true;
    L67:
        Boolean r123 = Boxing.boxBoolean(r105);     // Catch: Throwable -> L24
        r100.L$0 = r111;     // Catch: Throwable -> L24
        r100.L$1 = null;     // Catch: Throwable -> L24
        r100.label = 4;     // Catch: Throwable -> L24
        if (r122.emit(r123, r100) != r103) goto L70;
        return r103;
    L70:
        r106 = r111;
        goto L71
    L54:
        if (r114 != GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK) goto L56;
    L57:
        IDoraService r124 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L24
        if (r124 == null) goto L62;
        DeviceService r125 = r124.device();     // Catch: Throwable -> L24
        if (r125 == null) goto L62;
        r125.D0();     // Catch: Throwable -> L24
        goto L62
    L56:
        if (r114 != GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK) goto L62;
    L74:
        th = th;
        kotlinx.coroutines.sync.a r126 = r111;
    L76:
        r111 = r126;
        goto L80
    L26:
        byte r127 = r100.B$1;
        byte r128 = r100.B$0;
        r126 = (kotlinx.coroutines.sync.a) r100.L$1;
        GestureSettingsKey r129 = (GestureSettingsKey) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L29
        r114 = r129;
        r111 = r126;
        r113 = r128;
        r112 = r127;
    L82:
        r108 = ((Number) r102).intValue();     // Catch: Throwable -> L74
        if (r108 != 0) goto L43;
        r121 = 1;
    L44:
        if (r121 == 0) goto L63;
        r100.L$0 = r114;     // Catch: Throwable -> L74
        r100.L$1 = r111;     // Catch: Throwable -> L74
        r100.B$0 = r113;     // Catch: Throwable -> L74
        r100.B$1 = r112;     // Catch: Throwable -> L74
        r100.I$0 = r121;     // Catch: Throwable -> L74
        r100.I$1 = r108;     // Catch: Throwable -> L74
        r100.label = 3;     // Catch: Throwable -> L74
        if (f334402a.h(r114, r113, r100) != r103) goto L48;
        return r103;
    L48:
        r109 = r121;
        goto L49
    L63:
        t19.s r130 = t19.s.f544207a;     // Catch: Throwable -> L24
        Application r131 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L24
        r130.getClass();     // Catch: Throwable -> L24
        t19.s.b(r131, R.string.larus_dora_toast_update_failed_cn, false);     // Catch: Throwable -> L24
        goto L64
    L43:
        r121 = 0;
    L29:
        th = th;
        goto L76
    L31:
        byte r132 = r100.B$1;
        r113 = r100.B$0;
        kotlinx.coroutines.sync.a r133 = (kotlinx.coroutines.sync.a) r100.L$1;
        r114 = (GestureSettingsKey) r100.L$0;
        ResultKt.throwOnFailure(r102);
        byte r134 = r132;
        kotlinx.coroutines.sync.a r135 = r133;
    L84:
        r100.L$0 = r114;     // Catch: Throwable -> L77
        r100.L$1 = r135;     // Catch: Throwable -> L77
        r100.B$0 = r113;     // Catch: Throwable -> L77
        r100.B$1 = r134;     // Catch: Throwable -> L77
        r100.label = 2;     // Catch: Throwable -> L77
        r102 = DoraAdapterExtKt.K(kj4.a.g(), r114, r113);     // Catch: Throwable -> L77
        if (r102 != r103) goto L39;
        return r103;
    L39:
        r112 = r134;
        r111 = r135;
    L77:
        th = th;
        r106 = r135;
        goto L79
    L32:
        ResultKt.throwOnFailure(r102);
        MutexImpl r136 = f334412k;
        r100.L$0 = r110;
        r100.L$1 = r136;
        r113 = r210;
        r100.B$0 = r113;
        r134 = r211;
        r100.B$1 = r134;
        r100.label = 1;
        if (r136.a(null, r100) != r103) goto L35;
        return r103;
    L35:
        r114 = r110;
        r135 = r136;
    L24:
        th = th;
    L7:
        r100 = new AnonymousClass1(this, r212);
        goto L8
    }
}
