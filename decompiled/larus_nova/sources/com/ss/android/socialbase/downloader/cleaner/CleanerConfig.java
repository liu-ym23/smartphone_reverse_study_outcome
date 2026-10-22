package com.ss.android.socialbase.downloader.cleaner;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CleanerConfig {
    private static final int FORCE_CLEAN_ID = -1;
    private static final String KEY_CLEAN_FINISH = "key_clean_finish";
    private static final String KEY_CLEAN_TIME = "key_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY = "key_download_cache_clean_strategy";
    private static final String KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME = "key_download_cache_last_directory_clean_time";
    private static final String KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME = "key_download_cache_last_report_time";
    private static final String KEY_UPDATE_SP_INFO_TIME = "key_update_sp_info_time";
    private static final String TAG = "CleanerConfig";
    private volatile Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private volatile Set<Integer> mCleanDownloadIdSet;
    private volatile Map<Integer, CleanItem> mCleanItemMaps;
    private volatile Map<Integer, String> mFileDirPathMap;
    private volatile Map<Integer, String> mFileNameMap;
    private volatile boolean mFinish;
    private volatile Map<Integer, CleanItem> mNeedCleanItemMaps;
    private volatile Set<Integer> mOnlyCleanFileSet;
    private String mPackageName;
    private volatile Map<Integer, String> mTempSavePath;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.CleanerConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes38.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes38.dex */
    public class CleanItem {
        boolean finish;
        List<String> prefixUrls;
        Set<String> savePaths;
        Set<String> scenes;
        final /* synthetic */ CleanerConfig this$0;

        public String toString() {
            return "CleanItem{finish=" + this.finish + ", scenes=" + this.scenes + ", prefixUrls=" + this.prefixUrls + ", savePaths=" + this.savePaths + '}';
        }

        private CleanItem(CleanerConfig r100) {
            this.this$0 = r100;
            this.scenes = new HashSet();
            this.prefixUrls = new ArrayList();
            this.savePaths = new HashSet();
        }

        public /* synthetic */ CleanItem(CleanerConfig r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public void finish() {
        this.mFinish = true;
        this.mCleanItemMaps.clear();
        this.mNeedCleanItemMaps.clear();
        clearData();
    }

    public void clearData() {
        this.mCleanCacheKeyMaps.clear();
        this.mFileDirPathMap.clear();
        this.mFileNameMap.clear();
        this.mTempSavePath.clear();
        this.mOnlyCleanFileSet.clear();
        this.mCleanDownloadIdSet.clear();
    }

    public long getCacheLastReportTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME);
    }

    public long getLastCleanDirectoryTime() {
        return getLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME);
    }

    public boolean isNeedClean() {
        return !this.mNeedCleanItemMaps.isEmpty();
    }

    public boolean isNoCacheNeedClean() {
        return this.mCleanDownloadIdSet.isEmpty();
    }

    public void updateCacheReportTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_REPORT_TIME, System.currentTimeMillis());
    }

    public void updateCleanDirectoryTime() {
        putLong(KEY_DOWNLOAD_CACHE_LAST_DIRECTORY_CLEAN_TIME, System.currentTimeMillis());
    }

    public CleanerConfig() {
        this.mCleanItemMaps = new HashMap();
        this.mNeedCleanItemMaps = new HashMap();
        this.mCleanCacheKeyMaps = new HashMap();
        this.mCleanDownloadIdSet = new CopyOnWriteArraySet();
        this.mFileDirPathMap = new HashMap();
        this.mFileNameMap = new HashMap();
        this.mTempSavePath = new HashMap();
        this.mOnlyCleanFileSet = new HashSet();
        this.mFinish = false;
    }

    private SharedPreferences getDownloadCacheSp() {
        return DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
    }

    public boolean checkTimeInterval() {
        int r100 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.CLEAN_INTERVAL_D);
        if (r100 > 0) goto L5;
        return true;
    L5:
        long r101 = getLong(KEY_CLEAN_TIME);
        if (r101 > 0) goto L8;
    L14:
        putLong(KEY_CLEAN_TIME, System.currentTimeMillis());
        return true;
    L8:
        if ((System.currentTimeMillis() - r101) >= (((long) r100) * 86400000)) goto L14;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + r101);
        return false;
    L16:
        return false;
    }

    public boolean checkUpdateSPInfoTimeInterval() {
        int r100 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.UPDATE_DOWNLOAD_SP_INFO_INTERVAL_D);
        if (r100 > 0) goto L5;
        return true;
    L5:
        long r101 = getLong(KEY_UPDATE_SP_INFO_TIME);
        if (r101 > 0) goto L8;
    L14:
        putLong(KEY_UPDATE_SP_INFO_TIME, System.currentTimeMillis());
        return true;
    L8:
        if ((System.currentTimeMillis() - r101) >= (((long) r100) * 86400000)) goto L14;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "checkUpdateSPInfoTimeInterval", "It has already updated sp info, lastUpdateTime:" + r101);
        return false;
    L16:
        return false;
    }

    public void init() {
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (DownloadComponentManager.getAppContext() != null) goto L5;
        return;
    L5:
        String r100 = DownloadComponentManager.getAppContext().getPackageName();     // Catch: Throwable -> L19
        this.mPackageName = r100;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        parseCleanSetting(getString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY));     // Catch: Throwable -> L19
        parseCleanSetting(DownloadSetting.getGlobalSettings());     // Catch: Throwable -> L19
        DirectoryCleaner.init(this);     // Catch: Throwable -> L19
        if (this.mCleanItemMaps.isEmpty() == false) goto L11;
        return;
    L11:
        Iterator<Map.Entry<Integer, CleanItem>> r101 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r101.hasNext() == false) goto L30;
        Map.Entry<Integer, CleanItem> r102 = r101.next();     // Catch: Throwable -> L19
        CleanItem r103 = r102.getValue();     // Catch: Throwable -> L19
        if (r103.finish == true) goto L13;
        this.mNeedCleanItemMaps.put(r102.getKey(), r103);     // Catch: Throwable -> L19
        goto L13
    }

    public boolean isCacheCleanEnabled() {
        if (checkTimeInterval() == true) goto L5;
    L9:
        return false;
    L5:
        if (isNoCacheNeedClean() == true) goto L7;
    L8:
        return true;
    L7:
        if (DirectoryCleaner.isEnabled() == false) goto L9;
        goto L8
    }

    public Map<Integer, List<Integer>> getCleanCacheKeyMaps() {
        return this.mCleanCacheKeyMaps;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    private void addToCleanDownloadIdSet(int r100) {
        if (this.mFinish == false) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        return;
    L7:
        this.mCleanDownloadIdSet.add(Integer.valueOf(r100));
    }

    private long getLong(String r100) {
        return getDownloadCacheSp().getLong(r100, 0);
    L5:
        th = move-exception;
        Logger.globalError(TAG, "getLong", "Error:" + th);
        return 0;
    }

    private String getString(String r100) {
        return getDownloadCacheSp().getString(r100, "");
    L5:
        th = move-exception;
        Logger.globalError(TAG, "getString", "Error:" + th);
        return "";
    }

    private void parseCleanSetting(JSONObject r110) throws Throwable {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "parseCleanSetting", "Run");
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        JSONArray r111 = r110.optJSONArray(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP);
        if (r111 != null) goto L10;
        return;
    L10:
        if (r111.length() <= 0) goto L82;
        int r100 = 0;
    L14:
        if (r100 >= r111.length()) goto L63;
        JSONObject r101 = JSONArrayProtectorUtils.getJSONObject(r111, r100);
        int r102 = r101.optInt(DownloadSettingKeys.CacheCleaner.CLEAN_ID);
        if (this.mCleanItemMaps.containsKey(Integer.valueOf(r102)) == true) goto L61;
        CleanItem r103 = new CleanItem(this, null);
        boolean r104 = r101.optBoolean(KEY_CLEAN_FINISH);
        r103.finish = r104;
        if (r104 == false) goto L21;
        this.mCleanItemMaps.put(Integer.valueOf(r102), r103);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r102), new ArrayList());
        goto L61
    L21:
        JSONArray r105 = r101.optJSONArray(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST);
        if (r105 != null) goto L24;
    L32:
        JSONArray r106 = r101.optJSONArray(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST);
        if (r106 != null) goto L35;
    L43:
        JSONArray r107 = r101.optJSONArray(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST);
        if (r107 == null) goto L55;
        if (r107.length() <= 0) goto L55;
        int r108 = 0;
    L49:
        if (r108 >= r107.length()) goto L55;
        String r109 = r107.optString(r108);
        if (TextUtils.isEmpty(r109) == true) goto L53;
        r103.savePaths.add(r109);
    L53:
        r108 = r108 + 1;
    L55:
        if (r103.scenes.isEmpty() == true) goto L57;
    L60:
        this.mCleanItemMaps.put(Integer.valueOf(r102), r103);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r102), new ArrayList());
        goto L61
    L57:
        if (r103.prefixUrls.isEmpty() == false) goto L60;
        if (r103.savePaths.isEmpty() == true) goto L61;
    L35:
        if (r106.length() <= 0) goto L43;
        int r112 = 0;
    L38:
        if (r112 >= r106.length()) goto L43;
        String r113 = r106.optString(r112);
        if (TextUtils.isEmpty(r113) == true) goto L42;
        r103.prefixUrls.add(r113);
    L42:
        r112 = r112 + 1;
        goto L38
    L24:
        if (r105.length() <= 0) goto L32;
        int r114 = 0;
    L27:
        if (r114 >= r105.length()) goto L32;
        String r115 = r105.optString(r114);
        if (TextUtils.isEmpty(r115) == true) goto L31;
        r103.scenes.add(r115);
    L31:
        r114 = r114 + 1;
    L61:
        r100 = r100 + 1;
        goto L14
    L63:
        if (Logger.debug() == false) goto L81;
        Logger.globalDebug(TAG, "parseCleanSetting", "Result: " + this.mCleanItemMaps);
        return;
    L81:
        return;
    }

    private void saveFilePath(CleanDownloadInfo r100) {
        if (TextUtils.isEmpty(r100.getSavePath()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.getName()) == true) goto L11;
        this.mFileDirPathMap.put(Integer.valueOf(r100.getId()), r100.getSavePath());
        this.mFileNameMap.put(Integer.valueOf(r100.getId()), r100.getName());
        if (TextUtils.isEmpty(r100.getTempPath()) == true) goto L12;
        this.mTempSavePath.put(Integer.valueOf(r100.getId()), r100.getTempPath());
        return;
    L12:
        return;
    }

    public String getName(int r100) {
        return this.mFileNameMap.get(Integer.valueOf(r100));
    }

    public String getSavePath(int r100) {
        return this.mFileDirPathMap.get(Integer.valueOf(r100));
    }

    public String getTempSavePath(int r100) {
        return this.mTempSavePath.get(Integer.valueOf(r100));
    }

    public boolean isExistInCleanSet(int r100) {
        if (this.mFinish == false) goto L5;
        return false;
    L5:
        if (this.mCleanDownloadIdSet.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.mCleanDownloadIdSet.contains(Integer.valueOf(r100));
    }

    public boolean isOnlyCleanFile(int r100) {
        return this.mOnlyCleanFileSet.contains(Integer.valueOf(r100));
    }

    public void removeFromCleanDownloadIdSet(int r100) {
        this.mCleanDownloadIdSet.remove(Integer.valueOf(r100));
    }

    public boolean updateCleanDownloadId(CleanDownloadInfo r100) {
        Iterator<Map.Entry<Integer, CleanItem>> r101 = this.mNeedCleanItemMaps.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<Integer, CleanItem> r102 = r101.next();
        if (matchCleanItem(r102.getValue(), r100) == false) goto L4;
        addCleanDownloadItem(r102.getKey().intValue(), r100, false);
        return true;
    L9:
        return false;
    }

    public void updateCleanSetting(int r110) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "updateCleanSetting", "Run:" + r110);
    L6:
        if (this.mCleanItemMaps.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mCleanItemMaps.get(Integer.valueOf(r110)) != null) goto L10;
        return;
    L10:
        if (this.mCleanItemMaps.get(Integer.valueOf(r110)).finish == true) goto L56;
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L40
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<Map.Entry<Integer, CleanItem>> r102 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L40
    L14:
        if (r102.hasNext() == false) goto L38;
        Map.Entry<Integer, CleanItem> r103 = r102.next();     // Catch: Throwable -> L40
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L40
        r104.put(DownloadSettingKeys.CacheCleaner.CLEAN_ID, r103.getKey());     // Catch: Throwable -> L40
        CleanItem r105 = r103.getValue();     // Catch: Throwable -> L40
        if (r105.finish == false) goto L18;
    L21:
        boolean r106 = true;
    L22:
        r105.finish = r106;     // Catch: Throwable -> L40
        r104.put(KEY_CLEAN_FINISH, r106);     // Catch: Throwable -> L40
        if (r105.finish == true) goto L24;
        JSONArray r107 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r108 = r105.scenes.iterator();     // Catch: Throwable -> L40
    L27:
        if (r108.hasNext() == false) goto L29;
        r107.put(r108.next());     // Catch: Throwable -> L40
        goto L27
    L29:
        r104.put(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST, r107);     // Catch: Throwable -> L40
        JSONArray r109 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r111 = r105.prefixUrls.iterator();     // Catch: Throwable -> L40
    L31:
        if (r111.hasNext() == false) goto L33;
        r109.put(r111.next());     // Catch: Throwable -> L40
        goto L31
    L33:
        r104.put(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST, r109);     // Catch: Throwable -> L40
        JSONArray r112 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r113 = r105.savePaths.iterator();     // Catch: Throwable -> L40
    L35:
        if (r113.hasNext() == false) goto L37;
        r112.put(r113.next());     // Catch: Throwable -> L40
        goto L35
    L37:
        r104.put(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST, r112);     // Catch: Throwable -> L40
        r101.put(r104);     // Catch: Throwable -> L40
        goto L14
    L24:
        r101.put(r104);     // Catch: Throwable -> L40
        goto L14
    L18:
        if (r103.getKey().intValue() == r110) goto L21;
        r106 = false;
        goto L22
    L38:
        r100.put(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP, r101);     // Catch: Throwable -> L40
        putString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY, r100.toString());     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "updateCleanSetting", "Error:" + th);
        return;
    }

    private void parseCleanSetting(String r100) throws Throwable {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        parseCleanSetting(new JSONObject(r100));
    }

    public static File getRealExternalFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        String r102 = "Android/data/" + r101;
        int r103 = r102.length();
        if (r100.length() > r103) goto L10;
        return null;
    L10:
        File r104 = DownloadDirUtils.getExternalCacheDir(DownloadComponentManager.getAppContext(), false);
        if (r104 != null) goto L13;
        return null;
    L13:
        String r105 = r104.getParent();
        if (r100.startsWith(r102) == false) goto L19;
        if (TextUtils.isEmpty(r105) == true) goto L19;
        return new PolarisFileWrapper(r105, r100.substring(r103));
    }

    public static File getRealInternalFile(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        int r102 = r101.length();
        if (r100.length() > r102) goto L8;
        return null;
    L8:
        File r103 = DownloadDirUtils.getFilesDir(DownloadComponentManager.getAppContext(), false);
        if (r103 != null) goto L11;
        return null;
    L11:
        String r104 = r103.getParent();
        if (r100.startsWith(r101) == true) goto L14;
    L17:
        return null;
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L17;
        return new PolarisFileWrapper(r104, r100.substring(r102));
    }

    private boolean matchCleanItem(CleanItem r100, CleanDownloadInfo r101) {
        if (r100 == null) goto L42;
        if (r101 == null) goto L42;
        if (TextUtils.isEmpty(r101.getSavePath()) == true) goto L42;
        if (r100.scenes.isEmpty() == true) goto L16;
        if (TextUtils.isEmpty(r101.getMonitorScene()) == true) goto L16;
        if (r100.scenes.contains(r101.getMonitorScene()) == false) goto L16;
        return true;
    L16:
        if (r100.prefixUrls.isEmpty() == true) goto L27;
        String r102 = r101.getUrl();
        if (TextUtils.isEmpty(r102) == false) goto L20;
        return false;
    L20:
        Iterator<String> r103 = r100.prefixUrls.iterator();
    L22:
        if (r103.hasNext() == false) goto L27;
        if (r102.startsWith(r103.next()) == false) goto L22;
        return true;
    L27:
        if (r100.savePaths.isEmpty() == true) goto L42;
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L42;
        String r104 = r101.getSavePath();
        if (TextUtils.isEmpty(r104) == false) goto L34;
        return false;
    L34:
        if (r104.indexOf(this.mPackageName) > 0) goto L37;
        return false;
    L37:
        if (r104.endsWith(HTTP.URL_DEFAULT) == false) goto L40;
        r104 = r104.substring(0, r104.length() - 1);
    L40:
        if (r100.savePaths.contains(r104) == false) goto L42;
        return true;
    L42:
        return false;
    }

    private void putLong(String r100, long r101) {
        getDownloadCacheSp().edit().putLong(r100, r101).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.globalError(TAG, "putLong", "Error:" + th);
    }

    private void putString(String r100, String r101) {
        getDownloadCacheSp().edit().putString(r100, r101).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.globalError(TAG, "putString", "Error:" + th);
    }

    public boolean forceUpdateCleanDownloadId(CleanDownloadInfo r100, boolean r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        addCleanDownloadItem(-1, r100, r101);
        return true;
    }

    private void addCleanDownloadItem(int r100, CleanDownloadInfo r101, boolean r102) {
        List<Integer> r103 = this.mCleanCacheKeyMaps.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        r103 = new ArrayList();
    L5:
        r103.add(Integer.valueOf(r101.getId()));
        addToCleanDownloadIdSet(r101.getId());
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r100), r103);
        saveFilePath(r101);
        if (r102 == false) goto L9;
        this.mOnlyCleanFileSet.add(Integer.valueOf(r101.getId()));
        return;
    }
}
