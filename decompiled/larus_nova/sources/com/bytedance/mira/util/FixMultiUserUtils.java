package com.bytedance.mira.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.pm.PluginPackageManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FixMultiUserUtils {
    private static final String TAG = "FixMultiUserUtils";

    public FixMultiUserUtils() {
    }

    public static ApplicationInfo fix(ApplicationInfo r100) {
        if (r100 != null) goto L5;
    L25:
        MiraLogger.e("mira/file", "FixMultiUserUtils fixApplicationInfo check valid failed, info=" + r100);
        return r100;
    L5:
        if (r100.packageName == null) goto L25;
        String r101 = r100.sourceDir;
        if (r101 == null) goto L25;
        if (r101.length() == 0) goto L25;
        if (Objects.equals(r100.packageName, Mira.getAppContext().getApplicationInfo().packageName) == false) goto L15;
        MiraLogger.e("mira/file", "FixMultiUserUtils fixApplicationInfo check valid failed,is host info, info=" + r100);
        return r100;
    L15:
        String r102 = "/data/user/" + Process.myUserHandle().hashCode() + HTTP.URL_DEFAULT;
        String r103 = r100.sourceDir;
        if (r103.startsWith(r102) == true) goto L24;
        int r104 = PluginPackageManager.getInstalledPluginVersion(r100.packageName);
        String r105 = PluginDirHelper.getSourceFile(r100.packageName, r104);
        if (TextUtils.isEmpty(r105) == false) goto L20;
        return r100;
    L20:
        r100.sourceDir = r105;
        r100.publicSourceDir = r105;
        readAndWriteField(r100, "scanSourceDir", r105);
        readAndWriteField(r100, "scanPublicSourceDir", r100.publicSourceDir);
        if (MiraManager.getInstance().getParam().enableOptResourcesArch() == false) goto L23;
        r100.publicSourceDir = Mira.getAppContext().getApplicationInfo().publicSourceDir;
    L23:
        r100.nativeLibraryDir = PluginDirHelper.getNativeLibraryDir(r100.packageName, r104);
        MiraLogger.i("mira/file", "FixMultiUserUtils fixApplicationInfo after, old sourceDir=" + r103 + ", new sourceDir=" + r105);
    L24:
        return r100;
    }

    public static PackageInfo fix(PackageInfo r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        r100.applicationInfo = fix(r100.applicationInfo);
        return r100;
    }

    private static void readAndWriteField(Object r100, String r101, Object r102) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (FieldUtils.readField(r100, r101) != null) goto L11;
        FieldUtils.writeField(r100, r101, r102);     // Catch: Throwable -> L6
        return;
    }
}
