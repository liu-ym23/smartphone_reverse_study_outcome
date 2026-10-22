package com.bytedance.mira;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.helper.NativeLibHelper;
import com.bytedance.mira.oat.Dex2OatManager;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginLoader;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.pm.PluginPackageManager;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Mira {
    public static final int GET_ONLY_FROM_ANDROID = 16777216;
    public static final String START_ONLY_FOR_ANDROID = "start_only_for_android";
    private static Context sAppContext;

    public Mira() {
    }

    public static String getHostAbi() {
        return NativeLibHelper.getHostAbi();
    }

    public static int getHostAbiBit() {
        return NativeLibHelper.getHostAbiBit();
    }

    public static List<String> getInstalledPackageNames() {
        return PluginPackageManager.getInstalledPackageNames();
    }

    public static List<Plugin> listPlugins() {
        return PluginPackageManager.getPluginList();
    }

    public static void start() {
        MiraManager.getInstance().startHook();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static int asyncInstallPlugin(File r2) {
        return PluginPackageManager.installPackage(r2.getAbsolutePath(), true, 0);
    }

    public static void clearOfflineFlag(String r1) {
        MetaManager.getInst().clearOfflineFlag(r1);
    }

    public static int getInstalledPluginVersion(String r0) {
        return PluginPackageManager.getInstalledPluginVersion(r0);
    }

    public static Plugin getPlugin(String r0) {
        return PluginPackageManager.getPlugin(r0);
    }

    public static ClassLoader getPluginClassLoader(String r0) {
        return PluginLoader.getPluginClassLoader(r0);
    }

    public static int getPluginStatus(String r0) {
        return PluginPackageManager.getPluginStatus(r0);
    }

    public static boolean hasOfflineFlag(String r1) {
        return MetaManager.getInst().hasOfflineFlag(r1);
    }

    public static void init(Application r1) {
        init(r1, null);
    }

    public static int installPlugin(File r0) {
        return asyncInstallPlugin(r0);
    }

    public static boolean isPluginApkMatchHostAbi(File r0) {
        return NativeLibHelper.isPluginApkMatchHostAbi(r0);
    }

    public static boolean isPluginInstalled(String r0) {
        return PluginPackageManager.checkPluginInstalled(r0);
    }

    public static boolean isPluginLoaded(String r1) {
        return PluginManager.getInstance().isLoaded(r1);
    }

    public static boolean loadPlugin(String r1) {
        return PluginManager.getInstance().loadPlugin(r1);
    }

    public static void markOfflineFlag(String r1) {
        MetaManager.getInst().markOfflineFlag(r1);
    }

    public static void registerMiraProxyActivityCallback(MiraProxyActivityCallback r1) {
        MiraManager.getInstance().registerMiraProxyActivityCallback(r1);
    }

    public static void registerMiraProxyReceiverCallback(MiraProxyReceiverCallback r1) {
        MiraManager.getInstance().registerMiraProxyReceiverCallback(r1);
    }

    public static void registerPluginEventListener(MiraPluginEventListener r1) {
        MiraManager.getInstance().registerPluginEventListener(r1);
    }

    public static void setActivityThreadHInterceptor(MiraHandlerMsgInterceptor r1) {
        MiraManager.getInstance().setHandlerMsgInterceptor(r1);
    }

    public static void setAppContext(Context r0) {
        sAppContext = r0;
    }

    public static void setErrorReporter(MiraErrorReporter r1) {
        MiraManager.getInstance().setMiraErrorReporter(r1);
    }

    public static void setInstrumentationCallback(MiraInstrumentationCallback r1) {
        MiraManager.getInstance().setInstrumentationCallback(r1);
    }

    public static boolean syncInstallPlugin(File r2) {
        return PluginPackageManager.syncInstallPackage(r2.getAbsolutePath(), true, 0);
    }

    public static boolean unInstallPlugin(String r1) {
        if (PluginPackageManager.deletePackage(r1, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void unregisterMiraProxyActivityCallback(MiraProxyActivityCallback r1) {
        MiraManager.getInstance().unregisterMiraProxyActivityCallback(r1);
    }

    public static void unregisterMiraProxyReceiverCallback(MiraProxyReceiverCallback r1) {
        MiraManager.getInstance().unregisterMiraProxyReceiverCallback(r1);
    }

    public static void unregisterPluginEventListener(MiraPluginEventListener r1) {
        MiraManager.getInstance().unregisterPluginEventListener(r1);
    }

    public static void init(Application r1, MiraParam r2) {
        setAppContext(r1);
        Dex2OatManager.init(r1);
        MiraManager.getInstance().init(r1, r2);
    }

    public static void initPre(Application r0, MiraParamPre r1) {
        setAppContext(r0);
        MiraManager.getInstance().initPre(r1);
    }

    public static void markOfflineFlag(String r1, int r2) {
        MetaManager.getInst().markOfflineFlag(r1, r2);
    }

    public static int asyncInstallCompatPlugin(File r2, String r3, String r4) {
        return PluginPackageManager.installCompatPackage(r2.getAbsolutePath(), r3, r4, true, 0);
    }

    public static boolean syncInstallCompatPlugin(File r2, String r3, String r4) {
        return PluginPackageManager.syncInstallCompatPackage(r2.getAbsolutePath(), r3, r4, true, 0);
    }
}
