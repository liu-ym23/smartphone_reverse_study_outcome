package com.bytedance.bdp.appbase.base.info;

import com.bytedance.bdp.bdpbase.ipc.annotation.Event;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpAppInfoService extends IBdpService {
    @Event
    String getDeviceId(String r100);
}
