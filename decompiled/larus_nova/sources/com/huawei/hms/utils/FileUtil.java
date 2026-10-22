package com.huawei.hms.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f277854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f277855b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f277856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f277857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f277858c;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_utils_FileUtil$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_utils_FileUtil$a__run$___twin___() {
            File r100 = this.f277856a;
            if (r100 != null) goto L6;
            HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
            return;
        L6:
            File r101 = r100.getParentFile();
            if (r101 != null) goto L9;
        L39:
            HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
            return;
        L9:
            if (r101.mkdirs() == false) goto L11;
        L13:
            RandomAccessFile r102 = null;
            long r103 = this.f277856a.length();     // Catch: Throwable -> L30 IOException -> L32
            if (r103 <= this.f277857b) goto L21;
            String r104 = this.f277856a.getCanonicalPath();     // Catch: Throwable -> L30 IOException -> L32
            if (this.f277856a.delete() == true) goto L20;
            HMSLog.e("FileUtil", "last file delete failed.");     // Catch: Throwable -> L30 IOException -> L32
        L20:
            r102 = new RandomAccessFile(new PolarisFileWrapper(r104), "rw");     // Catch: Throwable -> L30 IOException -> L32
        L24:
            r102.writeBytes(this.f277858c + System.getProperty("line.separator"));     // Catch: Throwable -> L30 IOException -> L32
        L34:
            IOUtils.closeQuietly(r102);
            return;
        L21:
            RandomAccessFile r105 = new RandomAccessFile(this.f277856a, "rw");     // Catch: Throwable -> L30 IOException -> L32
            r105.seek(r103);     // Catch: Throwable -> L26 IOException -> L28
            r102 = r105;
            goto L24
        L28:
            e = move-exception;
            e = e;
            r102 = r105;
        L33:
            HMSLog.e("FileUtil", "writeFile exception:", e);     // Catch: Throwable -> L30
        L26:
            Throwable th10 = th;
        L37:
            IOUtils.closeQuietly(r105);
            throw th10;
        L30:
            th = move-exception;
            r105 = null;
            th10 = th;
        L32:
            e = e;
            goto L33
        L11:
            if (r101.isDirectory() == true) goto L13;
            goto L13
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_utils_FileUtil$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_utils_FileUtil$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(File r100, long r101, String r102) {
            this.f277856a = r100;
            this.f277857b = r101;
            this.f277858c = r102;
        }
    }

    public FileUtil() {
    }

    static {
        f277855b = Executors.newSingleThreadScheduledExecutor();
    }

    public static boolean verifyHash(String r100, File r101) {
        byte[] r102 = SHA256.digest(r101);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (HEX.encodeHexString(r102, true).equalsIgnoreCase(r100) == false) goto L7;
        return true;
    }

    public static void writeFile(File r100, String r101, long r102) {
        f277855b.execute(new a(r100, r102, r101));
    }

    public static void writeFileReport(Context r100, File r101, File r102, String r103, long r104, int r105) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isFile() == true) goto L6;
        return;
    L6:
        if (r101.exists() == true) goto L8;
        return;
    L8:
        if (f277854a == true) goto L16;
        if (r102 != null) goto L11;
    L15:
        f277854a = true;
        goto L16
    L11:
        if (r102.exists() == false) goto L15;
        if (r102.delete() == true) goto L15;
        HMSLog.e("FileUtil", "file delete failed.");
    L16:
        writeFile(r102, r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r104 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r105, LOCAL_REPORT_FILE_MAX_SIZE);
    }
}
