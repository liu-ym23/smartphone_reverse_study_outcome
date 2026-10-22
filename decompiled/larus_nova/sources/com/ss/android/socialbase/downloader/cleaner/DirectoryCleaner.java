package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DirectoryCleaner implements CleanerImpl.CleanerHandler {
    private static final String TAG = "DirectoryCleaner";
    private static volatile boolean sEnabled;
    private static volatile long sExpiredTime;
    private long mCleanDuration;
    private CleanerConfig mCleanerConfig;
    private CleanerImpl mCleanerImpl;
    private int mDeleteFileCount;
    private IDirectoryCleanerListener mDirectoryCleanerListener;
    private String mPackageName;
    private int mSearchDBCount;

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public void start() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "start", "Run");
    L5:
        long r100 = System.nanoTime();
        startImpl();     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "start", "Run End");
    L10:
        long r101 = ((System.nanoTime() - r100) / 1000) / 1000;
        this.mCleanDuration = r101;
        IDirectoryCleanerListener r102 = this.mDirectoryCleanerListener;
        if (r102 == null) goto L34;
        r102.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, r101);
        return;
    L34:
        return;
    L13:
        th = move-exception;
        Logger.globalError(TAG, "start", "Error:" + th);     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "start", "Run End");
    L18:
        long r110 = ((System.nanoTime() - r100) / 1000) / 1000;
        this.mCleanDuration = r110;
        IDirectoryCleanerListener r103 = this.mDirectoryCleanerListener;
        if (r103 == null) goto L36;
        r103.onFinish(th, this.mSearchDBCount, this.mDeleteFileCount, r110);
        return;
    L36:
        return;
    L22:
        th = move-exception;
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "start", "Run End");
    L26:
        long r111 = ((System.nanoTime() - r100) / 1000) / 1000;
        this.mCleanDuration = r111;
        IDirectoryCleanerListener r104 = this.mDirectoryCleanerListener;
        if (r104 == null) goto L29;
        r104.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, r111);
    L29:
        throw th;
    }

    private void startImpl() {
        Context r100 = DownloadComponentManager.getAppContext();
        if (r100 != null) goto L6;
        Logger.globalError(TAG, "init", "Error context is null");
        return;
    L6:
        this.mPackageName = r100.getPackageName();
        if (sExpiredTime >= 0) goto L10;
        sExpiredTime = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEAN_DIRECTORY_EXPIRED_TIME_D, -1);
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "init", TTVideoEngineInterface.AUTH_EXPIREDTIME + sExpiredTime);
    L13:
        if (sExpiredTime >= 0) goto L15;
        return;
    L15:
        sExpiredTime *= 86400000;
        CleanerConfig r101 = this.mCleanerConfig;
        if (r101 == null) goto L18;
        r101.updateCleanDirectoryTime();
    L18:
        JSONArray r102 = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.CLEAN_DIRECTORY_LIST);
        if (r102 != null) goto L21;
        return;
    L21:
        if (r102.length() <= 0) goto L79;
        int r103 = 0;
    L25:
        if (r103 >= r102.length()) goto L80;
        JSONObject r104 = r102.optJSONObject(r103);
        if (r104 == null) goto L66;
        String r105 = r104.optString(DownloadSettingKeys.CleanDirectory.DIRECTORY_PATH);
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "startImpl", "Run directoryPath:" + r105);
    L33:
        if (TextUtils.isEmpty(r105) == true) goto L66;
        JSONArray r106 = r104.optJSONArray(DownloadSettingKeys.CleanDirectory.PATH_CONTAINS_LIST);
        ArrayList r107 = new ArrayList();
        if (r106 != null) goto L38;
    L46:
        File r108 = CleanerConfig.getRealExternalFile(r105, this.mPackageName);
        if (r108 != null) goto L49;
    L51:
        CleanerImpl r109 = this.mCleanerImpl;
        if (r109 != null) goto L54;
    L56:
        File r110 = CleanerConfig.getRealInternalFile(r105, this.mPackageName);
        if (r110 != null) goto L59;
    L61:
        CleanerImpl r111 = this.mCleanerImpl;
        if (r111 == null) goto L66;
        if (r111.isStop() == false) goto L66;
        return;
    L59:
        if (r110.isDirectory() == false) goto L61;
        deleteCacheData(r110, r107);
        goto L61
    L54:
        if (r109.isStop() == false) goto L56;
        return;
    L49:
        if (r108.isDirectory() == false) goto L51;
        deleteCacheData(r108, r107);
        goto L66
    L38:
        if (r106.length() <= 0) goto L46;
        int r112 = 0;
    L41:
        if (r112 >= r106.length()) goto L46;
        String r113 = r106.optString(r112);
        if (TextUtils.isEmpty(r113) == true) goto L45;
        r107.add(r113);
    L45:
        r112 = r112 + 1;
    L66:
        r103 = r103 + 1;
        goto L25
    L80:
        return;
    }

    public DirectoryCleaner() {
    }

    public static /* synthetic */ long access$000() {
        return sExpiredTime;
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void init(CleanerConfig r110) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "init", "Run");
    L5:
        DownloadSetting r100 = DownloadSetting.obtainGlobal();
        if (r100.optInt(DownloadSettingKeys.AUTO_CLEAN_DIRECTORY) > 0) goto L8;
        return;
    L8:
        JSONArray r101 = r100.optJSONArray(DownloadSettingKeys.CLEAN_DIRECTORY_LIST);
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.length() <= 0) goto L32;
        int r102 = r100.optInt(DownloadSettingKeys.CLEAN_DIRECTORY_CHECK_INTERVAL_D);
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "init", "Clean_directory_check_interval_d:" + r102 + " clean_directory_list:" + r101);
    L16:
        if (r102 <= 0) goto L25;
        long r103 = r110.getLastCleanDirectoryTime();
        if (r103 <= 0) goto L25;
        if ((System.currentTimeMillis() - r103) >= (((long) r102) * 86400000)) goto L25;
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + r103);
        return;
    L29:
        return;
    L25:
        sEnabled = true;
        if (Logger.debug() == false) goto L31;
        Logger.globalDebug(TAG, "init", "Run End");
        return;
    L31:
        return;
    }

    public void setDirectoryCleanerListener(IDirectoryCleanerListener r100) {
        this.mDirectoryCleanerListener = r100;
    }

    public DirectoryCleaner(CleanerImpl r100, CleanerConfig r101) {
        this.mCleanerImpl = r100;
        this.mCleanerConfig = r101;
    }

    private void deleteCacheData(File r100, List<String> r110) {
        List<File> r111 = getExpiredFiles(r100, r110);
        if (r111 != null) goto L5;
        return;
    L5:
        if (r111.isEmpty() == true) goto L35;
        Map r101 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getInstalledTimeStampBySavePath(r100.getAbsolutePath() + GXTemplateKey.GAIAX_PE);
        if (r101 == null) goto L10;
        this.mSearchDBCount += r101.size();
    L10:
        Iterator<File> r112 = r111.iterator();
    L12:
        if (r112.hasNext() == false) goto L36;
        File r102 = r112.next();
        CleanerImpl r103 = this.mCleanerImpl;
        if (r103 != null) goto L16;
    L18:
        String r104 = r102.getAbsolutePath();
        if (r101 == null) goto L25;
        Pair r105 = (Pair) r101.get(r104.toLowerCase(Locale.getDefault()));
        if (r105 == null) goto L25;
        if (((Long) r105.second).longValue() > 0) goto L25;
        DownloadComponentManager.getDownloadCache().removeDownloadTaskData(((Integer) r105.first).intValue());
    L25:
        r102.delete();
        this.mDeleteFileCount++;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "deleteCacheDataImpl", "Delete DownloadData:" + r104);
        goto L12
    L16:
        if (r103.isStop() == false) goto L18;
        return;
    L36:
        return;
    }

    private List<File> getExpiredFiles(File r110, final List<String> r111) {
        final long r100 = System.currentTimeMillis();
        final ArrayList r101 = new ArrayList();
        final LinkedList r102 = new LinkedList();
        r102.add(r110);
        FileFilter r112 = new AnonymousClass1(this, r111, r100, r101, r102);
    L4:
        if (r102.isEmpty() == true) goto L6;
        ((File) r102.poll()).listFiles(r112);
        goto L4
    L6:
        return r101;
    }
}
