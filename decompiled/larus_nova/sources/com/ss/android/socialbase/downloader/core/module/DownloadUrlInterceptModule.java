package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadUrlInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadUrlInterceptModule";
    private JSONArray mHosts;
    private JSONArray mPaths;
    private JSONArray mPatterns;

    private boolean checkUrlIntercept() {
        String r100 = this.mDownloadInfo.getUrl();
        URL r101 = new URL(r100);     // Catch: MalformedURLException -> L43
        String r102 = r101.getHost();
        String r103 = r101.getPath();
        if (this.mHosts == null) goto L17;
        int r104 = 0;
    L8:
        if (r104 >= this.mHosts.length()) goto L17;
        String r105 = this.mHosts.optString(r104);
        if (TextUtils.isEmpty(r105) == true) goto L15;
        if (r102.equals(r105) == false) goto L15;
        return true;
    L15:
        r104 = r104 + 1;
    L17:
        if (this.mPaths == null) goto L29;
        int r106 = 0;
    L20:
        if (r106 >= this.mPaths.length()) goto L29;
        String r107 = this.mPaths.optString(r106);
        if (TextUtils.isEmpty(r107) == true) goto L27;
        if (r103.equals(r107) == false) goto L27;
        return true;
    L27:
        r106 = r106 + 1;
    L29:
        if (this.mPatterns == null) goto L42;
        int r108 = 0;
    L32:
        if (r108 >= this.mPatterns.length()) goto L42;
        String r109 = this.mPatterns.optString(r108);
        if (TextUtils.isEmpty(r109) == true) goto L41;
        if (Pattern.matches(r109, r100) == false) goto L41;
        return true;
    L39:
        th = move-exception;
        Logger.taskError(TAG, this.mDownloadInfo.getId(), "checkUrlIntercept", "Error:" + th);
    L41:
        r108 = r108 + 1;
    L42:
        return false;
    L43:
        e = move-exception;
        Logger.taskError(TAG, this.mDownloadInfo.getId(), "checkUrlIntercept", "Error:" + e);
        return false;
    }

    public DownloadUrlInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        JSONObject r101 = r100.mSetting.optJSONObject(DownloadSettingKeys.URL_INTERCEPT_CONFIG);
        if (r101 != null) goto L5;
        return null;
    L5:
        this.mHosts = r101.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.HOST_LIST);
        this.mPaths = r101.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.PATH_LIST);
        JSONArray r102 = r101.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.PATTERN_LIST);
        this.mPatterns = r102;
        if (this.mHosts != null) goto L12;
        if (this.mPaths != null) goto L12;
        if (r102 != null) goto L12;
        return null;
    L12:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        if (checkUrlIntercept() == true) goto L7;
        r100.proceed();
        return;
    L7:
        throw new BaseException(1083, "download url intercept");
    }
}
