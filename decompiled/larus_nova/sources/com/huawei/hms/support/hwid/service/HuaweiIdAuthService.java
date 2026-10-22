package com.huawei.hms.support.hwid.service;

import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.feature.service.AuthService;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* JADX INFO: loaded from: classes23.dex */
public interface HuaweiIdAuthService extends AuthService {
    Intent getSignInIntent(String r100);

    Task<AuthHuaweiId> silentSignIn();

    Task<AuthHuaweiId> silentSignIn(String r100);
}
