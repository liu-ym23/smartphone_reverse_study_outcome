package com.bytedance.bdp.bdpbase.manager;

import android.text.TextUtils;
import ca4.c;
import com.bytedance.bdp.bdpbase.core.BdpApp;
import com.bytedance.bdp.bdpbase.core.BdpPluginAdapterService;
import com.bytedance.bdp.bdpbase.core.BdpPluginService;
import com.bytedance.bdp.bdpbase.core.IBdpApp;
import com.bytedance.bdp.bdpbase.service.BdpServiceImplInfo;
import com.bytedance.bdp.bdpbase.service.BdpServiceInfo;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BdpManager {
    private ca4.b bdpServiceManager;
    private boolean debugMode;
    private com.bytedance.bdp.bdpbase.core.a mSdkInfo;

    /* JADX INFO: loaded from: classes11.dex */
    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BdpManager f201271a = null;

        static {
            f201271a = new BdpManager(null);
        }
    }

    public void checkHotfix() {
        Map<String, String> r100 = z94.a.f571008a;
        if (z94.a.f571009b == true) goto L23;
        z94.a.f571009b = true;
        Iterator<Map.Entry<String, String>> r101 = z94.a.f571008a.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L38;
        Map.Entry<String, String> r102 = r101.next();
        int r103 = y94.a.f566973a;     // Catch: Throwable -> L21
        String r104 = r102.getKey();     // Catch: Throwable -> L21
        String r105 = r102.getValue();     // Catch: Throwable -> L21
        Class r106 = ((BdpPluginService) getInst().getService(BdpPluginService.class)).k1(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L24;
    L14:
        if (r106 == null) goto L7;
        Object r107 = r106.newInstance();     // Catch: Throwable -> L21
        if (r107 == null) goto L7;
        if ((r107 instanceof z94.b) == false) goto L7;
        ((z94.b) r107).a();     // Catch: Throwable -> L21
        goto L7
    L24:
        r106 = y94.a.a(r105);     // Catch: Throwable -> L13
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L7
    L38:
        return;
    }

    public List<BdpApp> getAllBdpApps() {
        ArrayList r100 = new ArrayList();
        ca4.b r101 = this.bdpServiceManager;
        r101.getClass();
        Iterator r102 = new ArrayList(((ConcurrentHashMap) r101.f22934a).values()).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        IBdpApp r103 = (IBdpApp) r102.next();
        if ((r103 instanceof BdpApp) == false) goto L4;
        r100.add((BdpApp) r103);
        goto L4
    L8:
        return r100;
    }

    public List<BdpServiceInfo> getAllBdpService() {
        ca4.b r100 = this.bdpServiceManager;
        if (r100.f22940g.compareAndSet(false, true) == false) goto L6;
        r100.c(r100.f22939f);
    L6:
        return new ArrayList(((ConcurrentHashMap) r100.f22936c).values());
    }

    public com.bytedance.bdp.bdpbase.core.a getSDKInfo() {
        if (this.mSdkInfo != null) goto L6;
        this.mSdkInfo = new com.bytedance.bdp.bdpbase.core.a();
    L6:
        return this.mSdkInfo;
    }

    public void mergePluginRuntimeProvider() {
        this.bdpServiceManager.e();
    }

    private BdpManager() {
        this.debugMode = false;
        this.bdpServiceManager = new ca4.b();
    }

    public static BdpManager getInst() {
        return b.f201271a;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public /* synthetic */ BdpManager(a r100) {
        this();
    }

    public void addPluginBdpRuntimeProvider(String r100) {
        ca4.b r101 = this.bdpServiceManager;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty((String) ((ConcurrentHashMap) r101.f22938e).get(r100)) == true) goto L21;
        monitor-enter(r101);
        BdpPluginAdapterService r102 = (BdpPluginAdapterService) r101.a(BdpPluginAdapterService.class);     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r102.isPluginReady();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public BdpApp findSupportBdpApp(int r100) {
        List<BdpApp> r101 = getAllBdpApps();
        if (r101 == null) goto L12;
        Iterator<BdpApp> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L20;
        BdpApp r103 = r102.next();
        int[] r104 = r103.getBdpAppTechTypes();
        if (r104 == null) goto L6;
        if (Arrays.binarySearch(r104, r100) < 0) goto L6;
        return r103;
    L20:
        return null;
    L12:
        return null;
    }

    public <T extends IBdpService> T getService(Class<T> r100) {
        ca4.b r101 = this.bdpServiceManager;
        IBdpService r102 = r101.a(r100);
        if (r102 == null) goto L5;
    L7:
        if (r102 != null) goto L16;
        monitor-enter(r101);
        if (r102 == null) goto L17;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        r102 = (T) ((IBdpService) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new ca4.a()));
    L16:
        return (T) r102;
    L5:
        if (((ConcurrentHashMap) r101.f22938e).isEmpty() == true) goto L7;
        r101.e();
        r102 = (T) r101.a(r100);
        goto L7
    }

    public void setDebugMode(boolean r100) {
        this.debugMode = r100;
    }

    public void addPluginBdpRuntimeProvider(c r100) {
        ca4.b r101 = this.bdpServiceManager;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        r101.b(r100);
        r101.d(r100);
        r101.c(r100);
    }

    public <T extends IBdpService> void registerService(Class<T> r100, T r101) {
        ca4.b r102 = this.bdpServiceManager;
        r102.getClass();
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        BdpServiceImplInfo r103 = new BdpServiceImplInfo(r101.getClass(), 99999, r101);
        Map<String, Object> r104 = r102.f22937d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r101.getClass().getName(), r101);
        Map<String, BdpServiceImplInfo> r106 = r102.f22935b;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(r100.getName(), r103);
        return;
    L8:
        return;
    }
}
