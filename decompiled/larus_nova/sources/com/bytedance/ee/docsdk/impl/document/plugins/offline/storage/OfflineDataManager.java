package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.content.Context;
import android.util.Pair;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes18.dex */
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
        OfflineDatabase r100 = OfflineDatabase.Companion.getDataBase(Env.getApplication());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
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

    private OfflineDataManager(Context r100) {
        this.mContext = r100;
    }

    public static void init(Context r100) {
        if (sDM == null) goto L5;
        return;
    L5:
        monitor-enter(OfflineDataManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDM != null) goto L9;
        sDM = new OfflineDataManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OfflineDataManager.class);     // Catch: Throwable -> L11
    }

    public Pair<Long, String> insertResourceData(ResourceData r100) {
        return new Pair(Long.valueOf(getOfflineDB().getResourceDataDao().insertResourceData(r100)), "");
    L4:
        e = move-exception;
        Log r101 = Log.INSTANCE;
        Log.e(TAG, e.getMessage(), e);
        return new Pair(-1L, e.getMessage());
    }

    public int updateResourceData(ResourceData r100) {
        int r101 = getOfflineDB().getResourceDataDao().updateResourceData(r100);     // Catch: Exception -> L7
        if (r101 > 0) goto L6;
        Log r102 = Log.INSTANCE;     // Catch: Exception -> L7
        Log.w(TAG, "Failed to update resource data and the result is " + r101);     // Catch: Exception -> L7
    L6:
        return r101;
    L7:
        e = move-exception;
        Log r103 = Log.INSTANCE;
        Log.e(TAG, e.getMessage(), e);
        return -1;
    }

    public ResourceData loadResourceData(String r100, String r101, int r102) {
        return getOfflineDB().getResourceDataDao().loadResourceData(r101, r100, r102);
    L5:
        return new ResourceData();
    }

    public ResourceData loadSubInfo(String r100, String r101, int r102) {
        ResourceData r103 = new ResourceData();     // Catch: Exception -> L6
        ResourceDataSubInfo r104 = getOfflineDB().getResourceDataDao().loadSubInfo(r101, r100, r102);     // Catch: Exception -> L6
        if (r104 == null) goto L5;
        r103.setId(r104.getId());     // Catch: Exception -> L6
        r103.setSubblock_preload_status(r104.getSubblock_preload_status());     // Catch: Exception -> L6
        r103.setPage(r104.getPage());     // Catch: Exception -> L6
        r103.setTotalPage(r104.getTotalPage());     // Catch: Exception -> L6
    L5:
        return r103;
    L7:
        return new ResourceData();
    }
}
