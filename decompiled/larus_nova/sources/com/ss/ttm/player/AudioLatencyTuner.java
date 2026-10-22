package com.ss.ttm.player;

import android.media.AudioTrack;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class AudioLatencyTuner {
    private static final int STATE_LOWERING = 1;
    private static final int STATE_PRIMING = 0;
    private static final int STATE_RAISING = 2;
    private static final int STATE_STABLE = 3;
    private static final String TAG = "AudioLatencyTuner";
    private int mActualSize;
    private float mActualSizeRate;
    private AudioTrack mAudioTrack;
    private int mAudioTrackBlockCount;
    private boolean mAudioTrackWillBlock;
    private int mAutoUpdateSizeStableNum;
    private int mChangeSizeRate;
    private boolean mEnableAutoUpdateSize;
    private boolean mEnableChangeSize;
    private boolean mEnableInitialSizeAdaptFrameSize;
    private int mFramesPerBlock;
    private int mGlobalUpdateSizeMode;
    private boolean[] mHistoryUnderRunRise;
    private int mInitialSize;
    private int mMinTrackSize;
    private int mOutputPcmFrameSize;
    private int mPreviousUnderrunCount;
    private int mPrimingThreshold;
    private int mStableStopUpdateThresh;
    private int mState;
    private float mSuggestedInitialSizeRate;

    public void close() {
        if (this.mGlobalUpdateSizeMode > 0) goto L5;
    L7:
        this.mAudioTrack = null;
        return;
    L5:
        if (this.mState != 3) goto L7;
        TTPlayerConfiger.setValue(74, this.mActualSize);
        goto L7
    }

    public AudioLatencyTuner() {
        this.mSuggestedInitialSizeRate = 1.0f;
        this.mEnableInitialSizeAdaptFrameSize = false;
        this.mAudioTrack = null;
        this.mOutputPcmFrameSize = 0;
        this.mInitialSize = 0;
        this.mActualSize = 0;
        this.mActualSizeRate = 1.0f;
        this.mEnableChangeSize = false;
        this.mChangeSizeRate = 2;
        this.mEnableAutoUpdateSize = false;
        this.mFramesPerBlock = 64;
        this.mPrimingThreshold = 8;
        this.mState = 0;
        this.mPreviousUnderrunCount = 0;
        this.mStableStopUpdateThresh = 0;
        this.mAutoUpdateSizeStableNum = 0;
        this.mGlobalUpdateSizeMode = 0;
        this.mAudioTrackWillBlock = true;
        this.mAudioTrackBlockCount = 0;
        this.mMinTrackSize = 0;
        this.mHistoryUnderRunRise = new boolean[]{false, false};
    }

    private boolean incrementThreshold(int r100) {
        int r101 = this.mAudioTrack.getBufferSizeInFrames();
        int r102 = this.mFramesPerBlock;
        int r103 = ((r101 / r102) + r100) * r102;
        int r104 = this.mAudioTrack.setBufferSizeInFrames(r103);
        int r105 = this.mOutputPcmFrameSize;
        int r106 = r104 * r105;
        this.mActualSize = r106;
        if (r106 != (r101 * r105)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setFloatOption(int r100, float r101) {
        if (r100 != 11) goto L5;
        this.mSuggestedInitialSizeRate = r101;
        return;
    L5:
        if (r100 != 12) goto L11;
        this.mActualSizeRate = r101;
        return;
    }

    public void setIntOption(int r100, int r101) {
        boolean r102 = true;
        if (r100 == 10) goto L18;
        switch(r100) {
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L9;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L6;
            default: goto L29;
        };
    L6:
        this.mGlobalUpdateSizeMode = r101;
        return;
    L7:
        this.mStableStopUpdateThresh = r101;
        return;
    L8:
        this.mPrimingThreshold = r101;
        return;
    L9:
        if (r101 > 0) goto L12;
        r102 = false;
    L12:
        this.mEnableAutoUpdateSize = r102;
        return;
    L13:
        this.mChangeSizeRate = r101;
        return;
    L14:
        if (r101 > 0) goto L17;
        r102 = false;
    L17:
        this.mEnableChangeSize = r102;
        return;
    L29:
        return;
    L18:
        if (r101 > 0) goto L21;
        r102 = false;
    L21:
        this.mEnableInitialSizeAdaptFrameSize = r102;
    }

    public int update(int r100, long r101) {
        AudioTrack r102 = this.mAudioTrack;
        if (r102 == null) goto L5;
        int r103 = 1;
        if (this.mAudioTrackWillBlock == false) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        this.mAudioTrackBlockCount++;
    L16:
        if (r100 > 256) goto L19;
        if (r100 < 0) goto L19;
        boolean r105 = true;
    L20:
        this.mAudioTrackWillBlock = r105;
        if (this.mEnableChangeSize == false) goto L28;
        if (this.mAudioTrackBlockCount <= this.mChangeSizeRate) goto L28;
        int r106 = this.mActualSize;
        int r107 = this.mMinTrackSize;
        if (r106 == r107) goto L28;
        this.mActualSize = r102.setBufferSizeInFrames(r107 / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
        this.mEnableChangeSize = false;
    L28:
        if (this.mEnableAutoUpdateSize == false) goto L73;
        if (r104 == false) goto L73;
        int r108 = this.mState;
        if (r108 == 0) goto L68;
        if (r108 == 1) goto L50;
        if (r108 != 2) goto L70;
        int r109 = this.mAudioTrack.getUnderrunCount();
        if (r109 <= this.mPreviousUnderrunCount) goto L44;
        boolean[] r110 = this.mHistoryUnderRunRise;
        if (r110[0] == false) goto L41;
    L42:
        incrementThreshold(3);
    L43:
        this.mAutoUpdateSizeStableNum = 0;
        boolean[] r111 = this.mHistoryUnderRunRise;
        r111[0] = r111[1];
        r111[1] = true;
    L48:
        r103 = r108;
    L49:
        this.mPreviousUnderrunCount = r109;
    L71:
        this.mState = r103;
    L86:
        return this.mActualSize;
    L41:
        if (r110[1] == false) goto L43;
    L44:
        int r112 = this.mAutoUpdateSizeStableNum + 1;
        this.mAutoUpdateSizeStableNum = r112;
        boolean[] r113 = this.mHistoryUnderRunRise;
        r113[0] = r113[1];
        r113[1] = false;
        int r114 = this.mStableStopUpdateThresh;
        if (r114 <= 0) goto L48;
        if (r112 <= r114) goto L48;
        r103 = 3;
    L70:
        r103 = r108;
        goto L71
    L50:
        int r115 = this.mAudioTrack.getUnderrunCount();
        if (r115 <= this.mPreviousUnderrunCount) goto L58;
        boolean[] r116 = this.mHistoryUnderRunRise;
        if (r116[0] == false) goto L55;
    L56:
        incrementThreshold(3);
        r108 = 2;
    L57:
        boolean[] r117 = this.mHistoryUnderRunRise;
        r117[0] = r117[1];
        r117[1] = true;
    L66:
        r103 = r108;
        this.mPreviousUnderrunCount = r115;
        goto L71
    L55:
        if (r116[1] == false) goto L57;
    L58:
        boolean[] r118 = this.mHistoryUnderRunRise;
        if (r118[0] == false) goto L61;
    L65:
        boolean[] r119 = this.mHistoryUnderRunRise;
        r119[0] = r119[1];
        r119[1] = false;
        goto L66
    L61:
        if (r118[1] == true) goto L65;
        if (incrementThreshold(-1) == false) goto L65;
        r108 = 2;
        goto L65
    L68:
        if (this.mAudioTrackBlockCount <= this.mPrimingThreshold) goto L70;
        this.mPreviousUnderrunCount = this.mAudioTrack.getUnderrunCount();
    L73:
        if (this.mActualSize >= this.mMinTrackSize) goto L86;
        if (r104 == false) goto L86;
        int r120 = this.mAudioTrack.getUnderrunCount();
        if (r120 <= this.mPreviousUnderrunCount) goto L83;
        boolean[] r121 = this.mHistoryUnderRunRise;
        if (r121[0] == false) goto L80;
    L81:
        this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(this.mMinTrackSize / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
    L82:
        boolean[] r122 = this.mHistoryUnderRunRise;
        r122[0] = r122[1];
        r122[1] = true;
    L84:
        this.mPreviousUnderrunCount = r120;
        goto L86
    L80:
        if (r121[1] == false) goto L82;
    L83:
        boolean[] r123 = this.mHistoryUnderRunRise;
        r123[0] = r123[1];
        r123[1] = false;
    L19:
        r105 = false;
        goto L20
    L9:
        if (r101 >= 5) goto L12;
        r104 = false;
        goto L13
    L5:
        return this.mActualSize;
    }

    public int updateAudioTrack(AudioTrack r100, int r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        this.mAudioTrack = r100;
        this.mOutputPcmFrameSize = r101;
        int r102 = TTPlayerConfiger.getValue(74, 0);
        if (this.mGlobalUpdateSizeMode <= 0) goto L11;
        if (r102 <= 0) goto L11;
        this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(r102 / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
        if (this.mGlobalUpdateSizeMode != 2) goto L12;
        this.mState = 3;
    L12:
        Objects.toString(this.mAudioTrack);
        return this.mActualSize;
    L11:
        this.mActualSize = this.mAudioTrack.setBufferSizeInFrames((int) ((this.mInitialSize * this.mActualSizeRate) / this.mOutputPcmFrameSize)) * this.mOutputPcmFrameSize;
        goto L12
    }

    public int getSuggestedInitialSize(int r100, int r101, int r102, int r103) {
        int r104 = AudioTrack.getMinBufferSize(r100, r101, r102);
        this.mMinTrackSize = r104;
        int r105 = (int) (r104 * this.mSuggestedInitialSizeRate);
        this.mInitialSize = r105;
        if (this.mEnableInitialSizeAdaptFrameSize == false) goto L6;
        this.mInitialSize = ((r105 / r103) + 1) * r103;
    L6:
        return this.mInitialSize;
    }
}
