package com.larus.caijing_pay.impl.config;

import android.os.Bundle;
import com.bytedance.caijing.sdk.infra.base.api.phone.PhoneCarrierService;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJPhoneCarrierServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/phone/PhoneCarrierService;", "<init>", "()V", "getCurrentPhoneCarrier", "", "getMaskedPhoneInfo", "", "callback", "Lcom/bytedance/caijing/sdk/infra/base/api/phone/OnMaskedPhoneResult;", "getAuthToken", "Lcom/bytedance/caijing/sdk/infra/base/api/phone/OnAuthTokenResult;", "getOneKeyLoginService", "Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPhoneCarrierServiceImpl implements PhoneCarrierService {
    private static final a Companion = null;
    public static final String ERROR_MESSAGE_SERVICE_UNAVAILABLE = "One-key login service unavailable";
    public static final String ERROR_SERVICE_UNAVAILABLE = "-1";

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b implements AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ce4.a f321299a;

        public b(ce4.a r100) {
            this.f321299a = r100;
        }

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onError(AuthorizeErrorResponse r100) {
            ce4.a r101 = this.f321299a;
            if ((r100 instanceof OnekeyLoginErrorResponse) == false) goto L5;
            OnekeyLoginErrorResponse r102 = (OnekeyLoginErrorResponse) r100;
        L6:
            if (r102 == null) goto L8;
            String r103 = r102.netType;
        L10:
            if (r100 == null) goto L12;
            String r104 = r100.platformErrorCode;
        L13:
            if (r100 == null) goto L15;
            String r105 = r100.platformErrorMsg;
        L16:
            r101.onResult(null, r103, null, r104, r105);
            return;
        L15:
            r105 = null;
            goto L16
        L12:
            r104 = null;
            goto L13
        L8:
            r103 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onSuccess(Bundle r100) {
            ce4.a r101 = this.f321299a;
            if (r100 == null) goto L5;
            String r102 = r100.getString("access_token");
        L6:
            if (r100 == null) goto L8;
            String r103 = r100.getString("net_type");
        L9:
            r101.onResult(r102, r103, null, null, null);
            return;
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class c implements AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ce4.b f321300a;

        public c(ce4.b r100) {
            this.f321300a = r100;
        }

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onError(AuthorizeErrorResponse r100) {
            ce4.b r101 = this.f321300a;
            if (r100 == null) goto L5;
            String r102 = r100.platformErrorCode;
        L6:
            if (r100 == null) goto L8;
            String r103 = r100.platformErrorMsg;
        L9:
            r101.onResult(null, r102, r103);
            return;
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onSuccess(Bundle r100) {
            ce4.b r101 = this.f321300a;
            if (r100 == null) goto L5;
            String r102 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
        L6:
            r101.onResult(r102, null, null);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public CJPhoneCarrierServiceImpl() {
    }

    private final IOnekeyLoginService getOneKeyLoginService() {
        return (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.phone.PhoneCarrierService
    public String getCurrentPhoneCarrier() {
        IOnekeyLoginService r100 = getOneKeyLoginService();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCarrier();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.phone.PhoneCarrierService
    public void getAuthToken(ce4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IOnekeyLoginService r101 = getOneKeyLoginService();
        if (r101 != null) goto L6;
        r100.onResult(null, null, null, "-1", ERROR_MESSAGE_SERVICE_UNAVAILABLE);
        return;
    L6:
        r101.getAuthToken(new b(r100));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.phone.PhoneCarrierService
    public void getMaskedPhoneInfo(ce4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IOnekeyLoginService r101 = getOneKeyLoginService();
        if (r101 != null) goto L6;
        r100.onResult(null, "-1", ERROR_MESSAGE_SERVICE_UNAVAILABLE);
        return;
    L6:
        r101.getPhoneInfo(new c(r100));
    }
}
