package com.larus.avlink;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes24.dex */
public final class DoraWakeupResponseManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraWakeupResponseManager f291394a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f291395b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f291396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f291397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f291398e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f291399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f291400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f291401h;

    public static final class a implements l68.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f291402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f291403b;

        /* JADX INFO: renamed from: com.larus.avlink.DoraWakeupResponseManager$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3985a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f291404a = null;

            static {
                int[] r100 = new int[TtsState.values().length];
                r100[TtsState.TTS_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[TtsState.TTS_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f291404a = r100;
            }
        }

        @Override // l68.b
        public final void b(byte[] r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // l68.b
        public final void e(TtsLifeState r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "lifeState");
        }

        @Override // l68.b
        public final void a(TtsTracer r100) {
            Intrinsics.checkNotNullParameter(r100, "tracer");
        }

        @Override // l68.b
        public final void d(final TtsState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            DoraWakeupResponseManager r101 = DoraWakeupResponseManager.f291394a;
            final String r102 = this.f291402a;
            DoraWakeupResponseManager.g(new g1(r102, r100));
        }

        public a(String r100, long r101) {
            this.f291402a = r100;
            this.f291403b = r101;
        }

        @Override // l68.b
        public final void c(TtsEventEnum r100, String r101, int r102, String r103, Map<String, ? extends Object> r104) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "customErrorMsg");
            Intrinsics.checkNotNullParameter(r103, "ext");
            Intrinsics.checkNotNullParameter(r104, "extMap");
            FLogger.f375446a.i("DoraWakeupResponse", "wakeup response onEvent, event=" + r100 + ", customErrorMsg=" + r101 + ", customErrorErrorCode=" + r102 + ", ext=" + r103 + ", extMap=" + r104);
            if (r100 != TtsEventEnum.TTS_FIRST_PACKAGE) goto L6;
            DoraWakeupResponseManager r105 = DoraWakeupResponseManager.f291394a;
            final long r106 = this.f291403b;
            final String r107 = this.f291402a;
            DoraWakeupResponseManager.g(new f1(r106, r107));
            return;
        }
    }

    public DoraWakeupResponseManager() {
    }

    static {
        f291394a = new DoraWakeupResponseManager();
        f291395b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new w0())));
        f291398e = LazyKt.lazy(new x0());
    }

    public static void d() {
        Job r100 = f291396c;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        f291396c = null;
        Job r101 = f291397d;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        f291397d = null;
        f291399f = 0;
        f291400g = null;
        FLogger.f375446a.i("DoraWakeupResponse", "cancelWakeupResponseTimer");
    }

    public static long e() {
        e10 r100 = e10.f368561a;
        Long r101 = e10.w0().getWakeupResponseCancelCutoffMs();
        if (r101 != null) goto L7;
        return 2000;
    L7:
        return r101.longValue();
    }

    public static void c(String r100) {
        ((SoundPlayManager) f291398e.getValue()).h();
        String r101 = f291400g;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        FLogger.f375446a.i("DoraWakeupResponse", "skip cancel wakeup response, taskId is empty");
        return;
    L13:
        FLogger.f375446a.i("DoraWakeupResponse", "cancel wakeup response because " + r100 + ", taskId=" + r101);
        IFlowTtsClientService.f288300a.getClass();
        IFlowTtsClientService r103 = IFlowTtsClientService.a.a();
        if (r103 == null) goto L17;
        r103.g(r101, false, r100);
        return;
    L17:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public static void g(Function0 r100) {
        BuildersKt.launch$default(f291395b, null, null, new DoraWakeupResponseManager$post$1(r100, null), 3, null);
    }

    public static final Object a(DoraWakeupResponseManager r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DoraWakeupResponseManager$runCancelTimeout$1) == false) goto L7;
        DoraWakeupResponseManager$runCancelTimeout$1 r102 = (DoraWakeupResponseManager$runCancelTimeout$1) r101;
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
    L17:
        c("wakeup response not started in 3000 ms");
        d();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (DelayKt.delay(3000, r102) != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraWakeupResponseManager$runCancelTimeout$1(r100, r101);
        goto L8
    }

    public static final Object b(DoraWakeupResponseManager r110, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof DoraWakeupResponseManager$runWakeupResponse$1) == false) goto L7;
        DoraWakeupResponseManager$runWakeupResponse$1 r100 = (DoraWakeupResponseManager$runWakeupResponse$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        long r106 = r100.J$0;
        String r107 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L39:
        FLogger.f375446a.i("DoraWakeupResponse", "play wakeup response mp3, taskId=" + r108 + ", path=" + r107);
        ((SoundPlayManager) f291398e.getValue()).f(r107, new e1(r108, r106));
    L41:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r109 = r100.J$1;
        long r111 = r100.J$0;
        String r112 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        long r113 = r111;
        long r114 = r109;
    L25:
        String r115 = (String) r102;
        JobKt.ensureActive(r100.getContext());
        long r116 = System.currentTimeMillis() - r114;
        if (r116 <= 2500) goto L28;
        FLogger.f375446a.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path cost " + r116 + "ms exceed 2500 ms, skip wakeup response, taskId=" + r112);
        d();
        return Unit.INSTANCE;
    L28:
        if (r115 != null) goto L30;
    L33:
        if (r105 == false) goto L35;
        FLogger.f375446a.i("DoraWakeupResponse", "wakeup response mp3 not found, play TTS now, taskId=" + r112);
        f(r112, r113);
        goto L41
    L35:
        long r117 = RangesKt.coerceAtLeast(e() - (System.currentTimeMillis() - f291399f), 0);
        FLogger.f375446a.i("DoraWakeupResponse", "wakeup response top style hit, schedule gecko mp3 after " + r117 + "ms, taskId=" + r112 + ", path=" + r115);
        r100.L$0 = r112;
        r100.L$1 = r115;
        r100.J$0 = r113;
        r100.label = 3;
        if (DelayKt.delay(r117, r100) == r103) goto L45;
        r107 = r115;
        r108 = r112;
        r106 = r113;
        goto L39
    L45:
        return r103;
    L30:
        if (r115.length() == 0) goto L33;
        r105 = false;
        goto L33
    L17:
        ResultKt.throwOnFailure(r102);
    L21:
        String r118 = "DoraWakeupNotice" + System.currentTimeMillis();
        f291400g = r118;
        r113 = System.currentTimeMillis();
        FLogger.f375446a.i("DoraWakeupResponse", "wakeupResponseTimer timeout, hasReceivedVadEnd=" + f291401h + ", taskId=" + r118);
        r114 = System.currentTimeMillis();
        CoroutineDispatcher r119 = Dispatchers.getIO();
        DoraWakeupResponseManager$runWakeupResponse$mp3Path$1 r120 = new DoraWakeupResponseManager$runWakeupResponse$mp3Path$1(null);
        r100.L$0 = r118;
        r100.J$0 = r113;
        r100.J$1 = r114;
        r100.label = 2;
        Object r121 = BuildersKt.withContext(r119, r120, r100);
        if (r121 == r103) goto L44;
        r112 = r118;
        r102 = r121;
        goto L25
    L44:
        return r103;
    L18:
        ResultKt.throwOnFailure(r102);
        r100.label = 1;
        if (DelayKt.delay(1700, r100) != r103) goto L21;
        return r103;
    L7:
        r100 = new DoraWakeupResponseManager$runWakeupResponse$1(r110, r210);
        goto L8
    }

    public static void f(String r100, long r101) {
        String r102 = (String) CollectionsKt.random(CollectionsKt.listOf(new String[]{"嗯。", "我在听"}), Random.Default);
        FLogger.f375446a.i("DoraWakeupResponse", "play wakeup response TTS, taskId=" + r100 + ", text=" + r102);
        u0.b(r102, r100, new a(r100, r101));
    }
}
