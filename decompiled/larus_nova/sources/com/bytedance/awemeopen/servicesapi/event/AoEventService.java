package com.bytedance.awemeopen.servicesapi.event;

import com.bytedance.awemeopen.infra.base.event.a;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface AoEventService extends IBdpService {
    void D1(a r100);

    void init();

    String k(String r100);

    void k2(String r100, JSONObject r101, String r102, JSONObject r103);

    JSONObject z2(JSONObject r100);
}
