package com.ss.bytertc.audio.device.router.device;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes40.dex */
public class KaraokeMediaHelper {
    private final String KARAOKE_APP_SUPPORT;
    private final String KARAOKE_ENABLE;
    private final String KARAOKE_EQ;
    private final String KARAOKE_KTVMODE;
    private final String KARAOKE_REVERB;
    private final String KARAOKE_SUPPORT;
    private final String KARAOKE_VOLUME;
    private final int VOLUME_MAX_APP;
    private final int VOLUME_MIN_APP;
    private AudioManager mAudioManager;
    private ContentResolver mContentResolver;
    private Context mContext;
    private int mEnabled;
    private int mEqMode;
    private boolean mInitialized;
    private int mReverbMode;
    private SharedPreferences mSp;
    private int mVolume;

    public void closeKTVDevice() {
        this.mAudioManager.setParameters("audio_karaoke_ktvmode=disable");
        this.mInitialized = false;
    }

    public boolean isDeviceSupportKaraoke() {
        return this.mAudioManager.getParameters("audio_karaoke_support").contains("true");
    }

    public boolean isEnable() {
        if (this.mEnabled == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void openKTVDevice() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        this.mVolume = this.mSp.getInt("audio_karaoke_volume", 50);
        this.mEqMode = this.mSp.getInt("audio_karaoke_EQ", 0);
        this.mReverbMode = this.mSp.getInt("karaoke_Reverb", 0);
        this.mAudioManager.setParameters("audio_karaoke_ktvmode=enable");
        this.mAudioManager.setParameters("audio_karaoke_volume=" + this.mVolume);
        this.mAudioManager.setParameters("audio_karaoke_EQ=" + this.mEqMode);
        this.mAudioManager.setParameters("karaoke_Reverb=" + this.mReverbMode);
        this.mInitialized = true;
    }

    public int getPlayFeedbackParam() {
        if (isEnable() == false) goto L6;
        return 1;
    L6:
        return 0;
    }

    public int getMicVolParam() {
        return this.mVolume;
    }

    public KaraokeMediaHelper(Context r100) {
        this.KARAOKE_ENABLE = "audio_karaoke_enable";
        this.KARAOKE_VOLUME = "audio_karaoke_volume";
        this.KARAOKE_EQ = "audio_karaoke_EQ";
        this.KARAOKE_REVERB = "karaoke_Reverb";
        this.KARAOKE_SUPPORT = "audio_karaoke_support";
        this.KARAOKE_APP_SUPPORT = "karaoke_app_support";
        this.KARAOKE_KTVMODE = "audio_karaoke_ktvmode";
        this.VOLUME_MAX_APP = 15;
        this.VOLUME_MIN_APP = 0;
        this.mContext = r100;
        this.mContentResolver = r100.getContentResolver();
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mSp = this.mContext.getSharedPreferences("loopback_mode", 0);
        this.mInitialized = false;
    }

    public static KaraokeMediaHelper getInstance(Context r100) {
        return new KaraokeMediaHelper(r100);
    }

    public boolean isAppSupportKaraoke(String r100) {
        return this.mAudioManager.getParameters("karaoke_app_support:" + r100).contains("true");
    }

    public void setFeedbackEffect(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (r100 <= 3) goto L6;
        return;
    L6:
        if (this.mReverbMode == r100) goto L11;
        this.mAudioManager.setParameters("karaoke_Reverb=" + r100);
        this.mReverbMode = r100;
        return;
    }

    public void setMicVolParam(int r100) {
        if (r100 <= 15) goto L5;
        r100 = 15;
    L5:
        if (r100 >= 0) goto L8;
        r100 = 0;
    L8:
        if (this.mVolume != r100) goto L10;
        return;
    L10:
        if (isEnable() == false) goto L14;
        this.mAudioManager.setParameters("audio_karaoke_volume=" + r100);
        this.mVolume = r100;
        return;
    }

    public void setPlayFeedbackParam(int r100) {
        if (this.mEnabled != r100) goto L5;
        return;
    L5:
        this.mEnabled = r100;
        this.mAudioManager.setParameters("audio_karaoke_enable=" + r100);
    }
}
