package com.bytedance.ee.bear.bitable.homepage.activity;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageAdapter f212310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f212311b;

    public d(BitableMessageAdapter r100, UserInfo r101) {
        this.f212310a = r100;
        this.f212311b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<String, Unit> r101 = this.f212310a.f212269b;
        UserInfo r102 = this.f212311b;
        if (r102 == null) goto L5;
        String r103 = r102.getUserId();
    L6:
        r101.invoke(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
