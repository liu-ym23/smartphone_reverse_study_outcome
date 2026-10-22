package com.ss.android.socialbase.downloader.setting;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadSetting {
    private static final int POOL_SIZE = 16;
    private static final String TAG = "DownloadSetting";
    private static final LruCache<Integer, DownloadSetting> sCache = null;
    private static JSONObject sDisabledTaskKeys;
    private static final DownloadSetting sGlobal = null;
    private static Boolean sGlobalBugFixDefault;
    private static JSONObject sGlobalBugFixSetting;
    private static JSONObject sGlobalTaskSetting;
    private static DownloadSetting sLastSetting;
    private static boolean sTaskSettingDisabled;
    private final Boolean mBugFixDefault;
    private final JSONObject mBugFixSetting;
    private int mDownloadId;
    private final JSONObject mTaskSetting;

    static {
        sCache = new LruCache(16, 16);
        sGlobal = new DownloadSetting(null);
        boolean r100 = DownloadUtils.isEnableDownloadSettingInit();
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "construct", "EnableDownloadSettingInit:" + r100);
    L5:
        if (r100 == false) goto L8;
        init();
        return;
    }

    public static JSONObject getGlobalSettings() {
        return ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
    }

    public static void init() {
        JSONObject r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadSetting();
        boolean r101 = false;
        if (r100.optInt(DownloadSettingKeys.DISABLE_TASK_SETTING, 0) != 1) goto L5;
        boolean r102 = true;
    L6:
        sTaskSettingDisabled = r102;
        sDisabledTaskKeys = r100.optJSONObject(DownloadSettingKeys.DISABLED_TASK_KEYS);
        sGlobalTaskSetting = r100.optJSONObject(DownloadSettingKeys.GLOBAL_TASK_SETTING);
        JSONObject r103 = r100.optJSONObject(DownloadSettingKeys.BUG_FIX);
        if (r103 != null) goto L9;
    L14:
        Boolean r104 = null;
    L15:
        sGlobalBugFixSetting = r103;
        sGlobalBugFixDefault = r104;
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "init", "SettingUpdate:" + r100.toString());
        return;
    L19:
        return;
    L9:
        if (r103.has("default") == false) goto L14;
        if (r103.optInt("default", 0) != 1) goto L13;
        r101 = true;
    L13:
        r104 = Boolean.valueOf(r101);
        goto L15
    L5:
        r102 = false;
        goto L6
    }

    public String toString() {
        return "DownloadSetting{mTaskSetting=" + this.mTaskSetting + ", mBugFixSetting=" + this.mBugFixSetting + ", mBugFixDefault=" + this.mBugFixDefault + ", mDownloadId=" + this.mDownloadId + ", globalSetting=" + getGlobalSettings() + '}';
    L5:
        th = move-exception;
        Logger.globalError(TAG, "toString", "Error:" + th);
        return "DownloadSetting Error";
    }

    public static JSONObject getGlobalTaskSettings() {
        return sGlobalTaskSetting;
    }

    public static DownloadSetting obtainGlobal() {
        return sGlobal;
    }

    private DownloadSetting(JSONObject r100) {
        this.mTaskSetting = r100;
        JSONObject r101 = null;
        Boolean r102 = null;
        r102 = null;
        r102 = null;
        if (r100 != null) goto L5;
    L17:
        Boolean r103 = null;
    L18:
        this.mBugFixSetting = r101;
        this.mBugFixDefault = r103;
        return;
    L5:
        if (isTaskKeyDisabled(DownloadSettingKeys.BUG_FIX) == true) goto L17;
        JSONObject r104 = r100.optJSONObject(DownloadSettingKeys.BUG_FIX);
        if (r104 != null) goto L9;
    L16:
        Boolean r105 = r102;
        r101 = r104;
        r103 = r105;
        goto L18
    L9:
        if (r104.has("default") == false) goto L16;
        if (isTaskKeyDisabled("default") == true) goto L16;
        boolean r106 = false;
        if (r104.optInt("default", 0) != 1) goto L15;
        r106 = true;
    L15:
        r102 = Boolean.valueOf(r106);
        goto L16
    }

    private static DownloadSetting create(DownloadInfo r100) {
        if (sTaskSettingDisabled == true) goto L5;
        String r101 = r100.getDownloadSettingString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == true) goto L9;
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L14
    L10:
        JSONObject r103 = mergeGlobalTaskSetting(r102, r100.getMonitorScene());     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        return new DownloadSetting(r103);
    L17:
        return sGlobal;
    L9:
        r102 = null;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L5:
        return sGlobal;
    }

    public static boolean isTaskKeyDisabled(String r100) {
        JSONObject r101 = sDisabledTaskKeys;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.optInt(r100, 0) != 1) goto L7;
        return true;
    }

    private static boolean matchSceneTaskSetting(String r100) {
        if (sGlobalTaskSetting != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (sGlobalTaskSetting.has(r100) == false) goto L9;
        return true;
    }

    public static DownloadSetting obtain(JSONObject r100) {
        if (r100 == null) goto L30;
        if (r100 == getGlobalSettings()) goto L30;
        if (sTaskSettingDisabled == true) goto L30;
        DownloadSetting r101 = sLastSetting;
        if (r101 != null) goto L11;
    L13:
        LruCache<Integer, DownloadSetting> r102 = sCache;
        monitor-enter(r102);
        Iterator<DownloadSetting> r103 = r102.values().iterator();     // Catch: Throwable -> L26
    L17:
        if (r103.hasNext() == false) goto L23;
        DownloadSetting r104 = r103.next();     // Catch: Throwable -> L26
        if (r104.mTaskSetting != r100) goto L17;
        sLastSetting = r104;     // Catch: Throwable -> L26
        monitor-exit(r102);     // Catch: Throwable -> L26
        return r104;
    L23:
        monitor-exit(r102);     // Catch: Throwable -> L26
        DownloadSetting r105 = new DownloadSetting(r100);
        sLastSetting = r105;
        return r105;
    L26:
        th = move-exception;
        throw th;
    L11:
        if (r101.mTaskSetting != r100) goto L13;
        return r101;
    L30:
        return sGlobal;
    }

    public static void removeTaskDownloadSetting(int r100) {
        DownloadSetting r101 = sLastSetting;
        if (r101 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r102 = sCache;
        monitor-enter(r102);
        r102.remove(Integer.valueOf(r100));     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r101.mDownloadId != r100) goto L7;
        sLastSetting = null;
        goto L7
    }

    public boolean has(String r100) {
        if (this.mTaskSetting == null) goto L9;
        if (isTaskKeyDisabled(r100) == true) goto L9;
        return this.mTaskSetting.has(r100);
    L9:
        return getGlobalSettings().has(r100);
    }

    public Object opt(String r100) {
        JSONObject r101 = this.mTaskSetting;
        if (r101 == null) goto L11;
        if (r101.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.opt(r100);
    L11:
        return getGlobalSettings().opt(r100);
    }

    public boolean optBoolean(String r100) {
        return optBoolean(r100, false);
    }

    public boolean optBugFix(String r100) {
        return optBugFix(r100, false);
    }

    public double optDouble(String r100) {
        return optDouble(r100, Double.NaN);
    }

    public int optInt(String r100) {
        return optInt(r100, 0);
    }

    public JSONArray optJSONArray(String r100) {
        JSONObject r101 = this.mTaskSetting;
        if (r101 == null) goto L11;
        if (r101.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optJSONArray(r100);
    L11:
        return getGlobalSettings().optJSONArray(r100);
    }

    public JSONObject optJSONObject(String r100) {
        JSONObject r101 = this.mTaskSetting;
        if (r101 == null) goto L11;
        if (r101.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optJSONObject(r100);
    L11:
        return getGlobalSettings().optJSONObject(r100);
    }

    public long optLong(String r100) {
        return optLong(r100, 0);
    }

    public String optString(String r100) {
        return optString(r100, "");
    }

    private static DownloadSetting create(int r100) {
        if (sTaskSettingDisabled == false) goto L7;
        return sGlobal;
    L7:
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext() == null) goto L13;
        DownloadInfo r101 = ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(r100);
        if (r101 == null) goto L13;
        return create(r101);
    L13:
        return sGlobal;
    }

    public static DownloadSetting obtain(DownloadInfo r100) {
        if (r100 != null) goto L6;
        return sGlobal;
    L6:
        return obtain(r100.getId(), r100);
    }

    public static DownloadSetting obtain(int r100) {
        return obtain(r100, null);
    }

    public static void addTaskDownloadSetting(int r100, JSONObject r101) {
        addTaskDownloadSetting(r100, null, r101);
    }

    private static JSONObject mergeGlobalTaskSetting(JSONObject r100, String r101) {
    L18:
        th = move-exception;
        Logger.globalError(TAG, "mergeGlobalTaskSetting", "Error:" + th + " " + r101);
    L20:
        return null;
    L4:
        if (matchSceneTaskSetting(r101) == false) goto L6;
        JSONObject r102 = sGlobalTaskSetting.optJSONObject(r101);     // Catch: Throwable -> L18
    L7:
        if (r100 == null) goto L14;
        if (r102 == null) goto L14;
        Iterator<String> r103 = r102.keys();     // Catch: Throwable -> L18
    L10:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();     // Catch: Throwable -> L18
        r100.put(r104, r102.get(r104));     // Catch: Throwable -> L18
    L14:
        if (r100 == null) goto L16;
        return r100;
    L16:
        if (r102 == null) goto L20;
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    private static DownloadSetting obtain(int r100, DownloadInfo r101) {
        DownloadSetting r102 = sLastSetting;
        if (r102 != null) goto L5;
    L7:
        LruCache<Integer, DownloadSetting> r103 = sCache;
        monitor-enter(r103);
        DownloadSetting r104 = r103.get(Integer.valueOf(r100));     // Catch: Throwable -> L25
        monitor-exit(r103);     // Catch: Throwable -> L25
        if (r104 != null) goto L23;
        if (r101 != null) goto L14;
        DownloadSetting r105 = create(r100);
    L15:
        r104 = r105;
        monitor-enter(r103);
        r103.put(Integer.valueOf(r100), r104);     // Catch: Throwable -> L20
        monitor-exit(r103);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L14:
        r105 = create(r101);
    L23:
        r104.mDownloadId = r100;
        sLastSetting = r104;
        return r104;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r102.mDownloadId != r100) goto L7;
        return r102;
    }

    public static void setGlobalBugFix(String r100, boolean r101) {
        if (sGlobalBugFixSetting != null) goto L5;
        sGlobalBugFixSetting = new JSONObject();     // Catch: JSONException -> L11
    L5:
        JSONObject r102 = sGlobalBugFixSetting;     // Catch: JSONException -> L11
        if (r101 == false) goto L8;
        int r103 = 1;
    L9:
        r102.put(r100, r103);     // Catch: JSONException -> L11
        return;
    L8:
        r103 = 0;
    }

    public boolean optBoolean(String r100, boolean r101) {
        JSONObject r102 = this.mTaskSetting;
        if (r102 == null) goto L11;
        if (r102.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optBoolean(r100, r101);
    L11:
        return getGlobalSettings().optBoolean(r100, r101);
    }

    public boolean optBugFix(String r100, boolean r101) {
        if (this.mBugFixSetting != null) goto L5;
    L16:
        JSONObject r102 = sGlobalBugFixSetting;
        if (r102 != null) goto L19;
    L28:
        return r101;
    L19:
        if (r102.has(r100) == true) goto L21;
        Boolean r103 = sGlobalBugFixDefault;
        if (r103 == null) goto L28;
        return r103.booleanValue();
    L21:
        if (sGlobalBugFixSetting.optInt(r100, r101 ? 1 : 0) != 1) goto L30;
        return true;
    L30:
        return false;
    L5:
        if (isTaskKeyDisabled(r100) == true) goto L16;
        if (this.mBugFixSetting.has(r100) == true) goto L9;
        Boolean r104 = this.mBugFixDefault;
        if (r104 == null) goto L16;
        return r104.booleanValue();
    L9:
        if (this.mBugFixSetting.optInt(r100, r101 ? 1 : 0) != 1) goto L29;
        return true;
    L29:
        return false;
    }

    public double optDouble(String r100, double r101) {
        JSONObject r102 = this.mTaskSetting;
        if (r102 == null) goto L11;
        if (r102.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optDouble(r100, r101);
    L11:
        return getGlobalSettings().optDouble(r100, r101);
    }

    public int optInt(String r100, int r101) {
        JSONObject r102 = this.mTaskSetting;
        if (r102 == null) goto L11;
        if (r102.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optInt(r100, r101);
    L11:
        return getGlobalSettings().optInt(r100, r101);
    }

    public long optLong(String r100, long r101) {
        JSONObject r102 = this.mTaskSetting;
        if (r102 == null) goto L11;
        if (r102.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optLong(r100, r101);
    L11:
        return getGlobalSettings().optLong(r100, r101);
    }

    public String optString(String r100, String r101) {
        JSONObject r102 = this.mTaskSetting;
        if (r102 == null) goto L11;
        if (r102.has(r100) == false) goto L11;
        if (isTaskKeyDisabled(r100) == true) goto L11;
        return this.mTaskSetting.optString(r100, r101);
    L11:
        return getGlobalSettings().optString(r100, r101);
    }

    public static void addTaskDownloadSetting(int r100, String r101, JSONObject r102) {
        JSONObject r103 = mergeGlobalTaskSetting(r102, r101);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103 != getGlobalSettings()) goto L7;
        return;
    L7:
        if (sTaskSettingDisabled == true) goto L40;
        LruCache<Integer, DownloadSetting> r104 = sCache;
        monitor-enter(r104);
        DownloadSetting r105 = sLastSetting;     // Catch: Throwable -> L30
        if (r105 != null) goto L14;
    L16:
        Iterator<DownloadSetting> r106 = r104.values().iterator();     // Catch: Throwable -> L30
    L18:
        if (r106.hasNext() == false) goto L22;
        DownloadSetting r107 = r106.next();     // Catch: Throwable -> L30
        if (r107.mTaskSetting != r103) goto L18;
        r107.mDownloadId = r100;     // Catch: Throwable -> L30
    L23:
        if (r107 != null) goto L25;
        r105 = new DownloadSetting(r103);     // Catch: Throwable -> L30
        r105.mDownloadId = r100;     // Catch: Throwable -> L30
    L26:
        sLastSetting = r105;     // Catch: Throwable -> L30
    L27:
        sCache.put(Integer.valueOf(r100), r105);     // Catch: Throwable -> L30
        monitor-exit(r104);     // Catch: Throwable -> L30
        return;
    L25:
        r105 = r107;
        goto L26
    L22:
        r107 = null;
        goto L23
    L14:
        if (r105.mTaskSetting != r103) goto L16;
        r105.mDownloadId = r100;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
