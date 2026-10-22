package com.ss.ttm.player;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class TTPlayerConfiger {
    private static String APP_EXTERNAL_DATA_PATH = null;
    private static String APP_PATH = null;
    private static String CRASH_FILE_NAME = "ttplayer_crash.log";
    private static String CRASH_FILE_PATH = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_POOL_STACK_SIZE = 32;
    public static final int DEFAULT_VC2_DEC_POOL_SIZE = 2;
    public static final int DEFAULT_VC2_STACK_SIZE_VALUE = 131072;
    public static final int DEFAULT_VC2_THREAD_PRIORITY_VALUE = 5242880;
    public static final int FALSE = 0;
    public static boolean IS_PRINT_INFO = false;
    public static final int IS_TIME_OUT_COUNT = 3;
    private static final ConcurrentHashMap<Integer, Value> KEYS = null;
    public static final int KEY_IS_AUDIOTRACK_POOL_CHECK_INTERVAL = 82;
    public static final int KEY_IS_AUDIOTRACK_POOL_EXPIRE_CHECK = 81;
    public static final int KEY_IS_AUDIOTRACK_POOL_MAX_USED_COUNT = 50;
    public static final int KEY_IS_AUDIOTRACK_POOL_SAMPLES_CHECK = 51;
    public static final int KEY_IS_AUDIOTRACK_POOL_SIZE = 47;
    public static final int KEY_IS_AUDIOX_BAT_CONFIG_JSON = 77;
    public static final int KEY_IS_AUDIO_ADAPTER_MAX_QUEUE_SIZE = 52;
    public static final int KEY_IS_AUDIO_ADAPTER_MAX_USE_COUNT = 53;
    public static final int KEY_IS_AUDIO_DECODER_THREAD_STACK_SIZE_KB = 63;
    public static final int KEY_IS_AUDIO_GRAPH_THREAD_STACK_SIZE_KB = 72;
    public static final int KEY_IS_AUDIO_OUTLET_THREAD_STACK_SIZE_KB = 61;
    public static final int KEY_IS_AV_BASE_PLAYER_THREAD_STACK_SIZE_KB = 65;
    public static final int KEY_IS_AV_FORMATER_THREAD_STACK_SIZE_KB = 66;
    public static final int KEY_IS_BATTERY_INFO = 23;
    public static final int KEY_IS_BUSINESS_TYPE = 33;
    public static final int KEY_IS_CHECK_LIB = 3;
    public static final int KEY_IS_CHECK_TTPLAYER_MODEL = 0;
    public static final int KEY_IS_CRASHED = 7;
    public static final int KEY_IS_CRASH_FILE_NAME = 17;
    public static final int KEY_IS_CRASH_PATH = 19;
    public static final int KEY_IS_DEBUG_MODEL = 6;
    public static final int KEY_IS_DIRECTBUFFER_POOL_CHECK_INTERVAL = 86;
    public static final int KEY_IS_DIRECTBUFFER_POOL_EXPIRE_CHECK = 85;
    public static final int KEY_IS_DIRECTBUFFER_POOL_SIZE = 84;
    public static final int KEY_IS_ENABLE_AUDIOX_PLUGIN = 78;
    public static final int KEY_IS_ENABLE_AVBUFFER_REUSE = 79;
    public static final int KEY_IS_ENABLE_AVPACKET_REUSE = 80;
    public static final int KEY_IS_ENABLE_GLOBAL_MUTE_FEATURE = 31;
    public static final int KEY_IS_ENABLE_LOAD_AFLNA_SO = 83;
    public static final int KEY_IS_ENABLE_REFACTOR_LOGGER = 75;
    public static final int KEY_IS_ENABLE_THREAD2_POOL = 45;
    public static final int KEY_IS_ENABLE_VC2_DEC_POOL = 41;
    public static final int KEY_IS_ENABLE_VC2_THREAD_PRIORITY = 34;
    public static final int KEY_IS_ENABLE_VC2_THREAD_PRIORITY_LITE = 36;
    public static final int KEY_IS_EXO_PLAYER_ON = 26;
    public static final int KEY_IS_FALLBACK_EXO_FIRST = 27;
    public static final int KEY_IS_FAST_MALLOC_ARENAS_NUM = 68;
    public static final int KEY_IS_FAST_MALLOC_ENABLE_TCACHE = 69;
    public static final int KEY_IS_FAST_MALLOC_LG_CHUNK = 71;
    public static final int KEY_IS_FAST_MALLOC_LG_TCACHE_MAX = 70;
    public static final int KEY_IS_FORBID_CREATED_OS_PLAYER = 11;
    public static final int KEY_IS_FOREGROUND = 21;
    public static final int KEY_IS_FREEDOM_PLAYER_ON = 37;
    public static final int KEY_IS_GET_VC2_DEC_POOL_SIZE = 42;
    public static final int KEY_IS_GLOBAL_AVMESSAGE_POOL_SIZE = 56;
    public static final int KEY_IS_GLOBAL_BUFFER_POOL = 55;
    public static final int KEY_IS_GLOBAL_CHECK_POOL_EXPIRE_INTERVAL_MS = 58;
    public static final int KEY_IS_GLOBAL_ENABLE_MEMORY_POOL = 59;
    public static final int KEY_IS_GLOBAL_FFPKTBUFFER_POOL_SIZE = 57;
    public static final int KEY_IS_GLOBAL_FF_REGISTER_CACHE = 88;
    public static final int KEY_IS_GLOBAL_MEMORY_OPT = 49;
    public static final int KEY_IS_GLOBAL_MEM_POOL_BLOCKSIZE = 87;
    public static final int KEY_IS_GLOBAL_MUTE = 32;
    public static final int KEY_IS_GLOBAL_QOS_LOOPER = 44;
    public static final int KEY_IS_GLOBAL_THREAD2_REFACTOR = 54;
    public static final int KEY_IS_IPTTPLAYER_ON = 2;
    public static final int KEY_IS_LOG_FILE_DIR = 20;
    public static final int KEY_IS_LOOPER_THREAD_STACK_SIZE_KB = 67;
    public static final int KEY_IS_MEDIA_CODEC_USING_CODEC2 = 48;
    public static final int KEY_IS_ON_SCREEN = 22;
    public static final int KEY_IS_OPEN_DEVICE_FAIL = 8;
    public static final int KEY_IS_OTHER_THREAD_STACK_SIZE_KB = 73;
    public static final int KEY_IS_PLAYER_CREATION_CONFIG = 43;
    public static final int KEY_IS_PORT_VERSION = 18;
    public static final int KEY_IS_PRINT_INFO = 5;
    public static final int KEY_IS_SDK_VERSION = 13;
    public static final int KEY_IS_SDK_VERSION_INFO = 15;
    public static final int KEY_IS_SDK_VERSION_NAME = 14;
    public static final int KEY_IS_SKIP_LOAD_SSL = 28;
    public static final int KEY_IS_SKIP_LOAD_STL = 30;
    public static final int KEY_IS_START_SERVICE = 16;
    public static final int KEY_IS_STOP_SERVICE = 12;
    public static final int KEY_IS_THREAD2_POOL_SIZE = 46;
    public static final int KEY_IS_THREAD_POOL_STACK_SIZE = 25;
    public static final int KEY_IS_THREAD_V2 = 38;
    public static final int KEY_IS_THROW_CRASH = 4;
    public static final int KEY_IS_TIMEOUT_COUNT = 10;
    public static final int KEY_IS_TTPLAYER_ON = 1;
    public static final int KEY_IS_TUNER_GLOBAL_UPDATE_SIZE = 74;
    public static final int KEY_IS_USED_THREAD_POOL = 24;
    public static final int KEY_IS_USE_BETA_PLAYER = 29;
    public static final int KEY_IS_USE_PGO_PLAYER = 76;
    public static final int KEY_IS_VC2_STACK_SIZE_OPT = 39;
    public static final int KEY_IS_VC2_STACK_SIZE_VALUE = 40;
    public static final int KEY_IS_VC2_THREAD_PRIORITY_VALUE = 35;
    public static final int KEY_IS_VIDEO_DECODER_THREAD_STACK_SIZE_KB = 62;
    public static final int KEY_IS_VIDEO_MEDIACODEC_THREAD_STACK_SIZE_KB = 64;
    public static final int KEY_IS_VIDEO_OUTLET_THREAD_STACK_SIZE_KB = 60;
    private static String LIBRARY_DIR = null;
    private static String PLAYER_LIBRARY_NAME = "libttmplayer.so";
    private static final int PORT_VERSION = 2;
    public static final String TAG = "ttplayer";
    public static final int TRUE = 1;
    private static String TTPLAYER_FILE_CACHE_DIR = null;
    private static final int VERSION = 1;
    private static final String VERSION_INFO = "version code:1,name:999.999.999.9default sdk info 2016-12-05";
    private static final String VERSION_NAME = "999.999.999.9";

    public static final class IntValue extends Value {
        private int mValue;

        public int getValue() {
            return this.mValue;
        }

        public void setValue(int r100) {
            this.mValue = r100;
        }

        public IntValue(int r100, int r101) {
            super(r100);
            this.mValue = r101;
        }
    }

    public static class LongValue extends Value {
        private long mValue;

        public long getValue() {
            return this.mValue;
        }

        public void setValue(long r100) {
            this.mValue = r100;
        }

        public LongValue(int r100, long r101) {
            super(r100);
            this.mValue = r101;
        }
    }

    public static class StringValue extends Value {
        private String mValue;

        public String getValue() {
            return this.mValue;
        }

        public void setValue(String r100) {
            this.mValue = r100;
        }

        public StringValue(int r100, String r101) {
            super(r100);
            this.mValue = r101;
        }
    }

    public static class Value {
        private int mKey;

        public int getKey() {
            return this.mKey;
        }

        public Value(int r100) {
            this.mKey = r100;
        }
    }

    public TTPlayerConfiger() {
    }

    public static void checkDebugTTPlayerLib() {
    }

    public static final String getExternalStorageDirectoryCrashFilePath(Context r100) {
        return null;
    }

    public static String getPlayerLibraryPath() {
        return getPlayerLibraryPath(null);
    }

    public static final int getVersion() {
        return 1;
    }

    public static final boolean isOnTTPlayer() {
        if (getValue(6, 0) != 1) goto L6;
        return true;
    L6:
        if (getValue(1, 0) != 0) goto L9;
        return false;
    L9:
        if (getValue(11, 0) != 1) goto L12;
        return true;
    L12:
        if (getValue(7, 0) != 1) goto L14;
    L20:
        return false;
    L14:
        if (getValue(8, 0) == 1) goto L20;
        if (getValue(10, 0) < 3) goto L19;
        return false;
    L19:
        return true;
    }

    static {
        KEYS = new ConcurrentHashMap();
        setValue(13, 1);
        setValue(14, VERSION_NAME);
        setValue(15, VERSION_INFO);
        setValue(0, false);
        setValue(1, true);
        setValue(2, true);
        setValue(3, false);
        setValue(4, false);
        setValue(5, false);
        setValue(6, false);
        setValue(7, false);
        setValue(8, false);
        setValue(10, 0);
        setValue(11, false);
        setValue(18, 2);
        setValue(25, 32);
        setValue(34, 0);
        setValue(35, 5242880);
        setValue(36, 0);
        setValue(39, 0);
        setValue(40, 131072);
        setValue(41, 0);
        setValue(42, 2);
        setValue(47, 3);
        setValue(48, 0);
        setValue(50, 20);
        setValue(51, 0);
        setValue(74, 0);
    }

    public static final String getAppExternalDataPath() {
        return APP_EXTERNAL_DATA_PATH;
    }

    public static boolean isPrintInfo() {
        return IS_PRINT_INFO;
    }

    public static final String getAppCrashFilePath(Context r100) {
        if (CRASH_FILE_PATH != null) goto L9;
        if (new PolarisFileWrapper(getAppCrashFileStorePath(r100)).exists() == true) goto L9;
        return APP_PATH + File.separatorChar + n.KEY_PLUGINS + File.separatorChar + "com.ss.ttm" + File.separatorChar + "data" + File.separatorChar + KevaImpl.PrivateConstants.FILES_DIR_NAME + File.separatorChar + CRASH_FILE_NAME;
    L9:
        if (isPrintInfo() == true) goto L12;
    L12:
        return CRASH_FILE_PATH;
    }

    public static final String getAppCrashFilePath2(Context r100) {
        if (r100 == null) goto L7;
        if (APP_PATH != null) goto L7;
        APP_PATH = r100.getApplicationContext().getFilesDir().getAbsolutePath();
    L7:
        if (CRASH_FILE_PATH != null) goto L21;
        if (APP_PATH != null) goto L12;
        APP_PATH = getAppFilesPath(r100);
    L12:
        if (isPrintInfo() == true) goto L15;
    L15:
        if (APP_PATH != null) goto L17;
        return null;
    L17:
        return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
    L21:
        if (isPrintInfo() == true) goto L24;
    L24:
        return CRASH_FILE_PATH;
    }

    public static final String getAppCrashFileStorePath(Context r100) {
        if (r100 == null) goto L7;
        if (APP_PATH != null) goto L7;
        APP_PATH = r100.getApplicationContext().getFilesDir().getAbsolutePath();
    L7:
        if (CRASH_FILE_PATH != null) goto L21;
        if (APP_PATH != null) goto L12;
        APP_PATH = getAppFilesPath(r100);
    L12:
        if (isPrintInfo() == true) goto L15;
    L15:
        if (APP_PATH != null) goto L17;
        return null;
    L17:
        return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
    L21:
        if (isPrintInfo() == true) goto L24;
    L24:
        return CRASH_FILE_PATH;
    }

    public static final String getAppFileCachePath(Context r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = TTPLAYER_FILE_CACHE_DIR;
        if (r101 == null) goto L9;
        return r101;
    L9:
        String r102 = APP_PATH;
        if (r102 == null) goto L13;
        return r102;
    L13:
        if (r100 != null) goto L18;
        return null;
    L18:
        String r103 = r100.getApplicationContext().getFilesDir().getAbsolutePath();     // Catch: Exception -> L17
        APP_PATH = r103;     // Catch: Exception -> L17
        return r103;
    L17:
        return null;
    L4:
        if (APP_PATH != null) goto L6;
        APP_PATH = r100.getApplicationContext().getFilesDir().getAbsolutePath();
        goto L6
    }

    public static final String getAppFilesPath(Context r100) {
        String r101 = APP_PATH;
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L14;
        return null;
    L14:
        APP_PATH = r100.getApplicationContext().getFilesDir().getAbsolutePath();     // Catch: Exception -> L12
        File r102 = r100.getApplicationContext().getExternalCacheDir();     // Catch: Exception -> L13
        Objects.requireNonNull(r102);     // Catch: Exception -> L13
        File r103 = r102;     // Catch: Exception -> L13
        APP_EXTERNAL_DATA_PATH = r102.getAbsolutePath();     // Catch: Exception -> L13
    L11:
        return APP_PATH;
    L12:
        return null;
    }

    public static String getPlayerLibraryPath(Context r100) {
        if (APP_PATH == null) goto L5;
        if (r100 != null) goto L5;
    L7:
        if (APP_PATH == null) goto L9;
    L12:
        String r101 = LIBRARY_DIR;
        if (r101 == null) goto L21;
        if (r101.endsWith(String.valueOf(File.separatorChar)) == false) goto L19;
        return LIBRARY_DIR + PLAYER_LIBRARY_NAME;
    L19:
        return LIBRARY_DIR + File.separatorChar + PLAYER_LIBRARY_NAME;
    L21:
        return APP_PATH + File.separatorChar + PLAYER_LIBRARY_NAME;
    L9:
        if (LIBRARY_DIR != null) goto L12;
        return null;
    L5:
        APP_PATH = getAppFilesPath(r100);
        goto L7
    }

    public static String getPlayerLibrarysDir(Context r100) {
        String r101 = LIBRARY_DIR;
        if (r101 != null) goto L7;
        String r102 = getAppFilesPath(r100) + File.separatorChar;
        LIBRARY_DIR = r102;
        return r102;
    L7:
        if (r101.endsWith(String.valueOf(File.separatorChar)) == false) goto L11;
        return LIBRARY_DIR;
    L11:
        return LIBRARY_DIR + File.separatorChar;
    }

    public static final String getPlugerCrashFilePath(Context r100) {
        return APP_PATH + File.separatorChar + n.KEY_PLUGINS + File.separatorChar + "com.ss.ttm" + File.separatorChar + "data" + File.separatorChar + KevaImpl.PrivateConstants.FILES_DIR_NAME + File.separatorChar + CRASH_FILE_NAME;
    }

    public static final void setCrashFileName(String r100) {
        CRASH_FILE_NAME = r100;
    }

    public static final void setCrashFilePath(String r100) {
        CRASH_FILE_PATH = r100;
    }

    public static final void setLibraryName(String r100) {
        PLAYER_LIBRARY_NAME = r100;
    }

    public static final void setLibrarysDir(String r100) {
        LIBRARY_DIR = r100;
    }

    public static final String getValue(int r100, String r101) {
        if (r100 == 17) goto L5;
        Value r102 = KEYS.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
    L12:
        return r101;
    L9:
        if ((r102 instanceof StringValue) == false) goto L12;
        return ((StringValue) r102).getValue();
    L5:
        return CRASH_FILE_NAME;
    }

    public static final void setValue(int r100, int r101) {
        ConcurrentHashMap<Integer, Value> r102 = KEYS;
        Value r103 = r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
    L14:
        IntValue r104 = new IntValue(r100, r101);
        r102.put(Integer.valueOf(r100), r104);
        return;
    L5:
        if ((r103 instanceof IntValue) == true) goto L7;
        r102.remove(Integer.valueOf(r100));
        goto L14
    L7:
        if (r100 == 2) goto L9;
    L11:
        ((IntValue) r103).setValue(r101);
        return;
    L9:
        if (getValue(6, false) == false) goto L11;
    }

    public static final boolean getValue(int r100, boolean r101) {
        Value r102 = KEYS.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof IntValue) == true) goto L7;
        return r101;
    L7:
        if (((IntValue) r102).getValue() == 1) goto L13;
        return false;
    L13:
        return true;
    }

    public static final void setValue(int r100, long r101) {
        ConcurrentHashMap<Integer, Value> r102 = KEYS;
        Value r103 = r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
    L9:
        LongValue r104 = new LongValue(r100, r101);
        r102.put(Integer.valueOf(r100), r104);
        return;
    L5:
        if ((r103 instanceof LongValue) == false) goto L8;
        ((LongValue) r103).setValue(r101);
        return;
    L8:
        r102.remove(Integer.valueOf(r100));
        goto L9
    }

    public static final int getValue(int r100, int r101) {
        Value r102 = KEYS.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
    L8:
        return r101;
    L5:
        if ((r102 instanceof IntValue) == false) goto L8;
        return ((IntValue) r102).getValue();
    }

    public static final void setValue(int r100, String r101) {
        ConcurrentHashMap<Integer, Value> r102 = KEYS;
        Value r103 = r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
    L9:
        StringValue r104 = new StringValue(r100, r101);
        r102.put(Integer.valueOf(r100), r104);
        return;
    L5:
        if ((r103 instanceof StringValue) == false) goto L8;
        ((StringValue) r103).setValue(r101);
        return;
    L8:
        r102.remove(Integer.valueOf(r100));
        goto L9
    }

    public static final long getValue(int r100, long r101) {
        Value r102 = KEYS.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
    L8:
        return r101;
    L5:
        if ((r102 instanceof LongValue) == false) goto L8;
        return ((LongValue) r102).getValue();
    }

    public static final void setValue(int r100, boolean r101) {
        setValue(r100, r101 ? 1 : 0);
    }

    public static final boolean moveFile(String r100, String r101, boolean r102) {
        return copyFile(r100, r101, r102, true);
    }

    public static final boolean copyFile(String r100, String r101, boolean r102, boolean r103) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.exists() == true) goto L6;
        return false;
    L6:
        if (r104.isFile() == true) goto L8;
        return false;
    L8:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100);
        if (r105.exists() == false) goto L13;
        if (r102 == false) goto L17;
        new PolarisFileWrapper(r100).delete();
    L17:
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L40 IOException -> L52 FileNotFoundException -> L62
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L38 IOException -> L72 FileNotFoundException -> L73
    L82:
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
    L22:
        int r110 = r107.read(r109);     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        if (r110 == (-1)) goto L25;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        goto L22
    L25:
        r108.close();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        r107.close();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
        if (r103 == false) goto L76;
        r104.delete();     // Catch: Throwable -> L34 IOException -> L36 FileNotFoundException -> L37
    L76:
        r108.close();     // Catch: IOException -> L30
        r107.close();     // Catch: IOException -> L30
        return true;
    L30:
        e = move-exception;
        e.printStackTrace();
        return true;
    L37:
        r106 = r108;
    L36:
        r106 = r108;
    L34:
        Throwable th10 = th;
    L43:
        if (r108 != null) goto L80;
    L47:
        if (r107 == null) goto L51;
        r107.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th10;
    L80:
        r108.close();     // Catch: IOException -> L45
    L38:
        th = th;
        r108 = null;
    L42:
        th10 = th;
    L63:
        if (r106 != null) goto L78;
    L67:
        if (r107 == null) goto L71;
        r107.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L71:
        return false;
    L78:
        r106.close();     // Catch: IOException -> L65
    L53:
        if (r106 != null) goto L74;
    L57:
        if (r107 == null) goto L61;
        r107.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L61:
        return false;
    L74:
        r106.close();     // Catch: IOException -> L55
        goto L57
    L62:
        r107 = null;
    L52:
        r107 = null;
    L40:
        th = th;
        r107 = null;
        r108 = null;
        goto L42
    L13:
        if (r105.getParentFile().exists() == true) goto L17;
        if (r105.getParentFile().mkdirs() == true) goto L17;
        return false;
    }
}
