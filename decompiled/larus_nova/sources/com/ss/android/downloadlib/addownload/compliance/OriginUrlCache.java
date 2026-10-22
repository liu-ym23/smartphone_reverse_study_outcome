package com.ss.android.downloadlib.addownload.compliance;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.model.SharedPrefsManager;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class OriginUrlCache extends LruCache<String, String> {
    public static volatile OriginUrlCache INSTANCE = null;
    private static final String SP_ORIGIN_URL = "sp_origin_url";

    private OriginUrlCache() {
        super(16, 16);
        Iterator<Map.Entry<String, ?>> r100 = SharedPrefsManager.getSpByName(SP_ORIGIN_URL, 0).getAll().entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<String, ?> r101 = r100.next();
        if (r101.getValue() == null) goto L4;
        put(r101.getKey(), String.valueOf(r101.getValue()));
        goto L4
    }

    public static OriginUrlCache getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(OriginUrlCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new OriginUrlCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OriginUrlCache.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public String getNewUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        return get(r100);
    }

    public String getOriginUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        LinkedHashSet r101 = new LinkedHashSet(keySet());
        if (r101.isEmpty() == true) goto L13;
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        if (r100.equals(get(r103)) == false) goto L9;
        return r103;
    L13:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.utils.LruCache, java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, String> r100) {
        SharedPreferences.Editor r101 = SharedPrefsManager.getSpByName(SP_ORIGIN_URL, 0).edit();
        r101.remove(r100.getKey());
        r101.apply();
        return super.removeEldestEntry(r100);
    }

    public synchronized void putOriginUrl(String r100, String r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        put(r100, r101);     // Catch: Throwable -> L10
        SharedPreferences.Editor r102 = SharedPrefsManager.getSpByName(SP_ORIGIN_URL, 0).edit();     // Catch: Throwable -> L10
        r102.putString(r100, r101);     // Catch: Throwable -> L10
        r102.apply();     // Catch: Throwable -> L10
        goto L8
    }
}
