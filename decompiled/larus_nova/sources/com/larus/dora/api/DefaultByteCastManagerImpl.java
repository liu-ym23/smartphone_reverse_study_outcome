package com.larus.dora.api;

import com.larus.avlink.plugins.u2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\bH\u0016¨\u0006#"}, d2 = {"Lcom/larus/dora/api/DefaultByteCastManagerImpl;", "Lcom/larus/dora/api/IByteCastManager;", "<init>", "()V", "init", "", "initAfterAbilityNegotiation", "isInitSuccess", "", "isP2PRTCClientConnected", "invalidateP2PRTCClientOwnership", "updateP2PRTCCompanionRetention", "retain", "setDataCallBack", "callBack", "Lcom/larus/dora/api/IByteCastDataCallBack;", "clearDataCallBack", "requestKeyFrame", "changeSinkConfig", "cmd", "", "param", "Lorg/json/JSONObject;", "finishSession", "isBtRtcRunning", "getBtBandwidthMonitorData", "Lcom/larus/dora/api/BluetoothBandwidthMonitorData;", "getBtBandwidthMonitorSnapshot", "Lcom/larus/dora/api/BluetoothBandwidthMonitorSnapshot;", "recordMmtTargetBitrate", "targetBitrateBps", "", "getRtcVideoDumpEnable", "syncRtcVideoDumpEnable", "checked", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultByteCastManagerImpl implements IByteCastManager {
    public DefaultByteCastManagerImpl() {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean a() {
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean b(boolean r100) {
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean c() {
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void c0() {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void d() {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void e(long r100) {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void f() {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void g(u2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean h() {
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void init() {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void requestKeyFrame() {
    }
}
