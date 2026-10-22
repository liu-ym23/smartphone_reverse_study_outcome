package com.bytedance.locallife.bridge.common.method;

import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements kt6.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kt6.g f257076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XGetCurrentGCJLocationMethod f257077b;

    @Override // kt6.i
    public final void onActivityResult() {
        boolean r100 = false;
        Unit r101 = null;
        if (this.f257076a.j() == false) goto L20;
        XGetCurrentGCJLocationMethod r102 = this.f257077b;
        if (r102.f257052h == false) goto L19;
        String r103 = r102.f257053i;
        if (r103 != null) goto L9;
    L10:
        r100 = true;
    L12:
        if ((!r100) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        this.f257076a.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_onActivityResult_trylocate_immediately_with_auth_new").auth(r103), this.f257077b);
        r101 = Unit.INSTANCE;
    L17:
        if (r101 != null) goto L22;
        this.f257076a.i(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_onActivityResult_trylocate_immediately"), this.f257077b);
        return;
    L22:
        return;
    L9:
        if (r103.length() != 0) goto L12;
    L19:
        this.f257076a.r(TokenCert.Companion.with("bpea-getCurrentGCJLocation_Xjsb_activityresult_getcache"), new XGetCurrentGCJLocationMethod.b(this.f257077b));
        return;
    L20:
        this.f257077b.j(null, 0, null);
    }

    public o(kt6.g r100, XGetCurrentGCJLocationMethod r101) {
        this.f257076a = r100;
        this.f257077b = r101;
    }
}
