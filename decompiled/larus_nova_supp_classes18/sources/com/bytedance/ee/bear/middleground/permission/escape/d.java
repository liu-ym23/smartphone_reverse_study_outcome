package com.bytedance.ee.bear.middleground.permission.escape;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.bytedance.ee.bear.middleground.permission.secret.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ Instance a;

    public d(Instance r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        b0.d(this.a.getInstanceCode());
    }
}
