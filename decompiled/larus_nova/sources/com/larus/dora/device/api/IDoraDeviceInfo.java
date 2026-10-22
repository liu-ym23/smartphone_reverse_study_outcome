package com.larus.dora.device.api;

import hm9.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0010H&¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/device/api/IDoraDeviceInfo;", "", "getDoraState", "", "hasDoraDevice", "", "getDoraBondCount", "", "getQueryWorkThread", "Ljava/lang/Thread;", "addDoraWakeStateChangeCallback", "", "callback", "Lcom/larus/platform/api/DoraWakeStateChangeCallback;", "getProductId", "getDeviceName", "", "isDoraGEnabled", "canEnableLocationPoll", "registerDoraLinkCallback", "Lcom/larus/dora/device/api/DoraDeviceLinkCallback;", "registerWearStateListener", "listener", "Lcom/larus/dora/device/api/DoraDeviceWearStateListener;", "getHookURL", "dora-device-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraDeviceInfo {
    String a();

    boolean b();

    void c(g r100);

    void d();

    String e();

    long getDoraBondCount();

    int getDoraState();

    int getProductId();

    boolean hasDoraDevice();

    Thread m();
}
