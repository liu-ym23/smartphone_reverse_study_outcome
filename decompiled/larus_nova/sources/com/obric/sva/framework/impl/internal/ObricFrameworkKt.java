package com.obric.sva.framework.impl.internal;

import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.content.Context;
import android.hardware.soundtrigger.SoundTrigger;
import android.hardware.soundtrigger.SoundTriggerModule;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.permission.Identity;
import android.os.Build;
import android.os.Handler;
import android.os.ServiceManager;
import com.android.internal.app.IVoiceInteractionManagerService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.obric.sva.framework.log.AiagentLog;
import com.obric.sva.framework.wrapper.ActivityTaskManagerWrapper;
import com.obric.sva.framework.wrapper.AudioManagerWrapper;
import com.obric.sva.framework.wrapper.IVoiceInteractionManagerServiceWrapper;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J*\u0010\u0019\u001a\u00020\n2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\"\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0007J\u0012\u0010.\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/sva/framework/impl/internal/ObricFrameworkKt;", "", "<init>", "()V", "TAG", "", "setInternalCapturePresetExt", "Landroid/media/AudioAttributes$Builder;", "builder", "preset", "", "getInitialApplication", "Landroid/content/Context;", "shareAudioHistoryExt", "", "record", "Landroid/media/AudioRecord;", "pkg", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "", "getActivityTaskManager", "Lcom/obric/sva/framework/wrapper/ActivityTaskManagerWrapper;", PerfLog.PARAM_KEY_CONTEXT_ID, "IVoiceInteractionManagerService_AsInterface", "Lcom/obric/sva/framework/wrapper/IVoiceInteractionManagerServiceWrapper;", "listModulesAsOriginator", IPerformanceManager.Params.modules, "Ljava/util/ArrayList;", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$ModulePropertiesWrapper;", "Lkotlin/collections/ArrayList;", "originatorIdentity", "Lcom/obric/sva/framework/wrapper/IdentityWrapper;", "attachModuleAsOriginator", "Lcom/obric/sva/framework/wrapper/SoundTriggerModuleWrapper;", "moduleId", "listener", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$StatusListenerWrapper;", "handler", "Landroid/os/Handler;", "setAudioServerStateCallback", "audioManager", "Landroid/media/AudioManager;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Lcom/obric/sva/framework/wrapper/AudioManagerWrapper$AudioServerStateCallbackWrapper;", "clearAudioServerStateCallback", "impl_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricFrameworkKt {
    public static final ObricFrameworkKt INSTANCE = null;
    public static final String TAG = "ObricFrameworkKt";

    static {
        INSTANCE = new ObricFrameworkKt();
    }

    private ObricFrameworkKt() {
    }

    @JvmStatic
    public static final Context getInitialApplication() {
        AiagentLog.d(TAG, "getInitialApplication");
        return AppGlobals.getInitialApplication();
    }

    @JvmStatic
    public static final IVoiceInteractionManagerServiceWrapper IVoiceInteractionManagerService_AsInterface() {
        return new IVoiceInteractionManagerServiceWrapper(IVoiceInteractionManagerService.Stub.asInterface(ServiceManager.getService("voiceinteraction")));
    }

    @JvmStatic
    public static final void clearAudioServerStateCallback(AudioManager r100) {
        if (r100 == null) goto L5;
        r100.clearAudioServerStateCallback();
        return;
    }

    @JvmStatic
    public static final ActivityTaskManagerWrapper getActivityTaskManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r101 = r100.getSystemService("activity_task");
        if ((r101 instanceof ActivityTaskManager) == true) goto L7;
        return null;
    L7:
        return new ActivityTaskManagerWrapper((ActivityTaskManager) r101);
    L8:
        return null;
    }

    @JvmStatic
    public static final int listModulesAsOriginator(ArrayList<SoundTriggerWrapper.ModulePropertiesWrapper> r100, IdentityWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, IPerformanceManager.Params.modules);
        ArrayList r102 = new ArrayList(r100.size());
        if (r101 == null) goto L5;
        Identity r103 = r101.identity;
    L6:
        Intrinsics.checkNotNull(r103);
        int r104 = SoundTrigger.listModulesAsOriginator(r102, r103);
        Iterator r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r100.add(new SoundTriggerWrapper.ModulePropertiesWrapper((SoundTrigger.ModuleProperties) r105.next()));
        goto L8
    L10:
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final AudioAttributes.Builder setInternalCapturePresetExt(AudioAttributes.Builder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        AiagentLog.d(TAG, "setInternalCapturePresetExt " + r101);
        r100.setInternalCapturePreset(r101);
        return r100;
    }

    @JvmStatic
    public static final void setAudioServerStateCallback(AudioManager r100, Executor r101, AudioManagerWrapper.AudioServerStateCallbackWrapper r102) {
        Intrinsics.checkNotNullParameter(r101, "executor");
        Intrinsics.checkNotNullParameter(r102, "stateCallback");
        if (r100 == null) goto L6;
        r100.setAudioServerStateCallback(r101, r102.mAudioServerStateCallback);
        return;
    }

    @JvmStatic
    public static final void shareAudioHistoryExt(AudioRecord r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "record");
        Intrinsics.checkNotNullParameter(r101, "pkg");
        AiagentLog.d(TAG, "shareAudioHistoryExt " + r101 + " -> " + r102);
        r100.shareAudioHistory(r101, r102);
    }

    @JvmStatic
    public static final SoundTriggerModuleWrapper attachModuleAsOriginator(int r100, SoundTriggerWrapper.StatusListenerWrapper r101, Handler r102, IdentityWrapper r103) {
        if (r101 == null) goto L5;
        SoundTrigger.StatusListener r104 = r101.statusListener;
    L6:
        if (r104 == null) goto L23;
        if (r103 == null) goto L9;
        Identity r105 = r103.identity;
    L10:
        if (r105 == null) goto L25;
        if (r101 == null) goto L14;
        SoundTrigger.StatusListener r106 = r101.statusListener;
    L15:
        Intrinsics.checkNotNull(r106);
        if (r103 == null) goto L18;
        Identity r107 = r103.identity;
    L19:
        Intrinsics.checkNotNull(r107);
        SoundTriggerModule r108 = SoundTrigger.attachModuleAsOriginator(r100, r106, r102, r107);
        if (r108 != null) goto L22;
        return null;
    L22:
        return new SoundTriggerModuleWrapper(r108);
    L18:
        r107 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L25:
        return null;
    L9:
        r105 = null;
        goto L10
    L23:
        return null;
    L5:
        r104 = null;
        goto L6
    }
}
