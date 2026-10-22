package com.huawei.hms.support.hwid;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdAuthAPIManager {
    public static final Scope HUAWEIID_BASE_SCOPE = null;
    public static final Api<HuaweiIdAuthParams> HUAWEI_OAUTH_API = null;
    public static final HuaweiIdAuthAPIService HuaweiIdAuthAPIService = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.Options<HuaweiIdAuthParams> f277785a = null;

    public HuaweiIdAuthAPIManager() {
    }

    static {
        Api.Options<HuaweiIdAuthParams> r100 = new AnonymousClass1();
        f277785a = r100;
        HuaweiIdAuthAPIService = new HuaweiIdAuthAPIServiceImpl();
        HUAWEI_OAUTH_API = new Api(HuaweiApiAvailability.HMS_API_NAME_ID, r100);
        HUAWEIID_BASE_SCOPE = new Scope(CommonConstant.SCOPE.ACCOUNT_BASEPROFILE);
    }
}
