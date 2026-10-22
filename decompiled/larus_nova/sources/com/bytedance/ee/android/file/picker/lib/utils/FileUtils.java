package com.bytedance.ee.android.file.picker.lib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f206006a = null;

    public static final class MimeTypeCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[][] f206007a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FileUtils$MimeTypeCompat$COMPAT_MIME_MAP$1 f206008b = null;

        static {
            f206007a = new String[][]{new String[]{MimeType.ZIP, "application/x-zip-compressed"}};
            f206008b = new FileUtils$MimeTypeCompat$COMPAT_MIME_MAP$1();
        }
    }

    static {
        f206006a = new String[]{" Byte", " KB", " MB", " GB"};
    }

    public static String a(long r100) {
        String[] r101 = f206006a;
        Intrinsics.checkNotNullParameter(r101, "units");
        if (r100 >= 0) goto L6;
        r100 = 0;
    L6:
        if (r100 < 1024) goto L16;
        long r102 = 1024;
        long r103 = r100 / r102;
        if (r103 >= 1024) goto L12;
        return r103 + r101[1];
    L12:
        if (r103 >= 1048576) goto L14;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103 / r102);
        r104.append('.');
        long r105 = 100;
        r104.append(((r103 * r105) / r102) % r105);
        r104.append(r101[2]);
        return r104.toString();
    L14:
        long r106 = 100;
        long r107 = ((r103 * r106) / r102) / r102;
        return (r107 / r106) + '.' + (r107 % r106) + r101[3];
    L16:
        return r100 + r101[0];
    }

    public static VFSPath b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getExternalFilesDir(null);
        if (r101 != null) goto L5;
        r101 = r100.getFilesDir();
    L5:
        if (r101 == null) goto L7;
        String r102 = r101.getPath();
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        return null;
    L15:
        return VFSFiles.f444819b.u(r102, "download");
    L11:
        r103 = false;
        goto L12
    L7:
        r102 = "";
        goto L9
    }

    @JvmStatic
    public static final String c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = LarkContext.getApplication().getContentResolver().getType(r100);
        if (r101 != null) goto L6;
        return "*/*";
    L6:
        return r101;
    }

    public static boolean d(Context r100, Uri r101, String r102) {
        if (e(r100, r101, r102) == false) goto L6;
        return true;
    L6:
        String[][] r103 = MimeTypeCompat.f206007a;
        Intrinsics.checkNotNullParameter(r102, "type");
        if (((String) MimeTypeCompat.f206008b.get(r102)) != null) goto L10;
        r102 = "";
    L10:
        return e(r100, r101, r102);
    }

    public static boolean e(Context r100, Uri r101, String r102) {
        Log.i("FileUtils", "openFile: " + r102);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = c(r101);
    L5:
        Intent r103 = new Intent();
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.addFlags(268435456);
        if (Build.VERSION.SDK_INT < 24) goto L8;
        r103.setDataAndType(r101, r102);
        r103.addFlags(1);
        r103.addFlags(2);
    L14:
        r100.startActivity(r103);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        Log.w("FileUtils", "openFile: " + e.getMessage());
        return false;
    L8:
        r103.setDataAndType(r101, r102);
        goto L14
    }
}
