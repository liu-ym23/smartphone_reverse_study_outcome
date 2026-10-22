package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Observer<AuthorizeStateNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BatchAuthorizeActivity f233128a;

    public a(BatchAuthorizeActivity r100) {
        this.f233128a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(AuthorizeStateNode r100) {
        AuthorizeStateNode r101 = r100;
        if (r101 == null) goto L24;
        int r102 = BatchAuthorizeActivity.a.f233123a[r101.getState().ordinal()];
        if (r102 != 1) goto L8;
        this.f233128a.f233112e.setVisibility(8);
    L15:
        BatchAuthorizeActivity r103 = this.f233128a;
        int r104 = r101.getHasPermissionCount();
        int r105 = r101.getNoPermissionCount();
        HashMap r106 = new HashMap();
        String r107 = "";
        if (r104 <= 0) goto L20;
        if (r105 <= 0) goto L19;
        r106.put("num1", r104 + "");
        r106.put("num2", r105 + "");
        r107 = xo5.a.d(r103, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Desc1, r106);
    L22:
        this.f233128a.f233111d.setText(r107);
        return;
    L19:
        r107 = xo5.a.c(r103, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Desc2, "number", r104 + "");
        goto L22
    L20:
        if (r105 <= 0) goto L22;
        r107 = xo5.a.c(r103, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Desc3, "number", r105 + "");
        goto L22
    L8:
        if (r102 != 2) goto L10;
        this.f233128a.f233112e.setVisibility(0);
        BatchAuthorizeActivity r108 = this.f233128a;
        r108.f233112e.setText(r108.getString(R.string.LarkCCM_EmbeddedFiles_GrantAllPermission_Button_Mobile));
        goto L15
    L10:
        if (r102 != 3) goto L15;
        this.f233128a.f233112e.setVisibility(0);
        BatchAuthorizeActivity r109 = this.f233128a;
        r109.f233112e.setText(r109.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_RevokeAll));
        goto L15
    }
}
