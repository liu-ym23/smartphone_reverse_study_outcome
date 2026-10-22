package com.ss.android.socialbase.downloader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadUtils {
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static volatile boolean ENABLE_APP_DOWNLOADER = false;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    private static final char[] HEX_CHARS = null;
    public static final int MULTI_PROCESS_DB_MODE = 2;
    public static final int MULTI_PROCESS_NORMAL_DB = 4;
    public static final int MULTI_PROCESS_NO_DB_MODE = 1;
    public static final int MULTI_PROCESS_NO_DB_MODE_RESUME_SUPPORTED = 3;
    private static final String TAG = null;
    private static ConnectivityManager connectivityManager;
    private static volatile boolean enableLruCache;
    private static String sCurProcessName;
    private static volatile boolean sEnableDownloadSettingInit;
    private static volatile AtomicInteger sMultiProcessMode;
    private static volatile int sPid;
    private static int sPluginDegradeTimeout;
    private static int sPluginThreadPoolSize;

    public DownloadUtils() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static boolean isChunkedTask(long r100) {
        if (r100 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMd5Valid(int r100) {
        if (r100 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == 2) goto L7;
        return false;
    }

    static {
        TAG = "DownloadUtils";
        ENABLE_APP_DOWNLOADER = true;
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        sCurProcessName = null;
        sMultiProcessMode = new AtomicInteger(-1);
        enableLruCache = false;
        sPid = -1;
        sEnableDownloadSettingInit = true;
    }

    private static String getCurProcessNameByActivityThread() {
        String r100 = null;
        Method r101 = INVOKESTATIC_com_ss_android_socialbase_downloader_utils_DownloadUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L14
        r101.setAccessible(true);     // Catch: Throwable -> L14
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Throwable -> L14
        if ((r102 instanceof String) == false) goto L21;
        String r103 = (String) r102;     // Catch: Throwable -> L14
    L12:
        th = th;
        r100 = r103;
    L15:
        th.printStackTrace();
        return r100;
    L7:
        if (Logger.debug() == false) goto L22;
        if (TextUtils.isEmpty(r103) == true) goto L22;
        Logger.globalDebug(TAG, "getCurProcessNameByActivityThread", "ProcessName: " + r103);     // Catch: Throwable -> L12
    L22:
        return r103;
    L21:
        return null;
    L14:
        th = th;
        goto L15
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r100 = Application.getProcessName();     // Catch: Exception -> L10
        if (Logger.debug() == true) goto L7;
    L9:
        return r100;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        Logger.globalDebug(TAG, "getCurProcessNameByApplication", "ProcessName: " + r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L17
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L17
        if (r102 <= 0) goto L9;
        r101.append((char) r102);     // Catch: Throwable -> L17
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "getCurProcessNameFromProc", "ProcessName: " + r101.toString());     // Catch: Throwable -> L17
    L11:
        String r103 = r101.toString();     // Catch: Throwable -> L17
        safeClose(new Closeable[]{r100});
        return r103;
    L15:
        safeClose(new Closeable[]{r100});
        return null;
    L14:
        r100 = null;
        goto L15
    }

    public static int getPid() {
        if (sPid != (-1)) goto L6;
        sPid = Process.myPid();
    L6:
        return sPid;
    }

    public static boolean isMultiProcessDBMode() {
        if (sMultiProcessMode.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMultiProcessNoDBMode() {
        if (sMultiProcessMode.get() != 1) goto L5;
        return true;
    L5:
        if (isMultiProcessNoDBModeResumeSupported() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isMultiProcessNoDBModeResumeSupported() {
        if (sMultiProcessMode.get() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMultiProcessNormalDBMode() {
        if (sMultiProcessMode.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNoWifiAndInNet() {
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (isWifi(r100) == true) goto L9;
        if (isNetworkConnected(r100) == false) goto L9;
        return true;
    }

    public static boolean optimizeMultiProcess() {
        sMultiProcessMode.compareAndSet(-1, 0);
        if (sMultiProcessMode.get() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static String getDownloadPath() {
        return DownloadDirUtils.getDownloadPath();
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getPluginDegradeTimeout() {
        return sPluginDegradeTimeout;
    }

    public static int getPluginThreadPoolSize() {
        return sPluginThreadPoolSize;
    }

    public static boolean isEnableDownloadSettingInit() {
        return sEnableDownloadSettingInit;
    }

    public static boolean isEnableLruCache() {
        return enableLruCache;
    }

    public static boolean cacheExpired(DownloadInfo r100) {
        return cacheExpiredWithHttp(r100, false);
    }

    public static void clearAntiHijackDir(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        DownloadSetting r101 = DownloadSetting.obtain(r100.getId());
        JSONObject r102 = r101.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (r102 == null) goto L24;
        String r103 = r102.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (TextUtils.isEmpty(r103) == true) goto L9;
        deleteFile(r100.getSavePath(), r103);
    L9:
        String r104 = r100.getTitle();
        if (TextUtils.isEmpty(r104) == false) goto L12;
        r104 = r100.getName();
    L12:
        String r105 = getRedirectSavePath(r104, r101);
        String r106 = r100.getSavePath();
        if (TextUtils.isEmpty(r105) == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r106) == true) goto L30;
        File r107 = new PolarisFileWrapper(r105);
        File r108 = new PolarisFileWrapper(r106);
    L17:
        if (r107 == null) goto L31;
        if (r108 == null) goto L32;
        if (r108.isDirectory() == false) goto L33;
        if (TextUtils.equals(r107.getName(), r108.getName()) == false) goto L34;
        deleteDirIfEmpty(r108.getPath());
        r107 = r107.getParentFile();
        r108 = r108.getParentFile();
        goto L17
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static void deleteAllDownloadFiles(DownloadInfo r100) {
        deleteAllDownloadFiles(r100, true);
    }

    private static boolean deleteDirIfEmpty(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "deleteDirIfEmpty", "Thread:" + ThreadMethodProxy.currentThread());
    L6:
        if (DownloadFileUtils.getTypeByUri(r100) == 1) goto L8;
    L21:
        return false;
    L8:
        if (DownloadDirUtils.isSavePathSecurity(r100) == false) goto L21;
        if (TextUtils.isEmpty(r100) == true) goto L21;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.isDirectory() == false) goto L21;
        if (r101.delete() == false) goto L17;
        return true;
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "deleteDirIfEmpty", "Delete Failed");
    L19:
        return false;
    }

    public static void ensureDirExists(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ensureDirExists(new PolarisFileWrapper(r100));
    }

    public static long getAvailableSpaceBytes(String r100) throws BaseException {
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
            boolean r0 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.isMediaUri(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            if (r0 == 0) goto L17
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            android.net.Uri r2 = com.bytedance.mt.protector.impl.UriProtector.parse(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            java.lang.String r2 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.getFilePathFromUri(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            java.lang.String r2 = r0.getParent()     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
        L17:
            android.os.StatFs r0 = new android.os.StatFs     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            long r0 = r0.getAvailableBytes()     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            return r0
        L21:
            r2 = move-exception
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1052(0x41c, float:1.474E-42)
            r0.<init>(r1, r2)
            throw r0
        L2a:
            r2 = move-exception
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1050(0x41a, float:1.471E-42)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(java.lang.String):long");
    }

    public static ConnectivityManager getConnectivityManager(Context r100) {
        ConnectivityManager r101 = connectivityManager;
        if (r101 != null) goto L6;
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");
        connectivityManager = r102;
        return r102;
    L6:
        return r101;
    }

    public static long getContentLength(IDownloadHeadHttpConnection r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        String r101 = getRespHeadFieldIgnoreCase(r100, "Content-Length");
        if (TextUtils.isEmpty(r101) == true) goto L13;
        return CastLongProtector.parseLong(r101);
    L14:
        return -1;
    L13:
        return parseContentLengthFromContentRange(r100);
    }

    public static String getCurProcessName(Context r100) {
        String r101 = sCurProcessName;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        String r102 = getCurProcessNameByApplication();
        sCurProcessName = r102;
        if (TextUtils.isEmpty(r102) == false) goto L8;
        String r103 = getCurProcessNameByActivityThread();
        sCurProcessName = r103;
        if (TextUtils.isEmpty(r103) == false) goto L12;
        String r104 = getCurProcessNameFromProc();
        sCurProcessName = r104;
        if (TextUtils.isEmpty(r104) == false) goto L16;
        String r105 = getCurProcessNameByActivityManager(r100);
        sCurProcessName = r105;
        return r105;
    L16:
        return sCurProcessName;
    L12:
        return sCurProcessName;
    L8:
        return sCurProcessName;
    }

    private static String getCurProcessNameByActivityManager(Context r100) {
        if (r100 != null) goto L20;
        return null;
    L20:
        int r101 = Process.myPid();     // Catch: Exception -> L17
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L17
        if (r102 == null) goto L19;
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.getRunningAppProcesses().iterator();     // Catch: Exception -> L17
    L9:
        if (r103.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L17
        if (r104.pid != r101) goto L9;
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "getCurProcessNameByActivityManager", "ProcessName: " + r104.processName);     // Catch: Exception -> L17
    L15:
        return r104.processName;
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static String getEncodedStr(String r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        char r104 = r100.charAt(r103);
        if (r104 > 31) goto L7;
    L10:
        r101.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r104)}));
    L11:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 >= 127) goto L10;
        r101.append(r104);
        goto L11
    L13:
        return r101.toString();
    }

    public static String getLoggerTag(String r100) {
        return Logger.downloaderTag(r100);
    }

    public static String getMd5StatusMsg(int r100) {
        String r101 = "ttmd5 check code = " + r100 + ", ";
        if (r100 == 99) goto L14;
        switch(r100) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L22;
        };
    L22:
        return r101;
    L15:
        return r101 + "get file md5 error";
    L16:
        return r101 + "file not exist";
    L17:
        return r101 + "ttmd5 tag parser error";
    L18:
        return r101 + "ttmd5 version not support";
    L19:
        return r101 + "md5 empty";
    L20:
        return r101 + "md5 not match";
    L21:
        return r101 + "md5 match";
    L14:
        return r101 + IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    }

    public static int getNetworkType(Context r100) {
        if (r100 != null) goto L21;
        return 0;
    L21:
        ConnectivityManager r101 = getConnectivityManager(r100);     // Catch: Exception -> L20
        if (r101 != null) goto L8;
        return 0;
    L8:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r102 == null) goto L19;
        if (r102.isAvailable() == false) goto L19;
        if (1 != r102.getType()) goto L17;
        return 1;
    L17:
        return 2;
    L19:
        return 0;
    }

    public static long getReportableSpaceMB(long r100) {
        long r101 = 50;
        return ((r100 / 1048576) / r101) * r101;
    }

    public static String getTempFileName(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return String.format("%s.tp", new Object[]{r100});
    }

    public static String getThrowableMsg(Throwable r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        return r100.toString();
    L7:
        th = move-exception;
        th.printStackTrace();
        return "throwable getMsg error";
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.size() == 0) goto L36;
        Iterator<HttpHeader> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L37;
        HttpHeader r102 = r101.next();
        if (r102 == null) goto L9;
        if (TextUtils.isEmpty(r102.getName()) == true) goto L9;
        if (TextUtils.isEmpty(r102.getValue()) == true) goto L9;
        if (HEADER_TAG_DOWNLOAD_CACHE.equals(r102.getName()) == false) goto L9;
        if (HEADER_TAG_DOWNLOAD_CACHE.equals(r102.getValue()) == false) goto L9;
        return true;
    L37:
        return false;
    L36:
        return false;
    }

    public static String hexToString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L19;
        int r104 = r103 * 2;
        r102[r103] = (byte) (CastIntegerProtector.parseInt(r100.substring(r104, r104 + 2), 16) & 255);     // Catch: Exception -> L11
    L13:
        r103 = r103 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L19:
        return new String(r102, XML.CHARSET_UTF8);
    L16:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static boolean isFileDownloaded(DownloadInfo r100) {
        return isFileDownloaded(r100, r100.isForce(), r100.getMd5());
    }

    public static boolean isInsufficientSpaceError(Throwable r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof BaseException) == false) goto L31;
        BaseException r101 = (BaseException) r100;
        int r102 = r101.getErrorCode();
        if (r102 != 1006) goto L11;
        return true;
    L11:
        if (r102 != 1023) goto L13;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == false) goto L40;
        String r104 = r101.getMessage();
        if (TextUtils.isEmpty(r104) == false) goto L27;
        return false;
    L27:
        if (r104.contains("ENOSPC") == false) goto L39;
        return true;
    L39:
        return false;
    L40:
        return false;
    L13:
        if (r102 == 1039) goto L22;
        if (r102 == 1040) goto L22;
        if (r102 == 1054) goto L22;
        if (r102 == 1064) goto L22;
        r103 = false;
        goto L23
    L31:
        if ((r100 instanceof IOException) == false) goto L41;
        String r105 = getThrowableMsg(r100);
        if (TextUtils.isEmpty(r105) == false) goto L35;
        return false;
    L35:
        if (r105.contains("ENOSPC") == false) goto L43;
        return true;
    L43:
        return false;
    L41:
        return false;
    }

    public static boolean isNetworkConnected(Context r100) {
        NetworkInfo r101 = getConnectivityManager(r100).getActiveNetworkInfo();     // Catch: Exception -> L8
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.isConnected();
    L8:
        return false;
    }

    public static boolean isNetworkError(Throwable r100) {
        if (r100 != null) goto L5;
    L60:
        return false;
    L5:
        if ((r100 instanceof BaseException) == false) goto L60;
        int r101 = ((BaseException) r100).getErrorCode();
        if (r101 < 2000) goto L13;
        if (r101 >= 3000) goto L13;
        return true;
    L13:
        if (r101 != 1075) goto L15;
    L59:
        return true;
    L15:
        if (r101 == 1078) goto L59;
        if (r101 == 1079) goto L59;
        if (r101 == 1055) goto L59;
        if (r101 == 1023) goto L59;
        if (r101 == 1041) goto L59;
        if (r101 == 1022) goto L59;
        if (r101 == 1048) goto L59;
        if (r101 == 1056) goto L59;
        if (r101 == 1057) goto L59;
        if (r101 == 1058) goto L59;
        if (r101 == 1059) goto L59;
        if (r101 == 1060) goto L59;
        if (r101 == 1061) goto L59;
        if (r101 == 1067) goto L59;
        if (r101 == 1049) goto L59;
        if (r101 == 1047) goto L59;
        if (r101 == 1051) goto L59;
        if (r101 == 1004) goto L59;
        if (r101 == 1011) goto L59;
        if (r101 == 1002) goto L59;
        if (r101 == 1013) goto L59;
        return false;
    }

    public static boolean isProcessNameSame(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return true;
    L5:
        String r101 = getCurProcessName(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.equals(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isResponseCode304Error(Throwable r100) {
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(r100) != 304) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isWifi(Context r100) {
        NetworkInfo r101 = getConnectivityManager(r100).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> jsonStringTolist(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L19;
        return null;
    L19:
        JSONArray r101 = new JSONArray(r100);     // Catch: Exception -> L16
        if (r101.length() > 0) goto L8;
        return null;
    L8:
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L16
        int r103 = 0;
    L10:
        if (r103 >= r101.length()) goto L15;
        String r104 = r101.optString(r103);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r104) == true) goto L14;
        r102.add(r104);     // Catch: Exception -> L16
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        return r102;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String listToJsonString(List<String> r100) {
        if (r100 != null) goto L5;
    L17:
        return "";
    L5:
        if (r100.isEmpty() == true) goto L17;
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L15
        Iterator<String> r102 = r100.iterator();     // Catch: Exception -> L15
    L9:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r101.put(r103);     // Catch: Exception -> L15
        goto L9
    L13:
        return r101.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String md5Hex(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r101.digest());
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        String r101 = getRespHeadFieldIgnoreCase(r100, "Content-Range");
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return -1;
    L16:
        Matcher r102 = PatternProtector.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(r101);     // Catch: Exception -> L13
        if (r102.find() == false) goto L15;
        return (CastLongProtector.parseLong(r102.group(2)) - CastLongProtector.parseLong(r102.group(1))) + 1;
    L15:
        return -1;
    L13:
        e = move-exception;
        Logger.globalError(TAG, "parseContentLengthFromContentRange", "Exception:" + e);
        goto L15
    }

    public static String parseDevicePostfix(String r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isDigitsOnly(r100) == false) goto L15;
        return String.valueOf(CastLongProtector.valueOf(r100).longValue() % 100);
    L15:
        return "";
    }

    public static String parseTTNetIp(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        int r101 = r100.lastIndexOf(":");
        if (r101 > 0) goto L9;
        return "";
    L9:
        return r100.substring(0, r101);
    }

    public static void safeClose(Cursor... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        Cursor r103 = r100[r102];
        if (r103 == null) goto L13;
        r103.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r102 = r102 + 1;
        goto L5
    }

    public static void setEnableDownloadSettingInit(boolean r100) {
        sEnableDownloadSettingInit = r100;
    }

    public static void setEnableLruCache(boolean r100) {
        enableLruCache = r100;
    }

    public static void setPluginDegradeTimeout(int r100) {
        sPluginDegradeTimeout = r100;
    }

    public static void setPluginThreadPoolSize(int r100) {
        sPluginThreadPoolSize = r100;
    }

    public static String toHexString(byte[] r100) {
        if (r100 == null) goto L6;
        return toHexString(r100, 0, r100.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    private static void ensureDirExists(File r100) {
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
        return;
    }

    public static void safeClose(Closeable... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L13;
        r103.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r102 = r102 + 1;
        goto L5
    }

    public static boolean cacheExpiredWithHttp(DownloadInfo r100, boolean r110) {
        boolean r101 = false;
        if (r100.isDeleteCacheIfCheckFailed() == true) goto L10;
        if (TextUtils.isEmpty(r100.getLastModified()) == false) goto L10;
        if (Logger.debugScene(r100) == false) goto L18;
        Logger.taskDebug(TAG, r100, "cacheExpiredWithHttp", "Modify is empty, so just return cache");
    L18:
        if (Logger.debugScene(r100) == false) goto L20;
        Logger.taskDebug(TAG, r100, "cacheExpiredWithHttp", "Name=" + r100.getName() + " expired=" + r101);
    L20:
        return r101;
    L10:
        if (Logger.debugScene(r100) == false) goto L13;
        Logger.taskDebug(TAG, r100, "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + r100.getCacheExpiredTime());
    L13:
        if (System.currentTimeMillis() <= r100.getCacheExpiredTime()) goto L15;
    L14:
        r101 = true;
        goto L18
    L15:
        if (r110 == false) goto L18;
        goto L14
    }

    public static boolean checkFileLength(DownloadInfo r100, DownloadFile r101) {
        if (r100.getTotalBytes() > 0) goto L5;
        return true;
    L5:
        if (r101.length() >= r100.getTotalBytes()) goto L10;
        return false;
    L10:
        return true;
    }

    public static int checkMd5Status(DownloadFile r100, String r101) {
        if (r100.isTypeFile() == true) goto L5;
        return TTMd5.checkMd5(r101, r100.getFile(), new DownloadFileRandomAccess(r100.obtainInputStream()));
    L8:
        th = move-exception;
        th.printStackTrace();
        return 5;
    L5:
        return TTMd5.checkMd5(r101, r100.getFile());
    }

    public static boolean checkMd5Valid(DownloadFile r100, String r101) {
        return isMd5Valid(checkMd5Status(r100, r101));
    }

    public static void deleteAllDownloadFiles(DownloadInfo r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isForce() == true) goto L7;
    L9:
        if (r101 == true) goto L26;
    L11:
        deleteFile(r100.getTempPath(), r100.getTempName());     // Catch: Throwable -> L23
        if (r100.isSavePathRedirected() == false) goto L14;
        clearAntiHijackDir(r100);     // Catch: Throwable -> L23
    L14:
        if (r101 == false) goto L28;
        String r102 = md5Hex(r100.getUrl());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r100.getSavePath()) == false) goto L20;
        return;
    L20:
        if (r100.getSavePath().contains(r102) == false) goto L31;
        deleteDirIfEmpty(r100.getSavePath());     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        return;
    L28:
        return;
    L26:
        deleteFile(r100.getSavePath(), r100.getName());     // Catch: Throwable -> L23
        goto L11
    L7:
        if (DownloadDirUtils.isSavePathSecurity(r100.getSavePath()) == true) goto L9;
        r101 = false;
        goto L9
    }

    public static void deleteFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        DownloadFile r102 = new DownloadFile(r100, r101, false, true);
        if (r102.exists() == true) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "deleteFile", "Path: " + r102.getAbsolutePath());
    L11:
        r102.delete();
        return;
    }

    public static String generateDistinctDirectory(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r102 = md5Hex(r101);
        if (TextUtils.isEmpty(r102) == false) goto L7;
        return r100;
    L7:
        if (r100.contains(r102) == false) goto L9;
        return r100;
    L9:
        return new PolarisFileWrapper(r100, r102).getAbsolutePath();
    L10:
        return r100;
    }

    public static boolean getBoolean(Object r100, boolean r101) {
        return ((Boolean) r100).booleanValue();
    L4:
        return r101;
    }

    public static String getErrorMsgWithTagPrefix(Throwable r100, String r101) {
        if (r101 != null) goto L6;
        return getThrowableMsg(r100);
    L6:
        return r101 + "-" + getThrowableMsg(r100);
    }

    public static int getInt(Object r100, int r101) {
        return ((Integer) r100).intValue();
    L4:
        return r101;
    }

    public static String getRedirectSavePath(String r100, DownloadSetting r101) {
        if (r101 == null) goto L22;
        JSONObject r102 = r101.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (r102 == null) goto L22;
        String r103 = r102.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (TextUtils.isEmpty(r103) == true) goto L11;
        if (r103.startsWith(HTTP.URL_DEFAULT) == false) goto L11;
        r103 = r103.substring(1);
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        return r103;
    L13:
        if (r103.contains("%s") == true) goto L24;
        String r104 = r103 + r100;
    L15:
        r103 = r104;
    L20:
        if (r103.length() > 255) goto L28;
        return r103;
    L28:
        return r103.substring(r103.length() - 255);
    L24:
        r104 = String.format(r103, new Object[]{r100});     // Catch: Throwable -> L18
    L22:
        return "";
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        String r102 = r100.getResponseHeaderField(r101);
        if (TextUtils.isEmpty(r102) == false) goto L10;
        r102 = r100.getResponseHeaderField(r101.toLowerCase());
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return r102;
    L12:
        return r100.getResponseHeaderField(r101.toUpperCase());
    L16:
        return null;
    }

    public static String getString(Object r100, String r101) {
        return (String) r100;
    L4:
        return r101;
    }

    public static String getTargetFilePath(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (DownloadFileUtils.isMediaUri(r100) == false) goto L13;
        if (DownloadFileUtils.checkUriInsert(r100) == true) goto L13;
        return null;
    L13:
        return new DownloadFile(r100, r101).getPath();
    }

    public static String getTempFileSavePath(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return r100;
    L11:
        return r101;
    }

    public static boolean isFileExist(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (DownloadFileUtils.isMediaUri(r100) == false) goto L13;
        if (DownloadFileUtils.checkUriInsert(r100) == true) goto L13;
        return false;
    L13:
        return new DownloadFile(r100, r101).exists();
    }

    public static boolean isWaitWifiAndInNet(BaseException r100, DownloadInfo r101) {
        if (r101 != null) goto L4;
    L8:
        return false;
    L4:
        if (r101.isOnlyWifi() == false) goto L8;
        if (isNetworkConnected(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == false) goto L8;
        return true;
    }

    public static String readStreamToString(InputStream r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        if (r100 == null) goto L26;
        if (r101 <= 0) goto L26;
        BufferedReader r103 = null;
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L18
    L30:
        String r105 = r104.readLine();     // Catch: Throwable -> L16
        if (r105 == null) goto L15;
        r102.append(r105);     // Catch: Throwable -> L16
        if (r102.length() <= r101) goto L30;
        String r106 = r102.substring(0, r101);     // Catch: Throwable -> L16
        safeClose(new Closeable[]{r104});
        safeClose(new Closeable[]{r100});
        return r106;
    L15:
        safeClose(new Closeable[]{r104});
        safeClose(new Closeable[]{r100});
    L22:
        return r102.toString();
    L16:
        th = th;
        r103 = r104;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L23
        safeClose(new Closeable[]{r103});
        safeClose(new Closeable[]{r100});
    L23:
        th = move-exception;
        safeClose(new Closeable[]{r103});
        safeClose(new Closeable[]{r100});
        throw th;
    L18:
        th = th;
    L26:
        safeClose(new Closeable[]{r100});
        return r102.toString();
    }

    private static void securityDeleteFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        DownloadFile r102 = new DownloadFile(r100, r101, true, true);
        if (r102.exists() == true) goto L10;
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "deleteFile", "Path: " + r102.getAbsolutePath());
    L12:
        r102.delete();
        return;
    }

    public static int checkMd5Status(File r100, String r101) {
        return TTMd5.checkMd5(r101, r100);
    }

    public static boolean checkMd5Valid(File r100, String r101) {
        return isMd5Valid(TTMd5.checkMd5(r101, r100));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_downloader_utils_DownloadUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static int checkMd5Status(String r100, String r101, String r102) {
        return checkMd5Status(new DownloadFile(r100, r101), r102);
    }

    public static boolean checkMd5Valid(String r100, String r101, String r102) {
        return isMd5Valid(checkMd5Status(new DownloadFile(r100, r101), r102));
    }

    public static void clearDownloadFile(String r100, String r101, String r102) {
        String r103 = String.format("%s.tp", new Object[]{r102});
        securityDeleteFile(r100, r102);
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        securityDeleteFile(r100, r103);
    }

    public static String getTempFilePath(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L8:
        return null;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        String r103 = getTargetFilePath(r101, r102);
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L17;
        return null;
    L17:
        return String.format("%s.tp", new Object[]{r103});
    L12:
        r103 = getTargetFilePath(r100, r102);
        goto L14
    }

    public static boolean isDownloadSuccessAndFileNotExist(int r100, String r101, String r102) {
        if (r100 == (-3)) goto L5;
        return false;
    L5:
        if (isFileExist(r101, r102) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isFileDownloaded(DownloadInfo r100, boolean r101, String r102) {
        if (r101 == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getSavePath()) == true) goto L19;
        if (TextUtils.isEmpty(r100.getName()) == true) goto L19;
        DownloadFile r103 = new DownloadFile(r100.getSavePath(), r100.getName());     // Catch: OutOfMemoryError -> L17
        if (DownloadFileUtils.existsAndNotEmpty(r103) == false) goto L19;
        if (checkFileLength(r100, r103) == false) goto L19;
        if (checkMd5Valid(r103, r102) == false) goto L19;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static void setMultiProcessMode(int r100, String r101, boolean r102) {
        if (r102 == false) goto L9;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (r101.endsWith(":downloader") == false) goto L9;
        return;
    L9:
        if (sMultiProcessMode.compareAndSet(-1, r100) == true) goto L11;
        return;
    L11:
        if (isMultiProcessNormalDBMode() == false) goto L15;
        enableLruCache = true;
        return;
    }

    public static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L14;
        if (r110 < 0) goto L12;
        if ((r110 + r111) > r100.length) goto L12;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r111) goto L10;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return new String(r102, 0, r101);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }

    public static boolean isFileDownloaded(String r100, String r101, boolean r102) {
        return isFileDownloaded(r100, r101, null, r102);
    }

    public static boolean isFileDownloaded(String r100, String r101, String r102, boolean r103) {
        if (r103 == false) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        if (TextUtils.isEmpty(r101) == true) goto L17;
        DownloadFile r104 = new DownloadFile(r100, r101);     // Catch: OutOfMemoryError -> L15
        if (DownloadFileUtils.existsAndNotEmpty(r104) == false) goto L17;
        if (checkMd5Valid(r104, r102) == false) goto L17;
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
