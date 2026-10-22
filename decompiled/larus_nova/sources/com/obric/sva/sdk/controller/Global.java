package com.obric.sva.sdk.controller;

import android.content.Context;
import android.os.HandlerThread;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.sdk.base.Constant;
import com.obric.sva.sdk.data.SettingsDAO;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.SvaFramework;
import com.obric.sva.sdk.utils.Utils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class Global {
    public static final boolean ALWAYS_USE_RECORDER = false;
    public static boolean DEBUG_HOTWORD_DUMP = false;
    public static int DEBUG_VOICE_REQUEST_COUNT = 200;
    public static final String DESTROY_SAMICORE_ACTIVITY_ACTION = "com.larus.nova.action.destroy.sami.core";
    public static final boolean ENABLE_BREATH_WAKEUP_SID_AUTH = false;
    public static String KEY_WAKEUP_MODEL_NAME = "obric_voice_wakeup_model_name";
    public static final int NA = -1;
    public static final String NAME_MERGED_LANGUAGE_MODEL = "merged_language_model_1225.lat";
    public static final String NAME_TRAINING_SUBDIR = "trainings";
    public static final String NAME_VOICE_REQUESTS_SUBDIR = "voiceRequests";
    public static final int OFF = 0;
    public static final int ON = 1;
    public static final String PULL_UP_ASSIST_ONCE_ACTION = "com.larus.nova.action.pull.up.assist.once";
    public static final String RECORDING_TYPE_CLEAN = "clean";
    public static final String RELOAD_SAMICORE_ACTIVITY_ACTION = "com.larus.nova.action.reload.sami.core";
    public static final String RELOAD_VOICE_SID_MODEL_BY_UPDATE = "com.larus.nova.action.reload.after.update";
    public static final String SAMI_LOG_DIR = "sa_log";
    public static final String SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS = "voice_assistant_wakeup_status";
    public static final String SHARED_WAKEUP_PREFERENCES_NAME = "sva_wakeup_config.xml";
    public static final String SUFFIX_DATA_FILE = ".data";
    public static final String SUFFIX_PCM_FILE = ".pcm";
    public static final String SUFFIX_TXT_FILE = ".txt";
    public static final String SUFFIX_WAV_FILE = ".wav";
    public static final boolean SUPPORT_CPU_BOOST = true;
    public static final boolean SUPPORT_FINGER_PRINT_AUTH = false;
    public static final boolean SUPPORT_SKIP_STAGE2 = false;
    public static final boolean SUPPORT_TRACE_SECTION = true;
    public static final String SVA_SDK_IPC_CONTENT_URL = "content://com.larus.nova.sva.sdk.ipc/call";
    public static final String TAG = "SVA-Global";
    public static final boolean USE_BACKTRACE_RECORDER = false;
    private static Object lock = null;
    private static Global mInstance = null;
    private static boolean sBreathStatus = false;
    public static boolean sDozeOn = false;
    public static boolean sEnrollIgnore = false;
    public static boolean sOutputLog = false;
    public static boolean sReloadSamiCoreByUpdate = false;
    public static Map<String, SessionType> sSessionTypeMap = null;
    public static boolean sSidOnline = true;
    public static boolean sWakeupDataUpload = true;
    public static boolean sWakeupSid = true;
    public static boolean sWakeupStatus;
    public static boolean sWakeupSupress;
    public String PATH_ENROLL_SID;
    public String PATH_ROOT;
    public String PATH_SAMI_LOG;
    public String PATH_TRAINING_RECORDINGS;
    public String PATH_TRAINING_RECORDING_TEMP_FILE;
    public String PATH_VOICE_REQUESTS;
    private AssetsFileMgr mAssetFileMgr;
    private ExtendedSmMgr mExtendedSmMgr;
    private HandlerThread mHandlerThread;
    private boolean mIsToggleXmlParam;

    static {
        lock = new String("Global.lock");
        HashMap r100 = new HashMap(2);
        sSessionTypeMap = r100;
        r100.put(SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL, SessionType.BREATH);
        sSessionTypeMap.put(SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL, SessionType.VOICE);
    }

    public static Global getInstance() {
        if (mInstance != null) goto L15;
        Object r100 = lock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new Global(ISvaFrameworkKt.getSvaFrameworkDelegate().getInitialApplication());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static boolean getBreathStatus() {
        boolean r100 = ManufactureFeatures.isFeatureBreathWakeupEnable();
        if (r100 == true) goto L6;
        LogUtils.d(TAG, "getBreathStatus ALWAYS FALSE caused by not support breath wakeup feature !! ", new Object[0]);
        return false;
    L6:
        LogUtils.d(TAG, "getBreathStatus :" + sBreathStatus + " featureEnable? " + r100, new Object[0]);
        return sBreathStatus;
    }

    public void doWarmUp() {
        getInstance();
        LogUtils.i(TAG, "doWarmUp", new Object[0]);
    }

    public ExtendedSmMgr getExtendedSmMgr() {
        return this.mExtendedSmMgr;
    }

    public boolean getIsToggleXmlParam() {
        return this.mIsToggleXmlParam;
    }

    private Global(Context r100) {
        this.PATH_ROOT = null;
        this.PATH_TRAINING_RECORDINGS = null;
        this.PATH_TRAINING_RECORDING_TEMP_FILE = null;
        this.PATH_VOICE_REQUESTS = null;
        this.PATH_ENROLL_SID = null;
        this.PATH_SAMI_LOG = null;
        this.mHandlerThread = new PthreadHandlerThreadV2("voice_assistant");
        this.mIsToggleXmlParam = false;
        SvaFramework.INSTANCE.init();
        this.PATH_ROOT = Utils.rootFilePath(r100).getAbsolutePath();
        this.PATH_TRAINING_RECORDINGS = this.PATH_ROOT + "/trainings";
        this.PATH_TRAINING_RECORDING_TEMP_FILE = this.PATH_TRAINING_RECORDINGS + "/temp_recording.wav";
        this.PATH_VOICE_REQUESTS = this.PATH_ROOT + "/voiceRequests";
        this.PATH_SAMI_LOG = this.PATH_ROOT + "/sa_log";
        rna.c.a(this.PATH_ROOT);
        rna.c.a(this.PATH_VOICE_REQUESTS);
        rna.c.a(this.PATH_SAMI_LOG);
        AssetsFileMgr r101 = new AssetsFileMgr();
        this.mAssetFileMgr = r101;
        r101.copyAssetsIfNotExists(r100, this.PATH_ROOT);
        this.mExtendedSmMgr = new ExtendedSmMgr();
        ThreadMethodProxy.start(this.mHandlerThread);
        boolean r102 = true;
        if (sna.f.a(SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, -1) != 1) goto L5;
        boolean r103 = true;
    L6:
        sWakeupStatus = r103;
        if (sOutputLog == false) goto L9;
    L13:
        sDozeOn = KtUtils.isDozeModeEnable(r100);
        if (sna.f.a(Constant.BREATH_WAKEUP_STATUS, -1) == 1) goto L17;
        r102 = false;
    L17:
        sBreathStatus = r102;
        ISvaFrameworkKt.getSvaFrameworkDelegate().start();
        SvaSdkGlobal.INSTANCE.init(r100);
        LogUtils.d(TAG, "Initialize ... sWakeupStatus = " + sWakeupStatus + ", sWakeupSid = " + sWakeupSid + ", sOutputLog = " + sOutputLog + ", sDozeOn = " + sDozeOn + ", sBreathStatus:" + sBreathStatus, new Object[0]);
        return;
    L9:
        if (sna.f.a(Constant.WAKEUP_LOG_OUTPUT_TERMINAL, 0) != 1) goto L11;
        boolean r104 = true;
    L12:
        sOutputLog = r104;
        goto L13
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    public static void setBreathStatus(boolean r100) {
        boolean r101 = ManufactureFeatures.isFeatureBreathWakeupEnable();
        LogUtils.d(TAG, "setBreathStatus :" + r100 + " featureEnable? " + r101, new Object[0]);
        if (r101 == true) goto L5;
        return;
    L5:
        sBreathStatus = r100;
    }
}
