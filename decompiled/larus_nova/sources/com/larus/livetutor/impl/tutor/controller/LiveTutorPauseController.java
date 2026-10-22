package com.larus.livetutor.impl.tutor.controller;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.livetutor.api.idl.ControlReason;
import com.larus.livetutor.api.idl.PauseLocation;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.tutor.data.LiveTutorPauseEvent;
import com.larus.livetutor.impl.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0014\u001a\u00020\u00122\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010J7\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0002\u0010\u001fJ \u0010 \u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0012J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110&*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/livetutor/impl/tutor/controller/LiveTutorPauseController;", "Landroidx/lifecycle/LifecycleObserver;", "viewModel", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "<init>", "(Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;)V", "pauseRtc", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/livetutor/impl/tutor/data/LiveTutorPauseEvent;", "kotlin.jvm.PlatformType", "getPauseRtc", "()Landroidx/lifecycle/MutableLiveData;", "pauseMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "onPause", "Lkotlin/Function1;", "Lcom/larus/livetutor/api/idl/ControlReason;", "", "onResumeFail", "initObserver", "pause", "pauseReason", "autoResume", "", "customPauseKey", "withAnim", "(Lcom/larus/livetutor/api/idl/ControlReason;ZLjava/lang/Integer;Z)V", "generatePauseKey", "(Lcom/larus/livetutor/api/idl/ControlReason;Ljava/lang/Integer;)I", "resume", "(Lcom/larus/livetutor/api/idl/ControlReason;Ljava/lang/Integer;Z)V", "sendResumeWithRetry", "maxRetries", "(Lcom/larus/livetutor/api/idl/ControlReason;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPause", BasicTestActionHandler.TEST_ACTION_RESET, "pauseType", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorPauseController implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f356447f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveTutorViewModel f356448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<LiveTutorPauseEvent> f356449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LiveTutorPauseEvent> f356450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super ControlReason, Unit> f356451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super ControlReason, Unit> f356452e;

    public static final class a {
    }

    public static final class b implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ControlReason f356453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f356454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f356455c;

        public b(ControlReason r100, int r101, SafeContinuation r102) {
            this.f356453a = r100;
            this.f356454b = r101;
            this.f356455c = r102;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            boolean r102 = kj9.b.f503724a;
            kj9.b.a("[LiveTutorPauseController] resumeSpeaking " + r101 + ", reason = " + this.f356453a + ", times = " + this.f356454b);
            this.f356455c.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r101)));
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void d() {
        kj9.b.a("[LiveTutorPauseController] reset");
        this.f356450c.clear();
        this.f356449b.postValue(new LiveTutorPauseEvent(false, false, null, false, false, 30, null));
    }

    public LiveTutorPauseController(LiveTutorViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        this.f356448a = r110;
        this.f356449b = new MutableLiveData(new LiveTutorPauseEvent(false, false, null, false, false, 30, null));
        this.f356450c = new ConcurrentHashMap();
        this.f356451d = new v();
        this.f356452e = new w();
    }

    public static List c(Map r100) {
        Collection r101 = ((ConcurrentHashMap) r100).values();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ControlReason r104 = ((LiveTutorPauseEvent) r103.next()).getPauseReason();
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public final void a(com.larus.livetutor.impl.repository.viewmodel.g r100, com.larus.livetutor.impl.repository.viewmodel.h r101) {
        Intrinsics.checkNotNullParameter(r100, "onPause");
        Intrinsics.checkNotNullParameter(r101, "onResumeFail");
        LifecycleOwner r102 = this.f356448a.getLifecycleOwner();
        if (r102 == null) goto L7;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L7;
        r103.addObserver(this);
    L7:
        this.f356451d = r100;
        this.f356452e = r101;
        UtilsKt.n(ViewModelKt.getViewModelScope(this.f356448a), null, new LiveTutorPauseController$initObserver$3(this, null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12, types: [int] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.Boolean, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16, types: [int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12, types: [int] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009c -> B:47:0x00a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d3 -> B:40:0x00d8). Please report as a decompilation issue!!! */
    public final Object f(ControlReason r110, int r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof LiveTutorPauseController$sendResumeWithRetry$1) == false) goto L7;
        LiveTutorPauseController$sendResumeWithRetry$1 r100 = (LiveTutorPauseController$sendResumeWithRetry$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        ?? r114 = r100.I$2;
        ?? r115 = r100.I$1;
        int r104 = r100.I$0;
        LiveTutorPauseController$sendResumeWithRetry$1 r105 = (LiveTutorPauseController$sendResumeWithRetry$1) r100.L$2;
        LiveTutorPauseController r106 = (LiveTutorPauseController) r100.L$1;
        ControlReason r107 = (ControlReason) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
        ControlReason r108 = r107;
        int r109 = r104;
        LiveTutorPauseController r116 = this;
        r114 = r114;
        r115 = r115;
    L47:
    L36:
        Throwable th10 = th;
    L40:
        Result.Companion r117 = Result.Companion;
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        ?? r119 = r114;
        ?? r120 = r115;
    L41:
        Object r121 = r118;
        ?? r122 = r120;
        ControlReason r123 = r108;
        LiveTutorPauseController r124 = r116;
        Object r125 = r102;
        LiveTutorPauseController$sendResumeWithRetry$1 r126 = r100;
        Throwable r127 = Result.m9452exceptionOrNullimpl(r121);
        if (r127 == null) goto L44;
        boolean r128 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorPauseController] exception during retry " + r119 + ": " + r127);
    L44:
        int r129 = (r122 == true ? 1 : 0) + 1;
        r100 = r126;
        r102 = r125;
        int r130 = r109;
        r116 = r124;
        r114 = r129;
    L19:
        if (r114 < r130) goto L51;
        boolean r131 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorPauseController] all " + r130 + " retries failed");
        return Boxing.boxBoolean(false);
    L51:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L38
        r100.L$0 = r123;     // Catch: Throwable -> L38
        r100.L$1 = r116;     // Catch: Throwable -> L38
        r100.L$2 = r100;     // Catch: Throwable -> L38
        r100.I$0 = r130;     // Catch: Throwable -> L38
        r100.I$1 = r114;     // Catch: Throwable -> L38
        r100.I$2 = r114;     // Catch: Throwable -> L38
        r100.label = 1;     // Catch: Throwable -> L38
        SafeContinuation r133 = new SafeContinuation(IntrinsicsKt.intercepted(r100));     // Catch: Throwable -> L38
        jj9.b r134 = r116.f356448a.getAudioController();     // Catch: Throwable -> L38
        if (r134 == null) goto L23;
        r134.e(r123, new b(r123, r114, r133));     // Catch: Throwable -> L38
    L24:
        Object r135 = r133.getOrThrow();     // Catch: Throwable -> L38
        if (r135 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r100);     // Catch: Throwable -> L38
    L27:
        if (r135 != r102) goto L29;
        return r102;
    L29:
        r108 = r123;
        r115 = r114;
        r109 = r130;
        r113 = r135;
        r114 = r114;
        goto L47
    L23:
        r133.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(false)));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r108 = r123;
        r115 = r114;
        r109 = r130;
        th10 = th;
        goto L40
    L31:
        if (((Boolean) r113).booleanValue() == false) goto L34;
        r114 = Boxing.boxBoolean(true);     // Catch: Throwable -> L36
        return r114;
    L34:
        boolean r136 = kj9.b.f503724a;     // Catch: Throwable -> L36
        kj9.b.a("[LiveTutorPauseController] retry " + r114 + " failed, will retry");     // Catch: Throwable -> L36
        r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
        r119 = r114;
        r120 = r115;
    L14:
        th10 = th;
        r108 = r107;
        r109 = r104;
        r116 = this;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        r116 = this;
        r130 = r111;
        r123 = r110;
        r114 = 0;
    L7:
        r100 = new LiveTutorPauseController$sendResumeWithRetry$1(this, r112);
        goto L8
    }

    public static void e(LiveTutorPauseController r210, ControlReason r211, Integer r212, boolean r213, int r214) {
        Integer r100 = null;
        if ((r214 & 1) == 0) goto L5;
        ControlReason r101 = null;
    L7:
        if ((r214 & 2) != 0) goto L11;
        r100 = r212;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r110 = false;
    L15:
        monitor-enter(r210);
        r210.f356448a.dLogger("LiveTutorPauseController", "resume pauseReason = " + r101 + ", pauseType = " + c(r210.f356450c));     // Catch: Throwable -> L38
        if (r101 == null) goto L20;
        int r102 = r101.getValue();     // Catch: Throwable -> L38
    L19:
        int r103 = r102;
        if (r210.f356450c.containsKey(Integer.valueOf(r103)) == true) goto L29;
        r210.f356448a.eLogger("LiveTutorPauseController", "resume reason is not pause, pauseReason = " + r101 + ", pauseKey = " + r103);     // Catch: Throwable -> L38
        monitor-exit(r210);
        return;
    L29:
        if (r210.f356450c.size() <= 1) goto L33;
        boolean r104 = kj9.b.f503724a;     // Catch: Throwable -> L38
        kj9.b.a("[LiveTutorPauseController] pause size > 1, remove, pauseReason = " + r101 + ", pauseKey = " + r103);     // Catch: Throwable -> L38
        r210.f356450c.remove(Integer.valueOf(r103));     // Catch: Throwable -> L38
        monitor-exit(r210);
        return;
    L33:
        if (r101 == null) goto L35;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r210.f356448a), null, null, new LiveTutorPauseController$resume$1(r210, r101, r103, r110, null), 3, null);     // Catch: Throwable -> L38
    L36:
        monitor-exit(r210);
        return;
    L35:
        r210.f356450c.remove(Integer.valueOf(r103));     // Catch: Throwable -> L38
        r210.f356449b.setValue(new LiveTutorPauseEvent(false, false, null, false, r110, 14, null));     // Catch: Throwable -> L38
        goto L36
    L20:
        if (r100 == null) goto L22;
        r102 = r100.intValue();     // Catch: Throwable -> L38
        goto L19
    L22:
        r102 = ControlReason.Unknown.getValue();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L13:
        r110 = r213;
        goto L15
    L5:
        r101 = r211;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.larus.livetutor.impl.tutor.controller.u] */
    public static void b(final LiveTutorPauseController r110, ControlReason r111, boolean r112, Integer r113, boolean r114, int r115) {
        Integer r100 = null;
        if ((r115 & 1) == 0) goto L5;
        final ControlReason r101 = null;
    L6:
        boolean r116 = false;
        if ((r115 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r115 & 4) != 0) goto L15;
        r100 = r113;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        monitor-enter(r110);
        PauseLocation r117 = r110.f356448a.getCurrentPauseLocation();     // Catch: Throwable -> L51
        r110.f356448a.dLogger("LiveTutorPauseController", "pause pauseLocation = " + r117 + ", pauseReason = " + r101 + ", pauseType = " + c(r110.f356450c));     // Catch: Throwable -> L51
        if (r101 != ControlReason.SystemInterrupt) goto L23;
        final int r104 = ControlReason.PauseContinueButton.getValue();     // Catch: Throwable -> L51
    L30:
        if (r110.f356450c.containsKey(Integer.valueOf(r104)) == false) goto L34;
        r110.f356448a.eLogger("LiveTutorPauseController", " pause same reason cannot pause twice, pauseReason = " + r101 + ", pauseKey = " + r104);     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L34:
        final LiveTutorPauseEvent r118 = new LiveTutorPauseEvent(true, r102, r101, false, r103, 8, null);     // Catch: Throwable -> L51
        Intrinsics.checkNotNullParameter(r118, "<this>");     // Catch: Throwable -> L51
        ControlReason r105 = r118.getPauseReason();     // Catch: Throwable -> L51
        ControlReason r106 = ControlReason.PauseContinueButton;     // Catch: Throwable -> L51
        if (r105 != r106) goto L37;
        boolean r107 = true;
    L38:
        if (r107 == false) goto L40;
    L41:
        r116 = true;
    L42:
        r118.setContainsProactive(r116);     // Catch: Throwable -> L51
        if (r110.f356450c.isEmpty() == false) goto L48;
        if (r101 == null) goto L48;
        jj9.b r108 = r110.f356448a.getAudioController();     // Catch: Throwable -> L51
        if (r108 == 0) goto L49;
        r108.c(r117, r101, new u(r110, r104, r118, r101));     // Catch: Throwable -> L51
    L49:
        monitor-exit(r110);
        return;
    L48:
        r110.f356450c.put(Integer.valueOf(r104), r118);     // Catch: Throwable -> L51
        r110.f356449b.setValue(r118);     // Catch: Throwable -> L51
        r110.f356451d.invoke(r101);     // Catch: Throwable -> L51
        goto L49
    L40:
        if (r110.f356450c.containsKey(Integer.valueOf(r106.getValue())) == false) goto L42;
    L37:
        r107 = false;
        goto L38
    L23:
        if (r101 == null) goto L25;
        ControlReason r109 = r101;
    L28:
        r104 = r109.getValue();     // Catch: Throwable -> L51
        goto L30
    L25:
        if (r100 == null) goto L27;
        r104 = r100.intValue();     // Catch: Throwable -> L51
        goto L30
    L27:
        r109 = ControlReason.Unknown;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L17:
        r103 = r114;
        goto L19
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
