package com.obric.sva.sdk.ipc;

import android.app.ActivityManager;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ixigua.lib.track.TrackParams;
import com.obric.assistant.t1;
import com.obric.sva.sdk.apm.InteractorApmHelper;
import com.obric.sva.sdk.controller.HotwordRecorderMgr;
import com.obric.sva.sdk.logger.BackTraceEventEmitter;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.logger.WakeupInterruptedEventEmitter;
import com.obric.sva.sdk.logger.WakeupMetricAttributionEmitter;
import com.obric.sva.sdk.upload.WakeupUploadManager;
import com.obric.sva.sdk.utils.InteractConst;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0013J\b\u00100\u001a\u00020.H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0013H\u0002J\u000e\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u001aJ\u000e\u00106\u001a\u00020.2\u0006\u00105\u001a\u00020\u001aJ*\u00107\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005J\u0010\u0010=\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J*\u0010?\u001a\u00020.2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J \u0010@\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0018\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u00020.H\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u001a\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0005J\u0018\u0010H\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010J\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020.H\u0002J\u0018\u0010N\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010O\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0002J\u001c\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010F\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010T\u001a\u00020.*\u00020U2\u0006\u0010V\u001a\u00020\u0005H\u0002J\f\u0010W\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u0014\u0010X\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackerManager;", "", "<init>", "()V", "TAG", "", "KEY_SESSION_TYPE", "SESSION_TYPE_VOICE", "SESSION_TYPE_BREATH", "voiceBreathTags", "", "[Ljava/lang/String;", "MAX_PENDING_REPORT_EVENTS", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "observerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "messenger", "Landroid/os/Messenger;", "attachedGeneration", "", "callbacks", "", "Lcom/obric/sva/sdk/ipc/TrackerManager$MessageCallback;", "pendingReportEvents", "Lkotlin/collections/ArrayDeque;", "Lkotlin/Pair;", "pendingReportDrainCallbackRegistered", "handlerThread", "Landroid/os/HandlerThread;", "interactorHandler", "Landroid/os/Handler;", "interactorMessenger", "getInteractorMessenger", "()Landroid/os/Messenger;", "interactorMessenger$delegate", "Lkotlin/Lazy;", "observer", "Landroid/database/ContentObserver;", "getObserver", "()Landroid/database/ContentObserver;", "observer$delegate", "initLocal", "", "_context", "ensureWorkerReady", "isMainProcessAlive", "", "ctx", "registerMessengerCallback", "callback", "unregisterMessengerCallback", "attachFromHostProvider", "binder", "Landroid/os/IBinder;", "ownerToken", "generation", "reason", "tryAttachFromProviderIfMainAlive", "tryAttachFromProvider", "attachMainMessenger", "detachMainMessengerIfCurrent", "onMainMessengerDetached", "prevGeneration", "sendInteractorMessengerLocked", "postHandshakeIfReady", "onTrackEvent", "trackerID", "trackerData", "handleTrackEventOnWorker", "data", "enqueueReportEvent", "schedulePendingReportDrainOnReady", "postDrainPendingReportEvents", "drainPendingReportEvents", "handleWakeupUploadTriggerInInteractor", "handleTrackerInInteractor", "traceDataInInteractor", "trackID", "wakeupSessionType", "buildTrackerDataForLog", "maskLogField", "Lorg/json/JSONObject;", "key", "toLogTail", "timeJson", "getTimeJson", "()Ljava/lang/String;", "MessageCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackerManager {
    public static final TrackerManager INSTANCE = null;
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final int MAX_PENDING_REPORT_EVENTS = 200;
    private static final String SESSION_TYPE_BREATH = "BREATH";
    private static final String SESSION_TYPE_VOICE = "VOICE";
    private static final String TAG = "TrackerManager";
    private static volatile long attachedGeneration;
    private static final List<MessageCallback> callbacks = null;
    private static volatile Context context;
    private static final HandlerThread handlerThread = null;
    private static Handler interactorHandler;
    private static final Lazy interactorMessenger$delegate = null;
    private static final ReentrantLock lock = null;
    private static volatile Messenger messenger;
    private static final Lazy observer$delegate = null;
    private static final AtomicBoolean observerRegistered = null;
    private static final AtomicBoolean pendingReportDrainCallbackRegistered = null;
    private static final ArrayDeque<Pair<Integer, String>> pendingReportEvents = null;
    private static final String[] voiceBreathTags = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackerManager$MessageCallback;", "", "onMessage", "", "msg", "Landroid/os/Message;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MessageCallback {
        void onMessage(Message r100);
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.ipc.TrackerManager$traceDataInInteractor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.sva.sdk.ipc.TrackerManager$traceDataInInteractor$1", f = "TrackerManager.kt", i = {0}, l = {476}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ int $trackID;
        final /* synthetic */ Ref.ObjectRef<String> $wakeupStage;
        final /* synthetic */ Ref.BooleanRef $wakeupSuccess;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(int r100, String r101, Ref.ObjectRef<String> r102, Ref.BooleanRef r103, Continuation<? super AnonymousClass1> r104) {
            this.$trackID = r100;
            this.$data = r101;
            this.$wakeupStage = r102;
            this.$wakeupSuccess = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$trackID, this.$data, this.$wakeupStage, this.$wakeupSuccess, r101);
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
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            int r102 = 1;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);
        L11:
            Map<Integer, String> r104 = com.obric.assistant.voice.m.f394382a;
            Map<Integer, String> r105 = com.obric.assistant.voice.m.f394382a;
            int r106 = this.$trackID;
            LinkedHashMap r107 = new LinkedHashMap();
            Iterator<Map.Entry<Integer, String>> r108 = r105.entrySet().iterator();
        L12:
            int r109 = 0;
            if (r108.hasNext() == false) goto L19;
            Map.Entry<Integer, String> r110 = r108.next();
            if (r110.getKey().intValue() != r106) goto L17;
            r109 = 1;
        L17:
            if (r109 == 0) goto L12;
            r107.put(r110.getKey(), r110.getValue());
            goto L12
        L19:
            String r111 = this.$data;
            Ref.ObjectRef<String> r112 = this.$wakeupStage;
            Ref.BooleanRef r113 = this.$wakeupSuccess;
            Iterator r114 = r107.entrySet().iterator();
        L21:
            if (r114.hasNext() == false) goto L70;
            String r115 = (String) ((Map.Entry) r114.next()).getValue();
            Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L25
            Object r117 = Result.m9449constructorimpl(new JSONObject(r111));     // Catch: Throwable -> L25
        L27:
            JSONObject r118 = new JSONObject();
            if (Result.m9455isFailureimpl(r117) == false) goto L30;
            r117 = r118;
        L30:
            JSONObject r119 = (JSONObject) r117;
            by7.a r120 = new by7.a(r115);     // Catch: Throwable -> L33
            r120.f21463a.merge(new TrackParams().merge(r119));     // Catch: Throwable -> L33
            r120.b();     // Catch: Throwable -> L33
            Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
        L35:
            Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
            if (r122 == null) goto L79;
            LogUtils.w(TrackerManager.TAG, "Event.emit failed event=" + r115 + ": " + r122.getMessage(), new Object[r109]);
        L79:
        L49:
            th = th;
            String r123 = TrackerManager.TAG;
            String r124 = ": ";
        L51:
            Result.Companion r125 = Result.Companion;
            Object r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L52:
            Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
            if (r127 == null) goto L56;
            LogUtils.w(r123, "schedule sys pb failed event=" + r115 + r124 + r127.getMessage(), new Object[0]);
        L56:
            if (InteractorReportInitializer.INSTANCE.isApmReady() == true) goto L58;
            r109 = 0;
            LogUtils.i(r123, "monitorEventForSlardar skipped before APM ready event=" + r115, new Object[0]);
        L68:
            LogUtils.i(r123, "traceDataInInteractor event=" + r115 + " payload=" + r119, new Object[r109]);
            r102 = 1;
            goto L21
        L58:
            if (t1.f393353a.o0() == true) goto L77;
        L66:
            r109 = 0;
            goto L68
        L77:
            InteractorApmHelper.INSTANCE.monitorEventForSlardar(r115, r119, null, null);     // Catch: Throwable -> L61
            Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
        L63:
            Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
            if (r129 == null) goto L66;
            r109 = 0;
            LogUtils.w(r123, "monitorEventForSlardar failed: " + r129.getMessage(), new Object[0]);
        L61:
            th = move-exception;
            Result.Companion r130 = Result.Companion;
            r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L63
        L40:
            if (ArraysKt.contains(TrackerManager.access$getVoiceBreathTags$p(), r119.optString(TrackerManager.KEY_SESSION_TYPE)) == false) goto L44;
            CoroutineScope r131 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, r102, null)));     // Catch: Throwable -> L49
            r123 = TrackerManager.TAG;
            r124 = ": ";
            BuildersKt.launch$default(r131, null, null, new TrackerManager$traceDataInInteractor$1$2$3$1(r115, r112, r113, r119, null), 3, null);     // Catch: Throwable -> L47
        L45:
            r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
        L47:
            th = th;
            goto L51
        L44:
            r123 = TrackerManager.TAG;
            r124 = ": ";
        L33:
            th = move-exception;
            Result.Companion r132 = Result.Companion;
            r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L25:
            th = move-exception;
            Result.Companion r133 = Result.Companion;
            r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L27
        L70:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            if (DelayKt.delay(3000, this) != r100) goto L11;
            return r100;
        }
    }

    private TrackerManager() {
    }

    public static /* synthetic */ void a() {
        postDrainPendingReportEvents$lambda$31();
    }

    public static /* synthetic */ void b(String r100) {
        postHandshakeIfReady$lambda$27(r100);
    }

    public static /* synthetic */ Messenger c() {
        return interactorMessenger_delegate$lambda$4();
    }

    public static /* synthetic */ void d(int r100, String r101) {
        onTrackEvent$lambda$28(r100, r101);
    }

    public static /* synthetic */ TrackerManager$observer$2$1 e() {
        return observer_delegate$lambda$5();
    }

    public static /* synthetic */ Unit f() {
        return schedulePendingReportDrainOnReady$lambda$30();
    }

    public static /* synthetic */ void g() {
        initLocal$lambda$8();
    }

    public static /* synthetic */ boolean h(Message r100) {
        return interactorMessenger_delegate$lambda$4$lambda$3(r100);
    }

    static {
        INSTANCE = new TrackerManager();
        voiceBreathTags = new String[]{SESSION_TYPE_VOICE, SESSION_TYPE_BREATH};
        lock = new ReentrantLock();
        observerRegistered = new AtomicBoolean(false);
        callbacks = new ArrayList();
        pendingReportEvents = new ArrayDeque();
        pendingReportDrainCallbackRegistered = new AtomicBoolean(false);
        handlerThread = new PthreadHandlerThreadV2("sva-interactor-tracker");
        interactorMessenger$delegate = LazyKt.lazy(new z());
        observer$delegate = LazyKt.lazy(new a0());
    }

    private final void drainPendingReportEvents() {
        ReentrantLock r100 = lock;
        r100.lock();
        ArrayDeque<Pair<Integer, String>> r101 = pendingReportEvents;     // Catch: Throwable -> L10
        List r102 = CollectionsKt.toList(r101);     // Catch: Throwable -> L10
        r101.clear();     // Catch: Throwable -> L10
        r100.unlock();
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Pair r104 = (Pair) r103.next();
        INSTANCE.handleTrackerInInteractor(((Number) r104.component1()).intValue(), (String) r104.component2());
        goto L6
    L8:
        LogUtils.i(TAG, "drainPendingReportEvents size=" + r102.size(), new Object[0]);
        return;
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    private final void ensureWorkerReady() {
        HandlerThread r100 = handlerThread;
        if (ThreadMethodProxy.isAlive(r100) == true) goto L14;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (ThreadMethodProxy.isAlive(r100) == true) goto L8;
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
    L14:
        getInteractorMessenger();
    }

    private final Messenger getInteractorMessenger() {
        return (Messenger) interactorMessenger$delegate.getValue();
    }

    private final ContentObserver getObserver() {
        return (ContentObserver) observer$delegate.getValue();
    }

    private final String getTimeJson() {
        JSONObject r100 = new JSONObject();
        r100.put("timestamp", System.currentTimeMillis());
        return r100.toString();
    }

    private static final void initLocal$lambda$8() {
        INSTANCE.tryAttachFromProviderIfMainAlive("init_local");
    }

    private static final Messenger interactorMessenger_delegate$lambda$4() {
        interactorHandler = new Handler(handlerThread.getLooper(), new x());
        Handler r100 = interactorHandler;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r100 = null;
    L6:
        return new Messenger(r100);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.sva.sdk.ipc.TrackerManager$observer$2$1] */
    private static final TrackerManager$observer$2$1 observer_delegate$lambda$5() {
        final Handler r100 = interactorHandler;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r100 = null;
    L6:
        return new TrackerManager$observer$2$1(r100);
    }

    private static final void postDrainPendingReportEvents$lambda$31() {
        INSTANCE.drainPendingReportEvents();
    }

    private final void schedulePendingReportDrainOnReady() {
        AtomicBoolean r100 = pendingReportDrainCallbackRegistered;
        if (r100.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        InteractorReportInitializer r101 = InteractorReportInitializer.INSTANCE;
        r101.initIfNeeded(new t());
        if (r101.isPrivacyAgreed() == true) goto L9;
        r100.set(false);
        return;
    }

    private static final Unit schedulePendingReportDrainOnReady$lambda$30() {
        pendingReportDrainCallbackRegistered.set(false);
        INSTANCE.postDrainPendingReportEvents();
        return Unit.INSTANCE;
    }

    private final void sendInteractorMessengerLocked() {
        ReentrantLock r100 = lock;
        r100.lock();
        Messenger r101 = messenger;     // Catch: Throwable -> L22
        if (r101 == null) goto L7;
        Pair r102 = TuplesKt.to(r101, Long.valueOf(attachedGeneration));     // Catch: Throwable -> L22
    L8:
        r100.unlock();
        if (r102 != null) goto L11;
        return;
    L11:
        Messenger r103 = (Messenger) r102.component1();
        long r104 = ((Number) r102.component2()).longValue();
        Message r105 = Message.obtain();
        r105.what = 2;
        r105.replyTo = INSTANCE.getInteractorMessenger();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        r103.send(r105);     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L29;
        LogUtils.e(TAG, "sendInteractorMessenger failed: " + r108.getMessage(), new Object[0]);
        if ((r108 instanceof DeadObjectException) == false) goto L30;
        INSTANCE.detachMainMessengerIfCurrent(r103.getBinder(), r104, "dead_on_handshake");
        return;
    L30:
        return;
    L29:
        return;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L7:
        r102 = null;
    L22:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    private final void postDrainPendingReportEvents() {
        ensureWorkerReady();
        Handler r100 = interactorHandler;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r100 = null;
    L5:
        r100.post(new y());
    }

    public static final /* synthetic */ String[] access$getVoiceBreathTags$p() {
        return voiceBreathTags;
    }

    private static final boolean interactorMessenger_delegate$lambda$4$lambda$3(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Message r101 = Message.obtain();
        r101.what = r100.what;
        r101.arg1 = r100.arg1;
        r101.arg2 = r100.arg2;
        if (r100.getData() == null) goto L5;
        r101.setData(r100.getData());
    L5:
        ReentrantLock r102 = lock;
        r102.lock();
        Iterator<T> r103 = callbacks.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L10;
        MessageCallback r104 = (MessageCallback) r103.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L13
        r104.onMessage(r101);     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r102.unlock();
        return true;
    L13:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    private final boolean isMainProcessAlive(Context r100) {
        Object r101 = r100.getSystemService("activity");
        Object r102 = null;
        if ((r101 instanceof ActivityManager) == false) goto L5;
        ActivityManager r103 = (ActivityManager) r101;
    L7:
        if (r103 != null) goto L9;
        return false;
    L9:
        String r104 = r100.getPackageName();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(r103.getRunningAppProcesses());     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r102 = r106;
    L18:
        List r107 = (List) r102;
        if (r107 != null) goto L21;
        r107 = CollectionsKt.emptyList();
    L21:
        List r108 = r107;
        if ((r108 instanceof Collection) == true) goto L24;
    L26:
        Iterator r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) r109.next()).processName, r104) == false) goto L28;
        return true;
    L39:
        return false;
    L24:
        if (r108.isEmpty() == false) goto L26;
        return false;
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        r103 = null;
        goto L7
    }

    private final void postHandshakeIfReady(final String r100) {
        ensureWorkerReady();
        Handler r101 = interactorHandler;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r101 = null;
    L5:
        r101.post(new u(r100));
    }

    private static final void postHandshakeIfReady$lambda$27(String r100) {
        ReentrantLock r101 = lock;
        r101.lock();
        boolean r102 = !callbacks.isEmpty();
        r101.unlock();
        if (r102 == true) goto L8;
        LogUtils.i(TAG, "handshake deferred: callback not ready reason=" + r100, new Object[0]);
        return;
    L8:
        INSTANCE.sendInteractorMessengerLocked();
        return;
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    private final String toLogTail(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return "";
    L10:
        return "***" + StringsKt.takeLast(r100, 4);
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryAttachFromProvider(String r110) {
        Context r100 = context;
        if (r100 != null) goto L5;
        return;
    L5:
        ReentrantLock r101 = lock;
        r101.lock();
        Messenger r102 = messenger;     // Catch: Throwable -> L77
        ContentProviderClient r103 = 0;
        Unit r104 = null;
        if (r102 == null) goto L10;
        Pair r105 = TuplesKt.to(r102.getBinder(), Long.valueOf(attachedGeneration));     // Catch: Throwable -> L77
    L11:
        r101.unlock();
        if (r105 == null) goto L86;
        IBinder r106 = (IBinder) r105.component1();
        long r107 = ((Number) r105.component2()).longValue();
        if (r106.isBinderAlive() == false) goto L16;
        return;
    L16:
        Intrinsics.checkNotNull(r106);
        if (detachMainMessengerIfCurrent(r106, r107, "stale_before_attach") == true) goto L86;
        return;
    L86:
        ContentProviderClient r111 = com_obric_sva_sdk_ipc_TrackerManager_android_content_ContentResolver_acquireUnstableContentProviderClient(r100.getContentResolver(), com.obric.assistant.voice.l.f394381a);     // Catch: Throwable -> L57 Exception -> L59
        if (r111 != null) goto L28;
        LogUtils.w(TAG, "tryAttachFromProvider: provider client null reason=" + r110, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L28:
        Bundle r109 = r111.call("get-tracker-messenger", null, null);     // Catch: Exception -> L55 Throwable -> L67
        if (r109 != null) goto L31;
    L49:
        LogUtils.i(TAG, "tryAttachFromProvider: main process not ready reason=" + r110, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L52
        r111.close();     // Catch: Throwable -> L52
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L31:
        if (r109.isEmpty() == true) goto L49;
        IBinder r114 = r109.getBinder("tracker_messenger");     // Catch: Exception -> L55 Throwable -> L67
        IBinder r115 = r109.getBinder("owner_token");     // Catch: Exception -> L55 Throwable -> L67
        long r116 = r109.getLong("ipc_generation", 0);     // Catch: Exception -> L55 Throwable -> L67
        if (r114 != null) goto L36;
    L43:
        LogUtils.w(TAG, "tryAttachFromProvider: binder null or dead reason=" + r110, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L46
        r111.close();     // Catch: Throwable -> L46
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
        return;
    L46:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L36:
        if (r114.isBinderAlive() == false) goto L43;
        attachMainMessenger(r114, r115, r116, r110);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L41
        r111.close();     // Catch: Throwable -> L41
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
        return;
    L55:
        e = e;
    L61:
        LogUtils.e(TAG, "tryAttachFromProvider failed reason=" + r110 + ": " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L67
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L41
        if (r111 == null) goto L65;
        r111.close();     // Catch: Throwable -> L41
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L65:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L41
        return;
    L67:
        th = move-exception;
        Throwable r121 = th;
    L81:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L74
        if (0 == 0) goto L72;
        r103.close();     // Catch: Throwable -> L74
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L74
    L72:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L74
        throw r121;
    L74:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw r121;
    L59:
        e = e;
        r111 = null;
    L57:
        th = move-exception;
        r121 = th;
    L41:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L10:
        r105 = null;
    L77:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    private final void tryAttachFromProviderIfMainAlive(String r100) {
        Context r101 = context;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = sna.d.f542675a;
        Context r103 = sna.f.f542676a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r104 = sna.f.b();
        r104.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        if (r104.a().getBoolean("reporter_privacy_agreed", false) == true) goto L10;
        LogUtils.i(TAG, "tryAttachFromProviderIfMainAlive skip: privacy not agreed reason=" + r100, new Object[0]);
        return;
    L10:
        if (isMainProcessAlive(r101) == true) goto L13;
        LogUtils.i(TAG, "tryAttachFromProviderIfMainAlive skip: main process not alive reason=" + r100, new Object[0]);
        return;
    L13:
        tryAttachFromProvider(r100);
    }

    private final String wakeupSessionType(String r100) {
        Object r101 = SESSION_TYPE_VOICE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(new JSONObject(r100).optString(KEY_SESSION_TYPE, SESSION_TYPE_VOICE));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r101 = r103;
    L12:
        return (String) r101;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void initLocal(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "_context");
        Context r101 = r100.getApplicationContext();
        context = r101;
        ensureWorkerReady();
        if (observerRegistered.compareAndSet(false, true) == true) goto L16;
    L11:
        Handler r102 = interactorHandler;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r102 = null;
    L14:
        r102.post(new w());
        return;
    L16:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L6
        r101.getContentResolver().registerContentObserver(com.obric.assistant.voice.l.f394381a, false, INSTANCE.getObserver());     // Catch: Throwable -> L6
        LogUtils.i(TAG, "initLocal ContentObserver registered", new Object[0]);     // Catch: Throwable -> L6
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        observerRegistered.set(false);
        LogUtils.e(TAG, "initLocal registerContentObserver failed: " + r105.getMessage(), new Object[0]);
    L6:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void registerMessengerCallback(MessageCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ensureWorkerReady();
        ReentrantLock r101 = lock;
        r101.lock();
        callbacks.add(r100);     // Catch: Throwable -> L6
        r101.unlock();
        postHandshakeIfReady("callback_registered");
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void unregisterMessengerCallback(MessageCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ReentrantLock r101 = lock;
        r101.lock();
        callbacks.remove(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public static final /* synthetic */ void access$tryAttachFromProvider(TrackerManager r100, String r101) {
        r100.tryAttachFromProvider(r101);
    }

    private final String buildTrackerDataForLog(int r100, String r101) {
        if (r100 == 411) goto L5;
        return r101;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L26;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r104 = new JSONObject(r101);     // Catch: Throwable -> L15
        TrackerManager r105 = INSTANCE;     // Catch: Throwable -> L15
        r105.maskLogField(r104, "raw_uid");     // Catch: Throwable -> L15
        r105.maskLogField(r104, "uid");     // Catch: Throwable -> L15
        r105.maskLogField(r104, com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: Throwable -> L15
        r105.maskLogField(r104, "os_did");     // Catch: Throwable -> L15
        r105.maskLogField(r104, InteractConst.USER_HANDLE_ID);     // Catch: Throwable -> L15
        Object r106 = Result.m9449constructorimpl(r104.toString());     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L22;
        LogUtils.w(TAG, "buildTrackerDataForLog failed: " + r107.getMessage(), new Object[0]);
        r106 = "[masked-invalid-truth-capture-payload]";
    L22:
        return (String) r106;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L26:
        return r101;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    private static ContentProviderClient com_obric_sva_sdk_ipc_TrackerManager_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private final void enqueueReportEvent(int r100, String r101) {
        ReentrantLock r102 = lock;
        r102.lock();
    L12:
        ArrayDeque<Pair<Integer, String>> r103 = pendingReportEvents;     // Catch: Throwable -> L9
        if (r103.size() < 200) goto L6;
        r103.removeFirst();     // Catch: Throwable -> L9
        goto L12
    L6:
        r103.addLast(TuplesKt.to(Integer.valueOf(r100), r101));     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r102.unlock();
        return;
    L9:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    private final void handleTrackEventOnWorker(int r100, String r101) {
        String r102 = buildTrackerDataForLog(r100, r101);
        InteractorReportInitializer r103 = InteractorReportInitializer.INSTANCE;
        if (r103.isPrivacyAgreed() == true) goto L6;
        LogUtils.d(TAG, "onTrackEvent dropped before privacy agreed trackerID=" + r100 + " data=" + r102, new Object[0]);
        return;
    L6:
        handleWakeupUploadTriggerInInteractor(r100, r101);
        if (r103.isReady() == true) goto L10;
        enqueueReportEvent(r100, r101);
        schedulePendingReportDrainOnReady();
        LogUtils.d(TAG, "onTrackEvent queued until reporter ready trackerID=" + r100 + " data=" + r102, new Object[0]);
        return;
    L10:
        handleTrackerInInteractor(r100, r101);
        LogUtils.d(TAG, "onTrackEvent handled in interactor trackerID=" + r100 + " data=" + r102, new Object[0]);
    }

    private final void handleTrackerInInteractor(int r100, String r101) {
        if (r100 != 400) goto L5;
        WakeupInterruptedEventEmitter.INSTANCE.reportWakeupFailed(r101);
        return;
    L5:
        switch(r100) {
            case 500: goto L41;
            case 501: goto L43;
            case 502: goto L17;
            case 503: goto L39;
            default: goto L6;
        };
    L6:
        traceDataInInteractor(r100, r101);
        return;
    L17:
        BackTraceEventEmitter.INSTANCE.reportBacktraceDuration(r101);
        return;
    L39:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L10
    L12:
        JSONObject r104 = new JSONObject();
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = r104;
    L15:
        JSONObject r105 = (JSONObject) r103;
        String r106 = r105.optString("scene", "obric_hotword_wakeup");
        String r107 = r105.optString("error_reason", "");
        BackTraceEventEmitter r108 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r107);
        r108.reportBacktraceRecordError(r106, r107);
        return;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L41:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L30
        Object r111 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L30
    L32:
        JSONObject r112 = new JSONObject();
        if (Result.m9455isFailureimpl(r111) == false) goto L35;
        r111 = r112;
    L35:
        String r113 = ((JSONObject) r111).optString("scene", "obric_hotword_wakeup");
        BackTraceEventEmitter r114 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r113);
        r114.reportAudioRecorderStart(r113);
        return;
    L30:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L43:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L21
        Object r117 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L21
    L23:
        JSONObject r118 = new JSONObject();
        if (Result.m9455isFailureimpl(r117) == false) goto L26;
        r117 = r118;
    L26:
        JSONObject r119 = (JSONObject) r117;
        String r120 = r119.optString("scene", "obric_hotword_wakeup");
        boolean r121 = r119.optBoolean("success", false);
        String r122 = r119.optString("error_reason", "");
        BackTraceEventEmitter r123 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r120);
        r123.reportAudioRecorderStartResult(r120, r121, r122);
        return;
    L21:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private final void handleWakeupUploadTriggerInInteractor(int r100, String r101) {
        if (r100 == 200) goto L17;
        return;
    L17:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(wakeupSessionType(r101), SESSION_TYPE_BREATH) == false) goto L8;
        WakeupUploadManager.INSTANCE.onBreathWakeupPassed();     // Catch: Throwable -> L11
    L9:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L19;
        LogUtils.w(TAG, "handleWakeupUploadTriggerInInteractor failed: " + r104.getMessage(), new Object[0]);
        return;
    L19:
        return;
    L8:
        WakeupUploadManager.INSTANCE.onVoiceWakeupPassed();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void maskLogField(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
        return;
    L5:
        r100.put(r101, toLogTail(r100.optString(r101)));
    }

    private final void onMainMessengerDetached(long r100, String r101) {
        TrackerTelemetry.INSTANCE.onTrackerDetach(r100, r101);
        HotwordRecorderMgr.forceStopStream();
    }

    private static final void onTrackEvent$lambda$28(int r100, String r101) {
        INSTANCE.handleTrackEventOnWorker(r100, r101);
    }

    private final void traceDataInInteractor(int r110, String r111) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = "";
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        if (r110 != 100) goto L5;
        r100.element = "stage1";
        r101.element = true;
    L24:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        Object r103 = Result.m9449constructorimpl(new JSONObject(r111));     // Catch: Throwable -> L17
    L19:
        JSONObject r104 = new JSONObject();
        if (Result.m9455isFailureimpl(r103) == false) goto L22;
        r103 = r104;
    L22:
        WakeupMetricAttributionEmitter r105 = WakeupMetricAttributionEmitter.INSTANCE;
        r105.onSecondaryWakeup(r110, (JSONObject) r103);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(r110, r111, r100, r101, null), 3, null);
        return;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        if (r110 != 300) goto L7;
        r100.element = "stage3";
        r101.element = true;
        goto L24
    L7:
        if (r110 != 200) goto L9;
        r100.element = "stage2";
        r101.element = true;
        goto L24
    L9:
        if (r110 != 201) goto L24;
        r100.element = "stage2";
        r101.element = false;
        goto L24
    }

    public final void onTrackEvent(final int r100, final String r101) {
        if (r101 != null) goto L4;
        r101 = getTimeJson();
    L4:
        ensureWorkerReady();
        Handler r102 = interactorHandler;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r102 = null;
    L7:
        r102.post(new v(r100, r101));
    }

    private final boolean detachMainMessengerIfCurrent(IBinder r100, long r101, String r102) {
        ReentrantLock r103 = lock;
        r103.lock();
        Messenger r104 = messenger;     // Catch: Throwable -> L17
        Long r105 = null;
        if (r104 == null) goto L6;
        IBinder r106 = r104.getBinder();     // Catch: Throwable -> L17
    L7:
        if (r106 == r100) goto L9;
    L11:
        r103.unlock();
        if (r105 == null) goto L15;
        onMainMessengerDetached(r105.longValue(), r102);
        return true;
    L15:
        LogUtils.i(TAG, "detachMainMessengerIfCurrent ignored generation=" + r101 + " reason=" + r102, new Object[0]);
        return false;
    L9:
        if (attachedGeneration != r101) goto L11;
        long r107 = attachedGeneration;     // Catch: Throwable -> L17
        messenger = null;     // Catch: Throwable -> L17
        attachedGeneration = 0;     // Catch: Throwable -> L17
        r105 = Long.valueOf(r107);     // Catch: Throwable -> L17
        goto L11
    L6:
        r106 = null;
    L17:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    public static final /* synthetic */ boolean access$detachMainMessengerIfCurrent(TrackerManager r100, IBinder r101, long r102, String r103) {
        return r100.detachMainMessengerIfCurrent(r101, r102, r103);
    }

    private final void attachMainMessenger(final IBinder r100, IBinder r101, final long r102, String r103) {
        ReentrantLock r104 = lock;
        r104.lock();
        Messenger r105 = messenger;     // Catch: Throwable -> L28
        if (r105 == null) goto L6;
        IBinder r106 = r105.getBinder();     // Catch: Throwable -> L28
    L7:
        if (r106 != null) goto L9;
    L15:
        messenger = new Messenger(r100);     // Catch: Throwable -> L28
        attachedGeneration = r102;     // Catch: Throwable -> L28
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r104.unlock();
        TrackerTelemetry.INSTANCE.onTrackerAttach(r102, r103);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L19
        r100.linkToDeath(new TrackerManager$attachMainMessenger$2$1(r100, r102), 0);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L24;
        LogUtils.e(TAG, "linkToDeath failed: " + r110.getMessage(), new Object[0]);
    L24:
        if (r101 == null) goto L26;
        TemporaryWakeupGateManager.INSTANCE.onOwnerTokenAvailable(r101, r102);
    L26:
        postHandshakeIfReady(r103);
        return;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L9:
        if (r106.isBinderAlive() == false) goto L15;
        if (attachedGeneration != r102) goto L15;
        r104.unlock();
        return;
    L6:
        r106 = null;
    L28:
        th = move-exception;
        r104.unlock();
        throw th;
    }

    public final void attachFromHostProvider(IBinder r100, IBinder r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "reason");
        if (r100 != null) goto L5;
    L9:
        LogUtils.w(TAG, "attachFromHostProvider ignored: binder null/dead reason=" + r103 + " generation=" + r102, new Object[0]);
        return;
    L5:
        if (r100.isBinderAlive() == false) goto L9;
        ensureWorkerReady();
        attachMainMessenger(r100, r101, r102, r103);
    }

    public static /* synthetic */ void onTrackEvent$default(TrackerManager r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.onTrackEvent(r101, r102);
    }
}
