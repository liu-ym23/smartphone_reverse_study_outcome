package com.bytedance.common.profilesdk.util;

import android.os.Build;
import android.os.Process;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes15.dex */
public class PathUtils {
    public static File getPrimaryCurProfile() {
        return new PolarisFileWrapper("/data/misc/profiles/cur/" + getUserId() + HTTP.URL_DEFAULT + AppContext.getPackageName() + "/primary.prof");
    }

    public static int getUserId() {
        return Process.myUid() / 100000;
    }

    public static void ensureExist(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (new PolarisFileWrapper(r100).exists() == true) goto L8;
        new PolarisFileWrapper(r100).mkdirs();
        return;
    }

    public static String getOatDir(String r100) {
        String r101 = r100.substring(0, r100.lastIndexOf(HTTP.URL_DEFAULT));
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        String r103 = File.separator;
        r102.append(r103);
        r102.append("oat");
        r102.append(r103);
        r102.append(AppContext.getInstructionSet());
        String r104 = r102.toString();
        ensureExist(r104);
        return r104;
    }

    public static String getOatFileName(String r100) {
        String r101 = r100.substring(r100.lastIndexOf(HTTP.URL_DEFAULT) + 1);
        String r102 = r101.substring(r101.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        String r103 = Dex2OatHelper.ODEX_SUFFIX;
    L7:
        if (Dex2OatHelper.DEX_SUFFIX.equals(r102) == true) goto L15;
        if (".zip".equals(r102) == true) goto L15;
        if (".apk".equals(r102) == true) goto L15;
        return r101.concat(r103);
    L15:
        return r101.replace(r102, r103);
    L5:
        r103 = Dex2OatHelper.DEX_SUFFIX;
        goto L7
    }

    public static String getOatDir(String r100, String r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r101 = getOatDir(r100);
    L5:
        ensureExist(r101);
        return r101;
    }

    public static String getOatFilePath(String r100, String r101) {
        return getOatDir(r100, r101) + File.separator + getOatFileName(r100);
    }
}
