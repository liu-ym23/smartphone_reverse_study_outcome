package com.obric.sva.sdk.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAecContextParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.obric.assistant.common.spi.IObricSamiService;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0005\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010\u000f\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/sdk/audio/AecModel;", "", "<init>", "()V", "audioPlayConfig", "com/obric/sva/sdk/audio/AecModel$audioPlayConfig$1", "Lcom/obric/sva/sdk/audio/AecModel$audioPlayConfig$1;", "audioRecordConfig", "com/obric/sva/sdk/audio/AecModel$audioRecordConfig$1", "Lcom/obric/sva/sdk/audio/AecModel$audioRecordConfig$1;", "samiCore", "Lcom/mammon/audiosdk/SAMICore;", "TAG", "", "lock", MapMonitorConst.EVENT_DESTROY, "", "hasInit", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "aecRootPath", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "processAndGet", "", "data", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantAudioData;", "initSamiCoreLocked", BasicTestActionHandler.TEST_ACTION_RESET, "isModelInit", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AecModel {
    public static final String AEC_MODEL_ASSET = "aec_p_micro5_bin_20k_260901_multich_v4.0.model";
    public static final Companion Companion = null;
    private final String TAG;
    private String aecRootPath;
    private final AecModel$audioPlayConfig$1 audioPlayConfig;
    private final AecModel$audioRecordConfig$1 audioRecordConfig;
    private volatile boolean destroy;
    private volatile Handler handler;
    private volatile HandlerThread handlerThread;
    private volatile boolean hasInit;
    private final Object lock;
    private final SAMICore samiCore;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/audio/AecModel$Companion;", "", "<init>", "()V", "AEC_MODEL_ASSET", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(AecModel r100) {
        destroy$lambda$5(r100);
    }

    private final boolean initSamiCoreLocked() {
        SAMICoreVoiceAssistantAecContextParameter r100 = new SAMICoreVoiceAssistantAecContextParameter();
        boolean r101 = false;
        LogUtils.d(this.TAG, "AEC initSamiCore model path: " + this.aecRootPath, new Object[0]);
        r100.modelPath = this.aecRootPath;
        r100.refSampleRate = this.audioPlayConfig.getSampleRate();
        r100.refNumberChannel = 1;
        r100.srcSampleRate = this.audioRecordConfig.getSampleRate();
        r100.srcNumberChannel = 1;
        r100.enableFluteEngine = 0;
        this.samiCore.setEnableSyncInterface(true);
        int r102 = this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_RealtimeCall_Aec, r100);
        LogUtils.i(this.TAG, "AEC initSamiCore ret: " + r102, new Object[0]);
        if (r102 != 0) goto L5;
        r101 = true;
    L5:
        this.hasInit = r101;
        return r101;
    }

    public final void destroy() {
        Object r100 = this.lock;
        monitor-enter(r100);
        LogUtils.i(this.TAG, "AEC destroy SamiCore", new Object[0]);     // Catch: Throwable -> L21
        this.destroy = true;     // Catch: Throwable -> L21
        this.hasInit = false;     // Catch: Throwable -> L21
        Handler r101 = this.handler;     // Catch: Throwable -> L21
        HandlerThread r102 = this.handlerThread;     // Catch: Throwable -> L21
        Boolean r103 = null;
        this.handler = null;     // Catch: Throwable -> L21
        this.handlerThread = null;     // Catch: Throwable -> L21
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r100);
        if (r101 == null) goto L28;
        r101.post(new a(this));
    L26:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        if (r102 == null) goto L16;
        r103 = Boolean.valueOf(r102.quitSafely());     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L28:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L10
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(this.samiCore.SAMICoreDestroyHandle()));     // Catch: Throwable -> L10
    L12:
        Result.m9448boximpl(r108);
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    public final void reset() {
        LogUtils.i(this.TAG, "AEC reset SamiCore", new Object[0]);
        IObricSamiService r100 = (IObricSamiService) ServiceManager.get().getService(IObricSamiService.class);
        if (r100 == null) goto L6;
        r100.d(this.samiCore);
        return;
    }

    public AecModel() {
        this.audioPlayConfig = new AecModel$audioPlayConfig$1();
        this.audioRecordConfig = new AecModel$audioRecordConfig$1();
        this.samiCore = new SAMICore();
        this.TAG = "SVA-AecModel";
        this.lock = new Object();
        this.aecRootPath = "";
    }

    public final boolean isModelInit() {
        return this.hasInit;
    }

    private static final void destroy$lambda$5(AecModel r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Integer.valueOf(r100.samiCore.SAMICoreDestroyHandle()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = this.lock;
        monitor-enter(r101);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInit == false) goto L9;
        LogUtils.i(this.TAG, "[init] return", new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r101);
        return;
    L9:
        this.destroy = false;     // Catch: Throwable -> L27
        this.aecRootPath = r100.getFilesDir().getAbsolutePath() + File.separator + AEC_MODEL_ASSET;     // Catch: Throwable -> L27
        HandlerThread r102 = this.handlerThread;     // Catch: Throwable -> L27
        if (r102 != null) goto L12;
    L14:
        r102 = null;
    L15:
        if (r102 != null) goto L17;
        r102 = new PthreadHandlerThreadV2("background_aec");     // Catch: Throwable -> L27
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L27
        this.handlerThread = r102;     // Catch: Throwable -> L27
    L17:
        this.handler = new Handler(r102.getLooper());     // Catch: Throwable -> L27
        if (initSamiCoreLocked() == false) goto L30;
    L24:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r101);
        return;
    L30:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        Result.m9449constructorimpl(Boolean.valueOf(r102.quitSafely()));     // Catch: Throwable -> L21
    L23:
        this.handlerThread = null;     // Catch: Throwable -> L27
        this.handler = null;     // Catch: Throwable -> L27
        goto L24
    L21:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L27
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L23
    L12:
        if (ThreadMethodProxy.isAlive(r102) == false) goto L14;
        goto L14
    }

    public final byte[] processAndGet(SAMICoreVoiceAssistantAudioData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.destroy == false) goto L5;
    L23:
        return null;
    L5:
        if (this.hasInit == false) goto L23;
        SAMICoreBlock r101 = new SAMICoreBlock();
        r101.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        boolean r102 = true;
        r101.audioData = new SAMICoreVoiceAssistantAudioData[]{r100};
        r101.numberAudioData = 1;
        SAMICoreBlock r103 = new SAMICoreBlock();
        int r104 = this.samiCore.SAMICoreProcess(r101, r103);
        if (r104 == 0) goto L14;
        if (r104 == 150009) goto L14;
        LogUtils.i(this.TAG, "processAndGet fail ret=" + r104, new Object[0]);
        return null;
    L14:
        if (r103.dataType != SAMICoreDataType.SAMICoreDataType_AudioBin) goto L23;
        Object[] r105 = r103.audioData;
        if (r105 == null) goto L23;
        Object r106 = r105[0];
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.mammon.audiosdk.structures.SAMICoreAudioBin");
        SAMICoreAudioBin r107 = (SAMICoreAudioBin) r106;
        String r108 = this.TAG;
        StringBuilder r109 = new StringBuilder("processAndGet success, null data? ");
        if (r107.audioData == null) goto L21;
        r102 = false;
    L21:
        r109.append(r102);
        r109.append(", data size: ");
        r109.append(r107.audioData.length);
        LogUtils.i(r108, r109.toString(), new Object[0]);
        return r107.audioData;
    }
}
