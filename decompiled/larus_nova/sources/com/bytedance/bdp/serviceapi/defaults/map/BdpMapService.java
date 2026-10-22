package com.bytedance.bdp.serviceapi.defaults.map;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.service.plug.map.model.BdpMap;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpMapService extends IBdpService {
    BdpMap createMapInstance();

    boolean support3DMap();
}
