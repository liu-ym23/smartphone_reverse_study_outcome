package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.content.Context;
import android.util.Pair;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfflineDataManager {
    public static final int DEFAULT_PAGE = 0;
    private static final double MAX_LEN_PERCENT = 1.5d;
    private static final int MEM_CACHE_SIZE = 52428800;
    private static final int NUM_999 = 999;
    private static final String PAGE_RES_DATA_OPEN_FLAG = "page_res_data_clean_flag";
    private static final int PHOTO_CACHE_MAX_COUNT = 800;
    private static final String TAG = "OfflineDataManager";
    private static long sCategoryDeleteTimeout = 5184000000L;
    private static volatile OfflineDataManager sDM;
    private Context mContext;

    private synchronized OfflineDatabase getOfflineDB() {
        monitor-enter(this);
        OfflineDatabase r0 = OfflineDatabase.Companion.getDataBase(Env.getApplication());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static OfflineDataManager get() {
        if (sDM != null) goto L6;
        init(Env.getApplication());
    L6:
        return sDM;
    }

    private OfflineDataManager(Context r1) {
        this.mContext = r1;
    }

    public static void init(Context r2) {
        if (sDM == null) goto L5;
        return;
    L5:
        monitor-enter(OfflineDataManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDM != null) goto L9;
        sDM = new OfflineDataManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OfflineDataManager.class);     // Catch: Throwable -> L11
    }

    public Pair<Long, String> insertResourceData(ResourceData r4) {
        return new Pair(Long.valueOf(getOfflineDB().getResourceDataDao().insertResourceData(r4)), "");
    L4:
        e = move-exception;
        Log r0 = Log.INSTANCE;
        Log.e(TAG, e.getMessage(), e);
        return new Pair(-1L, e.getMessage());
    }

    public int updateResourceData(ResourceData r4) {
        int r5 = getOfflineDB().getResourceDataDao().updateResourceData(r4);     // Catch: Exception -> L7
        if (r5 > 0) goto L6;
        Log r2 = Log.INSTANCE;     // Catch: Exception -> L7
        Log.w(TAG, "Failed to update resource data and the result is " + r5);     // Catch: Exception -> L7
    L6:
        return r5;
    L7:
        e = move-exception;
        Log r1 = Log.INSTANCE;
        Log.e(TAG, e.getMessage(), e);
        return -1;
    }

    public ResourceData loadResourceData(String r2, String r3, int r4) {
        return getOfflineDB().getResourceDataDao().loadResourceData(r3, r2, r4);
    L5:
        return new ResourceData();
    }

    public ResourceData loadSubInfo(String r3, String r4, int r5) {
        ResourceData r0 = new ResourceData();     // Catch: Exception -> L6
        ResourceDataSubInfo r6 = getOfflineDB().getResourceDataDao().loadSubInfo(r4, r3, r5);     // Catch: Exception -> L6
        if (r6 == null) goto L5;
        r0.setId(r6.getId());     // Catch: Exception -> L6
        r0.setSubblock_preload_status(r6.getSubblock_preload_status());     // Catch: Exception -> L6
        r0.setPage(r6.getPage());     // Catch: Exception -> L6
        r0.setTotalPage(r6.getTotalPage());     // Catch: Exception -> L6
    L5:
        return r0;
    L7:
        return new ResourceData();
    }
}
