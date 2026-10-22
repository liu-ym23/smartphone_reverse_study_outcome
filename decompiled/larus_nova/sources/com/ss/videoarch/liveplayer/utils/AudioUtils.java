package com.ss.videoarch.liveplayer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class AudioUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f459648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f459649b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f459650c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f459651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static OnVolumeChangeListener f459652e;

    public static class OnVolumeChangeListener extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AudioManager> f459653a;

        public OnVolumeChangeListener(AudioManager r100) {
            this.f459653a = new WeakReference(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
        L13:
            AudioUtils.access$002(-1);
            return;
        L4:
            if ("android.media.VOLUME_CHANGED_ACTION".equals(r101.getAction()) == true) goto L6;
            return;
        L6:
            if (r101.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) goto L8;
            return;
        L8:
            if (this.f459653a.get() == null) goto L19;
            int r102 = this.f459653a.get().getStreamVolume(3);     // Catch: Exception -> L13
            if (r102 < 0) goto L20;
            AudioUtils.access$002(r102);     // Catch: Exception -> L13
            return;
        L20:
            return;
        }
    }

    public AudioUtils() {
    }

    public static /* synthetic */ int access$002(int r100) {
        f459650c = r100;
        return r100;
    }

    public static int getCurrentMusicVolume(Context r100) {
        return getStreamVolume(r100, 3);
    }

    public static int getMusicMaxVolume(Context r100) {
        if (isServiceNull(r100) == false) goto L7;
        return -1;
    L7:
        if (f459649b >= 0) goto L10;
        f459649b = f459648a.getStreamMaxVolume(3);
    L10:
        return f459649b;
    }

    public static int getRingerMode(Context r100) {
        if (isServiceNull(r100) == false) goto L7;
        return -1;
    L7:
        return f459648a.getRingerMode();
    }

    public static double getVolume(Context r100) {
        return getVolumeInner(r100);
    }

    private static double getVolumeInner(Context r100) {
        if (isServiceNull(r100) == false) goto L14;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L14:
        if (f459650c >= 0) goto L8;
    L9:
        f459650c = getStreamVolume(r100, 3);     // Catch: Exception -> L13
    L10:
        return f459650c;
    L8:
        if (f459651d == true) goto L10;
    L16:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static boolean isMusicMuted(Context r100) {
        return isStreamMuted(r100, 3);
    }

    public static boolean isOnExternalAudio(Context r100) {
        if (isServiceNull(r100) == false) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        AudioDeviceInfo[] r101 = f459648a.getDevices(2);
        if (r101 != null) goto L10;
        return false;
    L10:
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L23;
        int r104 = r101[r103].getType();
        if (r104 == 3) goto L22;
        if (r104 == 4) goto L22;
        if (r104 == 7) goto L22;
        if (r104 == 8) goto L22;
        r103 = r103 + 1;
    L22:
        return true;
    L23:
        return false;
    L25:
        if (f459648a.isWiredHeadsetOn() == false) goto L27;
    L30:
        return true;
    L27:
        if (f459648a.isBluetoothScoOn() == true) goto L30;
        if (f459648a.isBluetoothA2dpOn() == true) goto L30;
        return false;
    }

    public static boolean isRingerNormal(Context r100) {
        if (isServiceNull(r100) == false) goto L6;
        return false;
    L6:
        if (f459648a.getRingerMode() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isServiceNull(Context r100) {
        if (f459648a != null) goto L9;
        f459648a = (AudioManager) r100.getSystemService("audio");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if (f459648a != null) goto L11;
        return true;
    L11:
        return false;
    }

    public static void registerVolumeChangedListener(Context r100) {
        if (f459651d == true) goto L12;
        if (isServiceNull(r100) == false) goto L7;
        return;
    L7:
        f459652e = new OnVolumeChangeListener(f459648a);     // Catch: Exception -> L9
        IntentFilter r101 = new IntentFilter();     // Catch: Exception -> L9
        r101.addAction("android.media.VOLUME_CHANGED_ACTION");     // Catch: Exception -> L9
        INVOKEVIRTUAL_com_ss_videoarch_liveplayer_utils_AudioUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, f459652e, r101);     // Catch: Exception -> L9
        f459651d = true;     // Catch: Exception -> L9
        return;
    L13:
        return;
    }

    public static void unregisterVolumeChangedListener(Context r100) {
        if (f459651d == false) goto L9;
        INVOKEVIRTUAL_com_ss_videoarch_liveplayer_utils_AudioUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, f459652e);     // Catch: Exception -> L6
        f459652e = null;     // Catch: Exception -> L6
        f459651d = false;     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_videoarch_liveplayer_utils_AudioUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    public static void checkAndAdjustMusicVolume(Context r100, float r101) {
        float r102 = getMusicMaxVolume(r100);
        int r103 = getCurrentMusicVolume(r100);
        if (r102 != (-1.0f)) goto L5;
        return;
    L5:
        if (r103 != (-1)) goto L8;
        return;
    L8:
        if ((r103 / r102) > r101) goto L10;
        return;
    L10:
        setMusicVolume(r100, r101, 16);
    }

    public static int getStreamVolume(Context r100, int r101) {
        if (isServiceNull(r100) == false) goto L8;
        return -1;
    L8:
        return f459648a.getStreamVolume(r101);
    L7:
        return -1;
    }

    public static boolean isStreamMuted(Context r100, int r101) {
        if (getStreamVolume(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void toggleMusicMute(Context r100, boolean r101) {
        if (isServiceNull(r100) == false) goto L18;
        return;
    L18:
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (Build.VERSION.SDK_INT <= 23) goto L12;
        AudioManager r102 = f459648a;     // Catch: Exception -> L14
        if (r101 == false) goto L10;
        int r103 = -100;
    L11:
        r102.adjustStreamVolume(3, r103, 0);     // Catch: Exception -> L14
    L17:
        return;
    L10:
        r103 = 100;
        goto L11
    L12:
        f459648a.setStreamMute(3, r101);     // Catch: Exception -> L14
        goto L17
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_videoarch_liveplayer_utils_AudioUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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

    public static boolean raiseMusicVolume(Context r100, int r101, int r102) {
        getMusicMaxVolume(r100);
        getCurrentMusicVolume(r100);
        return setMusicVolume(r100, getCurrentMusicVolume(r100) + r101, r102);
    }

    public static boolean setMusicVolume(Context r100, int r101, int r102) {
        if (isServiceNull(r100) == false) goto L11;
        return false;
    L11:
        f459648a.setStreamVolume(3, r101, r102);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void setMusicVolume(Context r100, float r101, int r102) {
        setMusicVolume(r100, (int) (r101 * getMusicMaxVolume(r100)), r102);
    }
}
