package yz8;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.account.base.impl.m;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import n38.c0;
import n38.y;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOnekeyLoginService f569555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f569556b;

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        y r101 = this.f569556b;
        if (r100 == null) goto L6;
        String r102 = r100.platformErrorCode;
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L10;
        String r103 = r100.platformErrorMsg;
        if (r103 == null) goto L10;
    L11:
        r101.a(r102, r103);
        return;
    L10:
        r103 = "";
    L6:
        r102 = "-1";
        goto L7
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
    L5:
        String r102 = this.f569555a.getCarrier();
        if (r102 == null) goto L26;
        int r103 = r102.hashCode();
        if (r103 == (-1429363305)) goto L23;
        if (r103 == (-1068855134)) goto L19;
        if (r103 != (-840542575)) goto L26;
        if (r102.equals(OnekeyLoginConstants.UNICOM) == false) goto L26;
        PhoneOneKeyPlatform r104 = PhoneOneKeyPlatform.UNICOM;
    L27:
        this.f569556b.b(new c0(r101, r104));
        return;
    L19:
        if (r102.equals("mobile") == false) goto L26;
        r104 = PhoneOneKeyPlatform.MOBILE;
        goto L27
    L23:
        if (r102.equals(OnekeyLoginConstants.TELECOM) == false) goto L26;
        r104 = PhoneOneKeyPlatform.TELECOM;
    L26:
        r104 = PhoneOneKeyPlatform.UNKNOWN;
        goto L27
    L4:
        r101 = null;
        goto L5
    }

    public b(IOnekeyLoginService r100, m r101) {
        this.f569555a = r100;
        this.f569556b = r101;
    }
}
