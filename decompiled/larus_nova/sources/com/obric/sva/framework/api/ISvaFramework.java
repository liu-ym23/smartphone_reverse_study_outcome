package com.obric.sva.framework.api;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.obric.sva.framework.wrapper.ActivityTaskManagerWrapper;
import com.obric.sva.framework.wrapper.AudioManagerWrapper;
import com.obric.sva.framework.wrapper.IVoiceInteractionManagerServiceWrapper;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0016H&J*\u0010\u0017\u001a\u00020\b2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J0\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\"\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u0012\u0010,\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0003H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000201H&J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000201H&J\b\u00108\u001a\u000201H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&¨\u0006:"}, d2 = {"Lcom/obric/sva/framework/api/ISvaFramework;", "", "start", "", "setInternalCapturePresetExt", "Landroid/media/AudioAttributes$Builder;", "builder", "preset", "", "getInitialApplication", "Landroid/content/Context;", "shareAudioHistoryExt", "audioRecord", "Landroid/media/AudioRecord;", "pkg", "", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "", "getActivityTaskManager", "Lcom/obric/sva/framework/wrapper/ActivityTaskManagerWrapper;", PerfLog.PARAM_KEY_CONTEXT_ID, "IVoiceInteractionManagerService_AsInterface", "Lcom/obric/sva/framework/wrapper/IVoiceInteractionManagerServiceWrapper;", "listModulesAsOriginator", IPerformanceManager.Params.modules, "Ljava/util/ArrayList;", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$ModulePropertiesWrapper;", "Lkotlin/collections/ArrayList;", "originatorIdentity", "Lcom/obric/sva/framework/wrapper/IdentityWrapper;", "attachModuleAsOriginator", "Lcom/obric/sva/framework/wrapper/SoundTriggerModuleWrapper;", "moduleId", "listener", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$StatusListenerWrapper;", "handler", "Landroid/os/Handler;", "setAudioServerStateCallback", "audioManager", "Landroid/media/AudioManager;", "executor", "Ljava/util/concurrent/Executor;", "stateCallback", "Lcom/obric/sva/framework/wrapper/AudioManagerWrapper$AudioServerStateCallbackWrapper;", "clearAudioServerStateCallback", "powerUpScreen", "packageName", "resetPowerUpMode", "powerDown", "", "startPowerUpTimer", "stopPowerUpTimer", "resetPowerUpAsync", "powerOff", "setPowerUpState", "state", "getPowerUpState", "setPowerUpHandler", "api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ISvaFramework {
    IVoiceInteractionManagerServiceWrapper IVoiceInteractionManagerService_AsInterface();

    SoundTriggerModuleWrapper attachModuleAsOriginator(int r100, SoundTriggerWrapper.StatusListenerWrapper r101, Handler r102, IdentityWrapper r103);

    void clearAudioServerStateCallback(AudioManager r100);

    ActivityTaskManagerWrapper getActivityTaskManager(Context r100);

    Context getInitialApplication();

    boolean getPowerUpState();

    int listModulesAsOriginator(ArrayList<SoundTriggerWrapper.ModulePropertiesWrapper> r100, IdentityWrapper r101);

    void powerUpScreen(Context r100, String r101);

    void resetPowerUpAsync(boolean r100);

    void resetPowerUpMode(boolean r100);

    void setAudioServerStateCallback(AudioManager r100, Executor r101, AudioManagerWrapper.AudioServerStateCallbackWrapper r102);

    AudioAttributes.Builder setInternalCapturePresetExt(AudioAttributes.Builder r100, int r101);

    void setPowerUpHandler(Handler r100);

    void setPowerUpState(boolean r100);

    void shareAudioHistoryExt(AudioRecord r100, String r101, long r102);

    void start();

    void startPowerUpTimer();

    void stopPowerUpTimer();
}
