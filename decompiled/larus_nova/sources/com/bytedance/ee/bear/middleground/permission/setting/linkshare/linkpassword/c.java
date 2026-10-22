package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC3359a f234172a;

    public c(f r100) {
        this.f234172a = r100;
    }

    @Override // ut5.a
    public final void onResult(Boolean r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals(r100) == false) goto L6;
        f r102 = (f) this.f234172a;
        r102.f234177a.getView().V5();
        r102.f234177a.f234179b.RN();
        return;
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        tt5.a.e("PasswordChecker", "checkPassword failed, code: " + r100, r101, false);
        a.InterfaceC3359a r102 = this.f234172a;
        if (r101 != null) goto L6;
        r101 = new Throwable();
    L6:
        f r103 = (f) r102;
        r103.f234177a.getView().V5();
        if (ax4.d.b(r101, 10017) == false) goto L10;
        r103.f234177a.getView().P1();
        return;
    L10:
        if (ax4.d.b(r101, 10018) == false) goto L12;
        Context r104 = r103.f234177a.f234178a;
        Toast.showFailureText(r104, r104.getString(R.string.Doc_Permission_PasswordErrorLimitTips), 0);
        return;
    L12:
        Context r105 = r103.f234177a.f234178a;
        Toast.showFailureText(r105, r105.getString(R.string.Doc_Doc_NetException), 0);
    }
}
