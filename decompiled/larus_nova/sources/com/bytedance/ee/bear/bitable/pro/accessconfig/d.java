package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDefaultRoleAdapter f215122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Role f215123b;

    public d(BitableDefaultRoleAdapter r100, Role r101) {
        this.f215122a = r100;
        this.f215123b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<Role, Unit> r101 = this.f215122a.f215112a;
        if (r101 == null) goto L6;
        r101.invoke(this.f215123b);
        return;
    }
}
