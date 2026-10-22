package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.hihonor.android.magicx.media.audio.interfaces.HnAudioClient;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;

/* JADX INFO: loaded from: classes40.dex */
public class HardwareEarbackPackageChecker {
    public HardwareEarbackPackageChecker() {
    }

    public static boolean isHnEarbackPackageSupported() {
        HnAudioClient r100 = null;
        boolean r101 = HnAudioClient.isDeviceSupported(ContextUtils.getApplicationContext());     // Catch: NoClassDefFoundError -> L8
        if (r101 == true) goto L15;
    L9:
        if (r101 == false) goto L17;
        if (r100 == null) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L15:
        r100 = new HnAudioClient(ContextUtils.getApplicationContext(), null);     // Catch: NoClassDefFoundError -> L7
    L8:
        r101 = false;
        goto L9
    }

    public static boolean isHwEarbackPackageSupported() {
        HwAudioKit r100 = null;
        r100 = new HwAudioKit(ContextUtils.getApplicationContext(), null);     // Catch: NoClassDefFoundError -> L5
    L6:
        if (r100 == null) goto L8;
        return true;
    L8:
        return false;
    }
}
