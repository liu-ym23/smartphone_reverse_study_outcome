package com.ss.android.ugc.effectmanager;

import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadableModelSupportResourceFinder {
    public DownloadableModelSupportResourceFinder() {
    }

    public long getNativeResourceFinder() {
        return AlgorithmResourceManager.getInstance().getResourceFinder().getNativeResourceFinder();
    }

    public static String findResourceUri(String r100, String r101) {
        return AlgorithmResourceManager.getInstance().getResourceFinder().realFindResourceUri(0, r100, r101);
    }
}
