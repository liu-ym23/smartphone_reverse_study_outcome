package com.bytedance.awemeopen.share.serviceapi;

import android.app.Activity;
import com.bytedance.awemeopen.domain.share.a;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/share/serviceapi/AoSharePanelService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_share_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoSharePanelService extends IBdpService {
    void Z1(Activity r100, String r101, String r102, String r103, String r104, a r105, JSONObject r106, Function2 r107);

    boolean l();
}
