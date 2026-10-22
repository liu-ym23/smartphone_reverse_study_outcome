package com.bytedance.badger.collect.impl.network;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.monitor.MonitorManager;
import com.bytedance.badger.collect.impl.network.impl.NetworkServiceImpl;
import com.bytedance.badger.collect.impl.network.interfaces.INetWorkService;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class NetworkManager {
    private static volatile NetworkManager instance;
    private final INetWorkService netWorkService;

    public static NetworkManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(NetworkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new NetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private NetworkManager() {
        this.netWorkService = new NetworkServiceImpl();
    }

    public TTResponse fetchMobilePseudoCodeSign(String r100, Map<String, String> r101, NetworkMethodEnum r102, Map<String, String> r103) throws Exception {
        return this.netWorkService.fetchMobilePseudoCodeSign(r100, r101, r102, r103);
    }

    public TTResponse fetchMobilePseudoCodeToken(Network r100, String r101, Map<String, String> r110, NetworkMethodEnum r111, Map<String, String> r112) throws Exception {
        MonitorManager.getInstance().getMobileGetTokenMonitor().setStartRequestTime();
        TTResponse r102 = this.netWorkService.fetchMobilePseudoCodeToken(r100, r101, r110, r111, r112);
        MonitorManager.getInstance().getMobileGetTokenMonitor().setFinishRequestTime();
        return r102;
    }
}
