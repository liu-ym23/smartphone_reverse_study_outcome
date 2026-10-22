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

/* JADX INFO: loaded from: classes.dex */
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

    public static int asyncInstallPlugin(File r100) {
        return PluginPackageManager.installPackage(r100.getAbsolutePath(), true, 0);
    }

    public static void clearOfflineFlag(String r100) {
        MetaManager.getInst().clearOfflineFlag(r100);
    }

    public static int getInstalledPluginVersion(String r100) {
        return PluginPackageManager.getInstalledPluginVersion(r100);
    }

    public static Plugin getPlugin(String r100) {
        return PluginPackageManager.getPlugin(r100);
    }

    public static ClassLoader getPluginClassLoader(String r100) {
        return PluginLoader.getPluginClassLoader(r100);
    }

    public static int getPluginStatus(String r100) {
        return PluginPackageManager.getPluginStatus(r100);
    }

    public static boolean hasOfflineFlag(String r100) {
        return MetaManager.getInst().hasOfflineFlag(r100);
    }

    public static void init(Application r100) {
        init(r100, null);
    }

    public static int installPlugin(File r100) {
        return asyncInstallPlugin(r100);
    }

    public static boolean isPluginApkMatchHostAbi(File r100) {
        return NativeLibHelper.isPluginApkMatchHostAbi(r100);
    }

    public static boolean isPluginInstalled(String r100) {
        return PluginPackageManager.checkPluginInstalled(r100);
    }

    public static boolean isPluginLoaded(String r100) {
        return PluginManager.getInstance().isLoaded(r100);
    }

    public static boolean loadPlugin(String r100) {
        return PluginManager.getInstance().loadPlugin(r100);
    }

    public static void markOfflineFlag(String r100) {
        MetaManager.getInst().markOfflineFlag(r100);
    }

    public static void registerMiraProxyActivityCallback(MiraProxyActivityCallback r100) {
        MiraManager.getInstance().registerMiraProxyActivityCallback(r100);
    }

    public static void registerMiraProxyReceiverCallback(MiraProxyReceiverCallback r100) {
        MiraManager.getInstance().registerMiraProxyReceiverCallback(r100);
    }

    public static void registerPluginEventListener(MiraPluginEventListener r100) {
        MiraManager.getInstance().registerPluginEventListener(r100);
    }

    public static void setActivityThreadHInterceptor(MiraHandlerMsgInterceptor r100) {
        MiraManager.getInstance().setHandlerMsgInterceptor(r100);
    }

    public static void setAppContext(Context r100) {
        sAppContext = r100;
    }

    public static void setErrorReporter(MiraErrorReporter r100) {
        MiraManager.getInstance().setMiraErrorReporter(r100);
    }

    public static void setInstrumentationCallback(MiraInstrumentationCallback r100) {
        MiraManager.getInstance().setInstrumentationCallback(r100);
    }

    public static boolean syncInstallPlugin(File r100) {
        return PluginPackageManager.syncInstallPackage(r100.getAbsolutePath(), true, 0);
    }

    public static boolean unInstallPlugin(String r100) {
        if (PluginPackageManager.deletePackage(r100, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void unregisterMiraProxyActivityCallback(MiraProxyActivityCallback r100) {
        MiraManager.getInstance().unregisterMiraProxyActivityCallback(r100);
    }

    public static void unregisterMiraProxyReceiverCallback(MiraProxyReceiverCallback r100) {
        MiraManager.getInstance().unregisterMiraProxyReceiverCallback(r100);
    }

    public static void unregisterPluginEventListener(MiraPluginEventListener r100) {
        MiraManager.getInstance().unregisterPluginEventListener(r100);
    }

    public static void init(Application r100, MiraParam r101) {
        setAppContext(r100);
        Dex2OatManager.init(r100);
        MiraManager.getInstance().init(r100, r101);
    }

    public static void initPre(Application r100, MiraParamPre r101) {
        setAppContext(r100);
        MiraManager.getInstance().initPre(r101);
    }

    public static void markOfflineFlag(String r100, int r101) {
        MetaManager.getInst().markOfflineFlag(r100, r101);
    }

    public static int asyncInstallCompatPlugin(File r100, String r101, String r102) {
        return PluginPackageManager.installCompatPackage(r100.getAbsolutePath(), r101, r102, true, 0);
    }

    public static boolean syncInstallCompatPlugin(File r100, String r101, String r102) {
        return PluginPackageManager.syncInstallCompatPackage(r100.getAbsolutePath(), r101, r102, true, 0);
    }
}
