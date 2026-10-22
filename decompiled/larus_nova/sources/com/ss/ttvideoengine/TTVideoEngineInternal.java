package com.ss.ttvideoengine;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttvideoengine.configcenter.IEngineConfig;
import com.ss.ttvideoengine.configcenter.PlayerConfigExecutor;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.IPlayDurationManager;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public abstract class TTVideoEngineInternal implements ITTVideoEngineInternal, ITTVideoEngineEventSource {
    protected static final int MAX_ERROR_COUNT = 3;
    private static final String TAG = "TTVideoEngine";
    private static int sIsColdStart = 1;
    protected int mAccumulatedErrorCount;
    protected int mAllowAllExtensions;
    protected int mAsyncInitEnable;
    protected int mAudioCodecID;
    protected int mAudioCodecType;
    protected int mBufferingType;
    protected int mCleanWhenStop;
    protected int mCodecId;
    protected int mConfigCenterVersion;
    protected HashMap<Integer, Integer> mConfigParams;
    protected int mConfigParamsOption;
    protected Context mContext;
    protected int mCurPlayBackTime;
    protected String mCurrentUrl;
    protected int mCurrentUrlIndex;
    protected String mDirectURL;
    protected String mDirectUrlSrc;
    protected int mDisableResetSystemVolume;
    protected int mDisableThreadPoolUsing;
    protected int mDuration;
    protected int mEnableMasterM3u8Optimize;
    protected int mEnablePlaySpeedExtend;
    protected IEngineConfig mEngineConfig;
    protected boolean mEngineHasUsed;
    protected Error mError;
    protected int mErrorCount;
    protected boolean mErrorEnd;
    protected int mExoAllowMediaCodecHelper;
    protected int mExoCodecAsyncInitEnable;
    protected int mExoCodecReusable;
    protected int mExoConsecutiveFailNum;
    protected boolean mExoEnableNativeMdl;
    protected String mExoLoadControlParameters;
    protected int mExoRenderReadyMs;
    protected int mExtVoiceFormat;
    protected int mFallbackExoFirst;
    protected boolean mFirstGetWidthHeight;
    protected int mForbidOSPlayer;
    protected int mHardwareDecodeEnablePlayer2;
    protected boolean mHasComplete;
    protected boolean mHasFirstFrameShown;
    protected int mHeight;
    protected String mInitialURL;
    protected int mIsColdStart;
    protected boolean mIsDirectURL;
    protected boolean mIsLocal;
    protected boolean mIsMute;
    protected boolean mIsPlayComplete;
    protected boolean mIsStartPlayAutomatically;
    protected int mLastPlaybackTime;
    protected long mLastSwitchRadioModeTime;
    protected float mLeftVolume;
    protected int mLoadState;
    protected int mLoadedProgress;
    protected String mLocalURL;
    protected boolean mLooping;
    protected int mMaxAccumulatedCountSetByUser;
    protected MediaPlayer mMediaPlayer;
    protected MyMediaPlayerListener mMediaPlayerListener;
    protected String[] mOriginalUrls;
    protected boolean mPausedBeforePrepared;
    protected String mPlayBufferConfig;
    protected IPlayDurationManager mPlayDuration;
    protected String mPlayLoadConfig;
    protected String mPlayRangeConfig;
    protected long mPlayTime;
    protected PlaybackParams mPlaybackParams;
    protected int mPlaybackState;
    protected PlayerConfigExecutor mPlayerConfigExecutor;
    protected int mPlayerDegradeMode;
    protected int mPlayerType;
    protected boolean mPrepared;
    protected int mRadioModeEnable;
    protected volatile boolean mReleased;
    protected boolean mRetrying;
    protected boolean mRetryingNotHandleError;
    protected float mRightVolume;
    protected SeekCompletionListener mSeekCompletionListener;
    protected boolean mSeeking;
    protected long mSeekingStartTime;
    protected int mSetTrackVolume;
    protected boolean mShouldPlay;
    protected boolean mShouldStop;
    private String mSourceTypeStr;
    protected boolean mStarted;
    protected int mState;
    protected String mSubTag;
    protected Surface mSurface;
    protected SurfaceHolder mSurfaceHolder;
    protected int mSurfaceHolderByKernel;
    protected int mSyncMaster;
    protected String mTag;
    protected boolean mTexNotifyFirstFrame;
    protected boolean mUserStopped;
    protected int mVideoCodecID;
    protected int mVideoCodecType;
    protected int mWidth;

    public static class MyMediaPlayerListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.onSARChangedListener {
        private final WeakReference<TTVideoEngineInternal> mVideoEngineInternalRef;

        public MyMediaPlayerListener(TTVideoEngineInternal r100) {
            this.mVideoEngineInternalRef = new WeakReference(r100);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer r100) {
            TTVideoEngineInternal r101 = this.mVideoEngineInternalRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onMediaPlayerCompletion(r100);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer r100) {
            TTVideoEngineInternal r101 = this.mVideoEngineInternalRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onMediaPlayerPrepared(r100);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer r100) {
            TTVideoEngineInternal r101 = this.mVideoEngineInternalRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onMediaPlayerSeekComplete(r100, true);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer r100, int r101) {
            TTVideoEngineInternal r102 = this.mVideoEngineInternalRef.get();
            if (r102 != null) goto L5;
            return;
        L5:
            r102.onMediaPlayerBufferingUpdate(r100, r101);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer r100, int r101, int r102) {
            TTVideoEngineInternal r103 = this.mVideoEngineInternalRef.get();
            if (r103 != null) goto L7;
            return false;
        L7:
            return r103.onMediaPlayerError(r100, r101, r102);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer r100, int r101, int r102) {
            TTVideoEngineInternal r103 = this.mVideoEngineInternalRef.get();
            if (r103 != null) goto L7;
            return false;
        L7:
            return r103.onMediaPlayerInfo(r100, r101, r102);
        }

        @Override // com.ss.ttm.player.MediaPlayer.onSARChangedListener
        public void onSARChanged(MediaPlayer r100, int r101, int r102) {
            TTVideoEngineInternal r103 = this.mVideoEngineInternalRef.get();
            if (r103 != null) goto L5;
            return;
        L5:
            r103.onMediaPlayerSARChanged(r100, r101, r102);
        }

        @Override // com.ss.ttm.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer r100, int r101, int r102) {
            TTVideoEngineInternal r103 = this.mVideoEngineInternalRef.get();
            if (r103 != null) goto L5;
            return;
        L5:
            r103.onMediaPlayerVideoSizeChanged(r100, r101, r102);
        }
    }

    public abstract MediaPlayer createMediaPlayer();

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getFloatOption(int r100) {
        return 0.0f;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public String getStringOption(int r100) {
        return "";
    }

    public boolean isInHousePlayer() {
        if (isPlayerType(0) == false) goto L5;
    L10:
        return true;
    L5:
        if (isPlayerType(1) == true) goto L10;
        if (isPlayerType(3) == true) goto L10;
        if (isPlayerType(4) == true) goto L10;
        return false;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isOSPlayer() {
        return isPlayerType(2);
    }

    public abstract String logcatTag();

    public void notifyBufferEnd(int r100) {
    }

    public void notifyBufferStart(int r100, int r101, int r102) {
    }

    public void notifyBufferingUpdate(int r100) {
    }

    public void notifyCompletion() {
    }

    public void notifyError(Error r100) {
    }

    public void notifyInfoIdChanged(int r100) {
    }

    public void notifyLoadStateChanged(int r100) {
    }

    public void notifyPlaybackStateChanged(int r100) {
    }

    public void notifyPrepare() {
    }

    public void notifyPrepared() {
    }

    public void notifyReadyForDisplay() {
    }

    public void notifyRenderStart() {
    }

    public void notifySARChanged(int r100, int r101) {
    }

    public void notifySeekCompletion(boolean r100) {
    }

    public void notifyStreamChanged(int r100) {
    }

    public void notifyVideoSizeChanged(int r100, int r101) {
    }

    public void onMediaPlayerBufferingUpdate(MediaPlayer r100, int r101) {
    }

    public void onMediaPlayerCompletion(MediaPlayer r100) {
    }

    public boolean onMediaPlayerError(MediaPlayer r100, int r101, int r102) {
        return false;
    }

    public boolean onMediaPlayerInfo(MediaPlayer r100, int r101, int r102) {
        return false;
    }

    public void onMediaPlayerPrepared(MediaPlayer r100) {
    }

    public void onMediaPlayerSARChanged(MediaPlayer r100, int r101, int r102) {
    }

    public void onMediaPlayerSeekComplete(MediaPlayer r100, boolean r101) {
    }

    public void onMediaPlayerVideoSizeChanged(MediaPlayer r100, int r101, int r102) {
    }

    public void receivedError(Error r100) {
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void resetEngine() {
    }

    public void updateLoadState(int r100, int r101) {
    }

    public void updatePlaybackState(int r100) {
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoHeight() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getVideoHeight();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getVideoWidth() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getVideoWidth();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public float getVolume() {
        return TTVideoEngineInternalHelper.getVolume(this.mContext);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getWatchedDuration() {
        IPlayDurationManager r100 = this.mPlayDuration;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getPlayedDuration();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isMute() {
        if (this.mState != 3) goto L14;
        if (this.mShouldPlay == false) goto L7;
    L9:
        boolean r100 = this.mIsMute;
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L12;
        return r100;
    L12:
        return r101.isMute();
    L7:
        if (this.mPlaybackState == 2) goto L9;
    L14:
        return this.mIsMute;
    }

    public boolean needReleaseMediaPlayer() {
        if (this.mMediaPlayer.getPlayerType() != 0) goto L5;
    L12:
        return true;
    L5:
        if (this.mMediaPlayer.getPlayerType() == 5) goto L12;
        if (this.mMediaPlayer.getPlayerType() == 3) goto L12;
        if (this.mMediaPlayer.getPlayerType() == 4) goto L12;
        return false;
    }

    public void registerListenerMediaPlayer() {
        if (this.mMediaPlayer != null) goto L5;
        return;
    L5:
        MyMediaPlayerListener r100 = new MyMediaPlayerListener(this);
        this.mMediaPlayerListener = r100;
        this.mMediaPlayer.setOnPreparedListener(r100);
        this.mMediaPlayer.setOnInfoListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnBufferingUpdateListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnCompletionListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnErrorListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnSeekCompleteListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnSARChangedListener(this.mMediaPlayerListener);
    }

    public void releaseMediaPlayer() {
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        this.mTexNotifyFirstFrame = false;
    }

    public void resetMediaPlayerOptions() {
        this.mMediaPlayer.setIntOption(59, this.mHardwareDecodeEnablePlayer2);
    }

    public void setMediaPlayerOptions() {
        this.mMediaPlayer.setIntOption(94, getConfigInt(415, this.mSetTrackVolume));
        this.mMediaPlayer.setIntOption(98, getConfigInt(340, this.mDisableResetSystemVolume));
        this.mMediaPlayer.setIntOption(261, this.mRadioModeEnable);
        setPlayerMute(this.mIsMute);
        float r100 = this.mLeftVolume;
        if (r100 < 0.0f) goto L8;
        float r101 = this.mRightVolume;
        if (r101 < 0.0f) goto L8;
        setPlayerVolume(r100, r101);
    L8:
        if (this.mHardwareDecodeEnablePlayer2 != 1) goto L11;
        this.mMediaPlayer.setIntOption(182, this.mCodecId);
        this.mMediaPlayer.setIntOption(181, this.mAsyncInitEnable);
    L11:
        if (this.mPlayerType != 5) goto L31;
        String r102 = this.mExoLoadControlParameters;
        if (r102 == null) goto L15;
        this.mMediaPlayer.setStringOption(5000, r102);
    L15:
        int r103 = this.mExoRenderReadyMs;
        if (r103 < 0) goto L18;
        this.mMediaPlayer.setIntOption(5001, r103);
    L18:
        int r104 = this.mExoConsecutiveFailNum;
        if (r104 < 0) goto L21;
        this.mMediaPlayer.setIntOption(5002, r104);
    L21:
        int r105 = this.mExoCodecReusable;
        if (r105 < 0) goto L24;
        this.mMediaPlayer.setIntOption(5003, r105);
    L24:
        int r106 = this.mExoCodecAsyncInitEnable;
        if (r106 < 0) goto L27;
        this.mMediaPlayer.setIntOption(ITTVideoEngineInternal.PLAYER_OPTION_EXO_CODEC_ASYNC_INIT_ENABLE, r106);
    L27:
        int r107 = this.mExoAllowMediaCodecHelper;
        if (r107 < 0) goto L32;
        this.mMediaPlayer.setIntOption(ITTVideoEngineInternal.PLAYER_OPTION_EXO_ALLOW_MEDIACODECHELPER, r107);
        return;
    L32:
        return;
    }

    public boolean shouldPrepare() {
        int r100 = this.mPlaybackState;
        if (r100 == 0) goto L7;
        if (r100 == 3) goto L7;
    L9:
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r101.getPlayerType() == 0) goto L14;
        return false;
    L14:
        if (this.mPrepared == true) goto L19;
        return true;
    L19:
        return false;
    L7:
        if (this.mPrepared == true) goto L9;
        return true;
    }

    public TTVideoEngineInternal() {
        this.mTag = "";
        this.mSubTag = "";
        this.mConfigParams = null;
        this.mSurfaceHolderByKernel = 0;
        this.mState = 0;
        this.mPlaybackState = 0;
        this.mLoadState = 0;
        this.mSyncMaster = 0;
        this.mExtVoiceFormat = -1;
        this.mBufferingType = -1;
        this.mSourceTypeStr = "";
        this.mIsDirectURL = false;
        this.mDirectURL = "";
        this.mDirectUrlSrc = "";
        this.mOriginalUrls = null;
        this.mCurrentUrl = null;
        this.mCurrentUrlIndex = 0;
        this.mIsLocal = false;
        this.mLocalURL = "";
        this.mConfigParamsOption = 1;
        this.mForbidOSPlayer = 0;
        this.mFallbackExoFirst = -1;
        this.mPlayerDegradeMode = 0;
        this.mDisableThreadPoolUsing = 0;
        this.mIsColdStart = 0;
        this.mShouldPlay = false;
        this.mShouldStop = false;
        this.mUserStopped = false;
        this.mPausedBeforePrepared = false;
        this.mStarted = false;
        this.mPrepared = false;
        this.mReleased = false;
        this.mHasComplete = false;
        this.mErrorEnd = false;
        this.mEngineHasUsed = false;
        this.mPlayTime = 0;
        this.mRetrying = false;
        this.mRetryingNotHandleError = false;
        this.mAccumulatedErrorCount = 0;
        this.mIsPlayComplete = false;
        this.mHasFirstFrameShown = false;
        this.mTexNotifyFirstFrame = false;
        this.mFirstGetWidthHeight = true;
        this.mSeeking = false;
        this.mSeekingStartTime = 0;
        this.mLastPlaybackTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mDuration = 0;
        this.mCurPlayBackTime = 0;
        this.mLoadedProgress = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mCodecId = 0;
        this.mAsyncInitEnable = 0;
        this.mSetTrackVolume = 0;
        this.mIsStartPlayAutomatically = true;
        this.mCleanWhenStop = 0;
        this.mMaxAccumulatedCountSetByUser = 30;
        this.mRadioModeEnable = 0;
        this.mLastSwitchRadioModeTime = 0;
        this.mHardwareDecodeEnablePlayer2 = 0;
        this.mDisableResetSystemVolume = 0;
        this.mVideoCodecType = -1;
        this.mAudioCodecType = -1;
        this.mVideoCodecID = -1;
        this.mAudioCodecID = -1;
        this.mExoLoadControlParameters = null;
        this.mExoRenderReadyMs = -1;
        this.mExoConsecutiveFailNum = -1;
        this.mExoCodecReusable = 0;
        this.mExoCodecAsyncInitEnable = 0;
        this.mExoAllowMediaCodecHelper = 0;
        this.mExoEnableNativeMdl = false;
        this.mErrorCount = 0;
        this.mError = null;
        this.mPlayLoadConfig = "";
        this.mPlayRangeConfig = "";
        this.mPlayBufferConfig = "";
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getCurrentPlaybackTimeAsync() {
        return getCurrentPlaybackTime();
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getBufferingType() {
        return this.mBufferingType;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadState() {
        return this.mLoadState;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getLoadedProgress() {
        return this.mLoadedProgress;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getPlaybackState() {
        return this.mPlaybackState;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isLooping() {
        return this.mLooping;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isShouldPlay() {
        return this.mShouldPlay;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isStarted() {
        return this.mStarted;
    }

    public static String logcatTag(TTVideoEngineInternal r100) {
        if (r100 != null) goto L6;
        return TAG;
    L6:
        return r100.logcatTag();
    }

    public static int transMediaPlayerType(int r100) {
        if (r100 != 0) goto L5;
        return 2;
    L5:
        if (r100 == 1) goto L17;
        if (r100 != 2) goto L8;
        return 1;
    L8:
        if (r100 != 3) goto L10;
        return 3;
    L10:
        if (r100 != 4) goto L12;
        return 4;
    L12:
        if (r100 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException("unknown internal player type: " + r100);
    L17:
        return 0;
    }

    @Override // com.ss.ttvideoengine.log.EventSource
    public Object get(String r100) {
        r100.getClass();
        byte r101 = 0;
        switch(r100.hashCode()) {
            case -1918669260: goto L106;
            case -1627548605: goto L102;
            case -1590191033: goto L98;
            case -1387706125: goto L94;
            case -1232105869: goto L90;
            case -1221029593: goto L86;
            case -973335816: goto L82;
            case -891528870: goto L78;
            case -810883302: goto L74;
            case -408413369: goto L70;
            case -84625186: goto L66;
            case -2219161: goto L62;
            case 3181: goto L58;
            case 3343: goto L54;
            case 3758: goto L50;
            case 114586: goto L46;
            case 3363353: goto L42;
            case 18295322: goto L38;
            case 25209764: goto L34;
            case 94834710: goto L30;
            case 113126854: goto L26;
            case 1146284520: goto L22;
            case 1194780756: goto L18;
            case 1233717748: goto L14;
            case 1309305083: goto L10;
            case 1458614914: goto L6;
            default: goto L4;
        };
    L4:
        r101 = -1;
    L109:
        switch(r101) {
            case 0: goto L223;
            case 1: goto L206;
            case 2: goto L205;
            case 3: goto L203;
            case 4: goto L194;
            case 5: goto L193;
            case 6: goto L184;
            case 7: goto L183;
            case 8: goto L181;
            case 9: goto L179;
            case 10: goto L177;
            case 11: goto L175;
            case 12: goto L173;
            case 13: goto L162;
            case 14: goto L161;
            case 15: goto L159;
            case 16: goto L150;
            case 17: goto L225;
            case 18: goto L144;
            case 19: goto L126;
            case 20: goto L125;
            case 21: goto L123;
            case 22: goto L121;
            case 23: goto L119;
            case 24: goto L117;
            case 25: goto L111;
            default: goto L228;
        };
    L111:
        MediaPlayer r102 = this.mMediaPlayer;
        if (r102 != null) goto L114;
        return "";
    L114:
        return r102.getStringOption(516);
    L126:
        MediaPlayer r103 = this.mMediaPlayer;
        if (r103 != null) goto L130;
        return null;
    L130:
        if (this.mVideoCodecID >= 0) goto L132;
        this.mVideoCodecID = r103.getIntOption(141, -1);
    L132:
        int r104 = this.mVideoCodecID;
        if (r104 != 0) goto L136;
        return "h264";
    L136:
        if (r104 != 1) goto L140;
        return "bytevc1";
    L140:
        if (r104 == 33) goto L142;
        return null;
    L142:
        return Integer.valueOf(r104);
    L150:
        MediaPlayer r105 = this.mMediaPlayer;
        if (r105 == null) goto L157;
        if (r105.isMute() == false) goto L155;
        return 1;
    L155:
        return 0;
    L157:
        return -1;
    L162:
        MediaPlayer r106 = this.mMediaPlayer;
        if (r106 != null) goto L166;
        return 0;
    L166:
        if (this.mVideoCodecType >= 0) goto L169;
        this.mVideoCodecType = r106.getIntOption(157, -1);
    L169:
        if (this.mVideoCodecType == 2) goto L171;
        return 0;
    L171:
        return 1;
    L184:
        MediaPlayer r107 = this.mMediaPlayer;
        if (r107 != null) goto L188;
        return 0;
    L188:
        if (this.mAudioCodecType >= 0) goto L191;
        this.mAudioCodecType = r107.getIntOption(158, -1);
    L191:
        return Integer.valueOf(this.mAudioCodecType);
    L194:
        MediaPlayer r108 = this.mMediaPlayer;
        if (r108 != null) goto L198;
        return 0;
    L198:
        if (this.mVideoCodecType >= 0) goto L201;
        this.mVideoCodecType = r108.getIntOption(157, -1);
    L201:
        return Integer.valueOf(this.mVideoCodecType);
    L206:
        MediaPlayer r109 = this.mMediaPlayer;
        if (r109 == null) goto L230;
        int r110 = r109.getIntOption(139, -1);
        if (r110 == 0) goto L216;
        if (r110 != 1) goto L227;
        return "nativewindow";
    L227:
        return null;
    L216:
        return "opengl";
    L230:
        return null;
    L223:
        return Build.HARDWARE;
    L220:
        e = move-exception;
        TTVideoEngineInternalLog.d(e);
        return "";
    L225:
        return Build.BOARD;
    L147:
        e = move-exception;
        TTVideoEngineInternalLog.d(e);
        return "";
    L228:
        return null;
    L117:
        return Integer.valueOf(this.mHardwareDecodeEnablePlayer2);
    L119:
        return this.mInitialURL;
    L121:
        return Integer.valueOf(this.mState);
    L123:
        return Integer.valueOf(this.mCurPlayBackTime);
    L125:
        return Integer.valueOf(this.mWidth);
    L144:
        return BaseAppInfo.mDeviceId;
    L159:
        return this.mTag;
    L161:
        return Integer.valueOf(this.mDuration);
    L173:
        return Integer.valueOf(this.mExoAllowMediaCodecHelper);
    L175:
        return Integer.valueOf(this.mRadioModeEnable);
    L177:
        return this.mSourceTypeStr;
    L179:
        return Integer.valueOf(this.mIsColdStart);
    L181:
        return Float.valueOf(getVolume());
    L183:
        return this.mSubTag;
    L193:
        return Integer.valueOf(this.mHeight);
    L203:
        return Integer.valueOf(this.mAsyncInitEnable);
    L205:
        return Integer.valueOf(this.mCodecId);
    L6:
        if (r100.equals("format_type") == false) goto L4;
        r101 = 25;
        goto L109
    L10:
        if (r100.equals(ITTVideoEngineEventSource.KEY_HW_USER) == false) goto L4;
        r101 = 24;
        goto L109
    L14:
        if (r100.equals(ITTVideoEngineEventSource.KEY_INITIAL_URL) == false) goto L4;
        r101 = 23;
        goto L109
    L18:
        if (r100.equals(ITTVideoEngineEventSource.KEY_ENGINE_STATE) == false) goto L4;
        r101 = 22;
        goto L109
    L22:
        if (r100.equals(ITTVideoEngineEventSource.KEY_CUR_PLAY_POS) == false) goto L4;
        r101 = 21;
        goto L109
    L26:
        if (r100.equals("width") == false) goto L4;
        r101 = 20;
        goto L109
    L30:
        if (r100.equals("codec") == false) goto L4;
        r101 = 19;
        goto L109
    L34:
        if (r100.equals("device_id") == false) goto L4;
        r101 = 18;
        goto L109
    L38:
        if (r100.equals(ITTVideoEngineEventSource.KEY_CHIPBOARD) == false) goto L4;
        r101 = 17;
        goto L109
    L42:
        if (r100.equals(ITTVideoEngineEventSource.KEY_MUTE) == false) goto L4;
        r101 = 16;
        goto L109
    L46:
        if (r100.equals("tag") == false) goto L4;
        r101 = 15;
        goto L109
    L50:
        if (r100.equals(ITTVideoEngineEventSource.KEY_VIDEO_DURATION) == false) goto L4;
        r101 = 14;
        goto L109
    L54:
        if (r100.equals("hw") == false) goto L4;
        r101 = HTTP.CR;
        goto L109
    L58:
        if (r100.equals("cp") == false) goto L4;
        r101 = 12;
        goto L109
    L62:
        if (r100.equals(ITTVideoEngineEventSource.KEY_RADIO_MODE) == false) goto L4;
        r101 = 11;
        goto L109
    L66:
        if (r100.equals("source_type") == false) goto L4;
        r101 = 10;
        goto L109
    L70:
        if (r100.equals("cold_start") == false) goto L4;
        r101 = 9;
        goto L109
    L74:
        if (r100.equals(ITTVideoEngineEventSource.KEY_VOLUME) == false) goto L4;
        r101 = 8;
        goto L109
    L78:
        if (r100.equals(ITTVideoEngineEventSource.KEY_SUBTAG) == false) goto L4;
        r101 = 7;
        goto L109
    L82:
        if (r100.equals(ITTVideoEngineEventSource.KEY_AUDIO_CODEC_NAME_ID) == false) goto L4;
        r101 = 6;
        goto L109
    L86:
        if (r100.equals("height") == false) goto L4;
        r101 = 5;
        goto L109
    L90:
        if (r100.equals(ITTVideoEngineEventSource.KEY_VIDEO_CODEC_NAME_ID) == false) goto L4;
        r101 = 4;
        goto L109
    L94:
        if (r100.equals("async_init") == false) goto L4;
        r101 = 3;
        goto L109
    L98:
        if (r100.equals(ITTVideoEngineEventSource.KEY_ASYNC_CODEC_ID) == false) goto L4;
        r101 = 2;
        goto L109
    L102:
        if (r100.equals("render_type") == false) goto L4;
        r101 = 1;
        goto L109
    L106:
        if (r100.equals(ITTVideoEngineEventSource.KEY_CHIPHARDWARE) == true) goto L109;
        goto L4
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public int getIntOption(int r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        int r102 = -1;
        if (r100 == 480) goto L84;
        switch(r100) {
            case 43: goto L53;
            case 44: goto L48;
            case 45: goto L43;
            case 46: goto L38;
            case 47: goto L79;
            case 48: goto L29;
            case 49: goto L22;
            case 50: goto L74;
            case 51: goto L73;
            case 52: goto L17;
            case 53: goto L14;
            case 54: goto L68;
            case 55: goto L67;
            case 56: goto L66;
            case 57: goto L65;
            default: goto L7;
        };
    L14:
        IPlayDurationManager r103 = this.mPlayDuration;     // Catch: Throwable -> L57
        if (r103 != null) goto L70;
        return -1;
    L70:
        return r103.getPlayedDuration();
    L17:
        if (r101 != null) goto L72;
    L71:
        return 0;
    L72:
        return r101.getCurrentPosition();
    L22:
        Context r104 = this.mContext;     // Catch: Throwable -> L57
        if (r104 == null) goto L75;
        AudioManager r105 = (AudioManager) r104.getSystemService("audio");     // Catch: Throwable -> L57
        if (r105 == null) goto L27;
        r102 = r105.getStreamVolume(3);     // Catch: Throwable -> L57
    L27:
        if (r102 < 0) goto L71;
        return r102;
    L75:
        return -1;
    L29:
        Context r106 = this.mContext;     // Catch: Throwable -> L57
        if (r106 == null) goto L77;
        AudioManager r107 = (AudioManager) r106.getSystemService("audio");     // Catch: Throwable -> L57
        if (r107 == null) goto L34;
        r102 = r107.getStreamMaxVolume(3);     // Catch: Throwable -> L57
    L34:
        if (r102 < 0) goto L71;
        return r102;
    L77:
        return -1;
    L7:
        if (this.mConfigCenterVersion > 0) goto L9;
        return -1;
    L9:
        return this.mEngineConfig.getIntOption(r100);
    L65:
        return this.mState;
    L66:
        return this.mLoadState;
    L67:
        return this.mPlaybackState;
    L68:
        return this.mBufferingType;
    L73:
        return this.mLoadedProgress;
    L74:
        return this.mDuration;
    L79:
        return this.mPlayerType;
    L38:
        if (this.mAudioCodecID >= 0) goto L80;
        if (r101 == null) goto L80;
        this.mAudioCodecID = r101.getIntOption(140, -1);     // Catch: Throwable -> L57
    L80:
        return this.mAudioCodecID;
    L43:
        if (this.mVideoCodecID >= 0) goto L81;
        if (r101 == null) goto L81;
        this.mVideoCodecID = r101.getIntOption(141, -1);     // Catch: Throwable -> L57
    L81:
        return this.mVideoCodecID;
    L48:
        if (this.mAudioCodecType >= 0) goto L82;
        if (r101 == null) goto L82;
        this.mAudioCodecType = r101.getIntOption(158, -1);     // Catch: Throwable -> L57
    L82:
        return this.mAudioCodecType;
    L53:
        if (this.mVideoCodecType >= 0) goto L83;
        if (r101 == null) goto L83;
        this.mVideoCodecType = r101.getIntOption(157, -1);     // Catch: Throwable -> L57
    L83:
        return this.mVideoCodecType;
    L84:
        return this.mRadioModeEnable;
    L57:
        th = move-exception;
        TTVideoEngineInternalLog.d(th);
        return -1;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public long getLongOption(int r100) {
        if (this.mConfigCenterVersion > 0) goto L5;
        return -1;
    L5:
        return this.mEngineConfig.getLongOption(r100);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public boolean isPlayerType(int r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 == null) goto L5;
        int r102 = transMediaPlayerType(r101.getPlayerType());
    L6:
        if (r102 != r100) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = this.mPlayerType;
        goto L6
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIsMute(boolean r100) {
        TTVideoEngineInternalLog.i(logcatTag(), String.format("setIsMute:%s", new Object[]{Boolean.valueOf(r100)}));
        this.mIsMute = r100;
        setPlayerMute(r100);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLooping(boolean r100) {
        TTVideoEngineInternalLog.i(logcatTag(), "setLooping:" + r100);
        this.mLooping = r100;
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setPlaybackParams(PlaybackParams r100) {
        this.mPlaybackParams = r100;
        if (this.mMediaPlayer == null) goto L17;
        if (isOSPlayer() == true) goto L7;
    L11:
        this.mMediaPlayer.setPlaybackParams(r100);     // Catch: NullPointerException -> L13
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        return;
    L9:
        if (this.mPrepared == true) goto L11;
        return;
    L18:
        return;
    }

    public void setPlayerMute(boolean r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isOSPlayer() == false) goto L13;
        if (r100 == false) goto L8;
        float r102 = 0.0f;
    L15:
        r101.setVolume(r102, r102);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        TTVideoEngineInternalLog.d(e);
        return;
    L8:
        r102 = 1.0f;
        goto L15
    L13:
        r101.setIsMute(r100);
    }

    public void setSourceType(int r100) {
        switch(r100) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L20;
        };
    L4:
        this.mSourceTypeStr = "mds";
        return;
    L5:
        this.mSourceTypeStr = "fd";
        return;
    L6:
        this.mSourceTypeStr = "vid";
        return;
    L7:
        this.mSourceTypeStr = "feed";
        return;
    L8:
        this.mSourceTypeStr = "preload";
        return;
    L9:
        this.mSourceTypeStr = "playitem";
        return;
    L10:
        this.mSourceTypeStr = "dir_url";
        return;
    L11:
        this.mSourceTypeStr = "local_url";
        return;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setSubTag(String r100) {
        TTVideoEngineInternalLog.i(logcatTag(), "setSubTag: " + r100);
        this.mSubTag = r100;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setTag(String r100) {
        TTVideoEngineInternalLog.i(logcatTag(), "setTag: " + r100);
        this.mTag = r100;
    }

    public void updateConfigParams(Map<Integer, Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
        if (this.mPlayerType != 1) goto L7;
        int r102 = 1;
    L8:
        r100.put(2, Integer.valueOf(r102));
        int r103 = this.mPlayerType;
        if (r103 == 2) goto L12;
        if (r103 == 5) goto L12;
        int r104 = 1;
    L13:
        r100.put(1, Integer.valueOf(r104));
        HashMap<Integer, Integer> r105 = this.mConfigParams;
        if (this.mPlayerType != 5) goto L16;
        r101 = 1;
    L16:
        r105.put(26, Integer.valueOf(r101));
        r100.put(11, Integer.valueOf(this.mForbidOSPlayer));
        r100.put(100, Integer.valueOf(this.mConfigParamsOption));
        r100.put(43, Integer.valueOf(this.mDisableThreadPoolUsing));
        if (getConfigInt(85, this.mFallbackExoFirst) < 0) goto L20;
        r100.put(27, Integer.valueOf(getConfigInt(85, this.mFallbackExoFirst)));
        return;
    L20:
        return;
    L12:
        r104 = 0;
        goto L13
    L7:
        r102 = 0;
        goto L8
    }

    public static int transMediaPlayerType(MediaPlayer r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.getPlayerType();
        if (r101 == 0) goto L18;
        if (r101 == 2) goto L16;
        int r102 = 3;
        if (r101 == 3) goto L15;
        r102 = 4;
        if (r101 == 4) goto L15;
        r102 = 5;
        if (r101 == 5) goto L15;
        return 0;
    L15:
        return r102;
    L16:
        return 1;
    L18:
        return 2;
    }

    public float getConfigFloat(int r100, float r101) {
        if (this.mConfigCenterVersion > 0) goto L5;
        return r101;
    L5:
        return this.mEngineConfig.getFloatOption(r100);
    }

    public int getConfigInt(int r100, int r101) {
        if (this.mConfigCenterVersion > 0) goto L5;
        return r101;
    L5:
        return this.mEngineConfig.getIntOption(r100);
    }

    public String getConfigString(int r100, String r101) {
        if (this.mConfigCenterVersion > 0) goto L5;
        return r101;
    L5:
        return this.mEngineConfig.getStringOption(r100);
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void initEngine(Context r100, int r101) {
        this.mContext = r100;
        this.mPlayerType = r101;
        this.mConfigParams = new HashMap();
        this.mIsMute = false;
        this.mIsColdStart = sIsColdStart;
        sIsColdStart = 0;
        TTPlayerConfiger.setValue(6, false);
        boolean r102 = true;
        if (r101 == 2) goto L6;
        if (r101 == 5) goto L6;
        int r103 = 1;
    L7:
        TTPlayerConfiger.setValue(1, r103);
        if (r101 != 1) goto L10;
        boolean r104 = true;
    L11:
        TTPlayerConfiger.setValue(2, r104);
        if (r101 == 5) goto L15;
        r102 = false;
    L15:
        TTPlayerConfiger.setValue(26, r102);
        TTPlayerConfiger.setValue(11, false);
        TTPlayerConfiger.setValue(4, false);
        return;
    L10:
        r104 = false;
    L6:
        r103 = 0;
        goto L7
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setFloatOption(int r100, float r101) {
        if (this.mConfigCenterVersion <= 0) goto L6;
        this.mPlayerConfigExecutor.execute(this.mEngineConfig.setFloatOption(r100, r101));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setIntOption(int r100, int r101) {
        if (r100 != 3) goto L5;
        this.mForbidOSPlayer = r101;
        TTPlayerConfiger.setValue(11, r101);
        return;
    L5:
        if (r100 != 7) goto L7;
        this.mHardwareDecodeEnablePlayer2 = r101;
        TTVideoEngineInternalLog.i(logcatTag(), "hardware enable = " + this.mHardwareDecodeEnablePlayer2);
        MediaPlayer r102 = this.mMediaPlayer;
        if (r102 == null) goto L106;
        r102.setIntOption(59, r101);
        return;
    L106:
        return;
    L7:
        if (r100 == 85) goto L72;
        boolean r103 = 0;
        boolean r104 = false;
        if (r100 != 100) goto L11;
        if (r101 == 0) goto L69;
        r103 = 1;
    L69:
        this.mIsStartPlayAutomatically = r103;
        MediaPlayer r105 = this.mMediaPlayer;
        if (r105 == null) goto L103;
        r105.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, !r103);
        return;
    L103:
        return;
    L11:
        if (r100 != 117) goto L13;
        TTPlayerConfiger.setValue(4, r101);
        return;
    L13:
        if (r100 != 340) goto L15;
        this.mDisableResetSystemVolume = r101;
        MediaPlayer r106 = this.mMediaPlayer;
        if (r106 == null) goto L100;
        r106.setIntOption(98, r101);
        return;
    L100:
        return;
    L15:
        if (r100 != 415) goto L17;
        this.mSetTrackVolume = r101;
        MediaPlayer r107 = this.mMediaPlayer;
        if (r107 == null) goto L98;
        r107.setIntOption(94, r101);
        return;
    L98:
        return;
    L17:
        if (r100 != 480) goto L19;
        this.mRadioModeEnable = r101;
        this.mLastSwitchRadioModeTime = System.currentTimeMillis();
        MediaPlayer r108 = this.mMediaPlayer;
        if (r108 == null) goto L96;
        r108.setIntOption(261, r101);
        return;
    L96:
        return;
    L19:
        if (r100 != 5010) goto L21;
        if (r101 == 0) goto L56;
        r104 = true;
    L56:
        this.mExoEnableNativeMdl = r104;
        return;
    L21:
        if (r100 != 27) goto L23;
        this.mCleanWhenStop = r101;
        return;
    L23:
        if (r100 != 28) goto L25;
        this.mMaxAccumulatedCountSetByUser = r101;
        return;
    L25:
        switch(r100) {
            case 5001: goto L47;
            case 5002: goto L42;
            case 5003: goto L37;
            case 5004: goto L32;
            case 5005: goto L27;
            default: goto L108;
        };
    L27:
        this.mExoAllowMediaCodecHelper = r101;
        MediaPlayer r109 = this.mMediaPlayer;
        if (r109 != null) goto L30;
        return;
    L30:
        if (r109.getPlayerType() != 5) goto L79;
        this.mMediaPlayer.setIntOption(ITTVideoEngineInternal.PLAYER_OPTION_EXO_ALLOW_MEDIACODECHELPER, r101);
        return;
    L79:
        return;
    L32:
        this.mExoCodecAsyncInitEnable = r101;
        MediaPlayer r110 = this.mMediaPlayer;
        if (r110 != null) goto L35;
        return;
    L35:
        if (r110.getPlayerType() != 5) goto L82;
        this.mMediaPlayer.setIntOption(ITTVideoEngineInternal.PLAYER_OPTION_EXO_CODEC_ASYNC_INIT_ENABLE, r101);
        return;
    L82:
        return;
    L37:
        this.mExoCodecReusable = r101;
        MediaPlayer r111 = this.mMediaPlayer;
        if (r111 != null) goto L40;
        return;
    L40:
        if (r111.getPlayerType() != 5) goto L85;
        this.mMediaPlayer.setIntOption(5003, r101);
        return;
    L85:
        return;
    L42:
        this.mExoConsecutiveFailNum = r101;
        MediaPlayer r112 = this.mMediaPlayer;
        if (r112 != null) goto L45;
        return;
    L45:
        if (r112.getPlayerType() != 5) goto L88;
        this.mMediaPlayer.setIntOption(5002, r101);
        return;
    L88:
        return;
    L47:
        this.mExoRenderReadyMs = r101;
        MediaPlayer r113 = this.mMediaPlayer;
        if (r113 != null) goto L50;
        return;
    L50:
        if (r113.getPlayerType() != 5) goto L91;
        this.mMediaPlayer.setIntOption(5001, r101);
        return;
    L91:
        return;
    L108:
        return;
    L72:
        this.mFallbackExoFirst = r101;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setLongOption(int r100, long r101) {
        if (this.mConfigCenterVersion <= 0) goto L6;
        this.mPlayerConfigExecutor.execute(this.mEngineConfig.setLongOption(r100, r101));
        return;
    }

    public void setPlayerVolume(float r100, float r101) {
        MediaPlayer r102 = this.mMediaPlayer;
        if (r102 != null) goto L6;
        return;
    L6:
        if (getConfigInt(415, this.mSetTrackVolume) == 0) goto L8;
    L17:
        r102.setVolume(r100, r101);
        return;
    L8:
        if (isInHousePlayer() == true) goto L17;
        if (r100 == 0.0f) goto L12;
        float r103 = 1.0f;
        float r104 = 1.0f;
    L13:
        AudioManager r105 = (AudioManager) this.mContext.getSystemService("audio");
        if (r105 == null) goto L16;
        r105.setStreamVolume(3, (int) r100, 0);
    L16:
        r100 = r103;
        r101 = r104;
        goto L17
    L12:
        r104 = r101;
        r103 = r100;
        goto L13
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setStringOption(int r100, String r101) {
        if (r100 != 5000) goto L5;
        MediaPlayer r102 = this.mMediaPlayer;
        if (r102 != null) goto L10;
    L12:
        this.mExoLoadControlParameters = r101;
        return;
    L10:
        if (r102.getPlayerType() != 5) goto L12;
        this.mMediaPlayer.setStringOption(5000, r101);
        goto L12
    L5:
        if (this.mConfigCenterVersion <= 0) goto L14;
        this.mPlayerConfigExecutor.execute(this.mEngineConfig.setStringOption(r100, r101));
        return;
    }

    @Override // com.ss.ttvideoengine.ITTVideoEngineInternal
    public void setVolume(float r100, float r101) {
        TTVideoEngineInternalLog.i(logcatTag(), "setVolume left:" + r100 + " right:" + r101);
        this.mLeftVolume = r100;
        this.mRightVolume = r101;
        setPlayerVolume(r100, r101);
    }
}
