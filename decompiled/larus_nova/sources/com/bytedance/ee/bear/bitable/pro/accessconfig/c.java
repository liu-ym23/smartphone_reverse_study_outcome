package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserInfo f215120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UserInfo f215121d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f215120c.isUserType() == false) goto L9;
        k r101 = (k) org.koin.java.a.c(k.class, null, null, 6);
        String r102 = this.f215121d.getId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.e(r102, "");
        return;
    }

    public c(UserInfo r100, UserInfo r101) {
        this.f215120c = r100;
        this.f215121d = r101;
    }
}
