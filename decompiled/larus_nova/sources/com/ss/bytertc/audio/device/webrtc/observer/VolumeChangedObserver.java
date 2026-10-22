package com.ss.bytertc.audio.device.webrtc.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class VolumeChangedObserver {
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static final int STREAM_BLUETOOTH_SCO = 6;
    private static final String TAG = "VolumeChangedObserver";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private VolumeBroadcastReceiver mVolumeBroadcastReceiver;
    private OnVolumeChangedListener onVolumeChangedListener;

    public interface OnVolumeChangedListener {
        void onVolumeChanged(int r100, int r101);
    }

    public class VolumeBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ VolumeChangedObserver this$0;

        public VolumeBroadcastReceiver(VolumeChangedObserver r100) {
            this.this$0 = r100;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            VolumeChangedObserver r102 = this.this$0;
            if (VolumeChangedObserver.access$000(r102) != null) goto L6;
            return;
        L6:
            if (VolumeChangedObserver.VOLUME_CHANGED_ACTION.equals(r101.getAction()) == false) goto L19;
            int r103 = r101.getIntExtra(VolumeChangedObserver.EXTRA_VOLUME_STREAM_TYPE, -1);     // Catch: Exception -> L14
            if (r103 == 3) goto L12;
            if (r103 == 0) goto L12;
            if (r103 == 6) goto L12;
            return;
        L12:
            int r104 = r101.getIntExtra(VolumeChangedObserver.EXTRA_VOLUME_STREAM_VALUE, -1);     // Catch: Exception -> L14
            VolumeChangedObserver.access$000(r102).onVolumeChanged(r103, r104);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            e.getMessage();
            return;
        }
    }

    private void unregisterReceiver() {
        Context r100 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L10 Exception -> L12
        VolumeBroadcastReceiver r101 = this.mVolumeBroadcastReceiver;     // Catch: Throwable -> L10 Exception -> L12
        if (r101 == null) goto L7;
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Throwable -> L10 Exception -> L12
        this.mVolumeBroadcastReceiver = null;     // Catch: Throwable -> L10 Exception -> L12
    L7:
        if (this.onVolumeChangedListener == null) goto L9;
    L8:
        this.onVolumeChangedListener = null;
    L9:
        this.mVolumeBroadcastReceiver = null;
        return;
    L12:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L10
        if (this.onVolumeChangedListener == null) goto L9;
    L10:
        th = move-exception;
        if (this.onVolumeChangedListener == null) goto L21;
        this.onVolumeChangedListener = null;
    L21:
        this.mVolumeBroadcastReceiver = null;
        throw th;
    }

    private void registerVolumeChangeAction() {
        Context r100 = ContextUtils.getApplicationContext();
        if (r100 != null) goto L5;
        return;
    L5:
        this.mVolumeBroadcastReceiver = new VolumeBroadcastReceiver(this);
        IntentFilter r101 = new IntentFilter();
        r101.addAction(VOLUME_CHANGED_ACTION);
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this.mVolumeBroadcastReceiver, r101);
    }

    public void release() {
        unregisterReceiver();
        this.onVolumeChangedListener = null;
    }

    public VolumeChangedObserver(OnVolumeChangedListener r100) {
        this.onVolumeChangedListener = r100;
        registerVolumeChangeAction();
    }

    public static /* synthetic */ OnVolumeChangedListener access$000(VolumeChangedObserver r100) {
        return r100.onVolumeChangedListener;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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
    public static Intent INVOKEVIRTUAL_com_ss_bytertc_audio_device_webrtc_observer_VolumeChangedObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
