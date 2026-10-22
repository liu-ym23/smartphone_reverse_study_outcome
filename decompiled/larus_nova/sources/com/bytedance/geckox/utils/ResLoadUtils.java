package com.bytedance.geckox.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.a;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import ez5.c;
import ez5.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ResLoadUtils {
    public ResLoadUtils() {
    }

    private static String tripChannel(String r100) {
        if (r100.indexOf(HTTP.URL_DEFAULT) != 0) goto L6;
        r100 = r100.substring(1);
    L6:
        if (r100.lastIndexOf(HTTP.URL_DEFAULT) == (r100.length() - 1)) goto L8;
        return r100;
    L8:
        return r100.substring(0, r100.lastIndexOf(HTTP.URL_DEFAULT));
    }

    public static List<Pair<String, Long>> getAllLocalChannels(File r100, String r101) {
        if (r100 != null) goto L5;
    L26:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        if (AppSettingsManager.b.f245071a.a() == false) goto L13;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r102 = GlobalManager.f250638g;
        if (r102 != null) goto L12;
        return null;
    L12:
        r100 = new PolarisFileWrapper(r102.getRootDir());
    L13:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, r101);
        String[] r104 = r103.list();
        ArrayList r105 = new ArrayList();
        if (r104 != null) goto L16;
    L25:
        return r105;
    L16:
        if (r104.length <= 0) goto L25;
        int r106 = r104.length;
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L25;
        String r108 = r104[r107];
        PolarisFileWrapper r109 = new PolarisFileWrapper(r103, r108);
        if (r109.isDirectory() == false) goto L24;
        Long r110 = f.c(r109);
        if (r110 == null) goto L24;
        r105.add(new Pair(r108, r110));
    L24:
        r107 = r107 + 1;
        goto L18
    }

    public static boolean checkExist(File r100, String r101, String r102) {
        if (AppSettingsManager.b.f245071a.a() == false) goto L10;
        if (IESGurdKit.a(r101, r102) > 0) goto L25;
        return false;
    L25:
        return true;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
    L23:
        return false;
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L23;
        if (r100 == null) goto L23;
        if (r100.exists() == false) goto L23;
        if (r100.isDirectory() == false) goto L23;
        if (innerGetLatestChannelVersion(r100, r101, r102) == null) goto L23;
        return true;
    }

    public static boolean deleteChannel(File r110, String r111, String r112) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L30:
        return false;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L30;
        if (r110 == null) goto L30;
        if (AppSettingsManager.b.f245071a.a() == false) goto L15;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r113 = GlobalManager.f250638g;
        if (r113 != null) goto L13;
        return false;
    L13:
        r110 = new PolarisFileWrapper(r113.getRootDir());
    L15:
        if (r110.exists() == false) goto L30;
        if (r110.isDirectory() == false) goto L30;
        String r100 = tripChannel(r112);
        PolarisFileWrapper r114 = new PolarisFileWrapper(r110, File.separator + r111);     // Catch: Throwable -> L28
        if (r114.exists() == true) goto L23;
        return false;
    L23:
        PolarisFileWrapper r115 = new PolarisFileWrapper(r114.getAbsolutePath(), r100);     // Catch: Throwable -> L28
        if (r115.exists() == true) goto L26;
        return false;
    L26:
        GeckoLogger.d("deleteChannel: " + r111 + "-" + r100);     // Catch: Throwable -> L28
        a.e(r111, r100);     // Catch: Throwable -> L28
        new z86.a(CleanStrategy.BUSINESS_CALL, -1, r111, r100, 0, 200, 0, null).a();     // Catch: Throwable -> L28
        return c.delete(r115);
    L28:
        th = move-exception;
        GeckoLogger.w("deleteChannel:error:", th);
        goto L30
    }

    public static String getChannelPath(File r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L31:
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L31;
        if (r100 == null) goto L31;
        if (AppSettingsManager.b.f245071a.a() == false) goto L15;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r103 = GlobalManager.f250638g;
        if (r103 != null) goto L13;
        return null;
    L13:
        r100 = new PolarisFileWrapper(r103.getRootDir());
    L15:
        if (r100.exists() == false) goto L31;
        if (r100.isDirectory() == false) goto L31;
        String r104 = tripChannel(r102);
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L29
        String r106 = File.separator;     // Catch: Throwable -> L29
        r105.append(r106);     // Catch: Throwable -> L29
        r105.append(r101);     // Catch: Throwable -> L29
        String r107 = new PolarisFileWrapper(r100, r105.toString()).getAbsolutePath();     // Catch: Throwable -> L29
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, r104);     // Catch: Throwable -> L29
        Long r109 = f.c(r108);     // Catch: Throwable -> L29
        if (r108.exists() == false) goto L27;
        if (r109 == null) goto L27;
        String r110 = r107 + r106 + r104 + r106 + r109 + r106 + "res";     // Catch: Throwable -> L29
        com.bytedance.iesgurd.loader.a.f250751a.getClass();     // Catch: Throwable -> L29
        com.bytedance.iesgurd.loader.a.b(r101, r104, r109, "3");     // Catch: Throwable -> L29
        return r110;
    L27:
        com.bytedance.iesgurd.loader.a.f250751a.getClass();     // Catch: Throwable -> L29
        com.bytedance.iesgurd.loader.a.b(r101, r104, r109, "3");     // Catch: Throwable -> L29
        return null;
    L29:
        th = move-exception;
        GeckoLogger.w("getChannelPath:error:", th);
        goto L31
    }

    public static Long getLatestChannelVersion(File r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r100 != null) goto L9;
        return null;
    L9:
        return innerGetLatestChannelVersion(r100, r101, r102);
    L12:
        return null;
    }

    public static Long innerGetLatestChannelVersion(File r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        ChannelMeta r103 = a.c(r101, r102);
        if (r103 == null) goto L16;
        String r104 = "rootDir: ";
        if (r100 == null) goto L13;
        r104 = "rootDir: " + r100.getAbsolutePath();
    L13:
        return a.a(r101, r102, r103, r104);
    L16:
        return null;
    L17:
        return null;
    }

    public static boolean checkChannelFileExist(File r100, String r101, String r102, String r103) {
        if (searchChannelFile(r100, r101, r102, r103) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getChannelPath(File r100, String r101, String r102, long r103) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L32:
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L32;
        if (r100 == null) goto L32;
        if (r103 == 0) goto L32;
        if (AppSettingsManager.b.f245071a.a() == false) goto L17;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r104 = GlobalManager.f250638g;
        if (r104 != null) goto L15;
        return null;
    L15:
        r100 = new PolarisFileWrapper(r104.getRootDir());
    L17:
        if (r100.exists() == false) goto L32;
        if (r100.isDirectory() == false) goto L32;
        String r105 = tripChannel(r102);
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L30
        String r107 = File.separator;     // Catch: Throwable -> L30
        r106.append(r107);     // Catch: Throwable -> L30
        r106.append(r101);     // Catch: Throwable -> L30
        PolarisFileWrapper r108 = new PolarisFileWrapper(r100, r106.toString());     // Catch: Throwable -> L30
        if (r108.exists() == true) goto L25;
        return null;
    L25:
        String r109 = r108.getAbsolutePath();     // Catch: Throwable -> L30
        if (new PolarisFileWrapper(r109, r105).exists() == true) goto L28;
        return null;
    L28:
        return r109 + r107 + r105 + r107 + r103 + r107 + "res";
    L30:
        th = move-exception;
        GeckoLogger.w("getChannelPath:error:", th);
        goto L32
    }

    public static InputStream getPrefetchDataForPath(File r100, String r101, String r102, String r103) throws FileNotFoundException {
        Map r104 = (Map) ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.f250660a).get(r101);
        if (r104 == null) goto L7;
        List r105 = (List) r104.get(r102);
        if (r105 == null) goto L7;
        boolean r106 = r105.contains(r103);
    L9:
        if (r106 == true) goto L11;
        return null;
    L11:
        if (AppSettingsManager.b.f245071a.a() == false) goto L16;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r107 = GlobalManager.f250638g;
        if (r107 != null) goto L15;
        return null;
    L15:
        r100 = new PolarisFileWrapper(r107.getRootDir());
    L16:
        StringBuilder r108 = new StringBuilder();
        r108.append(r101);
        String r109 = File.separator;
        r108.append(r109);
        r108.append(r102);
        PolarisFileWrapper r110 = new PolarisFileWrapper(r100, r108.toString());
        if (r110.exists() == true) goto L19;
        return null;
    L19:
        Long r111 = f.c(r110);
        if (r111 != null) goto L22;
        return null;
    L22:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r110, r111 + r109 + "res" + r109 + r103);
        if (r112.exists() == true) goto L32;
        String r113 = GkFSUtils.d(r101, r102, r103);
        if (r113 == null) goto L30;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r110, r111 + r109 + "res" + r109 + r113);
        if (r114.exists() == false) goto L30;
        return new GkFSFileInputStream(r114, true);
    L30:
        return null;
    L32:
        return new PolarisFileInputStreamWrapper(r112);
    L7:
        r106 = false;
        goto L9
    }

    public static String searchChannelFile(File r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L36:
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L36;
        if (r100 == null) goto L36;
        if (AppSettingsManager.b.f245071a.a() == false) goto L15;
        GlobalManager.f250642k.a();
        GeckoGlobalConfig r104 = GlobalManager.f250638g;
        if (r104 != null) goto L13;
        return null;
    L13:
        r100 = new PolarisFileWrapper(r104.getRootDir());
    L15:
        if (r100.exists() == false) goto L36;
        if (r100.isDirectory() == false) goto L36;
        if (TextUtils.isEmpty(r103) == false) goto L22;
        return null;
    L22:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100, r101 + File.separator + r102);
        if (r105.exists() == false) goto L36;
        if (r105.listFiles().length <= 0) goto L36;
        File[] r106 = r105.listFiles();
        int r107 = r106.length;
        int r108 = 0;
    L28:
        if (r108 >= r107) goto L36;
        String r109 = r106[r108].getName();
        if (r109.endsWith(r103) == true) goto L35;
        if (r109.endsWith(r103 + ".gkfsf") == true) goto L35;
        r108 = r108 + 1;
    L35:
        return r109;
    }
}
