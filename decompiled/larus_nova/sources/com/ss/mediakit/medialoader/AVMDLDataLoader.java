package com.ss.mediakit.medialoader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.mediakit.downloader.AVMDLHttpExcutor;
import com.ss.mediakit.net.AVMDLDNSInfo;
import com.ss.mediakit.net.AVMDLDNSParser;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.ss.mediakit.net.IPCache;
import com.ss.mediakit.utils.AVMDLDeviceUtil;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class AVMDLDataLoader implements Handler.Callback {
    public static final int AVMDLCopyErrorFileCopyFailed = -5;
    public static final int AVMDLCopyErrorFileHaveHole = -6;
    public static final int AVMDLCopyErrorFileKeyNotCaching = -4;
    public static final int AVMDLCopyErrorInvalidParameter = -1;
    public static final int AVMDLCopyErrorMdlNotRunning = -2;
    public static final int AVMDLCopyErrorNotCached = -3;
    public static final int AVMDLErrorIsCreateTask = -1000;
    public static final int AVMDLErrorIsInvalidContentLenth = -2000;
    public static final int AVMDLErrorIsInvalidFileWrite = -5000;
    public static final int AVMDLErrorIsInvalidRequestInfo = -4000;
    public static final int AVMDLErrorIsStatusCodeMoreThan400 = -3000;
    public static final int AVMDLErrorIsStatusCodeMoreThan500 = -3001;
    public static final int AVMDLErrorIsTheSameKeyTask = -1001;
    public static final int AVMDLErrorIsTooManyTask = -1002;
    public static final int AVMDLLoaderTypeNone = 10000;
    public static final int AVMDLTaskStateStart = 1;
    public static final int AVMDLTaskStateStop = 2;
    public static final int AVMDLTaskTypeDownloadTask = 3;
    public static final int AVMDLTaskTypePlayTask = 1;
    public static final int AVMDLTaskTypePreconnectTask = 4;
    public static final int AVMDLTaskTypePreloadTask = 2;
    public static final int AVMDLoaderTypeAliP2P = 5;
    public static final int AVMDLoaderTypeHttp = 0;
    public static final int AVMDLoaderTypeKsyP2P = 3;
    public static final int AVMDLoaderTypeOwnLiveVDP = 7;
    public static final int AVMDLoaderTypeOwnVDP = 2;
    public static final int AVMDLoaderTypeWsuP2P = 6;
    public static final int AVMDLoaderTypeXYVod = 1;
    public static final int AVMDLoaderTypeYFP2P = 4;
    public static final int IsCellular = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsDefault = 0;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int IsWifi = 2;
    public static final int KeyIsAccessCheckLevel = 3511;
    public static final int KeyIsAllowTryTheLastUrl = 7357;
    public static final int KeyIsAlogEnable = 7225;
    public static final int KeyIsAlogInfo = 14;
    public static final int KeyIsBusinessDirControlConfig = 7448;
    public static final int KeyIsByteMediaNetLoaderCronetBufSizeKB = 7351;
    public static final int KeyIsCDNLog = 6;
    public static final int KeyIsCacheDirListsStr = 7399;
    public static final int KeyIsCheckCacheDir = 7430;
    public static final int KeyIsCheckContentTypeMethod = 7407;
    public static final int KeyIsCloseFileCache = 800;
    public static final int KeyIsCloseLocalServer = 7441;
    public static final int KeyIsCloseThreadPool = 7408;
    public static final int KeyIsConnectPoolStragetyValue = 7363;
    public static final int KeyIsControlCDNRangeType = 703;
    public static final int KeyIsCopyOperation = 23;
    public static final int KeyIsCustomUA = 8222;
    public static final int KeyIsDNSLog = 15;
    public static final int KeyIsDeviceScoreEx = 7426;
    public static final int KeyIsDisableRecentCache = 7435;
    public static final int KeyIsDownloadDir = 7300;
    public static final int KeyIsDownloadEnd = 21;
    public static final int KeyIsDownloadSuspend = 22;
    public static final int KeyIsDownloaderLog = 19;
    public static final int KeyIsDownloaderLogTTNet = 16;
    public static final int KeyIsDynamicPreconnectConfigStr = 7501;
    public static final int KeyIsEnableByteMediaNetLoader = 7350;
    public static final int KeyIsEnableCacheReqRange = 7358;
    public static final int KeyIsEnableCellularUp = 8215;
    public static final int KeyIsEnableCustomDirSearchAllPath = 7447;
    public static final int KeyIsEnableDynamicSocketTimeout = 7362;
    public static final int KeyIsEnableEarlyData = 8219;
    public static final int KeyIsEnableEventInfo = 9999;
    public static final int KeyIsEnableExternDNS = 700;
    public static final int KeyIsEnableFileCacheV2 = 7222;
    public static final int KeyIsEnableFileMutexOptimize = 7420;
    public static final int KeyIsEnableFileRingBuffer = 7228;
    public static final int KeyIsEnableIOManager = 7391;
    public static final int KeyIsEnableIpBucket = 901;
    public static final int KeyIsEnableLazyBufferpool = 7332;
    public static final int KeyIsEnableLoaderLogExtractUrls = 7405;
    public static final int KeyIsEnableLoaderPreempt = 2510;
    public static final int KeyIsEnableLoaderSeek = 7369;
    public static final int KeyIsEnableMissReasonRecord = 7438;
    public static final int KeyIsEnableMultiDownloadPath = 7411;
    public static final int KeyIsEnableNetScheduler = 7342;
    public static final int KeyIsEnableNewBufferpool = 7334;
    public static final int KeyIsEnableOkHttpLoader = 9300;
    public static final int KeyIsEnableOptimizeRange = 7428;
    public static final int KeyIsEnableP2PPreDown = 7340;
    public static final int KeyIsEnableP2PUpload = 11000;
    public static final int KeyIsEnablePlayInfoCache = 7339;
    public static final int KeyIsEnablePlayLog = 7341;
    public static final int KeyIsEnablePreconnect = 2508;
    public static final int KeyIsEnablePreloadReUse = 105;
    public static final int KeyIsEnableSessionReuse = 5511;
    public static final int KeyIsEnableSocketReuse = 701;
    public static final int KeyIsEnableSpeedEngine = 8224;
    public static final int KeyIsEnableSpeedPredict = 8220;
    public static final int KeyIsEnableSpeedReport = 8225;
    public static final int KeyIsEnableStorageModule = 10000;
    public static final int KeyIsEnableSyncDnsForPcdn = 7226;
    public static final int KeyIsEnableTTQuicHeLoaderCheckWithNetworkTypeI32 = 7353;
    public static final int KeyIsEnableThreadPoolCheckIdle = 7413;
    public static final int KeyIsEnableTraceidPreloadLog = 7440;
    public static final int KeyIsEnableUseFileExtendLoaderBuffer = 7229;
    public static final int KeyIsEnableUseGroupId = 7431;
    public static final int KeyIsEnableUseOriginalUrl = 7404;
    public static final int KeyIsEnableWaitNetReachable = 7419;
    public static final int KeyIsEnginePortraitStr = 7445;
    public static final int KeyIsEnginePortraitUpdateStr = 7446;
    public static final int KeyIsErrorStateTrustTime = 902;
    public static final int KeyIsFileCacheProgress = 3;
    public static final int KeyIsFileDeleteSizeByUsedTime = 902;
    public static final int KeyIsFileKeyRule = 12000;
    public static final int KeyIsFileManagerInterval = 7443;
    public static final int KeyIsFileRingBufferOptStr = 8302;
    public static final int KeyIsFirstRangeLeftThreshold = 7346;
    public static final int KeyIsForbidByPassCookie = 1510;
    public static final int KeyIsGetAllCacheSize = 100;
    public static final int KeyIsGetBatteryPct = 11009;
    public static final int KeyIsGetCacheInfo = 101;
    public static final int KeyIsGetCacheSize = 103;
    public static final int KeyIsGetCookieTokenLevel = 8303;
    public static final int KeyIsGetCostLog = 1011;
    public static final int KeyIsGetCustomHttpHeader = 1509;
    public static final int KeyIsGetDemuxerVersion = 7433;
    public static final int KeyIsGetDevModel = 11012;
    public static final int KeyIsGetDownloadCountByVid = 9217;
    public static final int KeyIsGetEnableHls = 9407;
    public static final int KeyIsGetFreeStorageKB = 11008;
    public static final int KeyIsGetFsV4Domain = 6401;
    public static final int KeyIsGetFsV6Domain = 6402;
    public static final int KeyIsGetIOManagerHandle = 7390;
    public static final int KeyIsGetIOManagerInterfaceVersion = 7402;
    public static final int KeyIsGetIoDiskEmptyHoleInfo = 1014;
    public static final int KeyIsGetIoWriteError = 1013;
    public static final int KeyIsGetIsOverHeat = 11011;
    public static final int KeyIsGetIsPowerSaveMode = 11010;
    public static final int KeyIsGetLoaderVersion = 11;
    public static final int KeyIsGetLocalAddr = 4;
    public static final int KeyIsGetMdlProtocolHandle = 7218;
    public static final int KeyIsGetMissReason = 112;
    public static final int KeyIsGetOfflineCacheFileInfo = 114;
    public static final int KeyIsGetPlayLog = 1010;
    public static final int KeyIsGetPreloadTraceId = 1012;
    public static final int KeyIsGetProxyUrl = 3512;
    public static final int KeyIsGetResStatus = 7231;
    public static final int KeyIsGetSpeedStatus = 7230;
    public static final int KeyIsGetTotalStorageKB = 11007;
    public static final int KeyIsGetUrlGenerator = 7425;
    public static final int KeyIsGetVersionInfo = 830;
    public static final int KeyIsGlobalSpeedSample = 703;
    public static final int KeyIsHeartBeatLog = 70;
    public static final int KeyIsHiJackError = 701;
    public static final int KeyIsHlsTsFileKeyGenerateType = 12001;
    public static final int KeyIsIOSpeedInfo = 5;
    public static final int KeyIsIgnorePlayInfo = 9400;
    public static final int KeyIsIgnoreTextSpeedTest = 7427;
    public static final int KeyIsInitialSocketTimeout = 7360;
    public static final int KeyIsIsCheckPreloadLevel = 6512;
    public static final int KeyIsIsChecksumLevel = 1504;
    public static final int KeyIsIsDownloadSource = 1506;
    public static final int KeyIsIsEnableDownloaderLog = 7347;
    public static final int KeyIsIsEnableTTNetLoader = 7348;
    public static final int KeyIsIsEnableTTQuicHeLoader = 7352;
    public static final int KeyIsIsEncryptVersion = 1505;
    public static final int KeyIsIsGetChecksumInfo = 1503;
    public static final int KeyIsIsMaxTlsVersion = 5512;
    public static final int KeyIsIsPreloadCancel = 7;
    public static final int KeyIsIsTestSpeedVersion = 1502;
    public static final int KeyIsLiveCacheThresholdHttpToP2p = 8006;
    public static final int KeyIsLiveCacheThresholdP2pToHttp = 8007;
    public static final int KeyIsLiveContainerString = 8021;
    public static final int KeyIsLiveEnableMdlProto = 8102;
    public static final int KeyIsLiveGetCurrentBitRate = 8004;
    public static final int KeyIsLiveGetLoaderType = 8103;
    public static final int KeyIsLiveGetP2pState = 8002;
    public static final int KeyIsLiveGetPlayCacheSec = 8003;
    public static final int KeyIsLiveLoaderEnable = 8100;
    public static final int KeyIsLiveLoaderP2pEnable = 8101;
    public static final int KeyIsLiveMaxTrySwitchP2pTimes = 8008;
    public static final int KeyIsLiveMobileDownloadAllow = 8011;
    public static final int KeyIsLiveMobileUploadAllow = 8010;
    public static final int KeyIsLivePlayInfoAudioMixingEnd = 8014;
    public static final int KeyIsLivePlayInfoAudioMixingStart = 8013;
    public static final int KeyIsLivePlayInfoIsPreview = 8016;
    public static final int KeyIsLivePlayInfoIsStreamReceived = 8015;
    public static final int KeyIsLiveRecvDataTimeout = 8012;
    public static final int KeyIsLiveSetLoaderType = 8000;
    public static final int KeyIsLiveSetP2pAllow = 8001;
    public static final int KeyIsLiveSetPrepareTask = 8017;
    public static final int KeyIsLiveSetTaskFinish = 8018;
    public static final int KeyIsLiveWaitP2pReadyThreshold = 8009;
    public static final int KeyIsLiveWatchDurationThreshold = 8005;
    public static final int KeyIsLoadMonitorMinAllowLoadSize = 7397;
    public static final int KeyIsLoadMonitorTimeInternal = 7396;
    public static final int KeyIsLoaderCacheSize = 9216;
    public static final int KeyIsLoaderEventCancel = 72;
    public static final int KeyIsLoaderEventCompleted = 73;
    public static final int KeyIsLoaderEventStart = 71;
    public static final int KeyIsLoaderEventUnKnown = 74;
    public static final int KeyIsLoaderFactoryP2PLevel = 8216;
    public static final int KeyIsLoaderFactoryP2PStragetyLevel = 8218;
    public static final int KeyIsLoaderFactoryXYLibValue = 8217;
    public static final int KeyIsLoaderTypeSwitch = 12;
    public static final int KeyIsMAXIPV4Num = 7331;
    public static final int KeyIsMAXIPV6Num = 7330;
    public static final int KeyIsMarkedFileIOSpeed = 1508;
    public static final int KeyIsMaxCacheSizeForDefaultDir = 7449;
    public static final int KeyIsMaxFileMemCacheNum = 5515;
    public static final int KeyIsMaxFileMemCacheSize = 5513;
    public static final int KeyIsMaxIpCountEachDomain = 900;
    public static final int KeyIsMaxIpNum = 8301;
    public static final int KeyIsMaxKeepAliveHostNum = 7364;
    public static final int KeyIsMaxLoaderLogNum = 7406;
    public static final int KeyIsMaxSocketReuseNum = 7361;
    public static final int KeyIsN80OptsStr = 7503;
    public static final int KeyIsNeedNetworkSwitch = 901;
    public static final int KeyIsNetCacheDir = 5510;
    public static final int KeyIsNetSchedulerBlockAllNetErr = 7343;
    public static final int KeyIsNetSchedulerBlockDurationMs = 7345;
    public static final int KeyIsNetSchedulerBlockErrCount = 7344;
    public static final int KeyIsNetSchedulerConfigStr = 7403;
    public static final int KeyIsNetUnreachableStopRetry = 7418;
    public static final int KeyIsNetUnreachableTimeout = 7422;
    public static final int KeyIsNetworkAccessType = 7219;
    public static final int KeyIsNetworkChanged = 7217;
    public static final int KeyIsNewBufferPoolGrowBlockCount = 7337;
    public static final int KeyIsNewBufferpoolBlockSize = 7335;
    public static final int KeyIsNewBufferpoolResidentSize = 7336;
    public static final int KeyIsNewPreloadLog = 1002;
    public static final int KeyIsNewProtocolLog = 1001;
    public static final int KeyIsNewProxyLog = 1000;
    public static final int KeyIsNewSampleLog = 1004;
    public static final int KeyIsNewTaskLog = 1003;
    public static final int KeyIsNextDownloadThreshold = 2511;
    public static final int KeyIsNonBlockRangeMaxSizeKB = 7417;
    public static final int KeyIsNonBlockRangeMode = 7416;
    public static final int KeyIsOnLiveLoaderError = 9;
    public static final int KeyIsOwnLiveLoaderLog = 10;
    public static final int KeyIsOwnLiveLoaderLogSample = 11;
    public static final int KeyIsOwnVdpLog = 1;
    public static final int KeyIsP2PConfigStr = 8221;
    public static final int KeyIsP2PCostTag = 7423;
    public static final int KeyIsP2PFirstRangeLoaderType = 7372;
    public static final int KeyIsP2PPredownPeerCount = 7359;
    public static final int KeyIsPlayInfoBufferingEnd = 7214;
    public static final int KeyIsPlayInfoBufferingStart = 7213;
    public static final int KeyIsPlayInfoCurrentBuffer = 7215;
    public static final int KeyIsPlayInfoLoadPercent = 7212;
    public static final int KeyIsPlayInfoPlayingPos = 7211;
    public static final int KeyIsPlayInfoRenderStart = 7210;
    public static final int KeyIsPlayTaskCacheEnd = 52;
    public static final int KeyIsPlayTaskEnd = 51;
    public static final int KeyIsPlayTaskState = 50;
    public static final int KeyIsPrecisePreloadConfig = 7434;
    public static final int KeyIsPreconnectNum = 2509;
    public static final int KeyIsPreloadEnd = 4;
    public static final int KeyIsPreloadFail = 8;
    public static final int KeyIsPreloadInfoRecordMaxCnt = 7439;
    public static final int KeyIsPreloadStragetyWhenPlay = 1030;
    public static final int KeyIsPreloadTraceIdRecordMaxCntI32 = 7424;
    public static final int KeyIsPreloadWaitListType = 1040;
    public static final int KeyIsProtectCacheDirAvoidClear = 7444;
    public static final int KeyIsQuickGetCacheSize = 106;
    public static final int KeyIsQuickQueryCacheSize = 113;
    public static final int KeyIsRingBufferSizeKB = 7221;
    public static final int KeyIsSessionCacheInterval = 7442;
    public static final int KeyIsSessionTimeout = 7333;
    public static final int KeyIsSetAlogFuncPtr = 1100;
    public static final int KeyIsSetBackupLoaderType = 7227;
    public static final int KeyIsSetCacheDir = 0;
    public static final int KeyIsSetCurDiskSizeMB = 11003;
    public static final int KeyIsSetCurMemorySizeMB = 11005;
    public static final int KeyIsSetDMDomain = 9402;
    public static final int KeyIsSetDemuxerHandle = 7432;
    public static final int KeyIsSetDevDiskSizeMB = 11002;
    public static final int KeyIsSetDevMemorySizeMB = 11004;
    public static final int KeyIsSetDomains = 9404;
    public static final int KeyIsSetDownLogMaxSize = 7429;
    public static final int KeyIsSetEnableMaxCacheAgeForAllDir = 111;
    public static final int KeyIsSetEnableOwnVdpPreloadNotify = 7395;
    public static final int KeyIsSetEnableReportTaskLog = 7371;
    public static final int KeyIsSetFileExtendSize = 7392;
    public static final int KeyIsSetForesightDomain = 9403;
    public static final int KeyIsSetGlobalSpeedSampleInterval = 7370;
    public static final int KeyIsSetKeyDomain = 9405;
    public static final int KeyIsSetKeyToken = 9406;
    public static final int KeyIsSetLiveListener = 107;
    public static final int KeyIsSetLoaderFactoryAppInfo = 10;
    public static final int KeyIsSetLoaderFactoryCacheDir = 9;
    public static final int KeyIsSetLoaderFactoryMaxCacheSize = 7;
    public static final int KeyIsSetLoaderFactoryMaxMemorySize = 8;
    public static final int KeyIsSetLoaderType = 6;
    public static final int KeyIsSetMaxCacheAge = 104;
    public static final int KeyIsSetMaxCacheSize = 1;
    public static final int KeyIsSetMdlExtensionOpts = 7500;
    public static final int KeyIsSetMdlTTQuicHeOpts = 7504;
    public static final int KeyIsSetMinAllowSpeed = 7393;
    public static final int KeyIsSetNetSchedulerBlockHostErrIpCount = 7394;
    public static final int KeyIsSetOnlyUseCdn = 7216;
    public static final int KeyIsSetOpenTimeOut = 3;
    public static final int KeyIsSetPcdnAuto = 12;
    public static final int KeyIsSetPlayInfoSeekAction = 7338;
    public static final int KeyIsSetPreconnectState = 8223;
    public static final int KeyIsSetPreloadParallelNum = 102;
    public static final int KeyIsSetRWTimeOut = 2;
    public static final int KeyIsSetSettingsDomain = 9401;
    public static final int KeyIsSetSocketRecvBuffer = 7401;
    public static final int KeyIsSetSpeedSampleInterval = 7368;
    public static final int KeyIsSetTryCount = 5;
    public static final int KeyIsSetUseNewSingSpeedTest = 7400;
    public static final int KeyIsSetVdpExtDynamicInfo = 11006;
    public static final int KeyIsSetVdpExtGlobalInfo = 11001;
    public static final int KeyIsSkipCDNBeforeExpiredSec = 7421;
    public static final int KeyIsSocketIdleTimeout = 702;
    public static final int KeyIsSocketSendBufferKB = 7220;
    public static final int KeyIsSocketTrainingCenterConfigStr = 7398;
    public static final int KeyIsSpeedCoefficientValue = 1507;
    public static final int KeyIsSpeedEngineSetting = 8226;
    public static final int KeyIsSpeedInfo = 2;
    public static final int KeyIsSpeedTestSampledByTime = 700;
    public static final int KeyIsSpeedTestSampledByTimeV2 = 702;
    public static final int KeyIsStoIoWriteLimitKBTh1 = 10004;
    public static final int KeyIsStoIoWriteLimitKBTh2 = 10005;
    public static final int KeyIsStoMaxIdleTimeSec = 10006;
    public static final int KeyIsStoPlayDldWinSizeKBLS = 10002;
    public static final int KeyIsStoPlayDldWinSizeKBNM = 10001;
    public static final int KeyIsStoRingBufferSizeKB = 10003;
    public static final int KeyIsStoStrategyConfig = 10007;
    public static final int KeyIsStoUpdateCacheDir = 7437;
    public static final int KeyIsStorageLog = 1005;
    public static final int KeyIsTTNetLoaderCronetBufSizeKB = 7349;
    public static final int KeyIsTTQuicHeCacheDir = 6513;
    public static final int KeyIsTaskFail = 20;
    public static final int KeyIsTaskLog = 0;
    public static final int KeyIsTaskOpen = 24;
    public static final int KeyIsTemporaryOptStr = 7502;
    public static final int KeyIsThreadPoolIdleTTLSecond = 7414;
    public static final int KeyIsThreadPoolMinCount = 7415;
    public static final int KeyIsThreadStackSizeLevel = 7412;
    public static final int KeyIsUpdateCacheFileInternal = 7436;
    public static final int KeyIsUpdateNetworkScore = 7409;
    public static final int KeyIsUpdateNetworkStrength = 7410;
    public static final int KeyIsVdpABTestId = 7223;
    public static final int KeyIsVdpGroupId = 7224;
    public static final int KeyIsWriteFileNotifyIntervalMS = 110;
    public static final int LogInfoKeyIsPcdnTaskLog = 13;
    public static final long LongValueViaConfigNotReady = -998;
    public static final long LongValueViaUnknownKey = -1;
    public static final int S_FAIL = -1;
    public static final int S_OK = 0;
    private static final String TAG = "AVMDLDataLoader";
    private static boolean isSupportQueryEncode = true;
    private static Context mGlobalApplicationContext = null;
    private static volatile AVMDLDataLoader mInstance = null;
    public static Boolean mIsByteMediaNetInit = null;
    private static volatile boolean mIsLibraryLoaded = false;
    private static volatile boolean mIsMdlByteMediaNetPluginLoaded = false;
    private static volatile boolean mIsMdlTtnetPluginLoaded = false;
    private static String mLoadFailMsg = "";
    private boolean isSupportGetAuth;
    private AVMDLDataLoaderConfigure mConfigure;
    private MDLDownloaderCallback mDownloaderCallback;
    private long mEndTime;
    private LoaderListener mEventListener;
    private long mHandle;
    private Handler mHandler;
    private AVMDLDataLoaderListener mLiveListener;
    private Handler mLogHandler;
    private Map<Integer, MDLDownloader> mMDLDownloaderMap;
    private Thread mMsgThread;
    private IAVMDLLibraryLoader mPluginLibraryLoader;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private AVMDLStartCompleteListener mStartCompleteListener;
    private volatile int mState;
    private AVMDLTaskEventListener mTaskListener;
    private boolean mTryedLoadP2pPlugin;
    private AVMDLDataLoaderListener mVodListener;
    private Map<String, AVMDLCopyOperation> mWaitingCopyItem;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    public class MDLDownloader {
        private static final String TAG = "MDLDownloader";
        private MDLDownloadConfig mConfig;
        final /* synthetic */ AVMDLDataLoader this$0;

        public class MDLDownloadConfig {
            public long mBid;
            public Map<String, String> mOptions;
            final /* synthetic */ MDLDownloader this$1;

            public MDLDownloadConfig(MDLDownloader r100, long r101, String r102) {
                this.this$1 = r100;
                this.mBid = r101;
                AVMDLLog.d(MDLDownloader.TAG, "MDLDownloadConfig mBid: " + this.mBid);
            }
        }

        public class MDLDownloadTask {
            final /* synthetic */ MDLDownloader this$1;

            public int asyncStart(MDLTaskCallback r100) {
                return -1;
            }

            public String getValue(String r100) {
                return null;
            }

            public int read(long r100, int r101, byte[] r102, int r103) {
                return -1;
            }

            public int setValue(String r100, String r101) {
                return -1;
            }

            public int stop(int r100) {
                return -1;
            }

            public MDLDownloadTask(MDLDownloader r100) {
                this.this$1 = r100;
            }
        }

        public class MDLTaskCallback {
            final /* synthetic */ MDLDownloader this$1;

            public int onData(int r100, long r101, long r102, byte[] r103) {
                return 0;
            }

            public int onError(int r100, int r101, String r102) {
                return 0;
            }

            public int onInfos(int r100, String r101, String r102) {
                return 0;
            }

            public int onResponse(int r100, int r101, long r102, String r103) {
                return 0;
            }

            public MDLTaskCallback(MDLDownloader r100) {
                this.this$1 = r100;
            }
        }

        public MDLDownloader(AVMDLDataLoader r100) {
            this.this$0 = r100;
        }

        public String getValue(int r100, String r101) {
            return AVMDLDataLoader.access$700(AVMDLDataLoader.access$400(this.this$0), r100, r101);
        }

        public int Init(int r100, String r101, MDLDownloaderCallback r102) {
            this.mConfig = new MDLDownloadConfig(this, r100, r101);
            return AVMDLDataLoader.access$500(AVMDLDataLoader.access$400(this.this$0), r100, r101, r102);
        }

        public int setValue(int r100, String r101, String r102) {
            return AVMDLDataLoader.access$600(AVMDLDataLoader.access$400(this.this$0), r100, r101, r102);
        }

        public MDLDownloadTask createTask(final int r100, String r110, Map<String, String> r111, Map<String, String> r112, String r113) {
            final long r114 = AVMDLDataLoader.access$800(AVMDLDataLoader.access$400(this.this$0), r100, r110, r111, r112, r113);
            AVMDLLog.d(TAG, "createHandler dlHandler: " + r114);
            if (r114 != 0) goto L6;
            AVMDLLog.d(TAG, "createHandler dlHandler = 0 ");
            return null;
        L6:
            MDLDownloadTask r115 = new AnonymousClass1(this, r100, r114);
            AVMDLLog.d(TAG, "new MDLDownloadTask");
            AVMDLLog.d(TAG, "task != null");
            return r115;
        }
    }

    public class MDLDownloaderCallback {
        final /* synthetic */ AVMDLDataLoader this$0;

        public int onInfos(int r100, int r101, long r102, String r103) {
            return 0;
        }

        public MDLDownloaderCallback(AVMDLDataLoader r100) {
            this.this$0 = r100;
        }
    }

    private static native void _addDataSource(long r100, int r101, String r102);

    private static native void _cancel(long r100, String r101);

    private static native void _cancelAll(long r100);

    private static native void _cancelAllPreloadWaitReqs(long r100);

    private static native void _cleanCacheDir(long r100, long r101);

    private static native void _cleanSpecifiedCacheDir(long r100, String r101, int r102);

    private static native void _clearAllCaches(long r100);

    private static native long _clearAndGetCachesByUsedTime(long r100, long r101, int r102);

    private static native void _clearCachesByUsedTime(long r100, long r101);

    private static native void _clearNetinfoCache(long r100);

    private static native void _close(long r100);

    private static native int _copyFile(long r100, String r101, String r102);

    private static native long _copyFile64(long r100, String r101, String r102);

    private static native int _copyFileWithCustomDir(long r100, String r101, String r102, String r103);

    private static native long _copyFileWithCustomDir64(long r100, String r101, String r102, String r103);

    private static native int _copyFileWithForceFlag(long r100, String r101, String r102, int r103);

    private static native long _copyFileWithForceFlag64(long r100, String r101, String r102, int r103);

    private final native long _create();

    private static native int _dhAsyncStart(long r100, long r101, MDLDownloader.MDLTaskCallback r102);

    private static native String _dhGetValue(long r100, long r101, String r102);

    private static native int _dhRead(long r100, long r101, long r102, int r103, byte[] r104, int r105);

    private static native int _dhSetValue(long r100, long r101, String r102, String r103);

    private static native int _dhStop(long r100, long r101, int r102);

    private static native int _dmBussinessInit(long r100, int r101, String r102, MDLDownloaderCallback r103);

    private static native long _dmCreateHandler(long r100, int r101, String r102, Map<String, String> r103, Map<String, String> r104, String r105);

    private static native int _dmDeleteHandler(long r100, int r101, long r102);

    private static native String _dmGetValue(long r100, int r101, String r102);

    private static native int _dmSetValue(long r100, int r101, String r102, String r103);

    private static native void _downloadResource(long r100, String r101);

    private static native String _encodeUrl(String r100, int r101);

    private static native void _forceClearAllCaches(long r100);

    private static native void _forceRemoveCacheFile(long r100, String r101);

    private static native String _getAuth(long r100, String r101);

    private static native String _getCDNLog(long r100, String r101);

    private static native long _getContinueCacheSize(long r100, String r101, int r102, long r103);

    private static native int _getIsFileCacheComplete(long r100, String r101);

    private static native long _getLongValue(long r100, int r101);

    private static native long _getLongValueByStr(long r100, String r101, int r102);

    private static native long _getLongValueByStrStr(long r100, String r101, String r102, int r103);

    private static native String _getStringValue(long r100, int r101);

    private static native String _getStringValueByStr(long r100, String r101, int r102);

    private static native String _getStringValueByStrStr(long r100, String r101, String r102, int r103);

    private static native int _haveRunningPlayTask(long r100, String r101);

    private static native void _makeFileAutoDeleteFlag(long r100, String r101, int r102);

    private static native String _makeTsFileKey(String r100, String r101);

    private static native int _onCellularAlwaysUp(long r100, long r101, int r102);

    private static native int _onInitMultiNetworkEnv(long r100, int r101);

    private static native void _p2pPredown(long r100, String r101);

    private static native void _preConnectByHost(long r100, String r101, int r102);

    private static native void _preloadGroupResource(long r100, String r101, String r102, long r103, long r104);

    private static native void _preloadResource(long r100, String r101, long r102);

    private static native void _preloadResourceWithOffset(long r100, String r101, long r102, long r103);

    private static native void _removeCacheFile(long r100, String r101);

    private static native void _resetPreloadTraceId(long r100, String r101);

    private static native void _resumeFileWriteIO(long r100);

    private static native void _setInt64Value(long r100, int r101, long r102);

    private static native void _setInt64ValueByStrKey(long r100, int r101, String r102, long r103);

    private static native void _setIntValue(long r100, int r101, int r102);

    private static native void _setStringValue(long r100, int r101, String r102);

    private static native int _start(long r100);

    private static native int _startPcdn(long r100);

    private static native void _stop(long r100);

    private static native void _suspendedDownload(long r100, String r101);

    private static native int _tryDownloadPlayReqByKey(long r100, String r101);

    private static native void _updateDNSInfo(long r100, String r101, String r102, long r103, String r104, int r105);

    private static native int _writeDataToFile(long r100, String r101, long r102, long r103, int r104, byte[] r105);

    public static /* synthetic */ String a(AVMDLCopyOperation r100) {
        return lambda$handleCopyMsg$0(r100);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    private boolean isNotifyInfo(int r100) {
        if (r100 != 4) goto L5;
    L30:
        return true;
    L5:
        if (r100 == 20) goto L30;
        if (r100 == 50) goto L30;
        if (r100 == 8) goto L30;
        if (r100 == 3) goto L30;
        if (r100 == 21) goto L30;
        if (r100 == 51) goto L30;
        if (r100 == 7) goto L30;
        if (r100 == 22) goto L30;
        if (r100 == 52) goto L30;
        if (r100 == 901) goto L30;
        if (r100 == 24) goto L30;
        if (r100 == 902) goto L30;
        return false;
    }

    public static boolean isVCBasekitStaticLinked() {
        return false;
    }

    private void tryLoadQuicPluginInternal() {
    }

    static {
        mIsByteMediaNetInit = Boolean.FALSE;
    }

    public static Context getApplicationContext() {
        monitor-enter(AVMDLDataLoader.class);
        Context r100 = mGlobalApplicationContext;     // Catch: Throwable -> L7
        monitor-exit(AVMDLDataLoader.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static AVMDLDataLoader getInstance() {
        if (mInstance != null) goto L19;
        monitor-enter(AVMDLDataLoader.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (mInstance == null) goto L22;
    L13:
        monitor-exit(AVMDLDataLoader.class);     // Catch: Throwable -> L15
        goto L19
    L22:
        mInstance = new AVMDLDataLoader(null);     // Catch: Exception -> L11 Throwable -> L15
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        e.toString();     // Catch: Throwable -> L15
        mInstance = null;     // Catch: Throwable -> L15
    L19:
        return mInstance;
    }

    public static synchronized String getLoadFailMsg() {
        monitor-enter(AVMDLDataLoader.class);
        String r100 = mLoadFailMsg;     // Catch: Throwable -> L7
        monitor-exit(AVMDLDataLoader.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private String getProxyUrl() {
        AVMDLLog.d("AVMDLProxy", "----try get proxyaddr");
        String r100 = System.getProperty("http.proxyHost");
        AVMDLLog.d("AVMDLProxy", "proxy host:" + r100);
        if (TextUtils.isEmpty(r100) == true) goto L7;
        String r101 = System.getProperty("http.proxyPort");
        AVMDLLog.d("AVMDLProxy", "proxy port:" + r101);
        if (TextUtils.isEmpty(r101) == true) goto L7;
        String r102 = "http://" + r100 + ":" + r101 + HTTP.URL_DEFAULT;
    L8:
        AVMDLLog.d("AVMDLProxy", "****end get proxyaddr, result:" + r102);
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    private void hijack() {
        AVMDLLog.d("ttmdljava", "----hijack start");
        AVMDLDNSParser.processHijack();
        AVMDLLog.d("ttmdljava", "hijack clear net cache: ");
        clearNetinfoCache();
        AVMDLLog.d("ttmdljava", "****hijack end");
    }

    public static synchronized int initDependency() {
        monitor-enter(AVMDLDataLoader.class);
        pc4.a.b();     // Catch: Throwable -> L8
        VcnlibloadWrapper.tryLoadVcnlib();     // Catch: Throwable -> L8
        VcnlibloadWrapper.tryLoadVcnverifylib();     // Catch: Throwable -> L8
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    private void initNativeHandle() {
        if (this.mHandle == 0) goto L18;
        return;
    L18:
        this.mHandle = _create();     // Catch: Throwable -> L7
    L10:
        if (this.mHandle != 0) goto L12;
        return;
    L12:
        if (this.mHandler == null) goto L14;
        return;
    L14:
        if (Looper.myLooper() == null) goto L16;
        this.mHandler = new Handler(this);
        return;
    L16:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        return;
    L7:
        th = move-exception;
        this.mHandle = 0;
        th.printStackTrace();
        goto L10
    }

    public static synchronized int initWithLibraryManager() {
        monitor-enter(AVMDLDataLoader.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        int r100 = 0;
        if (mIsLibraryLoaded == false) goto L10;
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L10:
        if (AVMDLLibraryManager.loadLibraries() == false) goto L12;
        mIsLibraryLoaded = true;     // Catch: Throwable -> L18
    L12:
        if (mIsLibraryLoaded == true) goto L16;
        r100 = -1;
    L16:
        monitor-exit(AVMDLDataLoader.class);
        return r100;
    }

    public static synchronized void loadAVMDLBaseLibrary() {
        monitor-enter(AVMDLDataLoader.class);
        initDependency();     // Catch: Throwable -> L13
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdlbase");     // Catch: Throwable -> L7 UnsatisfiedLinkError -> L9
    L11:
        monitor-exit(AVMDLDataLoader.class);
        return;
    L9:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L13
    L7:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void startInternal() {
        this.mWriteLock.lock();
    L34:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mState == 1) goto L13;
        initLogThread(this);     // Catch: Throwable -> L34
        if (this.mHandle == 0) goto L13;
        if (this.mConfigure.mLoadP2pPluginAfterMdlStart != 0) goto L10;
        this.mTryedLoadP2pPlugin = true;     // Catch: Throwable -> L34
        tryLoadP2pPluginInternal();     // Catch: Throwable -> L34
    L10:
        tryLoadQuicPluginInternal();     // Catch: Throwable -> L34
        setConfigureInternal(this.mConfigure);     // Catch: Throwable -> L34
        if (_start(this.mHandle) < 0) goto L13;
        this.mState = 1;     // Catch: Throwable -> L34
    L13:
        this.mWriteLock.unlock();
        if (this.mConfigure.mEnableBenchMarkIOSpeed <= 0) goto L18;
        int r100 = testFileIOSpeed();
        AVMDLLog.d("BENCHMARKIO", String.format(Locale.US, "test io average speed:%d", new Object[]{Integer.valueOf(r100)}));
        if (r100 <= 0) goto L18;
        setIntValue(1508, r100);
    L18:
        AVMDLStartCompleteListener r101 = this.mStartCompleteListener;
        if (r101 == null) goto L22;
        r101.onStartComplete();
    L22:
        if (this.mConfigure.mLoadP2pPluginAfterMdlStart == 0) goto L28;
        this.mWriteLock.lock();
        if (this.mTryedLoadP2pPlugin == true) goto L26;
        this.mTryedLoadP2pPlugin = true;
        tryLoadP2pPluginInternal();
    L26:
        this.mWriteLock.unlock();
    L28:
        if (this.mState == 1) goto L30;
    L32:
        AVMDLMultiNetwork.registerNetworkChangeCallback(getApplicationContext());
        return;
    L30:
        if (this.mConfigure.mEnableCellularUp <= 0) goto L32;
        AVMDLLog.d(TAG, "start try up cellular");
        AVMDLMultiNetwork.alwayUpCellular(getApplicationContext());
        AVMDLLog.d(TAG, "end try up cellular");
        goto L32
    }

    private void startPcdnInternal() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r5.mWriteLock
            r0.lock()
            int r0 = r5.mState     // Catch: java.lang.Throwable -> L25 java.lang.UnsatisfiedLinkError -> L2c
            r1 = 1
            if (r0 != r1) goto L1f
            long r0 = r5.mHandle     // Catch: java.lang.Throwable -> L25 java.lang.UnsatisfiedLinkError -> L2c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L1f
            int r0 = _startPcdn(r0)     // Catch: java.lang.Throwable -> L25 java.lang.UnsatisfiedLinkError -> L2c
            if (r0 < 0) goto L1f
            java.lang.String r0 = "AVMDLDataLoader"
            java.lang.String r1 = "delay start pcdn succ"
            com.ss.mediakit.medialoader.AVMDLLog.d(r0, r1)     // Catch: java.lang.Throwable -> L25 java.lang.UnsatisfiedLinkError -> L2c
        L1f:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r5.mWriteLock
            r0.unlock()
            goto L33
        L25:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r0.toString()     // Catch: java.lang.Throwable -> L34
            goto L1f
        L2c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r0.toString()     // Catch: java.lang.Throwable -> L34
            goto L1f
        L33:
            return
        L34:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r5.mWriteLock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.mediakit.medialoader.AVMDLDataLoader.startPcdnInternal():void");
    }

    private int testFileIOSpeed() {
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir) == false) goto L5;
        return -1;
    L5:
        String r100 = this.mConfigure.mCacheDir;
        if (r100.charAt(r100.length() - 1) != '/') goto L8;
        String r101 = String.format(Locale.US, "%siospeed", new Object[]{this.mConfigure.mCacheDir});
    L9:
        String r102 = r101;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == true) goto L12;
        r103.mkdirs();
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, "iospeed.cach");
        if (r104.exists() == false) goto L50;
        r104.delete();
    L50:
        RandomAccessFile r105 = new RandomAccessFile(r104, "rw");     // Catch: Exception -> L43
        int r106 = 0;
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L18:
        if (r106 >= 30) goto L33;
        double r112 = testFileIO(r102, r106, r105);     // Catch: Exception -> L24 Throwable -> L35
        AVMDLLog.d("BENCHMARKIO", String.format(Locale.US, "num:%d result:%f", new Object[]{Integer.valueOf(r106), Double.valueOf(r112)}));     // Catch: Exception -> L22 Throwable -> L35
    L28:
        if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        if (r106 < 20) goto L32;
        r111 = r111 + r112;     // Catch: Throwable -> L35 Exception -> L37
        r110 = r110 + 1.0d;     // Catch: Throwable -> L35 Exception -> L37
    L39:
        if (r110 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
        return 0;
    L41:
        return (int) (r111 / r110);
    L32:
        r106 = r106 + 1;     // Catch: Throwable -> L35 Exception -> L37
    L22:
        e = e;
    L26:
        AVMDLLog.d("BENCHMARKIO", "test fileio exception:" + e);     // Catch: Throwable -> L35 Exception -> L37
        e.printStackTrace();     // Catch: Throwable -> L35 Exception -> L37
    L35:
        th = move-exception;
        throw th;
    L24:
        e = e;
        r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L26
    L33:
        r105.close();     // Catch: Throwable -> L35 Exception -> L37
        r104.delete();     // Catch: Throwable -> L35 Exception -> L37
    L43:
        e = move-exception;
        AVMDLLog.d("BENCHMARKIO", "create accefile exception:" + e);
        return -1;
    L8:
        r101 = String.format(Locale.US, "%s/iospeed", new Object[]{this.mConfigure.mCacheDir});
        goto L9
    }

    public static synchronized boolean tryLoadByteMediaNetLoaderPlugin() {
        monitor-enter(AVMDLDataLoader.class);
        boolean r100 = mIsMdlByteMediaNetPluginLoaded;     // Catch: Throwable -> L7
        monitor-exit(AVMDLDataLoader.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private void tryLoadP2pPluginInternal() {
        if (this.mPluginLibraryLoader == null) goto L17;
        AVMDLLog.e(TAG, "try to load p2p lib by mdl");     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        boolean r100 = this.mPluginLibraryLoader.loadLibrary("avmdlp2p");     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        Locale r101 = Locale.US;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        int r102 = 1;
        Object[] r103 = new Object[1];     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == true) goto L8;
        r102 = 0;
    L8:
        r103[0] = Integer.valueOf(r102);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        AVMDLLog.e(TAG, String.format(r101, "load p2p lib by mdl result:%d", r103));     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L19:
        return;
    L12:
        e = move-exception;
        e.toString();
        return;
    L10:
        th = move-exception;
        th.toString();
        return;
    }

    public static synchronized boolean tryLoadTTNetLoaderPlugin() {
        monitor-enter(AVMDLDataLoader.class);
        boolean r100 = mIsMdlTtnetPluginLoaded;     // Catch: Throwable -> L7
        monitor-exit(AVMDLDataLoader.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public void cancelAll() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == 0) goto L9;
        _cancelAll(r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void cancelAllPreloadWaitReqs() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mReadLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == 0) goto L9;
        _cancelAllPreloadWaitReqs(r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mReadLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public void clearAllCaches() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == 0) goto L9;
        _clearAllCaches(r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void clearNetinfoCache() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        IPCache.getInstance().clear();
        this.mWriteLock.lock();
        _clearNetinfoCache(this.mHandle);     // Catch: Throwable -> L8 UnsatisfiedLinkError -> L10
    L7:
        this.mWriteLock.unlock();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void close() {
        this.mWriteLock.lock();
        if (this.mState == 1) goto L22;
        return;
    L22:
        long r100 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r100 == 0) goto L13;
        _close(r100);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        this.mHandle = 0;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        this.mState = 5;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        Handler r101 = this.mHandler;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r101 == null) goto L10;
        r101.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        this.mHandler = null;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
    L10:
        Handler r102 = this.mLogHandler;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == null) goto L13;
        r102.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        ThreadMethodProxy.quit(this.mLogHandler.getLooper());     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        this.mLogHandler = null;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        this.mMsgThread = null;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
    L13:
        this.mWriteLock.unlock();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void forceClearAllCaches() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == 0) goto L9;
        _forceClearAllCaches(r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public long getAllCacheSize() {
        long r100 = -1;
        if (this.mState == 1) goto L5;
        return -1;
    L5:
        this.mReadLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        if (r101 == 0) goto L10;
        r100 = _getLongValue(r101, 100);     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        goto L10
    L10:
        this.mReadLock.unlock();
        return r100;
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        goto L10
    }

    public AVMDLDataLoaderConfigure getConfig() {
        if (this.mState == 1) goto L7;
        return null;
    L7:
        return this.mConfigure;
    }

    public String getLocalAddr() {
        String r100 = null;
        if (this.mState == 1) goto L5;
        return null;
    L5:
        this.mReadLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        if (r101 == 0) goto L10;
        r100 = _getStringValue(r101, 4);     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        goto L10
    L10:
        this.mReadLock.unlock();
        return r100;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public boolean isRunning() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void resumeFileWriteIO() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        AVMDLLog.d(TAG, "resume file write io: ");
        this.mWriteLock.lock();
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L7:
        if (this.mConfigure.mMaxFileMemCacheSize <= 0) goto L13;
        _resumeFileWriteIO(this.mHandle);     // Catch: Throwable -> L10 Throwable -> L15
        this.mConfigure.mMaxFileMemCacheSize = 0;     // Catch: Throwable -> L10 Throwable -> L15
    L13:
        this.mWriteLock.unlock();
    }

    public void resumePreConnect() {
        setIntValue(KeyIsSetPreconnectState, 0);
    }

    public int start() {
        if (this.mState != 1) goto L5;
        return 0;
    L5:
        initNativeHandle();
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass2(this), TAG));
        return 0;
    }

    public int startPcdn() {
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass3(this), TAG));
        return 0;
    }

    public void stop() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r100 == 0) goto L9;
        _stop(r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void suspendPreconnect() {
        setIntValue(KeyIsSetPreconnectState, 1);
    }

    public static boolean tryLoadVcnverifylib() {
        if (VcnlibloadWrapper.tryLoadVcnlib() == true) goto L6;
        AVMDLLog.d("vcn", "load vcnverify fail");
        return false;
    L6:
        AVMDLLog.d("vcn", "load vcnverify suc");
        return true;
    }

    public int onInitMultiNetworkEnv() {
        AVMDLLog.d(TAG, "start on init multinetwork env");
        this.mWriteLock.lock();
        int r100 = -1;
        long r101 = this.mHandle;     // Catch: Throwable -> L12 Throwable -> L7
        if (r101 == 0) goto L6;
        r100 = _onInitMultiNetworkEnv(r101, Build.VERSION.SDK_INT);     // Catch: Throwable -> L12 Throwable -> L7
    L7:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L6:
        this.mWriteLock.unlock();
        AVMDLLog.d(TAG, "end on init multinetwork env");
        return r100;
    }

    private AVMDLDataLoader(AVMDLDataLoaderConfigure r100) throws Exception {
        this.mState = -1;
        this.mHandler = null;
        this.mLogHandler = null;
        this.mConfigure = null;
        this.mPluginLibraryLoader = null;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r101;
        this.mMsgThread = null;
        this.isSupportGetAuth = true;
        this.mStartCompleteListener = null;
        this.mWaitingCopyItem = new HashMap();
        this.mTaskListener = null;
        this.mMDLDownloaderMap = new HashMap();
        this.mTryedLoadP2pPlugin = false;
        initNativeHandle();
        this.mReadLock = r101.readLock();
        this.mWriteLock = r101.writeLock();
        if (this.mHandle == 0) goto L7;
        initLogThread(this);
        this.mConfigure = r100;
        this.mState = 0;
        this.isSupportGetAuth = true;
        return;
    L7:
        throw new Exception("create native mdl fail");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void _copyInternal(AVMDLCopyOperation r100) {
        if (TextUtils.isEmpty(r100.mCustomDir) == false) goto L5;
        long r101 = copyFile(r100.mFileKey, r100.mDestPath, r100.mForceCopyUnfinished);
    L6:
        AVMDLFileInfo r102 = getCacheInfo(r100.mFileKey);
        if (r102 != null) goto L12;
        AVMDLCopyOperationListener r103 = r100.mListener;
        if (r103 == null) goto L27;
        r103.onCopyComplete(false, -5, "copy failed. file info null " + r101);
        return;
    L27:
        return;
    L12:
        AVMDLCopyOperationListener r104 = r100.mListener;
        if (r104 == null) goto L15;
        r104.onFileInfo(r102);
    L15:
        AVMDLLog.d(TAG, "copy file result: " + r101);
        AVMDLCopyOperationListener r105 = r100.mListener;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r101 != r102.mCacheSize) goto L20;
    L25:
        r105.onCopyComplete(true, 0, "copy success.");
        return;
    L20:
        if (r101 == r102.mContentLenght) goto L25;
        if (r101 == 0) goto L25;
        r105.onCopyComplete(false, -5, "copy failed.copy error code " + r101);
        return;
    L5:
        r101 = copyFile(r100.mFileKey, r100.mCustomDir, r100.mDestPath);
        goto L6
    }

    public static /* synthetic */ MDLDownloaderCallback access$100(AVMDLDataLoader r100) {
        return r100.mDownloaderCallback;
    }

    public static /* synthetic */ void access$200(AVMDLDataLoader r100) {
        r100.startInternal();
    }

    public static /* synthetic */ void access$300(AVMDLDataLoader r100) {
        r100.startPcdnInternal();
    }

    public static /* synthetic */ long access$400(AVMDLDataLoader r100) {
        return r100.mHandle;
    }

    private void copyInternal(AVMDLCopyOperation r110) {
        if (r110 != null) goto L5;
    L44:
        AVMDLLog.d(TAG, "copy file invalid filekey or destpath is null");
        if (r110 == null) goto L54;
        AVMDLCopyOperationListener r111 = r110.mListener;
        if (r111 == null) goto L55;
        r111.onCopyComplete(false, -1, "invalid parameter");
        return;
    L55:
        return;
    L54:
        return;
    L5:
        if (TextUtils.isEmpty(r110.mFileKey) == true) goto L44;
        if (TextUtils.isEmpty(r110.mDestPath) == true) goto L44;
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r100 == 0) goto L50;
        int r101 = _getIsFileCacheComplete(r100, r110.mFileKey);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r101 != 1) goto L15;
        _copyInternal(r110);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        goto L50
    L15:
        if (r101 != (-1)) goto L20;
        AVMDLCopyOperationListener r102 = r110.mListener;     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r102 == null) goto L50;
        r102.onCopyComplete(false, -6, "cache file read writer failed.");     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        goto L50
    L20:
        if (r110.mForceCopyUnfinished == false) goto L23;
        _copyInternal(r110);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        goto L50
    L23:
        if (r110.mWaitIfCaching == false) goto L30;
        int r103 = _haveRunningPlayTask(this.mHandle, r110.mFileKey);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        AVMDLLog.d(TAG, "try download play " + r110.mFileKey + " result: " + r103);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r103 <= 0) goto L27;
        this.mWaitingCopyItem.put(r110.mFileKey, r110);     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        goto L50
    L27:
        AVMDLCopyOperationListener r104 = r110.mListener;     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r104 == null) goto L50;
        r104.onCopyComplete(false, -4, "file key not playing.");     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        goto L50
    L30:
        AVMDLCopyOperationListener r105 = r110.mListener;     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
        if (r105 == null) goto L50;
        r105.onCopyComplete(false, -3, "cache not finish.");     // Catch: Throwable -> L34 UnsatisfiedLinkError -> L36
    L50:
    L33:
        this.mWriteLock.unlock();
        return;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        AVMDLCopyOperationListener r112 = r110.mListener;     // Catch: Throwable -> L34
        if (r112 == null) goto L33;
        r112.onCopyComplete(false, -2, "medialoader not running");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    private String encodeUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return r100;
    L9:
        return URLEncoder.encode(r100, "UTF-8");
    L7:
        return null;
    }

    private void handleCopyMsg(AVMDLDataLoaderNotifyInfo r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r110.logInfo) == true) goto L51;
        int r100 = r110.what;
        if (r100 == 3) goto L9;
        if (r100 == 51) goto L9;
        return;
    L9:
        String[] r101 = r110.logInfo.split(",");
        if (r101.length >= 4) goto L12;
        return;
    L12:
        long r102 = CastLongProtector.valueOf(r101[0]).longValue();
        long r103 = CastLongProtector.valueOf(r101[1]).longValue();
        if (r103 <= 0) goto L15;
    L17:
        String r104 = r101[2];
        if (this.mWaitingCopyItem.containsKey(r104) == false) goto L45;
        final AVMDLCopyOperation r105 = this.mWaitingCopyItem.get(r104);
        if (r102 != r103) goto L33;
        if (r105 != null) goto L23;
        return;
    L23:
        if (TextUtils.isEmpty(r105.mFileKey) == true) goto L42;
        long r106 = copyFile(r105.mFileKey, r105.mDestPath, r105.mForceCopyUnfinished);
        AVMDLCopyOperationListener r111 = r105.mListener;
        if (r111 != null) goto L28;
        return;
    L28:
        if (r106 != 0) goto L30;
        r111.onCopyComplete(true, 0, "copy success.");
        return;
    L30:
        r111.onCopyComplete(false, -5, "copy failed.");
        return;
    L42:
        return;
    L33:
        if (r110.what == 51) goto L35;
        return;
    L35:
        if (_haveRunningPlayTask(this.mHandle, r105.mFileKey) <= 0) goto L38;
        AVMDLLog.d(TAG, new a(r105));
        return;
    L38:
        AVMDLCopyOperationListener r112 = r105.mListener;
        if (r112 == null) goto L50;
        r112.onCopyComplete(false, -3, "copy failed.");
        return;
    L50:
        return;
    L45:
        return;
    L15:
        if (r110.what == 4) goto L17;
        return;
    }

    public static synchronized int init(boolean r100) {
        monitor-enter(AVMDLDataLoader.class);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (mIsLibraryLoaded == false) goto L9;
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L9:
        mIsLibraryLoaded = r100;     // Catch: Throwable -> L26
        if (mIsLibraryLoaded == true) goto L19;
        pc4.a.b();     // Catch: Throwable -> L26
        VcnlibloadWrapper.tryLoadVcnlib();     // Catch: Throwable -> L26
        loadAVMDLBaseLibrary();     // Catch: Throwable -> L26
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdl");     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        mIsLibraryLoaded = true;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
    L18:
        VcnlibloadWrapper.tryLoadVcnverifylib();     // Catch: Throwable -> L26
        tryLoadTTNetLoaderPlugin();     // Catch: Throwable -> L26
        tryLoadByteMediaNetLoaderPlugin();     // Catch: Throwable -> L26
        goto L19
    L14:
        th = move-exception;
        mLoadFailMsg = "other exception when loading avmdl library: " + th;     // Catch: Throwable -> L26
        th.toString();     // Catch: Throwable -> L26
    L16:
        e = move-exception;
        mLoadFailMsg = "Can't load avmdl library: " + e;     // Catch: Throwable -> L26
        e.toString();     // Catch: Throwable -> L26
    L19:
        if (mIsLibraryLoaded == true) goto L24;
        monitor-exit(AVMDLDataLoader.class);
        return -1;
    L24:
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    }

    public static void initApplicationContext(Context r100) {
        monitor-enter(AVMDLDataLoader.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mGlobalApplicationContext != null) goto L7;
        mGlobalApplicationContext = r100;     // Catch: Throwable -> L9
    L7:
        monitor-exit(AVMDLDataLoader.class);     // Catch: Throwable -> L9
    }

    private void initLogThread(final Handler.Callback r100) {
        if (this.mMsgThread != null) goto L6;
        PthreadThreadV2 r101 = new AnonymousClass1(this, r100);
        this.mMsgThread = r101;
        ThreadMethodProxy.setName(r101, "mdl_log_handler");
        ThreadMethodProxy.start(this.mMsgThread);
        return;
    }

    private static /* synthetic */ String lambda$handleCopyMsg$0(AVMDLCopyOperation r100) {
        return String.format(Locale.US, "have running playtask skip, %s", new Object[]{r100.mFileKey});
    }

    public static String queryComponentEncode(String r100) {
        if (isSupportQueryEncode == true) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        AVMDLLog.d(TAG, "before encode, src: " + r100);
        return _encodeUrl(r100, 4);
    L10:
        e = move-exception;
        AVMDLLog.d(TAG, "query ComponentEncode:err " + e.getMessage());
        AVMDLLog.d(TAG, "query ComponentEncode:stacktrace " + e.getStackTrace());
    L12:
        e = move-exception;
        isSupportQueryEncode = false;
        AVMDLLog.d(TAG, "query ComponentEncode:err " + e.getMessage());
        AVMDLLog.d(TAG, "query ComponentEncode:stacktrace " + e.getStackTrace());
        goto L14
    }

    private void setConfigureInternal(AVMDLDataLoaderConfigure r110) {
        if (this.mHandle == 0) goto L158;
        if (r110 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r110.mCacheDir) == true) goto L16;
        String r100 = createFilePathBaseDir(r110.mCacheDir, "loaderFactory");
        if (TextUtils.isEmpty(r100) == true) goto L12;
        _setStringValue(this.mHandle, 9, r100);
    L12:
        if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir) == false) goto L14;
        r110.mNetCacheDir = createFilePathBaseDir(r110.mCacheDir, "netCache");
    L14:
        _setStringValue(this.mHandle, 0, r110.mCacheDir);
    L16:
        if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir) == true) goto L19;
        _setStringValue(this.mHandle, KeyIsNetCacheDir, r110.mNetCacheDir);
        String r101 = createFilePathBaseDir(r110.mNetCacheDir, "ttquiche");
        r110.mTTquicheCacheDir = r101;
        _setStringValue(this.mHandle, KeyIsTTQuicHeCacheDir, r101);
    L19:
        if (TextUtils.isEmpty(r110.mAppInfo) == true) goto L22;
        _setStringValue(this.mHandle, 10, r110.mAppInfo);
    L22:
        if (TextUtils.isEmpty(r110.mDownloadDir) == true) goto L25;
        _setStringValue(this.mHandle, KeyIsDownloadDir, r110.mDownloadDir);
    L25:
        if (TextUtils.isEmpty(r110.mMdlExtensionOptsStr) == true) goto L28;
        _setStringValue(this.mHandle, KeyIsSetMdlExtensionOpts, r110.mMdlExtensionOptsStr);
    L28:
        if (TextUtils.isEmpty(r110.mMdlTTQuicHeOptsStr) == true) goto L31;
        _setStringValue(this.mHandle, KeyIsSetMdlTTQuicHeOpts, r110.mMdlTTQuicHeOptsStr);
    L31:
        if (TextUtils.isEmpty(r110.mTemporaryOptStr) == true) goto L34;
        _setStringValue(this.mHandle, KeyIsTemporaryOptStr, r110.mTemporaryOptStr);
    L34:
        if (TextUtils.isEmpty(r110.mN80OptsStr) == true) goto L37;
        _setStringValue(this.mHandle, KeyIsN80OptsStr, r110.mN80OptsStr);
    L37:
        if (TextUtils.isEmpty(r110.mSpeedEngineSetting) == true) goto L40;
        _setStringValue(this.mHandle, KeyIsSpeedEngineSetting, r110.mSpeedEngineSetting);
    L40:
        if (TextUtils.isEmpty(r110.mPrecisePreloadConfigStr) == true) goto L42;
        _setStringValue(this.mHandle, KeyIsPrecisePreloadConfig, r110.mPrecisePreloadConfigStr);
    L42:
        _setIntValue(this.mHandle, 8001, r110.mLiveP2pAllow);
        _setIntValue(this.mHandle, 8000, r110.mLiveLoaderType);
        _setIntValue(this.mHandle, 8005, r110.mLiveWatchDurationThreshold);
        _setIntValue(this.mHandle, 8006, r110.mLiveCacheThresholdHttpToP2p);
        _setIntValue(this.mHandle, 8007, r110.mLiveCacheThresholdP2pToHttp);
        _setIntValue(this.mHandle, 8008, r110.mLiveMaxTrySwitchP2pTimes);
        _setIntValue(this.mHandle, 8009, r110.mLiveWaitP2pReadyThreshold);
        _setIntValue(this.mHandle, 8010, r110.mLiveMobileUploadAllow);
        _setIntValue(this.mHandle, 8011, r110.mLiveMobileDownloadAllow);
        _setIntValue(this.mHandle, 8012, r110.mLiveRecvDataTimeout);
        _setStringValue(this.mHandle, 8021, r110.mLiveContainerString);
        _setIntValue(this.mHandle, 1, r110.mMaxCacheSize);
        _setIntValue(this.mHandle, 2, r110.mRWTimeOut);
        _setIntValue(this.mHandle, 3, r110.mOpenTimeOut);
        _setIntValue(this.mHandle, 5, r110.mTryCount);
        _setIntValue(this.mHandle, 7, r110.mMaxCacheSize);
        _setIntValue(this.mHandle, 8, r110.mLoaderFactoryMaxMemorySize);
        int r102 = r110.mEnablePcdnAuto;
        if (r102 != 1) goto L45;
        _setIntValue(this.mHandle, 12, r102);
    L46:
        _setIntValue(this.mHandle, 102, r110.mPreloadParallelNum);
        _setIntValue(this.mHandle, 800, r110.mIsCloseFileCache);
        int r103 = r110.mMaxCacheAge;
        if (r103 <= 0) goto L49;
        _setIntValue(this.mHandle, 104, r103);
    L49:
        _setIntValue(this.mHandle, 111, r110.mEnableMaxCacheAgeForAllDir);
        _setIntValue(this.mHandle, 1030, r110.mPreloadStrategy);
        _setIntValue(this.mHandle, 1040, r110.mPreloadWaitListType);
        _setIntValue(this.mHandle, 105, r110.mEnablePreloadReUse);
        _setIntValue(this.mHandle, 700, r110.mEnableExternDNS);
        _setIntValue(this.mHandle, 701, r110.mEnableSocketReuse);
        _setIntValue(this.mHandle, 703, r110.mControlCDNRangeType);
        _setIntValue(this.mHandle, 702, r110.mSocketIdleTimeOut);
        _setIntValue(this.mHandle, 800, r110.mIsCloseFileCache);
        _setIntValue(this.mHandle, 1502, r110.mTestSpeedTypeVersion);
        _setIntValue(this.mHandle, 1504, r110.mCheckSumLevel);
        _setIntValue(this.mHandle, 1505, r110.mEncryptVersion);
        _setIntValue(this.mHandle, 1507, r110.mSpeedCoefficientValue);
        _setIntValue(this.mHandle, 900, r110.mMaxIpCountEachDomain);
        _setIntValue(this.mHandle, 901, r110.mEnableIpBucket);
        _setIntValue(this.mHandle, 902, r110.mErrorStateTrustTime);
        _setIntValue(this.mHandle, KeyIsEnablePreconnect, r110.mEnablePreconnect);
        _setIntValue(this.mHandle, KeyIsPreconnectNum, r110.mPreconnectNum);
        _setIntValue(this.mHandle, KeyIsEnableLoaderPreempt, r110.mEnableLoaderPreempt);
        _setIntValue(this.mHandle, KeyIsNextDownloadThreshold, r110.mNextDownloadThreshold);
        _setIntValue(this.mHandle, KeyIsSetOnlyUseCdn, r110.mOnlyUseCdn);
        _setIntValue(this.mHandle, KeyIsAccessCheckLevel, r110.mAccessCheckLevel);
        _setIntValue(this.mHandle, KeyIsEnableSessionReuse, r110.mEnableSessionReuse);
        _setIntValue(this.mHandle, KeyIsIsMaxTlsVersion, r110.mMaxTlsVersion);
        _setIntValue(this.mHandle, KeyIsIsCheckPreloadLevel, r110.mCheckPreloadLevel);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryXYLibValue, r110.mXYLibValue);
        _setIntValue(this.mHandle, KeyIsEnableP2PPreDown, r110.mEnableP2PPreDown);
        _setIntValue(this.mHandle, KeyIsEnablePlayLog, r110.mEnablePlayLog);
        _setIntValue(this.mHandle, KeyIsEnableNetScheduler, r110.mEnableNetScheduler);
        _setIntValue(this.mHandle, KeyIsEnableCacheReqRange, r110.mEnableCacheReqRange);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockAllNetErr, r110.mNetSchedulerBlockAllNetErr);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockErrCount, r110.mNetSchedulerBlockErrCount);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockDurationMs, r110.mNetSChedulerBlockDurationMs);
        _setIntValue(this.mHandle, KeyIsFirstRangeLeftThreshold, r110.mFirstRangeLeftThreshold);
        _setIntValue(this.mHandle, KeyIsSetNetSchedulerBlockHostErrIpCount, r110.mNetSchedulerBlockHostIpErrCount);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheSize, r110.mMaxFileMemCacheSize);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheNum, r110.mMaxFileMemCacheNum);
        _setIntValue(this.mHandle, 110, r110.mWriteFileNotifyIntervalMS);
        _setIntValue(this.mHandle, KeyIsP2PPredownPeerCount, r110.mP2PPreDownPeerCount);
        _setIntValue(this.mHandle, KeyIsP2PFirstRangeLoaderType, r110.mP2PFirstRangeLoaderType);
        int r104 = r110.mSocketSendBufferKB;
        if (r104 <= 0) goto L52;
        _setIntValue(this.mHandle, KeyIsSocketSendBufferKB, r104);
    L52:
        int r105 = r110.mRingBufferSizeKB;
        if (r105 <= 0) goto L55;
        _setIntValue(this.mHandle, KeyIsRingBufferSizeKB, r105);
    L55:
        _setIntValue(this.mHandle, KeyIsEnableFileCacheV2, r110.mEnableFileCacheV2);
        if (TextUtils.isEmpty(r110.mVdpABTestId) == true) goto L59;
        _setStringValue(this.mHandle, KeyIsVdpABTestId, r110.mVdpABTestId);
    L59:
        if (TextUtils.isEmpty(r110.mVdpGroupId) == true) goto L62;
        _setStringValue(this.mHandle, KeyIsVdpGroupId, r110.mVdpGroupId);
    L62:
        if (TextUtils.isEmpty(r110.mNetSchedulerConfigStr) == true) goto L64;
        _setStringValue(this.mHandle, KeyIsNetSchedulerConfigStr, r110.mNetSchedulerConfigStr);
    L64:
        _setIntValue(this.mHandle, KeyIsAlogEnable, r110.mAlogEnable);
        _setIntValue(this.mHandle, KeyIsEnableSyncDnsForPcdn, r110.mEnableSyncDnsForPcdn);
        _setIntValue(this.mHandle, KeyIsEnableFileRingBuffer, r110.mEnableFileRingBuffer);
        _setIntValue(this.mHandle, KeyIsEnableLazyBufferpool, r110.mEnableLazyBufferpool);
        _setIntValue(this.mHandle, KeyIsEnableNewBufferpool, r110.mEnableNewBufferpool);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolBlockSize, r110.mNewBufferPoolBlockSize);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolResidentSize, r110.mNewBufferPoolResidentSize);
        _setIntValue(this.mHandle, KeyIsNewBufferPoolGrowBlockCount, r110.mNewBufferPoolGrowBlockCount);
        _setIntValue(this.mHandle, KeyIsEnableUseFileExtendLoaderBuffer, r110.mEnableUseFileExtendLoaderBuffer);
        _setIntValue(this.mHandle, KeyIsMAXIPV6Num, r110.mMaxIPV6Num);
        _setIntValue(this.mHandle, KeyIsMAXIPV4Num, r110.mMaxIPV4Num);
        _setIntValue(this.mHandle, 1510, r110.mForbidByPassCookie);
        _setIntValue(this.mHandle, KeyIsSessionTimeout, r110.mSessionTimeout);
        _setIntValue(this.mHandle, KeyIsEnablePlayInfoCache, r110.mEnablePlayInfoCache);
        _setIntValue(this.mHandle, KeyIsIsEnableDownloaderLog, r110.mEnableDownloaderLog);
        _setIntValue(this.mHandle, KeyIsIsEnableTTNetLoader, r110.mEnableTTNetLoader);
        _setIntValue(this.mHandle, KeyIsTTNetLoaderCronetBufSizeKB, r110.mTTNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsAllowTryTheLastUrl, r110.mIsAllowTryTheLastUrl);
        _setIntValue(this.mHandle, KeyIsSetSpeedSampleInterval, r110.mSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsSetUseNewSingSpeedTest, r110.mUseNewSpeedTestForSingle);
        _setIntValue(this.mHandle, KeyIsIsEnableTTQuicHeLoader, r110.mEnableTTQuicHeLoader);
        _setIntValue(this.mHandle, KeyIsEnableTTQuicHeLoaderCheckWithNetworkTypeI32, r110.mEnableTTQuicHeLoaderCheckWithNetworkType);
        _setIntValue(this.mHandle, KeyIsEnableIOManager, r110.mEnableIOManager);
        _setIntValue(this.mHandle, KeyIsEnableLoaderSeek, r110.mEnableLoaderSeek);
        _setIntValue(this.mHandle, KeyIsSetGlobalSpeedSampleInterval, r110.mGlobalSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableDynamicSocketTimeout, r110.mEnableDynamicTimeout);
        _setIntValue(this.mHandle, KeyIsInitialSocketTimeout, r110.mSocketInitialTimeout);
        _setIntValue(this.mHandle, KeyIsMaxSocketReuseNum, r110.mMaxSocketReuseCount);
        _setIntValue(this.mHandle, KeyIsSetEnableReportTaskLog, r110.mEnableReportTaskLog);
        _setInt64Value(this.mHandle, KeyIsLoaderFactoryP2PStragetyLevel, r110.mP2PStragetyLevel);
        _setInt64Value(this.mHandle, KeyIsConnectPoolStragetyValue, r110.mConnectPoolStragetyValue);
        _setIntValue(this.mHandle, KeyIsMaxKeepAliveHostNum, r110.mMaxAliveHostNum);
        _setIntValue(this.mHandle, KeyIsSetFileExtendSize, r110.mFileExtendSizeKB);
        _setIntValue(this.mHandle, KeyIsSetMinAllowSpeed, r110.mMinAllowSpeed);
        _setIntValue(this.mHandle, KeyIsSetEnableOwnVdpPreloadNotify, r110.mEnableOwnVDPPreloadNotify);
        _setIntValue(this.mHandle, KeyIsEnableEarlyData, r110.mEnableEarlyData);
        _setIntValue(this.mHandle, KeyIsEnableSpeedPredict, r110.mEnableSpeedPredict);
        _setIntValue(this.mHandle, KeyIsEnableSpeedEngine, r110.mEnableSpeedEngine);
        _setIntValue(this.mHandle, KeyIsEnableSpeedReport, r110.mEnableSpeedReport);
        _setIntValue(this.mHandle, KeyIsEnableUseOriginalUrl, r110.mEnableUseOriginalUrl);
        _setIntValue(this.mHandle, KeyIsEnableLoaderLogExtractUrls, r110.mEnableLoaderLogExtractUrls);
        _setIntValue(this.mHandle, KeyIsMaxLoaderLogNum, r110.mMaxLoaderLogNum);
        _setIntValue(this.mHandle, KeyIsCheckContentTypeMethod, r110.mCheckContentTypeMethod);
        _setIntValue(this.mHandle, KeyIsThreadStackSizeLevel, r110.mThreadStackSizeLevel);
        _setIntValue(this.mHandle, KeyIsEnableThreadPoolCheckIdle, r110.mEnableThreadPoolCheckIdle);
        _setIntValue(this.mHandle, KeyIsThreadPoolIdleTTLSecond, r110.mThreadPoolTTLSecond);
        _setIntValue(this.mHandle, KeyIsThreadPoolMinCount, r110.mThreadPoolMinCount);
        _setIntValue(this.mHandle, KeyIsNonBlockRangeMode, r110.mNonBlockRangeMode);
        int r106 = r110.mNonBlockRangeMaxSizeKB;
        if (r106 <= 0) goto L67;
        _setIntValue(this.mHandle, KeyIsNonBlockRangeMaxSizeKB, r106);
    L67:
        _setIntValue(this.mHandle, KeyIsNetUnreachableStopRetry, r110.mNetUnreachableStopRetry);
        _setIntValue(this.mHandle, KeyIsEnableWaitNetReachable, r110.mEnableWaitNetReachable);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorMinAllowLoadSize, r110.mMonitorMinAllowLoadSize);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorTimeInternal, r110.mMonitorTimeInternal);
        _setStringValue(this.mHandle, KeyIsSocketTrainingCenterConfigStr, r110.mSocketTraingCenterConfigStr);
        if (TextUtils.isEmpty(r110.mEnginePortraitStr) == true) goto L70;
        _setStringValue(this.mHandle, KeyIsEnginePortraitStr, r110.mEnginePortraitStr);
    L70:
        _setStringValue(this.mHandle, KeyIsCacheDirListsStr, r110.mCacheDirListsStr);
        _setStringValue(this.mHandle, KeyIsP2PConfigStr, r110.mP2PConfigStr);
        _setIntValue(this.mHandle, KeyIsSetSocketRecvBuffer, r110.mSocketRecvBufferSize);
        _setIntValue(this.mHandle, KeyIsEnableByteMediaNetLoader, r110.mEnableByteMediaNetLoader);
        _setIntValue(this.mHandle, KeyIsByteMediaNetLoaderCronetBufSizeKB, r110.mByteMediaNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsEnableCellularUp, r110.mEnableCellularUp);
        _setIntValue(this.mHandle, KeyIsCloseThreadPool, r110.mCloseThreadPool);
        _setIntValue(this.mHandle, KeyIsMaxIpNum, r110.mMaxIpNum);
        _setIntValue(this.mHandle, KeyIsIgnoreTextSpeedTest, r110.mIgnoreTextSpeedTest);
        _setIntValue(this.mHandle, KeyIsEnableOptimizeRange, r110.mEnableOptimizeRange);
        _setIntValue(this.mHandle, KeyIsCheckCacheDir, r110.mCheckCacheDir);
        _setIntValue(this.mHandle, KeyIsEnableUseGroupId, r110.mEnableUseGroupId);
        _setIntValue(this.mHandle, KeyIsEnableMissReasonRecord, r110.mEnableMissReason);
        _setIntValue(this.mHandle, KeyIsPreloadInfoRecordMaxCnt, r110.mPreloadInfoRecordMaxCnt);
        _setIntValue(this.mHandle, KeyIsEnableTraceidPreloadLog, r110.mEnableTraceIdPreloadLog);
        int r107 = r110.mCloseLocalServer;
        if (r107 <= 0) goto L73;
        _setIntValue(this.mHandle, KeyIsCloseLocalServer, r107);
    L73:
        int r108 = r110.mGetCookieTokenLevel;
        if (r108 <= 0) goto L76;
        _setIntValue(this.mHandle, KeyIsGetCookieTokenLevel, r108);
    L76:
        _setIntValue(this.mHandle, KeyIsDisableRecentCache, r110.mDisableRecentCache);
        _setIntValue(this.mHandle, KeyIsUpdateCacheFileInternal, r110.mUpdateCacheFileInternal);
        _setIntValue(this.mHandle, KeyIsEnableCustomDirSearchAllPath, r110.mEnableCustomDirSearchAllPath);
        _setIntValue(this.mHandle, 12001, r110.mHlsTsFileKeyGenerateType);
        _setStringValue(this.mHandle, KeyIsProtectCacheDirAvoidClear, r110.mProtectCacheDirsStr);
        if (TextUtils.isEmpty(r110.mBusinessDirControlConfigStr) == true) goto L79;
        _setStringValue(this.mHandle, KeyIsBusinessDirControlConfig, r110.mBusinessDirControlConfigStr);
    L79:
        long r109 = r110.mMaxCacheSize64;
        if (r109 <= 0) goto L82;
        _setInt64Value(this.mHandle, KeyIsMaxCacheSizeForDefaultDir, r109);
    L82:
        int r111 = r110.mEnableEventInfo;
        if (r111 <= 0) goto L85;
        _setIntValue(this.mHandle, 9999, r111);
    L85:
        int r112 = r110.mDownLogMaxSize;
        if (r112 <= 0) goto L88;
        _setIntValue(this.mHandle, KeyIsSetDownLogMaxSize, r112);
    L88:
        int r113 = r110.mEnableStorageModule;
        if (r113 <= 0) goto L106;
        _setIntValue(this.mHandle, 10000, r113);
        int r114 = r110.mStoPlayDldWinSizeKBNM;
        if (r114 <= 0) goto L93;
        _setIntValue(this.mHandle, 10001, r114);
    L93:
        int r115 = r110.mStoPlayDldWinSizeKBLS;
        if (r115 <= 0) goto L96;
        _setIntValue(this.mHandle, 10002, r115);
    L96:
        int r116 = r110.mStoRingBufferSizeKB;
        if (r116 <= 0) goto L99;
        _setIntValue(this.mHandle, 10003, r116);
    L99:
        int r117 = r110.mStoIoWriteLimitKBTh1;
        if (r117 <= 0) goto L102;
        _setIntValue(this.mHandle, 10004, r117);
    L102:
        int r118 = r110.mStoMaxIdleTimeSec;
        if (r118 <= 0) goto L106;
        _setIntValue(this.mHandle, 10006, r118);
    L106:
        if (TextUtils.isEmpty(r110.mStoStrategyConfig) == true) goto L108;
        _setStringValue(this.mHandle, 10007, r110.mStoStrategyConfig);
    L108:
        int r119 = r110.mStoIoWriteLimitKBTh2;
        if (r119 <= 0) goto L112;
        _setIntValue(this.mHandle, 10005, r119);
    L112:
        if (TextUtils.isEmpty(r110.mP2PCostTag) == true) goto L114;
        _setStringValue(this.mHandle, KeyIsP2PCostTag, r110.mP2PCostTag);
    L114:
        _setIntValue(this.mHandle, KeyIsIgnorePlayInfo, r110.mIgnorePlayInfo);
        if (TextUtils.isEmpty(r110.mSettingsDomain) == true) goto L118;
        _setStringValue(this.mHandle, KeyIsSetSettingsDomain, r110.mSettingsDomain);
    L118:
        if (TextUtils.isEmpty(r110.mDmDomain) == true) goto L121;
        _setStringValue(this.mHandle, KeyIsSetDMDomain, r110.mDmDomain);
    L121:
        if (TextUtils.isEmpty(r110.mForesightDomain) == true) goto L124;
        _setStringValue(this.mHandle, KeyIsSetForesightDomain, r110.mForesightDomain);
    L124:
        if (TextUtils.isEmpty(r110.mDomains) == true) goto L127;
        _setStringValue(this.mHandle, KeyIsSetDomains, r110.mDomains);
    L127:
        if (TextUtils.isEmpty(r110.mKeyDomain) == true) goto L130;
        _setStringValue(this.mHandle, KeyIsSetKeyDomain, r110.mKeyDomain);
    L130:
        if (TextUtils.isEmpty(r110.mKeyToken) == true) goto L133;
        _setStringValue(this.mHandle, KeyIsSetKeyToken, r110.mKeyToken);
    L133:
        if (TextUtils.isEmpty(r110.mDynamicPreconnectConfigStr) == true) goto L136;
        _setStringValue(this.mHandle, KeyIsDynamicPreconnectConfigStr, r110.mDynamicPreconnectConfigStr);
    L136:
        if (TextUtils.isEmpty(r110.mCustomUA) == true) goto L139;
        _setStringValue(this.mHandle, KeyIsCustomUA, r110.mCustomUA);
    L139:
        if (TextUtils.isEmpty(r110.mFileRingBufferOptStr) == true) goto L142;
        _setStringValue(this.mHandle, KeyIsFileRingBufferOptStr, r110.mFileRingBufferOptStr);
    L142:
        if (TextUtils.isEmpty(r110.mFileKeyRule) == true) goto L144;
        _setStringValue(this.mHandle, 12000, r110.mFileKeyRule);
    L144:
        _setIntValue(this.mHandle, KeyIsEnableOkHttpLoader, r110.mEnableOkHttpLoader);
        _setIntValue(this.mHandle, 11000, r110.mEnableP2pUpload);
        _setIntValue(this.mHandle, 11002, r110.mDevDiskSizeMB);
        _setIntValue(this.mHandle, 11004, r110.mDevMemorySizeMB);
        if (TextUtils.isEmpty(r110.mVdpExtGlobalInfo) == true) goto L147;
        _setStringValue(this.mHandle, 11001, r110.mVdpExtGlobalInfo);
    L147:
        _setIntValue(this.mHandle, KeyIsEnableMultiDownloadPath, r110.mEnableMultiDownloadPath);
        _setIntValue(this.mHandle, KeyIsEnableFileMutexOptimize, r110.mEnableFileMutexOptimize);
        _setIntValue(this.mHandle, KeyIsSkipCDNBeforeExpiredSec, r110.mSkipCDNBeforeExpiredSec);
        _setIntValue(this.mHandle, KeyIsNetUnreachableTimeout, r110.mNetUnreachableTimeout);
        int r120 = r110.mDeviceScoreEx;
        if (r120 <= 0) goto L150;
        _setIntValue(this.mHandle, KeyIsDeviceScoreEx, r120);
    L150:
        int r121 = r110.mSessionCacheInterval;
        if (r121 <= 0) goto L153;
        _setIntValue(this.mHandle, KeyIsSessionCacheInterval, r121);
    L153:
        int r122 = r110.mFileManagerInterval;
        if (r122 <= 0) goto L156;
        _setIntValue(this.mHandle, KeyIsFileManagerInterval, r122);
    L156:
        AVMDLDNSParser.setIntValue(0, this.mConfigure.mDNSMainType);
        AVMDLDNSParser.setIntValue(1, this.mConfigure.mDNSBackType);
        AVMDLDNSParser.setIntValue(2, this.mConfigure.mDefaultExpiredTime);
        AVMDLDNSParser.setIntValue(3, this.mConfigure.mMainToBackUpDelayedTime);
        return;
    L45:
        _setIntValue(this.mHandle, 6, r110.mLoaderType);
        goto L46
    }

    public static void setOkhttpClient(OkHttpClient r100) {
        AVMDLHttpExcutor.setOkHttpClient(r100);
    }

    public int asyncCopyOperation(AVMDLCopyOperation r100) {
        if (this.mState != 1) goto L9;
        Handler r101 = this.mLogHandler;
        if (r101 == null) goto L11;
        Message r102 = r101.obtainMessage();
        r102.what = 23;
        r102.obj = r100;
        r102.sendToTarget();
        return 0;
    L11:
        return -1;
    L9:
        return -1;
    }

    public void cancel(String r100) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r101 == 0) goto L9;
        _cancel(r101, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void cleanCacheDir(long r100) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mReadLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r101 == 0) goto L9;
        _cleanCacheDir(r101, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mReadLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public void doParseHosts(String[] r100) {
        AVMDLDNSParser.getInstance().doParseHosts(r100);
    }

    public void downloadResource(String r100) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r101 == 0) goto L12;
        _downloadResource(r101, r100);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public void forceRemoveFileCache(String r100) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r101 == 0) goto L12;
        _forceRemoveCacheFile(r101, r100);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public String getAuth(String r100) {
        String r101 = null;
        if (this.mState == 1) goto L5;
    L18:
        return null;
    L5:
        if (this.isSupportGetAuth == false) goto L18;
        this.mReadLock.lock();
        r101 = _getAuth(this.mHandle, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mReadLock.unlock();
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        this.isSupportGetAuth = false;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public String getCDNLog(String r100) {
        String r101 = null;
        if (this.mState == 1) goto L5;
        return null;
    L5:
        this.mReadLock.lock();
        r101 = _getCDNLog(this.mHandle, r100);     // Catch: Throwable -> L8 UnsatisfiedLinkError -> L10
    L7:
        this.mReadLock.unlock();
        return r101;
    L8:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L10:
        e = move-exception;
        AVMDLLog.d(TAG, "not support get cdnlog," + e.toString());     // Catch: Throwable -> L8
        goto L7
    }

    public AVMDLFileInfo getCacheInfo(String r100) {
        AVMDLFileInfo r101 = null;
        if (this.mState == 1) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
        if (r102 == 0) goto L28;
        String r103 = _getStringValueByStr(r102, r100, 101);     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
        if (TextUtils.isEmpty(r103) == false) goto L15;
        this.mReadLock.unlock();
        return null;
    L15:
        String[] r104 = r103.split(",");     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
        if (r104.length < 3) goto L28;
        AVMDLFileInfo r105 = new AVMDLFileInfo();     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
        r105.mFilePath = r104[2];     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L29
        if (TextUtils.isEmpty(r104[0]) == true) goto L23;
        r105.mCacheSize = Long.valueOf(r104[0]).longValue();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L29
    L23:
        if (TextUtils.isEmpty(r104[1]) == true) goto L25;
        r105.mContentLenght = Long.valueOf(r104[1]).longValue();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L29
    L25:
        r101 = r105;
    L26:
        e = e;
        r101 = r105;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L29
    L28:
        this.mReadLock.unlock();
        return r101;
    L29:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L31:
        e = e;
        goto L32
    }

    public long getCacheSize(String r100) {
        long r101 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return -1;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        r101 = _getLongValueByStr(r102, r100, 103);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r101;
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public long getDownloadCount(String r100) {
        long r101 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return -1;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        r101 = _getLongValueByStr(r102, r100, KeyIsGetDownloadCountByVid);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r101;
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public long getLongValue(int r110) {
        long r100 = -1;
        if (r110 != 7218) goto L5;
    L45:
        long r101 = this.mHandle;
        if (r101 != 0) goto L48;
        return -1;
    L48:
        return _getLongValue(r101, r110);
    L5:
        if (r110 == 7390) goto L45;
        if (r110 == 9407) goto L45;
        if (r110 == 7402) goto L45;
        if (r110 == 7433) goto L45;
        if (this.mState == 1) goto L18;
        AVMDLLog.d("ttmdljava", "getLongValue key: " + r110 + " result: -1");
        return -1;
    L18:
        if (this.mConfigure != null) goto L21;
        AVMDLLog.d("ttmdljava", "getLongValue key: " + r110 + " result: -998");
        return -998;
    L21:
        this.mReadLock.lock();
        switch(r110) {
            case 8100: goto L27;
            case 8101: goto L26;
            case 8102: goto L25;
            case 8103: goto L24;
            default: goto L23;
        };
    L23:
        long r102 = this.mHandle;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        if (r102 == 0) goto L38;
        long r103 = _getLongValue(r102, r110);     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
    L29:
        r100 = r103;
    L38:
        this.mReadLock.unlock();
        AVMDLLog.d("ttmdljava", "getLongValue key: " + r110 + " result: " + r100);
        return r100;
    L24:
        int r104 = this.mConfigure.mLiveLoaderType;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
    L28:
        r103 = r104;
        goto L29
    L25:
        r104 = this.mConfigure.mLiveEnableMdlProto;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        goto L28
    L26:
        r104 = this.mConfigure.mLiveP2pAllow;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        goto L28
    L27:
        r104 = this.mConfigure.mLiveLoaderEnable;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
    L30:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
        goto L38
    }

    public String getStringCacheInfo(String r100) {
        String r101 = null;
        if (this.mState == 1) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        r101 = _getStringValueByStr(r102, r100, 101);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r101;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public String getStringValue(int r100) {
        String r101 = null;
        if (this.mState == 1) goto L5;
        return null;
    L5:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        if (r102 == 0) goto L10;
        r101 = _getStringValue(r102, r100);     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        goto L10
    L10:
        this.mReadLock.unlock();
        return r101;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 23) goto L10;
        AVMDLCopyOperation r102 = (AVMDLCopyOperation) r100.obj;
        if (r102 == null) goto L37;
        copyInternal(r102);
        return true;
    L37:
        return true;
    L10:
        if (r101 != 3) goto L12;
    L13:
        AVMDLDataLoaderNotifyInfo r103 = (AVMDLDataLoaderNotifyInfo) r100.obj;
        if (this.mWaitingCopyItem.size() <= 0) goto L18;
        if (r103 == null) goto L18;
        handleCopyMsg(r103);
    L18:
        if (r101 == 12) goto L36;
        if (r101 == 9) goto L36;
        if (r101 == 71) goto L34;
        if (r101 == 72) goto L34;
        if (r101 == 73) goto L34;
        if (r101 == 74) goto L34;
        return postMessage(this.mVodListener, r100);
    L34:
        return postMessage(this.mEventListener, r100);
    L36:
        return postMessage(this.mLiveListener, r100);
    L12:
        if (r101 != 51) goto L18;
        goto L13
    }

    public int onCellularAlwaysUp(long r100) {
        AVMDLLog.d(TAG, "start on cellular netId: " + r100);
        this.mWriteLock.lock();
        int r101 = -1;
        long r102 = this.mHandle;     // Catch: Throwable -> L12 Throwable -> L7
        if (r102 == 0) goto L6;
        r101 = _onCellularAlwaysUp(r102, r100, Build.VERSION.SDK_INT);     // Catch: Throwable -> L12 Throwable -> L7
    L7:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L6:
        this.mWriteLock.unlock();
        AVMDLLog.d(TAG, "end on cellular netId: " + r100 + " ret: " + r101);
        return r101;
    }

    public void onEventInfo(Object r210) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        if (this.mLogHandler == null) goto L45;
        LoaderEventInfo r110 = new LoaderEventInfo();
        r110.what = 74;
        HashMap r100 = (HashMap) r210;     // Catch: Exception -> L38
        if (r100.containsKey("what") == false) goto L13;
        r110.what = ((Integer) r100.get("what")).intValue();     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains What" + r110.what);     // Catch: Exception -> L38
    L13:
        if (r100.containsKey("taskType") == false) goto L16;
        r110.taskType = ((Integer) r100.get("taskType")).intValue();     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains taskType" + r110.taskType);     // Catch: Exception -> L38
    L16:
        if (r100.containsKey("off") == false) goto L19;
        r110.off = ((Long) r100.get("off")).longValue();     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains off" + r110.off);     // Catch: Exception -> L38
    L19:
        if (r100.containsKey("endOff") == false) goto L22;
        r110.endOff = ((Long) r100.get("endOff")).longValue();     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains endOff" + r110.endOff);     // Catch: Exception -> L38
    L22:
        if (r100.containsKey("fileHash") == false) goto L25;
        r110.fileHash = String.valueOf(r100.get("fileHash"));     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains fileHash" + r110.fileHash);     // Catch: Exception -> L38
    L25:
        if (r100.containsKey("bytesLoaded") == false) goto L29;
        r110.bytesLoaded = ((Long) r100.get("bytesLoaded")).longValue();     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains bytesLoaded" + r110.bytesLoaded);     // Catch: Exception -> L38
    L29:
        if (r100.containsKey("headers") == false) goto L31;
        String r101 = String.valueOf(r100.get("headers"));     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI] eventMap contains headers".concat(r101));     // Catch: Exception -> L38
    L32:
        if (r101 == "") goto L36;
        String[] r102 = r101.split("\r\n");     // Catch: Exception -> L38
        int r103 = r102.length;     // Catch: Exception -> L38
        int r104 = 0;
    L34:
        if (r104 >= r103) goto L40;
        String[] r105 = r102[r104].split(":");     // Catch: Exception -> L38
        r110.mHeaders.put(r105[0], r105[1]);     // Catch: Exception -> L38
        r104 = r104 + 1;     // Catch: Exception -> L38
    L40:
        Message r106 = this.mLogHandler.obtainMessage();
        r106.what = r110.what;
        r106.obj = r110;
        r106.sendToTarget();
        return;
    L36:
        AVMDLLog.d(TAG, "[debugUI] what" + r110.what);     // Catch: Exception -> L38
        AVMDLLog.d(TAG, "[debugUI]no headers");     // Catch: Exception -> L38
        goto L40
    L31:
        r101 = "";
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    }

    public long quickQueryCacheSize(String r100) {
        long r101 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return -1;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        r101 = _getLongValueByStr(r102, r100, 113);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r101;
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public void removeFileCache(String r100) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r101 == 0) goto L12;
        _removeCacheFile(r101, r100);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public void resetPreloadTraceId(String r100) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r101 == 0) goto L9;
        _resetPreloadTraceId(r101, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setConfigure(AVMDLDataLoaderConfigure r100) {
        this.mWriteLock.lock();
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mState == 1) goto L6;
        this.mConfigure = r100;     // Catch: Throwable -> L8
        r100.ParseJsonConfig();     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
    }

    public void setDownloaderCallback(MDLDownloaderCallback r100) {
        this.mDownloaderCallback = r100;
    }

    public void setEventListener(LoaderListener r100) {
        this.mWriteLock.lock();
        this.mEventListener = r100;     // Catch: Throwable -> L6
        this.mWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setListener(AVMDLDataLoaderListener r100) {
        this.mWriteLock.lock();
        this.mVodListener = r100;     // Catch: Throwable -> L6
        this.mWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setPluginLibraryLoader(IAVMDLLibraryLoader r100) {
        this.mWriteLock.lock();
        this.mPluginLibraryLoader = r100;     // Catch: Throwable -> L6
        this.mWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setStartCompleteListener(AVMDLStartCompleteListener r100) {
        this.mStartCompleteListener = r100;
    }

    public synchronized void setTaskEventListener(AVMDLTaskEventListener r100) {
        monitor-enter(this);
        this.mTaskListener = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void suspendDownload(String r100) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r101 == 0) goto L9;
        _suspendedDownload(r101, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public long tryQuickGetCacheSize(String r100) {
        long r101 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return -1;
    L8:
        this.mReadLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        r101 = _getLongValueByStr(r102, r100, 106);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r101;
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public void tryToClearCachesByUsedTime(long r100) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L15
        if (r101 == 0) goto L13;
        _clearCachesByUsedTime(r101, r100);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L15
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L13:
        this.mWriteLock.unlock();
    }

    public static /* synthetic */ Handler access$002(AVMDLDataLoader r100, Handler r101) {
        r100.mLogHandler = r101;
        return r101;
    }

    private String createFilePathBaseDir(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return null;
    L8:
        if (r100.charAt(r100.length() - 1) != '/') goto L10;
        String r102 = r100 + r101;
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L16;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == true) goto L16;
        r103.mkdirs();
    L16:
        return r102;
    L10:
        r102 = r100 + HTTP.URL_DEFAULT + r101;
        goto L12
    }

    public static synchronized int init(boolean r100, boolean r101) {
        monitor-enter(AVMDLDataLoader.class);
    L34:
        th = move-exception;
        throw th;
    L6:
        if (mIsLibraryLoaded == false) goto L9;
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L9:
        mIsLibraryLoaded = r100;     // Catch: Throwable -> L34
        if (mIsLibraryLoaded == true) goto L27;
        pc4.a.b();     // Catch: Throwable -> L34
        VcnlibloadWrapper.tryLoadVcnlib();     // Catch: Throwable -> L34
        loadAVMDLBaseLibrary();     // Catch: Throwable -> L34
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdl");     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        mIsLibraryLoaded = true;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
    L18:
        VcnlibloadWrapper.tryLoadVcnverifylib();     // Catch: Throwable -> L34
        if (r101 == true) goto L39;
    L26:
        tryLoadTTNetLoaderPlugin();     // Catch: Throwable -> L34
        tryLoadByteMediaNetLoaderPlugin();     // Catch: Throwable -> L34
        goto L27
    L39:
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdlp2p");     // Catch: Throwable -> L22 UnsatisfiedLinkError -> L24
    L24:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L34
    L22:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L34
        goto L26
    L16:
        e = move-exception;
        mLoadFailMsg = "Can't load avmdl library: " + e;     // Catch: Throwable -> L34
        e.toString();     // Catch: Throwable -> L34
    L14:
        th = move-exception;
        mLoadFailMsg = "other exception when loading avmdl library: " + th;     // Catch: Throwable -> L34
        th.toString();     // Catch: Throwable -> L34
    L27:
        if (mIsLibraryLoaded == true) goto L32;
        monitor-exit(AVMDLDataLoader.class);
        return -1;
    L32:
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    }

    public static void initByteMediaNetEnv(Context r100, ClassLoader r101) {
        monitor-enter(AVMDLDataLoader.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (mIsByteMediaNetInit.booleanValue() == false) goto L26;
        monitor-exit(AVMDLDataLoader.class);     // Catch: Throwable -> L22
        return;
    L26:
        Class r102 = INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.avframework.transport.ContextUtils");     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        Method r103 = r102.getMethod("initApplicationContext", new Class[]{Context.class});     // Catch: Throwable -> L18
        r103.setAccessible(true);     // Catch: Throwable -> L18
        r103.invoke(null, new Object[]{r100});     // Catch: Throwable -> L18
    L11:
        Class r104 = INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.avframework.transport.JNIUtils");     // Catch: Throwable -> L18
        if (r104 == null) goto L14;
        Method r105 = r104.getMethod("setClassLoader", new Class[]{ClassLoader.class});     // Catch: Throwable -> L18
        r105.setAccessible(true);     // Catch: Throwable -> L18
        r105.invoke(null, new Object[]{r101});     // Catch: Throwable -> L18
    L14:
        if (r102 == null) goto L20;
        if (r104 == null) goto L20;
        mIsByteMediaNetInit = Boolean.TRUE;     // Catch: Throwable -> L18
    L20:
        monitor-exit(AVMDLDataLoader.class);     // Catch: Throwable -> L22
        return;
    L18:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L22
        th.getLocalizedMessage();     // Catch: Throwable -> L22
        goto L20
    }

    public static String makeTsFileKey(String r100, String r101) {
        return _makeTsFileKey(r100, r101);
    L5:
        e = move-exception;
        AVMDLLog.e(TAG, "makeTsFileKey failed, other reason:  " + e.getMessage());
        return null;
    L7:
        e = move-exception;
        AVMDLLog.e(TAG, "makeTsFileKey failed, native not support: " + e.getMessage());
        return null;
    }

    private boolean postMessage(LoaderListener r100, Message r101) {
        if (r100 == null) goto L19;
        Object r102 = r101.obj;
        if (r102 == null) goto L19;
        LoaderEventInfo r103 = (LoaderEventInfo) r102;
        if (r103 == null) goto L19;
        int r104 = r101.what;
        if (r104 != 71) goto L13;
        r100.onLoaderTaskStart(r103);
        AVMDLLog.d("ttmdljava", "receive eventLog KeyIsLoaderEventStart");
        goto L19
    L13:
        if (r104 != 72) goto L16;
        r100.onLoaderTaskCancel(r103);
        AVMDLLog.d("ttmdljava", "receive eventLog KeyIsLoaderEventCancel");
        goto L19
    L16:
        if (r104 != 73) goto L18;
        r100.onLoaderTaskCompleted(r103);
        AVMDLLog.d("ttmdljava", "receive eventLog KeyIsLoaderEventCompleted");
        goto L19
    L18:
        AVMDLLog.d("ttmdljava", "receive eventLog fail");
    L19:
        return true;
    }

    public void addDataSource(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        AVMDLLog.d(TAG, "addDataSource: id: " + r100 + ", queyr: " + r101);
        this.mWriteLock.lock();
        _addDataSource(this.mHandle, r100, r101);     // Catch: Throwable -> L8 Throwable -> L13
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L11:
        this.mWriteLock.unlock();
    }

    public void cleanSpecifiedCacheDir(String r100, int r101) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r102 == 0) goto L9;
        _cleanSpecifiedCacheDir(r102, r100, r101);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public long copyFile(String r100, String r110) {
        long r101 = -1;
        if (this.mState == 1) goto L5;
        return -1;
    L5:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r102 == 0) goto L9;
        r101 = _copyFile64(r102, r100, r110);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return r101;
    L12:
        e = move-exception;
        long r103 = this.mHandle;     // Catch: Throwable -> L10
        if (r103 != 0) goto L27;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L9
    L27:
        r101 = _copyFile(r103, r100, r110);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L18
        goto L20
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public long getCacheSize(String r100, String r101) {
        long r102 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return -1;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return -1;
    L11:
        this.mReadLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L17 UnsatisfiedLinkError -> L19
        if (r103 == 0) goto L16;
        r102 = _getLongValueByStrStr(r103, r100, r101, 103);     // Catch: Throwable -> L17 UnsatisfiedLinkError -> L19
        goto L16
    L16:
        this.mReadLock.unlock();
        return r102;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public MDLDownloader getDownloader(int r100, MDLDownloaderCallback r101) {
        AVMDLLog.d(TAG, "getDownloader bid: " + r100);
        if (this.mMDLDownloaderMap.containsKey(Integer.valueOf(r100)) == false) goto L6;
        AVMDLLog.d(TAG, "mMDLDownloaderMap.get(bid) but no init");
        return this.mMDLDownloaderMap.get(Integer.valueOf(r100));
    L6:
        MDLDownloader r102 = new MDLDownloader(this);
        AVMDLLog.d(TAG, "InitDownloader downloader: " + r102);
        r102.Init(r100, "", r101);
        this.mMDLDownloaderMap.put(Integer.valueOf(r100), r102);
        return r102;
    }

    public long getInt64Value(int r100, long r101) {
        if (r100 != 8003) goto L5;
    L6:
        AVMDLDataLoaderListener r102 = this.mLiveListener;
        if (r102 != null) goto L9;
        AVMDLLog.e("ttmdljava", "getInt64Value mLiveListener is nullptr, code: " + r100);
    L12:
        switch(r100) {
            case 11007: goto L23;
            case 11008: goto L22;
            case 11009: goto L21;
            case 11010: goto L19;
            case 11011: goto L15;
            default: goto L24;
        };
    L21:
        r101 = AVMDLDeviceUtil.getBatteryPercentage(getApplicationContext());
        goto L24
    L22:
        r101 = AVMDLDeviceUtil.getTotalFreeStorageKB();
        goto L24
    L23:
        r101 = AVMDLDeviceUtil.getTotalStorageSpaceKB();
    L24:
        AVMDLLog.d("ttmdljava", "getInt64Value code: " + r100 + " defaultValue: " + r101);
        return r101;
    L15:
        if (AVMDLDeviceUtil.isOverHeat(getApplicationContext()) == false) goto L17;
    L16:
        r101 = 1;
    L17:
        r101 = 0;
        goto L24
    L19:
        if (AVMDLDeviceUtil.isPowerSaveMode(getApplicationContext()) == false) goto L17;
    L9:
        return r102.getInt64Value(r100, r101);
    L5:
        if (r100 != 8004) goto L12;
        goto L6
    }

    public long getLongValueByStr(String r100, int r101) {
        long r102 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return -1;
    L8:
        this.mWriteLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r103 == 0) goto L13;
        r102 = _getLongValueByStr(r103, r100, r101);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mWriteLock.unlock();
        return r102;
    L14:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public long getMissReason(String r100, String r101) {
        long r102 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
    L24:
        return -1;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        this.mReadLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
        if (r103 == 0) goto L15;
        r102 = _getLongValueByStrStr(r103, r100, r101, 112);     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
        goto L15
    L15:
        this.mReadLock.unlock();
        return r102;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public String getOfflineCacheInfo(String r100, String r101) {
        String r102 = null;
        if (this.mState == 1) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        this.mReadLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r103 == 0) goto L13;
        r102 = _getStringValueByStrStr(r103, r100, r101, 114);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r102;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public String getStringCacheInfo(String r100, String r101) {
        String r102 = null;
        if (this.mState == 1) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    L11:
        this.mReadLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L17 UnsatisfiedLinkError -> L19
        if (r103 == 0) goto L16;
        r102 = _getStringValueByStrStr(r103, r100, r101, 101);     // Catch: Throwable -> L17 UnsatisfiedLinkError -> L19
        goto L16
    L16:
        this.mReadLock.unlock();
        return r102;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public String getStringValueByStr(String r100, int r101) {
        String r102 = null;
        if (this.mState == 1) goto L5;
        return null;
    L5:
        this.mReadLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        if (r103 == 0) goto L10;
        r102 = _getStringValueByStr(r103, r100, r101);     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        goto L10
    L10:
        this.mReadLock.unlock();
        return r102;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    }

    public void makeFileAutoDeleteFlag(String r100, int r101) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r102 == 0) goto L12;
        _makeFileAutoDeleteFlag(r102, r100, r101);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public void preConnectByHost(String r100, int r101) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        _preConnectByHost(this.mHandle, r100, r101);     // Catch: Throwable -> L8 UnsatisfiedLinkError -> L10
    L7:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L7
    }

    public void preloadResource(String r100, long r101) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (r101 == 0) goto L27;
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        if (r102 == 0) goto L14;
        _preloadResource(r102, r100, r101);     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
    L14:
        this.mWriteLock.unlock();
        return;
    L15:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L14
    }

    public void setBackUpIp(String r110, String r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L10;
        AVMDLDNSInfo r100 = new AVMDLDNSInfo(11, r110, r111, 0, null, -1);
        IPCache.getInstance().putBackUpIp(r110, r100);
        return;
    }

    public void setIntValue(int r100, int r101) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r102 == 0) goto L9;
        _setIntValue(r102, r100, r101);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setListener(int r100, AVMDLDataLoaderListener r101) {
        this.mWriteLock.lock();
        if (r100 == 107) goto L11;
    L9:
        this.mWriteLock.unlock();
        return;
    L11:
        this.mLiveListener = r101;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void setLongValue(int r100, long r101) {
        if (r100 != 7432) goto L9;
        long r102 = this.mHandle;
        if (r102 == 0) goto L27;
        _setInt64Value(r102, r100, r101);
        return;
    L27:
        return;
    L9:
        if (this.mState == 1) goto L11;
        return;
    L11:
        this.mWriteLock.lock();
        long r103 = this.mHandle;     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
        if (r103 == 0) goto L15;
        _setInt64Value(r103, r100, r101);     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
    L15:
        this.mWriteLock.unlock();
        return;
    L16:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L15
    }

    public void setStringValue(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (this.mState == 1) goto L8;
        return;
    L8:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r102 == 0) goto L12;
        _setStringValue(r102, r100, r101);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public long tryToClearAndGetCachesByUsedTime(long r100, boolean r101) {
        long r102 = 0;
        int r103 = 1;
        if (this.mState == 1) goto L5;
        return 0;
    L5:
        this.mWriteLock.lock();
        long r104 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r104 == 0) goto L12;
        if (r101 == true) goto L11;
        r103 = 0;
    L11:
        r102 = _clearAndGetCachesByUsedTime(r104, r100, r103);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L12:
        this.mWriteLock.unlock();
        return r102;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L13
        goto L12
    }

    private boolean postMessage(AVMDLDataLoaderListener r100, Message r101) {
        if (r101.what != 701) goto L6;
        AVMDLLog.d("ttmdljava", "receive hijack err: ");
        hijack();
        return true;
    L6:
        if (r100 == null) goto L13;
        Object r102 = r101.obj;
        if (r102 == null) goto L13;
        AVMDLDataLoaderNotifyInfo r103 = (AVMDLDataLoaderNotifyInfo) r102;
        if (r103 == null) goto L13;
        r100.onNotify(r103);
    L13:
        return true;
    }

    public void preloadResource(String r100, int r101) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L22;
        if (r101 == 0) goto L26;
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r102 == 0) goto L13;
        _preloadResource(r102, r100, r101);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
    L13:
        this.mWriteLock.unlock();
        return;
    L14:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    L26:
        return;
    }

    public static /* synthetic */ int access$1100(long r100, long r101, int r102) {
        return _dhStop(r100, r101, r102);
    }

    public static /* synthetic */ int access$1200(long r100, int r101, long r102) {
        return _dmDeleteHandler(r100, r101, r102);
    }

    public static /* synthetic */ String access$1400(long r100, long r101, String r102) {
        return _dhGetValue(r100, r101, r102);
    }

    public static /* synthetic */ String access$700(long r100, int r101, String r102) {
        return _dmGetValue(r100, r101, r102);
    }

    public static /* synthetic */ int access$900(long r100, long r101, MDLDownloader.MDLTaskCallback r102) {
        return _dhAsyncStart(r100, r101, r102);
    }

    public static synchronized int init(boolean r110, boolean r111, boolean r112) {
        monitor-enter(AVMDLDataLoader.class);
    L53:
        th = move-exception;
        throw th;
    L6:
        if (mIsLibraryLoaded == false) goto L9;
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L9:
        Locale r100 = Locale.US;     // Catch: Throwable -> L53
        Object[] r101 = new Object[3];     // Catch: Throwable -> L53
        if (r110 == false) goto L12;
        int r102 = 1;
    L13:
        r101[0] = Integer.valueOf(r102);     // Catch: Throwable -> L53
        if (r111 == false) goto L16;
        int r103 = 1;
    L17:
        r101[1] = Integer.valueOf(r103);     // Catch: Throwable -> L53
        if (r112 == false) goto L20;
        int r104 = 1;
    L21:
        r101[2] = Integer.valueOf(r104);     // Catch: Throwable -> L53
        AVMDLLog.e(TAG, String.format(r100, "init loadLibrary:%d, needLoadP2PLib:%d, useV2:%d", r101));     // Catch: Throwable -> L53
        mIsLibraryLoaded = r110;     // Catch: Throwable -> L53
        if (mIsLibraryLoaded == true) goto L46;
        pc4.a.b();     // Catch: Throwable -> L53
        VcnlibloadWrapper.tryLoadVcnlib();     // Catch: Throwable -> L53
        loadAVMDLBaseLibrary();     // Catch: Throwable -> L53
        if (r112 == false) goto L30;
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdlv2");     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L53
        mIsLibraryLoaded = true;     // Catch: UnsatisfiedLinkError -> L27 Throwable -> L53
    L27:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L53
        e.getMessage();     // Catch: Throwable -> L53
    L30:
        if (mIsLibraryLoaded == true) goto L46;
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdl");     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
        mIsLibraryLoaded = true;     // Catch: Throwable -> L33 UnsatisfiedLinkError -> L35
    L37:
        VcnlibloadWrapper.tryLoadVcnverifylib();     // Catch: Throwable -> L53
        if (r111 == true) goto L60;
    L45:
        tryLoadTTNetLoaderPlugin();     // Catch: Throwable -> L53
        tryLoadByteMediaNetLoaderPlugin();     // Catch: Throwable -> L53
        goto L46
    L60:
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLDataLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("avmdlp2p");     // Catch: Throwable -> L41 UnsatisfiedLinkError -> L43
    L43:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L53
    L41:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L53
        goto L45
    L35:
        e = move-exception;
        mLoadFailMsg = "Can't load avmdl library: " + e;     // Catch: Throwable -> L53
        e.toString();     // Catch: Throwable -> L53
    L33:
        th = move-exception;
        mLoadFailMsg = "other exception when loading avmdl library: " + th;     // Catch: Throwable -> L53
        th.toString();     // Catch: Throwable -> L53
    L46:
        if (mIsLibraryLoaded == true) goto L51;
        monitor-exit(AVMDLDataLoader.class);
        return -1;
    L51:
        monitor-exit(AVMDLDataLoader.class);
        return 0;
    L20:
        r104 = 0;
        goto L21
    L16:
        r103 = 0;
        goto L17
    L12:
        r102 = 0;
        goto L13
    }

    private double testFileIO(String r100, int r101, RandomAccessFile r110) throws Exception {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1.0d;
    L5:
        long r102 = System.currentTimeMillis();
        r110.seek(r101);
        byte[] r103 = new byte[4096];
        int r104 = 0;
    L7:
        if (r104 >= 200) goto L9;
        Thread.sleep(5);
        r110.write(r103, 0, 1024);
        r104 = r104 + 1;
        goto L7
    L9:
        long r105 = ((System.currentTimeMillis() - r102) - ((long) 1000)) + 0;
        if (r105 <= 0) goto L13;
        AVMDLLog.d("BENCHMARKIO", String.format(Locale.US, "size:%d costtime:%d", new Object[]{819200, Long.valueOf(r105)}));
        return 819200 / r105;
    L13:
        return -1.0d;
    }

    public long copyFile(String r110, String r111, boolean r112) {
        long r100 = -1;
        if (this.mState == 1) goto L5;
        return -1;
    L5:
        this.mWriteLock.lock();
        boolean r101 = false;
        long r102 = this.mHandle;     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
        if (r102 == 0) goto L12;
        if (r112 == false) goto L10;
        int r103 = 1;
    L11:
        r100 = _copyFileWithForceFlag64(r102, r110, r111, r103);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L15
    L10:
        r103 = 0;
    L12:
        this.mWriteLock.unlock();
        return r100;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L15:
        e = move-exception;
        long r104 = this.mHandle;     // Catch: Throwable -> L13
        if (r104 == 0) goto L29;
        if (r112 == false) goto L21;
        int r105 = 1;
    L35:
        r100 = _copyFileWithForceFlag(r104, r110, r111, r105);     // Catch: Throwable -> L13 UnsatisfiedLinkError -> L24
    L26:
        if (r101 == false) goto L29;
        if (r112 == true) goto L29;
        r100 = copyFile(r110, r111);     // Catch: Throwable -> L13
        goto L29
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        r101 = true;
        goto L26
    L21:
        r105 = 0;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L12
    }

    public long getContinueCacheSize(String r110, int r111, long r112) {
        long r100 = -1;
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return -1;
    L8:
        this.mReadLock.lock();
        long r101 = this.mHandle;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        if (r101 == 0) goto L13;
        r100 = _getContinueCacheSize(r101, r110, r111, r112);     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        goto L13
    L13:
        this.mReadLock.unlock();
        return r100;
    L14:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L13
    }

    public String getStringValueByStrkey(int r100, long r101, String r102) {
        if (this.mState == 1) goto L6;
        return null;
    L6:
        if (r100 == 1503) goto L33;
        if (r100 == 1506) goto L28;
        if (r100 == 1509) goto L28;
        if (r100 == 3512) goto L42;
        if (r100 == 11012) goto L41;
        if (r100 == 6401) goto L21;
        if (r100 == 6402) goto L21;
        return null;
    L21:
        if (this.mVodListener != null) goto L23;
        return null;
    L23:
        if (TextUtils.isEmpty(r102) == true) goto L39;
        String r103 = this.mVodListener.getStringValue(r100, r101, r102);
        AVMDLLog.d("ttmdljava", "what:" + r100 + ", code:" + r101 + ", key3" + r102 + ", result:" + r103);
        return r103;
    L39:
        return null;
    L41:
        return AVMDLDeviceUtil.getDeviceModel();
    L42:
        return getProxyUrl();
    L28:
        if (this.mVodListener != null) goto L30;
        return null;
    L30:
        if (TextUtils.isEmpty(r102) == false) goto L45;
        return null;
    L45:
        return this.mVodListener.getStringValue(r100, r101, r102);
    L33:
        if (this.mVodListener != null) goto L35;
        return null;
    L35:
        if (TextUtils.isEmpty(r102) == false) goto L37;
        return null;
    L37:
        return this.mVodListener.getCheckSumInfo(r102);
    }

    public void onLogInfo(int r100, int r101, String r102) {
        onLogInfo(r100, r101, -1, r102);
    }

    public void onNotify(int r100, long r101, int r102) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        if (this.mHandler == null) goto L10;
        AVMDLDataLoaderNotifyInfo r103 = new AVMDLDataLoaderNotifyInfo();
        r103.what = r100;
        r103.parameter = r101;
        r103.code = r102;
        Message r104 = this.mHandler.obtainMessage();
        r104.obj = r103;
        r104.what = r100;
        r104.sendToTarget();
        return;
    }

    public void preloadResource(String r110, long r111, long r112) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return;
    L8:
        if (r112 == 0) goto L27;
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        if (r100 == 0) goto L14;
        _preloadResourceWithOffset(r100, r110, r111, r112);     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
    L14:
        this.mWriteLock.unlock();
        return;
    L15:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L14
    }

    public void setInt64ValueByStrKey(int r100, String r101, long r110) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r102 == 0) goto L9;
        _setInt64ValueByStrKey(r102, r100, r101, r110);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public long copyFile(String r100, String r110, String r111) {
        long r101 = -1;
        if (this.mState == 1) goto L5;
        return -1;
    L5:
        this.mWriteLock.lock();
        long r102 = this.mHandle;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (r102 == 0) goto L9;
        r101 = _copyFileWithCustomDir64(r102, r100, r110, r111);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L9:
        this.mWriteLock.unlock();
        return r101;
    L12:
        e = move-exception;
        long r103 = this.mHandle;     // Catch: Throwable -> L10
        if (r103 != 0) goto L27;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L9
    L27:
        r101 = _copyFileWithCustomDir(r103, r100, r110, r111);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L18
        goto L20
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public static /* synthetic */ int access$1300(long r100, long r101, String r102, String r103) {
        return _dhSetValue(r100, r101, r102, r103);
    }

    public static /* synthetic */ int access$500(long r100, int r101, String r102, MDLDownloaderCallback r103) {
        return _dmBussinessInit(r100, r101, r102, r103);
    }

    public static /* synthetic */ int access$600(long r100, int r101, String r102, String r103) {
        return _dmSetValue(r100, r101, r102, r103);
    }

    public void onLogInfo(int r110, int r111, int r112, String r113) {
        String r100 = "unknown";
        if (this.mState == 1) goto L5;
        return;
    L5:
        if (this.mLogHandler == null) goto L112;
        AVMDLDataLoaderNotifyInfo r101 = new AVMDLDataLoaderNotifyInfo();
        r101.what = r110;
        r101.code = r111;
        r101.logInfo = r113;
        r101.parameter = r112;
        AVMDLLog.d("ttmdljava", "onLogInfo what:" + r101.what);
        if (isNotifyInfo(r110) == true) goto L101;
        AVMDLLog.d("ttmdljava", "onLogInfo what: " + r101.what + " is not notify");
        if (r110 != 4) goto L12;
    L14:
        if (r110 == 0) goto L95;
        boolean r114 = false;
        if (r110 != 1) goto L18;
        r101.logType = "own_vdp";
    L97:
        if (r114 != true) goto L101;
        if (r101.jsonLog != null) goto L101;
        return;
    L18:
        if (r110 != 10) goto L20;
        r101.logType = "own_live_loader";
        goto L97
    L20:
        if (r110 != 11) goto L22;
        r101.logType = "own_live_loader_sample";
        goto L97
    L22:
        if (r110 != 19) goto L24;
        r101.logType = "mdl_downloader_log";
        goto L97
    L24:
        if (r110 != 70) goto L26;
        r101.logType = "heart_beat";
    L96:
        r114 = true;
        goto L97
    L26:
        if (r110 != 700) goto L28;
        if (TextUtils.isEmpty(r101.logInfo) == true) goto L97;
        String[] r102 = r101.logInfo.split(",");     // Catch: Throwable -> L89
        if (r102.length < 4) goto L97;
        r101.logType = "unknown";     // Catch: Throwable -> L89
        if (r102[0].equals("0") == false) goto L53;
        r101.logType = "video";     // Catch: Throwable -> L89
    L55:
        r101.logInfo = r102[1];     // Catch: Throwable -> L89
        r101.code = CastLongProtector.parseLong(r102[2]);     // Catch: NumberFormatException -> L103 Throwable -> L89
    L107:
        r101.parameter = CastIntegerProtector.parseInt(r102[3]);     // Catch: NumberFormatException -> L104 Throwable -> L89
    L61:
        String r103 = "-1";
        if (r102.length < 5) goto L64;
        String r115 = r102[4];     // Catch: Throwable -> L89 Throwable -> L89
    L66:
        if (r102.length < 6) goto L68;
        String r104 = r102[5];     // Catch: Throwable -> L89 Throwable -> L89
    L70:
        if (r102.length < 7) goto L73;
        r100 = r102[6];     // Catch: Throwable -> L89 Throwable -> L89
    L73:
        if (r102.length < 8) goto L75;
        String r105 = r102[7];     // Catch: Throwable -> L89 Throwable -> L89
    L77:
        if (r102.length < 9) goto L79;
        String r106 = r102[8];     // Catch: Throwable -> L89 Throwable -> L89
    L81:
        if (r102.length < 10) goto L83;
        String r107 = r102[9];     // Catch: Throwable -> L89 Throwable -> L89
    L85:
        if (r102.length < 11) goto L87;
        r103 = r102[10];     // Catch: Throwable -> L89 Throwable -> L89
    L87:
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L89 Throwable -> L89
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L89 Throwable -> L89
        r108.put("tcpRtt", r115);     // Catch: Throwable -> L89 Throwable -> L89
        r108.put("tcpLastRecvDate", r104);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("tcpInfo", r108);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("protocol", r100);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("downStart", r105);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("downEnd", r106);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("curBuf", r107);     // Catch: Throwable -> L89 Throwable -> L89
        r116.put("fullBuf", r103);     // Catch: Throwable -> L89 Throwable -> L89
        r101.logExtraJsonStr = r116.toString();     // Catch: Throwable -> L89 Throwable -> L89
        goto L97
    L83:
        r107 = "-1";
        goto L85
    L79:
        r106 = "-1";
        goto L81
    L75:
        r105 = "-1";
        goto L77
    L68:
        r104 = "-1";
        goto L70
    L64:
        r115 = "-1";
        goto L66
    L53:
        if (r102[0].equals("1") == false) goto L55;
        r101.logType = "audio";     // Catch: Throwable -> L89
        goto L55
    L28:
        if (r110 != 702) goto L30;
        r101.logType = "speed_info";
        goto L97
    L30:
        if (r110 == 703) goto L43;
        switch(r110) {
            case 13: goto L42;
            case 14: goto L41;
            case 15: goto L40;
            case 16: goto L95;
            default: goto L32;
        };
    L32:
        switch(r110) {
            case 1000: goto L39;
            case 1001: goto L38;
            case 1002: goto L37;
            case 1003: goto L36;
            case 1004: goto L35;
            case 1005: goto L34;
            default: goto L97;
        };
    L34:
        r101.logType = "bb_storage";
        goto L97
    L35:
        r101.logType = "bb_sample";
        goto L97
    L36:
        r101.logType = "bb_task";
        goto L97
    L37:
        r101.logType = "bb_preload";
        goto L97
    L38:
        r101.logType = "bb_protocol";
        goto L97
    L39:
        r101.logType = "bb_proxy";
        goto L97
    L40:
        r101.logType = "mdl_dns_log";
        goto L97
    L41:
        r101.logType = "alog_info";
        goto L97
    L42:
        r101.logType = "pcdn_task";
        goto L97
    L43:
        r101.logType = "global_speed";
    L95:
        r101.logType = "media_loader";
        goto L96
    L12:
        if (r110 == 14) goto L14;
        r101.logToJson();
    L101:
        Message r117 = this.mLogHandler.obtainMessage();
        r117.what = r110;
        r117.obj = r101;
        r117.sendToTarget();
        return;
    }

    public void preloadGroupResource(String r110, String r111, long r112, long r113) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r111) == false) goto L8;
        return;
    L8:
        if (r113 == 0) goto L27;
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        if (r100 == 0) goto L14;
        _preloadGroupResource(r100, r110, r111, r112, r113);     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
    L14:
        this.mWriteLock.unlock();
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public synchronized void onTaskEvent(int r100, String r101, int r102, int r110, String r111) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.mTaskListener != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (AVMDLTaskEventID.taskTypeIsValid(r102) == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (AVMDLTaskEventID.eventTypeIsValid(r110) == true) goto L16;
        monitor-exit(this);
        return;
    L16:
        if (TextUtils.isEmpty(r101) == false) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r111) == false) goto L32;
    L24:
        JSONObject r103 = null;
    L25:
        this.mTaskListener.onTaskEventNotify(r100, r101, r102, r110, r103);     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L32:
        r103 = new JSONObject(r111);     // Catch: Exception -> L31 Throwable -> L28
        goto L25
    }

    public void updateDNSInfo(String r110, String r111, long r112, String r113, int r114) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        this.mWriteLock.lock();
        _updateDNSInfo(this.mHandle, r110, r111, r112, r113, r114);     // Catch: Throwable -> L8 UnsatisfiedLinkError -> L10
    L7:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L7
    }

    public int writeDataToFile(String r110, long r111, long r210, int r211, byte[] r212) {
        if (this.mState == 1) goto L6;
        return -1;
    L6:
        AVMDLLog.d(TAG, "start write data to file filekey:" + r110 + " off:" + r210 + " length:" + r211);
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L11 Exception -> L14 UnsatisfiedLinkError -> L16
        String r112 = TAG;
        int r101 = _writeDataToFile(r100, r110, r111, r210, r211, r212);     // Catch: Throwable -> L11 Exception -> L20 UnsatisfiedLinkError -> L21
        this.mWriteLock.unlock();
    L18:
        AVMDLLog.d(r112, "end write data to file filekey:" + r110 + " off:" + r210 + " length:" + r211);
        return r101;
    L15:
        this.mWriteLock.unlock();
        r101 = -3;
    L17:
        this.mWriteLock.unlock();
        r101 = -2;
        goto L18
    L11:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L14:
        r112 = TAG;
    L16:
        r112 = TAG;
        goto L17
    }

    public static /* synthetic */ int access$1000(long r100, long r101, long r102, int r103, byte[] r104, int r105) {
        return _dhRead(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ long access$800(long r100, int r101, String r102, Map r103, Map r104, String r105) {
        return _dmCreateHandler(r100, r101, r102, r103, r104, r105);
    }
}
