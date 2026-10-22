package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ UserInfo d;

    public final void a(View r3) {
        if (this.c.isUserType() == false) goto L9;
        k r4 = (k) org.koin.java.a.c(k.class, null, null, 6);
        String r0 = this.d.getId();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r4.e(r0, "");
        return;
    }

    public c(UserInfo r1, UserInfo r2) {
        this.c = r1;
        this.d = r2;
    }
}
