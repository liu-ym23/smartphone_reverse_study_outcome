package com.bytedance.awemeopen.user.serviceapi;

import com.bytedance.awemeopen.domain.user.login.LoginHelper;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import u64.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/user/serviceapi/AoLoginBaseService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_user_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoLoginBaseService extends IBdpService {
    void b1(LoginHelper.a r100);

    b getAccessToken();

    void u0(com.bytedance.awemeopen.domain.user.login.b r100);
}
