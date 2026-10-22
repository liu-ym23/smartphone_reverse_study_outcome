package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements s55.d {
    public final /* synthetic */ b a;
    public final /* synthetic */ BaseMoreMenuAction b;

    @Override // s55.d
    public final void a(PermissionResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        if (r3.getAllow() == false) goto L5;
        this.a.f(this.b);
        return;
    L5:
        if (r3.getDenySource().getDenyType() != DenyType.DLP_SENSATIVE) goto L10;
        FragmentActivity r4 = this.a.a;
        Toast.showFailureText(r4, r4.getResources().getString(2131888913), 0);
        return;
    }

    public l(b r1, BaseMoreMenuAction r2) {
        this.a = r1;
        this.b = r2;
    }
}
