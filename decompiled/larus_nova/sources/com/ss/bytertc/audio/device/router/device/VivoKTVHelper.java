package com.ss.bytertc.audio.device.router.device;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.android.live.uikit.toast.CustomToast;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes40.dex */
public class VivoKTVHelper {
    private static final int[][] EQCustomGain = null;
    private static final int[][] EchoCustomParams = null;
    private static final String KEY_EXT_SPKR = "vivo_ktv_ext_speaker";
    private static final String KEY_KTV_MODE = "vivo_ktv_mode";
    private static final String KEY_MIC_SRC = "vivo_ktv_rec_source";
    private static final String KEY_MIC_TYPE = "vivo_ktv_mic_type";
    private static final String KEY_PLAY_SRC = "vivo_ktv_play_source";
    private static final String KEY_PRESET = "vivo_ktv_preset_effect";
    private static final String KEY_VOL_MIC = "vivo_ktv_volume_mic";
    public static final int MODE_CUSTOM_3DDRAEMY = 6;
    public static final int MODE_CUSTOM_AIRY = 4;
    public static final int MODE_CUSTOM_ATTRACTIVE = 3;
    public static final int MODE_CUSTOM_DISTANT = 5;
    public static final int MODE_CUSTOM_GRAMOPHONE = 7;
    public static final int MODE_CUSTOM_KTV = 1;
    public static final int MODE_CUSTOM_NOEFFECT = 8;
    public static final int MODE_CUSTOM_RECSTUDIO = 0;
    public static final int MODE_CUSTOM_WARM = 2;
    private static final int[][] ReverbCustomParams = null;
    private static final String TAG = "VivoKTVHelper";
    private static final String TAG_ECHO_DELAY = "vivo_ktv_echo_delay";
    private static final String TAG_ECHO_DRY = "vivo_ktv_echo_dry";
    private static final String TAG_ECHO_ENABLE = "vivo_ktv_echo_enable";
    private static final String TAG_ECHO_GAIN = "vivo_ktv_echo_feedback";
    private static final String TAG_ECHO_WET = "vivo_ktv_echo_wet";
    private static final String TAG_MEQ_BAND_1 = "vivo_ktv_miceq_band1";
    private static final String TAG_MEQ_BAND_2 = "vivo_ktv_miceq_band2";
    private static final String TAG_MEQ_BAND_3 = "vivo_ktv_miceq_band3";
    private static final String TAG_MEQ_BAND_4 = "vivo_ktv_miceq_band4";
    private static final String TAG_MEQ_BAND_5 = "vivo_ktv_miceq_band5";
    private static final String TAG_RB_DAMP = "vivo_ktv_rb_damp";
    private static final String TAG_RB_DRY = "vivo_ktv_rb_dry";
    private static final String TAG_RB_GAIN = "vivo_ktv_rb_gain";
    private static final String TAG_RB_ROOMSIZE = "vivo_ktv_rb_roomsize";
    private static final String TAG_RB_WET = "vivo_ktv_rb_wet";
    private static final String TAG_RB_WIDTH = "vivo_ktv_rb_width";
    private static final String TAG_REVERB = "vivo_ktv_reverb_preset";
    private static final int effect_size = 0;
    private static VivoKTVHelper mVivoKTVHelper;
    private AudioManager mAudioManager;
    private Context mContext;
    private final Object mParamLock;

    static {
        int[][] r100 = {new int[]{200, 1000, 500, 4500, 1000, 1500}, new int[]{5000, 4500, 1200, 4500, 6500, 1200}, new int[]{4500, 8000, 1000, 4000, 6500, 1500}, new int[]{CustomToast.LENGTH_SHORT, 3000, 1500, 4000, 5000, 1500}, new int[]{3500, 5500, 1500, 5000, 5500, 1500}, new int[]{4000, 3000, 1000, CustomToast.LENGTH_SHORT, 5500, 1200}, new int[]{500, 5000, 800, 4500, 3000, 1200}, new int[]{20, 500, 60, 4500, 5000, 1500}, new int[]{0, 0, 0, 4000, 0, 1200}};
        ReverbCustomParams = r100;
        effect_size = r100.length;
        EQCustomGain = new int[][]{new int[]{0, 0, 0, 2, 2}, new int[]{0, 0, 0, 0, 0}, new int[]{3, 4, 2, 0, -3}, new int[]{3, 2, 0, 0, 2}, new int[]{3, 2, 0, -1, -3}, new int[]{2, 2, 2, 0, 0}, new int[]{5, 2, -2, 1, 3}, new int[]{-2, 0, 1, 2, 1}, new int[]{0, 0, 0, 0, 0}};
        EchoCustomParams = new int[][]{new int[]{3200, 150, 1500, 2000}};
    }

    public void closeKTVDevice() {
        this.mAudioManager.setParameters("vivo_ktv_mode=0");
    }

    public boolean isDeviceSupportKaraoke() {
        if (Build.MANUFACTURER.trim().contains(DimLocationCheckUtil.VIVO) == false) goto L13;
        StringTokenizer r100 = new StringTokenizer(this.mAudioManager.getParameters(KEY_MIC_TYPE), ContainerUtils.KEY_VALUE_DELIMITER);
        if (r100.countTokens() == 2) goto L8;
        return false;
    L8:
        if (r100.nextToken().equals(KEY_MIC_TYPE) == false) goto L13;
        int r101 = CastIntegerProtector.parseInt(r100.nextToken());
        if (r101 == 1) goto L12;
        if (r101 != 0) goto L13;
    L12:
        return true;
    L13:
        return false;
    }

    public void openKTVDevice() {
        this.mAudioManager.setParameters("vivo_ktv_mode=1");
    }

