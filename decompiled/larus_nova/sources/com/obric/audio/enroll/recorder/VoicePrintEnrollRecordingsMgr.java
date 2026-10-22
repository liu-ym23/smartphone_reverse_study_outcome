package com.obric.audio.enroll.recorder;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import f06.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import me.ele.lancet.base.annotations.Skip;
import qia.d;
import qia.e;

/* JADX INFO: loaded from: classes33.dex */
public final class VoicePrintEnrollRecordingsMgr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f395460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnrollViewModel f395461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f395462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioRecord f395463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f395464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f395465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExecutorService f395466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Future<?> f395467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f395468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineScope f395469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BluetoothScoController f395470k;

    public final class BluetoothScoController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Job f395471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f395472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f395473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f395474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f395475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 f395476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f395477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CompletableDeferred<Boolean> f395478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile long f395479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ VoicePrintEnrollRecordingsMgr f395480j;

        public final AudioManager b() {
            Context r100 = this.f395480j.getContext();
            if (r100 == null) goto L11;
            Context r101 = r100.getApplicationContext();
            if (r101 == null) goto L13;
            Object r102 = r101.getSystemService("audio");
            if ((r102 instanceof AudioManager) == true) goto L10;
            return null;
        L10:
            return (AudioManager) r102;
        L13:
            return null;
        L11:
            return null;
        }

        public final void c() {
            if (this.f395472b == true) goto L6;
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: scheduleStopIfActive ignored (scoActive=false)");
            return;
        L6:
            Job r100 = this.f395471a;
            if (r100 == null) goto L9;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L9:
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: scheduleStopIfActive in 10000ms");
            this.f395471a = BuildersKt.launch$default(this.f395480j.f395469j, null, null, new VoicePrintEnrollRecordingsMgr$BluetoothScoController$scheduleStopIfActive$1(this, null), 3, null);
        }

        public final void g() {
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNowIfActive");
            Job r100 = this.f395471a;
            if (r100 == null) goto L5;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L5:
            this.f395471a = null;
            f(b());
        }

        public BluetoothScoController(VoicePrintEnrollRecordingsMgr r100) {
            this.f395480j = r100;
        }

        /* JADX WARN: Type inference failed for: r8v4, types: [com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1] */
        public final Object d(Continuation<? super Boolean> r110) {
            if ((r110 instanceof VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1) == false) goto L7;
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1 r100 = (VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1) r110;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r111 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L18;
            if (r103 == 1) goto L17;
            if (r103 == 2) goto L16;
            if (r103 != 3) goto L15;
            long r104 = r100.J$0;
            AudioManager r105 = (AudioManager) r100.L$0;
            ResultKt.throwOnFailure(r111);
        L76:
            boolean r112 = ((Boolean) r111).booleanValue();
            long r106 = r104;
            AudioManager r107 = r105;
        L77:
            long r108 = SystemClock.elapsedRealtime() - r106;
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected result=" + r112 + " cost=" + r108 + "ms");
            this.f395472b = r112;
            if (r112 == true) goto L81;
            f(r107);
        L81:
            return Boxing.boxBoolean(r112);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r106 = r100.J$0;
            r107 = (AudioManager) r100.L$0;
            ResultKt.throwOnFailure(r111);
        L72:
            r100.L$0 = r107;
            r100.J$0 = r106;
            r100.label = 3;
            r111 = e(this, r107, true, r100);
            if (r111 != r102) goto L75;
            return r102;
        L75:
            r105 = r107;
            r104 = r106;
            goto L76
        L17:
            r106 = r100.J$0;
            r107 = (AudioManager) r100.L$0;
            ResultKt.throwOnFailure(r111);
        L59:
            r112 = ((Boolean) r111).booleanValue();
            if (r112 == true) goto L77;
            Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L63
            r107.stopBluetoothSco();     // Catch: Throwable -> L63
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
        L88:
            r107.setBluetoothScoOn(false);     // Catch: Throwable -> L67
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
        L69:
            r100.L$0 = r107;
            r100.J$0 = r106;
            r100.label = 2;
            if (DelayKt.delay(200, r100) != r102) goto L72;
            return r102;
        L67:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L63:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L88
        L18:
            ResultKt.throwOnFailure(r111);
            Job r115 = this.f395471a;
            if (r115 == null) goto L21;
            Job.DefaultImpls.cancel$default(r115, null, 1, null);
        L21:
            Context r116 = this.f395480j.getContext();
            if (r116 == null) goto L82;
            Context r117 = r116.getApplicationContext();
            if (r117 == null) goto L82;
            r107 = b();
            if (r107 != null) goto L31;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (AudioManager null)");
            return Boxing.boxBoolean(false);
        L31:
            if (this.f395472b == false) goto L37;
            if (r107.isBluetoothScoOn() == false) goto L37;
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected fast-path (scoActive && isBluetoothScoOn)");
            return Boxing.boxBoolean(true);
        L37:
            if (this.f395477g == true) goto L52;
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: register receiver ACTION_SCO_AUDIO_STATE_UPDATED");
            final VoicePrintEnrollRecordingsMgr r118 = this.f395480j;
            ?? r119 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1(this, r118);
            Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L42
            a(r117, r119, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));     // Catch: Throwable -> L42
            Object r121 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L42
        L44:
            Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
            if (r122 == null) goto L48;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "registerReceiver ACTION_SCO_AUDIO_STATE_UPDATED failed: " + r122.getMessage());
            r121 = Boolean.FALSE;
        L48:
            boolean r123 = ((Boolean) r121).booleanValue();
            this.f395477g = r123;
            if (r123 == true) goto L51;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: register receiver failed");
            boolean r124 = false;
        L53:
            if (r124 == true) goto L56;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (register receiver failed)");
            return Boxing.boxBoolean(false);
        L56:
            r106 = SystemClock.elapsedRealtime();
            r100.L$0 = r107;
            r100.J$0 = r106;
            r100.label = 1;
            r111 = e(this, r107, false, r100);
            if (r111 != r102) goto L59;
            return r102;
        L51:
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: receiver registered");
            this.f395476f = r119;
        L42:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L52:
            r124 = true;
        L82:
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (appContext null)");
            return Boxing.boxBoolean(false);
        L7:
            r100 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1(this, r110);
            goto L8
        }

        public final void f(AudioManager r100) {
            if (r100 != null) goto L6;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: stopNow ignored (AudioManager null)");
            return;
        L6:
            this.f395473c = true;
            CompletableDeferred<Boolean> r101 = this.f395478h;
            if (r101 != null) goto L9;
        L11:
            this.f395478h = null;
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNow begin currentMode=" + r100.getMode() + " prevMode=" + this.f395475e);
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
            r100.stopBluetoothSco();     // Catch: Throwable -> L14
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L33:
            r100.setBluetoothScoOn(false);     // Catch: Throwable -> L19
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Integer r103 = this.f395475e;
            this.f395475e = null;
            if (r103 == null) goto L25;
            r100.setMode(r103.intValue());     // Catch: Throwable -> L29
        L27:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        L31:
            FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNow end restoredMode=" + r100.getMode());
            this.f395472b = false;
            this.f395473c = false;
            return;
        L25:
            if (r100.getMode() != 3) goto L27;
            r100.setMode(0);     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L19:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L14:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L33
        L9:
            if (r101.isCompleted() == true) goto L11;
            r101.complete(Boolean.FALSE);
            goto L11
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r100, VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
            if (r102 != 1) goto L12;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L12:
            if (r102 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r102 == 3) goto L40;
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }

        public static final Object e(BluetoothScoController r110, AudioManager r111, boolean r112, Continuation<? super Boolean> r113) {
            BluetoothScoController r100 = r110;
            if ((r113 instanceof VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1) == false) goto L7;
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1 r101 = (VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1) r113;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L16;
            if (r105 != 1) goto L15;
            r100 = (BluetoothScoController) r101.L$0;
            ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L40
        L38:
            boolean r106 = ((Boolean) r103).booleanValue();     // Catch: Throwable -> L40
            r100.f395479i = 0;
            r100.f395478h = null;
        L44:
            return Boxing.boxBoolean(r106);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r103);
            CompletableDeferred<Boolean> r107 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            r100.f395478h = r107;
            r100.f395479i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L30
            if (r112 == true) goto L21;
        L24:
            FLogger r109 = FLogger.f375446a;     // Catch: Throwable -> L30
            StringBuilder r114 = new StringBuilder("sco: startBluetoothSco begin useCommunicationMode=");     // Catch: Throwable -> L30
            if (r112 == false) goto L27;
            boolean r115 = true;
        L28:
            r114.append(r115);     // Catch: Throwable -> L30
            r114.append(" prevMode=");     // Catch: Throwable -> L30
            r114.append(r100.f395475e);     // Catch: Throwable -> L30
            r114.append(" currentMode=");     // Catch: Throwable -> L30
            r114.append(r111.getMode());     // Catch: Throwable -> L30
            r109.i("VoicePrintEnrollRecordingsMgr", r114.toString());     // Catch: Throwable -> L30
            r111.startBluetoothSco();     // Catch: Throwable -> L30
            r111.setBluetoothScoOn(true);     // Catch: Throwable -> L30
            Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
        L32:
            Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L40
            if (r117 == null) goto L35;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: startBluetoothSco threw " + r117.getMessage());     // Catch: Throwable -> L40
        L35:
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$4 r118 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$4(r107, null);     // Catch: Throwable -> L40
            r101.L$0 = r100;     // Catch: Throwable -> L40
            r101.label = 1;     // Catch: Throwable -> L40
            r103 = TimeoutKt.b(2500, r118, r101);     // Catch: Throwable -> L40
            if (r103 != r104) goto L38;
            return r104;
        L27:
            r115 = false;
            goto L28
        L21:
            if (r100.f395475e != null) goto L23;
            r100.f395475e = Boxing.boxInt(r111.getMode());     // Catch: Throwable -> L30
        L23:
            r111.setMode(3);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L40
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "sco: wait connected failed: " + th.getMessage());     // Catch: Throwable -> L45
            r100.f395479i = 0;
            r100.f395478h = null;
            r106 = false;
        L45:
            th = move-exception;
            r100.f395479i = 0;
            r100.f395478h = null;
            throw th;
        L7:
            r101 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1(r113);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr$ScoPrecheck;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "AUDIO_MANAGER_NULL", "NOT_SUPPORTED_OFF_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScoPrecheck extends Enum<ScoPrecheck> {
        public static final ScoPrecheck AUDIO_MANAGER_NULL = null;
        public static final ScoPrecheck NOT_SUPPORTED_OFF_CALL = null;
        public static final ScoPrecheck OK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScoPrecheck[] f395483a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f395484b = null;

        public static EnumEntries<ScoPrecheck> getEntries() {
            return f395484b;
        }

        static {
            ScoPrecheck r100 = new ScoPrecheck("OK", 0);
            OK = r100;
            ScoPrecheck r101 = new ScoPrecheck("AUDIO_MANAGER_NULL", 1);
            AUDIO_MANAGER_NULL = r101;
            ScoPrecheck r102 = new ScoPrecheck("NOT_SUPPORTED_OFF_CALL", 2);
            NOT_SUPPORTED_OFF_CALL = r102;
            ScoPrecheck[] r103 = {r100, r101, r102};
            f395483a = r103;
            f395484b = EnumEntriesKt.enumEntries(r103);
        }

        public static ScoPrecheck[] values() {
            return (ScoPrecheck[]) f395483a.clone();
        }

        public static ScoPrecheck valueOf(String r100) {
            return (ScoPrecheck) r27.a.a(ScoPrecheck.class, r100);
        }

        public ScoPrecheck(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void c() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())), null, null, new VoicePrintEnrollRecordingsMgr$stop$1(this, null), 3, null);
    }

    public final Context getContext() {
        return this.f395460a;
    }

    public static void a(AudioRecord r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    public final Object b(Continuation<? super Unit> r210) {
        if ((r210 instanceof VoicePrintEnrollRecordingsMgr$startRecording$1) == false) goto L7;
        VoicePrintEnrollRecordingsMgr$startRecording$1 r100 = (VoicePrintEnrollRecordingsMgr$startRecording$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L20;
        if (r104 == 3) goto L19;
        if (r104 == 4) goto L18;
        if (r104 != 5) goto L17;
        ResultKt.throwOnFailure(r102);
    L103:
        this.f395467h = this.f395466g.submit(new b(this));
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r105 = r100.I$0;
        ResultKt.throwOnFailure(r102);
    L100:
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r106 = this.f395461b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r107 = new com.obric.audio.enroll.recorder.a(r105, RecordState.START);
        r100.label = 5;
        if (r106.emit(r107, r100) != r103) goto L103;
        return r103;
    L19:
        r105 = r100.I$2;
        int r108 = r100.I$1;
        int r109 = r100.I$0;
        ResultKt.throwOnFailure(r102);
    L82:
        boolean r110 = ((Boolean) r102).booleanValue();
        FLogger r111 = FLogger.f375446a;
        r111.i("VoicePrintEnrollRecordingsMgr", "startRecording: startAndWaitConnected=" + r110);
        if (r110 == true) goto L86;
        r111.e("VoicePrintEnrollRecordingsMgr", "startRecording: startAndWaitConnected=false, report BluetoothScoNotSupported");
        this.f395462c = false;
        this.f395461b.reportEvent(d.f533212a);
        return Unit.INSTANCE;
    L86:
        int r112 = r108;
        int r113 = r109;
    L88:
        AudioRecord r114 = new AudioRecord(6, 16000, r113, r112, this.f395464e);
        this.f395463d = r114;
        if (r114.getState() == 1) goto L97;
        FLogger.f375446a.e("VoicePrintEnrollRecordingsMgr", "startTrainingRecording: AudioRecord initialize failed");
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L93
        a(r114);     // Catch: Throwable -> L93
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L93
    L95:
        this.f395463d = null;
        this.f395462c = false;
        this.f395470k.c();
        return Unit.INSTANCE;
    L93:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L95
    L97:
        this.f395468i = false;
        Job r117 = BuildersKt.launch$default(this.f395469j, null, null, new VoicePrintEnrollRecordingsMgr$startRecording$7(this, null), 3, null);
        r100.I$0 = r105;
        r100.label = 4;
        if (r117.join(r100) != r103) goto L100;
        return r103;
    L20:
        int r118 = r100.I$1;
        int r119 = r100.I$0;
        ResultKt.throwOnFailure(r102);
        r109 = r119;
        int r120 = r118;
    L105:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L53
        Future<?> r122 = this.f395467h;     // Catch: Throwable -> L53
        if (r122 == null) goto L50;
        Boolean r123 = Boxing.boxBoolean(r122.cancel(true));     // Catch: Throwable -> L53
    L51:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L53
    L56:
        if (Result.m9456isSuccessimpl(r124) == false) goto L59;
        Boolean r125 = (Boolean) r124;
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "startRecording: cancel recordingJob");
    L59:
        if (Result.m9452exceptionOrNullimpl(r124) == null) goto L61;
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "startRecording: cancel recordingJob failed");
    L61:
        this.f395462c = true;
        int r126 = this.f395461b.getEnrollIndex().getValue().intValue();
        FLogger r127 = FLogger.f375446a;
        r127.i("VoicePrintEnrollRecordingsMgr", "startRecording: index=" + r126 + " enrollDeviceType=" + this.f395461b.getEnrollDeviceType());
        if (this.f395461b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.THIRD_PARTY_BT) goto L87;
        AudioManager r128 = this.f395470k.b();
        if (r128 != null) goto L67;
        r127.e("VoicePrintEnrollRecordingsMgr", "sco: shouldStartSco false (AudioManager null)");
        ScoPrecheck r129 = ScoPrecheck.AUDIO_MANAGER_NULL;
    L70:
        r127.i("VoicePrintEnrollRecordingsMgr", "startRecording: scoPrecheck=" + r129);
        if (r129 == ScoPrecheck.OK) goto L78;
        this.f395462c = false;
        EnrollViewModel r130 = this.f395461b;
        if (r129 != ScoPrecheck.NOT_SUPPORTED_OFF_CALL) goto L75;
        e r131 = d.f533212a;
    L76:
        r130.reportEvent(r131);
        return Unit.INSTANCE;
    L75:
        r131 = qia.c.f533211a;
        goto L76
    L78:
        BluetoothScoController r132 = this.f395470k;
        r100.I$0 = r109;
        r100.I$1 = r120;
        r100.I$2 = r126;
        r100.label = 3;
        Object r133 = r132.d(r100);
        if (r133 != r103) goto L81;
        return r103;
    L81:
        r108 = r120;
        r105 = r126;
        r102 = r133;
        goto L82
    L67:
        if (r128.isBluetoothScoAvailableOffCall() == true) goto L69;
        r127.i("VoicePrintEnrollRecordingsMgr", "sco: shouldStartSco false (isBluetoothScoAvailableOffCall=false)");
        r129 = ScoPrecheck.NOT_SUPPORTED_OFF_CALL;
        goto L70
    L69:
        r129 = ScoPrecheck.OK;
        goto L70
    L87:
        r112 = r120;
        r113 = r109;
        r105 = r126;
        goto L88
    L50:
        r123 = null;
    L53:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L21:
        ResultKt.throwOnFailure(r102);
    L32:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r102);
        if (this.f395462c == false) goto L27;
        return Unit.INSTANCE;
    L27:
        if (this.f395461b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L34;
        this.f395462c = true;
        this.f395468i = false;
        int r135 = this.f395461b.getEnrollIndex().getValue().intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r136 = this.f395461b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r137 = new com.obric.audio.enroll.recorder.a(r135, RecordState.START);
        r100.label = 1;
        if (r136.emit(r137, r100) != r103) goto L32;
        return r103;
    L34:
        if (this.f395461b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT) goto L36;
        int r138 = 12;
    L37:
        if (r138 != 12) goto L39;
        int r139 = 2;
    L40:
        int r140 = AudioRecord.getMinBufferSize(16000, r138, 2);
        this.f395465f = r139;
        this.f395464e = ((r139 * TECameraUtils.CAPTURE_NORMAL) * 16) / 8;
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "startRecording: recorderChannelCount = " + r139 + " minBufferSize = " + r140 + " mTrainingBufferSize = " + this.f395464e);
        if (this.f395464e >= r140) goto L43;
        this.f395464e = r140;
    L43:
        Job r141 = BuildersKt.launch$default(this.f395469j, null, null, new VoicePrintEnrollRecordingsMgr$startRecording$2(this, null), 3, null);
        r100.I$0 = r138;
        r100.I$1 = 2;
        r100.label = 2;
        if (r141.join(r100) != r103) goto L46;
        return r103;
    L46:
        r109 = r138;
        r120 = 2;
        goto L105
    L39:
        r139 = 1;
        goto L40
    L36:
        r138 = 16;
    L7:
        r100 = new VoicePrintEnrollRecordingsMgr$startRecording$1(this, r210);
        goto L8
    }

    public final Object d(Continuation<? super Unit> r110) {
        if ((r110 instanceof VoicePrintEnrollRecordingsMgr$stopRecording$1) == false) goto L7;
        VoicePrintEnrollRecordingsMgr$stopRecording$1 r100 = (VoicePrintEnrollRecordingsMgr$stopRecording$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L35:
        Future<?> r112 = this.f395467h;
        if (r112 == null) goto L38;
        Boxing.boxBoolean(r112.cancel(true));
    L38:
        this.f395462c = false;
        this.f395470k.c();
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
    L32:
        int r113 = this.f395461b.getEnrollIndex().getValue().intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r104 = this.f395461b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r105 = new com.obric.audio.enroll.recorder.a(r113, RecordState.STOP);
        r100.label = 3;
        if (r104.emit(r105, r100) != r102) goto L35;
        return r102;
    L17:
        ResultKt.throwOnFailure(r111);
    L27:
        this.f395462c = false;
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "stopRecording..." + this.f395462c);
        if (this.f395462c == true) goto L23;
        return Unit.INSTANCE;
    L23:
        if (this.f395461b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L29;
        this.f395468i = true;
        int r114 = this.f395461b.getEnrollIndex().getValue().intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r106 = this.f395461b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r107 = new com.obric.audio.enroll.recorder.a(r114, RecordState.STOP);
        r100.label = 1;
        if (r106.emit(r107, r100) != r102) goto L27;
        return r102;
    L29:
        this.f395468i = true;
        Job r115 = BuildersKt.launch$default(this.f395469j, null, null, new VoicePrintEnrollRecordingsMgr$stopRecording$2(this, null), 3, null);
        r100.label = 2;
        if (r115.join(r100) != r102) goto L32;
        return r102;
    L7:
        r100 = new VoicePrintEnrollRecordingsMgr$stopRecording$1(this, r110);
        goto L8
    }

    public VoicePrintEnrollRecordingsMgr(Context r100, EnrollViewModel r101) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f395460a = r100;
        this.f395461b = r101;
        this.f395465f = 1;
        this.f395466g = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoicePrintEnrollRecordingsMgr"));
        this.f395469j = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f395470k = new BluetoothScoController(this);
    }
}
