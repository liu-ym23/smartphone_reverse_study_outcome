package com.ss.android.bytedcert.config;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public interface IDownloadConfig {

    public interface IDOwnloadCallback {
        void checkUpdate(boolean r100);

        void updateResult(boolean r100, Throwable r101);
    }

    void clearCache();

    String getModelPath(String r100);

    void init(Context r100, HashMap<String, String> r101);

    void update(Context r100, IDOwnloadCallback r101);
}
