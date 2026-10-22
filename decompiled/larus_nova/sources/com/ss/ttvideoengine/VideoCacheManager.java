package com.ss.ttvideoengine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.model.VideoCacheInfo;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.UByte;

/* JADX INFO: loaded from: classes34.dex */
public class VideoCacheManager {
    public static final int CLEAN_IFNECESSARY = 2;
    public static final int CLEAR_CACHE = 1;
    public static final int INIT_CACHE = 0;
    public static final int KEY_NUMBER = 4;
    public static final int KEY_NUMBER_ENCRYPTED = 5;
    private static String TAG = "VideoCacheManager";
    private static volatile File dir;
    private final LinkedHashMap<String, File> cache;
    private volatile float cleanFactor;
    private ClearTask clearTask;
    private volatile boolean isInited;
    private final LinkedHashMap<String, VideoCacheInfo> keyCache;
    private final ReentrantReadWriteLock lock;
    private volatile long maxSize;
    private final ProtectKeyManager protectKeyManager;
    private final ReentrantReadWriteLock.ReadLock readLock;
    private final ReentrantReadWriteLock.WriteLock writeLock;

    public static class ClearTask {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        public ClearTask() {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("clearCacheThread");     // Catch: Throwable -> L5
            this.mHandlerThread = r100;     // Catch: Throwable -> L5
            ThreadMethodProxy.start(r100);     // Catch: Throwable -> L5
            final Looper r101 = this.mHandlerThread.getLooper();     // Catch: Throwable -> L5
            this.mHandler = new AnonymousClass1(this, r101);     // Catch: Throwable -> L5
            return;
        L5:
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
            this.mHandler = null;
        }

        public void postMessage(VideoCacheManager r100, int r101) {
            if (this.mHandler != null) goto L5;
            return;
        L5:
            if (this.mHandlerThread == null) goto L9;
            Message r102 = new Message();
            r102.what = r101;
            r102.obj = r100;
            this.mHandler.sendMessage(r102);
            return;
        }
    }

    public static final class ProtectKeyManager {
        private final Map<String, Integer> protectKeys;

        private ProtectKeyManager() {
            this.protectKeys = new HashMap();
        }

        public /* synthetic */ ProtectKeyManager(AnonymousClass1 r100) {
            this();
        }

        public synchronized void addProtectKey(String r100) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (TextUtils.isEmpty(r100) == true) goto L9;
            Integer r101 = this.protectKeys.get(r100);     // Catch: Throwable -> L11
            if (r101 != null) goto L8;
            this.protectKeys.put(r100, 1);     // Catch: Throwable -> L11
            goto L9
        L8:
            this.protectKeys.put(r100, Integer.valueOf(r101.intValue() + 1));     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
        }

