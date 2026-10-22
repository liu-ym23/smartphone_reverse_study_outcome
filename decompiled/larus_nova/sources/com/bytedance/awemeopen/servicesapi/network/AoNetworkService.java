package com.bytedance.awemeopen.servicesapi.network;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import q64.a;
import q64.g;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoNetworkService extends IBdpService {
    void getNetworkType();

    g s2(a r100);
}
