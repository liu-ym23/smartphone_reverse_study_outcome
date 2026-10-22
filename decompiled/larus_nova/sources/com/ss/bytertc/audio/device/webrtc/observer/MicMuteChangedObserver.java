package com.ss.bytertc.audio.device.webrtc.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class MicMuteChangedObserver {
    private static final String TAG = "MicMuteChangedObserver";
    private MicMuteBroadCastReceiver mMicMuteBroadCastReceiver;
    private OnMicMuteChangedListener mOnMicMuteChangedListener;

    /* JADX INFO: renamed from: com.ss.bytertc.audio.device.webrtc.observer.MicMuteChangedObserver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class MicMuteBroadCastReceiver extends BroadcastReceiver {
        final /* synthetic */ MicMuteChangedObserver this$0;

        private MicMuteBroadCastReceiver(MicMuteChangedObserver r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ MicMuteBroadCastReceiver(MicMuteChangedObserver r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            MicMuteChangedObserver r102 = this.this$0;
            if (r100 == null) goto L19;
            if (r101 == null) goto L20;
            if (r102 != null) goto L7;
            return;
        L7:
            if (r101.getAction() != "android.media.action.MICROPHONE_MUTE_CHANGED") goto L22;
            AudioManager r103 = (AudioManager) r100.getSystemService("audio");     // Catch: Exception -> L14
            if (r103 != null) goto L11;
            return;
        L11:
            if (MicMuteChangedObserver.access$100(r102) == null) goto L24;
            MicMuteChangedObserver.access$100(r102).onMicMuteChanged(r103.isMicrophoneMute());     // Catch: Exception -> L14
            return;
        L24:
            return;
        L14:
            e = move-exception;
            e.getMessage();
            return;
        L22:
            return;
        L20:
            return;
        }
    }

    public interface OnMicMuteChangedListener {
        void onMicMuteChanged(boolean r100);
    }

    private void registerReceiver() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L5;
        return;
    L5:
        MicMuteBroadCastReceiver r101 = new MicMuteBroadCastReceiver(this, null);
        this.mMicMuteBroadCastReceiver = r101;
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, new IntentFilter("android.media.action.MICROPHONE_MUTE_CHANGED"));
    }

    private void unregisterReceiver() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L12;
        return;
    L12:
        MicMuteBroadCastReceiver r101 = this.mMicMuteBroadCastReceiver;     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Exception -> L9
        this.mMicMuteBroadCastReceiver = null;     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.getMessage();
    }

    public void release() {
        unregisterReceiver();
        this.mOnMicMuteChangedListener = null;
    }

    public MicMuteChangedObserver(OnMicMuteChangedListener r100) {
        this.mOnMicMuteChangedListener = r100;
        registerReceiver();
    }

    public static /* synthetic */ OnMicMuteChangedListener access$100(MicMuteChangedObserver r100) {
        return r100.mOnMicMuteChangedListener;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_MicMuteChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
