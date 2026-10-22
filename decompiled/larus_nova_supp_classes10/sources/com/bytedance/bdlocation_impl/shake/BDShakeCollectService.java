package com.bytedance.bdlocation_impl.shake;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.LocationInfo;
import com.bytedance.bdlocation.network.model.PlaceInfo;
import com.bytedance.bdlocation.network.model.ShakeUploadInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDShakeCollectService {
    private static final String TAG = "UG_LOCATION_SHAKE";
    private static BDShakeCollectService collectService;
    private boolean isStartScanTask;
    private long mLastShakeUploadTime;
    private String mScanBpeaAction;
    private Object scanBpeaCert;
    private BDShakeScanTask shakeScanTask;

    public static /* synthetic */ void a(BDShakeCollectService r0, String r1, JSONObject r2, ShakeUploadCallback r3, Object r4, String r5) {
        r0.lambda$startShakeUpload$0(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void b(ShakeUploadCallback r0) {
        lambda$shakeSuccess$1(r0);
    }

    public static /* synthetic */ void c(BDShakeCollectService r0, boolean r1) {
        r0.lambda$registerBackgroundCallback$3(r1);
    }

    public static /* synthetic */ void d(ShakeUploadCallback r0, BDLocationException r1) {
        lambda$shakeError$2(r0, r1);
    }

    public synchronized void stopScanTask() {
        monitor-enter(this);
        this.isStartScanTask = false;     // Catch: Throwable -> L7
        this.shakeScanTask.stopScan();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private JsonArray getBleInfos() {
        if (this.shakeScanTask.isBlueToothEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mBleInfos;
    }

    public static BDShakeCollectService getInstance() {
        if (collectService != null) goto L15;
        monitor-enter(BDShakeCollectService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (collectService != null) goto L9;
        collectService = new BDShakeCollectService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDShakeCollectService.class);     // Catch: Throwable -> L11
    L15:
        return collectService;
    }

    private JsonArray getWifiInfos() {
        if (this.shakeScanTask.isWifiEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mWifiInfos;
    }

    public BDShakeCollectService() {
        this.isStartScanTask = false;
        this.mLastShakeUploadTime = 0;
        this.scanBpeaCert = null;
        this.mScanBpeaAction = "";
        this.shakeScanTask = new BDShakeScanTask();
        registerBackgroundCallback();
    }

    private void registerBackgroundCallback() {
        BDLocationConfig.getAppBackgroundProvider().addCallback(new d(this));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("", e);
    }

    private LocationInfo getGpsInfo(BDLocation r2) {
        return LocationUtil.bdLocationToLocationInfo(r2, BDLocationConfig.isUploadGPS());
    }

    private long getSubdivisionId(BDLocation r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.getLocationResult() == null) goto L13;
        PlaceInfo[] r5 = r4.getLocationResult().subdivisions;
        if (r5 != null) goto L10;
        return 0;
    L10:
        if (r5.length > 0) goto L12;
        return 0;
    L12:
        return r5[0].geoNameID;
    L13:
        return 0;
    }

    private /* synthetic */ void lambda$registerBackgroundCallback$3(boolean r3) {
        if (this.isStartScanTask == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        Logger.i("enter background");
        this.shakeScanTask.stopScan();
        return;
    L7:
        Logger.i("enter foreground");
        this.shakeScanTask.startScan(this.scanBpeaCert, this.mScanBpeaAction);
    }

    private static /* synthetic */ void lambda$shakeSuccess$1(ShakeUploadCallback r0) {
        r0.onSuccess();
    }

    public void setUploadSource(String r2) {
        this.shakeScanTask.setUploadSource(r2);
    }

    public void shakeSuccess(final ShakeUploadCallback r3) {
        new Handler(Looper.getMainLooper()).post(new c(r3));
    }

    private static /* synthetic */ void lambda$shakeError$2(ShakeUploadCallback r0, BDLocationException r1) {
        r0.onError(r1);
    }

    private boolean refreshShake(String r4, JSONObject r5) {
        ShakeUploadInfo r1 = new ShakeUploadInfo();     // Catch: Exception -> L8
        r1.busiName = r4;     // Catch: Exception -> L8
        if (r5 == null) goto L6;
        r1.extra = (JsonObject) new Gson().fromJson(r5.toString(), JsonObject.class);     // Catch: Exception -> L8
    L6:
        r1.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L8
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake");     // Catch: Exception -> L8
        return ServerApi.uploadShakeInfo(r1, true, 1);
    L8:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake error:" + e);
        return false;
    }

    public void shakeError(final BDLocationException r3, final ShakeUploadCallback r4) {
        new Handler(Looper.getMainLooper()).post(new b(r4, r3));
    }

    public synchronized boolean startScanTask(Object r2, String r3) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (LocationUtil.checkBackground() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.isStartScanTask = true;     // Catch: Throwable -> L12
        this.scanBpeaCert = r2;     // Catch: Throwable -> L12
        this.mScanBpeaAction = r3;     // Catch: Throwable -> L12
        boolean r4 = this.shakeScanTask.startScan(r2, r3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r4;
    }

    private void executeShakeRefresh(String r3, JSONObject r4, ShakeUploadCallback r5) {
        if (refreshShake(r3, r4) == false) goto L5;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo success");
        shakeSuccess(r5);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo error");
        shakeError(new BDLocationException("refresh shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r5);
    }

    private boolean shakeUpload(String r6, BDLocation r7, JSONObject r8) {
        ShakeUploadInfo r2 = new ShakeUploadInfo();     // Catch: Exception -> L17
        r2.busiName = r6;     // Catch: Exception -> L17
        if (r7 == null) goto L7;
        r2.subdivisionId = getSubdivisionId(r7);     // Catch: Exception -> L17
        r2.locationInfo = getGpsInfo(r7);     // Catch: Exception -> L17
    L7:
        if (BDShakeConfig.isShakeUploadWifi() == false) goto L10;
        r2.wifiInfo = getWifiInfos();     // Catch: Exception -> L17
    L10:
        if (BDShakeConfig.isShakeUploadBle() == false) goto L12;
        r2.bleInfo = getBleInfos();     // Catch: Exception -> L17
    L12:
        r2.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L17
        if (r8 == null) goto L15;
        r2.extra = (JsonObject) new Gson().fromJson(r8.toString(), JsonObject.class);     // Catch: Exception -> L17
    L15:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload");     // Catch: Exception -> L17
        return ServerApi.uploadShakeInfo(r2, false, 1);
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload error:" + e);
        return false;
    }

    public void executeShakeUpload(String r3, BDLocation r4, JSONObject r5, ShakeUploadCallback r6) {
        if (shakeUpload(r3, r4, r5) == false) goto L5;
        this.mLastShakeUploadTime = System.currentTimeMillis();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo success");
        shakeSuccess(r6);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo error");
        shakeError(new BDLocationException("upload shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r6);
    }

    public synchronized void startShakeUpload(final Object r9, final String r10, final JSONObject r11, final ShakeUploadCallback r12) {
        monitor-enter(this);
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService startShakeUpload");     // Catch: Throwable -> L13
        if (r9 != null) goto L17;
    L7:
        AppExecutors.getInstance().networkIO().execute(new a(this, r10, r11, r12, r9));     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo check cert error");     // Catch: Throwable -> L13
        shakeError(new BDLocationException("upload shake info check cert error", TAG, BDLocationException.ERROR_SHAKE_BPEA_CERT_CHECK), r12);     // Catch: Throwable -> L13
        goto L11
    L17:
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r9, "startShakeUpload");     // Catch: Exception -> L9 Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startShakeUpload$0(String r17, JSONObject r18, ShakeUploadCallback r19, Object r20, String r21) {
        if ((System.currentTimeMillis() - this.mLastShakeUploadTime) >= BDShakeConfig.getShakeUploadInterval()) goto L18;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refresh data");
        executeShakeRefresh(r17, r18, r19);
        return;
    L18:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService upload data");     // Catch: BDLocationException -> L15
        long r6 = BDShakeConfig.getGpsCacheTime() + 15000;     // Catch: BDLocationException -> L15
        String r1 = "location_shake_upload";
        if (r20 == null) goto L9;
        r1 = BDLocationExtrasService.getBPEAManager().getBpeaToken(r20);     // Catch: BDLocationException -> L15
    L9:
        BDLocation r0 = m84.b.a(getShakeUploadOption(r1, 1, true, 10000, r6, r20, r21));     // Catch: BDLocationException -> L15
        StringBuilder r2 = new StringBuilder("BDShakeCollectService upload location:");     // Catch: BDLocationException -> L15
        if (r0 != null) goto L12;
        String r3 = "";
    L13:
        r2.append(r3);     // Catch: BDLocationException -> L15
        Logger.d(BDShakeConfig.TAG, r2.toString());     // Catch: BDLocationException -> L15
        executeShakeUpload(r17, r0, r18, r19);     // Catch: BDLocationException -> L15
        return;
    L12:
        r3 = r0.toString();     // Catch: BDLocationException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService getLocation error");
        executeShakeUpload(r17, null, r18, r19);
    }

    private LocationOption getShakeUploadOption(String r2, int r3, boolean r4, int r5, long r6, Object r8, String r9) {
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r2);
        r0.setCert(true);
        r0.setMaxCacheTime(r6);
        r0.setTriggerType(r3);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setUpload(r4);
        r0.setLocationTimeOutMs(r5);
        r0.setBpeaCert(r8);
        r0.setBpeaAction(r9);
        r0.setScanBle(false);
        return r0;
    }
}
