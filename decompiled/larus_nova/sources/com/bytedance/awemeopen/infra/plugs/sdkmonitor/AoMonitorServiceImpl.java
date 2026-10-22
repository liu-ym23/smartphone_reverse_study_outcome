package com.bytedance.awemeopen.infra.plugs.sdkmonitor;

import android.content.Context;
import com.bytedance.awemeopen.servicesapi.monitor.AoMonitorService;
import g64.a;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AoMonitorServiceImpl implements AoMonitorService {
    public AoMonitorServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.monitor.AoMonitorService
    public final a Z(Context r100, String r101, JSONObject r102, List r103) {
        return new a(r100, r101, r102, r103);
    }
}
