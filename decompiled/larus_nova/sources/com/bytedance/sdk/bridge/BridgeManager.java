package com.bytedance.sdk.bridge;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.bytedance.sdk.bridge.api.BridgeService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0007H\u0007J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/bridge/BridgeManager;", "", "()V", "DEFAULT_DEBUG", "", "DEFAULT_IGNORE_NAMESPACE", "DEFAULT_SCHEMA", "", "bridgeConfig", "Lcom/bytedance/sdk/bridge/BridgeConfig;", "getBridgeConfig", "()Lcom/bytedance/sdk/bridge/BridgeConfig;", "setBridgeConfig", "(Lcom/bytedance/sdk/bridge/BridgeConfig;)V", "bridgeService", "Lcom/bytedance/sdk/bridge/api/BridgeService;", "config", "", "registerBridgeWithLifeCycle", "bridgeModule", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "registerEvent", "event", "privilege", "registerGlobalBridge", "bridge_release"}, k = 1, mv = {1, 1, 15})
public final class BridgeManager {
    private static final boolean DEFAULT_DEBUG = false;
    private static final boolean DEFAULT_IGNORE_NAMESPACE = true;
    private static final String DEFAULT_SCHEMA = "nativeapp";
    public static final BridgeManager INSTANCE = null;
    private static BridgeConfig bridgeConfig;
    private static BridgeService bridgeService;

    private BridgeManager() {
    }

    static {
        INSTANCE = new BridgeManager();
        DEFAULT_SCHEMA = "nativeapp";
        DEFAULT_IGNORE_NAMESPACE = true;
        BridgeService r100 = (BridgeService) ServiceManager.getService(BridgeService.class);
        bridgeService = r100;
        if (r100 == null) goto L7;
        BridgeConfig r101 = r100.initBridgeConfig();
        if (r101 == null) goto L7;
    L8:
        bridgeConfig = r101;
        return;
    L7:
        BridgeConfig.Builder r102 = new BridgeConfig.Builder().isDebug(Boolean.valueOf(DEFAULT_DEBUG)).setSchema("nativeapp").setIgnoreNameSpace(true);
        Boolean r103 = Boolean.FALSE;
        r101 = r102.jsCallSuccessCostEnable(r103).isCompatiblePreLoadWebview(r103).build();
        goto L8
    }

    public final BridgeConfig getBridgeConfig() {
        return bridgeConfig;
    }

    @Deprecated(message = "Please init by 'implements BridgeService'.")
    public final void config(BridgeConfig r100) {
        BridgeService r101 = bridgeService;
        if (r101 == null) goto L8;
        if (r101 == null) goto L6;
        BridgeConfig r102 = r101.initBridgeConfig();
    L7:
        if (r102 == null) goto L8;
        return;
    L6:
        r102 = null;
    L8:
        bridgeConfig = r100;
    }

    public final void registerGlobalBridge(Object r100) {
        e.f269589c.add(new ed7.b(r100, null, 2));
    }

    public final void setBridgeConfig(BridgeConfig r100) {
        bridgeConfig = r100;
    }

    public final void registerBridgeWithLifeCycle(Object r100, Lifecycle r101) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r102 = e.f269587a;
        r101.addObserver(new BridgeLifeCycleObserver(r100, r101));
        e.f269589c.add(new ed7.b(r100, r101, 2));
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).getClass();
        return;
    }

    @Deprecated(message = "取消event鉴权")
    public final void registerEvent(String r100, @BridgePrivilege String r110) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r101 = e.f269587a;
        e.f269588b.put(r100, new BridgeMethodInfo(null, r100, r110, BridgeSyncType.ASYNC, null));
    }
}
