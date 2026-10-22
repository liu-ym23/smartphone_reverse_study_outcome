package com.enroll.audio.enroll.vm;

import android.content.Context;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dtf.face.config.IConstValues;
import com.enroll.audio.enroll.model.EnrollState;
import com.enroll.audio.enroll.recorder.VoicePrintEnrollFileMgr;
import com.enroll.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.enroll.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1;
import com.enroll.audio.enroll.recorder.b;
import com.enroll.audio.enroll.ui.VoicePrintEnrollActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import jt7.e;
import jt7.f;
import jt7.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0095\u00012\u00020\u0001:\u0002\u0095\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010D\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?2\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u0012J\u0006\u0010G\u001a\u00020\u0012J\u0011\u0010\u008e\u0001\u001a\u00020\u00122\b\u0010\u008f\u0001\u001a\u00030\u0086\u0001J\u0010\u0010\u0090\u0001\u001a\u00020\u000b2\u0007\u0010\u0091\u0001\u001a\u00020PJ\u0007\u0010\u0092\u0001\u001a\u00020\u000bJ\u0010\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020PR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001a\u0010,\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001a\u0010.\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)R\u001a\u00101\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R \u00104\u001a\b\u0012\u0004\u0012\u00020\u000b05X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001a\u0010<\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR \u0010N\u001a\b\u0012\u0004\u0012\u00020P0OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR \u0010U\u001a\b\u0012\u0004\u0012\u00020P0OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010R\"\u0004\bW\u0010TR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0O¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020P0O¢\u0006\b\n\u0000\u001a\u0004\ba\u0010RR#\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020P0c0\\¢\u0006\b\n\u0000\u001a\u0004\be\u0010_R#\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020g0c0\\¢\u0006\b\n\u0000\u001a\u0004\bh\u0010_R \u0010i\u001a\b\u0012\u0004\u0012\u00020k0jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u00107\"\u0004\bm\u00109R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001a\u0010y\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR\u001a\u0010|\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010v\"\u0004\b~\u0010xR\u001c\u0010\u007f\u001a\u00020PX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010v\"\u0005\b\u0081\u0001\u0010xR\u001d\u0010\u0082\u0001\u001a\u00020PX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010v\"\u0005\b\u0084\u0001\u0010xR\u001a\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\\¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010_R \u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0096\u0001"}, d2 = {"Lcom/enroll/audio/enroll/vm/EnrollViewModel;", "Lcom/enroll/audio/enroll/vm/BaseViewModel;", "<init>", "()V", "enrollDeviceType", "Lcom/enroll/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;", "getEnrollDeviceType", "()Lcom/enroll/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;", "setEnrollDeviceType", "(Lcom/enroll/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;)V", "value", "", "enrollDeviceSn", "getEnrollDeviceSn", "()Ljava/lang/String;", "enrollDeviceName", "getEnrollDeviceName", "setEnrollDeviceInfo", "", "sn", "name", "fileManager", "Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollFileMgr;", "getFileManager", "()Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollFileMgr;", "setFileManager", "(Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollFileMgr;)V", "recordingManager", "Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;", "getRecordingManager", "()Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;", "setRecordingManager", "(Lcom/enroll/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;)V", "startFrom", "getStartFrom", "setStartFrom", "(Ljava/lang/String;)V", "isLeaveFromPrivacy", "", "()Z", "setLeaveFromPrivacy", "(Z)V", "isAlreadyEnroll", "setAlreadyEnroll", "isEnrollSuccess", "setEnrollSuccess", "voiceWakeupSwitch", "getVoiceWakeupSwitch", "setVoiceWakeupSwitch", "lockVoiceprintSwitch", "getLockVoiceprintSwitch", "setLockVoiceprintSwitch", "currentSettingItems", "", "getCurrentSettingItems", "()Ljava/util/List;", "setCurrentSettingItems", "(Ljava/util/List;)V", "isInterruptEnhancedVoiceEnroll", "setInterruptEnhancedVoiceEnroll", "isRequestingRecordPermission", "setRequestingRecordPermission", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "init", IConstValues.DEVICE_TYPE, "release", "stop", "eventBusContext", "Lkotlin/coroutines/CoroutineContext;", "eventBusScope", "Lkotlinx/coroutines/CoroutineScope;", "getEventBusScope", "()Lkotlinx/coroutines/CoroutineScope;", "enrollIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getEnrollIndex", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setEnrollIndex", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "stageingIndex", "getStageingIndex", "setStageingIndex", "enrollState", "Lcom/enroll/audio/enroll/model/EnrollState;", "getEnrollState", "recordingEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/enroll/audio/enroll/recorder/RecordToken;", "getRecordingEvent", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "asrState", "getAsrState", "audioData", "Lkotlin/Pair;", "", "getAudioData", "enrollProgress", "", "getEnrollProgress", "enrollSentences", "", "Lcom/enroll/audio/enroll/model/EnrollTeam;", "getEnrollSentences", "setEnrollSentences", "enrollSentence", "Lcom/enroll/audio/enroll/model/EnrollSentence;", "getEnrollSentence", "()Lcom/enroll/audio/enroll/model/EnrollSentence;", "setEnrollSentence", "(Lcom/enroll/audio/enroll/model/EnrollSentence;)V", "topGuideLine", "getTopGuideLine", "()I", "setTopGuideLine", "(I)V", "neckGuideLine", "getNeckGuideLine", "setNeckGuideLine", "footGuideLine", "getFootGuideLine", "setFootGuideLine", "leftBorderLine", "getLeftBorderLine", "setLeftBorderLine", "bottomGuideLine", "getBottomGuideLine", "setBottomGuideLine", "eventBus", "Lcom/enroll/audio/enroll/model/EnrollEvent;", "getEventBus", "combineAudio", "Lcom/enroll/audio/enroll/edit/CombineAudio;", "getCombineAudio", "()Lcom/enroll/audio/enroll/edit/CombineAudio;", "setCombineAudio", "(Lcom/enroll/audio/enroll/edit/CombineAudio;)V", "reportEvent", "event", "sentence", "index", "enterFrom", "getCurrentPageName", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollViewModel extends BaseViewModel {
    public static final String ASSISTANT_ONBOARDING = "obric_assistant_onboarding";
    public static final String ASSISTANT_SETTINGS = "obric_assistant_settings";
    public static final String CURRENT_SETTING_ITEMS = "current_setting_items";
    public static final a Companion = null;
    public static final String DORA_DEVICE_MANAGEMENT = "dora_device_management";
    public static final String DORA_ONBOARDING = "dora_onboarding";
    public static final String DOUBAO_GUIDE = "DoubaoGuide";
    public static final String FAILED_PAGE = "obric_record_voice_wakeup_failed";
    public static final String HAS_RECORD_PERMISSION = "hasRecordPermission";
    public static final String IS_VOICE_AUTHORIZATION_SWITCH_OPEN = "isVoiceAuthorizationSwitchOpen";
    public static final String OBRIC_DEVICE_SETTINGS = "obric_device_settings";
    public static final String OS_ONBOARDING = "obric_os_onboarding";
    public static final String PAGE_1 = "obric_record_voice_wakeup_1";
    public static final String PAGE_2 = "obric_record_voice_wakeup_2";
    public static final String PAGE_3 = "obric_record_voice_wakeup_3";
    public static final String PAGE_4 = "obric_record_voice_wakeup_4";
    public static final String PAGE_5 = "obric_record_voice_wakeup_5";
    public static final String SET_UP_WIZARD = "SetUpWizard";
    public static final String SUCCESS_PAGE = "obric_onboarding_voice_wakeup_complete";
    public static final String SYSTEM_SETTINGS = "SystemSetting";
    public static final String TAG = "EnrollViewModel";
    public static final String TIME_OUT_PAGE = "obric_record_voice_wakeup_timeout";
    public static final String VOICE_AUTHORIZATION = "VoiceAuthorization";
    public static final String VOICE_MANAGER = "VoiceManager";
    public static final String VOICE_WAKEUP = "VoiceWakeup";
    private final z0<Integer> asrState;
    private final MutableSharedFlow<Pair<byte[], Integer>> audioData;
    private int bottomGuideLine;
    private ht7.a combineAudio;
    private Context context;
    private List<String> currentSettingItems;
    private String enrollDeviceName;
    private String enrollDeviceSn;
    private VoicePrintEnrollActivity.Companion.EnrollDeviceType enrollDeviceType;
    private z0<Integer> enrollIndex;
    private final MutableSharedFlow<Pair<Integer, int[]>> enrollProgress;
    private f enrollSentence;
    private List<g> enrollSentences;
    private final z0<EnrollState> enrollState;
    private final MutableSharedFlow<e> eventBus;
    private final CoroutineContext eventBusContext;
    private final CoroutineScope eventBusScope;
    public VoicePrintEnrollFileMgr fileManager;
    private int footGuideLine;
    private boolean isAlreadyEnroll;
    private boolean isEnrollSuccess;
    private boolean isInterruptEnhancedVoiceEnroll;
    private boolean isLeaveFromPrivacy;
    private boolean isRequestingRecordPermission;
    private int leftBorderLine;
    private boolean lockVoiceprintSwitch;
    private int neckGuideLine;
    private final MutableSharedFlow<b> recordingEvent;
    public VoicePrintEnrollRecordingsMgr recordingManager;
    private z0<Integer> stageingIndex;
    public String startFrom;
    private int topGuideLine;
    private boolean voiceWakeupSwitch;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.enroll.audio.enroll.vm.EnrollViewModel$reportEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.enroll.audio.enroll.vm.EnrollViewModel$reportEvent$1", f = "EnrollViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $event;
        int label;
        final /* synthetic */ EnrollViewModel this$0;

        public AnonymousClass1(EnrollViewModel r100, e r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$event = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$event, r101);
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
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow<e> r103 = this.this$0.getEventBus();
            e r104 = this.$event;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public final void release() {
        this.context = null;
        getFileManager().f273742a = null;
        VoicePrintEnrollRecordingsMgr r100 = getRecordingManager();
        r100.c();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Future<?> r102 = r100.f273754g;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        Boolean r103 = Boolean.valueOf(r102.cancel(true));     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L52:
        Result.m9449constructorimpl(r100.f273753f.shutdownNow());     // Catch: Throwable -> L13
    L15:
        VoicePrintEnrollRecordingsMgr.BluetoothScoController r104 = r100.f273757j;
        r104.getClass();
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: release");
        Job r105 = r104.f273758a;
        if (r105 == null) goto L18;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L18:
        r104.f273758a = null;
        if (r104.f273764g == false) goto L44;
        Context r106 = r104.f273767j.getContext();
        if (r106 == null) goto L44;
        Context r107 = r106.getApplicationContext();
        if (r107 == null) goto L44;
        VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 r108 = r104.f273763f;
        if (r108 == null) goto L44;
        r104.f273764g = false;
        r104.f273763f = null;
        ReceiverRegisterLancet.loge(r108, false);     // Catch: Throwable -> L41
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L46;
        r107.unregisterReceiver(r108);     // Catch: Throwable -> L41
    L39:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        FLogger.f375446a.i("VoicePrintEnrollRecordingsMgr", "sco: receiver unregistered");
        goto L44
    L46:
    L36:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r108.toString());     // Catch: Throwable -> L41
        e.printStackTrace();     // Catch: Throwable -> L41
        goto L39
    L33:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r108, r107) == false) goto L39;
        r107.unregisterReceiver(r108);     // Catch: Exception -> L36 Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        r104.f(r104.b());
        r100.f273748a = null;
        return;
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    }

    public final VoicePrintEnrollFileMgr getFileManager() {
        VoicePrintEnrollFileMgr r100 = this.fileManager;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        return null;
    }

    public final VoicePrintEnrollRecordingsMgr getRecordingManager() {
        VoicePrintEnrollRecordingsMgr r100 = this.recordingManager;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("recordingManager");
        return null;
    }

    public final String getStartFrom() {
        String r100 = this.startFrom;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("startFrom");
        return null;
    }

    public EnrollViewModel() {
        this.enrollDeviceType = VoicePrintEnrollActivity.Companion.EnrollDeviceType.THIRD_PARTY_BT;
        this.enrollDeviceSn = "";
        this.enrollDeviceName = "";
        this.currentSettingItems = CollectionsKt.emptyList();
        ExecutorCoroutineDispatcher r100 = w1.a(1, "eventBusContext");
        this.eventBusContext = r100;
        this.eventBusScope = CoroutineScopeKt.CoroutineScope(r100.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.enrollIndex = j1.a(-1);
        this.stageingIndex = j1.a(-1);
        this.enrollState = j1.a(EnrollState.IDLE);
        BufferOverflow r101 = BufferOverflow.DROP_OLDEST;
        this.recordingEvent = SharedFlowKt.MutableSharedFlow$default(0, 8, r101, 1, null);
        this.asrState = j1.a(-1);
        this.audioData = SharedFlowKt.MutableSharedFlow$default(0, 32, r101, 1, null);
        this.enrollProgress = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.enrollSentences = new ArrayList();
        this.eventBus = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.combineAudio = new ht7.a();
    }

    public final String enterFrom() {
        if (Intrinsics.areEqual(getStartFrom(), "SetUpWizard") == false) goto L7;
        return "obric_os_onboarding";
    L7:
        if (Intrinsics.areEqual(getStartFrom(), "DoubaoGuide") == false) goto L11;
        return "obric_assistant_onboarding";
    L11:
        if (Intrinsics.areEqual(getStartFrom(), "SystemSetting") == false) goto L15;
        return "obric_device_settings";
    L15:
        if (Intrinsics.areEqual(getStartFrom(), "dora_onboarding") == false) goto L18;
        return "dora_onboarding";
    L18:
        if (Intrinsics.areEqual(getStartFrom(), "dora_device_management") == false) goto L20;
        return "dora_device_management";
    L20:
        return "obric_assistant_settings";
    }

    public final void stop() {
        getRecordingManager().c();
    }

    public final z0<Integer> getAsrState() {
        return this.asrState;
    }

    public final MutableSharedFlow<Pair<byte[], Integer>> getAudioData() {
        return this.audioData;
    }

    public final int getBottomGuideLine() {
        return this.bottomGuideLine;
    }

    public final ht7.a getCombineAudio() {
        return this.combineAudio;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<String> getCurrentSettingItems() {
        return this.currentSettingItems;
    }

    public final String getEnrollDeviceName() {
        return this.enrollDeviceName;
    }

    public final String getEnrollDeviceSn() {
        return this.enrollDeviceSn;
    }

    public final VoicePrintEnrollActivity.Companion.EnrollDeviceType getEnrollDeviceType() {
        return this.enrollDeviceType;
    }

    public final z0<Integer> getEnrollIndex() {
        return this.enrollIndex;
    }

    public final MutableSharedFlow<Pair<Integer, int[]>> getEnrollProgress() {
        return this.enrollProgress;
    }

    public final f getEnrollSentence() {
        return this.enrollSentence;
    }

    public final List<g> getEnrollSentences() {
        return this.enrollSentences;
    }

    public final z0<EnrollState> getEnrollState() {
        return this.enrollState;
    }

    public final MutableSharedFlow<e> getEventBus() {
        return this.eventBus;
    }

    public final CoroutineScope getEventBusScope() {
        return this.eventBusScope;
    }

    public final int getFootGuideLine() {
        return this.footGuideLine;
    }

    public final int getLeftBorderLine() {
        return this.leftBorderLine;
    }

    public final boolean getLockVoiceprintSwitch() {
        return this.lockVoiceprintSwitch;
    }

    public final int getNeckGuideLine() {
        return this.neckGuideLine;
    }

    public final MutableSharedFlow<b> getRecordingEvent() {
        return this.recordingEvent;
    }

    public final z0<Integer> getStageingIndex() {
        return this.stageingIndex;
    }

    public final int getTopGuideLine() {
        return this.topGuideLine;
    }

    public final boolean getVoiceWakeupSwitch() {
        return this.voiceWakeupSwitch;
    }

    public final boolean isAlreadyEnroll() {
        return this.isAlreadyEnroll;
    }

    public final boolean isEnrollSuccess() {
        return this.isEnrollSuccess;
    }

    public final boolean isInterruptEnhancedVoiceEnroll() {
        return this.isInterruptEnhancedVoiceEnroll;
    }

    public final boolean isLeaveFromPrivacy() {
        return this.isLeaveFromPrivacy;
    }

    public final boolean isRequestingRecordPermission() {
        return this.isRequestingRecordPermission;
    }

    public final String getCurrentPageName(int r100) {
        if (r100 != 1) goto L5;
        return "obric_record_voice_wakeup_1";
    L5:
        if (r100 != 2) goto L7;
        return "obric_record_voice_wakeup_2";
    L7:
        if (r100 != 3) goto L9;
        return "obric_record_voice_wakeup_3";
    L9:
        if (r100 != 4) goto L11;
        return "obric_record_voice_wakeup_4";
    L11:
        if (r100 == 5) goto L13;
        FLogger.f375446a.i("EnrollingFragment", "getCurrentPageName: unknown position " + r100);
        return "unknown page";
    L13:
        return "obric_record_voice_wakeup_5";
    }

    public final void reportEvent(e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        BuildersKt.launch$default(this.eventBusScope, null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    public final String sentence(int r100) {
        if (r100 >= 0) goto L4;
        return "unknown";
    L4:
        if (r100 >= this.enrollSentences.size()) goto L13;
        String r101 = ((g) ListProtector.get(this.enrollSentences, r100)).b();
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101;
    L13:
        return "unknown";
    }

    public final void setAlreadyEnroll(boolean r100) {
        this.isAlreadyEnroll = r100;
    }

    public final void setBottomGuideLine(int r100) {
        this.bottomGuideLine = r100;
    }

    public final void setCombineAudio(ht7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.combineAudio = r100;
    }

    public final void setContext(Context r100) {
        this.context = r100;
    }

    public final void setCurrentSettingItems(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentSettingItems = r100;
    }

    public final void setEnrollDeviceType(VoicePrintEnrollActivity.Companion.EnrollDeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enrollDeviceType = r100;
    }

    public final void setEnrollIndex(z0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enrollIndex = r100;
    }

    public final void setEnrollSentence(f r100) {
        this.enrollSentence = r100;
    }

    public final void setEnrollSentences(List<g> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enrollSentences = r100;
    }

    public final void setEnrollSuccess(boolean r100) {
        this.isEnrollSuccess = r100;
    }

    public final void setFileManager(VoicePrintEnrollFileMgr r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileManager = r100;
    }

    public final void setFootGuideLine(int r100) {
        this.footGuideLine = r100;
    }

    public final void setInterruptEnhancedVoiceEnroll(boolean r100) {
        this.isInterruptEnhancedVoiceEnroll = r100;
    }

    public final void setLeaveFromPrivacy(boolean r100) {
        this.isLeaveFromPrivacy = r100;
    }

    public final void setLeftBorderLine(int r100) {
        this.leftBorderLine = r100;
    }

    public final void setLockVoiceprintSwitch(boolean r100) {
        this.lockVoiceprintSwitch = r100;
    }

    public final void setNeckGuideLine(int r100) {
        this.neckGuideLine = r100;
    }

    public final void setRecordingManager(VoicePrintEnrollRecordingsMgr r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordingManager = r100;
    }

    public final void setRequestingRecordPermission(boolean r100) {
        this.isRequestingRecordPermission = r100;
    }

    public final void setStageingIndex(z0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stageingIndex = r100;
    }

    public final void setStartFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startFrom = r100;
    }

    public final void setTopGuideLine(int r100) {
        this.topGuideLine = r100;
    }

    public final void setVoiceWakeupSwitch(boolean r100) {
        this.voiceWakeupSwitch = r100;
    }

    public final void init(Context r100, VoicePrintEnrollActivity.Companion.EnrollDeviceType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        this.enrollDeviceType = r101;
        this.context = r100;
        setFileManager(new VoicePrintEnrollFileMgr(r100, this));
        setRecordingManager(new VoicePrintEnrollRecordingsMgr(r100, this));
    }

    public final void setEnrollDeviceInfo(String r100, String r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = StringsKt.trim(r100).toString();
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.enrollDeviceSn = r103;
        if (r101 == null) goto L12;
        r102 = StringsKt.trim(r101).toString();
    L12:
        if (r102 == null) goto L15;
        r104 = r102;
    L15:
        this.enrollDeviceName = r104;
        FLogger.f375446a.i("EnrollViewModel", "setEnrollDeviceInfo sn=" + this.enrollDeviceSn + " nameLen=" + this.enrollDeviceName.length());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
