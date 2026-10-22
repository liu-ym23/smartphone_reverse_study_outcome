package com.bytedance.lynx.webview.glue.sdk111;

import android.content.Context;
import android.os.Handler;
import android.os.Trace;
import com.alipay.sdk.m.p.e;
import com.bytedance.lynx.webview.extension.a;
import com.bytedance.lynx.webview.internal.AppInfo;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.LibraryLoader;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.d;
import com.bytedance.lynx.webview.internal.f0;
import com.bytedance.lynx.webview.internal.p;
import com.bytedance.lynx.webview.internal.q;
import com.bytedance.lynx.webview.util.flipped.ModifiedFlipped;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l17.k;
import l17.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public abstract class IGlueToSdk111 {
    public IGlueToSdk111() {
    }

    public static void onURLRequestCompletedForFlowCount(String r100, long r101, long r102, long r103, Set<String> r104) {
    }

    public static void setHasLoadLibrary() {
        AtomicBoolean r100 = TTWebContext.f265205q;     // Catch: Throwable -> L7 Exception -> L9
        if (r100.compareAndSet(false, true) == false) goto L11;
        boolean r101 = Setting.f265158j;     // Catch: Throwable -> L7 Exception -> L9
        TTWebContext.C(new f0());     // Catch: Throwable -> L7 Exception -> L9
    L11:
        r100.set(true);
        return;
    L7:
        th = move-exception;
        TTWebContext.f265205q.set(true);
        throw th;
    L9:
        k.b(new String[]{"Setting failed to notify native."});     // Catch: Throwable -> L7
        r100 = TTWebContext.f265205q;
        goto L11
    }

    public static boolean getAppInfoValid() {
        boolean r100 = Setting.f265158j;
        return false;
    }

    public static Set<String> getTagList() {
        WeakHashMap<Object, String> r100 = a.f265111a;
        monitor-enter(a.class);
        HashSet r101 = new HashSet();     // Catch: Throwable -> L10
        Iterator<Map.Entry<Object, String>> r102 = a.f265111a.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(r102.next().getValue());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public static Map<String, String> getAppInfoData() {
        com.bytedance.lynx.webview.internal.a r100 = TTWebContext.e();
        if (r100 != null) goto L6;
        return null;
    L6:
        HashMap r101 = new HashMap();
        AppInfo r102 = r100.getAppInfo();
        r101.put("IId", r102.getIId());
        r101.put("UserId", r102.getUserId());
        r101.put(e.f25660h, r102.getAppId());
        r101.put("OSApi", r102.getOSApi());
        r101.put("AbFlag", r102.getAbFlag());
        r101.put("IId", r102.getIId());
        r101.put("UserId", r102.getUserId());
        r101.put(e.f25660h, r102.getAppId());
        r101.put("OSApi", r102.getOSApi());
        r101.put("AbFlag", r102.getAbFlag());
        r101.put("OpenVersion", r102.getOpenVersion());
        r101.put("DeviceId", r102.getDeviceId());
        r101.put("NetAccessType", r102.getNetAccessType());
        r101.put("VersionCode", r102.getVersionCode());
        r101.put("DeviceType", r102.getDeviceType());
        r101.put("AppName", r102.getAppName());
        r101.put("Channel", r102.getChannel());
        r101.put("CityName", r102.getCityName());
        r101.put("LiveSdkVersion", r102.getLiveSdkVersion());
        r101.put("OSVersion", r102.getOSVersion());
        r101.put("DevicePlatform", r102.getDevicePlatform());
        r101.put("UUID", r102.getUUID());
        r101.put("OpenUdid", r102.getOpenUdid());
        r101.put("Resolution", r102.getResolution());
        r101.put("AbVersion", r102.getAbVersion());
        r101.put("AbClient", r102.getAbClient());
        r101.put("AbFeature", r102.getAbFeature());
        r101.put("DeviceBrand", r102.getDeviceBrand());
        r101.put("Language", r102.getLanguage());
        r101.put("VersionName", r102.getVersionName());
        r101.put("SSmix", r102.getSSmix());
        r101.put("UpdateVersionCode", r102.getUpdateVersionCode());
        r101.put("ManifestVersionCode", r102.getManifestVersionCode());
        r101.put("DPI", r102.getDPI());
        r101.put("Rticket", r102.getRticket());
        r101.put("Abi", r102.getAbi());
        r101.put("HostFirst", r102.getHostFirst());
        r101.put("HostSecond", r102.getHostSecond());
        r101.put("HostThird", r102.getHostThird());
        r101.put("DomainBase", r102.getDomainBase());
        r101.put("DomainLog", r102.getDomainLog());
        r101.put("DomainSub", r102.getDomainSub());
        r101.put("DomainChannel", r102.getDomainChannel());
        r101.put("DomainMon", r102.getDomainMon());
        r101.put("DomainSec", r102.getDomainSec());
        r101.put("IsMainProcess", r102.getIsMainProcess());
        r101.put("StoreIdc", r102.getStoreIdc());
        r101.put("Region", r102.getRegion());
        r101.put("SysRegion", r102.getSysRegion());
        r101.put("CarrierRegion", r102.getCarrierRegion());
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public static Context getApplicationContext() {
        return TTWebContext.h().getContext();
    }

    public static String getLoadSoVersionCode() {
        TTWebContext.h().getClass();
        return TTWebContext.l(true);
    }

    public static Context getResourcesContext() {
        return getApplicationContext();
    }

    public static String getSoDirectory() {
        return TTWebContext.h().f265216b.f265148k;
    }

    public static Handler getUIHandler() {
        return TTWebContext.f265204p;
    }

    public static void ensureResourcesLoaded(Context r100) {
        Trace.beginSection("ensureResourcesLoaded");     // Catch: Throwable -> L5
        TTWebContext.h().f265216b.getClass();     // Catch: Throwable -> L5
        LibraryLoader.j(r100);     // Catch: Throwable -> L5
        Trace.endSection();
        return;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static String getCurProcessName(Context r100) {
        if (r100 != null) goto L6;
        return n.b(getApplicationContext());
    L6:
        return n.b(r100);
    }

    public static long getLibraryHandleAddress(String r110) {
        long r100 = ModifiedFlipped.getLibraryHandleAddress(r110);     // Catch: Exception -> L5
        k.d(new String[]{"[interface]", "getLibraryHandleAddress for " + r110 + " , ptr: " + r100});     // Catch: Exception -> L5
        return r100;
    L5:
        e = move-exception;
        k.b(new String[]{"[interface]", "getLibraryHandleAddress for " + r110 + " , error: " + e.toString()});
        return 0;
    }

    public static void glueSendAlog(String... r100) {
        String r101 = k.e(r100);
        if (p.b() == false) goto L7;
        q r102 = p.f265347b;
        if (r102 == null) goto L9;
        r102.a("LYNX_TT_WEBVIEW", r101);
        return;
    L9:
        return;
    L7:
        p.a(1, r101);
    }

    public static void addEventExtentionInfo(String r100, String r101) {
        int r102 = EventStatistics.f265113a;
        TTWebContext.C(new d(r100, r101));
    }

    public static boolean getBooleanConfig(String r100, boolean r101) {
        return Setting.c().b(r100, r101);
    }

    public static int getIntConfig(String r100, int r101) {
        return Setting.c().d(r100, r101);
    }

    public static String getStringConfig(String r100, String r101) {
        return Setting.c().h(r100, r101);
    }

    public static void glueSendCategoryEvent(int r100, JSONObject r101) {
        EventStatistics.f(r100, r101);
    }

    public static void nativeSendCategoryEvent(int r100, JSONObject r101) {
        EventStatistics.f(r100, r101);
    }

    public static boolean registerPackageLoadedCallback(String r100, Runnable r101) {
        AtomicInteger r102 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean getProcessFeature(String r100, int r101, boolean r102) {
        Setting.c().getClass();
        return Setting.f(r100, r101, r102);
    }

    public static void reportData(String r100, Map<String, Object> r101, Map<String, Object> r102) {
        EventStatistics.d(r100, r101, r102);
    }
}
