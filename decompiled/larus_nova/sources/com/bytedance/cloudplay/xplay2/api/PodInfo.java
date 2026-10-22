package com.bytedance.cloudplay.xplay2.api;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\u00020\u001dX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0005¨\u0006'"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/PodInfo;", "", "()V", "isPodReconnect", "", "()Z", "planId", "", "getPlanId", "()Ljava/lang/String;", "podDc", "getPodDc", "podDeviceId", "getPodDeviceId", "podDeviceModel", "getPodDeviceModel", "podGpuInfo", "getPodGpuInfo", "podId", "getPodId", "podRtcUserId", "getPodRtcUserId", "productId", "getProductId", "supplierGameId", "getSupplierGameId", "supplierPodId", "getSupplierPodId", "supplierSdkType", "", "getSupplierSdkType", "()I", "supportResolutionInfo", "", "Lcom/bytedance/cloudplay/xplay2/api/ResolutionInfo;", "getSupportResolutionInfo", "()Ljava/util/List;", "useLocalKeyboard", "getUseLocalKeyboard", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PodInfo {
    private final boolean isPodReconnect;
    private final String planId;
    private final String podDc;
    private final String podDeviceId;
    private final String podDeviceModel;
    private final String podGpuInfo;
    private final String podId;
    private final String podRtcUserId;
    private final String productId;
    private final String supplierGameId;
    private final String supplierPodId;
    private final int supplierSdkType;
    private final List<ResolutionInfo> supportResolutionInfo;
    private final boolean useLocalKeyboard;

    public PodInfo() {
        this.podRtcUserId = "";
        this.podDc = "";
        this.podId = "";
        this.planId = "";
        this.productId = "";
        this.podDeviceModel = "";
        this.podGpuInfo = "";
        this.supplierPodId = "";
        this.supplierGameId = "";
        this.podDeviceId = "";
        this.supportResolutionInfo = new ArrayList();
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getPodDc() {
        return this.podDc;
    }

    public final String getPodDeviceId() {
        return this.podDeviceId;
    }

    public final String getPodDeviceModel() {
        return this.podDeviceModel;
    }

    public final String getPodGpuInfo() {
        return this.podGpuInfo;
    }

    public final String getPodId() {
        return this.podId;
    }

    public final String getPodRtcUserId() {
        return this.podRtcUserId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSupplierGameId() {
        return this.supplierGameId;
    }

    public final String getSupplierPodId() {
        return this.supplierPodId;
    }

    public final int getSupplierSdkType() {
        return this.supplierSdkType;
    }

    public final List<ResolutionInfo> getSupportResolutionInfo() {
        return this.supportResolutionInfo;
    }

    public final boolean getUseLocalKeyboard() {
        return this.useLocalKeyboard;
    }

    public final boolean isPodReconnect() {
        return this.isPodReconnect;
    }
}