        public synchronized boolean containsKey(String r100) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (TextUtils.isEmpty(r100) == true) goto L8;
            boolean r101 = this.protectKeys.containsKey(r100);     // Catch: Throwable -> L11
            monitor-exit(this);
            return r101;
        L8:
            monitor-exit(this);
            return false;
        }

        public synchronized void removeProtectKey(String r100) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (TextUtils.isEmpty(r100) == true) goto L11;
            Integer r101 = this.protectKeys.get(r100);     // Catch: Throwable -> L13
            if (r101 == null) goto L11;
            if (r101.intValue() != 1) goto L10;
            this.protectKeys.remove(r100);     // Catch: Throwable -> L13
            goto L11
        L10:
            this.protectKeys.put(r100, Integer.valueOf(r101.intValue() - 1));     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);
        }
    }

    public static class VideoCacheManagerSingletonHolder {
        private static final VideoCacheManager instance = null;

        private VideoCacheManagerSingletonHolder() {
        }

        static {
            instance = new VideoCacheManager(null);
        }

        public static /* synthetic */ VideoCacheManager access$200() {
            return instance;
        }
    }

    public void cleanIfNecessary() {
        TTVideoEngineLog.d(TAG, "start clean file maxSize: " + this.maxSize);
        trimSize(this.maxSize);
        TTVideoEngineLog.d(TAG, "end clean file maxSize: " + this.maxSize);
    }

    public void clear() {
        TTVideoEngineLog.d(TAG, "start clear all cache");
        trimSize(0);
        TTVideoEngineLog.d(TAG, "end clear all cache");
    }

    public void init() {
        TTVideoEngineLog.i(TAG, "start init videocachemanager");
        this.writeLock.lock();
    L38:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L43
    L37:
        this.writeLock.unlock();
        TTVideoEngineLog.d(TAG, "end init videocachemanager");
        return;
    L43:
        th = move-exception;
        this.writeLock.unlock();
        throw th;
    L4:
        if (this.isInited == true) goto L37;
        if (isValidDir(dir) == false) goto L37;
        File[] r100 = dir.listFiles();     // Catch: Throwable -> L38
        if (r100 != null) goto L10;
    L36:
        this.isInited = true;     // Catch: Throwable -> L38
        goto L37
    L10:
        if (r100.length <= 0) goto L36;
        final HashMap r101 = new HashMap(r100.length);     // Catch: Throwable -> L38
        ArrayList r102 = new ArrayList(r100.length);     // Catch: Throwable -> L38
        int r103 = r100.length;     // Catch: Throwable -> L38
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L17;
        File r105 = r100[r104];     // Catch: Throwable -> L38
        if (r105.isFile() == false) goto L16;
        r102.add(r105);     // Catch: Throwable -> L38
        r101.put(r105, Long.valueOf(r105.lastModified()));     // Catch: Throwable -> L38
    L16:
        r104 = r104 + 1;     // Catch: Throwable -> L38
        goto L12
    L17:
        Collections.sort(r102, new AnonymousClass1(this, r101));     // Catch: Throwable -> L38
        Iterator r106 = r102.iterator();     // Catch: Throwable -> L38
    L19:
        if (r106.hasNext() == false) goto L36;
        File r107 = (File) r106.next();     // Catch: Throwable -> L38
        TTVideoEngineLog.i(TAG, String.format("add file:%s", new Object[]{r107.getName()}));     // Catch: Throwable -> L38
        this.cache.put(getKey(r107), r107);     // Catch: Throwable -> L38
        String[] r108 = extractKeys(r107);     // Catch: Throwable -> L38
        if (isValidKeys(r108) == false) goto L19;
        String r109 = String.format("%s_%s", new Object[]{r108[0], r108[1]});     // Catch: Throwable -> L38
        String r110 = String.format("%s_%s_%s_%s", new Object[]{r108[0], r108[1], r108[2], r108[3]});     // Catch: Throwable -> L38
        if (r108.length != 5) goto L25;
        String r111 = r108[4];     // Catch: Throwable -> L38
    L26:
        String r112 = r107.getCanonicalPath();     // Catch: Throwable -> L38
        if (r111 != null) goto L29;
    L35:
        this.keyCache.put(r109, new VideoCacheInfo(r112, r110, r110, r111));     // Catch: Throwable -> L38
        goto L19
    L29:
        if (r111.length() <= 0) goto L35;
        String r113 = TTHelper.customBase64Encode(r111);     // Catch: Throwable -> L38
        if (r113 == null) goto L35;
        if (r113.equals(r111) == true) goto L35;
        r112 = r112.replace(r111, r113);     // Catch: Throwable -> L38
        r107.renameTo(new PolarisFileWrapper(r112));     // Catch: Throwable -> L38
        r111 = r113;
        goto L35
    L25:
        r111 = null;
        goto L26
    }

    public void start() {
        this.clearTask.postMessage(this, 0);
    }

    private VideoCacheManager() {
        this.cache = new LinkedHashMap(0, 0.75f, true);
        this.keyCache = new LinkedHashMap(0, 0.75f, true);
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        this.lock = r100;
        this.readLock = r100.readLock();
        this.writeLock = r100.writeLock();
        this.maxSize = 209715200;
        this.cleanFactor = 0.3f;
        this.isInited = false;
        this.protectKeyManager = new ProtectKeyManager(null);
        this.clearTask = new ClearTask();
    }

    public static VideoCacheManager getInstance() {
        return VideoCacheManagerSingletonHolder.access$200();
    }

    public /* synthetic */ VideoCacheManager(AnonymousClass1 r100) {
        this();
    }

    private String[] extractKeys(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101 != null) goto L8;
    L11:
        return null;
    L8:
        if (r101.length <= 0) goto L11;
        return r101[0].split("_");
    }

    private String getKey(File r100) {
        return r100.getName();
    }

    public static void setDir(File r100) {
        if (r100 == null) goto L5;
        dir = r100;
        return;
    }

    private void trimSize(long r110) {
        HashSet r100 = new HashSet();
        TTVideoEngineLog.d(TAG, "start trim");
        this.writeLock.lock();
        Iterator<Map.Entry<String, File>> r101 = this.cache.entrySet().iterator();     // Catch: Throwable -> L39
        long r102 = 0;
    L5:
        if (r101.hasNext() == false) goto L7;
        r102 = r102 + r101.next().getValue().length();     // Catch: Throwable -> L39
        goto L5
    L7:
        TTVideoEngineLog.d(TAG, "current file size: " + r102 + ", maxsize: " + r110);     // Catch: Throwable -> L39
        if (r102 > r110) goto L13;
        this.writeLock.unlock();
        return;
    L13:
        long r103 = (long) (r110 * this.cleanFactor);     // Catch: Throwable -> L39
        HashSet r104 = new HashSet();     // Catch: Throwable -> L39
        HashSet r105 = new HashSet();     // Catch: Throwable -> L39
        Iterator<Map.Entry<String, File>> r111 = this.cache.entrySet().iterator();     // Catch: Throwable -> L39
    L15:
        if (r111.hasNext() == false) goto L30;
        Map.Entry<String, File> r112 = r111.next();     // Catch: Throwable -> L39
        File r113 = r112.getValue();     // Catch: Throwable -> L39
        if (r113 != null) goto L19;
    L27:
        r104.add(r112.getKey());     // Catch: Throwable -> L39
    L29:
        if (r102 > r103) goto L15;
    L19:
        if (r113.exists() == false) goto L27;
        if (this.protectKeyManager.containsKey(getKey(r113)) == true) goto L29;
        long r114 = r113.length();     // Catch: Throwable -> L39
        PolarisFileWrapper r115 = new PolarisFileWrapper(r113.getAbsolutePath() + "-tmp");     // Catch: Throwable -> L39
        if (r113.renameTo(r115) == false) goto L29;
        r100.add(r115);     // Catch: Throwable -> L39
        r102 = r102 - r114;     // Catch: Throwable -> L39
        r104.add(r112.getKey());     // Catch: Throwable -> L39
        String[] r106 = extractKeys(r113);     // Catch: Throwable -> L39
        if (isValidKeys(r106) == false) goto L29;
        r105.add(String.format("%s_%s", new Object[]{r106[0], r106[1]}));     // Catch: Throwable -> L39
    L30:
        Iterator r107 = r104.iterator();     // Catch: Throwable -> L39
    L32:
        if (r107.hasNext() == false) goto L34;
        this.cache.remove((String) r107.next());     // Catch: Throwable -> L39
        goto L32
    L34:
        Iterator r108 = r105.iterator();     // Catch: Throwable -> L39
    L35:
        if (r108.hasNext() == false) goto L41;
        this.keyCache.remove((String) r108.next());     // Catch: Throwable -> L39
    L41:
        this.writeLock.unlock();
        Iterator r109 = r100.iterator();
    L43:
        if (r109.hasNext() == false) goto L59;
        File r116 = (File) r109.next();
        String r117 = TAG;     // Catch: Throwable -> L55
        Object[] r118 = new Object[1];     // Catch: Throwable -> L53
        r118[0] = r116.getName();     // Catch: Throwable -> L51
        TTVideoEngineLog.d(r117, String.format("delete file name:%s", r118));     // Catch: Throwable -> L51
        r116.delete();     // Catch: Throwable -> L51
    L51:
        th = th;
    L58:
        TTVideoEngineLog.d(th);
    L53:
        th = th;
    L55:
        th = th;
        goto L58
    L59:
        TTVideoEngineLog.d(TAG, "end trim");
        return;
    L39:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        this.writeLock.unlock();
        throw th;
    }

    public void addProtectKey(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        TTVideoEngineLog.i(TAG, String.format("start add protect key:%s", new Object[]{r100}));
        this.protectKeyManager.addProtectKey(r100);
        TTVideoEngineLog.d(TAG, String.format("end add protect key:%s", new Object[]{r100}));
        return;
    }

    public VideoCacheInfo getCacheInfo(String r100) {
        VideoCacheInfo r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.readLock.tryLock() == true) goto L25;
    L24:
        return r101;
    L25:
        VideoCacheInfo r102 = this.keyCache.get(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L29;
    L17:
        r101 = r102;
    L20:
        this.readLock.unlock();
        goto L24
    L29:
        r102.spadeaKey = TTHelper.customBase64Decode(r102.spadeaKey);     // Catch: Throwable -> L15
        String[] r103 = extractKeys(r102.fileName);     // Catch: Throwable -> L15
        if (isValidKeys(r103) == true) goto L12;
    L13:
        TTVideoEngineLog.d(TAG, String.format("get info err", new Object[]{r100}));     // Catch: Throwable -> L15
        goto L20
    L12:
        if (checkMD5(r102.filePath, r103[2], Long.parseLong(r103[3])) == true) goto L17;
    L15:
        th = th;
        r101 = r102;
    L27:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.readLock.unlock();
        throw th;
    L18:
        th = th;
        goto L27
    }

    public boolean isCacheInfoExist(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (this.readLock.tryLock() == true) goto L18;
    L15:
        return r101;
    L18:
        r101 = this.keyCache.containsKey(r100);     // Catch: Throwable -> L9
    L8:
        this.readLock.unlock();
    L9:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.readLock.unlock();
        throw th;
    }

    public boolean isValidDir(File r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.exists() == true) goto L6;
        return false;
    L6:
        if (r100.isDirectory() == true) goto L8;
        return false;
    L8:
        if (r100.canRead() == true) goto L10;
        return false;
    L10:
        if (r100.canWrite() == false) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean isValidKeys(String[] r100) {
        if (r100 != null) goto L5;
    L17:
        return false;
    L5:
        if (r100.length != 4) goto L7;
    L9:
        int r101 = r100.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L15;
        if (r100[r102] == null) goto L13;
        r102 = r102 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    L7:
        if (r100.length == 5) goto L9;
        goto L9
    }

    public void removeProtectKey(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        TTVideoEngineLog.i(TAG, String.format("start remove protect key:%s", new Object[]{r100}));
        this.protectKeyManager.removeProtectKey(r100);
        TTVideoEngineLog.d(TAG, String.format("end remove protect key:%s", new Object[]{r100}));
        return;
    }

    public void setMaxSize(long r100) {
        this.maxSize = r100;
    }

    private String[] extractKeys(File r100) {
        String r101 = r100.getName();
        if (r101 != null) goto L7;
        return null;
    L7:
        return extractKeys(r101);
    }

    public void addCacheInfo(String r100, String r110) {
        if (this.writeLock.tryLock() == true) goto L23;
        return;
    L23:
        String[] r101 = extractKeys(r100);     // Catch: Throwable -> L14
        if (isValidKeys(r101) == false) goto L16;
        String r102 = String.format("%s_%s", new Object[]{r101[0], r101[1]});     // Catch: Throwable -> L14
        String r103 = String.format("%s_%s_%s_%s", new Object[]{r101[0], r101[1], r101[2], r101[3]});     // Catch: Throwable -> L14
        if (r101.length != 5) goto L9;
        String r104 = r101[4];     // Catch: Throwable -> L14
    L10:
        VideoCacheInfo r105 = new VideoCacheInfo(r110, r103, r103, r104);     // Catch: Throwable -> L14
        if (this.keyCache.containsKey(r102) == true) goto L16;
        this.keyCache.put(r102, r105);     // Catch: Throwable -> L14
        goto L16
    L9:
        r104 = null;
    L16:
        this.writeLock.unlock();
        return;
    L14:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.writeLock.unlock();
        throw th;
    }

    public static boolean checkCacheFileIntegrity(String r100, String r101, long r110) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
    L60:
        return false;
    L5:
        if (r102.isFile() == false) goto L60;
        if (r102.length() >= r110) goto L10;
        return false;
    L10:
        int r103 = 10240;
        if (r110 >= 10240) goto L13;
        r103 = (int) r110;
    L13:
        PolarisFileInputStreamWrapper r104 = null;
        MessageDigest r105 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L44 Exception -> L46
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L44 Exception -> L46
        byte[] r107 = new byte[r103];     // Catch: Throwable -> L40 Exception -> L42
        boolean r108 = false;
    L16:
        if (r108 == true) goto L25;
        if (r110 >= r103) goto L20;
        int r109 = (int) r110;     // Catch: Throwable -> L40 Exception -> L42
    L21:
        int r111 = r106.read(r107, 0, r109);     // Catch: Throwable -> L40 Exception -> L42
        r105.update(r107, 0, r111);     // Catch: Throwable -> L40 Exception -> L42
        long r112 = r111;
        if (r110 <= r112) goto L23;
        r110 = r110 - r112;     // Catch: Throwable -> L40 Exception -> L42
        goto L16
    L23:
        r108 = true;
        goto L16
    L20:
        r109 = r103;
        goto L21
    L25:
        byte[] r113 = r105.digest();     // Catch: Throwable -> L40 Exception -> L42
        StringBuilder r114 = new StringBuilder("");     // Catch: Throwable -> L40 Exception -> L42
        int r115 = r113.length;     // Catch: Throwable -> L40 Exception -> L42
        int r116 = 0;
    L26:
        if (r116 >= r115) goto L31;
        String r117 = Integer.toHexString(r113[r116] & UByte.MAX_VALUE);     // Catch: Throwable -> L40 Exception -> L42
        if (r117.length() >= 2) goto L30;
        r114.append(0);     // Catch: Throwable -> L40 Exception -> L42
    L30:
        r114.append(r117);     // Catch: Throwable -> L40 Exception -> L42
        r116 = r116 + 1;     // Catch: Throwable -> L40 Exception -> L42
        goto L26
    L31:
        String r118 = r114.toString();     // Catch: Throwable -> L40 Exception -> L42
        r106.close();     // Catch: Throwable -> L34
    L36:
        if (r118 != null) goto L38;
        return false;
    L38:
        return r118.equals(r101);
    L34:
        th = move-exception;
        TTVideoEngineLog.d(th);
        goto L36
    L42:
        e = e;
        r104 = r106;
    L47:
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L44
        if (r104 != null) goto L63;
    L53:
        return false;
    L63:
        r104.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        TTVideoEngineLog.d(th);
    L40:
        th = th;
        r104 = r106;
    L54:
        if (r104 != null) goto L61;
    L59:
        throw th;
    L61:
        r104.close();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        TTVideoEngineLog.d(th);
    L46:
        e = e;
    L44:
        th = th;
        goto L54
    }

    public boolean checkMD5(String r110, String r111, long r112) {
        if (r110 == null) goto L49;
        if (r111 == null) goto L49;
        long r100 = 0;
        if (r112 <= 0) goto L49;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r110);
        if (r101.exists() == true) goto L11;
    L48:
        TTVideoEngineLog.e(TAG, String.format("file not exist or filesize not engough:%s length:%d filesize:%d", new Object[]{r110, Long.valueOf(r101.length()), Long.valueOf(r112)}));
        goto L49
    L11:
        if (r101.length() < r112) goto L48;
        byte[] r102 = new byte[16384];
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Exception -> L45
        MessageDigest r104 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L34
    L16:
        long r113 = r112 - r100;     // Catch: Throwable -> L34
        if (r113 <= 16384) goto L19;
        r113 = 16384;
    L19:
        int r114 = (int) r113;     // Catch: Throwable -> L34
        if (r114 == 0) goto L25;
        int r115 = r103.read(r102, 0, r114);     // Catch: Throwable -> L34
        if (r115 < 0) goto L24;
        r100 = r100 + ((long) r115);
        r104.update(r102, 0, r115);     // Catch: Throwable -> L34
        goto L16
    L24:
        TTVideoEngineLog.e(TAG, String.format("read data err:%s", new Object[]{r110}));     // Catch: Throwable -> L34
    L25:
        r103.close();     // Catch: Exception -> L45
        BigInteger r105 = new BigInteger(1, r104.digest());
        String r106 = String.format("%032x", new Object[]{r105});
        TTVideoEngineLog.i(TAG, String.format("cache md5:%s compute md5:%s", new Object[]{r111, r105.toString(16)}));
        if (r111.equals(r106) == false) goto L30;
        TTVideoEngineLog.i(TAG, "md5 match right");
        return true;
    L30:
        return false;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L41
    L59:
        throw th;     // Catch: Exception -> L45
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return false;
    L49:
        return false;
    }
}
