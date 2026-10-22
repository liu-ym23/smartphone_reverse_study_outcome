package com.bytedance.sdk.account.devicetransfer;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.utils.n;
import kotlin.text.StringsKt;
import qb7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f268886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IOnekeyLoginService f268887b;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.devicetransfer.a$a, reason: collision with other inner class name */
    public static final class C3757a implements AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f268888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f268889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f268890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f268891d;

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onError(AuthorizeErrorResponse r100) {
            AccountDeviceTransferManager.f268883h.c(this.f268888a.f268886a);
        }

        @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
        public final void onSuccess(Bundle r100) {
            if (r100 == null) goto L5;
            String r101 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
        L6:
            if (r100 == null) goto L8;
            String r102 = r100.getString("net_type");
        L10:
            if (StringsKt.equals$default(r102, this.f268889b, false, 2, null) == true) goto L12;
            tb7.a.e("AccountDeviceTransferManager", "getPhoneInfo success, carrier=" + r102 + ", securityPhone=" + r101 + ", but not equal with getAuthToken(carrier=" + this.f268889b + ", securityPhone=" + this.f268890c + ')');
        L13:
            AccountDeviceTransferManager.f268883h.c(this.f268888a.f268886a);
            return;
        L12:
            this.f268891d.putString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE, r101);
            goto L13
        L8:
            r102 = null;
            goto L10
        L5:
            r101 = null;
            goto L6
        }

        public C3757a(a r100, String r101, String r102, Bundle r103) {
            this.f268888a = r100;
            this.f268889b = r101;
            this.f268890c = r102;
            this.f268891d = r103;
        }
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        StringBuilder r101 = new StringBuilder("getAuthToken error, code=");
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.platformErrorCode;
    L6:
        r101.append(r103);
        r101.append(", msg=");
        if (r100 == null) goto L9;
        String r104 = r100.platformErrorMsg;
    L10:
        r101.append(r104);
        tb7.a.d("AccountDeviceTransferManager", r101.toString());
        c r105 = this.f268886a;
        StringBuilder r106 = new StringBuilder();
        if (r100 == null) goto L13;
        String r107 = r100.platformErrorMsg;
    L14:
        r106.append(r107);
        r106.append(", ");
        if (r100 == null) goto L17;
        r102 = r100.platformErrorMsg;
    L17:
        r106.append(r102);
        r105.f532410b = r106.toString();
        AccountDeviceTransferManager.f268883h.c(this.f268886a);
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r100) {
        if (r100 != 0) goto L4;
    L26:
        c r101 = this.f268886a;
        r101.f532410b = "getAuthToken success, bundle is empty";
        AccountDeviceTransferManager.f268883h.c(r101);
        return;
    L4:
        if (r100.isEmpty() == true) goto L26;
        String r102 = r100.getString("access_token");
        String r103 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
        String r104 = r100.getString("net_type");
        tb7.a.d("AccountDeviceTransferManager", "getAuthToken success, carrier=" + r104 + ", securityPhone=" + r103 + ", token=" + n.b(r102, 4) + '}');
        boolean r105 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L16;
        c r107 = this.f268886a;
        r107.f532410b = "getAuthToken success, token is empty";
        AccountDeviceTransferManager.f268883h.c(r107);
        return;
    L16:
        this.f268886a.f532409a = 0;
        this.f268886a.f532411c = r100;
        if (r103 != null) goto L19;
    L22:
        if (r105 == false) goto L24;
        this.f268887b.getPhoneInfo("device_transfer", new C3757a(this, r104, r103, r100));
        return;
    L24:
        AccountDeviceTransferManager.f268883h.c(this.f268886a);
        return;
    L19:
        if (r103.length() == 0) goto L22;
        r105 = false;
        goto L22
    L9:
        if (r102.length() == 0) goto L12;
        r106 = false;
        goto L13
    }

    public a(c r100, IOnekeyLoginService r101) {
        this.f268886a = r100;
        this.f268887b = r101;
    }
}
