package com.bytedance.ee.bear.middleground.permission.escape;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.bytedance.ee.bear.middleground.permission.secret.b0;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Instance f233858a;

    public d(Instance r100) {
        this.f233858a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b0.d(this.f233858a.getInstanceCode());
    }
}
