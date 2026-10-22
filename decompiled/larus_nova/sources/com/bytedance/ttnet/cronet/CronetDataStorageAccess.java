package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes22.dex */
public class CronetDataStorageAccess extends Observable {
    public static final String LOGID = "logid";
    public static final String REGION_LEGACY_USER = "region_legacy_user";
    public static final String REGION_SOURCE = "region_source";
    public static final String SEC_UID = "sec_uid";
    public static final String STORE_IDC = "store_idc";
    public static final String STORE_REGION = "store_region";
    private static final String TAG = "CronetDataStorageAccess";
    private static volatile CronetDataStorageAccess sInstance = null;
    private static volatile String sRegionLegacyUser = "";
    private static volatile String sRegionSource = "";
    private static volatile String sSecUid = "";
    private static volatile String sUserIdc = "";
    private static volatile String sUserRegion = "";

    public static CronetDataStorageAccess inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetDataStorageAccess.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetDataStorageAccess();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetDataStorageAccess.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public CronetDataStorageAccess() {
    }

    public static String getRegionLegacyUser() {
        return sRegionLegacyUser;
    }

    public static String getRegionSource() {
        return sRegionSource;
    }

    public static String getSecUid() {
        return sSecUid;
    }

    public static String getUserIdc() {
        return sUserIdc;
    }

    public static String getUserRegion() {
        return sUserRegion;
    }

    private void notifyCronetDataObservers(Map<String, Object> r100) {
        setChanged();
        notifyObservers(r100);
    }

    public void onStoreIdcChanged(String r100, String r101, String r102, String r103, String r104, String r105) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onStoreIdcChanged idc: " + r100 + " region: " + r101 + " source: " + r102 + " sec_uid:" + r104 + " logid:" + r105);
    L5:
        sUserIdc = r100;
        sUserRegion = r101;
        sRegionSource = r102;
        sRegionLegacyUser = r103;
        sSecUid = r104;
        HashMap r106 = new HashMap();
        r106.put(STORE_IDC, r100);
        r106.put(STORE_REGION, r101);
        r106.put(REGION_SOURCE, r102);
        r106.put(REGION_LEGACY_USER, r103);
        r106.put("sec_uid", r104);
        r106.put(LOGID, r105);
        notifyCronetDataObservers(r106);
    }
}
