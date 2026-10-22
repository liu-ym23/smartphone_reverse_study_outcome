package com.huawei.hms.support.account.service;

import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.entity.account.GetAssistTokenRequest;
import com.huawei.hms.support.feature.service.AuthService;

/* JADX INFO: loaded from: classes23.dex */
public interface AccountAuthService extends AuthService {
    Task<AssistTokenResult> getAssistToken(GetAssistTokenRequest r100);

    Task<AccountIcon> getChannel();

    Intent getIndependentSignInIntent(String r100);

    Task<Void> logout();

    Task<AuthAccount> silentSignIn();

    Task<Void> startAssistLogin(String r100);
}
