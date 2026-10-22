package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import com.ss.ttm.utils.OnceConfig;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = null;
    private static String mAppPath;
    private static String mLoadErr;
    private static boolean mLoadSoSuccess;
    private TTPlayerClient mClient;
    private final Context mContext;
    private long mId;
    OnceConfig mOnceBySelf;
    private TTPlayer mPlayer;

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setCacheFile(String r100, int r101) {
    }

    static {
        TAG = "TTPlayerRef";
        mAppPath = null;
        mLoadErr = null;
        mLoadSoSuccess = false;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        return this.mPlayer.getTrackInfo();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public boolean isValid() {
        if (this.mPlayer != null) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int preDemux() {
        return this.mPlayer.preDemux();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void release() {
        OnceConfig r100 = this.mOnceBySelf;
        if (r100 == null) goto L5;
        r100.release();
        this.mOnceBySelf = null;
    L5:
        TTPlayer r101 = this.mPlayer;
        this.mPlayer = null;
        r101.release();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setupMediaCodec() {
        this.mPlayer.setupMediaCodec();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    public TTPlayer getPlayer() {
        return this.mPlayer;
    }

    public TTPlayerRef(Context r100) {
        this.mId = System.currentTimeMillis();
        this.mOnceBySelf = null;
        this.mContext = r100;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public Object getObjectOption(int r100) {
        return this.mPlayer.getObjectValue(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getStringOption(int r100) {
        return this.mPlayer.getStringOption(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getSubtitleContent(int r100) {
        return this.mPlayer.getSubtitleContent(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int r100) {
        this.mPlayer.seekTo(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setABRStrategy(ABRStrategy r100) {
        this.mPlayer.setABRStrategy(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setAIBarrageInfo(MaskInfo r100) {
        this.mPlayer.setAIBarrageInfo(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setAudioProcessor(AudioProcessor r100) {
        this.mPlayer.setAudioProcessor(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(IMediaDataSource r100) {
        this.mPlayer.setDataSource(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSourceFd(int r100) {
        this.mPlayer.setDataSourceFd(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setFrameMetadataListener(FrameMetadataListener r100) {
        this.mPlayer.setFrameMetadataListener(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLoadControl(LoadControl r100) {
        this.mPlayer.setLoadControl(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLooping(int r100) {
        this.mPlayer.setLooping(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setMaskInfo(MaskInfo r100) {
        this.mPlayer.setMaskInfo(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setMediaTransport(MediaTransport r100) {
        this.mPlayer.setMediaTransport(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setNotifyState(long r100) {
        this.mPlayer.setNotifyerState(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener r100) {
        this.mPlayer.setOnScreenshotListener(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setStrategyParamsTransport(StrategyParamsTransport r100) {
        this.mPlayer.setStrategyParamsTransport(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSubInfo(SubInfo r100) {
        this.mPlayer.setSubInfo(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurface(Surface r100) {
        this.mPlayer.setVideoSurface(r100);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setWindowClient(TTAVWindowClient r100) {
        if ((r100 instanceof TTWindowClient) == false) goto L6;
        ((TTWindowClient) r100).bindPlayer(this.mPlayer);
        return;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(String r100) {
        this.mPlayer.setDataSource(r100);
    }

    public static void setGlobalIntOptionForKey(int r100, int r101) {
        if (r100 != 1015) goto L5;
        TTPlayerConfiger.setValue(31, r101);
    L63:
        if (mLoadSoSuccess == false) goto L66;
        TTPlayer.setGlobalIntOptionForKey(r100, r101);
        return;
    L66:
        return;
    L5:
        if (r100 != 1016) goto L7;
        TTPlayerConfiger.setValue(32, r101);
        goto L63
    L7:
        if (r100 != 1306) goto L9;
        TTPlayerConfiger.setValue(52, r101);
        goto L63
    L9:
        if (r100 != 1307) goto L11;
        TTPlayerConfiger.setValue(53, r101);
        goto L63
    L11:
        if (r100 != 40002) goto L13;
        TTPlayerConfiger.setValue(49, r101);
        goto L63
    L13:
        if (r100 == 40007) goto L56;
        switch(r100) {
            case 1356: goto L55;
            case 1357: goto L54;
            case 1358: goto L53;
            case 1359: goto L52;
            case 1360: goto L51;
            case 1361: goto L50;
            default: goto L15;
        };
    L15:
        switch(r100) {
            case 40013: goto L49;
            case 40014: goto L48;
            case 40015: goto L47;
            case 40016: goto L46;
            case 40017: goto L45;
            case 40018: goto L44;
            case 40019: goto L43;
            case 40020: goto L42;
            case 40021: goto L41;
            case 40022: goto L40;
            case 40023: goto L39;
            case 40024: goto L38;
            case 40025: goto L37;
            case 40026: goto L36;
            case 40027: goto L35;
            case 40028: goto L34;
            case 40029: goto L33;
            case 40030: goto L32;
            case 40031: goto L31;
            default: goto L16;
        };
    L16:
        switch(r100) {
            case 40034: goto L30;
            case 40035: goto L29;
            case 40036: goto L28;
            case 40037: goto L27;
            case 40038: goto L26;
            case 40039: goto L25;
            case 40040: goto L24;
            case 40041: goto L23;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 40051: goto L22;
            case 40052: goto L21;
            case 40053: goto L20;
            case 40054: goto L19;
            default: goto L63;
        };
    L19:
        TTPlayerConfiger.setValue(88, r101);
        goto L63
    L20:
        TTPlayerConfiger.setValue(87, r101);
        goto L63
    L21:
        TTPlayerConfiger.setValue(83, r101);
        goto L63
    L22:
        TTPlayerConfiger.setValue(78, r101);
        goto L63
    L23:
        TTPlayerConfiger.setValue(86, r101);
        goto L63
    L24:
        TTPlayerConfiger.setValue(85, r101);
        goto L63
    L25:
        TTPlayerConfiger.setValue(84, r101);
        goto L63
    L26:
        TTPlayerConfiger.setValue(82, r101);
        goto L63
    L27:
        TTPlayerConfiger.setValue(81, r101);
        goto L63
    L28:
        TTPlayerConfiger.setValue(80, r101);
        goto L63
    L29:
        TTPlayerConfiger.setValue(79, r101);
        goto L63
    L30:
        TTPlayerConfiger.setValue(75, r101);
        goto L63
    L31:
        TTPlayerConfiger.setValue(73, r101);
        goto L63
    L32:
        TTPlayerConfiger.setValue(72, r101);
        goto L63
    L33:
        TTPlayerConfiger.setValue(71, r101);
        goto L63
    L34:
        TTPlayerConfiger.setValue(70, r101);
        goto L63
    L35:
        TTPlayerConfiger.setValue(69, r101);
        goto L63
    L36:
        TTPlayerConfiger.setValue(68, r101);
        goto L63
    L37:
        TTPlayerConfiger.setValue(67, r101);
        goto L63
    L38:
        TTPlayerConfiger.setValue(66, r101);
        goto L63
    L39:
        TTPlayerConfiger.setValue(65, r101);
        goto L63
    L40:
        TTPlayerConfiger.setValue(64, r101);
        goto L63
    L41:
        TTPlayerConfiger.setValue(63, r101);
        goto L63
    L42:
        TTPlayerConfiger.setValue(62, r101);
        goto L63
    L43:
        TTPlayerConfiger.setValue(61, r101);
        goto L63
    L44:
        TTPlayerConfiger.setValue(60, r101);
        goto L63
    L45:
        TTPlayerConfiger.setValue(59, r101);
        goto L63
    L46:
        TTPlayerConfiger.setValue(58, r101);
        goto L63
    L47:
        TTPlayerConfiger.setValue(57, r101);
        goto L63
    L48:
        TTPlayerConfiger.setValue(56, r101);
        goto L63
    L49:
        TTPlayerConfiger.setValue(55, r101);
        goto L63
    L50:
        TTPlayerConfiger.setValue(51, r101);
        goto L63
    L51:
        TTPlayerConfiger.setValue(50, r101);
        goto L63
    L52:
        TTPlayerConfiger.setValue(47, r101);
        goto L63
    L53:
        TTPlayerConfiger.setValue(46, r101);
        goto L63
    L54:
        TTPlayerConfiger.setValue(45, r101);
        goto L63
    L55:
        TTPlayerConfiger.setValue(44, r101);
        goto L63
    L56:
        TTPlayerConfiger.setValue(54, r101);
        goto L63
    }

    public static void setGlobalStringOptionForKey(int r100, String r101) {
        if (r100 != 40050) goto L7;
        TTPlayerConfiger.setValue(77, r101);
    L7:
        if (mLoadSoSuccess == false) goto L10;
        TTPlayer.setGlobalStringOptionForKey(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public double getDoubleOption(int r100, double r101) {
        return this.mPlayer.getDoubleOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public float getFloatOption(int r100, float r101) {
        return this.mPlayer.getFloatOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getIntOption(int r100, int r101) {
        return this.mPlayer.getIntOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public long getLongOption(int r100, long r101) {
        return this.mPlayer.getLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void rotateCamera(float r100, float r101) {
        this.mPlayer.rotateCamera(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int r100, int r101) {
        this.mPlayer.seekTo(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setDoubleOption(int r100, double r101) {
        return this.mPlayer.setDoubleOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOption(int r100, float r101) {
        return this.mPlayer.setFloatOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOptionArray(int[] r100, float[] r101) {
        return this.mPlayer.setFloatOptionArray(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOption(int r100, int r101) {
        return this.mPlayer.setIntOption(r100, r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOptionArray(int[] r100, int[] r101) {
        return this.mPlayer.setIntOptionArray(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOption(int r100, long r101) {
        return this.mPlayer.setLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOptionArray(int[] r100, long[] r101) {
        return this.mPlayer.setLongOptionArray(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
        this.mPlayer.setOnImageAvailableListener(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOption(int r100, String r101) {
        return this.mPlayer.setStringOption(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOptionArray(int[] r100, String[] r101) {
        return this.mPlayer.setStringOptionArray(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurfaceTimeOut(Surface r100, int r101) {
        this.mPlayer.setVideoSurfaceTimeOut(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setTraitObject(int r100, TraitObject r101) {
        this.mPlayer.setTraitObject(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setVolume(float r100, float r101) {
        this.mPlayer.setVolume(r100, r101);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void switchStream(int r100, int r101) {
        this.mPlayer.switchStream(r100, r101);
    }

    public static final synchronized TTPlayerRef create(TTPlayerClient r100, Context r101, OnceConfig r102) {
        monitor-enter(TTPlayerRef.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (mAppPath != null) goto L14;
        mAppPath = TTPlayerConfiger.getAppFileCachePath(r101);     // Catch: Throwable -> L32
    L11:
        e = move-exception;
        mLoadErr = e.getMessage();     // Catch: Throwable -> L32
        goto L14
    L8:
        if (TTPlayer.getAppPath() != null) goto L14;
        TTPlayer.setTempFileDir(mAppPath);     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L32
    L14:
        if (mLoadErr != null) goto L31;
        if (mLoadSoSuccess == true) goto L18;
        TTPlayer.setGlobalIntOptionForKey(1015, TTPlayerConfiger.getValue(31, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(1016, TTPlayerConfiger.getValue(32, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(1356, TTPlayerConfiger.getValue(44, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(1357, TTPlayerConfiger.getValue(45, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(1358, TTPlayerConfiger.getValue(46, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40002, TTPlayerConfiger.getValue(49, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIO_ADAPTER_MAX_QUEUE_SIZE, TTPlayerConfiger.getValue(52, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIO_ADAPTER_MAX_USE_COUNT, TTPlayerConfiger.getValue(53, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40007, TTPlayerConfiger.getValue(54, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40013, TTPlayerConfiger.getValue(55, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40014, TTPlayerConfiger.getValue(56, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40015, TTPlayerConfiger.getValue(57, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40016, TTPlayerConfiger.getValue(58, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40037, TTPlayerConfiger.getValue(81, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40038, TTPlayerConfiger.getValue(82, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40039, TTPlayerConfiger.getValue(84, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40040, TTPlayerConfiger.getValue(85, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40041, TTPlayerConfiger.getValue(86, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40017, TTPlayerConfiger.getValue(59, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40018, TTPlayerConfiger.getValue(60, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40019, TTPlayerConfiger.getValue(61, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40020, TTPlayerConfiger.getValue(62, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40021, TTPlayerConfiger.getValue(63, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40022, TTPlayerConfiger.getValue(64, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40023, TTPlayerConfiger.getValue(65, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40024, TTPlayerConfiger.getValue(66, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40025, TTPlayerConfiger.getValue(67, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40026, TTPlayerConfiger.getValue(68, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40027, TTPlayerConfiger.getValue(69, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40028, TTPlayerConfiger.getValue(70, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40029, TTPlayerConfiger.getValue(71, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40030, TTPlayerConfiger.getValue(72, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40031, TTPlayerConfiger.getValue(73, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40035, TTPlayerConfiger.getValue(79, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40036, TTPlayerConfiger.getValue(80, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(TTVideoEngineInterface.GLOBAL_PLAYER_OPTION_ENABLE_REFACTOR_LOGGER, TTPlayerConfiger.getValue(75, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalStringOptionForKey(40050, TTPlayerConfiger.getValue(77, ""));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40053, TTPlayerConfiger.getValue(87, 0));     // Catch: Throwable -> L32
        TTPlayer.setGlobalIntOptionForKey(40054, TTPlayerConfiger.getValue(88, 0));     // Catch: Throwable -> L32
    L18:
        mLoadSoSuccess = true;     // Catch: Throwable -> L32
        TTPlayerRef r103 = new TTPlayerRef(r101);     // Catch: Throwable -> L32
        r103.mClient = r100;     // Catch: Throwable -> L32
        TTPlayer r104 = new TTPlayer(r101, r103.mId, r102);     // Catch: Throwable -> L22
        r103.mPlayer = r104;     // Catch: Throwable -> L22
        r104.setNotifyer(r103);     // Catch: Throwable -> L22
        monitor-exit(TTPlayerRef.class);
        return r103;
    L22:
        th = move-exception;
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L32
        String r106 = TTPlayerLibraryLoader.getErrorInfo();     // Catch: Throwable -> L26
    L28:
        r105.append(th.toString());     // Catch: Throwable -> L32
        r105.append(",player:");     // Catch: Throwable -> L32
        r105.append(r106);     // Catch: Throwable -> L32
        throw new RuntimeException(r105.toString());     // Catch: Throwable -> L32
    L26:
        th = move-exception;
        r106 = th.toString();     // Catch: Throwable -> L32
        goto L28
    L31:
        throw new UnsatisfiedLinkError(mLoadErr);     // Catch: Throwable -> L32
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void mouseEvent(int r100, int r101, int r102) {
        this.mPlayer.mouseEvent(r100, r101, r102);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handleErrorNotify(long r100, int r101, int r102, String r103) {
        this.mClient.onPlayLogInfo(r101, r102, r103);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handlePlayerNotify(long r100, int r101, int r102, int r103, String r104) {
        this.mClient.onPlayerNotify(r101, r102, r103, r104);
    }
}
