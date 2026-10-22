package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class TransactionTooLargeOpt {
    private static final String ACTIVITY_HASHCODE_KEY = "TransactionTooLargeOptActivityHashCode";
    private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS = null;
    private static final String ACTIVITY_RECORD_KEY = "TransactionTooLargeOptActivityRecordKey";
    private static final String TAG = "TransactionTooLargeOpt";
    private static List<String> sDisableActivities = null;
    private static boolean sForceClear = false;
    private static final Map<String, Bundle> sKey2ContentMap = null;
    private static ILog sLog = null;
    private static boolean sRestartOnRestore = false;
    private static int sSaveRootBundleSize = 460800;
    private static boolean sStarted;

    public interface ILog {
        void d(String r100, String r101);

        void e(String r100, String r101);
    }

    public TransactionTooLargeOpt() {
    }

    static {
        sDisableActivities = Collections.EMPTY_LIST;
        sForceClear = false;
        sRestartOnRestore = false;
        sKey2ContentMap = new HashMap();
        sLog = new AnonymousClass1();
        ACTIVITY_LIFECYCLE_CALLBACKS = new AnonymousClass2();
    }

    public static /* synthetic */ ILog access$100() {
        return sLog;
    }

    public static /* synthetic */ Map access$400() {
        return sKey2ContentMap;
    }

    public static /* synthetic */ boolean access$000(Activity r100) {
        return isDisable(r100);
    }

    public static /* synthetic */ String access$300(Activity r100) {
        return getActivityKey(r100);
    }

    private static byte[] bundle2Bytes(Bundle r100) {
        Parcel r101 = Parcel.obtain();
        r101.writeBundle(r100);     // Catch: Throwable -> L6
        byte[] r102 = r101.marshall();     // Catch: Throwable -> L6
        r101.recycle();
        return r102;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        r101.recycle();
        return null;
    L10:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    private static int bundleSize(Bundle r100) {
        Parcel r101 = Parcel.obtain();
        r101.setDataPosition(0);     // Catch: Throwable -> L6
        r101.writeBundle(r100);     // Catch: Throwable -> L6
        int r102 = r101.dataSize();     // Catch: Throwable -> L6
        r101.recycle();
        return r102;
    L6:
        th = move-exception;
        sLog.e(TAG, Log.getStackTraceString(th));     // Catch: Throwable -> L10
        r101.recycle();
        return 0;
    L10:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    private static String getActivityKey(Activity r100) {
        return r100.getClass().getName() + "@" + Integer.toHexString(r100.hashCode());
    }

    private static boolean isDisable(Activity r100) {
        String r101 = r100.getClass().getName();
        Iterator<String> r102 = sDisableActivities.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (TextUtils.equals(r102.next(), r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static void restart(Activity r100) {
        Application r101 = r100.getApplication();
        if (r101 != null) goto L6;
        sLog.e(TAG, "application == null");
        return;
    L6:
        Intent r102 = r101.getPackageManager().getLaunchIntentForPackage(r101.getPackageName());
        if (r102 != null) goto L10;
        sLog.e(TAG, "intent == null");
        return;
    L10:
        r100.startActivity(Intent.makeRestartActivityTask(r102.getComponent()));
        sLog.e(TAG, "RestartActivity");
        Runtime.getRuntime().exit(0);
    }

    public static /* synthetic */ void access$200(Activity r100, Bundle r101) {
        restoreRootBundle(r100, r101);
    }

    public static /* synthetic */ void access$500(Activity r100, Bundle r101) {
        saveRootBundle(r100, r101);
    }

    private static Bundle bytes2Bundle(byte[] r100, ClassLoader r101) {
        Parcel r102 = Parcel.obtain();
        r102.unmarshall(r100, 0, r100.length);     // Catch: Throwable -> L6
        r102.setDataPosition(0);     // Catch: Throwable -> L6
        Bundle r103 = r102.readBundle(r101);     // Catch: Throwable -> L6
        r102.recycle();
        return r103;
    L6:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    private static void restoreRootBundle(Activity r100, Bundle r101) {
        Object r102 = r101.get(ACTIVITY_RECORD_KEY);
        if ((r102 instanceof String) == true) goto L17;
        sLog.e(TAG, "restoreRootBundle() uuid = [" + r102 + "]");
        return;
    L17:
        r101.remove(ACTIVITY_RECORD_KEY);     // Catch: Throwable -> L12
        Bundle r103 = sKey2ContentMap.remove(r102);     // Catch: Throwable -> L12
        if (r103 != null) goto L10;
        sLog.d(TAG, "restoreRootBundle() called with: uuid = [" + r102 + "], bundle == null");     // Catch: Throwable -> L12
        if (sRestartOnRestore == false) goto L18;
        restart(r100);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L10:
        r101.putAll(r103);     // Catch: Throwable -> L12
    L14:
        String r104 = r101.getString(ACTIVITY_HASHCODE_KEY);
        sLog.d(TAG, "restoreRootBundle() called with: uuid = [" + r102 + "], activityHashCode=[" + r104 + "]");
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    private static void saveRootBundle(Activity r100, Bundle r101) {
        int r102 = bundleSize(r101);
        if (r102 <= sSaveRootBundleSize) goto L13;
        String r103 = getActivityKey(r100);
        Bundle r104 = new Bundle();     // Catch: Throwable -> L7
        r104.putAll(r101);     // Catch: Throwable -> L7
        sKey2ContentMap.put(r103, r104);     // Catch: Throwable -> L7
        r101.clear();     // Catch: Throwable -> L7
        r101.putString(ACTIVITY_RECORD_KEY, r103);     // Catch: Throwable -> L7
    L9:
        r101.putString(ACTIVITY_HASHCODE_KEY, r103);
        sLog.d(TAG, "saveRootBundle() called with: uuid = [" + r103 + "], size=[" + r102 + "]");
        return;
    L7:
        th = move-exception;
        sLog.e(TAG, Log.getStackTraceString(th));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.putString(ACTIVITY_HASHCODE_KEY, r103);
        throw th;
    L13:
        sLog.d(TAG, "saveRootBundle() called size = [" + r102 + "]");
    }

    public static boolean start(ILog r100, Application r101, int r102, boolean r103, boolean r104, List<String> r105) {
        int r106 = Build.VERSION.SDK_INT;
        if (r106 >= 29) goto L7;
        System.out.println("Ignore for sdk " + r106);
        return false;
    L7:
        if (sStarted == false) goto L10;
        System.out.println("Ignore for already started");
        return false;
    L10:
        sStarted = true;
        sSaveRootBundleSize = r102;
        sForceClear = r103;
        sRestartOnRestore = r104;
        sDisableActivities = r105;
        sLog = r100;
        r101.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
        return true;
    }
}
