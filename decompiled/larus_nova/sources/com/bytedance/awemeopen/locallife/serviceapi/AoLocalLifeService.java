package com.bytedance.awemeopen.locallife.serviceapi;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/locallife/serviceapi/AoLocalLifeService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_locallife_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoLocalLifeService extends IBdpService {
    void X0(Activity r100, String r101, Function0 r102, Function2 r103, Map r104, Function1 r105);

    boolean isAvailable();
}
