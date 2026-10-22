package com.ttnetuploader.uploader.api;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class ULLog {
    private static final boolean DEBUG = false;
    private static final String KEY_GLOBAL_REPORT = "GlobalReport";
    private static final String KEY_TASK_REPORT = "TaskReport";
    private static final String TAG = "UploaderLogger";
    private static final String TAG_GLOBAL_FORMAT = "[MNetUploader|Global|%s]";
    private static final String TAG_TASK_FORMAT = "[MNetUploader|%d|%s]";
    private static final String UPLOAD_TAG_PREFIX = "MNetUploader-";
    private static Object mAlogLock;
    private static Set mAlogTaskSceneList;
    private static boolean mEnableALogWritter;
    private static boolean mEnableGlobalReport;
    private static int mLevel;
    private static ILogReport mLogReport;
    private static Set mTaskReportSceneList;
    private static ILogWritter sLogWritter;

    /* JADX INFO: renamed from: com.ttnetuploader.uploader.api.ULLog$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class ALogHolder {
        private static Method mAlogMethod;

        private ALogHolder() {
        }

        public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private static Method getAlogMethod() {
            return INVOKESTATIC_com_ttnetuploader_uploader_api_ULLog$ALogHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog").getMethod("e", new Class[]{String.class, String.class});
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }

        static {
            mAlogMethod = getAlogMethod();
        }

        public static /* synthetic */ Method access$000() {
            return mAlogMethod;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_ttnetuploader_uploader_api_ULLog$ALogHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
            Class r104 = access$001(r100);     // Catch: Throwable -> L17
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
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class AlogHandler extends ILogWritter {
        private AlogHandler() {
        }

        public /* synthetic */ AlogHandler(AnonymousClass1 r100) {
            this();
        }

        @Override // com.ttnetuploader.uploader.api.ULLog.ILogWritter
        public void logD(String r100, String r101) {
            ULLog.alogE(r100, r101);
        }

        @Override // com.ttnetuploader.uploader.api.ULLog.ILogWritter
        public void logE(String r100, String r101) {
            ULLog.alogE(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static abstract class ILogReport {
        public ILogReport() {
        }

        public void monitorEvent(String r100, String r101) {
        }
    }

    public static abstract class ILogWritter {
        public ILogWritter() {
        }

        public void logD(String r100, String r101) {
        }

        public void logE(String r100, String r101) {
        }

        public void logE(String r100, String r101, Throwable r102) {
        }

        public void logI(String r100, String r101) {
        }

        public void logI(String r100, String r101, Throwable r102) {
        }

        public void logK(String r100, String r101) {
        }

        public void logV(String r100, String r101) {
        }

        public void logW(String r100, String r101) {
        }

        public void logW(String r100, String r101, Throwable r102) {
        }
    }

    public ULLog() {
    }

    public static boolean alog() {
        return false;
    }

    private static boolean isLoggerParamsValid(String r100, String r101, String r102) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        return true;
    L6:
        return false;
    }

    static {
        mAlogLock = new Object();
        mEnableALogWritter = false;
        mLevel = 6;
        mTaskReportSceneList = new CopyOnWriteArraySet();
        mAlogTaskSceneList = new CopyOnWriteArraySet();
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static void d(String r100) {
        d(TAG, r100);
    }

    public static boolean debugScene(String r100) {
        if (mAlogTaskSceneList.isEmpty() == true) goto L13;
        if (mAlogTaskSceneList.contains(r100) == false) goto L13;
        if (mLevel <= 4) goto L17;
        return false;
    L17:
        return true;
    L13:
        if (mLevel <= 3) goto L18;
        return false;
    L18:
        return true;
    }

    public static void e(String r100) {
        e(TAG, r100);
    }

    private static String getSimpleClassName(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 >= 0) goto L6;
        return r100;
    L6:
        return r100.substring(r101 + 1);
    }

    public static void i(String r100) {
        i(TAG, r100);
    }

    public static void k(String r100) {
        k(TAG, r100);
    }

    public static void registerLogHandler(ILogWritter r100) {
        Object r101 = mAlogLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        sLogWritter = r100;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public static void registerLogReport(ILogReport r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        mLogReport = r100;
    }

    public static void setLogLevel(int r100) {
        Object r101 = mAlogLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        mLevel = r100;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public static String uploaderTag(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return TAG;
    L5:
        return UPLOAD_TAG_PREFIX + r100;
    }

    public static void v(String r100) {
        v(TAG, r100);
    }

    public static void w(String r100) {
        w(TAG, r100);
    }

    public static void alogE(String r100, String r101) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ALogHolder.access$000() == null) goto L11;
        ALogHolder.access$000().invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L6
        return;
    }

    public static void d(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L7;
        uploaderTag(r100);
    L7:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L11;
        r102.logD(uploaderTag(r100), r101);
        return;
    }

    public static void e(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L7;
        uploaderTag(r100);
    L7:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L11;
        r102.logE(uploaderTag(r100), r101);
        return;
    }

    public static void i(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L7;
        uploaderTag(r100);
    L7:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L11;
        r102.logI(uploaderTag(r100), r101);
        return;
    }

    public static void k(String r100, String r101) {
        if (mLevel > 3) goto L5;
        uploaderTag(r100);
    L5:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L9;
        r102.logK(uploaderTag(r100), r101);
        return;
    }

    public static void st(String r100, int r101) {
    L4:
        e = move-exception;
        StackTraceElement[] r102 = e.getStackTrace();
        StringBuilder r103 = new StringBuilder();
        int r104 = 1;
    L7:
        if (r104 >= Math.min(r101, r102.length)) goto L11;
        if (r104 <= 1) goto L10;
        r103.append("\n");
    L10:
        r103.append(getSimpleClassName(r102[r104].getClassName()));
        r103.append(".");
        r103.append(r102[r104].getMethodName());
        r104 = r104 + 1;
        goto L7
    L11:
        v(uploaderTag(r100), r103.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void v(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L8;
        r102.logV(uploaderTag(r100), r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L7;
        uploaderTag(r100);
    L7:
        ILogWritter r102 = sLogWritter;
        if (r102 == null) goto L11;
        r102.logW(uploaderTag(r100), r101);
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L8;
        uploaderTag(r100);
    L8:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L12;
        r103.logD(uploaderTag(r100), r101 + r102);
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L8;
        uploaderTag(r100);
    L8:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L12;
        r103.logE(uploaderTag(r100), r101, r102);
        return;
    }

    private static void globalAlog(String r100, String r101, String r102) {
        if (isLoggerParamsValid(r100, r101, r102) == true) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L13;
        String r103 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r100});
        String r104 = "[TTNet-Uploader]" + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102;
        ILogWritter r105 = sLogWritter;
        if (r105 == null) goto L12;
        r105.logE(r103, r104);
        return;
    L12:
        return;
    }

    public static void globalDebug(String r100, String r101, String r102) {
        if (isLoggerParamsValid(r100, r101, r102) == true) goto L6;
        return;
    L6:
        if (alog() == false) goto L10;
        globalAlog(r100, r101, r102);
        return;
    L10:
        if (mLevel <= 3) goto L12;
        return;
    L12:
        String r103 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r100});
        String r104 = "[TTNet-Uploader]" + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102;
        ILogWritter r105 = sLogWritter;
        if (r105 == null) goto L16;
        r105.logD(r103, r104);
        return;
    }

    public static void globalError(String r100, String r101, String r102) {
        if (isLoggerParamsValid(r100, r101, r102) == true) goto L5;
        return;
    L5:
        globalReport(r100, r101, r102);
        if (alog() == false) goto L10;
        globalAlog(r100, r101, r102);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r103 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r100});
        String r104 = "[TTNet-Uploader]" + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102;
        ILogWritter r105 = sLogWritter;
        if (r105 == null) goto L16;
        r105.logE(r103, r104);
        return;
    }

    private static void globalReport(String r100, String r101, String r102) {
        if (mEnableGlobalReport == true) goto L5;
        return;
    L5:
        if (isLoggerParamsValid(r100, r101, r102) == false) goto L13;
        ILogReport r103 = mLogReport;
        if (r103 == null) goto L12;
        r103.monitorEvent(KEY_GLOBAL_REPORT, "[TTNet-Uploader]" + r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102);
        return;
    L12:
        return;
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L8;
        uploaderTag(r100);
    L8:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L12;
        r103.logI(uploaderTag(r100), r101, r102);
        return;
    }

    public static void v(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
        return;
    L5:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L9;
        r103.logV(uploaderTag(r100), r101 + r102);
        return;
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L8;
        uploaderTag(r100);
    L8:
        ILogWritter r103 = sLogWritter;
        if (r103 == null) goto L12;
        r103.logW(uploaderTag(r100), r101, r102);
        return;
    }

    public static void setLogReportParams(int r100, boolean r101, List<String> r102, List<String> r103) {
        Object r104 = mAlogLock;
        monitor-enter(r104);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r104);     // Catch: Throwable -> L25
        return;
    L8:
        mEnableALogWritter = true;     // Catch: Throwable -> L25
        mLevel = r100;     // Catch: Throwable -> L25
        sLogWritter = new AlogHandler(null);     // Catch: Throwable -> L25
        mEnableGlobalReport = r101;     // Catch: Throwable -> L25
        if (r102 != null) goto L11;
    L16:
        if (r103 != null) goto L18;
    L23:
        monitor-exit(r104);     // Catch: Throwable -> L25
        return;
    L18:
        if (r103.isEmpty() == true) goto L23;
        Iterator<String> r105 = r103.iterator();     // Catch: Throwable -> L25
    L21:
        if (r105.hasNext() == false) goto L23;
        String r106 = r105.next();     // Catch: Throwable -> L25
        mAlogTaskSceneList.add(r106);     // Catch: Throwable -> L25
        goto L21
    L11:
        if (r102.isEmpty() == true) goto L16;
        Iterator<String> r107 = r102.iterator();     // Catch: Throwable -> L25
    L14:
        if (r107.hasNext() == false) goto L16;
        String r108 = r107.next();     // Catch: Throwable -> L25
        mTaskReportSceneList.add(r108);     // Catch: Throwable -> L25
        goto L14
    }

    private static void taskAlog(String r100, long r101, String r102, String r103) {
        if (isLoggerParamsValid(r100, r102, r103) == true) goto L5;
        return;
    L5:
        String r104 = String.format(TAG_TASK_FORMAT, new Object[]{Long.valueOf(r101), r100});
        String r105 = "[TTNet-Uploader]" + r102 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103;
        ILogWritter r106 = sLogWritter;
        if (r106 == null) goto L9;
        r106.logE(r104, r105);
        return;
    }

    public static void taskDebug(String r100, long r101, String r110, String r111) {
        taskDebug(r100, r101, null, r110, r111, false);
    }

    public static void taskError(String r100, int r101, String r102, String r103) {
        if (isLoggerParamsValid(r100, r102, r103) == true) goto L5;
        return;
    L5:
        globalReport(r100, r102, r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103);
        if (alog() == false) goto L10;
        taskAlog(r100, r101, r102, r103);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r104 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r101), r100});
        String r105 = "[TTNet-Uploader]" + r102 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103;
        ILogWritter r106 = sLogWritter;
        if (r106 == null) goto L16;
        r106.logE(r104, r105);
        return;
    }

    private static void taskReport(String r100, long r101, String r102, String r103, String r104) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        if (mTaskReportSceneList.isEmpty() == false) goto L7;
        return;
    L7:
        if (mTaskReportSceneList.contains(r102) == true) goto L9;
        return;
    L9:
        if (isLoggerParamsValid(r100, r103, r104) == false) goto L19;
        ILogReport r105 = mLogReport;
        if (r105 == null) goto L18;
        r105.monitorEvent(KEY_TASK_REPORT, "[TTNet-Uploader]" + r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r104);
        return;
    L18:
        return;
    }

    public static void taskDebug(String r100, long r101, String r102, String r103, String r104, boolean r105) {
        if (isLoggerParamsValid(r100, r103, r104) == true) goto L5;
        return;
    L5:
        if (r105 == false) goto L8;
        taskReport(r100, r101, r102, r103, r104);
    L8:
        if (alog() == false) goto L14;
        if (TextUtils.isEmpty(r102) == true) goto L14;
        taskAlog(r100, r101, r103, r104);
        return;
    L14:
        if (mLevel <= 3) goto L16;
        return;
    L16:
        String r106 = String.format(TAG_TASK_FORMAT, new Object[]{Long.valueOf(r101), r100});
        String r107 = "[TTNet-Uploader]" + r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r104;
        ILogWritter r108 = sLogWritter;
        if (r108 == null) goto L20;
        r108.logD(r106, r107);
        return;
    }
}
