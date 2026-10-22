package com.ttnetuploader.uploader.discovery;

import android.content.Context;
import com.ttnetuploader.uploader.api.IServerStatusChange;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class DiscoveryManager {
    private static final String TAG = "DiscoveryManager";
    private static volatile DiscoveryManager s_instance;
    private Context mContext;
    private final Map<String, ServerDetector> mServerDetectorMap;
    private final Map<String, ServerInfo> mServerInfoMap;
    private ServiceDiscovery serviceDiscovery;

    public void stopDiscovery() {
        Map<String, ServerDetector> r100 = this.mServerDetectorMap;
        monitor-enter(r100);
        ServiceDiscovery r101 = this.serviceDiscovery;     // Catch: Throwable -> L14
        if (r101 == null) goto L7;
        r101.stopDiscovery();     // Catch: Throwable -> L14
    L7:
        Iterator<ServerDetector> r102 = this.mServerDetectorMap.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().stop();     // Catch: Throwable -> L14
        goto L9
    L11:
        this.mServerDetectorMap.clear();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public DiscoveryManager(Context r100) {
        this.serviceDiscovery = null;
        this.mContext = null;
        this.mServerInfoMap = new HashMap();
        this.mServerDetectorMap = new HashMap();
        if (r100 == null) goto L6;
        this.mContext = r100.getApplicationContext();
        return;
    }

    private void addServerInfo(ServerInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<String, ServerInfo> r101 = this.mServerInfoMap;
        monitor-enter(r101);
        this.mServerInfoMap.put(r100.getKey(), r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static DiscoveryManager getInstance(Context r100) {
        if (s_instance != null) goto L15;
        monitor-enter(DiscoveryManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s_instance != null) goto L9;
        s_instance = new DiscoveryManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DiscoveryManager.class);     // Catch: Throwable -> L11
    L15:
        return s_instance;
    }

    private void removeServerInfo(String r100) {
        Map<String, ServerInfo> r101 = this.mServerInfoMap;
        monitor-enter(r101);
        if (r100 != null) goto L7;
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        this.mServerInfoMap.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public String getIpv4(String r100) {
        String r101 = CommonTools.getSNId(r100);     // Catch: Throwable -> L14
        Map<String, ServerInfo> r102 = this.mServerInfoMap;     // Catch: Throwable -> L14
        monitor-enter(r102);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L6:
        if (this.mServerInfoMap.get(r101) == null) goto L8;
        String r103 = this.mServerInfoMap.get(r101).getIpv4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
        return r103;
    L8:
        r103 = null;
    L14:
        th = move-exception;
        th.toString();
        return null;
    }

    public int getPort(String r100) {
        String r101 = CommonTools.getSNId(r100);     // Catch: Throwable -> L14
        Map<String, ServerInfo> r102 = this.mServerInfoMap;     // Catch: Throwable -> L14
        monitor-enter(r102);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L6:
        if (this.mServerInfoMap.get(r101) == null) goto L8;
        int r103 = this.mServerInfoMap.get(r101).getPort();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
        return r103;
    L8:
        r103 = 0;
    L14:
        th = move-exception;
        th.toString();
        return 0;
    }

    public static /* synthetic */ void access$000(DiscoveryManager r100, ServerInfo r101) {
        r100.addServerInfo(r101);
    }

    public void addNewServerInfo(String r100, String r110, int r111) {
        if (r100 == null) goto L8;
        if (r110 == null) goto L9;
        if (r111 <= 0) goto L10;
        addServerInfo(new ServerInfo(CommonTools.getSNId(r100), r100, r110, r111, System.currentTimeMillis()));
        return;
    L10:
        return;
    L9:
        return;
    }

    public boolean isReachable(String r100, boolean r101, boolean r102) {
        Map<String, ServerDetector> r103 = this.mServerDetectorMap;     // Catch: Throwable -> L14
        monitor-enter(r103);     // Catch: Throwable -> L14
        ServerDetector r104 = this.mServerDetectorMap.get(r100);     // Catch: Throwable -> L11
        if (r104 == null) goto L9;
        boolean r105 = r104.isReachable(r101, r102);     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
        return r105;
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.toString();
        return false;
    }

    public void startDiscovery(boolean r100, List<String> r101, IServerStatusChange r102, boolean r103) {
        if (r100 == true) goto L7;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return;
    L7:
        Map<String, ServerDetector> r104 = this.mServerDetectorMap;
        monitor-enter(r104);
    L21:
        th = move-exception;
        throw th;
    L10:
        if (this.mServerDetectorMap.isEmpty() == false) goto L16;
        Iterator<String> r105 = r101.iterator();     // Catch: Throwable -> L21
    L13:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();     // Catch: Throwable -> L21
        ServerDetector r107 = new ServerDetector(r106, r102, r103, this.mContext);     // Catch: Throwable -> L21
        r107.start();     // Catch: Throwable -> L21
        this.mServerDetectorMap.put(r106, r107);     // Catch: Throwable -> L21
    L16:
        if (this.serviceDiscovery != null) goto L18;
        this.serviceDiscovery = new ServiceDiscovery(this.mContext, new AnonymousClass1(this), r100, r101);     // Catch: Throwable -> L21
    L18:
        this.serviceDiscovery.startDiscovery();     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L21
    }
}
