package com.bytedance.ee.bear.document.setting;

import android.view.View;
import com.bytedance.ee.bear.route.PostCard;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentSettingActivity f221757a;

    public h(DocumentSettingActivity r100) {
        this.f221757a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PostCard r101 = ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).w2("/doc/ccm/perm_type/activity");
        Integer r102 = this.f221757a.f221738h;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.j("permission_type", r103).e();
        return;
    L5:
        r103 = 1;
        goto L6
    }
}
