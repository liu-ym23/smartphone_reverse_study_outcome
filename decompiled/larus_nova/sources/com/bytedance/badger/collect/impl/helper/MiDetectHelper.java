package com.bytedance.badger.collect.impl.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectCallback;
import com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class MiDetectHelper {
    public static final String DOUYIN_APP_ID = "2882303761517509924";
    public static final String DOUYIN_APP_KEY = "5571750917924";
    private static final long SERVICE_WAIT_TIMEOUT = 8000;
    private static final String TAG = "MiDetectHelper# ";
    private static final Set<Map.Entry<DetectCallback, IMiSafetyDetectCallback.Stub>> mAidlCallbackRef = null;
    private static String mAppId = "";
    private static String mAppKey = "";
    private static Throwable mBindServiceError;
    private static volatile boolean mBinding;
    private static volatile boolean mBound;
    private static Context mContext;
    private static volatile IMiSafetyDetectServer mSafetyDetectServer;
    private static final ServiceConnection mSafetyServiceConn = null;
    private static final Object serviceBindLock = null;

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.helper.MiDetectHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        private void handleBinderDied() {
            MiDetectHelper.access$202(false);
            MiDetectHelper.access$302(false);
            MiDetectHelper.access$002(null);
        }

        public static /* synthetic */ void access$100(AnonymousClass1 r100) {
            r100.handleBinderDied();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            MiDetectHelper.access$202(false);
            MiDetectHelper.access$302(false);
            MiDetectHelper.access$002(null);
            Object r101 = MiDetectHelper.access$400();
            monitor-enter(r101);
            MiDetectHelper.access$400().notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, final IBinder r101) {
            ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC28771(this, r101), "MiDetectHelper$1"));
        }
    }

    public static class BindServiceException extends RuntimeException {
        public BindServiceException(String r100) {
            super(r100);
        }

        public BindServiceException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public interface DetectCallback {
        void onFailure(Throwable r100);

        void onResult(String r100, int r101);
    }

    public MiDetectHelper() {
    }

    static {
        serviceBindLock = new Object();
        mBinding = false;
        mBound = false;
        mSafetyDetectServer = null;
        mSafetyServiceConn = new AnonymousClass1();
        mAidlCallbackRef = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    private static JSONObject getCommonParamsJson() {
        JSONObject r100 = new JSONObject();
        r100.put("PACKAGE_NAME", mContext.getPackageName());     // Catch: JSONException -> L5
        r100.put("APP_KEY", mAppKey);     // Catch: JSONException -> L5
        r100.put("APP_ID", mAppId);     // Catch: JSONException -> L5
    L4:
        return r100;
    }

    private static String getCommonParams() {
        return getCommonParamsJson().toString();
    }

    public static /* synthetic */ IMiSafetyDetectServer access$000() {
        return mSafetyDetectServer;
    }

    public static /* synthetic */ Object access$400() {
        return serviceBindLock;
    }

    public static /* synthetic */ Set access$500() {
        return mAidlCallbackRef;
    }

    public static /* synthetic */ IMiSafetyDetectServer access$002(IMiSafetyDetectServer r100) {
        mSafetyDetectServer = r100;
        return r100;
    }

    public static /* synthetic */ boolean access$202(boolean r100) {
        mBound = r100;
        return r100;
    }

    public static /* synthetic */ boolean access$302(boolean r100) {
        mBinding = r100;
        return r100;
    }

    public static IMiSafetyDetectCallback.Stub asAidlCallback(final DetectCallback r100) {
        IMiSafetyDetectCallback.Stub r101 = new AnonymousClass2(r100);
        mAidlCallbackRef.add(new AbstractMap.SimpleImmutableEntry(r100, r101));
        return r101;
    }

    private static boolean bindMiSafetyService(Context r100) {
        if (mBound == false) goto L13;
        return true;
    L13:
        mBinding = true;     // Catch: Exception -> L10
        Intent r101 = new Intent("com.xiaomi.security.xsof.SAFETY_DETECT_SERVICE");     // Catch: Exception -> L10
        r101.setPackage("com.miui.securitycenter");     // Catch: Exception -> L10
        mBound = r100.bindService(r101, mSafetyServiceConn, 1);     // Catch: Exception -> L10
        if (mBound == false) goto L9;
        return true;
    L9:
        throw new BindServiceException("bind service failed");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        mBinding = false;
        mBindServiceError = e;
        mBound = false;
        mSafetyDetectServer = null;
        return false;
    }

    public static void getRiskApps(DetectCallback r100) {
        if (mContext != null) goto L6;
        return;
    L6:
        if (waitForBindService(r100) == true) goto L9;
        return;
    L9:
        if (mSafetyDetectServer != null) goto L16;
        r100.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L16:
        mSafetyDetectServer.getRiskAppList(getCommonParams(), asAidlCallback(r100));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        r100.onFailure(th);
    }

    public static int getSafetyDetectServerVersion(Context r100) {
        Bundle r101 = r100.getPackageManager().getPackageInfo("com.miui.securitycenter", 128).applicationInfo.metaData;     // Catch: Exception -> L10
        if (r101 == null) goto L9;
        if (r101.containsKey("com.xiaomi.security.xsof.service.version") == false) goto L9;
        return r101.getInt("com.xiaomi.security.xsof.service.version");
    L9:
        return 0;
    }

    public static void release(Context r100) {
        unbindMiSafetyService(r100);
    }

    private static void unbindMiSafetyService(Context r100) {
        if (mBound == false) goto L10;
        r100.unbindService(mSafetyServiceConn);     // Catch: Exception -> L7
    L5:
        mBound = false;
        return;
    }

    private static boolean waitForBindService(DetectCallback r100) {
        if (mBinding == false) goto L19;
        Object r101 = serviceBindLock;
        monitor-enter(r101);
        r101.wait(8000);     // Catch: Throwable -> L10 InterruptedException -> L12
        monitor-exit(r101);     // Catch: Throwable -> L10
        goto L19
    L12:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L10
        r100.onFailure(new BindServiceException("wait for bind service interrupted", e));     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    L19:
        if (mBound == true) goto L22;
        r100.onFailure(new BindServiceException("bind service failed after timeout", mBindServiceError));
        return false;
    L22:
        return true;
    }

    public static void getSimulatedTouchDetectResult(long r100, DetectCallback r101) {
        if (waitForBindService(r101) == true) goto L6;
        return;
    L6:
        if (mSafetyDetectServer != null) goto L13;
        r101.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L13:
        mSafetyDetectServer.getSimulatedTouchResult(getCommonParams(), r100, asAidlCallback(r101));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        r101.onFailure(th);
    }

    public static void getTrustDeviceStatus(String r100, DetectCallback r101) {
        getTrustDeviceStatus(2, r100, r101);
    }

    public static void getTrustDeviceStatus(int r100, String r101, DetectCallback r102) {
        if (mContext != null) goto L6;
        return;
    L6:
        if (waitForBindService(r102) == true) goto L8;
        return;
    L8:
        String r103 = getCommonParams();
        if (mSafetyDetectServer != null) goto L16;
        r102.onFailure(new BindServiceException("service is null", mBindServiceError));
        return;
    L16:
        mSafetyDetectServer.getTrustDeviceStatusInfo(r103, r101, r100, asAidlCallback(r102));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        r102.onFailure(th);
    }

    public static synchronized boolean init(Context r100, String r101, String r102) {
        monitor-enter(MiDetectHelper.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mContext != null) goto L8;
        mContext = r100.getApplicationContext();     // Catch: Throwable -> L16
    L8:
        if (TextUtils.isEmpty(mAppId) == false) goto L11;
        mAppId = r101;     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(mAppKey) == false) goto L13;
        mAppKey = r102;     // Catch: Throwable -> L16
    L13:
        boolean r103 = bindMiSafetyService(mContext);     // Catch: Throwable -> L16
        monitor-exit(MiDetectHelper.class);
        return r103;
    }
}
