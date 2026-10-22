package com.bytedance.ee.bear.bitable.pro.member;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserInfo f215211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableRoleMemberAdapter f215212d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f215211c.isUserType() == false) goto L6;
        this.f215212d.f215188b.invoke(this.f215211c);
        return;
    }

    public a(UserInfo r100, BitableRoleMemberAdapter r101) {
        this.f215211c = r100;
        this.f215212d = r101;
    }
}
