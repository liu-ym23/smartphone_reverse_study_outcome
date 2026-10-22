package com.ss.android.lark.utils;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes38.dex */
public class PackageChannelManager {
    private static final String CI_DEPLOY_MODE_HOSTED = "hosted";
    private static final String CI_DEPLOY_MODE_ON_PREMISE = "on-premise";
    private static final String CI_DEPLOY_MODE_SAAS = "saas";
    private static final String DEFAULT_CHANNEL = "normal";
    private static final boolean DEFAULT_IS_KA = false;
    private static final String DEFAULT_LOCAL_CHANNEL = "local";
    private static final String META_DATA_KEY_DEPLOY_MODE = "DEPLOY_MODE";
    private static final String TAG = "PackageChannelManager";
    private static String sPangolinChannel;
    private static String sStoredChannelName;
    private static Integer sStoredDeployMode;
    private static Boolean sStoredIsKAPackage;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeployMode {
        public static final int HOSTED = 2;
        public static final int ON_PREMISE = 3;
        public static final int SAAS = 1;
    }

    public PackageChannelManager() {
    }

    public static String getBuildPackageChannel(Context r110) {
        if (TextUtils.isEmpty(sStoredChannelName) == true) goto L7;
        return sStoredChannelName;
    L7:
        if (r110 != null) goto L31;
        Log.i(TAG, "getBuildPackageChannel: context is null");
        return "normal";
    L31:
        long r100 = System.nanoTime();     // Catch: Exception -> L27
        String r101 = o87.c.a(r110);     // Catch: Exception -> L27
        Log.i(TAG, "pangolin channel = " + r101 + ", cost nano: " + (System.nanoTime() - r100));     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r101) == true) goto L14;
        sStoredChannelName = r101;     // Catch: Exception -> L27
        return r101;
    L14:
        long r102 = System.nanoTime();     // Catch: Exception -> L27
        lac.b r103 = lac.e.a(r110);     // Catch: Exception -> L27
        if (r103 == null) goto L17;
        r101 = r103.f508247a;     // Catch: Exception -> L27
    L17:
        Log.i(TAG, "walle channel = " + r101 + ", cost nano: " + (System.nanoTime() - r102));     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r101) == true) goto L21;
        sStoredChannelName = r101;     // Catch: Exception -> L27
        return r101;
    L21:
        String r111 = r110.getPackageManager().getApplicationInfo(r110.getPackageName(), 128).metaData.getString("LARK_RELEASE_CHANNEL", "normal");     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r111) == true) goto L25;
        sStoredChannelName = r111;     // Catch: Exception -> L27
        return r111;
    L25:
        sStoredChannelName = "normal";     // Catch: Exception -> L27
    L30:
        return sStoredChannelName;
    L27:
        e = move-exception;
        Log.e(TAG, e);
        goto L30
    }

    public static int getDeployMode(Context r100) {
        Integer r101 = sStoredDeployMode;
        if (r101 == null) goto L21;
        return r101.intValue();
    L21:
        String r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.getString(META_DATA_KEY_DEPLOY_MODE, null);     // Catch: Exception -> L18
        if ("saas".equals(r102) == false) goto L11;
    L9:
        int r103 = 1;
    L16:
        Integer r104 = Integer.valueOf(r103);     // Catch: Exception -> L18
        sStoredDeployMode = r104;     // Catch: Exception -> L18
        return r104.intValue();
    L11:
        if (CI_DEPLOY_MODE_HOSTED.equals(r102) == false) goto L14;
        r103 = 2;
        goto L16
    L14:
        if (CI_DEPLOY_MODE_ON_PREMISE.equals(r102) == false) goto L9;
        r103 = 3;
    L18:
        e = move-exception;
        Log.e(TAG, e);
        return 1;
    }

    public static String getPangolinChannel(Context r100) {
        if (TextUtils.isEmpty(sPangolinChannel) == false) goto L5;
        long r101 = System.nanoTime();
        String r102 = o87.c.a(r100);
        if (TextUtils.isEmpty(r102) == true) goto L9;
        sPangolinChannel = r102;
    L9:
        Log.i(TAG, "getPangolinChannel, channel = " + r102 + ", cost nano: " + (System.nanoTime() - r101));
        return r102;
    L5:
        return sPangolinChannel;
    }

    public static String getRuntimePackageChannel(Context r100) {
        if (DevEnvUtil.isDevelopPackage(r100) == false) goto L6;
        return "local";
    L6:
        if (DevEnvUtil.isDebugMode(r100) == false) goto L9;
        return "local";
    L9:
        return getBuildPackageChannel(r100);
    }

    public static boolean isKABuildPackage(Context r100) {
        Boolean r101 = sStoredIsKAPackage;
        if (r101 == null) goto L12;
        return r101.booleanValue();
    L12:
        boolean r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.getBoolean("IS_KA_PACKAGE", false);     // Catch: Exception -> L9
        sStoredIsKAPackage = Boolean.valueOf(r102);     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        Log.e(TAG, e);
        return false;
    }
}
