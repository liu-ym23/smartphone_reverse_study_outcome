package com.ss.ttvideoengine;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.player.PlaybackParams;

/* JADX INFO: loaded from: classes34.dex */
public interface ITTVideoEngineInternal {
    public static final String CODEC_TYPE_BYTEVC1 = "bytevc1";
    public static final String CODEC_TYPE_BYTEVC2 = "bytevc2";
    public static final String CODEC_TYPE_H264 = "h264";
    public static final int ENGINE_STATE_ERROR = 4;
    public static final int ENGINE_STATE_FETCHING_INFO = 1;
    public static final int ENGINE_STATE_PARSING_DNS = 2;
    public static final int ENGINE_STATE_PLAYER_RUNNING = 3;
    public static final int ENGINE_STATE_RELEASE = 5;
    public static final int ENGINE_STATE_UNKNOWN = 0;
    public static final int KEY_IS_CONFIG_PARAMS_OPTION = 100;
    public static final int LOAD_STATE_ERROR = 3;
    public static final int LOAD_STATE_PLAYABLE = 1;
    public static final int LOAD_STATE_STALLED = 2;
    public static final int LOAD_STATE_UNKNOWN = 0;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;
    public static final int PLAYER_DECODER_BUFFERING = 1;
    public static final int PLAYER_DEGRADE_MODE_LITE = 0;
    public static final int PLAYER_DEGRADE_MODE_OS = 1;
    public static final int PLAYER_MAX_ACCUMULATED_COUNT = 30;
    public static final int PLAYER_NET_BUFFERING = 0;
    public static final int PLAYER_OPTION_CLEAN_WHEN_STOP = 27;
    public static final int PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME = 340;
    public static final int PLAYER_OPTION_ENABEL_HARDWARE_DECODE = 7;
    public static final int PLAYER_OPTION_ENABLE_HARDWARE_DECODE = 7;
    public static final int PLAYER_OPTION_ENABLE_SEND_EVENT = 206;
    public static final int PLAYER_OPTION_ENABLE_START_AUTOMATICALLY = 100;
    public static final int PLAYER_OPTION_EXO_ALLOW_MEDIACODECHELPER = 5005;
    public static final int PLAYER_OPTION_EXO_CODEC_ASYNC_INIT_ENABLE = 5004;
    public static final int PLAYER_OPTION_EXO_CODEC_REUSABLE = 5003;
    public static final int PLAYER_OPTION_EXO_CONSECUTIVE_FAIL_NUM = 5002;
    public static final int PLAYER_OPTION_EXO_ENABLE_NATIVE_MDL = 5010;
    public static final int PLAYER_OPTION_EXO_LOADCONTROL_PARAMETERS = 5000;
    public static final int PLAYER_OPTION_EXO_RENDER_READY_MS = 5001;
    public static final int PLAYER_OPTION_FALLBACK_EXO_FIRST = 85;
    public static final int PLAYER_OPTION_FORBID_OS_PLAYER = 3;
    public static final int PLAYER_OPTION_GET_AUDIO_CODEC_ID = 46;
    public static final int PLAYER_OPTION_GET_AUDIO_CODEC_TYPE = 44;
    public static final int PLAYER_OPTION_GET_BUFFERING_TYPE = 54;
    public static final int PLAYER_OPTION_GET_CURRENT_PLAYBACK_TIME = 52;
    public static final int PLAYER_OPTION_GET_CURRENT_VOLUME = 49;
    public static final int PLAYER_OPTION_GET_DURATION = 50;
    public static final int PLAYER_OPTION_GET_ENGINE_STATE = 57;
    public static final int PLAYER_OPTION_GET_LOADED_PROGRESS = 51;
    public static final int PLAYER_OPTION_GET_LOADED_STATE = 56;
    public static final int PLAYER_OPTION_GET_MAX_VOLUME = 48;
    public static final int PLAYER_OPTION_GET_PLAYBACK_STATE = 55;
    public static final int PLAYER_OPTION_GET_PLAYER_TYPE = 47;
    public static final int PLAYER_OPTION_GET_VIDEO_CODEC_ID = 45;
    public static final int PLAYER_OPTION_GET_VIDEO_CODEC_TYPE = 43;
    public static final int PLAYER_OPTION_GET_WATCHED_DURATION = 53;
    public static final int PLAYER_OPTION_GET_WATCHED_DUTATION = 53;
    public static final int PLAYER_OPTION_OVERLAY_TOKEN_URL = 86;
    public static final int PLAYER_OPTION_OVERLAY_TYPE = 87;
    public static final int PLAYER_OPTION_RADIO_MODE = 480;
    public static final int PLAYER_OPTION_SET_MAX_ACCUMULATED_COUNT = 28;
    public static final int PLAYER_OPTION_SET_TRACK_VOLUME = 415;
    public static final int PLAYER_OPTION_THROW_CRASH = 117;
    public static final int PLAYER_TYPE_EXO = 5;
    public static final int PLAYER_TYPE_IP = 1;
    public static final int PLAYER_TYPE_IP_LITE = 4;
    public static final int PLAYER_TYPE_OS = 2;
    public static final int PLAYER_TYPE_OWN = 0;
    public static final int PLAYER_TYPE_OWN_LITE = 3;
    public static final int PLAY_CODEC_NAME_AN_HW = 2;
    public static final int PLAY_CODEC_NAME_AVC = 4;
    public static final int PLAY_CODEC_NAME_BYTEVC2 = 7;
    public static final int PLAY_CODEC_NAME_CPPBYTEVC1 = 8;
    public static final int PLAY_CODEC_NAME_CPPBYTEVC2 = 9;
    public static final int PLAY_CODEC_NAME_FFVIDEO = 3;
    public static final int PLAY_CODEC_NAME_IOS_HW = 1;
    public static final int PLAY_CODEC_NAME_JX = 6;
    public static final int PLAY_CODEC_NAME_KSC = 5;
    public static final int SOURCE_TYPE_DIRECT_URL = 1;
    public static final int SOURCE_TYPE_FEED = 4;
    public static final int SOURCE_TYPE_FILEDESCRIPTOR = 6;
    public static final int SOURCE_TYPE_LOCAL_URL = 0;
    public static final int SOURCE_TYPE_MEDIADATASOURCE = 7;
    public static final int SOURCE_TYPE_PLAYITEM = 2;
    public static final int SOURCE_TYPE_PRELOADITEM = 3;
    public static final int SOURCE_TYPE_SMARTURL = 8;
    public static final int SOURCE_TYPE_UNKNOWN = -1;
    public static final int SOURCE_TYPE_VID = 5;

