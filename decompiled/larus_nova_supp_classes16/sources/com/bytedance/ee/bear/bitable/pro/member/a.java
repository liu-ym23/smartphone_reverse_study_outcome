package com.bytedance.ee.bear.bitable.pro.member;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ BitableRoleMemberAdapter d;

    public final void a(View r2) {
        if (this.c.isUserType() == false) goto L6;
        this.d.b.invoke(this.c);
        return;
    }

    public a(UserInfo r1, BitableRoleMemberAdapter r2) {
        this.c = r1;
        this.d = r2;
    }
}
