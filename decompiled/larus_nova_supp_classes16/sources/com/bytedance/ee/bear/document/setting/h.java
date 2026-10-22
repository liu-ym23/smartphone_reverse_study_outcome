package com.bytedance.ee.bear.document.setting;

import android.view.View;
import com.bytedance.ee.bear.route.PostCard;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ DocumentSettingActivity a;

    public h(DocumentSettingActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PostCard r4 = ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).w2("/doc/ccm/perm_type/activity");
        Integer r0 = this.a.h;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        r4.j("permission_type", r1).e();
        return;
    L5:
        r1 = 1;
        goto L6
    }
}
