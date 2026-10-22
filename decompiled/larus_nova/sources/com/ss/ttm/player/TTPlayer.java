package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.InitConfig;
import com.ss.ttm.utils.OnceConfig;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayer {
    private static final String TAG = "TTPlayerJava";
    private static String mAppPath;
    private static String mCachePath;
    private static String mCrashPath;
    private static ILibraryLoader mDebugLibLoader;
    private static boolean mIsIPCPlayer;
    private static boolean mSetLibraryLoader;
    private static int mSupportSampleRateNB;
    private static int[] mSupportSampleRates;
    private static String playerLibName;
    private Context mContext;
    private FrameMetadataListener mFrameMetadataListener;
    private long mHandle;
    private long mId;
    private long mMediaDataSource;
    private IPlayerNotifyer mNotifyer;
    private MediaPlayer.OnScreenshotListener mScreenshotListener;
    private StrategyParamsTransport mStrategyParamsTransport;
    private int mTracker;

    public static class DefaultLibraryLoader implements ILibraryLoader {
        boolean mLoadLibraryPath;

        public static /* synthetic */ void access$000(String r100) {
            System.loadLibrary(r100);
        }

        public DefaultLibraryLoader(boolean r100) {
            this.mLoadLibraryPath = r100;
        }

        @JvmStatic
        public static void INVOKESTATIC_com_ss_ttm_player_TTPlayer$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> r100) {
            Iterator<String> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L14;
            String r102 = r101.next();
            if (this.mLoadLibraryPath == true) goto L8;
            INVOKESTATIC_com_ss_ttm_player_TTPlayer$DefaultLibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r102);     // Catch: Throwable -> L11
            goto L4
        L8:
            System.load(r102);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            AVLogger.Error(TTPlayer.TAG, this, "load lib failed = " + th.getMessage());
            return false;
        L14:
            return true;
        }
    }

    private static final native void _close(long r100);

    private final native long _create(Context r100, long r101, String r102);

    private static final native String _getAppPath();

    private static final native int _getCurrentPosition(long r100);

    private static final native long _getDemuxerFactory(int r100);

    private static final native double _getDoubleValue(long r100, int r101, double r102);

    private static final native int _getDuration(long r100);

    private static final native float _getFloatValue(long r100, int r101, float r102);

    private static final native int _getIntValue(long r100, int r101, int r102);

    private static final native Object _getJObjectValue(long r100, int r101);

    private static final native long _getLongValue(long r100, int r101, long r102);

    private static final native Object[] _getStreamInfo(long r100);

    private static final native String _getStringValue(long r100, int r101);

    private static final native String _getSubtitleContent(long r100, int r101);

    private static final native int _getVideoHeight(long r100);

    private static final native int _getVideoWidth(long r100);

    private static final native int _isLooping(long r100);

    private static final native int _isPlaying(long r100);

    private static final native void _mouseEvent(long r100, int r101, int r102, int r103);

    private static final native int _pause(long r100);

    private static final native int _preDemux(long r100);

    private static final native int _prepare(long r100);

    private static final native int _registerNativeMdl(long r100);

    private static final native void _registerPlayerInfo();

    private static final native void _release(long r100);

    private static final native int _reset(long r100);

    private static final native void _rotateCamera(long r100, float r101, float r102);

    private static final native int _seek(long r100, int r101);

    private static final native int _seek2(long r100, int r101, int r102);

    private static final native void _setABRStrategy(long r100, ABRStrategy r101);

    private static final native void _setAIBarrageInfo(long r100, MaskInfo r101);

    private static final native void _setAudioProcessor(long r100, AudioProcessor r101);

    private static final native void _setDataSource(long r100, IMediaDataSource r101);

    private static final native void _setDataSource(long r100, String r101);

    private static final native void _setDataSourceFd(long r100, int r101);

    private static final native int _setDoubleValue(long r100, int r101, double r102);

    private static final native int _setFloatValue(long r100, int r101, float r102);

    private static final native int _setFloatValueArray(long r100, int[] r101, float[] r102);

    private static final native void _setGlobalIntForKey(int r100, int r101);

    private static final native void _setGlobalStringForKey(int r100, String r101);

    private static final native int _setIntValue(long r100, int r101, int r102);

    private static final native int _setIntValueArray(long r100, int[] r101, int[] r102);

    private static final native void _setLoadControl(long r100, LoadControl r101);

    private static final native int _setLongValue(long r100, int r101, long r102);

    private static final native int _setLongValueArray(long r100, int[] r101, long[] r102);

    private static final native void _setLooping(long r100, int r101);

    private static final native void _setMaskInfo(long r100, MaskInfo r101);

    private static final native void _setMediaTransport(long r100, MediaTransport r101);

    private static final native int _setStringValue(long r100, int r101, String r102);

    private static final native int _setStringValueArray(long r100, int[] r101, String[] r102);

    private static final native void _setSubInfo(long r100, SubInfo r101);

    private static final native void _setSupportFormatNB(int r100);

    private static final native void _setSupprotSampleRates(int[] r100, int r101);

    private static final native int _setSurfaceValue(long r100, long r101);

    private static final native void _setTraitObject(long r100, int r101, int r102, TraitObject r103);

    private static final native int _setVideoSurface(long r100, Surface r101);

    private static final native int _setVideoSurfaceTimeout(long r100, Surface r101, int r102);

    private static final native void _setVolume(long r100, float r101, float r102);

    private static final native int _setupMediaCodec(long r100);

    private static final native int _start(long r100);

    private static final native void _stop(long r100);

    private static final native void _switchStream(long r100, int r101, int r102);

    private static final native void _takeScreenshot(long r100);

    private static final void checkPlayerModel() {
    }

    static {
        mDebugLibLoader = new DefaultLibraryLoader(true);
        playerLibName = "";
        monitor-enter(TTPlayer.class);
        TTPlayerLibLoader.loadLibrary();     // Catch: Throwable -> L14
        playerLibName = TTPlayerLibLoader.getPlayerLibName();     // Catch: Throwable -> L14
        detectAudioFormat();     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L14
        monitor-exit(TTPlayer.class);     // Catch: Throwable -> L14
        return;
    L8:
        e = move-exception;
        String r100 = TTPlayerLibLoader.getErrorInfo();     // Catch: Throwable -> L14
        if (r100 != null) goto L12;
        throw e;     // Catch: Throwable -> L14
    L12:
        throw new UnsatisfiedLinkError(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static void detectAudioFormat() {
        if (mSupportSampleRateNB != 0) goto L6;
        int[] r100 = new int[AudioFormats.getDefaultSampleRatesNB()];
        mSupportSampleRates = r100;
        int r101 = AudioFormats.getMaxSupportedSampleRates(r100);
        mSupportSampleRateNB = r101;
        _setSupprotSampleRates(mSupportSampleRates, r101);
        return;
    }

    public static int getThreadPoolStackSize() {
        return TTPlayerConfiger.getValue(25, 32);
    }

    public static int getVC2DecPoolSize() {
        return TTPlayerConfiger.getValue(42, 0);
    }

    public static int getVC2StackSizeValue() {
        return TTPlayerConfiger.getValue(40, 0);
    }

    public static int getVC2ThreadPriorityValue() {
        return TTPlayerConfiger.getValue(35, 0);
    }

    public static int isEnableVC2DecPool() {
        return TTPlayerConfiger.getValue(41, false) ? 1 : 0;
    }

    public static int isEnableVC2ThreadPriority() {
        return TTPlayerConfiger.getValue(34, false) ? 1 : 0;
    }

    public static int isEnableVC2ThreadPriorityLite() {
        return TTPlayerConfiger.getValue(36, false) ? 1 : 0;
    }

    public static boolean isIPPlayer() {
        return mIsIPCPlayer;
    }

    public static int isUseThreadV2() {
        return TTPlayerConfiger.getValue(38, 0);
    }

    public static int isUsedThreadPool() {
        return TTPlayerConfiger.getValue(24, false) ? 1 : 0;
    }

    public static int isVC2StackSizeOpt() {
        return TTPlayerConfiger.getValue(39, 0);
    }

    public int close() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        _close(r100);
        return 0;
    }

    public StreamInfo[] getStreamInfo() {
        return (StreamInfo[]) _getStreamInfo(this.mHandle);
    }

    public MediaPlayer.TrackInfo[] getTrackInfo() {
        StreamInfo[] r100 = (StreamInfo[]) _getStreamInfo(this.mHandle);
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length == 0) goto L14;
        int r101 = r100.length;
        MediaPlayer.TrackInfo[] r102 = new MediaPlayer.TrackInfo[r101];
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L10;
        r102[r103] = r100[r103].convertToTrackInfo();
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    L14:
        return null;
    }

    public int pause() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _pause(r100);
    }

    public int preDemux() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _preDemux(r100);
    }

    public int prepare() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _prepare(r100);
    }

    public int prevClose() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        _setVideoSurface(r100, null);
        return 0;
    }

    public void release() {
        AVLogger.InfoTrackLife(TAG, this, String.format(Locale.US, "release TTPlayer:%x", new Object[]{Long.valueOf(this.mHandle)}));
        long r100 = this.mHandle;
        if (r100 == 0) goto L5;
        _release(r100);
        this.mHandle = 0;
    L5:
        this.mNotifyer = null;
        this.mScreenshotListener = null;
    }

    public int reset() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _reset(r100);
    }

    public int setupMediaCodec() {
        return _setupMediaCodec(this.mHandle);
    }

    public int start() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return _start(r100);
    }

    public int stop() {
        long r100 = this.mHandle;
        if (r100 == 0) goto L6;
        _stop(r100);
        return 0;
    L6:
        return -1;
    }

    public void takeScreenshot() {
        _takeScreenshot(this.mHandle);
    }

    public static final String getAppPath() {
        return mAppPath;
    }

    public static final String getCachePath() {
        return mCachePath;
    }

    public static final String getCrashPath() {
        return mCrashPath;
    }

    public static void registerPlayerInfo() {
        _registerPlayerInfo();
    }

    public Context getContext() {
        return this.mContext;
    }

    public final long getHandle() {
        return this.mHandle;
    }

    public long getNativePlayer() {
        return this.mHandle;
    }

    public static int getAudioTrackPoolSize(int r100) {
        AudioTrackPool r101 = AudioTrackPool.getInstance();
        int r102 = r101.getAudioTrackPoolSize();
        if (r100 <= 0) goto L6;
        if (r102 != 0) goto L6;
        r101.preBuild();
    L6:
        return r102;
    }

    public static long getDemuxerFactory(int r100) {
        return _getDemuxerFactory(r100);
    }

    public static int registerNativeMdl(long r100) {
        return _registerNativeMdl(r100);
    }

    public static final void setCachePath(String r100) {
        mCachePath = r100;
    }

    public static final void setCrashPath(String r100) {
        mCrashPath = r100;
    }

    public static void setIsIPPlayer(boolean r100) {
        mIsIPCPlayer = r100;
    }

    public static final void setTempFileDir(String r100) {
        mAppPath = r100;
    }

    public Object getObjectValue(int r100) {
        return _getJObjectValue(this.mHandle, r100);
    }

    public String getStrategyParams(String r100) {
        StrategyParamsTransport r101 = this.mStrategyParamsTransport;     // Catch: Throwable -> L7
        if (r101 == null) goto L12;
        return r101.getStrategyParams(r100);
    L12:
        return "none";
    L7:
        th = move-exception;
        th.printStackTrace();
        return "none";
    }

    public String getStringOption(int r100) {
        if (r100 != 1095) goto L7;
        return playerLibName;
    L7:
        return _getStringValue(this.mHandle, r100);
    }

    public String getSubtitleContent(int r100) {
        return _getSubtitleContent(this.mHandle, r100);
    }

    public void receiveBinarySei(ByteBuffer r100) {
        FrameMetadataListener r101 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.receiveBinarySei(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void seekTo(int r100) {
        _seek(this.mHandle, r100);
    }

    public void setABRStrategy(ABRStrategy r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setABRStrategy(r101, r100);
        return;
    }

    public void setAIBarrageInfo(MaskInfo r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setAIBarrageInfo(r101, r100);
        return;
    }

    public void setAudioProcessor(AudioProcessor r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setAudioProcessor(r101, r100);
        return;
    }

    public void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, SecurityException, IllegalStateException {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setDataSource(r101, r100);
        return;
    }

    public void setDataSourceFd(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setDataSourceFd(r101, r100);
        return;
    }

    public void setFrameMetadataListener(FrameMetadataListener r100) {
        this.mFrameMetadataListener = r100;
    }

    public void setLoadControl(LoadControl r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setLoadControl(r101, r100);
        return;
    }

    public void setLooping(int r100) {
        _setLooping(this.mHandle, r100);
    }

    public void setMaskInfo(MaskInfo r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setMaskInfo(r101, r100);
        return;
    }

    public void setMediaTransport(MediaTransport r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setMediaTransport(r101, r100);
        return;
    }

    public void setNotifyer(IPlayerNotifyer r100) {
        this.mNotifyer = r100;
    }

    public void setNotifyerState(long r100) {
        _setIntValue(this.mHandle, 16, (int) r100);
    }

    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener r100) {
        this.mScreenshotListener = r100;
    }

    public void setStrategyParamsTransport(StrategyParamsTransport r100) {
        this.mStrategyParamsTransport = r100;
    }

    public void setSubInfo(SubInfo r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setSubInfo(r101, r100);
        return;
    }

    public int setSurfaceValue(long r100) {
        return _setSurfaceValue(this.mHandle, r100);
    }

    public int setVideoSurface(Surface r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L7;
        return -1;
    L7:
        return _setVideoSurface(r101, r100);
    }

    public final void takeScreenshotComplete(Bitmap r100) {
        MediaPlayer.OnScreenshotListener r101 = this.mScreenshotListener;
        if (r101 == null) goto L6;
        r101.onTakeScreenShotCompletion(r100);
        return;
    }

    public void setDataSource(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L6;
        _setDataSource(r101, r100);
        return;
    }

    private void create(long r100, InitConfig r101) throws Exception {
        this.mNotifyer = null;
        long r102 = _create(this.mContext, r101.nativeHandle(), mAppPath);
        this.mHandle = r102;
        AVLogger.InfoTrackLife(TAG, this, String.format(Locale.US, "create TTPlayer:%x", new Object[]{Long.valueOf(r102)}));
        this.mId = r100;
        if (this.mHandle == 0) goto L6;
        return;
    L6:
        throw new Exception("create native player is fail.");
    }

    public static final void setGlobalIntOptionForKey(int r100, int r101) {
        _setGlobalIntForKey(r100, r101);
    }

    public static final void setGlobalStringOptionForKey(int r100, String r101) {
        _setGlobalStringForKey(r100, r101);
    }

    public double getDoubleOption(int r100, double r101) {
        return _getDoubleValue(this.mHandle, r100, r101);
    }

    public float getFloatOption(int r100, float r101) {
        return _getFloatValue(this.mHandle, r100, r101);
    }

    public int getIntOption(int r100, int r101) {
        if (r100 == 11) goto L24;
        if (r100 == 51) goto L22;
        switch(r100) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            default: goto L8;
        };
    L8:
        return _getIntValue(this.mHandle, r100, r101);
    L10:
        return _isPlaying(this.mHandle);
    L12:
        return _isLooping(this.mHandle);
    L14:
        return _getVideoHeight(this.mHandle);
    L16:
        return _getVideoWidth(this.mHandle);
    L18:
        return _getCurrentPosition(this.mHandle);
    L20:
        return _getDuration(this.mHandle);
    L22:
        return this.mTracker;
    L24:
        return _getIntValue(this.mHandle, r100, r101);
    }

    public long getLongOption(int r100, long r101) {
        if (r100 != 50) goto L7;
        return this.mHandle;
    L7:
        return _getLongValue(this.mHandle, r100, r101);
    }

    public void onAbrDecisionInfo(long r100, String r101) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.onAbrDecisionInfo(r100, r101);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void rotateCamera(float r100, float r101) {
        _rotateCamera(this.mHandle, r100, r101);
    }

    public void seekTo(int r100, int r101) {
        _seek2(this.mHandle, r100, r101);
    }

    public int setDoubleOption(int r100, double r101) {
        return _setDoubleValue(this.mHandle, r100, r101);
    }

    public int setFloatOption(int r100, float r101) {
        return _setFloatValue(this.mHandle, r100, r101);
    }

    public int setFloatOptionArray(int[] r100, float[] r101) {
        return _setFloatValueArray(this.mHandle, r100, r101);
    }

    public int setIntOption(int r100, int r101) throws RemoteException {
        if (r100 != 111) goto L13;
        int[] r102 = TTPlayerKeys.SupportSampleRates;
        int r103 = r102.length;
        int[] r104 = new int[r102.length];
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r105 >= r103) goto L10;
        if (((1 << r105) & r101) != 0) goto L9;
        r104[r106] = TTPlayerKeys.SupportSampleRates[r105];
        r106 = r106 + 1;
    L9:
        r105 = r105 + 1;
        goto L5
    L10:
        _setSupprotSampleRates(r104, r106);
        return 0;
    L13:
        return _setIntValue(this.mHandle, r100, r101);
    }

    public int setIntOptionArray(int[] r100, int[] r101) {
        return _setIntValueArray(this.mHandle, r100, r101);
    }

    public int setLongOption(int r100, long r101) {
        return _setLongValue(this.mHandle, r100, r101);
    }

    public int setLongOptionArray(int[] r100, long[] r101) {
        return _setLongValueArray(this.mHandle, r100, r101);
    }

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
        AJProducerManager.setOnImageAvailableListener(this.mHandle, r100, r101);
    }

    public int setStringOption(int r100, String r101) {
        return _setStringValue(this.mHandle, r100, r101);
    }

    public int setStringOptionArray(int[] r100, String[] r101) {
        return _setStringValueArray(this.mHandle, r100, r101);
    }

    public void setTraitObject(int r100, TraitObject r101) {
        if (this.mHandle == 0) goto L9;
        if (r101 == null) goto L6;
        int r102 = r101.version();
    L7:
        _setTraitObject(this.mHandle, r100, r102, r101);
        return;
    L6:
        r102 = -1;
        goto L7
    }

    public int setVideoSurfaceTimeOut(Surface r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L7;
        return -1;
    L7:
        return _setVideoSurfaceTimeout(r102, r100, r101);
    }

    public void setVolume(float r100, float r101) {
        _setVolume(this.mHandle, r100, r101);
    }

    public void switchStream(int r100, int r101) {
        _switchStream(this.mHandle, r100, r101);
    }

    public TTPlayer(Context r100, long r101, OnceConfig r102) throws Exception {
        this.mTracker = 0;
        this.mContext = r100;
        create(r101, r102);
    }

    public void frameDTSNotify(int r100, long r101, long r110) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.frameDTSNotify(r100, r110, r101);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void mouseEvent(int r100, int r101, int r102) {
        _mouseEvent(this.mHandle, r100, r101, r102);
    }

    public final void onLogInfo(int r100, int r101, String r110) {
        IPlayerNotifyer r102 = this.mNotifyer;
        if (r102 == null) goto L9;
        r102.handleErrorNotify(this.mId, r100, r101, r110);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public void updateFrameTerminatedDTS(int r100, long r101, long r110) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.updateFrameTerminatedDTS(r100, r101, r110);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void didReceivePacket(int r100, long r101, long r110, Map<Integer, String> r111) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.didReceivePacket(r100, r101, r110, r111);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void onFrameAboutToBeRendered(int r100, long r101, long r110, Map<Integer, String> r111) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.onFrameAboutToBeRendered(r100, r101, r110, r111);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNotify(int r100, int r101, int r110, String r111) {
        IPlayerNotifyer r102 = this.mNotifyer;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.handlePlayerNotify(this.mId, r100, r101, r110, r111);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public void willRenderFrame(int r100, long r101, long r110, String r111) {
        FrameMetadataListener r102 = this.mFrameMetadataListener;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.willRenderFrame(r100, r101, r110, r111);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }
}
