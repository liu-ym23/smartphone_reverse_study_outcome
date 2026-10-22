package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.hwid.ab;
import com.huawei.hms.hwid.ac;
import com.huawei.hms.hwid.ad;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.v;
import com.huawei.hms.hwid.x;
import com.huawei.hms.hwid.z;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.hwid.HuaweiIdGetTokenOptions;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdAuthServiceImpl extends HuaweiApi<HuaweiIdAuthParams> implements HuaweiIdAuthService {
    private static final Api<HuaweiIdAuthParams> HUAWEI_ID_AUTH_API = null;
    protected static final String TAG = "[HUAWEIIDSDK]HuaweiIdAuthService";
    private String mAccountName;
    private boolean mFromRequestToken;

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    static {
        HUAWEI_ID_AUTH_API = new Api(HuaweiApiAvailability.HMS_API_NAME_ID);
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> cancelAuthorization() {
        as.b(TAG, "cancelAuthorization", true);
        HuaweiIdSignInRequest r100 = new HuaweiIdSignInRequest();
        r100.setHuaweiIdAuthParams(getOption());
        return doWrite(new z(CommonNaming.revokeAccess, r100.toJson(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.revokeAccess, 60900100)));
    L5:
        as.d(TAG, "JSONException, errorcode is:2015", true);
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setException(new ApiException(new Status(2015)));
        return r101.getTask();
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Intent getSignInIntent() {
        return getSignInIntent("");
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> signOut() {
        as.b(TAG, "signOut", true);
        x.a();
        SignOutReq r100 = new SignOutReq();
        String r101 = HiAnalyticsClient.reportEntry(getContext(), CommonNaming.signout, 60900100);
        return doWrite(new ad(CommonNaming.signout, r100.toJson(), r101));
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn() {
        return silentSignIn("");
    }

    private HuaweiIdAuthParams setSignInParams(String r100) {
        HuaweiIdAuthParams r101 = getOption();
        new JSONObject(r100);     // Catch: JSONException -> L9
        HuaweiIdAuthParams r102 = r101.clone();     // Catch: CloneNotSupportedException -> L7
        r102.setSignInParams(r100);
        return r102;
    L7:
        as.d(TAG, "CloneNotSupportedException", true);
        return r101;
    L9:
        as.d(TAG, "JSONException", true);
        return r101;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Intent getSignInIntent(String r100) {
        as.b(TAG, "getSignInIntent", true);
        return x.a(getContext(), setSignInParams(r100), getSubAppID());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn(String r100) {
        as.b(TAG, "silentSignIn", true);
        HuaweiIdSignInRequest r101 = new HuaweiIdSignInRequest();
        r101.setHuaweiIdAuthParams(setSignInParams(r100));
        boolean r102 = this.mFromRequestToken;
        if (r102 == false) goto L13;
        r101.setHuaweiIdGetTokenOptions(new HuaweiIdGetTokenOptions(this.mAccountName, r102));
    L13:
        String r103 = r101.toJson();     // Catch: JSONException -> L11
        String r104 = HiAnalyticsClient.reportEntry(getContext(), CommonNaming.silentSignIn, 60900100);     // Catch: JSONException -> L11
        if (this.mFromRequestToken == false) goto L10;
        return doWrite(new ab(CommonNaming.silentSignIn, r103, r104));
    L10:
        return doWrite(new ac(CommonNaming.silentSignIn, r103, r104));
    L11:
        as.d(TAG, "JSONException, errorcode is:2015", true);
        TaskCompletionSource r105 = new TaskCompletionSource();
        r105.setException(new ApiException(new Status(2015)));
        return r105.getTask();
    }

    public HuaweiIdAuthServiceImpl(Activity r100, HuaweiIdAuthParams r101, int r102) {
        super(r100, HUAWEI_ID_AUTH_API, r101, new v(), r102);
    }

    public HuaweiIdAuthServiceImpl(Context r100, HuaweiIdAuthParams r101, int r102) {
        super(r100, HUAWEI_ID_AUTH_API, r101, new v(), r102);
    }

    public HuaweiIdAuthServiceImpl(Activity r100, HuaweiIdAuthParams r101, String r102, int r110) {
        super(r100, HUAWEI_ID_AUTH_API, r101, new v(), r110);
        this.mAccountName = r102;
        this.mFromRequestToken = true;
    }

    public HuaweiIdAuthServiceImpl(Context r100, HuaweiIdAuthParams r101, String r102, int r110) {
        super(r100, HUAWEI_ID_AUTH_API, r101, new v(), r110);
        this.mAccountName = r102;
        this.mFromRequestToken = true;
    }
}
