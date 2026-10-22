package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.hwid.RevokeAccessResp;
import com.huawei.hms.support.api.entity.hwid.SignInReq;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.entity.hwid.SignOutResp;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiIdAuthAPIServiceImpl implements HuaweiIdAuthAPIService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HuaweiApiClient f277787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f277788b;

    public static class SignOutNoConnectPendingResult extends PendingResultImpl<Status, SignOutResp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ResultCallback f277793a;

        public ResultCallback getCallback() {
            return this.f277793a;
        }

        public Status onComplete(SignOutResp r100) {
            Status r101 = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return r101;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback<Status> r100) {
            this.f277793a = r100;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity r100) {
            return onComplete((SignOutResp) r100);
        }

        public SignOutNoConnectPendingResult(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    public static class SignOutOnCompleteListener implements OnCompleteListener<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SignOutNoConnectPendingResult f277794a;

        public SignOutOnCompleteListener(SignOutNoConnectPendingResult r100) {
            this.f277794a = r100;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<Void> r100) {
            as.b("HuaweiIdAuthAPIServiceImpl", "SignOutOnCompleteListener onComplete", true);
            if (this.f277794a != null) goto L6;
            as.d("HuaweiIdAuthAPIServiceImpl", "signOutResultPendingResult is null", true);
            return;
        L6:
            Status r101 = Status.FAILURE;
            if (r100.isSuccessful() == false) goto L9;
            r101 = Status.SUCCESS;
        L15:
            ResultCallback r102 = this.f277794a.getCallback();
            if (r102 == null) goto L18;
            r102.onResult(r101);
            return;
        L18:
            as.d("HuaweiIdAuthAPIServiceImpl", "set Result callback after signOut completed", true);
            return;
        L9:
            Exception r103 = r100.getException();
            if (r103 != null) goto L12;
        L14:
            as.d("HuaweiIdAuthAPIServiceImpl", "wrong exception while failed", true);
            goto L15
        L12:
            if ((r103 instanceof ApiException) == false) goto L14;
            r101 = new Status(((ApiException) r103).getStatusCode());
            goto L15
        }
    }

    public class a implements ResultCallback<ResolveResult<JosGetNoticeResp>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HuaweiIdAuthAPIServiceImpl f277795a;

        private a(HuaweiIdAuthAPIServiceImpl r100) {
            this.f277795a = r100;
        }

        public void a(ResolveResult<JosGetNoticeResp> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.getStatus().isSuccess() == false) goto L21;
            JosGetNoticeResp r101 = r100.getValue();
            Intent r102 = r101.getNoticeIntent();
            if (r102 != null) goto L8;
            return;
        L8:
            if (r101.getStatusCode() != 0) goto L23;
            as.a("HuaweiIdAuthAPIServiceImpl", "get notice has intent.", true);
            Activity r103 = Util.getValidActivity((Activity) HuaweiIdAuthAPIServiceImpl.b(this.f277795a).get(), HuaweiIdAuthAPIServiceImpl.a(this.f277795a).getTopActivity());
            if (r103 != null) goto L18;
            as.d("HuaweiIdAuthAPIServiceImpl", "showNotice no valid activity!", true);
            return;
        L18:
            r103.startActivity(r102);     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            as.d("HuaweiIdAuthAPIServiceImpl", "startActivity exception".concat(e.getClass().getSimpleName()), true);
            return;
        L23:
            return;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public /* synthetic */ void onResult(ResolveResult<JosGetNoticeResp> r100) {
            a(r100);
        }

        public /* synthetic */ a(HuaweiIdAuthAPIServiceImpl r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class b extends PendingResultImpl<Status, RevokeAccessResp> {
        public Status a(RevokeAccessResp r100) {
            as.b("HuaweiIdAuthAPIServiceImpl", "RevokeAccessPendingResult onComplete", true);
            return new Status(r100.getRetCode());
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* synthetic */ Result onComplete(IMessageEntity r100) {
            return a((RevokeAccessResp) r100);
        }

        public b(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    public static class c extends PendingResultImpl<Status, SignOutResp> {
        public Status a(SignOutResp r100) {
            Status r101 = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return r101;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* synthetic */ Result onComplete(IMessageEntity r100) {
            return a((SignOutResp) r100);
        }

        public c(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    public HuaweiIdAuthAPIServiceImpl() {
        this.f277787a = null;
        this.f277788b = null;
    }

    private AuthHuaweiId a(SafeBundle r210) {
        if (r210 != null) goto L6;
        as.b("HuaweiIdAuthAPIServiceImpl", "bd is null", true);
        return new AuthHuaweiId();
    L6:
        String r100 = r210.getString(CommonConstant.RETKEY.ACCESS_TOKEN, "");
        String r110 = r210.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, "");
        String r101 = r210.getString(CommonConstant.RETKEY.DISPLAYNAME, "");
        String r102 = r210.getString("USER_ID", "");
        String r103 = r210.getString(CommonConstant.RETKEY.OPENID, "");
        String r104 = r210.getString(CommonConstant.RETKEY.PHOTOURL);
        String r105 = r210.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        String r111 = r210.getString(CommonConstant.RETKEY.COUNTRYCODE, "");
        String r112 = r210.getString(CommonConstant.RETKEY.UNIONID, "");
        int r113 = a(r210.getString(CommonConstant.RETKEY.GENDER));
        int r114 = b(r210.getString(CommonConstant.RETKEY.STATUS));
        int r106 = c(r210.getString(CommonConstant.RETKEY.HOME_ZONE));
        String r107 = r210.getString(CommonConstant.RETKEY.SCOPE);
        HashSet r115 = new HashSet();
        if (r107 == null) goto L12;
        String[] r108 = r107.split(" ");
        int r109 = r108.length;
        int r116 = 0;
    L9:
        if (r116 >= r109) goto L12;
        int r117 = r109;
        String[] r118 = r108;
        r115.add(new Scope(r108[r116]));
        r116 = r116 + 1;
        r109 = r117;
        r108 = r118;
    L12:
        AuthHuaweiId r119 = AuthHuaweiId.build(r103, r102, r101, r104, r100, r105, r114, r113, r115, r110, r112, r111);
        r119.setIdToken(r210.getString(CommonConstant.RETKEY.ID_TOKEN));
        r119.setEmail(r210.getString(CommonConstant.RETKEY.EMAIL));
        r119.setFamilyName(r210.getString(CommonConstant.RETKEY.FAMILY_NAME));
        r119.setGivenName(r210.getString(CommonConstant.RETKEY.GIVEN_NAME));
        r119.setAgeRange(r210.getString(CommonConstant.RETKEY.AGE_RANGE));
        r119.setHomeZone(r106);
        return r119;
    }

    private int b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "0";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return 0;
    }

    private SignInReq c(HuaweiApiClient r100) {
        List<Scope> r101 = a(r100);
        List<PermissionInfo> r102 = b(r100);
        HashSet r103 = new HashSet();
        Iterator<Scope> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r104.next().getScopeUri());
        goto L4
    L6:
        HashSet r105 = new HashSet();
        Iterator<PermissionInfo> r106 = r102.iterator();
    L8:
        if (r106.hasNext() == false) goto L11;
        r105.add(r106.next().getPermission());
        goto L8
    L11:
        return new SignInReq(r103, r105);
    }

    public static int conversionGender(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "-1";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return -1;
    }

    public static int conversionHomeZone(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "0";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return 0;
    }

    public static HashSet<Scope> conversionScopes(String r100) {
        HashSet<Scope> r101 = new HashSet();
        if (r100 == null) goto L7;
        String[] r102 = r100.split(" ");
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r101.add(new Scope(r102[r104]));
        r104 = r104 + 1;
    L7:
        return r101;
    }

    public static int conversionStatus(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "0";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return 0;
    }

    private PendingResult<Status> d(HuaweiApiClient r100) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOutNoConnected", true);
        Task<Void> r101 = HuaweiIdAuthManager.getService(r100.getContext(), getSignInOption(r100)).signOut();
        SignOutNoConnectPendingResult r102 = new SignOutNoConnectPendingResult(r100, CommonNaming.signout, new SignOutReq());
        r101.addOnCompleteListener(new SignOutOnCompleteListener(r102));
        return r102;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> cancelAuthorization(HuaweiApiClient r100) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter cancelAuthorization", true);
        this.f277787a = r100;
        return new b(r100, CommonNaming.revokeAccess, c(r100));
    }

    public HuaweiIdAuthResult getHuaweiIdSignInResultFromIntent(Intent r100) {
        HuaweiIdAuthResult r101 = new HuaweiIdAuthResult();
        if (r100 != null) goto L5;
    L10:
        Status r102 = new Status(2003);
        as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
    L11:
        r101.setStatus(r102);
        return r101;
    L5:
        if (r100.getExtras() == null) goto L10;
        SafeBundle r103 = new SafeBundle(r100.getExtras());
        int r104 = r103.getInt(CommonConstant.RETKEY.RETCODE, 0);
        r102 = new Status(r104);
        if (r104 != 0) goto L9;
        r101.setAuthHuaweiId(a(r103));
        as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
        goto L11
    L9:
        as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
        goto L11
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public SignInResult getHwIdSignInResultFromIntent(Intent r210) {
        if (r210 != null) goto L5;
    L20:
        SignInResult r100 = new SignInResult(new Status(2003));
        as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        return r100;
    L5:
        if (r210.getExtras() == null) goto L20;
        SafeBundle r101 = new SafeBundle(r210.getExtras());
        int r102 = r101.getInt(CommonConstant.RETKEY.RETCODE, 0);
        if (r102 != 0) goto L10;
        String r103 = r101.getString(CommonConstant.RETKEY.GENDER);
        String r104 = r101.getString("USER_ID", "");
        String r105 = r101.getString(CommonConstant.RETKEY.STATUS);
        String r106 = r101.getString(CommonConstant.RETKEY.SCOPE);
        String r110 = r101.getString(CommonConstant.RETKEY.ID_TOKEN);
        String r111 = r101.getString(CommonConstant.RETKEY.EMAIL);
        String r112 = r101.getString(CommonConstant.RETKEY.FAMILY_NAME);
        String r113 = r101.getString(CommonConstant.RETKEY.GIVEN_NAME);
        String r114 = r101.getString(CommonConstant.RETKEY.AGE_RANGE);
        String r211 = r101.getString(CommonConstant.RETKEY.HOME_ZONE);
        AuthHuaweiId r107 = AuthHuaweiId.build(r101.getString(CommonConstant.RETKEY.OPENID, ""), r104, r101.getString(CommonConstant.RETKEY.DISPLAYNAME, ""), r101.getString(CommonConstant.RETKEY.PHOTOURL), r101.getString(CommonConstant.RETKEY.ACCESS_TOKEN, ""), r101.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, ""), conversionStatus(r105), conversionGender(r103), conversionScopes(r106), r101.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, ""), r101.getString(CommonConstant.RETKEY.UNIONID, ""), r101.getString(CommonConstant.RETKEY.COUNTRYCODE, ""));
        r107.setIdToken(r110);
        r107.setEmail(r111);
        r107.setFamilyName(r112);
        r107.setGivenName(r113);
        r107.setAgeRange(r114);
        r107.setHomeZone(conversionHomeZone(r211));
        Status r108 = new Status(r102);
        SignInResult r109 = new SignInResult(r108);
        r109.setStatus(r108);
        r109.setAuthHuaweiId(r107);
        as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
        return r109;
    L10:
        if (r102 != 2002) goto L12;
    L15:
        Random r115 = new Random();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        as.b("HuaweiIdAuthAPIServiceImpl", "SDK version >= 23", true);
        PendingIntent r116 = PendingIntent.getActivity(this.f277787a.getContext(), r115.nextInt(), r210, 67108864);
    L19:
        Status r117 = new Status(r102, null, r116);
        SignInResult r118 = new SignInResult(r117);
        r118.setStatus(r117);
        r118.setData(r210);
        as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
        return r118;
    L18:
        as.b("HuaweiIdAuthAPIServiceImpl", "SDK version < 23", true);
        r116 = PendingIntent.getActivity(this.f277787a.getContext(), r115.nextInt(), r210, 0);
        goto L19
    L12:
        if (r102 == 2004) goto L15;
        r116 = null;
        goto L19
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public Intent getSignInIntent(HuaweiApiClient r100) {
        Context r101 = r100.getContext();
        HuaweiIdAuthParams r102 = getSignInOption(r100);
        String r103 = null;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r100.getSubAppInfo() == null) goto L9;
        r103 = r100.getSubAppInfo().getSubAppID();
    L9:
        return x.a(r101, r102, r103);
    }

    public HuaweiIdAuthParams getSignInOption(HuaweiApiClient r100) {
        Map<Api<?>, Api.ApiOptions> r101 = r100.getApiMap();
        if (r101 == null) goto L10;
        Api.ApiOptions r102 = r101.get(HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API);
        if (r102 != null) goto L7;
        return null;
    L7:
        if ((r102 instanceof HuaweiIdAuthParams) == true) goto L9;
        return null;
    L9:
        return (HuaweiIdAuthParams) r102;
    L10:
        return null;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent r100) {
        return x.a(r100);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signInBackend(final HuaweiApiClient r100) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signInBackend", true);
        Checker.checkNonNull(r100, "HuaweiApiClient must not be null.");
        this.f277787a = r100;
        List<Scope> r101 = a(r100);
        List<PermissionInfo> r102 = b(r100);
        HashSet r103 = new HashSet();
        Iterator<Scope> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r104.next().getScopeUri());
        goto L4
    L6:
        HashSet r105 = new HashSet();
        Iterator<PermissionInfo> r106 = r102.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.add(r106.next().getPermission());
        goto L8
    L10:
        final SignInReq r107 = new SignInReq(r103, r105);
        final String r108 = CommonNaming.singinbackend;
        return new AnonymousClass2(this, r100, r108, r107);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> signOut(HuaweiApiClient r100) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOut", true);
        if (r100.isConnected() == true) goto L7;
        return d(r100);
    L7:
        return new c(r100, CommonNaming.signout, new SignOutReq());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(final HuaweiApiClient r100) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter silentSignIn", true);
        Checker.checkNonNull(r100, "HuaweiApiClient must not be null.");
        this.f277787a = r100;
        final SignInReq r101 = c(r100);
        final String r102 = CommonNaming.singinbackend;
        return new OptionalPendingResultImpl(new AnonymousClass3(this, r100, r102, r101));
    }

    private void a(int r100) {
        if (r100 == 0) goto L4;
        return;
    L4:
        if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f277787a.getContext()) != 0) goto L8;
        TimerTask r101 = new AnonymousClass4(this);
        new Timer().schedule(r101, 200);
        return;
    }

    public static List<PermissionInfo> b(HuaweiApiClient r100) {
        return ((HuaweiApiClientImpl) r100).getPermissionInfos();
    }

    private int c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "0";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        as.d("HuaweiIdAuthAPIServiceImpl", "parse homeZone error.", true);
        return 0;
    }

    private int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "-1";
    L9:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return -1;
    }

    public static /* synthetic */ WeakReference b(HuaweiIdAuthAPIServiceImpl r100) {
        return r100.f277788b;
    }

    public static List<Scope> a(HuaweiApiClient r100) {
        return ((HuaweiApiClientImpl) r100).getScopes();
    }

    public static /* synthetic */ HuaweiApiClient a(HuaweiIdAuthAPIServiceImpl r100) {
        return r100.f277787a;
    }

    public static /* synthetic */ void a(HuaweiIdAuthAPIServiceImpl r100, int r101) {
        r100.a(r101);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signIn(Activity r100, final HuaweiApiClient r101) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signIn", true);
        Checker.checkNonNull(r100, "Activity must not be null.");
        Checker.checkNonNull(r101, "HuaweiApiClient must not be null.");
        List<Scope> r102 = a(r101);
        List<PermissionInfo> r103 = b(r101);
        HashSet r104 = new HashSet();
        Iterator<Scope> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(r105.next().getScopeUri());
        goto L4
    L6:
        HashSet r106 = new HashSet();
        Iterator<PermissionInfo> r107 = r103.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        r106.add(r107.next().getPermission());
        goto L8
    L10:
        final SignInReq r108 = new SignInReq(r104, r106);
        this.f277787a = r101;
        this.f277788b = new WeakReference(r100);
        final String r109 = CommonNaming.signin;
        return new AnonymousClass1(this, r101, r109, r108);
    }
}