    public int getExtSpeakerParam() {
        return getKTVParam(KEY_EXT_SPKR);
    }

    public int getMicTypeParam() {
        return getKTVParam(KEY_MIC_TYPE);
    }

    public int getMicVolParam() {
        return getKTVParam(KEY_VOL_MIC);
    }

    public int getPlayFeedbackParam() {
        return getKTVParam(KEY_PLAY_SRC);
    }

    public int getPreModeParam() {
        return getKTVParam(KEY_PRESET);
    }

    public int getVoiceOutParam() {
        return getKTVParam(KEY_MIC_SRC);
    }

    public int getEffectSize() {
        return effect_size;
    }

    public VivoKTVHelper(Context r100) {
        this.mParamLock = new Object();
        this.mContext = r100;
        this.mAudioManager = (AudioManager) r100.getSystemService("audio");
    }

    public static VivoKTVHelper getInstance(Context r100) {
        if (mVivoKTVHelper != null) goto L6;
        mVivoKTVHelper = new VivoKTVHelper(r100);
    L6:
        return mVivoKTVHelper;
    }

    private int getKTVParam(String r100) {
        if (Build.MANUFACTURER.trim().contains(DimLocationCheckUtil.VIVO) == false) goto L11;
        StringTokenizer r101 = new StringTokenizer(this.mAudioManager.getParameters(r100), ContainerUtils.KEY_VALUE_DELIMITER);
        if (r101.countTokens() == 2) goto L8;
        return 0;
    L8:
        if (r100.equals(r101.nextToken()) == true) goto L10;
        return 0;
    L10:
        return CastIntegerProtector.parseInt(r101.nextToken().trim());
    L11:
        return 0;
    }

    private void setEQParams(int r100) {
        AudioManager r101 = this.mAudioManager;
        StringBuilder r102 = new StringBuilder("vivo_ktv_miceq_band1=");
        int[][] r103 = EQCustomGain;
        r102.append(r103[r100][0] + 8);
        r101.setParameters(r102.toString());
        this.mAudioManager.setParameters("vivo_ktv_miceq_band2=" + (r103[r100][1] + 8));
        this.mAudioManager.setParameters("vivo_ktv_miceq_band3=" + (r103[r100][2] + 8));
        this.mAudioManager.setParameters("vivo_ktv_miceq_band4=" + (r103[r100][3] + 8));
        this.mAudioManager.setParameters("vivo_ktv_miceq_band5=" + (r103[r100][4] + 8));
    }

    private void setEchoParams(int r100) {
        if (r100 != 4) goto L6;
        this.mAudioManager.setParameters("vivo_ktv_echo_enable=1");
        AudioManager r101 = this.mAudioManager;
        StringBuilder r102 = new StringBuilder("vivo_ktv_echo_feedback=");
        int[][] r103 = EchoCustomParams;
        r102.append(r103[0][0]);
        r101.setParameters(r102.toString());
        this.mAudioManager.setParameters("vivo_ktv_echo_delay=" + r103[0][1]);
        this.mAudioManager.setParameters("vivo_ktv_echo_wet=" + r103[0][2]);
        this.mAudioManager.setParameters("vivo_ktv_echo_dry=" + r103[0][3]);
        return;
    }

    private void setGramophoneParams(int r100) {
        if (r100 != 7) goto L5;
        this.mAudioManager.setParameters("vivo_ktv_reverb_preset=4");
        return;
    L5:
        this.mAudioManager.setParameters("vivo_ktv_reverb_preset=0");
    }

    private void setReverbParams(int r100) {
        AudioManager r101 = this.mAudioManager;
        StringBuilder r102 = new StringBuilder("vivo_ktv_rb_roomsize=");
        int[][] r103 = ReverbCustomParams;
        r102.append(r103[r100][0]);
        r101.setParameters(r102.toString());
        this.mAudioManager.setParameters("vivo_ktv_rb_damp=" + r103[r100][1]);
        this.mAudioManager.setParameters("vivo_ktv_rb_wet=" + r103[r100][2]);
        this.mAudioManager.setParameters("vivo_ktv_rb_dry=" + r103[r100][3]);
        this.mAudioManager.setParameters("vivo_ktv_rb_width=" + r103[r100][4]);
        this.mAudioManager.setParameters("vivo_ktv_rb_gain=" + r103[r100][5]);
        this.mAudioManager.setParameters("vivo_ktv_echo_enable=0");
    }

    public void setCustomMode(int r100) {
        Object r101 = this.mParamLock;
        monitor-enter(r101);
        setExtSpeakerParam(0);     // Catch: Throwable -> L8
        setGramophoneParams(r100);     // Catch: Throwable -> L8
        setReverbParams(r100);     // Catch: Throwable -> L8
        setEQParams(r100);     // Catch: Throwable -> L8
        setEchoParams(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setExtSpeakerParam(int r100) {
        Object r101 = this.mParamLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioManager == null) goto L7;
        this.mAudioManager.setParameters("vivo_ktv_ext_speaker=" + r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void setMicVolParam(int r100) {
        Object r101 = this.mParamLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioManager == null) goto L7;
        this.mAudioManager.setParameters("vivo_ktv_volume_mic=" + r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void setPlayFeedbackParam(int r100) {
        Object r101 = this.mParamLock;
        monitor-enter(r101);
        AudioManager r102 = this.mAudioManager;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.setParameters("vivo_ktv_play_source=" + r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setVoiceOutParam(int r100) {
        Object r101 = this.mParamLock;
        monitor-enter(r101);
        AudioManager r102 = this.mAudioManager;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.setParameters("vivo_ktv_rec_source=" + r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
