package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;

/* JADX INFO: loaded from: classes23.dex */
public interface HuaweiIdAuthAPIService {
    public static final String EXTRA_AUTH_HUAWEI_ID = "HUAWEIID_SIGNIN_RESULT";

    PendingResult<Status> cancelAuthorization(HuaweiApiClient r100);

    SignInResult getHwIdSignInResultFromIntent(Intent r100);

    Intent getSignInIntent(HuaweiApiClient r100);

    HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent r100);

    PendingResult<SignInResult> signIn(Activity r100, HuaweiApiClient r101);

    PendingResult<SignInResult> signInBackend(HuaweiApiClient r100);

    PendingResult<Status> signOut(HuaweiApiClient r100);

    OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(HuaweiApiClient r100);
}
