package com.ss.ttm.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.ImageReader;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.net.AVResolver;
import com.ss.ttm.utils.AVErrorInfo;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.AVTime;
import com.ss.ttm.utils.OnceConfig;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerClient extends MediaPlayerClient implements Handler.Callback, ISurfaceListener {
    public static final int KEY_IS_CONFIG_PARAMS_OPTION = 100;
    private static final String TAG = null;
    private String mBufferingInfo;
    private TTSurfaceCallback mCallback;
    private int mCodecAndSurfaceReuse;
    private HashMap<Integer, Integer> mConfigParams;
    private boolean mConnectedCpu;
    private Context mContext;
    private int mCrashType;
    private final StringBuilder mCrashedInfo;
    private int mDisablePlayerStayAwake;
    private int mErrorCode;
    private Handler mHandler;
    private int mIgnoreSurfaceCreated;
    private LinkedList<String> mLogInfo;
    private MediaPlayer.OnLogListener mLogListener;
    private int mMediaCodecStopTimeOutMs;
    private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnExternInfoListener mOnExternInfoListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private MediaPlayer.onSARChangedListener mOnSARChangedListener;
    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private int mPlayLifeId;
    private ITTPlayerRef mPlayer;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private volatile boolean mRealsedSurface;
    private final ReentrantLock mReentrantLock;
    private final ReentrantLock mReentrantLockInRtc;
    private int mRtcPlay;
    private boolean mScreenOnWhilePlaying;
    private boolean mSeekComplete;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private String mUri;
    private String mVoiceInfo;
    private PowerManager.WakeLock mWakeLock;
    private MediaPlayer mWrapper;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    private String getPlayerErrorInfo() {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L24
        LinkedList<String> r101 = this.mLogInfo;     // Catch: Exception -> L24
        if (r101 == null) goto L8;
        if (r101.size() <= 0) goto L8;
    L11:
        AVErrorInfo.setupErrorInfo(this.mContext, r100, "error", "play error", this.mUri);     // Catch: Exception -> L24
        Iterator<String> r102 = this.mLogInfo.iterator();     // Catch: Exception -> L24
    L14:
        if (r102.hasNext() == false) goto L16;
        r100.append(r102.next());     // Catch: Exception -> L24
        r100.append("\n");     // Catch: Exception -> L24
        goto L14
    L16:
        String r103 = this.mBufferingInfo;     // Catch: Exception -> L24
        if (r103 == null) goto L19;
        r100.append(r103);     // Catch: Exception -> L24
        r100.append("\n");     // Catch: Exception -> L24
        this.mBufferingInfo = null;     // Catch: Exception -> L24
    L19:
        String r104 = this.mVoiceInfo;     // Catch: Exception -> L24
        if (r104 == null) goto L22;
        r100.append(r104);     // Catch: Exception -> L24
        r100.append("\n");     // Catch: Exception -> L24
        this.mVoiceInfo = null;     // Catch: Exception -> L24
    L22:
        return r100.toString();
    L8:
        if (this.mBufferingInfo != null) goto L11;
        if (this.mVoiceInfo == null) goto L22;
    L28:
        return null;
    }

    public void close() {
        this.mRealsedSurface = true;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.close();     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int r100) {
        if (r100 != 2) goto L5;
        return 1;
    L5:
        if (r100 != 1) goto L9;
        return 0;
    L9:
        if (r100 != 4) goto L11;
        return 2;
    L11:
        return -1;
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceChanged(SurfaceHolder r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prevClose() {
        this.mRealsedSurface = true;
        SurfaceHolder r100 = this.mSurfaceHolder;
        if (r100 == null) goto L5;
        r100.removeCallback(this.mCallback);
    L5:
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L7:
        if (isValid() == false) goto L9;
        this.mPlayer.prevClose();     // Catch: Throwable -> L11
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        this.mWriteLock.lock();
        ITTPlayerRef r100 = this.mPlayer;     // Catch: Throwable -> L22
        this.mPlayer = null;     // Catch: Throwable -> L22
        this.mPlayLifeId = -1;     // Catch: Throwable -> L22
        this.mWriteLock.unlock();
        if (r100 == null) goto L7;
        r100.release();
    L7:
        SurfaceHolder r101 = this.mSurfaceHolder;
        if (r101 == null) goto L10;
        r101.removeCallback(this.mCallback);
        this.mSurfaceHolder = null;
        this.mRealsedSurface = true;
    L10:
        Handler r102 = this.mHandler;
        if (r102 == null) goto L14;
        r102.removeCallbacksAndMessages(null);
        this.mHandler = null;
    L14:
        if (this.mLogListener == null) goto L20;
        String r103 = getPlayerErrorInfo();
        if (r103 == null) goto L20;
        if (r103.isEmpty() == true) goto L20;
        this.mLogListener.onLogInfo(this.mWrapper, r103);
    L20:
        this.mContext = null;
        return;
    L22:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        this.mRealsedSurface = true;
        SurfaceHolder r100 = this.mSurfaceHolder;
        if (r100 == null) goto L5;
        r100.removeCallback(this.mCallback);
    L5:
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L7:
        if (isValid() == false) goto L9;
        this.mPlayer.prevClose();     // Catch: Throwable -> L11
    L9:
        this.mReadLock.unlock();
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this), "TPlayerClient"));
    }

    static {
        TAG = "TTPlayerClient";
        TTVersion.saveVersionInfo();
    }

    private String getPlayerCrashedInfo() {
        int r100 = TTPlayerConfiger.getValue(18, 1);
        StringBuilder r101 = new StringBuilder();
        ITTPlayerRef r102 = this.mPlayer;
        if (r102 != null) goto L5;
        Context r103 = this.mContext;
    L6:
        if (r103 != null) goto L10;
        return "context is null";
    L10:
        if (r100 <= 1) goto L18;
        String r104 = TTCrashUtil.existsCrashFilePath(r103);
        if (r104 == null) goto L17;
        String r105 = TTCrashUtil.getCrashFileContext(r103, r104, r101);
        if (r105 == null) goto L17;
        TTCrashUtil.deleteCrashFile(this.mContext, r104);
        this.mCrashType = 1;
        TTPlayerConfiger.getValue(5, false);
        return r105;
    L17:
        AVErrorInfo.setupPhoneInfo(r103, r101);
    L18:
        String r106 = TTPlayerConfiger.getValue(19, null);
        if (r106 == null) goto L24;
        String r107 = TTCrashUtil.getCrashFileContext(this.mContext, r106, r101);
        if (r107 == null) goto L24;
        TTCrashUtil.deleteCrashFile(this.mContext, r106);
        this.mCrashType = 1;
        TTPlayerConfiger.getValue(5, false);
        return r107;
    L24:
        r101.append("\ncreate time:" + AVTime.getFormatNow());
        r101.append("\nport version:");
        r101.append(r100);
        r101.append("\nstart service info:");
        r101.append(TTPlayerConfiger.getValue(16, "not find service start info"));
        r101.append("\nstop service info:");
        r101.append(TTPlayerConfiger.getValue(12, "not find service stop info"));
        r101.append("\ncrash:");
        r101.append(TTPlayerConfiger.getValue(7, false));
        r101.append("\nsdk info:");
        r101.append(TTPlayerConfiger.getValue(15, "not find sdk info"));
        r101.append("\ntimeout count:");
        r101.append(TTPlayerConfiger.getValue(10, -1));
        r101.append("\nforeground:");
        r101.append(TTPlayerConfiger.getValue(21, -1));
        r101.append("\non screen:");
        r101.append(TTPlayerConfiger.getValue(22, -1));
        r101.append("\n battery info:");
        r101.append(TTPlayerConfiger.getValue(23, "not find"));
        r101.append("\nurl:");
        r101.append(this.mUri);
        r101.append("\ncrash:\r\n");
        r101.append(this.mCrashedInfo);
        this.mCrashType = 0;
        if (r100 <= 1) goto L32;
        if (TTPlayerConfiger.getValue(5, false) == true) goto L30;
    L30:
        return TTCrashUtil.getBase64SampleCrash(r101.toString());
    L32:
        return r101.toString();
    L5:
        r103 = r102.getContext();
        goto L6
    }

    private boolean isValid() {
        ITTPlayerRef r100 = this.mPlayer;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isValid() == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        this.mReadLock.lock();
        int r100 = 0;
        if (isValid() == false) goto L6;
        r100 = this.mPlayer.getIntOption(2, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r100;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        this.mReadLock.lock();
        int r100 = 0;
        if (isValid() == false) goto L6;
        r100 = this.mPlayer.getIntOption(1, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r100;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        MediaPlayer.TrackInfo[] r100 = this.mPlayer.getTrackInfo();     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r100;
    L7:
        r100 = null;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r100 = this.mPlayer.getType();     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r100;
    L7:
        r100 = 0;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        this.mReadLock.lock();
        int r100 = 0;
        if (isValid() == false) goto L6;
        r100 = this.mPlayer.getIntOption(4, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r100;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoType() {
        this.mReadLock.lock();
        int r100 = 0;
        if (isValid() == false) goto L6;
        r100 = this.mPlayer.getIntOption(11, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r100;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        this.mReadLock.lock();
        int r100 = 0;
        if (isValid() == false) goto L6;
        r100 = this.mPlayer.getIntOption(3, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r100;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        this.mReadLock.lock();
        boolean r100 = false;
        if (isValid() == false) goto L9;
        if (this.mPlayer.getIntOption(5, 0) != 1) goto L9;
        r100 = true;
    L9:
        this.mReadLock.unlock();
        return r100;
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isMute() {
        this.mReadLock.lock();
        boolean r100 = false;
        if (isValid() == false) goto L9;
        if (this.mPlayer.getIntOption(12, 0) != 1) goto L9;
        r100 = true;
    L9:
        this.mReadLock.unlock();
        return r100;
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        this.mReadLock.lock();
        boolean r100 = false;
        if (isValid() == false) goto L9;
        if (this.mPlayer.getIntOption(6, 0) != 1) goto L9;
        r100 = true;
    L9:
        this.mReadLock.unlock();
        return r100;
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.pause();     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        stayAwake(false);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void preDemux() {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.preDemux();     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L9;
        this.mErrorCode = 0;     // Catch: Throwable -> L11
        this.mLogInfo.clear();     // Catch: Throwable -> L11
        if (this.mRealsedSurface == false) goto L8;
        this.mPlayer.setSurfaceTimeOut(this.mSurfaceHolder.getSurface(), 0);     // Catch: Throwable -> L11
        this.mRealsedSurface = false;     // Catch: Throwable -> L11
    L8:
        this.mPlayer.prepare();     // Catch: Throwable -> L11
        updateLifeId();     // Catch: Throwable -> L11
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        this.mReadLock.lock();
    L13:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L11;
        this.mPlayer.reset();     // Catch: Throwable -> L13
        SurfaceHolder r100 = this.mSurfaceHolder;     // Catch: Throwable -> L13
        if (r100 != null) goto L8;
    L10:
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L13
        this.mErrorCode = 0;     // Catch: Throwable -> L13
        this.mLogInfo.clear();     // Catch: Throwable -> L13
        updateLifeId();     // Catch: Throwable -> L13
        goto L11
    L8:
        if (this.mCodecAndSurfaceReuse != 0) goto L10;
        this.mPlayer.setSurfaceTimeOut(r100.getSurface(), 0);     // Catch: Throwable -> L13
    L11:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setupMediaCodec() {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setupMediaCodec();     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.start();     // Catch: Throwable -> L8
        updateLifeId();     // Catch: Throwable -> L8
        this.mRtcPlay = this.mPlayer.getIntOption(800, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        stayAwake(true);
    }

    public void updateLifeId() {
        this.mReentrantLock.lock();     // Catch: Throwable -> L7
        this.mPlayLifeId = this.mPlayer.getLifeId();     // Catch: Throwable -> L7
        if (this.mReentrantLock.isLocked() == false) goto L14;
        this.mReentrantLock.unlock();
        return;
    L14:
        return;
    L7:
        th = move-exception;
        if (this.mReentrantLock.isLocked() == false) goto L11;
        this.mReentrantLock.unlock();
    L11:
        throw th;
    }

    public void updateSurfaceScreenOn() {
        SurfaceHolder r100 = this.mSurfaceHolder;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mDisablePlayerStayAwake == 0) goto L7;
        return;
    L7:
        if (this.mScreenOnWhilePlaying == true) goto L9;
    L11:
        boolean r101 = false;
    L12:
        r100.setKeepScreenOn(r101);
        return;
    L9:
        if (this.mStayAwake == false) goto L11;
        r101 = true;
        goto L12
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        this.mReadLock.lock();
    L15:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == true) goto L6;
    L13:
        this.mReadLock.unlock();
        stayAwake(false);
        return;
    L6:
        if (this.mConnectedCpu == true) goto L8;
    L12:
        this.mPlayer.stop();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (this.mCodecAndSurfaceReuse != 1) goto L12;
        SurfaceHolder r100 = this.mSurfaceHolder;     // Catch: Throwable -> L15
        if (r100 == null) goto L12;
        r100.removeCallback(this.mCallback);     // Catch: Throwable -> L15
        this.mSurfaceHolder = null;     // Catch: Throwable -> L15
        this.mPlayer.setSurfaceTimeOut(null, 0);     // Catch: Throwable -> L15
        this.mConnectedCpu = false;     // Catch: Throwable -> L15
        AVLogger.Warn(TAG, this, "testlog: mConnected Cpu " + this.mConnectedCpu);     // Catch: Throwable -> L15
        goto L12
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getDataSource() {
        return this.mUri;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        prepareAsync();
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100) {
        if (fna.g.d() == true) goto L6;
        r100.acquire();
        return;
    L6:
        r100.acquire();
        com.obric.performance.power.monitor.cpu.d.a(r100);
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
        if (fna.g.d() == true) goto L6;
        r100.release();
        return;
    L6:
        r100.release();
        com.obric.performance.power.monitor.cpu.d.b(r100);
    }

    public static /* synthetic */ ReentrantReadWriteLock.ReadLock access$000(TTPlayerClient r100) {
        return r100.mReadLock;
    }

    public static /* synthetic */ boolean access$100(TTPlayerClient r100) {
        return r100.isValid();
    }

    public static /* synthetic */ ITTPlayerRef access$200(TTPlayerClient r100) {
        return r100.mPlayer;
    }

    public static long getDemuxerFactory(int r100) {
        return TTPlayer.getDemuxerFactory(r100);
    }

    private void sendCompletioned(int r100) {
        this.mReentrantLock.lock();     // Catch: Throwable -> L11
        MediaPlayer.OnCompletionListener r101 = this.mOnCompletionListener;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        if (r100 < this.mPlayLifeId) goto L8;
        r101.onCompletion(this.mWrapper);     // Catch: Throwable -> L11
    L8:
        if (this.mReentrantLock.isLocked() == false) goto L18;
        this.mReentrantLock.unlock();
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (this.mReentrantLock.isLocked() == false) goto L15;
        this.mReentrantLock.unlock();
    L15:
        throw th;
    }

    private void sendSeekCompleted(int r100) {
        if (this.mSeekComplete == true) goto L10;
        MediaPlayer.OnSeekCompleteListener r101 = this.mOnSeekCompleteListener;
        if (r101 == null) goto L11;
        this.mSeekComplete = true;
        if (r100 < this.mPlayLifeId) goto L12;
        r101.onSeekComplete(this.mWrapper);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void stayAwake(boolean r100) {
        PowerManager.WakeLock r101 = this.mWakeLock;
        if (r101 == null) goto L12;
        if (r100 == true) goto L6;
    L8:
        if (r100 == true) goto L12;
        if (this.mWakeLock.isHeld() == false) goto L12;
        INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.mWakeLock);
        goto L12
    L6:
        if (r101.isHeld() == true) goto L8;
        INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.mWakeLock);
    L12:
        this.mStayAwake = r100;
        updateSurfaceScreenOn();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int r100) {
        this.mReadLock.lock();
        ITTPlayerRef r101 = this.mPlayer;
        if (r101 == null) goto L6;
        if (r100 != 0) goto L6;
        r101.setIntOption(261, 1);
    L8:
        this.mReadLock.unlock();
        return;
    L6:
        if (r101 == null) goto L8;
        r101.setIntOption(65, (r100 << 8) | 0);
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public Object getObjectOption(int r100) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        Object r101 = this.mPlayer.getObjectOption(r100);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getStringOption(int r100) {
        if (r100 == 5001) goto L5;
        String r101 = null;
        if (r100 != 5002) goto L15;
        LinkedList<String> r102 = this.mLogInfo;
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.size() != 0) goto L14;
        return null;
    L14:
        return getPlayerErrorInfo();
    L15:
        this.mReadLock.lock();
    L21:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L17:
        if (isValid() == false) goto L19;
        r101 = this.mPlayer.getStringOption(r100);     // Catch: Throwable -> L21
    L19:
        this.mReadLock.unlock();
        return r101;
    L5:
        return getPlayerCrashedInfo();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getSubtitleContent(int r100) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        String r101 = this.mPlayer.getSubtitleContent(r100);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100.what == 3) goto L5;
        ThreadMethodProxy.currentThread().getId();
    L5:
        int r101 = r100.arg2;
        int r102 = r100.what;
        int r103 = r100.arg1;
        Object r104 = r100.obj;
        if ((r104 instanceof String) == false) goto L8;
        String r105 = (String) r104;
    L9:
        handleNotify(r101, r102, r103, r105);
        if (r100.what == 3) goto L14;
        ThreadMethodProxy.currentThread().getId();
        return true;
    L14:
        return true;
    L8:
        r105 = null;
        goto L9
    }

    public void onCrashedInfo(String r100) {
        if (this.mCrashedInfo.length() >= 1024) goto L6;
        StringBuilder r101 = this.mCrashedInfo;
        r101.append(r100);
        r101.append("\n");
        return;
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceCreated(SurfaceHolder r100) {
        this.mSurfaceHolder = r100;
        if (this.mRealsedSurface == false) goto L6;
        return;
    L6:
        if (this.mIgnoreSurfaceCreated != 1) goto L8;
        return;
    L8:
        this.mReadLock.lock();
    L21:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L10:
        if (isValid() == false) goto L19;
        SurfaceHolder r101 = this.mSurfaceHolder;     // Catch: Throwable -> L21
        if (r100 == r101) goto L18;
        if (r101 == null) goto L15;
        r101.removeCallback(this.mCallback);     // Catch: Throwable -> L21
    L15:
        this.mSurfaceHolder = r100;     // Catch: Throwable -> L21
        if (r100 == null) goto L18;
        r100.addCallback(this.mCallback);     // Catch: Throwable -> L21
    L18:
        this.mPlayer.setSurfaceTimeOut(r100.getSurface(), 0);     // Catch: Throwable -> L21
    L19:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceDestroyed(SurfaceHolder r100) {
        if (this.mRealsedSurface == false) goto L6;
        return;
    L6:
        if (this.mMediaCodecStopTimeOutMs > 0) goto L21;
        this.mReadLock.lock();
    L18:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L14:
        if (isValid() == false) goto L16;
        this.mPlayer.setSurfaceTimeOut(null, 0);     // Catch: Throwable -> L18
    L16:
        this.mReadLock.unlock();
        return;
    L21:
        String r101 = AVThreadPool.addTask(new AnonymousClass2(this)).get(this.mMediaCodecStopTimeOutMs, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        return;
    L10:
        AVLogger.Error(TAG, this, "set surface time out");
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mSeekComplete = false;     // Catch: Throwable -> L8
        this.mPlayer.seekTo(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int r100) {
        this.mReadLock.lock();
        ITTPlayerRef r101 = this.mPlayer;
        if (r101 == null) goto L6;
        if (r100 != 0) goto L6;
        r101.setIntOption(261, 0);
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setABRStrategy(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setAIBarrageInfo(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAudioProcessor(AudioProcessor r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setAudioProcessor(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (r100.toLowerCase(Locale.US).indexOf("://") > 0) goto L5;
        this.mUri = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r100);
    L6:
        this.mReadLock.lock();
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L8:
        if (isValid() == false) goto L10;
        this.mPlayer.setDataSource(this.mUri);     // Catch: Throwable -> L12
    L10:
        this.mReadLock.unlock();
        return;
    L5:
        this.mUri = r100;
        goto L6
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder r100) {
        if (this.mCodecAndSurfaceReuse == 0) goto L8;
        SurfaceHolder r101 = this.mSurfaceHolder;
        if (r101 != r100) goto L8;
        if (r101 == null) goto L8;
        return;
    L8:
        SurfaceHolder r102 = this.mSurfaceHolder;
        if (r102 == null) goto L11;
        r102.removeCallback(this.mCallback);
    L11:
        this.mSurfaceHolder = r100;
        if (r100 == null) goto L14;
        r100.addCallback(this.mCallback);
        Surface r103 = this.mSurfaceHolder.getSurface();
    L15:
        this.mReadLock.lock();
    L21:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L17:
        if (isValid() == false) goto L19;
        this.mPlayer.setSurfaceTimeOut(r103, 0);     // Catch: Throwable -> L21
    L19:
        this.mReadLock.unlock();
        updateSurfaceScreenOn();
        return;
    L14:
        r103 = null;
        goto L15
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setFrameMetadataListener(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setIsMute(boolean r100) {
        this.mReadLock.lock();
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L10;
        ITTPlayerRef r101 = this.mPlayer;     // Catch: Throwable -> L12
        if (r100 == false) goto L8;
        int r102 = 1;
    L9:
        r101.setIntOption(12, r102);     // Catch: Throwable -> L12
        goto L10
    L8:
        r102 = 0;
    L10:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setLoadControl(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean r100) {
        this.mReadLock.lock();
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L10;
        ITTPlayerRef r101 = this.mPlayer;     // Catch: Throwable -> L12
        if (r100 == false) goto L8;
        int r102 = 1;
    L9:
        r101.setLooping(r102);     // Catch: Throwable -> L12
        goto L10
    L8:
        r102 = 0;
    L10:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setMaskInfo(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setMediaTransport(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100) {
        this.mOnBufferingUpdateListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(3);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener r100) {
        this.mOnCompletionListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(13);     // Catch: Throwable -> L8
        this.mPlayer.setNotifyState(111);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener r100) {
        this.mOnErrorListener = r100;
        long[] r101 = {0, 45};
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= 2) goto L9;
        long r103 = r101[r102];     // Catch: Throwable -> L11
        this.mPlayer.setNotifyState(r103);     // Catch: Throwable -> L11
        r102 = r102 + 1;
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r100) {
        this.mOnExternInfoListener = r100;
        long[] r101 = {63, 59, 19, 33, 40, 43, 44, 68, 85, 87, 90};
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= 11) goto L9;
        long r103 = r101[r102];     // Catch: Throwable -> L11
        this.mPlayer.setNotifyState(r103);     // Catch: Throwable -> L11
        r102 = r102 + 1;
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener r100) {
        this.mOnInfoListener = r100;
        long[] r101 = {1, 4, 5, 7, 8, 9, 10, 21, 22, 20, 24, 25, 26, 28, 27, 29, 32, 34, 35, 36, 37, 38, 39, 41, 42, 50, 49, 47, 51, 52, 53, 54, 30, 57, 58, 61, 62, 65, 66, 67, 70, 71, 72, 73, 82, 84, 88, 91, 92};
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= 49) goto L9;
        long r103 = r101[r102];     // Catch: Throwable -> L11
        this.mPlayer.setNotifyState(r103);     // Catch: Throwable -> L11
        r102 = r102 + 1;
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnLogListener(MediaPlayer.OnLogListener r100) {
        this.mLogListener = r100;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener r100) {
        this.mOnPreparedListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(2);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener r100) {
        this.mOnSARChangedListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(23);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100) {
        this.mOnSeekCompleteListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(12);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100) {
        this.mOnVideoSizeChangedListener = r100;
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setNotifyState(6);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPanoVideoControlModel(int r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setIntOption(11, r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams r100) {
        this.mReadLock.lock();
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L9;
        if (r100 == null) goto L9;
        if (r100.getSpeed() == (-1.0f)) goto L9;
        this.mPlayer.setFloatOption(60, r100.getSpeed());     // Catch: Throwable -> L11
    L9:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean r100) {
        if (this.mScreenOnWhilePlaying == r100) goto L10;
        if (r100 == true) goto L6;
    L8:
        this.mScreenOnWhilePlaying = r100;
        updateSurfaceScreenOn();
        return;
    L6:
        if (this.mSurfaceHolder != null) goto L8;
        AVLogger.Warn(TAG, this, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setStrategyParamsTransport(StrategyParamsTransport r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setStrategyParamsTransport(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setSubInfo(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setSurfaceTimeOut(r100, 0);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWindowClient(TTAVWindowClient r100) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setWindowClient(r100);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener r100) {
        if (this.mPlayer == null) goto L13;
        if (r100 == null) goto L16;
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L7:
        if (isValid() == false) goto L9;
        this.mPlayer.setNotifyState(15);     // Catch: Throwable -> L10
        this.mPlayer.setOnScreenshotListener(r100);     // Catch: Throwable -> L10
        this.mPlayer.takeScreenshot();     // Catch: Throwable -> L10
    L9:
        this.mReadLock.unlock();
        return;
    L16:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (r100 == null) goto L13;
        this.mReadLock.lock();
    L9:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L5:
        if (isValid() == false) goto L7;
        this.mPlayer.setDataSource(r100);     // Catch: Throwable -> L9
    L7:
        this.mReadLock.unlock();
        return;
    L13:
        throw new IllegalArgumentException("null mediadatasource pointer.");
    }

    public void setDataSource(FileDescriptor r100) throws IOException {
        ParcelFileDescriptor r101 = ParcelFileDescriptor.dup(r100);
        ITTPlayerRef r102 = this.mPlayer;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.setDataSourceFd(r101.getFd());     // Catch: Throwable -> L9
    L6:
        if (r101 == null) goto L15;
        r101.close();
        return;
    L15:
        return;
    L9:
        th = move-exception;
        if (r101 == null) goto L12;
        r101.close();
    L12:
        throw th;
    }

    public static TTPlayerClient create(MediaPlayer r100, Context r101) {
        return create(r100, r101, null, null);
    }

    private void notifyInfo(int r100, int r101) {
        MediaPlayer.OnInfoListener r102 = this.mOnInfoListener;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r100 != 4) goto L8;
        int r103 = 701;
    L79:
        r102.onInfo(this.mWrapper, r103, r101);
        return;
    L8:
        if (r100 != 5) goto L10;
        r103 = 702;
        goto L79
    L10:
        if (r100 != 41) goto L12;
        r103 = MediaPlayer.MEDIA_INFO_RTC_VIDEO_DECODE_STALL;
        goto L79
    L12:
        if (r100 != 42) goto L14;
        r103 = MediaPlayer.MEDIA_INFO_RTC_AUDIO_DECODE_STALL;
        goto L79
    L14:
        if (r100 != 57) goto L16;
        r103 = MediaPlayer.MEDIA_NO_AVRENDER_START;
        goto L79
    L16:
        if (r100 != 58) goto L18;
        r103 = MediaPlayer.MEDIA_NO_AVRENDER_END;
        goto L79
    L18:
        if (r100 != 61) goto L20;
        r103 = MediaPlayer.MEDIA_STARTTIME_NO_VIDEO_FRAME;
        goto L79
    L20:
        if (r100 == 62) goto L71;
        switch(r100) {
            case 7: goto L70;
            case 8: goto L69;
            case 9: goto L68;
            case 10: goto L67;
            default: goto L22;
        };
    L22:
        switch(r100) {
            case 20: goto L66;
            case 21: goto L65;
            case 22: goto L64;
            case 23: goto L63;
            case 24: goto L62;
            case 25: goto L61;
            case 26: goto L60;
            case 27: goto L59;
            case 28: goto L58;
            case 29: goto L57;
            case 30: goto L56;
            case 32: goto L55;
            case 47: goto L54;
            case 82: goto L53;
            case 84: goto L52;
            case 88: goto L51;
            case 91: goto L50;
            case 92: goto L49;
            case 111: goto L48;
            case 1000: goto L47;
            default: goto L23;
        };
    L23:
        switch(r100) {
            case 34: goto L46;
            case 35: goto L45;
            case 36: goto L44;
            case 37: goto L43;
            case 38: goto L42;
            case 39: goto L41;
            default: goto L24;
        };
    L24:
        switch(r100) {
            case 49: goto L40;
            case 50: goto L39;
            case 51: goto L38;
            case 52: goto L37;
            case 53: goto L36;
            case 54: goto L35;
            default: goto L25;
        };
    L25:
        switch(r100) {
            case 65: goto L34;
            case 66: goto L33;
            case 67: goto L32;
            default: goto L26;
        };
    L26:
        switch(r100) {
            case 70: goto L31;
            case 71: goto L30;
            case 72: goto L29;
            case 73: goto L28;
            default: goto L27;
        };
    L27:
        r103 = -1;
        goto L79
    L28:
        r103 = MediaPlayer.MEDIA_INFO_REFRESH_SURFACE;
        goto L79
    L29:
        r103 = MediaPlayer.MEDIA_INFO_FIRST_AVSYNC_FRAME;
        goto L79
    L30:
        r103 = MediaPlayer.MEDIA_INFO_LIVE_FIRST_FRAME_AFTER_SURFACE_CHANGE;
        goto L79
    L31:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_SECOND_FRAME;
        goto L79
    L32:
        r103 = MediaPlayer.MEDIA_INFO_LIVE_VIDEO_RENDER_START;
        goto L79
    L33:
        r103 = MediaPlayer.MEDIA_INFO_ABR_GET_PREDICT;
        goto L79
    L34:
        r103 = MediaPlayer.MEDIA_INFO_PRECISE_PAUSED;
        goto L79
    L35:
        r103 = MediaPlayer.MEDIA_INFO_DECODER_START;
        goto L79
    L36:
        r103 = MediaPlayer.MEDIA_INFO_FORMATER_START;
        goto L79
    L37:
        r103 = MediaPlayer.MEDIA_INFO_AVOUTSYNC_END;
        goto L79
    L38:
        r103 = MediaPlayer.MEDIA_INFO_AVOUTSYNC_START;
        goto L79
    L39:
        r103 = MediaPlayer.MEDIA_INFO_SUBTITLE_INFO;
        goto L79
    L40:
        r103 = MediaPlayer.MEDIA_INFO_BARRAGE_MASK_INFO;
        goto L79
    L41:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_PTS_BACK;
        goto L79
    L42:
        r103 = MediaPlayer.MEDIA_INFO_POSITION_UPDATE;
        goto L79
    L43:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_DECODE_STALL;
        goto L79
    L44:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_DECODE_STALL;
        goto L79
    L45:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_DEMUX_STALL;
        goto L79
    L46:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_DEMUX_STALL;
        goto L79
    L47:
        r103 = MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP;
        goto L79
    L48:
        r103 = MediaPlayer.MEDIA_INFO_PLAY_LOOP_END;
        goto L79
    L49:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_SR_MODE_CHANGE;
        goto L79
    L50:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_DECODE_ERROR_CONSUMED;
        goto L79
    L51:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_RENDER_DEVICE_CHANGED;
        goto L79
    L52:
        r103 = MediaPlayer.MEDIA_INFO_RENDER_EXCEPTION;
        goto L79
    L53:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_ABNORMAL_OCCURED;
        goto L79
    L54:
        r103 = MediaPlayer.MEDIA_INFO_PREBUFFERING_START;
        goto L79
    L55:
        r103 = MediaPlayer.MEDIA_INFO_SILENCE_DETECTED;
        goto L79
    L56:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_READY_FOR_DISPLAY;
        goto L79
    L57:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_RENDER_START;
        goto L79
    L58:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_RENDER_STALL;
        goto L79
    L59:
        r103 = MediaPlayer.MEDIA_INFO_AUDIO_RENDER_STALL;
        goto L79
    L60:
        r103 = MediaPlayer.MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED;
        goto L79
    L61:
        r103 = MediaPlayer.MEDIA_INFO_FIRST_FRAME_AFTER_SEEK;
        goto L79
    L62:
        r103 = MediaPlayer.MEDIA_INFO_SPEED_CHANGED;
        goto L79
    L63:
        r103 = MediaPlayer.MEDIA_INFO_SAR_CHANGED;
        goto L79
    L64:
        r103 = MediaPlayer.MEDIA_INFO_DEVICE_OPENED;
        goto L79
    L65:
        r103 = MediaPlayer.MEDIA_INFO_STREAM_CHANGED;
        goto L79
    L66:
        r103 = MediaPlayer.MEDIA_INFO_ROTATION_CHANGED;
        goto L79
    L67:
        r103 = 901;
        goto L79
    L68:
        r103 = 802;
        goto L79
    L69:
        r103 = 801;
        goto L79
    L70:
        r103 = 3;
        goto L79
    L71:
        r103 = MediaPlayer.MEDIA_INFO_INFO_ID_CHANGED;
        goto L79
    }

    private void sendErrorInfo(int r100, int r101) {
        this.mReentrantLock.lock();     // Catch: Throwable -> L17
        MediaPlayer.OnErrorListener r102 = this.mOnErrorListener;     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        if (r101 < this.mPlayLifeId) goto L14;
        int r103 = this.mErrorCode;     // Catch: Throwable -> L17
        if (r103 != 0) goto L11;
        if (r100 != 0) goto L12;
        r100 = -1048575;
    L12:
        r102.onError(this.mWrapper, r100, 0);     // Catch: Throwable -> L17
        goto L14
    L11:
        r100 = r103;
    L14:
        if (this.mReentrantLock.isLocked() == false) goto L24;
        this.mReentrantLock.unlock();
        return;
    L24:
        return;
    L17:
        th = move-exception;
        if (this.mReentrantLock.isLocked() == false) goto L21;
        this.mReentrantLock.unlock();
    L21:
        throw th;
    }

    public static void setGlobalIntOptionForKey(int r100, int r101) {
        ITTPlayerRef.setGlobalIntOptionForKey(r100, r101);
    }

    public static void setGlobalStringOptionForKey(int r100, String r101) {
        ITTPlayerRef.setGlobalStringOptionForKey(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public float getFloatOption(int r100, float r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        r101 = this.mPlayer.getFloatOption(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r101;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getIntOption(int r100, int r101) {
        if (r100 != 5000) goto L7;
        return this.mErrorCode;
    L7:
        if (r100 == 26) goto L9;
        this.mReadLock.lock();
    L16:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L12:
        if (isValid() == false) goto L14;
        r101 = this.mPlayer.getIntOption(r100, r101);     // Catch: Throwable -> L16
    L14:
        this.mReadLock.unlock();
        return r101;
    L9:
        return this.mCrashType;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public long getLongOption(int r100, long r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        r101 = this.mPlayer.getLongOption(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
        return r101;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void rotateCamera(float r100, float r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.rotateCamera(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int r100, int r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mSeekComplete = false;     // Catch: Throwable -> L8
        this.mPlayer.seekTo(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setCacheFile(String r100, int r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setCacheFile(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context r100, Uri r101) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (r101 != null) goto L5;
        return;
    L5:
        if ("content".equals(r101.getScheme()) == true) goto L7;
    L13:
        AssetFileDescriptor r102 = null;
        AssetFileDescriptor r103 = ContentResolverWrapper.openAssetFileDescriptor(r100.getContentResolver(), r101, "r");     // Catch: Throwable -> L22 IOException -> L26 SecurityException -> L29
        if (r103 != null) goto L19;
        if (r103 == null) goto L36;
        r103.close();
        return;
    L36:
        return;
    L19:
        setDataSource(r103.getFileDescriptor());     // Catch: Throwable -> L22 IOException -> L26 SecurityException -> L29
        r103.close();
        return;
    L22:
        th = move-exception;
        if (0 == 0) goto L25;
        r102.close();
    L25:
        throw th;
    L27:
        if (0 != 0) goto L31;
    L32:
        setDataSource(r101.toString());
        return;
    L31:
        r102.close();
    L30:
        if (0 == 0) goto L32;
    L7:
        if ("settings".equals(r101.getAuthority()) == false) goto L13;
        r101 = RingtoneManager.getActualDefaultRingtoneUri(r100, RingtoneManager.getDefaultType(r101));
        if (r101 != null) goto L13;
        throw new FileNotFoundException("Can't resolve default ringtone");
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOption(int r100, float r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setFloatOption(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOptionArray(int[] r100, float[] r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setFloatOptionArray(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOption(int r100, int r101) {
        if (r100 != 1301) goto L10;
        if (Looper.myLooper() == null) goto L7;
        this.mHandler = new Handler(this);
    L8:
        return 0;
    L7:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L8
    L10:
        if (r100 != 41) goto L14;
        AVResolver.HOST_MAX_CACHE_TIME = r101;
        return 0;
    L14:
        if (r100 != 5003) goto L18;
        this.mDisablePlayerStayAwake = r101;
        return 0;
    L18:
        if (r100 != 952) goto L22;
        this.mMediaCodecStopTimeOutMs = r101;
        return 0;
    L22:
        if (r100 != 1007) goto L25;
        this.mCodecAndSurfaceReuse = r101;
    L56:
        this.mReadLock.lock();
    L64:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L58:
        if (isValid() == false) goto L61;
        int r102 = this.mPlayer.setIntOption(r100, r101);     // Catch: Throwable -> L64
    L62:
        this.mReadLock.unlock();
        return r102;
    L61:
        r102 = -1;
        goto L62
    L25:
        if (r100 != 1036) goto L28;
        this.mIgnoreSurfaceCreated = r101;
        goto L56
    L28:
        if (r100 != 984) goto L51;
        if (r101 != 0) goto L32;
        r101 = 0;
    L49:
        AVLogger.setLogLevel(r101);
        goto L56
    L32:
        if (r101 != 1) goto L35;
        r101 = 16777216;
        goto L49
    L35:
        if (r101 != 2) goto L38;
        r101 = 33554432;
        goto L49
    L38:
        if (r101 != 3) goto L41;
    L39:
        r101 = 34603008;
        goto L49
    L41:
        if (r101 == 4) goto L39;
        if (r101 != 5) goto L47;
        r101 = 50331648;
        goto L49
    L47:
        if (r101 != 6) goto L49;
        r101 = 67108864;
        goto L49
    L51:
        if (r100 != 1501) goto L54;
        AVLogger.setLogLevel(r101);
        goto L56
    L54:
        if (r100 != 1502) goto L56;
        AVLogger.setLogLevel(r101);
        goto L56
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOptionArray(int[] r100, int[] r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setIntOptionArray(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOption(int r100, long r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setLongOption(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOptionArray(int[] r100, long[] r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setLongOptionArray(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setOnImageAvailableListener(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOption(int r100, String r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setStringOption(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOptionArray(int[] r100, String[] r101) {
        this.mReadLock.lock();
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L7;
        int r102 = this.mPlayer.setStringOptionArray(r100, r101);     // Catch: Throwable -> L10
    L8:
        this.mReadLock.unlock();
        return r102;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface r100, int r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setSurfaceTimeOut(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setTraitObject(int r100, TraitObject r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setTraitObject(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float r100, float r101) {
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setVolume(r100, r101);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context r100, int r101) {
        PowerManager.WakeLock r102 = this.mWakeLock;
        if (r102 != null) goto L5;
        boolean r103 = false;
    L10:
        PowerManager.WakeLock r104 = ((PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(r101 | 536870912, TTPlayerClient.class.getName());
        this.mWakeLock = r104;
        if (r104 == null) goto L16;
        r104.setReferenceCounted(false);
        if (r103 == false) goto L17;
        INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.mWakeLock);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r102.isHeld() == false) goto L7;
        INVOKEVIRTUAL_com_ss_ttm_player_TTPlayerClient_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.mWakeLock);
        r103 = true;
    L8:
        this.mWakeLock = null;
        goto L10
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int r100, int r101) {
        if (this.mPlayer == null) goto L12;
        this.mReadLock.lock();
    L9:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L6:
        if (isValid() == false) goto L8;
        this.mPlayer.switchStream(r100, r101);     // Catch: Throwable -> L9
    L8:
        this.mReadLock.unlock();
        return;
    }

    private TTPlayerClient(Context r100, HashMap<Integer, Integer> r101, OnceConfig r102) {
        this.mSeekComplete = true;
        this.mLogInfo = new LinkedList();
        this.mRealsedSurface = false;
        this.mPlayLifeId = -1;
        this.mReentrantLock = new ReentrantLock();
        this.mReentrantLockInRtc = new ReentrantLock();
        ReentrantReadWriteLock r103 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r103;
        this.mReadLock = r103.readLock();
        this.mWriteLock = r103.writeLock();
        this.mErrorCode = 0;
        this.mRtcPlay = 0;
        this.mCrashedInfo = new StringBuilder(1024);
        this.mCrashType = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mMediaCodecStopTimeOutMs = -1;
        this.mCodecAndSurfaceReuse = 0;
        this.mIgnoreSurfaceCreated = 0;
        this.mConnectedCpu = false;
        this.mConfigParams = r101;
        this.mRealsedSurface = false;
        this.mCallback = new TTSurfaceCallback(this);
        this.mContext = r100;
        if (Looper.myLooper() == null) goto L5;
        this.mHandler = new Handler(this);
        return;
    L5:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public static TTPlayerClient create(MediaPlayer r100, Context r101, HashMap<Integer, Integer> r102) {
        return create(r100, r101, r102, null);
    }

    private void onExternInfo(int r100, int r101, String r102) {
        if (this.mRtcPlay != 0) goto L17;
        MediaPlayer.OnExternInfoListener r103 = this.mOnExternInfoListener;
        if (r103 == null) goto L20;
        if (r102 == null) goto L21;
        r103.onExternInfo(this.mWrapper, r100, r102);
        this.mOnExternInfoListener.onExternInfo2(this.mWrapper, r100, r101, r102);
        return;
    L21:
        return;
    L20:
        return;
    L17:
        this.mReentrantLockInRtc.lock();     // Catch: Throwable -> L9
        MediaPlayer.OnExternInfoListener r104 = this.mOnExternInfoListener;     // Catch: Throwable -> L9
        if (r104 == null) goto L8;
        if (r102 == null) goto L8;
        r104.onExternInfo(this.mWrapper, r100, r102);     // Catch: Throwable -> L9
        this.mOnExternInfoListener.onExternInfo2(this.mWrapper, r100, r101, r102);     // Catch: Throwable -> L9
    L8:
        this.mReentrantLockInRtc.unlock();
        return;
    L9:
        th = move-exception;
        this.mReentrantLockInRtc.unlock();
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void mouseEvent(int r100, int r101, int r102) {
        int r103 = 1;
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L8;
        r103 = 2;
        if (r100 == 2) goto L9;
        r103 = 0;
        goto L9
    L8:
        r103 = 3;
    L9:
        this.mReadLock.lock();
    L15:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L11:
        if (isValid() == false) goto L13;
        this.mPlayer.mouseEvent(r103, r101, r102);     // Catch: Throwable -> L15
    L13:
        this.mReadLock.unlock();
    }

    public void onPlayLogInfo(int r100, int r101, String r102) {
        if (r100 != 2) goto L9;
        if (r101 != 1) goto L6;
        this.mVoiceInfo = r102;
        return;
    L6:
        if (r101 != 0) goto L18;
        this.mBufferingInfo = r102;
        return;
    L18:
        return;
    L9:
        if (r100 != 0) goto L11;
        this.mErrorCode = r101;
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        if (this.mLogInfo.size() <= 40) goto L15;
        this.mLogInfo.removeFirst();
    L15:
        this.mLogInfo.addLast(String.format(Locale.US, "%s&&time:%d", new Object[]{r102, Long.valueOf(System.currentTimeMillis())}));
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context r100, Uri r101, Map<String, String> r102) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (r101 != null) goto L4;
        return;
    L4:
        setDataSource(r100, r101);
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.size() == 0) goto L26;
        StringBuilder r103 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        Map.Entry<String, String> r105 = r104.next();
        r103.append(r105.getKey());
        r103.append(": ");
        r103.append(r105.getValue());
        r103.append("\r\n");
        goto L11
    L13:
        this.mReadLock.lock();
    L19:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L15:
        if (isValid() == false) goto L17;
        this.mPlayer.setStringOption(20, r103.toString());     // Catch: Throwable -> L19
    L17:
        this.mReadLock.unlock();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor r100, long r101, long r102) throws IllegalStateException, IllegalArgumentException, IOException {
        setDataSource(r100);
        this.mReadLock.lock();
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L4:
        if (isValid() == false) goto L6;
        this.mPlayer.setLongOption(135, r101);     // Catch: Throwable -> L8
        this.mPlayer.setLongOption(136, r102);     // Catch: Throwable -> L8
    L6:
        this.mReadLock.unlock();
    }

    public static synchronized TTPlayerClient create(MediaPlayer r100, Context r101, HashMap<Integer, Integer> r102, OnceConfig r103) {
        monitor-enter(TTPlayerClient.class);
        TTVersion.saveVersionInfo();     // Catch: Throwable -> L15
        if (r101 == null) goto L7;
        r101 = r101.getApplicationContext();     // Catch: Throwable -> L15
    L7:
        TTPlayerClient r104 = new TTPlayerClient(r101, r102, r103);     // Catch: Throwable -> L15
        ITTPlayerRef r105 = ITTPlayerRef.create(r101, r104, r102, r103);     // Catch: Throwable -> L15
        if (r105 != null) goto L12;
        monitor-exit(TTPlayerClient.class);
        return null;
    L12:
        r104.mPlayer = r105;     // Catch: Throwable -> L15
        r104.mWrapper = r100;     // Catch: Throwable -> L15
        monitor-exit(TTPlayerClient.class);
        return r104;
    L15:
        th = move-exception;
        throw th;
    }

    private void onPlayerNotifyWithoutLock(int r100, int r101, int r102, String r103) {
        if (this.mHandler != null) goto L7;
        ThreadMethodProxy.currentThread().getId();
        return;
    L7:
        if (r101 != 40) goto L12;
        if (r103 == null) goto L12;
        handleNotify(r100, r101, r102, r103);
        return;
    L12:
        if (r101 == 3) goto L14;
        ThreadMethodProxy.currentThread().getId();
    L14:
        Message r104 = this.mHandler.obtainMessage(r101, r102, r100);
        r104.obj = r103;
        r104.sendToTarget();
        if (r101 == 3) goto L18;
        ThreadMethodProxy.currentThread().getId();
        return;
    }

    public void handleNotify(int r100, int r101, int r102, String r103) {
        if (r101 != 0) goto L5;
    L60:
        stayAwake(false);
        if (r102 != (-499989)) goto L68;
        HashMap<Integer, Integer> r104 = this.mConfigParams;
        if (r104 != null) goto L65;
    L67:
        TTPlayerConfiger.setValue(8, true);
        goto L68
    L65:
        if (r104.get(100).intValue() != 1) goto L67;
        this.mConfigParams.put(8, 1);
    L68:
        sendSeekCompleted(r100);
        sendErrorInfo(r102, r100);
        return;
    L5:
        if (r101 != 12) goto L7;
        sendSeekCompleted(r100);
        return;
    L7:
        if (r101 != 13) goto L9;
        stayAwake(false);
        sendSeekCompleted(r100);
        sendCompletioned(r100);
        return;
    L9:
        if (r101 != 84) goto L11;
    L57:
        notifyInfo(r101, r102);
        return;
    L11:
        if (r101 == 85) goto L56;
        switch(r101) {
            case 0: goto L60;
            case 32: goto L57;
            case 33: goto L56;
            case 34: goto L57;
            case 35: goto L57;
            case 36: goto L57;
            case 37: goto L57;
            case 38: goto L57;
            case 39: goto L57;
            case 40: goto L56;
            case 41: goto L57;
            case 42: goto L57;
            case 43: goto L56;
            case 44: goto L56;
            case 45: goto L60;
            case 47: goto L57;
            case 49: goto L57;
            case 82: goto L57;
            case 87: goto L56;
            case 88: goto L57;
            case 90: goto L56;
            case 91: goto L57;
            case 92: goto L57;
            case 111: goto L57;
            case 1000: goto L57;
            case 20000: goto L38;
            default: goto L14;
        };
    L14:
        switch(r101) {
            case 2: goto L34;
            case 3: goto L29;
            case 4: goto L57;
            case 5: goto L57;
            case 6: goto L26;
            case 7: goto L57;
            case 8: goto L57;
            case 9: goto L57;
            case 10: goto L57;
            default: goto L15;
        };
    L15:
        switch(r101) {
            case 19: goto L56;
            case 20: goto L57;
            case 21: goto L57;
            case 22: goto L57;
            case 23: goto L23;
            case 24: goto L57;
            case 25: goto L57;
            case 26: goto L57;
            case 27: goto L57;
            case 28: goto L57;
            case 29: goto L57;
            case 30: goto L57;
            default: goto L16;
        };
    L16:
        switch(r101) {
            case 51: goto L57;
            case 52: goto L57;
            case 53: goto L57;
            case 54: goto L57;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 57: goto L57;
            case 58: goto L57;
            case 59: goto L56;
            default: goto L18;
        };
    L18:
        switch(r101) {
            case 61: goto L57;
            case 62: goto L57;
            case 63: goto L56;
            default: goto L19;
        };
    L19:
        switch(r101) {
            case 65: goto L57;
            case 66: goto L57;
            case 67: goto L57;
            case 68: goto L56;
            default: goto L20;
        };
    L20:
        switch(r101) {
            case 70: goto L57;
            case 71: goto L57;
            case 72: goto L57;
            case 73: goto L22;
            default: goto L86;
        };
    L22:
        this.mConnectedCpu = true;
        notifyInfo(r101, r102);
        return;
    L86:
        return;
    L23:
        int r105 = 65535 & r102;
        int r106 = r102 >> 16;
        MediaPlayer.onSARChangedListener r107 = this.mOnSARChangedListener;
        if (r107 == null) goto L73;
        r107.onSARChanged(this.mWrapper, r105, r106);
        return;
    L73:
        return;
    L26:
        MediaPlayer.OnVideoSizeChangedListener r108 = this.mOnVideoSizeChangedListener;
        if (r108 == null) goto L75;
        r108.onVideoSizeChanged(this.mWrapper, 65535 & r102, r102 >> 16);
        return;
    L75:
        return;
    L29:
        if (r102 == 100) goto L31;
    L31:
        MediaPlayer.OnBufferingUpdateListener r109 = this.mOnBufferingUpdateListener;
        if (r109 == null) goto L77;
        r109.onBufferingUpdate(this.mWrapper, r102);
        return;
    L77:
        return;
    L34:
        MediaPlayer.OnPreparedListener r110 = this.mOnPreparedListener;
        if (r110 == null) goto L79;
        r110.onPrepared(this.mWrapper);
        return;
    L79:
        return;
    L38:
        if (this.mErrorCode != (-2139062143)) goto L40;
        return;
    L40:
        this.mErrorCode = MediaPlayer.MEDIA_PLAYER_CRASHED_ERROR;
        this.mWriteLock.lock();
        ITTPlayerRef r111 = this.mPlayer;     // Catch: Throwable -> L53
        if (r111 == null) goto L51;
        this.mPlayer = null;     // Catch: Throwable -> L53
        r111.invalid();     // Catch: Throwable -> L53
        this.mWriteLock.unlock();
        HashMap<Integer, Integer> r112 = this.mConfigParams;
        if (r112 != null) goto L47;
    L49:
        TTPlayerConfiger.setValue(7, true);
    L50:
        stayAwake(false);
        sendSeekCompleted(r100);
        sendErrorInfo(r102, r100);
        sendCompletioned(r100);
        return;
    L47:
        if (r112.get(100).intValue() != 1) goto L49;
        this.mConfigParams.put(7, 1);
        goto L50
    L51:
        this.mWriteLock.unlock();
        return;
    L53:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L56:
        onExternInfo(r101, r102, r103);
    }

    public void onPlayerNotify(int r100, int r101, int r102, String r103) {
        if (r101 == 3) goto L5;
        ThreadMethodProxy.currentThread().getId();
    L5:
        onPlayerNotifyWithoutLock(r100, r101, r102, r103);
    }
}