    int getBufferingType();

    int getCurrentPlaybackTime();

    int getCurrentPlaybackTimeAsync();

    int getDuration();

    float getFloatOption(int r100);

    int getIntOption(int r100);

    int getLoadState();

    int getLoadedProgress();

    long getLongOption(int r100);

    int getPlaybackState();

    String getStringOption(int r100);

    Surface getSurface();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    int getWatchedDuration();

    void initEngine(Context r100, int r101);

    boolean isLooping();

    boolean isMute();

    boolean isOSPlayer();

    boolean isPlayerType(int r100);

    boolean isShouldPlay();

    boolean isStarted();

    void pause();

    void play();

    void prepare();

    void release();

    void releaseAsync();

    void resetEngine();

    void seekTo(int r100, SeekCompletionListener r101);

    void setAsyncInit(boolean r100, int r101);

    void setDirectURL(String r100);

    void setFloatOption(int r100, float r101);

    void setIntOption(int r100, int r101);

    void setIsMute(boolean r100);

    void setLocalURL(String r100);

    void setLongOption(int r100, long r101);

    void setLooping(boolean r100);

    void setPlaybackParams(PlaybackParams r100);

    void setStringOption(int r100, String r101);

    void setSubTag(String r100);

    void setSurface(Surface r100);

    void setSurfaceHolder(SurfaceHolder r100);

    void setTag(String r100);

    void setVolume(float r100, float r101);

    void start();

    void stop();
}
