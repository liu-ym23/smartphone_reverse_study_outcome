package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BitableDefaultRoleAdapter a;
    public final /* synthetic */ Role b;

    public d(BitableDefaultRoleAdapter r1, Role r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1<Role, Unit> r3 = this.a.a;
        if (r3 == null) goto L6;
        r3.invoke(this.b);
        return;
    }
}
