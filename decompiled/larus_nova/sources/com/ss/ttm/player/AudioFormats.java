package com.ss.ttm.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public class AudioFormats {
    private static boolean sDetectDlbDevices;
    private static boolean sDlbDevice;
    private static final int[] validSampleRates = null;

    public AudioFormats() {
    }

    static {
        validSampleRates = new int[]{4000, 8000, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
        sDetectDlbDevices = false;
        sDlbDevice = false;
    }

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices == true) goto L5;
        AudioEffect.Descriptor[] r100 = AudioEffect.queryEffects();
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        if (r100[r102].implementor.contains("Dolby Laboratories") == true) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        sDlbDevice = true;
    L13:
        sDetectDlbDevices = true;
        return sDlbDevice;
    L5:
        return sDlbDevice;
    }

    public static int getMaxSupportedSampleRates(int[] r100) {
        int r101 = validSampleRates.length;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r102 = r101 - 3;
    L6:
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        r100[r103] = validSampleRates[r103];
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    L5:
        r102 = r101 - 5;
        goto L6
    }
}
