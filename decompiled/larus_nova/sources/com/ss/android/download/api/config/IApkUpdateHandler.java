package com.ss.android.download.api.config;

import com.ss.android.socialbase.downloader.exception.BaseException;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IApkUpdateHandler {
    JSONObject getApkUpdateConfig(String r100);

    void tryApkUpdate(String r100, String r101, File r102, JSONObject r103) throws BaseException;
}
