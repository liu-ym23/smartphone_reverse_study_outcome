package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class ComplianceResultCache extends LruCache<Long, ComplianceResult> {
    private static volatile ComplianceResultCache INSTANCE;

    private ComplianceResultCache() {
        super(16, 16);
    }

    public static ComplianceResultCache getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(ComplianceResultCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new ComplianceResultCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ComplianceResultCache.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public static long getResultId(String r100) {
        String r101 = DownloadUtils.md5Hex(r100);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return 0;
    L7:
        return r101.hashCode();
    }

    public ComplianceResult.AuthInfo getAuthInfo(long r100) {
        if (getComplianceResult(r100) != null) goto L7;
        return null;
    L7:
        return getComplianceResult(r100).getAuthInfo();
    }

    public long getCId(long r100) {
        if (getComplianceResult(r100) != null) goto L7;
        return 0;
    L7:
        return getComplianceResult(r100).getId();
    }

    public ComplianceResult getComplianceResult(long r100) {
        return get(Long.valueOf(r100));
    }

    public void removeComplianceResult(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        remove(Long.valueOf(getResultId(r100)));
    }

    @Override // com.ss.android.socialbase.downloader.utils.LruCache, java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Long, ComplianceResult> r100) {
        return super.removeEldestEntry(r100);
    }

    public ComplianceResult getComplianceResult(String r100) {
        return getComplianceResult(getResultId(r100));
    }

    public void putComplianceResult(String r100, ComplianceResult r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        put(Long.valueOf(getResultId(r100)), r101);
        return;
    }
}
