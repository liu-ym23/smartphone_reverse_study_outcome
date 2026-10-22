package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadTaskKeyManager {
    private static final String TAG = null;
    private final ConcurrentHashMap<String, String> urls;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.DownloadTaskKeyManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingleTonHolder {
        private static DownloadTaskKeyManager INSTANCE;

        public SingleTonHolder() {
        }

        static {
            INSTANCE = new DownloadTaskKeyManager(null);
        }

        public static /* synthetic */ DownloadTaskKeyManager access$100() {
            return INSTANCE;
        }
    }

    static {
        TAG = "DownloadTaskKeyManager";
    }

    private void printUrls() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r101 = this.urls.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, String> r102 = r101.next();
        r100.append(r102.getKey());
        r100.append(":");
        r100.append(r102.getValue());
        r100.append(",");
        goto L4
    L7:
        if (r100.length() <= 0) goto L9;
        TTDownloaderLogger.INSTANCE.innerLogD("OrderDownload", "printUrls", "当前存储的数据为:" + r100.substring(0, r100.length() - 1));
        return;
    L9:
        TTDownloaderLogger.INSTANCE.innerLogD("OrderDownload", "printUrls", "当前还没有记录url和taskkey的映射记录");
    }

    private DownloadTaskKeyManager() {
        this.urls = new ConcurrentHashMap();
    }

    public static DownloadTaskKeyManager getInstance() {
        return SingleTonHolder.access$100();
    }

    public /* synthetic */ DownloadTaskKeyManager(AnonymousClass1 r100) {
        this();
    }

    private String parseGameStationObj(JSONObject r100) {
        String r101 = r100.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return r101;
    }

    private String parseOrderDownloadObj(JSONObject r100) {
        String r101 = r100.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.FILTERED_DOWNLOAD_URL);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "parseOrderDownloadObj", "未获取到需要的参数,不符合预期");
        return "";
    }

    public boolean checkEnableTaskKeyForOrderDownload(DownloadModel r100) {
        if ((r100 instanceof AdDownloadModel) == true) goto L5;
        return false;
    L5:
        if (r100.getExtra() == null) goto L13;
        JSONObject r101 = r100.getExtra();
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "checkEnableTaskKeyForOrderDownload", "DownloadModel中传递的extra信息为:" + r101);
        if (r101 != null) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r101.optString("biz"), AdBaseConstants.BOOKING_OFFICIAL_NOTIFICATION) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public String getDownloadTaskKey(AdDownloadModel r100) {
        printUrls();
        String r101 = parseTaskKeyObject(r100.getTaskKeyObject(), r100.getTaskKeyCallScene());
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        return DownloadUtils.md5Hex(r101 + r100.getTaskKeyCallScene());
    }

    public String getTaskKeyByUrl(String r100) {
        printUrls();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.urls.isEmpty() == false) goto L9;
        return null;
    L9:
        if (checkValueExist(this.urls.keySet(), r100) == true) goto L12;
        return null;
    L12:
        return this.urls.get(r100);
    }

    public void unBindMapByTaskKey(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Iterator<String> r101 = this.urls.keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        if (TextUtils.equals(this.urls.get(r102), r100) == false) goto L7;
        this.urls.remove(r102);
        printUrls();
        goto L7
    }

    public void unbindMapByUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (checkValueExist(this.urls.keySet(), r100) == false) goto L9;
        this.urls.remove(r100);
        printUrls();
        return;
    }

    public boolean whetherTaskKey(String r100) {
        if (r100.contains("https") == false) goto L5;
        return false;
    L5:
        if (r100.contains("http") == true) goto L11;
        return true;
    L11:
        return false;
    }

    public String getDownloadTaskKey(String r100) {
        String r101 = DownloadUtils.md5Hex("1000" + ToolUtils.getFilteredDownloadUrl(r100));
        if (this.urls.containsValue(r101) == false) goto L5;
        return r101;
    L5:
        return null;
    }

    private boolean checkValueExist(Set<String> r100, String r101) {
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (TextUtils.equals(r102.next(), r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void addDownloadUrlToTaskKey(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (checkValueExist(this.urls.keySet(), r101) == true) goto L12;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "addDownloadUrlToTaskKey", "添加下载链接与taskkey的映射关系");
        this.urls.put(r101, r100);
        printUrls();
        return;
    }

    public String getDownloadTaskKey(int r100, JSONObject r101) {
        String r102 = parseTaskKeyObject(r101, r100);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return null;
    L5:
        return DownloadUtils.md5Hex(r102 + r100);
    }

    public String parseTaskKeyObject(JSONObject r100, int r101) {
        if (r100 != null) goto L4;
    L10:
        return "";
    L4:
        if (r101 == 11) goto L13;
        if (r101 != 1000) goto L10;
        return parseOrderDownloadObj(r100);
    L13:
        return parseGameStationObj(r100);
    }
}
