package com.bytedance.awemeopen.user.serviceapi.normal;

import android.app.Activity;
import com.bytedance.awemeopen.domain.user.login.normal.NormalLogin$login$afterHostLogin$1;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import u64.a;
import u64.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/user/serviceapi/normal/AoNormalLoginService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_user_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoNormalLoginService extends IBdpService {
    void R0(c r100);

    void S0(Activity r100, NormalLogin$login$afterHostLogin$1.a.b r101);

    void a();

    void isHostLogin();

    void s0(Activity r100, a r101);
}
